package com.tencent.qqmail.folderlist.model;

import com.tencent.qqmail.utilities.QMMath;

public class FolderData
  implements Comparable<FolderData>
{
  private int accountId;
  private int folderId;
  private int id;
  private String name;
  private boolean persistence;
  private boolean processing;
  private int section;
  private int sequence;
  private boolean shouldShow;
  private int type;
  
  public static int generateId(int paramInt1, int paramInt2)
  {
    return QMMath.hashInt(paramInt1 + ":" + paramInt2);
  }
  
  public int compareTo(FolderData paramFolderData)
  {
    return getSequence() - paramFolderData.getSequence();
  }
  
  public int getAccountId()
  {
    return this.accountId;
  }
  
  public int getFolderId()
  {
    return this.folderId;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getSection()
  {
    return this.section;
  }
  
  public int getSequence()
  {
    return this.sequence;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public boolean isPersistence()
  {
    return this.persistence;
  }
  
  public boolean isProcessing()
  {
    return this.processing;
  }
  
  public boolean isShouldShow()
  {
    return this.shouldShow;
  }
  
  public void setAccountId(int paramInt)
  {
    this.accountId = paramInt;
  }
  
  public void setFolderId(int paramInt)
  {
    this.folderId = paramInt;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setPersistence(boolean paramBoolean)
  {
    this.persistence = paramBoolean;
  }
  
  public void setProcessing(boolean paramBoolean)
  {
    this.processing = paramBoolean;
  }
  
  public void setSection(int paramInt)
  {
    this.section = paramInt;
  }
  
  public void setSequence(int paramInt)
  {
    this.sequence = paramInt;
  }
  
  public void setShouldShow(boolean paramBoolean)
  {
    this.shouldShow = paramBoolean;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public String toString()
  {
    return "FolderData:{id=" + this.id + ",folderId=" + this.folderId + ",accountId=" + this.accountId + ",name=" + this.name + ",section=" + this.section + ",seqence=" + this.sequence + ",type=" + this.type + ",shouldShow=" + this.shouldShow + ",persistence=" + this.persistence + ",processing=" + this.processing + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.model.FolderData
 * JD-Core Version:    0.7.0.1
 */