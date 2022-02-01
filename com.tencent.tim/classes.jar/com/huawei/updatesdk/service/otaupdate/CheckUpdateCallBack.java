package com.huawei.updatesdk.service.otaupdate;

import android.content.Intent;

public abstract interface CheckUpdateCallBack
{
  public abstract void onMarketInstallInfo(Intent paramIntent);
  
  public abstract void onMarketStoreError(int paramInt);
  
  public abstract void onUpdateInfo(Intent paramIntent);
  
  public abstract void onUpdateStoreError(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
 * JD-Core Version:    0.7.0.1
 */