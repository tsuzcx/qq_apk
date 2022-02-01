package com.tencent.qqmail.model.qmdomain;

public class Folder
  extends QMDomain
{
  public static final String ADDRVIP_FOLDER_SESSION_NAME = "addrvip";
  public static final String APP_FOLDER_SESSION_NAME = "app";
  public static final int DRAFT_ID = 4;
  public static final String DRAFT_INDEX = "4__";
  public static final int GROUP_ID = 8;
  public static final String GROUP_INDEX = "8__";
  public static final int INBOX_ID = 1;
  public static final String INBOX_INDEX = "1__";
  public static final String NOTE_INDEX = "note__";
  public static final String POP_FOLDER_SESSION_NAME = "pop";
  public static final int PURGE_TRASH_ID = 0;
  public static final String PURGE_TRASH_INDEX = "0__";
  public static final String SENDING_INDEX = "send__";
  public static final int SENT_ID = 3;
  public static final String SENT_INDEX = "3__";
  public static final int SPAM_ID = 6;
  public static final String SPAM_INDEX = "6__";
  public static final String STAR_INDEX = "all_star_";
  public static final String SUBSCRIPTION_INDEX = "129__";
  public static final String SYS_FOLDER_SESSION_NAME = "sys";
  public static final String TAG_FOLDER_SESSION_NAME = "tag";
  public static final String TAG_INDEX = "all_tag_";
  public static final int TRASH_ID = 5;
  public static final String TRASH_INDEX = "5__";
  public static final String UNREADLIST_FOLDER_SESSION_NAME = "unreadlist";
  public static final String UNREAD_INDEX = "unreadlist_unreadlist_";
  public static final String[] UNREAD_INDEX_LOCAL = { "1", "3", "8", "9", "subscribe", "pop", "personal" };
  public static final String USER_FOLDER_SESSION_NAME = "user";
  public static final String VIP_INDEX = "addrvip_addrvip_";
  private static final long serialVersionUID = -1223123327345993475L;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.Folder
 * JD-Core Version:    0.7.0.1
 */