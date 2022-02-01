package com.tencent.moai.mailsdk.protocol.activesync.Status;

public class SearchGALStatus
  extends ActiveSyncStatus
{
  public static final String SearchGALStatus_0 = "Default.";
  public static final String SearchGALStatus_1 = "Success.";
  public static final String SearchGALStatus_173 = "The user does not have a contact photo.";
  public static final String SearchGALStatus_174 = "The contact photo exceeded the size limit set by the MaxSize element.";
  public static final String SearchGALStatus_175 = "The number of contact photos returned exceeded the size limit set by the MaxPictures element.";
  
  public SearchGALStatus(int paramInt)
  {
    super(paramInt);
  }
  
  public String getStatusMsg()
  {
    switch (this.status)
    {
    default: 
      return "Default.";
    case 1: 
      return "Success.";
    case 173: 
      return "The user does not have a contact photo.";
    case 174: 
      return "The contact photo exceeded the size limit set by the MaxSize element.";
    }
    return "The number of contact photos returned exceeded the size limit set by the MaxPictures element.";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.Status.SearchGALStatus
 * JD-Core Version:    0.7.0.1
 */