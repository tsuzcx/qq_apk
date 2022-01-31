package com.tencent.securemodule.service;

import android.content.Context;

public abstract interface ISecureModuleService
{
  public abstract void cloudScan();
  
  public abstract int register(ProductInfo paramProductInfo);
  
  public abstract void registerCloudScanListener(Context paramContext, CloudScanListener paramCloudScanListener);
  
  public abstract void unregisterCloudScanListener(Context paramContext, CloudScanListener paramCloudScanListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.securemodule.service.ISecureModuleService
 * JD-Core Version:    0.7.0.1
 */