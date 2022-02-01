package com.tencent.qqlive.module.videoreport.reportdata;

import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
import com.tencent.qqlive.module.videoreport.data.DataEntityOperator;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import com.tencent.qqlive.module.videoreport.utils.ReusablePool;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class NestedDataBuilder
  implements IDataBuilder
{
  private void fillDataEntity(Map<String, Object> paramMap, DataEntity paramDataEntity)
  {
    String str = DataEntityOperator.getElementId(paramDataEntity);
    if (!TextUtils.isEmpty(str)) {
      paramMap.put("eid", str);
    }
    paramDataEntity = DataEntityOperator.getElementParams(paramDataEntity);
    if (!BaseUtils.isEmpty(paramDataEntity)) {
      paramMap.putAll(paramDataEntity);
    }
  }
  
  public static NestedDataBuilder getInstance()
  {
    return InstanceHolder.INSTANCE;
  }
  
  @Nullable
  public FinalData build(PathData paramPathData)
  {
    if (paramPathData.isEmpty()) {
      return null;
    }
    FinalData localFinalData = (FinalData)ReusablePool.obtain(6);
    int j = paramPathData.size();
    Object localObject = paramPathData.descendingIterator();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < j - 1)
    {
      DataEntity localDataEntity = (DataEntity)((Iterator)localObject).next();
      ArrayMap localArrayMap = new ArrayMap();
      fillDataEntity(localArrayMap, localDataEntity);
      localArrayList.add(localArrayMap);
      i += 1;
    }
    if (localArrayList.size() > 0) {
      localFinalData.put("prnts", localArrayList);
    }
    localObject = (DataEntity)((Iterator)localObject).next();
    localFinalData.put("eid", DataEntityOperator.getElementId((DataEntity)localObject));
    localFinalData.putAll(DataEntityOperator.getElementParams((DataEntity)localObject));
    FinalDataUtils.appendPageInfo(localFinalData, paramPathData);
    return localFinalData;
  }
  
  static class InstanceHolder
  {
    static final NestedDataBuilder INSTANCE = new NestedDataBuilder(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.reportdata.NestedDataBuilder
 * JD-Core Version:    0.7.0.1
 */