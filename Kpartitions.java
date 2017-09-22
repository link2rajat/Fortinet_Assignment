package com.divisiblity.rajat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Kpartitions 
{

static boolean isKPartitionPossible(List<Integer> list, int K)
{
int N = list.size();
if (K == 1)
 return true;
if (N < K)
 return false;
int sum = 0;
for (int i = 0; i < N; i++)
sum += list.get(i);
if (sum % K != 0)
 return false;
int subset = sum / K;
int[] subsetSum = new int[K]; 
boolean[] taken = new boolean[N]; 
for (int i = 0; i < K; i++)
 subsetSum[i] = 0;
for (int i = 0; i < N; i++)
 taken[i] = false;
subsetSum[0] = list.get(N - 1);
taken[N - 1] = true;
if (subset < subsetSum[0])
 return false;
return isKPartitionPossibleRec(list, subsetSum, taken,
                              subset, K, N, 0, N - 1);
}

static boolean isKPartitionPossibleRec(List<Integer> list, int subsetSum[], boolean taken[],
        int subset, int K, int N, int curIdx, int limitIdx)
{
if (subsetSum[curIdx] == subset)
{
if (curIdx == K - 2)
 return true;

return isKPartitionPossibleRec(list, subsetSum, taken, subset,
                                 K, N, curIdx + 1, N - 1);
}
for (int i = limitIdx; i >= 0; i--)
{
if (taken[i])
 continue;
int tmp = subsetSum[curIdx] + list.get(i);

if (tmp <= subset)
{
 taken[i] = true;
 subsetSum[curIdx] += list.get(i);
 boolean nxt = isKPartitionPossibleRec(list, subsetSum, taken,
                                 subset, K, N, curIdx, i - 1);
 taken[i] = false;
 subsetSum[curIdx] -= list.get(i);
 if (nxt)
     return true;
}
}
return false;
}
public static void main(String[] a)
{

int K = 3;
List<Integer> list = new ArrayList<Integer>();
list.add(2);
list.add(1);
list.add(4);
list.add(5);
list.add(3);
list.add(3);
if (isKPartitionPossible(list,K))
System.out.println("Partitions into equal sum is possible.\n"); 
else
	System.out.println("Partitions into equal sum is not possible.\n");
}
}
