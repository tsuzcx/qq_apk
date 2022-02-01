package com.tencent.qqmail.model.mail;

import android.content.Context;
import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteDatabase.CursorFactory;
import com.tencent.qqmail.QMBaseSQLiteOpenHelper;
import com.tencent.qqmail.attachment.QMAttachSQLite;
import com.tencent.qqmail.folderlist.FolderDataSQLite;
import com.tencent.qqmail.inquirymail.InquiryMailSQLite;
import com.tencent.qqmail.model.contact.QMContactSQLite;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgradeManager;
import com.tencent.qqmail.namelist.NameListSQLite;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import java.util.HashMap;

public class QMMailSQLiteHelper
  extends QMBaseSQLiteOpenHelper
{
  protected static final String FIELD_API_AID = "aid";
  protected static final String FIELD_API_BODY_ID = "bodyid";
  protected static final String FIELD_API_CONTENT_DESCRIPTION = "contentDescription";
  protected static final String FIELD_API_CONTENT_DISPOSITION = "contentDisposition";
  protected static final String FIELD_API_CONTENT_LINE_SIZE = "contentLineSize";
  protected static final String FIELD_API_CONTENT_SUB_TYPE = "contentSubType";
  protected static final String FIELD_API_CONTENT_TYPE = "contentType";
  protected static final String FIELD_API_CONTENT_TYPE_PARAMS = "contentTypeParams";
  protected static final String FIELD_API_ID = "id";
  protected static final String FIELD_API_ITEMID = "rmtitemid";
  protected static final String FIELD_API_ITEM_TYPE = "itemtype";
  protected static final String FIELD_API_PTC_AID = "rmtaid";
  protected static final String FIELD_API_PTC_ID = "rmtid";
  protected static final String FIELD_API_PTC_MID = "rmtmid";
  protected static final String FIELD_API_TRANSFER_ENCODING = "contentTransferEncoding";
  protected static final String FIELD_ATTACH_ACCOUNTID = "accountid";
  protected static final String FIELD_ATTACH_ALIAS = "alias";
  protected static final String FIELD_ATTACH_ATTR = "attr";
  protected static final String FIELD_ATTACH_COPYDISKLIST = "copydisklist";
  protected static final String FIELD_ATTACH_DISPLAY_NAME = "displayname";
  protected static final String FIELD_ATTACH_DOWNLOADKEY = "downloadkey";
  protected static final String FIELD_ATTACH_DOWNLOADSIZE = "downloadsize";
  protected static final String FIELD_ATTACH_DOWNLOADSIZE_BYTE = "downloadSizeByte";
  protected static final String FIELD_ATTACH_DOWNLOADURL = "downloadurl";
  protected static final String FIELD_ATTACH_EMLREF_MAILID = "refmailid";
  protected static final String FIELD_ATTACH_ENABLEATTFOLDER = "enableattfolder";
  protected static final String FIELD_ATTACH_FAVTIME = "favtime";
  protected static final String FIELD_ATTACH_FILESIZE_BYTE = "fileSizeByte";
  protected static final String FIELD_ATTACH_FOLDERID = "folderid";
  protected static final String FIELD_ATTACH_FOLDER_KEY = "folderkey";
  protected static final String FIELD_ATTACH_ICON_URL = "icon";
  protected static final String FIELD_ATTACH_ID = "id";
  protected static final String FIELD_ATTACH_ISAUDIO = "isaudio";
  protected static final String FIELD_ATTACH_ISDOWNLOAD = "isdownload";
  protected static final String FIELD_ATTACH_ISEMBED = "isembed";
  protected static final String FIELD_ATTACH_ISEXIST = "isexist";
  protected static final String FIELD_ATTACH_ISFAVORITE = "isfavorite";
  protected static final String FIELD_ATTACH_ISPIC = "ispic";
  protected static final String FIELD_ATTACH_ISPROTOCOL = "isprotocol";
  protected static final String FIELD_ATTACH_IVIEWTYPE = "iviewtype";
  protected static final String FIELD_ATTACH_MAILID = "mailid";
  protected static final String FIELD_ATTACH_MAILSENDER = "mailsender";
  protected static final String FIELD_ATTACH_MAILSENDERADDR = "mailsenderaddr";
  protected static final String FIELD_ATTACH_MAILSUBJECT = "mailsubject";
  protected static final String FIELD_ATTACH_MYDISK = "mydisk";
  protected static final String FIELD_ATTACH_NAME = "name";
  protected static final String FIELD_ATTACH_ORDER_INDEX = "orderidx";
  protected static final String FIELD_ATTACH_PREVIEWTYPE = "previewtype";
  protected static final String FIELD_ATTACH_PREVIEWURL = "previewurl";
  protected static final String FIELD_ATTACH_PTC_AID = "aid";
  protected static final String FIELD_ATTACH_PTC_CID = "cid";
  protected static final String FIELD_ATTACH_PTC_DATA = "data";
  protected static final String FIELD_ATTACH_PTC_EXCHANGE_FILE_UID = "exchangeFileUid";
  protected static final String FIELD_ATTACH_PTC_FILE_CONTENT_TYPE = "fileContentType";
  protected static final String FIELD_ATTACH_PTC_MID = "mid";
  protected static final String FIELD_ATTACH_PTC_PROTOCOLTYPE = "protocolType";
  protected static final String FIELD_ATTACH_PTC_TYPE = "type";
  protected static final String FIELD_ATTACH_RANK = "rank";
  protected static final String FIELD_ATTACH_REMOTEID = "remoteid";
  protected static final String FIELD_ATTACH_SIZE = "size";
  protected static final String FIELD_ATTACH_STORAGENAME = "keyname";
  protected static final String FIELD_ATTACH_SUFFIX = "suffix";
  protected static final String FIELD_ATTACH_URLENCODENAME = "urlencodename";
  protected static final String FIELD_ATTACH_VIEWMODE = "viewmode";
  protected static final String FIELD_ATTACH_VIEWTYPE = "viewtype";
  protected static final String FIELD_BIG_ATTACH_ACCOUNTID = "accountid";
  protected static final String FIELD_BIG_ATTACH_COPYDISKLIST = "copydisklist";
  protected static final String FIELD_BIG_ATTACH_DISPLAY_NAME = "displayname";
  protected static final String FIELD_BIG_ATTACH_DOWNLOADSIZE = "downloadsize";
  protected static final String FIELD_BIG_ATTACH_DOWNLOADURL = "downloadurl";
  protected static final String FIELD_BIG_ATTACH_EMLREF_MAILID = "refmailid";
  protected static final String FIELD_BIG_ATTACH_EXPIRETIME = "expiretime";
  protected static final String FIELD_BIG_ATTACH_ID = "id";
  protected static final String FIELD_BIG_ATTACH_ISDOWNLOAD = "isdownload";
  protected static final String FIELD_BIG_ATTACH_MAILID = "mailid";
  protected static final String FIELD_BIG_ATTACH_MYDISK = "mydisk";
  protected static final String FIELD_BIG_ATTACH_NAME = "name";
  protected static final String FIELD_BIG_ATTACH_ORDER_INDEX = "orderidx";
  protected static final String FIELD_BIG_ATTACH_PREVIEWTYPE = "previewtype";
  protected static final String FIELD_BIG_ATTACH_PROTOCOLTYPE = "protocoltype";
  protected static final String FIELD_BIG_ATTACH_SIZE = "size";
  protected static final String FIELD_BIG_ATTACH_STORAGENAME = "keyname";
  protected static final String FIELD_BIG_ATTACH_TYPE = "type";
  protected static final String FIELD_CG_ACCOUNT_ID = "accountId";
  protected static final String FIELD_CG_COUNT = "count";
  protected static final String FIELD_CG_GGID = "ggid";
  protected static final String FIELD_CG_GID = "gid";
  protected static final String FIELD_CG_ID = "id";
  protected static final String FIELD_CG_NAME = "name";
  protected static final String FIELD_CG_SEQ = "sequence";
  protected static final String FIELD_CONTACT_ADDR = "address";
  protected static final String FIELD_CONTACT_AID = "accountid";
  protected static final String FIELD_CONTACT_CID = "cid";
  protected static final String FIELD_CONTACT_FULL_PINYIN = "fullpinyin";
  protected static final String FIELD_CONTACT_GID = "gid";
  protected static final String FIELD_CONTACT_HASH = "hash";
  protected static final String FIELD_CONTACT_HASH_TYPE = "hashtype";
  protected static final String FIELD_CONTACT_HISTORY = "history";
  protected static final String FIELD_CONTACT_ID = "id";
  protected static final String FIELD_CONTACT_MARK = "mark";
  protected static final String FIELD_CONTACT_NAME = "name";
  protected static final String FIELD_CONTACT_OFFLINE_TYPE = "offlinetype";
  protected static final String FIELD_CONTACT_PINYIN = "pinyin";
  protected static final String FIELD_CONTACT_TYPE = "type";
  protected static final String FIELD_CONTACT_UIN = "uin";
  protected static final String FIELD_CONTACT_VIP = "vip";
  protected static final String FIELD_EDIT_ATTACH_ACCOUNTID = "accountid";
  protected static final String FIELD_EDIT_ATTACH_ICON = "icon";
  protected static final String FIELD_EDIT_ATTACH_ID = "id";
  protected static final String FIELD_EDIT_ATTACH_KEY = "key";
  protected static final String FIELD_EDIT_ATTACH_MAILID = "mailid";
  protected static final String FIELD_EDIT_ATTACH_NAME = "name";
  protected static final String FIELD_EDIT_ATTACH_SIZE = "size";
  protected static final String FIELD_EDIT_ATTACH_TYPE = "type";
  protected static final String FIELD_EDIT_ATTACH_URL = "url";
  protected static final String FIELD_FD_ACCOUNTID = "accountId";
  protected static final String FIELD_FD_FOLDERID = "folderId";
  protected static final String FIELD_FD_ID = "id";
  protected static final String FIELD_FD_NAME = "name";
  protected static final String FIELD_FD_PERSISTENCE = "persistence";
  protected static final String FIELD_FD_PROCESSING = "processing";
  protected static final String FIELD_FD_SECTION = "section";
  protected static final String FIELD_FD_SEQUENCE = "sequence";
  protected static final String FIELD_FD_SHOULDSHOW = "shouldShow";
  protected static final String FIELD_FD_TYPE = "type";
  protected static final String FIELD_FR_ACCOUNT_ID = "accountId";
  protected static final String FIELD_FR_CLI_CONV_UR_CNT = "cliConvUnreadCount";
  protected static final String FIELD_FR_CLI_UR_CNT = "cliUnreadCount";
  protected static final String FIELD_FR_COLORID = "colorId";
  protected static final String FIELD_FR_DISPLAY = "isDisplay";
  protected static final String FIELD_FR_FROMTIME = "fromtime";
  protected static final String FIELD_FR_HAS_NEW = "hasNewMail";
  protected static final String FIELD_FR_ID = "id";
  protected static final String FIELD_FR_LAST_CLI_CONV_UR_CNT = "cliLastConvUnreadCount";
  protected static final String FIELD_FR_LAST_CLI_UR_CNT = "cliLastcliUnreadCount";
  protected static final String FIELD_FR_LOCKED = "locked";
  protected static final String FIELD_FR_NAME = "name";
  protected static final String FIELD_FR_OVERDUE = "overdue";
  protected static final String FIELD_FR_PARENT_NAME = "parentname";
  protected static final String FIELD_FR_PERSONAL_CNT = "personalCount";
  protected static final String FIELD_FR_PID = "parentId";
  protected static final String FIELD_FR_POPEMAIL = "popEmail";
  protected static final String FIELD_FR_POPID = "popId";
  protected static final String FIELD_FR_PUSH = "push";
  protected static final String FIELD_FR_REMOTE_ID = "remoteId";
  protected static final String FIELD_FR_SEQ = "sequence";
  protected static final String FIELD_FR_SILENT = "silent";
  protected static final String FIELD_FR_SINCE = "since";
  protected static final String FIELD_FR_SVR_CNT = "svrCount";
  protected static final String FIELD_FR_SVR_UR_CNT = "svrUnreadCount";
  protected static final String FIELD_FR_SYNC_KEY = "syncKey";
  protected static final String FIELD_FR_SYNC_STATE = "syncState";
  protected static final String FIELD_FR_TYPE = "type";
  protected static final String FIELD_FR_VIRTUAL = "isVirtual";
  protected static final String FIELD_ICS_EVENT_ACCOUNT_ID = "accountId";
  protected static final String FIELD_ICS_EVENT_ALLDAY = "allday";
  protected static final String FIELD_ICS_EVENT_ATTENDEE = "attendee";
  protected static final String FIELD_ICS_EVENT_BODY = "body";
  protected static final String FIELD_ICS_EVENT_BODY_TYPE = "bodyType";
  protected static final String FIELD_ICS_EVENT_CREATE_TIME = "createTime";
  protected static final String FIELD_ICS_EVENT_DAY_OF_MONTH = "dayOfMonth";
  protected static final String FIELD_ICS_EVENT_DAY_OF_WEEK = "dayOfWeek";
  protected static final String FIELD_ICS_EVENT_END_TIME = "endTime";
  protected static final String FIELD_ICS_EVENT_ETAG = "etag";
  protected static final String FIELD_ICS_EVENT_FIRST_DAY_OF_WEEK = "firstDayOfWeek";
  protected static final String FIELD_ICS_EVENT_FOLDER_ID = "folderId";
  protected static final String FIELD_ICS_EVENT_FOLDER_TYPE = "folderType";
  protected static final String FIELD_ICS_EVENT_ID = "id";
  protected static final String FIELD_ICS_EVENT_ISDECLINE = "isDecline";
  protected static final String FIELD_ICS_EVENT_IS_LEAP_MONTH = "isLeapMonth";
  protected static final String FIELD_ICS_EVENT_LOCATION = "location";
  protected static final String FIELD_ICS_EVENT_MEETING_STATUS = "meeting_status";
  protected static final String FIELD_ICS_EVENT_MODIFY_TIME = "modifyTime";
  protected static final String FIELD_ICS_EVENT_MONTH_OF_YEAR = "monthOfYear";
  protected static final String FIELD_ICS_EVENT_ORGANIZER_EMAIL = "organizerEmail";
  protected static final String FIELD_ICS_EVENT_ORGANIZER_NAME = "organizerName";
  protected static final String FIELD_ICS_EVENT_PATH = "path";
  protected static final String FIELD_ICS_EVENT_RECURRENCE_CALENDAR_TYPE = "calendarType";
  protected static final String FIELD_ICS_EVENT_RECURRENCE_INTERVAL = "interval";
  protected static final String FIELD_ICS_EVENT_RECURRENCE_TYPE = "recurrenceType";
  protected static final String FIELD_ICS_EVENT_RECURRENCE_UNTIL = "until";
  protected static final String FIELD_ICS_EVENT_RELATE_ID = "relateId";
  protected static final String FIELD_ICS_EVENT_RELATE_TYPE = "relateType";
  protected static final String FIELD_ICS_EVENT_REMINDER = "reminder";
  protected static final String FIELD_ICS_EVENT_REMOTE_MAIL_ID = "mailId";
  protected static final String FIELD_ICS_EVENT_RESPONSE_TYPE = "responseType";
  protected static final String FIELD_ICS_EVENT_SENSITIVITY = "sensitivity";
  protected static final String FIELD_ICS_EVENT_SERVER_ID = "serverId";
  protected static final String FIELD_ICS_EVENT_START_TIME = "startTime";
  protected static final String FIELD_ICS_EVENT_SUBJECT = "subject";
  protected static final String FIELD_ICS_EVENT_TIMEZONE = "timezone";
  protected static final String FIELD_ICS_EVENT_UID = "uid";
  protected static final String FIELD_ICS_EVENT_WEEK_OF_MONTH = "weekOfMonth";
  protected static final String FIELD_IM_ACCOUNT_ID = "accountId";
  protected static final String FIELD_IM_EDGE_TIME = "edgeTime";
  protected static final String FIELD_IM_FOLDER = "folder";
  protected static final String FIELD_IM_FOLDER_ID = "folderId";
  protected static final String FIELD_IM_ID = "id";
  protected static final String FIELD_IM_IDX = "idx";
  protected static final String FIELD_IM_MAIL_ID = "mailId";
  protected static final String FIELD_IM_MSG_ID = "msgId";
  protected static final String FIELD_IM_PAGE = "page";
  protected static final String FIELD_IM_REASON = "reason";
  protected static final String FIELD_IM_RESTORE = "restore";
  protected static final String FIELD_IM_SENDER_ADDRESS = "senderAddress";
  protected static final String FIELD_IM_SENDER_NAME = "senderName";
  protected static final String FIELD_IM_SUBJECT = "subject";
  protected static final String FIELD_IM_TIME = "time";
  protected static final String FIELD_MAIL_AGGREGATE_ID = "id";
  protected static final String FIELD_MAIL_AGGREGATE_VALUE = "value";
  protected static final String FIELD_MCFS_CONTENT = "content";
  protected static final String FIELD_MCFS_DOCID = "docid";
  protected static final String FIELD_MCS_CONTENT = "content";
  protected static final String FIELD_MCS_ID = "id";
  protected static final String FIELD_MCS_MAIL_ID = "mailId";
  protected static final String FIELD_MCS_TYPE = "type";
  protected static final String FIELD_MC_CONTENT = "content";
  protected static final String FIELD_MC_EXTRA = "extra";
  protected static final String FIELD_MC_ID = "id";
  protected static final String FIELD_MIFS_ABS = "abs";
  protected static final String FIELD_MIFS_ATTACH_NAME = "attachName";
  protected static final String FIELD_MIFS_DOC_ID = "docid";
  protected static final String FIELD_MIFS_RECEIVER = "receiver";
  protected static final String FIELD_MIFS_SENDER = "sender";
  protected static final String FIELD_MIFS_SUBJECT = "subject";
  protected static final String FIELD_MI_ABS = "abstract";
  protected static final String FIELD_MI_ACCT_ID = "accountId";
  protected static final String FIELD_MI_ATTR = "attr";
  protected static final String FIELD_MI_COLID = "colid";
  protected static final String FIELD_MI_CONV_CNT = "convCnt";
  protected static final String FIELD_MI_CONV_CONTACT_HASH = "convContactHash";
  protected static final String FIELD_MI_CONV_HASH = "convHash";
  protected static final String FIELD_MI_CONV_REF_HASH = "convRefHash";
  protected static final String FIELD_MI_CONV_TYPE = "convType";
  protected static final String FIELD_MI_CONV_UNREAD_CNT = "convUrCnt";
  protected static final String FIELD_MI_FROM_ADDR = "fromAddr";
  protected static final String FIELD_MI_FROM_ADDR_ID = "fromAddrId";
  protected static final String FIELD_MI_FROM_ADDR_NAME = "fromAddrName";
  protected static final String FIELD_MI_FR_ID = "folderId";
  protected static final String FIELD_MI_ID = "id";
  protected static final String FIELD_MI_IS_LOADED = "isLoaded";
  protected static final String FIELD_MI_IS_STAR = "isStar";
  protected static final String FIELD_MI_IS_TOPPED = "isTopped";
  protected static final String FIELD_MI_IS_UNREAD = "isUnread";
  protected static final String FIELD_MI_IS_VIP = "isVip";
  protected static final String FIELD_MI_LOCAL_COUNT = "localCount";
  protected static final String FIELD_MI_MESSAGE_ID = "messageId";
  protected static final String FIELD_MI_QQMAIL_AD_TYPE = "qqAdType";
  protected static final String FIELD_MI_QQMAIL_SPAM_TYPE = "qqSpamType";
  protected static final String FIELD_MI_QQMAIL_XQQSTYLE = "xqqstyle";
  protected static final String FIELD_MI_REF = "reference";
  protected static final String FIELD_MI_REMOTE_ID = "remoteId";
  protected static final String FIELD_MI_SENDER_ADDR = "senderAddr";
  protected static final String FIELD_MI_SENDER_ADDR_NAME = "senderAddrName";
  protected static final String FIELD_MI_SEND_STATUS = "sendStatus";
  protected static final String FIELD_MI_SEND_UTC = "sendutc";
  protected static final String FIELD_MI_SIZE = "size";
  protected static final String FIELD_MI_SUBJ = "subject";
  protected static final String FIELD_MI_SVR_KEY = "svrKey";
  protected static final String FIELD_MI_TAGS = "tags";
  protected static final String FIELD_MI_TOPPED_AD_TIME = "toppedAdTime";
  protected static final String FIELD_MI_UTC_RECENT_OPR = "utcRecentOpr";
  protected static final String FIELD_MI_UTC_RECV = "utcReceived";
  protected static final String FIELD_MI_UTC_SENT = "utcSent";
  protected static final String FIELD_MPI_BODY_ID = "bodyId";
  protected static final String FIELD_MPI_ID = "id";
  protected static final String FIELD_MPI_ITEM_ID = "itemId";
  protected static final String FIELD_MPI_ITEM_TYPE = "itemType";
  protected static final String FIELD_MPI_LINE_SIZE = "contentLineSize";
  protected static final String FIELD_MPI_MAIL_ID = "mid";
  protected static final String FIELD_MPI_SUB_TYPE = "contentSubType";
  protected static final String FIELD_MPI_TRANS_ENCODE = "contentTransferEncoding";
  protected static final String FIELD_MPI_TYPE = "contentType";
  protected static final String FIELD_MPI_TYPE_PARAMS = "contentTypeParams";
  protected static final String FIELD_MS_ABS = "abstract";
  protected static final String FIELD_MS_ACC_ID = "accountId";
  protected static final String FIELD_MS_BIG_ICON = "bigIcon";
  protected static final String FIELD_MS_COLID = "colid";
  protected static final String FIELD_MS_FROM_ADDR = "fromAddr";
  protected static final String FIELD_MS_FROM_NAME = "fromName";
  protected static final String FIELD_MS_ICON = "icon";
  protected static final String FIELD_MS_ID = "id";
  protected static final String FIELD_MS_IDX = "idx";
  protected static final String FIELD_MS_LINK = "link";
  protected static final String FIELD_MS_MID = "mid";
  protected static final String FIELD_MS_RECV = "utcReceived";
  protected static final String FIELD_MS_RMID = "remoteId";
  protected static final String FIELD_MS_SUBJ = "subject";
  protected static final String FIELD_MTC_CONTENT = "translate_content";
  protected static final String FIELD_MTC_ID = "id";
  protected static final String FIELD_MTC_SUBJ = "translate_subj";
  protected static final String FIELD_NL_ACCOUNT_ID = "accountId";
  protected static final String FIELD_NL_EMAIL = "email";
  protected static final String FIELD_NL_ID = "id";
  protected static final String FIELD_NL_IS_QQ = "isQQ";
  protected static final String FIELD_NL_TYPE = "type";
  protected static final String FIELD_OFF_LINE_OPER_ACC_ID = "accountid";
  protected static final String FIELD_OFF_LINE_OPER_CLASS = "class";
  protected static final String FIELD_OFF_LINE_OPER_ID = "id";
  protected static final String FIELD_OFF_LINE_OPER_INFO_ACC_ID = "accountid";
  protected static final String FIELD_OFF_LINE_OPER_INFO_FR_ID = "folderid";
  protected static final String FIELD_OFF_LINE_OPER_INFO_ID = "id";
  protected static final String FIELD_OFF_LINE_OPER_INFO_MAILID = "mailid";
  protected static final String FIELD_OFF_LINE_OPER_INFO_SVR_KEY = "svrkey";
  protected static final String FIELD_OFF_LINE_OPER_MAILID = "mailid";
  protected static final String FIELD_OFF_LINE_OPER_OPER = "oper";
  protected static final String FIELD_OFF_LINE_OPER_PARAM = "param";
  public static final String FIELD_POPULARIZE_ABSTRACTS = "abstracts";
  public static final String FIELD_POPULARIZE_ACTION = "action";
  public static final String FIELD_POPULARIZE_APP_INSTALL_ACTION = "appInstallAction";
  public static final String FIELD_POPULARIZE_APP_NAME = "popularizeAppName";
  public static final String FIELD_POPULARIZE_APP_VERSION = "popularizeAppVersion";
  public static final String FIELD_POPULARIZE_BANNER_HEIGHT = "bannerHeight";
  public static final String FIELD_POPULARIZE_BANNER_POSITION = "bannerPosition";
  public static final String FIELD_POPULARIZE_COMMERCIAL_CONFIG_HEAD = "commercialConfigHead";
  public static final String FIELD_POPULARIZE_COMMERCIAL_CONFIG_LIST = "commercialConfigList";
  public static final String FIELD_POPULARIZE_COMMERCIAL_CONFIG_MARK = "commercialConfigMark";
  public static final String FIELD_POPULARIZE_COMMERCIAL_CONFIG_TOOL = "commercialConfigTool";
  public static final String FIELD_POPULARIZE_COMMERCIAL_FROM_EMAIL = "commercialFromEmail";
  public static final String FIELD_POPULARIZE_COMMERCIAL_FROM_NICK = "commercialFromNick";
  public static final String FIELD_POPULARIZE_CONDITION = "condition";
  public static final String FIELD_POPULARIZE_CONTENT = "content";
  public static final String FIELD_POPULARIZE_DURATION = "duration";
  public static final String FIELD_POPULARIZE_END_TIME = "endTime";
  public static final String FIELD_POPULARIZE_ID = "id";
  public static final String FIELD_POPULARIZE_IMAGE_MD5 = "imageMd5";
  public static final String FIELD_POPULARIZE_IMAGE_URL = "imageUrl";
  public static final String FIELD_POPULARIZE_IS_CANCEL = "isCancel";
  public static final String FIELD_POPULARIZE_IS_CLICK = "isClick";
  public static final String FIELD_POPULARIZE_IS_OPEN = "isOpen";
  public static final String FIELD_POPULARIZE_IS_READ = "isRead";
  public static final String FIELD_POPULARIZE_IS_RENDER = "isRender";
  public static final String FIELD_POPULARIZE_LAST_RENDER_TIME = "lastRenderTime";
  public static final String FIELD_POPULARIZE_MOVE = "move";
  public static final String FIELD_POPULARIZE_NEED_QQ_ACCOUNT = "needQQAccount";
  public static final String FIELD_POPULARIZE_NEED_WIFI = "needWifi";
  public static final String FIELD_POPULARIZE_OPEN_URL = "openUrl";
  public static final String FIELD_POPULARIZE_PAGE = "page";
  public static final String FIELD_POPULARIZE_PRIORITY = "priority";
  public static final String FIELD_POPULARIZE_RELATEDID = "relatedId";
  public static final String FIELD_POPULARIZE_REPORT_ID = "reportId";
  public static final String FIELD_POPULARIZE_RESOURCE_TYPE = "resourceType";
  public static final String FIELD_POPULARIZE_SERVER_ID = "serverId";
  public static final String FIELD_POPULARIZE_SESSION_TYPE = "sessionType";
  public static final String FIELD_POPULARIZE_SHOW_TYPE = "showType";
  public static final String FIELD_POPULARIZE_START_TIME = "startTime";
  public static final String FIELD_POPULARIZE_SUBJECT = "subject";
  public static final String FIELD_POPULARIZE_SUB_IMAGE_MD5 = "subImageMd5";
  public static final String FIELD_POPULARIZE_SUB_IMAGE_URL = "subImageUrl";
  public static final String FIELD_POPULARIZE_SUB_INFOMATION = "subInformation";
  public static final String FIELD_POPULARIZE_SUB_INFOMATION_DATA = "subInformationData";
  public static final String FIELD_POPULARIZE_SUB_ITEM_ACTION = "action";
  public static final String FIELD_POPULARIZE_SUB_ITEM_BOTTOM_RADIO = "bottomRadio";
  public static final String FIELD_POPULARIZE_SUB_ITEM_CONDITION = "condition";
  public static final String FIELD_POPULARIZE_SUB_ITEM_ID = "id";
  public static final String FIELD_POPULARIZE_SUB_ITEM_IMAGE_MD5 = "imageMd5";
  public static final String FIELD_POPULARIZE_SUB_ITEM_IMAGE_URL = "imageUrl";
  public static final String FIELD_POPULARIZE_SUB_ITEM_IS_CANCEL = "isCancel";
  public static final String FIELD_POPULARIZE_SUB_ITEM_IS_CLICK = "isClick";
  public static final String FIELD_POPULARIZE_SUB_ITEM_IS_CLICK_MYAPP = "isClickMyApp";
  public static final String FIELD_POPULARIZE_SUB_ITEM_IS_RELATED = "isRelated";
  public static final String FIELD_POPULARIZE_SUB_ITEM_IS_RENDER = "isRender";
  public static final String FIELD_POPULARIZE_SUB_ITEM_LAST_RENDER_TIME = "lastRenderTime";
  public static final String FIELD_POPULARIZE_SUB_ITEM_OPEN_URL = "openUrl";
  public static final String FIELD_POPULARIZE_SUB_ITEM_POPULARIZE_ID = "popularizeId";
  public static final String FIELD_POPULARIZE_SUB_ITEM_POSITION = "position";
  public static final String FIELD_POPULARIZE_SUB_ITEM_SEQUENCE = "sequence";
  public static final String FIELD_POPULARIZE_SUB_ITEM_SERVER_ID = "serverId";
  public static final String FIELD_POPULARIZE_SUB_ITEM_SHOW_TYPE = "showType";
  public static final String FIELD_POPULARIZE_SUB_ITEM_TEXT = "text";
  public static final String FIELD_POPULARIZE_TYPE = "type";
  public static final String FIELD_POPULARIZE_WEIGHT = "weight";
  protected static final String FIELD_RA_ACCOUNT_ID = "ruleAccId";
  protected static final String FIELD_RA_ADDR_ID = "ruleAddrId";
  protected static final String FIELD_RA_TYPE = "ruleType";
  protected static final String FIELD_RCC_CID = "cid";
  protected static final String FIELD_RCC_KEY = "key";
  protected static final String FIELD_RCC_TYPE = "type";
  protected static final String FIELD_RCC_VALUE = "value";
  protected static final String FIELD_RCE_CID = "cid";
  protected static final String FIELD_RCE_EMAIL = "email";
  protected static final String FIELD_RCE_EMAIL_HASH = "emailHash";
  protected static final String FIELD_RCE_FREQ = "freq";
  protected static final String FIELD_RCE_FREQ_UPDATE_TIME = "freqUpdateTime";
  protected static final String FIELD_RMAS_ADDR_ADDR = "address";
  protected static final String FIELD_RMAS_ADDR_ID = "addrId";
  protected static final String FIELD_RMAS_ADDR_NAME = "addrName";
  protected static final String FIELD_RMAS_ADDR_SEQ = "seq";
  protected static final String FIELD_RMAS_ADDR_UIN = "uin";
  protected static final String FIELD_RMAS_MID = "mid";
  protected static final String FIELD_RMAS_ROLE_TYPE = "roleType";
  protected static final String FIELD_RMAS_UID = "uid";
  protected static final String FIELD_RMA_ADDR_ADDR = "address";
  protected static final String FIELD_RMA_ADDR_ID = "addrId";
  protected static final String FIELD_RMA_ADDR_NAME = "addrName";
  protected static final String FIELD_RMA_ADDR_SEQ = "seq";
  protected static final String FIELD_RMA_ADDR_UIN = "uin";
  protected static final String FIELD_RMA_MID = "mid";
  protected static final String FIELD_RMA_ROLE_TYPE = "roleType";
  protected static final String FIELD_RMA_UID = "uid";
  protected static final String FIELD_RMR_ID = "id";
  protected static final String FIELD_RMR_MID = "mid";
  protected static final String FIELD_RMR_RECEIVER = "receiver";
  protected static final String FIELD_RMR_STATUS = "status";
  protected static final String FIELD_RMT_MID = "mid";
  protected static final String FIELD_RMT_TAG_ID = "tagId";
  protected static final String FIELD_RMT_UID = "uid";
  protected static final String FIELD_RM_ACCT_ID = "accountId";
  protected static final String FIELD_RM_ACTION = "action";
  protected static final String FIELD_RM_ALIAS = "alias";
  protected static final String FIELD_RM_FIELD_NAME = "fieldName";
  protected static final String FIELD_RM_ID = "ruleId";
  protected static final String FIELD_RM_OPERATOR = "operator";
  protected static final String FIELD_RM_PARAM = "param";
  protected static final String FIELD_RM_VAL = "val";
  protected static final String FIELD_RM_VAL2 = "val2";
  protected static final String FIELD_RR_ACCOUNT_ID = "rAccId";
  protected static final String FIELD_RR_ADDR_ID = "rAddrId";
  protected static final String FIELD_RR_SYNC_FLAG = "rSyncFlag";
  public static final String FIELD_SETTING_ACCOUNT_ID = "accountid";
  public static final String FIELD_SETTING_ID = "id";
  public static final String FIELD_SETTING_TYPE = "type";
  public static final String FIELD_SETTING_VALUE = "val";
  protected static final String FIELD_TSMU_MI_ID = "mailId";
  protected static final String FIELD_TSMU_SEARCH_TYPE = "searchType";
  protected static final String FIELD_TSMU_UTC_SEARCH = "utcSearch";
  protected static final String FILENAME = "QMMailDB";
  protected static final String INDEX_BIG_ATTACH = "INDEX_FTN_ATTACH";
  protected static final String INDEX_CONTACT = "INDEX_CONTACT";
  protected static final String INDEX_CONTACT_GROUP = "INDEX_CONTACT_GROUP";
  protected static final String INDEX_FOLDER = "INDEX_FOLDER";
  protected static final String INDEX_MAIL_ATTACH = "QM_MAIL_ATTACH_INDEX";
  protected static final String INDEX_MAIL_ATTACH_ORDER_IDX = "QM_MAIL_ATTACH_ORDER_IDX_INDEX";
  protected static final String INDEX_MAIL_CONTENT = "INDEX_MAIL_CONTENT";
  protected static final String INDEX_MAIL_INFO = "INDEX_MAIL_INFO";
  protected static final String INDEX_MAIL_INFO_CONV = "INDEX_MAIL_INFO_CONV";
  protected static final String INDEX_MAIL_INFO_FOLDER_ID = "INDEX_MAIL_INFO_FOLDER_ID";
  protected static final String INDEX_REF_CONTACT_CUSTOM = "INDEX_REF_CONTACT_CUSTOM";
  protected static final String INDEX_REF_CONTACT_EMAIL = "INDEX_REF_CONTACT_EMAIL";
  protected static final String INDEX_REL_MAIL_ADDR = "INDEX_REL_MAIL_ADDR";
  protected static final String INDEX_REL_MAIL_ADDR_SENDER = "INDEX_REL_MAIL_ADDR_SENDER";
  protected static final String INDEX_REL_MAIL_RECALL = "INDEX_REL_MAIL_RECALL";
  protected static final String TABLE_ATTACH_PART_INFO = "QM_MAIL_ATTACH_PART_INFO";
  protected static final String TABLE_BIG_ATTACH = "QM_FTN_ATTACH";
  protected static final String TABLE_CONTACT = "QM_CONTACT";
  protected static final String TABLE_CONTACT_GROUP = "QM_CONTACT_GROUP";
  protected static final String TABLE_EDIT_ATTACH = "QM_EDIT_ATTACH";
  protected static final String TABLE_FOLDER = "QM_FOLDER";
  protected static final String TABLE_FOLDERDATA = "QM_FOLDERDATA";
  protected static final String TABLE_ICS_EVENT = "QM_ICS_EVENT";
  protected static final String TABLE_INQUIRY_MAIL = "QM_INQUIRY_MAIL";
  public static final String TABLE_MAIL_AGGREGATE = "QM_MAIL_AGGREGATE";
  protected static final String TABLE_MAIL_ATTACH = "QM_MAIL_ATTACH";
  protected static final String TABLE_MAIL_CONTENT = "QM_MAIL_CONTENT";
  protected static final String TABLE_MAIL_CONTENT_SCALE = "QM_MAIL_CONTENT_SCALE";
  protected static final String TABLE_MAIL_INFO = "QM_MAIL_INFO";
  protected static final String TABLE_MAIL_PART_INFO = "QM_MAIL_PART_INFO";
  protected static final String TABLE_MAIL_SUBSCRIBE = "QM_MAIL_SUBSCRIBE";
  protected static final String TABLE_MAIL_TRANSLATE_CONTENT = "QM_MAIL_TRANSLATE_CONTENT";
  protected static final String TABLE_NAME_LIST = "QM_NAME_LIST";
  protected static final String TABLE_OFF_LINE_OPER = "QM_OFF_LINE_OPER";
  protected static final String TABLE_OFF_LINE_OPER_INFO = "QM_OFF_LINE_OPER_INFO";
  @Deprecated
  public static final String TABLE_POPULARIZE = "QM_POPULARIZE";
  @Deprecated
  public static final String TABLE_POPULARIZE_SUB_ITEM = "QM_POPULARIZE_SUBITEM";
  protected static final String TABLE_REF_CONTACT_CUSTOM = "QM_REF_CONTACT_CUSTOM";
  protected static final String TABLE_REF_CONTACT_EMAIL = "QM_REF_CONTACT_EMAIL";
  protected static final String TABLE_REL_MAIL_ADDR = "QM_REF_MAIL_ADDR";
  protected static final String TABLE_REL_MAIL_ADDR_SENDER = "QM_REF_MAIL_ADDR_SENDER";
  protected static final String TABLE_REL_MAIL_RECALL = "QM_REF_MAIL_RECALL";
  protected static final String TABLE_REL_MAIL_TAG = "QM_REF_MAIL_TAG";
  protected static final String TABLE_RULE_AD = "QM_RULE_AD";
  protected static final String TABLE_RULE_MAIL = "QM_RULE_MAIL";
  protected static final String TABLE_RULE_REJECT = "QM_RULE_REJECT";
  @Deprecated
  public static final String TABLE_SETTING = "QM_SETTING";
  protected static final String TABLE_TMP_EML_MAIL_ADDR = "QM_TMP_EML_MAIL_ADDR";
  protected static final String TABLE_TMP_EML_MAIL_INFO = "QM_TMP_EML_MAIL_INFO";
  protected static final String TABLE_TMP_SEARCH_MAIL_ADDR = "QM_TMP_SEARCH_MAIL_ADDR";
  protected static final String TABLE_TMP_SEARCH_MAIL_INFO = "QM_TMP_SEARCH_MAIL_INFO";
  protected static final String TABLE_TMP_SEARCH_MAIL_UTC = "QM_TMP_SEARCH_MAIL_UTC";
  protected static final String TAG = "QMMailSQLite";
  public static final int VALUE_RA_TYPE_MUST_BE_AD = 2;
  public static final int VALUE_RA_TYPE_NORMAL = 0;
  public static final int VALUE_RA_TYPE_NOT_AD = 1;
  public static final int VALUE_RMA_ROLE_TYPE_BCC = 4;
  public static final int VALUE_RMA_ROLE_TYPE_CC = 3;
  public static final int VALUE_RMA_ROLE_TYPE_FROM = 1;
  public static final int VALUE_RMA_ROLE_TYPE_GROUP = 5;
  public static final int VALUE_RMA_ROLE_TYPE_RLY = 6;
  public static final int VALUE_RMA_ROLE_TYPE_SENDER_LIST = 0;
  public static final int VALUE_RMA_ROLE_TYPE_TO = 2;
  protected static final String VIRTUAL_TABLE_MAIL_CONTENT_SEARCH = "QM_MAIL_CONTENT_FTS_SEARCH";
  protected static final String VIRTUAL_TABLE_MAIL_INFO_SEARCH = "QM_MAIL_INFO_FTS_SEARCH";
  protected static final SQLiteDatabase.CursorFactory cursorFactory = null;
  protected static final QMSQLiteDatabaseUpgradeManager upgradeManager = new QMSQLiteDatabaseUpgradeManager();
  public final QMAttachSQLite attach;
  public final QMContactSQLite contact;
  public final QMFolderSQLite folder;
  public final FolderDataSQLite folderData;
  public final InquiryMailSQLite inquiryMail;
  public final QMMailSQLite mail;
  public final NameListSQLite nameList;
  public final QMOffLineSQLite offLine;
  
  public QMMailSQLiteHelper(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, "QMMailDB", cursorFactory, upgradeManager.getVersion());
    if (paramBoolean)
    {
      this.folder = new QMFolderSQLite(paramContext);
      this.folderData = new FolderDataSQLite(paramContext);
      this.mail = new QMMailSQLite(paramContext);
      this.contact = new QMContactSQLite(paramContext);
      this.offLine = new QMOffLineSQLite(paramContext);
      this.inquiryMail = new InquiryMailSQLite(paramContext);
      this.nameList = new NameListSQLite(paramContext);
      this.attach = new QMAttachSQLite(paramContext);
      return;
    }
    this.folder = null;
    this.folderData = null;
    this.mail = null;
    this.contact = null;
    this.offLine = null;
    this.inquiryMail = null;
    this.nameList = null;
    this.attach = null;
  }
  
  public static void addCustomFunction(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.addCustomFunction("hashlong", 1, new QMMailSQLiteHelper.1());
    paramSQLiteDatabase.addCustomFunction("hashint", 1, new QMMailSQLiteHelper.2());
    paramSQLiteDatabase.addCustomFunction("hashpositiveint", 1, new QMMailSQLiteHelper.3());
  }
  
  public static void analyzeAll()
  {
    try
    {
      SQLiteDatabase.analyzeAll();
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "QMMailSQLite", "analyzeAll failed: " + localException);
    }
  }
  
  public static byte[] getBlob(Cursor paramCursor, String paramString)
  {
    return paramCursor.getBlob(paramCursor.getColumnIndex(paramString));
  }
  
  protected static int getColumnIndex(HashMap<String, Integer> paramHashMap, Cursor paramCursor, String paramString)
  {
    if (paramHashMap == null) {
      return paramCursor.getColumnIndex(paramString);
    }
    Integer localInteger2 = (Integer)paramHashMap.get(paramString);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null)
    {
      localInteger1 = Integer.valueOf(paramCursor.getColumnIndex(paramString));
      paramHashMap.put(paramString, localInteger1);
    }
    return localInteger1.intValue();
  }
  
  @Deprecated
  protected static String getInClause(int[] paramArrayOfInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(paramArrayOfInt[i]);
      if (i != j - 1) {
        localStringBuilder.append(",");
      }
      i += 1;
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static int getInt(Cursor paramCursor, String paramString)
  {
    return paramCursor.getInt(paramCursor.getColumnIndex(paramString));
  }
  
  public static long getLong(Cursor paramCursor, String paramString)
  {
    return paramCursor.getLong(paramCursor.getColumnIndex(paramString));
  }
  
  public static String getString(Cursor paramCursor, String paramString)
  {
    return paramCursor.getString(paramCursor.getColumnIndex(paramString));
  }
  
  public static void releaseMemory()
  {
    int i = SQLiteDatabase.releaseMemory();
    QMLog.log(4, "QMMailSQLite", "releaseSQLiteMemory: reduce " + i + " bytes");
  }
  
  public void createIndex(SQLiteDatabase paramSQLiteDatabase)
  {
    this.folder.createIndex(paramSQLiteDatabase);
    this.folderData.createIndex(paramSQLiteDatabase);
    this.mail.createIndex(paramSQLiteDatabase);
    this.contact.createIndex(paramSQLiteDatabase);
    this.offLine.createIndex(paramSQLiteDatabase);
    this.inquiryMail.createIndex(paramSQLiteDatabase);
    this.nameList.createIndex(paramSQLiteDatabase);
    this.attach.createIndex(paramSQLiteDatabase);
    paramSQLiteDatabase.execSQL("REINDEX");
  }
  
  public void createTable(SQLiteDatabase paramSQLiteDatabase)
  {
    this.folder.createTable(paramSQLiteDatabase);
    this.folderData.createTable(paramSQLiteDatabase);
    this.mail.createTable(paramSQLiteDatabase);
    this.contact.createTable(paramSQLiteDatabase);
    this.offLine.createTable(paramSQLiteDatabase);
    this.inquiryMail.createTable(paramSQLiteDatabase);
    this.nameList.createTable(paramSQLiteDatabase);
    this.attach.createTable(paramSQLiteDatabase);
  }
  
  public void dropIndex(SQLiteDatabase paramSQLiteDatabase)
  {
    this.folder.dropIndex(paramSQLiteDatabase);
    this.folderData.dropIndex(paramSQLiteDatabase);
    this.mail.dropIndex(paramSQLiteDatabase);
    this.contact.dropIndex(paramSQLiteDatabase);
    this.offLine.dropIndex(paramSQLiteDatabase);
    this.inquiryMail.dropIndex(paramSQLiteDatabase);
    this.nameList.dropIndex(paramSQLiteDatabase);
    this.attach.dropIndex(paramSQLiteDatabase);
  }
  
  public void dropTable(SQLiteDatabase paramSQLiteDatabase)
  {
    this.folder.dropTable(paramSQLiteDatabase);
    this.folderData.dropTable(paramSQLiteDatabase);
    this.mail.dropTable(paramSQLiteDatabase);
    this.contact.dropTable(paramSQLiteDatabase);
    this.offLine.dropTable(paramSQLiteDatabase);
    this.inquiryMail.dropTable(paramSQLiteDatabase);
    this.nameList.dropTable(paramSQLiteDatabase);
    this.attach.dropTable(paramSQLiteDatabase);
  }
  
  protected String getInClause(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramInt)
    {
      if (i != 0) {
        localStringBuilder.append(",");
      }
      localStringBuilder.append("?");
      i += 1;
    }
    return "(" + localStringBuilder.toString() + ")";
  }
  
  @Deprecated
  protected String getInClause(ArrayList<Integer> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(paramArrayList.get(i));
      if (i != j - 1) {
        localStringBuilder.append(",");
      }
      i += 1;
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  @Deprecated
  protected String getInClause(long[] paramArrayOfLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(paramArrayOfLong[i]);
      if (i != j - 1) {
        localStringBuilder.append(",");
      }
      i += 1;
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  @Deprecated
  protected String getInClause(String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    int j = paramArrayOfString.length;
    int i = 0;
    if (i < j)
    {
      String str = paramArrayOfString[i];
      if ((str == null) || (str.equals(""))) {}
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append("'").append(str).append("'");
        if (i != j - 1) {
          localStringBuilder.append(",");
        }
      }
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  @Deprecated
  protected String getLongInClause(ArrayList<Long> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(paramArrayList.get(i));
      if (i != j - 1) {
        localStringBuilder.append(",");
      }
      i += 1;
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  protected String getOrderByIds(String paramString, long[] paramArrayOfLong)
  {
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length == 0)) {
      return " " + paramString + " ";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" CASE ");
    localStringBuilder.append(paramString);
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      localStringBuilder.append(" WHEN ");
      localStringBuilder.append(paramArrayOfLong[i]);
      localStringBuilder.append(" THEN ");
      localStringBuilder.append(i);
      i += 1;
    }
    localStringBuilder.append(" END ");
    return localStringBuilder.toString();
  }
  
  public SQLiteDatabase getReadableDatabase()
  {
    return super.getReadableDatabase();
  }
  
  @Deprecated
  protected String getStringInClause(ArrayList<String> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    int j = paramArrayList.size();
    int i = 0;
    if (i < j)
    {
      String str = (String)paramArrayList.get(i);
      if ((str == null) || (str.equals(""))) {}
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append("'" + str + "'");
        if (i != j - 1) {
          localStringBuilder.append(",");
        }
      }
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void onConfigure(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onConfigure(paramSQLiteDatabase);
    addCustomFunction(paramSQLiteDatabase);
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    createTable(paramSQLiteDatabase);
    createIndex(paramSQLiteDatabase);
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    QMLog.log(4, "SQLiteDatbase", "Try Upgrade: from " + paramInt1 + " to " + paramInt2 + ", minVer:" + upgradeManager.getMinSupportVersion());
    if (paramInt1 < upgradeManager.getMinSupportVersion())
    {
      dropTable(paramSQLiteDatabase);
      dropIndex(paramSQLiteDatabase);
      createTable(paramSQLiteDatabase);
    }
    for (;;)
    {
      createIndex(paramSQLiteDatabase);
      return;
      if (upgradeManager.upgrade(this, paramSQLiteDatabase, paramInt1)) {
        QMLog.log(4, "SQLiteDatabase", "Upgraded from " + paramInt1 + " to " + paramInt2);
      } else {
        QMLog.log(4, "SQLiteDatabase", "No need upgrade from " + paramInt1 + " to " + paramInt2);
      }
    }
  }
  
  public static abstract class UnsupportedGetDatabase
    extends QMMailSQLiteHelper
  {
    public UnsupportedGetDatabase(Context paramContext, boolean paramBoolean)
    {
      super(paramBoolean);
    }
    
    public SQLiteDatabase getReadableDatabase()
    {
      throw new UnsupportedOperationException();
    }
    
    public SQLiteDatabase getWritableDatabase()
    {
      throw new UnsupportedOperationException();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailSQLiteHelper
 * JD-Core Version:    0.7.0.1
 */