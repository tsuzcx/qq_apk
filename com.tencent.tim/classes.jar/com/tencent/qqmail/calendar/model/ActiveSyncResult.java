package com.tencent.qqmail.calendar.model;

public final class ActiveSyncResult
{
  public int authCode;
  public int errorCode;
  public CActiveSyncFolderChangeResult folderChangeResult;
  public CActiveSyncFolderSyncResult folderSyncResult;
  public CActiveSyncMeetingResponseResult meetingResponseResult;
  public String policyKey;
  public String protocolVersion;
  public String serverAddr;
  public CActiveSyncSyncResult syncResult;
  public boolean update_account_ = false;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.ActiveSyncResult
 * JD-Core Version:    0.7.0.1
 */