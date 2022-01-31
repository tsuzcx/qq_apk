package android.support.v4.widget;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;
import android.support.v4.util.SimpleArrayMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public final class DirectedAcyclicGraph
{
  private final SimpleArrayMap mGraph = new SimpleArrayMap();
  private final Pools.Pool mListPool = new Pools.SimplePool(10);
  private final ArrayList mSortResult = new ArrayList();
  private final HashSet mSortTmpMarked = new HashSet();
  
  private void dfs(Object paramObject, ArrayList paramArrayList, HashSet paramHashSet)
  {
    if (paramArrayList.contains(paramObject)) {
      return;
    }
    if (paramHashSet.contains(paramObject)) {
      throw new RuntimeException("This graph contains cyclic dependencies");
    }
    paramHashSet.add(paramObject);
    ArrayList localArrayList = (ArrayList)this.mGraph.get(paramObject);
    if (localArrayList != null)
    {
      int i = 0;
      int j = localArrayList.size();
      while (i < j)
      {
        dfs(localArrayList.get(i), paramArrayList, paramHashSet);
        i += 1;
      }
    }
    paramHashSet.remove(paramObject);
    paramArrayList.add(paramObject);
  }
  
  @NonNull
  private ArrayList getEmptyList()
  {
    ArrayList localArrayList2 = (ArrayList)this.mListPool.acquire();
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null) {
      localArrayList1 = new ArrayList();
    }
    return localArrayList1;
  }
  
  private void poolList(@NonNull ArrayList paramArrayList)
  {
    paramArrayList.clear();
    this.mListPool.release(paramArrayList);
  }
  
  public void addEdge(@NonNull Object paramObject1, @NonNull Object paramObject2)
  {
    if ((!this.mGraph.containsKey(paramObject1)) || (!this.mGraph.containsKey(paramObject2))) {
      throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
    }
    ArrayList localArrayList2 = (ArrayList)this.mGraph.get(paramObject1);
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList1 = getEmptyList();
      this.mGraph.put(paramObject1, localArrayList1);
    }
    localArrayList1.add(paramObject2);
  }
  
  public void addNode(@NonNull Object paramObject)
  {
    if (!this.mGraph.containsKey(paramObject)) {
      this.mGraph.put(paramObject, null);
    }
  }
  
  public void clear()
  {
    int j = this.mGraph.size();
    int i = 0;
    while (i < j)
    {
      ArrayList localArrayList = (ArrayList)this.mGraph.valueAt(i);
      if (localArrayList != null) {
        poolList(localArrayList);
      }
      i += 1;
    }
    this.mGraph.clear();
  }
  
  public boolean contains(@NonNull Object paramObject)
  {
    return this.mGraph.containsKey(paramObject);
  }
  
  @Nullable
  public List getIncomingEdges(@NonNull Object paramObject)
  {
    return (List)this.mGraph.get(paramObject);
  }
  
  @Nullable
  public List getOutgoingEdges(@NonNull Object paramObject)
  {
    Object localObject1 = null;
    int j = this.mGraph.size();
    int i = 0;
    Object localObject2;
    if (i < j)
    {
      ArrayList localArrayList = (ArrayList)this.mGraph.valueAt(i);
      localObject2 = localObject1;
      if (localArrayList != null)
      {
        localObject2 = localObject1;
        if (localArrayList.contains(paramObject))
        {
          if (localObject1 != null) {
            break label99;
          }
          localObject1 = new ArrayList();
        }
      }
    }
    label99:
    for (;;)
    {
      ((ArrayList)localObject1).add(this.mGraph.keyAt(i));
      localObject2 = localObject1;
      i += 1;
      localObject1 = localObject2;
      break;
      return localObject1;
    }
  }
  
  @NonNull
  public ArrayList getSortedList()
  {
    this.mSortResult.clear();
    this.mSortTmpMarked.clear();
    int i = 0;
    int j = this.mGraph.size();
    while (i < j)
    {
      dfs(this.mGraph.keyAt(i), this.mSortResult, this.mSortTmpMarked);
      i += 1;
    }
    return this.mSortResult;
  }
  
  public boolean hasOutgoingEdges(@NonNull Object paramObject)
  {
    int j = this.mGraph.size();
    int i = 0;
    while (i < j)
    {
      ArrayList localArrayList = (ArrayList)this.mGraph.valueAt(i);
      if ((localArrayList != null) && (localArrayList.contains(paramObject))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  int size()
  {
    return this.mGraph.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.DirectedAcyclicGraph
 * JD-Core Version:    0.7.0.1
 */