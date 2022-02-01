package com.tencent.moai.mailsdk.protocol.activesync.Status;

public class GetItemEstimateStatus
  extends ActiveSyncStatus
{
  public static final String GetItemEstimateStatus_0 = "Default.";
  public static final String GetItemEstimateStatus_1 = "Success.";
  public static final String GetItemEstimateStatus_2 = "A collection was invalid or one of the specified collection IDs was invalid.";
  public static final String GetItemEstimateStatus_3 = "The synchronization state has not been primed.";
  public static final String GetItemEstimateStatus_4 = "The specified synchronization key was invalid.";
  
  public GetItemEstimateStatus(int paramInt)
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
    case 2: 
      return "A collection was invalid or one of the specified collection IDs was invalid.";
    case 3: 
      return "The synchronization state has not been primed.";
    }
    return "The specified synchronization key was invalid.";
  }
  
  public boolean isSyncKeyError()
  {
    return this.status == 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.Status.GetItemEstimateStatus
 * JD-Core Version:    0.7.0.1
 */