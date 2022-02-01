package com.tencent.qqmail.protocol.calendar;

import com.tencent.qqmail.calendar.model.CCalendar;
import com.tencent.qqmail.calendar.model.CalendarInfo;

public final class CalendarServiceRouter
{
  public static void addCalendarEvent(CalendarInfo paramCalendarInfo, CalendarCallback paramCalendarCallback)
  {
    if (paramCalendarInfo.accountType == 1) {
      CalendarActiveSyncService.addEvent(paramCalendarInfo, paramCalendarCallback);
    }
    while (paramCalendarInfo.accountType != 2) {
      return;
    }
    CaldavService.getInstance().addEvent(paramCalendarInfo, paramCalendarCallback);
  }
  
  public static void addCalendarFolder(CalendarInfo paramCalendarInfo, CalendarCallback paramCalendarCallback)
  {
    CalendarActiveSyncService.addCalendarFolder(paramCalendarInfo, paramCalendarCallback);
  }
  
  public static void deleteCalendar(CalendarInfo paramCalendarInfo, CalendarCallback paramCalendarCallback)
  {
    if (paramCalendarInfo.accountType == 1) {
      CalendarActiveSyncService.removeEvent(paramCalendarInfo, paramCalendarCallback);
    }
    while (paramCalendarInfo.accountType != 2) {
      return;
    }
    CaldavService.getInstance().removeEvent(paramCalendarInfo, paramCalendarCallback);
  }
  
  public static void deleteCalendarFolder(CalendarInfo paramCalendarInfo, CalendarCallback paramCalendarCallback)
  {
    CalendarActiveSyncService.deleteCalendarFolder(paramCalendarInfo, paramCalendarCallback);
  }
  
  public static void loadCalendarEventList(CalendarInfo paramCalendarInfo, CalendarCallback paramCalendarCallback)
  {
    if (paramCalendarInfo.accountType == 1) {
      CalendarActiveSyncService.loadCalendarEventList(paramCalendarInfo, paramCalendarCallback);
    }
    while (paramCalendarInfo.accountType != 2) {
      return;
    }
    CaldavService.getInstance().loadCalendarEventList(paramCalendarInfo, paramCalendarCallback);
  }
  
  public static void loadFolderList(CalendarInfo paramCalendarInfo, CalendarCallback paramCalendarCallback)
  {
    if (paramCalendarInfo.accountType == 1) {
      CalendarActiveSyncService.loadFolderList(paramCalendarInfo, paramCalendarCallback);
    }
    while (paramCalendarInfo.accountType != 2) {
      return;
    }
    CaldavService.getInstance().loadFolderList(paramCalendarInfo, paramCalendarCallback);
  }
  
  public static void loadMultiCalendarEvent(CalendarInfo paramCalendarInfo, CalendarCallback paramCalendarCallback)
  {
    CaldavService.getInstance().loadMultiCalendarEvent(paramCalendarInfo, paramCalendarCallback);
  }
  
  public static void login(CalendarInfo paramCalendarInfo, CalendarCallback paramCalendarCallback)
  {
    if (paramCalendarInfo.accountType == 1) {
      CalendarActiveSyncService.login(paramCalendarInfo, paramCalendarCallback);
    }
    while (paramCalendarInfo.accountType != 2) {
      return;
    }
    CaldavService.getInstance().login(paramCalendarInfo, paramCalendarCallback);
  }
  
  public static CCalendar parseICS(String paramString)
  {
    return ICalendarResolver.parseICS(paramString);
  }
  
  public static void responseCalendarEvent(CalendarInfo paramCalendarInfo, CalendarCallback paramCalendarCallback)
  {
    if (paramCalendarInfo.accountType == 1) {
      CalendarActiveSyncService.responseCalendarEvent(paramCalendarInfo, paramCalendarCallback);
    }
    while (paramCalendarInfo.accountType != 2) {
      return;
    }
    CaldavService.getInstance().responseCalendarEvent(paramCalendarInfo, paramCalendarCallback);
  }
  
  public static void updateCalendar(CalendarInfo paramCalendarInfo, CalendarCallback paramCalendarCallback)
  {
    if (paramCalendarInfo.accountType == 1) {
      CalendarActiveSyncService.updateEvent(paramCalendarInfo, paramCalendarCallback);
    }
    while (paramCalendarInfo.accountType != 2) {
      return;
    }
    CaldavService.getInstance().updateEvent(paramCalendarInfo, paramCalendarCallback);
  }
  
  public static void updateCalendarFolder(CalendarInfo paramCalendarInfo, CalendarCallback paramCalendarCallback)
  {
    CalendarActiveSyncService.updateCalendarFolder(paramCalendarInfo, paramCalendarCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.calendar.CalendarServiceRouter
 * JD-Core Version:    0.7.0.1
 */