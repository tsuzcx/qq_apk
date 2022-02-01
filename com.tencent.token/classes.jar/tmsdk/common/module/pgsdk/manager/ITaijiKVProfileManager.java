package tmsdk.common.module.pgsdk.manager;

import java.util.HashMap;

public abstract interface ITaijiKVProfileManager
{
  public abstract void uploadKVProfile(HashMap<Integer, String> paramHashMap, HashMap<Integer, Integer> paramHashMap1, IProfileUploadCallback paramIProfileUploadCallback);
  
  public static abstract interface IProfileUploadCallback
  {
    public abstract void onUploadSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.module.pgsdk.manager.ITaijiKVProfileManager
 * JD-Core Version:    0.7.0.1
 */