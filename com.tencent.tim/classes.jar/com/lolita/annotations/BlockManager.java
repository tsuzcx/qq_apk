package com.lolita.annotations;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BlockManager
{
  private static ArrayList<BlockTrace> blockTraces = new ArrayList();
  private static HashMap<String, ArrayList<Integer>> methodBlockDetails = new HashMap();
  
  public static void addMethodBlockDetail(String paramString, int paramInt)
  {
    ArrayList localArrayList = (ArrayList)methodBlockDetails.get(paramString);
    Object localObject = localArrayList;
    if (localArrayList == null) {
      localObject = new ArrayList();
    }
    ((ArrayList)localObject).add(Integer.valueOf(paramInt));
    methodBlockDetails.put(paramString, localObject);
    localObject = new Throwable().getStackTrace();
    paramString = localObject[1];
    localObject = localObject[2];
    appendTraceElement(paramInt, paramString.getClassName() + "." + paramString.getMethodName(), ((StackTraceElement)localObject).getClassName() + "." + ((StackTraceElement)localObject).getMethodName());
  }
  
  private static void appendTraceElement(int paramInt, String paramString1, String paramString2)
  {
    Object localObject = blockTraces.iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      BlockTrace localBlockTrace = (BlockTrace)((Iterator)localObject).next();
      String str = (String)localBlockTrace.methods.get(localBlockTrace.methods.size() - 1);
      int j = ((Integer)localBlockTrace.mills.get(localBlockTrace.mills.size() - 1)).intValue();
      if ((!paramString1.equals(str)) || (j != -1)) {
        break label216;
      }
      localBlockTrace.mills.set(localBlockTrace.mills.size() - 1, Integer.valueOf(paramInt));
      localBlockTrace.methods.add(paramString2);
      localBlockTrace.mills.add(Integer.valueOf(-1));
      i = 1;
    }
    label216:
    for (;;)
    {
      break;
      if (i == 0)
      {
        localObject = new BlockTrace();
        ((BlockTrace)localObject).methods.add(paramString1);
        ((BlockTrace)localObject).mills.add(Integer.valueOf(paramInt));
        ((BlockTrace)localObject).methods.add(paramString2);
        ((BlockTrace)localObject).mills.add(Integer.valueOf(-1));
        blockTraces.add(localObject);
      }
      return;
    }
  }
  
  public static float average(ArrayList<Integer> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return 0.0F;
    }
    Iterator localIterator = paramArrayList.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((Integer)localIterator.next()).intValue() + i) {}
    return i / paramArrayList.size();
  }
  
  public static void dump(int paramInt)
  {
    int j = 0;
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    Iterator localIterator = methodBlockDetails.keySet().iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localHashMap1.put(str, Float.valueOf(average((ArrayList)methodBlockDetails.get(str))));
      localHashMap2.put(str, Integer.valueOf(((ArrayList)methodBlockDetails.get(str)).size()));
    }
    localHashMap1 = (HashMap)sortByValue(localHashMap1);
    localHashMap2 = (HashMap)sortByValue(localHashMap2);
    int k = Math.min(paramInt, localHashMap1.keySet().size());
    System.out.println("----平均值排行 top " + k + "----");
    localIterator = localHashMap1.keySet().iterator();
    int i = 0;
    StringBuilder localStringBuilder;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (i >= k) {
        break;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str + ": " + formatFloat((Float)localHashMap1.get(str)));
      localStringBuilder.append("(次数-" + localHashMap2.get(str) + ")");
      System.out.println(localStringBuilder);
      i += 1;
    }
    i = Math.min(paramInt, localHashMap2.keySet().size());
    System.out.println("----卡顿次数排行 top " + i + "----");
    localIterator = localHashMap2.keySet().iterator();
    paramInt = j;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (paramInt >= i) {
        break;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str + ": " + localHashMap2.get(str));
      localStringBuilder.append("(平均-" + formatFloat((Float)localHashMap1.get(str)) + ")");
      System.out.println(localStringBuilder);
      paramInt += 1;
    }
  }
  
  public static void dumpBlockStackTrace()
  {
    System.out.println("----dumpBlockStackTrace----");
    Iterator localIterator = blockTraces.iterator();
    while (localIterator.hasNext())
    {
      BlockTrace localBlockTrace = (BlockTrace)localIterator.next();
      System.out.println("block StackTrace");
      System.out.println(localBlockTrace.toString());
    }
  }
  
  public static Float formatFloat(Float paramFloat)
  {
    return Float.valueOf(Math.round(paramFloat.floatValue() * 100.0F) / 100.0F);
  }
  
  public static HashMap<String, ArrayList<Integer>> getMethodBlockDetails()
  {
    return methodBlockDetails;
  }
  
  public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> paramMap)
  {
    Object localObject = new LinkedList(paramMap.entrySet());
    Collections.sort((List)localObject, new BlockManager.1());
    paramMap = new LinkedHashMap();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      paramMap.put(localEntry.getKey(), localEntry.getValue());
    }
    return paramMap;
  }
  
  static class BlockTrace
  {
    public ArrayList<String> methods = new ArrayList();
    public ArrayList<Integer> mills = new ArrayList();
    
    public String toString()
    {
      int j = this.methods.size();
      if (j <= 0) {
        return "BlockTrace length is " + j;
      }
      StringBuilder localStringBuilder = new StringBuilder("");
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append((String)this.methods.get(i)).append("-").append(this.mills.get(i)).append("ms").append("\n");
        i += 1;
      }
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.lolita.annotations.BlockManager
 * JD-Core Version:    0.7.0.1
 */