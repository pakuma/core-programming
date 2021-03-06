package com.pk.algorithms.backtracking;

/**
 *
 * @author parveenkumar
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class SubsetsII {
  public List<List<Integer>> subsetWithDup(int[] nums){
      List<List<Integer>> list = new ArrayList<>();
      Arrays.sort(nums);
      backtrack(list, new ArrayList<>(), nums, 0);
      return list;
  }
  private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start){
      list.add(new ArrayList<>(tempList));
      for(int i = start; i < nums.length; i++){
          //Bounding Functions for backtracking
          if(i > start && nums[i] == nums[i - 1]) continue; //skip duplicates
          tempList.add(nums[i]);
          backtrack(list, tempList, nums, i + 1);
          tempList.remove(tempList.size() - 1);
      }
  }
}
