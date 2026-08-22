#include <unordered_set>

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> hash;
        for (int num = 0; num < nums.size(); num++) {
            int y = target - nums[num];
            if (hash.contains(y)) {
               return {hash[y], num};
            }
            hash.insert({nums[num], num});
        } return {};
    }
};
