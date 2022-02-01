package com.tencent.qqmail.calendar.model;

import java.util.LinkedList;

public final class CalDavResult
{
  public LinkedList<CCalendar> addList = new LinkedList();
  public CCalendar calendarEvent;
  public String calendarHomeSetPath;
  public LinkedList<CalDavCalendar> calendarLists = new LinkedList();
  public int errorCode = -2147483648;
  public String icloudAuthToken;
  public LinkedList<String> removeList = new LinkedList();
  public String sync_token_;
  public LinkedList<CCalendar> updateList = new LinkedList();
  public String userPrincipalPath;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.CalDavResult
 * JD-Core Version:    0.7.0.1
 */