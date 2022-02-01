package com.tencent.moai.mailsdk.protocol.activesync.Status;

public class SyncStatus
  extends ActiveSyncStatus
{
  public static final String SyncStatus_0 = "Default.";
  public static final String SyncStatus_1 = "Success.";
  public static final String SyncStatus_12 = "The folder hierarchy has changed.";
  public static final String SyncStatus_13 = "The Sync command request is not complete.";
  public static final String SyncStatus_14 = "Invalid Wait or HeartbeatInterval value.";
  public static final String SyncStatus_15 = "Invalid Sync command request.";
  public static final String SyncStatus_16 = "Retry,Something on the server caused a retrievable error.";
  public static final String SyncStatus_3 = "Invalid synchronization key.";
  public static final String SyncStatus_4 = "Protocol error.";
  public static final String SyncStatus_5 = "Server error.";
  public static final String SyncStatus_6 = "Error in client/server conversion.";
  public static final String SyncStatus_7 = "Conflict matching the client and server object.";
  public static final String SyncStatus_8 = "Object not found.";
  public static final String SyncStatus_9 = "The Sync command cannot be completed.";
  
  public SyncStatus(int paramInt)
  {
    super(paramInt);
  }
  
  public String getStatusMsg()
  {
    switch (this.status)
    {
    case 2: 
    case 10: 
    case 11: 
    default: 
      return "Default.";
    case 1: 
      return "Success.";
    case 3: 
      return "Invalid synchronization key.";
    case 4: 
      return "Protocol error.";
    case 5: 
      return "Server error.";
    case 6: 
      return "Error in client/server conversion.";
    case 7: 
      return "Conflict matching the client and server object.";
    case 8: 
      return "Object not found.";
    case 9: 
      return "The Sync command cannot be completed.";
    case 12: 
      return "The folder hierarchy has changed.";
    case 13: 
      return "The Sync command request is not complete.";
    case 14: 
      return "Invalid Wait or HeartbeatInterval value.";
    case 15: 
      return "Invalid Sync command request.";
    }
    return "Retry,Something on the server caused a retrievable error.";
  }
  
  public boolean isSyncKeyError()
  {
    return this.status == 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.Status.SyncStatus
 * JD-Core Version:    0.7.0.1
 */