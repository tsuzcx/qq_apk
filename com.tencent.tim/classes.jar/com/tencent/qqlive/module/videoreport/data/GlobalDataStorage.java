package com.tencent.qqlive.module.videoreport.data;

import android.support.annotation.NonNull;
import java.util.WeakHashMap;

class GlobalDataStorage
{
  private static final WeakHashMap<Object, DataEntity> DATA_MAP = new WeakHashMap();
  
  static DataEntity getData(@NonNull Object paramObject)
  {
    return (DataEntity)DATA_MAP.get(paramObject);
  }
  
  static void setData(@NonNull Object paramObject, DataEntity paramDataEntity)
  {
    DATA_MAP.put(paramObject, paramDataEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.data.GlobalDataStorage
 * JD-Core Version:    0.7.0.1
 */