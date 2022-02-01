package com.tencent.qqmail.model.mail;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.DatabaseUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.downloader.util.StringUtil;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.attachment.QMAttachSQLite;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.calendar.data.Attendee;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.cache.QMAggrConvMailCache;
import com.tencent.qqmail.model.contact.ContactsHistoryMailSearchInfo;
import com.tencent.qqmail.model.mail.callback.ReadMailCallback;
import com.tencent.qqmail.model.mail.rule.MailRuleInfo;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContact.ContactType;
import com.tencent.qqmail.model.qmdomain.MailContent;
import com.tencent.qqmail.model.qmdomain.MailEditAttach;
import com.tencent.qqmail.model.qmdomain.MailGroupContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailRecall;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.qmdomain.MailTag;
import com.tencent.qqmail.model.qmdomain.MailTranslate;
import com.tencent.qqmail.model.qmdomain.MailVote;
import com.tencent.qqmail.model.qmdomain.ObjectSerializable;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.model.qmdomain.SearchInfo;
import com.tencent.qqmail.model.qmdomain.SubscribeMail;
import com.tencent.qqmail.protocol.ItemBodyStructureHelper.MailItemBodyStructureInfo;
import com.tencent.qqmail.protocol.MailUtil;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.trd.guava.Maps;
import com.tencent.qqmail.utilities.QMMath;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

public class QMMailSQLite
  extends QMMailSQLiteHelper.UnsupportedGetDatabase
{
  public static final String ATTR_IS_AD_CONV = " attr&2048 ";
  public static final String ATTR_IS_AD_MAIL = " attr&512 ";
  private static final String ATTR_IS_AGGREGATE_LIST = "( NOT  attr&2048  OR  attr&16384 )";
  private static final String ATTR_IS_HYBIRD = " attr&16384 ";
  public static final String ATTR_IS_SUBSCRIBE_CONV = " attr&8192 ";
  private static final String ATTR_IS_SUBSCRIBE_LOADED = " attr&262144 ";
  public static final String ATTR_IS_SUBSCRIBE_MAIL = " attr&4096 ";
  private static final String ATTR_NEED_CHECK_MAIL = "(attr&1024 AND  NOT attr&65536 )";
  private static final String ATTR_NEED_SYNC = " attr&256 ";
  public static final String ATTR_NOT_AD_CONV = " NOT  attr&2048 ";
  private static final String ATTR_NOT_HYBIRD = " NOT  attr&16384 ";
  public static final String ATTR_NOT_SUBSCRIBE_CONV = " NOT  attr&8192 ";
  private static final String ATTR_NOT_SUBSCRIBE_LOADED = " NOT  attr&262144 ";
  public static final String ATTR_NOT_SUBSCRIBE_MAIL = " NOT  attr&4096 ";
  private static final String CASE_QQMAIL_CONV_CHILD;
  private static final String CONDI_ACCOUNT;
  private static final String CONDI_AD_IN_SETTING;
  private static final String CONDI_AD_RULE_WITH_ALIAS = " ( EXISTS (SELECT * FROM QM_RULE_AD AS R  WHERE R.ruleAddrId=$alias$.fromAddrId AND ruleType=$type$) ) ";
  private static final String CONDI_CONV = "convHash= ? AND convType = -1";
  private static final String CONDI_CONV_ALL_CHILD;
  private static final String CONDI_CONV_CHILD;
  private static final String CONDI_CONV_FOLDER_CHILD = "mi.convType IN (-1,0) AND mi.convHash=QM_MAIL_INFO.convHash AND (mi.folderId=QM_MAIL_INFO.folderId)";
  private static final String CONDI_CONV_FOLDER_CHILD_ = "mi.convType IN (-1,0) AND mi.convHash=QM_MAIL_INFO.convHash AND (mi.folderId=QM_MAIL_INFO.folderId";
  private static final String CONDI_CONV_HASH_IN = "SELECT id FROM QM_MAIL_INFO WHERE convHash IN$inClause$ AND convType=1";
  private static final String CONDI_CONV_IN_SETTING;
  private static final String CONDI_CONV_PARENT_ID = "SELECT M.id FROM QM_MAIL_INFO AS M INNER JOIN QM_MAIL_INFO AS MM  ON M.convType=1 AND MM.convType<>1 AND MM.id IN$inClause$ AND MM.convHash=M.convHash AND CASE WHEN MM.convType=-1 THEN MM.folderId=M.folderId ELSE 1 END";
  private static final String CONDI_EXCEPT_INBOX_WITH_ALIAS = " EXISTS (SELECT * FROM QM_FOLDER AS FD  WHERE FD.id=$alias$.folderId AND FD.type<>1)";
  private static final String CONDI_IN_INBOX_WITH_ALIAS = " EXISTS (SELECT * FROM QM_FOLDER AS FD  WHERE FD.id=$alias$.folderId AND FD.type=1)";
  private static final String CONDI_IN_SUBSCRIBE_FOLDER_WITH_ALIAS = " EXISTS (SELECT id,type FROM QM_FOLDER AS FD  WHERE FD.id=$alias$.folderId AND FD.type=15)";
  public static final String CONDI_IS_BLACKLIST_AD_MAIL;
  public static final String CONDI_IS_BLACKLIST_AD_MAIL_WITH_ALIAS = " ( EXISTS (SELECT * FROM QM_RULE_AD AS R  WHERE R.ruleAddrId=$alias$.fromAddrId AND ruleType=$type$) ) ".replace("$type$", "2");
  public static final String CONDI_IS_WHITELIST_AD_MAIL;
  public static final String CONDI_IS_WHITELIST_AD_MAIL_WITH_ALIAS = " ( EXISTS (SELECT * FROM QM_RULE_AD AS R  WHERE R.ruleAddrId=$alias$.fromAddrId AND ruleType=$type$) ) ".replace("$type$", "1");
  private static final String CONDI_QQMAIL_CONV_AFFECT_FOLDERS = "SELECT DISTINCT folderId FROM QM_MAIL_INFO WHERE isLoaded=1 AND convType=1 AND convHash IN$inClause$";
  private static final String CONDI_QQMAIL_EMPYT_CONV_PARENT = "SELECT id FROM QM_MAIL_INFO INNER JOIN(SELECT folderId AS fid,convHash AS ch FROM QM_MAIL_INFO WHERE convType=1 AND convHash IN$inClause$) ON folderId=fid AND convHash=ch AND convType=1 AND isLoaded=1 AND NOT EXISTS(SELECT * FROM QM_MAIL_INFO WHERE convType=-1 AND convHash=ch AND folderId=fid)";
  private static final String CONDI_QQMAIL_SINCE_MAIL = " AND attr&256 AND utcSent>=? ORDER BY utcSent ASC  LIMIT 1";
  private static final String CONDI_SINCE = "utcSent>=?";
  private static final String CONDI_SUBS_IN_SETTING;
  private static final String IGNORE_SENT = " M.folderId NOT IN (SELECT id FROM QM_FOLDER WHERE type IN (3))";
  private static final String IGNORE_SILENT = " (M.folderId=0 OR NOT EXISTS(SELECT silent FROM QM_FOLDER WHERE id = M.folderId AND silent= 1)) ";
  private static final String IGNORE_SPAM_TRASH_DRAFT = " M.folderId NOT IN (SELECT id FROM QM_FOLDER WHERE type IN (5,6,4))";
  private static final String IGNORE_SPAM_TRASH_DRAFT_GROUP = " M.folderId NOT IN (SELECT id FROM QM_FOLDER WHERE type IN (5,6,8,4))";
  private static final String JOIN_AD_RULE = " LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId";
  private static final String JOIN_EMAIL_CONTACT = " LEFT OUTER JOIN QM_CONTACT AS E ON E.address=M.fromAddr";
  private static final String JOIN_MAIL_ADDR = " INNER JOIN QM_REF_MAIL_ADDR AS A ON M.id = A.mid AND A.roleType IN (1,5 ) ";
  private static final String JOIN_MAIL_CONTENT = " LEFT OUTER JOIN QM_MAIL_CONTENT AS C ON M.id=C.id";
  private static final String ORDER_MI_ASC = " ORDER BY utcSent ASC ";
  private static final String ORDER_MI_DESC = " ORDER BY utcSent DESC ";
  private static final String ORDER_MI_TOP = " ORDER BY utcSent DESC";
  private static final String ORDER_MI_TOPPED_AD = " ORDER BY utcSent+CASE WHEN(isUnread AND toppedAdTime>strftime('%s','now')) THEN 1000000000 ELSE 0 END DESC ";
  private static final String ORDER_MI_UTC_RECV = " ORDER BY utcReceived DESC ";
  private static final String ORDER_SEARCH = " ORDER BY utcSearch ASC ,utcReceived DESC ";
  private static final String ORDER_SUBSCRIBE = " ORDER BY utcReceived DESC, colid ASC ";
  private static final String SEARCH_ALL;
  private static final String SEARCH_AREA_ALL = "QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_CONTACT AS E ON E.address=M.fromAddr LEFT OUTER JOIN QM_MAIL_CONTENT AS C ON M.id=C.id";
  private static final String SEARCH_AREA_TYPE = "QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_CONTACT AS E ON E.address=M.fromAddr";
  private static final String SEARCH_EXCEPT_FOLDER = "EXISTS (SELECT * FROM QM_FOLDER AS FD WHERE FD.id=M.folderId AND FD.type NOT IN (6,5)) ";
  private static final String SEARCH_EXPAND_CONV;
  private static final String SEARCH_LIKE_INNER;
  private static final String SEARCH_MATCH_ALL_PARAM = "MIS.docid IN (SELECT MIS.docid FROM QM_MAIL_INFO_FTS_SEARCH AS MIS WHERE QM_MAIL_INFO_FTS_SEARCH MATCH $keyword$ UNION SELECT MCS.docid FROM QM_MAIL_CONTENT_FTS_SEARCH AS MCS WHERE MCS.content MATCH $keyword$)";
  private static final String SEARCH_MATCH_INNER;
  private static final String SEARCH_MATCH_TYPE_PARAM = "MIS.$type$ MATCH $keyword$";
  private static final String SEARCH_PARAM_ALL;
  private static final String SEARCH_PARAM_RECEIVER = " EXISTS (SELECT * FROM QM_REF_MAIL_ADDR AS AD LEFT OUTER JOIN QM_CONTACT AS EC  ON AD.address=EC.address WHERE AD.roleType <> 1  AND AD.mid=M.id AND (AD.addrName LIKE $keyword$ OR AD.address LIKE $keyword$ OR EC.name LIKE $keyword$ ))";
  private static final String SEARCH_PARAM_SENDER = " (M.fromAddr LIKE $keyword$  OR M.fromAddrName LIKE $keyword$  OR E.name LIKE $keyword$ ) ";
  private static final String SEARCH_PARAM_SUBJECT = " (M.subject LIKE $keyword$) ";
  private static final String SEARCH_TYPE_RECEIVER;
  private static final String SEARCH_TYPE_SENDER;
  private static final String SEARCH_TYPE_SUBJECT;
  private static final String SEARCH_WHERE_ACCOUNT = " $account$ AND EXISTS (SELECT * FROM QM_FOLDER AS FD WHERE FD.id=M.folderId AND FD.type NOT IN (6,5))  AND  NOT  attr&2048  AND  NOT  attr&8192 ";
  private static final String SEARCH_WHERE_FOLDER;
  private static final String SELECT_ALL_MAIL_COUNT = "SELECT COUNT(*) FROM QM_MAIL_INFO WHERE folderId = ?";
  private static final String SELECT_ALL_MAIL_POP_COUNT = "SELECT COUNT(*) FROM QM_MAIL_INFO";
  private static final String SELECT_ALL_MAIL_POP_UNREAD_COUNT = "SELECT COUNT(*) FROM QM_MAIL_INFO WHERE isUnread = 1";
  private static final String SELECT_CERTAIN_CONTACT_MAIL_INFO = "SELECT M.* FROM (SELECT DISTINCT M.convHash FROM QM_MAIL_INFO AS M WHERE (M.id IN(SELECT RMA.mid FROM QM_REF_MAIL_ADDR AS RMA WHERE RMA.addrId IN $inclause1$ AND ( RMA.roleType = 1 OR ( RMA.roleType IN ( 2,3,4) AND M.folderId IN (SELECT id FROM QM_FOLDER AS F WHERE F.accountId IN $inclause2$ AND F.type IN (3))))) AND accountId IN $inclause2$) OR (M.id IN (SELECT MAS.mid FROM QM_REF_MAIL_ADDR_SENDER AS MAS WHERE MAS.addrId IN $inclause1$) AND M.accountId IN $inclause2$)) AS MI INNER JOIN QM_MAIL_INFO AS M ON MI.convHash=M.convHash";
  private static final String SELECT_CERTAIN_CONTACT_MAIL_INFO_ = "SELECT DISTINCT M.convHash FROM QM_MAIL_INFO AS M WHERE (M.id IN(SELECT RMA.mid FROM QM_REF_MAIL_ADDR AS RMA WHERE RMA.addrId IN $inclause1$ AND ( RMA.roleType = 1 OR ( RMA.roleType IN ( 2,3,4) AND M.folderId IN (SELECT id FROM QM_FOLDER AS F WHERE F.accountId IN $inclause2$ AND F.type IN (3))))) AND accountId IN $inclause2$) OR (M.id IN (SELECT MAS.mid FROM QM_REF_MAIL_ADDR_SENDER AS MAS WHERE MAS.addrId IN $inclause1$) AND M.accountId IN $inclause2$)";
  private static final String SELECT_CONV_CHILD = "SELECT id FROM QM_MAIL_INFO WHERE convHash=? AND folderId IN(?,?) AND convType<>1";
  private static final String SELECT_CONV_CHILD_PARENT = "SELECT * FROM QM_MAIL_INFO AS mmi  WHERE mi.folderId=mmi.folderId AND mi.convHash=mmi.convHash AND mmi.convType=1";
  private static final String SELECT_CONV_PARENT = "(SELECT accountId AS aid,folderId AS fid,convHash AS ch,convType AS ct,id AS cid FROM QM_MAIL_INFO WHERE id IN $inClause$)";
  private static final String SELECT_ID_INCLUDE_CONV_CHILDS = " SELECT id FROM QM_MAIL_INFO INNER JOIN(SELECT id AS mid,folderId AS fid,convHash AS ch,convType AS ct FROM QM_MAIL_INFO WHERE id IN $inClause$) ON id=mid OR (convType=-1 AND convHash=ch AND folderId=fid AND ct=1)";
  private static final String SELECT_MAIL_INFO = "SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId";
  private static final String SELECT_MAIL_TAGS_INFO = "SELECT F.* FROM QM_REF_MAIL_TAG AS T LEFT OUTER JOIN QM_FOLDER AS F ON T.tagId = F.remoteId";
  private static final String SELECT_NEED_SYNC_MAIL_COUNT = "SELECT COUNT(*) FROM QM_MAIL_INFO WHERE folderId = ? AND attr & 256";
  private static final String SELECT_NEED_SYNC_MAIL_UNREAD_COUNT = "SELECT COUNT(*) FROM QM_MAIL_INFO WHERE folderId = ? AND attr & 256 AND isUnread=1";
  private static final String SELECT_SELF_MAIL_INFO_ = "SELECT DISTINCT convHash FROM QM_MAIL_INFO WHERE id IN(SELECT DISTINCT mid FROM QM_REF_MAIL_ADDR WHERE addrId IN$inClause$)";
  private static final String SELECT_SENT_FOLDER_ID = "(SELECT id FROM QM_FOLDER WHERE accountId=$accountId$ AND type=3)";
  private static final String SELECT_TAG_MAIL_INFO = "SELECT M.*, T.* FROM QM_REF_MAIL_TAG AS T LEFT OUTER JOIN QM_MAIL_INFO AS M ON T.mid=M.id AND T.tagId = ? ";
  private static final String SELECT_VIP_ADDR = "SELECT emailHash FROM QM_REF_CONTACT_EMAIL WHERE cid IN (SELECT id FROM QM_CONTACT WHERE vip = 1)";
  private static final String SELECT_VIP_MAIL_INFO = "SELECT M.* FROM (SELECT DISTINCT convHash FROM QM_MAIL_INFO WHERE fromAddrId IN(SELECT emailHash FROM QM_REF_CONTACT_EMAIL WHERE cid IN (SELECT id FROM QM_CONTACT WHERE vip = 1)) OR id IN (SELECT mid FROM QM_REF_MAIL_ADDR_SENDER WHERE addrId IN(SELECT emailHash FROM QM_REF_CONTACT_EMAIL WHERE cid IN (SELECT id FROM QM_CONTACT WHERE vip = 1)))) AS MI INNER JOIN QM_MAIL_INFO AS M ON MI.convHash=M.convHash";
  private static final String SELECT_VIP_MAIL_INFO_ = "SELECT DISTINCT convHash FROM QM_MAIL_INFO WHERE fromAddrId IN(SELECT emailHash FROM QM_REF_CONTACT_EMAIL WHERE cid IN (SELECT id FROM QM_CONTACT WHERE vip = 1)) OR id IN (SELECT mid FROM QM_REF_MAIL_ADDR_SENDER WHERE addrId IN(SELECT emailHash FROM QM_REF_CONTACT_EMAIL WHERE cid IN (SELECT id FROM QM_CONTACT WHERE vip = 1)))";
  private static final String TAG = "QMMailSQLite";
  private static final String UPDATE_CONV_STATUS;
  private static final String VIP_MAILLIST_FOLDER = " M.folderId NOT IN (SELECT ID FROM QM_FOLDER WHERE type IN (3,5,4,8,6))";
  private static boolean columnCacheForEMLInited = false;
  private static boolean columnCacheInited = false;
  private static final String getAllFolderId = "SELECT id FROM QM_FOLDER WHERE type=$inClause$";
  private static int[] mCacheColumnIndex;
  private static int[] mCacheColumnIndexForEML;
  public static final String queryAdvertiseMailList;
  public static final String queryAdvertiseMailListExpandConv;
  private static final String queryForAllRelativeContacts = "SELECT C.* FROM QM_MAIL_INFO AS M,QM_REF_MAIL_ADDR AS C  WHERE M.id = C.mid AND M.folderId IN $inClause$  ORDER BY mid,roleType,seq ASC";
  private static final String queryForRelativeContacts = "SELECT C.* FROM QM_MAIL_INFO AS M,QM_REF_MAIL_ADDR AS C  WHERE M.id = C.mid AND M.folderId IN $inClause$  AND C.roleType = 2 ORDER BY mid,roleType,seq ASC";
  private static final String queryLocalMailIds = "select M_TEMP.id from QM_MAIL_INFO as M_TEMP where M_TEMP.attr&33554432";
  private static final String queryMidWithAidAndMailHash = "SELECT RMA.mid FROM QM_REF_MAIL_ADDR AS RMA WHERE RMA.addrId IN $inclause1$ AND ( RMA.roleType = 1 OR ( RMA.roleType IN ( 2,3,4) AND M.folderId IN (SELECT id FROM QM_FOLDER AS F WHERE F.accountId IN $inclause2$ AND F.type IN (3))))";
  private static final String queryPopMailIds = "select M_TEMP.id from QM_MAIL_INFO as M_TEMP where M_TEMP.accountId in $inClause$";
  private static final String querySubscribeMailList;
  private static final String resetMailLoadedStatusExceptLocalMail = "update QM_MAIL_INFO set isLoaded = 0 where id not in (select M_TEMP.id from QM_MAIL_INFO as M_TEMP where M_TEMP.attr&33554432)";
  private static final String resetPopMailContentCompleteStatus = "update QM_MAIL_INFO set attr=attr&(~16777216) where id in (select M_TEMP.id from QM_MAIL_INFO as M_TEMP where M_TEMP.accountId in $inClause$)";
  private static final String resetTranslateStatus = "update QM_MAIL_INFO set attr=attr&(~2)&(~4294967296)&(~8589934592) where id in (select id from QM_MAIL_INFO)";
  private static final String sqlClearTranslateContent = "DELETE FROM QM_MAIL_TRANSLATE_CONTENT";
  static final String sqlCountAllUnreadDraftMailInfo = "select 0";
  static final String sqlCountAllUnreadSelfMailInfo = "SELECT COUNT(*) FROM (SELECT M.* FROM (SELECT DISTINCT convHash FROM QM_MAIL_INFO WHERE id IN(SELECT DISTINCT mid FROM QM_REF_MAIL_ADDR WHERE addrId IN$inClause$)) AS MI INNER JOIN QM_MAIL_INFO AS M ON MI.convHash=M.convHash AND M.convType IN (1, 0) AND  M.folderId NOT IN (SELECT id FROM QM_FOLDER WHERE type IN (3)) AND  M.folderId NOT IN (SELECT id FROM QM_FOLDER WHERE type IN (5,6,8,4)) AND  NOT  attr&4096  GROUP BY M.id ORDER BY utcSent DESC) WHERE isUnread = 1";
  static final String sqlCountAllUnreadSentMailInfo;
  static final String sqlCountAllUnreadTrashMailInfo;
  private static final String sqlCountUnreadAdMail;
  private static final String sqlCountUnreadSubscribeMail;
  private static final String sqlCreate = "CREATE TABLE IF NOT EXISTS QM_MAIL_INFO(id integer primary key, accountId integer, folderId integer, remoteId varchar, colid integer, messageId varchar, svrKey varchar, subject varchar, abstract varchar, fromAddr varchar, fromAddrId integer, fromAddrName varchar, senderAddr varchar, senderAddrName varchar, utcSent integer, utcReceived integer, utcRecentOpr integer, isUnread integer, isStar integer, isLoaded integer, isTopped integer, attr integer, size integer, tags varchar, reference varchar, sendStatus integer, localCount integer, sendutc integer, convType integer, convHash integer, convRefHash integer, convContactHash integer, convCnt integer, convUrCnt integer, qqAdType integer, qqSpamType integer, xqqstyle integer, toppedAdTime integer default -1) ";
  private static final String sqlCreateConvChildIndex = "CREATE INDEX IF NOT EXISTS INDEX_MAIL_INFO_CONV ON QM_MAIL_INFO(folderId,convHash,convType)";
  private static final String sqlCreateFolderIdIndex = "CREATE INDEX IF NOT EXISTS INDEX_MAIL_INFO_FOLDER_ID ON QM_MAIL_INFO(folderId,fromAddrId,convType,attr)";
  private static final String sqlCreateIcsEvent = "CREATE TABLE IF NOT EXISTS QM_ICS_EVENT(id integer primary key, accountId integer, folderId integer, uid varchar, reminder integer, subject varchar, location varchar, body varchar, bodyType integer, allday integer, sensitivity integer, timezone varchar, startTime integer, endTime integer, createTime integer, modifyTime integer, path varchar, etag varchar, serverId varchar, folderType integer, recurrenceType integer, calendarType integer, interval integer, until integer, weekOfMonth integer, dayOfWeek integer, monthOfYear integer, dayOfMonth integer, isLeapMonth integer, firstDayOfWeek integer, relateId varchar, relateType integer, organizerName varchar, organizerEmail varchar,responseType integer, meeting_status integer, attendee varchar,isDecline integer,mailId varchar ) ";
  private static final String sqlCreateIcsEventForUpgrade = "CREATE TABLE IF NOT EXISTS QM_ICS_EVENT(id integer primary key, accountId integer, folderId integer, uid varchar, reminder integer, subject varchar, location varchar, body varchar, bodyType integer, allday integer, sensitivity integer, timezone varchar, startTime integer, endTime integer, createTime integer, modifyTime integer, path varchar, etag varchar, serverId varchar, folderType integer, recurrenceType integer, calendarType integer, interval integer, until integer, weekOfMonth integer, dayOfWeek integer, monthOfYear integer, dayOfMonth integer, isLeapMonth integer, firstDayOfWeek integer, relateId varchar, relateType integer, organizerName varchar, organizerEmail varchar,responseType integer, meeting_status integer, attendee varchar ,isDecline integer,mailId varchar ) ";
  private static final String sqlCreateIndex = "CREATE INDEX IF NOT EXISTS INDEX_MAIL_INFO ON QM_MAIL_INFO(convHash,convType,fromAddrId,folderId,accountId,attr)";
  private static final String sqlCreateMailAddr = "CREATE TABLE IF NOT EXISTS QM_REF_MAIL_ADDR (uid integer primary key, mid integer, addrId integer, roleType integer, addrName varchar, address varchar, uin varchar,seq integer default 0)";
  private static final String sqlCreateMailAddrIndex = "CREATE INDEX IF NOT EXISTS INDEX_REL_MAIL_ADDR ON QM_REF_MAIL_ADDR(mid,roleType,addrId)";
  private static final String sqlCreateMailAddrSender = "CREATE TABLE IF NOT EXISTS QM_REF_MAIL_ADDR_SENDER (uid integer primary key, mid integer, addrId integer, roleType integer, addrName varchar, address varchar, uin varchar,seq integer default 0)";
  private static final String sqlCreateMailAddrSenderIndex = "CREATE INDEX IF NOT EXISTS INDEX_REL_MAIL_ADDR_SENDER ON QM_REF_MAIL_ADDR_SENDER(addrId,roleType,mid)";
  private static final String sqlCreateMailAggregate = "CREATE TABLE IF NOT EXISTS QM_MAIL_AGGREGATE(id varchar primary key, value integer)";
  private static final String sqlCreateMailAggregateForUpgrade = "CREATE TABLE IF NOT EXISTS QM_MAIL_AGGREGATE(id varchar primary key, value integer)";
  private static final String sqlCreateMailContent = "CREATE TABLE IF NOT EXISTS QM_MAIL_CONTENT(id integer primary key, content varchar, extra varchar) ";
  private static final String sqlCreateMailContentFts = "CREATE VIRTUAL TABLE IF NOT EXISTS QM_MAIL_CONTENT_FTS_SEARCH USING FTS4(CONTENT=QM_MAIL_CONTENT,content varchar, tokenize=single)";
  private static final String sqlCreateMailContentIndex = "CREATE INDEX IF NOT EXISTS INDEX_MAIL_CONTENT ON QM_MAIL_CONTENT(id)";
  private static final String sqlCreateMailContentScale = "CREATE TABLE IF NOT EXISTS QM_MAIL_CONTENT_SCALE(id integer primary key, mailId integer, type integer, content varchar) ";
  private static final String sqlCreateMailInfoFts = "CREATE VIRTUAL TABLE IF NOT EXISTS QM_MAIL_INFO_FTS_SEARCH USING FTS4(sender varchar, receiver varchar, subject varchar, abs varchar, attachName varchar, tokenize=single)";
  private static final String sqlCreateMailPart = "CREATE TABLE IF NOT EXISTS QM_MAIL_PART_INFO(id integer primary key, mid integer,itemId integer,itemType varchar, bodyId varchar, contentType varchar, contentSubType varchar, contentTypeParams varchar, contentTransferEncoding varchar, contentLineSize varchar) ";
  private static final String sqlCreateMailRecall = "CREATE TABLE IF NOT EXISTS QM_REF_MAIL_RECALL (id integer primary key, mid integer, receiver varchar, status integer )";
  private static final String sqlCreateMailRecallForUpgrade = "CREATE TABLE IF NOT EXISTS QM_REF_MAIL_RECALL (id integer primary key, mid integer, receiver varchar, status integer )";
  private static final String sqlCreateMailRecallIndex = "CREATE INDEX IF NOT EXISTS INDEX_REL_MAIL_RECALL ON QM_REF_MAIL_RECALL(mid,receiver,status)";
  private static final String sqlCreateMailRecallIndexForUpgrade = "CREATE INDEX IF NOT EXISTS INDEX_REL_MAIL_RECALL ON QM_REF_MAIL_RECALL(mid,receiver,status)";
  private static final String sqlCreateMailSubscribe = "CREATE TABLE IF NOT EXISTS QM_MAIL_SUBSCRIBE (id integer primary key, mid integer, remoteId varchar, colid integer, accountId integer, idx integer, abstract varchar, subject varchar, fromName varchar, fromAddr varchar, link varchar,bigIcon varchar, icon varchar,utcReceived integer )";
  private static final String sqlCreateMailTag = "CREATE TABLE IF NOT EXISTS QM_REF_MAIL_TAG(uid integer primary key, mid integer, tagId varchar )";
  private static final String sqlCreateMailTranslateContent = "CREATE TABLE IF NOT EXISTS QM_MAIL_TRANSLATE_CONTENT(id integer primary key, translate_subj varchar, translate_content varchar) ";
  private static final String sqlCreateRuleAd = "CREATE TABLE IF NOT EXISTS QM_RULE_AD (ruleAddrId integer, ruleAccId integer, ruleType integer, UNIQUE(ruleAddrId,ruleAccId))";
  private static final String sqlCreateRuleMail = "CREATE TABLE IF NOT EXISTS QM_RULE_MAIL (ruleId integer primary key, accountId integer, fieldName integer, operator integer, val varchar, val2 varchar, action integer, param varchar, alias varchar )";
  private static final String sqlCreateRuleMailForUpgrade = "CREATE TABLE IF NOT EXISTS QM_RULE_MAIL (ruleId integer primary key, accountId integer, fieldName integer, operator integer, val varchar, val2 varchar, action integer, param varchar, alias varchar )";
  private static final String sqlCreateTmpEml;
  private static final String sqlCreateTmpEmlAddr;
  private static final String sqlCreateTmpEmlAddrForUpgrade;
  private static final String sqlCreateTmpEmlForUpgrade;
  private static final String sqlCreateTmpSearch;
  private static final String sqlCreateTmpSearchAddr;
  private static final String sqlCreateTmpSearchUtc = "CREATE TABLE IF NOT EXISTS QM_TMP_SEARCH_MAIL_UTC (searchType integer, mailId integer, utcSearch integer,  primary key (searchType,mailId))";
  private static final String sqlDeleteCacheMailContent = "delete from QM_MAIL_CONTENT where id not in (select M_TEMP.id from QM_MAIL_INFO as M_TEMP where M_TEMP.attr&33554432)";
  private static final String sqlDeleteTranslateItem = "DELETE FROM QM_MAIL_TRANSLATE_CONTENT WHERE id = ?";
  private static final String sqlDrop = "DROP TABLE IF EXISTS QM_MAIL_INFO";
  private static final String sqlDropConvChildIndex = "DROP INDEX IF EXISTS INDEX_MAIL_INFO_CONV";
  private static final String sqlDropFolderIdIndex = "DROP INDEX IF EXISTS INDEX_MAIL_INFO_FOLDER_ID";
  private static final String sqlDropIcsEvent = "DROP TABLE IF EXISTS QM_ICS_EVENT";
  private static final String sqlDropIndex = "DROP INDEX IF EXISTS INDEX_MAIL_INFO";
  private static final String sqlDropMailAddr = "DROP TABLE IF EXISTS QM_REF_MAIL_ADDR";
  private static final String sqlDropMailAddrIndex = "DROP INDEX IF EXISTS INDEX_REL_MAIL_ADDR";
  private static final String sqlDropMailAddrSender = "DROP TABLE IF EXISTS QM_REF_MAIL_ADDR_SENDER";
  private static final String sqlDropMailAddrSenderIndex = "DROP TABLE IF EXISTS INDEX_REL_MAIL_ADDR_SENDER";
  private static final String sqlDropMailAggregate = "DROP TABLE IF EXISTS QM_MAIL_AGGREGATE";
  private static final String sqlDropMailContent = "DROP TABLE IF EXISTS QM_MAIL_CONTENT";
  private static final String sqlDropMailContentIndex = "DROP INDEX IF EXISTS INDEX_MAIL_CONTENT";
  private static final String sqlDropMailContentScale = "DROP TABLE IF EXISTS QM_MAIL_CONTENT_SCALE";
  private static final String sqlDropMailPart = "DROP TABLE IF EXISTS QM_MAIL_PART_INFO";
  private static final String sqlDropMailRecall = "DROP TABLE IF EXISTS QM_REF_MAIL_RECALL";
  private static final String sqlDropMailRecallIndex = "DROP TABLE IF EXISTS INDEX_REL_MAIL_RECALL";
  private static final String sqlDropMailSubscribe = "DROP TABLE IF EXISTS QM_MAIL_SUBSCRIBE";
  private static final String sqlDropMailTag = "DROP TABLE IF EXISTS QM_REF_MAIL_TAG";
  private static final String sqlDropMailTranslateContent = "DROP TABLE IF EXISTS QM_MAIL_TRANSLATE_CONTENT";
  private static final String sqlDropRuleAd = "DROP TABLE IF EXISTS QM_RULE_AD";
  private static final String sqlDropRuleMail = "DROP TABLE IF EXISTS QM_RULE_MAIL";
  private static final String sqlDropTmpEml = "DROP TABLE IF EXISTS QM_TMP_EML_MAIL_INFO";
  private static final String sqlDropTmpEmlAddr = "DROP TABLE IF EXISTS QM_TMP_EML_MAIL_ADDR";
  private static final String sqlDropTmpSearch = "DROP TABLE IF EXISTS QM_TMP_SEARCH_MAIL_INFO";
  private static final String sqlDropTmpSearchAddr = "DROP TABLE IF EXISTS QM_TMP_SEARCH_MAIL_ADDR";
  private static final String sqlDropTmpSearchUtc = "DROP TABLE IF EXISTS QM_TMP_SEARCH_MAIL_UTC";
  private static final String sqlGetSubscribeCol = "SELECT * FROM QM_MAIL_SUBSCRIBE WHERE accountId=?  AND mid IN (  SELECT DISTINCT id FROM QM_MAIL_INFO WHERE accountId=?  AND  attr&4096  AND " + " EXISTS (SELECT id,type FROM QM_FOLDER AS FD  WHERE FD.id=$alias$.folderId AND FD.type=15)".replace("$alias$", "QM_MAIL_INFO") + " ORDER BY utcReceived DESC, colid ASC " + " LIMIT $count$  ) " + " ORDER BY utcReceived DESC, colid ASC ";
  private static final String sqlGetSubscribeColCnt = "SELECT COUNT(*) FROM QM_MAIL_SUBSCRIBE WHERE accountId=?  AND idx=" + SubscribeMail.INDEX_ENTRANCE_MAIL + " AND " + "mid" + " IN (  SELECT " + "id" + " FROM " + "QM_MAIL_INFO" + " WHERE " + "accountId" + "=?  AND " + " attr&4096 " + " AND " + " EXISTS (SELECT id,type FROM QM_FOLDER AS FD  WHERE FD.id=$alias$.folderId AND FD.type=15)".replace("$alias$", "QM_MAIL_INFO") + " ORDER BY utcReceived DESC, colid ASC " + " LIMIT $count$  ) ";
  private static final String sqlInsert = "REPLACE INTO QM_MAIL_INFO ( id,accountId,messageId,folderId,remoteId,colid,convType,attr,size,svrKey,subject,abstract,fromAddr,fromAddrId,fromAddrName,senderAddr,senderAddrName,utcSent,utcReceived,utcRecentOpr,isUnread,isLoaded,isStar,tags,reference,sendStatus,localCount,sendutc,messageId,convHash,convRefHash,convContactHash,convCnt,convUrCnt,qqAdType,qqSpamType,xqqstyle,toppedAdTime) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
  private static final String sqlInsertIcsEvent = "REPLACE INTO QM_ICS_EVENT ( id , accountId , folderId , uid , reminder , subject , location , body , bodyType , allday , sensitivity , timezone , startTime , endTime , createTime , modifyTime , path , etag , serverId , folderType , recurrenceType , calendarType , interval , until , weekOfMonth , dayOfWeek , monthOfYear , dayOfMonth , isLeapMonth , firstDayOfWeek , relateId , relateType , organizerName , organizerEmail ,responseType , meeting_status , attendee , isDecline , mailId ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
  private static final String sqlInsertMailAddr = "REPLACE INTO QM_REF_MAIL_ADDR (uid,mid,addrId,addrName,address,roleType,uin,seq) VALUES (?,?,?,?,?,?,?,?)";
  private static final String sqlInsertMailAddrSender = "REPLACE INTO QM_REF_MAIL_ADDR_SENDER (uid,mid,addrId,addrName,address,roleType,uin,seq) VALUES (?,?,?,?,?,?,?,?)";
  private static final String sqlInsertMailAggregate = "REPLACE INTO QM_MAIL_AGGREGATE ( id , value ) VALUES (?,?)";
  private static final String sqlInsertMailContent = "REPLACE INTO QM_MAIL_CONTENT ( id,content,extra) VALUES (?,?,?)";
  private static final String sqlInsertMailContentFts = "REPLACE INTO QM_MAIL_CONTENT_FTS_SEARCH ( docid,content) VALUES (?,?)";
  private static final String sqlInsertMailContentScale = "REPLACE INTO QM_MAIL_CONTENT_SCALE ( id,mailId,type,content) VALUES (?,?,?,?)";
  private static final String sqlInsertMailInfoFts = "REPLACE INTO QM_MAIL_INFO_FTS_SEARCH ( docid,sender,receiver,subject,abs,attachName) VALUES (?,?,?,?,?,?)";
  private static final String sqlInsertMailPart = "REPLACE INTO QM_MAIL_PART_INFO ( id,mid,itemId,itemType,bodyId,contentType,contentSubType,contentTypeParams,contentTransferEncoding,contentLineSize) VALUES (?,?,?,?,?,?,?,?,?,?)";
  private static final String sqlInsertMailRecall = "REPLACE INTO QM_REF_MAIL_RECALL (id,mid,receiver,status) VALUES (?,?,?,?)";
  private static final String sqlInsertMailSubscribe = "REPLACE INTO QM_MAIL_SUBSCRIBE ( id,mid,remoteId,colid,accountId,idx,abstract,subject,fromName,fromAddr,link,bigIcon,icon,utcReceived) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
  private static final String sqlInsertMailTag = "REPLACE INTO QM_REF_MAIL_TAG (uid,mid,tagId) VALUES (?,?,?)";
  private static final String sqlInsertMailTranslateContent = "REPLACE INTO QM_MAIL_TRANSLATE_CONTENT ( id,translate_subj,translate_content) VALUES (?,?,?)";
  private static final String sqlInsertRuleAd = "REPLACE INTO QM_RULE_AD (ruleAddrId,ruleAccId,ruleType) VALUES (?,?,?)";
  private static final String sqlInsertRuleMail = "REPLACE INTO QM_RULE_MAIL (ruleId,accountId,fieldName,operator,val,val2,action,param,alias) VALUES (?,?,?,?,?,?,?,?,?)";
  private static final String sqlInsertTmpEmlAddr;
  private static final String sqlInsertTmpSearch;
  private static final String sqlInsertTmpSearchAddr;
  private static final String sqlInsertTmpSearchUtc = "REPLACE INTO QM_TMP_SEARCH_MAIL_UTC ( searchType,mailId,utcSearch) VALUES (?,?,?)";
  private static final String sqlMailListInFolders;
  private static final String sqlQueryAccountIdFolderIdRemoteId = "SELECT accountId,folderId,remoteId,id,utcSent,utcReceived FROM QM_MAIL_INFO ORDER BY utcReceived LIMIT 500";
  private static final String sqlQueryAccountSyncUTC = "SELECT utcSent FROM QM_MAIL_INFO AS M WHERE accountId=? AND attr&256 ORDER BY utcSent DESC  LIMIT 1";
  private static final String sqlQueryAllDraftMailInfo;
  private static final String sqlQueryAllMailInfoByFolderType;
  private static final String sqlQueryAllSelfMailInfo = "SELECT M.* FROM (SELECT DISTINCT convHash FROM QM_MAIL_INFO WHERE id IN(SELECT DISTINCT mid FROM QM_REF_MAIL_ADDR WHERE addrId IN$inClause$)) AS MI INNER JOIN QM_MAIL_INFO AS M ON MI.convHash=M.convHash AND M.convType IN (1, 0) AND  M.folderId NOT IN (SELECT id FROM QM_FOLDER WHERE type IN (3)) AND  M.folderId NOT IN (SELECT id FROM QM_FOLDER WHERE type IN (5,6,8,4)) AND  NOT  attr&4096  GROUP BY M.id ORDER BY utcSent DESC";
  private static final String sqlQueryAllSentMailInfo;
  private static final String sqlQueryAllTrashMailInfo;
  private static final String sqlQueryCertainContactMailInfo;
  private static final String sqlQueryClockSendMailIds = "SELECT DISTINCT id FROM QM_MAIL_INFO WHERE sendutc>0 AND id IN ";
  private static final String sqlQueryCntByAccountInAllFolder;
  private static final String sqlQueryCntByAccountInFolder;
  private static final String sqlQueryConvFirstChildId = "SELECT id FROM QM_MAIL_INFO WHERE convHash=? AND folderId IN(?,?) AND convType<>1 ORDER BY utcSent DESC LIMIT 1";
  private static final String sqlQueryConvHashForInfection = "SELECT convHash FROM QM_MAIL_INFO WHERE convContactHash = ? AND convHash&2 AND folderId = ?  AND  ( CASE WHEN convRefHash = 0  THEN 1  ELSE convRefHash = ?  END )  ORDER BY utcReceived LIMIT 1";
  private static final String sqlQueryConvLastChildId = "SELECT id FROM QM_MAIL_INFO WHERE convHash=? AND folderId IN(?,?) AND convType<>1 ORDER BY utcSent ASC  LIMIT 1";
  private static final String sqlQueryConvMailIds;
  private static final String sqlQueryConvMailInfo;
  private static final String sqlQueryConvMailInfoUnreadCount;
  private static final String sqlQueryConvMailParentIds = "SELECT id FROM QM_MAIL_INFO WHERE convHash=? AND convType=1";
  private static final String sqlQueryConvParentMailId = "SELECT id FROM QM_MAIL_INFO WHERE convHash=( SELECT convHash FROM QM_MAIL_INFO WHERE id=? ) AND convType=1 ";
  private static final String sqlQueryCreateConvParents = "SELECT id, ch, (SELECT COUNT(*) FROM QM_MAIL_INFO WHERE (folderId=fid OR (NOT ch&1 AND folderId=?)) AND convHash=ch) AS cnt FROM QM_FOLDER INNER JOIN (SELECT id AS fid FROM QM_FOLDER WHERE accountId=? AND id NOT IN$inClauseFolders$) ON fid=id INNER JOIN (SELECT DISTINCT convHash AS ch FROM QM_MAIL_INFO WHERE convHash IN$inClauseHash$) WHERE EXISTS(SELECT * FROM QM_MAIL_INFO WHERE folderId=fid AND convHash=ch) AND cnt > 1";
  private static final String sqlQueryExpireConvMailIds = "SELECT id FROM QM_MAIL_INFO WHERE convHash=? AND id NOT IN $inClause$";
  private static final String sqlQueryFidWithAidAndType = "SELECT id FROM QM_FOLDER AS F WHERE F.accountId IN $inclause2$ AND F.type IN (3)";
  private static final String sqlQueryFolderCanLoadMore = "SELECT (SELECT COUNT(DISTINCT M.id) FROM QM_MAIL_INFO AS M WHERE M.folderId IN$queryInClause$ AND M.attr&256 AND M.attr&549755813888=0 AND M.utcSent>=(SELECT F.since FROM QM_FOLDER AS F WHERE F.id = M.folderId))<(SELECT SUM(svrCount) FROM QM_FOLDER WHERE id IN$inClause$)";
  private static final String sqlQueryFolderIdFromMailId = "SELECT DISTINCT folderId FROM QM_MAIL_INFO WHERE id IN ";
  private static final String sqlQueryFolderMailInfo;
  private static final String sqlQueryFolderSyncMailList = "SELECT $selectClause$ FROM QM_MAIL_INFO WHERE folderId= ? AND attr&256 AND utcSent>=? ORDER BY utcSent DESC ";
  private static final String sqlQueryFolderSyncMailListByAccount = "SELECT id,folderId,remoteId,abstract,attr,size FROM QM_MAIL_INFO WHERE accountId= ? AND attr&256 GROUP BY id ORDER BY utcSent DESC ";
  private static final String sqlQueryGroupMailId = "SELECT M.remoteId,A.uin FROM QM_MAIL_INFO AS M INNER JOIN QM_REF_MAIL_ADDR AS A ON M.id = A.mid AND A.roleType = 5";
  private static final String sqlQueryHasMailContent = "SELECT COUNT(id) FROM QM_MAIL_CONTENT WHERE id=?";
  private static final String sqlQueryHitMailSince = "SELECT utcReceived FROM QM_MAIL_INFO WHERE folderId= ? AND attr&256 AND utcRecentOpr>? ORDER BY utcReceived ASC";
  private static final String sqlQueryIdsAndAccountId = "SELECT id,accountId,folderId,remoteId,svrKey,convType,attr FROM QM_MAIL_INFO WHERE id IN ( SELECT id FROM QM_MAIL_INFO INNER JOIN(SELECT id AS mid,folderId AS fid,convHash AS ch,convType AS ct FROM QM_MAIL_INFO WHERE id IN $inClause$) ON id=mid OR (convType=-1 AND convHash=ch AND folderId=fid AND ct=1)) ORDER BY accountId,folderId";
  private static final String sqlQueryIncludeMailIds = "SELECT remoteId FROM QM_MAIL_INFO WHERE accountId=? AND attr&256 AND remoteId IN$inClause$";
  private static final String sqlQueryLeftMailSince = "SELECT utcReceived FROM QM_MAIL_INFO WHERE folderId= ? AND attr&256 ORDER BY utcReceived DESC LIMIT ?";
  private static final String sqlQueryLocalMailByFolderId = "SELECT id FROM QM_MAIL_INFO WHERE attr&33554432 AND accountId=? AND folderId=?";
  private static final String sqlQueryLocalMailPopSvrCnt = "SELECT (SELECT COUNT(*) FROM QM_MAIL_INFO WHERE isUnread = 1 AND accountId=?), (SELECT COUNT(*) FROM QM_MAIL_INFO WHERE accountId=?)";
  private static final String sqlQueryMailByRemoteIds = "SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE M.remoteId IN $inClause$ AND M.accountId=?";
  private static final String sqlQueryMailContact = "SELECT * FROM QM_REF_MAIL_ADDR WHERE mid = ? AND roleType = ?";
  private static final String sqlQueryMailContent = "SELECT * FROM QM_MAIL_CONTENT WHERE id = ?";
  private static final String sqlQueryMailContentById = "SELECT content FROM QM_MAIL_CONTENT WHERE id=?";
  private static final String sqlQueryMailContentScale = "SELECT * FROM QM_MAIL_CONTENT_SCALE WHERE mailId = ?";
  private static final String sqlQueryMailCount;
  private static final String sqlQueryMailExist = "SELECT COUNT(*) FROM QM_MAIL_INFO WHERE id= ?";
  private static final String sqlQueryMailIdsByAccountId = "SELECT id FROM QM_MAIL_INFO WHERE accountId = ? ";
  private static final String sqlQueryMailInfoByChildHash = "SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE convType IN(0,-1) AND folderId IN $convFolder$ AND convHash=?  ORDER BY utcSent DESC LIMIT 1";
  private static final String sqlQueryMailInfoById = "SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE id=?";
  private static final String sqlQueryMailInfoByIds = "SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE id IN $inClause$";
  private static final String sqlQueryMailInfoWithoutSpamTrashDraft = "SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE id IN $inClause$ AND  M.folderId NOT IN (SELECT id FROM QM_FOLDER WHERE type IN (5,6,4)) GROUP BY M.id";
  private static final String sqlQueryMailNeedPreload;
  private static final String sqlQueryMailPartInfoById = "SELECT * FROM QM_MAIL_PART_INFO WHERE mid=?";
  private static final String sqlQueryMailRecall = "SELECT * FROM QM_REF_MAIL_RECALL WHERE mid=?";
  private static final String sqlQueryMailTagsId = "SELECT F.* FROM QM_REF_MAIL_TAG AS T LEFT OUTER JOIN QM_FOLDER AS F ON T.tagId = F.remoteId WHERE  T.mid IN $inclause$ AND F.type = 14 ORDER BY F.remoteId";
  private static final String sqlQueryMailTagsInfo = "SELECT F.* FROM QM_REF_MAIL_TAG AS T LEFT OUTER JOIN QM_FOLDER AS F ON T.tagId = F.remoteId WHERE F.accountId = ? AND T.mid = ? AND F.type = 14 ORDER BY F.remoteId";
  private static final String sqlQueryMailTranslateContent = "SELECT * FROM QM_MAIL_TRANSLATE_CONTENT WHERE id = ?";
  private static final String sqlQueryMailUTC = "SELECT utcSent FROM QM_MAIL_INFO WHERE accountId=? AND remoteId=?";
  private static final String sqlQueryMailUtcSend = "SELECT remoteId, utcSent FROM QM_MAIL_INFO WHERE folderId=? AND NOT attr&10240 ORDER BY utcSent DESC LIMIT ?";
  private static final String sqlQueryMailUtcSendExcludeParent = "SELECT remoteId, utcSent FROM QM_MAIL_INFO WHERE folderId=? AND NOT attr&10240 AND convType IN(0,-1) ORDER BY utcSent DESC LIMIT ?";
  private static final String sqlQueryOverdueMailIds = "SELECT id FROM QM_MAIL_INFO WHERE folderId = ? AND attr&256 AND utcReceived < ?  ORDER BY utcReceived DESC";
  private static final String sqlQueryPopInAdMailParentId = "SELECT id from QM_MAIL_INFO WHERE attr&2048";
  private static final String sqlQueryPopInConvMailParentInfo = "SELECT id FROM QM_MAIL_INFO INNER JOIN (SELECT convHash AS ch FROM QM_MAIL_INFO WHERE id=?) ON convHash=ch AND convType=1 ";
  private static final String sqlQueryProtocolConvHash = "SELECT convHash FROM QM_MAIL_INFO WHERE folderId=? AND remoteId=?";
  private static final String sqlQueryProtocolUnreadMailInfo;
  private static final String sqlQueryQQMailSinceMail = "SELECT * FROM QM_MAIL_INFO WHERE folderId=? AND attr&256 AND utcSent>=? ORDER BY utcSent ASC  LIMIT 1";
  private static final String sqlQueryQQMailStarSinceMail = "SELECT * FROM QM_MAIL_INFO WHERE accountId=? AND isStar=1 AND attr&256 AND utcSent>=? ORDER BY utcSent ASC  LIMIT 1";
  private static final String sqlQueryQQMailTagSinceMail;
  private static final String sqlQueryQQMailUnreadSinceMail = "SELECT * FROM QM_MAIL_INFO WHERE accountId=? AND isUnread=1 AND attr&256 AND utcSent>=? ORDER BY utcSent ASC  LIMIT 1";
  private static final String sqlQueryQQMailVipSinceMail = "SELECT M.* FROM (SELECT DISTINCT convHash FROM QM_MAIL_INFO WHERE fromAddrId IN(SELECT emailHash FROM QM_REF_CONTACT_EMAIL WHERE cid IN (SELECT id FROM QM_CONTACT WHERE vip = 1)) OR id IN (SELECT mid FROM QM_REF_MAIL_ADDR_SENDER WHERE addrId IN(SELECT emailHash FROM QM_REF_CONTACT_EMAIL WHERE cid IN (SELECT id FROM QM_CONTACT WHERE vip = 1)))) AS MI INNER JOIN QM_MAIL_INFO AS M ON MI.convHash=M.convHash WHERE M.accountId=? AND attr&256 AND utcSent>=? ORDER BY utcSent ASC  LIMIT 1";
  private static final String sqlQueryQQUnreadMailInfo;
  private static final String sqlQueryRawMailInfoByIds = "SELECT * FROM QM_MAIL_INFO WHERE id IN ";
  private static final String sqlQueryRecentConvChild = "SELECT * FROM QM_MAIL_INFO AS M WHERE convHash= ? AND convType = -1 AND attr&256 AND folderId=?  ORDER BY utcSent DESC LIMIT 1";
  private static final String sqlQueryRecentMailUTC;
  private static final String sqlQueryRecentRecvMails = "SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE M.accountId=? AND M.attr&256 AND M.convType IN(0,-1) AND M.utcSent>?  ORDER BY utcSent DESC";
  private static final String sqlQuerySinceMailUtc = "SELECT utcSent FROM QM_MAIL_INFO WHERE folderId= ? AND attr&256 AND utcSent>=? ORDER BY utcSent ASC  LIMIT 1";
  private static final String sqlQuerySpecialMailInfo;
  private static final String sqlQueryStarCnt;
  private static final String sqlQueryStarMailInfoForDelta;
  static final String sqlQueryStarUnreadCount;
  private static final String sqlQueryStarredCanLoadMore;
  private static final String sqlQueryStarredMailInfo;
  private static final String sqlQueryStarredMailInfoByAcc;
  private static final String sqlQueryStarredMailList;
  private static final String sqlQueryStarredSyncMailList;
  private static final String sqlQueryTagCanLoadMore = "SELECT COUNT(*) FROM (SELECT T.tagId, M.id, M.accountId FROM QM_REF_MAIL_TAG AS T INNER JOIN QM_MAIL_INFO AS M  ON M.attr&256 AND M.id=T.mid) AS T  INNER JOIN QM_FOLDER AS FR  ON FR.id=? AND FR.remoteId=T.tagId AND FR.accountId=T.accountId";
  private static final String sqlQueryTagCnt;
  private static final String sqlQueryTagMailInfo;
  private static final String sqlQueryTagMailInfoForDelta;
  private static final String sqlQueryTagSyncMailList;
  private static final String sqlQueryUnreadCnt;
  private static final String sqlQueryUnreadCountMailInfoByFolderType;
  private static final String sqlQueryUnreadMailInfoForDelta;
  private static final String sqlQueryUnreadMailList;
  private static final String sqlQueryUnreadSyncMailList;
  static final String sqlQueryUnreadedUnreadCount = "SELECT 0";
  private static final String sqlQueryUnreadrdMailInfo;
  private static final String sqlQueryVipCnt;
  private static final String sqlQueryVipMailInfo;
  private static final String sqlQueryVipMailInfoForDelta;
  private static final String sqlQueryVipMailList;
  private static final String sqlQueryVipSyncMailList;
  static final String sqlQueryVipUnreadCount;
  private static final String sqlResetMailAttr = "UPDATE QM_MAIL_INFO SET attr=attr&(~?) WHERE id IN$inClause$";
  private static final String sqlSearchLikeAll;
  private static final String sqlSearchLikeReceiver;
  private static final String sqlSearchLikeSender;
  private static final String sqlSearchLikeSubject;
  private static final String sqlSearchMatchAll;
  private static final String sqlSearchMatchReceiver;
  private static final String sqlSearchMatchSender;
  private static final String sqlSearchMatchSubject;
  private static final String sqlSelectIcsEventByMailIdAndAccountId = "SELECT * FROM QM_ICS_EVENT WHERE mailId=? AND accountId=?";
  private static final String sqlSelectIcsEvents = "SELECT * FROM QM_ICS_EVENT";
  private static final String sqlSelectMailFromMaidId = "SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE M.id = ?";
  private static final String sqlSelectQQMailConvHash = "SELECT id FROM QM_MAIL_INFO WHERE folderId=? AND convHash=? AND id NOT IN$inClause$";
  private static final String sqlSelectUnReadState = "SELECT isUnread FROM QM_MAIL_INFO WHERE id =?";
  private static final String sqlUpdateConvChildType = "UPDATE QM_MAIL_INFO SET convType=CASE convType WHEN 0 THEN -1 ELSE 0 END WHERE id IN(SELECT id FROM QM_MAIL_INFO AS mi WHERE CASE convType WHEN -1 THEN NOT EXISTS(SELECT * FROM QM_MAIL_INFO AS mmi  WHERE mi.folderId=mmi.folderId AND mi.convHash=mmi.convHash AND mmi.convType=1) WHEN 0 THEN EXISTS(SELECT * FROM QM_MAIL_INFO AS mmi  WHERE mi.folderId=mmi.folderId AND mi.convHash=mmi.convHash AND mmi.convType=1) END)";
  private static final String sqlUpdateConvMailConvCount = "UPDATE QM_MAIL_INFO SET convCnt=convCnt+1 WHERE id IN (SELECT id FROM QM_MAIL_INFO WHERE convHash=? AND convType=1)";
  private static final String sqlUpdateConvMailMove = "UPDATE QM_MAIL_INFO SET folderId=? WHERE id IN( SELECT id FROM QM_MAIL_INFO INNER JOIN(SELECT id AS mid,folderId AS fid,convHash AS ch,convType AS ct FROM QM_MAIL_INFO WHERE id IN $inClause$) ON id=mid OR (convType=-1 AND convHash=ch AND folderId=fid AND ct=1))";
  private static final String sqlUpdateConvMailParentStatus;
  private static final String sqlUpdateConvMailStar;
  private static final String sqlUpdateConvMailStatusWhere = "id IN (SELECT id FROM QM_MAIL_INFO INNER JOIN(SELECT accountId AS aid,folderId AS fid,convHash AS ch,convType AS ct,id AS cid FROM QM_MAIL_INFO WHERE id IN $inClause$)ON (folderId=fid AND convHash=ch and ct=1) OR (ct IN (0,-1) AND id=cid))";
  private static final String sqlUpdateConvMailUnread;
  private static final String sqlUpdateConvStatus;
  private static final String sqlUpdateConvStatusByIds;
  private static final String sqlUpdateIcsEventDecline = "update QM_ICS_EVENT set isDecline = 1  WHERE uid =? AND accountId=?";
  public static final String sqlUpdateLocalMailUrCntIntoFolder;
  private static final String sqlUpdateMailAbstract = "UPDATE QM_MAIL_INFO SET abstract=? WHERE id=?";
  private static final String sqlUpdateMailAttr = "UPDATE QM_MAIL_INFO SET attr=attr|(?) WHERE id IN$inClause$";
  private static final String sqlUpdateMailAttrByRemoteId = "UPDATE QM_MAIL_INFO SET attr=attr|(?) WHERE remoteId = ?";
  private static final String sqlUpdateMailConvHash = "UPDATE QM_MAIL_INFO SET convHash=? WHERE id=?";
  private static final String sqlUpdateMailUtc = "UPDATE QM_MAIL_INFO SET utcSent=?, utcReceived=?, utcRecentOpr=? WHERE id IN$inClause$";
  private static final String sqlUpdateQQMailConvChildType;
  private static final String sqlUpdateQQMailConvHash = "UPDATE QM_MAIL_INFO SET convHash=? WHERE id IN$inClause$";
  private static final String sqlUpdateQQMailConvParentCount;
  private static final String sqlUpdateQQMailConvParentUtc = "UPDATE QM_MAIL_INFO SET utcSent=utcSent+1000  WHERE id IN$inClause$ AND convType=1";
  private static final String sqlUpgradeFtsQueryMailId = "SELECT id FROM QM_MAIL_INFO";
  private static final String sqlUpgradeFtsQueryMailInfo = "SELECT id, senderAddr, senderAddrName, fromAddr, fromAddrName, subject,abstract FROM QM_MAIL_INFO WHERE id=?";
  private static final String sqlUpgradeFtsQueryReceiver = "SELECT mid,roleType,addrName,address FROM QM_REF_MAIL_ADDR WHERE mid=? AND roleType in (2,3,4)";
  private static final String sqlWherePopinConvMailAbstract = "id=? OR id IN ( SELECT id FROM QM_MAIL_INFO INNER JOIN ( SELECT convHash AS ch, utcSent AS us,attr AS at FROM QM_MAIL_INFO AS mi WHERE id=? ) ON ((convHash=ch AND convType=1) OR (at&512 AND attr&2048)) AND utcSent=us )";
  private static final String updateAdvertiseConvUnread;
  private static final String updateAggregateConvInfo = "UPDATE QM_MAIL_INFO SET subject=?, abstract=?, utcSent=?, utcReceived=?, isUnread =($countUnread$)>0  WHERE accountId=? AND attr&? ";
  private static final String updateAllAdvertiseConvUnread;
  
  static
  {
    CONDI_IS_BLACKLIST_AD_MAIL = CONDI_IS_BLACKLIST_AD_MAIL_WITH_ALIAS.replace("$alias$", "M");
    CONDI_IS_WHITELIST_AD_MAIL = CONDI_IS_WHITELIST_AD_MAIL_WITH_ALIAS.replace("$alias$", "M");
    CONDI_AD_IN_SETTING = " (CASE NOT EXISTS(SELECT value FROM QM_MAIL_AGGREGATE WHERE id='mail_aggregate_ad' AND value='false') AND NOT " + " EXISTS (SELECT * FROM QM_FOLDER AS FD  WHERE FD.id=$alias$.folderId AND FD.type<>1)".replace("$alias$", "M") + " AND NOT " + CONDI_IS_WHITELIST_AD_MAIL + " WHEN 1 THEN " + " attr&2048 " + " OR NOT " + " attr&512 " + " AND NOT " + CONDI_IS_BLACKLIST_AD_MAIL + " ELSE " + " NOT  attr&2048 " + " END) ";
    CONDI_SUBS_IN_SETTING = " (CASE NOT EXISTS(SELECT value FROM QM_MAIL_AGGREGATE WHERE id='mail_aggregate_book' AND value='false') AND NOT " + " EXISTS (SELECT * FROM QM_FOLDER AS FD  WHERE FD.id=$alias$.folderId AND FD.type<>1)".replace("$alias$", "M") + " WHEN 1 THEN " + " attr&8192 " + " OR " + " NOT  attr&4096 " + " ELSE " + " NOT  attr&8192 " + " END) ";
    CASE_QQMAIL_CONV_CHILD = "id IN$inClauseFolders$ OR NOT EXISTS(" + "SELECT * FROM QM_MAIL_INFO AS mmi  WHERE mi.folderId=mmi.folderId AND mi.convHash=mmi.convHash AND mmi.convType=1".replace(" mi", " QM_MAIL_INFO") + ")";
    sqlUpdateQQMailConvChildType = "UPDATE QM_MAIL_INFO SET convType=CASE WHEN " + CASE_QQMAIL_CONV_CHILD + "THEN 0 ELSE -1 END," + "attr" + "=CASE WHEN " + CASE_QQMAIL_CONV_CHILD + " THEN " + "attr" + "|" + 256L + " ELSE " + "attr" + "&~" + 256L + " END  WHERE " + "convType" + "<>1 AND " + "convHash" + " IN$inClauseHash$ AND " + "folderId" + "=?";
    CONDI_CONV_IN_SETTING = " (CASE  NOT (M.attr&512 AND NOT " + CONDI_IS_WHITELIST_AD_MAIL + ") AND EXISTS (SELECT " + "value" + " FROM " + "QM_MAIL_AGGREGATE" + " WHERE " + "id" + "='" + "aggregate_subject" + "_'||M." + "accountId" + " AND " + "value" + "='false') WHEN 1 THEN M." + "convType" + " IN (0,-1) ELSE M." + "convType" + " IN (0,1)  END)";
    CONDI_ACCOUNT = "accountId=? AND " + CONDI_CONV_IN_SETTING;
    sqlQueryMailCount = "SELECT COUNT(id) FROM QM_MAIL_INFO AS M WHERE accountId=? AND " + CONDI_CONV_IN_SETTING;
    sqlQueryMailNeedPreload = "SELECT * FROM QM_MAIL_INFO AS M  WHERE id IN$inClause$  AND attr&256 AND isUnread=1 AND isLoaded=0  AND NOT EXISTS(SELECT * FROM QM_FOLDER WHERE id=M.folderId AND type IN" + getInClause(new int[] { 4, 3, 5, 6, 15 }) + ")" + " ORDER BY utcSent DESC" + " LIMIT 10";
    sqlQueryStarredMailInfo = "SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE isStar=1 AND  NOT  attr&2048  AND  NOT  attr&8192  AND " + CONDI_CONV_IN_SETTING + " AND " + " (M.folderId=0 OR NOT EXISTS(SELECT silent FROM QM_FOLDER WHERE id = M.folderId AND silent= 1)) " + " AND " + " M.folderId NOT IN (SELECT id FROM QM_FOLDER WHERE type IN (5,6,4))" + " GROUP BY " + "id" + " ORDER BY utcSent DESC";
    sqlQueryStarredMailInfoByAcc = "SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE isStar=1 AND  NOT  attr&2048  AND  NOT  attr&8192  AND " + CONDI_CONV_IN_SETTING + " AND " + " (M.folderId=0 OR NOT EXISTS(SELECT silent FROM QM_FOLDER WHERE id = M.folderId AND silent= 1)) " + " AND " + " M.folderId NOT IN (SELECT id FROM QM_FOLDER WHERE type IN (5,6,4))" + " AND " + "accountId" + "=?  AND " + "utcReceived" + ">=?  GROUP BY " + "id" + " ORDER BY utcSent DESC";
    sqlQueryUnreadrdMailInfo = "SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE isUnread=1 AND  NOT  attr&2048  AND  NOT  attr&4096  AND " + CONDI_CONV_IN_SETTING + " AND " + " (M.folderId=0 OR NOT EXISTS(SELECT silent FROM QM_FOLDER WHERE id = M.folderId AND silent= 1)) " + " AND " + " M.folderId NOT IN (SELECT id FROM QM_FOLDER WHERE type IN (5,6,4))" + " AND (CASE WHEN M." + "accountId" + " IN $inClause$ THEN " + "folderId" + "=(SELECT " + "id" + " FROM " + "QM_FOLDER" + " WHERE " + "type" + " = " + 1 + ") ELSE 1 END) GROUP BY " + "id" + " ORDER BY utcSent DESC";
    sqlQueryQQUnreadMailInfo = "SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE isUnread=1 AND  NOT  attr&2048  AND  NOT  attr&8192  AND " + CONDI_CONV_IN_SETTING + " AND " + " (M.folderId=0 OR NOT EXISTS(SELECT silent FROM QM_FOLDER WHERE id = M.folderId AND silent= 1)) " + " AND " + " M.folderId NOT IN (SELECT id FROM QM_FOLDER WHERE type IN (5,6,4))" + " AND " + "accountId" + "=?  AND " + "utcReceived" + ">=?  GROUP BY " + "id" + " ORDER BY utcSent DESC";
    sqlQueryProtocolUnreadMailInfo = "SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE isUnread=1 AND  NOT  attr&2048  AND  NOT  attr&8192  AND " + CONDI_CONV_IN_SETTING + " AND " + " (M.folderId=0 OR NOT EXISTS(SELECT silent FROM QM_FOLDER WHERE id = M.folderId AND silent= 1)) " + " AND " + " M.folderId NOT IN (SELECT id FROM QM_FOLDER WHERE type IN (5,6,4))" + " AND " + "accountId" + "=?  AND (CASE WHEN M." + "accountId" + " IN $inClause$ THEN " + "folderId" + "=(SELECT " + "id" + " FROM " + "QM_FOLDER" + " WHERE " + "type" + " = " + 1 + ") ELSE 1 END) GROUP BY " + "id" + " ORDER BY utcSent DESC";
    sqlQueryAllMailInfoByFolderType = "SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE folderId IN (SELECT id FROM QM_FOLDER WHERE type IN ($inClause$)) AND  NOT  attr&2048  AND  NOT  attr&4096  AND " + CONDI_CONV_IN_SETTING + " AND " + " (M.folderId=0 OR NOT EXISTS(SELECT silent FROM QM_FOLDER WHERE id = M.folderId AND silent= 1)) " + " GROUP BY " + "id";
    sqlQueryUnreadCountMailInfoByFolderType = "SELECT COUNT(*) FROM (" + sqlQueryAllMailInfoByFolderType + ") WHERE " + "isUnread" + " = 1";
    sqlQuerySpecialMailInfo = sqlQueryAllMailInfoByFolderType + " ORDER BY utcSent DESC";
    sqlQueryAllSentMailInfo = sqlQuerySpecialMailInfo.replace("$inClause$", String.valueOf(3));
    sqlQueryAllDraftMailInfo = sqlQuerySpecialMailInfo.replace("$inClause$", String.valueOf(4));
    sqlQueryAllTrashMailInfo = sqlQuerySpecialMailInfo.replace("$inClause$", String.valueOf(5));
    sqlCountAllUnreadSentMailInfo = sqlQueryUnreadCountMailInfoByFolderType.replace("$inClause$", String.valueOf(3));
    sqlCountAllUnreadTrashMailInfo = sqlQueryUnreadCountMailInfoByFolderType.replace("$inClause$", String.valueOf(5));
    sqlQueryVipMailInfo = "SELECT M.* FROM (SELECT DISTINCT convHash FROM QM_MAIL_INFO WHERE fromAddrId IN(SELECT emailHash FROM QM_REF_CONTACT_EMAIL WHERE cid IN (SELECT id FROM QM_CONTACT WHERE vip = 1)) OR id IN (SELECT mid FROM QM_REF_MAIL_ADDR_SENDER WHERE addrId IN(SELECT emailHash FROM QM_REF_CONTACT_EMAIL WHERE cid IN (SELECT id FROM QM_CONTACT WHERE vip = 1)))) AS MI INNER JOIN QM_MAIL_INFO AS M ON MI.convHash=M.convHash WHERE " + CONDI_CONV_IN_SETTING + " AND " + " M.folderId NOT IN (SELECT ID FROM QM_FOLDER WHERE type IN (3,5,4,8,6))" + " AND NOT M." + "attr" + "&" + 2048L + " AND NOT M." + "attr" + "&" + 8192L + " GROUP BY M." + "id" + " ORDER BY utcSent DESC";
    sqlQueryCertainContactMailInfo = "SELECT M.* FROM (SELECT DISTINCT M.convHash FROM QM_MAIL_INFO AS M WHERE (M.id IN(SELECT RMA.mid FROM QM_REF_MAIL_ADDR AS RMA WHERE RMA.addrId IN $inclause1$ AND ( RMA.roleType = 1 OR ( RMA.roleType IN ( 2,3,4) AND M.folderId IN (SELECT id FROM QM_FOLDER AS F WHERE F.accountId IN $inclause2$ AND F.type IN (3))))) AND accountId IN $inclause2$) OR (M.id IN (SELECT MAS.mid FROM QM_REF_MAIL_ADDR_SENDER AS MAS WHERE MAS.addrId IN $inclause1$) AND M.accountId IN $inclause2$)) AS MI INNER JOIN QM_MAIL_INFO AS M ON MI.convHash=M.convHash WHERE " + CONDI_CONV_IN_SETTING + " AND M." + "folderId" + " NOT IN (SELECT ID FROM " + "QM_FOLDER" + " WHERE type IN (" + 5 + "," + 4 + "," + 8 + "," + 6 + ")) AND NOT M." + "attr" + "&" + 2048L + " AND NOT M." + "attr" + "&" + 8192L + " GROUP BY M." + "id" + " ORDER BY utcSent DESC";
    sqlQueryTagMailInfo = "SELECT M.*, T.* FROM QM_REF_MAIL_TAG AS T LEFT OUTER JOIN QM_MAIL_INFO AS M ON T.mid=M.id AND T.tagId = ?  WHERE folderId NOT IN$notInFolderInClause$ AND " + CONDI_ACCOUNT + " AND " + "utcSent>=?" + " GROUP BY " + "id" + " ORDER BY utcSent DESC";
    sqlQueryStarUnreadCount = "SELECT COUNT(*) FROM (" + sqlQueryStarredMailInfo + ") WHERE " + "isUnread" + "=1";
    sqlQueryVipUnreadCount = "SELECT COUNT(*) FROM (" + sqlQueryVipMailInfo + ") WHERE " + "isUnread" + "=1";
    sqlQueryVipMailInfoForDelta = "SELECT M.* FROM (SELECT DISTINCT convHash FROM QM_MAIL_INFO WHERE fromAddrId IN(SELECT emailHash FROM QM_REF_CONTACT_EMAIL WHERE cid IN (SELECT id FROM QM_CONTACT WHERE vip = 1)) OR id IN (SELECT mid FROM QM_REF_MAIL_ADDR_SENDER WHERE addrId IN(SELECT emailHash FROM QM_REF_CONTACT_EMAIL WHERE cid IN (SELECT id FROM QM_CONTACT WHERE vip = 1)))) AS MI INNER JOIN QM_MAIL_INFO AS M ON MI.convHash=M.convHash WHERE " + CONDI_CONV_IN_SETTING + " AND M." + "folderId" + " NOT IN (SELECT ID FROM " + "QM_FOLDER" + " WHERE type IN (" + 3 + "," + 5 + "," + 4 + "," + 15 + "," + 8 + "," + 6 + ")) AND NOT M." + "attr" + "&" + 2048L + " AND NOT M." + "attr" + "&" + 8192L + " AND M." + "utcSent>=?".replace("?", "QM_FOLDER.since") + " AND M." + CONDI_ACCOUNT.replace("?", "QM_FOLDER.accountId") + " GROUP BY M." + "id" + " ORDER BY utcSent DESC";
    sqlQueryVipCnt = "SELECT COUNT(*) FROM (" + sqlQueryVipMailInfoForDelta + ")";
    sqlQueryStarMailInfoForDelta = "SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE isStar=1 AND  NOT  attr&2048  AND  NOT  attr&8192  AND " + CONDI_CONV_IN_SETTING + " AND " + " (M.folderId=0 OR NOT EXISTS(SELECT silent FROM QM_FOLDER WHERE id = M.folderId AND silent= 1)) " + " AND " + " M.folderId NOT IN (SELECT id FROM QM_FOLDER WHERE type IN (5,6,4))" + " AND " + "utcSent>=?".replace("?", "QM_FOLDER.since") + " AND " + CONDI_ACCOUNT.replace("?", "QM_FOLDER.accountId") + " GROUP BY " + "id" + " ORDER BY utcSent DESC";
    sqlQueryStarCnt = "SELECT COUNT(*) FROM (" + sqlQueryStarMailInfoForDelta + ")";
    sqlQueryUnreadMailInfoForDelta = "SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE isUnread=1 AND  NOT  attr&2048  AND  NOT  attr&8192  AND " + CONDI_CONV_IN_SETTING + " AND " + " (M.folderId=0 OR NOT EXISTS(SELECT silent FROM QM_FOLDER WHERE id = M.folderId AND silent= 1)) " + " AND " + " M.folderId NOT IN (SELECT id FROM QM_FOLDER WHERE type IN (5,6,4))" + " AND " + "utcSent>=?".replace("?", "QM_FOLDER.since") + " AND " + CONDI_ACCOUNT.replace("?", "QM_FOLDER.accountId") + " GROUP BY " + "id" + " ORDER BY utcSent DESC";
    sqlQueryUnreadCnt = "SELECT COUNT(*) FROM (" + sqlQueryUnreadMailInfoForDelta + ")";
    sqlQueryFolderMailInfo = "SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE folderId= ? AND NOT attr&268435456 AND " + CONDI_CONV_IN_SETTING + " AND " + "utcSent>=?" + " AND " + CONDI_AD_IN_SETTING + " GROUP BY " + "id" + " ORDER BY utcSent DESC";
    sqlQueryStarredMailList = "SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE isStar=1 AND " + CONDI_ACCOUNT + " AND " + "utcSent>=?" + " GROUP BY " + "id" + " ORDER BY utcSent DESC";
    sqlQueryUnreadMailList = "SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE isUnread=1 AND " + CONDI_ACCOUNT + " AND " + "utcSent>=?" + " GROUP BY " + "id" + " ORDER BY utcSent DESC";
    sqlQueryVipMailList = "SELECT M.* FROM (SELECT DISTINCT convHash FROM QM_MAIL_INFO WHERE fromAddrId IN(SELECT emailHash FROM QM_REF_CONTACT_EMAIL WHERE cid IN (SELECT id FROM QM_CONTACT WHERE vip = 1)) OR id IN (SELECT mid FROM QM_REF_MAIL_ADDR_SENDER WHERE addrId IN(SELECT emailHash FROM QM_REF_CONTACT_EMAIL WHERE cid IN (SELECT id FROM QM_CONTACT WHERE vip = 1)))) AS MI INNER JOIN QM_MAIL_INFO AS M ON MI.convHash=M.convHash WHERE  M.folderId NOT IN (SELECT ID FROM QM_FOLDER WHERE type IN (3,5,4,8,6)) AND " + CONDI_ACCOUNT + " AND " + "utcSent>=?" + " GROUP BY " + "id" + " ORDER BY utcSent DESC";
    sqlQueryStarredCanLoadMore = "SELECT COUNT(*) FROM (" + sqlQueryStarredMailList + ")";
    sqlQueryTagSyncMailList = "SELECT $selectClause$ FROM (" + sqlQueryTagMailInfo + ") WHERE " + "attr" + "&" + 256L + " ORDER BY utcSent DESC ";
    sqlQueryStarredSyncMailList = "SELECT $selectClause$ FROM (" + sqlQueryStarredMailList + ") WHERE " + "attr" + "&" + 256L + " ORDER BY utcSent DESC ";
    sqlQueryUnreadSyncMailList = "SELECT $selectClause$ FROM (" + sqlQueryUnreadMailList + ") WHERE " + "attr" + "&" + 256L + " ORDER BY utcSent DESC ";
    sqlQueryVipSyncMailList = "SELECT $selectClause$ FROM (" + sqlQueryVipMailList + ") WHERE " + "attr" + "&" + 256L + " ORDER BY utcSent DESC ";
    sqlQueryRecentMailUTC = "SELECT * FROM QM_MAIL_INFO AS M WHERE " + CONDI_ACCOUNT + " AND " + "attr" + "&" + 256L + " ORDER BY utcSent DESC " + " LIMIT 1";
    sqlQueryQQMailTagSinceMail = "SELECT M.*, T.* FROM QM_REF_MAIL_TAG AS T LEFT OUTER JOIN QM_MAIL_INFO AS M ON T.mid=M.id AND T.tagId = ?  WHERE folderId NOT IN$notInFolderInClause$ AND " + CONDI_ACCOUNT + " AND attr&256 AND utcSent>=? ORDER BY utcSent ASC  LIMIT 1";
    CONDI_CONV_ALL_CHILD = "convHash=ch AND ((folderId=fid AND convType=-1) OR (NOT convHash&1 AND folderId=" + "(SELECT id FROM QM_FOLDER WHERE accountId=$accountId$ AND type=3)".replace("$accountId$", "aid") + "))";
    sqlQueryConvMailInfo = "SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId INNER JOIN" + "(SELECT accountId AS aid,folderId AS fid,convHash AS ch,convType AS ct,id AS cid FROM QM_MAIL_INFO WHERE id IN $inClause$)".replace("$inClause$", "(?)") + " ON " + CONDI_CONV_ALL_CHILD + " GROUP BY " + "id" + " ORDER BY utcSent DESC ";
    sqlQueryConvMailInfoUnreadCount = "SELECT COUNT(*) FROM (" + sqlQueryConvMailInfo + ") WHERE " + "isUnread" + "=1 AND " + "folderId" + " NOT IN (SELECT " + "id" + " FROM " + "QM_FOLDER" + " WHERE " + "type" + " = " + 3 + ")";
    sqlUpdateQQMailConvParentCount = "UPDATE QM_MAIL_INFO SET convCnt= (SELECT COUNT(*) FROM (" + sqlQueryConvMailInfo + ") ) WHERE " + "id" + " = ? AND " + "convType" + "=" + 1;
    sqlQueryConvMailIds = "SELECT id FROM QM_MAIL_INFO INNER JOIN " + "(SELECT accountId AS aid,folderId AS fid,convHash AS ch,convType AS ct,id AS cid FROM QM_MAIL_INFO WHERE id IN $inClause$)".replace("$inClause$", "(?)") + " ON " + CONDI_CONV_ALL_CHILD + " ORDER BY utcSent DESC";
    sqlUpdateConvMailParentStatus = "UPDATE QM_MAIL_INFO SET $field$=(SELECT COUNT(id) FROM QM_MAIL_INFO mi WHERE mi.$field$=1 AND mi.convType=-1 AND mi.convHash=QM_MAIL_INFO.convHash AND mi.folderId IN (QM_MAIL_INFO.folderId))>0 WHERE id IN (SELECT id FROM QM_MAIL_INFO INNER JOIN " + "(SELECT accountId AS aid,folderId AS fid,convHash AS ch,convType AS ct,id AS cid FROM QM_MAIL_INFO WHERE id IN $inClause$)".replace("$inClause$", "$inClause$ AND convType<>1") + "ON (" + "folderId" + "=fid AND " + "convHash" + "=ch AND " + "convType" + "=1))";
    sqlUpdateConvMailUnread = sqlUpdateConvMailParentStatus.replace("$field$", "isUnread");
    sqlUpdateConvMailStar = sqlUpdateConvMailParentStatus.replace("$field$", "isStar");
    CONDI_CONV_CHILD = "mi.convType IN (-1,0) AND mi.convHash=QM_MAIL_INFO.convHash AND (mi.folderId=QM_MAIL_INFO.folderId OR (NOT mi.convHash&1 AND mi.folderId=" + "(SELECT id FROM QM_FOLDER WHERE accountId=$accountId$ AND type=3)".replace("$accountId$", "mi.accountId") + "))";
    UPDATE_CONV_STATUS = "UPDATE QM_MAIL_INFO SET convCnt=(SELECT COUNT(id) FROM QM_MAIL_INFO AS mi WHERE " + CONDI_CONV_CHILD + ")," + "convUrCnt" + "=(SELECT COUNT(" + "id" + ") FROM " + "QM_MAIL_INFO" + " AS mi WHERE " + "isUnread" + "=1 AND " + CONDI_CONV_CHILD + ")," + "isUnread" + "=EXISTS(SELECT " + "id" + " FROM " + "QM_MAIL_INFO" + " AS mi WHERE " + "isUnread" + "=1 AND " + "mi.convType IN (-1,0) AND mi.convHash=QM_MAIL_INFO.convHash AND (mi.folderId=QM_MAIL_INFO.folderId)" + ")," + "isTopped" + "=EXISTS(SELECT " + "id" + " FROM " + "QM_MAIL_INFO" + " AS mi WHERE " + "isTopped" + "=1 AND " + "mi.convType IN (-1,0) AND mi.convHash=QM_MAIL_INFO.convHash AND (mi.folderId=QM_MAIL_INFO.folderId)" + ")," + "isStar" + "=EXISTS(SELECT " + "id" + " FROM " + "QM_MAIL_INFO" + " AS mi WHERE " + "isStar" + "=1 AND " + "mi.convType IN (-1,0) AND mi.convHash=QM_MAIL_INFO.convHash AND (mi.folderId=QM_MAIL_INFO.folderId)" + ")," + "attr" + "=" + "attr" + "|(CASE EXISTS(SELECT " + "id" + " FROM " + "QM_MAIL_INFO" + " AS mi WHERE " + "attr" + "&" + 2097152L + " AND " + "mi.convType IN (-1,0) AND mi.convHash=QM_MAIL_INFO.convHash AND (mi.folderId=QM_MAIL_INFO.folderId)" + ") WHEN 1 THEN " + 2097152L + " ELSE 0 END)|(CASE EXISTS(SELECT " + "id" + " FROM " + "QM_MAIL_INFO" + " AS mi WHERE " + "attr" + "&" + 512L + " AND " + "mi.convType IN (-1,0) AND mi.convHash=QM_MAIL_INFO.convHash AND (mi.folderId=QM_MAIL_INFO.folderId)" + ") WHEN 1 THEN " + 512L + " ELSE 0 END) WHERE " + "id" + " IN($where$)";
    sqlUpdateConvStatus = UPDATE_CONV_STATUS.replace("$where$", "SELECT id FROM QM_MAIL_INFO WHERE convHash IN$inClause$ AND convType=1");
    sqlUpdateConvStatusByIds = UPDATE_CONV_STATUS.replace("$where$", "SELECT M.id FROM QM_MAIL_INFO AS M INNER JOIN QM_MAIL_INFO AS MM  ON M.convType=1 AND MM.convType<>1 AND MM.id IN$inClause$ AND MM.convHash=M.convHash AND CASE WHEN MM.convType=-1 THEN MM.folderId=M.folderId ELSE 1 END");
    sqlQueryTagMailInfoForDelta = "SELECT M.*, T.* FROM QM_REF_MAIL_TAG AS T LEFT OUTER JOIN QM_MAIL_INFO AS M ON T.mid=M.id AND T.tagId = ? ".replace("?", "QM_FOLDER.remoteId") + " WHERE " + "folderId" + " NOT IN (SELECT " + "id" + " FROM " + "QM_FOLDER" + " WHERE " + "type" + " IN (" + 6 + "," + 5 + ")) AND " + CONDI_ACCOUNT.replace("?", "QM_FOLDER.accountId") + " AND " + "utcSent>=?".replace("?", "QM_FOLDER.since") + " GROUP BY " + "id" + " ORDER BY utcSent DESC";
    sqlQueryTagCnt = "SELECT COUNT(*) FROM (" + sqlQueryTagMailInfoForDelta + ")";
    sqlUpdateLocalMailUrCntIntoFolder = "UPDATE QM_FOLDER SET cliUnreadCount =(CASE WHEN type=14 THEN (" + sqlQueryTagCnt.replace(new StringBuilder().append("AND ").append(CONDI_CONV_IN_SETTING).toString(), "") + " WHERE " + "isUnread" + "=1 AND " + "convType" + " IN (0, -1)) WHEN " + "type" + "=" + 16 + " THEN (" + sqlQueryStarUnreadCount + " AND " + "convType" + " IN (0, -1) AND " + "accountId" + " = " + "QM_FOLDER" + "." + "accountId" + ") ELSE (SELECT COUNT(*) FROM " + "QM_MAIL_INFO" + " AS M " + " INNER JOIN QM_REF_MAIL_ADDR AS A ON M.id = A.mid AND A.roleType IN (1,5 ) " + " WHERE " + "folderId" + " = " + "QM_FOLDER" + "." + "id" + " AND " + "isUnread" + "=1 AND " + " NOT  attr&2048 " + " AND " + CONDI_SUBS_IN_SETTING + " AND (CASE WHEN M." + "attr" + "&" + 512L + " THEN " + "convType" + " IN (1, 0) ELSE " + "convType" + " IN (0, -1) END)) END), " + "cliConvUnreadCount" + " =(CASE WHEN " + "type" + "=" + 14 + " THEN (" + sqlQueryTagCnt.replace(new StringBuilder().append("AND ").append(CONDI_CONV_IN_SETTING).toString(), "") + " WHERE " + "isUnread" + "=1 AND " + "convType" + " IN (0, 1)) ELSE (SELECT COUNT(*) FROM " + "QM_MAIL_INFO" + " AS M " + " INNER JOIN QM_REF_MAIL_ADDR AS A ON M.id = A.mid AND A.roleType IN (1,5 ) " + " WHERE " + "folderId" + " = " + "QM_FOLDER" + "." + "id" + " AND " + "isUnread" + "=1 AND " + " NOT  attr&2048 " + " AND " + CONDI_SUBS_IN_SETTING + " AND " + "convType" + " IN (0, 1)) END) WHERE " + "id" + " IN $inClause$";
    queryAdvertiseMailListExpandConv = "SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE $aid$   AND M.folderId IN (SELECT id FROM QM_FOLDER WHERE $folder_aid$ AND type=1) AND ( attr&512  AND NOT " + CONDI_IS_WHITELIST_AD_MAIL + " OR " + CONDI_IS_BLACKLIST_AD_MAIL + ")";
    queryAdvertiseMailList = queryAdvertiseMailListExpandConv + " AND " + CONDI_CONV_IN_SETTING;
    sqlMailListInFolders = "SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE folderId IN $inClause$  AND " + CONDI_AD_IN_SETTING + " AND " + "( NOT  attr&2048  OR  attr&16384 )" + " AND " + CONDI_CONV_IN_SETTING + " AND " + " (M.folderId=0 OR NOT EXISTS(SELECT silent FROM QM_FOLDER WHERE id = M.folderId AND silent= 1)) " + " ORDER BY utcSent DESC";
    mCacheColumnIndex = new int[100];
    mCacheColumnIndexForEML = new int[100];
    columnCacheInited = false;
    columnCacheForEMLInited = false;
    Arrays.fill(mCacheColumnIndex, -2147483648);
    Arrays.fill(mCacheColumnIndexForEML, -2147483648);
    sqlQueryCntByAccountInAllFolder = "SELECT id,(CASE WHEN type=17 THEN (" + sqlQueryVipCnt + " WHERE " + "isUnread" + " = 1) WHEN " + "type" + "=" + 16 + " THEN (" + sqlQueryStarCnt + " WHERE " + "isUnread" + " = 1) WHEN " + "type" + "=" + 14 + " THEN (" + sqlQueryTagCnt + " WHERE " + "isUnread" + " = 1) WHEN " + "type" + "=" + 18 + " THEN (" + sqlQueryUnreadCnt + ") ELSE (SELECT COUNT(id) FROM " + "QM_MAIL_INFO" + " WHERE " + " attr&256 " + " AND " + "folderId" + "=" + "QM_FOLDER" + "." + "id" + " AND " + "utcSent>=?".replace("?", "QM_FOLDER.since") + " AND " + "isUnread" + "=1) END) AS cliUnreadCount,(CASE WHEN " + "type" + "=" + 17 + " THEN (" + sqlQueryVipCnt + ") WHEN " + "type" + "=" + 16 + " THEN (" + sqlQueryStarCnt + ") WHEN " + "type" + "=" + 14 + " THEN (" + sqlQueryTagCnt + ") WHEN " + "type" + "=" + 18 + " THEN (" + sqlQueryUnreadCnt + ") ELSE (SELECT COUNT(id) FROM " + "QM_MAIL_INFO" + " WHERE " + " attr&256 " + " AND " + "folderId" + "=" + "QM_FOLDER" + "." + "id" + " AND " + "utcSent>=?".replace("?", "QM_FOLDER.since") + ") END) AS cliCount FROM " + "QM_FOLDER" + " WHERE " + "id" + " NOT IN $inClause$ AND " + "accountId" + " = ?";
    sqlQueryCntByAccountInFolder = "SELECT id,(CASE WHEN type=14 THEN (" + sqlQueryTagCnt + " WHERE " + "isUnread" + " = 1) WHEN " + "type" + "=" + 16 + " THEN (" + sqlQueryStarCnt + " WHERE " + "isUnread" + " = 1) WHEN " + "type" + "=" + 18 + " THEN (" + sqlQueryUnreadCnt + ") ELSE (SELECT COUNT(id) FROM " + "QM_MAIL_INFO" + " WHERE " + " attr&256 " + " AND " + "folderId" + "=" + "QM_FOLDER" + "." + "id" + " AND " + "isUnread" + "=1) END) AS cliUnreadCount,(CASE WHEN " + "type" + "=" + 14 + " THEN (" + sqlQueryTagCnt + ") WHEN " + "type" + "=" + 16 + " THEN (" + sqlQueryStarCnt + ") WHEN " + "type" + "=" + 18 + " THEN (" + sqlQueryUnreadCnt + ") ELSE (SELECT COUNT(id) FROM " + "QM_MAIL_INFO" + " WHERE " + " attr&256 " + " AND " + "folderId" + "=" + "QM_FOLDER" + "." + "id" + ") END) AS cliCount FROM " + "QM_FOLDER" + " WHERE " + "id" + " NOT IN $inClause$ AND " + "accountId" + " = ?";
    sqlCreateTmpSearch = "CREATE TABLE IF NOT EXISTS QM_MAIL_INFO(id integer primary key, accountId integer, folderId integer, remoteId varchar, colid integer, messageId varchar, svrKey varchar, subject varchar, abstract varchar, fromAddr varchar, fromAddrId integer, fromAddrName varchar, senderAddr varchar, senderAddrName varchar, utcSent integer, utcReceived integer, utcRecentOpr integer, isUnread integer, isStar integer, isLoaded integer, isTopped integer, attr integer, size integer, tags varchar, reference varchar, sendStatus integer, localCount integer, sendutc integer, convType integer, convHash integer, convRefHash integer, convContactHash integer, convCnt integer, convUrCnt integer, qqAdType integer, qqSpamType integer, xqqstyle integer, toppedAdTime integer default -1) ".replace("QM_MAIL_INFO", "QM_TMP_SEARCH_MAIL_INFO");
    sqlInsertTmpSearch = "REPLACE INTO QM_MAIL_INFO ( id,accountId,messageId,folderId,remoteId,colid,convType,attr,size,svrKey,subject,abstract,fromAddr,fromAddrId,fromAddrName,senderAddr,senderAddrName,utcSent,utcReceived,utcRecentOpr,isUnread,isLoaded,isStar,tags,reference,sendStatus,localCount,sendutc,messageId,convHash,convRefHash,convContactHash,convCnt,convUrCnt,qqAdType,qqSpamType,xqqstyle,toppedAdTime) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)".replace("QM_MAIL_INFO", "QM_TMP_SEARCH_MAIL_INFO");
    sqlCreateTmpSearchAddr = "CREATE TABLE IF NOT EXISTS QM_REF_MAIL_ADDR (uid integer primary key, mid integer, addrId integer, roleType integer, addrName varchar, address varchar, uin varchar,seq integer default 0)".replace("QM_REF_MAIL_ADDR", "QM_TMP_SEARCH_MAIL_ADDR");
    sqlInsertTmpSearchAddr = "REPLACE INTO QM_REF_MAIL_ADDR (uid,mid,addrId,addrName,address,roleType,uin,seq) VALUES (?,?,?,?,?,?,?,?)".replace("QM_REF_MAIL_ADDR", "QM_TMP_SEARCH_MAIL_ADDR");
    sqlCreateTmpEmlForUpgrade = "CREATE TABLE IF NOT EXISTS QM_MAIL_INFO(id integer primary key, accountId integer, folderId integer, remoteId varchar, colid integer, messageId varchar, svrKey varchar, subject varchar, abstract varchar, fromAddr varchar, fromAddrId integer, fromAddrName varchar, senderAddr varchar, senderAddrName varchar, utcSent integer, utcReceived integer, utcRecentOpr integer, isUnread integer, isStar integer, isLoaded integer, isTopped integer, attr integer, size integer, tags varchar, reference varchar, sendStatus integer, localCount integer, sendutc integer, convType integer, convHash integer, convRefHash integer, convContactHash integer, convCnt integer, convUrCnt integer, qqAdType integer, qqSpamType integer, xqqstyle integer, toppedAdTime integer default -1) ".replace("QM_MAIL_INFO", "QM_TMP_EML_MAIL_INFO");
    sqlCreateTmpEml = "CREATE TABLE IF NOT EXISTS QM_MAIL_INFO(id integer primary key, accountId integer, folderId integer, remoteId varchar, colid integer, messageId varchar, svrKey varchar, subject varchar, abstract varchar, fromAddr varchar, fromAddrId integer, fromAddrName varchar, senderAddr varchar, senderAddrName varchar, utcSent integer, utcReceived integer, utcRecentOpr integer, isUnread integer, isStar integer, isLoaded integer, isTopped integer, attr integer, size integer, tags varchar, reference varchar, sendStatus integer, localCount integer, sendutc integer, convType integer, convHash integer, convRefHash integer, convContactHash integer, convCnt integer, convUrCnt integer, qqAdType integer, qqSpamType integer, xqqstyle integer, toppedAdTime integer default -1) ".replace("QM_MAIL_INFO", "QM_TMP_EML_MAIL_INFO");
    sqlCreateTmpEmlAddrForUpgrade = "CREATE TABLE IF NOT EXISTS QM_REF_MAIL_ADDR (uid integer primary key, mid integer, addrId integer, roleType integer, addrName varchar, address varchar, uin varchar,seq integer default 0)".replace("QM_REF_MAIL_ADDR", "QM_TMP_EML_MAIL_ADDR");
    sqlCreateTmpEmlAddr = "CREATE TABLE IF NOT EXISTS QM_REF_MAIL_ADDR (uid integer primary key, mid integer, addrId integer, roleType integer, addrName varchar, address varchar, uin varchar,seq integer default 0)".replace("QM_REF_MAIL_ADDR", "QM_TMP_EML_MAIL_ADDR");
    sqlInsertTmpEmlAddr = "REPLACE INTO QM_REF_MAIL_ADDR (uid,mid,addrId,addrName,address,roleType,uin,seq) VALUES (?,?,?,?,?,?,?,?)".replace("QM_REF_MAIL_ADDR", "QM_TMP_EML_MAIL_ADDR");
    SEARCH_EXPAND_CONV = " SELECT MIX.id FROM (SELECT M.* FROM QM_MAIL_INFO AS M  WHERE M.id IN $inClause$ ) AS ORI ,(SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId) AS MIX  WHERE  ORI.id=MIX.id OR (ORI.convType=1 AND ORI.convHash = MIX.convHash) OR ( ORI. attr&2048  AND (CASE ORI.folderId=0  WHEN 1 THEN " + " EXISTS (SELECT * FROM QM_FOLDER AS FD  WHERE FD.id=$alias$.folderId AND FD.type=1)".replace("$alias$", "MIX") + " ELSE ORI." + "folderId" + "=MIX." + "folderId" + " END) AND (MIX." + " attr&512 " + " OR MIX." + "ruleType" + "=" + 2 + ") )  OR (ORI." + " attr&8192 " + " AND MIX." + " attr&4096 " + " AND " + " EXISTS (SELECT id,type FROM QM_FOLDER AS FD  WHERE FD.id=$alias$.folderId AND FD.type=15)".replace("$alias$", "MIX") + " AND ORI." + "accountId" + "=MIX." + "accountId" + ")";
    SEARCH_WHERE_FOLDER = " M.id IN (" + SEARCH_EXPAND_CONV + ") AND " + " NOT  attr&2048 " + " AND " + " NOT  attr&8192 ";
    SEARCH_LIKE_INNER = "SELECT id,utcReceived FROM (SELECT M.* FROM $area$ WHERE $where$ AND $more_filter$ AND " + CONDI_CONV_IN_SETTING + " GROUP BY M." + "id" + ")";
    SEARCH_PARAM_ALL = " (M.abstract LIKE $keyword$  AND NOT M.abstract LIKE " + DatabaseUtils.sqlEscapeString("(无摘要)") + " AND NOT M." + "abstract" + " LIKE " + DatabaseUtils.sqlEscapeString("（无摘要）") + ") OR EXISTS (SELECT * FROM " + "QM_FTN_ATTACH" + " AS FTN WHERE FTN." + "mailid" + "=M." + "id" + " AND FTN." + "name" + " LIKE $keyword$) OR EXISTS (SELECT * FROM " + "QM_MAIL_ATTACH" + " AS ATT WHERE ATT." + "mailid" + "=M." + "id" + " AND ATT." + "name" + " LIKE $keyword$)  OR C." + "content" + " LIKE $keyword$ ";
    SEARCH_TYPE_SUBJECT = SEARCH_LIKE_INNER.replace("$area$", "QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_CONTACT AS E ON E.address=M.fromAddr").replace("$more_filter$", " (M.subject LIKE $keyword$) ");
    SEARCH_TYPE_SENDER = SEARCH_LIKE_INNER.replace("$area$", "QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_CONTACT AS E ON E.address=M.fromAddr").replace("$more_filter$", " (M.fromAddr LIKE $keyword$  OR M.fromAddrName LIKE $keyword$  OR E.name LIKE $keyword$ ) ");
    SEARCH_TYPE_RECEIVER = SEARCH_LIKE_INNER.replace("$area$", "QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_CONTACT AS E ON E.address=M.fromAddr").replace("$more_filter$", " EXISTS (SELECT * FROM QM_REF_MAIL_ADDR AS AD LEFT OUTER JOIN QM_CONTACT AS EC  ON AD.address=EC.address WHERE AD.roleType <> 1  AND AD.mid=M.id AND (AD.addrName LIKE $keyword$ OR AD.address LIKE $keyword$ OR EC.name LIKE $keyword$ ))");
    SEARCH_ALL = SEARCH_LIKE_INNER.replace("$area$", "QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_CONTACT AS E ON E.address=M.fromAddr LEFT OUTER JOIN QM_MAIL_CONTENT AS C ON M.id=C.id").replace("$more_filter$", " ( (M.subject LIKE $keyword$)  OR  (M.fromAddr LIKE $keyword$  OR M.fromAddrName LIKE $keyword$  OR E.name LIKE $keyword$ )  OR " + SEARCH_PARAM_ALL + " OR " + " EXISTS (SELECT * FROM QM_REF_MAIL_ADDR AS AD LEFT OUTER JOIN QM_CONTACT AS EC  ON AD.address=EC.address WHERE AD.roleType <> 1  AND AD.mid=M.id AND (AD.addrName LIKE $keyword$ OR AD.address LIKE $keyword$ OR EC.name LIKE $keyword$ ))" + ") ");
    sqlSearchLikeSubject = SEARCH_TYPE_SUBJECT + " ORDER BY utcReceived DESC ";
    sqlSearchLikeSender = SEARCH_TYPE_SENDER + " ORDER BY utcReceived DESC ";
    sqlSearchLikeReceiver = SEARCH_TYPE_RECEIVER + " ORDER BY utcReceived DESC ";
    sqlSearchLikeAll = SEARCH_ALL + " ORDER BY utcReceived DESC ";
    SEARCH_MATCH_INNER = "SELECT id,utcReceived FROM QM_MAIL_INFO AS M, QM_MAIL_INFO_FTS_SEARCH AS MIS WHERE MIS.docid IN  (SELECT M.id FROM QM_MAIL_INFO AS M WHERE $where$ AND " + CONDI_CONV_IN_SETTING + ") AND $match_filter$ AND MIS." + "docid" + "=M." + "id" + " GROUP BY M." + "id" + " ORDER BY utcReceived DESC ";
    sqlSearchMatchSender = SEARCH_MATCH_INNER.replace("$match_filter$", "MIS.$type$ MATCH $keyword$".replace("$type$", "sender"));
    sqlSearchMatchReceiver = SEARCH_MATCH_INNER.replace("$match_filter$", "MIS.$type$ MATCH $keyword$".replace("$type$", "receiver"));
    sqlSearchMatchSubject = SEARCH_MATCH_INNER.replace("$match_filter$", "MIS.$type$ MATCH $keyword$".replace("$type$", "subject"));
    sqlSearchMatchAll = SEARCH_MATCH_INNER.replace("$match_filter$", "MIS.docid IN (SELECT MIS.docid FROM QM_MAIL_INFO_FTS_SEARCH AS MIS WHERE QM_MAIL_INFO_FTS_SEARCH MATCH $keyword$ UNION SELECT MCS.docid FROM QM_MAIL_CONTENT_FTS_SEARCH AS MCS WHERE MCS.content MATCH $keyword$)");
    querySubscribeMailList = "SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE $accountId$ AND  attr&4096  AND " + " EXISTS (SELECT id,type FROM QM_FOLDER AS FD  WHERE FD.id=$alias$.folderId AND FD.type=15)".replace("$alias$", "M") + " ORDER BY utcReceived DESC, colid ASC ";
    sqlCountUnreadSubscribeMail = "SELECT COUNT(DISTINCT M.id) FROM QM_MAIL_INFO AS M  WHERE $accountId$  AND  attr&4096  AND " + " EXISTS (SELECT id,type FROM QM_FOLDER AS FD  WHERE FD.id=$alias$.folderId AND FD.type=15)".replace("$alias$", "M") + " AND " + "isUnread" + "=1";
    sqlCountUnreadAdMail = "SELECT COUNT(DISTINCT M.id) FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE $accountId$  AND ( attr&512  AND NOT " + CONDI_IS_WHITELIST_AD_MAIL + " OR " + CONDI_IS_BLACKLIST_AD_MAIL + ") AND " + CONDI_CONV_IN_SETTING + " AND " + " EXISTS (SELECT * FROM QM_FOLDER AS FD  WHERE FD.id=$alias$.folderId AND FD.type=1)".replace("$alias$", "M") + " AND " + "isUnread" + "=1 ";
    updateAdvertiseConvUnread = "UPDATE QM_MAIL_INFO SET isUnread =(" + sqlCountUnreadAdMail.replace("$accountId$", "accountId=QM_MAIL_INFO.accountId") + ")>0  WHERE " + " attr&2048 ";
    updateAllAdvertiseConvUnread = "UPDATE QM_MAIL_INFO SET isUnread =(" + sqlCountUnreadAdMail.replace("$accountId$", "1=1") + ")>0  WHERE " + " attr&2048 " + " AND " + "accountId" + "=0";
  }
  
  public QMMailSQLite(Context paramContext)
  {
    super(paramContext, false);
  }
  
  private static void beginColumnIndex(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null) {
      paramArrayOfInt[0] = 0;
    }
  }
  
  private int checkAggregateConvHasUnread(SQLiteDatabase paramSQLiteDatabase, int paramInt, long paramLong)
  {
    String str1;
    String str2;
    if (Mail.isAdConv(paramLong))
    {
      str1 = sqlCountUnreadAdMail;
      if (paramInt == 0) {
        break label91;
      }
      str2 = "accountId=" + paramInt;
      label38:
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(str1.replace("$accountId$", str2), null);
      if (paramSQLiteDatabase == null) {
        break label104;
      }
      if (!paramSQLiteDatabase.moveToFirst()) {
        break label99;
      }
    }
    label91:
    label99:
    for (paramInt = paramSQLiteDatabase.getInt(0);; paramInt = 0)
    {
      paramSQLiteDatabase.close();
      return paramInt;
      str1 = sqlCountUnreadSubscribeMail;
      break;
      str2 = "1=1";
      break label38;
    }
    label104:
    return 0;
  }
  
  private void createConvParent(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2, int paramInt3)
  {
    QMMailManager localQMMailManager = QMMailManager.sharedInstance();
    Object localObject2 = getConvMailInfo(paramSQLiteDatabase, paramInt1, paramInt2, paramInt3, false);
    if (localObject2 == null)
    {
      QMLog.log(6, "QMMailSQLite", "createConvParent. mail null");
      return;
    }
    if (getConvMailInfo(paramSQLiteDatabase, paramInt1, paramInt2, paramInt3, true) == null)
    {
      QMLog.log(6, "QMMailSQLite", "getConvMailInfo. mail null");
      return;
    }
    MailInformation localMailInformation2 = ((Mail)localObject2).getInformation();
    Mail localMail = new Mail();
    MailInformation localMailInformation1 = new MailInformation();
    Object localObject1 = new MailStatus();
    localMail.setInformation(localMailInformation1);
    localMailInformation1.setAccountId(paramInt1);
    localMailInformation1.setConvHash(paramInt3);
    localMailInformation1.setFolderId(paramInt2);
    localMailInformation1.setSubject(localMailInformation2.getSubject());
    localMailInformation1.setFrom(localMailInformation2.getFrom());
    localMailInformation1.setToList(localMailInformation2.getToList());
    localMailInformation1.setUtc(localMailInformation2.getUtc());
    localMailInformation1.setDate(localMailInformation2.getDate());
    localMailInformation1.setAbstractContent(localMailInformation2.getAbstractContent());
    localMailInformation1.setConvType(1);
    localMail.setStatus((MailStatus)localObject1);
    ((MailStatus)localObject1).setConversation(true);
    ((MailStatus)localObject1).setHasAttach(((Mail)localObject2).getStatus().hasAttach());
    localObject2 = AccountManager.shareInstance().getAccountList().getAccountById(paramInt1);
    if ((localObject2 != null) && (!((Account)localObject2).isQQMail())) {
      ((MailStatus)localObject1).setProtocolMail(true);
    }
    localObject1 = Mail.generateConvMailId(paramInt2, paramInt3);
    localMailInformation1.setMessageId((String)localObject1);
    long l = Mail.generateId(paramInt1, (String)localObject1);
    localMailInformation1.setRemoteId("_CONV_REMOTE_ID_" + l);
    updateConvMailChilds(paramSQLiteDatabase, paramInt1, paramInt3, paramInt2, true);
    localMailInformation1.setId(l);
    localQMMailManager.saveMail(paramSQLiteDatabase, localMail, 1024);
    updateMailLoaded(paramSQLiteDatabase, l, true);
  }
  
  private boolean deleteAggregateConv(SQLiteDatabase paramSQLiteDatabase, int paramInt, long paramLong)
  {
    if (paramInt == 0) {
      if (paramSQLiteDatabase.delete("QM_MAIL_INFO", "attr&? ", new String[] { paramLong + "" }) <= 0) {}
    }
    while (paramSQLiteDatabase.delete("QM_MAIL_INFO", "accountId=? AND attr&? ", new String[] { paramInt + "", paramLong + "" }) > 0)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public static void fillMail(Cursor paramCursor, Mail paramMail)
  {
    fillMail(paramCursor, paramMail, null);
  }
  
  public static void fillMail(Cursor paramCursor, Mail paramMail, int[] paramArrayOfInt)
  {
    beginColumnIndex(paramArrayOfInt);
    MailInformation localMailInformation = paramMail.getInformation();
    int i = fillMailInfo(paramCursor, localMailInformation, paramArrayOfInt);
    paramMail = paramMail.getStatus();
    fillMailStatus(localMailInformation.getAccountId(), paramCursor, paramArrayOfInt, i, paramMail);
  }
  
  private Mail fillMailAll(SQLiteDatabase paramSQLiteDatabase, Cursor paramCursor, boolean paramBoolean1, boolean paramBoolean2)
  {
    Mail localMail = new Mail();
    localMail.setStatus(new MailStatus());
    localMail.setInformation(new MailInformation());
    fillMail(paramCursor, localMail);
    readMailExtra(paramSQLiteDatabase, paramBoolean1, paramBoolean2, localMail);
    return localMail;
  }
  
  private void fillMailContent(SQLiteDatabase paramSQLiteDatabase, Mail paramMail)
  {
    if (paramMail.getStatus().isGroupVote()) {
      paramMail.setVote(readVoteContent(paramSQLiteDatabase, paramMail.getInformation().getId()));
    }
    if (paramMail.getStatus().isIcs()) {
      paramMail.setIcsEvent(getIcsEventByRemoteMailId(paramSQLiteDatabase, paramMail.getInformation().getRemoteId(), paramMail.getInformation().getAccountId()));
    }
    paramMail.setContent(readMailContent(paramSQLiteDatabase, paramMail.getInformation().getId()));
  }
  
  private static int fillMailInfo(Cursor paramCursor, MailInformation paramMailInformation, int[] paramArrayOfInt)
  {
    paramMailInformation.setId(paramCursor.getLong(getColumnIndex(paramArrayOfInt, paramCursor, "id")));
    paramMailInformation.setAccountId(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "accountId")));
    paramMailInformation.setRemoteId(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "remoteId")));
    paramMailInformation.setFolderId(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "folderId")));
    paramMailInformation.setSubject(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "subject")));
    paramMailInformation.setAbstractContent(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "abstract")));
    paramMailInformation.setDate(new Date(paramCursor.getLong(getColumnIndex(paramArrayOfInt, paramCursor, "utcSent"))));
    paramMailInformation.setUtc(new Date(paramCursor.getLong(getColumnIndex(paramArrayOfInt, paramCursor, "utcSent"))));
    paramMailInformation.setLastOptTime(new Date(paramCursor.getLong(getColumnIndex(paramArrayOfInt, paramCursor, "utcRecentOpr"))));
    paramMailInformation.setConvHash(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "convHash")));
    paramMailInformation.setSize(paramCursor.getLong(getColumnIndex(paramArrayOfInt, paramCursor, "size")));
    paramMailInformation.setQQmailAdType(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "qqAdType")));
    paramMailInformation.setReferences(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "reference")));
    paramMailInformation.setMessageId(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "messageId")));
    paramMailInformation.setLocalCount(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "localCount")));
    paramMailInformation.setSendUtc(paramCursor.getLong(getColumnIndex(paramArrayOfInt, paramCursor, "sendutc")));
    paramMailInformation.setSvrKey(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "svrKey")));
    int i = paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "convType"));
    paramMailInformation.setConvType(i);
    fillMailInfoTagList(paramMailInformation, paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "tags")));
    paramMailInformation.setConvCount(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "convCnt")));
    paramMailInformation.setConvUrCnt(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "convUrCnt")));
    MailContact localMailContact = new MailContact();
    localMailContact.setAddress(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "fromAddr")));
    String str = paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "fromAddrName"));
    if (str != null)
    {
      localObject = str;
      if (!str.equals("")) {}
    }
    else
    {
      if ((localMailContact.getAddress() == null) || (!localMailContact.getAddress().contains("@"))) {
        break label578;
      }
    }
    label578:
    for (Object localObject = localMailContact.getAddress().split("@")[0];; localObject = QMApplicationContext.sharedInstance().getResources().getString(2131693125))
    {
      localMailContact.setName((String)localObject);
      localMailContact.setNick((String)localObject);
      paramMailInformation.setFrom(localMailContact);
      localObject = new MailContact();
      ((MailContact)localObject).setAddress(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "senderAddr")));
      ((MailContact)localObject).setName(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "senderAddrName")));
      paramMailInformation.setSender((MailContact)localObject);
      return i;
    }
  }
  
  public static void fillMailInfoTagList(MailInformation paramMailInformation, String paramString)
  {
    if (paramString == null) {
      return;
    }
    paramString = paramString.split("\\|");
    ArrayList localArrayList = new ArrayList();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramString[i];
      if ((localObject != null) && (!"".equals(localObject)))
      {
        String[] arrayOfString = localObject.split("\\.");
        if ((arrayOfString != null) && (arrayOfString.length > 1))
        {
          MailTag localMailTag = new MailTag();
          localMailTag.setTagId(arrayOfString[0]);
          localMailTag.setColor(arrayOfString[1]);
          localMailTag.setName(localObject.replace(arrayOfString[0] + "." + arrayOfString[1] + ".", ""));
          localArrayList.add(localMailTag);
        }
      }
      i += 1;
    }
    paramMailInformation.setTagList(localArrayList);
  }
  
  private static void fillMailRecall(Cursor paramCursor, MailRecall paramMailRecall)
  {
    paramMailRecall.setId(paramCursor.getInt(paramCursor.getColumnIndex("id")));
    paramMailRecall.setMid(paramCursor.getInt(paramCursor.getColumnIndex("mid")));
    paramMailRecall.setReceiver(paramCursor.getString(paramCursor.getColumnIndex("receiver")));
    paramMailRecall.setStatus(paramCursor.getInt(paramCursor.getColumnIndex("status")));
  }
  
  private static void fillMailStatus(int paramInt1, Cursor paramCursor, int[] paramArrayOfInt, int paramInt2, MailStatus paramMailStatus)
  {
    boolean bool2 = true;
    if (paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "isLoaded")) != 0)
    {
      bool1 = true;
      paramMailStatus.setLoaded(bool1);
      if (paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "isTopped")) == 0) {
        break label291;
      }
      bool1 = true;
      label50:
      paramMailStatus.setTopped(bool1);
      if (paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "isUnread")) == 0) {
        break label297;
      }
      bool1 = true;
      label77:
      paramMailStatus.setUnread(bool1);
      if (paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "isStar")) == 0) {
        break label303;
      }
      bool1 = true;
      label104:
      paramMailStatus.setStarred(bool1);
      paramMailStatus.setSendStatus(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "sendStatus")));
      paramMailStatus.setXQQStyle(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "xqqstyle")));
      if (getColumnIndex(paramArrayOfInt, paramCursor, "toppedAdTime") >= 0) {
        paramMailStatus.setToppedAdTime(paramCursor.getLong(getColumnIndex(paramArrayOfInt, paramCursor, "toppedAdTime")));
      }
      paramMailStatus.setCheat(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "qqSpamType")));
      int i = paramCursor.getColumnIndex("ruleType");
      if (i != -1)
      {
        i = paramCursor.getInt(i);
        if (i != 2) {
          break label309;
        }
        bool1 = true;
        label234:
        paramMailStatus.setAdByUser(bool1);
        if (i != 1) {
          break label315;
        }
      }
    }
    label291:
    label297:
    label303:
    label309:
    label315:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramMailStatus.setNotAdByUser(bool1);
      fillMailStatusAttr(paramMailStatus, paramCursor.getLong(getColumnIndex(paramArrayOfInt, paramCursor, "attr")));
      fillMailStatusConvType(paramInt1, paramMailStatus, paramInt2);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label50;
      bool1 = false;
      break label77;
      bool1 = false;
      break label104;
      bool1 = false;
      break label234;
    }
  }
  
  public static void fillMailStatusAttr(MailStatus paramMailStatus, long paramLong)
  {
    if ((0x100 & paramLong) != 0L) {
      paramMailStatus.setNeedSync(true);
    }
    if ((0x200 & paramLong) != 0L) {
      paramMailStatus.setAdMail(true);
    }
    if ((0x1000 & paramLong) != 0L) {
      paramMailStatus.setSubscribeMail(true);
    }
    if ((0x800 & paramLong) != 0L) {
      paramMailStatus.setAdConv(true);
    }
    if ((0x2000 & paramLong) != 0L) {
      paramMailStatus.setSubscribeConv(true);
    }
    if ((0x4000 & paramLong) != 0L) {
      paramMailStatus.setHybirdList(true);
    }
    if ((0x8000 & paramLong) != 0L) {
      paramMailStatus.setSystemMail(true);
    }
    if ((0x0 & paramLong) != 0L) {
      paramMailStatus.setCalendarMail(true);
    }
    if ((0x400 & paramLong) != 0L) {
      paramMailStatus.setNeedCheck(true);
    }
    if ((0x10000 & paramLong) != 0L) {
      paramMailStatus.setChecked(true);
    }
    if ((0x40000 & paramLong) != 0L) {
      paramMailStatus.setSubscribeLoaded(true);
    }
    if ((0x80000 & paramLong) != 0L) {
      paramMailStatus.setReply(true);
    }
    if ((0x100000 & paramLong) != 0L) {
      paramMailStatus.setForward(true);
    }
    if ((0x20000000 & paramLong) != 0L) {
      paramMailStatus.setFirstShowForward(true);
    }
    if ((0x200000 & paramLong) != 0L) {
      paramMailStatus.setHasAttach(true);
    }
    if ((0x400000 & paramLong) != 0L) {
      paramMailStatus.setProtocolMail(true);
    }
    if ((0x800000 & paramLong) != 0L) {
      paramMailStatus.setGroupMail(true);
    }
    if ((0x1000000 & paramLong) != 0L) {
      paramMailStatus.setContentComplete(true);
    }
    if ((0x2000000 & paramLong) != 0L) {
      paramMailStatus.setLocalMail(true);
    }
    if ((0x4000000 & paramLong) != 0L) {
      paramMailStatus.setNoReferences(true);
    }
    if ((0x20000 & paramLong) != 0L) {
      paramMailStatus.setIsVip(true);
    }
    if ((0x40000000 & paramLong) != 0L) {
      paramMailStatus.setAbstractLoaded(true);
    }
    if ((0x40 & paramLong) != 0L) {
      paramMailStatus.setIsGroupOff(true);
    }
    if ((0x80 & paramLong) != 0L) {
      paramMailStatus.setIsGroupAdmin(true);
    }
    if ((0x80000000 & paramLong) != 0L) {
      paramMailStatus.setIsGroupVote(true);
    }
    if ((0x20 & paramLong) != 0L) {
      paramMailStatus.setIcs(true);
    }
    if ((0x10 & paramLong) != 0L) {
      paramMailStatus.setRecall(true);
    }
    if ((0x4 & paramLong) != 0L) {
      paramMailStatus.setIsSepCpy(true);
    }
    if ((0x2 & paramLong) != 0L) {
      paramMailStatus.setHasDetectLanguageByMailContent(true);
    }
    if ((0x0 & paramLong) != 0L) {
      paramMailStatus.setIsForeignLanguageSupport(true);
    }
    if ((0x0 & paramLong) != 0L) {
      paramMailStatus.setHasFixDetectLanguageResult(true);
    }
    if ((0x0 & paramLong) != 0L) {
      paramMailStatus.setAppleId(true);
    }
    for (;;)
    {
      if ((0x0 & paramLong) != 0L) {
        paramMailStatus.setAttrAppleIdWecharCheck(true);
      }
      if ((0x0 & paramLong) != 0L) {
        paramMailStatus.setAttrHasAppend(true);
      }
      if ((0x0 & paramLong) != 0L) {
        paramMailStatus.setAttrIsCreditMail(true);
      }
      if ((0x0 & paramLong) != 0L) {
        paramMailStatus.setAttrIsJourneyMail(true);
      }
      return;
      paramMailStatus.setAppleId(false);
    }
  }
  
  public static void fillMailStatusConvType(int paramInt1, MailStatus paramMailStatus, int paramInt2)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramMailStatus.isGroupMail())
    {
      if (paramInt2 == -1) {}
      for (;;)
      {
        paramMailStatus.setGroupChild(bool1);
        return;
        bool1 = false;
      }
    }
    if (paramInt2 == 1)
    {
      bool1 = true;
      paramMailStatus.setConversation(bool1);
      if (paramInt2 != -1) {
        break label60;
      }
    }
    label60:
    for (bool1 = bool2;; bool1 = false)
    {
      paramMailStatus.setConversationChild(paramInt1, bool1);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static void fillSubscribeMail(Cursor paramCursor, SubscribeMail paramSubscribeMail)
  {
    paramSubscribeMail.setAbstract(paramCursor.getString(paramCursor.getColumnIndex("abstract")));
    paramSubscribeMail.setAccountId(paramCursor.getInt(paramCursor.getColumnIndex("accountId")));
    paramSubscribeMail.setColId(paramCursor.getInt(paramCursor.getColumnIndex("colid")));
    paramSubscribeMail.setIcon(paramCursor.getString(paramCursor.getColumnIndex("icon")));
    paramSubscribeMail.setBigIcon(paramCursor.getString(paramCursor.getColumnIndex("bigIcon")));
    paramSubscribeMail.setId(paramCursor.getLong(paramCursor.getColumnIndex("id")));
    paramSubscribeMail.setLink(paramCursor.getString(paramCursor.getColumnIndex("link")));
    paramSubscribeMail.setRemoteId(paramCursor.getString(paramCursor.getColumnIndex("remoteId")));
    long l = paramCursor.getInt(paramCursor.getColumnIndex("utcReceived"));
    Date localDate = new Date();
    localDate.setTime(l * 1000L);
    paramSubscribeMail.setReceive(localDate);
    paramSubscribeMail.setSubject(paramCursor.getString(paramCursor.getColumnIndex("subject")));
    paramSubscribeMail.setIndex(paramCursor.getInt(paramCursor.getColumnIndex("idx")));
    paramSubscribeMail.setFromAddress(paramCursor.getString(paramCursor.getColumnIndex("fromAddr")));
    paramSubscribeMail.setFromName(paramCursor.getString(paramCursor.getColumnIndex("fromName")));
    paramSubscribeMail.setMid(paramCursor.getLong(paramCursor.getColumnIndex("mid")));
  }
  
  private String filterMatchChar(String paramString)
  {
    if (paramString != null)
    {
      paramString = paramString.trim();
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      if (i < paramString.length())
      {
        char c = paramString.charAt(i);
        if (c == '\'')
        {
          localStringBuilder.append('\'');
          label48:
          localStringBuilder.append(c);
        }
        for (;;)
        {
          i += 1;
          break;
          if (c != '"') {
            break label48;
          }
        }
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static int genRMAAddrId(String paramString)
  {
    if (paramString == null) {}
    for (paramString = "";; paramString = paramString.toLowerCase()) {
      return QMMath.hashInt(paramString);
    }
  }
  
  private long genRMAId(long paramLong, int paramInt1, int paramInt2)
  {
    return QMMath.hashLong(paramLong + "^" + paramInt1 + "^" + paramInt2);
  }
  
  private long genRMTId(long paramLong, String paramString)
  {
    return QMMath.hashLong(paramLong + "^" + paramString);
  }
  
  private String generateSearchExceptLockFolderFilter(int paramInt)
  {
    if (paramInt == 0)
    {
      String str = " AND (" + generateSearchExceptLockFolderFilterByAllAccounts();
      return str + ")";
    }
    return generateSearchExceptLockFolderFilterByOneAccount(paramInt);
  }
  
  private String generateSearchExceptLockFolderFilterByAllAccounts()
  {
    int j = 0;
    String str1 = "";
    AccountList localAccountList = AccountManager.shareInstance().getAccountList();
    int i = 0;
    if (i < localAccountList.size())
    {
      Account localAccount = localAccountList.get(i);
      if (localAccount == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (j == 0) {}
        for (String str2 = "";; str2 = " OR ")
        {
          j += 1;
          if (!localAccount.isLocked()) {
            break label196;
          }
          String str3 = getLockFolderTypeByAccount(localAccount);
          str1 = str1 + str2 + "EXISTS (SELECT * FROM " + "QM_FOLDER" + " AS FD WHERE FD." + "id" + "=M." + "folderId" + " AND M." + "accountId" + "=" + localAccount.getId() + " AND FD." + "type" + " NOT IN (" + str3 + "))";
          break;
        }
        label196:
        str1 = str1 + str2 + "EXISTS (SELECT * FROM " + "QM_FOLDER" + " AS FD WHERE FD." + "id" + "=M." + "folderId" + " AND M." + "accountId" + "=" + localAccount.getId() + ")";
      }
    }
    return str1;
  }
  
  private String generateSearchExceptLockFolderFilterByOneAccount(int paramInt)
  {
    String str2 = "";
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    String str1 = str2;
    if (localAccount != null)
    {
      str1 = str2;
      if (localAccount.isLocked())
      {
        str1 = getLockFolderTypeByAccount(localAccount);
        str1 = " AND EXISTS (SELECT * FROM QM_FOLDER AS FD WHERE FD.id=M.folderId AND FD.type NOT IN (" + str1 + "))";
      }
    }
    return str1;
  }
  
  private String generateTmpTableForMailAddrUpgradeSql(String paramString1, String paramString2)
  {
    return paramString1.replace("QM_REF_MAIL_ADDR", paramString2);
  }
  
  private String generateTmpTableForMailInfoUpgradeSql(String paramString1, String paramString2)
  {
    return paramString1.replace("QM_MAIL_INFO", paramString2);
  }
  
  private long[] getAdMailByStat(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString)
  {
    String str = "SELECT id FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE $accountId$  AND " + paramString + " AND (" + " attr&512 " + " AND NOT " + CONDI_IS_WHITELIST_AD_MAIL + " OR " + CONDI_IS_BLACKLIST_AD_MAIL + ") AND " + " NOT  attr&2048 ";
    if (paramInt != 0) {}
    for (paramString = "accountId=" + paramInt;; paramString = "1=1")
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(str.replace("$accountId$", paramString), new String[0]);
      paramString = new long[paramSQLiteDatabase.getCount()];
      if (paramSQLiteDatabase == null) {
        return paramString;
      }
      if (!paramSQLiteDatabase.moveToFirst()) {
        break;
      }
      int i = paramSQLiteDatabase.getCount();
      paramInt = 0;
      while (paramInt < i)
      {
        paramSQLiteDatabase.moveToPosition(paramInt);
        paramString[paramInt] = paramSQLiteDatabase.getLong(0);
        paramInt += 1;
      }
    }
    paramSQLiteDatabase.close();
    return paramString;
  }
  
  protected static int getColumnIndex(int[] paramArrayOfInt, Cursor paramCursor, String paramString)
  {
    if (paramArrayOfInt == null) {
      return paramCursor.getColumnIndex(paramString);
    }
    int i = paramArrayOfInt[0] + 1;
    paramArrayOfInt[0] = i;
    if ((paramArrayOfInt[i] > -2147483648) && (paramArrayOfInt[i] != -1)) {
      return paramArrayOfInt[i];
    }
    paramArrayOfInt[i] = paramCursor.getColumnIndex(paramString);
    return paramArrayOfInt[i];
  }
  
  private ArrayList<Integer> getExistQQAccountIdsFromSp()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).getAll();
    if (localObject != null)
    {
      localObject = ((Map)localObject).keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (str.endsWith("save_sid")) {
          try
          {
            localArrayList.add(Integer.valueOf(Integer.parseInt(str.replace("save_sid", ""))));
          }
          catch (Exception localException)
          {
            QMLog.log(6, "QMMailSQLite", Log.getStackTraceString(localException));
          }
        }
      }
    }
    return localArrayList;
  }
  
  private Object[] getFolderCursorParams(QMFolder paramQMFolder)
  {
    int i = paramQMFolder.getAccountId();
    String str;
    String[] arrayOfString;
    switch (paramQMFolder.getType())
    {
    case 15: 
    case 17: 
    default: 
      str = sqlQueryFolderMailInfo;
      arrayOfString = new String[2];
      arrayOfString[0] = String.valueOf(paramQMFolder.getId());
      arrayOfString[1] = String.valueOf(paramQMFolder.getSince());
      paramQMFolder = arrayOfString;
    }
    for (;;)
    {
      return new Object[] { str, paramQMFolder };
      int j = QMFolderManager.sharedInstance().getTrashFolderId(i);
      int k = QMFolderManager.sharedInstance().getSpamFolderId(i);
      str = sqlQueryTagMailInfo.replace("$notInFolderInClause$", getInClause(new int[] { j, k }));
      arrayOfString = new String[3];
      arrayOfString[0] = paramQMFolder.getRemoteId();
      arrayOfString[1] = String.valueOf(i);
      arrayOfString[2] = String.valueOf(paramQMFolder.getSince());
      paramQMFolder = arrayOfString;
      continue;
      str = sqlQueryStarredMailList;
      arrayOfString = new String[2];
      arrayOfString[0] = String.valueOf(i);
      arrayOfString[1] = String.valueOf(paramQMFolder.getSince());
      paramQMFolder = arrayOfString;
      continue;
      str = sqlQueryUnreadMailList;
      arrayOfString = new String[2];
      arrayOfString[0] = String.valueOf(i);
      arrayOfString[1] = String.valueOf(paramQMFolder.getSince());
      paramQMFolder = arrayOfString;
    }
  }
  
  private QMCalendarEvent getIcsEventFromCursor(Cursor paramCursor)
  {
    boolean bool2 = true;
    QMCalendarEvent localQMCalendarEvent = new QMCalendarEvent();
    localQMCalendarEvent.setId(paramCursor.getLong(paramCursor.getColumnIndex("id")));
    localQMCalendarEvent.setUid(paramCursor.getString(paramCursor.getColumnIndex("uid")));
    localQMCalendarEvent.setAccountId(paramCursor.getInt(paramCursor.getColumnIndex("accountId")));
    localQMCalendarEvent.setCalderFolderId(paramCursor.getInt(paramCursor.getColumnIndex("folderId")));
    localQMCalendarEvent.setReminder(paramCursor.getInt(paramCursor.getColumnIndex("reminder")));
    localQMCalendarEvent.setSubject(paramCursor.getString(paramCursor.getColumnIndex("subject")));
    localQMCalendarEvent.setBody(paramCursor.getString(paramCursor.getColumnIndex("body")));
    localQMCalendarEvent.setLocation(paramCursor.getString(paramCursor.getColumnIndex("location")));
    if (paramCursor.getInt(paramCursor.getColumnIndex("allday")) == 1)
    {
      bool1 = true;
      localQMCalendarEvent.setIsAllDay(bool1);
      localQMCalendarEvent.setSensivity(paramCursor.getInt(paramCursor.getColumnIndex("sensitivity")));
      localQMCalendarEvent.setTimezone(paramCursor.getString(paramCursor.getColumnIndex("timezone")));
      localQMCalendarEvent.setStartTime(paramCursor.getLong(paramCursor.getColumnIndex("startTime")));
      localQMCalendarEvent.setEndTime(paramCursor.getLong(paramCursor.getColumnIndex("endTime")));
      localQMCalendarEvent.setCreateTime(paramCursor.getLong(paramCursor.getColumnIndex("createTime")));
      localQMCalendarEvent.setModifyTime(paramCursor.getLong(paramCursor.getColumnIndex("modifyTime")));
      localQMCalendarEvent.setPath(paramCursor.getString(paramCursor.getColumnIndex("path")));
      localQMCalendarEvent.seteTag(paramCursor.getString(paramCursor.getColumnIndex("etag")));
      localQMCalendarEvent.setSvrId(paramCursor.getString(paramCursor.getColumnIndex("serverId")));
      int i = paramCursor.getInt(paramCursor.getColumnIndex("recurrenceType"));
      localQMCalendarEvent.setRecurrenceType(i);
      if (i != -1)
      {
        localQMCalendarEvent.setInterval(paramCursor.getInt(paramCursor.getColumnIndex("interval")));
        localQMCalendarEvent.setUntil(paramCursor.getLong(paramCursor.getColumnIndex("until")));
        localQMCalendarEvent.setWeekOfMonth(paramCursor.getInt(paramCursor.getColumnIndex("weekOfMonth")));
        localQMCalendarEvent.setDayOfWeek(paramCursor.getInt(paramCursor.getColumnIndex("dayOfWeek")));
        localQMCalendarEvent.setMonthOfYear(paramCursor.getInt(paramCursor.getColumnIndex("monthOfYear")));
        localQMCalendarEvent.setDayOfMonth(paramCursor.getInt(paramCursor.getColumnIndex("dayOfMonth")));
      }
      localQMCalendarEvent.setRelateType(paramCursor.getInt(paramCursor.getColumnIndex("relateType")));
      localQMCalendarEvent.setRelatedId(paramCursor.getString(paramCursor.getColumnIndex("relateId")));
      localQMCalendarEvent.setRelateAccountId(paramCursor.getInt(paramCursor.getColumnIndex("accountId")));
      localQMCalendarEvent.setOrganizerEmail(paramCursor.getString(paramCursor.getColumnIndex("organizerEmail")));
      localQMCalendarEvent.setOrganizerName(paramCursor.getString(paramCursor.getColumnIndex("organizerName")));
      localQMCalendarEvent.setResponseType(paramCursor.getInt(paramCursor.getColumnIndex("responseType")));
      localQMCalendarEvent.setMeetingStatus(paramCursor.getInt(paramCursor.getColumnIndex("meeting_status")));
      localQMCalendarEvent.setAttendees(Attendee.generateAttendees(paramCursor.getString(paramCursor.getColumnIndex("attendee"))));
      if (paramCursor.getInt(paramCursor.getColumnIndex("isDecline")) != 1) {
        break label725;
      }
    }
    label725:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localQMCalendarEvent.setIsDecline(bool1);
      return localQMCalendarEvent;
      bool1 = false;
      break;
    }
  }
  
  public static int getInt(Cursor paramCursor, String paramString)
  {
    return paramCursor.getInt(paramCursor.getColumnIndexOrThrow(paramString));
  }
  
  private Cursor getLocalSearchMails(SQLiteDatabase paramSQLiteDatabase, SearchInfo paramSearchInfo)
  {
    int i = paramSearchInfo.getSearchType();
    int j = paramSearchInfo.getArea();
    String str1 = paramSearchInfo.getKeyword();
    int k = paramSearchInfo.getAccountId();
    String str2 = generateSearchExceptLockFolderFilter(k);
    boolean bool = QMMailManager.sharedInstance().isFtsDone();
    if (i == 4) {
      if (bool)
      {
        localObject = sqlSearchMatchSubject;
        if (j != 2) {
          break label358;
        }
        paramSearchInfo = ((String)localObject).replace("$where$", " $account$ AND EXISTS (SELECT * FROM QM_FOLDER AS FD WHERE FD.id=M.folderId AND FD.type NOT IN (6,5))  AND  NOT  attr&2048  AND  NOT  attr&8192 " + str2).replace("$account$", "1=1");
      }
    }
    label540:
    for (;;)
    {
      label464:
      if (bool)
      {
        localObject = new StringBuilder("'\"");
        ((StringBuilder)localObject).append(filterMatchChar(str1) + "\"'");
        paramSearchInfo = paramSearchInfo.replace("$keyword$", ((StringBuilder)localObject).toString());
        paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(paramSearchInfo, null);
        QMLog.log(4, "QMMailSQLite", "getLocalSearchMails: " + paramSQLiteDatabase.getCount() + "," + bool + "," + i + "," + j + "," + str1 + "," + k);
        return paramSQLiteDatabase;
        localObject = sqlSearchLikeSubject;
        break;
        if (i == 1)
        {
          if (bool)
          {
            localObject = sqlSearchMatchSender;
            break;
          }
          localObject = sqlSearchLikeSender;
          break;
        }
        if (i == 2)
        {
          if (bool)
          {
            localObject = sqlSearchMatchReceiver;
            break;
          }
          localObject = sqlSearchLikeReceiver;
          break;
        }
        if (i == 3)
        {
          paramSearchInfo = (ContactsHistoryMailSearchInfo)paramSearchInfo;
          return getCertainContactMailListCursor(paramSQLiteDatabase, paramSearchInfo.getEmails(), paramSearchInfo.getAccounts());
        }
        if (bool)
        {
          localObject = sqlSearchMatchAll;
          break;
        }
        localObject = sqlSearchLikeAll;
        break;
        label358:
        if (j == 4)
        {
          paramSearchInfo = ((String)localObject).replace("$where$", " $account$ AND EXISTS (SELECT * FROM QM_FOLDER AS FD WHERE FD.id=M.folderId AND FD.type NOT IN (6,5))  AND  NOT  attr&2048  AND  NOT  attr&8192 " + str2).replace("$account$", " M.accountId=" + k);
        }
        else
        {
          str2 = ((String)localObject).replace("$where$", SEARCH_WHERE_FOLDER + str2);
          if (k == 0)
          {
            localObject = "1=1";
            str2 = str2.replace("$aid$", (CharSequence)localObject);
            if (k != 0) {
              break label540;
            }
          }
          for (localObject = "1=1";; localObject = "accountId=" + k)
          {
            paramSearchInfo = str2.replace("$folder_aid$", (CharSequence)localObject).replace("$inClause$", getInClause(paramSearchInfo.getMailIds()));
            break;
            localObject = "M.accountId=" + k;
            break label464;
          }
        }
      }
    }
    if (str1 != null) {}
    for (Object localObject = DatabaseUtils.sqlEscapeString("%" + str1 + "%");; localObject = "''")
    {
      paramSearchInfo = paramSearchInfo.replace("$keyword$", (CharSequence)localObject);
      break;
    }
  }
  
  @NonNull
  private String getLockFolderTypeByAccount(Account paramAccount)
  {
    String str2 = "";
    String str1;
    if (!paramAccount.mLockMy)
    {
      str1 = str2;
      if (!paramAccount.mLockPop) {}
    }
    else
    {
      if ((!paramAccount.mLockMy) || (!paramAccount.mLockPop)) {
        break label40;
      }
      str1 = "12,13";
    }
    label40:
    do
    {
      return str1;
      if (paramAccount.mLockMy) {
        return "12";
      }
      str1 = str2;
    } while (!paramAccount.mLockPop);
    return "13";
  }
  
  public static long getLong(Cursor paramCursor, String paramString)
  {
    return paramCursor.getLong(paramCursor.getColumnIndexOrThrow(paramString));
  }
  
  private static long getMailAttr(Mail paramMail, long paramLong)
  {
    paramMail = paramMail.getStatus();
    long l = paramLong;
    if (paramMail.needSync()) {
      l = paramLong | 0x100;
    }
    paramLong = l;
    if (paramMail.isAdMail()) {
      paramLong = l | 0x200;
    }
    l = paramLong;
    if (paramMail.isSubscribeMail()) {
      l = paramLong | 0x1000;
    }
    paramLong = l;
    if (paramMail.isAdConv()) {
      paramLong = l | 0x800;
    }
    l = paramLong;
    if (paramMail.isSubscribeConv()) {
      l = paramLong | 0x2000;
    }
    paramLong = l;
    if (paramMail.isHybirdList()) {
      paramLong = l | 0x4000;
    }
    l = paramLong;
    if (paramMail.isSystemMail()) {
      l = paramLong | 0x8000;
    }
    paramLong = l;
    if (paramMail.isCalendarMail()) {
      paramLong = l | 0x0;
    }
    l = paramLong;
    if (paramMail.isNeedCheck()) {
      l = paramLong | 0x400;
    }
    paramLong = l;
    if (paramMail.isChecked()) {
      paramLong = l | 0x10000;
    }
    l = paramLong;
    if (paramMail.isSubscribeLoaded()) {
      l = paramLong | 0x40000;
    }
    paramLong = l;
    if (paramMail.isReply()) {
      paramLong = l | 0x80000;
    }
    l = paramLong;
    if (paramMail.isForward()) {
      l = paramLong | 0x100000;
    }
    paramLong = l;
    if (paramMail.hasAttach()) {
      paramLong = l | 0x200000;
    }
    l = paramLong;
    if (paramMail.isProtocolMail()) {
      l = paramLong | 0x400000;
    }
    paramLong = l;
    if (paramMail.isGroupMail()) {
      paramLong = l | 0x800000;
    }
    l = paramLong;
    if (paramMail.isContentComplete()) {
      l = paramLong | 0x1000000;
    }
    paramLong = l;
    if (paramMail.isLocalMail()) {
      paramLong = l | 0x2000000;
    }
    l = paramLong;
    if (paramMail.isNoReferences()) {
      l = paramLong | 0x4000000;
    }
    paramLong = l;
    if (paramMail.isVip()) {
      paramLong = l | 0x20000;
    }
    l = paramLong;
    if (paramMail.isGroupOff()) {
      l = paramLong | 0x40;
    }
    paramLong = l;
    if (paramMail.isGroupAdmin()) {
      paramLong = l | 0x80;
    }
    l = paramLong;
    if (paramMail.isGroupVote()) {
      l = paramLong | 0x80000000;
    }
    paramLong = l;
    if (paramMail.isIcs()) {
      paramLong = l | 0x20;
    }
    l = paramLong;
    if (paramMail.isRecall()) {
      l = paramLong | 0x10;
    }
    paramLong = l;
    if (paramMail.isSepCpy()) {
      paramLong = l | 0x4;
    }
    l = paramLong;
    if (paramMail.hasDetectLanguageByMailContent()) {
      l = paramLong | 0x2;
    }
    paramLong = l;
    if (paramMail.isForeignLanguageSupport()) {
      paramLong = l | 0x0;
    }
    l = paramLong;
    if (paramMail.hasFixDetectLanguageResult()) {
      l = paramLong | 0x0;
    }
    paramLong = l;
    if (paramMail.isAppleIdMail()) {
      paramLong = l | 0x0;
    }
    l = paramLong;
    if (paramMail.isAttrAppleIdWecharCheck()) {
      l = paramLong | 0x0;
    }
    paramLong = l;
    if (paramMail.isAttrHasAppend()) {
      paramLong = l | 0x0;
    }
    l = paramLong;
    if (paramMail.isAttrHasDeleted()) {
      l = paramLong | 0x0;
    }
    paramLong = l;
    if (paramMail.isAttrIsCreditMail()) {
      paramLong = l | 0x0;
    }
    l = paramLong;
    if (paramMail.isAttrIsJourneyMail()) {
      l = paramLong | 0x0;
    }
    return l;
  }
  
  private ArrayList<Object> getMailContacts(SQLiteDatabase paramSQLiteDatabase, long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if (paramBoolean1) {
      localObject = "SELECT * FROM QM_REF_MAIL_ADDR WHERE mid = ? AND roleType = ?".replace("QM_REF_MAIL_ADDR", "QM_TMP_SEARCH_MAIL_ADDR");
    }
    for (;;)
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery((String)localObject, new String[] { paramLong + "", paramInt + "" });
      if (paramSQLiteDatabase != null)
      {
        if (paramSQLiteDatabase.moveToFirst()) {
          do
          {
            localObject = new MailContact();
            ((MailContact)localObject).setName(paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("addrName")));
            ((MailContact)localObject).setNick(((MailContact)localObject).getName());
            ((MailContact)localObject).setAddress(paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("address")));
            ((MailContact)localObject).setUin(paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("uin")));
            localArrayList.add(localObject);
          } while (paramSQLiteDatabase.moveToNext());
        }
        paramSQLiteDatabase.close();
      }
      return localArrayList;
      if (paramBoolean2) {
        localObject = "SELECT * FROM QM_REF_MAIL_ADDR WHERE mid = ? AND roleType = ?".replace("QM_REF_MAIL_ADDR", "QM_TMP_EML_MAIL_ADDR");
      } else {
        localObject = "SELECT * FROM QM_REF_MAIL_ADDR WHERE mid = ? AND roleType = ?";
      }
    }
  }
  
  private MailContact[] getMailContacts(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (paramBoolean1) {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE id IN $inClause$".replace("QM_MAIL_INFO", "QM_TMP_SEARCH_MAIL_INFO").replace("$inClause$", getInClause(paramArrayOfLong)), new String[0]);
    }
    while (paramSQLiteDatabase != null)
    {
      int j = paramSQLiteDatabase.getCount();
      if (j > 0)
      {
        int i = 0;
        for (;;)
        {
          if (i < j)
          {
            paramSQLiteDatabase.moveToPosition(i);
            paramArrayOfLong = paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("fromAddr"));
            String str = paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("fromAddrName"));
            if (!localArrayList2.contains(paramArrayOfLong))
            {
              MailContact localMailContact = new MailContact();
              localMailContact.setName(str);
              localMailContact.setNick(str);
              localMailContact.setAddress(paramArrayOfLong);
              localArrayList2.add(paramArrayOfLong);
              localArrayList1.add(localMailContact);
            }
            i += 1;
            continue;
            if (paramBoolean2)
            {
              paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE id IN $inClause$".replace("QM_MAIL_INFO", "QM_TMP_EML_MAIL_INFO").replace("$inClause$", getInClause(paramArrayOfLong)), new String[0]);
              break;
            }
            paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE id IN $inClause$".replace("$inClause$", getInClause(paramArrayOfLong)), new String[0]);
            break;
          }
        }
        localArrayList2.clear();
      }
      paramSQLiteDatabase.close();
    }
    return (MailContact[])localArrayList1.toArray(new MailContact[0]);
  }
  
  private int[] getMailConvHash(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong)
  {
    int k = 0;
    ArrayList localArrayList = new ArrayList();
    paramArrayOfLong = paramSQLiteDatabase.rawQuery("SELECT DISTINCT convHash FROM QM_MAIL_INFO WHERE id IN " + getInClause(paramArrayOfLong), null);
    int j;
    Integer localInteger;
    int i;
    if (paramArrayOfLong != null)
    {
      int m = paramArrayOfLong.getCount();
      j = 0;
      if (j < m)
      {
        paramArrayOfLong.moveToPosition(j);
        localInteger = Integer.valueOf(paramArrayOfLong.getInt(0));
        Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT COUNT(convHash) FROM QM_MAIL_INFO WHERE convHash=? ", new String[] { localInteger + "" });
        if (localCursor == null) {
          break label250;
        }
        if (!localCursor.moveToFirst()) {
          break label245;
        }
        i = localCursor.getInt(0);
        label146:
        localCursor.close();
      }
    }
    for (;;)
    {
      if ((i > 1) && (!localArrayList.contains(localInteger))) {
        localArrayList.add(localInteger);
      }
      j += 1;
      break;
      paramArrayOfLong.close();
      if (localArrayList.size() == 0) {
        return null;
      }
      paramSQLiteDatabase = new int[localArrayList.size()];
      i = k;
      while (i < localArrayList.size())
      {
        paramSQLiteDatabase[i] = ((Integer)localArrayList.get(i)).intValue();
        i += 1;
      }
      return paramSQLiteDatabase;
      label245:
      i = 0;
      break label146;
      label250:
      i = 0;
    }
  }
  
  private MailGroupContact getMailGroupContact(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_REF_MAIL_ADDR WHERE mid = ? AND roleType = ?", new String[] { paramLong + "", "5" });
    paramSQLiteDatabase = localObject2;
    if (localCursor != null)
    {
      paramSQLiteDatabase = localObject1;
      if (localCursor.moveToFirst())
      {
        paramSQLiteDatabase = new MailGroupContact();
        paramSQLiteDatabase.setName(localCursor.getString(localCursor.getColumnIndex("addrName")));
        paramSQLiteDatabase.setNick(paramSQLiteDatabase.getName());
        paramSQLiteDatabase.setAddress(localCursor.getString(localCursor.getColumnIndex("address")));
        paramSQLiteDatabase.setGid(localCursor.getString(localCursor.getColumnIndex("uin")));
      }
      localCursor.close();
    }
    return paramSQLiteDatabase;
  }
  
  private Object[] getMailInsertParams(int paramInt, Mail paramMail)
  {
    MailInformation localMailInformation = paramMail.getInformation();
    MailStatus localMailStatus = paramMail.getStatus();
    long l3 = localMailInformation.getId();
    Object localObject1 = localMailInformation.getTagList();
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject2;
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MailTag)((Iterator)localObject1).next();
        localStringBuilder.append(((MailTag)localObject2).getTagId());
        localStringBuilder.append(".");
        localStringBuilder.append(((MailTag)localObject2).getColor());
        localStringBuilder.append(".");
        localStringBuilder.append(((MailTag)localObject2).getName());
        localStringBuilder.append("|");
      }
    }
    long l2 = getMailAttr(paramMail, 0L);
    long l1;
    long l4;
    int i;
    String str1;
    String str2;
    int j;
    double d;
    String str3;
    String str4;
    String str5;
    String str6;
    label304:
    String str7;
    if (paramMail.getStatus().isGroupMail())
    {
      paramMail.getStatus().setGroupMail(true);
      l1 = l2 | 0x100;
      l2 = l1;
      if (paramMail.getStatus().hasAttach()) {
        l2 = l1 | 0x200000;
      }
      l4 = localMailInformation.getDate().getTime();
      localObject2 = localMailInformation.getMessageId();
      i = localMailInformation.getFolderId();
      str1 = localMailInformation.getRemoteId();
      str2 = localMailInformation.getColId();
      j = localMailInformation.getConvType();
      d = localMailInformation.getSize();
      str3 = localMailInformation.getSvrKey();
      str4 = localMailInformation.getSubject();
      str5 = localMailInformation.getAbstractContent();
      str6 = localMailInformation.getFrom().getAddress();
      if (localMailInformation.getFrom().getId() != 0L) {
        break label710;
      }
      l1 = genRMAAddrId(localMailInformation.getFrom().getAddress());
      str7 = localMailInformation.getFrom().getName();
      if (localMailInformation.getSender() != null) {
        break label723;
      }
      paramMail = null;
      label324:
      if (localMailInformation.getSender() != null) {
        break label735;
      }
    }
    label710:
    label723:
    label735:
    for (localObject1 = null;; localObject1 = localMailInformation.getSender().getName())
    {
      return new Object[] { Long.valueOf(l3), Integer.valueOf(paramInt), localObject2, Integer.valueOf(i), str1, str2, Integer.valueOf(j), Long.valueOf(l2), Double.valueOf(d), str3, str4, str5, str6, Long.valueOf(l1), str7, paramMail, localObject1, Long.valueOf(l4), Long.valueOf(l4), Long.valueOf(l4), Boolean.valueOf(localMailStatus.isUnread()), Boolean.valueOf(localMailStatus.isLoaded()), Boolean.valueOf(localMailStatus.isStarred()), localStringBuilder.toString(), localMailInformation.getReferences(), Integer.valueOf(localMailStatus.getSendStatus()), Integer.valueOf(localMailInformation.getLocalCount()), Long.valueOf(localMailInformation.getSendUtc()), localMailInformation.getMessageId(), Integer.valueOf(localMailInformation.getConvHash()), Integer.valueOf(localMailInformation.getConvReferenceHash()), Integer.valueOf(localMailInformation.getConvContactHash()), Integer.valueOf(localMailInformation.getConvCount()), Integer.valueOf(localMailInformation.getConvUrCnt()), Integer.valueOf(localMailInformation.getQQmailAdType()), Integer.valueOf(localMailStatus.getCheat()), Integer.valueOf(localMailStatus.getXQQStyle()), Long.valueOf(localMailStatus.getToppedAdTime()) };
      l1 = l2;
      if (!paramMail.getStatus().isProtocolMail()) {
        break;
      }
      l1 = l2;
      break;
      l1 = localMailInformation.getFrom().getId();
      break label304;
      paramMail = localMailInformation.getSender().getAddress();
      break label324;
    }
  }
  
  private Object[] getMailRecallInsertParams(MailRecall paramMailRecall)
  {
    return new Object[] { Long.valueOf(paramMailRecall.getId()), Long.valueOf(paramMailRecall.getMid()), paramMailRecall.getReceiver(), Integer.valueOf(paramMailRecall.getStatus()) };
  }
  
  private Object[] getMailTranslateParams(MailTranslate paramMailTranslate)
  {
    return new Object[] { Long.valueOf(paramMailTranslate.getMailId()), paramMailTranslate.getTranslateSubj(), paramMailTranslate.getTranslateContent() };
  }
  
  private String[] getMailsAddress(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {}
    for (String str = "QM_TMP_SEARCH_MAIL_INFO";; str = "QM_MAIL_INFO")
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE id IN $inClause$".replace("QM_MAIL_INFO", str).replace("$inClause$", getInClause(paramArrayOfLong)), new String[0]);
      if (paramSQLiteDatabase == null) {
        break label152;
      }
      int j = paramSQLiteDatabase.getCount();
      if (j <= 0) {
        break;
      }
      int i = 0;
      while (i < j)
      {
        paramSQLiteDatabase.moveToPosition(i);
        if (!localArrayList.contains(paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("fromAddr")))) {
          localArrayList.add(paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("fromAddr")));
        }
        i += 1;
      }
    }
    paramSQLiteDatabase.close();
    label152:
    return (String[])localArrayList.toArray(new String[0]);
  }
  
  public static ArrayList<Mail> getMailsFromCursor(Cursor paramCursor)
  {
    return getMailsFromCursor(paramCursor, 0, paramCursor.getCount());
  }
  
  public static ArrayList<Mail> getMailsFromCursor(Cursor paramCursor, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramCursor != null) && (paramCursor.moveToFirst()))
    {
      int i = paramCursor.getCount();
      paramInt1 = Math.max(0, paramInt1);
      while ((paramInt1 < i) && (paramInt1 < paramInt2))
      {
        paramCursor.moveToPosition(paramInt1);
        Mail localMail = new Mail();
        localMail.setStatus(new MailStatus());
        localMail.setInformation(new MailInformation());
        fillMail(paramCursor, localMail);
        localArrayList.add(localMail);
        paramInt1 += 1;
      }
    }
    return localArrayList;
  }
  
  private int[] getQQMailConvParentFolders(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT DISTINCT folderId FROM QM_MAIL_INFO WHERE isLoaded=1 AND convType=1 AND convHash IN$inClause$".replace("$inClause$", getInClause(paramArrayOfInt)), null);
    paramSQLiteDatabase = localObject2;
    if (localCursor != null)
    {
      int j = localCursor.getCount();
      paramSQLiteDatabase = localObject1;
      if (j > 0)
      {
        int k = localCursor.getColumnIndex("folderId");
        paramArrayOfInt = new int[j];
        int i = 0;
        for (;;)
        {
          paramSQLiteDatabase = paramArrayOfInt;
          if (i >= j) {
            break;
          }
          localCursor.moveToPosition(i);
          paramArrayOfInt[i] = localCursor.getInt(k);
          i += 1;
        }
      }
      localCursor.close();
    }
    return paramSQLiteDatabase;
  }
  
  public static String getString(Cursor paramCursor, String paramString)
  {
    return paramCursor.getString(paramCursor.getColumnIndexOrThrow(paramString));
  }
  
  private long[] getSubscribesByStat(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString)
  {
    String str = "SELECT id FROM QM_MAIL_INFO WHERE $accountId$  AND " + paramString + " AND " + " EXISTS (SELECT id,type FROM QM_FOLDER AS FD  WHERE FD.id=$alias$.folderId AND FD.type=15)".replace("$alias$", "QM_MAIL_INFO") + " AND " + " NOT  attr&8192 ";
    if (paramInt != 0) {}
    for (paramString = "accountId=" + paramInt;; paramString = "1=1")
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(str.replace("$accountId$", paramString), new String[0]);
      paramString = new long[paramSQLiteDatabase.getCount()];
      if (paramSQLiteDatabase == null) {
        return paramString;
      }
      if (!paramSQLiteDatabase.moveToFirst()) {
        break;
      }
      int i = paramSQLiteDatabase.getCount();
      paramInt = 0;
      while (paramInt < i)
      {
        paramSQLiteDatabase.moveToPosition(paramInt);
        paramString[paramInt] = paramSQLiteDatabase.getLong(0);
        paramInt += 1;
      }
    }
    paramSQLiteDatabase.close();
    return paramString;
  }
  
  private HashMap<String, QMFolder> getTagFolders(int paramInt)
  {
    Object localObject = QMFolderManager.sharedInstance().getFoldersByAccountId(paramInt);
    HashMap localHashMap = new HashMap();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      QMFolder localQMFolder = (QMFolder)((Iterator)localObject).next();
      if (localQMFolder.getType() == 14) {
        localHashMap.put(localQMFolder.getRemoteId(), localQMFolder);
      }
    }
    return localHashMap;
  }
  
  private ArrayList<Object> getTagListFromIds(HashMap<String, QMFolder> paramHashMap, String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if (paramHashMap.containsKey(str))
      {
        QMFolder localQMFolder = (QMFolder)paramHashMap.get(str);
        MailTag localMailTag = new MailTag();
        localMailTag.setName(localQMFolder.getName());
        localMailTag.setTagId(str);
        localMailTag.setColor(localQMFolder.getColorId());
        localArrayList.add(localMailTag);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private String getTagListString(ArrayList<Object> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    HashSet localHashSet = new HashSet();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject = paramArrayList.next();
        if ((localObject instanceof MailTag))
        {
          localObject = (MailTag)localObject;
          if (!localHashSet.contains(((MailTag)localObject).getTagId()))
          {
            localStringBuilder.append(((MailTag)localObject).getTagId()).append(".").append(((MailTag)localObject).getColor()).append(".").append(((MailTag)localObject).getName()).append("|");
            localHashSet.add(((MailTag)localObject).getTagId());
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  private void insertMailContact(SQLiteDatabase paramSQLiteDatabase, long paramLong, MailContact paramMailContact, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    long l;
    String str;
    if (paramMailContact != null)
    {
      i = genRMAAddrId(paramMailContact.getAddress());
      l = genRMAId(paramLong, paramInt2, paramInt1);
      if (!paramBoolean1) {
        break label113;
      }
      str = sqlInsertTmpSearchAddr;
    }
    for (;;)
    {
      paramSQLiteDatabase.execSQL(str, new Object[] { Long.valueOf(l), Long.valueOf(paramLong), Integer.valueOf(i), paramMailContact.getName(), paramMailContact.getAddress(), Integer.valueOf(paramInt1), paramMailContact.getUin(), Integer.valueOf(paramInt2) });
      return;
      label113:
      if (paramBoolean2) {
        str = sqlInsertTmpEmlAddr;
      } else if (paramInt1 == 0) {
        str = "REPLACE INTO QM_REF_MAIL_ADDR_SENDER (uid,mid,addrId,addrName,address,roleType,uin,seq) VALUES (?,?,?,?,?,?,?,?)";
      } else {
        str = "REPLACE INTO QM_REF_MAIL_ADDR (uid,mid,addrId,addrName,address,roleType,uin,seq) VALUES (?,?,?,?,?,?,?,?)";
      }
    }
  }
  
  private void insertMailContacts(SQLiteDatabase paramSQLiteDatabase, Mail paramMail, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramMail = paramMail.getInformation();
    long l = paramMail.getId();
    insertMailContact(paramSQLiteDatabase, l, paramMail.getFrom(), 1, 0, paramBoolean1, paramBoolean2);
    insertMailContact(paramSQLiteDatabase, l, paramMail.getReply(), 6, 0, paramBoolean1, paramBoolean2);
    paramMail = paramMail.getReceiverList();
    if ((paramMail != null) && (paramMail.size() > 0))
    {
      int j = 0;
      int i = 2;
      paramMail = paramMail.iterator();
      if (paramMail.hasNext())
      {
        MailContact localMailContact = (MailContact)paramMail.next();
        if (localMailContact.getMailContactType() == "to") {
          i = 2;
        }
        for (;;)
        {
          insertMailContact(paramSQLiteDatabase, l, localMailContact, i, j, paramBoolean1, paramBoolean2);
          j += 1;
          break;
          if (localMailContact.getMailContactType() == "cc") {
            i = 3;
          } else if (localMailContact.getMailContactType() == "bcc") {
            i = 4;
          } else if (localMailContact.getMailContactType() == "sender_list") {
            i = 0;
          }
        }
      }
    }
  }
  
  private Mail readMail(SQLiteDatabase paramSQLiteDatabase, Cursor paramCursor, boolean paramBoolean1, boolean paramBoolean2, ReadMailCallback paramReadMailCallback)
  {
    Mail localMail = new Mail();
    localMail.setStatus(new MailStatus());
    localMail.setInformation(new MailInformation());
    fillMail(paramCursor, localMail);
    Threads.runInBackground(new QMMailSQLite.1(this, paramSQLiteDatabase, paramBoolean1, paramBoolean2, localMail, paramReadMailCallback));
    return localMail;
  }
  
  public static Map<Integer, List<MailContact>> searchContactsFromCursor(Cursor paramCursor, long paramLong)
  {
    if (paramCursor == null) {
      return Maps.newHashMap();
    }
    int i = paramCursor.getColumnIndex("mid");
    long l;
    label48:
    Object localObject2;
    if (paramCursor.moveToFirst()) {
      try
      {
        l = paramCursor.getLong(i);
        if (l == paramLong)
        {
          HashMap localHashMap = Maps.newHashMap();
          if (l != paramLong) {
            break label282;
          }
          localObject2 = getString(paramCursor, "addrName");
          String str1 = getString(paramCursor, "address");
          Integer localInteger = Integer.valueOf(getInt(paramCursor, "roleType"));
          String str2 = getString(paramCursor, "uin");
          MailContact localMailContact = new MailContact();
          localMailContact.setAddress(str1);
          localMailContact.setName((String)localObject2);
          localMailContact.setNick((String)localObject2);
          localMailContact.setUin(str2);
          if (localHashMap.get(localInteger) == null) {
            localHashMap.put(localInteger, Lists.newArrayList(new MailContact[] { localMailContact }));
          }
          while (!paramCursor.moveToNext())
          {
            return localHashMap;
            ((List)localHashMap.get(localInteger)).add(localMailContact);
            continue;
            localObject1 = null;
          }
        }
      }
      catch (CursorIndexOutOfBoundsException localCursorIndexOutOfBoundsException)
      {
        localObject2 = new StringBuilder().append("searchContactsFromCursor failed: ").append(localCursorIndexOutOfBoundsException).append("\n  cursor count: ");
        if (!paramCursor.isClosed()) {}
      }
    }
    for (;;)
    {
      QMLog.log(6, "QMMailSQLite", localObject1);
      if (paramCursor.moveToNext()) {
        break;
      }
      return Maps.newHashMap();
      l = paramCursor.getLong(i);
      break label48;
      label282:
      return localObject1;
      Object localObject1 = Integer.valueOf(paramCursor.getCount());
    }
  }
  
  public static MailGroupContact searchGroupContactFromCursor(Cursor paramCursor, long paramLong)
  {
    if ((paramCursor != null) && (paramCursor.moveToFirst())) {
      do
      {
        if (getLong(paramCursor, "mid") == paramLong)
        {
          MailGroupContact localMailGroupContact = new MailGroupContact();
          String str = getString(paramCursor, "addrName");
          paramCursor = getString(paramCursor, "address");
          localMailGroupContact.setType(MailContact.ContactType.GroupContact);
          localMailGroupContact.setAddress(paramCursor);
          localMailGroupContact.setNick(str);
          localMailGroupContact.setName(str);
          return localMailGroupContact;
        }
      } while (paramCursor.moveToNext());
    }
    return null;
  }
  
  private void setReceiveList(SQLiteDatabase paramSQLiteDatabase, long paramLong, ArrayList<Object> paramArrayList1, ArrayList<Object> paramArrayList2, ArrayList<Object> paramArrayList3)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT mid,roleType,addrName,address FROM QM_REF_MAIL_ADDR WHERE mid=? AND roleType in (2,3,4)", new String[] { String.valueOf(paramLong) });
    if (paramSQLiteDatabase != null) {
      if (!paramSQLiteDatabase.moveToFirst()) {}
    }
    for (;;)
    {
      int i = paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("roleType"));
      String str1 = paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("address"));
      String str2 = paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("addrName"));
      MailContact localMailContact = new MailContact();
      localMailContact.setAddress(str1);
      localMailContact.setName(str2);
      switch (i)
      {
      }
      while (!paramSQLiteDatabase.moveToNext())
      {
        paramSQLiteDatabase.close();
        return;
        paramArrayList1.add(localMailContact);
        continue;
        paramArrayList2.add(localMailContact);
        continue;
        paramArrayList3.add(localMailContact);
      }
    }
  }
  
  private void updateAdvertiseConvUnread(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.beginTransactionNonExclusive();
    try
    {
      paramSQLiteDatabase.execSQL(updateAdvertiseConvUnread);
      paramSQLiteDatabase.execSQL(updateAllAdvertiseConvUnread);
      paramSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  private boolean updateAggregateConv(SQLiteDatabase paramSQLiteDatabase, int paramInt, long paramLong)
  {
    boolean bool3 = Mail.isAdConv(paramLong);
    boolean bool1;
    long l;
    label25:
    String str;
    if (paramInt == 0)
    {
      bool1 = true;
      if (!bool1) {
        break label132;
      }
      l = 0x4000 | paramLong;
      str = Mail.generateAggregateMailId(paramInt, l);
      l = Mail.generateId(paramInt, str);
      if (!bool3) {
        break label138;
      }
    }
    Object localObject1;
    Object localObject2;
    label132:
    label138:
    for (Mail localMail1 = getRecentAdvertiseMail(paramSQLiteDatabase, paramInt);; localMail1 = getRecentSubscribeMail(paramSQLiteDatabase, paramInt))
    {
      localObject1 = new StringBuilder();
      if (!bool3) {
        break label346;
      }
      localObject2 = QMMailManager.sharedInstance().getAllAdMail(paramInt).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((StringBuilder)localObject1).append(((Mail)((Iterator)localObject2).next()).getInformation().getFrom().getName()).append("，");
      }
      bool1 = false;
      break;
      l = paramLong;
      break label25;
    }
    if (((StringBuilder)localObject1).length() > 0) {
      localObject1 = ((StringBuilder)localObject1).subSequence(0, ((StringBuilder)localObject1).length() - 1).toString();
    }
    for (;;)
    {
      if (localMail1 != null)
      {
        int k = checkAggregateConvHasUnread(paramSQLiteDatabase, paramInt, paramLong);
        if (isMailExist(paramSQLiteDatabase, l, 0))
        {
          paramSQLiteDatabase.execSQL("UPDATE QM_MAIL_INFO SET subject=?, abstract=?, utcSent=?, utcReceived=?, isUnread =($countUnread$)>0  WHERE accountId=? AND attr&? ".replace("$countUnread$", String.valueOf(k)), new Object[] { localObject1, localMail1.getInformation().getAbstractContent(), Long.valueOf(localMail1.getInformation().getUtc().getTime()), Long.valueOf(localMail1.getInformation().getDate().getTime()), Integer.valueOf(paramInt), Long.valueOf(paramLong) });
          if (!bool1)
          {
            paramSQLiteDatabase = AccountManager.shareInstance().getAccountList().getAccountById(localMail1.getInformation().getAccountId());
            if ((paramSQLiteDatabase != null) && (!paramSQLiteDatabase.isQQMail()) && (!paramSQLiteDatabase.isBizMail())) {
              QMFolderManager.sharedInstance().updateLocalMailUnreadCountIntoFolder(localMail1.getInformation().getFolderId());
            }
          }
          return true;
          label346:
          if (localMail1 != null) {
            localObject1 = localMail1.getInformation().getSubject();
          }
        }
        else
        {
          localObject2 = new MailInformation();
          MailStatus localMailStatus = new MailStatus();
          Mail localMail2 = new Mail();
          ((MailInformation)localObject2).setSubject((String)localObject1);
          ((MailInformation)localObject2).setAbstractContent(localMail1.getInformation().getAbstractContent());
          ((MailInformation)localObject2).setUtc(localMail1.getInformation().getUtc());
          ((MailInformation)localObject2).setDate(localMail1.getInformation().getDate());
          localObject1 = new MailContact();
          int i;
          Object localObject3;
          label534:
          label565:
          label600:
          boolean bool2;
          if (bool3)
          {
            int j = 0;
            i = j;
            if (paramInt != 0)
            {
              localObject3 = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
              i = j;
              if (localObject3 != null)
              {
                i = j;
                if (((Account)localObject3).getEmail() != null)
                {
                  i = j;
                  if (((Account)localObject3).getEmail().toLowerCase().endsWith("@tencent.com")) {
                    i = 1;
                  }
                }
              }
            }
            localObject3 = QMApplicationContext.sharedInstance();
            if (i != 0)
            {
              i = 2131693931;
              localObject3 = ((QMApplicationContext)localObject3).getString(i);
              ((MailContact)localObject1).setName((String)localObject3);
              ((MailContact)localObject1).setNick((String)localObject3);
              ((MailContact)localObject1).setAddress("mail@qq.com");
              ((MailInformation)localObject2).setFrom((MailContact)localObject1);
              ((MailInformation)localObject2).setRemoteId(str);
              ((MailInformation)localObject2).setAccountId(paramInt);
              ((MailInformation)localObject2).setId(l);
              if (!bool1) {
                break label767;
              }
              i = 0;
              ((MailInformation)localObject2).setFolderId(i);
              ((MailInformation)localObject2).setConvHash(Mail.generateConvQQTidHash(paramInt, str));
              if (k <= 0) {
                break label779;
              }
              bool2 = true;
              label626:
              localMailStatus.setUnread(bool2);
              localMailStatus.setStarred(false);
              localMailStatus.setProtocolMail(false);
              localMailStatus.setHasAttach(false);
              localMailStatus.setNeedSync(false);
              localMailStatus.setLocalMail(true);
              if (k <= 0) {
                break label785;
              }
              bool2 = true;
              label671:
              localMailStatus.setUnread(bool2);
              if (!bool3) {
                break label791;
              }
              localMailStatus.setAdConv(true);
            }
          }
          for (;;)
          {
            localMailStatus.setHybirdList(bool1);
            localMail2.setInformation((MailInformation)localObject2);
            localMail2.setStatus(localMailStatus);
            insertMailInfo(paramSQLiteDatabase, paramInt, localMail2, 0);
            break;
            i = 2131693930;
            break label534;
            localObject3 = QMApplicationContext.sharedInstance().getString(2131693932);
            ((MailContact)localObject1).setName((String)localObject3);
            ((MailContact)localObject1).setNick((String)localObject3);
            ((MailContact)localObject1).setAddress("mail@qq.com");
            break label565;
            label767:
            i = QMFolderManager.sharedInstance().getInboxFolderId(paramInt);
            break label600;
            label779:
            bool2 = false;
            break label626;
            label785:
            bool2 = false;
            break label671;
            label791:
            localMailStatus.setSubscribeConv(true);
          }
        }
      }
      else
      {
        return false;
      }
      localObject1 = "";
    }
  }
  
  private void updateConvMailParentStar(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong)
  {
    String[] arrayOfString = new String[paramArrayOfLong.length];
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      arrayOfString[i] = String.valueOf(paramArrayOfLong[i]);
      i += 1;
    }
    paramArrayOfLong = sqlUpdateConvMailStar.replace("$inClause$", getInClause(paramArrayOfLong.length));
    paramSQLiteDatabase.execSQL(paramArrayOfLong, arrayOfString);
    paramSQLiteDatabase.execSQL(paramArrayOfLong.replace("QM_MAIL_INFO", "QM_TMP_SEARCH_MAIL_INFO"), arrayOfString);
  }
  
  private void updateConvMailParentUnread(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong)
  {
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length <= 0)) {
      return;
    }
    String[] arrayOfString = new String[paramArrayOfLong.length];
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      arrayOfString[i] = String.valueOf(paramArrayOfLong[i]);
      i += 1;
    }
    paramSQLiteDatabase.execSQL(sqlUpdateConvMailUnread.replace("$inClause$", getInClause(paramArrayOfLong.length)), arrayOfString);
  }
  
  private void updateConvMailStatus(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong, ContentValues paramContentValues)
  {
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length <= 0)) {
      return;
    }
    String[] arrayOfString = new String[paramArrayOfLong.length];
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      arrayOfString[i] = String.valueOf(paramArrayOfLong[i]);
      i += 1;
    }
    paramSQLiteDatabase.update("QM_MAIL_INFO", paramContentValues, "id IN (SELECT id FROM QM_MAIL_INFO INNER JOIN(SELECT accountId AS aid,folderId AS fid,convHash AS ch,convType AS ct,id AS cid FROM QM_MAIL_INFO WHERE id IN $inClause$)ON (folderId=fid AND convHash=ch and ct=1) OR (ct IN (0,-1) AND id=cid))".replace("$inClause$", getInClause(paramArrayOfLong.length)), arrayOfString);
  }
  
  private boolean updateMailTags(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong, String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("tags", paramString);
    paramString = new String[paramArrayOfLong.length];
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      paramString[i] = (paramArrayOfLong[i] + "");
      i += 1;
    }
    try
    {
      paramSQLiteDatabase.update("QM_MAIL_INFO", localContentValues, "id in " + getInClause(paramString.length), paramString);
      paramSQLiteDatabase.update("QM_TMP_SEARCH_MAIL_INFO", localContentValues, "id in " + getInClause(paramString.length), paramString);
      return true;
    }
    catch (Exception paramSQLiteDatabase) {}
    return false;
  }
  
  private void updateParentCounts(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt)
  {
    String str = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT DISTINCT id FROM QM_MAIL_INFO WHERE convHash IN $inClause$ AND convType = 1".replace("$inClause$", getInClause(paramArrayOfInt)), null);
    paramArrayOfInt = str;
    if (localCursor != null)
    {
      paramArrayOfInt = new long[localCursor.getCount()];
      if (localCursor.moveToFirst())
      {
        j = localCursor.getColumnIndex("id");
        i = 0;
        do
        {
          paramArrayOfInt[i] = localCursor.getLong(j);
          i += 1;
        } while (localCursor.moveToNext());
      }
      localCursor.close();
    }
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      str = String.valueOf(paramArrayOfInt[i]);
      paramSQLiteDatabase.execSQL(sqlUpdateQQMailConvParentCount, new String[] { str, str });
      i += 1;
    }
  }
  
  private void updateQQConvMails(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2, long[] paramArrayOfLong, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      return;
    }
    String str1 = getInClause(paramArrayOfLong);
    String str2 = getInClause(paramArrayOfInt);
    if ((paramInt2 != 0) && (paramInt1 != 0))
    {
      int[] arrayOfInt = QMFolderManager.sharedInstance().getNoConvFolderIds(paramInt1);
      paramSQLiteDatabase.execSQL(sqlUpdateQQMailConvChildType.replace("$inClauseFolders$", getInClause(arrayOfInt)).replace("$inClauseHash$", str2), new String[] { String.valueOf(paramInt2) });
    }
    paramSQLiteDatabase.delete("QM_MAIL_INFO", "id IN (" + "SELECT id FROM QM_MAIL_INFO INNER JOIN(SELECT folderId AS fid,convHash AS ch FROM QM_MAIL_INFO WHERE convType=1 AND convHash IN$inClause$) ON folderId=fid AND convHash=ch AND convType=1 AND isLoaded=1 AND NOT EXISTS(SELECT * FROM QM_MAIL_INFO WHERE convType=-1 AND convHash=ch AND folderId=fid)".replace("$inClause$", str2) + ")", null);
    paramSQLiteDatabase.execSQL("UPDATE QM_MAIL_INFO SET utcSent=utcSent+1000  WHERE id IN$inClause$ AND convType=1".replace("$inClause$", str1));
    updateParentCounts(paramSQLiteDatabase, paramArrayOfInt);
    updateConvMailStatus(paramSQLiteDatabase, paramArrayOfLong);
  }
  
  private void updateTempSearchMail(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong, ContentValues paramContentValues)
  {
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length <= 0)) {
      return;
    }
    String[] arrayOfString = new String[paramArrayOfLong.length];
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      arrayOfString[i] = String.valueOf(paramArrayOfLong[i]);
      i += 1;
    }
    paramSQLiteDatabase.update("QM_TMP_SEARCH_MAIL_INFO", paramContentValues, "id IN " + getInClause(paramArrayOfLong.length), arrayOfString);
  }
  
  public boolean canFolderLoadMore(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    boolean bool3 = true;
    boolean bool1 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool2 = bool4;
    label115:
    for (;;)
    {
      try
      {
        paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT (SELECT COUNT(DISTINCT M.id) FROM QM_MAIL_INFO AS M WHERE M.folderId IN$queryInClause$ AND M.attr&256 AND M.attr&549755813888=0 AND M.utcSent>=(SELECT F.since FROM QM_FOLDER AS F WHERE F.id = M.folderId))<(SELECT SUM(svrCount) FROM QM_FOLDER WHERE id IN$inClause$)".replace("$queryInClause$", getInClause(paramArrayOfInt1)).replace("$inClause$", getInClause(paramArrayOfInt2)), null);
        if (paramSQLiteDatabase != null)
        {
          bool1 = bool5;
          bool2 = bool4;
          if (paramSQLiteDatabase.moveToFirst())
          {
            bool2 = bool4;
            if (paramSQLiteDatabase.getInt(0) == 1)
            {
              bool1 = bool3;
              break label115;
            }
          }
          else
          {
            bool2 = bool1;
            paramSQLiteDatabase.close();
          }
        }
        else
        {
          return bool1;
        }
        bool1 = false;
      }
      catch (Exception paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
        return bool2;
      }
    }
  }
  
  public boolean canStarredLoadMore(SQLiteDatabase paramSQLiteDatabase, QMFolder paramQMFolder)
  {
    boolean bool = true;
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(sqlQueryStarredCanLoadMore, new String[] { String.valueOf(paramQMFolder.getAccountId()), String.valueOf(paramQMFolder.getSince()) });
    if (paramSQLiteDatabase != null)
    {
      int i;
      if (paramSQLiteDatabase.moveToFirst())
      {
        i = paramSQLiteDatabase.getInt(0);
        if (paramQMFolder != null) {
          if ((AccountManager.shareInstance().getAccountList().isAccountLocked(paramQMFolder.getAccountId())) && (paramQMFolder.getPersonalCount() > 0)) {
            if (i >= paramQMFolder.getSvrCount() - paramQMFolder.getPersonalCount()) {}
          }
        }
      }
      for (;;)
      {
        paramSQLiteDatabase.close();
        return bool;
        bool = false;
        continue;
        if (i >= paramQMFolder.getSvrCount())
        {
          bool = false;
          continue;
          bool = false;
        }
      }
    }
    return false;
  }
  
  public boolean canTagLoadMore(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    boolean bool = true;
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT COUNT(*) FROM (SELECT T.tagId, M.id, M.accountId FROM QM_REF_MAIL_TAG AS T INNER JOIN QM_MAIL_INFO AS M  ON M.attr&256 AND M.id=T.mid) AS T  INNER JOIN QM_FOLDER AS FR  ON FR.id=? AND FR.remoteId=T.tagId AND FR.accountId=T.accountId", new String[] { String.valueOf(paramInt) });
    if (paramSQLiteDatabase != null)
    {
      int i;
      QMFolder localQMFolder;
      if (paramSQLiteDatabase.moveToFirst())
      {
        i = paramSQLiteDatabase.getInt(0);
        localQMFolder = QMFolderManager.sharedInstance().getFolder(paramInt);
        if (localQMFolder != null) {
          if ((AccountManager.shareInstance().getAccountList().isAccountLocked(localQMFolder.getAccountId())) && (localQMFolder.getPersonalCount() > 0)) {
            if (i >= localQMFolder.getSvrCount() - localQMFolder.getPersonalCount()) {}
          }
        }
      }
      for (;;)
      {
        paramSQLiteDatabase.close();
        return bool;
        bool = false;
        continue;
        if (i >= localQMFolder.getSvrCount())
        {
          bool = false;
          continue;
          bool = false;
        }
      }
    }
    return false;
  }
  
  public void cleanRemoteSearchMails(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.delete("QM_TMP_SEARCH_MAIL_INFO", "", new String[0]);
    paramSQLiteDatabase.delete("QM_TMP_SEARCH_MAIL_UTC", "", new String[0]);
    paramSQLiteDatabase.delete("QM_TMP_SEARCH_MAIL_ADDR", "", new String[0]);
  }
  
  public void clearMailContent(SQLiteDatabase paramSQLiteDatabase)
  {
    QMLog.log(4, "QMMailSQLite", "delete all mail content.");
    paramSQLiteDatabase.execSQL("delete from QM_MAIL_CONTENT where id not in (select M_TEMP.id from QM_MAIL_INFO as M_TEMP where M_TEMP.attr&33554432)");
    paramSQLiteDatabase.execSQL("update QM_MAIL_INFO set isLoaded = 0 where id not in (select M_TEMP.id from QM_MAIL_INFO as M_TEMP where M_TEMP.attr&33554432)");
    paramSQLiteDatabase.execSQL("update QM_MAIL_INFO set attr=attr&(~2)&(~4294967296)&(~8589934592) where id in (select id from QM_MAIL_INFO)");
    paramSQLiteDatabase.delete("QM_MAIL_CONTENT_SCALE", "", null);
  }
  
  public void clearMailTranslateContent(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DELETE FROM QM_MAIL_TRANSLATE_CONTENT");
  }
  
  public SparseArray<int[]> countMailByAccountInFolder(SQLiteDatabase paramSQLiteDatabase, int paramInt, int[] paramArrayOfInt)
  {
    Object localObject = AccountManager.shareInstance().getAccountList();
    int i;
    if ((((AccountList)localObject).size() == 1) && (((AccountList)localObject).get(0).isQQMail()))
    {
      i = 1;
      localObject = sqlQueryCntByAccountInFolder;
      if (i == 0) {
        break label164;
      }
      localObject = sqlQueryCntByAccountInAllFolder;
    }
    label164:
    for (;;)
    {
      SparseArray localSparseArray = new SparseArray();
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(((String)localObject).replace("$inClause$", getInClause(paramArrayOfInt)), new String[] { String.valueOf(paramInt) });
      if (paramSQLiteDatabase != null)
      {
        if (paramSQLiteDatabase.moveToFirst()) {
          do
          {
            paramArrayOfInt = new int[3];
            paramArrayOfInt[0] = paramSQLiteDatabase.getInt(0);
            paramArrayOfInt[1] = paramSQLiteDatabase.getInt(1);
            paramArrayOfInt[2] = paramSQLiteDatabase.getInt(2);
            localSparseArray.put(paramArrayOfInt[0], paramArrayOfInt);
          } while (paramSQLiteDatabase.moveToNext());
        }
        paramSQLiteDatabase.close();
      }
      return localSparseArray;
      i = 0;
      break;
    }
  }
  
  /* Error */
  public int countUnreadAdMails(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: getstatic 1507	com/tencent/qqmail/model/mail/QMMailSQLite:sqlCountUnreadAdMail	Ljava/lang/String;
    //   3: astore 4
    //   5: aload_2
    //   6: ifnull +90 -> 96
    //   9: aload_2
    //   10: iconst_0
    //   11: iaload
    //   12: ifeq +84 -> 96
    //   15: new 849	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 852	java/lang/StringBuilder:<init>	()V
    //   22: ldc_w 3283
    //   25: invokevirtual 858	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_2
    //   29: invokestatic 971	com/tencent/qqmail/model/mail/QMMailSQLite:getInClause	([I)Ljava/lang/String;
    //   32: invokevirtual 858	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 872	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: astore_2
    //   39: aload 4
    //   41: ldc_w 1146
    //   44: aload_2
    //   45: invokevirtual 833	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   48: astore 4
    //   50: aconst_null
    //   51: astore_2
    //   52: aload_1
    //   53: aload 4
    //   55: iconst_0
    //   56: anewarray 829	java/lang/String
    //   59: invokevirtual 1564	com/tencent/moai/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   62: astore_1
    //   63: aload_1
    //   64: ifnull +87 -> 151
    //   67: aload_1
    //   68: invokeinterface 1570 1 0
    //   73: ifeq +78 -> 151
    //   76: aload_1
    //   77: iconst_0
    //   78: invokeinterface 1574 2 0
    //   83: istore_3
    //   84: aload_1
    //   85: ifnull +9 -> 94
    //   88: aload_1
    //   89: invokeinterface 1577 1 0
    //   94: iload_3
    //   95: ireturn
    //   96: ldc_w 1517
    //   99: astore_2
    //   100: goto -61 -> 39
    //   103: astore_1
    //   104: aload_2
    //   105: astore_1
    //   106: aload_1
    //   107: ifnull +42 -> 149
    //   110: aload_1
    //   111: invokeinterface 1577 1 0
    //   116: iconst_0
    //   117: ireturn
    //   118: astore_1
    //   119: aconst_null
    //   120: astore 4
    //   122: aload_1
    //   123: astore_2
    //   124: aload 4
    //   126: ifnull +10 -> 136
    //   129: aload 4
    //   131: invokeinterface 1577 1 0
    //   136: aload_2
    //   137: athrow
    //   138: astore_2
    //   139: aload_1
    //   140: astore 4
    //   142: goto -18 -> 124
    //   145: astore_2
    //   146: goto -40 -> 106
    //   149: iconst_0
    //   150: ireturn
    //   151: iconst_0
    //   152: istore_3
    //   153: goto -69 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	QMMailSQLite
    //   0	156	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	156	2	paramArrayOfInt	int[]
    //   83	70	3	i	int
    //   3	138	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   52	63	103	java/lang/Exception
    //   52	63	118	finally
    //   67	84	138	finally
    //   67	84	145	java/lang/Exception
  }
  
  public void createIndex(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS INDEX_MAIL_INFO ON QM_MAIL_INFO(convHash,convType,fromAddrId,folderId,accountId,attr)");
    paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS INDEX_MAIL_CONTENT ON QM_MAIL_CONTENT(id)");
    paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS INDEX_REL_MAIL_ADDR ON QM_REF_MAIL_ADDR(mid,roleType,addrId)");
    paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS INDEX_REL_MAIL_RECALL ON QM_REF_MAIL_RECALL(mid,receiver,status)");
    paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS INDEX_MAIL_INFO_FOLDER_ID ON QM_MAIL_INFO(folderId,fromAddrId,convType,attr)");
    paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS INDEX_MAIL_INFO_CONV ON QM_MAIL_INFO(folderId,convHash,convType)");
    paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS INDEX_REL_MAIL_ADDR_SENDER ON QM_REF_MAIL_ADDR_SENDER(addrId,roleType,mid)");
  }
  
  public void createTable(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_MAIL_INFO(id integer primary key, accountId integer, folderId integer, remoteId varchar, colid integer, messageId varchar, svrKey varchar, subject varchar, abstract varchar, fromAddr varchar, fromAddrId integer, fromAddrName varchar, senderAddr varchar, senderAddrName varchar, utcSent integer, utcReceived integer, utcRecentOpr integer, isUnread integer, isStar integer, isLoaded integer, isTopped integer, attr integer, size integer, tags varchar, reference varchar, sendStatus integer, localCount integer, sendutc integer, convType integer, convHash integer, convRefHash integer, convContactHash integer, convCnt integer, convUrCnt integer, qqAdType integer, qqSpamType integer, xqqstyle integer, toppedAdTime integer default -1) ");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_MAIL_PART_INFO(id integer primary key, mid integer,itemId integer,itemType varchar, bodyId varchar, contentType varchar, contentSubType varchar, contentTypeParams varchar, contentTransferEncoding varchar, contentLineSize varchar) ");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_MAIL_CONTENT(id integer primary key, content varchar, extra varchar) ");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_MAIL_CONTENT_SCALE(id integer primary key, mailId integer, type integer, content varchar) ");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_REF_MAIL_ADDR (uid integer primary key, mid integer, addrId integer, roleType integer, addrName varchar, address varchar, uin varchar,seq integer default 0)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_REF_MAIL_ADDR_SENDER (uid integer primary key, mid integer, addrId integer, roleType integer, addrName varchar, address varchar, uin varchar,seq integer default 0)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_REF_MAIL_RECALL (id integer primary key, mid integer, receiver varchar, status integer )");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_REF_MAIL_TAG(uid integer primary key, mid integer, tagId varchar )");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_MAIL_SUBSCRIBE (id integer primary key, mid integer, remoteId varchar, colid integer, accountId integer, idx integer, abstract varchar, subject varchar, fromName varchar, fromAddr varchar, link varchar,bigIcon varchar, icon varchar,utcReceived integer )");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_RULE_AD (ruleAddrId integer, ruleAccId integer, ruleType integer, UNIQUE(ruleAddrId,ruleAccId))");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_RULE_MAIL (ruleId integer primary key, accountId integer, fieldName integer, operator integer, val varchar, val2 varchar, action integer, param varchar, alias varchar )");
    paramSQLiteDatabase.execSQL(sqlCreateTmpSearch);
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_TMP_SEARCH_MAIL_UTC (searchType integer, mailId integer, utcSearch integer,  primary key (searchType,mailId))");
    paramSQLiteDatabase.execSQL(sqlCreateTmpSearchAddr);
    paramSQLiteDatabase.execSQL(sqlCreateTmpEml);
    paramSQLiteDatabase.execSQL(sqlCreateTmpEmlAddr);
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_ICS_EVENT(id integer primary key, accountId integer, folderId integer, uid varchar, reminder integer, subject varchar, location varchar, body varchar, bodyType integer, allday integer, sensitivity integer, timezone varchar, startTime integer, endTime integer, createTime integer, modifyTime integer, path varchar, etag varchar, serverId varchar, folderType integer, recurrenceType integer, calendarType integer, interval integer, until integer, weekOfMonth integer, dayOfWeek integer, monthOfYear integer, dayOfMonth integer, isLeapMonth integer, firstDayOfWeek integer, relateId varchar, relateType integer, organizerName varchar, organizerEmail varchar,responseType integer, meeting_status integer, attendee varchar,isDecline integer,mailId varchar ) ");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_MAIL_TRANSLATE_CONTENT(id integer primary key, translate_subj varchar, translate_content varchar) ");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_MAIL_AGGREGATE(id varchar primary key, value integer)");
    paramSQLiteDatabase.execSQL("CREATE VIRTUAL TABLE IF NOT EXISTS QM_MAIL_INFO_FTS_SEARCH USING FTS4(sender varchar, receiver varchar, subject varchar, abs varchar, attachName varchar, tokenize=single)");
    paramSQLiteDatabase.execSQL("CREATE VIRTUAL TABLE IF NOT EXISTS QM_MAIL_CONTENT_FTS_SEARCH USING FTS4(CONTENT=QM_MAIL_CONTENT,content varchar, tokenize=single)");
    QMLog.log(4, "QMMailSQLite", "createTable");
  }
  
  public boolean deleteAdvertiseConv(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    return deleteAggregateConv(paramSQLiteDatabase, paramInt, 2048L);
  }
  
  public void deleteAllFts(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("delete from QM_MAIL_INFO_FTS_SEARCH");
    paramSQLiteDatabase.execSQL("delete from QM_MAIL_CONTENT_FTS_SEARCH");
  }
  
  public void deleteAllMailRefContacts(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = (paramLong + "");
    paramSQLiteDatabase.delete("QM_REF_MAIL_ADDR", "mid = ?", arrayOfString);
    paramSQLiteDatabase.delete("QM_REF_MAIL_ADDR_SENDER", "mid = ?", arrayOfString);
  }
  
  public void deleteMailFts(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong)
  {
    paramArrayOfLong = getInClause(paramArrayOfLong);
    paramSQLiteDatabase.delete("QM_MAIL_INFO_FTS_SEARCH", "docid IN " + paramArrayOfLong, null);
    paramSQLiteDatabase.delete("QM_MAIL_CONTENT_FTS_SEARCH", "docid IN " + paramArrayOfLong, null);
  }
  
  public void deleteMailSubscribe(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    paramSQLiteDatabase.delete("QM_MAIL_SUBSCRIBE", "accountId=?", new String[] { paramInt + "" });
  }
  
  public void deleteMailTranslateContentById(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    paramSQLiteDatabase.execSQL("DELETE FROM QM_MAIL_TRANSLATE_CONTENT WHERE id = ?", new String[] { paramLong + "" });
  }
  
  public void deleteMails(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    int i = 0;
    paramSQLiteDatabase.beginTransactionNonExclusive();
    try
    {
      Object localObject2 = paramSQLiteDatabase.rawQuery("SELECT id FROM QM_MAIL_INFO WHERE accountId = ? ", new String[] { paramInt + "" });
      if (localObject2 != null)
      {
        long[] arrayOfLong = new long[((Cursor)localObject2).getCount()];
        if (((Cursor)localObject2).moveToFirst())
        {
          int j = ((Cursor)localObject2).getColumnIndex("id");
          do
          {
            arrayOfLong[i] = ((Cursor)localObject2).getLong(j);
            i += 1;
          } while (((Cursor)localObject2).moveToNext());
        }
        ((Cursor)localObject2).close();
        paramSQLiteDatabase.delete("QM_MAIL_INFO", "accountId =? ", new String[] { paramInt + "" });
        localObject2 = getInClause(arrayOfLong);
        paramSQLiteDatabase.delete("QM_MAIL_CONTENT", "id in " + (String)localObject2, new String[0]);
        paramSQLiteDatabase.delete("QM_REF_MAIL_ADDR", "mid in " + (String)localObject2, new String[0]);
        paramSQLiteDatabase.delete("QM_REF_MAIL_RECALL", "mid in " + (String)localObject2, new String[0]);
        paramSQLiteDatabase.delete("QM_REF_MAIL_TAG", "mid in " + (String)localObject2, new String[0]);
        paramSQLiteDatabase.delete("QM_MAIL_PART_INFO", "mid in " + (String)localObject2, new String[0]);
        paramSQLiteDatabase.delete("QM_ICS_EVENT", "accountId =? ", new String[] { paramInt + "" });
        deleteMailFts(paramSQLiteDatabase, arrayOfLong);
      }
      deleteMailSubscribe(paramSQLiteDatabase, paramInt);
      paramSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "QMMailSQLite", "deleteMails by Id failed. " + localException.toString());
      return;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  public void deleteMails(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong)
  {
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
    {
      String str = getInClause(paramArrayOfLong);
      paramSQLiteDatabase.delete("QM_MAIL_INFO", "id IN " + str, null);
      paramSQLiteDatabase.delete("QM_MAIL_CONTENT", "id IN " + str, null);
      paramSQLiteDatabase.delete("QM_MAIL_CONTENT_SCALE", "id IN " + str, null);
      paramSQLiteDatabase.delete("QM_MAIL_PART_INFO", "mid IN " + str, null);
      paramSQLiteDatabase.delete("QM_REF_MAIL_ADDR", "mid IN " + str, null);
      paramSQLiteDatabase.delete("QM_REF_MAIL_ADDR_SENDER", "mid IN " + str, null);
      paramSQLiteDatabase.delete("QM_REF_MAIL_RECALL", "mid IN " + str, null);
      paramSQLiteDatabase.delete("QM_REF_MAIL_TAG", "mid IN " + str, null);
      paramSQLiteDatabase.delete("QM_MAIL_ATTACH", "mailid IN " + str, null);
      paramSQLiteDatabase.delete("QM_FTN_ATTACH", "mailid IN " + str, null);
      paramSQLiteDatabase.delete("QM_EDIT_ATTACH", "mailid IN " + str, null);
      deleteMailFts(paramSQLiteDatabase, paramArrayOfLong);
      paramSQLiteDatabase.delete("QM_OFF_LINE_OPER", "id IN " + str, null);
      paramSQLiteDatabase.delete("QM_OFF_LINE_OPER_INFO", "id IN " + str, null);
      updateQQConvMails(paramSQLiteDatabase, 0, 0, paramArrayOfLong, getMailConvHash(paramSQLiteDatabase, paramArrayOfLong));
    }
  }
  
  public void deleteMailsByFolderIds(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt)
  {
    paramArrayOfInt = paramSQLiteDatabase.rawQuery("SELECT DISTINCT id FROM QM_MAIL_INFO WHERE id IN " + getInClause(paramArrayOfInt), null);
    if (paramArrayOfInt != null)
    {
      long[] arrayOfLong = new long[paramArrayOfInt.getCount()];
      if (arrayOfLong.length > 0)
      {
        int j = paramArrayOfInt.getCount();
        int i = 0;
        while (i < j)
        {
          paramArrayOfInt.moveToPosition(i);
          arrayOfLong[i] = paramArrayOfInt.getLong(0);
          i += 1;
        }
      }
      paramArrayOfInt.close();
      deleteMails(paramSQLiteDatabase, arrayOfLong);
    }
  }
  
  public void deleteMailsWithConv(SQLiteDatabase paramSQLiteDatabase, int paramInt, long[] paramArrayOfLong)
  {
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length == 0)) {
      return;
    }
    int[] arrayOfInt = getMailConvHash(paramSQLiteDatabase, paramArrayOfLong);
    deleteMails(paramSQLiteDatabase, paramArrayOfLong);
    rebuildConvParents(paramSQLiteDatabase, paramInt, arrayOfInt);
  }
  
  public boolean deleteRecordConv(SQLiteDatabase paramSQLiteDatabase)
  {
    return deleteAggregateConv(paramSQLiteDatabase, 0, 8L);
  }
  
  public boolean deleteSubscribeConv(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    QMAggrConvMailCache.sharedInstance().dropIndex(paramInt);
    return deleteAggregateConv(paramSQLiteDatabase, paramInt, 8192L);
  }
  
  public void deleteSubscribes(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong)
  {
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
    {
      paramArrayOfLong = getInClause(paramArrayOfLong);
      paramSQLiteDatabase.delete("QM_MAIL_SUBSCRIBE", "mid IN " + paramArrayOfLong, null);
    }
  }
  
  public void dropIndex(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS INDEX_MAIL_INFO");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS INDEX_MAIL_CONTENT");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS INDEX_MAIL_INFO_FOLDER_ID");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS INDEX_MAIL_INFO_CONV");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS INDEX_REL_MAIL_ADDR_SENDER");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS INDEX_REL_MAIL_ADDR");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS INDEX_REL_MAIL_RECALL");
  }
  
  public void dropTable(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_MAIL_INFO");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_MAIL_PART_INFO");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_MAIL_CONTENT");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_MAIL_CONTENT_SCALE");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_REF_MAIL_ADDR");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_REF_MAIL_ADDR_SENDER");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_REF_MAIL_RECALL");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_REF_MAIL_TAG");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_MAIL_SUBSCRIBE");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_RULE_AD");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_RULE_MAIL");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_TMP_SEARCH_MAIL_INFO");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_TMP_SEARCH_MAIL_UTC");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_TMP_SEARCH_MAIL_ADDR");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_TMP_EML_MAIL_INFO");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_TMP_EML_MAIL_ADDR");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_ICS_EVENT");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_MAIL_TRANSLATE_CONTENT");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_MAIL_AGGREGATE");
    QMLog.log(4, "QMMailSQLite", "dropTable");
  }
  
  public void fillMailContacts(SQLiteDatabase paramSQLiteDatabase, Mail paramMail, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = paramMail.getInformation().getId();
    paramMail.getInformation().setToList(getMailContacts(paramSQLiteDatabase, l, 2, paramBoolean1, paramBoolean2));
    paramMail.getInformation().setCcList(getMailContacts(paramSQLiteDatabase, l, 3, paramBoolean1, paramBoolean2));
    paramMail.getInformation().setBccList(getMailContacts(paramSQLiteDatabase, l, 4, paramBoolean1, paramBoolean2));
    ArrayList localArrayList = getMailContacts(paramSQLiteDatabase, l, 6, paramBoolean1, paramBoolean2);
    if (localArrayList.size() > 0) {
      paramMail.getInformation().setReply((MailContact)localArrayList.get(0));
    }
    if (paramMail.getStatus().isGroupMail())
    {
      paramSQLiteDatabase = getMailGroupContact(paramSQLiteDatabase, l);
      if (paramSQLiteDatabase != null)
      {
        paramMail.getInformation().setGroupContact(paramSQLiteDatabase);
        paramMail.getInformation().setGroupId(paramSQLiteDatabase.getGid());
      }
    }
  }
  
  public void fillMailCotent(SQLiteDatabase paramSQLiteDatabase, Mail paramMail)
  {
    paramMail.setContent(readMailContent(paramSQLiteDatabase, paramMail.getInformation().getId()));
  }
  
  public long[] getAdMailByReadStat(SQLiteDatabase paramSQLiteDatabase, int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("isUnread");
    if (paramBoolean) {}
    for (String str = "=1 ";; str = "=0 ") {
      return getAdMailByStat(paramSQLiteDatabase, paramInt, str);
    }
  }
  
  public long[] getAdMailByStarStat(SQLiteDatabase paramSQLiteDatabase, int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("isStar");
    if (paramBoolean) {}
    for (String str = "=1 ";; str = "=0 ") {
      return getAdMailByStat(paramSQLiteDatabase, paramInt, str);
    }
  }
  
  public Cursor getAdvertiseMailList(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    return getAdvertiseMailList(paramSQLiteDatabase, paramInt, false);
  }
  
  public Cursor getAdvertiseMailList(SQLiteDatabase paramSQLiteDatabase, int paramInt, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    if (paramBoolean)
    {
      str = queryAdvertiseMailListExpandConv;
      localObject = str + " ORDER BY utcSent+CASE WHEN(isUnread AND toppedAdTime>strftime('%s','now')) THEN 1000000000 ELSE 0 END DESC ";
      if (paramInt == 0) {
        break label126;
      }
      str = "M.accountId=" + paramInt;
      label61:
      localObject = ((String)localObject).replace("$aid$", str);
      if (paramInt == 0) {
        break label134;
      }
    }
    label134:
    for (String str = "accountId=" + paramInt;; str = "1=1")
    {
      return paramSQLiteDatabase.rawQuery(((String)localObject).replace("$folder_aid$", str), new String[0]);
      str = queryAdvertiseMailList;
      break;
      label126:
      str = "1=1";
      break label61;
    }
  }
  
  public ArrayList<Long> getAdvertiseMailListIds(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    return getAdvertiseMailListIds(paramSQLiteDatabase, paramInt, false);
  }
  
  public ArrayList<Long> getAdvertiseMailListIds(SQLiteDatabase paramSQLiteDatabase, int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    ArrayList localArrayList = null;
    Cursor localCursor = getAdvertiseMailList(paramSQLiteDatabase, paramInt, paramBoolean);
    paramSQLiteDatabase = localObject;
    if (localCursor != null)
    {
      int i = localCursor.getCount();
      paramSQLiteDatabase = localArrayList;
      if (i > 0)
      {
        localArrayList = new ArrayList();
        paramInt = 0;
        for (;;)
        {
          paramSQLiteDatabase = localArrayList;
          if (paramInt >= i) {
            break;
          }
          localCursor.moveToPosition(paramInt);
          localArrayList.add(Long.valueOf(localCursor.getLong(localCursor.getColumnIndex("id"))));
          paramInt += 1;
        }
      }
      localCursor.close();
    }
    return paramSQLiteDatabase;
  }
  
  public List<Mail> getAllAdMail(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    paramSQLiteDatabase = getAdvertiseMailList(paramSQLiteDatabase, paramInt, false);
    if ((paramSQLiteDatabase != null) && (paramSQLiteDatabase.moveToFirst())) {
      paramInt = i;
    }
    for (;;)
    {
      Mail localMail;
      if (paramInt < paramSQLiteDatabase.getCount())
      {
        localMail = new Mail();
        localMail.setStatus(new MailStatus());
        localMail.setInformation(new MailInformation());
      }
      try
      {
        fillMail(paramSQLiteDatabase, localMail);
        localArrayList.add(localMail);
        label91:
        paramSQLiteDatabase.moveToNext();
        paramInt += 1;
        continue;
        paramSQLiteDatabase.close();
        return localArrayList;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        break label91;
      }
    }
  }
  
  public Cursor getAllDraftMailListCursor(SQLiteDatabase paramSQLiteDatabase)
  {
    return paramSQLiteDatabase.rawQuery(sqlQueryAllDraftMailInfo, null);
  }
  
  public SparseArray<MailRuleInfo> getAllMailRules(SQLiteDatabase paramSQLiteDatabase)
  {
    int i = 0;
    SparseArray localSparseArray = new SparseArray();
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_RULE_MAIL", new String[0]);
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.getCount() > 0)
      {
        int j = paramSQLiteDatabase.getCount();
        while (i < j)
        {
          paramSQLiteDatabase.moveToPosition(i);
          MailRuleInfo localMailRuleInfo = new MailRuleInfo();
          localMailRuleInfo.setId(paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("ruleId")));
          localMailRuleInfo.setAccountId(paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("accountId")));
          localMailRuleInfo.setFieldName(paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("fieldName")));
          localMailRuleInfo.setOperator(paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("operator")));
          localMailRuleInfo.setVal(paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("val")));
          localMailRuleInfo.setVal2(paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("val2")));
          localMailRuleInfo.setAction(paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("action")));
          localMailRuleInfo.setParam(paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("param")));
          localMailRuleInfo.setAlias(paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("alias")));
          localSparseArray.put(i, localMailRuleInfo);
          i += 1;
        }
      }
      paramSQLiteDatabase.close();
    }
    return localSparseArray;
  }
  
  public Cursor getAllSelfMailListCursor(SQLiteDatabase paramSQLiteDatabase)
  {
    AccountList localAccountList = AccountManager.shareInstance().getAccountList();
    int[] arrayOfInt = new int[localAccountList.size()];
    int i = 0;
    while (i < localAccountList.size())
    {
      arrayOfInt[i] = genRMAAddrId(localAccountList.get(i).getEmail());
      i += 1;
    }
    return paramSQLiteDatabase.rawQuery("SELECT M.* FROM (SELECT DISTINCT convHash FROM QM_MAIL_INFO WHERE id IN(SELECT DISTINCT mid FROM QM_REF_MAIL_ADDR WHERE addrId IN$inClause$)) AS MI INNER JOIN QM_MAIL_INFO AS M ON MI.convHash=M.convHash AND M.convType IN (1, 0) AND  M.folderId NOT IN (SELECT id FROM QM_FOLDER WHERE type IN (3)) AND  M.folderId NOT IN (SELECT id FROM QM_FOLDER WHERE type IN (5,6,8,4)) AND  NOT  attr&4096  GROUP BY M.id ORDER BY utcSent DESC".replace("$inClause$", getInClause(arrayOfInt)), null);
  }
  
  public Cursor getAllSentMailListCursor(SQLiteDatabase paramSQLiteDatabase)
  {
    return paramSQLiteDatabase.rawQuery(sqlQueryAllSentMailInfo, null);
  }
  
  public Cursor getAllTrashMailListCursor(SQLiteDatabase paramSQLiteDatabase)
  {
    return paramSQLiteDatabase.rawQuery(sqlQueryAllTrashMailInfo, null);
  }
  
  public Cursor getCertainContactMailListCursor(SQLiteDatabase paramSQLiteDatabase, ArrayList<String> paramArrayList, ArrayList<Account> paramArrayList1)
  {
    int j = 0;
    int[] arrayOfInt = new int[paramArrayList.size()];
    int i = 0;
    while (i < paramArrayList.size())
    {
      arrayOfInt[i] = genRMAAddrId((String)paramArrayList.get(i));
      i += 1;
    }
    paramArrayList = sqlQueryCertainContactMailInfo.replace("$inclause1$", getInClause(arrayOfInt));
    arrayOfInt = new int[paramArrayList1.size()];
    i = j;
    while (i < paramArrayList1.size())
    {
      arrayOfInt[i] = ((Account)paramArrayList1.get(i)).getId();
      i += 1;
    }
    return paramSQLiteDatabase.rawQuery(paramArrayList.replace("$inclause2$", getInClause(arrayOfInt)), null);
  }
  
  public ArrayList<Long> getClockSendMailId(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong)
  {
    ArrayList localArrayList = new ArrayList();
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT DISTINCT id FROM QM_MAIL_INFO WHERE sendutc>0 AND id IN " + getInClause(paramArrayOfLong), null);
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst()) {
        do
        {
          localArrayList.add(Long.valueOf(paramSQLiteDatabase.getLong(paramSQLiteDatabase.getColumnIndex("id"))));
        } while (paramSQLiteDatabase.moveToNext());
      }
      paramSQLiteDatabase.close();
    }
    return localArrayList;
  }
  
  public long getConvFirstChildId(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2, int paramInt3)
  {
    long l1 = 0L;
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT id FROM QM_MAIL_INFO WHERE convHash=? AND folderId IN(?,?) AND convType<>1 ORDER BY utcSent DESC LIMIT 1", new String[] { String.valueOf(paramInt2), String.valueOf(QMFolderManager.sharedInstance().getSentFolderId(paramInt1)), String.valueOf(paramInt3) });
    long l2 = l1;
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst()) {
        l1 = paramSQLiteDatabase.getLong(0);
      }
      paramSQLiteDatabase.close();
      l2 = l1;
    }
    return l2;
  }
  
  public int getConvHashForInfection(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2, int paramInt3)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT convHash FROM QM_MAIL_INFO WHERE convContactHash = ? AND convHash&2 AND folderId = ?  AND  ( CASE WHEN convRefHash = 0  THEN 1  ELSE convRefHash = ?  END )  ORDER BY utcReceived LIMIT 1", new String[] { String.valueOf(paramInt2), String.valueOf(paramInt3), String.valueOf(paramInt1) });
    paramInt1 = paramInt2;
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst()) {
        paramInt2 = paramSQLiteDatabase.getInt(0);
      }
      paramSQLiteDatabase.close();
      paramInt1 = paramInt2;
    }
    return paramInt1;
  }
  
  public long getConvLastChildId(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2, int paramInt3)
  {
    long l1 = 0L;
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT id FROM QM_MAIL_INFO WHERE convHash=? AND folderId IN(?,?) AND convType<>1 ORDER BY utcSent ASC  LIMIT 1", new String[] { String.valueOf(paramInt2), String.valueOf(QMFolderManager.sharedInstance().getSentFolderId(paramInt1)), String.valueOf(paramInt3) });
    long l2 = l1;
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst()) {
        l1 = paramSQLiteDatabase.getLong(0);
      }
      paramSQLiteDatabase.close();
      l2 = l1;
    }
    return l2;
  }
  
  public long[] getConvMailIds(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    int i = 0;
    Object localObject = null;
    long[] arrayOfLong = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery(sqlQueryConvMailIds, new String[] { String.valueOf(paramLong) });
    paramSQLiteDatabase = localObject;
    if (localCursor != null)
    {
      paramSQLiteDatabase = arrayOfLong;
      if (localCursor.getCount() > 0)
      {
        int j = localCursor.getCount();
        arrayOfLong = new long[j];
        for (;;)
        {
          paramSQLiteDatabase = arrayOfLong;
          if (i >= j) {
            break;
          }
          localCursor.moveToPosition(i);
          arrayOfLong[i] = localCursor.getLong(localCursor.getColumnIndex("id"));
          i += 1;
        }
      }
      localCursor.close();
    }
    return paramSQLiteDatabase;
  }
  
  /* Error */
  public Mail getConvMailInfo(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: iload 5
    //   5: ifeq +122 -> 127
    //   8: iconst_1
    //   9: anewarray 829	java/lang/String
    //   12: astore 6
    //   14: aload 6
    //   16: iconst_0
    //   17: iload_3
    //   18: invokestatic 1040	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   21: aastore
    //   22: aload_1
    //   23: ldc_w 629
    //   26: ldc_w 3497
    //   29: aload_0
    //   30: aload 6
    //   32: invokevirtual 3500	com/tencent/qqmail/model/mail/QMMailSQLite:getInClause	([Ljava/lang/String;)Ljava/lang/String;
    //   35: invokevirtual 833	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   38: iconst_1
    //   39: anewarray 829	java/lang/String
    //   42: dup
    //   43: iconst_0
    //   44: iload 4
    //   46: invokestatic 1040	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   49: aastore
    //   50: invokevirtual 1564	com/tencent/moai/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   53: astore_1
    //   54: aload_1
    //   55: ifnull +178 -> 233
    //   58: aload_1
    //   59: invokeinterface 1570 1 0
    //   64: ifeq +169 -> 233
    //   67: new 1552	com/tencent/qqmail/model/qmdomain/Mail
    //   70: dup
    //   71: invokespecial 1604	com/tencent/qqmail/model/qmdomain/Mail:<init>	()V
    //   74: astore 6
    //   76: aload 6
    //   78: new 1609	com/tencent/qqmail/model/qmdomain/MailStatus
    //   81: dup
    //   82: invokespecial 1610	com/tencent/qqmail/model/qmdomain/MailStatus:<init>	()V
    //   85: invokevirtual 1674	com/tencent/qqmail/model/qmdomain/Mail:setStatus	(Lcom/tencent/qqmail/model/qmdomain/MailStatus;)V
    //   88: aload 6
    //   90: new 1606	com/tencent/qqmail/model/qmdomain/MailInformation
    //   93: dup
    //   94: invokespecial 1607	com/tencent/qqmail/model/qmdomain/MailInformation:<init>	()V
    //   97: invokevirtual 1614	com/tencent/qqmail/model/qmdomain/Mail:setInformation	(Lcom/tencent/qqmail/model/qmdomain/MailInformation;)V
    //   100: aload_1
    //   101: aload 6
    //   103: invokestatic 1777	com/tencent/qqmail/model/mail/QMMailSQLite:fillMail	(Landroid/database/Cursor;Lcom/tencent/qqmail/model/qmdomain/Mail;)V
    //   106: aload 6
    //   108: astore 7
    //   110: aload_1
    //   111: ifnull +13 -> 124
    //   114: aload_1
    //   115: invokeinterface 1577 1 0
    //   120: aload 6
    //   122: astore 7
    //   124: aload 7
    //   126: areturn
    //   127: iconst_2
    //   128: anewarray 829	java/lang/String
    //   131: astore 6
    //   133: aload 6
    //   135: iconst_0
    //   136: iload_3
    //   137: invokestatic 1040	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   140: aastore
    //   141: aload 6
    //   143: iconst_1
    //   144: invokestatic 2419	com/tencent/qqmail/folderlist/QMFolderManager:sharedInstance	()Lcom/tencent/qqmail/folderlist/QMFolderManager;
    //   147: iload_2
    //   148: invokevirtual 3490	com/tencent/qqmail/folderlist/QMFolderManager:getSentFolderId	(I)I
    //   151: invokestatic 1040	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   154: aastore
    //   155: goto -133 -> 22
    //   158: astore_1
    //   159: aconst_null
    //   160: astore_1
    //   161: aload 7
    //   163: astore 6
    //   165: aload_1
    //   166: astore 7
    //   168: aload 6
    //   170: ifnull -46 -> 124
    //   173: aload 6
    //   175: invokeinterface 1577 1 0
    //   180: aload_1
    //   181: areturn
    //   182: astore 6
    //   184: aconst_null
    //   185: astore_1
    //   186: aload_1
    //   187: ifnull +9 -> 196
    //   190: aload_1
    //   191: invokeinterface 1577 1 0
    //   196: aload 6
    //   198: athrow
    //   199: astore 6
    //   201: goto -15 -> 186
    //   204: astore 6
    //   206: aconst_null
    //   207: astore 7
    //   209: aload_1
    //   210: astore 6
    //   212: aload 7
    //   214: astore_1
    //   215: goto -50 -> 165
    //   218: astore 7
    //   220: aload_1
    //   221: astore 7
    //   223: aload 6
    //   225: astore_1
    //   226: aload 7
    //   228: astore 6
    //   230: goto -65 -> 165
    //   233: aconst_null
    //   234: astore 6
    //   236: goto -130 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	this	QMMailSQLite
    //   0	239	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	239	2	paramInt1	int
    //   0	239	3	paramInt2	int
    //   0	239	4	paramInt3	int
    //   0	239	5	paramBoolean	boolean
    //   12	162	6	localObject1	Object
    //   182	15	6	localObject2	Object
    //   199	1	6	localObject3	Object
    //   204	1	6	localException1	Exception
    //   210	25	6	localSQLiteDatabase1	SQLiteDatabase
    //   1	212	7	localObject4	Object
    //   218	1	7	localException2	Exception
    //   221	6	7	localSQLiteDatabase2	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   22	54	158	java/lang/Exception
    //   22	54	182	finally
    //   58	76	199	finally
    //   76	106	199	finally
    //   58	76	204	java/lang/Exception
    //   76	106	218	java/lang/Exception
  }
  
  public Cursor getConvMailList(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    return paramSQLiteDatabase.rawQuery(sqlQueryConvMailInfo, new String[] { String.valueOf(paramLong) });
  }
  
  public long[] getConvMailParentIds(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    int i = 0;
    Object localObject = null;
    long[] arrayOfLong = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT id FROM QM_MAIL_INFO WHERE convHash=? AND convType=1", new String[] { String.valueOf(paramInt) });
    paramSQLiteDatabase = localObject;
    if (localCursor != null)
    {
      paramSQLiteDatabase = arrayOfLong;
      if (localCursor.getCount() > 0)
      {
        int j = localCursor.getCount();
        arrayOfLong = new long[j];
        paramInt = i;
        for (;;)
        {
          paramSQLiteDatabase = arrayOfLong;
          if (paramInt >= j) {
            break;
          }
          localCursor.moveToPosition(paramInt);
          arrayOfLong[paramInt] = localCursor.getLong(localCursor.getColumnIndex("id"));
          paramInt += 1;
        }
      }
      localCursor.close();
    }
    return paramSQLiteDatabase;
  }
  
  public long getConvParentId(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    int i = 0;
    long l = 0L;
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT id FROM QM_MAIL_INFO WHERE convHash=( SELECT convHash FROM QM_MAIL_INFO WHERE id=? ) AND convType=1 ", new String[] { String.valueOf(paramLong) });
    paramLong = l;
    if (paramSQLiteDatabase != null)
    {
      int j = paramSQLiteDatabase.getCount();
      paramLong = l;
      if (j > 0)
      {
        paramLong = l;
        while (i < j)
        {
          paramSQLiteDatabase.moveToPosition(i);
          paramLong = paramSQLiteDatabase.getLong(paramSQLiteDatabase.getColumnIndex("id"));
          i += 1;
        }
      }
      paramSQLiteDatabase.close();
    }
    return paramLong;
  }
  
  public int getConvUnreadCount(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    int i = 0;
    int j = 0;
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(sqlQueryConvMailInfoUnreadCount, new String[] { String.valueOf(paramLong) });
    if (paramSQLiteDatabase != null)
    {
      i = j;
      if (paramSQLiteDatabase.moveToFirst()) {
        i = paramSQLiteDatabase.getInt(0);
      }
      paramSQLiteDatabase.close();
    }
    return i;
  }
  
  public long[] getExpireConvMailIds(SQLiteDatabase paramSQLiteDatabase, int paramInt, long[] paramArrayOfLong)
  {
    int i = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT id FROM QM_MAIL_INFO WHERE convHash=? AND id NOT IN $inClause$".replace("$inClause$", getInClause(paramArrayOfLong)), new String[] { String.valueOf(paramInt) });
    paramSQLiteDatabase = localObject2;
    if (localCursor != null)
    {
      paramSQLiteDatabase = localObject1;
      if (localCursor.getCount() > 0)
      {
        int j = localCursor.getCount();
        paramArrayOfLong = new long[j];
        paramInt = i;
        for (;;)
        {
          paramSQLiteDatabase = paramArrayOfLong;
          if (paramInt >= j) {
            break;
          }
          localCursor.moveToPosition(paramInt);
          paramArrayOfLong[paramInt] = localCursor.getLong(localCursor.getColumnIndex("id"));
          paramInt += 1;
        }
      }
      localCursor.close();
    }
    return paramSQLiteDatabase;
  }
  
  public int getFolderMailCount(SQLiteDatabase paramSQLiteDatabase, QMFolder paramQMFolder)
  {
    int i = 0;
    int j = 0;
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT COUNT(*) FROM QM_MAIL_INFO WHERE folderId = ? AND attr & 256", new String[] { String.valueOf(paramQMFolder.getId()) });
    if (paramSQLiteDatabase != null)
    {
      i = j;
      if (paramSQLiteDatabase.moveToFirst()) {
        i = paramSQLiteDatabase.getInt(0);
      }
      paramSQLiteDatabase.close();
    }
    return i;
  }
  
  public long[] getFolderMailIds(SQLiteDatabase paramSQLiteDatabase, QMFolder paramQMFolder)
  {
    paramQMFolder = getFolderCursorParams(paramQMFolder);
    paramQMFolder = paramSQLiteDatabase.rawQuery((String)paramQMFolder[0], (String[])paramQMFolder[1]);
    paramSQLiteDatabase = new long[0];
    if (paramQMFolder != null)
    {
      int j = paramQMFolder.getCount();
      paramSQLiteDatabase = new long[j];
      int k = paramQMFolder.getColumnIndex("id");
      int i = 0;
      while (i < j)
      {
        paramQMFolder.moveToPosition(i);
        paramSQLiteDatabase[i] = paramQMFolder.getLong(k);
        i += 1;
      }
      paramQMFolder.close();
    }
    return paramSQLiteDatabase;
  }
  
  public Cursor getFolderMailListCursor(SQLiteDatabase paramSQLiteDatabase, QMFolder paramQMFolder)
  {
    paramQMFolder = getFolderCursorParams(paramQMFolder);
    return paramSQLiteDatabase.rawQuery((String)paramQMFolder[0], (String[])paramQMFolder[1]);
  }
  
  public Cursor getFoldersCursor(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt)
  {
    int i = 0;
    HashSet localHashSet = new HashSet();
    localHashSet.add(Integer.valueOf(0));
    int j = paramArrayOfInt.length;
    while (i < j)
    {
      localHashSet.add(Integer.valueOf(paramArrayOfInt[i]));
      i += 1;
    }
    paramArrayOfInt = "( " + StringUtils.join(localHashSet.iterator(), ",") + " )";
    return paramSQLiteDatabase.rawQuery(sqlMailListInFolders.replace("$inClause$", paramArrayOfInt), null);
  }
  
  public SparseArray<String> getGroupIdByMailIds(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT M.remoteId,A.uin FROM QM_MAIL_INFO AS M INNER JOIN QM_REF_MAIL_ADDR AS A ON M.id = A.mid AND A.roleType = 5 WHERE id IN " + getInClause(paramArrayOfLong) + " GROUP BY A." + "uin", null);
    paramSQLiteDatabase = localObject2;
    if (localCursor != null)
    {
      int j = localCursor.getCount();
      paramSQLiteDatabase = localObject1;
      if (j > 0)
      {
        paramArrayOfLong = new SparseArray();
        int i = 0;
        for (;;)
        {
          paramSQLiteDatabase = paramArrayOfLong;
          if (i >= j) {
            break;
          }
          localCursor.moveToPosition(i);
          paramArrayOfLong.put(localCursor.getInt(localCursor.getColumnIndex("uin")), localCursor.getString(localCursor.getColumnIndex("remoteId")));
          i += 1;
        }
      }
      localCursor.close();
    }
    return paramSQLiteDatabase;
  }
  
  public QMCalendarEvent getIcsEventByRemoteMailId(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt)
  {
    Object localObject4 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = localObject2;
    try
    {
      paramString = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_ICS_EVENT WHERE mailId=? AND accountId=?", new String[] { paramString, String.valueOf(paramInt) });
      paramSQLiteDatabase = localObject4;
      if (paramString != null)
      {
        paramSQLiteDatabase = localObject3;
        localObject1 = localObject2;
        if (paramString.moveToFirst())
        {
          localObject1 = localObject2;
          paramSQLiteDatabase = getIcsEventFromCursor(paramString);
        }
        localObject1 = paramSQLiteDatabase;
        paramString.close();
      }
      return paramSQLiteDatabase;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(5, "QMMailSQLite", "getIcsEventByRemoteMailId:" + paramSQLiteDatabase.toString());
    }
    return localObject1;
  }
  
  public ArrayList<Integer> getInvokeTagFolderId(SQLiteDatabase paramSQLiteDatabase, ArrayList<Long> paramArrayList)
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return localArrayList;
    }
    long[] arrayOfLong = new long[paramArrayList.size()];
    int i = 0;
    while (i < paramArrayList.size())
    {
      arrayOfLong[i] = ((Long)paramArrayList.get(i)).longValue();
      i += 1;
    }
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT F.* FROM QM_REF_MAIL_TAG AS T LEFT OUTER JOIN QM_FOLDER AS F ON T.tagId = F.remoteId WHERE  T.mid IN $inclause$ AND F.type = 14 ORDER BY F.remoteId".replace("$inclause$", getInClause(arrayOfLong)), new String[0]);
    if (paramSQLiteDatabase != null)
    {
      int k = paramSQLiteDatabase.getCount();
      if (k > 0)
      {
        i = j;
        while (i < k)
        {
          paramSQLiteDatabase.moveToPosition(i);
          localArrayList.add(Integer.valueOf(paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("id"))));
          i += 1;
        }
      }
      paramSQLiteDatabase.close();
    }
    return localArrayList;
  }
  
  /* Error */
  public List<android.util.Pair<String, Long>> getLatestUTCSend(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 1948	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 1949	java/util/ArrayList:<init>	()V
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 5
    //   12: iload 4
    //   14: ifeq +103 -> 117
    //   17: ldc_w 660
    //   20: astore 6
    //   22: aload_1
    //   23: aload 6
    //   25: iconst_2
    //   26: anewarray 829	java/lang/String
    //   29: dup
    //   30: iconst_0
    //   31: iload_2
    //   32: invokestatic 1040	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   35: aastore
    //   36: dup
    //   37: iconst_1
    //   38: iload_3
    //   39: invokestatic 1040	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   42: aastore
    //   43: invokevirtual 1564	com/tencent/moai/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   46: astore_1
    //   47: aload_1
    //   48: ifnull +77 -> 125
    //   51: aload_1
    //   52: astore 5
    //   54: aload_1
    //   55: invokeinterface 2792 1 0
    //   60: ifeq +65 -> 125
    //   63: aload_1
    //   64: astore 5
    //   66: aload 7
    //   68: new 3554	android/util/Pair
    //   71: dup
    //   72: aload_1
    //   73: iconst_0
    //   74: invokeinterface 1833 2 0
    //   79: aload_1
    //   80: iconst_1
    //   81: invokeinterface 1828 2 0
    //   86: invokestatic 2883	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   89: invokespecial 3557	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   92: invokeinterface 3093 2 0
    //   97: pop
    //   98: goto -47 -> 51
    //   101: astore_1
    //   102: aload 5
    //   104: ifnull +10 -> 114
    //   107: aload 5
    //   109: invokeinterface 1577 1 0
    //   114: aload 7
    //   116: areturn
    //   117: ldc_w 663
    //   120: astore 6
    //   122: goto -100 -> 22
    //   125: aload_1
    //   126: ifnull -12 -> 114
    //   129: aload_1
    //   130: invokeinterface 1577 1 0
    //   135: aload 7
    //   137: areturn
    //   138: astore_1
    //   139: aconst_null
    //   140: astore 6
    //   142: aload_1
    //   143: astore 5
    //   145: aload 6
    //   147: ifnull +10 -> 157
    //   150: aload 6
    //   152: invokeinterface 1577 1 0
    //   157: aload 5
    //   159: athrow
    //   160: astore 5
    //   162: aload_1
    //   163: astore 6
    //   165: goto -20 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	QMMailSQLite
    //   0	168	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	168	2	paramInt1	int
    //   0	168	3	paramInt2	int
    //   0	168	4	paramBoolean	boolean
    //   10	148	5	localSQLiteDatabase	SQLiteDatabase
    //   160	1	5	localObject1	Object
    //   20	144	6	localObject2	Object
    //   7	129	7	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   22	47	101	java/lang/Exception
    //   54	63	101	java/lang/Exception
    //   66	98	101	java/lang/Exception
    //   22	47	138	finally
    //   54	63	160	finally
    //   66	98	160	finally
  }
  
  public long[] getLocalMailsByFolderId(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    int i = 0;
    Object localObject = null;
    long[] arrayOfLong = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT id FROM QM_MAIL_INFO WHERE attr&33554432 AND accountId=? AND folderId=?", new String[] { String.valueOf(paramInt1), String.valueOf(paramInt2) });
    paramSQLiteDatabase = localObject;
    if (localCursor != null)
    {
      paramInt2 = localCursor.getCount();
      paramSQLiteDatabase = arrayOfLong;
      if (paramInt2 > 0)
      {
        arrayOfLong = new long[paramInt2];
        int j = localCursor.getColumnIndex("id");
        paramInt1 = i;
        for (;;)
        {
          paramSQLiteDatabase = arrayOfLong;
          if (paramInt1 >= paramInt2) {
            break;
          }
          localCursor.moveToPosition(paramInt1);
          arrayOfLong[paramInt1] = localCursor.getLong(j);
          paramInt1 += 1;
        }
      }
      localCursor.close();
    }
    return paramSQLiteDatabase;
  }
  
  public ArrayList<Mail> getLocalSentMailList(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT id,subject,utcSent,remoteId,attr FROM QM_MAIL_INFO WHERE attr&33554432 AND accountId=? AND folderId=?", new String[] { String.valueOf(paramInt2), String.valueOf(paramInt1) });
    MailInformation localMailInformation;
    MailStatus localMailStatus;
    if (paramSQLiteDatabase != null) {
      if (paramSQLiteDatabase.moveToFirst())
      {
        localMailInformation = new MailInformation();
        localMailInformation.setId(paramSQLiteDatabase.getLong(paramSQLiteDatabase.getColumnIndex("id")));
        localMailInformation.setRemoteId(paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("remoteId")));
        localMailInformation.setSubject(paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("subject")));
        localMailInformation.setDate(new Date(paramSQLiteDatabase.getLong(paramSQLiteDatabase.getColumnIndex("utcSent"))));
        localMailStatus = new MailStatus();
        if ((paramSQLiteDatabase.getLong(paramSQLiteDatabase.getColumnIndex("attr")) & 0x0) == 0L) {
          break label236;
        }
      }
    }
    label236:
    for (boolean bool = true;; bool = false)
    {
      localMailStatus.setAttrHasAppend(bool);
      Mail localMail = new Mail();
      localMail.setInformation(localMailInformation);
      localMail.setStatus(localMailStatus);
      localArrayList.add(localMail);
      if (paramSQLiteDatabase.moveToNext()) {
        break;
      }
      paramSQLiteDatabase.close();
      return localArrayList;
    }
  }
  
  public ArrayList<String> getLocalSentMailRemoteId(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT remoteId FROM QM_MAIL_INFO WHERE attr&33554432 AND accountId=? AND folderId=?", new String[] { String.valueOf(paramInt2), String.valueOf(paramInt1) });
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst()) {
        do
        {
          localArrayList.add(paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("remoteId")));
        } while (paramSQLiteDatabase.moveToNext());
      }
      paramSQLiteDatabase.close();
    }
    return localArrayList;
  }
  
  public int getMailAdState(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString)
  {
    paramInt = 0;
    int i = 0;
    int j = genRMAAddrId(paramString);
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT ruleType FROM QM_RULE_AD WHERE ruleAddrId=?", new String[] { j + "" });
    if (paramSQLiteDatabase != null)
    {
      paramInt = i;
      if (paramSQLiteDatabase.moveToFirst()) {
        paramInt = paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("ruleType"));
      }
      paramSQLiteDatabase.close();
    }
    return paramInt;
  }
  
  public long[] getMailAttrByIds(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_MAIL_INFO WHERE id IN " + getInClause(paramArrayOfLong), null);
    paramSQLiteDatabase = localObject2;
    if (localCursor != null)
    {
      int j = localCursor.getCount();
      paramSQLiteDatabase = localObject1;
      if (j > 0)
      {
        paramArrayOfLong = new long[j];
        int k = localCursor.getColumnIndex(paramString);
        int i = 0;
        for (;;)
        {
          paramSQLiteDatabase = paramArrayOfLong;
          if (i >= j) {
            break;
          }
          localCursor.moveToPosition(i);
          paramArrayOfLong[i] = localCursor.getLong(k);
          i += 1;
        }
      }
      localCursor.close();
    }
    return paramSQLiteDatabase;
  }
  
  public MailContact[] getMailContacts(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong)
  {
    return getMailContacts(paramSQLiteDatabase, paramArrayOfLong, false, false);
  }
  
  public String getMailContentById(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    String str = "";
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT content FROM QM_MAIL_CONTENT WHERE id=?", new String[] { paramLong + "" });
    paramSQLiteDatabase = str;
    if (localCursor != null)
    {
      paramSQLiteDatabase = str;
      if (localCursor.moveToFirst()) {
        paramSQLiteDatabase = localCursor.getString(localCursor.getColumnIndex("content"));
      }
      localCursor.close();
    }
    return paramSQLiteDatabase;
  }
  
  public Cursor getMailCursorFromMailId(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    return paramSQLiteDatabase.rawQuery("SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE M.id = ?".replace("?", String.valueOf(paramLong)), null);
  }
  
  public int[] getMailFolderIds(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong)
  {
    int j = 0;
    String str = "SELECT DISTINCT folderId FROM QM_MAIL_INFO WHERE id IN " + getInClause(paramArrayOfLong.length);
    String[] arrayOfString = new String[paramArrayOfLong.length];
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      arrayOfString[i] = String.valueOf(paramArrayOfLong[i]);
      i += 1;
    }
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(str, arrayOfString);
    paramArrayOfLong = new int[paramSQLiteDatabase.getCount()];
    if (paramSQLiteDatabase != null)
    {
      i = j;
      while (paramSQLiteDatabase.moveToNext())
      {
        paramArrayOfLong[i] = paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("folderId"));
        i += 1;
      }
      paramSQLiteDatabase.close();
    }
    return paramArrayOfLong;
  }
  
  /* Error */
  @Nullable
  public Map<Long, Integer> getMailIdAndConvType(SQLiteDatabase paramSQLiteDatabase, long... paramVarArgs)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_2
    //   3: ifnull +8 -> 11
    //   6: aload_2
    //   7: arraylength
    //   8: ifne +9 -> 17
    //   11: aconst_null
    //   12: astore 4
    //   14: aload 4
    //   16: areturn
    //   17: new 849	java/lang/StringBuilder
    //   20: dup
    //   21: ldc_w 3587
    //   24: invokespecial 2622	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   27: astore 4
    //   29: iload_3
    //   30: aload_2
    //   31: arraylength
    //   32: if_icmpge +36 -> 68
    //   35: aload 4
    //   37: aload_2
    //   38: iload_3
    //   39: laload
    //   40: invokevirtual 907	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: iload_3
    //   45: aload_2
    //   46: arraylength
    //   47: iconst_1
    //   48: isub
    //   49: if_icmpeq +12 -> 61
    //   52: aload 4
    //   54: ldc_w 1074
    //   57: invokevirtual 858	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: iload_3
    //   62: iconst_1
    //   63: iadd
    //   64: istore_3
    //   65: goto -36 -> 29
    //   68: aload 4
    //   70: ldc_w 888
    //   73: invokevirtual 858	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_1
    //   78: aload 4
    //   80: invokevirtual 872	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: aconst_null
    //   84: invokevirtual 1564	com/tencent/moai/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   87: astore_2
    //   88: aload_2
    //   89: astore 4
    //   91: new 2994	java/util/HashMap
    //   94: dup
    //   95: invokespecial 2995	java/util/HashMap:<init>	()V
    //   98: astore_1
    //   99: aload_2
    //   100: astore 4
    //   102: aload_2
    //   103: invokeinterface 2792 1 0
    //   108: ifeq +67 -> 175
    //   111: aload_2
    //   112: astore 4
    //   114: aload_1
    //   115: aload_2
    //   116: iconst_0
    //   117: invokeinterface 1828 2 0
    //   122: invokestatic 2883	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   125: aload_2
    //   126: iconst_1
    //   127: invokeinterface 1574 2 0
    //   132: invokestatic 2389	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   135: invokeinterface 3090 3 0
    //   140: pop
    //   141: goto -42 -> 99
    //   144: astore 5
    //   146: aload_2
    //   147: astore 4
    //   149: iconst_5
    //   150: ldc 241
    //   152: ldc_w 3588
    //   155: aload 5
    //   157: invokestatic 3591	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   160: aload_1
    //   161: astore 4
    //   163: aload_2
    //   164: ifnull -150 -> 14
    //   167: aload_2
    //   168: invokeinterface 1577 1 0
    //   173: aload_1
    //   174: areturn
    //   175: aload_1
    //   176: astore 4
    //   178: aload_2
    //   179: ifnull -165 -> 14
    //   182: aload_2
    //   183: invokeinterface 1577 1 0
    //   188: aload_1
    //   189: areturn
    //   190: astore_1
    //   191: aconst_null
    //   192: astore 4
    //   194: aload 4
    //   196: ifnull +10 -> 206
    //   199: aload 4
    //   201: invokeinterface 1577 1 0
    //   206: aload_1
    //   207: athrow
    //   208: astore_1
    //   209: goto -15 -> 194
    //   212: astore 5
    //   214: aconst_null
    //   215: astore_2
    //   216: aconst_null
    //   217: astore_1
    //   218: goto -72 -> 146
    //   221: astore 5
    //   223: aconst_null
    //   224: astore_1
    //   225: goto -79 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	this	QMMailSQLite
    //   0	228	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	228	2	paramVarArgs	long[]
    //   1	64	3	i	int
    //   12	188	4	localObject	Object
    //   144	12	5	localException1	Exception
    //   212	1	5	localException2	Exception
    //   221	1	5	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   102	111	144	java/lang/Exception
    //   114	141	144	java/lang/Exception
    //   77	88	190	finally
    //   91	99	208	finally
    //   102	111	208	finally
    //   114	141	208	finally
    //   149	160	208	finally
    //   77	88	212	java/lang/Exception
    //   91	99	221	java/lang/Exception
  }
  
  public long[] getMailIdByRemoteIds(SQLiteDatabase paramSQLiteDatabase, int paramInt, String[] paramArrayOfString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT id FROM QM_MAIL_INFO WHERE folderId=? AND remoteId IN " + getInClause(paramArrayOfString), new String[] { String.valueOf(paramInt) });
    paramSQLiteDatabase = localObject2;
    if (localCursor != null)
    {
      int i = localCursor.getCount();
      paramSQLiteDatabase = localObject1;
      if (i > 0)
      {
        paramArrayOfString = new long[i];
        paramInt = 0;
        for (;;)
        {
          paramSQLiteDatabase = paramArrayOfString;
          if (paramInt >= i) {
            break;
          }
          localCursor.moveToPosition(paramInt);
          paramArrayOfString[paramInt] = localCursor.getLong(0);
          paramInt += 1;
        }
      }
      localCursor.close();
    }
    return paramSQLiteDatabase;
  }
  
  public ArrayList<Long> getMailIdList(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT id FROM QM_MAIL_INFO", null);
    ArrayList localArrayList = new ArrayList();
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst()) {
        do
        {
          localArrayList.add(Long.valueOf(paramSQLiteDatabase.getLong(paramSQLiteDatabase.getColumnIndex("id"))));
        } while (paramSQLiteDatabase.moveToNext());
      }
      paramSQLiteDatabase.close();
    }
    return localArrayList;
  }
  
  public long[] getMailIdsAfterAutoMove(SQLiteDatabase paramSQLiteDatabase, long paramLong, long[] paramArrayOfLong)
  {
    int j = 0;
    if (paramArrayOfLong == null)
    {
      localObject = null;
      return localObject;
    }
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SELECT M.id FROM QM_MAIL_INFO AS M WHERE ").append(" M.id IN " + getInClause(paramArrayOfLong)).append(" AND  EXISTS ( SELECT * FROM QM_MAIL_INFO AS IM ").append(" WHERE IM.convHash IN ( ").append(" SELECT convHash FROM QM_MAIL_INFO WHERE id=M.id").append(" ) ").append(" AND EXISTS ( SELECT * FROM QM_MAIL_INFO").append(" WHERE id=" + paramLong + " AND " + "fromAddr" + "=IM." + "fromAddr" + ") ").append(" ) ");
    localObject = paramSQLiteDatabase.rawQuery(((StringBuffer)localObject).toString(), new String[0]);
    int k;
    int i;
    if (localObject != null)
    {
      k = ((Cursor)localObject).getCount();
      paramSQLiteDatabase = new long[k];
      i = 0;
      while (i < k)
      {
        ((Cursor)localObject).moveToPosition(i);
        paramSQLiteDatabase[i] = ((Cursor)localObject).getLong(((Cursor)localObject).getColumnIndex("id"));
        i += 1;
      }
      ((Cursor)localObject).close();
    }
    for (;;)
    {
      localObject = paramArrayOfLong;
      if (paramSQLiteDatabase == null) {
        break;
      }
      localObject = paramArrayOfLong;
      if (paramSQLiteDatabase.length == 0) {
        break;
      }
      localObject = new long[paramArrayOfLong.length - paramSQLiteDatabase.length];
      StringBuilder localStringBuilder = new StringBuilder();
      k = paramSQLiteDatabase.length;
      i = 0;
      while (i < k)
      {
        paramLong = paramSQLiteDatabase[i];
        localStringBuilder.append(paramLong + ",");
        i += 1;
      }
      paramSQLiteDatabase = localStringBuilder.toString();
      QMLog.log(4, "QMMailSQLite", "afterCreateRule: hit mails - " + paramSQLiteDatabase);
      i = 0;
      while (i < paramArrayOfLong.length)
      {
        k = j;
        if (!paramSQLiteDatabase.contains(paramArrayOfLong[i] + ","))
        {
          k = j;
          if (j < localObject.length)
          {
            localObject[j] = paramArrayOfLong[i];
            k = j + 1;
          }
        }
        i += 1;
        j = k;
      }
      return localObject;
      paramSQLiteDatabase = null;
    }
  }
  
  public Object[] getMailInfoByIds(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_MAIL_INFO WHERE id IN " + getInClause(paramArrayOfLong), null);
    paramSQLiteDatabase = localObject2;
    if (localCursor != null)
    {
      int j = localCursor.getCount();
      paramSQLiteDatabase = localObject1;
      if (j > 0)
      {
        paramArrayOfLong = new String[j];
        int k = localCursor.getColumnIndex(paramString);
        int i = 0;
        for (;;)
        {
          paramSQLiteDatabase = paramArrayOfLong;
          if (i >= j) {
            break;
          }
          localCursor.moveToPosition(i);
          paramArrayOfLong[i] = localCursor.getString(k);
          i += 1;
        }
      }
      localCursor.close();
    }
    return paramSQLiteDatabase;
  }
  
  public Cursor getMailListCursorByCursor(SQLiteDatabase paramSQLiteDatabase, Cursor paramCursor, ArrayList<ArrayList<Long>> paramArrayList)
  {
    if ((paramCursor == null) || (paramCursor.isClosed())) {
      return null;
    }
    if (paramArrayList == null) {
      paramArrayList = new ArrayList();
    }
    while ((paramCursor != null) && (!paramCursor.isClosed()) && (paramCursor.getCount() > 0) && (paramArrayList != null))
    {
      Object localObject = paramArrayList.iterator();
      int i = 0;
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          i = ((ArrayList)((Iterator)localObject).next()).size() + i;
          continue;
          paramArrayList = new ArrayList(paramArrayList);
          break;
        }
      }
      int j;
      try
      {
        localObject = new long[paramCursor.getCount() + i];
        j = paramCursor.getColumnIndex("id");
        int k = paramCursor.getCount();
        i = 0;
        while (i < k)
        {
          paramCursor.moveToPosition(i);
          localObject[i] = paramCursor.getLong(j);
          i += 1;
        }
        paramCursor = paramArrayList.iterator();
      }
      catch (Exception paramSQLiteDatabase)
      {
        return null;
      }
      while (paramCursor.hasNext())
      {
        paramArrayList = (ArrayList)paramCursor.next();
        j = 0;
        while (j < paramArrayList.size())
        {
          localObject[i] = ((Long)paramArrayList.get(j)).longValue();
          j += 1;
          i += 1;
        }
      }
      return paramSQLiteDatabase.rawQuery("SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE id IN $inClause$ AND  M.folderId NOT IN (SELECT id FROM QM_FOLDER WHERE type IN (5,6,4)) GROUP BY M.id".replace("$inClause$", getInClause((long[])localObject)) + " ORDER BY " + getOrderByIds("id", (long[])localObject), null);
    }
    return null;
  }
  
  public long[] getMailRuleHits(SQLiteDatabase paramSQLiteDatabase, MailRuleInfo paramMailRuleInfo)
  {
    int i = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3 = new StringBuffer("SELECT id FROM QM_MAIL_INFO WHERE ");
    label52:
    label88:
    int j;
    if (paramMailRuleInfo.getFieldName() == 0)
    {
      ((StringBuffer)localObject3).append("fromAddr");
      if (paramMailRuleInfo.getOperator() != 0) {
        break label275;
      }
      ((StringBuffer)localObject3).append(" =? ");
      if (paramMailRuleInfo.getAccountId() == 0) {
        break label307;
      }
      ((StringBuffer)localObject3).append(" AND accountId=" + paramMailRuleInfo.getAccountId());
      j = QMFolderManager.sharedInstance().getInboxFolderId(paramMailRuleInfo.getAccountId());
      if ((paramMailRuleInfo.getAlias() != "reject") && (paramMailRuleInfo.getAlias() != "moveto")) {
        break label319;
      }
      ((StringBuffer)localObject3).append(" AND folderId=" + j);
    }
    for (;;)
    {
      localObject3 = paramSQLiteDatabase.rawQuery(((StringBuffer)localObject3).toString(), new String[] { paramMailRuleInfo.getVal() });
      paramSQLiteDatabase = localObject2;
      if (localObject3 == null) {
        return paramSQLiteDatabase;
      }
      j = ((Cursor)localObject3).getCount();
      paramSQLiteDatabase = localObject1;
      if (j <= 0) {
        break label331;
      }
      paramMailRuleInfo = new long[j];
      for (;;)
      {
        paramSQLiteDatabase = paramMailRuleInfo;
        if (i >= j) {
          break;
        }
        ((Cursor)localObject3).moveToPosition(i);
        paramMailRuleInfo[i] = ((Cursor)localObject3).getLong(((Cursor)localObject3).getColumnIndex("id"));
        i += 1;
      }
      if (paramMailRuleInfo.getFieldName() == 1)
      {
        ((StringBuffer)localObject3).append("subject");
        break;
      }
      ((StringBuffer)localObject3).append("fromAddr");
      break;
      label275:
      if (paramMailRuleInfo.getOperator() == 1)
      {
        ((StringBuffer)localObject3).append(" LIKE %?% ");
        break label52;
      }
      ((StringBuffer)localObject3).append(" ");
      break label52;
      label307:
      ((StringBuffer)localObject3).append(" ");
      break label88;
      label319:
      ((StringBuffer)localObject3).append(" ");
    }
    label331:
    ((Cursor)localObject3).close();
    return paramSQLiteDatabase;
  }
  
  public ArrayList<Object> getMailTags(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT F.* FROM QM_REF_MAIL_TAG AS T LEFT OUTER JOIN QM_FOLDER AS F ON T.tagId = F.remoteId WHERE F.accountId = ? AND T.mid = ? AND F.type = 14 ORDER BY F.remoteId", new String[] { paramInt + "", paramLong + "" });
    MailTag localMailTag = null;
    paramSQLiteDatabase = null;
    SQLiteDatabase localSQLiteDatabase = null;
    if (localCursor != null)
    {
      paramSQLiteDatabase = localMailTag;
      if (localCursor.moveToFirst())
      {
        localMailTag = new MailTag();
        localMailTag.setTagId(localCursor.getString(localCursor.getColumnIndex("remoteId")));
        localMailTag.setName(localCursor.getString(localCursor.getColumnIndex("name")));
        localMailTag.setColor(localCursor.getString(localCursor.getColumnIndex("colorId")));
        if (!paramString.equals(localMailTag.getTagId())) {
          break label227;
        }
      }
    }
    for (paramSQLiteDatabase = localMailTag;; paramSQLiteDatabase = localSQLiteDatabase)
    {
      localArrayList.add(localMailTag);
      localSQLiteDatabase = paramSQLiteDatabase;
      if (localCursor.moveToNext()) {
        break;
      }
      localCursor.close();
      if (paramSQLiteDatabase != null) {
        localArrayList.add(0, paramSQLiteDatabase);
      }
      return localArrayList;
      label227:
      localArrayList.add(localMailTag);
    }
  }
  
  public long getMailUTC(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString)
  {
    long l1 = 0L;
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT utcSent FROM QM_MAIL_INFO WHERE accountId=? AND remoteId=?", new String[] { String.valueOf(paramInt), paramString });
    long l2 = l1;
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst()) {
        l1 = paramSQLiteDatabase.getLong(0);
      }
      paramSQLiteDatabase.close();
      l2 = l1;
    }
    return l2;
  }
  
  public String[] getMailsAddress(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong)
  {
    return getMailsAddress(paramSQLiteDatabase, paramArrayOfLong, false);
  }
  
  @Nullable
  ArrayList<Mail> getMailsByRemoteId(SQLiteDatabase paramSQLiteDatabase, int paramInt, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return null;
    }
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE M.remoteId IN $inClause$ AND M.accountId=?".replace("$inClause$", getInClause(paramArrayOfString)), new String[] { String.valueOf(paramInt) });
    if (paramSQLiteDatabase != null)
    {
      paramArrayOfString = new ArrayList();
      int j = paramSQLiteDatabase.getCount();
      paramInt = i;
      while (paramInt < j)
      {
        paramSQLiteDatabase.moveToPosition(paramInt);
        Mail localMail = new Mail();
        localMail.setStatus(new MailStatus());
        localMail.setInformation(new MailInformation());
        fillMail(paramSQLiteDatabase, localMail, null);
        paramArrayOfString.add(localMail);
        paramInt += 1;
      }
      paramSQLiteDatabase.close();
      return paramArrayOfString;
    }
    return null;
  }
  
  public void getMailsPreload(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong, GroupMailPreloadWatcher paramGroupMailPreloadWatcher)
  {
    ArrayList localArrayList = new ArrayList();
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(sqlQueryMailNeedPreload.replace("$inClause$", getInClause(paramArrayOfLong)), null);
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst())
      {
        int j = paramSQLiteDatabase.getCount();
        int i = 0;
        while (i < j)
        {
          paramSQLiteDatabase.moveToPosition(i);
          paramArrayOfLong = new Mail();
          paramArrayOfLong.setStatus(new MailStatus());
          paramArrayOfLong.setInformation(new MailInformation());
          fillMail(paramSQLiteDatabase, paramArrayOfLong);
          localArrayList.add(paramArrayOfLong);
          i += 1;
        }
      }
      paramSQLiteDatabase.close();
    }
    paramGroupMailPreloadWatcher.onPreloadMail(localArrayList);
  }
  
  public long[] getNewMailIdByRemoteIds(SQLiteDatabase paramSQLiteDatabase, int paramInt, String[] paramArrayOfString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT id FROM QM_MAIL_INFO WHERE folderId=?  AND isUnread=1 AND isLoaded=0 AND remoteId IN " + getInClause(paramArrayOfString), new String[] { String.valueOf(paramInt) });
    paramSQLiteDatabase = localObject2;
    if (localCursor != null)
    {
      int i = localCursor.getCount();
      paramSQLiteDatabase = localObject1;
      if (i > 0)
      {
        paramArrayOfString = new long[i];
        paramInt = 0;
        for (;;)
        {
          paramSQLiteDatabase = paramArrayOfString;
          if (paramInt >= i) {
            break;
          }
          localCursor.moveToPosition(paramInt);
          paramArrayOfString[paramInt] = localCursor.getLong(0);
          paramInt += 1;
        }
      }
      localCursor.close();
    }
    return paramSQLiteDatabase;
  }
  
  public long[] getNonConvMailIds(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    paramArrayOfLong = "SELECT * FROM QM_MAIL_INFO WHERE id IN " + getInClause(paramArrayOfLong);
    paramArrayOfLong = new StringBuffer("SELECT M.* FROM QM_MAIL_INFO AS M, ( " + paramArrayOfLong + " ) AS ORI ");
    paramArrayOfLong.append(" WHERE ");
    paramArrayOfLong.append(" ORI.accountId=M.accountId");
    paramArrayOfLong.append(" AND ORI.convHash=M.convHash");
    paramArrayOfLong.append(" AND ORI.fromAddr=M.fromAddr");
    paramArrayOfLong.append(" AND M.convType IN (0,-1) ");
    Cursor localCursor = paramSQLiteDatabase.rawQuery(paramArrayOfLong.toString(), null);
    paramSQLiteDatabase = localObject2;
    if (localCursor != null)
    {
      int j = localCursor.getCount();
      paramSQLiteDatabase = localObject1;
      if (j > 0)
      {
        paramArrayOfLong = new long[j];
        int i = 0;
        for (;;)
        {
          paramSQLiteDatabase = paramArrayOfLong;
          if (i >= j) {
            break;
          }
          localCursor.moveToPosition(i);
          paramArrayOfLong[i] = localCursor.getLong(localCursor.getColumnIndex("id"));
          i += 1;
        }
      }
      localCursor.close();
    }
    return paramSQLiteDatabase;
  }
  
  /* Error */
  public long getOverDueMailsLastSince(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_2
    //   1: invokestatic 1040	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   4: astore 17
    //   6: aconst_null
    //   7: astore 13
    //   9: aconst_null
    //   10: astore 12
    //   12: aconst_null
    //   13: astore 15
    //   15: aconst_null
    //   16: astore 16
    //   18: aconst_null
    //   19: astore 14
    //   21: aload_1
    //   22: ldc_w 598
    //   25: iconst_2
    //   26: anewarray 829	java/lang/String
    //   29: dup
    //   30: iconst_0
    //   31: aload 17
    //   33: aastore
    //   34: dup
    //   35: iconst_1
    //   36: iload_3
    //   37: invokestatic 1040	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   40: aastore
    //   41: invokevirtual 1564	com/tencent/moai/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   44: astore 11
    //   46: aload 11
    //   48: ifnull +331 -> 379
    //   51: aload 15
    //   53: astore 12
    //   55: aload 11
    //   57: invokeinterface 2335 1 0
    //   62: iload_3
    //   63: if_icmpne +316 -> 379
    //   66: aload 15
    //   68: astore 12
    //   70: aload 11
    //   72: iload_3
    //   73: iconst_1
    //   74: isub
    //   75: invokeinterface 2339 2 0
    //   80: pop
    //   81: aload 15
    //   83: astore 12
    //   85: aload 11
    //   87: aload 11
    //   89: ldc_w 985
    //   92: invokeinterface 1972 2 0
    //   97: invokeinterface 1828 2 0
    //   102: lstore 7
    //   104: iload 4
    //   106: ifne +22 -> 128
    //   109: lload 7
    //   111: lstore 9
    //   113: iconst_0
    //   114: ifeq +11 -> 125
    //   117: new 3715	java/lang/NullPointerException
    //   120: dup
    //   121: invokespecial 3716	java/lang/NullPointerException:<init>	()V
    //   124: athrow
    //   125: lload 9
    //   127: lreturn
    //   128: aload 15
    //   130: astore 12
    //   132: aload 16
    //   134: astore 13
    //   136: aload_1
    //   137: ldc_w 589
    //   140: iconst_2
    //   141: anewarray 829	java/lang/String
    //   144: dup
    //   145: iconst_0
    //   146: aload 17
    //   148: aastore
    //   149: dup
    //   150: iconst_1
    //   151: new 1835	java/util/Date
    //   154: dup
    //   155: invokespecial 2236	java/util/Date:<init>	()V
    //   158: invokevirtual 2853	java/util/Date:getTime	()J
    //   161: ldc2_w 3717
    //   164: lsub
    //   165: invokestatic 2412	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   168: aastore
    //   169: invokevirtual 1564	com/tencent/moai/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   172: astore_1
    //   173: lload 7
    //   175: lstore 5
    //   177: aload_1
    //   178: astore 14
    //   180: aload_1
    //   181: ifnull +99 -> 280
    //   184: lload 7
    //   186: lstore 5
    //   188: aload_1
    //   189: astore 14
    //   191: aload_1
    //   192: astore 12
    //   194: aload_1
    //   195: astore 13
    //   197: aload_1
    //   198: invokeinterface 2335 1 0
    //   203: ifle +77 -> 280
    //   206: aload_1
    //   207: astore 12
    //   209: aload_1
    //   210: astore 13
    //   212: aload_1
    //   213: iconst_0
    //   214: invokeinterface 2339 2 0
    //   219: pop
    //   220: aload_1
    //   221: astore 12
    //   223: aload_1
    //   224: astore 13
    //   226: aload_1
    //   227: aload 11
    //   229: ldc_w 985
    //   232: invokeinterface 1972 2 0
    //   237: invokeinterface 1828 2 0
    //   242: lstore 9
    //   244: lload 7
    //   246: lstore 5
    //   248: aload_1
    //   249: astore 14
    //   251: lload 9
    //   253: lconst_0
    //   254: lcmp
    //   255: ifeq +25 -> 280
    //   258: lload 7
    //   260: lstore 5
    //   262: aload_1
    //   263: astore 14
    //   265: lload 9
    //   267: lload 7
    //   269: lcmp
    //   270: ifge +10 -> 280
    //   273: lload 9
    //   275: lstore 5
    //   277: aload_1
    //   278: astore 14
    //   280: lload 5
    //   282: lstore 9
    //   284: aload 14
    //   286: ifnull -161 -> 125
    //   289: aload 14
    //   291: invokeinterface 1577 1 0
    //   296: aload 11
    //   298: invokeinterface 1577 1 0
    //   303: lload 5
    //   305: lreturn
    //   306: astore_1
    //   307: aconst_null
    //   308: astore 11
    //   310: lconst_0
    //   311: lstore 7
    //   313: lload 7
    //   315: lstore 9
    //   317: aload 13
    //   319: ifnull -194 -> 125
    //   322: aload 13
    //   324: invokeinterface 1577 1 0
    //   329: aload 11
    //   331: invokeinterface 1577 1 0
    //   336: lload 7
    //   338: lreturn
    //   339: astore_1
    //   340: aconst_null
    //   341: astore 11
    //   343: aload 12
    //   345: ifnull +17 -> 362
    //   348: aload 12
    //   350: invokeinterface 1577 1 0
    //   355: aload 11
    //   357: invokeinterface 1577 1 0
    //   362: aload_1
    //   363: athrow
    //   364: astore_1
    //   365: goto -22 -> 343
    //   368: astore_1
    //   369: lconst_0
    //   370: lstore 7
    //   372: goto -59 -> 313
    //   375: astore_1
    //   376: goto -63 -> 313
    //   379: lconst_0
    //   380: lstore 5
    //   382: goto -102 -> 280
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	385	0	this	QMMailSQLite
    //   0	385	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	385	2	paramInt1	int
    //   0	385	3	paramInt2	int
    //   0	385	4	paramBoolean	boolean
    //   175	206	5	l1	long
    //   102	269	7	l2	long
    //   111	205	9	l3	long
    //   44	312	11	localCursor	Cursor
    //   10	339	12	localObject1	Object
    //   7	316	13	localObject2	Object
    //   19	271	14	localSQLiteDatabase	SQLiteDatabase
    //   13	116	15	localObject3	Object
    //   16	117	16	localObject4	Object
    //   4	143	17	str	String
    // Exception table:
    //   from	to	target	type
    //   21	46	306	java/lang/Exception
    //   21	46	339	finally
    //   55	66	364	finally
    //   70	81	364	finally
    //   85	104	364	finally
    //   136	173	364	finally
    //   197	206	364	finally
    //   212	220	364	finally
    //   226	244	364	finally
    //   55	66	368	java/lang/Exception
    //   70	81	368	java/lang/Exception
    //   85	104	368	java/lang/Exception
    //   136	173	375	java/lang/Exception
    //   197	206	375	java/lang/Exception
    //   212	220	375	java/lang/Exception
    //   226	244	375	java/lang/Exception
  }
  
  public ArrayList<Long> getOverdueMailsIds(SQLiteDatabase paramSQLiteDatabase, int paramInt, long paramLong)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT id FROM QM_MAIL_INFO WHERE folderId = ? AND attr&256 AND utcReceived < ?  ORDER BY utcReceived DESC", new String[] { String.valueOf(paramInt), String.valueOf(paramLong) });
    if (paramSQLiteDatabase != null)
    {
      int j = paramSQLiteDatabase.getCount();
      if (j > 0)
      {
        paramInt = i;
        while (paramInt < j)
        {
          paramSQLiteDatabase.moveToPosition(paramInt);
          localArrayList.add(Long.valueOf(paramSQLiteDatabase.getLong(paramSQLiteDatabase.getColumnIndex("id"))));
          paramInt += 1;
        }
      }
      paramSQLiteDatabase.close();
    }
    return localArrayList;
  }
  
  public ArrayList<Long> getPopInAdMailIds(SQLiteDatabase paramSQLiteDatabase)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT id from QM_MAIL_INFO WHERE attr&2048", new String[0]);
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst())
      {
        int j = paramSQLiteDatabase.getCount();
        while (i < j)
        {
          paramSQLiteDatabase.moveToPosition(i);
          long l = paramSQLiteDatabase.getLong(paramSQLiteDatabase.getColumnIndex("id"));
          if (l != 0L) {
            localArrayList.add(Long.valueOf(l));
          }
          i += 1;
        }
      }
      paramSQLiteDatabase.close();
    }
    return localArrayList;
  }
  
  public ArrayList<Long> getPopInConvMailParentIds(SQLiteDatabase paramSQLiteDatabase, int paramInt, long paramLong)
  {
    paramInt = 0;
    ArrayList localArrayList = new ArrayList();
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT id FROM QM_MAIL_INFO INNER JOIN (SELECT convHash AS ch FROM QM_MAIL_INFO WHERE id=?) ON convHash=ch AND convType=1 ", new String[] { String.valueOf(paramLong) });
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst())
      {
        int i = paramSQLiteDatabase.getCount();
        while (paramInt < i)
        {
          paramSQLiteDatabase.moveToPosition(paramInt);
          paramLong = paramSQLiteDatabase.getLong(paramSQLiteDatabase.getColumnIndex("id"));
          if (paramLong != 0L) {
            localArrayList.add(Long.valueOf(paramLong));
          }
          paramInt += 1;
        }
      }
      paramSQLiteDatabase.close();
    }
    return localArrayList;
  }
  
  public ArrayList<Long> getPopMailId(SQLiteDatabase paramSQLiteDatabase, ArrayList<Integer> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("select M_TEMP.id from QM_MAIL_INFO as M_TEMP where M_TEMP.accountId in $inClause$".replace("$inClause$", getInClause(paramArrayList)), null);
      if (paramSQLiteDatabase != null)
      {
        if (paramSQLiteDatabase.moveToFirst()) {
          do
          {
            localArrayList.add(Long.valueOf(paramSQLiteDatabase.getLong(paramSQLiteDatabase.getColumnIndex("id"))));
          } while (paramSQLiteDatabase.moveToNext());
        }
        paramSQLiteDatabase.close();
      }
      return localArrayList;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "QMMailSQLite", Log.getStackTraceString(paramSQLiteDatabase));
    }
    return localArrayList;
  }
  
  public Cursor getProtocolUnreadedMailListCursor(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    int[] arrayOfInt = AccountManager.shareInstance().getAccountList().getAllGMailAccountIds();
    return paramSQLiteDatabase.rawQuery(sqlQueryProtocolUnreadMailInfo.replace("$inClause$", getInClause(arrayOfInt)), new String[] { String.valueOf(paramInt) });
  }
  
  public Cursor getQQUnreadedMailListCursor(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    int i = QMFolderManager.sharedInstance().getQQMailUnreadFolderId(paramInt);
    QMFolder localQMFolder = QMFolderManager.sharedInstance().getFolder(i);
    return paramSQLiteDatabase.rawQuery(sqlQueryQQUnreadMailInfo, new String[] { String.valueOf(paramInt), String.valueOf(localQMFolder.getSince()) });
  }
  
  /* Error */
  public Mail getRecentAdvertiseMail(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    // Byte code:
    //   0: new 849	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 852	java/lang/StringBuilder:<init>	()V
    //   7: getstatic 1298	com/tencent/qqmail/model/mail/QMMailSQLite:queryAdvertiseMailList	Ljava/lang/String;
    //   10: invokevirtual 858	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: ldc 139
    //   15: invokevirtual 858	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: ldc_w 3738
    //   21: invokevirtual 858	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 872	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: astore 4
    //   29: iload_2
    //   30: ifeq +147 -> 177
    //   33: new 849	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 852	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 2660
    //   43: invokevirtual 858	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload_2
    //   47: invokevirtual 1006	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: invokevirtual 872	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: astore_3
    //   54: aload 4
    //   56: ldc_w 2649
    //   59: aload_3
    //   60: invokevirtual 833	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   63: astore 4
    //   65: iload_2
    //   66: ifeq +118 -> 184
    //   69: new 849	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 852	java/lang/StringBuilder:<init>	()V
    //   76: ldc_w 1558
    //   79: invokevirtual 858	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: iload_2
    //   83: invokevirtual 1006	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   86: invokevirtual 872	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: astore_3
    //   90: aload 4
    //   92: ldc_w 2651
    //   95: aload_3
    //   96: invokevirtual 833	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   99: astore_3
    //   100: aload_1
    //   101: aload_3
    //   102: iconst_0
    //   103: anewarray 829	java/lang/String
    //   106: invokevirtual 1564	com/tencent/moai/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   109: astore_3
    //   110: aload_3
    //   111: ifnull +130 -> 241
    //   114: aload_3
    //   115: invokeinterface 1570 1 0
    //   120: ifeq +121 -> 241
    //   123: new 1552	com/tencent/qqmail/model/qmdomain/Mail
    //   126: dup
    //   127: invokespecial 1604	com/tencent/qqmail/model/qmdomain/Mail:<init>	()V
    //   130: astore_1
    //   131: aload_1
    //   132: new 1609	com/tencent/qqmail/model/qmdomain/MailStatus
    //   135: dup
    //   136: invokespecial 1610	com/tencent/qqmail/model/qmdomain/MailStatus:<init>	()V
    //   139: invokevirtual 1674	com/tencent/qqmail/model/qmdomain/Mail:setStatus	(Lcom/tencent/qqmail/model/qmdomain/MailStatus;)V
    //   142: aload_1
    //   143: new 1606	com/tencent/qqmail/model/qmdomain/MailInformation
    //   146: dup
    //   147: invokespecial 1607	com/tencent/qqmail/model/qmdomain/MailInformation:<init>	()V
    //   150: invokevirtual 1614	com/tencent/qqmail/model/qmdomain/Mail:setInformation	(Lcom/tencent/qqmail/model/qmdomain/MailInformation;)V
    //   153: aload_3
    //   154: aload_1
    //   155: invokestatic 1777	com/tencent/qqmail/model/mail/QMMailSQLite:fillMail	(Landroid/database/Cursor;Lcom/tencent/qqmail/model/qmdomain/Mail;)V
    //   158: aload_1
    //   159: astore 4
    //   161: aload_3
    //   162: ifnull +12 -> 174
    //   165: aload_3
    //   166: invokeinterface 1577 1 0
    //   171: aload_1
    //   172: astore 4
    //   174: aload 4
    //   176: areturn
    //   177: ldc_w 1517
    //   180: astore_3
    //   181: goto -127 -> 54
    //   184: ldc_w 1517
    //   187: astore_3
    //   188: goto -98 -> 90
    //   191: astore_1
    //   192: aconst_null
    //   193: astore_3
    //   194: aconst_null
    //   195: astore_1
    //   196: aload_1
    //   197: astore 4
    //   199: aload_3
    //   200: ifnull -26 -> 174
    //   203: aload_3
    //   204: invokeinterface 1577 1 0
    //   209: aload_1
    //   210: areturn
    //   211: astore_1
    //   212: aconst_null
    //   213: astore_3
    //   214: aload_3
    //   215: ifnull +9 -> 224
    //   218: aload_3
    //   219: invokeinterface 1577 1 0
    //   224: aload_1
    //   225: athrow
    //   226: astore_1
    //   227: goto -13 -> 214
    //   230: astore_1
    //   231: aconst_null
    //   232: astore_1
    //   233: goto -37 -> 196
    //   236: astore 4
    //   238: goto -42 -> 196
    //   241: aconst_null
    //   242: astore_1
    //   243: goto -85 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	QMMailSQLite
    //   0	246	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	246	2	paramInt	int
    //   53	166	3	localObject1	Object
    //   27	171	4	localObject2	Object
    //   236	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   100	110	191	java/lang/Exception
    //   100	110	211	finally
    //   114	131	226	finally
    //   131	158	226	finally
    //   114	131	230	java/lang/Exception
    //   131	158	236	java/lang/Exception
  }
  
  /* Error */
  public Mail getRecentConvChild(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_1
    //   7: ldc_w 696
    //   10: iconst_2
    //   11: anewarray 829	java/lang/String
    //   14: dup
    //   15: iconst_0
    //   16: iload_3
    //   17: invokestatic 1040	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: iload_2
    //   24: invokestatic 1040	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   27: aastore
    //   28: invokevirtual 1564	com/tencent/moai/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   31: astore_1
    //   32: aload 6
    //   34: astore 4
    //   36: aload_1
    //   37: ifnull +55 -> 92
    //   40: aload 6
    //   42: astore 4
    //   44: aload_1
    //   45: invokeinterface 1570 1 0
    //   50: ifeq +42 -> 92
    //   53: new 1552	com/tencent/qqmail/model/qmdomain/Mail
    //   56: dup
    //   57: invokespecial 1604	com/tencent/qqmail/model/qmdomain/Mail:<init>	()V
    //   60: astore 4
    //   62: aload 4
    //   64: new 1609	com/tencent/qqmail/model/qmdomain/MailStatus
    //   67: dup
    //   68: invokespecial 1610	com/tencent/qqmail/model/qmdomain/MailStatus:<init>	()V
    //   71: invokevirtual 1674	com/tencent/qqmail/model/qmdomain/Mail:setStatus	(Lcom/tencent/qqmail/model/qmdomain/MailStatus;)V
    //   74: aload 4
    //   76: new 1606	com/tencent/qqmail/model/qmdomain/MailInformation
    //   79: dup
    //   80: invokespecial 1607	com/tencent/qqmail/model/qmdomain/MailInformation:<init>	()V
    //   83: invokevirtual 1614	com/tencent/qqmail/model/qmdomain/Mail:setInformation	(Lcom/tencent/qqmail/model/qmdomain/MailInformation;)V
    //   86: aload_1
    //   87: aload 4
    //   89: invokestatic 1777	com/tencent/qqmail/model/mail/QMMailSQLite:fillMail	(Landroid/database/Cursor;Lcom/tencent/qqmail/model/qmdomain/Mail;)V
    //   92: aload 4
    //   94: astore 5
    //   96: aload_1
    //   97: ifnull +13 -> 110
    //   100: aload_1
    //   101: invokeinterface 1577 1 0
    //   106: aload 4
    //   108: astore 5
    //   110: aload 5
    //   112: areturn
    //   113: astore_1
    //   114: aconst_null
    //   115: astore_1
    //   116: aload 5
    //   118: astore 4
    //   120: aload 4
    //   122: astore 5
    //   124: aload_1
    //   125: ifnull -15 -> 110
    //   128: aload_1
    //   129: invokeinterface 1577 1 0
    //   134: aload 4
    //   136: areturn
    //   137: astore_1
    //   138: aconst_null
    //   139: astore 5
    //   141: aload_1
    //   142: astore 4
    //   144: aload 5
    //   146: ifnull +10 -> 156
    //   149: aload 5
    //   151: invokeinterface 1577 1 0
    //   156: aload 4
    //   158: athrow
    //   159: astore 4
    //   161: aload_1
    //   162: astore 5
    //   164: goto -20 -> 144
    //   167: astore 4
    //   169: aload 5
    //   171: astore 4
    //   173: goto -53 -> 120
    //   176: astore 5
    //   178: goto -58 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	QMMailSQLite
    //   0	181	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	181	2	paramInt1	int
    //   0	181	3	paramInt2	int
    //   34	123	4	localObject1	Object
    //   159	1	4	localObject2	Object
    //   167	1	4	localException1	Exception
    //   171	1	4	localObject3	Object
    //   1	169	5	localObject4	Object
    //   176	1	5	localException2	Exception
    //   4	37	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   6	32	113	java/lang/Exception
    //   6	32	137	finally
    //   44	62	159	finally
    //   62	92	159	finally
    //   44	62	167	java/lang/Exception
    //   62	92	176	java/lang/Exception
  }
  
  public Mail getRecentMail(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery(sqlQueryRecentMailUTC, new String[] { String.valueOf(paramInt) });
    paramSQLiteDatabase = localObject2;
    if (localCursor != null)
    {
      paramSQLiteDatabase = localObject1;
      if (localCursor.moveToFirst())
      {
        paramSQLiteDatabase = new Mail();
        paramSQLiteDatabase.setStatus(new MailStatus());
        paramSQLiteDatabase.setInformation(new MailInformation());
        fillMail(localCursor, paramSQLiteDatabase);
      }
      localCursor.close();
    }
    return paramSQLiteDatabase;
  }
  
  /* Error */
  public ArrayList<Mail> getRecentRecvMails(SQLiteDatabase paramSQLiteDatabase, int paramInt, Date paramDate)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_1
    //   7: ldc_w 700
    //   10: iconst_2
    //   11: anewarray 829	java/lang/String
    //   14: dup
    //   15: iconst_0
    //   16: iload_2
    //   17: invokestatic 1040	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: aload_3
    //   24: invokevirtual 2853	java/util/Date:getTime	()J
    //   27: invokestatic 2412	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   30: aastore
    //   31: invokevirtual 1564	com/tencent/moai/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   34: astore_1
    //   35: aload 6
    //   37: astore_3
    //   38: aload_1
    //   39: ifnull +88 -> 127
    //   42: new 1948	java/util/ArrayList
    //   45: dup
    //   46: invokespecial 1949	java/util/ArrayList:<init>	()V
    //   49: astore_3
    //   50: aload_1
    //   51: invokeinterface 2335 1 0
    //   56: istore 4
    //   58: iconst_0
    //   59: istore_2
    //   60: iload_2
    //   61: iload 4
    //   63: if_icmpge +64 -> 127
    //   66: aload_1
    //   67: iload_2
    //   68: invokeinterface 2339 2 0
    //   73: pop
    //   74: new 1552	com/tencent/qqmail/model/qmdomain/Mail
    //   77: dup
    //   78: invokespecial 1604	com/tencent/qqmail/model/qmdomain/Mail:<init>	()V
    //   81: astore 5
    //   83: aload 5
    //   85: new 1609	com/tencent/qqmail/model/qmdomain/MailStatus
    //   88: dup
    //   89: invokespecial 1610	com/tencent/qqmail/model/qmdomain/MailStatus:<init>	()V
    //   92: invokevirtual 1674	com/tencent/qqmail/model/qmdomain/Mail:setStatus	(Lcom/tencent/qqmail/model/qmdomain/MailStatus;)V
    //   95: aload 5
    //   97: new 1606	com/tencent/qqmail/model/qmdomain/MailInformation
    //   100: dup
    //   101: invokespecial 1607	com/tencent/qqmail/model/qmdomain/MailInformation:<init>	()V
    //   104: invokevirtual 1614	com/tencent/qqmail/model/qmdomain/Mail:setInformation	(Lcom/tencent/qqmail/model/qmdomain/MailInformation;)V
    //   107: aload_1
    //   108: aload 5
    //   110: invokestatic 1777	com/tencent/qqmail/model/mail/QMMailSQLite:fillMail	(Landroid/database/Cursor;Lcom/tencent/qqmail/model/qmdomain/Mail;)V
    //   113: aload_3
    //   114: aload 5
    //   116: invokevirtual 1964	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   119: pop
    //   120: iload_2
    //   121: iconst_1
    //   122: iadd
    //   123: istore_2
    //   124: goto -64 -> 60
    //   127: aload_3
    //   128: astore 5
    //   130: aload_1
    //   131: ifnull +12 -> 143
    //   134: aload_1
    //   135: invokeinterface 1577 1 0
    //   140: aload_3
    //   141: astore 5
    //   143: aload 5
    //   145: areturn
    //   146: astore_1
    //   147: aconst_null
    //   148: astore_1
    //   149: aload 5
    //   151: astore_3
    //   152: aload_3
    //   153: astore 5
    //   155: aload_1
    //   156: ifnull -13 -> 143
    //   159: aload_1
    //   160: invokeinterface 1577 1 0
    //   165: aload_3
    //   166: areturn
    //   167: astore_1
    //   168: aconst_null
    //   169: astore 5
    //   171: aload_1
    //   172: astore_3
    //   173: aload 5
    //   175: ifnull +10 -> 185
    //   178: aload 5
    //   180: invokeinterface 1577 1 0
    //   185: aload_3
    //   186: athrow
    //   187: astore_3
    //   188: aload_1
    //   189: astore 5
    //   191: goto -18 -> 173
    //   194: astore_3
    //   195: aload 5
    //   197: astore_3
    //   198: goto -46 -> 152
    //   201: astore 5
    //   203: goto -51 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	QMMailSQLite
    //   0	206	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	206	2	paramInt	int
    //   0	206	3	paramDate	Date
    //   56	8	4	i	int
    //   1	195	5	localObject1	Object
    //   201	1	5	localException	Exception
    //   4	32	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   6	35	146	java/lang/Exception
    //   6	35	167	finally
    //   42	50	187	finally
    //   50	58	187	finally
    //   66	120	187	finally
    //   42	50	194	java/lang/Exception
    //   50	58	201	java/lang/Exception
    //   66	120	201	java/lang/Exception
  }
  
  public Mail getRecentSubscribeMail(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery((querySubscribeMailList + " LIMIT 1 ").replace("$accountId$", "accountId=" + paramInt), new String[0]);
    paramSQLiteDatabase = localObject2;
    if (localCursor != null)
    {
      paramSQLiteDatabase = localObject1;
      if (localCursor.moveToFirst())
      {
        paramSQLiteDatabase = new Mail();
        paramSQLiteDatabase.setStatus(new MailStatus());
        paramSQLiteDatabase.setInformation(new MailInformation());
        fillMail(localCursor, paramSQLiteDatabase);
      }
      localCursor.close();
    }
    return paramSQLiteDatabase;
  }
  
  public String getRemoteIdForLog(SQLiteDatabase paramSQLiteDatabase)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT accountId,folderId,remoteId,id,utcSent,utcReceived FROM QM_MAIL_INFO ORDER BY utcReceived LIMIT 500", null);
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst()) {
        do
        {
          localStringBuilder.append(paramSQLiteDatabase.getInt(0)).append(",").append(paramSQLiteDatabase.getInt(1)).append(",").append(paramSQLiteDatabase.getString(2)).append(",").append(paramSQLiteDatabase.getString(3)).append(",").append(paramSQLiteDatabase.getLong(4)).append(",").append(paramSQLiteDatabase.getLong(5)).append("\n");
        } while (paramSQLiteDatabase.moveToNext());
      }
      paramSQLiteDatabase.close();
    }
    return localStringBuilder.toString();
  }
  
  public String[] getRemoteIds(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong)
  {
    paramSQLiteDatabase = getMailInfoByIds(paramSQLiteDatabase, paramArrayOfLong, "remoteId");
    if (paramSQLiteDatabase == null) {
      return null;
    }
    paramArrayOfLong = new String[paramSQLiteDatabase.length];
    int i = 0;
    while (i < paramSQLiteDatabase.length)
    {
      paramArrayOfLong[i] = ((String)paramSQLiteDatabase[i]);
      i += 1;
    }
    return paramArrayOfLong;
  }
  
  public Cursor getRemoteSearchMails(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    String str = "SELECT $field$ FROM QM_TMP_SEARCH_MAIL_UTC WHERE searchType=" + paramInt;
    return paramSQLiteDatabase.rawQuery("SELECT * FROM (" + "SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId".replace("QM_MAIL_INFO", "QM_TMP_SEARCH_MAIL_INFO") + " WHERE " + "attr" + "&" + 256L + " AND " + "id" + " IN (" + str.replace("$field$", "mailId") + ")) LEFT OUTER JOIN (" + str.replace("$field$", "*") + ") ON " + "id" + "=" + "mailId" + " ORDER BY utcSearch ASC ,utcReceived DESC ", new String[0]);
  }
  
  public Cursor getSearchConvMailList(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    return paramSQLiteDatabase.rawQuery(sqlQueryConvMailInfo.replace("QM_MAIL_INFO", "QM_TMP_SEARCH_MAIL_INFO"), new String[] { String.valueOf(paramLong) });
  }
  
  public Cursor getSearchListCursorByIds(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE id IN $inClause$".replace("$inClause$", getInClause(paramArrayOfLong)));
    if (paramBoolean) {}
    for (paramArrayOfLong = " ORDER BY " + getOrderByIds("id", paramArrayOfLong);; paramArrayOfLong = " ORDER BY utcReceived DESC ") {
      return paramSQLiteDatabase.rawQuery(paramArrayOfLong, null);
    }
  }
  
  /* Error */
  public long[] getSearchMailIds(SQLiteDatabase paramSQLiteDatabase, SearchInfo paramSearchInfo)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: aload_0
    //   10: aload_1
    //   11: aload_2
    //   12: invokespecial 3771	com/tencent/qqmail/model/mail/QMMailSQLite:getLocalSearchMails	(Lcom/tencent/moai/database/sqlite/SQLiteDatabase;Lcom/tencent/qqmail/model/qmdomain/SearchInfo;)Landroid/database/Cursor;
    //   15: astore_1
    //   16: aload 6
    //   18: astore_2
    //   19: aload_1
    //   20: ifnull +75 -> 95
    //   23: aload 5
    //   25: astore 4
    //   27: aload_1
    //   28: invokeinterface 2335 1 0
    //   33: newarray long
    //   35: astore 5
    //   37: iconst_0
    //   38: istore_3
    //   39: aload 5
    //   41: astore_2
    //   42: aload 5
    //   44: astore 4
    //   46: iload_3
    //   47: aload 5
    //   49: arraylength
    //   50: if_icmpge +45 -> 95
    //   53: aload 5
    //   55: astore 4
    //   57: aload_1
    //   58: iload_3
    //   59: invokeinterface 2339 2 0
    //   64: pop
    //   65: aload 5
    //   67: astore 4
    //   69: aload 5
    //   71: iload_3
    //   72: aload_1
    //   73: aload_1
    //   74: ldc_w 939
    //   77: invokeinterface 1972 2 0
    //   82: invokeinterface 1828 2 0
    //   87: lastore
    //   88: iload_3
    //   89: iconst_1
    //   90: iadd
    //   91: istore_3
    //   92: goto -53 -> 39
    //   95: aload_2
    //   96: astore 5
    //   98: aload_1
    //   99: ifnull +12 -> 111
    //   102: aload_1
    //   103: invokeinterface 1577 1 0
    //   108: aload_2
    //   109: astore 5
    //   111: aload 5
    //   113: areturn
    //   114: astore_1
    //   115: aconst_null
    //   116: astore_1
    //   117: aload 4
    //   119: astore 5
    //   121: aload_1
    //   122: ifnull -11 -> 111
    //   125: aload_1
    //   126: invokeinterface 1577 1 0
    //   131: aload 4
    //   133: areturn
    //   134: astore_1
    //   135: aconst_null
    //   136: astore 4
    //   138: aload_1
    //   139: astore_2
    //   140: aload 4
    //   142: ifnull +10 -> 152
    //   145: aload 4
    //   147: invokeinterface 1577 1 0
    //   152: aload_2
    //   153: athrow
    //   154: astore_2
    //   155: aload_1
    //   156: astore 4
    //   158: goto -18 -> 140
    //   161: astore_2
    //   162: goto -45 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	QMMailSQLite
    //   0	165	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	165	2	paramSearchInfo	SearchInfo
    //   38	54	3	i	int
    //   1	156	4	localObject1	Object
    //   4	116	5	localObject2	Object
    //   7	10	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   9	16	114	java/lang/Exception
    //   9	16	134	finally
    //   27	37	154	finally
    //   46	53	154	finally
    //   57	65	154	finally
    //   69	88	154	finally
    //   27	37	161	java/lang/Exception
    //   46	53	161	java/lang/Exception
    //   57	65	161	java/lang/Exception
    //   69	88	161	java/lang/Exception
  }
  
  public long getSearchMailUTC(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString)
  {
    long l1 = 0L;
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT utcSent FROM QM_MAIL_INFO WHERE accountId=? AND remoteId=?".replace("QM_MAIL_INFO", "QM_TMP_SEARCH_MAIL_INFO"), new String[] { String.valueOf(paramInt), paramString });
    long l2 = l1;
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst()) {
        l1 = paramSQLiteDatabase.getLong(0);
      }
      paramSQLiteDatabase.close();
      l2 = l1;
    }
    return l2;
  }
  
  /* Error */
  public long getSinceMailUtc(SQLiteDatabase paramSQLiteDatabase, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: ldc_w 703
    //   7: iconst_2
    //   8: anewarray 829	java/lang/String
    //   11: dup
    //   12: iconst_0
    //   13: iload_2
    //   14: invokestatic 1040	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   17: aastore
    //   18: dup
    //   19: iconst_1
    //   20: lload_3
    //   21: invokestatic 2412	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   24: aastore
    //   25: invokevirtual 1564	com/tencent/moai/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   28: astore_1
    //   29: aload_1
    //   30: ifnull +32 -> 62
    //   33: aload_1
    //   34: invokeinterface 2792 1 0
    //   39: ifeq +23 -> 62
    //   42: aload_1
    //   43: iconst_0
    //   44: invokeinterface 1828 2 0
    //   49: lstore_3
    //   50: aload_1
    //   51: ifnull +9 -> 60
    //   54: aload_1
    //   55: invokeinterface 1577 1 0
    //   60: lload_3
    //   61: lreturn
    //   62: aload_1
    //   63: ifnull +9 -> 72
    //   66: aload_1
    //   67: invokeinterface 1577 1 0
    //   72: lconst_0
    //   73: lreturn
    //   74: astore_1
    //   75: aload 5
    //   77: astore_1
    //   78: aload_1
    //   79: ifnull -7 -> 72
    //   82: aload_1
    //   83: invokeinterface 1577 1 0
    //   88: goto -16 -> 72
    //   91: astore_1
    //   92: aconst_null
    //   93: astore 6
    //   95: aload_1
    //   96: astore 5
    //   98: aload 6
    //   100: ifnull +10 -> 110
    //   103: aload 6
    //   105: invokeinterface 1577 1 0
    //   110: aload 5
    //   112: athrow
    //   113: astore 5
    //   115: aload_1
    //   116: astore 6
    //   118: goto -20 -> 98
    //   121: astore 5
    //   123: goto -45 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	QMMailSQLite
    //   0	126	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	126	2	paramInt	int
    //   0	126	3	paramLong	long
    //   1	110	5	localSQLiteDatabase1	SQLiteDatabase
    //   113	1	5	localObject	Object
    //   121	1	5	localException	Exception
    //   93	24	6	localSQLiteDatabase2	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   3	29	74	java/lang/Exception
    //   3	29	91	finally
    //   33	50	113	finally
    //   33	50	121	java/lang/Exception
  }
  
  @Nullable
  public Mail getSinceQQMail(SQLiteDatabase paramSQLiteDatabase, QMFolder paramQMFolder)
  {
    Object localObject = null;
    paramQMFolder = QMFolderManager.sharedInstance().getFolder(paramQMFolder.getId(), false);
    if (paramQMFolder == null) {
      return null;
    }
    switch (paramQMFolder.getType())
    {
    case 15: 
    default: 
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_MAIL_INFO WHERE folderId=? AND attr&256 AND utcSent>=? ORDER BY utcSent ASC  LIMIT 1", new String[] { String.valueOf(paramQMFolder.getId()), String.valueOf(paramQMFolder.getSince()) });
    }
    while (paramSQLiteDatabase != null)
    {
      paramQMFolder = localObject;
      if (paramSQLiteDatabase.moveToFirst())
      {
        paramQMFolder = new Mail();
        paramQMFolder.setStatus(new MailStatus());
        paramQMFolder.setInformation(new MailInformation());
        fillMail(paramSQLiteDatabase, paramQMFolder);
      }
      paramSQLiteDatabase.close();
      return paramQMFolder;
      int i = QMFolderManager.sharedInstance().getTrashFolderId(paramQMFolder.getAccountId());
      int j = QMFolderManager.sharedInstance().getSpamFolderId(paramQMFolder.getAccountId());
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(sqlQueryQQMailTagSinceMail.replace("$notInFolderInClause$", getInClause(new int[] { i, j })), new String[] { paramQMFolder.getRemoteId(), String.valueOf(paramQMFolder.getAccountId()), String.valueOf(paramQMFolder.getSince()) });
      continue;
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_MAIL_INFO WHERE accountId=? AND isStar=1 AND attr&256 AND utcSent>=? ORDER BY utcSent ASC  LIMIT 1", new String[] { String.valueOf(paramQMFolder.getAccountId()), String.valueOf(paramQMFolder.getSince()) });
      continue;
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT M.* FROM (SELECT DISTINCT convHash FROM QM_MAIL_INFO WHERE fromAddrId IN(SELECT emailHash FROM QM_REF_CONTACT_EMAIL WHERE cid IN (SELECT id FROM QM_CONTACT WHERE vip = 1)) OR id IN (SELECT mid FROM QM_REF_MAIL_ADDR_SENDER WHERE addrId IN(SELECT emailHash FROM QM_REF_CONTACT_EMAIL WHERE cid IN (SELECT id FROM QM_CONTACT WHERE vip = 1)))) AS MI INNER JOIN QM_MAIL_INFO AS M ON MI.convHash=M.convHash WHERE M.accountId=? AND attr&256 AND utcSent>=? ORDER BY utcSent ASC  LIMIT 1", new String[] { String.valueOf(paramQMFolder.getAccountId()), String.valueOf(paramQMFolder.getSince()) });
      continue;
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_MAIL_INFO WHERE accountId=? AND isUnread=1 AND attr&256 AND utcSent>=? ORDER BY utcSent ASC  LIMIT 1", new String[] { String.valueOf(paramQMFolder.getAccountId()), String.valueOf(paramQMFolder.getSince()) });
    }
  }
  
  public Cursor getStarredMailListCursor(SQLiteDatabase paramSQLiteDatabase)
  {
    return paramSQLiteDatabase.rawQuery(sqlQueryStarredMailInfo, null);
  }
  
  public Cursor getStarredMailListCursor(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    int i = QMFolderManager.sharedInstance().getQQMailStarredFolderId(paramInt);
    QMFolder localQMFolder = QMFolderManager.sharedInstance().getFolder(i);
    return paramSQLiteDatabase.rawQuery(sqlQueryStarredMailInfoByAcc, new String[] { String.valueOf(paramInt), String.valueOf(localQMFolder.getSince()) });
  }
  
  public Cursor getSubscribeMailList(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    return paramSQLiteDatabase.rawQuery(querySubscribeMailList.replace("$accountId$", "accountId"), new String[0]);
  }
  
  public ArrayList<Long> getSubscribeMailListIds(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    Object localObject = null;
    ArrayList localArrayList = null;
    Cursor localCursor = getSubscribeMailList(paramSQLiteDatabase, paramInt);
    paramSQLiteDatabase = localObject;
    if (localCursor != null)
    {
      int i = localCursor.getCount();
      paramSQLiteDatabase = localArrayList;
      if (i > 0)
      {
        localArrayList = new ArrayList();
        paramInt = 0;
        for (;;)
        {
          paramSQLiteDatabase = localArrayList;
          if (paramInt >= i) {
            break;
          }
          localCursor.moveToPosition(paramInt);
          localArrayList.add(Long.valueOf(localCursor.getLong(localCursor.getColumnIndex("id"))));
          paramInt += 1;
        }
      }
      localCursor.close();
    }
    return paramSQLiteDatabase;
  }
  
  public Cursor getSubscribeMails(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramInt2 = Math.max(SubscribeMail.LOAD_MORE_PER_COUNT, paramInt2);
    return paramSQLiteDatabase.rawQuery(sqlGetSubscribeCol.replace("$count$", paramInt2 + ""), new String[] { paramInt1 + "", paramInt1 + "" });
  }
  
  public int getSubscribeMailsCnt(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    int j = 0;
    int i = 0;
    paramInt2 = Math.max(SubscribeMail.LOAD_MORE_PER_COUNT, paramInt2);
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(sqlGetSubscribeColCnt.replace("$count$", paramInt2 + ""), new String[] { paramInt1 + "", paramInt1 + "" });
    paramInt1 = j;
    if (paramSQLiteDatabase != null)
    {
      paramInt1 = i;
      if (paramSQLiteDatabase.moveToFirst()) {
        paramInt1 = paramSQLiteDatabase.getInt(0);
      }
      paramSQLiteDatabase.close();
    }
    return paramInt1;
  }
  
  public long[] getSubscribesByStarStat(SQLiteDatabase paramSQLiteDatabase, int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("isStar");
    if (paramBoolean) {}
    for (String str = "=1 ";; str = "=0 ") {
      return getSubscribesByStat(paramSQLiteDatabase, paramInt, str);
    }
  }
  
  public int[] getSvrCountInPopMail(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3 = String.valueOf(paramInt);
    localObject3 = paramSQLiteDatabase.rawQuery("SELECT (SELECT COUNT(*) FROM QM_MAIL_INFO WHERE isUnread = 1 AND accountId=?), (SELECT COUNT(*) FROM QM_MAIL_INFO WHERE accountId=?)", new String[] { localObject3, localObject3 });
    paramSQLiteDatabase = localObject2;
    if (localObject3 != null)
    {
      paramSQLiteDatabase = localObject1;
      if (((Cursor)localObject3).getCount() > 0)
      {
        ((Cursor)localObject3).moveToFirst();
        paramSQLiteDatabase = new int[2];
        paramSQLiteDatabase[0] = ((Cursor)localObject3).getInt(0);
        paramSQLiteDatabase[1] = ((Cursor)localObject3).getInt(1);
      }
      ((Cursor)localObject3).close();
    }
    return paramSQLiteDatabase;
  }
  
  public Cursor getSyncAccountCursor(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    return paramSQLiteDatabase.rawQuery("SELECT id,folderId,remoteId,abstract,attr,size FROM QM_MAIL_INFO WHERE accountId= ? AND attr&256 GROUP BY id ORDER BY utcSent DESC ", new String[] { String.valueOf(paramInt) });
  }
  
  public Date getSyncDate(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT utcSent FROM QM_MAIL_INFO AS M WHERE accountId=? AND attr&256 ORDER BY utcSent DESC  LIMIT 1", new String[] { String.valueOf(paramInt) });
    paramSQLiteDatabase = localObject2;
    if (localCursor != null) {
      if (!localCursor.moveToFirst()) {
        break label68;
      }
    }
    for (paramSQLiteDatabase = new Date(localCursor.getLong(0));; paramSQLiteDatabase = localObject1)
    {
      localCursor.close();
      return paramSQLiteDatabase;
      label68:
      QMLog.log(6, "QMMailSQLite", "getSyncDate no mail need sync:" + paramInt);
    }
  }
  
  public Cursor getSyncFolderCursor(SQLiteDatabase paramSQLiteDatabase, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt2 <= 0) {
      i = 500;
    }
    QMFolder localQMFolder = QMFolderManager.sharedInstance().getFolder(paramInt1);
    if (localQMFolder == null) {
      return null;
    }
    paramInt2 = localQMFolder.getAccountId();
    Object localObject2;
    long l;
    if (localQMFolder.getType() == 14)
    {
      paramInt1 = QMFolderManager.sharedInstance().getTrashFolderId(paramInt2);
      int j = QMFolderManager.sharedInstance().getSpamFolderId(paramInt2);
      localObject1 = sqlQueryTagSyncMailList.replace("$notInFolderInClause$", getInClause(new int[] { paramInt1, j })) + " LIMIT " + i;
      localObject2 = localQMFolder.getRemoteId();
      l = localQMFolder.getSince();
      localObject2 = new String[] { localObject2, String.valueOf(paramInt2), String.valueOf(l) };
      if (!paramBoolean) {
        break label493;
      }
    }
    label493:
    for (Object localObject1 = ((String)localObject1).replace("$selectClause$", "id,folderId,remoteId,abstract,attr,size");; localObject1 = ((String)localObject1).replace("$selectClause$", "id,remoteId,utcReceived,convCnt,tags,isUnread,isStar,attr,convType,accountId"))
    {
      return paramSQLiteDatabase.rawQuery((String)localObject1, (String[])localObject2);
      if (localQMFolder.getType() == 16)
      {
        localObject1 = sqlQueryStarredSyncMailList + " LIMIT " + i;
        l = localQMFolder.getSince();
        localObject2 = new String[] { String.valueOf(paramInt2), String.valueOf(l) };
        break;
      }
      if (localQMFolder.getType() == 18)
      {
        localObject1 = sqlQueryUnreadSyncMailList + " LIMIT " + i;
        l = localQMFolder.getSince();
        localObject2 = new String[] { String.valueOf(paramInt2), String.valueOf(l) };
        break;
      }
      if (localQMFolder.getType() == 17)
      {
        localObject1 = sqlQueryVipSyncMailList + " LIMIT " + i;
        l = localQMFolder.getSince();
        localObject2 = new String[] { String.valueOf(paramInt2), String.valueOf(l) };
        break;
      }
      localObject2 = "SELECT $selectClause$ FROM QM_MAIL_INFO WHERE folderId= ? AND attr&256 AND utcSent>=? ORDER BY utcSent DESC ";
      Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt2);
      localObject1 = localObject2;
      if (localAccount != null)
      {
        localObject1 = localObject2;
        if (localAccount.isQQMail()) {
          localObject1 = "SELECT $selectClause$ FROM QM_MAIL_INFO WHERE folderId= ? AND attr&256 AND utcSent>=? ORDER BY utcSent DESC " + " LIMIT " + i;
        }
      }
      localObject2 = new String[2];
      localObject2[0] = String.valueOf(paramInt1);
      localObject2[1] = String.valueOf(localQMFolder.getSince());
      break;
    }
  }
  
  public ArrayList<Mail> getUnCheckMails(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if (paramInt != 0) {
      localObject = "M.accountId=" + paramInt;
    }
    for (;;)
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE $accountId$  AND (attr&1024 AND  NOT attr&65536 ) ORDER BY utcReceived DESC ".replace("$accountId$", (CharSequence)localObject), new String[0]);
      if (paramSQLiteDatabase != null)
      {
        int i = paramSQLiteDatabase.getCount();
        paramInt = 0;
        label68:
        if (paramInt < i)
        {
          paramSQLiteDatabase.moveToPosition(paramInt);
          localObject = new Mail();
          ((Mail)localObject).setStatus(new MailStatus());
          ((Mail)localObject).setInformation(new MailInformation());
        }
      }
      try
      {
        fillMail(paramSQLiteDatabase, (Mail)localObject);
        localArrayList.add(localObject);
        label128:
        paramInt += 1;
        break label68;
        localObject = "1=1";
        continue;
        paramSQLiteDatabase.close();
        return localArrayList;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        break label128;
      }
    }
  }
  
  public Cursor getUnloadSubscribeMails(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    String str2 = "SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE M.id IN ( SELECT id FROM QM_MAIL_INFO AS N WHERE $accountId$ AND  attr&4096  AND " + " EXISTS (SELECT id,type FROM QM_FOLDER AS FD  WHERE FD.id=$alias$.folderId AND FD.type=15)".replace("$alias$", "N") + " ORDER BY utcReceived DESC, colid ASC " + " LIMIT " + paramInt2 + ") AND " + " NOT  attr&262144 " + " ORDER BY utcReceived DESC, colid ASC ";
    if (paramInt1 != 0) {}
    for (String str1 = "accountId=" + paramInt1;; str1 = "1=1") {
      return paramSQLiteDatabase.rawQuery(str2.replace("$accountId$", str1), new String[0]);
    }
  }
  
  public long[] getUnreadMailIdByAccount(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT id FROM QM_MAIL_INFO WHERE accountId IN " + getInClause(paramArrayOfInt) + " AND " + "isUnread" + "=1", null);
    paramSQLiteDatabase = localObject2;
    if (localCursor != null)
    {
      int j = localCursor.getCount();
      paramSQLiteDatabase = localObject1;
      if (j > 0)
      {
        paramArrayOfInt = new long[j];
        int i = 0;
        for (;;)
        {
          paramSQLiteDatabase = paramArrayOfInt;
          if (i >= j) {
            break;
          }
          localCursor.moveToPosition(i);
          paramArrayOfInt[i] = localCursor.getLong(0);
          i += 1;
        }
      }
      localCursor.close();
    }
    paramArrayOfInt = paramSQLiteDatabase;
    if (paramSQLiteDatabase == null) {
      paramArrayOfInt = new long[0];
    }
    return paramArrayOfInt;
  }
  
  public Cursor getUnreadedMailListCursor(SQLiteDatabase paramSQLiteDatabase)
  {
    int[] arrayOfInt = AccountManager.shareInstance().getAccountList().getAllGMailAccountIds();
    return paramSQLiteDatabase.rawQuery(sqlQueryUnreadrdMailInfo.replace("$inClause$", getInClause(arrayOfInt)), null);
  }
  
  public Cursor getVipMailListCursor(SQLiteDatabase paramSQLiteDatabase)
  {
    return paramSQLiteDatabase.rawQuery(sqlQueryVipMailInfo, null);
  }
  
  /* Error */
  public void groupMailIdsInAccount(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong, GroupMailAccountWatcher paramGroupMailAccountWatcher)
  {
    // Byte code:
    //   0: new 3274	android/util/SparseArray
    //   3: dup
    //   4: invokespecial 3275	android/util/SparseArray:<init>	()V
    //   7: astore 23
    //   9: new 3274	android/util/SparseArray
    //   12: dup
    //   13: invokespecial 3275	android/util/SparseArray:<init>	()V
    //   16: astore 24
    //   18: new 3274	android/util/SparseArray
    //   21: dup
    //   22: invokespecial 3275	android/util/SparseArray:<init>	()V
    //   25: astore 25
    //   27: new 3835	android/util/SparseBooleanArray
    //   30: dup
    //   31: invokespecial 3836	android/util/SparseBooleanArray:<init>	()V
    //   34: astore 26
    //   36: new 3835	android/util/SparseBooleanArray
    //   39: dup
    //   40: invokespecial 3836	android/util/SparseBooleanArray:<init>	()V
    //   43: astore 27
    //   45: aconst_null
    //   46: astore 21
    //   48: aload_1
    //   49: ldc_w 592
    //   52: ldc_w 1036
    //   55: aload_0
    //   56: aload_2
    //   57: invokevirtual 2658	com/tencent/qqmail/model/mail/QMMailSQLite:getInClause	([J)Ljava/lang/String;
    //   60: invokevirtual 833	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   63: aconst_null
    //   64: invokevirtual 1564	com/tencent/moai/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   67: astore 20
    //   69: aload 20
    //   71: ifnull +17 -> 88
    //   74: aload 20
    //   76: astore 21
    //   78: aload 20
    //   80: invokeinterface 2335 1 0
    //   85: ifgt +957 -> 1042
    //   88: aload 20
    //   90: astore 21
    //   92: aload_1
    //   93: ldc_w 592
    //   96: ldc_w 1220
    //   99: ldc_w 1341
    //   102: invokevirtual 833	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   105: ldc_w 1036
    //   108: aload_0
    //   109: aload_2
    //   110: invokevirtual 2658	com/tencent/qqmail/model/mail/QMMailSQLite:getInClause	([J)Ljava/lang/String;
    //   113: invokevirtual 833	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   116: aconst_null
    //   117: invokevirtual 1564	com/tencent/moai/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   120: astore_1
    //   121: aload_1
    //   122: ifnull +867 -> 989
    //   125: aload_1
    //   126: ldc_w 1830
    //   129: invokeinterface 1972 2 0
    //   134: istore 8
    //   136: aload_1
    //   137: ldc_w 1874
    //   140: invokeinterface 1972 2 0
    //   145: istore 9
    //   147: aload_1
    //   148: ldc_w 947
    //   151: invokeinterface 1972 2 0
    //   156: istore 10
    //   158: aload_1
    //   159: ldc_w 921
    //   162: invokeinterface 1972 2 0
    //   167: istore 11
    //   169: aload_1
    //   170: ldc_w 939
    //   173: invokeinterface 1972 2 0
    //   178: istore 12
    //   180: aload_1
    //   181: ldc_w 896
    //   184: invokeinterface 1972 2 0
    //   189: istore 13
    //   191: aload_1
    //   192: ldc_w 913
    //   195: invokeinterface 1972 2 0
    //   200: istore 14
    //   202: new 3835	android/util/SparseBooleanArray
    //   205: dup
    //   206: invokespecial 3836	android/util/SparseBooleanArray:<init>	()V
    //   209: astore 28
    //   211: aload_1
    //   212: invokeinterface 1570 1 0
    //   217: ifeq +847 -> 1064
    //   220: aload_1
    //   221: iload 12
    //   223: invokeinterface 1828 2 0
    //   228: lstore 17
    //   230: aload_1
    //   231: iload 10
    //   233: invokeinterface 1574 2 0
    //   238: istore 15
    //   240: aload_1
    //   241: iload 11
    //   243: invokeinterface 1574 2 0
    //   248: istore 16
    //   250: aload_1
    //   251: iload 8
    //   253: invokeinterface 1833 2 0
    //   258: astore 29
    //   260: aload_1
    //   261: iload 9
    //   263: invokeinterface 1833 2 0
    //   268: astore 21
    //   270: aload_1
    //   271: iload 14
    //   273: invokeinterface 1574 2 0
    //   278: istore 4
    //   280: aload 28
    //   282: iload 15
    //   284: invokevirtual 3839	android/util/SparseBooleanArray:indexOfKey	(I)I
    //   287: ifge +18 -> 305
    //   290: aload 28
    //   292: iload 15
    //   294: aload_3
    //   295: iload 15
    //   297: invokeinterface 3843 2 0
    //   302: invokevirtual 3845	android/util/SparseBooleanArray:put	(IZ)V
    //   305: aload_3
    //   306: iload 15
    //   308: invokeinterface 3843 2 0
    //   313: istore 19
    //   315: aload 28
    //   317: iload 15
    //   319: invokevirtual 3847	android/util/SparseBooleanArray:get	(I)Z
    //   322: ifeq +748 -> 1070
    //   325: iload 4
    //   327: iconst_m1
    //   328: if_icmpne +742 -> 1070
    //   331: iconst_1
    //   332: istore 4
    //   334: aload_1
    //   335: iload 13
    //   337: invokeinterface 1574 2 0
    //   342: i2l
    //   343: ldc2_w 903
    //   346: land
    //   347: lconst_0
    //   348: lcmp
    //   349: ifeq +727 -> 1076
    //   352: iconst_1
    //   353: istore 6
    //   355: aload_1
    //   356: iload 13
    //   358: invokeinterface 1574 2 0
    //   363: i2l
    //   364: ldc2_w 1057
    //   367: land
    //   368: lconst_0
    //   369: lcmp
    //   370: ifeq +712 -> 1082
    //   373: iconst_1
    //   374: istore 5
    //   376: aload_1
    //   377: iload 13
    //   379: invokeinterface 1574 2 0
    //   384: i2l
    //   385: ldc2_w 1059
    //   388: land
    //   389: lconst_0
    //   390: lcmp
    //   391: ifeq +697 -> 1088
    //   394: iconst_1
    //   395: istore 7
    //   397: goto +651 -> 1048
    //   400: iload 5
    //   402: ifeq +67 -> 469
    //   405: aload 26
    //   407: iload 15
    //   409: iload 19
    //   411: invokevirtual 3845	android/util/SparseBooleanArray:put	(IZ)V
    //   414: aload_1
    //   415: invokeinterface 2792 1 0
    //   420: ifne -200 -> 220
    //   423: goto +641 -> 1064
    //   426: iload 4
    //   428: aload 26
    //   430: invokevirtual 3848	android/util/SparseBooleanArray:size	()I
    //   433: if_icmpge +290 -> 723
    //   436: aload 26
    //   438: iload 4
    //   440: invokevirtual 3851	android/util/SparseBooleanArray:keyAt	(I)I
    //   443: istore 5
    //   445: aload_3
    //   446: iload 5
    //   448: aload 26
    //   450: iload 5
    //   452: invokevirtual 3847	android/util/SparseBooleanArray:get	(I)Z
    //   455: invokeinterface 3854 3 0
    //   460: iload 4
    //   462: iconst_1
    //   463: iadd
    //   464: istore 4
    //   466: goto -40 -> 426
    //   469: iload 7
    //   471: ifeq +27 -> 498
    //   474: aload 27
    //   476: iload 15
    //   478: iload 19
    //   480: invokevirtual 3845	android/util/SparseBooleanArray:put	(IZ)V
    //   483: goto -69 -> 414
    //   486: astore_2
    //   487: aload_1
    //   488: ifnull +9 -> 497
    //   491: aload_1
    //   492: invokeinterface 1577 1 0
    //   497: return
    //   498: aload 25
    //   500: iload 15
    //   502: invokevirtual 3855	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   505: checkcast 3017	java/util/HashSet
    //   508: astore 20
    //   510: aload 20
    //   512: astore_2
    //   513: aload 20
    //   515: ifnonnull +19 -> 534
    //   518: new 3017	java/util/HashSet
    //   521: dup
    //   522: invokespecial 3018	java/util/HashSet:<init>	()V
    //   525: astore_2
    //   526: aload 25
    //   528: iload 15
    //   530: aload_2
    //   531: invokevirtual 3278	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   534: aload_2
    //   535: lload 17
    //   537: invokestatic 2883	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   540: invokevirtual 3020	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   543: pop
    //   544: aload 23
    //   546: iload 15
    //   548: invokevirtual 3855	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   551: checkcast 3274	android/util/SparseArray
    //   554: astore_2
    //   555: aload_2
    //   556: ifnonnull +483 -> 1039
    //   559: new 3274	android/util/SparseArray
    //   562: dup
    //   563: invokespecial 3275	android/util/SparseArray:<init>	()V
    //   566: astore_2
    //   567: aload 23
    //   569: iload 15
    //   571: aload_2
    //   572: invokevirtual 3278	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   575: aload_2
    //   576: iload 16
    //   578: invokevirtual 3855	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   581: checkcast 1948	java/util/ArrayList
    //   584: astore 20
    //   586: aload 20
    //   588: ifnonnull +445 -> 1033
    //   591: new 1948	java/util/ArrayList
    //   594: dup
    //   595: invokespecial 1949	java/util/ArrayList:<init>	()V
    //   598: astore 20
    //   600: aload_2
    //   601: iload 16
    //   603: aload 20
    //   605: invokevirtual 3278	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   608: aload 20
    //   610: astore_2
    //   611: aload 24
    //   613: iload 15
    //   615: invokevirtual 3855	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   618: checkcast 3274	android/util/SparseArray
    //   621: astore 20
    //   623: aload 20
    //   625: ifnonnull +405 -> 1030
    //   628: new 3274	android/util/SparseArray
    //   631: dup
    //   632: invokespecial 3275	android/util/SparseArray:<init>	()V
    //   635: astore 20
    //   637: aload 24
    //   639: iload 15
    //   641: aload 20
    //   643: invokevirtual 3278	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   646: aload 20
    //   648: iload 16
    //   650: invokevirtual 3855	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   653: checkcast 1948	java/util/ArrayList
    //   656: astore 22
    //   658: aload 22
    //   660: ifnonnull +363 -> 1023
    //   663: new 1948	java/util/ArrayList
    //   666: dup
    //   667: invokespecial 1949	java/util/ArrayList:<init>	()V
    //   670: astore 22
    //   672: aload 20
    //   674: iload 16
    //   676: aload 22
    //   678: invokevirtual 3278	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   681: aload 22
    //   683: astore 20
    //   685: goto +415 -> 1100
    //   688: aload_2
    //   689: aload 29
    //   691: invokevirtual 1964	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   694: pop
    //   695: aload 20
    //   697: aload 21
    //   699: invokevirtual 1964	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   702: pop
    //   703: goto -289 -> 414
    //   706: astore_3
    //   707: aload_1
    //   708: astore_2
    //   709: aload_3
    //   710: astore_1
    //   711: aload_2
    //   712: ifnull +9 -> 721
    //   715: aload_2
    //   716: invokeinterface 1577 1 0
    //   721: aload_1
    //   722: athrow
    //   723: iconst_0
    //   724: istore 4
    //   726: iload 4
    //   728: aload 27
    //   730: invokevirtual 3848	android/util/SparseBooleanArray:size	()I
    //   733: if_icmpge +390 -> 1123
    //   736: aload 27
    //   738: iload 4
    //   740: invokevirtual 3851	android/util/SparseBooleanArray:keyAt	(I)I
    //   743: istore 5
    //   745: aload_3
    //   746: iload 5
    //   748: aload 27
    //   750: iload 5
    //   752: invokevirtual 3847	android/util/SparseBooleanArray:get	(I)Z
    //   755: invokeinterface 3858 3 0
    //   760: iload 4
    //   762: iconst_1
    //   763: iadd
    //   764: istore 4
    //   766: goto -40 -> 726
    //   769: iload 4
    //   771: aload 25
    //   773: invokevirtual 3859	android/util/SparseArray:size	()I
    //   776: if_icmpge +201 -> 977
    //   779: aload 25
    //   781: iload 4
    //   783: invokevirtual 3860	android/util/SparseArray:keyAt	(I)I
    //   786: istore 6
    //   788: aload_3
    //   789: iload 6
    //   791: invokeinterface 3843 2 0
    //   796: istore 19
    //   798: aload 25
    //   800: iload 6
    //   802: invokevirtual 3855	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   805: checkcast 3017	java/util/HashSet
    //   808: astore_2
    //   809: aload_2
    //   810: invokevirtual 3861	java/util/HashSet:size	()I
    //   813: ifle +33 -> 846
    //   816: aload_3
    //   817: iload 6
    //   819: iload 19
    //   821: aload_2
    //   822: invokevirtual 3864	java/util/HashSet:toArray	()[Ljava/lang/Object;
    //   825: aload_2
    //   826: invokevirtual 3861	java/util/HashSet:size	()I
    //   829: ldc_w 3866
    //   832: invokestatic 3870	java/util/Arrays:copyOf	([Ljava/lang/Object;ILjava/lang/Class;)[Ljava/lang/Object;
    //   835: checkcast 3866	[Ljava/lang/Long;
    //   838: invokestatic 3876	org/apache/commons/lang3/ArrayUtils:toPrimitive	([Ljava/lang/Long;)[J
    //   841: invokeinterface 3880 4 0
    //   846: aload 23
    //   848: iload 6
    //   850: invokevirtual 3855	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   853: checkcast 3274	android/util/SparseArray
    //   856: astore_2
    //   857: iconst_0
    //   858: istore 5
    //   860: iload 5
    //   862: aload_2
    //   863: invokevirtual 3859	android/util/SparseArray:size	()I
    //   866: if_icmpge +272 -> 1138
    //   869: aload_2
    //   870: iload 5
    //   872: invokevirtual 3860	android/util/SparseArray:keyAt	(I)I
    //   875: istore 7
    //   877: new 1948	java/util/ArrayList
    //   880: dup
    //   881: invokespecial 1949	java/util/ArrayList:<init>	()V
    //   884: astore 20
    //   886: aload 20
    //   888: aload_2
    //   889: iload 7
    //   891: invokevirtual 3855	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   894: checkcast 3882	java/util/Collection
    //   897: invokeinterface 3886 2 0
    //   902: pop
    //   903: new 1948	java/util/ArrayList
    //   906: dup
    //   907: invokespecial 1949	java/util/ArrayList:<init>	()V
    //   910: astore 21
    //   912: aload 21
    //   914: aload 24
    //   916: iload 6
    //   918: invokevirtual 3855	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   921: checkcast 3274	android/util/SparseArray
    //   924: iload 7
    //   926: invokevirtual 3855	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   929: checkcast 3882	java/util/Collection
    //   932: invokeinterface 3886 2 0
    //   937: pop
    //   938: aload 20
    //   940: invokeinterface 3887 1 0
    //   945: ifgt +13 -> 958
    //   948: aload 21
    //   950: invokeinterface 3887 1 0
    //   955: ifle +174 -> 1129
    //   958: aload_3
    //   959: iload 6
    //   961: iload 7
    //   963: iload 19
    //   965: aload 20
    //   967: aload 21
    //   969: invokeinterface 3891 6 0
    //   974: goto +155 -> 1129
    //   977: aload_3
    //   978: invokeinterface 3894 1 0
    //   983: invokestatic 3900	com/tencent/qqmail/utilities/badge/BadgeUtil:getInstance	()Lcom/tencent/qqmail/utilities/badge/BadgeUtil;
    //   986: invokevirtual 3903	com/tencent/qqmail/utilities/badge/BadgeUtil:setBadgeAccordingQMAccount	()V
    //   989: aload_1
    //   990: ifnull -493 -> 497
    //   993: aload_1
    //   994: invokeinterface 1577 1 0
    //   999: return
    //   1000: astore_1
    //   1001: aconst_null
    //   1002: astore_2
    //   1003: goto -292 -> 711
    //   1006: astore_1
    //   1007: aload 20
    //   1009: astore_2
    //   1010: goto -299 -> 711
    //   1013: astore_1
    //   1014: aload 21
    //   1016: astore_1
    //   1017: goto -530 -> 487
    //   1020: goto -332 -> 688
    //   1023: aload 22
    //   1025: astore 20
    //   1027: goto +73 -> 1100
    //   1030: goto -384 -> 646
    //   1033: aload 20
    //   1035: astore_2
    //   1036: goto -425 -> 611
    //   1039: goto -464 -> 575
    //   1042: aload 20
    //   1044: astore_1
    //   1045: goto -924 -> 121
    //   1048: iload 4
    //   1050: ifne +8 -> 1058
    //   1053: iload 6
    //   1055: ifeq +39 -> 1094
    //   1058: iconst_1
    //   1059: istore 4
    //   1061: goto -661 -> 400
    //   1064: iconst_0
    //   1065: istore 4
    //   1067: goto -641 -> 426
    //   1070: iconst_0
    //   1071: istore 4
    //   1073: goto -739 -> 334
    //   1076: iconst_0
    //   1077: istore 6
    //   1079: goto -724 -> 355
    //   1082: iconst_0
    //   1083: istore 5
    //   1085: goto -709 -> 376
    //   1088: iconst_0
    //   1089: istore 7
    //   1091: goto -43 -> 1048
    //   1094: iconst_0
    //   1095: istore 4
    //   1097: goto -697 -> 400
    //   1100: aload 29
    //   1102: ifnull -688 -> 414
    //   1105: iload 4
    //   1107: ifeq -693 -> 414
    //   1110: aload 21
    //   1112: ifnonnull -92 -> 1020
    //   1115: ldc_w 1264
    //   1118: astore 21
    //   1120: goto -432 -> 688
    //   1123: iconst_0
    //   1124: istore 4
    //   1126: goto -357 -> 769
    //   1129: iload 5
    //   1131: iconst_1
    //   1132: iadd
    //   1133: istore 5
    //   1135: goto -275 -> 860
    //   1138: iload 4
    //   1140: iconst_1
    //   1141: iadd
    //   1142: istore 4
    //   1144: goto -375 -> 769
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1147	0	this	QMMailSQLite
    //   0	1147	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	1147	2	paramArrayOfLong	long[]
    //   0	1147	3	paramGroupMailAccountWatcher	GroupMailAccountWatcher
    //   278	865	4	i	int
    //   374	760	5	j	int
    //   353	725	6	k	int
    //   395	695	7	m	int
    //   134	118	8	n	int
    //   145	117	9	i1	int
    //   156	76	10	i2	int
    //   167	75	11	i3	int
    //   178	44	12	i4	int
    //   189	189	13	i5	int
    //   200	72	14	i6	int
    //   238	402	15	i7	int
    //   248	427	16	i8	int
    //   228	308	17	l	long
    //   313	651	19	bool	boolean
    //   67	976	20	localObject1	Object
    //   46	1073	21	localObject2	Object
    //   656	368	22	localArrayList	ArrayList
    //   7	840	23	localSparseArray1	SparseArray
    //   16	899	24	localSparseArray2	SparseArray
    //   25	774	25	localSparseArray3	SparseArray
    //   34	415	26	localSparseBooleanArray1	android.util.SparseBooleanArray
    //   43	706	27	localSparseBooleanArray2	android.util.SparseBooleanArray
    //   209	107	28	localSparseBooleanArray3	android.util.SparseBooleanArray
    //   258	843	29	str	String
    // Exception table:
    //   from	to	target	type
    //   125	220	486	java/lang/Exception
    //   220	305	486	java/lang/Exception
    //   305	325	486	java/lang/Exception
    //   334	352	486	java/lang/Exception
    //   355	373	486	java/lang/Exception
    //   376	394	486	java/lang/Exception
    //   405	414	486	java/lang/Exception
    //   414	423	486	java/lang/Exception
    //   426	460	486	java/lang/Exception
    //   474	483	486	java/lang/Exception
    //   498	510	486	java/lang/Exception
    //   518	534	486	java/lang/Exception
    //   534	555	486	java/lang/Exception
    //   559	575	486	java/lang/Exception
    //   575	586	486	java/lang/Exception
    //   591	608	486	java/lang/Exception
    //   611	623	486	java/lang/Exception
    //   628	646	486	java/lang/Exception
    //   646	658	486	java/lang/Exception
    //   663	681	486	java/lang/Exception
    //   688	703	486	java/lang/Exception
    //   726	760	486	java/lang/Exception
    //   769	846	486	java/lang/Exception
    //   846	857	486	java/lang/Exception
    //   860	958	486	java/lang/Exception
    //   958	974	486	java/lang/Exception
    //   977	989	486	java/lang/Exception
    //   125	220	706	finally
    //   220	305	706	finally
    //   305	325	706	finally
    //   334	352	706	finally
    //   355	373	706	finally
    //   376	394	706	finally
    //   405	414	706	finally
    //   414	423	706	finally
    //   426	460	706	finally
    //   474	483	706	finally
    //   498	510	706	finally
    //   518	534	706	finally
    //   534	555	706	finally
    //   559	575	706	finally
    //   575	586	706	finally
    //   591	608	706	finally
    //   611	623	706	finally
    //   628	646	706	finally
    //   646	658	706	finally
    //   663	681	706	finally
    //   688	703	706	finally
    //   726	760	706	finally
    //   769	846	706	finally
    //   846	857	706	finally
    //   860	958	706	finally
    //   958	974	706	finally
    //   977	989	706	finally
    //   48	69	1000	finally
    //   78	88	1006	finally
    //   92	121	1006	finally
    //   48	69	1013	java/lang/Exception
    //   78	88	1013	java/lang/Exception
    //   92	121	1013	java/lang/Exception
  }
  
  public boolean hasMailContent(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    boolean bool = true;
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT COUNT(id) FROM QM_MAIL_CONTENT WHERE id=?", new String[] { paramLong + "" });
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst()) {
        if (paramSQLiteDatabase.getInt(0) <= 0) {}
      }
      for (;;)
      {
        paramSQLiteDatabase.close();
        return bool;
        bool = false;
        continue;
        bool = false;
      }
    }
    return false;
  }
  
  public boolean hasMailPartInfo(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    boolean bool = true;
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT id FROM QM_MAIL_PART_INFO WHERE mid=?", new String[] { String.valueOf(paramLong) });
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.getCount() > 0) {}
      for (;;)
      {
        paramSQLiteDatabase.close();
        return bool;
        bool = false;
      }
    }
    return false;
  }
  
  public boolean hasVip(SQLiteDatabase paramSQLiteDatabase)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT COUNT(*) FROM QM_CONTACT WHERE vip=1", null);
    if (paramSQLiteDatabase != null)
    {
      bool1 = bool2;
      if (paramSQLiteDatabase.moveToFirst())
      {
        bool1 = bool2;
        if (paramSQLiteDatabase.getInt(0) > 0) {
          bool1 = true;
        }
      }
      paramSQLiteDatabase.close();
    }
    return bool1;
  }
  
  public void initSubUnreadCache(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    int i = checkAggregateConvHasUnread(paramSQLiteDatabase, paramInt, 8192L);
    paramSQLiteDatabase = QMAggrConvMailCache.sharedInstance();
    if (i > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramSQLiteDatabase.ensureUnreadIndexes(paramInt, bool);
      return;
    }
  }
  
  public void insertIcsEvent(SQLiteDatabase paramSQLiteDatabase, QMCalendarEvent paramQMCalendarEvent, String paramString)
  {
    int j = 1;
    long l1;
    int k;
    int m;
    String str1;
    int n;
    String str2;
    String str3;
    String str4;
    int i;
    int i1;
    String str5;
    long l2;
    long l3;
    long l4;
    long l5;
    String str6;
    String str7;
    String str8;
    int i2;
    int i3;
    long l6;
    int i4;
    int i5;
    int i6;
    int i7;
    String str9;
    int i8;
    String str10;
    String str11;
    int i9;
    int i10;
    String str12;
    if (paramQMCalendarEvent != null)
    {
      l1 = paramQMCalendarEvent.getId();
      k = paramQMCalendarEvent.getAccountId();
      m = paramQMCalendarEvent.getCalderFolderId();
      str1 = paramQMCalendarEvent.getUid();
      n = paramQMCalendarEvent.getReminder();
      str2 = paramQMCalendarEvent.getSubject();
      str3 = paramQMCalendarEvent.getLocation();
      str4 = paramQMCalendarEvent.getBody();
      if (!paramQMCalendarEvent.isAllDay()) {
        break label526;
      }
      i = 1;
      i1 = paramQMCalendarEvent.getSensivity();
      str5 = paramQMCalendarEvent.getTimezone();
      l2 = paramQMCalendarEvent.getStartTime();
      l3 = paramQMCalendarEvent.getEndTime();
      l4 = paramQMCalendarEvent.getCreateTime();
      l5 = paramQMCalendarEvent.getModifyTime();
      str6 = paramQMCalendarEvent.getPath();
      str7 = paramQMCalendarEvent.geteTag();
      str8 = paramQMCalendarEvent.getSvrId();
      i2 = paramQMCalendarEvent.getRecurrenceType();
      i3 = paramQMCalendarEvent.getInterval();
      l6 = paramQMCalendarEvent.getUntil();
      i4 = paramQMCalendarEvent.getWeekOfMonth();
      i5 = paramQMCalendarEvent.getDayOfWeek();
      i6 = paramQMCalendarEvent.getMonthOfYear();
      i7 = paramQMCalendarEvent.getDayOfMonth();
      str9 = paramQMCalendarEvent.getRelatedId();
      i8 = paramQMCalendarEvent.getRelateType();
      str10 = paramQMCalendarEvent.getOrganizerName();
      str11 = paramQMCalendarEvent.getOrganizerEmail();
      i9 = paramQMCalendarEvent.getResponseType();
      i10 = paramQMCalendarEvent.getMeetingStatus();
      str12 = Attendee.genertateAttendeeToString(paramQMCalendarEvent.getAttendees());
      if (!paramQMCalendarEvent.isDecline()) {
        break label532;
      }
    }
    for (;;)
    {
      paramSQLiteDatabase.execSQL("REPLACE INTO QM_ICS_EVENT ( id , accountId , folderId , uid , reminder , subject , location , body , bodyType , allday , sensitivity , timezone , startTime , endTime , createTime , modifyTime , path , etag , serverId , folderType , recurrenceType , calendarType , interval , until , weekOfMonth , dayOfWeek , monthOfYear , dayOfMonth , isLeapMonth , firstDayOfWeek , relateId , relateType , organizerName , organizerEmail ,responseType , meeting_status , attendee , isDecline , mailId ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new Object[] { Long.valueOf(l1), Integer.valueOf(k), Integer.valueOf(m), str1, Integer.valueOf(n), str2, str3, str4, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(i1), str5, Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l5), str6, str7, str8, Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(i3), Long.valueOf(l6), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(0), Integer.valueOf(0), str9, Integer.valueOf(i8), str10, str11, Integer.valueOf(i9), Integer.valueOf(i10), str12, Integer.valueOf(j), paramString });
      return;
      label526:
      i = 0;
      break;
      label532:
      j = 0;
    }
  }
  
  public void insertMailContent(SQLiteDatabase paramSQLiteDatabase, long paramLong, String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      insertMailContentFtsBg(paramSQLiteDatabase, paramLong, paramString1);
      paramSQLiteDatabase.execSQL("REPLACE INTO QM_MAIL_CONTENT ( id,content,extra) VALUES (?,?,?)", new Object[] { Long.valueOf(paramLong), paramString1, paramString2 });
      paramSQLiteDatabase.delete("QM_MAIL_CONTENT_SCALE", "mailId=?", new String[] { String.valueOf(paramLong) });
    }
  }
  
  public void insertMailContentFtsBg(SQLiteDatabase paramSQLiteDatabase, long paramLong, String paramString)
  {
    Threads.runInBackground(new QMMailSQLite.2(this, paramString, paramSQLiteDatabase, paramLong));
  }
  
  public void insertMailContentScale(SQLiteDatabase paramSQLiteDatabase, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramString1 != null) {
      paramSQLiteDatabase.execSQL("REPLACE INTO QM_MAIL_CONTENT_SCALE ( id,mailId,type,content) VALUES (?,?,?,?)", new Object[] { Integer.valueOf(QMMath.hashInt("v" + paramLong)), Long.valueOf(paramLong), Integer.valueOf(0), paramString1 });
    }
    if (paramString2 != null) {
      paramSQLiteDatabase.execSQL("REPLACE INTO QM_MAIL_CONTENT_SCALE ( id,mailId,type,content) VALUES (?,?,?,?)", new Object[] { Integer.valueOf(QMMath.hashInt("s" + paramLong)), Long.valueOf(paramLong), Integer.valueOf(1), paramString2 });
    }
    if (paramString3 != null) {
      paramSQLiteDatabase.execSQL("REPLACE INTO QM_MAIL_CONTENT_SCALE ( id,mailId,type,content) VALUES (?,?,?,?)", new Object[] { Integer.valueOf(QMMath.hashInt("w" + paramLong)), Long.valueOf(paramLong), Integer.valueOf(2), paramString3 });
    }
    if (paramString4 != null) {
      paramSQLiteDatabase.execSQL("REPLACE INTO QM_MAIL_CONTENT_SCALE ( id,mailId,type,content) VALUES (?,?,?,?)", new Object[] { Integer.valueOf(QMMath.hashInt("c" + paramLong)), Long.valueOf(paramLong), Integer.valueOf(3), paramString4 });
    }
  }
  
  public boolean insertMailInfo(SQLiteDatabase paramSQLiteDatabase, int paramInt1, Mail paramMail, int paramInt2)
  {
    MailInformation localMailInformation = paramMail.getInformation();
    long l = localMailInformation.getId();
    Object localObject = localMailInformation.getTagList();
    String str;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        str = ((MailTag)((Iterator)localObject).next()).getTagId();
        paramSQLiteDatabase.execSQL("REPLACE INTO QM_REF_MAIL_TAG (uid,mid,tagId) VALUES (?,?,?)", new Object[] { Long.valueOf(genRMTId(l, str)), Long.valueOf(l), str });
      }
    }
    localObject = "QM_MAIL_INFO";
    label157:
    boolean bool2;
    if ((paramInt2 & 0x40) != 0)
    {
      localObject = "QM_TMP_EML_MAIL_INFO";
      paramSQLiteDatabase.execSQL("REPLACE INTO QM_MAIL_INFO ( id,accountId,messageId,folderId,remoteId,colid,convType,attr,size,svrKey,subject,abstract,fromAddr,fromAddrId,fromAddrName,senderAddr,senderAddrName,utcSent,utcReceived,utcRecentOpr,isUnread,isLoaded,isStar,tags,reference,sendStatus,localCount,sendutc,messageId,convHash,convRefHash,convContactHash,convCnt,convUrCnt,qqAdType,qqSpamType,xqqstyle,toppedAdTime) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)".replace("QM_MAIL_INFO", (CharSequence)localObject), getMailInsertParams(paramInt1, paramMail));
      if ((paramInt2 & 0x80) == 0) {
        break label335;
      }
      bool1 = true;
      if ((paramInt2 & 0x40) == 0) {
        break label341;
      }
      bool2 = true;
      label168:
      insertMailContacts(paramSQLiteDatabase, paramMail, bool1, bool2);
      if (paramMail.getStatus().isGroupMail())
      {
        localObject = paramMail.getInformation().getFrom();
        str = paramMail.getInformation().getGroupId();
        if ((!StringUtils.isEmpty(str)) && (localObject != null))
        {
          ((MailContact)localObject).setUin(str);
          ((MailContact)localObject).setAddress(str.replaceFirst("(@groupmail.qq.com)*$", "@groupmail.qq.com"));
          if ((paramInt2 & 0x80) == 0) {
            break label347;
          }
          bool1 = true;
          label254:
          if ((paramInt2 & 0x40) == 0) {
            break label353;
          }
          bool2 = true;
          label265:
          insertMailContact(paramSQLiteDatabase, l, (MailContact)localObject, 5, 0, bool1, bool2);
        }
      }
      localObject = QMAttachManager.sharedInstance();
      if ((paramInt2 & 0x40) == 0) {
        break label359;
      }
    }
    label335:
    label341:
    label347:
    label353:
    label359:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((QMAttachManager)localObject).updateMailAttaches(paramSQLiteDatabase, paramInt1, localMailInformation, bool1);
      insertMailInfoFts(paramSQLiteDatabase, paramMail.getInformation());
      return true;
      if ((paramInt2 & 0x80) == 0) {
        break;
      }
      localObject = "QM_TMP_SEARCH_MAIL_INFO";
      break;
      bool1 = false;
      break label157;
      bool2 = false;
      break label168;
      bool1 = false;
      break label254;
      bool2 = false;
      break label265;
    }
  }
  
  public void insertMailInfoFts(SQLiteDatabase paramSQLiteDatabase, MailInformation paramMailInformation)
  {
    StringBuilder localStringBuilder1;
    StringBuilder localStringBuilder2;
    if (paramMailInformation != null) {
      try
      {
        localStringBuilder1 = new StringBuilder();
        if (paramMailInformation.getFrom() != null) {
          localStringBuilder1.append(paramMailInformation.getFrom().getAddress() + " " + paramMailInformation.getFrom().getName() + " ");
        }
        if (paramMailInformation.getSender() != null) {
          localStringBuilder1.append(paramMailInformation.getSender().getAddress() + " " + paramMailInformation.getSender().getName());
        }
        localStringBuilder2 = new StringBuilder();
        if ((paramMailInformation.getReceiverList() != null) && (paramMailInformation.getReceiverList().size() > 0))
        {
          localObject1 = paramMailInformation.getReceiverList().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (MailContact)((Iterator)localObject1).next();
            localStringBuilder2.append(((MailContact)localObject2).getAddress() + " " + ((MailContact)localObject2).getName() + " ");
            continue;
            return;
          }
        }
      }
      catch (Exception paramSQLiteDatabase)
      {
        QMLog.log(6, "QMMailSQLite", "insert mail info fts fail: " + Log.getStackTraceString(paramSQLiteDatabase));
      }
    }
    Object localObject1 = paramMailInformation.getSubject();
    Object localObject2 = paramMailInformation.getAbstractContent();
    StringBuilder localStringBuilder3 = new StringBuilder();
    Iterator localIterator;
    Object localObject3;
    if ((paramMailInformation.getAttachList() != null) && (paramMailInformation.getAttachList().size() > 0))
    {
      localIterator = paramMailInformation.getAttachList().iterator();
      while (localIterator.hasNext())
      {
        localObject3 = localIterator.next();
        if ((localObject3 instanceof Attach))
        {
          localObject3 = (Attach)localObject3;
          localStringBuilder3.append(((Attach)localObject3).getName() + " ");
        }
      }
    }
    if ((paramMailInformation.getBigAttachList() != null) && (paramMailInformation.getBigAttachList().size() > 0))
    {
      localIterator = paramMailInformation.getBigAttachList().iterator();
      while (localIterator.hasNext())
      {
        localObject3 = localIterator.next();
        if ((localObject3 instanceof MailBigAttach))
        {
          localObject3 = (MailBigAttach)localObject3;
          localStringBuilder3.append(((MailBigAttach)localObject3).getName() + " ");
        }
      }
    }
    if ((paramMailInformation.getEditAttachList() != null) && (paramMailInformation.getEditAttachList().size() > 0))
    {
      localIterator = paramMailInformation.getEditAttachList().iterator();
      while (localIterator.hasNext())
      {
        localObject3 = localIterator.next();
        if ((localObject3 instanceof MailEditAttach))
        {
          localObject3 = (MailEditAttach)localObject3;
          localStringBuilder3.append(((MailEditAttach)localObject3).getName() + " ");
        }
      }
    }
    paramSQLiteDatabase.execSQL("REPLACE INTO QM_MAIL_INFO_FTS_SEARCH ( docid,sender,receiver,subject,abs,attachName) VALUES (?,?,?,?,?,?)", new Object[] { Long.valueOf(paramMailInformation.getId()), localStringBuilder1.toString(), localStringBuilder2.toString(), localObject1, localObject2, localStringBuilder3.toString() });
  }
  
  public void insertMailPartInfo(SQLiteDatabase paramSQLiteDatabase, long paramLong, ItemBodyStructureHelper.MailItemBodyStructureInfo paramMailItemBodyStructureInfo)
  {
    paramSQLiteDatabase.execSQL("REPLACE INTO QM_MAIL_PART_INFO ( id,mid,itemId,itemType,bodyId,contentType,contentSubType,contentTypeParams,contentTransferEncoding,contentLineSize) VALUES (?,?,?,?,?,?,?,?,?,?)", new Object[] { Long.valueOf(paramMailItemBodyStructureInfo.id_), Long.valueOf(paramLong), Long.valueOf(paramMailItemBodyStructureInfo.itemid_), paramMailItemBodyStructureInfo.item_type_, paramMailItemBodyStructureInfo.body_id_, paramMailItemBodyStructureInfo.content_type_, paramMailItemBodyStructureInfo.content_subtype_, paramMailItemBodyStructureInfo.content_type_params_, paramMailItemBodyStructureInfo.content_transfer_encoding_, paramMailItemBodyStructureInfo.content_line_size_ });
  }
  
  /* Error */
  public void insertMailRecall(SQLiteDatabase paramSQLiteDatabase, ArrayList<MailRecall> paramArrayList)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 3122	com/tencent/moai/database/sqlite/SQLiteDatabase:beginTransactionNonExclusive	()V
    //   4: aload_2
    //   5: ifnull +64 -> 69
    //   8: aload_2
    //   9: invokevirtual 2815	java/util/ArrayList:size	()I
    //   12: ifle +57 -> 69
    //   15: aload_2
    //   16: invokevirtual 2841	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   19: astore_2
    //   20: aload_2
    //   21: invokeinterface 2371 1 0
    //   26: ifeq +43 -> 69
    //   29: aload_1
    //   30: ldc_w 499
    //   33: aload_0
    //   34: aload_2
    //   35: invokeinterface 2375 1 0
    //   40: checkcast 1974	com/tencent/qqmail/model/qmdomain/MailRecall
    //   43: invokespecial 4123	com/tencent/qqmail/model/mail/QMMailSQLite:getMailRecallInsertParams	(Lcom/tencent/qqmail/model/qmdomain/MailRecall;)[Ljava/lang/Object;
    //   46: invokevirtual 3032	com/tencent/moai/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   49: goto -29 -> 20
    //   52: astore_2
    //   53: bipush 6
    //   55: ldc 241
    //   57: aload_2
    //   58: invokestatic 2395	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   61: invokestatic 1597	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   64: aload_1
    //   65: invokevirtual 3130	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   68: return
    //   69: aload_1
    //   70: invokevirtual 3127	com/tencent/moai/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   73: aload_1
    //   74: invokevirtual 3130	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   77: return
    //   78: astore_2
    //   79: aload_1
    //   80: invokevirtual 3130	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   83: aload_2
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	QMMailSQLite
    //   0	85	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	85	2	paramArrayList	ArrayList<MailRecall>
    // Exception table:
    //   from	to	target	type
    //   0	4	52	java/lang/Exception
    //   8	20	52	java/lang/Exception
    //   20	49	52	java/lang/Exception
    //   69	73	52	java/lang/Exception
    //   0	4	78	finally
    //   8	20	78	finally
    //   20	49	78	finally
    //   53	64	78	finally
    //   69	73	78	finally
  }
  
  public void insertMailRule(SQLiteDatabase paramSQLiteDatabase, MailRuleInfo paramMailRuleInfo)
  {
    paramSQLiteDatabase.execSQL("REPLACE INTO QM_RULE_MAIL (ruleId,accountId,fieldName,operator,val,val2,action,param,alias) VALUES (?,?,?,?,?,?,?,?,?)", new Object[] { Integer.valueOf(paramMailRuleInfo.getId()), Integer.valueOf(paramMailRuleInfo.getAccountId()), Integer.valueOf(paramMailRuleInfo.getFieldName()), Integer.valueOf(paramMailRuleInfo.getOperator()), paramMailRuleInfo.getVal(), paramMailRuleInfo.getVal2(), Integer.valueOf(paramMailRuleInfo.getAction()), paramMailRuleInfo.getParam(), paramMailRuleInfo.getAlias() });
  }
  
  public void insertMailTranslateContent(SQLiteDatabase paramSQLiteDatabase, MailTranslate paramMailTranslate)
  {
    if (paramMailTranslate != null) {
      paramSQLiteDatabase.execSQL("REPLACE INTO QM_MAIL_TRANSLATE_CONTENT ( id,translate_subj,translate_content) VALUES (?,?,?)", getMailTranslateParams(paramMailTranslate));
    }
  }
  
  public void insertRemoteSearchMails(SQLiteDatabase paramSQLiteDatabase, int paramInt, Mail paramMail, boolean paramBoolean)
  {
    int i = 0;
    if (!paramMail.getStatus().isGroupMail()) {
      insertMailContacts(paramSQLiteDatabase, paramMail, true, false);
    }
    Object localObject2;
    for (;;)
    {
      paramMail.getStatus().setLoaded(hasMailContent(paramSQLiteDatabase, paramMail.getInformation().getId()));
      paramMail.getStatus().setNeedSync(true);
      Object localObject1 = getMailInsertParams(paramInt, paramMail);
      localObject2 = new Object[localObject1.length];
      while (i < localObject1.length)
      {
        localObject2[i] = localObject1[i];
        i += 1;
      }
      localObject1 = paramMail.getInformation().getFrom();
      localObject2 = paramMail.getInformation().getGroupId();
      if (!StringUtils.isEmpty((CharSequence)localObject2))
      {
        ((MailContact)localObject1).setUin((String)localObject2);
        ((MailContact)localObject1).setAddress(((String)localObject2).replaceFirst("(@groupmail.qq.com)*$", "@groupmail.qq.com"));
      }
      insertMailContact(paramSQLiteDatabase, paramMail.getInformation().getId(), (MailContact)localObject1, 5, 0, true, false);
    }
    paramSQLiteDatabase.execSQL(sqlInsertTmpSearch, (Object[])localObject2);
    QMAttachManager.sharedInstance().updateMailAttaches(paramSQLiteDatabase, paramInt, paramMail.getInformation(), paramBoolean);
  }
  
  public void insertSubscribeMails(SQLiteDatabase paramSQLiteDatabase, SubscribeMail paramSubscribeMail)
  {
    paramSQLiteDatabase.execSQL("REPLACE INTO QM_MAIL_SUBSCRIBE ( id,mid,remoteId,colid,accountId,idx,abstract,subject,fromName,fromAddr,link,bigIcon,icon,utcReceived) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new Object[] { Long.valueOf(paramSubscribeMail.getId()), Long.valueOf(paramSubscribeMail.getMid()), paramSubscribeMail.getRemoteId(), Integer.valueOf(paramSubscribeMail.getColId()), Integer.valueOf(paramSubscribeMail.getAccountId()), Integer.valueOf(paramSubscribeMail.getIndex()), paramSubscribeMail.getAbstract(), paramSubscribeMail.getSubject(), paramSubscribeMail.getFromName(), paramSubscribeMail.getFromAddress(), paramSubscribeMail.getLink(), paramSubscribeMail.getBigIcon(), paramSubscribeMail.getIcon(), Long.valueOf(paramSubscribeMail.getReceive().getTime() / 1000L) });
  }
  
  public void insertTmpSearchUtc(SQLiteDatabase paramSQLiteDatabase, long paramLong, int paramInt)
  {
    paramSQLiteDatabase.execSQL("REPLACE INTO QM_TMP_SEARCH_MAIL_UTC ( searchType,mailId,utcSearch) VALUES (?,?,?)", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), Long.valueOf(new Date().getTime()) });
  }
  
  public boolean isAccountMailEmpty(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    boolean bool = false;
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(sqlQueryMailCount, new String[] { paramInt + "" });
    if (paramSQLiteDatabase != null) {
      if (paramSQLiteDatabase.moveToFirst())
      {
        paramInt = paramSQLiteDatabase.getInt(0);
        paramSQLiteDatabase.close();
      }
    }
    for (;;)
    {
      if (paramInt == 0) {
        bool = true;
      }
      return bool;
      paramInt = 0;
      break;
      paramInt = 0;
    }
  }
  
  public boolean isFolderSyncEmpty(SQLiteDatabase paramSQLiteDatabase, QMFolder paramQMFolder)
  {
    boolean bool = false;
    Object localObject = getFolderCursorParams(paramQMFolder);
    paramQMFolder = (String)localObject[0];
    localObject = (String[])localObject[1];
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT COUNT(*) FROM (" + paramQMFolder + ") WHERE " + "attr" + "&" + 256L, (String[])localObject);
    int i;
    if (paramSQLiteDatabase != null) {
      if (paramSQLiteDatabase.moveToFirst())
      {
        i = paramSQLiteDatabase.getInt(0);
        paramSQLiteDatabase.close();
      }
    }
    for (;;)
    {
      if (i == 0) {
        bool = true;
      }
      return bool;
      i = 0;
      break;
      i = 0;
    }
  }
  
  public boolean isMailAppended(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    boolean bool = true;
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT attr FROM QM_MAIL_INFO WHERE id=?", new String[] { String.valueOf(paramLong) });
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst()) {
        if ((paramSQLiteDatabase.getLong(paramSQLiteDatabase.getColumnIndex("attr")) & 0x0) == 0L) {}
      }
      for (;;)
      {
        paramSQLiteDatabase.close();
        return bool;
        bool = false;
        continue;
        bool = false;
      }
    }
    return false;
  }
  
  public boolean isMailExist(SQLiteDatabase paramSQLiteDatabase, long paramLong, int paramInt)
  {
    String str = "QM_MAIL_INFO";
    if ((paramInt & 0x40) != 0)
    {
      str = "QM_TMP_EML_MAIL_INFO";
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT COUNT(*) FROM QM_MAIL_INFO WHERE id= ?".replace("QM_MAIL_INFO", str), new String[] { paramLong + "" });
      if (paramSQLiteDatabase == null) {
        break label121;
      }
      if (!paramSQLiteDatabase.moveToFirst()) {
        break label115;
      }
      paramInt = paramSQLiteDatabase.getInt(0);
      label83:
      paramSQLiteDatabase.close();
    }
    for (;;)
    {
      if (paramInt > 0)
      {
        return true;
        if ((paramInt & 0x80) == 0) {
          break;
        }
        str = "QM_TMP_SEARCH_MAIL_INFO";
        break;
      }
      return false;
      label115:
      paramInt = -1;
      break label83;
      label121:
      paramInt = -1;
    }
  }
  
  public boolean isMailUnRead(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT isUnread FROM QM_MAIL_INFO WHERE id =?", new String[] { String.valueOf(paramLong) });
    if (paramSQLiteDatabase != null)
    {
      bool1 = bool2;
      if (paramSQLiteDatabase.moveToFirst()) {
        if (paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("isUnread")) != 1) {
          break label74;
        }
      }
    }
    label74:
    for (bool1 = bool2;; bool1 = false)
    {
      paramSQLiteDatabase.close();
      return bool1;
    }
  }
  
  public boolean isPOPMailDeleted(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    boolean bool = true;
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT attr FROM QM_MAIL_INFO WHERE id=?", new String[] { String.valueOf(paramLong) });
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst()) {
        if ((paramSQLiteDatabase.getLong(paramSQLiteDatabase.getColumnIndex("attr")) & 0x0) == 0L) {}
      }
      for (;;)
      {
        paramSQLiteDatabase.close();
        return bool;
        bool = false;
        continue;
        bool = false;
      }
    }
    return false;
  }
  
  public boolean isPopMailComplete(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    boolean bool = true;
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT attr FROM QM_MAIL_INFO WHERE id=?", new String[] { String.valueOf(paramLong) });
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst()) {
        if ((paramSQLiteDatabase.getLong(paramSQLiteDatabase.getColumnIndex("attr")) & 0x1000000) == 0L) {}
      }
      for (;;)
      {
        paramSQLiteDatabase.close();
        return bool;
        bool = false;
        continue;
        bool = false;
      }
    }
    return false;
  }
  
  public boolean isSearchMailExist(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    boolean bool = true;
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT COUNT(*) FROM QM_TMP_SEARCH_MAIL_INFO WHERE id=? ", new String[] { paramLong + "" });
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst()) {
        if (paramSQLiteDatabase.getInt(0) <= 0) {}
      }
      for (;;)
      {
        paramSQLiteDatabase.close();
        return bool;
        bool = false;
        continue;
        bool = false;
      }
    }
    return false;
  }
  
  public boolean isSearchMailInSearchTypeExist(SQLiteDatabase paramSQLiteDatabase, long paramLong, int paramInt)
  {
    boolean bool = true;
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT COUNT(*) FROM QM_TMP_SEARCH_MAIL_UTC WHERE mailId=? AND searchType=?", new String[] { paramLong + "", paramInt + "" });
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst()) {
        if (paramSQLiteDatabase.getInt(0) <= 0) {}
      }
      for (;;)
      {
        paramSQLiteDatabase.close();
        return bool;
        bool = false;
        continue;
        bool = false;
      }
    }
    return false;
  }
  
  public void markAdConvReadStat(SQLiteDatabase paramSQLiteDatabase, int paramInt, boolean paramBoolean)
  {
    ContentValues localContentValues = new ContentValues();
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      localContentValues.put("isUnread", str);
      if (paramInt != 0) {
        break;
      }
      paramSQLiteDatabase.update("QM_MAIL_INFO", localContentValues, " attr&2048 ", new String[0]);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(" attr&2048  AND accountId=? AND isUnread=");
    if (paramBoolean) {}
    for (str = "0";; str = "1")
    {
      paramSQLiteDatabase.update("QM_MAIL_INFO", localContentValues, str, new String[] { paramInt + "" });
      paramSQLiteDatabase.execSQL("UPDATE QM_MAIL_INFO SET isUnread=EXISTS (SELECT * FROM QM_MAIL_INFO WHERE isUnread=1 AND  attr&2048  AND  NOT  attr&16384 ) WHERE  attr&2048  AND  attr&16384 ");
      return;
    }
  }
  
  public boolean markMailAsLocal(SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString)
  {
    paramArrayOfString = "UPDATE QM_MAIL_INFO SET attr = attr|33554432" + " WHERE remoteId IN " + getInClause(paramArrayOfString);
    paramArrayOfString = paramArrayOfString + " AND attr&256";
    try
    {
      paramSQLiteDatabase.execSQL(paramArrayOfString, new String[0]);
      return true;
    }
    catch (Exception paramSQLiteDatabase)
    {
      paramSQLiteDatabase.printStackTrace();
    }
    return false;
  }
  
  public void markSubscribeConvReadStat(SQLiteDatabase paramSQLiteDatabase, int paramInt, boolean paramBoolean)
  {
    ContentValues localContentValues = new ContentValues();
    QMAggrConvMailCache.sharedInstance().ensureUnreadIndexes(paramInt, paramBoolean);
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      str = "1";
      localContentValues.put("isUnread", str);
      localStringBuilder = new StringBuilder().append("accountId=? AND isUnread=");
      if (!paramBoolean) {
        break label153;
      }
    }
    label153:
    for (String str = "0";; str = "1")
    {
      paramSQLiteDatabase.update("QM_MAIL_INFO", localContentValues, str + " AND  ( " + " EXISTS (SELECT id,type FROM QM_FOLDER AS FD  WHERE FD.id=$alias$.folderId AND FD.type=15)".replace("$alias$", "QM_MAIL_INFO") + " OR " + " attr&8192 " + " ) ", new String[] { paramInt + "" });
      return;
      str = "0";
      break;
    }
  }
  
  public void moveMails(SQLiteDatabase paramSQLiteDatabase, int paramInt1, long[] paramArrayOfLong, int paramInt2, boolean paramBoolean)
  {
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length <= 0)) {
      return;
    }
    String str = getInClause(paramArrayOfLong);
    Object localObject = AccountManager.shareInstance().getAccountList().getAccountById(paramInt1);
    int[] arrayOfInt = getMailConvHash(paramSQLiteDatabase, paramArrayOfLong);
    if ((paramBoolean) || (((Account)localObject).isPopMail()))
    {
      if (arrayOfInt == null) {
        break label156;
      }
      localObject = getQQMailConvParentFolders(paramSQLiteDatabase, arrayOfInt);
      paramSQLiteDatabase.execSQL("UPDATE QM_MAIL_INFO SET folderId=? WHERE id IN( SELECT id FROM QM_MAIL_INFO INNER JOIN(SELECT id AS mid,folderId AS fid,convHash AS ch,convType AS ct FROM QM_MAIL_INFO WHERE id IN $inClause$) ON id=mid OR (convType=-1 AND convHash=ch AND folderId=fid AND ct=1))".replace("$inClause$", str), new String[] { String.valueOf(paramInt2) });
      if (arrayOfInt != null)
      {
        if (!paramBoolean) {
          break label162;
        }
        updateQQConvMails(paramSQLiteDatabase, paramInt1, paramInt2, paramArrayOfLong, arrayOfInt);
      }
      label112:
      if (localObject != null) {
        break label173;
      }
      paramSQLiteDatabase = new int[1];
      paramSQLiteDatabase[0] = paramInt2;
    }
    for (;;)
    {
      QMFolderManager.sharedInstance().setOverdue(paramSQLiteDatabase, true);
      return;
      localObject = getRemoteIds(paramSQLiteDatabase, paramArrayOfLong);
      if (localObject != null) {
        markMailAsLocal(paramSQLiteDatabase, (String[])localObject);
      }
      label156:
      localObject = null;
      break;
      label162:
      rebuildConvParents(paramSQLiteDatabase, paramInt1, arrayOfInt);
      break label112;
      label173:
      paramSQLiteDatabase = new int[localObject.length + 1];
      System.arraycopy(localObject, 0, paramSQLiteDatabase, 0, localObject.length);
      paramSQLiteDatabase[localObject.length] = paramInt2;
    }
  }
  
  public void moveOutOfAdvertise(SQLiteDatabase paramSQLiteDatabase, Mail paramMail, boolean paramBoolean)
  {
    if (paramMail.getInformation().getFrom() != null) {}
    for (int i = genRMAAddrId(paramMail.getInformation().getFrom().getAddress());; i = genRMAAddrId(null))
    {
      paramMail.getInformation().getAccountId();
      long l2 = paramMail.getInformation().getId();
      paramMail.getInformation().getRemoteId();
      if ((!paramMail.getStatus().isProtocolMail()) && (paramMail.getStatus().isConversationChild()))
      {
        paramMail = getConvMailParentIds(paramSQLiteDatabase, paramMail.getInformation().getConvHash());
        long l1 = l2;
        if (paramMail != null)
        {
          l1 = l2;
          if (paramMail.length > 0) {
            l1 = paramMail[0];
          }
        }
        paramMail = readMailSync(paramSQLiteDatabase, l1);
        if (paramMail != null) {
          paramMail.getInformation().getRemoteId();
        }
      }
      if (!paramBoolean) {
        break;
      }
      paramSQLiteDatabase.execSQL("REPLACE INTO QM_RULE_AD (ruleAddrId,ruleAccId,ruleType) VALUES (?,?,?)", new Object[] { Integer.valueOf(i), "", Integer.valueOf(1) });
      return;
    }
    paramSQLiteDatabase.delete("QM_RULE_AD", "ruleAddrId=? AND ruleType=?", new String[] { i + "", "1" });
  }
  
  public void mustBeAdvertise(SQLiteDatabase paramSQLiteDatabase, Mail paramMail, boolean paramBoolean)
  {
    if (paramMail.getInformation().getFrom() != null) {}
    for (int i = genRMAAddrId(paramMail.getInformation().getFrom().getAddress());; i = genRMAAddrId(null))
    {
      paramMail.getInformation().getAccountId();
      long l2 = paramMail.getInformation().getId();
      paramMail.getInformation().getRemoteId();
      if ((!paramMail.getStatus().isProtocolMail()) && (paramMail.getStatus().isConversationChild()))
      {
        paramMail = getConvMailParentIds(paramSQLiteDatabase, paramMail.getInformation().getConvHash());
        long l1 = l2;
        if (paramMail != null)
        {
          l1 = l2;
          if (paramMail.length > 0) {
            l1 = paramMail[0];
          }
        }
        paramMail = readMailSync(paramSQLiteDatabase, l1);
        if (paramMail != null) {
          paramMail.getInformation().getRemoteId();
        }
      }
      if (!paramBoolean) {
        break;
      }
      paramSQLiteDatabase.execSQL("REPLACE INTO QM_RULE_AD (ruleAddrId,ruleAccId,ruleType) VALUES (?,?,?)", new Object[] { Integer.valueOf(i), "", Integer.valueOf(2) });
      return;
    }
    paramSQLiteDatabase.delete("QM_RULE_AD", "ruleAddrId=? AND ruleType=?", new String[] { i + "", "2" });
  }
  
  public Cursor queryForAllRelativeContacts(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null) {}
    for (paramArrayOfInt = "SELECT C.* FROM QM_MAIL_INFO AS M,QM_REF_MAIL_ADDR AS C  WHERE M.id = C.mid AND M.folderId IN $inClause$  ORDER BY mid,roleType,seq ASC".replace("$inClause$", "(" + "SELECT id FROM QM_FOLDER WHERE type=$inClause$".replace("$inClause$", String.valueOf(paramInt)) + ")");; paramArrayOfInt = "SELECT C.* FROM QM_MAIL_INFO AS M,QM_REF_MAIL_ADDR AS C  WHERE M.id = C.mid AND M.folderId IN $inClause$  ORDER BY mid,roleType,seq ASC".replace("$inClause$", getInClause(paramArrayOfInt))) {
      return paramSQLiteDatabase.rawQuery(paramArrayOfInt, null);
    }
  }
  
  public Cursor queryForRelativeContacts(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null) {}
    for (paramArrayOfInt = "SELECT C.* FROM QM_MAIL_INFO AS M,QM_REF_MAIL_ADDR AS C  WHERE M.id = C.mid AND M.folderId IN $inClause$  AND C.roleType = 2 ORDER BY mid,roleType,seq ASC".replace("$inClause$", "(" + "SELECT id FROM QM_FOLDER WHERE type=$inClause$".replace("$inClause$", String.valueOf(paramInt)) + ")");; paramArrayOfInt = "SELECT C.* FROM QM_MAIL_INFO AS M,QM_REF_MAIL_ADDR AS C  WHERE M.id = C.mid AND M.folderId IN $inClause$  AND C.roleType = 2 ORDER BY mid,roleType,seq ASC".replace("$inClause$", getInClause(paramArrayOfInt))) {
      return paramSQLiteDatabase.rawQuery(paramArrayOfInt, null);
    }
  }
  
  public Cursor queryForRelativeGroupContact(SQLiteDatabase paramSQLiteDatabase)
  {
    return paramSQLiteDatabase.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", new Object[] { "QM_REF_MAIL_ADDR", "roleType" }), new String[] { String.valueOf(5) });
  }
  
  public ArrayList<MailRecall> queryMailRecallByMailId(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_REF_MAIL_RECALL WHERE mid=?", new String[] { String.valueOf(paramLong) });
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst()) {
        do
        {
          MailRecall localMailRecall = new MailRecall();
          fillMailRecall(paramSQLiteDatabase, localMailRecall);
          localArrayList.add(localMailRecall);
        } while (paramSQLiteDatabase.moveToNext());
      }
      paramSQLiteDatabase.close();
    }
    return localArrayList;
  }
  
  public Mail readEmlMailAsync(SQLiteDatabase paramSQLiteDatabase, long paramLong, ReadMailCallback paramReadMailCallback)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE id=?".replace("QM_MAIL_INFO", "QM_TMP_EML_MAIL_INFO"), new String[] { String.valueOf(paramLong) });
    if (localCursor != null)
    {
      localObject1 = localObject2;
      if (localCursor.moveToFirst()) {
        localObject1 = readMail(paramSQLiteDatabase, localCursor, false, true, paramReadMailCallback);
      }
      localCursor.close();
    }
    return localObject1;
  }
  
  public Mail readEmlMailSync(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE id=?".replace("QM_MAIL_INFO", "QM_TMP_EML_MAIL_INFO"), new String[] { String.valueOf(paramLong) });
    if (localCursor != null)
    {
      localObject1 = localObject2;
      if (localCursor.moveToFirst()) {
        localObject1 = fillMailAll(paramSQLiteDatabase, localCursor, false, true);
      }
      localCursor.close();
    }
    return localObject1;
  }
  
  public Mail readMailAsync(SQLiteDatabase paramSQLiteDatabase, long paramLong, ReadMailCallback paramReadMailCallback)
  {
    SQLiteDatabase localSQLiteDatabase = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE id=?", new String[] { String.valueOf(paramLong) });
    if (localCursor != null) {}
    for (;;)
    {
      try
      {
        if (localCursor.moveToFirst())
        {
          paramSQLiteDatabase = readMail(paramSQLiteDatabase, localCursor, false, false, paramReadMailCallback);
          localCursor.close();
          localSQLiteDatabase = paramSQLiteDatabase;
          return localSQLiteDatabase;
        }
      }
      catch (Exception paramSQLiteDatabase)
      {
        QMLog.log(6, "QMMailSQLite", "readMailAsync exception:" + paramSQLiteDatabase);
        return null;
      }
      finally
      {
        localCursor.close();
      }
      paramSQLiteDatabase = null;
    }
  }
  
  public MailContent readMailContent(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_MAIL_CONTENT WHERE id = ?", new String[] { paramLong + "" });
    MailContent localMailContent = new MailContent();
    if (paramSQLiteDatabase != null) {}
    try
    {
      if (paramSQLiteDatabase.moveToFirst()) {
        localMailContent.setBody(paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("content")));
      }
      paramSQLiteDatabase.close();
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
        QMLog.log(5, "QMMailSQLite", "ReadMailContent exception: " + localException.getMessage() + " maybe content size is overflow");
      } while (paramSQLiteDatabase == null);
      paramSQLiteDatabase.close();
    }
    return localMailContent;
    return localMailContent;
  }
  
  public String[] readMailContentScale(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    int i = 0;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_MAIL_CONTENT_SCALE WHERE mailId = ?", new String[] { String.valueOf(paramLong) });
    paramSQLiteDatabase = null;
    String[] arrayOfString = null;
    int j;
    if (localCursor != null)
    {
      j = localCursor.getCount();
      paramSQLiteDatabase = arrayOfString;
      if (j > 0) {
        arrayOfString = new String[4];
      }
    }
    for (;;)
    {
      paramSQLiteDatabase = arrayOfString;
      if ((i >= j) || (localCursor.moveToPosition(i))) {}
      try
      {
        arrayOfString[localCursor.getInt(localCursor.getColumnIndex("type"))] = localCursor.getString(localCursor.getColumnIndex("content"));
        label115:
        i += 1;
        continue;
        localCursor.close();
        return paramSQLiteDatabase;
      }
      catch (Exception paramSQLiteDatabase)
      {
        break label115;
      }
    }
  }
  
  public void readMailExtra(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean1, boolean paramBoolean2, Mail paramMail)
  {
    fillMailContent(paramSQLiteDatabase, paramMail);
    fillMailContacts(paramSQLiteDatabase, paramMail, paramBoolean1, paramBoolean2);
    QMAttachSQLite.fillMailAttach(paramSQLiteDatabase, paramMail);
  }
  
  public Mail readMailInfo(SQLiteDatabase paramSQLiteDatabase, long paramLong, boolean paramBoolean)
  {
    Object localObject;
    label47:
    int[] arrayOfInt;
    if (paramBoolean)
    {
      localObject = "QM_TMP_EML_MAIL_INFO";
      localObject = paramSQLiteDatabase.rawQuery("SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE id=?".replace("QM_MAIL_INFO", (CharSequence)localObject), new String[] { String.valueOf(paramLong) });
      if (!paramBoolean) {
        break label145;
      }
      paramSQLiteDatabase = mCacheColumnIndexForEML;
      arrayOfInt = Arrays.copyOf(paramSQLiteDatabase, paramSQLiteDatabase.length);
      if (localObject == null) {
        break label174;
      }
      if (!((Cursor)localObject).moveToFirst()) {
        break label169;
      }
      paramSQLiteDatabase = new Mail();
      paramSQLiteDatabase.setStatus(new MailStatus());
      paramSQLiteDatabase.setInformation(new MailInformation());
      fillMail((Cursor)localObject, paramSQLiteDatabase, arrayOfInt);
      label108:
      ((Cursor)localObject).close();
    }
    for (;;)
    {
      if (paramBoolean) {
        if (!columnCacheForEMLInited)
        {
          mCacheColumnIndexForEML = arrayOfInt;
          columnCacheForEMLInited = true;
        }
      }
      label145:
      while (columnCacheInited)
      {
        return paramSQLiteDatabase;
        localObject = "QM_MAIL_INFO";
        break;
        paramSQLiteDatabase = mCacheColumnIndex;
        break label47;
      }
      mCacheColumnIndex = arrayOfInt;
      columnCacheInited = true;
      return paramSQLiteDatabase;
      label169:
      paramSQLiteDatabase = null;
      break label108;
      label174:
      paramSQLiteDatabase = null;
    }
  }
  
  public ArrayList<ItemBodyStructureHelper.MailItemBodyStructureInfo> readMailPartInfo(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_MAIL_PART_INFO WHERE mid=?", new String[] { String.valueOf(paramLong) });
    ArrayList localArrayList = new ArrayList();
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst()) {
        do
        {
          ItemBodyStructureHelper.MailItemBodyStructureInfo localMailItemBodyStructureInfo = new ItemBodyStructureHelper.MailItemBodyStructureInfo();
          localMailItemBodyStructureInfo.id_ = paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("id"));
          localMailItemBodyStructureInfo.itemid_ = paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("itemId"));
          localMailItemBodyStructureInfo.item_type_ = paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("itemType"));
          localMailItemBodyStructureInfo.body_id_ = paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("bodyId"));
          localMailItemBodyStructureInfo.content_type_ = paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("contentType"));
          localMailItemBodyStructureInfo.content_subtype_ = paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("contentSubType"));
          localMailItemBodyStructureInfo.content_type_params_ = paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("contentTypeParams"));
          localMailItemBodyStructureInfo.content_transfer_encoding_ = paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("contentTransferEncoding"));
          localMailItemBodyStructureInfo.content_line_size_ = paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("contentLineSize"));
          localArrayList.add(localMailItemBodyStructureInfo);
        } while (paramSQLiteDatabase.moveToNext());
      }
      paramSQLiteDatabase.close();
    }
    return localArrayList;
  }
  
  public Mail readMailSync(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE id=?", new String[] { String.valueOf(paramLong) });
    if (localCursor != null)
    {
      localObject1 = localObject2;
      if (localCursor.moveToFirst()) {
        localObject1 = fillMailAll(paramSQLiteDatabase, localCursor, false, false);
      }
      localCursor.close();
    }
    return localObject1;
  }
  
  public boolean readMailTranslateAsync(SQLiteDatabase paramSQLiteDatabase, long paramLong, ReadMailTranslateCallback paramReadMailTranslateCallback)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_MAIL_TRANSLATE_CONTENT WHERE id = ?", new String[] { String.valueOf(paramLong) });
    if ((paramSQLiteDatabase != null) && (paramSQLiteDatabase.moveToFirst()))
    {
      Threads.runInBackground(new QMMailSQLite.3(this, paramSQLiteDatabase, paramReadMailTranslateCallback));
      return true;
    }
    return false;
  }
  
  public MailTranslate readMailTranslateSync(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_MAIL_TRANSLATE_CONTENT WHERE id = ?", new String[] { String.valueOf(paramLong) });
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst())
      {
        MailTranslate localMailTranslate = new MailTranslate();
        localMailTranslate.setMailId(paramSQLiteDatabase.getLong(paramSQLiteDatabase.getColumnIndex("id")));
        localMailTranslate.setTranslateSubj(paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("translate_subj")));
        localMailTranslate.setTranslateContent(paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("translate_content")));
        return localMailTranslate;
      }
      paramSQLiteDatabase.close();
    }
    return null;
  }
  
  public Mail readSearchMailAsync(SQLiteDatabase paramSQLiteDatabase, long paramLong, ReadMailCallback paramReadMailCallback)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT M.*,C.content FROM QM_TMP_SEARCH_MAIL_INFO AS M " + " LEFT OUTER JOIN QM_MAIL_CONTENT AS C ON M.id=C.id".replace("QM_MAIL_INFO", "QM_TMP_SEARCH_MAIL_INFO") + " WHERE M." + "id" + "=?", new String[] { String.valueOf(paramLong) });
    if (localCursor != null)
    {
      localObject1 = localObject2;
      if (localCursor.moveToFirst()) {
        localObject1 = readMail(paramSQLiteDatabase, localCursor, true, false, paramReadMailCallback);
      }
      localCursor.close();
    }
    return localObject1;
  }
  
  public Mail readSearchMailInfo(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    Mail localMail = new Mail();
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT M.*  FROM QM_TMP_SEARCH_MAIL_INFO AS M  WHERE M.id=?", new String[] { String.valueOf(paramLong) });
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst())
      {
        localMail.setInformation(new MailInformation());
        localMail.setStatus(new MailStatus());
        fillMail(paramSQLiteDatabase, localMail);
      }
      paramSQLiteDatabase.close();
    }
    return localMail;
  }
  
  public Mail readSearchMailSync(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT M.*,C.content FROM QM_TMP_SEARCH_MAIL_INFO AS M " + " LEFT OUTER JOIN QM_MAIL_CONTENT AS C ON M.id=C.id".replace("QM_MAIL_INFO", "QM_TMP_SEARCH_MAIL_INFO") + " WHERE M." + "id" + "=?", new String[] { String.valueOf(paramLong) });
    if (localCursor != null)
    {
      localObject1 = localObject2;
      if (localCursor.moveToFirst()) {
        localObject1 = fillMailAll(paramSQLiteDatabase, localCursor, true, false);
      }
      localCursor.close();
    }
    return localObject1;
  }
  
  public MailVote readVoteContent(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_MAIL_CONTENT WHERE id = ?", new String[] { paramLong + "" });
    if (localCursor != null) {}
    for (;;)
    {
      try
      {
        if (localCursor.moveToFirst())
        {
          paramSQLiteDatabase = localCursor.getString(localCursor.getColumnIndex("extra"));
          return (MailVote)ObjectSerializable.fromByte(paramSQLiteDatabase.getBytes());
        }
      }
      catch (Exception localException1)
      {
        try
        {
          localCursor.close();
          if (paramSQLiteDatabase != null) {
            break label121;
          }
          return null;
        }
        catch (Exception localException2)
        {
          continue;
        }
        localException1 = localException1;
        paramSQLiteDatabase = null;
        QMLog.log(6, "readVoteContent", localException1.getMessage() + " maybe content size is overflow");
        continue;
      }
      label121:
      paramSQLiteDatabase = null;
      continue;
      paramSQLiteDatabase = null;
    }
  }
  
  public void rebuildConvParents(SQLiteDatabase paramSQLiteDatabase, int paramInt, int[] paramArrayOfInt)
  {
    int i = 0;
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
      return;
    }
    Object localObject = getInClause(paramArrayOfInt);
    int[] arrayOfInt = QMFolderManager.sharedInstance().getNoConvFolderIds(paramInt);
    try
    {
      paramSQLiteDatabase.beginTransactionNonExclusive();
      paramSQLiteDatabase.delete("QM_MAIL_INFO", "convHash IN " + (String)localObject + " AND " + "convType" + "=1", null);
      localObject = paramSQLiteDatabase.rawQuery("SELECT id, ch, (SELECT COUNT(*) FROM QM_MAIL_INFO WHERE (folderId=fid OR (NOT ch&1 AND folderId=?)) AND convHash=ch) AS cnt FROM QM_FOLDER INNER JOIN (SELECT id AS fid FROM QM_FOLDER WHERE accountId=? AND id NOT IN$inClauseFolders$) ON fid=id INNER JOIN (SELECT DISTINCT convHash AS ch FROM QM_MAIL_INFO WHERE convHash IN$inClauseHash$) WHERE EXISTS(SELECT * FROM QM_MAIL_INFO WHERE folderId=fid AND convHash=ch) AND cnt > 1".replace("$inClauseFolders$", getInClause(arrayOfInt)).replace("$inClauseHash$", (CharSequence)localObject), new String[] { String.valueOf(QMFolderManager.sharedInstance().getSentFolderId(paramInt)), String.valueOf(paramInt) });
      if (localObject != null)
      {
        int j = ((Cursor)localObject).getCount();
        if (j > 0) {
          while (i < j)
          {
            ((Cursor)localObject).moveToPosition(i);
            int k = ((Cursor)localObject).getInt(0);
            int m = ((Cursor)localObject).getInt(1);
            ((Cursor)localObject).getInt(2);
            createConvParent(paramSQLiteDatabase, paramInt, k, m);
            i += 1;
          }
        }
        ((Cursor)localObject).close();
      }
      localObject = new ContentValues();
      ((ContentValues)localObject).put("convType", Integer.valueOf(0));
      paramSQLiteDatabase.update("QM_MAIL_INFO", (ContentValues)localObject, "folderId IN " + getInClause(arrayOfInt), null);
      paramSQLiteDatabase.execSQL("UPDATE QM_MAIL_INFO SET convType=CASE convType WHEN 0 THEN -1 ELSE 0 END WHERE id IN(SELECT id FROM QM_MAIL_INFO AS mi WHERE CASE convType WHEN -1 THEN NOT EXISTS(SELECT * FROM QM_MAIL_INFO AS mmi  WHERE mi.folderId=mmi.folderId AND mi.convHash=mmi.convHash AND mmi.convType=1) WHEN 0 THEN EXISTS(SELECT * FROM QM_MAIL_INFO AS mmi  WHERE mi.folderId=mmi.folderId AND mi.convHash=mmi.convHash AND mmi.convType=1) END)");
      updateConvMailStatus(paramSQLiteDatabase, paramArrayOfInt);
      paramSQLiteDatabase.setTransactionSuccessful();
      try
      {
        paramSQLiteDatabase.endTransaction();
        return;
      }
      catch (Exception paramSQLiteDatabase)
      {
        return;
      }
      try
      {
        paramSQLiteDatabase.endTransaction();
        throw paramArrayOfInt;
      }
      catch (Exception paramSQLiteDatabase)
      {
        break label355;
      }
    }
    catch (Exception localException)
    {
      localException = localException;
      QMLog.log(6, "QMMailSQLite", "rebuildConvParents, accountId: " + paramInt + ", convHashesSize: " + paramArrayOfInt.length);
      try
      {
        paramSQLiteDatabase.endTransaction();
        return;
      }
      catch (Exception paramSQLiteDatabase) {}
    }
    finally {}
  }
  
  public void reindex(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("REINDEX");
  }
  
  public String[] remoteIdNotIncludes(SQLiteDatabase paramSQLiteDatabase, int paramInt, String[] paramArrayOfString)
  {
    HashSet localHashSet = null;
    Object localObject = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT remoteId FROM QM_MAIL_INFO WHERE accountId=? AND attr&256 AND remoteId IN$inClause$".replace("$inClause$", getInClause(paramArrayOfString)), new String[] { String.valueOf(paramInt) });
    paramSQLiteDatabase = localHashSet;
    if (localCursor != null)
    {
      localHashSet = new HashSet();
      paramSQLiteDatabase = localObject;
      if (localCursor.moveToFirst())
      {
        localHashSet.add(localCursor.getString(0));
        while (localCursor.moveToNext()) {
          localHashSet.add(localCursor.getString(0));
        }
        ArrayList localArrayList = new ArrayList();
        int i = paramArrayOfString.length;
        paramInt = 0;
        while (paramInt < i)
        {
          paramSQLiteDatabase = paramArrayOfString[paramInt];
          if (!localHashSet.contains(paramSQLiteDatabase)) {
            localArrayList.add(paramSQLiteDatabase);
          }
          paramInt += 1;
        }
        paramSQLiteDatabase = localObject;
        if (localArrayList.size() > 0) {
          paramSQLiteDatabase = (String[])localArrayList.toArray(new String[0]);
        }
      }
      localCursor.close();
    }
    return paramSQLiteDatabase;
  }
  
  public void removeMailRule(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt)
  {
    paramSQLiteDatabase.delete("QM_RULE_MAIL", "ruleId IN " + getInClause(paramArrayOfInt), null);
  }
  
  public void renameTag(SQLiteDatabase paramSQLiteDatabase, int paramInt, long[] paramArrayOfLong, String paramString1, String paramString2, String paramString3)
  {
    int k = paramArrayOfLong.length;
    int i = 0;
    long l;
    Object localObject;
    if (i < k)
    {
      l = paramArrayOfLong[i];
      localObject = getMailTags(paramSQLiteDatabase, paramString1, paramInt, l);
      Iterator localIterator = ((ArrayList)localObject).iterator();
      while (localIterator.hasNext())
      {
        MailTag localMailTag = (MailTag)localIterator.next();
        if (localMailTag.getName().equals(paramString3)) {
          localMailTag.setName(paramString2);
        }
      }
    }
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        localObject = getTagListString((ArrayList)localObject);
        updateMailTags(paramSQLiteDatabase, new long[] { l }, (String)localObject);
      }
      i += 1;
      break;
      return;
    }
  }
  
  public void resetEmlMailAttr(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong, long paramLong)
  {
    paramSQLiteDatabase.execSQL("UPDATE QM_MAIL_INFO SET attr=attr&(~?) WHERE id IN$inClause$".replace("QM_MAIL_INFO", "QM_TMP_EML_MAIL_INFO").replace("$inClause$", getInClause(paramArrayOfLong)), new Object[] { Long.valueOf(paramLong) });
  }
  
  public void resetMailAttr(SQLiteDatabase paramSQLiteDatabase, @NonNull long[] paramArrayOfLong, long paramLong)
  {
    paramSQLiteDatabase.execSQL("UPDATE QM_MAIL_INFO SET attr=attr&(~?) WHERE id IN$inClause$".replace("$inClause$", getInClause(paramArrayOfLong)), new Object[] { Long.valueOf(paramLong) });
  }
  
  public void resetPopMailContentCompleteStatus(SQLiteDatabase paramSQLiteDatabase, ArrayList<Integer> paramArrayList)
  {
    paramSQLiteDatabase.execSQL("update QM_MAIL_INFO set attr=attr&(~16777216) where id in (select M_TEMP.id from QM_MAIL_INFO as M_TEMP where M_TEMP.accountId in $inClause$)".replace("$inClause$", getInClause(paramArrayList)));
  }
  
  public void resetSearchMailAttr(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong, long paramLong)
  {
    paramSQLiteDatabase.execSQL("UPDATE QM_MAIL_INFO SET attr=attr&(~?) WHERE id IN$inClause$".replace("QM_MAIL_INFO", "QM_TMP_SEARCH_MAIL_INFO").replace("$inClause$", getInClause(paramArrayOfLong)), new Object[] { Long.valueOf(paramLong) });
  }
  
  public void setMailAggregate(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    paramSQLiteDatabase.execSQL("REPLACE INTO QM_MAIL_AGGREGATE ( id , value ) VALUES (?,?)", new String[] { paramString1, paramString2 });
  }
  
  public void spamMails(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong, int paramInt)
  {
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length <= 0)) {
      return;
    }
    String[] arrayOfString = new String[paramArrayOfLong.length];
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      arrayOfString[i] = (paramArrayOfLong[i] + "");
      i += 1;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("folderId", Integer.valueOf(QMFolderManager.sharedInstance().getSpamFolderId(paramInt)));
    paramSQLiteDatabase.update("QM_MAIL_INFO", localContentValues, "id in " + getInClause(arrayOfString.length), arrayOfString);
    updateQQConvMails(paramSQLiteDatabase, 0, 0, paramArrayOfLong, getMailConvHash(paramSQLiteDatabase, paramArrayOfLong));
  }
  
  public void starMails(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong, boolean paramBoolean)
  {
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length <= 0)) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("isStar", Boolean.valueOf(paramBoolean));
    updateConvMailStatus(paramSQLiteDatabase, paramArrayOfLong, localContentValues);
    updateConvMailParentStar(paramSQLiteDatabase, paramArrayOfLong);
    updateTempSearchMail(paramSQLiteDatabase, paramArrayOfLong, localContentValues);
  }
  
  public void syncAdAddressList(SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    paramSQLiteDatabase.delete("QM_RULE_AD", "", new String[0]);
    int j;
    int i;
    if (paramArrayOfString1 != null)
    {
      j = paramArrayOfString1.length;
      i = 0;
      while (i < j)
      {
        paramSQLiteDatabase.execSQL("REPLACE INTO QM_RULE_AD (ruleAddrId,ruleAccId,ruleType) VALUES (?,?,?)", new Object[] { Integer.valueOf(genRMAAddrId(paramArrayOfString1[i])), "", Integer.valueOf(2) });
        i += 1;
      }
    }
    if (paramArrayOfString2 != null)
    {
      j = paramArrayOfString2.length;
      i = 0;
      while (i < j)
      {
        paramSQLiteDatabase.execSQL("REPLACE INTO QM_RULE_AD (ruleAddrId,ruleAccId,ruleType) VALUES (?,?,?)", new Object[] { Integer.valueOf(genRMAAddrId(paramArrayOfString2[i])), "", Integer.valueOf(1) });
        i += 1;
      }
    }
  }
  
  public void tagMails(SQLiteDatabase paramSQLiteDatabase, int paramInt, long[] paramArrayOfLong, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    HashMap localHashMap = getTagFolders(paramInt);
    paramArrayOfString1 = getTagListFromIds(localHashMap, paramArrayOfString1);
    updateMailTags(paramSQLiteDatabase, paramArrayOfLong, getTagListString(paramArrayOfString1));
    updateRefMailTags(paramSQLiteDatabase, paramArrayOfLong, paramArrayOfString1, getTagListFromIds(localHashMap, paramArrayOfString2));
  }
  
  public void topMails(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong, boolean paramBoolean)
  {
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length <= 0)) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("isTopped", Boolean.valueOf(paramBoolean));
    paramSQLiteDatabase.update("QM_MAIL_INFO", localContentValues, "id IN " + getInClause(paramArrayOfLong), null);
    paramSQLiteDatabase.update("QM_TMP_SEARCH_MAIL_INFO", localContentValues, "id IN " + getInClause(paramArrayOfLong), null);
    updateConvMailStatus(paramSQLiteDatabase, paramArrayOfLong, localContentValues);
  }
  
  public void unreadMails(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong, boolean paramBoolean)
  {
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length <= 0)) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("isUnread", Boolean.valueOf(paramBoolean));
    updateConvMailStatus(paramSQLiteDatabase, paramArrayOfLong, localContentValues);
    updateConvMailParentUnread(paramSQLiteDatabase, paramArrayOfLong);
    updateTempSearchMail(paramSQLiteDatabase, paramArrayOfLong, localContentValues);
    updateAdvertiseConvUnread(paramSQLiteDatabase);
  }
  
  public void updateAdvertiseConv(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    if (paramInt != 0) {
      if (!updateAggregateConv(paramSQLiteDatabase, 0, 2048L)) {
        deleteAggregateConv(paramSQLiteDatabase, 0, 2048L);
      }
    }
    for (;;)
    {
      return;
      if (!updateAggregateConv(paramSQLiteDatabase, paramInt, 2048L))
      {
        deleteAggregateConv(paramSQLiteDatabase, paramInt, 2048L);
        return;
        if (!updateAggregateConv(paramSQLiteDatabase, paramInt, 2048L)) {
          break;
        }
        Iterator localIterator = AccountManager.shareInstance().getAccountList().iterator();
        while (localIterator.hasNext())
        {
          Account localAccount = (Account)localIterator.next();
          if (!updateAggregateConv(paramSQLiteDatabase, localAccount.getId(), 2048L)) {
            deleteAggregateConv(paramSQLiteDatabase, localAccount.getId(), 2048L);
          }
        }
      }
    }
    deleteAggregateConv(paramSQLiteDatabase, 0, 2048L);
  }
  
  public void updateAttendeeStatus(SQLiteDatabase paramSQLiteDatabase, QMCalendarEvent paramQMCalendarEvent)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("attendee", Attendee.genertateAttendeeToString(paramQMCalendarEvent.getAttendees()));
    paramSQLiteDatabase.update("QM_ICS_EVENT", localContentValues, "id=?", new String[] { String.valueOf(paramQMCalendarEvent.getId()) });
  }
  
  public void updateContentCompleteAttr(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      updateMailAttr(paramSQLiteDatabase, paramArrayOfLong, 16777216L);
      return;
    }
    resetMailAttr(paramSQLiteDatabase, paramArrayOfLong, 16777216L);
  }
  
  public void updateConvMailChilds(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    ContentValues localContentValues = new ContentValues();
    if (paramBoolean) {}
    for (paramInt1 = -1;; paramInt1 = 0)
    {
      localContentValues.put("convType", Integer.valueOf(paramInt1));
      paramSQLiteDatabase.update("QM_MAIL_INFO", localContentValues, "convHash=? AND folderId=?", new String[] { String.valueOf(paramInt2), String.valueOf(paramInt3) });
      return;
    }
  }
  
  public void updateConvMailConvCount(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    paramSQLiteDatabase.execSQL("UPDATE QM_MAIL_INFO SET convCnt=convCnt+1 WHERE id IN (SELECT id FROM QM_MAIL_INFO WHERE convHash=? AND convType=1)", new String[] { String.valueOf(paramInt) });
  }
  
  public void updateConvMailStatus(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt)
  {
    paramSQLiteDatabase.execSQL(sqlUpdateConvStatus.replace("$inClause$", getInClause(paramArrayOfInt)));
  }
  
  public void updateConvMailStatus(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong)
  {
    paramSQLiteDatabase.execSQL(sqlUpdateConvStatusByIds.replace("$inClause$", getInClause(paramArrayOfLong)));
  }
  
  public void updateConvMailType(SQLiteDatabase paramSQLiteDatabase, int paramInt1, long[] paramArrayOfLong, int paramInt2, boolean paramBoolean)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("convType", Integer.valueOf(paramInt2));
    if (paramBoolean) {}
    for (String str = "QM_TMP_SEARCH_MAIL_INFO";; str = "QM_MAIL_INFO")
    {
      paramSQLiteDatabase.update(str, localContentValues, "folderId=? AND id IN" + getInClause(paramArrayOfLong), new String[] { String.valueOf(paramInt1) });
      return;
    }
  }
  
  public void updateDetectLanguageAttrAfterDomRender(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l1 = 0L;
    if (paramBoolean1) {
      l1 = 0L | 0x0;
    }
    long l2 = l1;
    if (paramBoolean2) {
      l2 = l1 | 0x0;
    }
    paramSQLiteDatabase.execSQL("UPDATE QM_MAIL_INFO SET attr=attr|(?) WHERE id IN$inClause$".replace("$inClause$", getInClause(paramArrayOfLong)), new Object[] { Long.valueOf(l2) });
  }
  
  public void updateDetectLanguageAttrByMailContent(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l1 = 0L;
    if (paramBoolean1) {
      l1 = 0L | 0x2;
    }
    long l2 = l1;
    if (paramBoolean2) {
      l2 = l1 | 0x0;
    }
    paramSQLiteDatabase.execSQL("UPDATE QM_MAIL_INFO SET attr=attr|(?) WHERE id IN$inClause$ AND (attr&8589934592=0)".replace("$inClause$", getInClause(paramArrayOfLong)), new Object[] { Long.valueOf(l2) });
  }
  
  public void updateEmlMailAttr(SQLiteDatabase paramSQLiteDatabase, @NonNull Mail paramMail)
  {
    long l1 = paramMail.getInformation().getId();
    long l2 = getMailAttr(paramMail, 0L);
    updateEmlMailAttr(paramSQLiteDatabase, new long[] { l1 }, l2);
  }
  
  public void updateEmlMailAttr(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong, long paramLong)
  {
    paramSQLiteDatabase.execSQL("UPDATE QM_MAIL_INFO SET attr=attr|(?) WHERE id IN$inClause$".replace("QM_MAIL_INFO", "QM_TMP_EML_MAIL_INFO").replace("$inClause$", getInClause(paramArrayOfLong)), new Object[] { Long.valueOf(paramLong) });
  }
  
  public void updateEventDecline(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt)
  {
    paramSQLiteDatabase.execSQL("update QM_ICS_EVENT set isDecline = 1  WHERE uid =? AND accountId=?", new String[] { paramString, String.valueOf(paramInt) });
  }
  
  public void updateMailAbstract(SQLiteDatabase paramSQLiteDatabase, long paramLong, String paramString)
  {
    paramSQLiteDatabase.execSQL("UPDATE QM_MAIL_INFO SET abstract=? WHERE id=?", new Object[] { paramString, Long.valueOf(paramLong) });
  }
  
  public void updateMailAttr(SQLiteDatabase paramSQLiteDatabase, @NonNull Mail paramMail)
  {
    long l1 = paramMail.getInformation().getId();
    long l2 = getMailAttr(paramMail, 0L);
    updateMailAttr(paramSQLiteDatabase, new long[] { l1 }, l2);
  }
  
  public void updateMailAttr(SQLiteDatabase paramSQLiteDatabase, @NonNull long[] paramArrayOfLong, long paramLong)
  {
    paramSQLiteDatabase.execSQL("UPDATE QM_MAIL_INFO SET attr=attr|(?) WHERE id IN$inClause$".replace("$inClause$", getInClause(paramArrayOfLong)), new Object[] { Long.valueOf(paramLong) });
  }
  
  public void updateMailConvHash(SQLiteDatabase paramSQLiteDatabase, long paramLong, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "UPDATE QM_MAIL_INFO SET convHash=? WHERE id=?".replace("QM_MAIL_INFO", "QM_TMP_SEARCH_MAIL_INFO");; str = "UPDATE QM_MAIL_INFO SET convHash=? WHERE id=?")
    {
      paramSQLiteDatabase.execSQL(str, new String[] { String.valueOf(paramInt), String.valueOf(paramLong) });
      return;
    }
  }
  
  public void updateMailInfo(SQLiteDatabase paramSQLiteDatabase, int paramInt1, Mail paramMail, int paramInt2)
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt1);
    MailInformation localMailInformation = paramMail.getInformation();
    MailStatus localMailStatus = paramMail.getStatus();
    long l2 = localMailInformation.getId();
    Object localObject3 = localMailInformation.getTagList();
    Object localObject1 = "";
    Object localObject2 = localObject1;
    if (localObject3 != null)
    {
      localObject2 = localObject1;
      if (((ArrayList)localObject3).size() > 0)
      {
        localObject2 = ((ArrayList)localObject3).iterator();
        localObject1 = "";
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((Iterator)localObject2).next();
          Object localObject4 = (MailTag)localObject3;
          localObject4 = ((MailTag)localObject4).getTagId() + "." + ((MailTag)localObject4).getColor() + "." + ((MailTag)localObject4).getName();
          localObject1 = (String)localObject1 + (String)localObject4 + "|";
          localObject3 = ((MailTag)localObject3).getTagId();
          paramSQLiteDatabase.execSQL("REPLACE INTO QM_REF_MAIL_TAG (uid,mid,tagId) VALUES (?,?,?)", new Object[] { Long.valueOf(genRMTId(l2, (String)localObject3)), Long.valueOf(l2), localObject3 });
        }
        localObject2 = localObject1;
      }
    }
    int i = paramMail.getInformation().getFolderId();
    localObject1 = QMFolderManager.sharedInstance().getFolder(i);
    i = 0;
    int j = i;
    if (localObject1 != null)
    {
      j = i;
      if (((QMFolder)localObject1).getType() == 4) {
        j = 1;
      }
    }
    localObject1 = "QM_MAIL_INFO";
    i = 1;
    label673:
    long l1;
    label816:
    label1095:
    boolean bool2;
    if ((paramInt2 & 0x40) != 0)
    {
      localObject1 = "QM_TMP_EML_MAIL_INFO";
      i = 0;
      localObject3 = new ContentValues();
      if (localMailStatus.isProtocolMail()) {
        ((ContentValues)localObject3).put("convType", Integer.valueOf(localMailInformation.getConvType()));
      }
      bool1 = localMailStatus.isLoaded();
      if (bool1) {
        ((ContentValues)localObject3).put("isLoaded", Boolean.valueOf(bool1));
      }
      if (!localAccount.isPopMail()) {
        ((ContentValues)localObject3).put("isUnread", Boolean.valueOf(localMailStatus.isUnread()));
      }
      if (localMailStatus.getSendStatus() != 0) {
        ((ContentValues)localObject3).put("sendStatus", Integer.valueOf(localMailStatus.getSendStatus()));
      }
      if (localMailInformation.getLocalCount() != -1) {
        ((ContentValues)localObject3).put("localCount", Integer.valueOf(localMailInformation.getLocalCount()));
      }
      if (localMailInformation.getSendUtc() != -1L) {
        ((ContentValues)localObject3).put("sendutc", Long.valueOf(localMailInformation.getSendUtc()));
      }
      ((ContentValues)localObject3).put("tags", (String)localObject2);
      ((ContentValues)localObject3).put("isStar", Boolean.valueOf(localMailStatus.isStarred()));
      ((ContentValues)localObject3).put("convCnt", Integer.valueOf(localMailInformation.getConvCount()));
      ((ContentValues)localObject3).put("convUrCnt", Integer.valueOf(localMailInformation.getConvUrCnt()));
      ((ContentValues)localObject3).put("qqAdType", Integer.valueOf(localMailInformation.getQQmailAdType()));
      ((ContentValues)localObject3).put("xqqstyle", Integer.valueOf(localMailStatus.getXQQStyle()));
      ((ContentValues)localObject3).put("toppedAdTime", Long.valueOf(localMailStatus.getToppedAdTime()));
      if (localMailInformation.getFolderId() != 0) {
        ((ContentValues)localObject3).put("folderId", Integer.valueOf(localMailInformation.getFolderId()));
      }
      if (((paramInt2 & 0x800) != 0) || (paramMail.canContentChange()))
      {
        ((ContentValues)localObject3).put("utcSent", Long.valueOf(localMailInformation.getDate().getTime()));
        ((ContentValues)localObject3).put("utcReceived", Long.valueOf(localMailInformation.getDate().getTime()));
      }
      if ((localMailInformation.getConvHash() & 0x2) == 0) {
        break label1202;
      }
      ((ContentValues)localObject3).put("convHash", Integer.valueOf(localMailInformation.getConvHash()));
      if ((localMailStatus.isAdConv()) || (localMailStatus.isSubscribeConv()) || (localMailStatus.isHybirdList()) || (localMailStatus.isLocalMail()) || (localMailStatus.isConversation()) || (j != 0))
      {
        ((ContentValues)localObject3).put("abstract", localMailInformation.getAbstractContent());
        ((ContentValues)localObject3).put("subject", localMailInformation.getSubject());
      }
      if ((localMailStatus.isConversation()) || (j != 0))
      {
        ((ContentValues)localObject3).put("fromAddr", localMailInformation.getFrom().getAddress());
        ((ContentValues)localObject3).put("fromAddrName", localMailInformation.getFrom().getName());
        if (localMailInformation.getFrom().getId() != 0L) {
          break label1254;
        }
        l1 = genRMAAddrId(localMailInformation.getFrom().getAddress());
        ((ContentValues)localObject3).put("fromAddrId", Long.valueOf(l1));
      }
      if ((localMailInformation.getSender() != null) && (!StringUtil.isNullOrEmpty(localMailInformation.getSender().getAddress())))
      {
        ((ContentValues)localObject3).put("fromAddr", localMailInformation.getFrom().getAddress());
        ((ContentValues)localObject3).put("fromAddrName", localMailInformation.getFrom().getName());
        if (localMailInformation.getFrom().getId() != 0L) {
          break label1267;
        }
        l1 = genRMAAddrId(localMailInformation.getFrom().getAddress());
        label910:
        ((ContentValues)localObject3).put("fromAddrId", Long.valueOf(l1));
        ((ContentValues)localObject3).put("senderAddr", localMailInformation.getSender().getAddress());
        ((ContentValues)localObject3).put("senderAddrName", localMailInformation.getSender().getName());
      }
      if (localMailStatus.getCheat() != 0)
      {
        QMLog.log(3, "yecongtest", "update db cheat: " + localMailStatus.getCheat());
        ((ContentValues)localObject3).put("qqSpamType", Integer.valueOf(localMailStatus.getCheat()));
      }
      paramSQLiteDatabase.update((String)localObject1, (ContentValues)localObject3, "id=?", new String[] { String.valueOf(l2) });
      if (i != 0) {
        insertMailInfoFts(paramSQLiteDatabase, localMailInformation);
      }
      if (localMailStatus.isGroupMail()) {
        break label1292;
      }
      if (((paramInt2 & 0x400) != 0) || ((!bool1) && (localMailStatus.isConversation())))
      {
        deleteAllMailRefContacts(paramSQLiteDatabase, l2);
        if ((paramInt2 & 0x80) == 0) {
          break label1280;
        }
        bool1 = true;
        if ((paramInt2 & 0x40) == 0) {
          break label1286;
        }
        bool2 = true;
        label1106:
        insertMailContacts(paramSQLiteDatabase, paramMail, bool1, bool2);
      }
      localObject1 = QMAttachManager.sharedInstance();
      if ((paramInt2 & 0x40) == 0) {
        break label1373;
      }
    }
    label1202:
    label1332:
    label1367:
    label1373:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((QMAttachManager)localObject1).updateMailAttaches(paramSQLiteDatabase, paramInt1, localMailInformation, bool1);
      if (!localMailStatus.isAppleIdMail()) {
        resetMailAttr(paramSQLiteDatabase, new long[] { l2 }, 34359738368L);
      }
      if ((paramInt2 & 0x40) == 0) {
        break label1379;
      }
      updateEmlMailAttr(paramSQLiteDatabase, paramMail);
      return;
      if ((paramInt2 & 0x80) == 0) {
        break;
      }
      localObject1 = "QM_TMP_SEARCH_MAIL_INFO";
      i = 0;
      break;
      localObject2 = new ContentValues();
      ((ContentValues)localObject2).put("convHash", Integer.valueOf(localMailInformation.getConvHash()));
      paramSQLiteDatabase.update((String)localObject1, (ContentValues)localObject2, "id=? AND NOT convHash&2", new String[] { String.valueOf(l2) });
      break label673;
      label1254:
      l1 = localMailInformation.getFrom().getId();
      break label816;
      label1267:
      l1 = localMailInformation.getFrom().getId();
      break label910;
      bool1 = false;
      break label1095;
      bool2 = false;
      break label1106;
      localObject1 = paramMail.getInformation().getFrom();
      ((MailContact)localObject1).setUin(((MailContact)localObject1).getAddress().replace("@groupmail.qq.com", ""));
      if ((paramInt2 & 0x80) != 0)
      {
        bool1 = true;
        if ((paramInt2 & 0x40) == 0) {
          break label1367;
        }
      }
      for (bool2 = true;; bool2 = false)
      {
        insertMailContact(paramSQLiteDatabase, l2, (MailContact)localObject1, 5, 0, bool1, bool2);
        break;
        bool1 = false;
        break label1332;
      }
    }
    label1280:
    label1286:
    label1292:
    label1379:
    if ((paramInt2 & 0x80) != 0)
    {
      updateSearchMailAttr(paramSQLiteDatabase, paramMail);
      return;
    }
    updateMailAttr(paramSQLiteDatabase, paramMail);
  }
  
  public void updateMailInfo(SQLiteDatabase paramSQLiteDatabase, int paramInt, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String[] paramArrayOfString4)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = null;
    if (paramArrayOfString1.length > 0)
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("isUnread", Boolean.valueOf(false));
      localObject = getInClause(paramArrayOfString1);
      localStringBuilder.append("remoteId IN" + (String)localObject);
      paramSQLiteDatabase.update("QM_MAIL_INFO", localContentValues, "folderId=? AND remoteId IN" + (String)localObject, arrayOfString);
    }
    paramArrayOfString1 = (String[])localObject;
    if (paramArrayOfString2.length > 0)
    {
      if (localObject != null) {
        localStringBuilder.append(" OR ");
      }
      localObject = new ContentValues();
      ((ContentValues)localObject).put("isUnread", Boolean.valueOf(true));
      paramArrayOfString1 = getInClause(paramArrayOfString2);
      localStringBuilder.append("remoteId IN" + paramArrayOfString1);
      paramSQLiteDatabase.update("QM_MAIL_INFO", (ContentValues)localObject, "folderId=? AND remoteId IN" + paramArrayOfString1, arrayOfString);
    }
    paramArrayOfString2 = paramArrayOfString1;
    if (paramArrayOfString3 != null)
    {
      paramArrayOfString2 = paramArrayOfString1;
      if (paramArrayOfString3.length > 0)
      {
        if (paramArrayOfString1 != null) {
          localStringBuilder.append(" OR ");
        }
        paramArrayOfString1 = new ContentValues();
        paramArrayOfString1.put("isStar", Boolean.valueOf(true));
        paramArrayOfString2 = getInClause(paramArrayOfString3);
        localStringBuilder.append("remoteId IN" + paramArrayOfString2);
        paramSQLiteDatabase.update("QM_MAIL_INFO", paramArrayOfString1, "folderId=? AND remoteId IN" + paramArrayOfString2, arrayOfString);
      }
    }
    paramArrayOfString1 = paramArrayOfString2;
    if (paramArrayOfString4 != null)
    {
      paramArrayOfString1 = paramArrayOfString2;
      if (paramArrayOfString4.length > 0)
      {
        if (paramArrayOfString2 != null) {
          localStringBuilder.append(" OR ");
        }
        paramArrayOfString2 = new ContentValues();
        paramArrayOfString2.put("isStar", Boolean.valueOf(false));
        paramArrayOfString1 = getInClause(paramArrayOfString4);
        localStringBuilder.append("remoteId IN" + paramArrayOfString1);
        paramSQLiteDatabase.update("QM_MAIL_INFO", paramArrayOfString2, "folderId=? AND remoteId IN" + paramArrayOfString1, arrayOfString);
      }
    }
    if (paramArrayOfString1 != null)
    {
      paramArrayOfString1 = null;
      paramArrayOfString2 = null;
      paramArrayOfString3 = paramSQLiteDatabase.rawQuery("SELECT DISTINCT convHash FROM QM_MAIL_INFO WHERE folderId=? AND (" + localStringBuilder.toString() + ")", arrayOfString);
      if (paramArrayOfString3 != null)
      {
        int i = paramArrayOfString3.getCount();
        paramArrayOfString1 = paramArrayOfString2;
        if (i > 0)
        {
          paramArrayOfString2 = new int[i];
          paramInt = 0;
          for (;;)
          {
            paramArrayOfString1 = paramArrayOfString2;
            if (paramInt >= i) {
              break;
            }
            paramArrayOfString3.moveToPosition(paramInt);
            paramArrayOfString2[paramInt] = paramArrayOfString3.getInt(0);
            paramInt += 1;
          }
        }
        paramArrayOfString3.close();
      }
      if (paramArrayOfString1 != null) {
        updateConvMailStatus(paramSQLiteDatabase, paramArrayOfString1);
      }
    }
  }
  
  public void updateMailInfo(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean, Mail paramMail)
  {
    if (paramMail == null) {
      throw new IllegalArgumentException("use a initialized mail");
    }
    String str = "SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE id=?";
    if (paramBoolean) {
      str = "SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE id=?".replace("QM_MAIL_INFO", "QM_TMP_SEARCH_MAIL_INFO");
    }
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(str, new String[] { String.valueOf(paramMail.getInformation().getId()) });
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst()) {
        fillMailInfo(paramSQLiteDatabase, paramMail.getInformation(), null);
      }
      paramSQLiteDatabase.close();
    }
  }
  
  public boolean updateMailInfoCheat(SQLiteDatabase paramSQLiteDatabase, long paramLong, int paramInt)
  {
    try
    {
      paramSQLiteDatabase.execSQL("UPDATE QM_MAIL_INFO SET qqSpamType= ?  WHERE id=? ", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
      return true;
    }
    catch (Exception paramSQLiteDatabase) {}
    return false;
  }
  
  public void updateMailInfoFtsAttach(SQLiteDatabase paramSQLiteDatabase, MailInformation paramMailInformation)
  {
    if (paramMailInformation != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject2;
      if ((paramMailInformation.getAttachList() != null) && (paramMailInformation.getAttachList().size() > 0))
      {
        localObject1 = paramMailInformation.getAttachList().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          if ((localObject2 instanceof Attach))
          {
            localObject2 = (Attach)localObject2;
            localStringBuilder.append(((Attach)localObject2).getName() + " ");
          }
        }
      }
      if ((paramMailInformation.getBigAttachList() != null) && (paramMailInformation.getBigAttachList().size() > 0))
      {
        localObject1 = paramMailInformation.getBigAttachList().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          if ((localObject2 instanceof MailBigAttach))
          {
            localObject2 = (MailBigAttach)localObject2;
            localStringBuilder.append(((MailBigAttach)localObject2).getName() + " ");
          }
        }
      }
      if ((paramMailInformation.getEditAttachList() != null) && (paramMailInformation.getEditAttachList().size() > 0))
      {
        localObject1 = paramMailInformation.getEditAttachList().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          if ((localObject2 instanceof MailEditAttach))
          {
            localObject2 = (MailEditAttach)localObject2;
            localStringBuilder.append(((MailEditAttach)localObject2).getName() + " ");
          }
        }
      }
      Object localObject1 = new ContentValues();
      ((ContentValues)localObject1).put("attachName", localStringBuilder.toString());
      paramSQLiteDatabase.update("QM_MAIL_INFO_FTS_SEARCH", (ContentValues)localObject1, "docid=?", new String[] { paramMailInformation.getId() + "" });
    }
  }
  
  public void updateMailLoaded(SQLiteDatabase paramSQLiteDatabase, long paramLong, boolean paramBoolean)
  {
    updateMailLoaded(paramSQLiteDatabase, new long[] { paramLong }, paramBoolean);
  }
  
  public void updateMailLoaded(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong, boolean paramBoolean)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("isLoaded", Boolean.valueOf(paramBoolean));
    paramSQLiteDatabase.update("QM_MAIL_INFO", localContentValues, "id IN " + getInClause(paramArrayOfLong), null);
  }
  
  public void updateMailLoadedWhenUTCChanged(SQLiteDatabase paramSQLiteDatabase, long paramLong1, long paramLong2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("isLoaded", Boolean.valueOf(false));
    paramSQLiteDatabase.update("QM_MAIL_INFO", localContentValues, "id=? AND utcSent!= ?", new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) });
  }
  
  public void updateMailRecentOpTime(SQLiteDatabase paramSQLiteDatabase, ArrayList<Long> paramArrayList)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("utcRecentOpr", Long.valueOf(new Date().getTime()));
    String[] arrayOfString = new String[paramArrayList.size()];
    int i = 0;
    while (i < paramArrayList.size())
    {
      arrayOfString[i] = String.valueOf(paramArrayList.get(i));
      i += 1;
    }
    paramSQLiteDatabase.update("QM_MAIL_INFO", localContentValues, "id IN " + getInClause(paramArrayList.size()), arrayOfString);
  }
  
  public void updateMailRecentOpTime(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("utcRecentOpr", Long.valueOf(new Date().getTime()));
    String[] arrayOfString = new String[paramArrayOfLong.length];
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      arrayOfString[i] = String.valueOf(paramArrayOfLong[i]);
      i += 1;
    }
    paramSQLiteDatabase.update("QM_MAIL_INFO", localContentValues, "id IN " + getInClause(paramArrayOfLong.length), arrayOfString);
  }
  
  public void updateMailSendUtc(SQLiteDatabase paramSQLiteDatabase, long paramLong1, long paramLong2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("sendutc", Long.valueOf(paramLong2));
    paramSQLiteDatabase.update("QM_MAIL_INFO", localContentValues, "id=?", new String[] { String.valueOf(paramLong1) });
  }
  
  public void updateMailStatus(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = String.valueOf(paramInt);
    arrayOfString[1] = paramString;
    paramString = new ContentValues();
    paramString.put("isUnread", Boolean.valueOf(paramBoolean1));
    paramString.put("isStar", Boolean.valueOf(paramBoolean2));
    paramSQLiteDatabase.update("QM_MAIL_INFO", paramString, "folderId=? AND remoteId=?", arrayOfString);
    paramSQLiteDatabase.execSQL(sqlUpdateConvStatus.replace("$inClause$", "(SELECT convHash FROM QM_MAIL_INFO WHERE folderId=? AND remoteId=?)"), arrayOfString);
  }
  
  public void updateMailStatus(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean, Mail paramMail)
  {
    if (paramMail == null) {
      throw new IllegalArgumentException("use a initialized mail");
    }
    String str = "SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE id=?";
    if (paramBoolean) {
      str = "SELECT M.*, R.ruleType FROM QM_MAIL_INFO AS M  LEFT OUTER JOIN QM_RULE_AD AS R ON M.fromAddrId=R.ruleAddrId WHERE id=?".replace("QM_MAIL_INFO", "QM_TMP_SEARCH_MAIL_INFO");
    }
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(str, new String[] { String.valueOf(paramMail.getInformation().getId()) });
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst()) {
        fillMailStatus(paramMail.getInformation().getAccountId(), paramSQLiteDatabase, null, paramMail.getInformation().getConvType(), paramMail.getStatus());
      }
      paramSQLiteDatabase.close();
    }
  }
  
  public void updateMailUTC(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean, Mail paramMail)
  {
    if ((paramMail == null) || (paramMail.getInformation() == null)) {
      throw new IllegalArgumentException("use a initialized mail");
    }
    if (paramBoolean) {}
    for (long l = getSearchMailUTC(paramSQLiteDatabase, paramMail.getInformation().getAccountId(), paramMail.getInformation().getRemoteId());; l = getMailUTC(paramSQLiteDatabase, paramMail.getInformation().getAccountId(), paramMail.getInformation().getRemoteId()))
    {
      paramMail.getInformation().setDate(new Date(l));
      paramMail.getInformation().setUtc(new Date(l));
      return;
    }
  }
  
  public void updateMailUtc(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong, long paramLong1, long paramLong2, long paramLong3)
  {
    paramSQLiteDatabase.execSQL("UPDATE QM_MAIL_INFO SET utcSent=?, utcReceived=?, utcRecentOpr=? WHERE id IN$inClause$".replace("$inClause$", getInClause(paramArrayOfLong)), new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
  }
  
  public void updateMailsFolderId(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (paramInt != 0)
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("folderId", Integer.valueOf(paramInt));
        paramSQLiteDatabase.update("QM_MAIL_INFO", localContentValues, "folderId IN " + getInClause(paramArrayOfInt), null);
      }
    }
    else {
      return;
    }
    deleteMailsByFolderIds(paramSQLiteDatabase, paramArrayOfInt);
  }
  
  public void updateNeedSyncAttr(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      updateMailAttr(paramSQLiteDatabase, paramArrayOfLong, 256L);
      return;
    }
    resetMailAttr(paramSQLiteDatabase, paramArrayOfLong, 256L);
  }
  
  public void updateNotChildConvMailType(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("convType", Integer.valueOf(0));
    paramSQLiteDatabase.update("QM_MAIL_INFO", localContentValues, "convType=-1 AND id IN" + getInClause(paramArrayOfLong), null);
  }
  
  public int updatePopInConvMailAbstract(SQLiteDatabase paramSQLiteDatabase, int paramInt, long paramLong, String paramString)
  {
    String str = String.valueOf(paramLong);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("abstract", paramString);
    return paramSQLiteDatabase.update("QM_MAIL_INFO", localContentValues, "id=? OR id IN ( SELECT id FROM QM_MAIL_INFO INNER JOIN ( SELECT convHash AS ch, utcSent AS us,attr AS at FROM QM_MAIL_INFO AS mi WHERE id=? ) ON ((convHash=ch AND convType=1) OR (at&512 AND attr&2048)) AND utcSent=us )", new String[] { str, str });
  }
  
  public void updateQQMailConvHash(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    label38:
    label122:
    long l;
    if (paramBoolean)
    {
      localObject1 = "UPDATE QM_MAIL_INFO SET convHash=? WHERE id IN$inClause$".replace("QM_MAIL_INFO", "QM_TMP_SEARCH_MAIL_INFO");
      if (!paramBoolean) {
        break label233;
      }
      localObject2 = "SELECT id FROM QM_MAIL_INFO WHERE folderId=? AND convHash=? AND id NOT IN$inClause$".replace("QM_MAIL_INFO", "QM_TMP_SEARCH_MAIL_INFO");
      paramArrayOfLong = getInClause(paramArrayOfLong);
      String str = String.valueOf(paramInt3);
      paramSQLiteDatabase.execSQL(((String)localObject1).replace("$inClause$", paramArrayOfLong), new String[] { str });
      localObject1 = paramSQLiteDatabase.rawQuery(((String)localObject2).replace("$inClause$", paramArrayOfLong), new String[] { String.valueOf(paramInt2), str });
      if (localObject1 == null) {
        return;
      }
      paramInt3 = ((Cursor)localObject1).getCount();
      paramInt2 = 0;
      if (paramInt2 >= paramInt3) {
        break label248;
      }
      ((Cursor)localObject1).moveToPosition(paramInt2);
      l = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndex("id"));
      localObject2 = new ContentValues();
      ((ContentValues)localObject2).put("convHash", Integer.valueOf(Mail.generateConvQQIdHash(paramInt1, l)));
      if (!paramBoolean) {
        break label241;
      }
    }
    label233:
    label241:
    for (paramArrayOfLong = "QM_TMP_SEARCH_MAIL_INFO";; paramArrayOfLong = "QM_MAIL_INFO")
    {
      paramSQLiteDatabase.update(paramArrayOfLong, (ContentValues)localObject2, "id=?", new String[] { String.valueOf(l) });
      paramInt2 += 1;
      break label122;
      localObject1 = "UPDATE QM_MAIL_INFO SET convHash=? WHERE id IN$inClause$";
      break;
      localObject2 = "SELECT id FROM QM_MAIL_INFO WHERE folderId=? AND convHash=? AND id NOT IN$inClause$";
      break label38;
    }
    label248:
    ((Cursor)localObject1).close();
  }
  
  public void updateRefMailTags(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong, ArrayList<Object> paramArrayList1, ArrayList<Object> paramArrayList2)
  {
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l1 = paramArrayOfLong[i];
      Iterator localIterator = paramArrayList1.iterator();
      long l2;
      while (localIterator.hasNext())
      {
        Object localObject1 = localIterator.next();
        if ((localObject1 instanceof MailTag))
        {
          localObject1 = (MailTag)localObject1;
          l2 = genRMTId(l1, ((MailTag)localObject1).getTagId());
          localObject1 = ((MailTag)localObject1).getTagId();
          try
          {
            paramSQLiteDatabase.execSQL("REPLACE INTO QM_REF_MAIL_TAG (uid,mid,tagId) VALUES (?,?,?)", new Object[] { Long.valueOf(l2), Long.valueOf(l1), localObject1 });
          }
          catch (Exception localException1)
          {
            Log.e("QMMailSQLite", Log.getStackTraceString(localException1));
          }
        }
      }
      localIterator = paramArrayList2.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        if ((localObject2 instanceof MailTag))
        {
          l2 = genRMTId(l1, ((MailTag)localObject2).getTagId());
          try
          {
            paramSQLiteDatabase.delete("QM_REF_MAIL_TAG", "uid =? ", new String[] { l2 + "" });
          }
          catch (Exception localException2)
          {
            Log.e("QMMailSQLite", Log.getStackTraceString(localException2));
          }
        }
      }
      i += 1;
    }
  }
  
  public void updateSearchContentCompleteAttr(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      updateSearchMailAttr(paramSQLiteDatabase, paramArrayOfLong, 16777216L);
      return;
    }
    resetSearchMailAttr(paramSQLiteDatabase, paramArrayOfLong, 16777216L);
  }
  
  public void updateSearchMailAttr(SQLiteDatabase paramSQLiteDatabase, Mail paramMail)
  {
    long l1 = paramMail.getInformation().getId();
    long l2 = getMailAttr(paramMail, 0L);
    updateSearchMailAttr(paramSQLiteDatabase, new long[] { l1 }, l2);
  }
  
  public void updateSearchMailAttr(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong, long paramLong)
  {
    paramSQLiteDatabase.execSQL("UPDATE QM_MAIL_INFO SET attr=attr|(?) WHERE id IN$inClause$".replace("QM_MAIL_INFO", "QM_TMP_SEARCH_MAIL_INFO").replace("$inClause$", getInClause(paramArrayOfLong)), new Object[] { Long.valueOf(paramLong) });
  }
  
  public void updateSearchMailLoaded(SQLiteDatabase paramSQLiteDatabase, long paramLong, boolean paramBoolean)
  {
    updateSearchMailLoaded(paramSQLiteDatabase, new long[] { paramLong }, paramBoolean);
  }
  
  public void updateSearchMailLoaded(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong, boolean paramBoolean)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("isLoaded", Boolean.valueOf(paramBoolean));
    paramSQLiteDatabase.update("QM_TMP_SEARCH_MAIL_INFO", localContentValues, "id IN " + getInClause(paramArrayOfLong), null);
  }
  
  public void updateSearchNeedSyncAttr(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      updateSearchMailAttr(paramSQLiteDatabase, paramArrayOfLong, 256L);
      return;
    }
    resetSearchMailAttr(paramSQLiteDatabase, paramArrayOfLong, 256L);
  }
  
  public void updateSubscribeConv(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    if (paramInt != 0) {
      if (!updateAggregateConv(paramSQLiteDatabase, paramInt, 8192L)) {
        deleteAggregateConv(paramSQLiteDatabase, paramInt, 8192L);
      }
    }
    for (;;)
    {
      return;
      Iterator localIterator = AccountManager.shareInstance().getAccountList().iterator();
      while (localIterator.hasNext())
      {
        Account localAccount = (Account)localIterator.next();
        if (!updateAggregateConv(paramSQLiteDatabase, localAccount.getId(), 8192L)) {
          deleteAggregateConv(paramSQLiteDatabase, localAccount.getId(), 8192L);
        }
      }
    }
  }
  
  public void upgradeFtsInsertMailContent(SQLiteDatabase paramSQLiteDatabase, long paramLong, String paramString)
  {
    try
    {
      paramSQLiteDatabase.execSQL("REPLACE INTO QM_MAIL_CONTENT_FTS_SEARCH ( docid,content) VALUES (?,?)", new Object[] { Long.valueOf(paramLong), MailUtil.removeContentTag(paramString) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "QMMailSQLite", "insert mail content fts fail: " + paramLong + "\n" + Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public MailInformation upgradeFtsQueryMailInfo(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT id, senderAddr, senderAddrName, fromAddr, fromAddrName, subject,abstract FROM QM_MAIL_INFO WHERE id=?", new String[] { String.valueOf(paramLong) });
    Object localObject1 = null;
    MailInformation localMailInformation = null;
    Object localObject3;
    Object localObject2;
    if (localCursor != null)
    {
      localObject1 = localMailInformation;
      if (localCursor.moveToFirst())
      {
        localMailInformation = new MailInformation();
        localMailInformation.setId(localCursor.getLong(localCursor.getColumnIndex("id")));
        localMailInformation.setSubject(localCursor.getString(localCursor.getColumnIndex("subject")));
        localMailInformation.setAbstractContent(localCursor.getString(localCursor.getColumnIndex("abstract")));
        localObject3 = new MailContact();
        ((MailContact)localObject3).setAddress(localCursor.getString(localCursor.getColumnIndex("fromAddr")));
        localObject2 = localCursor.getString(localCursor.getColumnIndex("fromAddrName"));
        localObject1 = localObject2;
        if (StringExtention.isNullOrEmpty((String)localObject2)) {
          if ((((MailContact)localObject3).getAddress() == null) || (!((MailContact)localObject3).getAddress().contains("@"))) {
            break label394;
          }
        }
      }
    }
    label394:
    for (localObject1 = localObject3.getAddress().split("@")[0];; localObject1 = QMApplicationContext.sharedInstance().getResources().getString(2131693125))
    {
      ((MailContact)localObject3).setName((String)localObject1);
      ((MailContact)localObject3).setNick((String)localObject1);
      localMailInformation.setFrom((MailContact)localObject3);
      localObject1 = new MailContact();
      ((MailContact)localObject1).setAddress(localCursor.getString(localCursor.getColumnIndex("senderAddr")));
      ((MailContact)localObject1).setName(localCursor.getString(localCursor.getColumnIndex("senderAddrName")));
      localMailInformation.setSender((MailContact)localObject1);
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      localObject3 = new ArrayList();
      setReceiveList(paramSQLiteDatabase, paramLong, (ArrayList)localObject1, (ArrayList)localObject2, (ArrayList)localObject3);
      localMailInformation.setToList((ArrayList)localObject1);
      localMailInformation.setCcList((ArrayList)localObject2);
      localMailInformation.setBccList((ArrayList)localObject3);
      localMailInformation.setAttachList(QMAttachSQLite.getAttachNameListByMailId(paramSQLiteDatabase, paramLong));
      localMailInformation.setBigAttachList(QMAttachSQLite.getBigAttachNameListByMailId(paramSQLiteDatabase, paramLong));
      localObject1 = localMailInformation;
      localCursor.close();
      return localObject1;
    }
  }
  
  public void upgradeTableFor3002(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_RULE_MAIL (ruleId integer primary key, accountId integer, fieldName integer, operator integer, val varchar, val2 varchar, action integer, param varchar, alias varchar )");
  }
  
  public void upgradeTableFor3003(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_MAIL_INFO ADD COLUMN isTopped INTEGER");
    paramSQLiteDatabase.execSQL(sqlCreateTmpEmlForUpgrade);
    paramSQLiteDatabase.execSQL(sqlCreateTmpEmlAddrForUpgrade);
  }
  
  public void upgradeTableFor3004(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_TMP_SEARCH_MAIL_INFO ADD COLUMN isTopped INTEGER");
  }
  
  public void upgradeTableFor3009(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_MAIL_CONTENT ADD COLUMN extra VARCHAR");
  }
  
  public void upgradeTableFor3010(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_ICS_EVENT(id integer primary key, accountId integer, folderId integer, uid varchar, reminder integer, subject varchar, location varchar, body varchar, bodyType integer, allday integer, sensitivity integer, timezone varchar, startTime integer, endTime integer, createTime integer, modifyTime integer, path varchar, etag varchar, serverId varchar, folderType integer, recurrenceType integer, calendarType integer, interval integer, until integer, weekOfMonth integer, dayOfWeek integer, monthOfYear integer, dayOfMonth integer, isLeapMonth integer, firstDayOfWeek integer, relateId varchar, relateType integer, organizerName varchar, organizerEmail varchar,responseType integer, meeting_status integer, attendee varchar ,isDecline integer,mailId varchar ) ");
  }
  
  public void upgradeTableFor3011(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void upgradeTableFor3012(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_CONTACT ADD COLUMN history INTEGER DEFAULT 0");
  }
  
  public void upgradeTableFor3015(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("UPDATE QM_MAIL_INFO SET attr=attr|32 WHERE id IN ( SELECT DISTINCT QM_MAIL_INFO.id FROM QM_MAIL_INFO JOIN QM_ICS_EVENT WHERE QM_MAIL_INFO.accountId=QM_ICS_EVENT.accountId AND QM_MAIL_INFO.remoteId=QM_ICS_EVENT.mailId)");
  }
  
  public void upgradeTableFor3016(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void upgradeTableFor4013(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_MAIL_INFO ADD COLUMN sendStatus INTEGER DEFAULT 0");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_MAIL_INFO ADD COLUMN localCount INTEGER DEFAULT -1");
    paramSQLiteDatabase.execSQL("UPDATE QM_MAIL_INFO SET sendStatus = 3 WHERE folderId IN ( SELECT id FROM QM_FOLDER WHERE type = 3 AND accountId IN " + getInClause(getExistQQAccountIdsFromSp()) + ")");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_REF_MAIL_RECALL (id integer primary key, mid integer, receiver varchar, status integer )");
    paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS INDEX_REL_MAIL_RECALL ON QM_REF_MAIL_RECALL(mid,receiver,status)");
  }
  
  public void upgradeTableFor4014(SQLiteDatabase paramSQLiteDatabase)
  {
    String str1 = generateTmpTableForMailInfoUpgradeSql("ALTER TABLE QM_MAIL_INFO ADD COLUMN sendStatus INTEGER DEFAULT 0", "QM_TMP_SEARCH_MAIL_INFO");
    String str2 = generateTmpTableForMailInfoUpgradeSql("ALTER TABLE QM_MAIL_INFO ADD COLUMN sendStatus INTEGER DEFAULT 0", "QM_TMP_EML_MAIL_INFO");
    paramSQLiteDatabase.execSQL(str1);
    paramSQLiteDatabase.execSQL(str2);
    str1 = generateTmpTableForMailInfoUpgradeSql("ALTER TABLE QM_MAIL_INFO ADD COLUMN localCount INTEGER DEFAULT -1", "QM_TMP_SEARCH_MAIL_INFO");
    str2 = generateTmpTableForMailInfoUpgradeSql("ALTER TABLE QM_MAIL_INFO ADD COLUMN localCount INTEGER DEFAULT -1", "QM_TMP_EML_MAIL_INFO");
    paramSQLiteDatabase.execSQL(str1);
    paramSQLiteDatabase.execSQL(str2);
    str2 = "UPDATE QM_MAIL_INFO SET sendStatus = 3 WHERE folderId IN ( SELECT id FROM QM_FOLDER WHERE type = 3 AND accountId IN " + getInClause(getExistQQAccountIdsFromSp()) + ")";
    str1 = generateTmpTableForMailInfoUpgradeSql(str2, "QM_TMP_SEARCH_MAIL_INFO");
    str2 = generateTmpTableForMailInfoUpgradeSql(str2, "QM_TMP_EML_MAIL_INFO");
    paramSQLiteDatabase.execSQL(str1);
    paramSQLiteDatabase.execSQL(str2);
  }
  
  public void upgradeTableFor4015(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void upgradeTableFor4016(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_MAIL_TRANSLATE_CONTENT(id integer primary key, translate_subj varchar, translate_content varchar) ");
  }
  
  public void upgradeTableFor5000(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void upgradeTableFor5003(SQLiteDatabase paramSQLiteDatabase)
  {
    String str1 = generateTmpTableForMailInfoUpgradeSql("ALTER TABLE QM_MAIL_INFO ADD COLUMN sendutc INTEGER DEFAULT 0", "QM_TMP_SEARCH_MAIL_INFO");
    String str2 = generateTmpTableForMailInfoUpgradeSql("ALTER TABLE QM_MAIL_INFO ADD COLUMN sendutc INTEGER DEFAULT 0", "QM_TMP_EML_MAIL_INFO");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_MAIL_INFO ADD COLUMN sendutc INTEGER DEFAULT 0");
    paramSQLiteDatabase.execSQL(str1);
    paramSQLiteDatabase.execSQL(str2);
  }
  
  public void upgradeTableFor5008(SQLiteDatabase paramSQLiteDatabase)
  {
    QMLog.log(4, "QMMailSQLite", "upgradeTableFor5008 ");
    String str1 = generateTmpTableForMailInfoUpgradeSql("ALTER TABLE QM_MAIL_INFO ADD COLUMN toppedAdTime INTEGER DEFAULT -1", "QM_TMP_SEARCH_MAIL_INFO");
    String str2 = generateTmpTableForMailInfoUpgradeSql("ALTER TABLE QM_MAIL_INFO ADD COLUMN toppedAdTime INTEGER DEFAULT -1", "QM_TMP_EML_MAIL_INFO");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_MAIL_INFO ADD COLUMN toppedAdTime INTEGER DEFAULT -1");
    paramSQLiteDatabase.execSQL(str1);
    paramSQLiteDatabase.execSQL(str2);
  }
  
  public void upgradeTableFor5010(SQLiteDatabase paramSQLiteDatabase)
  {
    QMLog.log(4, "QMMailSQLite", "upgradeTableFor5010 ");
    deleteRecordConv(paramSQLiteDatabase);
  }
  
  public void upgradeTableFor5020(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_TMP_SEARCH_MAIL_INFO");
    paramSQLiteDatabase.execSQL(sqlCreateTmpSearch);
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_TMP_SEARCH_MAIL_UTC (searchType integer, mailId integer, utcSearch integer,  primary key (searchType,mailId))");
  }
  
  public void upgradeTableFor5210(SQLiteDatabase paramSQLiteDatabase)
  {
    QMLog.log(4, "QMMailSQLite", "upgradeTableFor5210 ");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_MAIL_AGGREGATE(id varchar primary key, value integer)");
  }
  
  public void upgradeTableFor5230(SQLiteDatabase paramSQLiteDatabase)
  {
    QMLog.log(4, "QMMailSQLite", "upgradeTableFor5230 ");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_MAIL_INFO ADD COLUMN senderAddr VARCHAR");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_MAIL_INFO ADD COLUMN senderAddrName VARCHAR");
  }
  
  public void upgradeTableFor5232(SQLiteDatabase paramSQLiteDatabase)
  {
    QMLog.log(4, "QMMailSQLite", "upgradeTableFor5232 ");
    try
    {
      paramSQLiteDatabase.execSQL(generateTmpTableForMailInfoUpgradeSql("ALTER TABLE QM_MAIL_INFO ADD COLUMN senderAddr VARCHAR", "QM_TMP_SEARCH_MAIL_INFO"));
      paramSQLiteDatabase.execSQL(generateTmpTableForMailInfoUpgradeSql("ALTER TABLE QM_MAIL_INFO ADD COLUMN senderAddrName VARCHAR", "QM_TMP_SEARCH_MAIL_INFO"));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          paramSQLiteDatabase.execSQL(generateTmpTableForMailInfoUpgradeSql("ALTER TABLE QM_MAIL_INFO ADD COLUMN senderAddr VARCHAR", "QM_TMP_EML_MAIL_INFO"));
          paramSQLiteDatabase.execSQL(generateTmpTableForMailInfoUpgradeSql("ALTER TABLE QM_MAIL_INFO ADD COLUMN senderAddrName VARCHAR", "QM_TMP_EML_MAIL_INFO"));
          return;
        }
        catch (Exception paramSQLiteDatabase)
        {
          QMLog.log(6, "QMMailSQLite", "upgradeTableFor5231 temp eml exception:" + paramSQLiteDatabase.toString());
        }
        localException = localException;
        QMLog.log(6, "QMMailSQLite", "upgradeTableFor5231 temp search exception:" + localException.toString());
      }
    }
  }
  
  public void upgradeTableFor5260(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS INDEX_MAIL_INFO_CONV ON QM_MAIL_INFO(folderId,convHash,convType)");
  }
  
  public void upgradeTableFor5300(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DELETE FROM QM_TMP_EML_MAIL_INFO");
    paramSQLiteDatabase.execSQL("DELETE FROM QM_TMP_EML_MAIL_ADDR");
    paramSQLiteDatabase.execSQL("CREATE VIRTUAL TABLE IF NOT EXISTS QM_MAIL_INFO_FTS_SEARCH USING FTS4(sender varchar, receiver varchar, subject varchar, abs varchar, attachName varchar, tokenize=single)");
    paramSQLiteDatabase.execSQL("CREATE VIRTUAL TABLE IF NOT EXISTS QM_MAIL_CONTENT_FTS_SEARCH USING FTS4(CONTENT=QM_MAIL_CONTENT,content varchar, tokenize=single)");
    paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS INDEX_MAIL_CONTENT ON QM_MAIL_CONTENT(id)");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS INDEX_REL_MAIL_ADDR");
    paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS INDEX_REL_MAIL_ADDR ON QM_REF_MAIL_ADDR(mid,roleType,addrId)");
  }
  
  public static abstract interface GroupMailPreloadWatcher
  {
    public abstract void onPreloadMail(ArrayList<Mail> paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailSQLite
 * JD-Core Version:    0.7.0.1
 */