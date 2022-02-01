package com.tencent.qqmail.calendar.model;

import java.util.LinkedList;

public final class CActiveSyncSyncResult
{
  public LinkedList<CCalendar> addList = new LinkedList();
  public String collectionId;
  public LinkedList<String> deleteList = new LinkedList();
  public LinkedList<String> serverIdAddList = new LinkedList();
  public LinkedList<String> sofedeleteList = new LinkedList();
  public String syncKey = "0";
  public LinkedList<CCalendar> updateList = new LinkedList();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.CActiveSyncSyncResult
 * JD-Core Version:    0.7.0.1
 */