package com.tencent.moai.mailsdk.protocol.exchange;

public class ExchangeDefine
{
  public static final String CMD_CREATE_FOLDER = "CreateFolder";
  public static final String CMD_CREATE_ITEM = "CreateItem";
  public static final String CMD_DELETE_FOLDER = "DeleteFolder";
  public static final String CMD_DELETE_ITEM = "DeleteItem";
  public static final String CMD_FIND_FOLDER = "FindFolder";
  public static final String CMD_FIND_ITEM = "FindItem";
  public static final String CMD_GET_ATTACHMENT = "GetAttachment";
  public static final String CMD_GET_FOLDER = "GetFolder";
  public static final String CMD_GET_ITEM = "GetItem";
  public static final String CMD_MOVE_ITEM = "MoveItem";
  public static final String CMD_SYNC_FOLDER_ITEMS = "SyncFolderItems";
  public static final String CMD_UPDATE_FOLDER = "UpdateFolder";
  public static final String CMD_UPDATE_INDEX_RULES = "UpdateInboxRules";
  public static final String CMD_UPDATE_ITEM = "UpdateItem";
  public static final String DISTINGUISHED_FOLDER_ID = "DistinguishedFolderId";
  public static final String FOLDER_CLASS = "FolderClass";
  public static final String FOLDER_DISPLAY_NAME = "DisplayName";
  public static final String FOLDER_ID = "FolderId";
  public static final String FOLDER_PARENT_FOLDER_ID = "ParentFolderId";
  public static final String FOLDER_TOTAL_COUNT = "TotalCount";
  public static final String FOLLOWUP_FLAGGED_VALUE = "2";
  public static final int HTTP_AUTH_CODE = 401;
  public static final int HTTP_FORBIDDEN = 403;
  public static final int MAX_RESPONSE_SIZE = 512;
  public static final String PROPERTY_TAG_FLAG_STATUS = "0x1090";
  public static final String PROPERTY_TAG_FOLLOW_ICON = "0x1095";
  public static final String RED_FLAG_VALUE = "6";
  public static final String RESPONSE_CODE_NOERROR = "NoError";
  public static final String SOAP_ENVELOPE_END = "</s:Envelope>";
  public static final String SOAP_ENVELOPE_START = "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:enc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:t=\"http://schemas.microsoft.com/exchange/services/2006/types\" xmlns:m=\"http://schemas.microsoft.com/exchange/services/2006/messages\">";
  public static final String SOAP_HEADER = "<s:Header><t:RequestServerVersion s:mustUnderstand=\"1\" Version=\"%s\"></t:RequestServerVersion></s:Header>";
  public static final int SYNC_DAYS = 15;
  public static final String SYSTEM_FOLDER_DELETEITEMS = "deleteditems";
  public static final String SYSTEM_FOLDER_DRAFTS = "drafts";
  public static final String SYSTEM_FOLDER_INBOX = "inbox";
  public static final String SYSTEM_FOLDER_JUNKEMAIL = "junkemail";
  public static final String SYSTEM_FOLDER_OUTBOX = "outbox";
  public static final String SYSTEM_FOLDER_ROOT = "msgfolderroot";
  public static final String SYSTEM_FOLDER_SENTITEMS = "sentitems";
  public static final String VALID_FOLDER_CLASS = "IPF.Note";
  public static final String VERSION_2007_SP1 = "Exchange2007_SP1";
  public static final String VERSION_2010_SP1 = "Exchange2010_SP1";
  public static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.exchange.ExchangeDefine
 * JD-Core Version:    0.7.0.1
 */