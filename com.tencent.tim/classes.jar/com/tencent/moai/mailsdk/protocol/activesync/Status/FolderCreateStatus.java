package com.tencent.moai.mailsdk.protocol.activesync.Status;

public class FolderCreateStatus
  extends ActiveSyncStatus
{
  public static final String FolderCreateStatus_0 = "Default.";
  public static final String FolderCreateStatus_1 = "Success.";
  public static final String FolderCreateStatus_10 = "Malformed request.";
  public static final String FolderCreateStatus_11 = "An unknown error occurred.";
  public static final String FolderCreateStatus_12 = "Code unknown.";
  public static final String FolderCreateStatus_2 = "A folder that has this name already exists.";
  public static final String FolderCreateStatus_3 = "The specified parent folder is a special system folder.";
  public static final String FolderCreateStatus_5 = "The specified parent folder was not found.";
  public static final String FolderCreateStatus_6 = "An error occurred on the server.";
  public static final String FolderCreateStatus_9 = "Synchronization key mismatch or invalid synchronization key.";
  
  public FolderCreateStatus(int paramInt)
  {
    super(paramInt);
  }
  
  public String getStatusMsg()
  {
    switch (this.status)
    {
    case 4: 
    case 7: 
    case 8: 
    default: 
      return "Default.";
    case 1: 
      return "Success.";
    case 2: 
      return "A folder that has this name already exists.";
    case 3: 
      return "The specified parent folder is a special system folder.";
    case 5: 
      return "The specified parent folder was not found.";
    case 6: 
      return "An error occurred on the server.";
    case 9: 
      return "Synchronization key mismatch or invalid synchronization key.";
    case 10: 
      return "Malformed request.";
    case 11: 
      return "An unknown error occurred.";
    }
    return "Code unknown.";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.Status.FolderCreateStatus
 * JD-Core Version:    0.7.0.1
 */