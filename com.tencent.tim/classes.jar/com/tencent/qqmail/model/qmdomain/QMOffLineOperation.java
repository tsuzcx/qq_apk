package com.tencent.qqmail.model.qmdomain;

import com.tencent.qqmail.utilities.QMMath;

public class QMOffLineOperation
{
  public static final int OPER_CATEGORY_MAIL = 1;
  public static final int OPER_CATEGORY_SETTING = 2;
  public static final int OPER_CATEGORY_UMA = 3;
  public static final int OPER_TYPE_ATTACH_FAVORITE = 5;
  public static final int OPER_TYPE_MOVE = 2;
  public static final int OPER_TYPE_PURGE_DEL = 3;
  public static final int OPER_TYPE_SETTING_AGGREAGTE_BY_SUBJECT = 28;
  public static final int OPER_TYPE_SETTING_AGGREGATE_AD = 11;
  public static final int OPER_TYPE_SETTING_AGGREGATE_SUBSCRIBE = 12;
  public static final int OPER_TYPE_SETTING_APPLICATION_SHOW_IN_HOME = 30;
  public static final int OPER_TYPE_SETTING_BADGE_INCREMENT = 31;
  public static final int OPER_TYPE_SETTING_ENABLE_NOTIFY_DETAIL = 32;
  public static final int OPER_TYPE_SETTING_ENABLE_REAL_TIME_CALL = 29;
  public static final int OPER_TYPE_SETTING_GESTURE_PWD = 21;
  public static final int OPER_TYPE_SETTING_LOAD_IMG_TYPE = 19;
  public static final int OPER_TYPE_SETTING_MAIL_LIST_AVATAR = 18;
  public static final int OPER_TYPE_SETTING_NEW_MAIL_PUSH = 10;
  public static final int OPER_TYPE_SETTING_NEW_MAIL_PUSH_RATE = 17;
  public static final int OPER_TYPE_SETTING_NEW_MAIL_PUSH_SOUND = 23;
  public static final int OPER_TYPE_SETTING_NEW_MAIL_PUSH_VIBERATE = 22;
  public static final int OPER_TYPE_SETTING_NEW_MAIL_PUSH_WAY = 16;
  public static final int OPER_TYPE_SETTING_NOTIFY_AD_MAIL = 13;
  public static final int OPER_TYPE_SETTING_NOTIFY_CALENDAR_REMINDER_MAIL = 26;
  public static final int OPER_TYPE_SETTING_ONLY_PUSH_MAILAPP = 14;
  public static final int OPER_TYPE_SETTING_PASSWORD = 9;
  public static final int OPER_TYPE_SETTING_PERSONALIZED_SIGNATURE = 24;
  public static final int OPER_TYPE_SETTING_PLP_BIND_ACCOUNT = 27;
  public static final int OPER_TYPE_SETTING_PROTOCOL_NOTIFY_ACCOUNT_MAIL = 15;
  public static final int OPER_TYPE_SETTING_PUSH_FOLDER = 8;
  public static final int OPER_TYPE_SETTING_PUSH_MODE = 7;
  public static final int OPER_TYPE_SETTING_PUSH_NIGHT_MODE = 6;
  public static final int OPER_TYPE_SETTING_SEND_MAIL_SOUND = 20;
  public static final int OPER_TYPE_SETTING_SYNC_MAIL_COUNT_OR_MAIL_TIME = 25;
  public static final int OPER_TYPE_STAR = 1;
  public static final int OPER_TYPE_TAG = 4;
  public static final int OPER_TYPE_UNREAD = 0;
  public static final int OPER_VAL_FOLDER_MOVE_DEL = 1;
  public static final int OPER_VAL_FOLDER_MOVE_REJECT = 0;
  public static final int OPER_VAL_FOLDER_MOVE_SPAM = 2;
  public static final int OPER_VAL_FOLDER_MOVE_UNREJECT = 3;
  private int accountId;
  private long[] attachIds;
  private int category;
  private int folderId;
  private int id;
  private String mailid;
  private String param;
  private String svrKey;
  private int type;
  
  public static long generateAccountSettingId(int paramInt1, int paramInt2)
  {
    return QMMath.hashLong(paramInt1 + "^" + paramInt2);
  }
  
  public static long generateGlobalSettingId(int paramInt)
  {
    return QMMath.hashLong(paramInt + "");
  }
  
  public static long generateMailOperId(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    return QMMath.hashLong(paramInt1 + "^" + paramInt2 + "^" + paramString + "^" + paramInt3);
  }
  
  public static long generateUMASettingId(int paramInt)
  {
    return QMMath.hashLong("umasetting^" + paramInt);
  }
  
  public static long generateUnitOperId(int paramInt1, int paramInt2, String paramString, long paramLong, int paramInt3)
  {
    return QMMath.hashLong(paramInt1 + "^" + paramInt2 + "^" + paramString + "^" + paramLong + "^" + paramInt3);
  }
  
  public static boolean isGlobalSetting(int paramInt)
  {
    if (paramInt == 7) {}
    while (paramInt == 6) {
      return true;
    }
    return false;
  }
  
  public int getAccountId()
  {
    return this.accountId;
  }
  
  public long[] getAttachIds()
  {
    return this.attachIds;
  }
  
  public int getCategory()
  {
    return this.category;
  }
  
  public int getFolderId()
  {
    return this.folderId;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getMailid()
  {
    return this.mailid;
  }
  
  public String getParam()
  {
    return this.param;
  }
  
  public String getSvrKey()
  {
    if (this.svrKey == null) {
      return "";
    }
    return this.svrKey;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public void setAccountId(int paramInt)
  {
    this.accountId = paramInt;
  }
  
  public void setAttachIds(long[] paramArrayOfLong)
  {
    this.attachIds = paramArrayOfLong;
  }
  
  public void setCategory(int paramInt)
  {
    this.category = paramInt;
  }
  
  public void setFolderId(int paramInt)
  {
    this.folderId = paramInt;
  }
  
  public void setMailid(String paramString)
  {
    this.mailid = paramString;
  }
  
  public void setParam(String paramString)
  {
    this.param = paramString;
  }
  
  public void setSvrKey(String paramString)
  {
    this.svrKey = paramString;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.QMOffLineOperation
 * JD-Core Version:    0.7.0.1
 */