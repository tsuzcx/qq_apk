package com.tencent.qapmsdk.impl.harvest;

public abstract interface HarvestLifecycleAware
{
  public abstract void onHarvest();
  
  public abstract void onHarvestBefore();
  
  public abstract void onHarvestComplete();
  
  public abstract void onHarvestConnected();
  
  public abstract void onHarvestDeviceIdError();
  
  public abstract void onHarvestDisabled();
  
  public abstract void onHarvestDisconnected();
  
  public abstract void onHarvestError();
  
  public abstract void onHarvestFilter();
  
  public abstract void onHarvestFinalize();
  
  public abstract void onHarvestSendFailed();
  
  public abstract void onHarvestStart();
  
  public abstract void onHarvestStop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.harvest.HarvestLifecycleAware
 * JD-Core Version:    0.7.0.1
 */