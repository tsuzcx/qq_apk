package com.tencent.qqmail.model.contact;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.util.Log;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteException;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.mail.QMComposeDataManager;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper.UnsupportedGetDatabase;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.qmdomain.ContactCustom;
import com.tencent.qqmail.model.qmdomain.ContactEmail;
import com.tencent.qqmail.model.qmdomain.ContactGroup;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContact.ContactType;
import com.tencent.qqmail.model.qmdomain.MailGroupContact;
import com.tencent.qqmail.model.qmdomain.MailGroupContactList;
import com.tencent.qqmail.model.qmdomain.NickNameCache.NickNameData;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.trd.guava.Sets;
import com.tencent.qqmail.utilities.QMMath;
import com.tencent.qqmail.utilities.contacts.ContactsHelper;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

public class QMContactSQLite
  extends QMMailSQLiteHelper.UnsupportedGetDatabase
{
  private static final String CHECKED_ACCOUNT_IDS = "$checked_account_ids$";
  private static final String FILTER_ACCOUNT_HASH_TYPE = " ((C.hashtype=0 AND C.accountid IN $accountIds$) OR  (C.hashtype=1 AND EXISTS(SELECT CN.id FROM QM_CONTACT AS CN  WHERE CN.hashtype=-1 AND CN.accountid IN $accountIds$ AND CN.hash=C.hash)))";
  private static final String FILTER_CONTACT_LIST;
  private static final String FILTER_HASH_TYPE = " (C.hashtype=0 OR C.hashtype=1)";
  private static final String FILTER_OFFLINE = " (C.offlinetype<3)";
  private static final char[] LETTERS;
  private static final char[] LETTERS_LOWERCASE = { 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122 };
  private static final char LETTER_ANY = '#';
  private static final char LETTER_HEAD = '@';
  private static final char LETTER_TAIL = '[';
  private static final String ORDER_BY_FREQ_AND_PINYIN = " ORDER BY  (CASE WHEN E.freqUpdateTime + E.freq>0 THEN 0  WHEN C.pinyin > '@' AND C.pinyin < '[' THEN 1 ELSE 2 END),E.freqUpdateTime + E.freq DESC,C.pinyin,C.name,C.address";
  private static final String ORDER_BY_PINYIN = " ORDER BY  (CASE WHEN C.pinyin > '@' AND C.pinyin < '[' THEN 0  ELSE 1 END),C.pinyin,C.name,C.address";
  private static final String ORDER_BY_TYPE_PINYIN;
  private static final String QUERY_SEARCH_CUSTOM_PARAM = "SELECT CUSTOM.* FROM QM_REF_CONTACT_CUSTOM AS CUSTOM WHERE C.id=CUSTOM.cid AND CUSTOM.value LIKE $keyword$";
  private static final String QUERY_SEARCH_EMAIL_PARAM = "SELECT E.* FROM QM_REF_CONTACT_EMAIL AS E WHERE C.id= E.cid AND (E.email LIKE $keyword$ OR E.email IN $inEmailClause$)";
  private static final String SEARCH_CONTACT_PARAM = "(C.name LIKE $keyword$ OR C.pinyin LIKE $keyword$ OR C.fullpinyin LIKE $keyword$ OR C.mark LIKE $keyword$ OR C.address LIKE $keyword$)";
  private static final String SEARCH_CUSTOM_PARAM = "CUSTOM.value LIKE $keyword$";
  private static final String SEARCH_EMAIL_PARAM = "(E.email LIKE $keyword$ OR E.email IN $inEmailClause$)";
  private static final String SEARCH_TYPE_PARAM = "C.type in $types$";
  private static final String SECTION_AND = "C.pinyin >= '$firstLetter$' AND C.pinyin < '$lastLetter$' AND  (C.offlinetype<3)";
  private static final String SECTION_OR = "C.pinyin >  '$firstLetter$' OR  C.pinyin < '$lastLetter$' AND  (C.offlinetype<3)";
  private static final String SELECT_CONTACT = "SELECT C.* FROM QM_CONTACT AS C";
  private static final String SELECT_COUNT = "SELECT COUNT(C.id) FROM QM_CONTACT AS C";
  private static final String SELECT_EMAIL_CONTACT = "SELECT C.*, E.* FROM QM_REF_CONTACT_EMAIL AS E LEFT JOIN QM_CONTACT AS C ON E.cid=C.id";
  private static final String SELECT_EMAIL_COUNT = "SELECT COUNT(C.id) FROM QM_REF_CONTACT_EMAIL AS E LEFT JOIN QM_CONTACT AS C ON E.cid=C.id";
  private static final long blackWhiteNameListFilter = 8435712L;
  private static final String predicateForMerge;
  private static final String queryBlackWhiteListContactSectionNotFreq = " ((C.hashtype=0 AND C.accountid IN $accountIds$) OR  (C.hashtype=1 AND EXISTS(SELECT CN.id FROM QM_CONTACT AS CN  WHERE CN.hashtype=-1 AND CN.accountid IN $accountIds$ AND CN.hash=C.hash))) AND C.address NOT IN (SELECT NL.email FROM QM_NAME_LIST AS NL WHERE NL.accountId=$accountIds$ AND NL.type=$nameListType$) AND C.address IS NOT NULL AND C.address != \"\" AND C.address != \"$selfEmail$\"";
  private static final String queryBlackWhiteListContactsByAccountIdsAndTypes = "SELECT C.* FROM QM_CONTACT AS C WHERE  ((C.hashtype=0 AND C.accountid IN $accountIds$) OR  (C.hashtype=1 AND EXISTS(SELECT CN.id FROM QM_CONTACT AS CN  WHERE CN.hashtype=-1 AND CN.accountid IN $accountIds$ AND CN.hash=C.hash))) AND C.address NOT IN (SELECT NL.email FROM QM_NAME_LIST AS NL WHERE NL.accountId=$accountIds$ AND NL.type=$nameListType$) AND C.address IS NOT NULL AND C.address != \"\" AND C.address != \"$selfEmail$\" ORDER BY  (CASE WHEN C.pinyin > '@' AND C.pinyin < '[' THEN 0  ELSE 1 END),C.pinyin,C.name,C.address";
  private static final String queryBlackWhiteListContactsByAccountIdsAndTypesRecentSender = "SELECT fromAddr,fromAddrName,accountId FROM (SELECT * FROM QM_MAIL_INFO WHERE accountId=$accountIds$ AND fromAddr NOT IN (SELECT NL.email FROM QM_NAME_LIST AS NL WHERE NL.accountId=$accountIds$ AND NL.type=$nameListType$) AND fromAddr IS NOT NULL AND fromAddr != \"\" AND fromAddr != \"$selfEmail$\" AND attr & 8435712 = 0 ORDER BY utcReceived ASC)  GROUP BY fromAddr ORDER BY utcReceived DESC LIMIT 20";
  private static final String queryBlackWhiteNameListAllNotRecentContact = "SELECT C.* FROM QM_CONTACT AS C WHERE  ((C.hashtype=0 AND C.accountid IN $accountIds$) OR  (C.hashtype=1 AND EXISTS(SELECT CN.id FROM QM_CONTACT AS CN  WHERE CN.hashtype=-1 AND CN.accountid IN $accountIds$ AND CN.hash=C.hash))) AND C.address NOT IN (SELECT NL.email FROM QM_NAME_LIST AS NL WHERE NL.accountId=$accountIds$ AND NL.type=$nameListType$) AND C.address IS NOT NULL AND C.address != \"\" AND C.address != \"$selfEmail$\"";
  private static final String queryBlackWhiteNameListMailInDatabase = "(SELECT NL.email FROM QM_NAME_LIST AS NL WHERE NL.accountId=$accountIds$ AND NL.type=$nameListType$)";
  private static final String queryBlackWhiteNameListRecentSenderInOrder = "SELECT * FROM QM_MAIL_INFO WHERE accountId=$accountIds$ AND fromAddr NOT IN (SELECT NL.email FROM QM_NAME_LIST AS NL WHERE NL.accountId=$accountIds$ AND NL.type=$nameListType$) AND fromAddr IS NOT NULL AND fromAddr != \"\" AND fromAddr != \"$selfEmail$\" AND attr & 8435712 = 0 ORDER BY utcReceived ASC";
  private static final String queryComposeContact;
  private static final String queryComposeContactSectionFreq;
  private static final String queryComposeContactSectionNotFreq;
  private static final String queryComposeContactWhereClause;
  private static final String queryContactByAccountAndEmail = "SELECT C.*  FROM QM_CONTACT AS C LEFT JOIN QM_REF_CONTACT_EMAIL AS E ON C.id = E.cid WHERE C.accountid = ? AND E.email = ?  AND  (C.offlinetype<3) ORDER BY C.vip DESC ";
  private static final String queryContactByAccountAndEmailAndName;
  private static final String queryContactById = "SELECT C.* FROM QM_CONTACT AS C WHERE C.id = ? ";
  private static final String queryContactIdByAccountAndType = "SELECT id FROM QM_CONTACT WHERE accountid=? AND type=?";
  private static final String queryContactIdByAccountAndTypeAndEmail = "SELECT C.id FROM QM_CONTACT AS C LEFT JOIN QM_REF_CONTACT_EMAIL AS E ON C.id = E.cid WHERE C.accountid = ? AND C.type = ? AND E.email = ?  AND  (C.offlinetype<3)";
  private static final String queryContactsByAccountIdsAndTypes = "SELECT C.* FROM QM_CONTACT AS C WHERE  C.type IN $types$ AND  ((C.hashtype=0 AND C.accountid IN $accountIds$) OR  (C.hashtype=1 AND EXISTS(SELECT CN.id FROM QM_CONTACT AS CN  WHERE CN.hashtype=-1 AND CN.accountid IN $accountIds$ AND CN.hash=C.hash))) AND  (C.offlinetype<3) ORDER BY  (CASE WHEN C.pinyin > '@' AND C.pinyin < '[' THEN 0  ELSE 1 END),C.pinyin,C.name,C.address";
  private static final String queryContactsByAccountIdsAndTypesWhereClause = " C.type IN $types$ AND  ((C.hashtype=0 AND C.accountid IN $accountIds$) OR  (C.hashtype=1 AND EXISTS(SELECT CN.id FROM QM_CONTACT AS CN  WHERE CN.hashtype=-1 AND CN.accountid IN $accountIds$ AND CN.hash=C.hash))) AND  (C.offlinetype<3)";
  private static final String queryContactsByGid = "SELECT C.* FROM QM_CONTACT AS C WHERE C.gid = ? AND  (C.hashtype=0 OR C.hashtype=1) AND  (C.offlinetype<3) ORDER BY  (CASE WHEN C.pinyin > '@' AND C.pinyin < '[' THEN 0  ELSE 1 END),C.pinyin,C.name,C.address";
  private static final String queryContactsByGidWhereClause = "C.gid = ? AND  (C.hashtype=0 OR C.hashtype=1) AND  (C.offlinetype<3)";
  private static final String queryHistoryContactCount;
  private static final String querySearchBlackWhiteListAddList = "SELECT C.* FROM QM_CONTACT AS C WHERE  ((C.hashtype=0 AND C.accountid IN $accountIds$) OR  (C.hashtype=1 AND EXISTS(SELECT CN.id FROM QM_CONTACT AS CN  WHERE CN.hashtype=-1 AND CN.accountid IN $accountIds$ AND CN.hash=C.hash))) AND C.address NOT IN (SELECT NL.email FROM QM_NAME_LIST AS NL WHERE NL.accountId=$accountIds$ AND NL.type=$nameListType$) AND C.address IS NOT NULL AND C.address != \"\" AND C.address != \"$selfEmail$\" AND ((C.name LIKE $keyword$ OR C.pinyin LIKE $keyword$ OR C.fullpinyin LIKE $keyword$ OR C.mark LIKE $keyword$ OR C.address LIKE $keyword$) OR EXISTS (SELECT CUSTOM.* FROM QM_REF_CONTACT_CUSTOM AS CUSTOM WHERE C.id=CUSTOM.cid AND CUSTOM.value LIKE $keyword$)) AND  ((C.hashtype=0 AND C.accountid IN $accountIds$) OR  (C.hashtype=1 AND EXISTS(SELECT CN.id FROM QM_CONTACT AS CN  WHERE CN.hashtype=-1 AND CN.accountid IN $accountIds$ AND CN.hash=C.hash))) AND  (C.offlinetype<3)";
  private static final String querySearchBlackWhiteListAddListWhereClause = "((C.name LIKE $keyword$ OR C.pinyin LIKE $keyword$ OR C.fullpinyin LIKE $keyword$ OR C.mark LIKE $keyword$ OR C.address LIKE $keyword$) OR EXISTS (SELECT CUSTOM.* FROM QM_REF_CONTACT_CUSTOM AS CUSTOM WHERE C.id=CUSTOM.cid AND CUSTOM.value LIKE $keyword$)) AND  ((C.hashtype=0 AND C.accountid IN $accountIds$) OR  (C.hashtype=1 AND EXISTS(SELECT CN.id FROM QM_CONTACT AS CN  WHERE CN.hashtype=-1 AND CN.accountid IN $accountIds$ AND CN.hash=C.hash))) AND  (C.offlinetype<3)";
  private static final String querySearchComposeContactSectionFreq = queryComposeContactSectionFreq + " AND " + "((C.name LIKE $keyword$ OR C.pinyin LIKE $keyword$ OR C.fullpinyin LIKE $keyword$ OR C.mark LIKE $keyword$ OR C.address LIKE $keyword$) OR (E.email LIKE $keyword$ OR E.email IN $inEmailClause$) OR EXISTS (SELECT CUSTOM.* FROM QM_REF_CONTACT_CUSTOM AS CUSTOM WHERE C.id=CUSTOM.cid AND CUSTOM.value LIKE $keyword$)) AND  ((C.hashtype=0 AND C.accountid IN $accountIds$) OR  (C.hashtype=1 AND EXISTS(SELECT CN.id FROM QM_CONTACT AS CN  WHERE CN.hashtype=-1 AND CN.accountid IN $accountIds$ AND CN.hash=C.hash))) AND  (C.offlinetype<3)";
  private static final String querySearchComposeContactSectionNotFreq;
  private static final String querySearchComposeContactsByAccountIds = "SELECT C.*, E.* FROM QM_REF_CONTACT_EMAIL AS E LEFT JOIN QM_CONTACT AS C ON E.cid=C.id WHERE ((C.name LIKE $keyword$ OR C.pinyin LIKE $keyword$ OR C.fullpinyin LIKE $keyword$ OR C.mark LIKE $keyword$ OR C.address LIKE $keyword$) OR (E.email LIKE $keyword$ OR E.email IN $inEmailClause$) OR EXISTS (SELECT CUSTOM.* FROM QM_REF_CONTACT_CUSTOM AS CUSTOM WHERE C.id=CUSTOM.cid AND CUSTOM.value LIKE $keyword$)) AND  ((C.hashtype=0 AND C.accountid IN $accountIds$) OR  (C.hashtype=1 AND EXISTS(SELECT CN.id FROM QM_CONTACT AS CN  WHERE CN.hashtype=-1 AND CN.accountid IN $accountIds$ AND CN.hash=C.hash))) AND  (C.offlinetype<3) ORDER BY  (CASE WHEN E.freqUpdateTime + E.freq>0 THEN 0  WHEN C.pinyin > '@' AND C.pinyin < '[' THEN 1 ELSE 2 END),E.freqUpdateTime + E.freq DESC,C.pinyin,C.name,C.address";
  private static final String querySearchComposeContactsWhereClause = "((C.name LIKE $keyword$ OR C.pinyin LIKE $keyword$ OR C.fullpinyin LIKE $keyword$ OR C.mark LIKE $keyword$ OR C.address LIKE $keyword$) OR (E.email LIKE $keyword$ OR E.email IN $inEmailClause$) OR EXISTS (SELECT CUSTOM.* FROM QM_REF_CONTACT_CUSTOM AS CUSTOM WHERE C.id=CUSTOM.cid AND CUSTOM.value LIKE $keyword$)) AND  ((C.hashtype=0 AND C.accountid IN $accountIds$) OR  (C.hashtype=1 AND EXISTS(SELECT CN.id FROM QM_CONTACT AS CN  WHERE CN.hashtype=-1 AND CN.accountid IN $accountIds$ AND CN.hash=C.hash))) AND  (C.offlinetype<3)";
  private static final String querySearchContactWhereClause = "((C.name LIKE $keyword$ OR C.pinyin LIKE $keyword$ OR C.fullpinyin LIKE $keyword$ OR C.mark LIKE $keyword$ OR C.address LIKE $keyword$) OR EXISTS (SELECT E.* FROM QM_REF_CONTACT_EMAIL AS E WHERE C.id= E.cid AND (E.email LIKE $keyword$ OR E.email IN $inEmailClause$)) OR EXISTS (SELECT CUSTOM.* FROM QM_REF_CONTACT_CUSTOM AS CUSTOM WHERE C.id=CUSTOM.cid AND CUSTOM.value LIKE $keyword$)) AND  ((C.hashtype=0 AND C.accountid IN $accountIds$) OR  (C.hashtype=1 AND EXISTS(SELECT CN.id FROM QM_CONTACT AS CN  WHERE CN.hashtype=-1 AND CN.accountid IN $accountIds$ AND CN.hash=C.hash))) AND  (C.offlinetype<3)";
  private static final String querySearchContactsByAccountIdsAndTypes = "SELECT C.* FROM QM_CONTACT AS C WHERE  C.type IN $types$ AND  ((C.hashtype=0 AND C.accountid IN $accountIds$) OR  (C.hashtype=1 AND EXISTS(SELECT CN.id FROM QM_CONTACT AS CN  WHERE CN.hashtype=-1 AND CN.accountid IN $accountIds$ AND CN.hash=C.hash))) AND  (C.offlinetype<3) AND (((C.name LIKE $keyword$ OR C.pinyin LIKE $keyword$ OR C.fullpinyin LIKE $keyword$ OR C.mark LIKE $keyword$ OR C.address LIKE $keyword$) OR EXISTS (SELECT E.* FROM QM_REF_CONTACT_EMAIL AS E WHERE C.id= E.cid AND (E.email LIKE $keyword$ OR E.email IN $inEmailClause$)) OR EXISTS (SELECT CUSTOM.* FROM QM_REF_CONTACT_CUSTOM AS CUSTOM WHERE C.id=CUSTOM.cid AND CUSTOM.value LIKE $keyword$)) AND  ((C.hashtype=0 AND C.accountid IN $accountIds$) OR  (C.hashtype=1 AND EXISTS(SELECT CN.id FROM QM_CONTACT AS CN  WHERE CN.hashtype=-1 AND CN.accountid IN $accountIds$ AND CN.hash=C.hash))) AND  (C.offlinetype<3)) ORDER BY  (CASE WHEN C.pinyin > '@' AND C.pinyin < '[' THEN 0  ELSE 1 END),C.pinyin,C.name,C.address";
  private static final String querySearchContactsByAccountIdsAndTypesOrderByType;
  private static final String querySearchContactsByGid = "SELECT C.* FROM QM_CONTACT AS C WHERE C.gid = ? AND  (C.hashtype=0 OR C.hashtype=1) AND  (C.offlinetype<3) AND (((C.name LIKE $keyword$ OR C.pinyin LIKE $keyword$ OR C.fullpinyin LIKE $keyword$ OR C.mark LIKE $keyword$ OR C.address LIKE $keyword$) OR EXISTS (SELECT E.* FROM QM_REF_CONTACT_EMAIL AS E WHERE C.id= E.cid AND (E.email LIKE $keyword$ OR E.email IN $inEmailClause$)) OR EXISTS (SELECT CUSTOM.* FROM QM_REF_CONTACT_CUSTOM AS CUSTOM WHERE C.id=CUSTOM.cid AND CUSTOM.value LIKE $keyword$)) AND  (C.hashtype=0 OR C.hashtype=1) AND  (C.offlinetype<3)) ORDER BY  (CASE WHEN C.pinyin > '@' AND C.pinyin < '[' THEN 0  ELSE 1 END),C.pinyin,C.name,C.address";
  private static final String querySearchCroupContactWhereClause = "((C.name LIKE $keyword$ OR C.pinyin LIKE $keyword$ OR C.fullpinyin LIKE $keyword$ OR C.mark LIKE $keyword$ OR C.address LIKE $keyword$) OR EXISTS (SELECT E.* FROM QM_REF_CONTACT_EMAIL AS E WHERE C.id= E.cid AND (E.email LIKE $keyword$ OR E.email IN $inEmailClause$)) OR EXISTS (SELECT CUSTOM.* FROM QM_REF_CONTACT_CUSTOM AS CUSTOM WHERE C.id=CUSTOM.cid AND CUSTOM.value LIKE $keyword$)) AND  (C.hashtype=0 OR C.hashtype=1) AND  (C.offlinetype<3)";
  private static final String sqlClearAllVipByAccount = "UPDATE QM_CONTACT SET vip = 0 WHERE accountid = ? ";
  private static final String sqlContactAllContactFilterOffline = "SELECT COUNT(id) AS CNT FROM QM_CONTACT AS C WHERE  (C.offlinetype<3)";
  private static final String sqlCountAllContact = "SELECT COUNT(id) AS CNT FROM QM_CONTACT";
  private static final String sqlCountContactWithAccountAndCid = "SELECT COUNT(id) AS CNT FROM QM_CONTACT AS C WHERE accountid=? AND cid =? AND  (C.offlinetype<3)";
  private static final String sqlCreate = "CREATE TABLE IF NOT EXISTS QM_CONTACT(id integer primary key, cid varchar, accountid integer, address varchar, name varchar, pinyin varchar, fullpinyin varchar,uin varchar, type int, vip integer default 0, history integer default 0, mark varchar, gid integer default 0 ,hash integer default 0 ,hashtype integer default 0 ,offlinetype integer default 0)";
  private static final String sqlCreateContactCustom = "CREATE TABLE IF NOT EXISTS QM_REF_CONTACT_CUSTOM(cid integer, type integer, key varchar, value varchar )";
  private static final String sqlCreateContactCustomForUpdate = "CREATE TABLE IF NOT EXISTS QM_REF_CONTACT_CUSTOM(cid integer, type integer, key varchar, value varchar )";
  private static final String sqlCreateContactCustomIndex = "CREATE INDEX IF NOT EXISTS INDEX_REF_CONTACT_CUSTOM ON QM_REF_CONTACT_CUSTOM(cid,type)";
  private static final String sqlCreateContactEmail = "CREATE TABLE IF NOT EXISTS QM_REF_CONTACT_EMAIL(cid integer, email varchar, emailHash integer, freq integer, freqUpdateTime integer,  unique(cid, email))";
  private static final String sqlCreateContactEmailIndex = "CREATE INDEX IF NOT EXISTS INDEX_REF_CONTACT_EMAIL ON QM_REF_CONTACT_EMAIL(cid,emailHash)";
  private static final String sqlCreateContactGroup = "CREATE TABLE IF NOT EXISTS QM_CONTACT_GROUP(id integer, gid integer, ggid integer, accountId integer, count integer, name varchar, sequence INTEGER DEFAULT 0,  unique(gid, ggid, accountId))";
  private static final String sqlCreateContactGroupForUpdate = "CREATE TABLE IF NOT EXISTS QM_CONTACT_GROUP(id integer, gid integer, ggid integer, accountId integer, count integer, name varchar, sequence integer,  unique(gid, ggid, accountId))";
  private static final String sqlCreateContactGroupIndex = "CREATE INDEX IF NOT EXISTS INDEX_CONTACT_GROUP ON QM_CONTACT_GROUP(gid,ggid,accountId)";
  private static final String sqlCreateIndex = "CREATE INDEX IF NOT EXISTS INDEX_CONTACT ON QM_CONTACT(type,hashtype,hash,vip DESC)";
  private static final String sqlDeleteContactCustomByAccountId = "DELETE FROM QM_REF_CONTACT_CUSTOM WHERE cid IN (SELECT DISTINCT id FROM QM_CONTACT WHERE accountid = ?);";
  private static final String sqlDeleteContactCustomsByContactID = "DELETE FROM QM_REF_CONTACT_CUSTOM WHERE cid = ?";
  private static final String sqlDeleteContactEmailsByAccountId = "DELETE FROM QM_REF_CONTACT_EMAIL WHERE cid IN (SELECT DISTINCT id FROM QM_CONTACT WHERE accountid = ?);";
  private static final String sqlDeleteContactEmailsByContactId = "DELETE FROM QM_REF_CONTACT_EMAIL WHERE cid = ?";
  private static final String sqlDeleteContactGroupByAccountAndGGID = "DELETE FROM QM_CONTACT_GROUP WHERE accountId =? AND ggid =?";
  private static final String sqlDeletePhoneContact = "DELETE FROM QM_CONTACT WHERE accountid = 0";
  private static final String sqlDeletePhoneContactCustom = "DELETE FROM QM_REF_CONTACT_CUSTOM WHERE cid IN (SELECT id FROM QM_CONTACT WHERE accountid  = 0)";
  private static final String sqlDeletePhoneContactEmail = "DELETE FROM QM_REF_CONTACT_EMAIL WHERE cid IN (SELECT id FROM QM_CONTACT WHERE accountid  = 0)";
  private static final String sqlDrop = "DROP TABLE IF EXISTS QM_CONTACT";
  private static final String sqlDropContactCustom = "DROP TABLE IF EXISTS QM_REF_CONTACT_CUSTOM";
  private static final String sqlDropContactCustomIndex = "DROP INDEX IF EXISTS INDEX_REF_CONTACT_CUSTOM";
  private static final String sqlDropContactEmail = "DROP TABLE IF EXISTS QM_REF_CONTACT_EMAIL";
  private static final String sqlDropContactEmailIndex = "DROP INDEX IF EXISTS INDEX_REF_CONTACT_EMAIL";
  private static final String sqlDropContactGroup = "DROP TABLE IF EXISTS QM_CONTACT_GROUP";
  private static final String sqlDropContactGroupIndex = "DROP INDEX IF EXISTS INDEX_CONTACT_GROUP";
  private static final String sqlDropIndex = "DROP INDEX IF EXISTS INDEX_CONTACT";
  private static final String sqlInsert = "REPLACE INTO QM_CONTACT (id,cid,accountid,address,name,pinyin,fullpinyin,uin,type,vip,history,mark,gid,hash,hashtype,offlinetype) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
  private static final String sqlInsertContactCustoms = "REPLACE INTO QM_REF_CONTACT_CUSTOM ( cid,type,key,value ) VALUES (?,?,?,?)";
  private static final String sqlInsertContactEmails = "REPLACE INTO QM_REF_CONTACT_EMAIL ( cid,email,emailHash,freq,freqUpdateTime ) VALUES (?,?,?,?,?)";
  private static final String sqlInsertContactGroup = "REPLACE INTO QM_CONTACT_GROUP ( id,gid,ggid,accountId,count,name,sequence ) VALUES (?,?,?,?,?,?,?)";
  private static final String sqlQueryAllNickNameData = "SELECT C.accountid, C.name, C.mark, C.cid, C.type, C.vip, C.history, E.email FROM QM_CONTACT AS C LEFT JOIN QM_REF_CONTACT_EMAIL AS E ON C.id = E.cid WHERE  (C.offlinetype<3) AND  (C.hashtype=0 OR C.hashtype=1)";
  private static final String sqlQueryAllVipContact = "SELECT *  FROM QM_CONTACT AS C  WHERE C.vip = 1  AND  (C.hashtype=0 OR C.hashtype=1) AND  (C.offlinetype<3) ORDER BY UPPER(C.pinyin)";
  private static final String sqlQueryChildContactIdByHash;
  private static final String sqlQueryContactCustomsByContactId = "SELECT *  FROM QM_REF_CONTACT_CUSTOM WHERE cid = ?";
  private static final String sqlQueryContactEmail = "SELECT cid, email FROM QM_REF_CONTACT_EMAIL";
  private static final String sqlQueryContactEmailByAccountAndDomain = "SELECT E.email FROM QM_CONTACT AS C INNER JOIN QM_REF_CONTACT_EMAIL AS E ON C.id = E.cid WHERE C.accountid = ? AND E.email LIKE ";
  private static final String sqlQueryContactEmailsByContactId = "SELECT *  FROM QM_REF_CONTACT_EMAIL WHERE cid = ?";
  private static final String sqlQueryContactGroupByAccountAndGGID = "SELECT * FROM QM_CONTACT_GROUP WHERE accountId =? AND ggid =? ORDER BY sequence";
  private static final String sqlQueryContactGroupById = "SELECT *  FROM QM_CONTACT_GROUP WHERE id = ?";
  private static final String sqlQueryContactTel = "SELECT cid,value FROM QM_REF_CONTACT_CUSTOM WHERE type = 1";
  private static final String sqlQueryGroupContact;
  private static final String sqlQueryIsVipAddress = "SELECT COUNT(DISTINCT C.id)  FROM QM_CONTACT AS C, QM_REF_CONTACT_EMAIL AS E  WHERE C.id = E.cid AND C.vip= 1 AND E.email = ? AND  (C.offlinetype<3)";
  private static final String sqlQueryIsVipAddressForAccount = "SELECT COUNT(DISTINCT C.id)  FROM QM_CONTACT AS C, QM_REF_CONTACT_EMAIL AS E  WHERE C.id = E.cid AND C.vip= 1 AND C.accountid= ? AND E.email = ? AND  (C.offlinetype<3)";
  private static final String sqlQueryNickNameData = "SELECT C.accountid, C.name, C.mark, C.cid, C.type, C.vip, C.history, E.email FROM QM_CONTACT AS C LEFT JOIN QM_REF_CONTACT_EMAIL AS E ON C.id = E.cid WHERE C.accountid =? AND LOWER(E.email) = LOWER(?)  AND  (C.offlinetype<3) AND  (C.hashtype=0 OR C.hashtype=1)";
  private static final String sqlQueryOnlyChildContactHash;
  private static final String sqlQueryOnlyChildContactIdByHash;
  private static final String sqlQueryParentContactIdByHash;
  private static final String sqlSelectAllOffLineOptEvents = "SELECT C.* FROM QM_CONTACT AS C WHERE offlinetype>0";
  private static final String sqlSelectAllOffLineOptEventsByAccountId = "SELECT C.* FROM QM_CONTACT AS C WHERE offlinetype>0 AND accountid =? AND type =?";
  private static final String sqlSelectContactIdInMergeByEmail;
  private static final String sqlSelectItemInJoinEmail;
  private static final String sqlSelectItemNeedToMergeByEmail;
  private static final String sqlSelectSameEmailContact;
  private static final String sqlSelectSameEmailContactIdWhenSync;
  private static final String sqlSelectSameNameContact;
  private static final String sqlUpdate = "UPDATE QM_CONTACT SET address = ?, name = ?, pinyin = ?, fullpinyin = ?, uin = ?, type = ?, vip = ?, history = ?, mark = ?, gid = ?, hash = ?, hashtype = ?, offlinetype = ? WHERE id = ?";
  private static final String sqlUpdateContactHashTypeByContactIds = "UPDATE QM_CONTACT SET hashtype =?  WHERE id IN ";
  private static final String sqlUpdateContactOffLineOptType = "UPDATE QM_CONTACT SET offlinetype = ?  WHERE id = ?";
  private static final String sqlUpdateVipContactByAccountAndCid = "UPDATE QM_CONTACT SET vip = 1 WHERE accountid=? AND cid=?";
  private static final String sqlUpdateVipContactByContactId = "UPDATE QM_CONTACT SET vip = ? WHERE id = ?";
  private String TAG = "QMContactSQLite";
  
  static
  {
    LETTERS = new char[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90 };
    FILTER_CONTACT_LIST = " (C.type = " + MailContact.ContactType.NormalContact.ordinal() + " OR C." + "type" + " = " + MailContact.ContactType.ProtocolContact.ordinal() + ")";
    ORDER_BY_TYPE_PINYIN = " ORDER BY  (CASE WHEN " + FILTER_CONTACT_LIST + " THEN 0 ELSE 1 END), (CASE WHEN C." + "pinyin" + " > '" + '@' + "' AND C." + "pinyin" + " < '" + '[' + "' THEN 0  ELSE 1 END),C." + "pinyin" + ",C." + "name" + ",C." + "address";
    queryComposeContactWhereClause = " C.type!=" + MailContact.ContactType.PhoneContact.ordinal() + " AND " + " ((C.hashtype=0 AND C.accountid IN $accountIds$) OR  (C.hashtype=1 AND EXISTS(SELECT CN.id FROM QM_CONTACT AS CN  WHERE CN.hashtype=-1 AND CN.accountid IN $accountIds$ AND CN.hash=C.hash)))" + " AND " + " (C.offlinetype<3)";
    queryComposeContactSectionNotFreq = queryComposeContactWhereClause + " AND E." + "freqUpdateTime" + " + E." + "freq" + "<=0";
    queryComposeContactSectionFreq = queryComposeContactWhereClause + " AND E." + "freqUpdateTime" + " + E." + "freq" + ">0";
    queryComposeContact = "SELECT C.*, E.* FROM QM_REF_CONTACT_EMAIL AS E LEFT JOIN QM_CONTACT AS C ON E.cid=C.id WHERE " + queryComposeContactWhereClause + " ORDER BY  (CASE WHEN E.freqUpdateTime + E.freq>0 THEN 0  WHEN C.pinyin > '@' AND C.pinyin < '[' THEN 1 ELSE 2 END),E.freqUpdateTime + E.freq DESC,C.pinyin,C.name,C.address";
    queryHistoryContactCount = "SELECT COUNT(C.id) FROM QM_REF_CONTACT_EMAIL AS E LEFT JOIN QM_CONTACT AS C ON E.cid=C.id WHERE " + queryComposeContactSectionFreq;
    queryContactByAccountAndEmailAndName = "SELECT C.*  FROM QM_CONTACT AS C LEFT JOIN QM_REF_CONTACT_EMAIL AS E ON C.id = E.cid WHERE C.accountid = ? AND E.email = ?  AND C.name = ?  AND  (C.offlinetype<3) ORDER BY C.vip DESC , (CASE WHEN " + FILTER_CONTACT_LIST + " THEN 0 ELSE 1 END)";
    sqlQueryParentContactIdByHash = "SELECT C.id FROM QM_CONTACT AS C WHERE C.hash IN $hash$ AND C.hashtype = 1 AND " + FILTER_CONTACT_LIST + " AND " + " (C.offlinetype<3)";
    sqlQueryChildContactIdByHash = "SELECT C.id FROM QM_CONTACT AS C WHERE C.hash IN $hash$ AND (C.hashtype = -1 OR C.hashtype = 0) AND " + FILTER_CONTACT_LIST + " AND " + " (C.offlinetype<3)";
    sqlQueryOnlyChildContactIdByHash = "SELECT C.id FROM QM_CONTACT AS C  WHERE C.hash IN $hash$ AND C.hashtype = -1 AND " + FILTER_CONTACT_LIST + " AND " + " (C.offlinetype<3)";
    sqlQueryOnlyChildContactHash = "SELECT hash FROM QM_CONTACT AS C  WHERE C.hashtype = -1 AND " + FILTER_CONTACT_LIST + " AND " + " (C.offlinetype<3)";
    sqlQueryGroupContact = "SELECT *  FROM QM_CONTACT WHERE type=" + MailContact.ContactType.GroupContact.ordinal() + " AND " + "accountid" + "=?";
    predicateForMerge = "((type=" + MailContact.ContactType.NormalContact.ordinal() + " or " + "type" + "=" + MailContact.ContactType.ProtocolContact.ordinal() + ") AND " + "name" + " is not null and " + "name" + " != \"\" AND (" + "hashtype" + "=" + 0 + " OR " + "hashtype" + "=" + -1 + ") AND " + "offlinetype" + " < " + 3 + " AND " + "accountid" + " IN (" + "$checked_account_ids$" + "))";
    sqlSelectSameNameContact = "SELECT * FROM QM_CONTACT WHERE " + predicateForMerge + " AND " + "name" + " IN (SELECT " + "name" + " FROM " + "QM_CONTACT" + " WHERE " + predicateForMerge + " GROUP BY " + "name" + " HAVING count(" + "name" + ")>1)";
    sqlSelectItemInJoinEmail = "SELECT $column$ FROM QM_CONTACT AS A LEFT JOIN QM_REF_CONTACT_EMAIL AS B ON A.id=B.cid WHERE ((A.type=" + MailContact.ContactType.NormalContact.ordinal() + " or A." + "type" + "=" + MailContact.ContactType.ProtocolContact.ordinal() + ") and B." + "email" + " is not null and B." + "email" + " != \"\" and  (A." + "hashtype" + " = " + 0 + " OR A." + "hashtype" + "=" + -1 + ") AND " + "offlinetype" + " < " + 3 + " AND A." + "accountid" + " IN (" + "$checked_account_ids$" + ") AND A." + "id" + " NOT IN (" + sqlSelectSameNameContact.replace("*", "id") + "))";
    sqlSelectItemNeedToMergeByEmail = sqlSelectItemInJoinEmail + " GROUP BY " + "email" + " HAVING COUNT(" + "email" + ")>1";
    sqlSelectContactIdInMergeByEmail = "SELECT id FROM (" + sqlSelectItemInJoinEmail.replace("$column$", "id,email") + ") WHERE " + "email" + "=?";
    sqlSelectSameEmailContact = "SELECT * FROM QM_CONTACT WHERE id IN (" + sqlSelectItemInJoinEmail.replace("$column$", "id") + " AND " + "email" + " IN (" + sqlSelectItemNeedToMergeByEmail.replace("$column$", "email") + "))";
    sqlSelectSameEmailContactIdWhenSync = " SELECT E.cid, E.email FROM QM_REF_CONTACT_EMAIL AS E LEFT JOIN QM_CONTACT AS C ON E.cid=C.id WHERE E.cid IN ( SELECT DISTINCT(cid) FROM QM_REF_CONTACT_EMAIL WHERE email IN $emails$) AND C.id != ? AND " + FILTER_CONTACT_LIST + " AND " + " (C.hashtype=0 OR C.hashtype=1)" + " AND " + " (C.offlinetype<3)" + " ORDER BY E." + "cid" + ", E." + "email";
    querySearchContactsByAccountIdsAndTypesOrderByType = "SELECT C.* FROM QM_CONTACT AS C WHERE  C.type IN $types$ AND  ((C.hashtype=0 AND C.accountid IN $accountIds$) OR  (C.hashtype=1 AND EXISTS(SELECT CN.id FROM QM_CONTACT AS CN  WHERE CN.hashtype=-1 AND CN.accountid IN $accountIds$ AND CN.hash=C.hash))) AND  (C.offlinetype<3) AND (((C.name LIKE $keyword$ OR C.pinyin LIKE $keyword$ OR C.fullpinyin LIKE $keyword$ OR C.mark LIKE $keyword$ OR C.address LIKE $keyword$) OR EXISTS (SELECT E.* FROM QM_REF_CONTACT_EMAIL AS E WHERE C.id= E.cid AND (E.email LIKE $keyword$ OR E.email IN $inEmailClause$)) OR EXISTS (SELECT CUSTOM.* FROM QM_REF_CONTACT_CUSTOM AS CUSTOM WHERE C.id=CUSTOM.cid AND CUSTOM.value LIKE $keyword$)) AND  ((C.hashtype=0 AND C.accountid IN $accountIds$) OR  (C.hashtype=1 AND EXISTS(SELECT CN.id FROM QM_CONTACT AS CN  WHERE CN.hashtype=-1 AND CN.accountid IN $accountIds$ AND CN.hash=C.hash))) AND  (C.offlinetype<3))" + ORDER_BY_TYPE_PINYIN;
    querySearchComposeContactSectionNotFreq = queryComposeContactSectionNotFreq + " AND " + "((C.name LIKE $keyword$ OR C.pinyin LIKE $keyword$ OR C.fullpinyin LIKE $keyword$ OR C.mark LIKE $keyword$ OR C.address LIKE $keyword$) OR (E.email LIKE $keyword$ OR E.email IN $inEmailClause$) OR EXISTS (SELECT CUSTOM.* FROM QM_REF_CONTACT_CUSTOM AS CUSTOM WHERE C.id=CUSTOM.cid AND CUSTOM.value LIKE $keyword$)) AND  ((C.hashtype=0 AND C.accountid IN $accountIds$) OR  (C.hashtype=1 AND EXISTS(SELECT CN.id FROM QM_CONTACT AS CN  WHERE CN.hashtype=-1 AND CN.accountid IN $accountIds$ AND CN.hash=C.hash))) AND  (C.offlinetype<3)";
  }
  
  public QMContactSQLite(Context paramContext)
  {
    super(paramContext, false);
  }
  
  private static void beginColumnIndex(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null) {
      paramArrayOfInt[0] = 0;
    }
  }
  
  private MailContact createParentContact(MailContact paramMailContact)
  {
    paramMailContact = paramMailContact.clone();
    paramMailContact.setHashType(1);
    paramMailContact.setId(MailContact.generateParentId(paramMailContact));
    return paramMailContact;
  }
  
  private void deleteContactCustom(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DELETE FROM QM_REF_CONTACT_CUSTOM WHERE cid = ?", new Object[] { Long.valueOf(paramLong) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, this.TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  private void deleteContactEmails(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DELETE FROM QM_REF_CONTACT_EMAIL WHERE cid = ?", new Object[] { Long.valueOf(paramLong) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, this.TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  private boolean doInsertContact(SQLiteDatabase paramSQLiteDatabase, int paramInt, MailContact paramMailContact)
  {
    int i = 0;
    long l = paramMailContact.getId();
    Object localObject = paramMailContact.getCid();
    String str1 = paramMailContact.getAddress();
    String str2 = paramMailContact.getName();
    String str3 = paramMailContact.getPinyin();
    String str4 = paramMailContact.getFullPinyin();
    String str5 = paramMailContact.getUin();
    int j = paramMailContact.getType().ordinal();
    boolean bool1 = paramMailContact.isVip();
    boolean bool2 = paramMailContact.isHistory();
    String str6 = paramMailContact.getMark();
    if (paramMailContact.getGroup() != null) {
      i = paramMailContact.getGroup().getId();
    }
    int k = paramMailContact.getHash();
    int m = paramMailContact.getHashType();
    int n = paramMailContact.getOfflineType();
    try
    {
      paramSQLiteDatabase.execSQL("REPLACE INTO QM_CONTACT (id,cid,accountid,address,name,pinyin,fullpinyin,uin,type,vip,history,mark,gid,hash,hashtype,offlinetype) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new Object[] { Long.valueOf(l), localObject, Integer.valueOf(paramInt), str1, str2, str3, str4, str5, Integer.valueOf(j), Boolean.valueOf(bool1), Boolean.valueOf(bool2), str6, Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n) });
      localObject = paramMailContact.getEmails();
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          insertContactEmails(paramSQLiteDatabase, l, (ContactEmail)((Iterator)localObject).next());
          continue;
          return true;
        }
      }
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, this.TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
    for (;;)
    {
      paramMailContact = paramMailContact.getCustoms();
      if ((paramMailContact != null) && (paramMailContact.size() > 0))
      {
        paramMailContact = paramMailContact.iterator();
        while (paramMailContact.hasNext()) {
          insertContactCustom(paramSQLiteDatabase, l, (ContactCustom)paramMailContact.next());
        }
      }
    }
  }
  
  public static MailContact fillContact(Cursor paramCursor, int[] paramArrayOfInt)
  {
    boolean bool2 = true;
    beginColumnIndex(paramArrayOfInt);
    Object localObject = new MailContact();
    int i = paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "type"));
    if (i == MailContact.ContactType.GroupContact.ordinal()) {
      localObject = new MailGroupContact();
    }
    ((MailContact)localObject).setId(paramCursor.getLong(getColumnIndex(paramArrayOfInt, paramCursor, "id")));
    ((MailContact)localObject).setCid(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "cid")));
    ((MailContact)localObject).setAccountId(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "accountid")));
    ((MailContact)localObject).setAddress(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "address")));
    ((MailContact)localObject).setName(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "name")));
    ((MailContact)localObject).setNick(((MailContact)localObject).getName());
    ((MailContact)localObject).setPinyin(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "pinyin")));
    ((MailContact)localObject).setFullPinyin(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "fullpinyin")));
    ((MailContact)localObject).setUin(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "uin")));
    ((MailContact)localObject).setType(MailContact.ContactType.values()[i]);
    if (paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "vip")) == 1)
    {
      bool1 = true;
      ((MailContact)localObject).setIsVip(bool1);
      if (paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "history")) != 1) {
        break label359;
      }
    }
    label359:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((MailContact)localObject).setIsHistory(bool1);
      ((MailContact)localObject).setMark(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "mark")));
      ((MailContact)localObject).setHash(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "hash")));
      ((MailContact)localObject).setHashType(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "hashtype")));
      ((MailContact)localObject).setOfflineType(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "offlinetype")));
      return localObject;
      bool1 = false;
      break;
    }
  }
  
  private static ContactCustom fillContactCustom(Cursor paramCursor)
  {
    ContactCustom localContactCustom = new ContactCustom();
    localContactCustom.setType(getInt(paramCursor, "type"));
    localContactCustom.setKey(getString(paramCursor, "key"));
    localContactCustom.setValue(getString(paramCursor, "value"));
    return localContactCustom;
  }
  
  private static ContactEmail fillContactEmails(Cursor paramCursor)
  {
    ContactEmail localContactEmail = new ContactEmail();
    localContactEmail.setEmail(getString(paramCursor, "email"));
    localContactEmail.setFreq(getInt(paramCursor, "freq"));
    localContactEmail.setFreqUpdateTime(getInt(paramCursor, "freqUpdateTime"));
    return localContactEmail;
  }
  
  private static ContactGroup fillContactGroup(Cursor paramCursor)
  {
    ContactGroup localContactGroup = new ContactGroup();
    localContactGroup.setId(getInt(paramCursor, "id"));
    localContactGroup.setGid(getInt(paramCursor, "gid"));
    localContactGroup.setGgid(getInt(paramCursor, "ggid"));
    localContactGroup.setAccountId(getInt(paramCursor, "accountId"));
    localContactGroup.setCount(getInt(paramCursor, "count"));
    localContactGroup.setName(getString(paramCursor, "name"));
    localContactGroup.setSequence(getInt(paramCursor, "sequence"));
    return localContactGroup;
  }
  
  public static MailContact fillContactRecentSender(Cursor paramCursor, int[] paramArrayOfInt)
  {
    beginColumnIndex(paramArrayOfInt);
    MailContact localMailContact = new MailContact();
    localMailContact.setAccountId(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "accountId")));
    localMailContact.setAddress(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "fromAddr")));
    localMailContact.setName(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "fromAddrName")));
    return localMailContact;
  }
  
  public static MailContact fillEmailContact(Cursor paramCursor, int[] paramArrayOfInt)
  {
    boolean bool2 = true;
    beginColumnIndex(paramArrayOfInt);
    Object localObject = new MailContact();
    int i = paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "C." + "type"));
    if (i == MailContact.ContactType.GroupContact.ordinal()) {
      localObject = new MailGroupContact();
    }
    ((MailContact)localObject).setId(paramCursor.getLong(getColumnIndex(paramArrayOfInt, paramCursor, "C." + "id")));
    ((MailContact)localObject).setCid(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "C." + "cid")));
    ((MailContact)localObject).setAccountId(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "C." + "accountid")));
    ((MailContact)localObject).setAddress(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "E." + "email")));
    ((MailContact)localObject).setName(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "C." + "name")));
    ((MailContact)localObject).setNick(((MailContact)localObject).getName());
    ((MailContact)localObject).setPinyin(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "C." + "pinyin")));
    ((MailContact)localObject).setFullPinyin(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "C." + "fullpinyin")));
    ((MailContact)localObject).setUin(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "C." + "uin")));
    ((MailContact)localObject).setType(MailContact.ContactType.values()[i]);
    if (paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "C." + "vip")) == 1)
    {
      bool1 = true;
      ((MailContact)localObject).setIsVip(bool1);
      if (paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "C." + "history")) != 1) {
        break label720;
      }
    }
    label720:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((MailContact)localObject).setIsHistory(bool1);
      ((MailContact)localObject).setMark(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "C." + "mark")));
      ((MailContact)localObject).setHash(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "C." + "hash")));
      ((MailContact)localObject).setHashType(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "C." + "hashtype")));
      ((MailContact)localObject).setOfflineType(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "C." + "offlinetype")));
      ((MailContact)localObject).setFreq(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "E." + "freq")));
      ((MailContact)localObject).setFreqUpdateTime(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "E." + "freqUpdateTime")));
      return localObject;
      bool1 = false;
      break;
    }
  }
  
  private NickNameCache.NickNameData fillNickNameData(Cursor paramCursor)
  {
    boolean bool2 = true;
    NickNameCache.NickNameData localNickNameData = new NickNameCache.NickNameData();
    localNickNameData.setAccountId(paramCursor.getInt(paramCursor.getColumnIndex("accountid")));
    localNickNameData.setCid(paramCursor.getString(paramCursor.getColumnIndex("cid")));
    localNickNameData.setType(paramCursor.getInt(paramCursor.getColumnIndex("type")));
    localNickNameData.setEmail(paramCursor.getString(paramCursor.getColumnIndex("email")));
    localNickNameData.setName(paramCursor.getString(paramCursor.getColumnIndex("name")));
    localNickNameData.setMark(paramCursor.getString(paramCursor.getColumnIndex("mark")));
    if (paramCursor.getInt(paramCursor.getColumnIndex("vip")) == 1)
    {
      bool1 = true;
      localNickNameData.setIsvip(bool1);
      if (paramCursor.getInt(paramCursor.getColumnIndex("history")) != 1) {
        break label193;
      }
    }
    label193:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localNickNameData.setHistory(bool1);
      return localNickNameData;
      bool1 = false;
      break;
    }
  }
  
  private int generateEmailHash(ArrayList<String> paramArrayList)
  {
    Collections.sort(paramArrayList);
    StringBuilder localStringBuilder = new StringBuilder();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      localStringBuilder.append(str + "^");
    }
    return QMMath.hashInt(localStringBuilder.toString());
  }
  
  private static int getColumnIndex(int[] paramArrayOfInt, Cursor paramCursor, String paramString)
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
  
  private MailContact getContact(SQLiteDatabase paramSQLiteDatabase, Cursor paramCursor)
  {
    MailContact localMailContact = fillContact(paramCursor, null);
    if (localMailContact.getType().ordinal() == MailContact.ContactType.GroupContact.ordinal())
    {
      paramSQLiteDatabase = (MailGroupContact)localMailContact;
      paramSQLiteDatabase.setGid(paramSQLiteDatabase.getAddress());
      paramSQLiteDatabase.setEmails(Lists.newArrayList(new ContactEmail[] { new ContactEmail(paramSQLiteDatabase.getAddress(), 0, 0) }));
      return localMailContact;
    }
    localMailContact.setEmails(getContactEmailByContactId(paramSQLiteDatabase, localMailContact.getId()));
    localMailContact.setCustoms(getContactCustomByContactId(paramSQLiteDatabase, localMailContact.getId()));
    localMailContact.setGroup(getContactGroupById(paramSQLiteDatabase, getInt(paramCursor, "gid")));
    return localMailContact;
  }
  
  private ArrayList<ContactCustom> getContactCustomByContactId(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT *  FROM QM_REF_CONTACT_CUSTOM WHERE cid = ?", new String[] { String.valueOf(paramLong) });
    if (paramSQLiteDatabase != null) {}
    try
    {
      if (paramSQLiteDatabase.moveToFirst())
      {
        boolean bool;
        do
        {
          localArrayList.add(fillContactCustom(paramSQLiteDatabase));
          bool = paramSQLiteDatabase.moveToNext();
        } while (bool);
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      QMLog.log(6, this.TAG, Log.getStackTraceString(localException));
      return localArrayList;
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
  }
  
  private long[] getContactIdByHash(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(paramString.replace("$hash$", getInClause(paramArrayOfString.length)), paramArrayOfString);
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst()) {
        do
        {
          localArrayList.add(Long.valueOf(getLong(paramSQLiteDatabase, "id")));
        } while (paramSQLiteDatabase.moveToNext());
      }
      paramSQLiteDatabase.close();
    }
    paramSQLiteDatabase = new long[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      paramSQLiteDatabase[i] = ((Long)localArrayList.get(i)).longValue();
      i += 1;
    }
    return paramSQLiteDatabase;
  }
  
  private boolean insertContactCustom(SQLiteDatabase paramSQLiteDatabase, long paramLong, ContactCustom paramContactCustom)
  {
    try
    {
      paramSQLiteDatabase.execSQL("REPLACE INTO QM_REF_CONTACT_CUSTOM ( cid,type,key,value ) VALUES (?,?,?,?)", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramContactCustom.getType()), paramContactCustom.getKey(), paramContactCustom.getValue() });
      return true;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, this.TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
    return true;
  }
  
  private boolean insertContactEmails(SQLiteDatabase paramSQLiteDatabase, long paramLong, ContactEmail paramContactEmail)
  {
    try
    {
      paramSQLiteDatabase.execSQL("REPLACE INTO QM_REF_CONTACT_EMAIL ( cid,email,emailHash,freq,freqUpdateTime ) VALUES (?,?,?,?,?)", new Object[] { Long.valueOf(paramLong), paramContactEmail.getEmail(), Integer.valueOf(QMMath.hashInt(paramContactEmail.getEmail().toLowerCase())), Integer.valueOf(paramContactEmail.getFreq()), Integer.valueOf(paramContactEmail.getFreqUpdateTime()) });
      return true;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, this.TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
    return true;
  }
  
  public void clearAllVipByAccount(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    paramSQLiteDatabase.execSQL("UPDATE QM_CONTACT SET vip = 0 WHERE accountid = ? ", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void createIndex(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS INDEX_CONTACT ON QM_CONTACT(type,hashtype,hash,vip DESC)");
  }
  
  public void createTable(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_CONTACT(id integer primary key, cid varchar, accountid integer, address varchar, name varchar, pinyin varchar, fullpinyin varchar,uin varchar, type int, vip integer default 0, history integer default 0, mark varchar, gid integer default 0 ,hash integer default 0 ,hashtype integer default 0 ,offlinetype integer default 0)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_REF_CONTACT_EMAIL(cid integer, email varchar, emailHash integer, freq integer, freqUpdateTime integer,  unique(cid, email))");
    paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS INDEX_REF_CONTACT_EMAIL ON QM_REF_CONTACT_EMAIL(cid,emailHash)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_REF_CONTACT_CUSTOM(cid integer, type integer, key varchar, value varchar )");
    paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS INDEX_REF_CONTACT_CUSTOM ON QM_REF_CONTACT_CUSTOM(cid,type)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_CONTACT_GROUP(id integer, gid integer, ggid integer, accountId integer, count integer, name varchar, sequence INTEGER DEFAULT 0,  unique(gid, ggid, accountId))");
    paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS INDEX_CONTACT_GROUP ON QM_CONTACT_GROUP(gid,ggid,accountId)");
    QMLog.log(4, this.TAG, "create table");
  }
  
  public void deleteAccountContact(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    paramSQLiteDatabase.beginTransactionNonExclusive();
    try
    {
      String[] arrayOfString = new String[1];
      arrayOfString[0] = String.valueOf(paramInt);
      paramSQLiteDatabase.execSQL("DELETE FROM QM_REF_CONTACT_EMAIL WHERE cid IN (SELECT DISTINCT id FROM QM_CONTACT WHERE accountid = ?);", arrayOfString);
      paramSQLiteDatabase.execSQL("DELETE FROM QM_REF_CONTACT_CUSTOM WHERE cid IN (SELECT DISTINCT id FROM QM_CONTACT WHERE accountid = ?);", arrayOfString);
      paramSQLiteDatabase.delete("QM_CONTACT", "accountid=?", arrayOfString);
      paramSQLiteDatabase.delete("QM_CONTACT_GROUP", "accountId=?", arrayOfString);
      paramSQLiteDatabase.setTransactionSuccessful();
      QMSettingManager.sharedInstance().removeContactSyncKey(paramInt);
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(6, this.TAG, Log.getStackTraceString(localException));
      return;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  public void deleteAccountContactByType(SQLiteDatabase paramSQLiteDatabase, int paramInt, MailContact.ContactType paramContactType)
  {
    ArrayList localArrayList = new ArrayList();
    paramContactType = paramSQLiteDatabase.rawQuery("SELECT id FROM QM_CONTACT WHERE accountid=? AND type=?", new String[] { String.valueOf(paramInt), String.valueOf(paramContactType.ordinal()) });
    if (paramContactType != null) {}
    try
    {
      if (paramContactType.moveToFirst())
      {
        boolean bool;
        do
        {
          localArrayList.add(Long.valueOf(getLong(paramContactType, "id")));
          bool = paramContactType.moveToNext();
        } while (bool);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(6, this.TAG, Log.getStackTraceString(localException));
        paramContactType.close();
      }
    }
    finally
    {
      paramContactType.close();
    }
    if (localArrayList.size() > 0)
    {
      paramContactType = getLongInClause(localArrayList);
      paramSQLiteDatabase.delete("QM_REF_CONTACT_CUSTOM", "cid IN " + paramContactType, null);
      paramSQLiteDatabase.delete("QM_REF_CONTACT_EMAIL", "cid IN " + paramContactType, null);
      paramSQLiteDatabase.delete("QM_CONTACT", "id IN " + paramContactType, null);
    }
  }
  
  public boolean deleteContact(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    deleteContactEmails(paramSQLiteDatabase, paramLong);
    deleteContactCustom(paramSQLiteDatabase, paramLong);
    paramSQLiteDatabase.delete("QM_CONTACT", "id = ?", new String[] { String.valueOf(paramLong) });
    return true;
  }
  
  public void deleteContactGroupByAccountAndGGID(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CONTACT_GROUP WHERE accountId =? AND ggid =?", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, this.TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public boolean deleteMobileContacts(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DELETE FROM QM_REF_CONTACT_EMAIL WHERE cid IN (SELECT id FROM QM_CONTACT WHERE accountid  = 0)");
    paramSQLiteDatabase.execSQL("DELETE FROM QM_REF_CONTACT_CUSTOM WHERE cid IN (SELECT id FROM QM_CONTACT WHERE accountid  = 0)");
    paramSQLiteDatabase.execSQL("DELETE FROM QM_CONTACT WHERE accountid = 0");
    return true;
  }
  
  public void dropIndex(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS INDEX_CONTACT");
  }
  
  public void dropTable(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_CONTACT");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_REF_CONTACT_EMAIL");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS INDEX_REF_CONTACT_EMAIL");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_REF_CONTACT_CUSTOM");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS INDEX_REF_CONTACT_CUSTOM");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_CONTACT_GROUP");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS INDEX_CONTACT_GROUP");
    QMLog.log(4, this.TAG, "drop table");
  }
  
  public List<NickNameCache.NickNameData> fetchAllNickNameData(SQLiteDatabase paramSQLiteDatabase)
  {
    ArrayList localArrayList = new ArrayList();
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT C.accountid, C.name, C.mark, C.cid, C.type, C.vip, C.history, E.email FROM QM_CONTACT AS C LEFT JOIN QM_REF_CONTACT_EMAIL AS E ON C.id = E.cid WHERE  (C.offlinetype<3) AND  (C.hashtype=0 OR C.hashtype=1)", new String[0]);
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst()) {
        do
        {
          localArrayList.add(fillNickNameData(paramSQLiteDatabase));
        } while (paramSQLiteDatabase.moveToNext());
      }
      paramSQLiteDatabase.close();
    }
    return localArrayList;
  }
  
  public Set<String> fetchEmailsNeededByMerge(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    HashSet localHashSet = Sets.newHashSet();
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(sqlSelectItemNeedToMergeByEmail.replace("$column$", "email").replace("$checked_account_ids$", paramString), null);
    if (paramSQLiteDatabase != null) {}
    try
    {
      if (paramSQLiteDatabase.moveToFirst())
      {
        boolean bool;
        do
        {
          localHashSet.add(getString(paramSQLiteDatabase, "email"));
          bool = paramSQLiteDatabase.moveToNext();
        } while (bool);
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QMLog.log(6, this.TAG, Log.getStackTraceString(paramString));
        paramSQLiteDatabase.close();
      }
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
    QMLog.log(4, this.TAG, "fetchEmailsNeededByMerge emails size=" + localHashSet.size());
    return localHashSet;
  }
  
  public List<MailContact> fetchMergeContacts(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    ArrayList localArrayList = Lists.newArrayList();
    paramString = paramSQLiteDatabase.rawQuery(paramString, null);
    if (paramString != null) {}
    try
    {
      if (paramString.moveToFirst())
      {
        boolean bool;
        do
        {
          localArrayList.add(getContact(paramSQLiteDatabase, paramString));
          bool = paramString.moveToNext();
        } while (bool);
      }
      return localArrayList;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, this.TAG, Log.getStackTraceString(paramSQLiteDatabase));
      return localArrayList;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public List<NickNameCache.NickNameData> fetchNickNameData(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT C.accountid, C.name, C.mark, C.cid, C.type, C.vip, C.history, E.email FROM QM_CONTACT AS C LEFT JOIN QM_REF_CONTACT_EMAIL AS E ON C.id = E.cid WHERE C.accountid =? AND LOWER(E.email) = LOWER(?)  AND  (C.offlinetype<3) AND  (C.hashtype=0 OR C.hashtype=1)", new String[] { "" + paramInt, "" + paramString });
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst()) {
        do
        {
          localArrayList.add(fillNickNameData(paramSQLiteDatabase));
        } while (paramSQLiteDatabase.moveToNext());
      }
      paramSQLiteDatabase.close();
    }
    return localArrayList;
  }
  
  public List<MailContact> fetchSameEmailContact(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    return fetchMergeContacts(paramSQLiteDatabase, sqlSelectSameEmailContact.replace("$checked_account_ids$", paramString));
  }
  
  public List<MailContact> fetchSameNameContact(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    return fetchMergeContacts(paramSQLiteDatabase, sqlSelectSameNameContact.replace("$checked_account_ids$", paramString));
  }
  
  public int getAllContactSize(SQLiteDatabase paramSQLiteDatabase)
  {
    int j = 0;
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT COUNT(id) AS CNT FROM QM_CONTACT AS C WHERE  (C.offlinetype<3)", new String[0]);
    int i = j;
    if (paramSQLiteDatabase != null)
    {
      i = j;
      if (paramSQLiteDatabase.moveToFirst())
      {
        i = paramSQLiteDatabase.getInt(0);
        paramSQLiteDatabase.close();
      }
    }
    return i;
  }
  
  public ArrayList<MailContact> getAllVipContacts(SQLiteDatabase paramSQLiteDatabase)
  {
    ArrayList localArrayList = Lists.newArrayList();
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT *  FROM QM_CONTACT AS C  WHERE C.vip = 1  AND  (C.hashtype=0 OR C.hashtype=1) AND  (C.offlinetype<3) ORDER BY UPPER(C.pinyin)", new String[0]);
    if (localCursor != null)
    {
      if (localCursor.moveToFirst()) {
        do
        {
          localArrayList.add(getContact(paramSQLiteDatabase, localCursor));
        } while (localCursor.moveToNext());
      }
      localCursor.close();
    }
    return localArrayList;
  }
  
  public LinkedHashMap<String, Integer> getBlackWhiteListContactSectionMap(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String paramString)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramSQLiteDatabase = getSectionMap(paramSQLiteDatabase, "SELECT COUNT(C.id) FROM QM_CONTACT AS C", " ((C.hashtype=0 AND C.accountid IN $accountIds$) OR  (C.hashtype=1 AND EXISTS(SELECT CN.id FROM QM_CONTACT AS CN  WHERE CN.hashtype=-1 AND CN.accountid IN $accountIds$ AND CN.hash=C.hash))) AND C.address NOT IN (SELECT NL.email FROM QM_NAME_LIST AS NL WHERE NL.accountId=$accountIds$ AND NL.type=$nameListType$) AND C.address IS NOT NULL AND C.address != \"\" AND C.address != \"$selfEmail$\"".replace("$selfEmail$", paramString).replace("$accountIds$", getInClause(paramArrayOfInt1)).replace("$nameListType$", getInClause(paramArrayOfInt2)), null);
    if (paramSQLiteDatabase != null)
    {
      paramSQLiteDatabase = paramSQLiteDatabase.entrySet().iterator();
      while (paramSQLiteDatabase.hasNext())
      {
        paramArrayOfInt1 = (Map.Entry)paramSQLiteDatabase.next();
        localLinkedHashMap.put(paramArrayOfInt1.getKey(), paramArrayOfInt1.getValue());
      }
    }
    return localLinkedHashMap;
  }
  
  public LinkedHashMap<String, Integer> getComposeContactSectionMap(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt)
  {
    int i = 0;
    int j = 0;
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT COUNT(C.id) FROM QM_REF_CONTACT_EMAIL AS E LEFT JOIN QM_CONTACT AS C ON E.cid=C.id WHERE " + queryComposeContactSectionFreq.replace("$accountIds$", getInClause(paramArrayOfInt)), null);
    if (localCursor != null)
    {
      i = j;
      if (localCursor.moveToFirst()) {
        i = localCursor.getInt(0);
      }
      localCursor.close();
    }
    if (i > 0) {
      localLinkedHashMap.put("&", Integer.valueOf(i));
    }
    paramSQLiteDatabase = getSectionMap(paramSQLiteDatabase, "SELECT COUNT(C.id) FROM QM_REF_CONTACT_EMAIL AS E LEFT JOIN QM_CONTACT AS C ON E.cid=C.id", queryComposeContactSectionNotFreq.replace("$accountIds$", getInClause(paramArrayOfInt)), null);
    if (paramSQLiteDatabase != null)
    {
      paramSQLiteDatabase = paramSQLiteDatabase.entrySet().iterator();
      while (paramSQLiteDatabase.hasNext())
      {
        paramArrayOfInt = (Map.Entry)paramSQLiteDatabase.next();
        localLinkedHashMap.put(paramArrayOfInt.getKey(), paramArrayOfInt.getValue());
      }
    }
    return localLinkedHashMap;
  }
  
  public LinkedHashMap<String, Integer> getComposeContactSectionMap(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt, String paramString)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Object localObject2 = "SELECT COUNT(C.id) FROM QM_REF_CONTACT_EMAIL AS E LEFT JOIN QM_CONTACT AS C ON E.cid=C.id WHERE " + querySearchComposeContactSectionFreq.replace("$accountIds$", getInClause(paramArrayOfInt));
    Object localObject1;
    label134:
    int i;
    if (paramString != null)
    {
      localObject1 = DatabaseUtils.sqlEscapeString("%" + paramString + "%");
      localObject1 = ((String)localObject2).replace("$keyword$", (CharSequence)localObject1);
      localObject2 = QMComposeDataManager.sharedInstance().getAllComposeDataCache();
      if ((paramString == null) || (!paramString.equals(QMApplicationContext.sharedInstance().getString(2131692082)))) {
        break label359;
      }
      localObject1 = ((String)localObject1).replace("$inEmailClause$", getStringInClause((ArrayList)localObject2));
      localObject1 = paramSQLiteDatabase.rawQuery((String)localObject1, null);
      if (localObject1 == null) {
        break label405;
      }
      if (!((Cursor)localObject1).moveToFirst()) {
        break label399;
      }
      i = ((Cursor)localObject1).getInt(0);
      label168:
      ((Cursor)localObject1).close();
    }
    for (;;)
    {
      if (i > 0) {
        localLinkedHashMap.put("&", Integer.valueOf(i));
      }
      localObject1 = querySearchComposeContactSectionNotFreq.replace("$accountIds$", getInClause(paramArrayOfInt));
      if (paramString != null)
      {
        paramArrayOfInt = DatabaseUtils.sqlEscapeString("%" + paramString + "%");
        label243:
        paramArrayOfInt = ((String)localObject1).replace("$keyword$", paramArrayOfInt);
        if ((paramString == null) || (!paramString.equals(QMApplicationContext.sharedInstance().getString(2131692082)))) {
          break label382;
        }
      }
      label359:
      label382:
      for (paramArrayOfInt = paramArrayOfInt.replace("$inEmailClause$", getStringInClause((ArrayList)localObject2));; paramArrayOfInt = paramArrayOfInt.replace("$inEmailClause$", "()"))
      {
        paramSQLiteDatabase = getSectionMap(paramSQLiteDatabase, "SELECT COUNT(C.id) FROM QM_REF_CONTACT_EMAIL AS E LEFT JOIN QM_CONTACT AS C ON E.cid=C.id", paramArrayOfInt, null);
        if (paramSQLiteDatabase == null) {
          break label396;
        }
        paramSQLiteDatabase = paramSQLiteDatabase.entrySet().iterator();
        while (paramSQLiteDatabase.hasNext())
        {
          paramArrayOfInt = (Map.Entry)paramSQLiteDatabase.next();
          localLinkedHashMap.put(paramArrayOfInt.getKey(), paramArrayOfInt.getValue());
        }
        localObject1 = "''";
        break;
        localObject1 = ((String)localObject1).replace("$inEmailClause$", "()");
        break label134;
        paramArrayOfInt = "''";
        break label243;
      }
      label396:
      return localLinkedHashMap;
      label399:
      i = 0;
      break label168;
      label405:
      i = 0;
    }
  }
  
  public ArrayList<MailContact> getContactByAccountsAndType(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayOfInt1 = paramSQLiteDatabase.rawQuery("SELECT C.* FROM QM_CONTACT AS C WHERE  C.type IN $types$ AND  ((C.hashtype=0 AND C.accountid IN $accountIds$) OR  (C.hashtype=1 AND EXISTS(SELECT CN.id FROM QM_CONTACT AS CN  WHERE CN.hashtype=-1 AND CN.accountid IN $accountIds$ AND CN.hash=C.hash))) AND  (C.offlinetype<3) ORDER BY  (CASE WHEN C.pinyin > '@' AND C.pinyin < '[' THEN 0  ELSE 1 END),C.pinyin,C.name,C.address".replace("$accountIds$", getInClause(paramArrayOfInt1)).replace("$types$", getInClause(paramArrayOfInt2)), null);
    if (paramArrayOfInt1 != null)
    {
      if (paramArrayOfInt1.moveToFirst()) {
        do
        {
          localArrayList.add(getContact(paramSQLiteDatabase, paramArrayOfInt1));
        } while (paramArrayOfInt1.moveToNext());
      }
      paramArrayOfInt1.close();
    }
    return localArrayList;
  }
  
  public MailContact getContactById(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT C.* FROM QM_CONTACT AS C WHERE C.id = ? ", new String[] { String.valueOf(paramLong) });
    Object localObject1 = null;
    Object localObject2 = null;
    if (localCursor != null)
    {
      localObject1 = localObject2;
      if (localCursor.moveToFirst()) {
        localObject1 = getContact(paramSQLiteDatabase, localCursor);
      }
      localCursor.close();
    }
    return localObject1;
  }
  
  public ArrayList<ContactEmail> getContactEmailByContactId(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT *  FROM QM_REF_CONTACT_EMAIL WHERE cid = ?", new String[] { String.valueOf(paramLong) });
    if (paramSQLiteDatabase != null) {}
    try
    {
      if (paramSQLiteDatabase.moveToFirst())
      {
        boolean bool;
        do
        {
          localArrayList.add(fillContactEmails(paramSQLiteDatabase));
          bool = paramSQLiteDatabase.moveToNext();
        } while (bool);
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      QMLog.log(6, this.TAG, Log.getStackTraceString(localException));
      return localArrayList;
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
  }
  
  public ArrayList<ContactGroup> getContactGroupByAccountAndGGID(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_CONTACT_GROUP WHERE accountId =? AND ggid =? ORDER BY sequence", new String[] { String.valueOf(paramInt1), String.valueOf(paramInt2) });
    ArrayList localArrayList = new ArrayList();
    if (paramSQLiteDatabase != null)
    {
      while (paramSQLiteDatabase.moveToNext()) {
        try
        {
          ContactGroup localContactGroup = fillContactGroup(paramSQLiteDatabase);
          if (localContactGroup != null) {
            localArrayList.add(localContactGroup);
          }
        }
        catch (Exception localException)
        {
          QMLog.log(6, this.TAG, Log.getStackTraceString(localException));
        }
      }
      paramSQLiteDatabase.close();
    }
    return localArrayList;
  }
  
  public ContactGroup getContactGroupById(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT *  FROM QM_CONTACT_GROUP WHERE id = ?", new String[] { String.valueOf(paramInt) });
    paramSQLiteDatabase = localObject2;
    if (localCursor != null) {
      paramSQLiteDatabase = localObject1;
    }
    try
    {
      if (localCursor.moveToFirst()) {
        paramSQLiteDatabase = fillContactGroup(localCursor);
      }
      return paramSQLiteDatabase;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, this.TAG, Log.getStackTraceString(paramSQLiteDatabase));
      return null;
    }
    finally
    {
      localCursor.close();
    }
  }
  
  public ArrayList<Long> getContactIdByAccountAndTypeAndEmail(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT C.id FROM QM_CONTACT AS C LEFT JOIN QM_REF_CONTACT_EMAIL AS E ON C.id = E.cid WHERE C.accountid = ? AND C.type = ? AND E.email = ?  AND  (C.offlinetype<3)", new String[] { String.valueOf(paramInt1), String.valueOf(paramInt2), paramString });
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst()) {
        do
        {
          localArrayList.add(Long.valueOf(getLong(paramSQLiteDatabase, "id")));
        } while (paramSQLiteDatabase.moveToNext());
      }
      paramSQLiteDatabase.close();
    }
    return localArrayList;
  }
  
  public LinkedHashMap<String, Integer> getContactTypeSectionMap(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    int k = 0;
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    String str = null;
    Object localObject = str;
    if (paramArrayOfString != null)
    {
      localObject = str;
      if (paramArrayOfString.length > 0)
      {
        localObject = new String[paramArrayOfString.length * (LETTERS.length + 1)];
        i = 0;
        while (i < LETTERS.length + 1)
        {
          j = 0;
          while (j < paramArrayOfString.length)
          {
            localObject[(paramArrayOfString.length * i + j)] = paramArrayOfString[j];
            j += 1;
          }
          i += 1;
        }
      }
    }
    int i = MailContact.ContactType.NormalContact.ordinal();
    int j = MailContact.ContactType.ProtocolContact.ordinal();
    int m = MailContact.ContactType.PhoneContact.ordinal();
    int n = MailContact.ContactType.DomainContact.ordinal();
    int i1 = MailContact.ContactType.QQFriendContact.ordinal();
    int i2 = MailContact.ContactType.HistoryContact.ordinal();
    str = "C.type in $types$".replace("$types$", getInClause(new int[] { i, j }));
    paramArrayOfString = new StringBuilder();
    paramArrayOfString.append("SELECT ");
    paramArrayOfString.append("(");
    paramArrayOfString.append(paramString1);
    paramArrayOfString.append(" WHERE ");
    paramArrayOfString.append(paramString2);
    paramArrayOfString.append(" AND ");
    paramArrayOfString.append(str);
    paramArrayOfString.append("),");
    str = "C.type in $types$".replace("$types$", getInClause(new int[] { m, n, i1, i2 }));
    paramArrayOfString.append("(");
    paramArrayOfString.append(paramString1);
    paramArrayOfString.append(" WHERE ");
    paramArrayOfString.append(paramString2);
    paramArrayOfString.append(" AND ");
    paramArrayOfString.append(str);
    paramArrayOfString.append(")");
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(paramArrayOfString.toString(), (String[])localObject);
    paramString1 = new String[2];
    paramString1[0] = QMApplicationContext.sharedInstance().getString(2131692076);
    paramString1[1] = QMApplicationContext.sharedInstance().getString(2131692065);
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst())
      {
        i = k;
        while (i < paramString1.length)
        {
          j = paramSQLiteDatabase.getInt(i);
          if (j > 0) {
            localLinkedHashMap.put(String.valueOf(paramString1[i]), Integer.valueOf(j));
          }
          i += 1;
        }
      }
      paramSQLiteDatabase.close();
    }
    return localLinkedHashMap;
  }
  
  public MailGroupContactList getGroupContacts(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    Cursor localCursor = paramSQLiteDatabase.rawQuery(sqlQueryGroupContact, new String[] { String.valueOf(paramInt) });
    MailGroupContactList localMailGroupContactList = new MailGroupContactList();
    if (localCursor != null) {}
    try
    {
      if (localCursor.moveToFirst())
      {
        ArrayList localArrayList = new ArrayList();
        do
        {
          localArrayList.add((MailGroupContact)getContact(paramSQLiteDatabase, localCursor));
        } while (localCursor.moveToNext());
        localMailGroupContactList.setGroupContacts(localArrayList);
      }
      return localMailGroupContactList;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, this.TAG, Log.getStackTraceString(paramSQLiteDatabase));
      return localMailGroupContactList;
    }
    finally
    {
      localCursor.close();
    }
  }
  
  public ArrayList<MailContact> getMailContactsByAccountAndEmail(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = paramSQLiteDatabase.rawQuery("SELECT C.*  FROM QM_CONTACT AS C LEFT JOIN QM_REF_CONTACT_EMAIL AS E ON C.id = E.cid WHERE C.accountid = ? AND E.email = ?  AND  (C.offlinetype<3) ORDER BY C.vip DESC ", new String[] { String.valueOf(paramInt), paramString });
    if (paramString != null)
    {
      if (paramString.moveToFirst()) {
        do
        {
          localArrayList.add(getContact(paramSQLiteDatabase, paramString));
        } while (paramString.moveToNext());
      }
      paramString.close();
    }
    return localArrayList;
  }
  
  public ArrayList<MailContact> getMailContactsByAccountAndEmailAndName(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    paramString1 = paramSQLiteDatabase.rawQuery(queryContactByAccountAndEmailAndName, new String[] { String.valueOf(paramInt), paramString1, paramString2 });
    if (paramString1 != null)
    {
      if (paramString1.moveToFirst()) {
        do
        {
          localArrayList.add(getContact(paramSQLiteDatabase, paramString1));
        } while (paramString1.moveToNext());
      }
      paramString1.close();
    }
    return localArrayList;
  }
  
  public ArrayList<MailContact> getOffLineOpt(SQLiteDatabase paramSQLiteDatabase)
  {
    ArrayList localArrayList = Lists.newArrayList();
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT C.* FROM QM_CONTACT AS C WHERE offlinetype>0", null);
    if (localCursor != null) {}
    try
    {
      if (localCursor.moveToFirst())
      {
        boolean bool;
        do
        {
          localArrayList.add(getContact(paramSQLiteDatabase, localCursor));
          bool = localCursor.moveToNext();
        } while (bool);
      }
      return localArrayList;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, this.TAG, Log.getStackTraceString(paramSQLiteDatabase));
      return localArrayList;
    }
    finally
    {
      localCursor.close();
    }
  }
  
  public ArrayList<MailContact> getOffLineOptByAccountIdAndContactType(SQLiteDatabase paramSQLiteDatabase, int paramInt, MailContact.ContactType paramContactType)
  {
    ArrayList localArrayList = Lists.newArrayList();
    paramContactType = paramSQLiteDatabase.rawQuery("SELECT C.* FROM QM_CONTACT AS C WHERE offlinetype>0 AND accountid =? AND type =?", new String[] { String.valueOf(paramInt), String.valueOf(paramContactType.ordinal()) });
    if (paramContactType != null) {}
    try
    {
      if (paramContactType.moveToFirst())
      {
        boolean bool;
        do
        {
          localArrayList.add(getContact(paramSQLiteDatabase, paramContactType));
          bool = paramContactType.moveToNext();
        } while (bool);
      }
      return localArrayList;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, this.TAG, Log.getStackTraceString(paramSQLiteDatabase));
      return localArrayList;
    }
    finally
    {
      paramContactType.close();
    }
  }
  
  public ArrayList<MailContact> getOnlyChildContactByHash(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt)
  {
    int k = 0;
    ArrayList localArrayList = new ArrayList();
    Object localObject = new String[paramArrayOfInt.length];
    int m = paramArrayOfInt.length;
    int j = 0;
    int i = 0;
    while (j < m)
    {
      localObject[i] = String.valueOf(paramArrayOfInt[j]);
      j += 1;
      i += 1;
    }
    paramArrayOfInt = getContactIdByHash(paramSQLiteDatabase, sqlQueryOnlyChildContactIdByHash, (String[])localObject);
    if (paramArrayOfInt != null)
    {
      j = paramArrayOfInt.length;
      i = k;
      while (i < j)
      {
        localObject = getContactById(paramSQLiteDatabase, paramArrayOfInt[i]);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public int[] getOnlyChildContactHashes(SQLiteDatabase paramSQLiteDatabase)
  {
    ArrayList localArrayList = new ArrayList();
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(sqlQueryOnlyChildContactHash, null);
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst()) {
        do
        {
          localArrayList.add(Integer.valueOf(getInt(paramSQLiteDatabase, "hash")));
        } while (paramSQLiteDatabase.moveToNext());
      }
      paramSQLiteDatabase.close();
    }
    paramSQLiteDatabase = new int[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      paramSQLiteDatabase[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
    return paramSQLiteDatabase;
  }
  
  public MailContact getSameEmailContactWhenSync(SQLiteDatabase paramSQLiteDatabase, long paramLong, ArrayList<String> paramArrayList)
  {
    int i = generateEmailHash(paramArrayList);
    Object localObject = new HashMap();
    paramArrayList = paramSQLiteDatabase.rawQuery(sqlSelectSameEmailContactIdWhenSync.replace("$emails$", getStringInClause(paramArrayList)), new String[] { String.valueOf(paramLong) });
    if (paramArrayList != null) {}
    for (;;)
    {
      try
      {
        if (paramArrayList.moveToFirst())
        {
          paramLong = getLong(paramArrayList, "cid");
          str = getString(paramArrayList, "email");
          if (!((HashMap)localObject).containsKey(Long.valueOf(paramLong))) {
            continue;
          }
          localArrayList = (ArrayList)((HashMap)localObject).get(Long.valueOf(paramLong));
          localArrayList.add(str);
          ((HashMap)localObject).put(Long.valueOf(paramLong), localArrayList);
          boolean bool = paramArrayList.moveToNext();
          if (bool) {
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        String str;
        ArrayList localArrayList;
        QMLog.log(6, this.TAG, Log.getStackTraceString(localException));
        paramArrayList.close();
        continue;
      }
      finally
      {
        paramArrayList.close();
      }
      paramArrayList = ((HashMap)localObject).entrySet().iterator();
      if (!paramArrayList.hasNext()) {
        break;
      }
      localObject = (Map.Entry)paramArrayList.next();
      if (generateEmailHash((ArrayList)((Map.Entry)localObject).getValue()) == i)
      {
        return getContactById(paramSQLiteDatabase, ((Long)((Map.Entry)localObject).getKey()).longValue());
        localArrayList = new ArrayList();
        localArrayList.add(str);
        ((HashMap)localObject).put(Long.valueOf(paramLong), localArrayList);
      }
    }
    return null;
  }
  
  public LinkedHashMap<String, Integer> getSectionMap(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    int k = 0;
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int j;
    if (paramArrayOfString != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfString.length > 0)
      {
        localObject1 = new String[paramArrayOfString.length * (LETTERS.length + 1)];
        i = 0;
        while (i < LETTERS.length + 1)
        {
          j = 0;
          while (j < paramArrayOfString.length)
          {
            localObject1[(paramArrayOfString.length * i + j)] = paramArrayOfString[j];
            j += 1;
          }
          i += 1;
        }
      }
    }
    paramArrayOfString = new StringBuilder();
    paramArrayOfString.append("SELECT ");
    int i = 0;
    while (i < LETTERS.length)
    {
      paramArrayOfString.append("(");
      paramArrayOfString.append(paramString1 + " WHERE (" + "C.pinyin >= '$firstLetter$' AND C.pinyin < '$lastLetter$' AND  (C.offlinetype<3)".replace("$firstLetter$", String.valueOf(LETTERS[i])).replace("$lastLetter$", String.valueOf((char)(LETTERS[i] + '\001'))) + " OR " + "C.pinyin >= '$firstLetter$' AND C.pinyin < '$lastLetter$' AND  (C.offlinetype<3)".replace("$firstLetter$", String.valueOf(LETTERS_LOWERCASE[i])).replace("$lastLetter$", String.valueOf((char)(LETTERS_LOWERCASE[i] + '\001'))) + ") AND " + paramString2);
      paramArrayOfString.append("),");
      i += 1;
    }
    paramArrayOfString.append("(");
    paramArrayOfString.append(paramString1 + " WHERE ((" + "C.pinyin >  '$firstLetter$' OR  C.pinyin < '$lastLetter$' AND  (C.offlinetype<3)".replace("$firstLetter$", "Z").replace("$lastLetter$", "A") + ") AND (" + "C.pinyin >  '$firstLetter$' OR  C.pinyin < '$lastLetter$' AND  (C.offlinetype<3)".replace("$firstLetter$", "z").replace("$lastLetter$", "a") + ")) AND " + paramString2);
    paramArrayOfString.append(")");
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(paramArrayOfString.toString(), (String[])localObject1);
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst())
      {
        i = k;
        while (i < LETTERS.length)
        {
          j = paramSQLiteDatabase.getInt(i);
          if (j > 0) {
            localLinkedHashMap.put(String.valueOf(LETTERS[i]), Integer.valueOf(j));
          }
          i += 1;
        }
        i = paramSQLiteDatabase.getInt(LETTERS.length);
        if (i > 0) {
          localLinkedHashMap.put(String.valueOf('#'), Integer.valueOf(i));
        }
      }
      paramSQLiteDatabase.close();
    }
    return localLinkedHashMap;
  }
  
  public boolean insertContact(SQLiteDatabase paramSQLiteDatabase, int paramInt, MailContact paramMailContact)
  {
    Object localObject;
    int j;
    int i;
    if ((StringUtils.isEmpty(paramMailContact.getPinyin())) || (StringUtils.isEmpty(paramMailContact.getFullPinyin())))
    {
      if ((paramMailContact.getType() != MailContact.ContactType.QQFriendContact) || (StringUtils.isEmpty(paramMailContact.getMark()))) {
        break label129;
      }
      localObject = new String[1];
      localObject[0] = paramMailContact.getMark();
      j = localObject.length;
      i = 0;
    }
    for (;;)
    {
      CharSequence localCharSequence;
      if (i < j)
      {
        localCharSequence = localObject[i];
        if (StringUtils.isEmpty(localCharSequence)) {}
      }
      else
      {
        try
        {
          localObject = ContactsHelper.generatePinyin(localCharSequence);
          paramMailContact.setPinyin((String)((List)localObject).get(0));
          paramMailContact.setFullPinyin((String)((List)localObject).get(1));
          return doInsertContact(paramSQLiteDatabase, paramInt, paramMailContact);
        }
        catch (Exception paramSQLiteDatabase)
        {
          label129:
          return false;
        }
        localObject = new String[2];
        localObject[0] = paramMailContact.getName();
        localObject[1] = paramMailContact.getNick();
        break;
      }
      i += 1;
    }
  }
  
  public boolean insertContactGroup(SQLiteDatabase paramSQLiteDatabase, ContactGroup paramContactGroup)
  {
    int i = paramContactGroup.getId();
    int j = paramContactGroup.getGid();
    int k = paramContactGroup.getGgid();
    int m = paramContactGroup.getAccountId();
    int n = paramContactGroup.getCount();
    String str = paramContactGroup.getName();
    int i1 = paramContactGroup.getSequence();
    try
    {
      paramSQLiteDatabase.execSQL("REPLACE INTO QM_CONTACT_GROUP ( id,gid,ggid,accountId,count,name,sequence ) VALUES (?,?,?,?,?,?,?)", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), str, Integer.valueOf(i1) });
      return true;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, this.TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
    return true;
  }
  
  public boolean isContactExistWithAccountAndCid(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString)
  {
    boolean bool = false;
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT COUNT(id) AS CNT FROM QM_CONTACT AS C WHERE accountid=? AND cid =? AND  (C.offlinetype<3)", new String[] { String.valueOf(paramInt), String.valueOf(paramString) });
    if (paramSQLiteDatabase != null) {
      if (paramSQLiteDatabase.moveToFirst())
      {
        paramInt = paramSQLiteDatabase.getInt(0);
        paramSQLiteDatabase.close();
      }
    }
    for (;;)
    {
      if (paramInt >= 1) {
        bool = true;
      }
      return bool;
      paramInt = 0;
      break;
      paramInt = 0;
    }
  }
  
  public boolean isVipAddress(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1 = bool3;
    if (!StringUtils.isBlank(paramString))
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT COUNT(DISTINCT C.id)  FROM QM_CONTACT AS C, QM_REF_CONTACT_EMAIL AS E  WHERE C.id = E.cid AND C.vip= 1 AND E.email = ? AND  (C.offlinetype<3)", new String[] { paramString });
      bool1 = bool3;
      if (paramSQLiteDatabase != null)
      {
        if (!paramSQLiteDatabase.moveToFirst()) {
          break label74;
        }
        if (paramSQLiteDatabase.getInt(0) <= 0) {
          break label69;
        }
        bool1 = bool2;
      }
    }
    for (;;)
    {
      paramSQLiteDatabase.close();
      return bool1;
      label69:
      bool1 = false;
      continue;
      label74:
      bool1 = false;
    }
  }
  
  public boolean isVipAddressForAccount(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString)
  {
    boolean bool = false;
    Object localObject = null;
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT COUNT(DISTINCT C.id)  FROM QM_CONTACT AS C, QM_REF_CONTACT_EMAIL AS E  WHERE C.id = E.cid AND C.vip= 1 AND C.accountid= ? AND E.email = ? AND  (C.offlinetype<3)", new String[] { String.valueOf(paramInt), paramString });
      if (paramSQLiteDatabase != null) {
        if (paramSQLiteDatabase.moveToFirst())
        {
          paramInt = paramSQLiteDatabase.getInt(0);
          paramSQLiteDatabase.close();
          if (paramInt >= 1) {
            bool = true;
          }
          return bool;
        }
      }
    }
    catch (SQLiteException paramSQLiteDatabase)
    {
      for (;;)
      {
        QMLog.log(6, this.TAG, "isVipAddressForAccount", paramSQLiteDatabase);
        paramSQLiteDatabase = localObject;
        continue;
        paramInt = 0;
        continue;
        paramInt = 0;
      }
    }
  }
  
  public Cursor queryAccountContactToBlackWhiteList(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String paramString)
  {
    return paramSQLiteDatabase.rawQuery("SELECT C.* FROM QM_CONTACT AS C WHERE  ((C.hashtype=0 AND C.accountid IN $accountIds$) OR  (C.hashtype=1 AND EXISTS(SELECT CN.id FROM QM_CONTACT AS CN  WHERE CN.hashtype=-1 AND CN.accountid IN $accountIds$ AND CN.hash=C.hash))) AND C.address NOT IN (SELECT NL.email FROM QM_NAME_LIST AS NL WHERE NL.accountId=$accountIds$ AND NL.type=$nameListType$) AND C.address IS NOT NULL AND C.address != \"\" AND C.address != \"$selfEmail$\" ORDER BY  (CASE WHEN C.pinyin > '@' AND C.pinyin < '[' THEN 0  ELSE 1 END),C.pinyin,C.name,C.address".replace("$selfEmail$", paramString).replace("$accountIds$", getInClause(paramArrayOfInt1)).replace("$nameListType$", getInClause(paramArrayOfInt2)), null);
  }
  
  public Cursor queryAccountContactToBlackWhiteListRecentSender(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String paramString)
  {
    return paramSQLiteDatabase.rawQuery("SELECT fromAddr,fromAddrName,accountId FROM (SELECT * FROM QM_MAIL_INFO WHERE accountId=$accountIds$ AND fromAddr NOT IN (SELECT NL.email FROM QM_NAME_LIST AS NL WHERE NL.accountId=$accountIds$ AND NL.type=$nameListType$) AND fromAddr IS NOT NULL AND fromAddr != \"\" AND fromAddr != \"$selfEmail$\" AND attr & 8435712 = 0 ORDER BY utcReceived ASC)  GROUP BY fromAddr ORDER BY utcReceived DESC LIMIT 20".replace("$selfEmail$", paramString).replace("$accountIds$", getInClause(paramArrayOfInt1)).replace("$nameListType$", getInClause(paramArrayOfInt2)), null);
  }
  
  public Cursor queryAccountContactsByTypes(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return paramSQLiteDatabase.rawQuery("SELECT C.* FROM QM_CONTACT AS C WHERE  C.type IN $types$ AND  ((C.hashtype=0 AND C.accountid IN $accountIds$) OR  (C.hashtype=1 AND EXISTS(SELECT CN.id FROM QM_CONTACT AS CN  WHERE CN.hashtype=-1 AND CN.accountid IN $accountIds$ AND CN.hash=C.hash))) AND  (C.offlinetype<3) ORDER BY  (CASE WHEN C.pinyin > '@' AND C.pinyin < '[' THEN 0  ELSE 1 END),C.pinyin,C.name,C.address".replace("$accountIds$", getInClause(paramArrayOfInt1)).replace("$types$", getInClause(paramArrayOfInt2)), null);
  }
  
  public LinkedHashMap<String, Integer> queryAccountSectionsByTypes(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return getSectionMap(paramSQLiteDatabase, "SELECT COUNT(C.id) FROM QM_CONTACT AS C", " C.type IN $types$ AND  ((C.hashtype=0 AND C.accountid IN $accountIds$) OR  (C.hashtype=1 AND EXISTS(SELECT CN.id FROM QM_CONTACT AS CN  WHERE CN.hashtype=-1 AND CN.accountid IN $accountIds$ AND CN.hash=C.hash))) AND  (C.offlinetype<3)".replace("$accountIds$", getInClause(paramArrayOfInt1)).replace("$types$", getInClause(paramArrayOfInt2)), null);
  }
  
  public Cursor queryComposeContact(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt)
  {
    return paramSQLiteDatabase.rawQuery(queryComposeContact.replace("$accountIds$", getInClause(paramArrayOfInt)), null);
  }
  
  public Cursor queryComposeHistoryContactCount(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt)
  {
    return paramSQLiteDatabase.rawQuery(queryHistoryContactCount.replace("$accountIds$", getInClause(paramArrayOfInt)), null);
  }
  
  public ArrayList<String> queryContactEmailByAccountAndDomain(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString)
  {
    localArrayList = new ArrayList();
    localObject = null;
    localSQLiteDatabase = null;
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT E.email FROM QM_CONTACT AS C INNER JOIN QM_REF_CONTACT_EMAIL AS E ON C.id = E.cid WHERE C.accountid = ? AND E.email LIKE '%" + paramString + "'", new String[] { String.valueOf(paramInt) });
      if (paramSQLiteDatabase != null)
      {
        localSQLiteDatabase = paramSQLiteDatabase;
        localObject = paramSQLiteDatabase;
        if (paramSQLiteDatabase.moveToFirst())
        {
          boolean bool;
          do
          {
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            localArrayList.add(getString(paramSQLiteDatabase, "E.email"));
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            bool = paramSQLiteDatabase.moveToNext();
          } while (bool);
        }
      }
      if (paramSQLiteDatabase != null) {
        paramSQLiteDatabase.close();
      }
    }
    catch (Exception paramSQLiteDatabase)
    {
      do
      {
        localObject = localSQLiteDatabase;
        QMLog.log(6, this.TAG, Log.getStackTraceString(paramSQLiteDatabase));
      } while (localSQLiteDatabase == null);
      localSQLiteDatabase.close();
      return localArrayList;
    }
    finally
    {
      if (localObject == null) {
        break label173;
      }
      ((Cursor)localObject).close();
    }
    return localArrayList;
  }
  
  public HashMap<Long, ArrayList<String>> queryContactEmailCountMap(SQLiteDatabase paramSQLiteDatabase)
  {
    localObject = null;
    localSQLiteDatabase = null;
    localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT cid, email FROM QM_REF_CONTACT_EMAIL", null);
        if (paramSQLiteDatabase != null)
        {
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          if (paramSQLiteDatabase.moveToFirst())
          {
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            l = getLong(paramSQLiteDatabase, "cid");
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            str = getString(paramSQLiteDatabase, "email");
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            if (!localHashMap.containsKey(Long.valueOf(l))) {
              continue;
            }
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            localArrayList = (ArrayList)localHashMap.get(Long.valueOf(l));
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            localArrayList.add(str);
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            localHashMap.put(Long.valueOf(l), localArrayList);
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            boolean bool = paramSQLiteDatabase.moveToNext();
            if (bool) {
              continue;
            }
          }
        }
        if (paramSQLiteDatabase != null) {
          paramSQLiteDatabase.close();
        }
      }
      catch (Exception paramSQLiteDatabase)
      {
        long l;
        String str;
        ArrayList localArrayList;
        localObject = localSQLiteDatabase;
        QMLog.log(6, this.TAG, Log.getStackTraceString(paramSQLiteDatabase));
        if (localSQLiteDatabase == null) {
          continue;
        }
        localSQLiteDatabase.close();
        return localHashMap;
      }
      finally
      {
        if (localObject == null) {
          continue;
        }
        ((Cursor)localObject).close();
      }
      return localHashMap;
      localSQLiteDatabase = paramSQLiteDatabase;
      localObject = paramSQLiteDatabase;
      localArrayList = new ArrayList();
      localSQLiteDatabase = paramSQLiteDatabase;
      localObject = paramSQLiteDatabase;
      localArrayList.add(str);
      localSQLiteDatabase = paramSQLiteDatabase;
      localObject = paramSQLiteDatabase;
      localHashMap.put(Long.valueOf(l), localArrayList);
    }
  }
  
  public HashMap<Long, ArrayList<String>> queryContactTelMap(SQLiteDatabase paramSQLiteDatabase)
  {
    localObject = null;
    localSQLiteDatabase = null;
    localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT cid,value FROM QM_REF_CONTACT_CUSTOM WHERE type = 1", null);
        if (paramSQLiteDatabase != null)
        {
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          if (paramSQLiteDatabase.moveToFirst())
          {
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            l = getLong(paramSQLiteDatabase, "cid");
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            str = getString(paramSQLiteDatabase, "value");
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            if (!localHashMap.containsKey(Long.valueOf(l))) {
              continue;
            }
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            localArrayList = (ArrayList)localHashMap.get(Long.valueOf(l));
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            localArrayList.add(str);
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            localHashMap.put(Long.valueOf(l), localArrayList);
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            boolean bool = paramSQLiteDatabase.moveToNext();
            if (bool) {
              continue;
            }
          }
        }
        if (paramSQLiteDatabase != null) {
          paramSQLiteDatabase.close();
        }
      }
      catch (Exception paramSQLiteDatabase)
      {
        long l;
        String str;
        ArrayList localArrayList;
        localObject = localSQLiteDatabase;
        QMLog.log(6, this.TAG, Log.getStackTraceString(paramSQLiteDatabase));
        if (localSQLiteDatabase == null) {
          continue;
        }
        localSQLiteDatabase.close();
        return localHashMap;
      }
      finally
      {
        if (localObject == null) {
          continue;
        }
        ((Cursor)localObject).close();
      }
      return localHashMap;
      localSQLiteDatabase = paramSQLiteDatabase;
      localObject = paramSQLiteDatabase;
      localArrayList = new ArrayList();
      localSQLiteDatabase = paramSQLiteDatabase;
      localObject = paramSQLiteDatabase;
      localArrayList.add(str);
      localSQLiteDatabase = paramSQLiteDatabase;
      localObject = paramSQLiteDatabase;
      localHashMap.put(Long.valueOf(l), localArrayList);
    }
  }
  
  public Cursor queryContactsByGid(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    return paramSQLiteDatabase.rawQuery("SELECT C.* FROM QM_CONTACT AS C WHERE C.gid = ? AND  (C.hashtype=0 OR C.hashtype=1) AND  (C.offlinetype<3) ORDER BY  (CASE WHEN C.pinyin > '@' AND C.pinyin < '[' THEN 0  ELSE 1 END),C.pinyin,C.name,C.address", new String[] { String.valueOf(paramInt) });
  }
  
  public LinkedHashMap<String, Integer> querySearchAccountSectionsByTypes(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = DatabaseUtils.sqlEscapeString("%" + paramString + "%");
      str = " C.type IN $types$ AND  ((C.hashtype=0 AND C.accountid IN $accountIds$) OR  (C.hashtype=1 AND EXISTS(SELECT CN.id FROM QM_CONTACT AS CN  WHERE CN.hashtype=-1 AND CN.accountid IN $accountIds$ AND CN.hash=C.hash))) AND  (C.offlinetype<3) AND (((C.name LIKE $keyword$ OR C.pinyin LIKE $keyword$ OR C.fullpinyin LIKE $keyword$ OR C.mark LIKE $keyword$ OR C.address LIKE $keyword$) OR EXISTS (SELECT E.* FROM QM_REF_CONTACT_EMAIL AS E WHERE C.id= E.cid AND (E.email LIKE $keyword$ OR E.email IN $inEmailClause$)) OR EXISTS (SELECT CUSTOM.* FROM QM_REF_CONTACT_CUSTOM AS CUSTOM WHERE C.id=CUSTOM.cid AND CUSTOM.value LIKE $keyword$)) AND  ((C.hashtype=0 AND C.accountid IN $accountIds$) OR  (C.hashtype=1 AND EXISTS(SELECT CN.id FROM QM_CONTACT AS CN  WHERE CN.hashtype=-1 AND CN.accountid IN $accountIds$ AND CN.hash=C.hash))) AND  (C.offlinetype<3))".replace("$keyword$", str);
      if ((paramString == null) || (!paramString.equals(QMApplicationContext.sharedInstance().getString(2131692082)))) {
        break label131;
      }
    }
    label131:
    for (paramString = str.replace("$inEmailClause$", getStringInClause(QMComposeDataManager.sharedInstance().getAllComposeDataCache()));; paramString = str.replace("$inEmailClause$", "()"))
    {
      return getSectionMap(paramSQLiteDatabase, "SELECT COUNT(C.id) FROM QM_CONTACT AS C", paramString.replace("$accountIds$", getInClause(paramArrayOfInt1)).replace("$types$", getInClause(paramArrayOfInt2)), null);
      str = "''";
      break;
    }
  }
  
  public LinkedHashMap<String, Integer> querySearchAccountSectionsByTypesOrderByType(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = DatabaseUtils.sqlEscapeString("%" + paramString + "%");
      str = " C.type IN $types$ AND  ((C.hashtype=0 AND C.accountid IN $accountIds$) OR  (C.hashtype=1 AND EXISTS(SELECT CN.id FROM QM_CONTACT AS CN  WHERE CN.hashtype=-1 AND CN.accountid IN $accountIds$ AND CN.hash=C.hash))) AND  (C.offlinetype<3) AND (((C.name LIKE $keyword$ OR C.pinyin LIKE $keyword$ OR C.fullpinyin LIKE $keyword$ OR C.mark LIKE $keyword$ OR C.address LIKE $keyword$) OR EXISTS (SELECT E.* FROM QM_REF_CONTACT_EMAIL AS E WHERE C.id= E.cid AND (E.email LIKE $keyword$ OR E.email IN $inEmailClause$)) OR EXISTS (SELECT CUSTOM.* FROM QM_REF_CONTACT_CUSTOM AS CUSTOM WHERE C.id=CUSTOM.cid AND CUSTOM.value LIKE $keyword$)) AND  ((C.hashtype=0 AND C.accountid IN $accountIds$) OR  (C.hashtype=1 AND EXISTS(SELECT CN.id FROM QM_CONTACT AS CN  WHERE CN.hashtype=-1 AND CN.accountid IN $accountIds$ AND CN.hash=C.hash))) AND  (C.offlinetype<3))".replace("$keyword$", str);
      if ((paramString == null) || (!paramString.equals(QMApplicationContext.sharedInstance().getString(2131692082)))) {
        break label131;
      }
    }
    label131:
    for (paramString = str.replace("$inEmailClause$", getStringInClause(QMComposeDataManager.sharedInstance().getAllComposeDataCache()));; paramString = str.replace("$inEmailClause$", "()"))
    {
      return getContactTypeSectionMap(paramSQLiteDatabase, "SELECT COUNT(C.id) FROM QM_CONTACT AS C", paramString.replace("$accountIds$", getInClause(paramArrayOfInt1)).replace("$types$", getInClause(paramArrayOfInt2)), null);
      str = "''";
      break;
    }
  }
  
  public Cursor querySearchBlackWhiteListAddContact(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt, int paramInt, String paramString1, String paramString2)
  {
    paramString2 = "SELECT C.* FROM QM_CONTACT AS C WHERE  ((C.hashtype=0 AND C.accountid IN $accountIds$) OR  (C.hashtype=1 AND EXISTS(SELECT CN.id FROM QM_CONTACT AS CN  WHERE CN.hashtype=-1 AND CN.accountid IN $accountIds$ AND CN.hash=C.hash))) AND C.address NOT IN (SELECT NL.email FROM QM_NAME_LIST AS NL WHERE NL.accountId=$accountIds$ AND NL.type=$nameListType$) AND C.address IS NOT NULL AND C.address != \"\" AND C.address != \"$selfEmail$\" AND ((C.name LIKE $keyword$ OR C.pinyin LIKE $keyword$ OR C.fullpinyin LIKE $keyword$ OR C.mark LIKE $keyword$ OR C.address LIKE $keyword$) OR EXISTS (SELECT CUSTOM.* FROM QM_REF_CONTACT_CUSTOM AS CUSTOM WHERE C.id=CUSTOM.cid AND CUSTOM.value LIKE $keyword$)) AND  ((C.hashtype=0 AND C.accountid IN $accountIds$) OR  (C.hashtype=1 AND EXISTS(SELECT CN.id FROM QM_CONTACT AS CN  WHERE CN.hashtype=-1 AND CN.accountid IN $accountIds$ AND CN.hash=C.hash))) AND  (C.offlinetype<3)".replace("$selfEmail$", paramString2).replace("$accountIds$", getInClause(paramArrayOfInt)).replace("$nameListType$", String.valueOf(paramInt));
    if (paramString1 != null) {}
    for (paramArrayOfInt = DatabaseUtils.sqlEscapeString("%" + paramString1 + "%");; paramArrayOfInt = "''") {
      return paramSQLiteDatabase.rawQuery(paramString2.replace("$keyword$", paramArrayOfInt).replace("$inEmailClause$", "()"), null);
    }
  }
  
  public Cursor querySearchComposeContact(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt, String paramString)
  {
    String str = "SELECT C.*, E.* FROM QM_REF_CONTACT_EMAIL AS E LEFT JOIN QM_CONTACT AS C ON E.cid=C.id WHERE ((C.name LIKE $keyword$ OR C.pinyin LIKE $keyword$ OR C.fullpinyin LIKE $keyword$ OR C.mark LIKE $keyword$ OR C.address LIKE $keyword$) OR (E.email LIKE $keyword$ OR E.email IN $inEmailClause$) OR EXISTS (SELECT CUSTOM.* FROM QM_REF_CONTACT_CUSTOM AS CUSTOM WHERE C.id=CUSTOM.cid AND CUSTOM.value LIKE $keyword$)) AND  ((C.hashtype=0 AND C.accountid IN $accountIds$) OR  (C.hashtype=1 AND EXISTS(SELECT CN.id FROM QM_CONTACT AS CN  WHERE CN.hashtype=-1 AND CN.accountid IN $accountIds$ AND CN.hash=C.hash))) AND  (C.offlinetype<3) ORDER BY  (CASE WHEN E.freqUpdateTime + E.freq>0 THEN 0  WHEN C.pinyin > '@' AND C.pinyin < '[' THEN 1 ELSE 2 END),E.freqUpdateTime + E.freq DESC,C.pinyin,C.name,C.address".replace("$accountIds$", getInClause(paramArrayOfInt));
    if (paramString != null)
    {
      paramArrayOfInt = DatabaseUtils.sqlEscapeString("%" + paramString + "%");
      paramArrayOfInt = str.replace("$keyword$", paramArrayOfInt);
      if ((paramString == null) || (!paramString.equals(QMApplicationContext.sharedInstance().getString(2131692082)))) {
        break label110;
      }
    }
    label110:
    for (paramArrayOfInt = paramArrayOfInt.replace("$inEmailClause$", getStringInClause(QMComposeDataManager.sharedInstance().getAllComposeDataCache()));; paramArrayOfInt = paramArrayOfInt.replace("$inEmailClause$", "()"))
    {
      return paramSQLiteDatabase.rawQuery(paramArrayOfInt, null);
      paramArrayOfInt = "''";
      break;
    }
  }
  
  public Cursor querySearchContactByGid(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt, int paramInt, String paramString)
  {
    String str = "SELECT C.* FROM QM_CONTACT AS C WHERE C.gid = ? AND  (C.hashtype=0 OR C.hashtype=1) AND  (C.offlinetype<3) AND (((C.name LIKE $keyword$ OR C.pinyin LIKE $keyword$ OR C.fullpinyin LIKE $keyword$ OR C.mark LIKE $keyword$ OR C.address LIKE $keyword$) OR EXISTS (SELECT E.* FROM QM_REF_CONTACT_EMAIL AS E WHERE C.id= E.cid AND (E.email LIKE $keyword$ OR E.email IN $inEmailClause$)) OR EXISTS (SELECT CUSTOM.* FROM QM_REF_CONTACT_CUSTOM AS CUSTOM WHERE C.id=CUSTOM.cid AND CUSTOM.value LIKE $keyword$)) AND  (C.hashtype=0 OR C.hashtype=1) AND  (C.offlinetype<3)) ORDER BY  (CASE WHEN C.pinyin > '@' AND C.pinyin < '[' THEN 0  ELSE 1 END),C.pinyin,C.name,C.address".replace("$accountIds$", getInClause(paramArrayOfInt));
    if (paramString != null)
    {
      paramArrayOfInt = DatabaseUtils.sqlEscapeString("%" + paramString + "%");
      paramArrayOfInt = str.replace("$keyword$", paramArrayOfInt);
      if ((paramString == null) || (!paramString.equals(QMApplicationContext.sharedInstance().getString(2131692082)))) {
        break label124;
      }
    }
    label124:
    for (paramArrayOfInt = paramArrayOfInt.replace("$inEmailClause$", getStringInClause(QMComposeDataManager.sharedInstance().getAllComposeDataCache()));; paramArrayOfInt = paramArrayOfInt.replace("$inEmailClause$", "()"))
    {
      return paramSQLiteDatabase.rawQuery(paramArrayOfInt, new String[] { String.valueOf(paramInt) });
      paramArrayOfInt = "''";
      break;
    }
  }
  
  public Cursor querySearchContactByTypes(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String paramString)
  {
    paramArrayOfInt2 = "SELECT C.* FROM QM_CONTACT AS C WHERE  C.type IN $types$ AND  ((C.hashtype=0 AND C.accountid IN $accountIds$) OR  (C.hashtype=1 AND EXISTS(SELECT CN.id FROM QM_CONTACT AS CN  WHERE CN.hashtype=-1 AND CN.accountid IN $accountIds$ AND CN.hash=C.hash))) AND  (C.offlinetype<3) AND (((C.name LIKE $keyword$ OR C.pinyin LIKE $keyword$ OR C.fullpinyin LIKE $keyword$ OR C.mark LIKE $keyword$ OR C.address LIKE $keyword$) OR EXISTS (SELECT E.* FROM QM_REF_CONTACT_EMAIL AS E WHERE C.id= E.cid AND (E.email LIKE $keyword$ OR E.email IN $inEmailClause$)) OR EXISTS (SELECT CUSTOM.* FROM QM_REF_CONTACT_CUSTOM AS CUSTOM WHERE C.id=CUSTOM.cid AND CUSTOM.value LIKE $keyword$)) AND  ((C.hashtype=0 AND C.accountid IN $accountIds$) OR  (C.hashtype=1 AND EXISTS(SELECT CN.id FROM QM_CONTACT AS CN  WHERE CN.hashtype=-1 AND CN.accountid IN $accountIds$ AND CN.hash=C.hash))) AND  (C.offlinetype<3)) ORDER BY  (CASE WHEN C.pinyin > '@' AND C.pinyin < '[' THEN 0  ELSE 1 END),C.pinyin,C.name,C.address".replace("$accountIds$", getInClause(paramArrayOfInt1)).replace("$types$", getInClause(paramArrayOfInt2));
    if (paramString != null)
    {
      paramArrayOfInt1 = DatabaseUtils.sqlEscapeString("%" + paramString + "%");
      paramArrayOfInt1 = paramArrayOfInt2.replace("$keyword$", paramArrayOfInt1);
      if ((paramString == null) || (!paramString.equals(QMApplicationContext.sharedInstance().getString(2131692082)))) {
        break label122;
      }
    }
    label122:
    for (paramArrayOfInt1 = paramArrayOfInt1.replace("$inEmailClause$", getStringInClause(QMComposeDataManager.sharedInstance().getAllComposeDataCache()));; paramArrayOfInt1 = paramArrayOfInt1.replace("$inEmailClause$", "()"))
    {
      return paramSQLiteDatabase.rawQuery(paramArrayOfInt1, null);
      paramArrayOfInt1 = "''";
      break;
    }
  }
  
  public Cursor querySearchContactByTypesOrderByType(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String paramString)
  {
    paramArrayOfInt2 = querySearchContactsByAccountIdsAndTypesOrderByType.replace("$accountIds$", getInClause(paramArrayOfInt1)).replace("$types$", getInClause(paramArrayOfInt2));
    if (paramString != null)
    {
      paramArrayOfInt1 = DatabaseUtils.sqlEscapeString("%" + paramString + "%");
      paramArrayOfInt1 = paramArrayOfInt2.replace("$keyword$", paramArrayOfInt1);
      if ((paramString == null) || (!paramString.equals(QMApplicationContext.sharedInstance().getString(2131692082)))) {
        break label123;
      }
    }
    label123:
    for (paramArrayOfInt1 = paramArrayOfInt1.replace("$inEmailClause$", getStringInClause(QMComposeDataManager.sharedInstance().getAllComposeDataCache()));; paramArrayOfInt1 = paramArrayOfInt1.replace("$inEmailClause$", "()"))
    {
      return paramSQLiteDatabase.rawQuery(paramArrayOfInt1, null);
      paramArrayOfInt1 = "''";
      break;
    }
  }
  
  public LinkedHashMap<String, Integer> querySearchSectionByGid(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = DatabaseUtils.sqlEscapeString("%" + paramString + "%");
      str = "C.gid = ? AND  (C.hashtype=0 OR C.hashtype=1) AND  (C.offlinetype<3) AND (((C.name LIKE $keyword$ OR C.pinyin LIKE $keyword$ OR C.fullpinyin LIKE $keyword$ OR C.mark LIKE $keyword$ OR C.address LIKE $keyword$) OR EXISTS (SELECT E.* FROM QM_REF_CONTACT_EMAIL AS E WHERE C.id= E.cid AND (E.email LIKE $keyword$ OR E.email IN $inEmailClause$)) OR EXISTS (SELECT CUSTOM.* FROM QM_REF_CONTACT_CUSTOM AS CUSTOM WHERE C.id=CUSTOM.cid AND CUSTOM.value LIKE $keyword$)) AND  (C.hashtype=0 OR C.hashtype=1) AND  (C.offlinetype<3))".replace("$keyword$", str);
      if ((paramString == null) || (!paramString.equals(QMApplicationContext.sharedInstance().getString(2131692082)))) {
        break label115;
      }
    }
    label115:
    for (paramString = str.replace("$inEmailClause$", getStringInClause(QMComposeDataManager.sharedInstance().getAllComposeDataCache()));; paramString = str.replace("$inEmailClause$", "()"))
    {
      return getSectionMap(paramSQLiteDatabase, "SELECT COUNT(C.id) FROM QM_CONTACT AS C", paramString, new String[] { String.valueOf(paramInt) });
      str = "''";
      break;
    }
  }
  
  public LinkedHashMap<String, Integer> querySectionsByGid(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    return getSectionMap(paramSQLiteDatabase, "SELECT COUNT(C.id) FROM QM_CONTACT AS C", "C.gid = ? AND  (C.hashtype=0 OR C.hashtype=1) AND  (C.offlinetype<3)", new String[] { String.valueOf(paramInt) });
  }
  
  public void rebuildContactHash(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {}
    for (;;)
    {
      int i;
      try
      {
        int m = paramArrayOfInt.length;
        i = 0;
        if (i < m)
        {
          int k = paramArrayOfInt[i];
          long[] arrayOfLong = getContactIdByHash(paramSQLiteDatabase, sqlQueryParentContactIdByHash, new String[] { String.valueOf(k) });
          if ((arrayOfLong != null) && (arrayOfLong.length > 0))
          {
            n = arrayOfLong.length;
            j = 0;
            if (j < n)
            {
              deleteContact(paramSQLiteDatabase, arrayOfLong[j]);
              j += 1;
              continue;
            }
          }
          arrayOfLong = getContactIdByHash(paramSQLiteDatabase, sqlQueryChildContactIdByHash, new String[] { String.valueOf(k) });
          if ((arrayOfLong == null) || (arrayOfLong.length <= 0)) {
            break label328;
          }
          Object[] arrayOfObject = new Object[arrayOfLong.length + 1];
          int n = arrayOfLong.length;
          k = 0;
          int j = 1;
          if (k < n)
          {
            arrayOfObject[j] = String.valueOf(arrayOfLong[k]);
            k += 1;
            j += 1;
            continue;
          }
          if (arrayOfLong.length > 1)
          {
            MailContact localMailContact = getContactById(paramSQLiteDatabase, arrayOfLong[0]);
            if (localMailContact != null)
            {
              localMailContact = createParentContact(localMailContact);
              insertContact(paramSQLiteDatabase, localMailContact.getAccountId(), localMailContact);
            }
            arrayOfObject[0] = String.valueOf(-1);
            paramSQLiteDatabase.execSQL("UPDATE QM_CONTACT SET hashtype =?  WHERE id IN " + getInClause(arrayOfLong.length), arrayOfObject);
          }
          else
          {
            arrayOfObject[0] = String.valueOf(0);
            paramSQLiteDatabase.execSQL("UPDATE QM_CONTACT SET hashtype =?  WHERE id IN " + getInClause(arrayOfLong.length), arrayOfObject);
          }
        }
      }
      catch (Exception paramSQLiteDatabase)
      {
        QMLog.log(6, this.TAG, Log.getStackTraceString(paramSQLiteDatabase));
      }
      return;
      label328:
      i += 1;
    }
  }
  
  public void resetOffLineOptType(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    setOffLineOptType(paramSQLiteDatabase, paramLong, 0);
  }
  
  public Set<Long> selectContactIdInMergeByEmail(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    HashSet localHashSet = new HashSet();
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(sqlSelectContactIdInMergeByEmail.replace("$checked_account_ids$", paramString2), new String[] { paramString1 });
    if (paramSQLiteDatabase != null) {}
    try
    {
      if (paramSQLiteDatabase.moveToFirst())
      {
        boolean bool;
        do
        {
          localHashSet.add(Long.valueOf(getLong(paramSQLiteDatabase, "id")));
          bool = paramSQLiteDatabase.moveToNext();
        } while (bool);
      }
      return localHashSet;
    }
    catch (Exception paramString1)
    {
      QMLog.log(6, this.TAG, Log.getStackTraceString(paramString1));
      return localHashSet;
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
  }
  
  public void setOffLineOptType(SQLiteDatabase paramSQLiteDatabase, long paramLong, int paramInt)
  {
    try
    {
      paramSQLiteDatabase.execSQL("UPDATE QM_CONTACT SET offlinetype = ?  WHERE id = ?", new String[] { String.valueOf(paramInt), String.valueOf(paramLong) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, this.TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void setVipContact(SQLiteDatabase paramSQLiteDatabase, Long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramSQLiteDatabase.execSQL("UPDATE QM_CONTACT SET vip = ? WHERE id = ?", new Object[] { Integer.valueOf(i), paramLong });
      return;
    }
  }
  
  public void setVipContactByAccount(SQLiteDatabase paramSQLiteDatabase, int paramInt, List<String> paramList)
  {
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        paramSQLiteDatabase.execSQL("UPDATE QM_CONTACT SET vip = 1 WHERE accountid=? AND cid=?", new String[] { String.valueOf(paramInt), (String)paramList.next() });
      }
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, this.TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public boolean updateContact(SQLiteDatabase paramSQLiteDatabase, MailContact paramMailContact)
  {
    int k = 0;
    long l = paramMailContact.getId();
    int i;
    int j;
    try
    {
      Object localObject = paramMailContact.getAddress();
      String str1 = paramMailContact.getName();
      String str2 = paramMailContact.getPinyin();
      String str3 = paramMailContact.getFullPinyin();
      String str4 = paramMailContact.getUin();
      int m = paramMailContact.getType().ordinal();
      if (paramMailContact.isVip())
      {
        i = 1;
        if (!paramMailContact.isHistory()) {
          break label280;
        }
        j = 1;
        label67:
        String str5 = paramMailContact.getMark();
        if (paramMailContact.getGroup() != null) {
          k = paramMailContact.getGroup().getId();
        }
        paramSQLiteDatabase.execSQL("UPDATE QM_CONTACT SET address = ?, name = ?, pinyin = ?, fullpinyin = ?, uin = ?, type = ?, vip = ?, history = ?, mark = ?, gid = ?, hash = ?, hashtype = ?, offlinetype = ? WHERE id = ?", new Object[] { localObject, str1, str2, str3, str4, Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), str5, Integer.valueOf(k), Integer.valueOf(paramMailContact.getHash()), Integer.valueOf(paramMailContact.getHashType()), Integer.valueOf(paramMailContact.getOfflineType()), String.valueOf(l) });
        localObject = paramMailContact.getEmails();
        deleteContactEmails(paramSQLiteDatabase, l);
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          insertContactEmails(paramSQLiteDatabase, l, (ContactEmail)((Iterator)localObject).next());
          continue;
          return true;
        }
      }
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, this.TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
    for (;;)
    {
      i = 0;
      break;
      label280:
      j = 0;
      break label67;
      paramMailContact = paramMailContact.getCustoms();
      deleteContactCustom(paramSQLiteDatabase, l);
      paramMailContact = paramMailContact.iterator();
      while (paramMailContact.hasNext()) {
        insertContactCustom(paramSQLiteDatabase, l, (ContactCustom)paramMailContact.next());
      }
    }
  }
  
  public void upgradeTableFor5000(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_CONTACT ADD COLUMN gid INTEGER DEFAULT 0");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_CONTACT ADD COLUMN hash INTEGER DEFAULT 0");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_CONTACT ADD COLUMN hashtype INTEGER DEFAULT 0");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_CONTACT ADD COLUMN offlinetype INTEGER DEFAULT 0");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_REF_CONTACT_CUSTOM(cid integer, type integer, key varchar, value varchar )");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_CONTACT_GROUP(id integer, gid integer, ggid integer, accountId integer, count integer, name varchar, sequence integer,  unique(gid, ggid, accountId))");
  }
  
  public void upgradeTableFor5012(SQLiteDatabase paramSQLiteDatabase) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.QMContactSQLite
 * JD-Core Version:    0.7.0.1
 */