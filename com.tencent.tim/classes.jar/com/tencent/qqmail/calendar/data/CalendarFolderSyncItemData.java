package com.tencent.qqmail.calendar.data;

import java.util.ArrayList;

public class CalendarFolderSyncItemData
{
  private ArrayList<QMCalendarShare> addShareList;
  private QMCalendarFolder folder;
  private ArrayList<QMCalendarShare> removeShareList;
  private ArrayList<QMCalendarShare> updateShareList;
  
  public ArrayList<QMCalendarShare> getAddShareList()
  {
    return this.addShareList;
  }
  
  public QMCalendarFolder getFolder()
  {
    return this.folder;
  }
  
  public ArrayList<QMCalendarShare> getRemoveShareList()
  {
    return this.removeShareList;
  }
  
  public ArrayList<QMCalendarShare> getUpdateShareList()
  {
    return this.updateShareList;
  }
  
  public void setAddShareList(ArrayList<QMCalendarShare> paramArrayList)
  {
    this.addShareList = paramArrayList;
  }
  
  public void setFolder(QMCalendarFolder paramQMCalendarFolder)
  {
    this.folder = paramQMCalendarFolder;
  }
  
  public void setRemoveShareList(ArrayList<QMCalendarShare> paramArrayList)
  {
    this.removeShareList = paramArrayList;
  }
  
  public void setUpdateShareList(ArrayList<QMCalendarShare> paramArrayList)
  {
    this.updateShareList = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.data.CalendarFolderSyncItemData
 * JD-Core Version:    0.7.0.1
 */