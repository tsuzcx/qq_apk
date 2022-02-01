package com.tencent.moai.mailsdk.protocol.activesync;

public class ActiveSyncDefine
{
  public static final String CMD_SUB_TYPE_PROVISION_POLICY_KEY = "PolicyKey";
  public static final String CMD_SUB_TYPE_PROVISION_POLICY_KEY_ACK = "PolicyKeyACK";
  public static final String CMD_SUB_TYPE_SEARCH_GAL = "SearchGAL";
  public static final String CMD_SUB_TYPE_SEARCH_MAIL = "SearchMail";
  public static final String CMD_SUB_TYPE_SYNC_MAIL_ABSTRACT = "SyncMailAbstract";
  public static final String CMD_SUB_TYPE_SYNC_MAIL_DELETE = "SyncMailDelete";
  public static final String CMD_SUB_TYPE_SYNC_MAIL_LIST = "SyncMailList";
  public static final String CMD_SUB_TYPE_SYNC_MAIL_MARK = "SyncMailMark";
  public static final String CMD_SUB_TYPE_SYNC_MAIL_TEXT = "SyncMailText";
  public static final String CMD_TYPE_FOLDER_CREATE = "FolderCreate";
  public static final String CMD_TYPE_FOLDER_DELETE = "FolderDelete";
  public static final String CMD_TYPE_FOLDER_SYNC = "FolderSync";
  public static final String CMD_TYPE_FOLDER_UPDATE = "FolderUpdate";
  public static final String CMD_TYPE_GET_ITEM_ESTIMATE = "GetItemEstimate";
  public static final String CMD_TYPE_ITEM_OPERATIONS = "ItemOperations";
  public static final String CMD_TYPE_MOVE_ITEMS = "MoveItems";
  public static final String CMD_TYPE_OPTIONS = "Options";
  public static final String CMD_TYPE_PROVISION = "Provision";
  public static final String CMD_TYPE_SEARCH = "Search";
  public static final String CMD_TYPE_SEND_MAIL = "SendMail";
  public static final String CMD_TYPE_SYNC = "Sync";
  public static final int MSF_BODY = 3;
  public static final int MSF_FROM = 0;
  public static final int MSF_SUBJECT = 2;
  public static final int MSF_TO = 1;
  public static final String POLICY_TYPE_WBXML = "MS-EAS-Provisioning-WBXML";
  public static final String POLICY_TYPE_XML = "MS-WAP-Provisioning-XML";
  public static final String szActiveSyncOptionsPrefix = "/Microsoft-Server-ActiveSync";
  public static final String szActiveSyncPathPrefix = "/Microsoft-Server-ActiveSync?";
  public static final String xmlHeader = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.ActiveSyncDefine
 * JD-Core Version:    0.7.0.1
 */