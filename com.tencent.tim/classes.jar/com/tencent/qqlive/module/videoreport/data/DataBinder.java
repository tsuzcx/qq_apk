package com.tencent.qqlive.module.videoreport.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

public class DataBinder
{
  private static final IDataBinder DEFAULT_BINDER = new CommonDataBinder(null);
  private static final IDataBinder VIEW_BINDER = new ViewDataBinder(null);
  
  @Nullable
  public static DataEntity getDataEntity(@Nullable Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return with(paramObject).getDataEntity(paramObject);
  }
  
  static void setDataEntity(@Nullable Object paramObject, @Nullable DataEntity paramDataEntity)
  {
    if (paramObject == null) {
      return;
    }
    with(paramObject).setDataEntity(paramObject, paramDataEntity);
  }
  
  @NonNull
  private static IDataBinder with(Object paramObject)
  {
    if ((paramObject instanceof View)) {
      return VIEW_BINDER;
    }
    return DEFAULT_BINDER;
  }
  
  static class CommonDataBinder
    implements DataBinder.IDataBinder
  {
    @Nullable
    public DataEntity getDataEntity(Object paramObject)
    {
      return GlobalDataStorage.getData(paramObject);
    }
    
    public void setDataEntity(Object paramObject, DataEntity paramDataEntity)
    {
      GlobalDataStorage.setData(paramObject, paramDataEntity);
    }
  }
  
  static abstract interface IDataBinder
  {
    @Nullable
    public abstract DataEntity getDataEntity(Object paramObject);
    
    public abstract void setDataEntity(Object paramObject, DataEntity paramDataEntity);
  }
  
  static class ViewDataBinder
    implements DataBinder.IDataBinder
  {
    @Nullable
    public DataEntity getDataEntity(Object paramObject)
    {
      return (DataEntity)((View)paramObject).getTag(2131370078);
    }
    
    public void setDataEntity(Object paramObject, DataEntity paramDataEntity)
    {
      ((View)paramObject).setTag(2131370078, paramDataEntity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.data.DataBinder
 * JD-Core Version:    0.7.0.1
 */