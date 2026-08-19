#include <unordered_set>
using namespace std;

class Solution {
public:
    bool hasDuplicate(vector<int>& nums) {
        unordered_set<int> hashTable;
        int term;
        for (int i = 0; i < nums.size(); i++) {
            term = nums[i];
            if (hashTable.contains(term)) {
                return true;
            } else {
                hashTable.insert(nums[i]);
            }
        }
        return false;
    }
};