package com.tencent.mobileqq.emosm;

import android.os.Bundle;

public abstract class Client$onRemoteRespObserver
{
  private static int seed = 0;
  public int key;
  
  public Client$onRemoteRespObserver()
  {
    int i = seed;
    seed = i + 1;
    this.key = i;
  }
  
  public abstract void onBindedToClient();
  
  public abstract void onDisconnectWithService();
  
  public abstract void onPushMsg(Bundle paramBundle);
  
  public abstract void onResponse(Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.Client.onRemoteRespObserver
 * JD-Core Version:    0.7.0.1
 */