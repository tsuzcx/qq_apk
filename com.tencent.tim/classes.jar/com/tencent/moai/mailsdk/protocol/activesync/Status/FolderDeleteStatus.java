package com.tencent.moai.mailsdk.protocol.activesync.Status;

public class FolderDeleteStatus
  extends ActiveSyncStatus
{
  public static final String FolderDeleteStatus_0 = "Default.";
  public static final String FolderDeleteStatus_1 = "Success.";
  public static final String FolderDeleteStatus_10 = "Incorrectly formatted request.";
  public static final String FolderDeleteStatus_11 = "An unknown error occurred.";
  public static final String FolderDeleteStatus_3 = "The specified folder is a special system folder, such as the Inbox folder, Outbox folder, Contacts folder, Recipient information, or Drafts folder, and cannot be deleted by the client.";
  public static final String FolderDeleteStatus_4 = "The specified folder does not exist.";
  public static final String FolderDeleteStatus_6 = "An error occurred on the server.";
  public static final String FolderDeleteStatus_9 = "Synchronization key mismatch or invalid synchronization key.";
  
  public FolderDeleteStatus(int paramInt)
  {
    super(paramInt);
  }
  
  public String getStatusMsg()
  {
    switch (this.status)
    {
    case 2: 
    case 5: 
    case 7: 
    case 8: 
    default: 
      return "Default.";
    case 1: 
      return "Success.";
    case 3: 
      return "The specified folder is a special system folder, such as the Inbox folder, Outbox folder, Contacts folder, Recipient information, or Drafts folder, and cannot be deleted by the client.";
    case 4: 
      return "The specified folder does not exist.";
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
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.Status.FolderDeleteStatus
 * JD-Core Version:    0.7.0.1
 */