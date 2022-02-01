package com.tencent.moai.mailsdk.protocol.activesync.Status;

public class SearchMailStatus
  extends ActiveSyncStatus
{
  public static final String SearchMailStatus_0 = "Default";
  public static final String SearchMailStatus_1 = "Success";
  public static final String SearchMailStatus_10 = "Timed out.";
  public static final String SearchMailStatus_11 = "FolderSync required.";
  public static final String SearchMailStatus_12 = "End of retrievable range warning.";
  public static final String SearchMailStatus_13 = "Access blocked.";
  public static final String SearchMailStatus_14 = "Credentials required.";
  public static final String SearchMailStatus_2 = "The request was invalid.";
  public static final String SearchMailStatus_3 = "An error occurred on the server.";
  public static final String SearchMailStatus_4 = "Bad link.";
  public static final String SearchMailStatus_5 = "Access denied.";
  public static final String SearchMailStatus_6 = "Not found.";
  public static final String SearchMailStatus_7 = "Connection failed.";
  public static final String SearchMailStatus_8 = "Too complex.";
  
  public SearchMailStatus(int paramInt)
  {
    super(paramInt);
  }
  
  public String getStatusMsg()
  {
    switch (this.status)
    {
    case 9: 
    default: 
      return "Default";
    case 1: 
      return "Success";
    case 2: 
      return "The request was invalid.";
    case 3: 
      return "An error occurred on the server.";
    case 4: 
      return "Bad link.";
    case 5: 
      return "Access denied.";
    case 6: 
      return "Not found.";
    case 7: 
      return "Connection failed.";
    case 8: 
      return "Too complex.";
    case 10: 
      return "Timed out.";
    case 11: 
      return "FolderSync required.";
    case 12: 
      return "End of retrievable range warning.";
    case 13: 
      return "Access blocked.";
    }
    return "Credentials required.";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.Status.SearchMailStatus
 * JD-Core Version:    0.7.0.1
 */