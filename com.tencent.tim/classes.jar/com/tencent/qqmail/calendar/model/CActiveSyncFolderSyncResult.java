package com.tencent.qqmail.calendar.model;

import java.util.LinkedList;

public final class CActiveSyncFolderSyncResult
{
  public LinkedList<CActiveSyncFolder> addList = new LinkedList();
  public String folderSynckey;
  public LinkedList<String> removeList = new LinkedList();
  public LinkedList<CActiveSyncFolder> updateList = new LinkedList();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.CActiveSyncFolderSyncResult
 * JD-Core Version:    0.7.0.1
 */