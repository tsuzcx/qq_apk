package com.tencent.qqmail.calendar.model;

import java.util.LinkedList;

public final class CActiveSyncFolder
{
  public String displayName;
  public int folderType;
  public String parentId = "0";
  public boolean qmShare;
  public int qmShareCount = 0;
  public String qmShareSource;
  public String serverId;
  public LinkedList<QMShareItem> shareItemAddList = new LinkedList();
  public LinkedList<QMShareItem> shareItemDeleteList = new LinkedList();
  public LinkedList<QMShareItem> shareItemUpdateList = new LinkedList();
  public String syncKey = "0";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.CActiveSyncFolder
 * JD-Core Version:    0.7.0.1
 */