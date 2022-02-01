package com.tencent.qqmail.protocol.calendar;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.moai.mailsdk.protocol.activesync.DeviceInfoHandler;
import com.tencent.moai.mailsdk.protocol.activesync.model.DeviceInfo;
import com.tencent.qqmail.calendar.model.ActiveSyncInfo;
import com.tencent.qqmail.calendar.model.ActiveSyncMeetingResponseInfo;
import com.tencent.qqmail.calendar.model.ActiveSyncResult;
import com.tencent.qqmail.calendar.model.CActiveSyncFolder;
import com.tencent.qqmail.calendar.model.CActiveSyncFolderChangeInfo;
import com.tencent.qqmail.calendar.model.CActiveSyncFolderChangeResult;
import com.tencent.qqmail.calendar.model.CActiveSyncFolderSyncInfo;
import com.tencent.qqmail.calendar.model.CActiveSyncFolderSyncResult;
import com.tencent.qqmail.calendar.model.CActiveSyncMeetingResponseResult;
import com.tencent.qqmail.calendar.model.CActiveSyncSyncInfo;
import com.tencent.qqmail.calendar.model.CActiveSyncSyncResult;
import com.tencent.qqmail.calendar.model.CAttendee;
import com.tencent.qqmail.calendar.model.CCalendar;
import com.tencent.qqmail.calendar.model.CException;
import com.tencent.qqmail.calendar.model.CRecurrence;
import com.tencent.qqmail.calendar.model.CalendarInfo;
import com.tencent.qqmail.calendar.model.CalendarResult;
import com.tencent.qqmail.calendar.model.QMShareItem;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.protocol.aswbxml.ASWBXML;
import com.tencent.qqmail.utilities.ByteConvert;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMHttpUtil;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest.QMHttpMethod;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.apache.commons.lang3.StringEscapeUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CalendarActiveSyncService
{
  private static final String CMD_FOLDER_CREATE = "FolderCreate";
  private static final String CMD_FOLDER_DELETE = "FolderDelete";
  private static final String CMD_FOLDER_SYNC = "FolderSync";
  private static final String CMD_FOLDER_UPDATE = "FolderUpdate";
  private static final String CMD_MEETING_RESPONSE = "MeetingResponse";
  private static final String CMD_OPTIONS = "OPTIONS";
  private static final String CMD_PROVISION = "Provision";
  private static final String CMD_SYNC = "Sync";
  private static final int CMD_TYPE_ADD_CALENDAR = 3;
  private static final int CMD_TYPE_ADD_CALENDAR_FOLDER = 12;
  private static final int CMD_TYPE_DELETE_CALENDAR_FOLDER = 14;
  private static final int CMD_TYPE_INIT_FOLDER = 1;
  private static final int CMD_TYPE_LOAD_CALENDAR = 6;
  private static final int CMD_TYPE_LOAD_FOLDER = 2;
  private static final int CMD_TYPE_MEETING_RESPONSE = 11;
  private static final int CMD_TYPE_POLICYKEY = 9;
  private static final int CMD_TYPE_POLICYKEY_ACK = 10;
  private static final int CMD_TYPE_PROVISION = 7;
  private static final int CMD_TYPE_PROVISION_ACK = 8;
  private static final int CMD_TYPE_REMOVE_CALENDAR = 4;
  private static final int CMD_TYPE_UPDATE_CALENDAR = 5;
  private static final int CMD_TYPE_UPDATE_CALENDAR_FOLDER = 13;
  private static final int ERROR_CODE_EAGAIN = 2;
  private static final int ERROR_CODE_NEED_FOLDERSYNC = 9;
  private static final int ERROR_CODE_NEED_SYNC = 10;
  private static final int ERROR_CODE_OK = 0;
  private static final int ERROR_CODE_POLICY_KEY = 6;
  private static final int ERROR_CODE_POLICY_KEY_ACK = 7;
  private static final int ERROR_CODE_REDIRECT = 8;
  private static final int ERROR_CODE_REMOTE_WIPED = 3;
  private static final int ERROR_CODE_REMOTE_WIPED_ACK = 4;
  private static final int ERROR_CODE_SYNCKEY_ERROR = 5;
  private static final String TAG = "CalendarActiveSyncService";
  private static final String USER_AGENT = "QQMail/Android/" + AppConfig.getCodeVersion() + "/" + Build.VERSION.RELEASE;
  private static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";
  
  public static void addCalendarFolder(CalendarInfo paramCalendarInfo, CalendarCallback paramCalendarCallback)
  {
    QMLog.log(4, "CalendarActiveSyncService", "addCalendarFolder, email: " + paramCalendarInfo.email);
    byte[] arrayOfByte = buildAddCalendarFolder(paramCalendarInfo);
    sendRequest("[addCalendarFolder--" + paramCalendarInfo.email + "]", paramCalendarInfo, "FolderCreate", 12, arrayOfByte, null, paramCalendarCallback);
  }
  
  public static void addEvent(CalendarInfo paramCalendarInfo, CalendarCallback paramCalendarCallback)
  {
    QMLog.log(4, "CalendarActiveSyncService", "addCalendarEvent, email: " + paramCalendarInfo.email);
    byte[] arrayOfByte = buildAddEvent(paramCalendarInfo);
    sendRequest("[addCalendarEvent--" + paramCalendarInfo.email + "]", paramCalendarInfo, "Sync", 3, arrayOfByte, null, paramCalendarCallback);
  }
  
  private static byte[] buildAddCalendarFolder(CalendarInfo paramCalendarInfo)
  {
    if (paramCalendarInfo.activeSyncInfo.syncFolderChangeInfo == null) {
      paramCalendarInfo.activeSyncInfo.syncFolderChangeInfo = new CActiveSyncFolderChangeInfo();
    }
    if (paramCalendarInfo.activeSyncInfo.syncFolderChangeInfo.folder == null) {
      paramCalendarInfo.activeSyncInfo.syncFolderChangeInfo.folder = new CActiveSyncFolder();
    }
    if (paramCalendarInfo.activeSyncInfo.syncFolderChangeInfo.syncKey == null) {
      paramCalendarInfo.activeSyncInfo.syncFolderChangeInfo.syncKey = "";
    }
    Object localObject = paramCalendarInfo.activeSyncInfo.syncFolderChangeInfo;
    paramCalendarInfo = ((CActiveSyncFolderChangeInfo)localObject).folder;
    localObject = new StringBuilder("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n").append("<FolderCreate xmlns=\"FolderHierarchy\">").append("<SyncKey>").append(((CActiveSyncFolderChangeInfo)localObject).syncKey).append("</SyncKey>").append("<ParentId>").append(paramCalendarInfo.parentId).append("</ParentId>").append("<DisplayName>").append(escapeXml(paramCalendarInfo.displayName)).append("</DisplayName>").append("<Type>").append(paramCalendarInfo.folderType).append("</Type>");
    if (paramCalendarInfo.qmShare) {
      ((StringBuilder)localObject).append("<QMshare>1</QMshare>");
    }
    ((StringBuilder)localObject).append("</FolderCreate>");
    paramCalendarInfo = ((StringBuilder)localObject).toString();
    printXml("buildAddCalendarFolder", paramCalendarInfo);
    return xml2Bytes(paramCalendarInfo);
  }
  
  private static byte[] buildAddEvent(CalendarInfo paramCalendarInfo)
  {
    Object localObject = paramCalendarInfo.activeSyncInfo.syncInfo;
    localObject = new StringBuilder("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n").append("<Sync xmlns:calendar=\"Calendar\" xmlns:airsyncbase=\"AirSyncBase\" xmlns=\"AirSync\">").append("<Collections><Collection>").append("<SyncKey>").append(((CActiveSyncSyncInfo)localObject).syncKey).append("</SyncKey>").append("<CollectionId>").append(((CActiveSyncSyncInfo)localObject).collectionId).append("</CollectionId>").append("<GetChanges>0</GetChanges>").append("<WindowSize>").append(((CActiveSyncSyncInfo)localObject).windowSize).append("</WindowSize>").append("<Options>").append("<FilterType>").append(((CActiveSyncSyncInfo)localObject).filterType).append("</FilterType>").append("<MIMETruncation>8</MIMETruncation>").append("<MIMESupport>0</MIMESupport>").append("<airsyncbase:BodyPreference>").append("<airsyncbase:Type>1</airsyncbase:Type>").append("</airsyncbase:BodyPreference>").append("</Options>").append("<Commands><Add>").append("<ClientId>").append(System.currentTimeMillis() / 1000L).append("</ClientId>").append("<ApplicationData>");
    buildApplicationData(paramCalendarInfo, (StringBuilder)localObject);
    ((StringBuilder)localObject).append("</ApplicationData>").append("</Add></Commands>").append("</Collection></Collections></Sync>");
    paramCalendarInfo = ((StringBuilder)localObject).toString();
    printXml("buildAddEvent", paramCalendarInfo);
    return xml2Bytes(paramCalendarInfo);
  }
  
  private static void buildAirSyncBaseBody(String paramString, StringBuilder paramStringBuilder)
  {
    if (!TextUtils.isEmpty(paramString)) {
      paramStringBuilder.append("<airsyncbase:Body>").append("<airsyncbase:Type>1</airsyncbase:Type>").append("<airsyncbase:Data><![CDATA[").append(escapeXml(paramString)).append("]]></airsyncbase:Data>").append("</airsyncbase:Body>");
    }
  }
  
  private static void buildApplicationData(CalendarInfo paramCalendarInfo, StringBuilder paramStringBuilder)
  {
    CCalendar localCCalendar = paramCalendarInfo.activeSyncInfo.calendarEvent;
    Object localObject;
    if (!TextUtils.isEmpty(localCCalendar.time_zone_))
    {
      int j = Integer.parseInt(localCCalendar.time_zone_) / 60;
      localObject = new byte['¬'];
      i = 0;
      while (i < 172)
      {
        localObject[i] = 0;
        i += 1;
      }
      System.arraycopy(ByteConvert.intToBytesLE(j - 960), 0, localObject, 0, 4);
      System.arraycopy(ByteConvert.intToBytesLE(-60), 0, localObject, 168, 4);
      paramStringBuilder.append("<calendar:TimeZone>").append(StringExtention.base64Encode((byte[])localObject, localObject.length)).append("</calendar:TimeZone>");
    }
    if (!TextUtils.isEmpty(localCCalendar.uid)) {
      paramStringBuilder.append("<calendar:UID>").append(localCCalendar.uid).append("</calendar:UID>");
    }
    paramStringBuilder.append("<calendar:DtStamp>").append(getTimeInFormat(localCCalendar.dt_stamp)).append("</calendar:DtStamp>").append("<calendar:StartTime>").append(getTimeInFormat(localCCalendar.start_time)).append("</calendar:StartTime>").append("<calendar:EndTime>").append(getTimeInFormat(localCCalendar.end_time)).append("</calendar:EndTime>");
    if (!TextUtils.isEmpty(localCCalendar.organizer_name)) {
      paramStringBuilder.append("<calendar:OrganizerName>").append(escapeXml(localCCalendar.organizer_name)).append("</calendar:OrganizerName>");
    }
    if (!TextUtils.isEmpty(localCCalendar.organizer_email)) {
      paramStringBuilder.append("<calendar:OrganizerEmail>").append(escapeXml(localCCalendar.organizer_email)).append("</calendar:OrganizerEmail>");
    }
    label470:
    StringBuilder localStringBuilder;
    if (("14.0".equals(paramCalendarInfo.activeSyncInfo.getActiveSyncVersion())) || ("14.1".equals(paramCalendarInfo.activeSyncInfo.getActiveSyncVersion())))
    {
      paramCalendarInfo = paramStringBuilder.append("<calendar:ResponseRequested>");
      if (localCCalendar.response_requested)
      {
        i = 1;
        paramCalendarInfo.append(i).append("</calendar:ResponseRequested>");
      }
    }
    else
    {
      if (!TextUtils.isEmpty(localCCalendar.subject)) {
        paramStringBuilder.append("<calendar:Subject>").append(escapeXml(localCCalendar.subject)).append("</calendar:Subject>");
      }
      buildAttendees(localCCalendar.attendees, paramStringBuilder);
      if (localCCalendar.recurrence != null)
      {
        paramCalendarInfo = localCCalendar.recurrence;
        paramStringBuilder.append("<calendar:Recurrence>").append("<calendar:Type>").append(paramCalendarInfo.type).append("</calendar:Type>");
        if (paramCalendarInfo.occurrences <= 0L) {
          break label1297;
        }
        paramStringBuilder.append("<calendar:Occurrences>").append(paramCalendarInfo.occurrences).append("</calendar:Occurrences>");
        if (paramCalendarInfo.interval > 0L) {
          paramStringBuilder.append("<calendar:Interval>").append(paramCalendarInfo.interval).append("</calendar:Interval>");
        }
        i = paramCalendarInfo.type;
      }
      switch (i)
      {
      case 2: 
      case 4: 
      case 5: 
      default: 
        label548:
        if (i > 1) {
          paramStringBuilder.append("<calendar:CalendarType>").append(paramCalendarInfo.calendar_type).append("</calendar:CalendarType>");
        }
        if (((i == 2) || (i == 5)) && (paramCalendarInfo.day_of_month > 0L)) {
          paramStringBuilder.append("<calendar:DayOfMonth>").append(paramCalendarInfo.day_of_month).append("</calendar:DayOfMonth>");
        }
        if (((i == 3) || (i == 6)) && (paramCalendarInfo.week_of_month > 0L)) {
          paramStringBuilder.append("<calendar:WeekOfMonth>").append(paramCalendarInfo.week_of_month).append("</calendar:WeekOfMonth>");
        }
        if (((i == 5) || (i == 6)) && (paramCalendarInfo.month_of_year > 0L)) {
          paramStringBuilder.append("<calendar:MonthOfYear>").append(paramCalendarInfo.month_of_year).append("</calendar:MonthOfYear>");
        }
        paramStringBuilder.append("</calendar:Recurrence>");
        if (!TextUtils.isEmpty(localCCalendar.location)) {
          paramStringBuilder.append("<calendar:Location>").append(escapeXml(localCCalendar.location)).append("</calendar:Location>");
        }
        buildCategories(localCCalendar.categories, paramStringBuilder);
        buildAirSyncBaseBody(localCCalendar.body, paramStringBuilder);
        paramCalendarInfo = paramStringBuilder.append("<calendar:MeetingStatus>").append(localCCalendar.meeting_status).append("</calendar:MeetingStatus>").append("<calendar:Sensitivity>").append(localCCalendar.sensitivity).append("</calendar:Sensitivity>").append("<calendar:BusyStatus>").append(localCCalendar.busy_status).append("</calendar:BusyStatus>").append("<calendar:AllDayEvent>");
        if (localCCalendar.allday_event)
        {
          i = 1;
          label836:
          paramCalendarInfo.append(i).append("</calendar:AllDayEvent>");
          if (localCCalendar.reminder != -1L) {
            paramStringBuilder.append("<calendar:Reminder>").append(localCCalendar.reminder).append("</calendar:Reminder>");
          }
          paramCalendarInfo = localCCalendar.exceptions;
          if ((paramCalendarInfo == null) || (paramCalendarInfo.size() <= 0)) {
            break label1384;
          }
          paramStringBuilder.append("<calendar:Exceptions>");
          paramCalendarInfo = paramCalendarInfo.iterator();
          label912:
          if (!paramCalendarInfo.hasNext()) {
            break label1376;
          }
          localObject = (CException)paramCalendarInfo.next();
          paramStringBuilder.append("<calendar:Exception>").append("<calendar:Deleted>").append(((CException)localObject).deleted).append("</calendar:Deleted>").append("<calendar:ExceptionStartTime>").append(getTimeInFormat(((CException)localObject).exception_start_time)).append("</calendar:ExceptionStartTime>");
          if (!((CException)localObject).deleted)
          {
            if (!TextUtils.isEmpty(((CException)localObject).subject)) {
              paramStringBuilder.append("<calendar:Subject>").append(escapeXml(((CException)localObject).subject)).append("</calendar:Subject>");
            }
            paramStringBuilder.append("<calendar:StartTime>").append(getTimeInFormat(((CException)localObject).start_time)).append("</calendar:StartTime>").append("<calendar:EndTime>").append(getTimeInFormat(((CException)localObject).end_time)).append("</calendar:EndTime>");
            buildAirSyncBaseBody(((CException)localObject).body, paramStringBuilder);
            if (!TextUtils.isEmpty(((CException)localObject).location)) {
              paramStringBuilder.append("<calendar:Location>").append(escapeXml(((CException)localObject).location)).append("</calendar:Location>");
            }
            buildCategories(((CException)localObject).categories, paramStringBuilder);
            paramStringBuilder.append("<calendar:Sensitivity>").append(((CException)localObject).sensitivity).append("</calendar:Sensitivity>");
            paramStringBuilder.append("<calendar:BusyStatus>").append(((CException)localObject).busyStatus).append("</calendar:BusyStatus>");
            localStringBuilder = paramStringBuilder.append("<calendar:AllDayEvent>");
            if (!((CException)localObject).allday_event) {
              break label1371;
            }
          }
        }
        break;
      }
    }
    label1297:
    label1371:
    for (int i = 1;; i = 0)
    {
      localStringBuilder.append(i).append("</calendar:AllDayEvent>");
      if (((CException)localObject).reminder != -1) {
        paramStringBuilder.append("<calendar:Reminder>").append(((CException)localObject).reminder).append("</calendar:Reminder>");
      }
      paramStringBuilder.append("<calendar:DtStamp>").append(getTimeInFormat(((CException)localObject).dt_stamp)).append("</calendar:DtStamp>").append("<calendar:MeetingStatus>").append(((CException)localObject).meeting_status).append("</calendar:MeetingStatus>");
      paramStringBuilder.append("</calendar:Exception>");
      break label912;
      i = 0;
      break;
      if (paramCalendarInfo.until <= 0L) {
        break label470;
      }
      paramStringBuilder.append("<calendar:Until>").append(getTimeInFormat(paramCalendarInfo.until)).append("</calendar:Until>");
      break label470;
      if (paramCalendarInfo.day_of_week <= 0L) {
        break label548;
      }
      paramStringBuilder.append("<calendar:DayOfWeek>").append(paramCalendarInfo.day_of_week).append("</calendar:DayOfWeek>");
      break label548;
      i = 0;
      break label836;
    }
    label1376:
    paramStringBuilder.append("</calendar:Exceptions>");
    label1384:
    if (!TextUtils.isEmpty(localCCalendar.relative_id)) {
      paramStringBuilder.append("<QQRelativeId>").append(localCCalendar.relative_id).append("</QQRelativeId>");
    }
    if (localCCalendar.calendar_type > 0) {
      paramStringBuilder.append("<QQCalendarType>").append(localCCalendar.calendar_type).append("</QQCalendarType>");
    }
  }
  
  private static void buildAttendees(LinkedList<CAttendee> paramLinkedList, StringBuilder paramStringBuilder)
  {
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
    {
      paramStringBuilder.append("<calendar:Attendees>");
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        CAttendee localCAttendee = (CAttendee)paramLinkedList.next();
        paramStringBuilder.append("<calendar:Attendee>").append("<calendar:Email>").append(escapeXml(localCAttendee.email)).append("</calendar:Email>").append("<calendar:Name>").append(escapeXml(localCAttendee.name)).append("</calendar:Name>").append("<calendar:AttendeeStatus>").append(localCAttendee.status).append("</calendar:AttendeeStatus>").append("<calendar:AttendeeType>").append(localCAttendee.type).append("</calendar:AttendeeType>").append("</calendar:Attendee>");
      }
      paramStringBuilder.append("</calendar:Attendees>");
    }
  }
  
  private static void buildCategories(LinkedList<String> paramLinkedList, StringBuilder paramStringBuilder)
  {
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
    {
      paramStringBuilder.append("<calendar:Categories>");
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        String str = (String)paramLinkedList.next();
        paramStringBuilder.append("<calendar:Category>").append(escapeXml(str)).append("</calendar:Category>");
      }
      paramStringBuilder.append("</calendar:Categories>");
    }
  }
  
  private static byte[] buildDeleteCalendarFolder(CalendarInfo paramCalendarInfo)
  {
    if (paramCalendarInfo.activeSyncInfo.syncFolderChangeInfo == null) {
      paramCalendarInfo.activeSyncInfo.syncFolderChangeInfo = new CActiveSyncFolderChangeInfo();
    }
    if (paramCalendarInfo.activeSyncInfo.syncFolderChangeInfo.folder == null) {
      paramCalendarInfo.activeSyncInfo.syncFolderChangeInfo.folder = new CActiveSyncFolder();
    }
    if (paramCalendarInfo.activeSyncInfo.syncFolderChangeInfo.syncKey == null) {
      paramCalendarInfo.activeSyncInfo.syncFolderChangeInfo.syncKey = "";
    }
    paramCalendarInfo = paramCalendarInfo.activeSyncInfo.syncFolderChangeInfo;
    CActiveSyncFolder localCActiveSyncFolder = paramCalendarInfo.folder;
    paramCalendarInfo = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + "<FolderDelete xmlns=\"FolderHierarchy\">" + "<SyncKey>" + paramCalendarInfo.syncKey + "</SyncKey>" + "<ServerId>" + localCActiveSyncFolder.serverId + "</ServerId>" + "</FolderDelete>";
    printXml("buildDeleteCalendarFolder", paramCalendarInfo);
    return xml2Bytes(paramCalendarInfo);
  }
  
  private static byte[] buildInitFolder(CalendarInfo paramCalendarInfo)
  {
    paramCalendarInfo = paramCalendarInfo.activeSyncInfo.syncInfo;
    paramCalendarInfo = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + "<Sync xmlns:calendar=\"Calendar\" xmlns:airsyncbase=\"AirSyncBase\" xmlns=\"AirSync\">" + "<Collections><Collection>" + "<SyncKey>0</SyncKey>" + "<CollectionId>" + paramCalendarInfo.collectionId + "</CollectionId>" + "<DeletesAsMoves>1</DeletesAsMoves>" + "<WindowSize>" + paramCalendarInfo.windowSize + "</WindowSize>" + "<Options>" + "<FilterType>" + paramCalendarInfo.filterType + "</FilterType>" + "<MIMETruncation>0</MIMETruncation>" + "<MIMESupport>0</MIMESupport>" + "<airsyncbase:BodyPreference>" + "<airsyncbase:Type>1</airsyncbase:Type>" + "</airsyncbase:BodyPreference>" + "</Options>" + "</Collection></Collections>" + "</Sync>";
    printXml("buildInitFolder", paramCalendarInfo);
    return xml2Bytes(paramCalendarInfo);
  }
  
  private static byte[] buildLoadCalendarEventList(CalendarInfo paramCalendarInfo)
  {
    paramCalendarInfo = paramCalendarInfo.activeSyncInfo.syncInfo;
    paramCalendarInfo = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + "<Sync xmlns=\"AirSync\" xmlns:airsyncbase=\"AirSyncBase\">" + "<Collections><Collection>" + "<SyncKey>" + paramCalendarInfo.syncKey + "</SyncKey>" + "<CollectionId>" + paramCalendarInfo.collectionId + "</CollectionId>" + "<DeletesAsMoves>1</DeletesAsMoves>" + "<GetChanges/>" + "<WindowSize>" + paramCalendarInfo.windowSize + "</WindowSize>" + "<Options>" + "<FilterType>" + paramCalendarInfo.filterType + "</FilterType>" + "<MIMETruncation>8</MIMETruncation>" + "<MIMESupport>0</MIMESupport>" + "<airsyncbase:BodyPreference>" + "<airsyncbase:Type>1</airsyncbase:Type>" + "</airsyncbase:BodyPreference>" + "</Options>" + "</Collection></Collections>" + "</Sync>";
    printXml("buildLoadCalendarEventList", paramCalendarInfo);
    return xml2Bytes(paramCalendarInfo);
  }
  
  private static byte[] buildLoadFolderList(CalendarInfo paramCalendarInfo)
  {
    if (paramCalendarInfo.activeSyncInfo.folderSyncInfo == null) {
      paramCalendarInfo.activeSyncInfo.folderSyncInfo = new CActiveSyncFolderSyncInfo();
    }
    paramCalendarInfo = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + "<FolderSync xmlns=\"FolderHierarchy\"><SyncKey>" + paramCalendarInfo.activeSyncInfo.folderSyncInfo.syncKey + "</SyncKey></FolderSync>";
    printXml("buildLoadFolderList", paramCalendarInfo);
    return xml2Bytes(paramCalendarInfo);
  }
  
  private static byte[] buildMeetingResponse(CalendarInfo paramCalendarInfo)
  {
    paramCalendarInfo = paramCalendarInfo.activeSyncInfo.meetingResponseInfo;
    paramCalendarInfo = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + "<MeetingResponse xmlns=\"MeetingResponse\"><Request>" + "<UserResponse>" + paramCalendarInfo.userResponse + "</UserResponse>" + "<CollectionId>" + paramCalendarInfo.collectionId + "</CollectionId>" + "<RequestId>" + paramCalendarInfo.requestId + "</RequestId>" + "</Request></MeetingResponse>";
    printXml("buildMeetingResponse", paramCalendarInfo);
    return xml2Bytes(paramCalendarInfo);
  }
  
  private static byte[] buildPolicyKey(CalendarInfo paramCalendarInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
    DeviceInfo localDeviceInfo = DeviceInfoHandler.getInstance().getDeviceInfo();
    localStringBuilder.append("<Provision xmlns=\"Provision\" xmlns:settings=\"Settings\">");
    if (("14.1".equals(paramCalendarInfo.activeSyncInfo.getActiveSyncVersion())) && (localDeviceInfo != null))
    {
      localStringBuilder.append("<settings:DeviceInformation><settings:Set>");
      if (!TextUtils.isEmpty(localDeviceInfo.getModel())) {
        localStringBuilder.append("<settings:Model>").append(localDeviceInfo.getModel()).append("</settings:Model>");
      }
      if (!TextUtils.isEmpty(localDeviceInfo.getImie())) {
        localStringBuilder.append("<settings:IMEI>").append(localDeviceInfo.getImie()).append("</settings:IMEI>");
      }
      if (!TextUtils.isEmpty(localDeviceInfo.getDeviceBrand())) {
        localStringBuilder.append("<settings:FriendlyName>").append(localDeviceInfo.getDeviceBrand()).append("</settings:FriendlyName>");
      }
      if (!TextUtils.isEmpty(localDeviceInfo.getOs())) {
        localStringBuilder.append("<settings:OS>").append(localDeviceInfo.getOs()).append("</settings:OS>");
      }
      if (!TextUtils.isEmpty(localDeviceInfo.getOsLang())) {
        localStringBuilder.append("<settings:OSLanguage>").append(localDeviceInfo.getOsLang()).append("</settings:OSLanguage>");
      }
      if (!TextUtils.isEmpty(localDeviceInfo.getPhoneNumber())) {
        localStringBuilder.append("<settings:PhoneNumber>").append(localDeviceInfo.getPhoneNumber()).append("</settings:PhoneNumber>");
      }
      if (!TextUtils.isEmpty(localDeviceInfo.getMobileOperator())) {
        localStringBuilder.append("<settings:MobileOperator>").append(localDeviceInfo.getMobileOperator()).append("</settings:MobileOperator>");
      }
      if (!TextUtils.isEmpty(localDeviceInfo.getUserAgent())) {
        localStringBuilder.append("<settings:UserAgent>").append(localDeviceInfo.getUserAgent()).append("</settings:UserAgent>");
      }
      localStringBuilder.append("</settings:Set></settings:DeviceInformation>");
    }
    localStringBuilder.append("<Policies><Policy><PolicyType>MS-EAS-Provisioning-WBXML</PolicyType></Policy></Policies>");
    localStringBuilder.append("</Provision>");
    paramCalendarInfo = localStringBuilder.toString();
    printXml("buildPolicyKey", paramCalendarInfo);
    return xml2Bytes(paramCalendarInfo);
  }
  
  private static byte[] buildPolicyKeyAck(CalendarInfo paramCalendarInfo)
  {
    paramCalendarInfo = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + "<Provision xmlns=\"Provision\"><Policies><Policy><PolicyType>MS-EAS-Provisioning-WBXML</PolicyType>" + "<PolicyKey>" + paramCalendarInfo.activeSyncInfo.getActiveSyncPolicyKey() + "</PolicyKey><Status>1</Status>" + "</Policy></Policies></Provision>";
    printXml("buildPolicyKeyAck", paramCalendarInfo);
    return xml2Bytes(paramCalendarInfo);
  }
  
  private static byte[] buildRemoveEvent(CalendarInfo paramCalendarInfo)
  {
    CActiveSyncSyncInfo localCActiveSyncSyncInfo = paramCalendarInfo.activeSyncInfo.syncInfo;
    paramCalendarInfo = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + "<Sync xmlns:calendar=\"Calendar\" xmlns:airsyncbase=\"AirSyncBase\" xmlns=\"AirSync\" xmlns:search=\"Search\">" + "<Collections><Collection>" + "<SyncKey>" + localCActiveSyncSyncInfo.syncKey + "</SyncKey>" + "<CollectionId>" + localCActiveSyncSyncInfo.collectionId + "</CollectionId>" + "<GetChanges>0</GetChanges>" + "<WindowSize>" + localCActiveSyncSyncInfo.windowSize + "</WindowSize>" + "<Options>" + "<FilterType>" + localCActiveSyncSyncInfo.filterType + "</FilterType>" + "<MIMETruncation>8</MIMETruncation>" + "<MIMESupport>0</MIMESupport>" + "<airsyncbase:BodyPreference>" + "<airsyncbase:Type>1</airsyncbase:Type>" + "</airsyncbase:BodyPreference>" + "</Options>" + "<Commands><Delete>" + "<ServerId>" + paramCalendarInfo.activeSyncInfo.calendarEvent.server_id + "</ServerId>" + "</Delete></Commands>" + "</Collection></Collections></Sync>";
    printXml("buildRemoveEvent", paramCalendarInfo);
    return xml2Bytes(paramCalendarInfo);
  }
  
  private static byte[] buildUpdateCalendarFolder(CalendarInfo paramCalendarInfo)
  {
    if (paramCalendarInfo.activeSyncInfo.syncFolderChangeInfo == null) {
      paramCalendarInfo.activeSyncInfo.syncFolderChangeInfo = new CActiveSyncFolderChangeInfo();
    }
    if (paramCalendarInfo.activeSyncInfo.syncFolderChangeInfo.folder == null) {
      paramCalendarInfo.activeSyncInfo.syncFolderChangeInfo.folder = new CActiveSyncFolder();
    }
    if (paramCalendarInfo.activeSyncInfo.syncFolderChangeInfo.syncKey == null) {
      paramCalendarInfo.activeSyncInfo.syncFolderChangeInfo.syncKey = "";
    }
    paramCalendarInfo = paramCalendarInfo.activeSyncInfo.syncFolderChangeInfo;
    Object localObject1 = paramCalendarInfo.folder;
    paramCalendarInfo = new StringBuilder("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n").append("<FolderUpdate xmlns=\"FolderHierarchy\">").append("<SyncKey>").append(paramCalendarInfo.syncKey).append("</SyncKey>").append("<ServerId>").append(((CActiveSyncFolder)localObject1).serverId).append("</ServerId>").append("<ParentId>").append(((CActiveSyncFolder)localObject1).parentId).append("</ParentId>").append("<DisplayName>").append(escapeXml(((CActiveSyncFolder)localObject1).displayName)).append("</DisplayName>");
    if (((CActiveSyncFolder)localObject1).qmShare)
    {
      paramCalendarInfo.append("<QMshare>1</QMshare>");
      Object localObject2;
      QMShareItem localQMShareItem;
      if (((CActiveSyncFolder)localObject1).shareItemAddList.size() > 0)
      {
        localObject2 = ((CActiveSyncFolder)localObject1).shareItemAddList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localQMShareItem = (QMShareItem)((Iterator)localObject2).next();
          paramCalendarInfo.append("<QMshareItemAdd>").append("<QMshareFrom>").append(escapeXml(localQMShareItem.qmShareFrom)).append("</QMshareFrom>").append("<QMshareName>").append(escapeXml(localQMShareItem.qmShareName)).append("</QMshareName>").append("<QMshareState>").append(localQMShareItem.qmShareState).append("</QMshareState>").append("</QMshareItemAdd>");
        }
      }
      if (((CActiveSyncFolder)localObject1).shareItemUpdateList.size() > 0)
      {
        localObject2 = ((CActiveSyncFolder)localObject1).shareItemUpdateList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localQMShareItem = (QMShareItem)((Iterator)localObject2).next();
          paramCalendarInfo.append("<QMshareItemUpdate>").append("<QMshareFrom>").append(escapeXml(localQMShareItem.qmShareFrom)).append("</QMshareFrom>").append("<QMshareState>").append(localQMShareItem.qmShareState).append("</QMshareState>").append("</QMshareItemUpdate>");
        }
      }
      if (((CActiveSyncFolder)localObject1).shareItemDeleteList.size() > 0)
      {
        localObject1 = ((CActiveSyncFolder)localObject1).shareItemDeleteList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (QMShareItem)((Iterator)localObject1).next();
          paramCalendarInfo.append("<QMshareItemDel>").append("<QMshareFrom>").append(escapeXml(((QMShareItem)localObject2).qmShareFrom)).append("</QMshareFrom>").append("</QMshareItemDel>");
        }
      }
    }
    paramCalendarInfo.append("</FolderUpdate>");
    paramCalendarInfo = paramCalendarInfo.toString();
    printXml("buildUpdateCalendarFolder", paramCalendarInfo);
    return xml2Bytes(paramCalendarInfo);
  }
  
  private static byte[] buildUpdateEvent(CalendarInfo paramCalendarInfo)
  {
    Object localObject = paramCalendarInfo.activeSyncInfo.syncInfo;
    localObject = new StringBuilder("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n").append("<Sync xmlns:calendar=\"Calendar\" xmlns:airsyncbase=\"AirSyncBase\" xmlns=\"AirSync\">").append("<Collections><Collection>").append("<SyncKey>").append(((CActiveSyncSyncInfo)localObject).syncKey).append("</SyncKey>").append("<CollectionId>").append(((CActiveSyncSyncInfo)localObject).collectionId).append("</CollectionId>").append("<GetChanges>0</GetChanges>").append("<WindowSize>").append(((CActiveSyncSyncInfo)localObject).windowSize).append("</WindowSize>").append("<Options>").append("<FilterType>").append(((CActiveSyncSyncInfo)localObject).filterType).append("</FilterType>").append("<MIMETruncation>8</MIMETruncation>").append("<MIMESupport>0</MIMESupport>").append("<airsyncbase:BodyPreference>").append("<airsyncbase:Type>1</airsyncbase:Type>").append("</airsyncbase:BodyPreference>").append("<Conflict>0</Conflict>").append("</Options>").append("<Commands><Change>").append("<ServerId>").append(paramCalendarInfo.activeSyncInfo.calendarEvent.server_id).append("</ServerId>").append("<ApplicationData>");
    buildApplicationData(paramCalendarInfo, (StringBuilder)localObject);
    ((StringBuilder)localObject).append("</ApplicationData>").append("</Change></Commands>").append("</Collection></Collections></Sync>");
    paramCalendarInfo = ((StringBuilder)localObject).toString();
    printXml("buildUpdateEvent", paramCalendarInfo);
    return xml2Bytes(paramCalendarInfo);
  }
  
  private static Document bytes2XmlDoc(byte[] paramArrayOfByte)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("===== decode xml =====\n");
      localStringBuilder.append("len: ").append(paramArrayOfByte.length).append("\n");
      long l = System.nanoTime();
      ASWBXML localASWBXML = new ASWBXML();
      localASWBXML.loadBytes(paramArrayOfByte);
      localStringBuilder.append("loadBytes => ").append(elpasedInMillis(l)).append("ms\n");
      paramArrayOfByte = localASWBXML.getXmlDocument();
      QMLog.log(6, "CalendarActiveSyncService", "bytes to xml failed", localException1);
    }
    catch (Exception localException1)
    {
      try
      {
        localStringBuilder.append("===== decode xml done =====");
        QMLog.log(2, "CalendarActiveSyncService", localStringBuilder.toString());
        return paramArrayOfByte;
      }
      catch (Exception localException2)
      {
        break label99;
      }
      localException1 = localException1;
      paramArrayOfByte = null;
    }
    label99:
    return paramArrayOfByte;
  }
  
  private static boolean checkResponseXmlDoc(Document paramDocument, CalendarResult paramCalendarResult)
  {
    if (paramDocument == null)
    {
      paramCalendarResult.code = 6;
      paramCalendarResult.msg = "handleLoadFolderListResult, xmlDoc is null";
      return false;
    }
    paramCalendarResult.code = 0;
    paramCalendarResult.msg = "";
    return true;
  }
  
  public static void deleteCalendarFolder(CalendarInfo paramCalendarInfo, CalendarCallback paramCalendarCallback)
  {
    QMLog.log(4, "CalendarActiveSyncService", "removeCalendarFolder, email: " + paramCalendarInfo.email);
    byte[] arrayOfByte = buildDeleteCalendarFolder(paramCalendarInfo);
    sendRequest("[removeCalendarFolder--" + paramCalendarInfo.email + "]", paramCalendarInfo, "FolderDelete", 14, arrayOfByte, null, paramCalendarCallback);
  }
  
  private static String elpasedInMillis(long paramLong)
  {
    long l = System.nanoTime();
    return String.format(Locale.getDefault(), "%.2f", new Object[] { Float.valueOf((float)(l - paramLong) / 1000.0F / 1000.0F) });
  }
  
  private static String escapeXml(String paramString)
  {
    return StringEscapeUtils.escapeXml(paramString);
  }
  
  private static CAttendee getAttendee(Node paramNode)
  {
    CAttendee localCAttendee = new CAttendee();
    if (paramNode.getChildNodes().getLength() == 0) {}
    do
    {
      return localCAttendee;
      paramNode = paramNode.getChildNodes().item(0);
    } while (paramNode == null);
    String str = paramNode.getNodeName();
    int i = -1;
    switch (str.hashCode())
    {
    default: 
      label96:
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      paramNode = paramNode.getNextSibling();
      break;
      if (!str.equals("calendar:Email")) {
        break label96;
      }
      i = 0;
      break label96;
      if (!str.equals("calendar:Name")) {
        break label96;
      }
      i = 1;
      break label96;
      if (!str.equals("calendar:AttendeeStatus")) {
        break label96;
      }
      i = 2;
      break label96;
      if (!str.equals("calendar:AttendeeType")) {
        break label96;
      }
      i = 3;
      break label96;
      localCAttendee.email = paramNode.getTextContent();
      continue;
      localCAttendee.name = paramNode.getTextContent();
      continue;
      localCAttendee.status = getIntContent(paramNode);
      continue;
      localCAttendee.type = getIntContent(paramNode);
    }
  }
  
  private static int getChildIntContent(Document paramDocument, String paramString1, String paramString2)
  {
    paramDocument = getChildText(paramDocument, paramString1, paramString2);
    if (paramDocument != null) {
      try
      {
        int i = Integer.parseInt(paramDocument);
        return i;
      }
      catch (Exception paramDocument)
      {
        QMLog.log(5, "CalendarActiveSyncService", "getChildIntContent failed, parent: " + paramString1 + ", child: " + paramString2, paramDocument);
      }
    }
    return 0;
  }
  
  private static int getChildIntContent(Node paramNode, String paramString)
  {
    paramNode = getChildText(paramNode, paramString);
    if (paramNode != null) {
      try
      {
        int i = Integer.parseInt(paramNode);
        return i;
      }
      catch (Exception paramNode)
      {
        QMLog.log(5, "CalendarActiveSyncService", "getChildIntContent, tag: " + paramString, paramNode);
      }
    }
    return 0;
  }
  
  private static Node getChildNode(Node paramNode, String paramString)
  {
    Node localNode;
    if ((paramNode == null) || (paramNode.getChildNodes().getLength() == 0))
    {
      localNode = null;
      return localNode;
    }
    for (paramNode = paramNode.getChildNodes().item(0);; paramNode = paramNode.getNextSibling())
    {
      if (paramNode == null) {
        break label64;
      }
      localNode = paramNode;
      if (paramString.equals(paramNode.getNodeName())) {
        break;
      }
    }
    label64:
    return null;
  }
  
  private static String getChildText(Document paramDocument, String paramString1, String paramString2)
  {
    paramDocument = paramDocument.getElementsByTagName(paramString1);
    if (paramDocument.getLength() == 0) {}
    for (;;)
    {
      return null;
      paramDocument = paramDocument.item(0).getChildNodes();
      if (paramDocument.getLength() != 0) {
        for (paramDocument = paramDocument.item(0); paramDocument != null; paramDocument = paramDocument.getNextSibling()) {
          if (paramString2.equals(paramDocument.getNodeName())) {
            return paramDocument.getTextContent();
          }
        }
      }
    }
  }
  
  private static String getChildText(Node paramNode, String paramString)
  {
    paramNode = getChildNode(paramNode, paramString);
    if (paramNode != null) {
      return paramNode.getTextContent();
    }
    return null;
  }
  
  private static CException getException(Node paramNode, CCalendar paramCCalendar, long paramLong)
  {
    CException localCException = new CException();
    if (paramNode.getChildNodes().getLength() == 0) {}
    int j;
    int k;
    do
    {
      return localCException;
      paramNode = paramNode.getChildNodes().item(0);
      j = 0;
      k = 0;
    } while (paramNode == null);
    Object localObject = paramNode.getNodeName();
    int i = -1;
    label212:
    int m;
    switch (((String)localObject).hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        m = j;
        i = k;
      }
      break;
    }
    for (;;)
    {
      if (m == 0) {
        localCException.allday_event = paramCCalendar.allday_event;
      }
      if (i == 0) {
        localCException.reminder = ((int)paramCCalendar.reminder);
      }
      paramNode = paramNode.getNextSibling();
      k = i;
      j = m;
      break;
      if (!((String)localObject).equals("calendar:Deleted")) {
        break label212;
      }
      i = 0;
      break label212;
      if (!((String)localObject).equals("calendar:ExceptionStartTime")) {
        break label212;
      }
      i = 1;
      break label212;
      if (!((String)localObject).equals("calendar:DtStamp")) {
        break label212;
      }
      i = 2;
      break label212;
      if (!((String)localObject).equals("calendar:StartTime")) {
        break label212;
      }
      i = 3;
      break label212;
      if (!((String)localObject).equals("calendar:EndTime")) {
        break label212;
      }
      i = 4;
      break label212;
      if (!((String)localObject).equals("calendar:Subject")) {
        break label212;
      }
      i = 5;
      break label212;
      if (!((String)localObject).equals("calendar:Location")) {
        break label212;
      }
      i = 6;
      break label212;
      if (!((String)localObject).equals("airsyncbase:Body")) {
        break label212;
      }
      i = 7;
      break label212;
      if (!((String)localObject).equals("calendar:Categories")) {
        break label212;
      }
      i = 8;
      break label212;
      if (!((String)localObject).equals("calendar:Sensitivity")) {
        break label212;
      }
      i = 9;
      break label212;
      if (!((String)localObject).equals("calendar:BusyStatus")) {
        break label212;
      }
      i = 10;
      break label212;
      if (!((String)localObject).equals("calendar:AllDayEvent")) {
        break label212;
      }
      i = 11;
      break label212;
      if (!((String)localObject).equals("calendar:Reminder")) {
        break label212;
      }
      i = 12;
      break label212;
      if (!((String)localObject).equals("calendar:MeetingStatus")) {
        break label212;
      }
      i = 13;
      break label212;
      if (!((String)localObject).equals("calendar:Attendee")) {
        break label212;
      }
      i = 14;
      break label212;
      if (!((String)localObject).equals("calendar:AppointmentReplyTime")) {
        break label212;
      }
      i = 15;
      break label212;
      if (!((String)localObject).equals("calendar:ResponseType")) {
        break label212;
      }
      i = 16;
      break label212;
      localCException.deleted = "1".equals(paramNode.getTextContent());
      i = k;
      m = j;
      continue;
      localCException.exception_start_time = getTimeInSeconds(paramNode.getTextContent(), paramLong);
      i = k;
      m = j;
      continue;
      localCException.dt_stamp = getTimeInSeconds(paramNode.getTextContent(), paramLong);
      i = k;
      m = j;
      continue;
      localCException.start_time = getTimeInSeconds(paramNode.getTextContent(), paramLong);
      i = k;
      m = j;
      continue;
      localCException.end_time = getTimeInSeconds(paramNode.getTextContent(), paramLong);
      i = k;
      m = j;
      continue;
      localCException.subject = paramNode.getTextContent();
      i = k;
      m = j;
      continue;
      localCException.location = paramNode.getTextContent();
      i = k;
      m = j;
      continue;
      localCException.body = getChildText(paramNode, "airsyncbase:Data");
      i = k;
      m = j;
      continue;
      i = k;
      m = j;
      if (paramNode.getChildNodes().getLength() > 0)
      {
        for (localObject = paramNode.getChildNodes().item(0);; localObject = ((Node)localObject).getNextSibling())
        {
          i = k;
          m = j;
          if (localObject == null) {
            break;
          }
          if ("calendar:Category".equals(((Node)localObject).getNodeName())) {
            localCException.categories.add(((Node)localObject).getTextContent());
          }
        }
        localCException.sensitivity = getIntContent(paramNode);
        i = k;
        m = j;
        continue;
        localCException.busyStatus = getIntContent(paramNode);
        i = k;
        m = j;
        continue;
        localCException.allday_event = "1".equals(paramNode.getTextContent());
        m = 1;
        i = k;
        continue;
        localCException.reminder = getIntContent(paramNode);
        i = 1;
        m = j;
        continue;
        localCException.meeting_status = getIntContent(paramNode);
        i = k;
        m = j;
        continue;
        i = k;
        m = j;
        if (paramNode.getChildNodes().getLength() > 0)
        {
          for (localObject = paramNode.getChildNodes().item(0);; localObject = ((Node)localObject).getNextSibling())
          {
            i = k;
            m = j;
            if (localObject == null) {
              break;
            }
            if ("calendar:Attendee".equals(((Node)localObject).getNodeName())) {
              localCException.attendees.add(getAttendee((Node)localObject));
            }
          }
          localCException.appointment_replytime = getTimeInSeconds(paramNode.getTextContent(), paramLong);
          i = k;
          m = j;
          continue;
          localCException.response_type = getIntContent(paramNode);
          i = k;
          m = j;
        }
      }
    }
  }
  
  private static HashMap<String, String> getHeaders(CalendarInfo paramCalendarInfo, int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("Content-Length", String.valueOf(paramInt));
    if (!"OPTIONS".equals(paramString))
    {
      localHashMap.put("MS-ASProtocolVersion", paramCalendarInfo.activeSyncInfo.getActiveSyncVersion());
      if (!"Provision".equals(paramString)) {
        localHashMap.put("X-MS-PolicyKey", paramCalendarInfo.activeSyncInfo.getActiveSyncPolicyKey());
      }
      localHashMap.put("Content-Type", "application/vnd.ms-sync.wbxml");
    }
    Object localObject1 = paramCalendarInfo.password;
    paramInt = paramCalendarInfo.activeSyncInfo.getWtAuthType();
    Object localObject2;
    if ((paramInt == 1) || (paramInt == 2))
    {
      localObject2 = paramCalendarInfo.activeSyncInfo.getActiveSyncPassword();
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label324;
      }
      localObject1 = StringExtention.MD5(((String)localObject2).getBytes(), ((String)localObject2).length());
      if (paramInt == 1)
      {
        localHashMap.put("X-QQ-A2MD5", localObject1);
        localObject1 = localObject2;
        localHashMap.put("X-QQ-AUTHTYPE", String.valueOf(paramInt));
      }
    }
    label324:
    for (;;)
    {
      localObject2 = localObject1;
      for (;;)
      {
        paramCalendarInfo = paramCalendarInfo.email + ":" + (String)localObject2;
        paramCalendarInfo = StringExtention.base64Encode(paramCalendarInfo.getBytes(), paramCalendarInfo.length());
        localHashMap.put("Authorization", "Basic " + paramCalendarInfo);
        localHashMap.put("User-Agent", USER_AGENT);
        QMLog.log(3, "CalendarActiveSyncService", "getHeaders, cmd: " + paramString + ", headers: " + localHashMap);
        return localHashMap;
        break;
        localObject2 = localObject1;
        if (paramInt == 3)
        {
          localHashMap.put("X-QQ-AUTHTYPE", String.valueOf(paramInt));
          localObject2 = localObject1;
        }
      }
    }
  }
  
  private static int getIntContent(Node paramNode)
  {
    try
    {
      int i = Integer.parseInt(paramNode.getTextContent());
      return i;
    }
    catch (Exception paramNode)
    {
      QMLog.log(5, "CalendarActiveSyncService", "getIntContent failed", paramNode);
    }
    return 0;
  }
  
  public static String getLocalTimeInFormat(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(1000L * paramLong);
    return new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.getDefault()).format(localCalendar.getTime());
  }
  
  private static long getLongContent(Node paramNode)
  {
    try
    {
      long l = Long.parseLong(paramNode.getTextContent());
      return l;
    }
    catch (Exception paramNode)
    {
      QMLog.log(5, "CalendarActiveSyncService", "getLongContent failed", paramNode);
    }
    return 0L;
  }
  
  private static int getNextCmdType(QMNetworkResponse paramQMNetworkResponse, CalendarInfo paramCalendarInfo, int paramInt, CalendarResult paramCalendarResult)
  {
    int i = paramQMNetworkResponse.getResponseCode();
    if (i == 449)
    {
      paramCalendarResult.activeSyncResult.errorCode = 6;
      switch (paramCalendarResult.activeSyncResult.errorCode)
      {
      case 5: 
      default: 
        paramInt = 0;
      }
    }
    for (;;)
    {
      QMLog.log(4, "CalendarActiveSyncService", "redirect after response, responseCode: " + i + ", errCode: " + paramCalendarResult.activeSyncResult.errorCode + ", nextCmdType: " + paramInt);
      return paramInt;
      if (i == 451)
      {
        paramCalendarResult.activeSyncResult.errorCode = 8;
        break;
      }
      if (i != 401) {
        break;
      }
      paramCalendarResult.activeSyncResult.errorCode = 2;
      break;
      paramInt = 7;
      continue;
      paramInt = 8;
      continue;
      paramInt = 9;
      continue;
      paramInt = 10;
      paramCalendarResult.activeSyncResult.serverAddr = paramCalendarInfo.activeSyncInfo.getActiveSyncServer();
      paramCalendarResult.activeSyncResult.protocolVersion = paramCalendarInfo.activeSyncInfo.getActiveSyncVersion();
      paramCalendarResult.activeSyncResult.update_account_ = true;
      continue;
      paramQMNetworkResponse = (List)paramQMNetworkResponse.getResponseHeaders().get("X-MS-Location");
      try
      {
        paramQMNetworkResponse = new URL((String)paramQMNetworkResponse.get(0));
        paramCalendarInfo.activeSyncInfo.setActiveSyncUsingSSL("https".equals(paramQMNetworkResponse.getProtocol()));
        paramCalendarInfo.activeSyncInfo.setActiveSyncServer(paramQMNetworkResponse.getHost());
        paramCalendarResult.activeSyncResult.serverAddr = paramCalendarInfo.activeSyncInfo.getActiveSyncServer();
        paramCalendarResult.activeSyncResult.update_account_ = true;
      }
      catch (Exception paramQMNetworkResponse)
      {
        QMLog.log(6, "CalendarActiveSyncService", "handleResponse error", paramQMNetworkResponse);
        paramInt = 0;
      }
      continue;
      paramInt = 2;
      continue;
      paramInt = 6;
    }
  }
  
  private static CalendarResult getProtocolResult(CalendarInfo paramCalendarInfo, CalendarResult paramCalendarResult)
  {
    CalendarResult localCalendarResult = paramCalendarResult;
    if (paramCalendarResult == null)
    {
      localCalendarResult = new CalendarResult();
      localCalendarResult.accountId = paramCalendarInfo.accountId;
    }
    if (localCalendarResult.activeSyncResult == null) {
      localCalendarResult.activeSyncResult = new ActiveSyncResult();
    }
    return localCalendarResult;
  }
  
  private static CRecurrence getRecurrence(Node paramNode, long paramLong)
  {
    CRecurrence localCRecurrence = new CRecurrence();
    if (paramNode.getChildNodes().getLength() == 0) {}
    do
    {
      return localCRecurrence;
      paramNode = paramNode.getChildNodes().item(0);
    } while (paramNode == null);
    String str = paramNode.getNodeName();
    int i = -1;
    switch (str.hashCode())
    {
    default: 
      label156:
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      paramNode = paramNode.getNextSibling();
      break;
      if (!str.equals("calendar:Type")) {
        break label156;
      }
      i = 0;
      break label156;
      if (!str.equals("calendar:Until")) {
        break label156;
      }
      i = 1;
      break label156;
      if (!str.equals("calendar:Occurrences")) {
        break label156;
      }
      i = 2;
      break label156;
      if (!str.equals("calendar:Interval")) {
        break label156;
      }
      i = 3;
      break label156;
      if (!str.equals("calendar:CalendarType")) {
        break label156;
      }
      i = 4;
      break label156;
      if (!str.equals("calendar:DayOfWeek")) {
        break label156;
      }
      i = 5;
      break label156;
      if (!str.equals("calendar:DayOfMonth")) {
        break label156;
      }
      i = 6;
      break label156;
      if (!str.equals("calendar:WeekOfMonth")) {
        break label156;
      }
      i = 7;
      break label156;
      if (!str.equals("calendar:MonthOfYear")) {
        break label156;
      }
      i = 8;
      break label156;
      if (!str.equals("calendar:IsLeapMonth")) {
        break label156;
      }
      i = 9;
      break label156;
      if (!str.equals("calendar:FirstDayOfWeek")) {
        break label156;
      }
      i = 10;
      break label156;
      localCRecurrence.type = getIntContent(paramNode);
      continue;
      localCRecurrence.until = getTimeInSeconds(paramNode.getTextContent(), paramLong);
      continue;
      localCRecurrence.occurrences = getLongContent(paramNode);
      continue;
      localCRecurrence.interval = getLongContent(paramNode);
      continue;
      localCRecurrence.calendar_type = getIntContent(paramNode);
      continue;
      localCRecurrence.day_of_week = getLongContent(paramNode);
      continue;
      localCRecurrence.day_of_month = getLongContent(paramNode);
      continue;
      localCRecurrence.week_of_month = getLongContent(paramNode);
      continue;
      localCRecurrence.month_of_year = getLongContent(paramNode);
      continue;
      localCRecurrence.is_leap_month = "1".equals(paramNode.getTextContent());
      continue;
      localCRecurrence.first_day_of_week = getIntContent(paramNode);
    }
  }
  
  private static QMShareItem getShareItem(Node paramNode)
  {
    QMShareItem localQMShareItem = new QMShareItem();
    localQMShareItem.qmShareFrom = getChildText(paramNode, "QMshareFrom");
    localQMShareItem.qmShareName = getChildText(paramNode, "QMshareName");
    localQMShareItem.qmShareState = getChildIntContent(paramNode, "QMshareState");
    return localQMShareItem;
  }
  
  public static String getTimeInFormat(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(1000L * paramLong);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'", Locale.getDefault());
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    return localSimpleDateFormat.format(localCalendar.getTime());
  }
  
  private static long getTimeInSeconds(String paramString, long paramLong)
  {
    Object localObject = new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.getDefault());
    ((SimpleDateFormat)localObject).setTimeZone(TimeZone.getTimeZone("GMT"));
    try
    {
      localObject = ((SimpleDateFormat)localObject).parse(paramString);
      if (!paramString.contains("Z")) {
        return ((Date)localObject).getTime() / 1000L - paramLong;
      }
      paramLong = ((Date)localObject).getTime() / 1000L;
      return paramLong;
    }
    catch (Exception localException)
    {
      QMLog.log(5, "CalendarActiveSyncService", "getTimeinSeconds failed: " + paramString);
    }
    return 0L;
  }
  
  private static CActiveSyncFolder getUpdateOrAddFolder(Node paramNode)
  {
    CActiveSyncFolder localCActiveSyncFolder = null;
    if (paramNode == null) {
      paramNode = localCActiveSyncFolder;
    }
    NodeList localNodeList;
    int j;
    int k;
    label45:
    do
    {
      do
      {
        return paramNode;
        localNodeList = paramNode.getChildNodes();
        if (localNodeList != null) {
          break;
        }
        j = 0;
        paramNode = localCActiveSyncFolder;
      } while (j <= 0);
      localCActiveSyncFolder = new CActiveSyncFolder();
      k = 0;
      paramNode = localCActiveSyncFolder;
    } while (k >= j);
    paramNode = localNodeList.item(k);
    if (paramNode == null) {}
    for (;;)
    {
      k += 1;
      break label45;
      j = localNodeList.getLength();
      break;
      String str = paramNode.getNodeName();
      int i = -1;
      switch (str.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          break;
        case 0: 
          localCActiveSyncFolder.folderType = Integer.parseInt(paramNode.getTextContent());
          break;
          if (str.equals("Type"))
          {
            i = 0;
            continue;
            if (str.equals("ServerId"))
            {
              i = 1;
              continue;
              if (str.equals("ParentId"))
              {
                i = 2;
                continue;
                if (str.equals("DisplayName"))
                {
                  i = 3;
                  continue;
                  if (str.equals("QMshareSource"))
                  {
                    i = 4;
                    continue;
                    if (str.equals("QMshare"))
                    {
                      i = 5;
                      continue;
                      if (str.equals("QMshareItemAdd"))
                      {
                        i = 6;
                        continue;
                        if (str.equals("QMshareItemUpdate"))
                        {
                          i = 7;
                          continue;
                          if (str.equals("QMshareItemDel")) {
                            i = 8;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          break;
        }
      }
      localCActiveSyncFolder.serverId = paramNode.getTextContent();
      continue;
      localCActiveSyncFolder.parentId = paramNode.getTextContent();
      continue;
      localCActiveSyncFolder.displayName = paramNode.getTextContent();
      continue;
      localCActiveSyncFolder.qmShareSource = paramNode.getTextContent();
      continue;
      localCActiveSyncFolder.qmShare = "1".equals(paramNode.getTextContent());
      continue;
      localCActiveSyncFolder.shareItemAddList.add(getShareItem(paramNode));
      continue;
      localCActiveSyncFolder.shareItemUpdateList.add(getShareItem(paramNode));
      continue;
      localCActiveSyncFolder.shareItemDeleteList.add(getShareItem(paramNode));
    }
  }
  
  private static String getUrl(CalendarInfo paramCalendarInfo, String paramString)
  {
    boolean bool2 = paramCalendarInfo.activeSyncInfo.isActiveSyncUsingSSL();
    boolean bool3 = "OPTIONS".equals(paramString);
    str2 = paramCalendarInfo.activeSyncInfo.getDeviceId();
    if (!TextUtils.isEmpty(str2)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ValidateHelper.assertInDebug("deviceId is empty", bool1);
      Object localObject1 = "";
      try
      {
        localObject2 = URLEncoder.encode(paramCalendarInfo.activeSyncInfo.getDeviceType(), "UTF-8");
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2;
          StringBuilder localStringBuilder;
          QMLog.log(5, "CalendarActiveSyncService", "getUrl", localException);
          continue;
          String str1 = "http://";
          continue;
          str1 = ":80";
          continue;
          paramCalendarInfo = str2.replace("-", "");
        }
      }
      if (!bool2) {
        break;
      }
      localObject2 = "https://";
      localStringBuilder = new StringBuilder((String)localObject2).append(paramCalendarInfo.activeSyncInfo.getActiveSyncServer());
      if (!bool2) {
        break label221;
      }
      localObject2 = ":443";
      localObject2 = localStringBuilder.append((String)localObject2).append("/Microsoft-Server-ActiveSync");
      if (!bool3)
      {
        localStringBuilder = ((StringBuilder)localObject2).append("?User=").append(paramCalendarInfo.email).append("&DeviceId=");
        if (!TextUtils.isEmpty(str2)) {
          break label229;
        }
        paramCalendarInfo = "";
        localStringBuilder.append(paramCalendarInfo).append("&DeviceType=").append((String)localObject1).append("&Cmd=").append(paramString);
      }
      return ((StringBuilder)localObject2).toString();
    }
  }
  
  private static void handleAddCalendarResult(Document paramDocument, CalendarInfo paramCalendarInfo, CalendarResult paramCalendarResult)
  {
    if (!checkResponseXmlDoc(paramDocument, paramCalendarResult)) {}
    do
    {
      do
      {
        do
        {
          return;
          paramCalendarResult = getProtocolResult(paramCalendarInfo, paramCalendarResult);
          if (paramCalendarResult.activeSyncResult.syncResult == null) {
            paramCalendarResult.activeSyncResult.syncResult = new CActiveSyncSyncResult();
          }
        } while ((isNodeExist(paramDocument, "Sync", "Status")) && (!handleCommonStatus(getChildIntContent(paramDocument, "Sync", "Status"), paramCalendarResult)));
        if (!isNodeExist(paramDocument, "Collection", "CollectionId"))
        {
          paramCalendarResult.code = 6;
          paramCalendarResult.msg = "handleAddCalendarResult, CollectionId tag not exist";
          return;
        }
        str = getChildText(paramDocument, "Collection", "CollectionId");
        paramCalendarResult.activeSyncResult.syncResult.collectionId = str;
      } while (!handleSyncStatus(getChildIntContent(paramDocument, "Collection", "Status"), paramCalendarResult));
      if (!isNodeExist(paramDocument, "Collection", "SyncKey"))
      {
        paramCalendarResult.code = 6;
        paramCalendarResult.msg = "handleAddCalendarResult, SyncKey tag not exist";
        return;
      }
      String str = getChildText(paramDocument, "Collection", "SyncKey");
      paramCalendarResult.activeSyncResult.syncResult.syncKey = str;
      paramCalendarInfo.activeSyncInfo.syncInfo.syncKey = str;
    } while (!handleSyncStatus(getChildIntContent(paramDocument, "Add", "Status"), paramCalendarResult));
    if (!isNodeExist(paramDocument, "Add", "ServerId"))
    {
      paramCalendarResult.code = 6;
      paramCalendarResult.msg = "handleAddCalendarResult, ServerId tag not exist";
      return;
    }
    paramCalendarResult.activeSyncResult.syncResult.serverIdAddList.add(getChildText(paramDocument, "Add", "ServerId"));
  }
  
  private static boolean handleCommonProvisionStatus(int paramInt, CalendarResult paramCalendarResult)
  {
    if (paramInt == 1) {
      return true;
    }
    String str;
    switch (paramInt)
    {
    default: 
      str = "unknown";
    }
    for (;;)
    {
      paramCalendarResult.detailMsg = str;
      paramCalendarResult.detailCode = paramInt;
      paramCalendarResult.code = 6;
      paramCalendarResult.msg = ("handleCommonProvisionStatus, status: " + paramInt + ", msg: " + str);
      return false;
      str = "Protocol error, Syntax error in the Provision command request.";
      continue;
      str = "An error occurred on the server.";
      continue;
      str = "The client cannot fully comply with all requirements of the policy.";
      continue;
      str = "The client did not submit a policy key value in a request. The server is configured to not allow clients that do not submit a policy key value.";
      continue;
      str = "The client returned a value of 4 in the Status child element of the Policy";
    }
  }
  
  private static boolean handleCommonStatus(int paramInt, CalendarResult paramCalendarResult)
  {
    if (paramInt == 1) {
      return true;
    }
    if (paramInt == 140) {
      paramCalendarResult.activeSyncResult.errorCode = 3;
    }
    for (;;)
    {
      paramCalendarResult.detailMsg = "unknown";
      paramCalendarResult.detailCode = paramInt;
      paramCalendarResult.code = 6;
      paramCalendarResult.msg = ("handleCommonStatus, status: " + paramInt + ", msg: " + "unknown");
      return false;
      if (paramInt == 142) {
        paramCalendarResult.activeSyncResult.errorCode = 6;
      } else if (paramInt == 451) {
        paramCalendarResult.activeSyncResult.errorCode = 8;
      }
    }
  }
  
  private static void handleCommonSyncResult(Document paramDocument, CalendarInfo paramCalendarInfo, CalendarResult paramCalendarResult)
  {
    if (!checkResponseXmlDoc(paramDocument, paramCalendarResult)) {}
    do
    {
      do
      {
        return;
        paramCalendarInfo = getProtocolResult(paramCalendarInfo, paramCalendarResult);
        if (paramCalendarInfo.activeSyncResult.syncResult == null) {
          paramCalendarInfo.activeSyncResult.syncResult = new CActiveSyncSyncResult();
        }
      } while ((isNodeExist(paramDocument, "Sync", "Status")) && (!handleCommonStatus(getChildIntContent(paramDocument, "Sync", "Status"), paramCalendarInfo)));
      if (!isNodeExist(paramDocument, "Collection", "CollectionId"))
      {
        paramCalendarInfo.code = 6;
        paramCalendarInfo.msg = "handleCommonSyncResult, CollectionId tag not exist";
        return;
      }
      paramCalendarResult = getChildText(paramDocument, "Collection", "CollectionId");
      paramCalendarInfo.activeSyncResult.syncResult.collectionId = paramCalendarResult;
    } while (!handleSyncStatus(getChildIntContent(paramDocument, "Collection", "Status"), paramCalendarInfo));
    if (!isNodeExist(paramDocument, "Collection", "SyncKey"))
    {
      paramCalendarInfo.code = 6;
      paramCalendarInfo.msg = "handleCommonSyncResult, SyncKey tag not exist";
      return;
    }
    paramCalendarInfo.activeSyncResult.syncResult.syncKey = getChildText(paramDocument, "Collection", "SyncKey");
  }
  
  private static void handleFolderCreateResult(Document paramDocument, CalendarInfo paramCalendarInfo, CalendarResult paramCalendarResult)
  {
    if (!checkResponseXmlDoc(paramDocument, paramCalendarResult)) {}
    CActiveSyncFolder localCActiveSyncFolder;
    do
    {
      return;
      paramCalendarInfo = getProtocolResult(paramCalendarInfo, paramCalendarResult);
      if (paramCalendarInfo.activeSyncResult.folderChangeResult == null) {
        paramCalendarInfo.activeSyncResult.folderChangeResult = new CActiveSyncFolderChangeResult();
      }
      if (paramCalendarInfo.activeSyncResult.folderChangeResult.folder == null) {
        paramCalendarInfo.activeSyncResult.folderChangeResult.folder = new CActiveSyncFolder();
      }
      paramCalendarResult = paramCalendarInfo.activeSyncResult.folderChangeResult;
      localCActiveSyncFolder = paramCalendarResult.folder;
    } while (!handleFolderCreateStatus(getChildIntContent(paramDocument, "FolderCreate", "Status"), paramCalendarInfo));
    if (!isNodeExist(paramDocument, "FolderCreate", "SyncKey"))
    {
      paramCalendarInfo.code = 6;
      paramCalendarInfo.msg = "handleFolderCreateResult, SyncKey tag not exist";
      return;
    }
    paramCalendarResult.syncKey = getChildText(paramDocument, "FolderCreate", "SyncKey");
    if (!isNodeExist(paramDocument, "FolderCreate", "ServerId"))
    {
      paramCalendarInfo.code = 6;
      paramCalendarInfo.msg = "handleFolderCreateResult, serverId tag not exist";
      return;
    }
    localCActiveSyncFolder.serverId = getChildText(paramDocument, "FolderCreate", "ServerId");
  }
  
  private static boolean handleFolderCreateStatus(int paramInt, CalendarResult paramCalendarResult)
  {
    if (paramInt == 1) {
      return true;
    }
    String str;
    switch (paramInt)
    {
    case 4: 
    case 7: 
    case 8: 
    default: 
      str = "unknown";
    }
    for (;;)
    {
      paramCalendarResult.detailMsg = str;
      paramCalendarResult.detailCode = paramInt;
      paramCalendarResult.code = 6;
      paramCalendarResult.msg = ("handleFolderCreateStatus, status: " + paramInt + ", msg: " + str);
      return false;
      str = "A folder that has this name already exists.";
      continue;
      str = "The specified parent folder is a special system folder.";
      continue;
      str = "The specified parent folder was not found.";
      continue;
      str = "An error occurred on the server.";
      continue;
      str = "Synchronization key mismatch or invalid synchronization key.";
      continue;
      str = "Malformed request.";
      continue;
      str = "An unknown error occurred.";
      continue;
      str = "Code unknown.";
    }
  }
  
  private static void handleFolderDeleteResult(Document paramDocument, CalendarInfo paramCalendarInfo, CalendarResult paramCalendarResult)
  {
    if (!checkResponseXmlDoc(paramDocument, paramCalendarResult)) {}
    do
    {
      return;
      paramCalendarInfo = getProtocolResult(paramCalendarInfo, paramCalendarResult);
      if (paramCalendarInfo.activeSyncResult.folderChangeResult == null) {
        paramCalendarInfo.activeSyncResult.folderChangeResult = new CActiveSyncFolderChangeResult();
      }
      paramCalendarResult = paramCalendarInfo.activeSyncResult.folderChangeResult;
    } while (!handleFolderDeleteStatus(getChildIntContent(paramDocument, "FolderDelete", "Status"), paramCalendarInfo));
    if (!isNodeExist(paramDocument, "FolderDelete", "SyncKey"))
    {
      paramCalendarInfo.code = 6;
      paramCalendarInfo.msg = "handleFolderDeleteResult, SyncKey tag not exist";
      return;
    }
    paramCalendarResult.syncKey = getChildText(paramDocument, "FolderDelete", "SyncKey");
  }
  
  private static boolean handleFolderDeleteStatus(int paramInt, CalendarResult paramCalendarResult)
  {
    if (paramInt == 1) {
      return true;
    }
    String str;
    switch (paramInt)
    {
    case 5: 
    case 7: 
    case 8: 
    default: 
      str = "unknown";
    }
    for (;;)
    {
      paramCalendarResult.detailMsg = str;
      paramCalendarResult.detailCode = paramInt;
      paramCalendarResult.code = 6;
      paramCalendarResult.msg = ("handleFolderDeleteStatus, status: " + paramInt + ", msg: " + str);
      return false;
      str = "The specified folder is a special system folder.";
      continue;
      str = "The specified folder does not exist.";
      continue;
      str = "An error occurred on the server.";
      continue;
      str = "Synchronization key mismatch or invalid synchronization key.";
      continue;
      str = "Incorrectly formatted request.";
      continue;
      str = "An unknown error occurred.";
    }
  }
  
  private static boolean handleFolderSyncStatus(int paramInt, CalendarResult paramCalendarResult)
  {
    if (paramInt == 1) {
      return true;
    }
    String str;
    switch (paramInt)
    {
    case 7: 
    case 8: 
    default: 
      str = "unknown";
    }
    for (;;)
    {
      paramCalendarResult.detailMsg = str;
      paramCalendarResult.detailCode = paramInt;
      paramCalendarResult.code = 6;
      paramCalendarResult.msg = ("handleFolderSyncStatus, status: " + paramInt + ", msg: " + str);
      return false;
      str = "An error occurred on the server.";
      continue;
      str = "Synchronization key mismatch or invalid synchronization key.";
      continue;
      str = "Incorrectly formatted request.";
      continue;
      str = "An unknown error occurred.";
      continue;
      str = "Code unknown.";
    }
  }
  
  private static void handleFolderUpdateResult(Document paramDocument, CalendarInfo paramCalendarInfo, CalendarResult paramCalendarResult)
  {
    if (!checkResponseXmlDoc(paramDocument, paramCalendarResult)) {}
    do
    {
      return;
      paramCalendarInfo = getProtocolResult(paramCalendarInfo, paramCalendarResult);
      if (paramCalendarInfo.activeSyncResult.folderChangeResult == null) {
        paramCalendarInfo.activeSyncResult.folderChangeResult = new CActiveSyncFolderChangeResult();
      }
      paramCalendarResult = paramCalendarInfo.activeSyncResult.folderChangeResult;
    } while (!handleFolderUpdateStatus(getChildIntContent(paramDocument, "FolderUpdate", "Status"), paramCalendarInfo));
    if (!isNodeExist(paramDocument, "FolderUpdate", "SyncKey"))
    {
      paramCalendarInfo.code = 6;
      paramCalendarInfo.msg = "handleFolderUpdateResult, SyncKey tag not exist";
      return;
    }
    paramCalendarResult.syncKey = getChildText(paramDocument, "FolderUpdate", "SyncKey");
  }
  
  private static boolean handleFolderUpdateStatus(int paramInt, CalendarResult paramCalendarResult)
  {
    if (paramInt == 1) {
      return true;
    }
    String str;
    switch (paramInt)
    {
    case 7: 
    case 8: 
    default: 
      str = "unknown";
    }
    for (;;)
    {
      paramCalendarResult.detailMsg = str;
      paramCalendarResult.detailCode = paramInt;
      paramCalendarResult.code = 6;
      paramCalendarResult.msg = ("handleFolderUpdateStatus, status: " + paramInt + ", msg: " + str);
      return false;
      str = "A folder with that name already exists or the specified folder is a special folder.";
      continue;
      str = "The specified folder is the Recipient information folder, which cannot be updated by the client.";
      continue;
      str = "The specified folder does not exist.";
      continue;
      str = "The specified parent folder was not found.";
      continue;
      str = "An error occurred on the server.";
      continue;
      str = "Synchronization key mismatch or invalid synchronization key.";
      continue;
      str = "Incorrectly formatted request.";
      continue;
      str = "An unknown error occurred.";
    }
  }
  
  private static void handleLoadCalendarListResult(Document paramDocument, CalendarInfo paramCalendarInfo, CalendarResult paramCalendarResult, boolean paramBoolean)
  {
    if (!checkResponseXmlDoc(paramDocument, paramCalendarResult)) {}
    String str1;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              paramCalendarResult = getProtocolResult(paramCalendarInfo, paramCalendarResult);
              if (paramCalendarResult.activeSyncResult.syncResult == null) {
                paramCalendarResult.activeSyncResult.syncResult = new CActiveSyncSyncResult();
              }
            } while ((isNodeExist(paramDocument, "Sync", "Status")) && (!handleCommonStatus(getChildIntContent(paramDocument, "Sync", "Status"), paramCalendarResult)));
            if (!isNodeExist(paramDocument, "Collection", "CollectionId"))
            {
              paramCalendarResult.code = 6;
              paramCalendarResult.msg = "handleLoadCalendarListResult, CollectionId tag not exist";
              return;
            }
            str1 = getChildText(paramDocument, "Collection", "CollectionId");
            paramCalendarResult.activeSyncResult.syncResult.collectionId = str1;
          } while (!handleSyncStatus(getChildIntContent(paramDocument, "Collection", "Status"), paramCalendarResult));
          if (isNodeExist(paramDocument, "MoreAvailable"))
          {
            paramCalendarResult.code = 3;
            paramCalendarResult.activeSyncResult.errorCode = 2;
            paramCalendarResult.msg = "handleLoadCalendarListResult, MoreAvailable";
            QMLog.log(4, "CalendarActiveSyncService", "MoreAvailable ");
          }
          if (!isNodeExist(paramDocument, "Collection", "SyncKey"))
          {
            paramCalendarResult.code = 6;
            paramCalendarResult.msg = "handleLoadCalendarListResult, SyncKey tag not exist";
            return;
          }
          String str2 = getChildText(paramDocument, "Collection", "SyncKey");
          paramCalendarResult.activeSyncResult.syncResult.syncKey = str2;
          paramCalendarInfo.activeSyncInfo.syncInfo.syncKey = str2;
          if (paramBoolean)
          {
            paramCalendarResult.activeSyncResult.errorCode = 10;
            return;
          }
          paramDocument = paramDocument.getElementsByTagName("Commands");
        } while (paramDocument.getLength() <= 0);
        paramDocument = paramDocument.item(0).getChildNodes();
        QMLog.log(4, "CalendarActiveSyncService", "sync calendar event list size " + paramDocument.getLength());
      } while (paramDocument.getLength() <= 0);
      paramDocument = paramDocument.item(0);
    } while (paramDocument == null);
    paramCalendarInfo = paramDocument.getNodeName();
    int i = -1;
    switch (paramCalendarInfo.hashCode())
    {
    default: 
      label392:
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      paramDocument = paramDocument.getNextSibling();
      break;
      if (!paramCalendarInfo.equals("Add")) {
        break label392;
      }
      i = 0;
      break label392;
      if (!paramCalendarInfo.equals("Delete")) {
        break label392;
      }
      i = 1;
      break label392;
      if (!paramCalendarInfo.equals("SoftDelete")) {
        break label392;
      }
      i = 2;
      break label392;
      if (!paramCalendarInfo.equals("Change")) {
        break label392;
      }
      i = 3;
      break label392;
      paramCalendarInfo = new CCalendar();
      paramCalendarInfo.folder_id_ = str1;
      paramCalendarInfo.server_id = getChildText(paramDocument, "ServerId");
      parseCalendar(getChildNode(paramDocument, "ApplicationData"), paramCalendarInfo);
      paramCalendarResult.activeSyncResult.syncResult.addList.add(paramCalendarInfo);
      continue;
      paramCalendarResult.activeSyncResult.syncResult.deleteList.add(getChildText(paramDocument, "ServerId"));
      continue;
      paramCalendarResult.activeSyncResult.syncResult.sofedeleteList.add(getChildText(paramDocument, "ServerId"));
      continue;
      paramCalendarInfo = new CCalendar();
      paramCalendarInfo.folder_id_ = str1;
      paramCalendarInfo.server_id = getChildText(paramDocument, "ServerId");
      parseCalendar(getChildNode(paramDocument, "ApplicationData"), paramCalendarInfo);
      paramCalendarResult.activeSyncResult.syncResult.updateList.add(paramCalendarInfo);
    }
  }
  
  private static void handleLoadFolderListResult(Document paramDocument, CalendarInfo paramCalendarInfo, CalendarResult paramCalendarResult)
  {
    if (!checkResponseXmlDoc(paramDocument, paramCalendarResult)) {}
    int i;
    do
    {
      do
      {
        return;
        paramCalendarInfo = getProtocolResult(paramCalendarInfo, paramCalendarResult);
        if (paramCalendarInfo.activeSyncResult.folderSyncResult == null) {
          paramCalendarInfo.activeSyncResult.folderSyncResult = new CActiveSyncFolderSyncResult();
        }
        paramCalendarResult = new StringBuilder("handleLoadFolderListResult, ");
        i = getChildIntContent(paramDocument, "FolderSync", "Status");
        paramCalendarResult.append("Status: ").append(i);
      } while (!handleFolderSyncStatus(i, paramCalendarInfo));
      if (!isNodeExist(paramDocument, "FolderSync", "SyncKey"))
      {
        paramCalendarInfo.code = 6;
        paramCalendarInfo.msg = "handleLoadFolderListResult, SyncKey tag not exist";
        return;
      }
      paramCalendarInfo.activeSyncResult.folderSyncResult.folderSynckey = getChildText(paramDocument, "FolderSync", "SyncKey");
      i = getChildIntContent(paramDocument, "Changes", "Count");
      paramCalendarResult.append(", count: ").append(i);
    } while (i == 0);
    Object localObject1 = paramDocument.getElementsByTagName("Update");
    int j = ((NodeList)localObject1).getLength();
    paramCalendarResult.append(", update: ").append(j);
    Object localObject2;
    if (j > 0)
    {
      i = 0;
      while (i < j)
      {
        localObject2 = getUpdateOrAddFolder(((NodeList)localObject1).item(i));
        if (localObject2 != null) {
          paramCalendarInfo.activeSyncResult.folderSyncResult.updateList.add(localObject2);
        }
        i += 1;
      }
    }
    localObject1 = paramDocument.getElementsByTagName("Add");
    j = ((NodeList)localObject1).getLength();
    paramCalendarResult.append(", add: ").append(j);
    if (j > 0)
    {
      i = 0;
      while (i < j)
      {
        localObject2 = getUpdateOrAddFolder(((NodeList)localObject1).item(i));
        if (localObject2 != null) {
          paramCalendarInfo.activeSyncResult.folderSyncResult.addList.add(localObject2);
        }
        i += 1;
      }
    }
    paramDocument = paramDocument.getElementsByTagName("Delete");
    int m = paramDocument.getLength();
    paramCalendarResult.append(", delete: ").append(m);
    if (m > 0)
    {
      i = 0;
      if (i < m)
      {
        localObject1 = paramDocument.item(i);
        if (localObject1 == null) {}
        for (;;)
        {
          i += 1;
          break;
          localObject1 = ((Node)localObject1).getChildNodes();
          label408:
          int k;
          if (localObject1 == null)
          {
            j = 0;
            if (j <= 0) {
              break label458;
            }
            k = 0;
            label416:
            if (k < j)
            {
              localObject2 = ((NodeList)localObject1).item(k);
              if (localObject2 != null) {
                break label460;
              }
            }
          }
          label458:
          label460:
          while (!"ServerId".equals(((Node)localObject2).getNodeName()))
          {
            k += 1;
            break label416;
            break;
            j = ((NodeList)localObject1).getLength();
            break label408;
            break;
          }
          paramCalendarInfo.activeSyncResult.folderSyncResult.removeList.add(((Node)localObject2).getTextContent());
        }
      }
    }
    QMLog.log(4, "CalendarActiveSyncService", paramCalendarResult.toString());
  }
  
  private static void handleMeetingResponseResult(Document paramDocument, CalendarInfo paramCalendarInfo, CalendarResult paramCalendarResult)
  {
    if (!checkResponseXmlDoc(paramDocument, paramCalendarResult)) {}
    do
    {
      do
      {
        return;
        paramCalendarInfo = getProtocolResult(paramCalendarInfo, paramCalendarResult);
        if (paramCalendarInfo.activeSyncResult.meetingResponseResult == null) {
          paramCalendarInfo.activeSyncResult.meetingResponseResult = new CActiveSyncMeetingResponseResult();
        }
      } while (!handleMeetingResponseStatus(getChildIntContent(paramDocument, "Result", "Status"), paramCalendarInfo));
      if (!isNodeExist(paramDocument, "Result", "RequestId"))
      {
        paramCalendarInfo.code = 6;
        paramCalendarInfo.msg = "handleMeetingResponseResult, RequestId tag not exist";
        return;
      }
      paramCalendarInfo.activeSyncResult.meetingResponseResult.requestId = getChildText(paramDocument, "Result", "RequestId");
    } while (!isNodeExist(paramDocument, "Result", "CalendarId"));
    paramCalendarInfo.activeSyncResult.meetingResponseResult.calendarId = getChildText(paramDocument, "Result", "CalendarId");
  }
  
  private static boolean handleMeetingResponseStatus(int paramInt, CalendarResult paramCalendarResult)
  {
    if (paramInt == 1) {
      return true;
    }
    String str;
    switch (paramInt)
    {
    default: 
      str = "unknown";
    }
    for (;;)
    {
      paramCalendarResult.detailMsg = str;
      paramCalendarResult.detailCode = paramInt;
      paramCalendarResult.code = 6;
      paramCalendarResult.msg = ("handleMeetingResponseStatus, status: " + paramInt + ", msg: " + str);
      return false;
      str = "Invalid meeting request.";
      continue;
      str = "An error occurred on the server mailbox.";
      continue;
      str = "An error occurred on the server.";
    }
  }
  
  private static void handlePolicyKeyResult(Document paramDocument, CalendarInfo paramCalendarInfo, CalendarResult paramCalendarResult, boolean paramBoolean)
  {
    if (!checkResponseXmlDoc(paramDocument, paramCalendarResult)) {}
    do
    {
      do
      {
        return;
        paramCalendarResult = getProtocolResult(paramCalendarInfo, paramCalendarResult);
      } while (((isNodeExist(paramDocument, "Provision", "Status")) && (!handleCommonProvisionStatus(getChildIntContent(paramDocument, "Provision", "Status"), paramCalendarResult))) || ((isNodeExist(paramDocument, "Policy", "airsync:Status")) && (!handleProvisionStatus(getChildIntContent(paramDocument, "Policy", "airsync:Status"), paramCalendarResult))) || ((isNodeExist(paramDocument, "Policy", "Status")) && (!handleProvisionStatus(getChildIntContent(paramDocument, "Policy", "Status"), paramCalendarResult))));
      if (!isNodeExist(paramDocument, "Policy", "PolicyKey"))
      {
        paramCalendarResult.code = 6;
        paramCalendarResult.msg = "handlePolicyKeyResult, PolicyKey tag not exist";
        return;
      }
      paramDocument = getChildText(paramDocument, "Policy", "PolicyKey");
      paramCalendarInfo.activeSyncInfo.setActiveSyncPolicyKey(paramDocument);
      paramCalendarResult.activeSyncResult.policyKey = paramDocument;
    } while (paramBoolean);
    paramCalendarResult.activeSyncResult.errorCode = 7;
  }
  
  private static boolean handleProvisionStatus(int paramInt, CalendarResult paramCalendarResult)
  {
    if (paramInt == 1) {
      return true;
    }
    String str;
    switch (paramInt)
    {
    default: 
      str = "unknown";
    }
    for (;;)
    {
      paramCalendarResult.detailMsg = str;
      paramCalendarResult.detailCode = paramInt;
      paramCalendarResult.code = 6;
      paramCalendarResult.msg = ("handleProvisionStatus, status: " + paramInt + ", msg: " + str);
      return false;
      str = "Policy not defined.";
      continue;
      str = "The policy type is unknown.";
      continue;
      str = "Policy data is corrupt.";
      continue;
      str = "￼The client is trying to acknowledge an out-of-date or invalid policy.";
    }
  }
  
  private static void handleRemoveCalendarResult(Document paramDocument, CalendarInfo paramCalendarInfo, CalendarResult paramCalendarResult)
  {
    handleCommonSyncResult(paramDocument, paramCalendarInfo, paramCalendarResult);
  }
  
  private static void handleResponse(QMNetworkResponse paramQMNetworkResponse, Document paramDocument, CalendarInfo paramCalendarInfo, int paramInt, CalendarResult paramCalendarResult, CalendarCallback paramCalendarCallback)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if ((!redirect(paramQMNetworkResponse, paramCalendarInfo, paramInt, paramCalendarResult, paramCalendarCallback)) && (paramCalendarCallback != null)) {
        paramCalendarCallback.onResult(paramCalendarResult);
      }
      return;
      handleLoadFolderListResult(paramDocument, paramCalendarInfo, paramCalendarResult);
      continue;
      handleLoadCalendarListResult(paramDocument, paramCalendarInfo, paramCalendarResult, true);
      continue;
      handleLoadCalendarListResult(paramDocument, paramCalendarInfo, paramCalendarResult, false);
      if (paramCalendarResult.activeSyncResult.errorCode == 2)
      {
        QMLog.log(4, "CalendarActiveSyncService", "load calendarList sync again");
        loadCalendarEventList(paramCalendarInfo, paramCalendarCallback);
        continue;
        handlePolicyKeyResult(paramDocument, paramCalendarInfo, paramCalendarResult, false);
        continue;
        handlePolicyKeyResult(paramDocument, paramCalendarInfo, paramCalendarResult, true);
        continue;
        handleAddCalendarResult(paramDocument, paramCalendarInfo, paramCalendarResult);
        continue;
        handleRemoveCalendarResult(paramDocument, paramCalendarInfo, paramCalendarResult);
        continue;
        handleUpdateCalendarResult(paramDocument, paramCalendarInfo, paramCalendarResult);
        continue;
        handleMeetingResponseResult(paramDocument, paramCalendarInfo, paramCalendarResult);
        continue;
        handleFolderCreateResult(paramDocument, paramCalendarInfo, paramCalendarResult);
        continue;
        handleFolderUpdateResult(paramDocument, paramCalendarInfo, paramCalendarResult);
        continue;
        handleFolderDeleteResult(paramDocument, paramCalendarInfo, paramCalendarResult);
      }
    }
  }
  
  private static boolean handleSyncStatus(int paramInt, CalendarResult paramCalendarResult)
  {
    if (paramInt == 1) {
      return true;
    }
    String str;
    switch (paramInt)
    {
    case 10: 
    case 11: 
    default: 
      str = "unknown";
    }
    for (;;)
    {
      paramCalendarResult.detailMsg = str;
      paramCalendarResult.detailCode = paramInt;
      paramCalendarResult.code = 6;
      paramCalendarResult.msg = ("handleSyncStatus, status: " + paramInt + ", msg: " + str);
      return false;
      str = "Invalid synchronization key.";
      paramCalendarResult.activeSyncResult.errorCode = 5;
      continue;
      str = "Protocol error.";
      continue;
      str = "Server error.";
      continue;
      str = "Error in client/server conversion.";
      continue;
      str = "Conflict matching the client and server object.";
      continue;
      str = "Object not found.";
      continue;
      str = "The Sync command cannot be completed.";
      continue;
      str = "The folder hierarchy has changed.";
      paramCalendarResult.activeSyncResult.errorCode = 9;
      continue;
      str = "The Sync command request is not complete.";
      continue;
      str = "Invalid Wait or HeartbeatInterval value.";
      continue;
      str = "Invalid Sync command request.";
      continue;
      str = "Retry, Something on the server caused a retriable error.";
    }
  }
  
  private static void handleUpdateCalendarResult(Document paramDocument, CalendarInfo paramCalendarInfo, CalendarResult paramCalendarResult)
  {
    handleCommonSyncResult(paramDocument, paramCalendarInfo, paramCalendarResult);
  }
  
  private static boolean isNodeExist(Document paramDocument, String paramString)
  {
    return paramDocument.getElementsByTagName(paramString).getLength() > 0;
  }
  
  private static boolean isNodeExist(Document paramDocument, String paramString1, String paramString2)
  {
    paramDocument = paramDocument.getElementsByTagName(paramString1);
    if (paramDocument.getLength() == 0) {}
    while (getChildNode(paramDocument.item(0), paramString2) == null) {
      return false;
    }
    return true;
  }
  
  public static void loadCalendarEventList(CalendarInfo paramCalendarInfo, CalendarCallback paramCalendarCallback)
  {
    byte[] arrayOfByte;
    if ("0".equals(paramCalendarInfo.activeSyncInfo.syncInfo.syncKey)) {
      arrayOfByte = buildInitFolder(paramCalendarInfo);
    }
    for (int i = 1;; i = 6)
    {
      QMLog.log(4, "CalendarActiveSyncService", "loadCalendarEventList, email: " + paramCalendarInfo.email + ", cmdType: " + i);
      sendRequest("[loadCalendarEventList--" + paramCalendarInfo.email + "]", paramCalendarInfo, "Sync", i, arrayOfByte, null, paramCalendarCallback);
      return;
      arrayOfByte = buildLoadCalendarEventList(paramCalendarInfo);
    }
  }
  
  public static void loadFolderList(CalendarInfo paramCalendarInfo, CalendarCallback paramCalendarCallback)
  {
    QMLog.log(4, "CalendarActiveSyncService", "loadFolderList, email: " + paramCalendarInfo.email);
    byte[] arrayOfByte = buildLoadFolderList(paramCalendarInfo);
    sendRequest("[loadFolderList--" + paramCalendarInfo.email + "]", paramCalendarInfo, "FolderSync", 2, arrayOfByte, null, paramCalendarCallback);
  }
  
  public static void login(CalendarInfo paramCalendarInfo, CalendarCallback paramCalendarCallback)
  {
    QMLog.log(4, "CalendarActiveSyncService", "login, email: " + paramCalendarInfo.email);
    QMNetworkRequest localQMNetworkRequest = new QMNetworkRequest(getUrl(paramCalendarInfo, "OPTIONS"), QMNetworkRequest.QMHttpMethod.QMHttpMethod_OPTIONS);
    localQMNetworkRequest.setRequestHeaders(getHeaders(paramCalendarInfo, 0, "OPTIONS"));
    QMCallback localQMCallback = new QMCallback();
    CalendarResult localCalendarResult = getProtocolResult(paramCalendarInfo, null);
    localQMCallback.setOnSuccess(new CalendarActiveSyncService.1(paramCalendarInfo, localCalendarResult, paramCalendarCallback));
    localQMCallback.setOnError(new CalendarActiveSyncService.2(localCalendarResult, paramCalendarCallback));
    localQMNetworkRequest.setRequestCallback(localQMCallback);
    QMHttpUtil.asyncSend(localQMNetworkRequest);
  }
  
  private static void parseCalendar(Node paramNode, CCalendar paramCCalendar)
  {
    if ((paramNode == null) || (paramNode.getChildNodes().getLength() == 0)) {
      return;
    }
    localNode3 = paramNode.getChildNodes().item(0);
    localStringBuilder = new StringBuilder("parseCalendar");
    long l2 = 0L;
    l1 = l2;
    Node localNode1 = localNode3;
    if ((paramNode instanceof Element))
    {
      paramNode = ((Element)paramNode).getElementsByTagName("calendar:TimeZone");
      l1 = l2;
      localNode1 = localNode3;
      if (paramNode != null)
      {
        l1 = l2;
        localNode1 = localNode3;
        if (paramNode.getLength() > 0)
        {
          paramNode = paramNode.item(0).getTextContent();
          l1 = l2;
        }
      }
    }
    for (;;)
    {
      try
      {
        i = (ByteConvert.bytesToIntLE(StringExtention.decode(paramNode)) + 960) * 60;
        l1 = l2;
        localStringBuilder.append(", TimeZone: ").append(i);
        l2 = i;
        l1 = l2;
        paramCCalendar.time_zone_ = String.valueOf(i);
        localNode1 = localNode3;
        l1 = l2;
      }
      catch (Exception localException)
      {
        QMLog.log(5, "CalendarActiveSyncService", "get TimeZone failed: " + paramNode, localException);
        Node localNode2 = localNode3;
        continue;
        if (!paramNode.equals("calendar:DtStamp")) {
          continue;
        }
        int i = 0;
        continue;
        if (!paramNode.equals("calendar:StartTime")) {
          continue;
        }
        i = 1;
        continue;
        if (!paramNode.equals("calendar:Subject")) {
          continue;
        }
        i = 2;
        continue;
        if (!paramNode.equals("UNKNOWN_TAG_2A")) {
          continue;
        }
        i = 3;
        continue;
        if (!paramNode.equals("calendar:QQRelativeId")) {
          continue;
        }
        i = 4;
        continue;
        if (!paramNode.equals("calendar:UID")) {
          continue;
        }
        i = 5;
        continue;
        if (!paramNode.equals("calendar:OrganizerName")) {
          continue;
        }
        i = 6;
        continue;
        if (!paramNode.equals("calendar:OrganizerEmail")) {
          continue;
        }
        i = 7;
        continue;
        if (!paramNode.equals("calendar:Categories")) {
          continue;
        }
        i = 8;
        continue;
        if (!paramNode.equals("calendar:Attendees")) {
          continue;
        }
        i = 9;
        continue;
        if (!paramNode.equals("calendar:Location")) {
          continue;
        }
        i = 10;
        continue;
        if (!paramNode.equals("calendar:EndTime")) {
          continue;
        }
        i = 11;
        continue;
        if (!paramNode.equals("calendar:AppointmentReplyTime")) {
          continue;
        }
        i = 12;
        continue;
        if (!paramNode.equals("calendar:Recurrence")) {
          continue;
        }
        i = 13;
        continue;
        if (!paramNode.equals("calendar:QQCalendarType")) {
          continue;
        }
        i = 14;
        continue;
        if (!paramNode.equals("airsyncbase:Body")) {
          continue;
        }
        i = 15;
        continue;
        if (!paramNode.equals("calendar:Sensitivity")) {
          continue;
        }
        i = 16;
        continue;
        if (!paramNode.equals("calendar:BusyStatus")) {
          continue;
        }
        i = 17;
        continue;
        if (!paramNode.equals("calendar:AllDayEvent")) {
          continue;
        }
        i = 18;
        continue;
        if (!paramNode.equals("calendar:Reminder")) {
          continue;
        }
        i = 19;
        continue;
        if (!paramNode.equals("calendar:Exceptions")) {
          continue;
        }
        i = 20;
        continue;
        if (!paramNode.equals("calendar:MeetingStatus")) {
          continue;
        }
        i = 21;
        continue;
        if (!paramNode.equals("calendar:NativeBodyType")) {
          continue;
        }
        i = 22;
        continue;
        if (!paramNode.equals("calendar:ResponseRequested")) {
          continue;
        }
        i = 23;
        continue;
        if (!paramNode.equals("calendar:ResponseType")) {
          continue;
        }
        i = 24;
        continue;
        paramCCalendar.dt_stamp = getTimeInSeconds(localNode2.getTextContent(), l1);
        paramCCalendar.create_time = paramCCalendar.dt_stamp;
        paramCCalendar.modified_time = paramCCalendar.dt_stamp;
        localStringBuilder.append(", DtStamp: ").append(paramCCalendar.dt_stamp);
        continue;
        paramCCalendar.start_time = getTimeInSeconds(localNode2.getTextContent(), l1);
        localStringBuilder.append(", StartTime: ").append(paramCCalendar.start_time);
        continue;
        paramCCalendar.subject = localNode2.getTextContent();
        localStringBuilder.append(", Subject: ").append(paramCCalendar.subject);
        continue;
        paramCCalendar.relative_id = localNode2.getTextContent();
        localStringBuilder.append(", QQRelativeId: ").append(paramCCalendar.relative_id);
        continue;
        paramCCalendar.uid = localNode2.getTextContent();
        localStringBuilder.append(", UID: ").append(paramCCalendar.uid);
        continue;
        paramCCalendar.organizer_name = localNode2.getTextContent();
        localStringBuilder.append(", OrganizerName: ").append(paramCCalendar.organizer_name);
        continue;
        paramCCalendar.organizer_email = localNode2.getTextContent();
        localStringBuilder.append(", OrganizerEmail: ").append(paramCCalendar.organizer_email);
        continue;
        if (localNode2.getChildNodes().getLength() <= 0) {
          continue;
        }
        paramNode = localNode2.getChildNodes().item(0);
        if (paramNode == null) {
          continue;
        }
        if (!"calendar:Category".equals(paramNode.getNodeName())) {
          continue;
        }
        paramCCalendar.categories.add(paramNode.getTextContent());
        paramNode = paramNode.getNextSibling();
        continue;
        localStringBuilder.append(", Categories: ").append(paramCCalendar.categories);
        continue;
        if (localNode2.getChildNodes().getLength() <= 0) {
          continue;
        }
        paramNode = localNode2.getChildNodes().item(0);
        if (paramNode == null) {
          continue;
        }
        if (!"calendar:Attendee".equals(paramNode.getNodeName())) {
          continue;
        }
        paramCCalendar.attendees.add(getAttendee(paramNode));
        paramNode = paramNode.getNextSibling();
        continue;
        localStringBuilder.append(", Attendees: ").append(paramCCalendar.attendees.size());
        continue;
        paramCCalendar.location = localNode2.getTextContent();
        localStringBuilder.append(", Location: ").append(paramCCalendar.location);
        continue;
        paramCCalendar.end_time = getTimeInSeconds(localNode2.getTextContent(), l1);
        localStringBuilder.append(", EndTime: ").append(paramCCalendar.end_time);
        continue;
        paramCCalendar.appointment_replytime = getTimeInSeconds(localNode2.getTextContent(), l1);
        localStringBuilder.append(", EndTime: ").append(paramCCalendar.appointment_replytime);
        continue;
        paramCCalendar.recurrence = getRecurrence(localNode2, l1);
        localStringBuilder.append(", Recurrence: ").append(paramCCalendar.recurrence.type);
        continue;
        paramCCalendar.calendar_type = getIntContent(localNode2);
        localStringBuilder.append(", QQCalendarType: ").append(paramCCalendar.calendar_type);
        continue;
        paramCCalendar.body = getChildText(localNode2, "airsyncbase:Data");
        localStringBuilder.append(", Body: ").append(paramCCalendar.body);
        continue;
        paramCCalendar.sensitivity = getIntContent(localNode2);
        localStringBuilder.append(", Sensitivity: ").append(paramCCalendar.sensitivity);
        continue;
        paramCCalendar.busy_status = getIntContent(localNode2);
        localStringBuilder.append(", BusyStatus: ").append(paramCCalendar.busy_status);
        continue;
        paramCCalendar.allday_event = "1".equals(localNode2.getTextContent());
        localStringBuilder.append(", AllDayEvent: ").append(paramCCalendar.allday_event);
        continue;
        paramCCalendar.reminder = getLongContent(localNode2);
        localStringBuilder.append(", Reminder: ").append(paramCCalendar.reminder);
        continue;
        if (localNode2.getChildNodes().getLength() <= 0) {
          continue;
        }
        paramNode = localNode2.getChildNodes().item(0);
        if (paramNode == null) {
          continue;
        }
        if (!"calendar:Exception".equals(paramNode.getNodeName())) {
          continue;
        }
        paramCCalendar.exceptions.add(getException(paramNode, paramCCalendar, l1));
        paramNode = paramNode.getNextSibling();
        continue;
        localStringBuilder.append(", Exceptions: ").append(paramCCalendar.exceptions.size());
        continue;
        paramCCalendar.meeting_status = getIntContent(localNode2);
        localStringBuilder.append(", MeetingStatus: ").append(paramCCalendar.meeting_status);
        continue;
        paramCCalendar.native_body_type = getIntContent(localNode2);
        localStringBuilder.append(", NativeBodyType: ").append(paramCCalendar.native_body_type);
        continue;
        paramCCalendar.response_requested = "1".equals(localNode2.getTextContent());
        localStringBuilder.append(", ResponseRequested: ").append(paramCCalendar.response_requested);
        continue;
        paramCCalendar.response_type = getIntContent(localNode2);
        localStringBuilder.append(", ResponseType: ").append(paramCCalendar.response_type);
        continue;
      }
      if (localNode1 == null) {
        break;
      }
      paramNode = localNode1.getNodeName();
      i = -1;
      switch (paramNode.hashCode())
      {
      default: 
        switch (i)
        {
        default: 
          localNode1 = localNode1.getNextSibling();
        }
        break;
      }
    }
  }
  
  private static void printXml(String paramString1, String paramString2) {}
  
  private static boolean redirect(CalendarInfo paramCalendarInfo, int paramInt, CalendarResult paramCalendarResult, CalendarCallback paramCalendarCallback)
  {
    boolean bool = false;
    QMLog.log(4, "CalendarActiveSyncService", "redirect, cmdType: " + paramInt);
    byte[] arrayOfByte = null;
    String str;
    switch (paramInt)
    {
    case 3: 
    case 4: 
    case 5: 
    default: 
      str = "";
    }
    for (;;)
    {
      if (arrayOfByte != null)
      {
        paramCalendarResult.activeSyncResult.errorCode = 0;
        sendRequest("[redirect_" + str + "_" + paramInt + "_" + paramCalendarInfo.email + "]", paramCalendarInfo, str, paramInt, arrayOfByte, paramCalendarResult, paramCalendarCallback);
        bool = true;
      }
      return bool;
      str = "FolderSync";
      arrayOfByte = buildLoadFolderList(paramCalendarInfo);
      continue;
      str = "Sync";
      arrayOfByte = buildInitFolder(paramCalendarInfo);
      continue;
      str = "Sync";
      arrayOfByte = buildLoadCalendarEventList(paramCalendarInfo);
      continue;
      str = "";
      continue;
      str = "";
      continue;
      str = "Provision";
      arrayOfByte = buildPolicyKey(paramCalendarInfo);
      continue;
      str = "Provision";
      arrayOfByte = buildPolicyKeyAck(paramCalendarInfo);
    }
  }
  
  private static boolean redirect(QMNetworkResponse paramQMNetworkResponse, CalendarInfo paramCalendarInfo, int paramInt, CalendarResult paramCalendarResult, CalendarCallback paramCalendarCallback)
  {
    paramInt = getNextCmdType(paramQMNetworkResponse, paramCalendarInfo, paramInt, paramCalendarResult);
    if (paramInt != 0) {
      return redirect(paramCalendarInfo, paramInt, paramCalendarResult, paramCalendarCallback);
    }
    return false;
  }
  
  public static void removeEvent(CalendarInfo paramCalendarInfo, CalendarCallback paramCalendarCallback)
  {
    QMLog.log(4, "CalendarActiveSyncService", "removeEvent, email: " + paramCalendarInfo.email);
    byte[] arrayOfByte = buildRemoveEvent(paramCalendarInfo);
    sendRequest("[removeEvent--" + paramCalendarInfo.email + "]", paramCalendarInfo, "Sync", 4, arrayOfByte, null, paramCalendarCallback);
  }
  
  public static void responseCalendarEvent(CalendarInfo paramCalendarInfo, CalendarCallback paramCalendarCallback)
  {
    QMLog.log(4, "CalendarActiveSyncService", "responseCalendarEvent, email: " + paramCalendarInfo.email);
    byte[] arrayOfByte = buildMeetingResponse(paramCalendarInfo);
    sendRequest("[responseCalendarEvent--" + paramCalendarInfo.email + "]", paramCalendarInfo, "MeetingResponse", 11, arrayOfByte, null, paramCalendarCallback);
  }
  
  private static void sendRequest(String paramString1, CalendarInfo paramCalendarInfo, String paramString2, int paramInt, byte[] paramArrayOfByte, CalendarResult paramCalendarResult, CalendarCallback paramCalendarCallback)
  {
    QMNetworkRequest localQMNetworkRequest = new QMNetworkRequest(getUrl(paramCalendarInfo, paramString2), QMNetworkRequest.QMHttpMethod.QMHttpMethod_POST);
    if (paramArrayOfByte == null) {}
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      localQMNetworkRequest.setRequestHeaders(getHeaders(paramCalendarInfo, i, paramString2));
      if (paramArrayOfByte != null) {
        localQMNetworkRequest.setRequestData(paramArrayOfByte);
      }
      localQMNetworkRequest.setRawResponse(true);
      paramArrayOfByte = new QMCallback();
      paramCalendarResult = getProtocolResult(paramCalendarInfo, paramCalendarResult);
      paramArrayOfByte.setOnSuccess(new CalendarActiveSyncService.3(paramString1, paramCalendarInfo, paramInt, paramCalendarResult, paramCalendarCallback));
      paramArrayOfByte.setOnError(new CalendarActiveSyncService.4(paramString1, paramCalendarInfo, paramInt, paramCalendarResult, paramCalendarCallback, paramString2));
      localQMNetworkRequest.setRequestCallback(paramArrayOfByte);
      QMHttpUtil.asyncSend(localQMNetworkRequest);
      return;
    }
  }
  
  public static void updateCalendarFolder(CalendarInfo paramCalendarInfo, CalendarCallback paramCalendarCallback)
  {
    QMLog.log(4, "CalendarActiveSyncService", "updateCalendarFolder, email: " + paramCalendarInfo.email);
    byte[] arrayOfByte = buildUpdateCalendarFolder(paramCalendarInfo);
    sendRequest("[updateCalendarFolder--" + paramCalendarInfo.email + "]", paramCalendarInfo, "FolderUpdate", 13, arrayOfByte, null, paramCalendarCallback);
  }
  
  public static void updateEvent(CalendarInfo paramCalendarInfo, CalendarCallback paramCalendarCallback)
  {
    QMLog.log(4, "CalendarActiveSyncService", "updateEvent, email: " + paramCalendarInfo.email);
    byte[] arrayOfByte = buildUpdateEvent(paramCalendarInfo);
    sendRequest("updateEvent--" + paramCalendarInfo.email, paramCalendarInfo, "Sync", 5, arrayOfByte, null, paramCalendarCallback);
  }
  
  private static byte[] xml2Bytes(String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("===== encode xml =====\n");
      localStringBuilder.append("len: ").append(paramString.length()).append("\n");
      long l = System.nanoTime();
      ASWBXML localASWBXML = new ASWBXML();
      localASWBXML.loadXml(paramString);
      localStringBuilder.append("loadXml => ").append(elpasedInMillis(l)).append("ms\n");
      l = System.nanoTime();
      paramString = localASWBXML.getBytes();
      QMLog.log(6, "CalendarActiveSyncService", "xml to bytes failed", localException1);
    }
    catch (Exception localException1)
    {
      try
      {
        localStringBuilder.append("getBytes => ").append(elpasedInMillis(l)).append("ms\n");
        localStringBuilder.append("===== encode xml done =====");
        QMLog.log(2, "CalendarActiveSyncService", localStringBuilder.toString());
        return paramString;
      }
      catch (Exception localException2)
      {
        break label126;
      }
      localException1 = localException1;
      paramString = null;
    }
    label126:
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.calendar.CalendarActiveSyncService
 * JD-Core Version:    0.7.0.1
 */