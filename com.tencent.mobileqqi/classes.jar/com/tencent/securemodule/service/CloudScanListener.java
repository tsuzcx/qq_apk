package com.tencent.securemodule.service;

public abstract interface CloudScanListener
{
  public abstract void onFinish(int paramInt);
  
  public abstract void onRiskFound();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.securemodule.service.CloudScanListener
 * JD-Core Version:    0.7.0.1
 */