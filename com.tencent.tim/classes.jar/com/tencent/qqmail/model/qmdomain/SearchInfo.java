package com.tencent.qqmail.model.qmdomain;

public class SearchInfo
{
  public static final int SEARCH_AREA_ACCOUNT = 4;
  public static final int SEARCH_AREA_ALL = 2;
  public static final int SEARCH_AREA_FOLDER = 1;
  public static final int SEARCH_AREA_NONE = 0;
  public static final int SEARCH_AREA_SENDERANDRECEIVER = 16;
  public static final int SEARCH_AREA_TAG = 8;
  public static final int SEARCH_FLAG_DRAFT = -11;
  public static final int SEARCH_FLAG_INBOXS = -1;
  public static final int SEARCH_FLAG_NORMAL = 0;
  public static final int SEARCH_FLAG_SELF = -14;
  public static final int SEARCH_FLAG_SENT = -13;
  public static final int SEARCH_FLAG_STARRED = -2;
  public static final int SEARCH_FLAG_TRASH = -12;
  public static final int SEARCH_FLAG_UNREADED = -9;
  public static final int SEARCH_FLAG_VIP = -3;
  public static final int SEARCH_TYPE_ALL = 7;
  public static final int SEARCH_TYPE_HISTORYMAIL = 3;
  public static final int SEARCH_TYPE_RECEIVER = 2;
  public static final int SEARCH_TYPE_SENDER = 1;
  public static final int SEARCH_TYPE_SUBJECT = 4;
  protected int accountId;
  protected int area;
  protected int folderId;
  protected String[] folders;
  protected String keyword;
  protected int mailFlag;
  protected long[] mailIds;
  protected int page;
  protected int searchType;
  protected String[] tags;
  
  public SearchInfo(int paramInt)
  {
    initParam();
    this.searchType = paramInt;
  }
  
  private void initParam()
  {
    this.searchType = 7;
    this.mailFlag = 0;
    this.area = 0;
    this.keyword = "";
    this.page = 0;
    this.mailIds = new long[0];
  }
  
  public int getAccountId()
  {
    return this.accountId;
  }
  
  public int getArea()
  {
    return this.area;
  }
  
  public int getFlag()
  {
    return this.mailFlag;
  }
  
  public int getFolderId()
  {
    return this.folderId;
  }
  
  public String[] getFolderIds()
  {
    return this.folders;
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
  
  public long[] getMailIds()
  {
    return this.mailIds;
  }
  
  public int getPage()
  {
    return this.page;
  }
  
  public int getSearchType()
  {
    return this.searchType;
  }
  
  public String[] getTagIds()
  {
    return this.tags;
  }
  
  public void setAccountId(int paramInt)
  {
    this.accountId = paramInt;
  }
  
  public void setArea(int paramInt)
  {
    this.area = paramInt;
  }
  
  public void setFlag(int paramInt)
  {
    this.mailFlag = paramInt;
  }
  
  public void setFolderId(int paramInt)
  {
    this.folderId = paramInt;
  }
  
  public void setFolderIds(String[] paramArrayOfString)
  {
    this.folders = paramArrayOfString;
  }
  
  public void setKeyword(String paramString)
  {
    this.keyword = paramString;
  }
  
  public void setMailIds(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong != null) {
      this.mailIds = paramArrayOfLong;
    }
  }
  
  public void setPage(int paramInt)
  {
    this.page = paramInt;
  }
  
  public void setTagIds(String[] paramArrayOfString)
  {
    this.tags = paramArrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.SearchInfo
 * JD-Core Version:    0.7.0.1
 */