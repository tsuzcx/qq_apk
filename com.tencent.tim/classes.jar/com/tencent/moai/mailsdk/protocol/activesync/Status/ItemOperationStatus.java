package com.tencent.moai.mailsdk.protocol.activesync.Status;

public class ItemOperationStatus
  extends ActiveSyncStatus
{
  public static final String ItemOperationStatus_0 = "Default.";
  public static final String ItemOperationStatus_1 = "Success.";
  public static final String ItemOperationStatus_10 = "The file is empty.";
  public static final String ItemOperationStatus_11 = "The requested data size is too large.";
  public static final String ItemOperationStatus_12 = "Failed to download file because of input/output (I/O) failure.";
  public static final String ItemOperationStatus_14 = "Mailbox fetch provider - The item failed conversion.";
  public static final String ItemOperationStatus_15 = "Attachment fetch provider - Attachment or attachment ID is invalid.";
  public static final String ItemOperationStatus_155 = "Protocol error. The Options element and the MoveAlways element are missing from the ItemOperations request.";
  public static final String ItemOperationStatus_156 = "Action not supported. The destination folder MUST be of type IPF.Note. For more details about folder types.";
  public static final String ItemOperationStatus_16 = "Access to the resource is denied.";
  public static final String ItemOperationStatus_17 = "Partial success; the command completed partially.";
  public static final String ItemOperationStatus_18 = "Credentials required.";
  public static final String ItemOperationStatus_2 = "Protocol error - protocol violation/XML validation error.";
  public static final String ItemOperationStatus_3 = "server error.";
  public static final String ItemOperationStatus_4 = "Document library access - The specified URI is bad.";
  public static final String ItemOperationStatus_5 = "Document library - Access denied.";
  public static final String ItemOperationStatus_6 = "Document library - The object was not found or access denied.";
  public static final String ItemOperationStatus_7 = "Document library - Failed to connect to the server.";
  public static final String ItemOperationStatus_8 = "The byte-range is invalid or too large.";
  public static final String ItemOperationStatus_9 = "The store is unknown or unsupported.";
  
  public ItemOperationStatus(int paramInt)
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
      return "Protocol error - protocol violation/XML validation error.";
    case 3: 
      return "server error.";
    case 4: 
      return "Document library access - The specified URI is bad.";
    case 5: 
      return "Document library - Access denied.";
    case 6: 
      return "Document library - The object was not found or access denied.";
    case 7: 
      return "Document library - Failed to connect to the server.";
    case 8: 
      return "The byte-range is invalid or too large.";
    case 9: 
      return "The store is unknown or unsupported.";
    case 10: 
      return "The file is empty.";
    case 11: 
      return "The requested data size is too large.";
    case 12: 
      return "Failed to download file because of input/output (I/O) failure.";
    case 14: 
      return "Mailbox fetch provider - The item failed conversion.";
    case 15: 
      return "Attachment fetch provider - Attachment or attachment ID is invalid.";
    case 16: 
      return "Access to the resource is denied.";
    case 17: 
      return "Partial success; the command completed partially.";
    case 18: 
      return "Credentials required.";
    case 155: 
      return "Protocol error. The Options element and the MoveAlways element are missing from the ItemOperations request.";
    }
    return "Action not supported. The destination folder MUST be of type IPF.Note. For more details about folder types.";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.Status.ItemOperationStatus
 * JD-Core Version:    0.7.0.1
 */