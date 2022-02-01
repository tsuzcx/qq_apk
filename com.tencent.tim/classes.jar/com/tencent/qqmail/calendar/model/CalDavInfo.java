package com.tencent.qqmail.calendar.model;

import java.util.LinkedList;

public final class CalDavInfo
{
  public LinkedList<CCalendar> cCalendarLinkedList = new LinkedList();
  public CCalendar calendarEvent;
  public String calendarHomeSetPath;
  public String calendarPath;
  public int command;
  public String icloudAuthToken;
  public boolean isOauth = false;
  public boolean loadDetail = false;
  public String oauthToken;
  public long queryEndTime = -9223372036854775808L;
  public long queryStartTime = -9223372036854775808L;
  public String rootPath;
  public boolean sslSupport;
  public LinkedList<String> stringLinkedList = new LinkedList();
  public String syncToken;
  public String userPrincipalPath;
  public int windowSize = 50;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.CalDavInfo
 * JD-Core Version:    0.7.0.1
 */