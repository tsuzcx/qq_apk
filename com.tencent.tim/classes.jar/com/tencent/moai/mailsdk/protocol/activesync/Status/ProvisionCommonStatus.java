package com.tencent.moai.mailsdk.protocol.activesync.Status;

public class ProvisionCommonStatus
  extends ActiveSyncStatus
{
  public static final String ProvisionCommonStatus_0 = "Default";
  public static final String ProvisionCommonStatus_1 = "Success";
  public static final String ProvisionCommonStatus_139 = "The client cannot fully comply with all requirements of the policy.";
  public static final String ProvisionCommonStatus_141 = "The client did not submit a policy key value in a request. The server is configured to not allow clients that do not submit a policy key value.";
  public static final String ProvisionCommonStatus_145 = "The client returned a value of 4 in the Status child element of the Policy.";
  public static final String ProvisionCommonStatus_2 = "Protocol error,Syntax error in the Provision command request.";
  public static final String ProvisionCommonStatus_3 = "An error occurred on the server.";
  
  public ProvisionCommonStatus(int paramInt)
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
      return "Protocol error,Syntax error in the Provision command request.";
    case 3: 
      return "An error occurred on the server.";
    case 139: 
      return "The client cannot fully comply with all requirements of the policy.";
    case 141: 
      return "The client did not submit a policy key value in a request. The server is configured to not allow clients that do not submit a policy key value.";
    }
    return "The client returned a value of 4 in the Status child element of the Policy.";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.Status.ProvisionCommonStatus
 * JD-Core Version:    0.7.0.1
 */