package com.tencent.qqlive.module.videoreport.reportdata;

import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.ArraySet;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
import com.tencent.qqlive.module.videoreport.data.DataEntityOperator;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import com.tencent.qqlive.module.videoreport.utils.ReusablePool;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FlattenDataBuilder
  implements IDataBuilder
{
  private static final String TAG = "FlattenDataBuilder";
  
  private Set<String> findDuplicateParams(PathData paramPathData)
  {
    Object localObject1 = paramPathData.iterator();
    paramPathData = new ArrayMap();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (DataEntity)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        localObject2 = DataEntityOperator.getElementParams((DataEntity)localObject2);
        if (localObject2 != null)
        {
          localObject2 = ((Map)localObject2).entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Map.Entry)((Iterator)localObject2).next()).getKey();
            if (!TextUtils.isEmpty(str)) {
              paramPathData.put(str, Integer.valueOf(((Integer)BaseUtils.nullAs(paramPathData.get(str), Integer.valueOf(0))).intValue() + 1));
            }
          }
        }
      }
    }
    localObject1 = new ArraySet();
    paramPathData = paramPathData.entrySet().iterator();
    while (paramPathData.hasNext())
    {
      localObject2 = (Map.Entry)paramPathData.next();
      if (((Integer)((Map.Entry)localObject2).getValue()).intValue() > 1) {
        ((Set)localObject1).add(((Map.Entry)localObject2).getKey());
      }
    }
    return localObject1;
  }
  
  public static FlattenDataBuilder getInstance()
  {
    return InstanceHolder.INSTANCE;
  }
  
  private void handleDuplication(PathData paramPathData)
  {
    Object localObject = findDuplicateParams(paramPathData);
    if (((Set)localObject).isEmpty()) {
      return;
    }
    Log.e("FlattenDataBuilder", "Duplicate params found: " + localObject);
    paramPathData = paramPathData.descendingIterator();
    while (paramPathData.hasNext())
    {
      localObject = (DataEntity)paramPathData.next();
      if (localObject != null)
      {
        Log.e("FlattenDataBuilder", "eid: " + (String)BaseUtils.nullAs(DataEntityOperator.getElementId((DataEntity)localObject), "eid is null"));
        localObject = DataEntityOperator.getElementParams((DataEntity)localObject);
        if (localObject != null)
        {
          localObject = ((Map)localObject).entrySet().iterator();
          while (((Iterator)localObject).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
            Log.e("FlattenDataBuilder", "    " + (String)localEntry.getKey() + ": " + localEntry.getValue());
          }
        }
      }
    }
    Log.e("FlattenDataBuilder", "--------");
  }
  
  @Nullable
  public FinalData build(PathData paramPathData)
  {
    if (paramPathData.isEmpty()) {
      return null;
    }
    FinalData localFinalData = (FinalData)ReusablePool.obtain(6);
    Iterator localIterator = paramPathData.descendingIterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (DataEntity)localIterator.next();
      if (localObject != null)
      {
        String str = DataEntityOperator.getElementId((DataEntity)localObject);
        if (!TextUtils.isEmpty(str)) {
          localFinalData.put("eid", str);
        }
        localObject = DataEntityOperator.getElementParams((DataEntity)localObject);
        if (BaseUtils.isEmpty((Map)localObject)) {
          break label117;
        }
        i = ((Map)localObject).size() + i;
        localFinalData.putAll((Map)localObject);
      }
    }
    label117:
    for (;;)
    {
      break;
      FinalDataUtils.appendPageInfo(localFinalData, paramPathData);
      return localFinalData;
    }
  }
  
  static class InstanceHolder
  {
    static final FlattenDataBuilder INSTANCE = new FlattenDataBuilder(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.reportdata.FlattenDataBuilder
 * JD-Core Version:    0.7.0.1
 */