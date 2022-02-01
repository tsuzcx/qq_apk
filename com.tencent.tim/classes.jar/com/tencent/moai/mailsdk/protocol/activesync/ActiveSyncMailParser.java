package com.tencent.moai.mailsdk.protocol.activesync;

import com.tencent.moai.mailsdk.model.Attachment;
import com.tencent.moai.mailsdk.model.Calendar;
import com.tencent.moai.mailsdk.model.Contact;
import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.model.Recurrence;
import com.tencent.moai.mailsdk.protocol.mime.model.MimeAddress;
import com.tencent.moai.mailsdk.protocol.model.Address;
import com.tencent.moai.mailsdk.util.MimeUtility;
import com.tencent.moai.mailsdk.util.StringUtility;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;
import com.tencent.moai.mailsdk.util.log.Logger;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ActiveSyncMailParser
{
  private static final String TAG = "ActiveSyncMailParser";
  
  private static int bytesToIntLE(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[0] & 0xFF | (paramArrayOfByte[1] & 0xFF) << 8 | (paramArrayOfByte[2] & 0xFF) << 16 | (paramArrayOfByte[3] & 0xFF) << 24;
  }
  
  private static Calendar getCalendar(Node paramNode)
  {
    Calendar localCalendar = new Calendar();
    localCalendar.setUid(XmlDocumentHelper.getChildText(paramNode, "email:GlobalObjId"));
    if (StringUtility.isNullOrEmpty(localCalendar.getUid())) {
      localCalendar.setUid(XmlDocumentHelper.getChildText(paramNode, "calendar:UID"));
    }
    localCalendar.setLocation(XmlDocumentHelper.getChildText(paramNode, "email:Location"));
    if (StringUtility.isNullOrEmpty(localCalendar.getLocation())) {
      localCalendar.setLocation(XmlDocumentHelper.getChildText(paramNode, "airsyncbase:Location"));
    }
    String str = XmlDocumentHelper.getChildText(paramNode, "email:TimeZone");
    l2 = 0L;
    l1 = l2;
    if (str != null) {}
    try
    {
      int i = (bytesToIntLE(MimeUtility.decode(str.getBytes(), "base64")) + 960) * 60;
      localCalendar.setTimeZone(String.valueOf(i));
      l1 = i;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Logger.log(6, "ActiveSyncMailParser", "");
        l1 = l2;
      }
    }
    localCalendar.setStartTime(getTimeInSeconds(XmlDocumentHelper.getChildText(paramNode, "email:StartTime"), l1));
    localCalendar.setDtStamp(getTimeInSeconds(XmlDocumentHelper.getChildText(paramNode, "email:DtStamp"), l1));
    localCalendar.setEndTime(getTimeInSeconds(XmlDocumentHelper.getChildText(paramNode, "email:EndTime"), l1));
    localCalendar.setAllDayEvent("1".equals(XmlDocumentHelper.getChildText(paramNode, "email:AllDayEvent")));
    localCalendar.setOrganizer(XmlDocumentHelper.getChildText(paramNode, "email:Organizer"));
    localCalendar.setSubject(XmlDocumentHelper.getChildText(paramNode, "email:Subject"));
    localCalendar.setReminder(XmlDocumentHelper.getChildIntContent(paramNode, "email:Reminder"));
    localCalendar.setSensitivity(XmlDocumentHelper.getChildIntContent(paramNode, "email:Sensitivity"));
    localCalendar.setBusyStatus(XmlDocumentHelper.getChildIntContent(paramNode, "email:BusyStatus"));
    localCalendar.setResponseRequested("1".equals(XmlDocumentHelper.getChildText(paramNode, "email:ResponseRequested")));
    localCalendar.setRecurrence(getRecurrence(XmlDocumentHelper.getChildNode(paramNode, "email:Recurrence"), l1));
    return localCalendar;
  }
  
  public static Mail getMail(Node paramNode)
  {
    Mail localMail = new Mail();
    Object localObject1 = MimeAddress.parseAddresses(XmlDocumentHelper.getChildText(paramNode, "email:To"));
    Object localObject2;
    int j;
    int i;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = new ArrayList();
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        localObject3 = localObject1[i];
        ((ArrayList)localObject2).add(new Contact(localObject3.getEmail(), localObject3.getNick()));
        i += 1;
      }
      localMail.setTo((ArrayList)localObject2);
    }
    localObject1 = MimeAddress.parseAddresses(XmlDocumentHelper.getChildText(paramNode, "email:Cc"));
    if (localObject1 != null)
    {
      localObject2 = new ArrayList();
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        localObject3 = localObject1[i];
        ((ArrayList)localObject2).add(new Contact(localObject3.getEmail(), localObject3.getNick()));
        i += 1;
      }
      localMail.setCc((ArrayList)localObject2);
    }
    localObject1 = MimeAddress.parseAddresses(XmlDocumentHelper.getChildText(paramNode, "email:Bcc"));
    if (localObject1 != null)
    {
      localObject2 = new ArrayList();
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        localObject3 = localObject1[i];
        ((ArrayList)localObject2).add(new Contact(localObject3.getEmail(), localObject3.getNick()));
        i += 1;
      }
      localMail.setBcc((ArrayList)localObject2);
    }
    localObject1 = MimeAddress.parseAddresses(XmlDocumentHelper.getChildText(paramNode, "email:From"));
    if ((localObject1 != null) && (localObject1.length < 0))
    {
      localObject1 = localObject1[0];
      localMail.setFrom(new Contact(((Address)localObject1).getEmail(), ((Address)localObject1).getNick()));
    }
    localObject1 = MimeAddress.parseAddresses(XmlDocumentHelper.getChildText(paramNode, "email:Sender"));
    if ((localObject1 != null) && (localObject1.length < 0))
    {
      localObject1 = localObject1[0];
      localMail.setSender(new Contact(((Address)localObject1).getEmail(), ((Address)localObject1).getNick()));
    }
    localObject1 = XmlDocumentHelper.getChildText(paramNode, "email:Subject");
    if (localObject1 != null) {
      localMail.setSubject((String)localObject1);
    }
    localObject1 = XmlDocumentHelper.getChildText(paramNode, "email:DateReceived");
    long l = 0L;
    if (localObject1 != null) {
      l = getTimeInSeconds((String)localObject1);
    }
    localMail.setUtc(l);
    localObject1 = XmlDocumentHelper.getChildText(paramNode, "email:Read");
    if (localObject1 != null) {
      localMail.setIsRead("1".equals(localObject1));
    }
    localObject1 = XmlDocumentHelper.getChildNode(paramNode, "email:Flag");
    if (localObject1 != null) {
      if (XmlDocumentHelper.getChildIntContent((Node)localObject1, "email:Status") != 2) {
        break label589;
      }
    }
    label589:
    for (boolean bool = true;; bool = false)
    {
      localMail.setIsStar(bool);
      localObject1 = XmlDocumentHelper.getChildNode(paramNode, "airsyncbase:Body");
      if (localObject1 != null)
      {
        localObject2 = XmlDocumentHelper.getChildText((Node)localObject1, "airsyncbase:EstimatedDataSize");
        if (localObject2 != null) {
          localMail.setSize(Long.valueOf((String)localObject2).longValue());
        }
        localObject1 = XmlDocumentHelper.getChildText((Node)localObject1, "airsyncbase:Data");
        if (localObject1 != null)
        {
          localMail.setPlainContent((String)localObject1);
          localMail.setHtmlContent((String)localObject1);
        }
      }
      localObject2 = XmlDocumentHelper.getChildNode(paramNode, "airsyncbase:Attachments");
      if (localObject2 == null) {
        break label602;
      }
      localObject1 = new ArrayList();
      localObject2 = XmlDocumentHelper.getChildNodes((Node)localObject2, "airsyncbase:Attachment").iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add(getMailAttach((Node)((Iterator)localObject2).next()));
      }
    }
    localMail.setAttachments((ArrayList)localObject1);
    label602:
    paramNode = XmlDocumentHelper.getChildNode(paramNode, "email:MeetingRequest");
    if (paramNode != null)
    {
      paramNode = getCalendar(paramNode);
      if (paramNode != null)
      {
        if (StringUtility.isNullOrEmpty(paramNode.getSubject())) {
          paramNode.setSubject(localMail.getSubject());
        }
        localMail.setCalendar(paramNode);
      }
    }
    return localMail;
  }
  
  private static Attachment getMailAttach(Node paramNode)
  {
    Attachment localAttachment = new Attachment();
    String str = XmlDocumentHelper.getChildText(paramNode, "airsyncbase:DisplayName");
    if (str != null) {
      localAttachment.setName(str);
    }
    str = XmlDocumentHelper.getChildText(paramNode, "airsyncbase:FileReference");
    if (str != null) {
      localAttachment.setFid(str);
    }
    str = XmlDocumentHelper.getChildText(paramNode, "airsyncbase:EstimatedDataSize");
    if (str != null) {
      localAttachment.setSize(Long.parseLong(str.trim()));
    }
    str = XmlDocumentHelper.getChildText(paramNode, "airsyncbase:ContentId");
    if (str != null) {
      localAttachment.setCid(str);
    }
    str = XmlDocumentHelper.getChildText(paramNode, "airsyncbase:Method");
    paramNode = XmlDocumentHelper.getChildText(paramNode, "airsyncbase:IsInline");
    if (((paramNode != null) && ("1".equals(paramNode))) || ((str != null) && ("6".equals(str))))
    {
      localAttachment.setType("inline");
      return localAttachment;
    }
    localAttachment.setType("attachment");
    return localAttachment;
  }
  
  private static Recurrence getRecurrence(Node paramNode, long paramLong)
  {
    Object localObject = null;
    if (paramNode == null) {}
    Recurrence localRecurrence;
    do
    {
      do
      {
        return localObject;
      } while (paramNode.getChildNodes().getLength() == 0);
      localRecurrence = new Recurrence();
      paramNode = paramNode.getChildNodes().item(0);
      localObject = localRecurrence;
    } while (paramNode == null);
    localObject = paramNode.getNodeName();
    int i = -1;
    switch (((String)localObject).hashCode())
    {
    default: 
      label168:
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      paramNode = paramNode.getNextSibling();
      break;
      if (!((String)localObject).equals("calendar:Type")) {
        break label168;
      }
      i = 0;
      break label168;
      if (!((String)localObject).equals("calendar:Until")) {
        break label168;
      }
      i = 1;
      break label168;
      if (!((String)localObject).equals("calendar:Occurrences")) {
        break label168;
      }
      i = 2;
      break label168;
      if (!((String)localObject).equals("calendar:Interval")) {
        break label168;
      }
      i = 3;
      break label168;
      if (!((String)localObject).equals("calendar:CalendarType")) {
        break label168;
      }
      i = 4;
      break label168;
      if (!((String)localObject).equals("calendar:DayOfWeek")) {
        break label168;
      }
      i = 5;
      break label168;
      if (!((String)localObject).equals("calendar:DayOfMonth")) {
        break label168;
      }
      i = 6;
      break label168;
      if (!((String)localObject).equals("calendar:WeekOfMonth")) {
        break label168;
      }
      i = 7;
      break label168;
      if (!((String)localObject).equals("calendar:MonthOfYear")) {
        break label168;
      }
      i = 8;
      break label168;
      if (!((String)localObject).equals("calendar:IsLeapMonth")) {
        break label168;
      }
      i = 9;
      break label168;
      if (!((String)localObject).equals("calendar:FirstDayOfWeek")) {
        break label168;
      }
      i = 10;
      break label168;
      localRecurrence.setType(XmlDocumentHelper.getIntContent(paramNode));
      continue;
      localRecurrence.setUntil(getTimeInSeconds(paramNode.getTextContent(), paramLong));
      continue;
      localRecurrence.setOccurrences(XmlDocumentHelper.getLongContent(paramNode));
      continue;
      localRecurrence.setInterval(XmlDocumentHelper.getLongContent(paramNode));
      continue;
      localRecurrence.setCalendar_type(XmlDocumentHelper.getIntContent(paramNode));
      continue;
      localRecurrence.setDay_of_week(XmlDocumentHelper.getLongContent(paramNode));
      continue;
      localRecurrence.setDay_of_month(XmlDocumentHelper.getLongContent(paramNode));
      continue;
      localRecurrence.setWeek_of_month(XmlDocumentHelper.getLongContent(paramNode));
      continue;
      localRecurrence.setMonth_of_year(XmlDocumentHelper.getLongContent(paramNode));
      continue;
      localRecurrence.setIs_leap_month("1".equals(paramNode.getTextContent()));
      continue;
      localRecurrence.setFirst_day_of_week(XmlDocumentHelper.getIntContent(paramNode));
    }
  }
  
  private static long getTimeInSeconds(String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    try
    {
      long l = localSimpleDateFormat.parse(paramString).getTime();
      return l;
    }
    catch (Exception localException)
    {
      Logger.log(6, "ActiveSyncMailParser", "parse time error " + paramString + " " + localException.getMessage());
    }
    return 0L;
  }
  
  private static long getTimeInSeconds(String paramString, long paramLong)
  {
    Object localObject = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());
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
      Logger.log(5, "ActiveSyncMailParser", "getTimeinSeconds failed: " + paramString);
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.ActiveSyncMailParser
 * JD-Core Version:    0.7.0.1
 */