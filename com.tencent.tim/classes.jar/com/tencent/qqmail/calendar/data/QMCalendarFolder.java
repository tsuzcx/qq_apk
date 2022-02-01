package com.tencent.qqmail.calendar.data;

import com.tencent.qqmail.utilities.QMMath;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

public class QMCalendarFolder
  extends QMCalendarBase
{
  public static final int CAL_ACCESS_OWNER = 700;
  public static final String[] COLLECTION_ID_PUBLIC_CALENDAR = { "10001002#H#1024", "10001002#H#1025", "10001002#H#1026", "10001002#H#1027", "10001002#H#1042", "10001002#H#1043", "10001002#H#1044" };
  public static final String COLLECTION_ID_QQFRIEND_BIRTHDAY = "10001007";
  public static final int TYPE_CALENDAR_DEFAULT_FOLDER = 8;
  public static final int TYPE_CALENDAR_FOLDER = 13;
  private int accountId;
  private String accountName = "";
  private String accountType = "";
  private String cTag = "";
  private int category = 0;
  private String collectionId = "";
  private int color = -1;
  private long createTime;
  private ArrayList<QMCalendarEvent> currentCalDavEventListInfo;
  private int id;
  private boolean isEditable = true;
  private boolean isShow = true;
  private String name = "";
  private int offLineOptType = 0;
  private String ownerAccount = "";
  private String parentId = "";
  private String path = "";
  private ArrayList<QMCalendarShare> shareList;
  private String shareOwner = "";
  private String syncKey = "";
  private String syncToken = "";
  private int type;
  
  public static int generateId(QMCalendarFolder paramQMCalendarFolder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramQMCalendarFolder.getAccountId()).append("^").append(paramQMCalendarFolder.getCollectionId()).append("^").append(paramQMCalendarFolder.getPath()).append("^").append(paramQMCalendarFolder.getType());
    return QMMath.hashInt(localStringBuilder.toString());
  }
  
  public static int generateTmpId(QMCalendarFolder paramQMCalendarFolder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramQMCalendarFolder.getAccountId()).append("^").append(paramQMCalendarFolder.getCollectionId()).append("^").append(paramQMCalendarFolder.getPath()).append("^").append(paramQMCalendarFolder.getType()).append("^").append(System.currentTimeMillis());
    return QMMath.hashInt(localStringBuilder.toString());
  }
  
  public int getAccountId()
  {
    return this.accountId;
  }
  
  public String getAccountName()
  {
    return this.accountName;
  }
  
  public String getAccountType()
  {
    return this.accountType;
  }
  
  public int getCategory()
  {
    return this.category;
  }
  
  public String getCollectionId()
  {
    return this.collectionId;
  }
  
  public int getColor()
  {
    return this.color;
  }
  
  public long getCreateTime()
  {
    return this.createTime;
  }
  
  public ArrayList<QMCalendarEvent> getCurrentCalDavEventListInfo()
  {
    return this.currentCalDavEventListInfo;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getOffLineOptType()
  {
    return this.offLineOptType;
  }
  
  public String getOwnerAccount()
  {
    return this.ownerAccount;
  }
  
  public String getParentId()
  {
    if ((this.parentId == null) || (this.parentId.equals(""))) {
      this.parentId = "0";
    }
    return this.parentId;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public ArrayList<QMCalendarShare> getShareList()
  {
    return this.shareList;
  }
  
  public String getShareOwner()
  {
    return this.shareOwner;
  }
  
  public String getSyncKey()
  {
    if ((this.syncKey == null) || (this.syncKey.equals(""))) {
      this.syncKey = "0";
    }
    return this.syncKey;
  }
  
  public String getSyncToken()
  {
    return this.syncToken;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public String getcTag()
  {
    return this.cTag;
  }
  
  public boolean isActiveSyncCalendarFolder()
  {
    return getType() == 13;
  }
  
  public boolean isActiveSyncDefaultCalendarFolder()
  {
    return getType() == 8;
  }
  
  public boolean isEditable()
  {
    return this.isEditable;
  }
  
  public boolean isLocalFolder()
  {
    return getCategory() == 1;
  }
  
  public boolean isPublicFolder()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    String[] arrayOfString;
    int j;
    int i;
    if (!StringUtils.isBlank(this.collectionId))
    {
      arrayOfString = COLLECTION_ID_PUBLIC_CALENDAR;
      j = arrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        String str = arrayOfString[i];
        if (this.collectionId.equals(str)) {
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
  
  public boolean isQQBirthDayFolder()
  {
    return (!StringUtils.isBlank(this.collectionId)) && (this.collectionId.equals("10001007"));
  }
  
  public boolean isSelfFolder()
  {
    return (!isQQBirthDayFolder()) && (!isPublicFolder()) && (!isShareSystemFolder()) && (!isShareReceiverFolder());
  }
  
  public boolean isShareOwnerFolder()
  {
    return getCategory() == 2;
  }
  
  public boolean isShareReceiverFolder()
  {
    return getCategory() == 3;
  }
  
  public boolean isShareSystemFolder()
  {
    return (this.shareOwner != null) && (this.shareOwner.equals("10000@qq.com"));
  }
  
  public boolean isShow()
  {
    return this.isShow;
  }
  
  public void setAccountId(int paramInt)
  {
    this.accountId = paramInt;
  }
  
  public void setAccountName(String paramString)
  {
    this.accountName = paramString;
  }
  
  public void setAccountType(String paramString)
  {
    this.accountType = paramString;
  }
  
  public void setCategory(int paramInt)
  {
    this.category = paramInt;
  }
  
  public void setCollectionId(String paramString)
  {
    this.collectionId = paramString;
  }
  
  public void setColor(int paramInt)
  {
    this.color = paramInt;
  }
  
  public void setCreateTime(long paramLong)
  {
    this.createTime = paramLong;
  }
  
  public void setCurrentCalDavEventListInfo(ArrayList<QMCalendarEvent> paramArrayList)
  {
    this.currentCalDavEventListInfo = paramArrayList;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setIsEditable(boolean paramBoolean)
  {
    this.isEditable = paramBoolean;
  }
  
  public void setIsShow(boolean paramBoolean)
  {
    this.isShow = paramBoolean;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setOffLineOptType(int paramInt)
  {
    this.offLineOptType = paramInt;
  }
  
  public void setOwnerAccount(String paramString)
  {
    this.ownerAccount = paramString;
  }
  
  public void setParentId(String paramString)
  {
    this.parentId = paramString;
  }
  
  public void setPath(String paramString)
  {
    this.path = paramString;
  }
  
  public void setShareList(ArrayList<QMCalendarShare> paramArrayList)
  {
    this.shareList = paramArrayList;
  }
  
  public void setShareOwner(String paramString)
  {
    this.shareOwner = paramString;
  }
  
  public void setSyncKey(String paramString)
  {
    this.syncKey = paramString;
  }
  
  public void setSyncToken(String paramString)
  {
    this.syncToken = paramString;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void setcTag(String paramString)
  {
    this.cTag = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.data.QMCalendarFolder
 * JD-Core Version:    0.7.0.1
 */