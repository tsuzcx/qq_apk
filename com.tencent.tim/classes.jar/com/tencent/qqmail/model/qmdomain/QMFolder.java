package com.tencent.qqmail.model.qmdomain;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.utilities.QMMath;

public class QMFolder
  implements Comparable<QMFolder>
{
  public static final int FOLDER_ID_ADDRESSBOOK = -22;
  public static final int FOLDER_ID_ADD_FOLDER = -100;
  public static final int FOLDER_ID_ALL = 0;
  public static final int FOLDER_ID_ALL_DRAFT = -11;
  public static final int FOLDER_ID_ALL_SELF = -14;
  public static final int FOLDER_ID_ALL_SENT = -13;
  public static final int FOLDER_ID_ALL_TRASH = -12;
  public static final int FOLDER_ID_APP = -20;
  public static final int FOLDER_ID_ATTACHFOLDER = -19;
  public static final int FOLDER_ID_BOTTLE = -16;
  public static final int FOLDER_ID_CALENDAR = -18;
  public static final int FOLDER_ID_CARD = -23;
  public static final int FOLDER_ID_CONTACT_MAIL = -21;
  public static final int FOLDER_ID_FTN = -5;
  public static final int FOLDER_ID_INBOXES = -1;
  public static final int FOLDER_ID_NOTE = -4;
  public static final int FOLDER_ID_QQMAIL_POP = -8;
  public static final int FOLDER_ID_QQMAIL_SYS = -6;
  public static final int FOLDER_ID_QQMAIL_UNREAD = -17;
  public static final int FOLDER_ID_QQMAIL_USER = -7;
  public static final int FOLDER_ID_SENDING = -10;
  public static final int FOLDER_ID_STARRED = -2;
  public static final int FOLDER_ID_UNREADED = -9;
  public static final int FOLDER_ID_VIP = -3;
  public static final int FOLDER_TYPE_AD = 120;
  public static final int FOLDER_TYPE_ALL_MAIL = 152;
  public static final int FOLDER_TYPE_CALENDAR = 9;
  public static final int FOLDER_TYPE_CONTACT_MAIL = 19;
  public static final int FOLDER_TYPE_DRAFT = 4;
  public static final int FOLDER_TYPE_FLAGGED = 151;
  public static final int FOLDER_TYPE_HYBIRD = 103;
  public static final int FOLDER_TYPE_IMPORTANT = 150;
  public static final int FOLDER_TYPE_INBOX = 1;
  public static final int FOLDER_TYPE_MYAPP = 140;
  public static final int FOLDER_TYPE_POPULARIZE = 130;
  public static final int FOLDER_TYPE_QQMAIL_APP = 7;
  public static final int FOLDER_TYPE_QQMAIL_GROUP = 8;
  public static final int FOLDER_TYPE_QQMAIL_POP = 13;
  public static final int FOLDER_TYPE_QQMAIL_STARRED = 16;
  public static final int FOLDER_TYPE_QQMAIL_SUB = 15;
  public static final int FOLDER_TYPE_QQMAIL_SYS = 11;
  public static final int FOLDER_TYPE_QQMAIL_TAG = 14;
  public static final int FOLDER_TYPE_QQMAIL_UNREAD = 18;
  public static final int FOLDER_TYPE_QQMAIL_USER = 12;
  public static final int FOLDER_TYPE_QQMAIL_VIP = 17;
  public static final int FOLDER_TYPE_SEARCH = 110;
  public static final int FOLDER_TYPE_SENDING = 102;
  public static final int FOLDER_TYPE_SENT = 3;
  public static final int FOLDER_TYPE_SPAM = 6;
  public static final int FOLDER_TYPE_TRASH = 5;
  public static final int FOLDER_TYPE_USER = 0;
  private int accountId = -1;
  private int cliConvUnreadCount = -1;
  private int cliUnreadCount = -1;
  private String colorId = "-1";
  private int folderId = -2147483648;
  private long fromTime = 0L;
  private int ftnExpUnread = -1;
  private boolean hasNewMail = false;
  private int id;
  private boolean isDisplay = true;
  private boolean isFtnExpUnreadUpdate = false;
  private boolean isNameReserved = false;
  private boolean isTop = false;
  private boolean isVirtual = false;
  private boolean locked = false;
  private String name = "";
  private boolean overdue = false;
  private int parentId = 0;
  private String parentName = "";
  private int personalCount = 0;
  private String popEmail = "";
  private String popId = "";
  private boolean push = false;
  private String remoteId = "";
  private int sequence = 0;
  private int svrCount = -1;
  private int svrUnreadCount = -1;
  private String syncKey = "";
  private String syncState = "";
  private int topPos;
  private int type = 0;
  private long utcSince = 0L;
  
  public static int generateId(int paramInt, String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(paramInt).append("_").append(paramString.toLowerCase());
    if (paramBoolean) {}
    for (paramString = "_";; paramString = "") {
      return QMMath.hashPositivetInt(paramString);
    }
  }
  
  public int compareTo(QMFolder paramQMFolder)
  {
    int i = 0;
    if (getId() == paramQMFolder.getId()) {}
    int j;
    do
    {
      do
      {
        return i;
      } while ((getAccountId() == paramQMFolder.getAccountId()) && (getType() == paramQMFolder.getType()) && (getName().equals(paramQMFolder.getName())));
      j = getSequence() - paramQMFolder.getSequence();
      i = j;
    } while (j != 0);
    return 1;
  }
  
  public int getAccountId()
  {
    return this.accountId;
  }
  
  public int getCliConvUnreadCount()
  {
    return this.cliConvUnreadCount;
  }
  
  public int getCliUnreadCount()
  {
    return this.cliUnreadCount;
  }
  
  public String getColorId()
  {
    return this.colorId;
  }
  
  public long getFromTime()
  {
    return this.fromTime;
  }
  
  public int getFtnExpUnread()
  {
    return this.ftnExpUnread;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getParentId()
  {
    return this.parentId;
  }
  
  public String getParentName()
  {
    return this.parentName;
  }
  
  public int getPersonalCount()
  {
    return this.personalCount;
  }
  
  public String getPopEmail()
  {
    return this.popEmail;
  }
  
  public String getPopId()
  {
    return this.popId;
  }
  
  public String getRemoteId()
  {
    return this.remoteId;
  }
  
  public int getSequence()
  {
    return this.sequence;
  }
  
  public long getSince()
  {
    return this.utcSince;
  }
  
  public int getSvrCount()
  {
    return this.svrCount;
  }
  
  public int getSvrUnreadCount()
  {
    return this.svrUnreadCount;
  }
  
  public String getSyncKey()
  {
    if (this.syncKey == null) {
      return "0";
    }
    return this.syncKey;
  }
  
  public String getSyncState()
  {
    if (this.syncState == null) {
      return "";
    }
    return this.syncState;
  }
  
  public int getTopPos()
  {
    return this.topPos;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public boolean hasNewMail()
  {
    return this.hasNewMail;
  }
  
  public int hashCode()
  {
    return getId();
  }
  
  public boolean isDisplay()
  {
    return this.isDisplay;
  }
  
  public boolean isFtnExpUnreadUpdate()
  {
    return this.isFtnExpUnreadUpdate;
  }
  
  public boolean isLocked()
  {
    return this.locked;
  }
  
  public boolean isNameReserved()
  {
    return this.isNameReserved;
  }
  
  public boolean isOverdue()
  {
    return this.overdue;
  }
  
  public boolean isPush()
  {
    return this.push;
  }
  
  public boolean isQQPopFolder()
  {
    return this.type == 13;
  }
  
  public boolean isTop()
  {
    return this.isTop;
  }
  
  public boolean isVirtual()
  {
    return this.isVirtual;
  }
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    boolean bool4 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = bool4;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject("inf");
        if (localJSONObject != null)
        {
          bool1 = bool4;
          String str2 = (String)localJSONObject.get("id");
          String str1 = str2;
          if (str2 == null)
          {
            bool1 = bool4;
            str1 = (String)localJSONObject.get("folderid");
          }
          bool2 = bool3;
          if (str1 != null)
          {
            bool2 = bool3;
            bool1 = bool4;
            if (!str1.equals(""))
            {
              bool2 = bool3;
              bool1 = bool4;
              if (!str1.equals(this.folderId + ""))
              {
                bool1 = bool4;
                setRemoteId(str1);
                bool2 = true;
              }
            }
          }
          bool1 = bool2;
          str1 = (String)localJSONObject.get("name");
          bool3 = bool2;
          if (str1 != null)
          {
            bool3 = bool2;
            bool1 = bool2;
            if (!str1.equals(""))
            {
              bool3 = bool2;
              bool1 = bool2;
              if (!str1.equals(this.name))
              {
                bool1 = bool2;
                setName(str1);
                bool3 = true;
              }
            }
          }
          bool1 = bool3;
          str1 = (String)localJSONObject.get("acctid");
          bool2 = bool3;
          if (str1 != null)
          {
            bool2 = bool3;
            bool1 = bool3;
            if (!str1.equals(""))
            {
              bool2 = bool3;
              bool1 = bool3;
              if (!str1.equals(this.popId))
              {
                bool1 = bool3;
                setPopId(str1);
                bool2 = true;
              }
            }
          }
          bool1 = bool2;
          str1 = (String)localJSONObject.get("acctemail");
          bool3 = bool2;
          if (str1 != null)
          {
            bool3 = bool2;
            bool1 = bool2;
            if (!str1.equals(""))
            {
              bool3 = bool2;
              bool1 = bool2;
              if (!str1.equals(this.popEmail))
              {
                bool1 = bool2;
                setPopEmail(str1);
                bool3 = true;
              }
            }
          }
          bool1 = bool3;
          str2 = (String)localJSONObject.get("color");
          str1 = str2;
          if (str2 == null)
          {
            bool1 = bool3;
            str1 = (String)localJSONObject.get("flagbg");
          }
          bool2 = bool3;
          if (str1 != null)
          {
            bool1 = bool3;
            bool2 = bool3;
            if (!str1.equals(""))
            {
              bool1 = bool3;
              bool2 = bool3;
              if (!str1.equals(this.colorId))
              {
                bool1 = bool3;
                setColorId(str1);
                bool1 = true;
                bool4 = bool1;
              }
            }
          }
        }
        int i;
        bool1 = bool2;
      }
      catch (Exception paramJSONObject)
      {
        try
        {
          paramJSONObject = paramJSONObject.getJSONObject("st");
          bool3 = bool1;
          if (paramJSONObject != null)
          {
            bool4 = bool1;
            if (paramJSONObject.get("fromtime") != null)
            {
              bool4 = bool1;
              setFromTime(paramJSONObject.getLong("fromtime").longValue());
            }
            bool2 = bool1;
            bool4 = bool1;
            if (paramJSONObject.get("cnt") != null)
            {
              bool4 = bool1;
              i = paramJSONObject.getIntValue("cnt");
              bool2 = bool1;
              bool4 = bool1;
              if (i != getSvrCount())
              {
                bool4 = bool1;
                if (getSvrCount() != -1)
                {
                  bool4 = bool1;
                  setOverdue(true);
                }
              }
            }
          }
        }
        catch (Exception paramJSONObject)
        {
          continue;
        }
        try
        {
          setSvrCount(i);
          bool2 = true;
          bool3 = bool2;
          bool4 = bool2;
          if (paramJSONObject.get("urCnt") != null)
          {
            bool4 = bool2;
            i = paramJSONObject.getIntValue("urCnt");
            bool3 = bool2;
            bool4 = bool2;
            if (i != getCliUnreadCount())
            {
              bool4 = bool2;
              if (getCliUnreadCount() != -1)
              {
                bool4 = bool2;
                setOverdue(true);
              }
              if (i > 0)
              {
                bool4 = bool2;
                if (i > getCliUnreadCount())
                {
                  bool4 = bool2;
                  setHasNewMail(true);
                }
              }
              setCliUnreadCount(i);
              setCliConvUnreadCount(i);
              setSvrUnreadCount(i);
              bool3 = true;
            }
          }
          return bool3;
        }
        catch (Exception paramJSONObject)
        {
          bool4 = true;
          continue;
        }
        paramJSONObject = paramJSONObject;
        bool4 = bool1;
        paramJSONObject.printStackTrace();
        return bool4;
      }
    }
  }
  
  public void setAccountId(int paramInt)
  {
    this.accountId = paramInt;
  }
  
  public void setCliConvUnreadCount(int paramInt)
  {
    this.cliConvUnreadCount = paramInt;
  }
  
  public void setCliUnreadCount(int paramInt)
  {
    this.cliUnreadCount = paramInt;
  }
  
  public void setColorId(String paramString)
  {
    this.colorId = paramString;
  }
  
  public void setDisplay(boolean paramBoolean)
  {
    this.isDisplay = paramBoolean;
  }
  
  public void setFromTime(long paramLong)
  {
    this.fromTime = paramLong;
  }
  
  public void setFtnExpUnread(int paramInt)
  {
    this.ftnExpUnread = paramInt;
  }
  
  public void setHasNewMail(boolean paramBoolean)
  {
    this.hasNewMail = paramBoolean;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setIsFtnExpUnreadUpdate(boolean paramBoolean)
  {
    this.isFtnExpUnreadUpdate = paramBoolean;
  }
  
  public void setLocked(boolean paramBoolean)
  {
    this.locked = paramBoolean;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setNameReserved(boolean paramBoolean)
  {
    this.isNameReserved = paramBoolean;
  }
  
  public void setOverdue(boolean paramBoolean)
  {
    this.overdue = paramBoolean;
  }
  
  public void setParentId(int paramInt)
  {
    this.parentId = paramInt;
  }
  
  public void setParentName(String paramString)
  {
    this.parentName = paramString;
  }
  
  public void setPersonalCount(int paramInt)
  {
    this.personalCount = paramInt;
  }
  
  public void setPopEmail(String paramString)
  {
    this.popEmail = paramString;
  }
  
  public void setPopId(String paramString)
  {
    this.popId = paramString;
  }
  
  public void setPush(boolean paramBoolean)
  {
    this.push = paramBoolean;
  }
  
  public void setRemoteId(String paramString)
  {
    this.remoteId = paramString;
  }
  
  public void setSequence(int paramInt)
  {
    this.sequence = paramInt;
  }
  
  public void setSince(long paramLong)
  {
    this.utcSince = paramLong;
  }
  
  public void setSvrCount(int paramInt)
  {
    this.svrCount = paramInt;
  }
  
  public void setSvrUnreadCount(int paramInt)
  {
    this.svrUnreadCount = paramInt;
  }
  
  public void setSyncKey(String paramString)
  {
    this.syncKey = paramString;
  }
  
  public void setSyncState(String paramString)
  {
    this.syncState = paramString;
  }
  
  public void setTop(boolean paramBoolean)
  {
    this.isTop = paramBoolean;
  }
  
  public void setTopPos(int paramInt)
  {
    this.topPos = paramInt;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void setVirtual(boolean paramBoolean)
  {
    this.isVirtual = paramBoolean;
  }
  
  public String toString()
  {
    return "[" + this.name + "/" + this.id + "/" + this.remoteId + "/" + this.push + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.QMFolder
 * JD-Core Version:    0.7.0.1
 */