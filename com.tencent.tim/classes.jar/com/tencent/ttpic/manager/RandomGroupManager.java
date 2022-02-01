package com.tencent.ttpic.manager;

import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.model.MemRandomValue;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public enum RandomGroupManager
{
  INSTANCE;
  
  private static final int HAND_RANDOM_INDEX = 0;
  private Map<Integer, MemRandomValue> mRandomGroupFaceValueMap = new HashMap();
  private Map<Integer, MemRandomValue> mRandomGroupHandValueMap = new HashMap();
  
  private RandomGroupManager()
  {
    clearAll();
  }
  
  private void clearFaceRandomGroupStatus()
  {
    Iterator localIterator = this.mRandomGroupFaceValueMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      MemRandomValue localMemRandomValue = (MemRandomValue)this.mRandomGroupFaceValueMap.get(Integer.valueOf(i));
      if (localMemRandomValue != null)
      {
        localMemRandomValue.curValue = -1;
        this.mRandomGroupFaceValueMap.put(Integer.valueOf(i), localMemRandomValue);
      }
    }
  }
  
  private void clearFaceRandomGroupStatus(List<Integer> paramList)
  {
    Iterator localIterator = this.mRandomGroupFaceValueMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      if (!faceExist(paramList, i))
      {
        MemRandomValue localMemRandomValue = (MemRandomValue)this.mRandomGroupFaceValueMap.get(Integer.valueOf(i));
        if (localMemRandomValue != null)
        {
          localMemRandomValue.curValue = -1;
          this.mRandomGroupFaceValueMap.put(Integer.valueOf(i), localMemRandomValue);
        }
      }
    }
  }
  
  private void clearHandRandomGroupStatus()
  {
    MemRandomValue localMemRandomValue = (MemRandomValue)this.mRandomGroupHandValueMap.get(Integer.valueOf(0));
    localMemRandomValue.curValue = -1;
    this.mRandomGroupHandValueMap.put(Integer.valueOf(0), localMemRandomValue);
  }
  
  private boolean faceExist(List<Integer> paramList, int paramInt)
  {
    if (paramInt == -1) {
      return true;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((Integer)paramList.next()).intValue() == paramInt) {
        return true;
      }
    }
    return false;
  }
  
  private void fillEmptyRandomGroupValue(List<Integer> paramList, int paramInt)
  {
    if (!this.mRandomGroupFaceValueMap.containsKey(Integer.valueOf(-1))) {
      this.mRandomGroupFaceValueMap.put(Integer.valueOf(-1), new MemRandomValue());
    }
    Object localObject = (MemRandomValue)this.mRandomGroupFaceValueMap.get(Integer.valueOf(-1));
    if (((MemRandomValue)localObject).curValue < 0)
    {
      i = AlgoUtils.randValueDiff(((MemRandomValue)localObject).lastValue, paramInt);
      ((MemRandomValue)localObject).curValue = i;
      ((MemRandomValue)localObject).lastValue = i;
    }
    localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      i = ((Integer)((Iterator)localObject).next()).intValue();
      if (!this.mRandomGroupFaceValueMap.containsKey(Integer.valueOf(i))) {
        this.mRandomGroupFaceValueMap.put(Integer.valueOf(i), new MemRandomValue());
      }
    }
    int i = 1;
    while (i < paramList.size())
    {
      localObject = (MemRandomValue)this.mRandomGroupFaceValueMap.get(paramList.get(i));
      if ((localObject != null) && (((MemRandomValue)localObject).curValue < 0))
      {
        int j = AlgoUtils.randValueDiff(((MemRandomValue)localObject).lastValue, paramInt);
        ((MemRandomValue)localObject).curValue = j;
        ((MemRandomValue)localObject).lastValue = j;
      }
      this.mRandomGroupFaceValueMap.put(paramList.get(i), localObject);
      i += 1;
    }
  }
  
  public static RandomGroupManager getInstance()
  {
    return INSTANCE;
  }
  
  public void clearAll()
  {
    this.mRandomGroupFaceValueMap.clear();
    this.mRandomGroupHandValueMap.put(Integer.valueOf(0), new MemRandomValue());
  }
  
  public void clearCurValue()
  {
    clearFaceRandomGroupStatus();
    clearHandRandomGroupStatus();
  }
  
  public int getFaceValue(int paramInt)
  {
    if (this.mRandomGroupFaceValueMap.containsKey(Integer.valueOf(paramInt))) {
      return ((MemRandomValue)this.mRandomGroupFaceValueMap.get(Integer.valueOf(paramInt))).curValue;
    }
    return 0;
  }
  
  public int getHandValue()
  {
    return ((MemRandomValue)this.mRandomGroupHandValueMap.get(Integer.valueOf(0))).curValue;
  }
  
  public void updateValue(List<Integer> paramList, boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean) {
      clearHandRandomGroupStatus();
    }
    clearFaceRandomGroupStatus(paramList);
    fillEmptyRandomGroupValue(paramList, paramInt);
    MemRandomValue localMemRandomValue2 = (MemRandomValue)this.mRandomGroupHandValueMap.get(Integer.valueOf(0));
    MemRandomValue localMemRandomValue1;
    int i;
    if (!CollectionUtils.isEmpty(paramList))
    {
      localMemRandomValue1 = (MemRandomValue)this.mRandomGroupFaceValueMap.get(paramList.get(0));
      if ((localMemRandomValue2 == null) || (localMemRandomValue1 == null) || (((localMemRandomValue2.curValue >= 0) || (!paramBoolean)) && ((localMemRandomValue1.curValue >= 0) || (CollectionUtils.isEmpty(paramList))))) {
        break label207;
      }
      if (localMemRandomValue2.curValue >= 0) {
        break label136;
      }
      i = localMemRandomValue1.lastValue;
    }
    label117:
    for (paramInt = AlgoUtils.randValueDiff(i, paramInt);; paramInt = -1)
    {
      if (paramInt < 0) {}
      do
      {
        return;
        localMemRandomValue1 = localMemRandomValue2;
        break;
        i = localMemRandomValue2.lastValue;
        break label117;
        if (!CollectionUtils.isEmpty(paramList)) {
          this.mRandomGroupFaceValueMap.put(paramList.get(0), new MemRandomValue(paramInt, paramInt));
        }
      } while (!paramBoolean);
      this.mRandomGroupHandValueMap.put(Integer.valueOf(0), new MemRandomValue(paramInt, paramInt));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.manager.RandomGroupManager
 * JD-Core Version:    0.7.0.1
 */