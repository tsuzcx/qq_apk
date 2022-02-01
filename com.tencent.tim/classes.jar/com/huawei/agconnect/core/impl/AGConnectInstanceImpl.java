package com.huawei.agconnect.core.impl;

import android.content.Context;
import com.huawei.agconnect.AGConnectInstance;

public class AGConnectInstanceImpl
  extends AGConnectInstance
{
  private final Context mContext;
  private final ServiceRepository mServiceRepository;
  
  public AGConnectInstanceImpl(Context paramContext)
  {
    this.mContext = paramContext;
    this.mServiceRepository = new ServiceRepository(new ServiceRegistrarParser(paramContext).getServices());
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public <T> T getService(Class<T> paramClass)
  {
    return this.mServiceRepository.getService(this, paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.agconnect.core.impl.AGConnectInstanceImpl
 * JD-Core Version:    0.7.0.1
 */