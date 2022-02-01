package com.tencent.moai.mailsdk.protocol.activesync;

import com.tencent.moai.mailsdk.util.log.Logger;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SyncKeyHandler
{
  private static SyncKeyHandler instance = new SyncKeyHandler();
  private SyncKeyCallback accountSyncKeyCallback;
  private ConcurrentHashMap<Integer, String> accountSyncKeys = new ConcurrentHashMap();
  private SyncKeyCallback folderSyncKeyCallback;
  private ConcurrentHashMap<Integer, String> folderSyncKeys = new ConcurrentHashMap();
  
  public static SyncKeyHandler getInstance()
  {
    return instance;
  }
  
  public String getAccountSyncKey(int paramInt)
  {
    String str2 = (String)this.accountSyncKeys.get(Integer.valueOf(paramInt));
    String str1 = str2;
    if (str2 == null) {
      str1 = "0";
    }
    return str1;
  }
  
  public String getFolderSyncKey(int paramInt)
  {
    String str2 = (String)this.folderSyncKeys.get(Integer.valueOf(paramInt));
    String str1 = str2;
    if (str2 == null) {
      str1 = "0";
    }
    return str1;
  }
  
  public void initAccountSyncKeyMapping(Map<Integer, String> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      this.accountSyncKeys.put(localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public void initFolderSyncKeyMapping(Map<Integer, String> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      this.folderSyncKeys.put(localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public void removeAccountSyncKey(int paramInt)
  {
    this.accountSyncKeys.remove(Integer.valueOf(paramInt));
  }
  
  public void removeFolderSyncKey(int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      this.folderSyncKeys.remove(Integer.valueOf(k));
      i += 1;
    }
  }
  
  public void setAccountSyncKey(int paramInt, String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.accountSyncKeys.put(Integer.valueOf(paramInt), paramString);
    if (this.accountSyncKeyCallback != null) {
      this.accountSyncKeyCallback.onSyncKey(paramInt, paramString);
    }
    Logger.log(4, "SYNC_KEY", "set syncKey accountId " + paramInt + " synckey " + paramString);
  }
  
  public void setAccountSyncKeyCallback(SyncKeyCallback paramSyncKeyCallback)
  {
    this.accountSyncKeyCallback = paramSyncKeyCallback;
  }
  
  public void setFolderSyncKey(int paramInt, String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.folderSyncKeys.put(Integer.valueOf(paramInt), paramString);
    if (this.folderSyncKeyCallback != null) {
      this.folderSyncKeyCallback.onSyncKey(paramInt, paramString);
    }
    Logger.log(4, "SYNC_KEY", "set syncKey folderId " + paramInt + " synckey " + paramString);
  }
  
  public void setFolderSyncKeyCallback(SyncKeyCallback paramSyncKeyCallback)
  {
    this.folderSyncKeyCallback = paramSyncKeyCallback;
  }
  
  public static abstract interface SyncKeyCallback
  {
    public abstract void onSyncKey(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.SyncKeyHandler
 * JD-Core Version:    0.7.0.1
 */