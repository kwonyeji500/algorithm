import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Set<String> uniqueReports = new HashSet<>(Arrays.asList(report));
        
        Map<String, Integer> reportCount = new HashMap<>();
        
        Map<String, List<String>> reporterMap = new HashMap<>();
        
        for (String r : uniqueReports) {
            String[] parts = r.split(" ");
            String reporter = parts[0];
            String reported = parts[1];
            
            reportCount.put(reported, reportCount.getOrDefault(reported, 0) + 1);
            
            reporterMap.computeIfAbsent(reporter, v -> new ArrayList<>()).add(reported);
        }
        
        Set<String> bannedUsers = new HashSet<>();
        for (Map.Entry<String, Integer> entry : reportCount.entrySet()) {
            if (entry.getValue() >= k) {
                bannedUsers.add(entry.getKey());
            }
        }
        
        int[] result = new int[id_list.length];
        Map<String, Integer> userIndex = new HashMap<>();
        for (int i=0; i<id_list.length; i++) {
            userIndex.put(id_list[i], i);
        }
        
        for(String reporter : reporterMap.keySet()) {
            int index = userIndex.get(reporter);
            List<String> reportedUsers = reporterMap.get(reporter);
            for(String reported : reportedUsers) {
                if (bannedUsers.contains(reported)) {
                    result[index]++;
                }
            }
        }
        
        return result;
    }
}