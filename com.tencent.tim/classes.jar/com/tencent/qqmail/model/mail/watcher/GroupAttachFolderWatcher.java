package com.tencent.qqmail.model.mail.watcher;

public abstract interface GroupAttachFolderWatcher
{
  public abstract boolean isQQMail(int paramInt);
  
  public abstract void onSyncLocal(int paramInt, long[] paramArrayOfLong);
  
  public abstract void onSyncLocalComplete();
  
  public abstract void onSyncRemote(int paramInt, SyncRemoteParams[] paramArrayOfSyncRemoteParams);
  
  public static class SyncRemoteParams
  {
    public long attachId;
    public String groupDownKey;
    public String name;
    public String remoteId;
    
    public String getSyncRemoteParamsDetail()
    {
      return this.attachId + "," + this.remoteId + "," + this.name + "," + this.groupDownKey;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.GroupAttachFolderWatcher
 * JD-Core Version:    0.7.0.1
 */