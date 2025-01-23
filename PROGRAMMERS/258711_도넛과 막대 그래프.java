import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();
        Set<Integer> nodes = new HashSet<>();
        
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            
            outDegree.put(from, outDegree.getOrDefault(from, 0) + 1);
            inDegree.put(to, inDegree.getOrDefault(to, 0) + 1);
            
            nodes.add(from);
            nodes.add(to);
        }
        
        Integer generatedNode = null;
        for (Integer node : outDegree.keySet()) {
            if (inDegree.getOrDefault(node, 0) == 0 && outDegree.get(node) >= 2) {
                generatedNode = node;
                break;
            }
        }
        
        int donutCount = 0;
        int eightCount = 0;
        int stickCount = 0;
        
        for (Integer node : nodes) {
            if (node == generatedNode) {
                continue;
            }
            
            int in = inDegree.getOrDefault(node, 0);
            int out = outDegree.getOrDefault(node, 0);
            
            if (out == 0) {
                stickCount++;
            } else if (in >= 2 && out == 2) {
                eightCount++;
            }
        }
        
        int totalGraphs = outDegree.get(generatedNode);
        donutCount = totalGraphs - stickCount - eightCount;
        
        return new int[]{generatedNode, donutCount, stickCount, eightCount};
    }
}