package com.tencent.moai.mailsdk.protocol.activesync.Status;

public class MoveItemStatus
  extends ActiveSyncStatus
{
  public static final String MoveItemStatus_0 = "Default.";
  public static final String MoveItemStatus_1 = "Invalid source collection ID or invalid source Item ID.";
  public static final String MoveItemStatus_2 = "Invalid destination collection ID.";
  public static final String MoveItemStatus_3 = "Success.";
  public static final String MoveItemStatus_4 = "Source and destination collection IDs are the same.";
  public static final String MoveItemStatus_5 = "One of the following failures occurred: the item cannot be moved to more than one item at a time, or the source or destination item was locked.";
  public static final String MoveItemStatus_7 = "Source or destination item was locked.";
  
  public MoveItemStatus(int paramInt)
  {
    super(paramInt);
  }
  
  public String getStatusMsg()
  {
    switch (this.status)
    {
    case 6: 
    default: 
      return "Default.";
    case 1: 
      return "Invalid source collection ID or invalid source Item ID.";
    case 2: 
      return "Invalid destination collection ID.";
    case 3: 
      return "Success.";
    case 4: 
      return "Source and destination collection IDs are the same.";
    case 5: 
      return "One of the following failures occurred: the item cannot be moved to more than one item at a time, or the source or destination item was locked.";
    }
    return "Source or destination item was locked.";
  }
  
  public boolean isStatusOk()
  {
    return this.status == 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.Status.MoveItemStatus
 * JD-Core Version:    0.7.0.1
 */