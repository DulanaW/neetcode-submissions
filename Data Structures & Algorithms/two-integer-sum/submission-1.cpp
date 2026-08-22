#include <unordered_set>

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> hash;
        for (int num = 0; num < nums.size(); num++) {
            if (hash.contains(target - nums[num])) {
               return {hash[target - nums[num]], num};
            }
            hash.insert({nums[num], num});
        } return {};
    }
};
