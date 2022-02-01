package com.tencent.ttpic.videoshelf.model.edit;

public class ShelfNode
{
  private int changeViewID;
  private int descID;
  private String mCoverUri;
  
  public int getChangeViewID()
  {
    return this.changeViewID;
  }
  
  public String getCoverUri()
  {
    return this.mCoverUri;
  }
  
  public int getDescID()
  {
    return this.descID;
  }
  
  public void setChangeViewID(int paramInt)
  {
    this.changeViewID = paramInt;
  }
  
  public void setCoverUri(String paramString)
  {
    this.mCoverUri = paramString;
  }
  
  public void setDescID(int paramInt)
  {
    this.descID = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.model.edit.ShelfNode
 * JD-Core Version:    0.7.0.1
 */