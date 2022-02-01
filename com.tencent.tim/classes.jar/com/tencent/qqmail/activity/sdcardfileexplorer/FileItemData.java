package com.tencent.qqmail.activity.sdcardfileexplorer;

public class FileItemData
{
  public String canonicalPath;
  public boolean isFolder;
  public String itemModifyDateTime;
  public String itemName;
  public int resItemIcon;
  
  public FileItemData()
  {
    reset();
  }
  
  public void reset()
  {
    this.isFolder = false;
    this.resItemIcon = 0;
    this.itemName = null;
    this.itemModifyDateTime = null;
    this.canonicalPath = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.sdcardfileexplorer.FileItemData
 * JD-Core Version:    0.7.0.1
 */