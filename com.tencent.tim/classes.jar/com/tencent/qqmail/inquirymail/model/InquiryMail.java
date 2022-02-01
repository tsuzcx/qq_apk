package com.tencent.qqmail.inquirymail.model;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.qmdomain.QMDomain;
import com.tencent.qqmail.utilities.QMMath;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.HashMap;

public class InquiryMail
  extends QMDomain
{
  public static final int FOLDER_INBOX = 2;
  public static final int FOLDER_INTERCEPTION = 1;
  public static final int FOLDER_MESSAGE = 5;
  public static final int FOLDER_NULL = 0;
  public static final int FOLDER_PERSONAL = 4;
  public static final int FOLDER_PURGE_TRASH = 7;
  public static final int FOLDER_SENT = 8;
  public static final int FOLDER_SPAM = 3;
  public static final int FOLDER_SUBSCRIBE = 9;
  public static final int FOLDER_TRASH = 6;
  public static final int[] REASONS_CAN_ADD_WHITE_LIST = { 2, 3, 6 };
  public static final int[] REASONS_CAN_REMOVE_BLACK_LIST = { 10 };
  public static final int REASON_AUTO_FORWARD = 8;
  public static final int REASON_DELETED_BLACK_LIST = 12;
  public static final int REASON_DIGITAL_ACCOUNT_MAIL = 16;
  public static final int REASON_DOMAIN_BLACK_LIST = 11;
  public static final int REASON_DOMAIN_WHITE_LIST = 14;
  public static final int REASON_EMPTY_DOMAIN = 18;
  public static final int REASON_NOT_CHINESE_MAIL = 15;
  public static final int REASON_NOT_STORAGE = 19;
  public static final int REASON_NULL = 0;
  public static final int REASON_PERSONAL_FILTER = 7;
  public static final int REASON_SYSTEM_ERROR = 4;
  public static final int REASON_SYSTEM_INTERCEPTION = 2;
  public static final int REASON_SYSTEM_INTERCEPTION_RECOVERY = 6;
  public static final int REASON_SYSTEM_JUDGMENT = 3;
  public static final int REASON_SYSTEM_OVERTIME = 5;
  public static final int REASON_UNKNOWN = 1;
  public static final int REASON_USER_BLACK_LIST = 10;
  public static final int REASON_USER_SETTING = 9;
  public static final int REASON_USER_WHITE_LIST = 13;
  public static final int REASON_VIRUS_MAIL = 17;
  public static final int RESTORE_CAN_RETRIEVE = 1;
  public static final int RESTORE_NORMAL = 0;
  public static final int RESTORE_NOT_RETRIEVE = 3;
  public static final int RESTORE_RETRIEVED = 2;
  private static final HashMap<Integer, String> folderMap;
  private static final HashMap<Integer, String> reasonMap = new HashMap();
  private int accountId;
  private long edgeTime;
  private int folder;
  private int folderId;
  private long id;
  private String idx;
  private String mailId;
  private String msgId;
  private int page;
  private int reason;
  private int restore;
  private String senderAddress;
  private String senderName;
  private String subject;
  private long time;
  
  static
  {
    folderMap = new HashMap();
    QMApplicationContext localQMApplicationContext = QMApplicationContext.sharedInstance();
    reasonMap.put(Integer.valueOf(1), localQMApplicationContext.getString(2131695012));
    reasonMap.put(Integer.valueOf(2), localQMApplicationContext.getString(2131695008));
    reasonMap.put(Integer.valueOf(3), localQMApplicationContext.getString(2131695010));
    reasonMap.put(Integer.valueOf(4), localQMApplicationContext.getString(2131695007));
    reasonMap.put(Integer.valueOf(5), localQMApplicationContext.getString(2131695011));
    reasonMap.put(Integer.valueOf(6), localQMApplicationContext.getString(2131695009));
    reasonMap.put(Integer.valueOf(7), localQMApplicationContext.getString(2131695006));
    reasonMap.put(Integer.valueOf(8), localQMApplicationContext.getString(2131694997));
    reasonMap.put(Integer.valueOf(9), localQMApplicationContext.getString(2131695014));
    reasonMap.put(Integer.valueOf(10), localQMApplicationContext.getString(2131695013));
    reasonMap.put(Integer.valueOf(11), localQMApplicationContext.getString(2131695000));
    reasonMap.put(Integer.valueOf(12), localQMApplicationContext.getString(2131694998));
    reasonMap.put(Integer.valueOf(13), localQMApplicationContext.getString(2131695015));
    reasonMap.put(Integer.valueOf(14), localQMApplicationContext.getString(2131695001));
    reasonMap.put(Integer.valueOf(15), localQMApplicationContext.getString(2131695003));
    reasonMap.put(Integer.valueOf(16), localQMApplicationContext.getString(2131694999));
    reasonMap.put(Integer.valueOf(17), localQMApplicationContext.getString(2131695016));
    reasonMap.put(Integer.valueOf(18), localQMApplicationContext.getString(2131695002));
    reasonMap.put(Integer.valueOf(19), localQMApplicationContext.getString(2131695004));
    reasonMap.put(Integer.valueOf(0), localQMApplicationContext.getString(2131695005));
    folderMap.put(Integer.valueOf(1), localQMApplicationContext.getString(2131694983));
    folderMap.put(Integer.valueOf(2), localQMApplicationContext.getString(2131694982));
    folderMap.put(Integer.valueOf(3), localQMApplicationContext.getString(2131694989));
    folderMap.put(Integer.valueOf(4), localQMApplicationContext.getString(2131694986));
    folderMap.put(Integer.valueOf(5), localQMApplicationContext.getString(2131694984));
    folderMap.put(Integer.valueOf(6), localQMApplicationContext.getString(2131694991));
    folderMap.put(Integer.valueOf(7), localQMApplicationContext.getString(2131694987));
    folderMap.put(Integer.valueOf(8), localQMApplicationContext.getString(2131694988));
    folderMap.put(Integer.valueOf(9), localQMApplicationContext.getString(2131694990));
    folderMap.put(Integer.valueOf(0), localQMApplicationContext.getString(2131694985));
  }
  
  public static long generateId(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("^");
    localStringBuilder.append(paramString);
    return QMMath.hashLong(localStringBuilder.toString());
  }
  
  public boolean canAddToWhiteList()
  {
    boolean bool2 = false;
    int[] arrayOfInt = REASONS_CAN_ADD_WHITE_LIST;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        int k = arrayOfInt[i];
        if (getReason() == k) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean canReadMail()
  {
    return (getFolder() != 1) && (getFolder() != 7) && (getFolder() != 0) && (!StringExtention.isNullOrEmpty(getMailId()));
  }
  
  public boolean canRemoveBlackList()
  {
    boolean bool2 = false;
    int[] arrayOfInt = REASONS_CAN_REMOVE_BLACK_LIST;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        int k = arrayOfInt[i];
        if (getReason() == k) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean canRetrieveMail()
  {
    return getRestore() == 1;
  }
  
  public int getAccountId()
  {
    return this.accountId;
  }
  
  public long getEdgeTime()
  {
    return this.edgeTime;
  }
  
  public int getFolder()
  {
    return this.folder;
  }
  
  public int getFolderId()
  {
    return this.folderId;
  }
  
  public long getId()
  {
    return this.id;
  }
  
  public String getIdx()
  {
    return this.idx;
  }
  
  public String getMailId()
  {
    return this.mailId;
  }
  
  public String getMsgId()
  {
    return this.msgId;
  }
  
  public int getPage()
  {
    return this.page;
  }
  
  public int getReason()
  {
    return this.reason;
  }
  
  public int getRestore()
  {
    return this.restore;
  }
  
  public String getSenderAddress()
  {
    return this.senderAddress;
  }
  
  public String getSenderName()
  {
    return this.senderName;
  }
  
  public String getStatus()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if (getFolder() != 0)
    {
      if ((getReason() == 6) && (getRestore() == 2)) {
        localStringBuilder.append(QMApplicationContext.sharedInstance().getString(2131695025));
      }
    }
    else if (getReason() != 0)
    {
      if ((getReason() != 6) || (getRestore() != 2)) {
        break label136;
      }
      localStringBuilder.append("（" + QMApplicationContext.sharedInstance().getString(2131695026) + "）");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append((String)folderMap.get(Integer.valueOf(getFolder())));
      break;
      label136:
      localStringBuilder.append("（" + (String)reasonMap.get(Integer.valueOf(getReason())) + "）");
    }
  }
  
  public String getSubject()
  {
    return this.subject;
  }
  
  public long getTime()
  {
    return this.time;
  }
  
  public boolean isIntercept()
  {
    return getFolder() == 1;
  }
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramJSONObject == null) {}
    do
    {
      do
      {
        return bool1;
        String str = (String)paramJSONObject.get("time");
        bool1 = bool2;
        if (str != null)
        {
          long l = Long.parseLong(str);
          bool1 = bool2;
          if (getTime() != l)
          {
            setTime(l);
            bool1 = true;
          }
        }
        str = (String)paramJSONObject.get("sender_name");
        bool2 = bool1;
        if (str != null) {
          if ((getSenderName() != null) && (!getSenderName().equals("")))
          {
            bool2 = bool1;
            if (getSenderName() == str) {}
          }
          else
          {
            setSenderName(str);
            bool2 = true;
          }
        }
        str = (String)paramJSONObject.get("sender_addr");
        bool1 = bool2;
        if (str != null) {
          if ((getSenderAddress() != null) && (!getSenderAddress().equals("")))
          {
            bool1 = bool2;
            if (getSenderAddress() == str) {}
          }
          else
          {
            setSenderAddress(str);
            bool1 = true;
          }
        }
        str = (String)paramJSONObject.get("subject");
        bool2 = bool1;
        if (str != null) {
          if ((getSubject() != null) && (!getSubject().equals("")))
          {
            bool2 = bool1;
            if (getSubject() == str) {}
          }
          else
          {
            setSubject(str);
            bool2 = true;
          }
        }
        str = (String)paramJSONObject.get("restore");
        bool1 = bool2;
        int i;
        if (str != null)
        {
          i = Integer.parseInt(str);
          bool1 = bool2;
          if (getRestore() != i)
          {
            setRestore(i);
            bool1 = true;
          }
        }
        str = (String)paramJSONObject.get("msgid");
        bool2 = bool1;
        if (str != null) {
          if ((getMsgId() != null) && (!getMsgId().equals("")))
          {
            bool2 = bool1;
            if (getMsgId() == str) {}
          }
          else
          {
            setMsgId(str);
            bool2 = true;
          }
        }
        str = (String)paramJSONObject.get("folder");
        bool1 = bool2;
        if (str != null)
        {
          i = Integer.parseInt(str);
          bool1 = bool2;
          if (getFolder() != i)
          {
            setFolder(i);
            bool1 = true;
          }
        }
        str = (String)paramJSONObject.get("folderid");
        bool2 = bool1;
        if (str != null)
        {
          i = Integer.parseInt(str);
          bool2 = bool1;
          if (getFolderId() != i)
          {
            setFolderId(i);
            bool2 = true;
          }
        }
        str = (String)paramJSONObject.get("idx");
        bool1 = bool2;
        if (str != null) {
          if ((getIdx() != null) && (!getIdx().equals("")))
          {
            bool1 = bool2;
            if (getIdx() == str) {}
          }
          else
          {
            setIdx(str);
            bool1 = true;
          }
        }
        str = (String)paramJSONObject.get("reason");
        bool2 = bool1;
        if (str != null)
        {
          i = Integer.parseInt(str);
          bool2 = bool1;
          if (getReason() != i)
          {
            setReason(i);
            bool2 = true;
          }
        }
        paramJSONObject = (String)paramJSONObject.get("mailid");
        bool1 = bool2;
      } while (paramJSONObject == null);
      if ((getMailId() == null) || (getMailId().equals(""))) {
        break;
      }
      bool1 = bool2;
    } while (getMailId() == paramJSONObject);
    setMailId(paramJSONObject);
    return true;
  }
  
  public void setAccountId(int paramInt)
  {
    this.accountId = paramInt;
  }
  
  public void setEdgeTime(long paramLong)
  {
    this.edgeTime = paramLong;
  }
  
  public void setFolder(int paramInt)
  {
    this.folder = paramInt;
  }
  
  public void setFolderId(int paramInt)
  {
    this.folderId = paramInt;
  }
  
  public void setId(long paramLong)
  {
    this.id = paramLong;
  }
  
  public void setIdx(String paramString)
  {
    this.idx = paramString;
  }
  
  public void setMailId(String paramString)
  {
    this.mailId = paramString;
  }
  
  public void setMsgId(String paramString)
  {
    this.msgId = paramString;
  }
  
  public void setPage(int paramInt)
  {
    this.page = paramInt;
  }
  
  public void setReason(int paramInt)
  {
    this.reason = paramInt;
  }
  
  public void setRestore(int paramInt)
  {
    this.restore = paramInt;
  }
  
  public void setSenderAddress(String paramString)
  {
    this.senderAddress = paramString;
  }
  
  public void setSenderName(String paramString)
  {
    this.senderName = paramString;
  }
  
  public void setSubject(String paramString)
  {
    this.subject = paramString;
  }
  
  public void setTime(long paramLong)
  {
    this.time = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.model.InquiryMail
 * JD-Core Version:    0.7.0.1
 */