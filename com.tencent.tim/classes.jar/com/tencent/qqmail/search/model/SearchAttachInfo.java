package com.tencent.qqmail.search.model;

public class SearchAttachInfo
{
  public static final int SEARCH_TYPE_ALL = 7;
  public static final int SEARCH_TYPE_DOCUMENT = 4;
  public static final int SEARCH_TYPE_IMAGE = 1;
  public static final int SEARCH_TYPE_MEDIA = 2;
  private long[] mAttachIds = new long[0];
  private String mKeyword = "";
  private int mSearchType = 7;
  
  public SearchAttachInfo(int paramInt)
  {
    this.mSearchType = paramInt;
  }
  
  public long[] getAttachIds()
  {
    return this.mAttachIds;
  }
  
  public String getKeyword()
  {
    return this.mKeyword;
  }
  
  public int getSearchType()
  {
    return this.mSearchType;
  }
  
  public void setAttachIds(long[] paramArrayOfLong)
  {
    this.mAttachIds = paramArrayOfLong;
  }
  
  public void setKeyword(String paramString)
  {
    this.mKeyword = paramString;
  }
  
  public void setSearchType(int paramInt)
  {
    this.mSearchType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.model.SearchAttachInfo
 * JD-Core Version:    0.7.0.1
 */