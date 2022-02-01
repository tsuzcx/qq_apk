package com.tencent.qqmail.protocol.aswbxml;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Stack;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class ASWBXML
{
  static final byte characterSetByte = 106;
  static final byte publicIdentifierByte = 1;
  static final byte stringTableLengthByte = 0;
  static final byte versionByte = 3;
  private ASWBXMLCodePage[] codePages = new ASWBXMLCodePage[25];
  private int currentCodePage = 0;
  private int defaultCodePage = -1;
  private Document xmlDoc;
  
  public ASWBXML()
    throws Exception
  {
    this.codePages[0] = new ASWBXMLCodePage();
    this.codePages[0].setNamespace("AirSync");
    this.codePages[0].setXmlns("airsync");
    this.codePages[0].addToken((byte)5, "Sync");
    this.codePages[0].addToken((byte)6, "Responses");
    this.codePages[0].addToken((byte)7, "Add");
    this.codePages[0].addToken((byte)8, "Change");
    this.codePages[0].addToken((byte)9, "Delete");
    this.codePages[0].addToken((byte)10, "Fetch");
    this.codePages[0].addToken((byte)11, "SyncKey");
    this.codePages[0].addToken((byte)12, "ClientId");
    this.codePages[0].addToken((byte)13, "ServerId");
    this.codePages[0].addToken((byte)14, "Status");
    this.codePages[0].addToken((byte)15, "Collection");
    this.codePages[0].addToken((byte)16, "Class");
    this.codePages[0].addToken((byte)18, "CollectionId");
    this.codePages[0].addToken((byte)19, "GetChanges");
    this.codePages[0].addToken((byte)20, "MoreAvailable");
    this.codePages[0].addToken((byte)21, "WindowSize");
    this.codePages[0].addToken((byte)22, "Commands");
    this.codePages[0].addToken((byte)23, "Options");
    this.codePages[0].addToken((byte)24, "FilterType");
    this.codePages[0].addToken((byte)27, "Conflict");
    this.codePages[0].addToken((byte)28, "Collections");
    this.codePages[0].addToken((byte)29, "ApplicationData");
    this.codePages[0].addToken((byte)30, "DeletesAsMoves");
    this.codePages[0].addToken((byte)32, "Supported");
    this.codePages[0].addToken((byte)33, "SoftDelete");
    this.codePages[0].addToken((byte)34, "MIMESupport");
    this.codePages[0].addToken((byte)35, "MIMETruncation");
    this.codePages[0].addToken((byte)36, "Wait");
    this.codePages[0].addToken((byte)37, "Limit");
    this.codePages[0].addToken((byte)38, "Partial");
    this.codePages[0].addToken((byte)39, "ConversationMode");
    this.codePages[0].addToken((byte)40, "MaxItems");
    this.codePages[0].addToken((byte)41, "HeartbeatInterval");
    this.codePages[0].addToken((byte)42, "QQRelativeId");
    this.codePages[0].addToken((byte)43, "QQRelate");
    this.codePages[0].addToken((byte)44, "QQNotRelate");
    this.codePages[0].addToken((byte)45, "QQCalendarType");
    this.codePages[1] = new ASWBXMLCodePage();
    this.codePages[1].setNamespace("Contacts");
    this.codePages[1].setXmlns("contacts");
    this.codePages[1].addToken((byte)5, "Anniversary");
    this.codePages[1].addToken((byte)6, "AssistantName");
    this.codePages[1].addToken((byte)7, "AssistantPhoneNumber");
    this.codePages[1].addToken((byte)8, "Birthday");
    this.codePages[1].addToken((byte)12, "Business2PhoneNumber");
    this.codePages[1].addToken((byte)13, "BusinessAddressCity");
    this.codePages[1].addToken((byte)14, "BusinessAddressCountry");
    this.codePages[1].addToken((byte)15, "BusinessAddressPostalCode");
    this.codePages[1].addToken((byte)16, "BusinessAddressState");
    this.codePages[1].addToken((byte)17, "BusinessAddressStreet");
    this.codePages[1].addToken((byte)18, "BusinessFaxNumber");
    this.codePages[1].addToken((byte)19, "BusinessPhoneNumber");
    this.codePages[1].addToken((byte)20, "CarPhoneNumber");
    this.codePages[1].addToken((byte)21, "Categories");
    this.codePages[1].addToken((byte)22, "Category");
    this.codePages[1].addToken((byte)23, "Children");
    this.codePages[1].addToken((byte)24, "Child");
    this.codePages[1].addToken((byte)25, "CompanyName");
    this.codePages[1].addToken((byte)26, "Department");
    this.codePages[1].addToken((byte)27, "Email1Address");
    this.codePages[1].addToken((byte)28, "Email2Address");
    this.codePages[1].addToken((byte)29, "Email3Address");
    this.codePages[1].addToken((byte)30, "FileAs");
    this.codePages[1].addToken((byte)31, "FirstName");
    this.codePages[1].addToken((byte)32, "Home2PhoneNumber");
    this.codePages[1].addToken((byte)33, "HomeAddressCity");
    this.codePages[1].addToken((byte)34, "HomeAddressCountry");
    this.codePages[1].addToken((byte)35, "HomeAddressPostalCode");
    this.codePages[1].addToken((byte)36, "HomeAddressState");
    this.codePages[1].addToken((byte)37, "HomeAddressStreet");
    this.codePages[1].addToken((byte)38, "HomeFaxNumber");
    this.codePages[1].addToken((byte)39, "HomePhoneNumber");
    this.codePages[1].addToken((byte)40, "JobTitle");
    this.codePages[1].addToken((byte)41, "LastName");
    this.codePages[1].addToken((byte)42, "MiddleName");
    this.codePages[1].addToken((byte)43, "MobilePhoneNumber");
    this.codePages[1].addToken((byte)44, "OfficeLocation");
    this.codePages[1].addToken((byte)45, "OtherAddressCity");
    this.codePages[1].addToken((byte)46, "OtherAddressCountry");
    this.codePages[1].addToken((byte)47, "OtherAddressPostalCode");
    this.codePages[1].addToken((byte)48, "OtherAddressState");
    this.codePages[1].addToken((byte)49, "OtherAddressStreet");
    this.codePages[1].addToken((byte)50, "PagerNumber");
    this.codePages[1].addToken((byte)51, "RadioPhoneNumber");
    this.codePages[1].addToken((byte)52, "Spouse");
    this.codePages[1].addToken((byte)53, "Suffix");
    this.codePages[1].addToken((byte)54, "Title");
    this.codePages[1].addToken((byte)55, "WebPage");
    this.codePages[1].addToken((byte)56, "YomiCompanyName");
    this.codePages[1].addToken((byte)57, "YomiFirstName");
    this.codePages[1].addToken((byte)58, "YomiLastName");
    this.codePages[1].addToken((byte)60, "Picture");
    this.codePages[1].addToken((byte)61, "Alias");
    this.codePages[1].addToken((byte)62, "WeightedRank");
    this.codePages[2] = new ASWBXMLCodePage();
    this.codePages[2].setNamespace("Email");
    this.codePages[2].setXmlns("email");
    this.codePages[2].addToken((byte)15, "DateReceived");
    this.codePages[2].addToken((byte)17, "DisplayTo");
    this.codePages[2].addToken((byte)18, "Importance");
    this.codePages[2].addToken((byte)19, "MessageClass");
    this.codePages[2].addToken((byte)20, "Subject");
    this.codePages[2].addToken((byte)21, "Read");
    this.codePages[2].addToken((byte)22, "To");
    this.codePages[2].addToken((byte)23, "Cc");
    this.codePages[2].addToken((byte)24, "From");
    this.codePages[2].addToken((byte)25, "ReplyTo");
    this.codePages[2].addToken((byte)26, "AllDayEvent");
    this.codePages[2].addToken((byte)27, "Categories");
    this.codePages[2].addToken((byte)28, "Category");
    this.codePages[2].addToken((byte)29, "DtStamp");
    this.codePages[2].addToken((byte)30, "EndTime");
    this.codePages[2].addToken((byte)31, "InstanceType");
    this.codePages[2].addToken((byte)32, "BusyStatus");
    this.codePages[2].addToken((byte)33, "Location");
    this.codePages[2].addToken((byte)34, "MeetingRequest");
    this.codePages[2].addToken((byte)35, "Organizer");
    this.codePages[2].addToken((byte)36, "RecurrenceId");
    this.codePages[2].addToken((byte)37, "Reminder");
    this.codePages[2].addToken((byte)38, "ResponseRequested");
    this.codePages[2].addToken((byte)39, "Recurrences");
    this.codePages[2].addToken((byte)40, "Recurrence");
    this.codePages[2].addToken((byte)41, "Type");
    this.codePages[2].addToken((byte)42, "Until");
    this.codePages[2].addToken((byte)43, "Occurrences");
    this.codePages[2].addToken((byte)44, "Interval");
    this.codePages[2].addToken((byte)45, "DayOfWeek");
    this.codePages[2].addToken((byte)46, "DayOfMonth");
    this.codePages[2].addToken((byte)47, "WeekOfMonth");
    this.codePages[2].addToken((byte)48, "MonthOfYear");
    this.codePages[2].addToken((byte)49, "StartTime");
    this.codePages[2].addToken((byte)50, "Sensitivity");
    this.codePages[2].addToken((byte)51, "TimeZone");
    this.codePages[2].addToken((byte)52, "GlobalObjId");
    this.codePages[2].addToken((byte)53, "ThreadTopic");
    this.codePages[2].addToken((byte)57, "InternetCPID");
    this.codePages[2].addToken((byte)58, "Flag");
    this.codePages[2].addToken((byte)59, "Status");
    this.codePages[2].addToken((byte)60, "ContentClass");
    this.codePages[2].addToken((byte)61, "FlagType");
    this.codePages[2].addToken((byte)62, "CompleteTime");
    this.codePages[2].addToken((byte)63, "DisallowNewTimeProposal");
    this.codePages[3] = new ASWBXMLCodePage();
    this.codePages[3].setNamespace("");
    this.codePages[3].setXmlns("");
    this.codePages[4] = new ASWBXMLCodePage();
    this.codePages[4].setNamespace("Calendar");
    this.codePages[4].setXmlns("calendar");
    this.codePages[4].addToken((byte)5, "TimeZone");
    this.codePages[4].addToken((byte)6, "AllDayEvent");
    this.codePages[4].addToken((byte)7, "Attendees");
    this.codePages[4].addToken((byte)8, "Attendee");
    this.codePages[4].addToken((byte)9, "Email");
    this.codePages[4].addToken((byte)10, "Name");
    this.codePages[4].addToken((byte)13, "BusyStatus");
    this.codePages[4].addToken((byte)14, "Categories");
    this.codePages[4].addToken((byte)15, "Category");
    this.codePages[4].addToken((byte)17, "DtStamp");
    this.codePages[4].addToken((byte)18, "EndTime");
    this.codePages[4].addToken((byte)19, "Exception");
    this.codePages[4].addToken((byte)20, "Exceptions");
    this.codePages[4].addToken((byte)21, "Deleted");
    this.codePages[4].addToken((byte)22, "ExceptionStartTime");
    this.codePages[4].addToken((byte)23, "Location");
    this.codePages[4].addToken((byte)24, "MeetingStatus");
    this.codePages[4].addToken((byte)25, "OrganizerEmail");
    this.codePages[4].addToken((byte)26, "OrganizerName");
    this.codePages[4].addToken((byte)27, "Recurrence");
    this.codePages[4].addToken((byte)28, "Type");
    this.codePages[4].addToken((byte)29, "Until");
    this.codePages[4].addToken((byte)30, "Occurrences");
    this.codePages[4].addToken((byte)31, "Interval");
    this.codePages[4].addToken((byte)32, "DayOfWeek");
    this.codePages[4].addToken((byte)33, "DayOfMonth");
    this.codePages[4].addToken((byte)34, "WeekOfMonth");
    this.codePages[4].addToken((byte)35, "MonthOfYear");
    this.codePages[4].addToken((byte)36, "Reminder");
    this.codePages[4].addToken((byte)37, "Sensitivity");
    this.codePages[4].addToken((byte)38, "Subject");
    this.codePages[4].addToken((byte)39, "StartTime");
    this.codePages[4].addToken((byte)40, "UID");
    this.codePages[4].addToken((byte)41, "AttendeeStatus");
    this.codePages[4].addToken((byte)42, "AttendeeType");
    this.codePages[4].addToken((byte)51, "DisallowNewTimeProposal");
    this.codePages[4].addToken((byte)52, "ResponseRequested");
    this.codePages[4].addToken((byte)53, "AppointmentReplyTime");
    this.codePages[4].addToken((byte)54, "ResponseType");
    this.codePages[4].addToken((byte)55, "CalendarType");
    this.codePages[4].addToken((byte)56, "IsLeapMonth");
    this.codePages[4].addToken((byte)57, "FirstDayOfWeek");
    this.codePages[4].addToken((byte)58, "OnlineMeetingConfLink");
    this.codePages[4].addToken((byte)59, "OnlineMeetingExternalLink");
    this.codePages[5] = new ASWBXMLCodePage();
    this.codePages[5].setNamespace("Move");
    this.codePages[5].setXmlns("move");
    this.codePages[5].addToken((byte)5, "MoveItems");
    this.codePages[5].addToken((byte)6, "Move");
    this.codePages[5].addToken((byte)7, "SrcMsgId");
    this.codePages[5].addToken((byte)8, "SrcFldId");
    this.codePages[5].addToken((byte)9, "DstFldId");
    this.codePages[5].addToken((byte)10, "Response");
    this.codePages[5].addToken((byte)11, "Status");
    this.codePages[5].addToken((byte)12, "DstMsgId");
    this.codePages[6] = new ASWBXMLCodePage();
    this.codePages[6].setNamespace("GetItemEstimate");
    this.codePages[6].setXmlns("getitemestimate");
    this.codePages[6].addToken((byte)5, "GetItemEstimate");
    this.codePages[6].addToken((byte)6, "Version");
    this.codePages[6].addToken((byte)7, "Collections");
    this.codePages[6].addToken((byte)8, "Collection");
    this.codePages[6].addToken((byte)9, "Class");
    this.codePages[6].addToken((byte)10, "CollectionId");
    this.codePages[6].addToken((byte)11, "DateTime");
    this.codePages[6].addToken((byte)12, "Estimate");
    this.codePages[6].addToken((byte)13, "Response");
    this.codePages[6].addToken((byte)14, "Status");
    this.codePages[7] = new ASWBXMLCodePage();
    this.codePages[7].setNamespace("FolderHierarchy");
    this.codePages[7].setXmlns("folderhierarchy");
    this.codePages[7].addToken((byte)7, "DisplayName");
    this.codePages[7].addToken((byte)8, "ServerId");
    this.codePages[7].addToken((byte)9, "ParentId");
    this.codePages[7].addToken((byte)10, "Type");
    this.codePages[7].addToken((byte)12, "Status");
    this.codePages[7].addToken((byte)14, "Changes");
    this.codePages[7].addToken((byte)15, "Add");
    this.codePages[7].addToken((byte)16, "Delete");
    this.codePages[7].addToken((byte)17, "Update");
    this.codePages[7].addToken((byte)18, "SyncKey");
    this.codePages[7].addToken((byte)19, "FolderCreate");
    this.codePages[7].addToken((byte)20, "FolderDelete");
    this.codePages[7].addToken((byte)21, "FolderUpdate");
    this.codePages[7].addToken((byte)22, "FolderSync");
    this.codePages[7].addToken((byte)23, "Count");
    this.codePages[7].addToken((byte)25, "QMshare");
    this.codePages[7].addToken((byte)26, "QMshareCount");
    this.codePages[7].addToken((byte)27, "QMshareSource");
    this.codePages[7].addToken((byte)28, "QMshareItemAdd");
    this.codePages[7].addToken((byte)29, "QMshareItemDel");
    this.codePages[7].addToken((byte)30, "QMshareItemUpdate");
    this.codePages[7].addToken((byte)31, "QMshareFrom");
    this.codePages[7].addToken((byte)32, "QMshareName");
    this.codePages[7].addToken((byte)33, "QMshareState");
    this.codePages[8] = new ASWBXMLCodePage();
    this.codePages[8].setNamespace("MeetingResponse");
    this.codePages[8].setXmlns("meetingresponse");
    this.codePages[8].addToken((byte)5, "CalendarId");
    this.codePages[8].addToken((byte)6, "CollectionId");
    this.codePages[8].addToken((byte)7, "MeetingResponse");
    this.codePages[8].addToken((byte)8, "RequestId");
    this.codePages[8].addToken((byte)9, "Request");
    this.codePages[8].addToken((byte)10, "Result");
    this.codePages[8].addToken((byte)11, "Status");
    this.codePages[8].addToken((byte)12, "UserResponse");
    this.codePages[8].addToken((byte)14, "InstanceId");
    this.codePages[9] = new ASWBXMLCodePage();
    this.codePages[9].setNamespace("Tasks");
    this.codePages[9].setXmlns("tasks");
    this.codePages[9].addToken((byte)8, "Categories");
    this.codePages[9].addToken((byte)9, "Category");
    this.codePages[9].addToken((byte)10, "Complete");
    this.codePages[9].addToken((byte)11, "DateCompleted");
    this.codePages[9].addToken((byte)12, "DueDate");
    this.codePages[9].addToken((byte)13, "UtcDueDate");
    this.codePages[9].addToken((byte)14, "Importance");
    this.codePages[9].addToken((byte)15, "Recurrence");
    this.codePages[9].addToken((byte)16, "Type");
    this.codePages[9].addToken((byte)17, "Start");
    this.codePages[9].addToken((byte)18, "Until");
    this.codePages[9].addToken((byte)19, "Occurrences");
    this.codePages[9].addToken((byte)20, "Interval");
    this.codePages[9].addToken((byte)21, "DayOfMonth");
    this.codePages[9].addToken((byte)22, "DayOfWeek");
    this.codePages[9].addToken((byte)23, "WeekOfMonth");
    this.codePages[9].addToken((byte)24, "MonthOfYear");
    this.codePages[9].addToken((byte)25, "Regenerate");
    this.codePages[9].addToken((byte)26, "DeadOccur");
    this.codePages[9].addToken((byte)27, "ReminderSet");
    this.codePages[9].addToken((byte)28, "ReminderTime");
    this.codePages[9].addToken((byte)29, "Sensitivity");
    this.codePages[9].addToken((byte)30, "StartDate");
    this.codePages[9].addToken((byte)31, "UtcStartDate");
    this.codePages[9].addToken((byte)32, "Subject");
    this.codePages[9].addToken((byte)34, "OrdinalDate");
    this.codePages[9].addToken((byte)35, "SubOrdinalDate");
    this.codePages[9].addToken((byte)36, "CalendarType");
    this.codePages[9].addToken((byte)37, "IsLeapMonth");
    this.codePages[9].addToken((byte)38, "FirstDayOfWeek");
    this.codePages[10] = new ASWBXMLCodePage();
    this.codePages[10].setNamespace("ResolveRecipients");
    this.codePages[10].setXmlns("resolverecipients");
    this.codePages[10].addToken((byte)5, "ResolveRecipients");
    this.codePages[10].addToken((byte)6, "Response");
    this.codePages[10].addToken((byte)7, "Status");
    this.codePages[10].addToken((byte)8, "Type");
    this.codePages[10].addToken((byte)9, "Recipient");
    this.codePages[10].addToken((byte)10, "DisplayName");
    this.codePages[10].addToken((byte)11, "EmailAddress");
    this.codePages[10].addToken((byte)12, "Certificates");
    this.codePages[10].addToken((byte)13, "Certificate");
    this.codePages[10].addToken((byte)14, "MiniCertificate");
    this.codePages[10].addToken((byte)15, "Options");
    this.codePages[10].addToken((byte)16, "To");
    this.codePages[10].addToken((byte)17, "CertificateRetrieval");
    this.codePages[10].addToken((byte)18, "RecipientCount");
    this.codePages[10].addToken((byte)19, "MaxCertificates");
    this.codePages[10].addToken((byte)20, "MaxAmbiguousRecipients");
    this.codePages[10].addToken((byte)21, "CertificateCount");
    this.codePages[10].addToken((byte)22, "Availability");
    this.codePages[10].addToken((byte)23, "StartTime");
    this.codePages[10].addToken((byte)24, "EndTime");
    this.codePages[10].addToken((byte)25, "MergedFreeBusy");
    this.codePages[10].addToken((byte)26, "Picture");
    this.codePages[10].addToken((byte)27, "MaxSize");
    this.codePages[10].addToken((byte)28, "Data");
    this.codePages[10].addToken((byte)29, "MaxPictures");
    this.codePages[11] = new ASWBXMLCodePage();
    this.codePages[11].setNamespace("ValidateCert");
    this.codePages[11].setXmlns("validatecert");
    this.codePages[11].addToken((byte)5, "ValidateCert");
    this.codePages[11].addToken((byte)6, "Certificates");
    this.codePages[11].addToken((byte)7, "Certificate");
    this.codePages[11].addToken((byte)8, "CertificateChain");
    this.codePages[11].addToken((byte)9, "CheckCRL");
    this.codePages[11].addToken((byte)10, "Status");
    this.codePages[12] = new ASWBXMLCodePage();
    this.codePages[12].setNamespace("Contacts2");
    this.codePages[12].setXmlns("contacts2");
    this.codePages[12].addToken((byte)5, "CustomerId");
    this.codePages[12].addToken((byte)6, "GovernmentId");
    this.codePages[12].addToken((byte)7, "IMAddress");
    this.codePages[12].addToken((byte)8, "IMAddress2");
    this.codePages[12].addToken((byte)9, "IMAddress3");
    this.codePages[12].addToken((byte)10, "ManagerName");
    this.codePages[12].addToken((byte)11, "CompanyMainPhone");
    this.codePages[12].addToken((byte)12, "AccountName");
    this.codePages[12].addToken((byte)13, "NickName");
    this.codePages[12].addToken((byte)14, "MMS");
    this.codePages[13] = new ASWBXMLCodePage();
    this.codePages[13].setNamespace("Ping");
    this.codePages[13].setXmlns("ping");
    this.codePages[13].addToken((byte)5, "Ping");
    this.codePages[13].addToken((byte)6, "AutdState");
    this.codePages[13].addToken((byte)7, "Status");
    this.codePages[13].addToken((byte)8, "HeartbeatInterval");
    this.codePages[13].addToken((byte)9, "Folders");
    this.codePages[13].addToken((byte)10, "Folder");
    this.codePages[13].addToken((byte)11, "Id");
    this.codePages[13].addToken((byte)12, "Class");
    this.codePages[13].addToken((byte)13, "MaxFolders");
    this.codePages[14] = new ASWBXMLCodePage();
    this.codePages[14].setNamespace("Provision");
    this.codePages[14].setXmlns("provision");
    this.codePages[14].addToken((byte)5, "Provision");
    this.codePages[14].addToken((byte)6, "Policies");
    this.codePages[14].addToken((byte)7, "Policy");
    this.codePages[14].addToken((byte)8, "PolicyType");
    this.codePages[14].addToken((byte)9, "PolicyKey");
    this.codePages[14].addToken((byte)10, "Data");
    this.codePages[14].addToken((byte)11, "Status");
    this.codePages[14].addToken((byte)12, "RemoteWipe");
    this.codePages[14].addToken((byte)13, "EASProvisionDoc");
    this.codePages[14].addToken((byte)14, "DevicePasswordEnabled");
    this.codePages[14].addToken((byte)15, "AlphanumericDevicePasswordRequired");
    this.codePages[14].addToken((byte)16, "RequireStorageCardEncryption");
    this.codePages[14].addToken((byte)17, "PasswordRecoveryEnabled");
    this.codePages[14].addToken((byte)19, "AttachmentsEnabled");
    this.codePages[14].addToken((byte)20, "MinDevicePasswordLength");
    this.codePages[14].addToken((byte)21, "MaxInactivityTimeDeviceLock");
    this.codePages[14].addToken((byte)22, "MaxDevicePasswordFailedAttempts");
    this.codePages[14].addToken((byte)23, "MaxAttachmentSize");
    this.codePages[14].addToken((byte)24, "AllowSimpleDevicePassword");
    this.codePages[14].addToken((byte)25, "DevicePasswordExpiration");
    this.codePages[14].addToken((byte)26, "DevicePasswordHistory");
    this.codePages[14].addToken((byte)27, "AllowStorageCard");
    this.codePages[14].addToken((byte)28, "AllowCamera");
    this.codePages[14].addToken((byte)29, "RequireDeviceEncryption");
    this.codePages[14].addToken((byte)30, "AllowUnsignedApplications");
    this.codePages[14].addToken((byte)31, "AllowUnsignedInstallationPackages");
    this.codePages[14].addToken((byte)32, "MinDevicePasswordComplexCharacters");
    this.codePages[14].addToken((byte)33, "AllowWiFi");
    this.codePages[14].addToken((byte)34, "AllowTextMessaging");
    this.codePages[14].addToken((byte)35, "AllowPOPIMAPEmail");
    this.codePages[14].addToken((byte)36, "AllowBluetooth");
    this.codePages[14].addToken((byte)37, "AllowIrDA");
    this.codePages[14].addToken((byte)38, "RequireManualSyncWhenRoaming");
    this.codePages[14].addToken((byte)39, "AllowDesktopSync");
    this.codePages[14].addToken((byte)40, "MaxCalendarAgeFilter");
    this.codePages[14].addToken((byte)41, "AllowHTMLEmail");
    this.codePages[14].addToken((byte)42, "MaxEmailAgeFilter");
    this.codePages[14].addToken((byte)43, "MaxEmailBodyTruncationSize");
    this.codePages[14].addToken((byte)44, "MaxEmailHTMLBodyTruncationSize");
    this.codePages[14].addToken((byte)45, "RequireSignedSMIMEMessages");
    this.codePages[14].addToken((byte)46, "RequireEncryptedSMIMEMessages");
    this.codePages[14].addToken((byte)47, "RequireSignedSMIMEAlgorithm");
    this.codePages[14].addToken((byte)48, "RequireEncryptionSMIMEAlgorithm");
    this.codePages[14].addToken((byte)49, "AllowSMIMEEncryptionAlgorithmNegotiation");
    this.codePages[14].addToken((byte)50, "AllowSMIMESoftCerts");
    this.codePages[14].addToken((byte)51, "AllowBrowser");
    this.codePages[14].addToken((byte)52, "AllowConsumerEmail");
    this.codePages[14].addToken((byte)53, "AllowRemoteDesktop");
    this.codePages[14].addToken((byte)54, "AllowInternetSharing");
    this.codePages[14].addToken((byte)55, "UnapprovedInROMApplicationList");
    this.codePages[14].addToken((byte)56, "ApplicationName");
    this.codePages[14].addToken((byte)57, "ApprovedApplicationList");
    this.codePages[14].addToken((byte)58, "Hash");
    this.codePages[15] = new ASWBXMLCodePage();
    this.codePages[15].setNamespace("Search");
    this.codePages[15].setXmlns("search");
    this.codePages[15].addToken((byte)5, "Search");
    this.codePages[15].addToken((byte)7, "Store");
    this.codePages[15].addToken((byte)8, "Name");
    this.codePages[15].addToken((byte)9, "Query");
    this.codePages[15].addToken((byte)10, "Options");
    this.codePages[15].addToken((byte)11, "Range");
    this.codePages[15].addToken((byte)12, "Status");
    this.codePages[15].addToken((byte)13, "Response");
    this.codePages[15].addToken((byte)14, "Result");
    this.codePages[15].addToken((byte)15, "Properties");
    this.codePages[15].addToken((byte)16, "Total");
    this.codePages[15].addToken((byte)17, "EqualTo");
    this.codePages[15].addToken((byte)18, "Value");
    this.codePages[15].addToken((byte)19, "And");
    this.codePages[15].addToken((byte)20, "Or");
    this.codePages[15].addToken((byte)21, "FreeText");
    this.codePages[15].addToken((byte)23, "DeepTraversal");
    this.codePages[15].addToken((byte)24, "LongId");
    this.codePages[15].addToken((byte)25, "RebuildResults");
    this.codePages[15].addToken((byte)26, "LessThan");
    this.codePages[15].addToken((byte)27, "GreaterThan");
    this.codePages[15].addToken((byte)30, "UserName");
    this.codePages[15].addToken((byte)31, "Password");
    this.codePages[15].addToken((byte)32, "ConversationId");
    this.codePages[15].addToken((byte)33, "Picture");
    this.codePages[15].addToken((byte)34, "MaxSize");
    this.codePages[15].addToken((byte)35, "MaxPictures");
    this.codePages[16] = new ASWBXMLCodePage();
    this.codePages[16].setNamespace("GAL");
    this.codePages[16].setXmlns("gal");
    this.codePages[16].addToken((byte)5, "DisplayName");
    this.codePages[16].addToken((byte)6, "Phone");
    this.codePages[16].addToken((byte)7, "Office");
    this.codePages[16].addToken((byte)8, "Title");
    this.codePages[16].addToken((byte)9, "Company");
    this.codePages[16].addToken((byte)10, "Alias");
    this.codePages[16].addToken((byte)11, "FirstName");
    this.codePages[16].addToken((byte)12, "LastName");
    this.codePages[16].addToken((byte)13, "HomePhone");
    this.codePages[16].addToken((byte)14, "MobilePhone");
    this.codePages[16].addToken((byte)15, "EmailAddress");
    this.codePages[16].addToken((byte)16, "Picture");
    this.codePages[16].addToken((byte)17, "Status");
    this.codePages[16].addToken((byte)18, "Data");
    this.codePages[17] = new ASWBXMLCodePage();
    this.codePages[17].setNamespace("AirSyncBase");
    this.codePages[17].setXmlns("airsyncbase");
    this.codePages[17].addToken((byte)5, "BodyPreference");
    this.codePages[17].addToken((byte)6, "Type");
    this.codePages[17].addToken((byte)7, "TruncationSize");
    this.codePages[17].addToken((byte)8, "AllOrNone");
    this.codePages[17].addToken((byte)10, "Body");
    this.codePages[17].addToken((byte)11, "Data");
    this.codePages[17].addToken((byte)12, "EstimatedDataSize");
    this.codePages[17].addToken((byte)13, "Truncated");
    this.codePages[17].addToken((byte)14, "Attachments");
    this.codePages[17].addToken((byte)15, "Attachment");
    this.codePages[17].addToken((byte)16, "DisplayName");
    this.codePages[17].addToken((byte)17, "FileReference");
    this.codePages[17].addToken((byte)18, "Method");
    this.codePages[17].addToken((byte)19, "ContentId");
    this.codePages[17].addToken((byte)20, "ContentLocation");
    this.codePages[17].addToken((byte)21, "IsInline");
    this.codePages[17].addToken((byte)22, "NativeBodyType");
    this.codePages[17].addToken((byte)23, "ContentType");
    this.codePages[17].addToken((byte)24, "Preview");
    this.codePages[17].addToken((byte)25, "BodyPartPreference");
    this.codePages[17].addToken((byte)26, "BodyPart");
    this.codePages[17].addToken((byte)27, "Status");
    this.codePages[18] = new ASWBXMLCodePage();
    this.codePages[18].setNamespace("Settings");
    this.codePages[18].setXmlns("settings");
    this.codePages[18].addToken((byte)5, "Settings");
    this.codePages[18].addToken((byte)6, "Status");
    this.codePages[18].addToken((byte)7, "Get");
    this.codePages[18].addToken((byte)8, "Set");
    this.codePages[18].addToken((byte)9, "Oof");
    this.codePages[18].addToken((byte)10, "OofState");
    this.codePages[18].addToken((byte)11, "StartTime");
    this.codePages[18].addToken((byte)12, "EndTime");
    this.codePages[18].addToken((byte)13, "OofMessage");
    this.codePages[18].addToken((byte)14, "AppliesToInternal");
    this.codePages[18].addToken((byte)15, "AppliesToExternalKnown");
    this.codePages[18].addToken((byte)16, "AppliesToExternalUnknown");
    this.codePages[18].addToken((byte)17, "Enabled");
    this.codePages[18].addToken((byte)18, "ReplyMessage");
    this.codePages[18].addToken((byte)19, "BodyType");
    this.codePages[18].addToken((byte)20, "DevicePassword");
    this.codePages[18].addToken((byte)21, "Password");
    this.codePages[18].addToken((byte)22, "DeviceInformation");
    this.codePages[18].addToken((byte)23, "Model");
    this.codePages[18].addToken((byte)24, "IMEI");
    this.codePages[18].addToken((byte)25, "FriendlyName");
    this.codePages[18].addToken((byte)26, "OS");
    this.codePages[18].addToken((byte)27, "OSLanguage");
    this.codePages[18].addToken((byte)28, "PhoneNumber");
    this.codePages[18].addToken((byte)29, "UserInformation");
    this.codePages[18].addToken((byte)30, "EmailAddresses");
    this.codePages[18].addToken((byte)31, "SMTPAddress");
    this.codePages[18].addToken((byte)32, "UserAgent");
    this.codePages[18].addToken((byte)33, "EnableOutboundSMS");
    this.codePages[18].addToken((byte)34, "MobileOperator");
    this.codePages[18].addToken((byte)35, "PrimarySmtpAddress");
    this.codePages[18].addToken((byte)36, "Accounts");
    this.codePages[18].addToken((byte)37, "Account");
    this.codePages[18].addToken((byte)38, "AccountId");
    this.codePages[18].addToken((byte)39, "AccountName");
    this.codePages[18].addToken((byte)40, "UserDisplayName");
    this.codePages[18].addToken((byte)41, "SendDisabled");
    this.codePages[18].addToken((byte)43, "RightsManagementInformation");
    this.codePages[19] = new ASWBXMLCodePage();
    this.codePages[19].setNamespace("DocumentLibrary");
    this.codePages[19].setXmlns("documentlibrary");
    this.codePages[19].addToken((byte)5, "LinkId");
    this.codePages[19].addToken((byte)6, "DisplayName");
    this.codePages[19].addToken((byte)7, "IsFolder");
    this.codePages[19].addToken((byte)8, "CreationDate");
    this.codePages[19].addToken((byte)9, "LastModifiedDate");
    this.codePages[19].addToken((byte)10, "IsHidden");
    this.codePages[19].addToken((byte)11, "ContentLength");
    this.codePages[19].addToken((byte)12, "ContentType");
    this.codePages[20] = new ASWBXMLCodePage();
    this.codePages[20].setNamespace("ItemOperations");
    this.codePages[20].setXmlns("itemoperations");
    this.codePages[20].addToken((byte)5, "ItemOperations");
    this.codePages[20].addToken((byte)6, "Fetch");
    this.codePages[20].addToken((byte)7, "Store");
    this.codePages[20].addToken((byte)8, "Options");
    this.codePages[20].addToken((byte)9, "Range");
    this.codePages[20].addToken((byte)10, "Total");
    this.codePages[20].addToken((byte)11, "Properties");
    this.codePages[20].addToken((byte)12, "Data");
    this.codePages[20].addToken((byte)13, "Status");
    this.codePages[20].addToken((byte)14, "Response");
    this.codePages[20].addToken((byte)15, "Version");
    this.codePages[20].addToken((byte)16, "Schema");
    this.codePages[20].addToken((byte)17, "Part");
    this.codePages[20].addToken((byte)18, "EmptyFolderContents");
    this.codePages[20].addToken((byte)19, "DeleteSubFolders");
    this.codePages[20].addToken((byte)20, "UserName");
    this.codePages[20].addToken((byte)21, "Password");
    this.codePages[20].addToken((byte)22, "Move");
    this.codePages[20].addToken((byte)23, "DstFldId");
    this.codePages[20].addToken((byte)24, "ConversationId");
    this.codePages[20].addToken((byte)25, "MoveAlways");
    this.codePages[21] = new ASWBXMLCodePage();
    this.codePages[21].setNamespace("ComposeMail");
    this.codePages[21].setXmlns("composemail");
    this.codePages[21].addToken((byte)5, "SendMail");
    this.codePages[21].addToken((byte)6, "SmartForward");
    this.codePages[21].addToken((byte)7, "SmartReply");
    this.codePages[21].addToken((byte)8, "SaveInSentItems");
    this.codePages[21].addToken((byte)9, "ReplaceMime");
    this.codePages[21].addToken((byte)11, "Source");
    this.codePages[21].addToken((byte)12, "FolderId");
    this.codePages[21].addToken((byte)13, "ItemId");
    this.codePages[21].addToken((byte)14, "LongId");
    this.codePages[21].addToken((byte)15, "InstanceId");
    this.codePages[21].addToken((byte)16, "Mime");
    this.codePages[21].addToken((byte)17, "ClientId");
    this.codePages[21].addToken((byte)18, "Status");
    this.codePages[21].addToken((byte)19, "AccountId");
    this.codePages[22] = new ASWBXMLCodePage();
    this.codePages[22].setNamespace("Email2");
    this.codePages[22].setXmlns("email2");
    this.codePages[22].addToken((byte)5, "UmCallerID");
    this.codePages[22].addToken((byte)6, "UmUserNotes");
    this.codePages[22].addToken((byte)7, "UmAttDuration");
    this.codePages[22].addToken((byte)8, "UmAttOrder");
    this.codePages[22].addToken((byte)9, "ConversationId");
    this.codePages[22].addToken((byte)10, "ConversationIndex");
    this.codePages[22].addToken((byte)11, "LastVerbExecuted");
    this.codePages[22].addToken((byte)12, "LastVerbExecutionTime");
    this.codePages[22].addToken((byte)13, "ReceivedAsBcc");
    this.codePages[22].addToken((byte)14, "Sender");
    this.codePages[22].addToken((byte)15, "CalendarType");
    this.codePages[22].addToken((byte)16, "IsLeapMonth");
    this.codePages[22].addToken((byte)17, "AccountId");
    this.codePages[22].addToken((byte)18, "FirstDayOfWeek");
    this.codePages[22].addToken((byte)19, "MeetingMessageType");
    this.codePages[23] = new ASWBXMLCodePage();
    this.codePages[23].setNamespace("Notes");
    this.codePages[23].setXmlns("notes");
    this.codePages[23].addToken((byte)5, "Subject");
    this.codePages[23].addToken((byte)6, "MessageClass");
    this.codePages[23].addToken((byte)7, "LastModifiedDate");
    this.codePages[23].addToken((byte)8, "Categories");
    this.codePages[23].addToken((byte)9, "Category");
    this.codePages[24] = new ASWBXMLCodePage();
    this.codePages[24].setNamespace("RightsManagement");
    this.codePages[24].setXmlns("rightsmanagement");
    this.codePages[24].addToken((byte)5, "RightsManagementSupport");
    this.codePages[24].addToken((byte)6, "RightsManagementTemplates");
    this.codePages[24].addToken((byte)7, "RightsManagementTemplate");
    this.codePages[24].addToken((byte)8, "RightsManagementLicense");
    this.codePages[24].addToken((byte)9, "EditAllowed");
    this.codePages[24].addToken((byte)10, "ReplyAllowed");
    this.codePages[24].addToken((byte)11, "ReplyAllAllowed");
    this.codePages[24].addToken((byte)12, "ForwardAllowed");
    this.codePages[24].addToken((byte)13, "ModifyRecipientsAllowed");
    this.codePages[24].addToken((byte)14, "ExtractAllowed");
    this.codePages[24].addToken((byte)15, "PrintAllowed");
    this.codePages[24].addToken((byte)16, "ExportAllowed");
    this.codePages[24].addToken((byte)17, "ProgrammaticAccessAllowed");
    this.codePages[24].addToken((byte)18, "Owner");
    this.codePages[24].addToken((byte)19, "ContentExpiryDate");
    this.codePages[24].addToken((byte)20, "TemplateID");
    this.codePages[24].addToken((byte)21, "TemplateName");
    this.codePages[24].addToken((byte)22, "TemplateDescription");
    this.codePages[24].addToken((byte)23, "ContentOwner");
    this.codePages[24].addToken((byte)24, "RemoveRightsManagementDistribution");
  }
  
  private void encodeMultiByteInteger(int paramInt, ByteArrayOutputStream paramByteArrayOutputStream)
    throws Exception
  {
    Stack localStack = new Stack();
    while (paramInt > 0)
    {
      int j = (byte)(paramInt & 0x7F);
      int i = j;
      if (!localStack.isEmpty()) {
        i = (byte)(j | 0x80);
      }
      localStack.add(Byte.valueOf(i));
      paramInt >>>= 7;
    }
    while (!localStack.isEmpty()) {
      paramByteArrayOutputStream.write(((Byte)localStack.pop()).byteValue());
    }
  }
  
  private byte[] encodeNode(Node paramNode, ByteArrayOutputStream paramByteArrayOutputStream)
    throws Exception
  {
    int i = paramNode.getNodeType();
    if (i == 1)
    {
      if (paramNode.getAttributes().getLength() > 0) {
        parseXmlnsAttributes(paramNode);
      }
      if (setCodePageByXmlns(paramNode.getPrefix()))
      {
        paramByteArrayOutputStream.write(0);
        paramByteArrayOutputStream.write((byte)this.currentCodePage);
      }
      int j = this.codePages[this.currentCodePage].getToken(paramNode.getLocalName());
      i = j;
      if (paramNode.hasChildNodes()) {
        i = (byte)(j | 0x40);
      }
      paramByteArrayOutputStream.write(i);
      if (paramNode.hasChildNodes())
      {
        paramNode = paramNode.getChildNodes();
        j = paramNode.getLength();
        i = 0;
        while (i < j)
        {
          encodeNode(paramNode.item(i), paramByteArrayOutputStream);
          i += 1;
        }
        paramByteArrayOutputStream.write(1);
      }
    }
    for (;;)
    {
      return paramByteArrayOutputStream.toByteArray();
      if (i == 3)
      {
        paramByteArrayOutputStream.write(3);
        encodeString(paramNode.getNodeValue(), paramByteArrayOutputStream);
      }
      else if (i == 4)
      {
        paramByteArrayOutputStream.write(-61);
        if (paramNode.getParentNode().getNodeName().equals("Mime")) {
          encodeStringAsOpaqueData(paramNode.getNodeValue(), paramByteArrayOutputStream);
        } else {
          encodeStringAsOpaqueData(paramNode.getNodeValue(), paramByteArrayOutputStream);
        }
      }
    }
  }
  
  private void encodeString(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    throws Exception
  {
    paramByteArrayOutputStream.write(paramString.getBytes());
    paramByteArrayOutputStream.write(0);
  }
  
  private void encodeStringAsOpaqueData(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    throws Exception
  {
    paramString = paramString.getBytes();
    encodeMultiByteInteger(paramString.length, paramByteArrayOutputStream);
    paramByteArrayOutputStream.write(paramString);
  }
  
  private int getCodePageByNamespace(String paramString)
    throws Exception
  {
    int i = 0;
    while (i < this.codePages.length)
    {
      if (this.codePages[i].getNamespace().equalsIgnoreCase(paramString)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private int getCodePageByXmlns(String paramString)
    throws Exception
  {
    int i = 0;
    while (i < this.codePages.length)
    {
      if (this.codePages[i].getXmlns().equalsIgnoreCase(paramString)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private void parseXmlnsAttributes(Node paramNode)
    throws Exception
  {
    paramNode = paramNode.getAttributes();
    int i = 0;
    int j = paramNode.getLength();
    if (i < j)
    {
      Node localNode = paramNode.item(i);
      String str = localNode.getNodeValue().trim();
      if (localNode.getNodeName().equalsIgnoreCase("xmlns")) {
        this.defaultCodePage = getCodePageByNamespace(str);
      }
      for (;;)
      {
        i += 1;
        break;
        if ("xmlns".equalsIgnoreCase(localNode.getPrefix()))
        {
          int k = getCodePageByNamespace(str);
          this.codePages[k].setXmlns(localNode.getLocalName());
        }
      }
    }
  }
  
  private boolean setCodePageByXmlns(String paramString)
    throws Exception
  {
    boolean bool = false;
    if ((paramString == null) || (paramString.equalsIgnoreCase(""))) {
      if (this.currentCodePage != this.defaultCodePage)
      {
        this.currentCodePage = this.defaultCodePage;
        bool = true;
      }
    }
    while (this.codePages[this.currentCodePage].getXmlns().equalsIgnoreCase(paramString)) {
      return bool;
    }
    int i = 0;
    while (i < this.codePages.length)
    {
      if (this.codePages[i].getXmlns().equalsIgnoreCase(paramString))
      {
        this.currentCodePage = i;
        return true;
      }
      i += 1;
    }
    throw new Exception(String.format("Unknown Xmlns: {0}.", new Object[] { paramString }));
  }
  
  public byte[] getBytes()
    throws Exception
  {
    int i = 0;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    localByteArrayOutputStream.write(3);
    localByteArrayOutputStream.write(1);
    localByteArrayOutputStream.write(106);
    localByteArrayOutputStream.write(0);
    NodeList localNodeList = this.xmlDoc.getChildNodes();
    int j = localNodeList.getLength();
    while (i < j)
    {
      encodeNode(localNodeList.item(i), localByteArrayOutputStream);
      i += 1;
    }
    return localByteArrayOutputStream.toByteArray();
  }
  
  public String getXml()
    throws Exception
  {
    Transformer localTransformer = TransformerFactory.newInstance().newTransformer();
    StringWriter localStringWriter = new StringWriter();
    localTransformer.transform(new DOMSource(this.xmlDoc), new StreamResult(localStringWriter));
    return localStringWriter.getBuffer().toString();
  }
  
  public Document getXmlDocument()
  {
    return this.xmlDoc;
  }
  
  public void loadBytes(byte[] paramArrayOfByte)
    throws Exception
  {
    Object localObject = DocumentBuilderFactory.newInstance();
    ((DocumentBuilderFactory)localObject).setNamespaceAware(true);
    this.xmlDoc = ((DocumentBuilderFactory)localObject).newDocumentBuilder().newDocument();
    if (paramArrayOfByte.length == 0)
    {
      this.xmlDoc.appendChild(this.xmlDoc.createElement("root"));
      return;
    }
    ASWBXMLByteQueue localASWBXMLByteQueue = new ASWBXMLByteQueue(paramArrayOfByte);
    localASWBXMLByteQueue.Dequeue();
    localASWBXMLByteQueue.dequeueMultibyteInt();
    if (localASWBXMLByteQueue.dequeueMultibyteInt() != 106) {
      throw new Exception("EX2010_activesyncfolder_cs only supports UTF-8 encoded XML.");
    }
    if (localASWBXMLByteQueue.dequeueMultibyteInt() != 0) {
      throw new Exception("WBXML data contains a string table.");
    }
    paramArrayOfByte = this.xmlDoc;
    label793:
    for (;;)
    {
      label118:
      int k;
      if (localASWBXMLByteQueue.getCount() > 0)
      {
        int i = localASWBXMLByteQueue.Dequeue();
        int j;
        switch (i)
        {
        default: 
          if ((i & 0x80) != 0)
          {
            j = 1;
            label314:
            if ((i & 0x40) == 0) {
              break label553;
            }
          }
          break;
        }
        label553:
        for (k = 1;; k = 0)
        {
          i = (byte)(i & 0x3F);
          if (j == 0) {
            break label559;
          }
          throw new Exception(String.format("Token 0x{0:X} has attributes.", new Object[] { Byte.valueOf(i) }));
          j = localASWBXMLByteQueue.Dequeue();
          if ((j >= 0) && (j < 25))
          {
            this.currentCodePage = j;
            break;
          }
          throw new Exception(String.format("Unknown code page ID 0x{0:X} encountered in WBXML", new Object[] { Byte.valueOf(i) }));
          if (paramArrayOfByte.getParentNode() != null)
          {
            paramArrayOfByte = paramArrayOfByte.getParentNode();
            break;
          }
          throw new Exception("END global token encountered out of sequence");
          j = localASWBXMLByteQueue.dequeueMultibyteInt();
          if ("Mime".equals(paramArrayOfByte.getNodeName())) {}
          for (localObject = localASWBXMLByteQueue.dequeueString(j);; localObject = localASWBXMLByteQueue.dequeueString(j))
          {
            paramArrayOfByte.appendChild(this.xmlDoc.createCDATASection((String)localObject));
            break;
          }
          paramArrayOfByte.appendChild(this.xmlDoc.createTextNode(localASWBXMLByteQueue.dequeueString()));
          break;
          throw new Exception(String.format("Encountered unknown global token 0x{0:X}.", new Object[] { Byte.valueOf(i) }));
          j = 0;
          break label314;
        }
        label559:
        String str = this.codePages[this.currentCodePage].getTag(i);
        localObject = str;
        if (str == null) {
          localObject = String.format("UNKNOWN_TAG_%02X", new Object[] { Byte.valueOf(i) });
        }
        localObject = this.xmlDoc.createElementNS(this.codePages[this.currentCodePage].getNamespace(), (String)localObject);
        if (this.xmlDoc.getDocumentElement() != null) {
          break label696;
        }
        this.defaultCodePage = this.currentCodePage;
        paramArrayOfByte.appendChild((Node)localObject);
        this.xmlDoc.getDocumentElement().setAttribute("xmlns", this.codePages[this.currentCodePage].getNamespace());
      }
      for (;;)
      {
        if (k == 0) {
          break label793;
        }
        paramArrayOfByte = (byte[])localObject;
        break label118;
        break;
        label696:
        if (this.currentCodePage != this.defaultCodePage)
        {
          this.xmlDoc.getDocumentElement().setAttribute("xmlns:" + this.codePages[this.currentCodePage].getXmlns(), this.codePages[this.currentCodePage].getNamespace());
          ((Node)localObject).setPrefix(this.codePages[this.currentCodePage].getXmlns());
        }
        paramArrayOfByte.appendChild((Node)localObject);
      }
    }
  }
  
  public void loadXml(String paramString)
    throws Exception
  {
    DocumentBuilderFactory localDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
    localDocumentBuilderFactory.setNamespaceAware(true);
    this.xmlDoc = localDocumentBuilderFactory.newDocumentBuilder().parse(new InputSource(new StringReader(paramString)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.aswbxml.ASWBXML
 * JD-Core Version:    0.7.0.1
 */