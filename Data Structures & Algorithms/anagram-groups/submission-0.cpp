class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<int>> hash;
        string str;
        //store anagrams with their index
        for (int index = 0; index < strs.size(); index++) {
            
            //getsortedstring()
            str = strs[index];
            sort(str.begin(), str.end());
            
            //add index of new anagram to list
            hash[str].push_back(index);
        }

        
        vector<vector<string>> output;
        for (auto s : hash) {
            vector<string> holder;
            for (auto i : s.second) {
                
                holder.push_back(strs[i]);
            }
            output.push_back(holder);
        }

        

        return output;
    }
};
