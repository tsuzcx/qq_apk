package com.tencent.moai.mailsdk.protocol.activesync.Status;

public class FolderSyncStatus
  extends ActiveSyncStatus
{
  public static final String FolderSyncStatus_0 = "Default.";
  public static final String FolderSyncStatus_1 = "Success.";
  public static final String FolderSyncStatus_10 = "Incorrectly formatted request.";
  public static final String FolderSyncStatus_11 = "An unknown error occurred.";
  public static final String FolderSyncStatus_12 = "Code unknown.";
  public static final String FolderSyncStatus_6 = "An error occurred on the server.";
  public static final String FolderSyncStatus_9 = "Synchronization key mismatch or invalid synchronization key.";
  
  public FolderSyncStatus(int paramInt)
  {
    super(paramInt);
  }
  
  public String getStatusMsg()
  {
    switch (this.status)
    {
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 7: 
    case 8: 
    default: 
      return "Default.";
    case 1: 
      return "Success.";
    case 6: 
      return "An error occurred on the server.";
    case 9: 
      return "Synchronization key mismatch or invalid synchronization key.";
    case 10: 
      return "Incorrectly formatted request.";
    case 11: 
      return "An unknown error occurred.";
    }
    return "Code unknown.";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.Status.FolderSyncStatus
 * JD-Core Version:    0.7.0.1
 */