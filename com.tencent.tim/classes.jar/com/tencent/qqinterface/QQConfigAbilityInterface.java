package com.tencent.qqinterface;

import org.json.JSONObject;

public abstract interface QQConfigAbilityInterface
{
  public abstract JSONObject getConfigFromQQ();
  
  public abstract void requestConfigFromQQ(Callback<JSONObject> paramCallback);
  
  public static abstract interface Callback<T>
  {
    public abstract void onResult(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.qqinterface.QQConfigAbilityInterface
 * JD-Core Version:    0.7.0.1
 */