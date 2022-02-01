package com.tencent.moai.mailsdk.protocol.activesync.Status;

public class ProvisionStatus
  extends ActiveSyncStatus
{
  public static final String ProvisionStatus_0 = "Default";
  public static final String ProvisionStatus_1 = "Success";
  public static final String ProvisionStatus_2 = "Policy not defined.";
  public static final String ProvisionStatus_3 = "The policy type is unknown.";
  public static final String ProvisionStatus_4 = "Policy data is corrupt.";
  public static final String ProvisionStatus_5 = "The client is trying to acknowledge an out-of-date or invalid policy.";
  
  public ProvisionStatus(int paramInt)
  {
    super(paramInt);
  }
  
  public String getStatusMsg()
  {
    switch (this.status)
    {
    default: 
      return "Default";
    case 1: 
      return "Success";
    case 2: 
      return "Policy not defined.";
    case 3: 
      return "The policy type is unknown.";
    case 4: 
      return "Policy data is corrupt.";
    }
    return "The client is trying to acknowledge an out-of-date or invalid policy.";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.Status.ProvisionStatus
 * JD-Core Version:    0.7.0.1
 */