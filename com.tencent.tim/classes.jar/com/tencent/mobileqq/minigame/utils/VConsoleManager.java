package com.tencent.mobileqq.minigame.utils;

import java.util.HashMap;

public class VConsoleManager
{
  private static final String TAG = "VConsoleManager";
  private static VConsoleManager instance;
  private HashMap<Integer, VConsoleLogManager> vConsoleLogManagerMap = new HashMap();
  
  public static VConsoleManager getInstance()
  {
    if (instance == null) {
      instance = new VConsoleManager();
    }
    return instance;
  }
  
  public VConsoleLogManager getLogManager(int paramInt)
  {
    if ((this.vConsoleLogManagerMap == null) || (this.vConsoleLogManagerMap.size() == 0)) {
      return null;
    }
    return (VConsoleLogManager)this.vConsoleLogManagerMap.get(Integer.valueOf(paramInt));
  }
  
  public void registerLogManager(int paramInt, VConsoleLogManager paramVConsoleLogManager)
  {
    if (this.vConsoleLogManagerMap == null) {
      this.vConsoleLogManagerMap = new HashMap();
    }
    this.vConsoleLogManagerMap.put(Integer.valueOf(paramInt), paramVConsoleLogManager);
  }
  
  public void unRegisterLogManager(int paramInt)
  {
    if (this.vConsoleLogManagerMap == null) {
      return;
    }
    this.vConsoleLogManagerMap.remove(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.utils.VConsoleManager
 * JD-Core Version:    0.7.0.1
 */