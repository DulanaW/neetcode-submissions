class Solution {
public:
    bool isAnagram(string s, string t) {
        unordered_map<char, int> counter;
        for (char i : s) {
            if (counter.contains(i)) {
                counter.at(i)++;
            } else {
                counter.insert({i, 1});
            }
        }
        for (char i : t) {
            if (counter.contains(i)) {
                counter.at(i)--;
                if (counter.at(i) < 0) {
                    return false;
                } 
            } else {
                return false;
            }
        } 
        for (char i : s) {
            if (counter.at(i)) {
                return false;
            } 
        } return true;
    }
};
