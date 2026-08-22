#include <unordered_set>

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> hash;
        vector<int> v;
        for (int num = 0; num < nums.size(); num++) {
            hash.insert({nums[num], num});
            if (hash.contains(target - nums[num]) && hash[target - nums[num]] != num) {
                v.push_back(hash[target - nums[num]]);
                v.push_back(num);
            }
        } return v;
    }
};
