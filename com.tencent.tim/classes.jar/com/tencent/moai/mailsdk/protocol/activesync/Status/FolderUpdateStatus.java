package com.tencent.moai.mailsdk.protocol.activesync.Status;

public class FolderUpdateStatus
  extends ActiveSyncStatus
{
  public static final String FolderUpdateStatus_0 = "Default.";
  public static final String FolderUpdateStatus_1 = "Success.";
  public static final String FolderUpdateStatus_10 = "Incorrectly formatted request.";
  public static final String FolderUpdateStatus_11 = "An unknown error occurred.";
  public static final String FolderUpdateStatus_2 = "A folder that has this name already exists or the specified folder is a special folder.";
  public static final String FolderUpdateStatus_3 = "The specified folder is the Recipient information folder, which cannot be updated by the client.";
  public static final String FolderUpdateStatus_4 = "The specified folder does not exist.";
  public static final String FolderUpdateStatus_5 = "The specified parent folder was not found.";
  public static final String FolderUpdateStatus_6 = "An error occurred on the server.";
  public static final String FolderUpdateStatus_9 = "Synchronization key mismatch or invalid synchronization key.";
  
  public FolderUpdateStatus(int paramInt)
  {
    super(paramInt);
  }
  
  public String getStatusMsg()
  {
    switch (this.status)
    {
    case 7: 
    case 8: 
    default: 
      return "Default.";
    case 1: 
      return "Success.";
    case 2: 
      return "A folder that has this name already exists or the specified folder is a special folder.";
    case 3: 
      return "The specified folder is the Recipient information folder, which cannot be updated by the client.";
    case 4: 
      return "The specified folder does not exist.";
    case 5: 
      return "The specified parent folder was not found.";
    case 6: 
      return "An error occurred on the server.";
    case 9: 
      return "Synchronization key mismatch or invalid synchronization key.";
    case 10: 
      return "Incorrectly formatted request.";
    }
    return "An unknown error occurred.";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.Status.FolderUpdateStatus
 * JD-Core Version:    0.7.0.1
 */