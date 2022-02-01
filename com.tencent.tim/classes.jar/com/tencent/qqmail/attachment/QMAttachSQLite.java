package com.tencent.qqmail.attachment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.util.SparseArray;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.model.AttachProtocol;
import com.tencent.qqmail.attachment.model.AttachProtocol.MailItemBodyInfo;
import com.tencent.qqmail.attachment.model.AttachState;
import com.tencent.qqmail.attachment.util.AttachToolbox;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper.UnsupportedGetDatabase;
import com.tencent.qqmail.model.mail.watcher.GroupAttachFolderWatcher;
import com.tencent.qqmail.model.mail.watcher.GroupAttachFolderWatcher.SyncRemoteParams;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailEditAttach;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.protocol.ItemBodyStructureHelper.MailItemBodyStructureInfo;
import com.tencent.qqmail.search.model.SearchAttachInfo;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

public class QMAttachSQLite
  extends QMMailSQLiteHelper.UnsupportedGetDatabase
{
  private static final String sqlAttachInsert = "REPLACE INTO QM_MAIL_ATTACH (id,alias,name,size,suffix,mailid,keyname,downloadsize,accountid,downloadurl,isembed,isaudio,isdownload,ispic,enableattfolder,mydisk,viewtype,iviewtype,previewtype,isprotocol,isexist,displayname,fileSizeByte,downloadSizeByte,mid,aid,type,data,cid,exchangeFileUid,fileContentType,protocolType,copydisklist,icon,refmailid,orderidx,folderkey,rank,attr,favtime,viewmode,mailsender,mailsubject,previewurl,mailsenderaddr,remoteid,urlencodename,isfavorite,folderid,downloadkey) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
  private static final String sqlBigAttachInsert = "REPLACE INTO QM_FTN_ATTACH (id,name,size,expiretime,type,previewtype,accountid,mailid,isdownload,keyname,downloadsize,downloadurl,protocoltype,mydisk,displayname,copydisklist,refmailid,orderidx) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
  private static final String sqlCreateAttach = "CREATE TABLE IF NOT EXISTS QM_MAIL_ATTACH(id integer primary key, alias varchar, name varchar, size varchar, suffix varchar, mailid integer, keyname varchar, downloadsize integer default 0, accountid integer, downloadurl varchar, isembed integer, isaudio integer, isdownload integer, ispic integer, enableattfolder integer, mydisk varchar, viewtype varchar, iviewtype integer, previewtype integer, isprotocol integer, isexist integer, displayname varchar, fileSizeByte integer, downloadSizeByte integer, mid integer, aid integer, type varchar, data blob, cid varchar, exchangeFileUid varchar, fileContentType varchar, protocolType integer, copydisklist varchar, icon varchar, refmailid integer, orderidx integer, folderkey integer, rank integer, attr integer, favtime integer, viewmode varchar, mailsender varchar, mailsubject varchar, previewurl varchar, mailsenderaddr varchar, remoteid varchar, urlencodename varchar, isfavorite integer, folderid integer, downloadkey varchar )";
  private static final String sqlCreateAttachIndex = "CREATE INDEX IF NOT EXISTS QM_MAIL_ATTACH_INDEX ON QM_MAIL_ATTACH(mailid)";
  private static final String sqlCreateAttachOrderIdxIndex = "CREATE INDEX IF NOT EXISTS QM_MAIL_ATTACH_ORDER_IDX_INDEX ON QM_MAIL_ATTACH(mailid,orderidx)";
  private static final String sqlCreateBigAttach = "CREATE TABLE IF NOT EXISTS QM_FTN_ATTACH(id integer primary key, name varchar, size varchar, expiretime integer, type varchar, previewtype integer, accountid integer, mailid varchar, isdownload integer, keyname varchar, downloadsize integer default 0, downloadurl varchar, protocoltype integer, mydisk varchar, displayname varchar, copydisklist varchar, refmailid integer, orderidx integer)";
  private static final String sqlCreateBigAttachOrderIdxIndex = "CREATE INDEX IF NOT EXISTS INDEX_FTN_ATTACH ON QM_FTN_ATTACH(mailid,orderidx)";
  private static final String sqlCreateEditAttach = "CREATE TABLE IF NOT EXISTS QM_EDIT_ATTACH(id integer primary key, name varchar, type varchar, icon varchar, url varchar, key varchar, size varchar, accountid integer, mailid integer)";
  private static final String sqlCreatePartInfo = "CREATE TABLE IF NOT EXISTS QM_MAIL_ATTACH_PART_INFO(id integer primary key, aid integer, rmtaid integer, rmtmid integer, rmtid integer, bodyid integer, rmtitemid varchar, itemtype varchar, contentType varchar, contentSubType varchar, contentTypeParams varchar, contentDescription varchar, contentTransferEncoding varchar, contentLineSize varchar, contentDisposition varchar)";
  private static final String sqlDeleteAttachPathByMyDisk = "UPDATE QM_MAIL_ATTACH SET mydisk = '' WHERE mydisk = ?";
  private static final String sqlDeleteBigAttachPathByMyDisk = "UPDATE QM_FTN_ATTACH SET mydisk = '' WHERE mydisk = ?";
  private static final String sqlDropAttach = "DROP TABLE IF EXISTS QM_MAIL_ATTACH";
  private static final String sqlDropAttachIndex = "DROP INDEX IF EXISTS QM_MAIL_ATTACH_INDEX";
  private static final String sqlDropAttachOrderIdxIndex = "DROP INDEX IF EXISTS QM_MAIL_ATTACH_ORDER_IDX_INDEX";
  private static final String sqlDropBigAttach = "DROP TABLE IF EXISTS QM_FTN_ATTACH";
  private static final String sqlDropBigAttachOrderIdxIndex = "DROP INDEX IF EXISTS INDEX_FTN_ATTACH";
  private static final String sqlDropEditAttach = "DROP TABLE IF EXISTS QM_EDIT_ATTACH";
  private static final String sqlDropPartInfo = "DROP TABLE IF EXISTS QM_MAIL_ATTACH_PART_INFO";
  private static final String sqlEditAttachInsert = "REPLACE INTO QM_EDIT_ATTACH (id,name,type,icon,url,key,size,accountid,mailid) VALUES (?,?,?,?,?,?,?,?,?)";
  private static final String sqlGroupAccountIds = "SELECT accountid, name, remoteid, downloadurl, id, downloadkey FROM QM_MAIL_ATTACH WHERE id IN $inClause$ ORDER BY accountid";
  private static final String sqlPartInfoInsert = "REPLACE INTO QM_MAIL_ATTACH_PART_INFO (id,aid,rmtaid,rmtmid,rmtid,bodyid,rmtitemid,itemtype,contentType,contentSubType,contentTypeParams,contentDescription,contentTransferEncoding,contentLineSize,contentDisposition) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
  private static final String sqlQueryAttach = "SELECT * FROM QM_MAIL_ATTACH WHERE id = ?";
  private static final String sqlQueryAttachAttr = "SELECT attr FROM QM_MAIL_ATTACH WHERE id=?";
  private static final String sqlQueryAttachByAccount = "SELECT id FROM QM_MAIL_ATTACH WHERE accountid IN ";
  private static final String sqlQueryAttachByMailId = "SELECT * FROM QM_MAIL_ATTACH WHERE mailid = ? ORDER BY orderidx";
  private static final String sqlQueryAttachByMailIds = "SELECT * FROM QM_MAIL_ATTACH WHERE mailid IN ";
  private static final String sqlQueryAttachByRemoteMailId = "SELECT * FROM QM_MAIL_ATTACH WHERE remoteid = ?";
  private static final String sqlQueryAttachCopyDisk = "SELECT copydisklist FROM QM_MAIL_ATTACH WHERE id = ? ";
  private static final String sqlQueryAttachDownUrl = "SELECT downloadurl FROM QM_MAIL_ATTACH WHERE id = ? ORDER BY orderidx";
  private static final String sqlQueryAttachFolderById = "SELECT COUNT(id) FROM QM_MAIL_ATTACH WHERE isfavorite=1 AND id=? ";
  private static final String sqlQueryAttachFolderCount = "SELECT COUNT(id) FROM QM_MAIL_ATTACH WHERE isfavorite=1 ";
  private static final String sqlQueryAttachFolderSyncKey = "SELECT folderkey FROM QM_MAIL_ATTACH WHERE accountid=? AND ~(attr &?) AND isfavorite=1 ";
  private static final String sqlQueryAttachIds = "SELECT id FROM QM_MAIL_ATTACH";
  private static final String sqlQueryAttachMatchedMailId = "SELECT mailid,subject,QM_MAIL_INFO.accountId FROM QM_MAIL_ATTACH , QM_MAIL_INFO WHERE QM_MAIL_ATTACH.name = ? AND QM_MAIL_ATTACH.mailid = QM_MAIL_INFO.id ORDER BY QM_MAIL_INFO.utcReceived DESC LIMIT 1";
  private static final String sqlQueryAttachMyDisk = "SELECT mydisk FROM QM_MAIL_ATTACH WHERE id = ? ";
  private static final String sqlQueryAttachNotDelete = "SELECT A.* FROM QM_MAIL_ATTACH AS A WHERE mailid NOT IN ( SELECT id FROM QM_MAIL_INFO WHERE folderId IN ( SELECT id FROM QM_FOLDER WHERE type IN ( 5,6,102,4)))";
  private static final String sqlQueryAttachPartInfo = "SELECT * FROM QM_MAIL_ATTACH_PART_INFO WHERE aid = ?";
  private static final String sqlQueryAttachRefMailId = "SELECT refmailid FROM QM_MAIL_ATTACH WHERE id = ? ";
  private static final String sqlQueryBigAttach = "SELECT * FROM QM_FTN_ATTACH WHERE id = ?";
  private static final String sqlQueryBigAttachByMailId = "SELECT * FROM QM_FTN_ATTACH WHERE mailid = ? ORDER BY orderidx";
  private static final String sqlQueryBigAttachByMailIds = "SELECT * FROM QM_FTN_ATTACH WHERE mailid IN  ";
  private static final String sqlQueryBigAttachCopyDisk = "SELECT copydisklist FROM QM_FTN_ATTACH WHERE id = ? ";
  private static final String sqlQueryBigAttachDownUrl = "SELECT downloadurl FROM QM_FTN_ATTACH WHERE id = ? ORDER BY orderidx";
  private static final String sqlQueryBigAttachMyDisk = "SELECT mydisk FROM QM_FTN_ATTACH WHERE id = ? ";
  private static final String sqlQueryBigAttachRefMailId = "SELECT refmailid FROM QM_FTN_ATTACH WHERE id = ? ";
  private static final String sqlQueryEditAttach = "SELECT * FROM QM_EDIT_ATTACH WHERE id = ?";
  private static final String sqlQueryEditAttachByMailId = "SELECT * FROM QM_EDIT_ATTACH WHERE mailid = ?";
  private static final String sqlQueryEditAttachByMailIds = "SELECT * FROM QM_EDIT_ATTACH WHERE mailid IN  ";
  private static final String sqlQueryInlineImage = "SELECT * FROM QM_MAIL_ATTACH WHERE cid = ?";
  private static final String sqlQueryIsEml = "SELECT * FROM QM_TMP_EML_MAIL_INFO WHERE id = ?";
  private static final String sqlUpdateAddAttachFavorite = "UPDATE QM_MAIL_ATTACH SET isfavorite=1  WHERE id IN ";
  private static final String sqlUpdateAttachCidByID = "UPDATE QM_MAIL_ATTACH SET cid=? WHERE id=? ";
  private static final String sqlUpdateAttachCidByUID = "UPDATE QM_MAIL_ATTACH SET cid=? WHERE exchangeFileUid=? ";
  private static final String sqlUpdateAttachDisk = "UPDATE QM_MAIL_ATTACH SET mydisk=?, copydisklist=?, displayname=?  WHERE id=? ";
  private static final String sqlUpdateAttachDiskByAid = "UPDATE QM_MAIL_ATTACH SET mydisk=?, copydisklist=?  WHERE aid=? ";
  private static final String sqlUpdateAttachFavoriteStateByAccount = "UPDATE QM_MAIL_ATTACH SET isfavorite=0  WHERE folderkey=0 AND accountid=? ";
  private static final String sqlUpdateAttachFavoriteStateByFolderKey = "UPDATE QM_MAIL_ATTACH SET isfavorite=0 WHERE folderkey IN ";
  private static final String sqlUpdateAttachIsDownload = "UPDATE QM_MAIL_ATTACH SET displayname=? , isdownload=?  WHERE id=? ";
  private static final String sqlUpdateAttachRefMailId = "UPDATE QM_MAIL_ATTACH SET refmailid=? WHERE id=? ";
  private static final String sqlUpdateAttachTypeByCID = "UPDATE QM_MAIL_ATTACH SET type=? WHERE cid IN$inClause$";
  private static final String sqlUpdateAttachTypeByID = "UPDATE QM_MAIL_ATTACH SET type=? WHERE id IN$inClause$";
  private static final String sqlUpdateAttachTypeByUID = "UPDATE QM_MAIL_ATTACH SET type=? WHERE exchangeFileUid IN$inClause$";
  private static final String sqlUpdateBigAttachDisk = "UPDATE QM_FTN_ATTACH SET mydisk=?, copydisklist=?, displayname=?  WHERE id=? ";
  private static final String sqlUpdateBigAttachDiskByAid = "UPDATE QM_FTN_ATTACH SET mydisk=?, copydisklist=?  WHERE id=? ";
  private static final String sqlUpdateBigAttachExpire = "UPDATE QM_FTN_ATTACH SET expiretime = ? WHERE id = ?";
  private static final String sqlUpdateBigAttachIsDownload = "UPDATE QM_FTN_ATTACH SET displayname=? , isdownload=?  WHERE id=? ";
  private static final String sqlUpdateBigAttachRefMailId = "UPDATE QM_FTN_ATTACH SET refmailid=? WHERE id=? ";
  private static final String sqlUpdateRemoveAttachFavorite = "UPDATE QM_MAIL_ATTACH SET isfavorite=0  WHERE id IN ";
  
  public QMAttachSQLite(Context paramContext)
  {
    super(paramContext, false);
  }
  
  private void deleteAttach(SQLiteDatabase paramSQLiteDatabase, ArrayList<Object> paramArrayList, boolean paramBoolean)
  {
    Object localObject1 = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      Object localObject2 = paramArrayList.get(i);
      if ((localObject2 instanceof Attach)) {
        ((ArrayList)localObject1).add(String.valueOf(((Attach)localObject2).getHashId()));
      }
      i += 1;
    }
    paramArrayList = getInClause(((ArrayList)localObject1).size());
    localObject1 = (String[])((ArrayList)localObject1).toArray(new String[((ArrayList)localObject1).size()]);
    if (paramBoolean)
    {
      paramSQLiteDatabase.delete("QM_FTN_ATTACH", "id IN " + paramArrayList, (String[])localObject1);
      return;
    }
    paramSQLiteDatabase.delete("QM_MAIL_ATTACH_PART_INFO", "aid IN " + paramArrayList, (String[])localObject1);
    paramSQLiteDatabase.delete("QM_MAIL_ATTACH", "id IN " + paramArrayList, (String[])localObject1);
  }
  
  private void deleteAttachPartInfo(SQLiteDatabase paramSQLiteDatabase, ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    String[] arrayOfString = new String[paramArrayList.size()];
    paramArrayList.toArray(arrayOfString);
    paramSQLiteDatabase.delete("QM_MAIL_ATTACH_PART_INFO", "aid IN " + getInClause(paramArrayList.size()), arrayOfString);
  }
  
  private void deleteEditAttach(SQLiteDatabase paramSQLiteDatabase, ArrayList<Object> paramArrayList)
  {
    Object localObject1 = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      Object localObject2 = paramArrayList.get(i);
      if ((localObject2 instanceof Attach)) {
        ((ArrayList)localObject1).add(String.valueOf(((Attach)localObject2).getHashId()));
      }
      i += 1;
    }
    paramArrayList = getInClause(((ArrayList)localObject1).size());
    localObject1 = (String[])((ArrayList)localObject1).toArray(new String[((ArrayList)localObject1).size()]);
    paramSQLiteDatabase.delete("QM_EDIT_ATTACH", "id IN" + paramArrayList, (String[])localObject1);
  }
  
  private static Attach fillAttach(Cursor paramCursor)
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        Attach localAttach = new Attach(false);
        localAttach.setHashId(getInt(paramCursor, "id"));
        localAttach.setAlias(getString(paramCursor, "alias"));
        localAttach.setName(getString(paramCursor, "name"));
        localAttach.setSize(getString(paramCursor, "size"));
        localAttach.setSuffix(getString(paramCursor, "suffix"));
        localAttach.setBelongMailId(getLong(paramCursor, "mailid"));
        localAttach.setAccountId(getInt(paramCursor, "accountid"));
        localAttach.setDisplayName(getString(paramCursor, "displayname"));
        localAttach.setBytes(getLong(paramCursor, "fileSizeByte"));
        localAttach.setRefMailId(getLong(paramCursor, "refmailid"));
        localAttach.setOrderIndex(getInt(paramCursor, "orderidx"));
        localAttach.setFolderId(getInt(paramCursor, "folderid"));
        if (getInt(paramCursor, "isfavorite") != 0)
        {
          bool1 = true;
          localAttach.setIsFav(bool1);
          localAttach.setFolderKey(getInt(paramCursor, "folderkey"));
          localAttach.setRank(getInt(paramCursor, "folderkey"));
          localAttach.setFavTime(getLong(paramCursor, "favtime"));
          localAttach.setViewMode(getString(paramCursor, "viewmode"));
          localAttach.setMailSender(getString(paramCursor, "mailsender"));
          localAttach.setMailSubject(getString(paramCursor, "mailsubject"));
          localAttach.setPreviewUrl(getString(paramCursor, "previewurl"));
          localAttach.setMailSenderAddr(getString(paramCursor, "mailsenderaddr"));
          localAttach.setRemoteId(getString(paramCursor, "remoteid"));
          localAttach.setUrlEncodeName(getString(paramCursor, "urlencodename"));
          localAttach.setDownloadKey(getString(paramCursor, "downloadkey"));
          localAttach.getState().setIsDownload(getInt(paramCursor, "isdownload") + "");
          localAttach.getState().setKeyName(getString(paramCursor, "keyname"));
          localAttach.getState().setDownloadSize(getInt(paramCursor, "downloadsize") + "");
          localAttach.getState().setDownloadSizeByte(getLong(paramCursor, "downloadSizeByte"));
          localAttach.getState().setAttr(getInt(paramCursor, "attr"));
          setAttachAttr(localAttach, localAttach.getState().getAttr());
          localAttach.getPreview().setDownloadUrl(getString(paramCursor, "downloadurl"));
          Object localObject = localAttach.getPreview();
          if (getInt(paramCursor, "ispic") == 0) {
            break label879;
          }
          bool1 = true;
          ((AttachPreview)localObject).setIsPic(bool1);
          localObject = localAttach.getPreview();
          if (getInt(paramCursor, "isembed") == 0) {
            break label884;
          }
          bool1 = true;
          ((AttachPreview)localObject).setIsEmbed(bool1);
          localObject = localAttach.getPreview();
          if (getInt(paramCursor, "isaudio") == 0) {
            break label889;
          }
          bool1 = true;
          ((AttachPreview)localObject).setIsAudio(bool1);
          localObject = localAttach.getPreview();
          if (getInt(paramCursor, "enableattfolder") == 0) {
            break label894;
          }
          bool1 = true;
          ((AttachPreview)localObject).setEnableAttFolder(bool1);
          localAttach.getPreview().setMyDisk(getString(paramCursor, "mydisk"));
          localAttach.getPreview().setViewType(getString(paramCursor, "viewtype"));
          localAttach.getPreview().setIviewtype(getInt(paramCursor, "iviewtype") + "");
          localAttach.getPreview().setIcon(getString(paramCursor, "icon"));
          localObject = AttachPreview.parseCopyDiskList(getString(paramCursor, "copydisklist"));
          if (localObject != null)
          {
            int j = localObject.length;
            int i = 0;
            if (i < j)
            {
              String str = localObject[i];
              localAttach.getPreview().addCopyDisk(str);
              i += 1;
              continue;
            }
          }
          if (getInt(paramCursor, "isprotocol") != 0)
          {
            bool1 = bool2;
            localAttach.setIsProtocol(bool1);
            localAttach.getProtocol().setIsexist(getInt(paramCursor, "isexist"));
            localAttach.getProtocol().setMailId(getLong(paramCursor, "mid"));
            localAttach.getProtocol().setAttachId(getLong(paramCursor, "aid"));
            localAttach.getProtocol().setType(getString(paramCursor, "type"));
            localAttach.getProtocol().setData(getBlob(paramCursor, "data"));
            localAttach.getProtocol().setCid(getString(paramCursor, "cid"));
            localAttach.getProtocol().setExchangeFileUid(getString(paramCursor, "exchangeFileUid"));
            localAttach.getProtocol().setFileContentType(getString(paramCursor, "fileContentType"));
            localAttach.getProtocol().setProtocolType(getInt(paramCursor, "protocolType"));
            return localAttach;
          }
          bool1 = false;
          continue;
        }
        bool1 = false;
      }
      catch (Exception paramCursor)
      {
        QMLog.log(5, "QMMailSQLite", "fillAttach:" + paramCursor.toString());
        return null;
      }
      continue;
      label879:
      boolean bool1 = false;
      continue;
      label884:
      bool1 = false;
      continue;
      label889:
      bool1 = false;
      continue;
      label894:
      bool1 = false;
    }
  }
  
  public static Attach fillAttach(SQLiteDatabase paramSQLiteDatabase, Cursor paramCursor)
  {
    if (paramCursor != null) {
      return fillAttachProtocol(paramSQLiteDatabase, fillAttach(paramCursor));
    }
    return null;
  }
  
  private static Attach fillAttachBodyInfo(Cursor paramCursor, Attach paramAttach)
  {
    try
    {
      paramAttach.getProtocol().setAttachId(getLong(paramCursor, "rmtaid"));
      paramAttach.getProtocol().setMailId(getLong(paramCursor, "rmtmid"));
      paramAttach.getProtocol().getBodyInfo().hashId = getLong(paramCursor, "id");
      paramAttach.getProtocol().getBodyInfo().attachId = getLong(paramCursor, "rmtaid");
      paramAttach.getProtocol().getBodyInfo().mailId = getLong(paramCursor, "rmtmid");
      paramAttach.getProtocol().getBodyInfo().id = getLong(paramCursor, "rmtid");
      paramAttach.getProtocol().getBodyInfo().itemId = getLong(paramCursor, "rmtitemid");
      paramAttach.getProtocol().getBodyInfo().bodyId = getString(paramCursor, "bodyid");
      paramAttach.getProtocol().getBodyInfo().itemType = getString(paramCursor, "itemtype");
      paramAttach.getProtocol().getBodyInfo().contentType = getString(paramCursor, "contentType");
      paramAttach.getProtocol().getBodyInfo().contentSubType = getString(paramCursor, "contentSubType");
      paramAttach.getProtocol().getBodyInfo().contentTypeParams = getString(paramCursor, "contentTypeParams");
      paramAttach.getProtocol().getBodyInfo().contentDescription = getString(paramCursor, "contentDescription");
      paramAttach.getProtocol().getBodyInfo().transferEncoding = getString(paramCursor, "contentTransferEncoding");
      paramAttach.getProtocol().getBodyInfo().contentLineSize = getString(paramCursor, "contentLineSize");
      paramAttach.getProtocol().getBodyInfo().contentDisposition = getString(paramCursor, "contentDisposition");
      return paramAttach;
    }
    catch (Exception paramCursor)
    {
      QMLog.log(5, "QMMailSQLite", "fillAttachBodyInfo:" + paramCursor.toString());
    }
    return null;
  }
  
  private static ArrayList<Object> fillAttachList(SQLiteDatabase paramSQLiteDatabase, Cursor paramCursor)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramCursor != null) {
      while (paramCursor.moveToNext()) {
        localArrayList.add(fillAttachProtocol(paramSQLiteDatabase, fillAttach(paramCursor)));
      }
    }
    return localArrayList;
  }
  
  private static Attach fillAttachProtocol(SQLiteDatabase paramSQLiteDatabase, Attach paramAttach)
  {
    Attach localAttach = paramAttach;
    if (paramAttach != null)
    {
      localAttach = paramAttach;
      if (paramAttach.isProtocol())
      {
        localAttach = paramAttach;
        if (paramAttach.getProtocol().getProtocolType() == 1)
        {
          paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_MAIL_ATTACH_PART_INFO WHERE aid = ?", new String[] { paramAttach.getHashId() + "" });
          localAttach = paramAttach;
          if (paramSQLiteDatabase != null)
          {
            localAttach = paramAttach;
            if (paramSQLiteDatabase.moveToFirst())
            {
              localAttach = fillAttachBodyInfo(paramSQLiteDatabase, paramAttach);
              paramSQLiteDatabase.close();
            }
          }
        }
      }
    }
    return localAttach;
  }
  
  private static MailBigAttach fillBigAttach(Cursor paramCursor)
  {
    int i = 0;
    try
    {
      MailBigAttach localMailBigAttach = new MailBigAttach(false);
      localMailBigAttach.setHashId(getInt(paramCursor, "id"));
      localMailBigAttach.setName(getString(paramCursor, "name"));
      localMailBigAttach.setSize(getString(paramCursor, "size"));
      localMailBigAttach.setExpire(getLong(paramCursor, "expiretime"));
      localMailBigAttach.setType(getString(paramCursor, "type"));
      localMailBigAttach.setAccountId(getInt(paramCursor, "accountid"));
      localMailBigAttach.setBelongMailId(Long.valueOf(getString(paramCursor, "mailid")).longValue());
      localMailBigAttach.setDisplayName(getString(paramCursor, "displayname"));
      localMailBigAttach.setRefMailId(getLong(paramCursor, "refmailid"));
      localMailBigAttach.setOrderIndex(getInt(paramCursor, "orderidx"));
      localMailBigAttach.getState().setIsDownload(getInt(paramCursor, "isdownload") + "");
      localMailBigAttach.getState().setDownloadSize(getInt(paramCursor, "downloadsize") + "");
      localMailBigAttach.getState().setKeyName(getString(paramCursor, "keyname"));
      Object localObject = localMailBigAttach.getState().getKeyName();
      if ((localObject != null) && (!((String)localObject).equals("")))
      {
        localObject = ((String)localObject).split("&");
        if (localObject.length >= 2)
        {
          localMailBigAttach.setFid(localObject[0]);
          localMailBigAttach.setSha(localObject[1]);
        }
      }
      localMailBigAttach.getPreview().setDownloadUrl(getString(paramCursor, "downloadurl"));
      localMailBigAttach.getPreview().setMyDisk(getString(paramCursor, "mydisk"));
      localObject = AttachPreview.parseCopyDiskList(getString(paramCursor, "copydisklist"));
      if (localObject != null)
      {
        int j = localObject.length;
        while (i < j)
        {
          String str = localObject[i];
          localMailBigAttach.getPreview().addCopyDisk(str);
          i += 1;
        }
      }
      localMailBigAttach.getProtocol().setProtocolType(getInt(paramCursor, "protocoltype"));
      return localMailBigAttach;
    }
    catch (Exception paramCursor)
    {
      paramCursor.printStackTrace();
    }
    return null;
  }
  
  private static ArrayList<Object> fillBigAttachList(Cursor paramCursor)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramCursor != null) {
      while (paramCursor.moveToNext()) {
        localArrayList.add(fillBigAttach(paramCursor));
      }
    }
    return localArrayList;
  }
  
  private static MailEditAttach fillEditAttach(Cursor paramCursor)
  {
    try
    {
      MailEditAttach localMailEditAttach = new MailEditAttach(false);
      localMailEditAttach.setHashId(getInt(paramCursor, "id"));
      localMailEditAttach.setName(getString(paramCursor, "name"));
      localMailEditAttach.setType(getString(paramCursor, "type"));
      localMailEditAttach.setIcon(getString(paramCursor, "icon"));
      localMailEditAttach.setUrl(getString(paramCursor, "url"));
      localMailEditAttach.setKey(getString(paramCursor, "key"));
      localMailEditAttach.setSize(getString(paramCursor, "size"));
      localMailEditAttach.setAccountId(getInt(paramCursor, "accountid"));
      localMailEditAttach.setBelongMailId(getLong(paramCursor, "id"));
      return localMailEditAttach;
    }
    catch (Exception paramCursor)
    {
      paramCursor.printStackTrace();
    }
    return null;
  }
  
  private static ArrayList<Object> fillEditAttachList(Cursor paramCursor)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramCursor != null) {
      while (paramCursor.moveToNext()) {
        localArrayList.add(fillEditAttach(paramCursor));
      }
    }
    return localArrayList;
  }
  
  public static void fillMailAttach(SQLiteDatabase paramSQLiteDatabase, Mail paramMail)
  {
    MailInformation localMailInformation = paramMail.getInformation();
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_MAIL_ATTACH WHERE mailid = ? ORDER BY orderidx", new String[] { paramMail.getInformation().getId() + "" });
    ArrayList localArrayList;
    if (localCursor != null)
    {
      localArrayList = fillAttachList(paramSQLiteDatabase, localCursor);
      if (localArrayList != null) {
        localMailInformation.setAttachList(localArrayList);
      }
      localCursor.close();
    }
    localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_FTN_ATTACH WHERE mailid = ? ORDER BY orderidx", new String[] { paramMail.getInformation().getId() + "" });
    if (localCursor != null)
    {
      localArrayList = fillBigAttachList(localCursor);
      if (localArrayList != null) {
        localMailInformation.setBigAttachList(localArrayList);
      }
      localCursor.close();
    }
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_EDIT_ATTACH WHERE mailid = ?", new String[] { paramMail.getInformation().getId() + "" });
    if (paramSQLiteDatabase != null)
    {
      paramMail = fillEditAttachList(paramSQLiteDatabase);
      if (paramMail != null) {
        localMailInformation.setEditAttachList(paramMail);
      }
      paramSQLiteDatabase.close();
    }
  }
  
  private int getAttachAttr(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    int i = 0;
    int j = 0;
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT attr FROM QM_MAIL_ATTACH WHERE id=?", new String[] { String.valueOf(paramLong) });
    if (paramSQLiteDatabase != null)
    {
      i = j;
      if (paramSQLiteDatabase.moveToFirst()) {
        i = getInt(paramSQLiteDatabase, "attr");
      }
      paramSQLiteDatabase.close();
    }
    return i;
  }
  
  private static int getAttachAttr(Attach paramAttach, int paramInt)
  {
    int i = paramInt;
    if (paramAttach.getState().isFavLocal()) {
      i = paramInt | 0x40;
    }
    return i;
  }
  
  public static ArrayList<Object> getAttachNameListByMailId(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT name FROM QM_MAIL_ATTACH WHERE mailid=?", new String[] { String.valueOf(paramLong) });
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst()) {
        do
        {
          Attach localAttach = new Attach();
          localAttach.setName(paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("name")));
          localArrayList.add(localAttach);
        } while (paramSQLiteDatabase.moveToNext());
      }
      paramSQLiteDatabase.close();
    }
    return localArrayList;
  }
  
  public static ArrayList<Object> getBigAttachNameListByMailId(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT name FROM QM_FTN_ATTACH WHERE mailid=?", new String[] { String.valueOf(paramLong) });
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst()) {
        do
        {
          MailBigAttach localMailBigAttach = new MailBigAttach();
          localMailBigAttach.setName(paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("name")));
          localArrayList.add(localMailBigAttach);
        } while (paramSQLiteDatabase.moveToNext());
      }
      paramSQLiteDatabase.close();
    }
    return localArrayList;
  }
  
  public static ArrayList<Object> getEditAttachNameListByMailId(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT name FROM QM_EDIT_ATTACH WHERE mailid=?", new String[] { String.valueOf(paramLong) });
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst()) {
        do
        {
          MailEditAttach localMailEditAttach = new MailEditAttach();
          localMailEditAttach.setName(paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("name")));
          localArrayList.add(localMailEditAttach);
        } while (paramSQLiteDatabase.moveToNext());
      }
      paramSQLiteDatabase.close();
    }
    return localArrayList;
  }
  
  private Cursor getLocalSearchAttach(SQLiteDatabase paramSQLiteDatabase, SearchAttachInfo paramSearchAttachInfo)
  {
    int i = paramSearchAttachInfo.getSearchType();
    String str = paramSearchAttachInfo.getKeyword();
    paramSearchAttachInfo = "SELECT A.* FROM QM_MAIL_ATTACH AS A WHERE mailid NOT IN ( SELECT id FROM QM_MAIL_INFO WHERE folderId IN ( SELECT id FROM QM_FOLDER WHERE type IN ( 5,6,102,4))) AND isfavorite=1 ";
    Object localObject;
    if (i == 1)
    {
      paramSearchAttachInfo = "SELECT A.* FROM QM_MAIL_ATTACH AS A WHERE mailid NOT IN ( SELECT id FROM QM_MAIL_INFO WHERE folderId IN ( SELECT id FROM QM_FOLDER WHERE type IN ( 5,6,102,4))) AND isfavorite=1 " + " AND " + "viewmode" + "='img'";
      localObject = paramSearchAttachInfo;
      if (!StringExtention.isNullOrEmpty(str)) {
        localObject = paramSearchAttachInfo + " AND name LIKE $keyword$";
      }
      if (str == null) {
        break label258;
      }
    }
    label258:
    for (paramSearchAttachInfo = DatabaseUtils.sqlEscapeString("%" + str + "%");; paramSearchAttachInfo = "''")
    {
      paramSearchAttachInfo = ((String)localObject).replace("$keyword$", paramSearchAttachInfo);
      return paramSQLiteDatabase.rawQuery(paramSearchAttachInfo + " ORDER BY favtime DESC ", null);
      if (i == 2)
      {
        paramSearchAttachInfo = "SELECT A.* FROM QM_MAIL_ATTACH AS A WHERE mailid NOT IN ( SELECT id FROM QM_MAIL_INFO WHERE folderId IN ( SELECT id FROM QM_FOLDER WHERE type IN ( 5,6,102,4))) AND isfavorite=1 " + "AND (" + "viewmode" + "='music' OR " + "viewmode" + "='video')";
        break;
      }
      if (i != 4) {
        break;
      }
      paramSearchAttachInfo = "SELECT A.* FROM QM_MAIL_ATTACH AS A WHERE mailid NOT IN ( SELECT id FROM QM_MAIL_INFO WHERE folderId IN ( SELECT id FROM QM_FOLDER WHERE type IN ( 5,6,102,4))) AND isfavorite=1 " + " AND " + "viewmode" + "='doc'";
      break;
    }
  }
  
  private ArrayList<Object> removeAttachInListById(ArrayList<Object> paramArrayList, Attach paramAttach, boolean paramBoolean)
  {
    if ((paramArrayList == null) || (paramAttach == null)) {}
    for (;;)
    {
      return paramArrayList;
      int i = 0;
      while (i < paramArrayList.size())
      {
        Object localObject = paramArrayList.get(i);
        if ((localObject instanceof Attach))
        {
          localObject = (Attach)localObject;
          if (Attach.generateHashId(paramAttach, paramBoolean) == ((Attach)localObject).getHashId())
          {
            paramAttach.getPreview().setMyDisk(((Attach)localObject).getPreview().getMyDisk());
            paramArrayList.remove(i);
            return paramArrayList;
          }
        }
        i += 1;
      }
    }
  }
  
  private static void setAttachAttr(Attach paramAttach, int paramInt)
  {
    paramAttach = paramAttach.getState();
    if ((paramInt & 0x40) != 0) {
      paramAttach.setIsFavLocal(true);
    }
  }
  
  private void updateAttachExtraMailInfo(SQLiteDatabase paramSQLiteDatabase)
  {
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT subject, id, fromAddr, fromAddrName, utcSent, folderId FROM QM_MAIL_INFO WHERE id IN ( SELECT mailid FROM QM_MAIL_ATTACH )", null);
    if (localCursor != null)
    {
      while (localCursor.moveToNext())
      {
        String str1 = getString(localCursor, "subject");
        String str2 = getString(localCursor, "fromAddr");
        String str3 = getString(localCursor, "fromAddrName");
        long l1 = getLong(localCursor, "id");
        long l2 = getLong(localCursor, "utcSent");
        int i = getInt(localCursor, "folderId");
        if ((str1 != null) && (str2 != null) && (str3 != null)) {
          paramSQLiteDatabase.execSQL("UPDATE QM_MAIL_ATTACH SET mailsubject=?, mailsenderaddr=?, mailsender=?, favtime=?, folderid=?  WHERE mailid=? ", new Object[] { str1, str2, str3, Long.valueOf(l2), Integer.valueOf(i), Long.valueOf(l1) });
        }
      }
      localCursor.close();
    }
  }
  
  private void updateBigAttachForUpgrade(SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject = new ArrayList();
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_FTN_ATTACH", null);
    if (localCursor != null)
    {
      if (localCursor.moveToFirst()) {
        do
        {
          MailBigAttach localMailBigAttach = fillBigAttach(localCursor);
          localMailBigAttach.getPreview().setMyDisk("");
          localMailBigAttach.getPreview().setCopyDiskList(new ArrayList());
          localMailBigAttach.getState().setIsDownload("0");
          long l = Attach.generateHashId(localMailBigAttach, false);
          QMLog.log(4, "QMMailSQLite", "update big attach from " + localMailBigAttach.getHashId() + " to " + l + ",name:" + localMailBigAttach.getName() + ",size:" + localMailBigAttach.getSize() + ",mailId:" + localMailBigAttach.getBelongMailId());
          localMailBigAttach.setHashId(l);
          ((ArrayList)localObject).add(localMailBigAttach);
        } while (localCursor.moveToNext());
      }
      localCursor.close();
    }
    if (((ArrayList)localObject).size() > 0)
    {
      paramSQLiteDatabase.execSQL("DELETE FROM QM_FTN_ATTACH");
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        insertBigAttach(paramSQLiteDatabase, (MailBigAttach)((Iterator)localObject).next());
      }
    }
  }
  
  private void updateNormalAttachIdForUpgrade(SQLiteDatabase paramSQLiteDatabase)
  {
    HashMap localHashMap = new HashMap();
    Cursor localCursor1 = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_MAIL_ATTACH", null);
    if (localCursor1 != null) {
      if (!localCursor1.moveToFirst()) {}
    }
    for (;;)
    {
      Object localObject2 = fillAttach(localCursor1);
      Object localObject1 = localObject2;
      if (((Attach)localObject2).isProtocol())
      {
        Cursor localCursor2 = paramSQLiteDatabase.rawQuery(String.format("SELECT * FROM %s WHERE aid = ?", new Object[] { "QM_MAIL_ATTACH_PART_INFO" }), new String[] { ((Attach)localObject2).getHashId() + "" });
        localObject1 = localObject2;
        if (localCursor2 != null)
        {
          localObject1 = localObject2;
          if (localCursor2.getCount() > 0)
          {
            localCursor2.moveToFirst();
            localObject1 = fillAttachBodyInfo(localCursor2, (Attach)localObject2);
            localCursor2.close();
          }
        }
      }
      localObject2 = new ArrayList();
      if (((Attach)localObject1).getProtocol().getProtocolType() == 0) {
        ((ArrayList)localObject2).add(((Attach)localObject1).getPreview().getMyDisk());
      }
      ((Attach)localObject1).getPreview().setMyDisk("");
      ((Attach)localObject1).getPreview().setCopyDiskList((ArrayList)localObject2);
      ((Attach)localObject1).getState().setIsDownload("0");
      long l = Attach.generateHashId((Attach)localObject1, false);
      QMLog.log(4, "QMMailSQLite", "update normal attach from " + ((Attach)localObject1).getHashId() + " to " + l + ",name:" + ((Attach)localObject1).getName() + ",size:" + ((Attach)localObject1).getSize() + ",mailId:" + ((Attach)localObject1).getBelongMailId());
      ((Attach)localObject1).setHashId(l);
      if (localHashMap.get(Long.valueOf(l)) != null)
      {
        QMLog.log(4, "QMMailSQLite", "same attach:" + l + ",name:" + ((Attach)localObject1).getName() + ",fav:" + ((Attach)localObject1).isFav());
        if (((Attach)localObject1).isFav()) {
          ((Attach)localHashMap.get(Long.valueOf(l))).setIsFav(true);
        }
      }
      while (!localCursor1.moveToNext())
      {
        localCursor1.close();
        if ((localHashMap == null) || (localHashMap.size() <= 0)) {
          return;
        }
        paramSQLiteDatabase.execSQL("DELETE FROM QM_MAIL_ATTACH");
        localObject1 = localHashMap.keySet().iterator();
        while (((Iterator)localObject1).hasNext()) {
          insertAttach(paramSQLiteDatabase, (Attach)localHashMap.get((Long)((Iterator)localObject1).next()), false);
        }
        ((Attach)localObject1).setIsFav(true);
        localHashMap.remove(Long.valueOf(l));
        localHashMap.put(Long.valueOf(l), localObject1);
        continue;
        localHashMap.put(Long.valueOf(l), localObject1);
      }
    }
  }
  
  public void createIndex(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS QM_MAIL_ATTACH_INDEX ON QM_MAIL_ATTACH(mailid)");
    paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS QM_MAIL_ATTACH_ORDER_IDX_INDEX ON QM_MAIL_ATTACH(mailid,orderidx)");
    paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS INDEX_FTN_ATTACH ON QM_FTN_ATTACH(mailid,orderidx)");
  }
  
  public void createTable(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_MAIL_ATTACH(id integer primary key, alias varchar, name varchar, size varchar, suffix varchar, mailid integer, keyname varchar, downloadsize integer default 0, accountid integer, downloadurl varchar, isembed integer, isaudio integer, isdownload integer, ispic integer, enableattfolder integer, mydisk varchar, viewtype varchar, iviewtype integer, previewtype integer, isprotocol integer, isexist integer, displayname varchar, fileSizeByte integer, downloadSizeByte integer, mid integer, aid integer, type varchar, data blob, cid varchar, exchangeFileUid varchar, fileContentType varchar, protocolType integer, copydisklist varchar, icon varchar, refmailid integer, orderidx integer, folderkey integer, rank integer, attr integer, favtime integer, viewmode varchar, mailsender varchar, mailsubject varchar, previewurl varchar, mailsenderaddr varchar, remoteid varchar, urlencodename varchar, isfavorite integer, folderid integer, downloadkey varchar )");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_FTN_ATTACH(id integer primary key, name varchar, size varchar, expiretime integer, type varchar, previewtype integer, accountid integer, mailid varchar, isdownload integer, keyname varchar, downloadsize integer default 0, downloadurl varchar, protocoltype integer, mydisk varchar, displayname varchar, copydisklist varchar, refmailid integer, orderidx integer)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_MAIL_ATTACH_PART_INFO(id integer primary key, aid integer, rmtaid integer, rmtmid integer, rmtid integer, bodyid integer, rmtitemid varchar, itemtype varchar, contentType varchar, contentSubType varchar, contentTypeParams varchar, contentDescription varchar, contentTransferEncoding varchar, contentLineSize varchar, contentDisposition varchar)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_EDIT_ATTACH(id integer primary key, name varchar, type varchar, icon varchar, url varchar, key varchar, size varchar, accountid integer, mailid integer)");
    QMLog.log(4, "QMMailSQLite", "create table");
  }
  
  public void deleteAccountAttach(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong)
  {
    String str = getInClause(paramArrayOfLong.length);
    String[] arrayOfString = new String[paramArrayOfLong.length];
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      arrayOfString[i] = String.valueOf(paramArrayOfLong[i]);
      i += 1;
    }
    paramArrayOfLong = paramSQLiteDatabase.rawQuery("SELECT id FROM QM_MAIL_ATTACH WHERE accountid IN " + str, arrayOfString);
    if (paramArrayOfLong != null)
    {
      ArrayList localArrayList = new ArrayList();
      i = 0;
      while (paramArrayOfLong.moveToNext())
      {
        localArrayList.add(String.valueOf(getLong(paramArrayOfLong, "id")));
        int j = i + 1;
        i = j;
        if (j > 500)
        {
          deleteAttachPartInfo(paramSQLiteDatabase, localArrayList);
          localArrayList.clear();
          i = 0;
        }
      }
      deleteAttachPartInfo(paramSQLiteDatabase, localArrayList);
      paramArrayOfLong.close();
    }
    paramSQLiteDatabase.delete("QM_MAIL_ATTACH", "accountid IN " + str, arrayOfString);
    paramSQLiteDatabase.delete("QM_FTN_ATTACH", "accountid IN " + str, arrayOfString);
    paramSQLiteDatabase.delete("QM_EDIT_ATTACH", "accountid IN " + str, arrayOfString);
  }
  
  public void deletePathByMyDisk(SQLiteDatabase paramSQLiteDatabase, ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      paramSQLiteDatabase.execSQL("UPDATE QM_MAIL_ATTACH SET mydisk = '' WHERE mydisk = ?", new String[] { str });
      if (paramBoolean) {
        paramSQLiteDatabase.execSQL("UPDATE QM_FTN_ATTACH SET mydisk = '' WHERE mydisk = ?", new String[] { str });
      }
    }
  }
  
  public void dropIndex(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS QM_MAIL_ATTACH_INDEX");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS QM_MAIL_ATTACH_ORDER_IDX_INDEX");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS INDEX_FTN_ATTACH");
  }
  
  public void dropTable(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_MAIL_ATTACH");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_FTN_ATTACH");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_MAIL_ATTACH_PART_INFO");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_EDIT_ATTACH");
    QMLog.log(4, "QMMailSQLite", "drop table");
  }
  
  public Attach getAttach(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_MAIL_ATTACH WHERE id = ?", new String[] { String.valueOf(paramLong) });
    if (localCursor != null)
    {
      localObject1 = localObject2;
      if (localCursor.moveToFirst()) {
        localObject1 = fillAttachProtocol(paramSQLiteDatabase, fillAttach(localCursor));
      }
      localCursor.close();
    }
    return localObject1;
  }
  
  public String getAttachCopyDisk(SQLiteDatabase paramSQLiteDatabase, long paramLong, int paramInt)
  {
    Object localObject;
    if (paramInt == 0)
    {
      localObject = "SELECT copydisklist FROM QM_MAIL_ATTACH WHERE id = ? ";
      localObject = paramSQLiteDatabase.rawQuery((String)localObject, new String[] { String.valueOf(paramLong) });
      if (localObject == null) {
        break label92;
      }
      if (!((Cursor)localObject).moveToFirst()) {
        break label85;
      }
      if (paramInt != 0) {
        break label73;
      }
      paramSQLiteDatabase = getString((Cursor)localObject, "copydisklist");
    }
    for (;;)
    {
      ((Cursor)localObject).close();
      return paramSQLiteDatabase;
      localObject = "SELECT copydisklist FROM QM_FTN_ATTACH WHERE id = ? ";
      break;
      label73:
      paramSQLiteDatabase = getString((Cursor)localObject, "copydisklist");
      continue;
      label85:
      paramSQLiteDatabase = "";
    }
    label92:
    return "";
  }
  
  public String getAttachDownloadUrl(SQLiteDatabase paramSQLiteDatabase, long paramLong, boolean paramBoolean)
  {
    Object localObject;
    if (!paramBoolean)
    {
      localObject = "SELECT downloadurl FROM QM_MAIL_ATTACH WHERE id = ? ORDER BY orderidx";
      localObject = paramSQLiteDatabase.rawQuery((String)localObject, new String[] { paramLong + "" });
      if (localObject == null) {
        break label108;
      }
      if (!((Cursor)localObject).moveToFirst()) {
        break label101;
      }
      if (paramBoolean) {
        break label89;
      }
      paramSQLiteDatabase = getString((Cursor)localObject, "downloadurl");
    }
    for (;;)
    {
      ((Cursor)localObject).close();
      return paramSQLiteDatabase;
      localObject = "SELECT downloadurl FROM QM_FTN_ATTACH WHERE id = ? ORDER BY orderidx";
      break;
      label89:
      paramSQLiteDatabase = getString((Cursor)localObject, "downloadurl");
      continue;
      label101:
      paramSQLiteDatabase = "";
    }
    label108:
    return "";
  }
  
  public Cursor getAttachFolderListCursor(SQLiteDatabase paramSQLiteDatabase)
  {
    return paramSQLiteDatabase.rawQuery("SELECT A.* FROM QM_MAIL_ATTACH AS A WHERE mailid NOT IN ( SELECT id FROM QM_MAIL_INFO WHERE folderId IN ( SELECT id FROM QM_FOLDER WHERE type IN ( 5,6,102,4))) AND isfavorite=1 ORDER BY favtime DESC ", null);
  }
  
  public List<Attach> getAttachFolderListCursorByIds(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong)
  {
    paramArrayOfLong = paramSQLiteDatabase.rawQuery("SELECT A.* FROM QM_MAIL_ATTACH AS A WHERE mailid NOT IN ( SELECT id FROM QM_MAIL_INFO WHERE folderId IN ( SELECT id FROM QM_FOLDER WHERE type IN ( 5,6,102,4))) AND isfavorite=1 AND id IN " + getInClause(paramArrayOfLong) + " ORDER BY " + "favtime" + " DESC ", null);
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfLong != null)
    {
      while (paramArrayOfLong.moveToNext()) {
        localArrayList.add(fillAttach(paramSQLiteDatabase, paramArrayOfLong));
      }
      paramArrayOfLong.close();
    }
    return localArrayList;
  }
  
  public int[] getAttachFolderListKeys(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    int i = 0;
    Object localObject = null;
    int[] arrayOfInt = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT folderkey FROM QM_MAIL_ATTACH WHERE accountid=? AND ~(attr &?) AND isfavorite=1 ", new String[] { String.valueOf(paramInt), String.valueOf(64) });
    paramSQLiteDatabase = localObject;
    if (localCursor != null)
    {
      paramSQLiteDatabase = arrayOfInt;
      if (localCursor.moveToFirst())
      {
        int j = localCursor.getCount();
        arrayOfInt = new int[j];
        paramInt = i;
        for (;;)
        {
          paramSQLiteDatabase = arrayOfInt;
          if (paramInt >= j) {
            break;
          }
          localCursor.moveToPosition(paramInt);
          arrayOfInt[paramInt] = getInt(localCursor, "folderkey");
          paramInt += 1;
        }
      }
      localCursor.close();
    }
    return paramSQLiteDatabase;
  }
  
  public ArrayList<Object> getAttachList(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_MAIL_ATTACH WHERE mailid = ? ORDER BY orderidx", new String[] { paramLong + "" });
    ArrayList localArrayList = null;
    if (localCursor != null)
    {
      localArrayList = fillAttachList(paramSQLiteDatabase, localCursor);
      localCursor.close();
    }
    return localArrayList;
  }
  
  public ArrayList<Object> getAttachListByMailIds(SQLiteDatabase paramSQLiteDatabase, ArrayList<Long> paramArrayList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if (!paramBoolean)
    {
      localObject = "SELECT * FROM QM_MAIL_ATTACH WHERE mailid IN ";
      localObject = paramSQLiteDatabase.rawQuery((String)localObject + getLongInClause(paramArrayList), null);
      if (localObject == null) {
        break label109;
      }
      label52:
      if (!((Cursor)localObject).moveToNext()) {
        break label102;
      }
      if (paramBoolean) {
        break label93;
      }
    }
    label93:
    for (paramArrayList = fillAttachProtocol(paramSQLiteDatabase, fillAttach((Cursor)localObject));; paramArrayList = fillBigAttach((Cursor)localObject))
    {
      localArrayList.add(paramArrayList);
      break label52;
      localObject = "SELECT * FROM QM_FTN_ATTACH WHERE mailid IN  ";
      break;
    }
    label102:
    ((Cursor)localObject).close();
    label109:
    return localArrayList;
  }
  
  public ArrayList<Object> getAttachListByRemoteId(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_MAIL_ATTACH WHERE remoteid = ?", new String[] { paramString });
    paramString = null;
    if (localCursor != null)
    {
      paramString = fillAttachList(paramSQLiteDatabase, localCursor);
      localCursor.close();
    }
    return paramString;
  }
  
  public String[] getAttachMatchedMailId(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    long l1 = 0L;
    String str = "";
    paramString = paramSQLiteDatabase.rawQuery("SELECT mailid,subject,QM_MAIL_INFO.accountId FROM QM_MAIL_ATTACH , QM_MAIL_INFO WHERE QM_MAIL_ATTACH.name = ? AND QM_MAIL_ATTACH.mailid = QM_MAIL_INFO.id ORDER BY QM_MAIL_INFO.utcReceived DESC LIMIT 1", new String[] { paramString });
    long l2;
    if (paramString != null) {
      if (paramString.moveToFirst())
      {
        l2 = paramString.getLong(0);
        paramSQLiteDatabase = paramString.getString(1);
        l1 = paramString.getLong(2);
        paramString.close();
      }
    }
    for (;;)
    {
      return new String[] { String.valueOf(l2), paramSQLiteDatabase, String.valueOf(l1) };
      l2 = 0L;
      paramSQLiteDatabase = str;
      break;
      l2 = 0L;
      paramSQLiteDatabase = str;
    }
  }
  
  public String getAttachMyDisk(SQLiteDatabase paramSQLiteDatabase, long paramLong, int paramInt)
  {
    Object localObject;
    if (paramInt == 0)
    {
      localObject = "SELECT mydisk FROM QM_MAIL_ATTACH WHERE id = ? ";
      localObject = paramSQLiteDatabase.rawQuery((String)localObject, new String[] { String.valueOf(paramLong) });
      if (localObject == null) {
        break label92;
      }
      if (!((Cursor)localObject).moveToFirst()) {
        break label85;
      }
      if (paramInt != 0) {
        break label73;
      }
      paramSQLiteDatabase = getString((Cursor)localObject, "mydisk");
    }
    for (;;)
    {
      ((Cursor)localObject).close();
      return paramSQLiteDatabase;
      localObject = "SELECT mydisk FROM QM_FTN_ATTACH WHERE id = ? ";
      break;
      label73:
      paramSQLiteDatabase = getString((Cursor)localObject, "mydisk");
      continue;
      label85:
      paramSQLiteDatabase = "";
    }
    label92:
    return "";
  }
  
  public long getAttachRefMailId(SQLiteDatabase paramSQLiteDatabase, long paramLong, boolean paramBoolean)
  {
    String str;
    if (!paramBoolean)
    {
      str = "SELECT refmailid FROM QM_MAIL_ATTACH WHERE id = ? ";
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(str, new String[] { paramLong + "" });
      if (paramSQLiteDatabase == null) {
        break label100;
      }
      if (!paramSQLiteDatabase.moveToFirst()) {
        break label95;
      }
      if (paramBoolean) {
        break label84;
      }
      paramLong = getLong(paramSQLiteDatabase, "refmailid");
    }
    for (;;)
    {
      paramSQLiteDatabase.close();
      return paramLong;
      str = "SELECT refmailid FROM QM_FTN_ATTACH WHERE id = ? ";
      break;
      label84:
      paramLong = getLong(paramSQLiteDatabase, "refmailid");
      continue;
      label95:
      paramLong = 0L;
    }
    label100:
    return 0L;
  }
  
  public MailBigAttach getBigAttach(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_FTN_ATTACH WHERE id = ?", new String[] { String.valueOf(paramLong) });
    paramSQLiteDatabase = localObject2;
    if (localCursor != null)
    {
      paramSQLiteDatabase = localObject1;
      if (localCursor.moveToFirst()) {
        paramSQLiteDatabase = fillBigAttach(localCursor);
      }
      localCursor.close();
    }
    return paramSQLiteDatabase;
  }
  
  public ArrayList<Object> getBigAttachList(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_FTN_ATTACH WHERE mailid = ? ORDER BY orderidx", new String[] { paramLong + "" });
    paramSQLiteDatabase = null;
    if (localCursor != null)
    {
      paramSQLiteDatabase = fillBigAttachList(localCursor);
      localCursor.close();
    }
    return paramSQLiteDatabase;
  }
  
  public MailEditAttach getEditAttach(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_EDIT_ATTACH WHERE id = ?", new String[] { String.valueOf(paramLong) });
    paramSQLiteDatabase = localObject2;
    if (localCursor != null)
    {
      paramSQLiteDatabase = localObject1;
      if (localCursor.moveToFirst()) {
        paramSQLiteDatabase = fillEditAttach(localCursor);
      }
      localCursor.close();
    }
    return paramSQLiteDatabase;
  }
  
  public ArrayList<Object> getEditAttachList(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_EDIT_ATTACH WHERE mailid = ?", new String[] { paramLong + "" });
    paramSQLiteDatabase = null;
    if (localCursor != null)
    {
      paramSQLiteDatabase = fillEditAttachList(localCursor);
      localCursor.close();
    }
    return paramSQLiteDatabase;
  }
  
  public Attach getInlineImage(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_MAIL_ATTACH WHERE cid = ?", new String[] { paramString });
    paramString = localObject2;
    if (localCursor != null)
    {
      paramString = localObject1;
      if (localCursor.moveToFirst()) {
        paramString = fillAttachProtocol(paramSQLiteDatabase, fillAttach(localCursor));
      }
      localCursor.close();
    }
    return paramString;
  }
  
  public String getInlineImageMyDisk(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    Object localObject = "";
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_MAIL_ATTACH WHERE cid = ?", new String[] { paramString });
    paramSQLiteDatabase = (SQLiteDatabase)localObject;
    if (localCursor != null)
    {
      paramSQLiteDatabase = (SQLiteDatabase)localObject;
      if (localCursor.moveToFirst())
      {
        paramString = getString(localCursor, "mydisk");
        paramSQLiteDatabase = paramString;
        if (StringExtention.isNullOrEmpty(paramString))
        {
          localObject = AttachPreview.parseCopyDiskList(getString(localCursor, "copydisklist"));
          paramSQLiteDatabase = paramString;
          if (localObject != null)
          {
            paramSQLiteDatabase = paramString;
            if (localObject.length > 0) {
              paramSQLiteDatabase = localObject[0];
            }
          }
        }
      }
      localCursor.close();
    }
    return paramSQLiteDatabase;
  }
  
  public ArrayList<Integer> getLocalAttachIds(SQLiteDatabase paramSQLiteDatabase)
  {
    ArrayList localArrayList = new ArrayList();
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT id FROM QM_MAIL_ATTACH", null);
    if (paramSQLiteDatabase != null)
    {
      while (paramSQLiteDatabase.moveToNext())
      {
        int i = getInt(paramSQLiteDatabase, "id");
        if (i != 0) {
          localArrayList.add(Integer.valueOf(i));
        }
      }
      paramSQLiteDatabase.close();
    }
    return localArrayList;
  }
  
  public Cursor getSearchAttachFolderListCursor(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong, boolean paramBoolean)
  {
    return paramSQLiteDatabase.rawQuery("SELECT * FROM QM_MAIL_ATTACH WHERE id IN " + getInClause(paramArrayOfLong) + " ORDER BY " + "favtime" + " DESC ", null);
  }
  
  public long[] getSearchAttachIds(SQLiteDatabase paramSQLiteDatabase, SearchAttachInfo paramSearchAttachInfo)
  {
    Object localObject = null;
    paramSearchAttachInfo = getLocalSearchAttach(paramSQLiteDatabase, paramSearchAttachInfo);
    paramSQLiteDatabase = localObject;
    if (paramSearchAttachInfo != null)
    {
      paramSQLiteDatabase = new long[paramSearchAttachInfo.getCount()];
      int i = 0;
      while (i < paramSQLiteDatabase.length)
      {
        paramSearchAttachInfo.moveToPosition(i);
        paramSQLiteDatabase[i] = paramSearchAttachInfo.getLong(paramSearchAttachInfo.getColumnIndex("id"));
        i += 1;
      }
      paramSearchAttachInfo.close();
    }
    return paramSQLiteDatabase;
  }
  
  public void groupFolderAttachInAccount(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong, GroupAttachFolderWatcher paramGroupAttachFolderWatcher)
  {
    boolean bool = false;
    SparseArray localSparseArray = new SparseArray();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT accountid, name, remoteid, downloadurl, id, downloadkey FROM QM_MAIL_ATTACH WHERE id IN $inClause$ ORDER BY accountid".replace("$inClause$", getInClause(paramArrayOfLong)), null);
    int i;
    String str2;
    long l;
    GroupAttachFolderWatcher.SyncRemoteParams localSyncRemoteParams;
    if (localCursor != null) {
      if (localCursor.moveToNext())
      {
        i = getInt(localCursor, "accountid");
        paramArrayOfLong = getString(localCursor, "name");
        String str1 = getString(localCursor, "remoteid");
        str2 = getString(localCursor, "downloadurl");
        paramSQLiteDatabase = getString(localCursor, "downloadkey");
        l = getLong(localCursor, "id");
        if (paramGroupAttachFolderWatcher.isQQMail(i))
        {
          localArrayList2.add(Long.valueOf(l));
          localSyncRemoteParams = new GroupAttachFolderWatcher.SyncRemoteParams();
          localSyncRemoteParams.attachId = l;
          localSyncRemoteParams.name = paramArrayOfLong;
          localSyncRemoteParams.remoteId = str1;
          if (StringExtention.isNullOrEmpty(str2)) {
            break label412;
          }
          bool = str2.contains("cgi-bin/groupattachment");
        }
      }
    }
    label409:
    label412:
    for (;;)
    {
      if (bool)
      {
        if (!StringExtention.isNullOrEmpty(paramSQLiteDatabase)) {
          break label409;
        }
        paramSQLiteDatabase = AttachToolbox.getGroupMailAttFromUrl(str2);
      }
      for (;;)
      {
        localSyncRemoteParams.groupDownKey = paramSQLiteDatabase;
        paramArrayOfLong = (HashSet)localSparseArray.get(i);
        paramSQLiteDatabase = paramArrayOfLong;
        if (paramArrayOfLong == null)
        {
          paramSQLiteDatabase = new HashSet();
          localSparseArray.put(i, paramSQLiteDatabase);
        }
        paramSQLiteDatabase.add(localSyncRemoteParams);
        break;
        localArrayList1.add(Long.valueOf(l));
        break;
        localCursor.close();
        paramSQLiteDatabase = new long[localArrayList1.size()];
        i = 0;
        while (i < paramSQLiteDatabase.length)
        {
          paramSQLiteDatabase[i] = ((Long)localArrayList1.get(i)).longValue();
          i += 1;
        }
        paramGroupAttachFolderWatcher.onSyncLocal(0, paramSQLiteDatabase);
        i = 0;
        while (i < localSparseArray.size())
        {
          int j = localSparseArray.keyAt(i);
          paramSQLiteDatabase = (HashSet)localSparseArray.get(j);
          paramArrayOfLong = new GroupAttachFolderWatcher.SyncRemoteParams[paramSQLiteDatabase.size()];
          paramSQLiteDatabase.toArray(paramArrayOfLong);
          if (paramArrayOfLong.length > 0) {
            paramGroupAttachFolderWatcher.onSyncRemote(j, paramArrayOfLong);
          }
          i += 1;
        }
        paramGroupAttachFolderWatcher.onSyncLocalComplete();
        return;
      }
    }
  }
  
  public boolean hasAttachFavorite(SQLiteDatabase paramSQLiteDatabase)
  {
    boolean bool = false;
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT COUNT(id) FROM QM_MAIL_ATTACH WHERE isfavorite=1 ", null);
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
      if (i > 0) {
        bool = true;
      }
      return bool;
      i = 0;
      break;
      i = 0;
    }
  }
  
  public boolean insertAttach(SQLiteDatabase paramSQLiteDatabase, Attach paramAttach, boolean paramBoolean)
  {
    int i4 = Attach.generateHashId(paramAttach, paramBoolean);
    paramAttach.setHashId(i4);
    int i;
    int j;
    label40:
    int k;
    label53:
    int m;
    label63:
    int n;
    if (paramAttach.getPreview().isEmbed())
    {
      i = 1;
      if (!paramAttach.getPreview().isAudio()) {
        break label1013;
      }
      j = 1;
      if (!paramAttach.getPreview().isPic()) {
        break label1019;
      }
      k = 1;
      if (!paramAttach.isProtocol()) {
        break label1025;
      }
      m = 1;
      if (!paramAttach.isFav()) {
        break label1031;
      }
      n = 1;
      label73:
      if (!paramAttach.getPreview().isEnableAttFolder()) {
        break label1037;
      }
    }
    label1025:
    label1031:
    label1037:
    for (int i1 = 1;; i1 = 0)
    {
      String str2 = AttachPreview.formatCopyDiskList(paramAttach.getPreview().getCopyDiskList());
      int i3 = 0;
      int i2 = i3;
      if (paramAttach.getState().getIsDownload() != null)
      {
        i2 = i3;
        if (paramAttach.getState().getIsDownload().equals("1")) {
          i2 = 1;
        }
      }
      i3 = 0;
      Object localObject1 = paramAttach.getPreview().getIviewtype();
      if (localObject1 != null) {
        i3 = Integer.parseInt((String)localObject1);
      }
      Object localObject2 = paramAttach.getSize();
      localObject1 = localObject2;
      if (!StringExtention.isNullOrEmpty((String)localObject2))
      {
        localObject1 = localObject2;
        if (((String)localObject2).contains("字节")) {
          localObject1 = ((String)localObject2).replace("字节", "B");
        }
      }
      String str1 = paramAttach.getViewMode();
      localObject2 = str1;
      if (StringExtention.isNullOrEmpty(str1)) {
        localObject2 = AttachToolbox.getViewModeByName(paramAttach.getName());
      }
      paramSQLiteDatabase.execSQL("REPLACE INTO QM_MAIL_ATTACH (id,alias,name,size,suffix,mailid,keyname,downloadsize,accountid,downloadurl,isembed,isaudio,isdownload,ispic,enableattfolder,mydisk,viewtype,iviewtype,previewtype,isprotocol,isexist,displayname,fileSizeByte,downloadSizeByte,mid,aid,type,data,cid,exchangeFileUid,fileContentType,protocolType,copydisklist,icon,refmailid,orderidx,folderkey,rank,attr,favtime,viewmode,mailsender,mailsubject,previewurl,mailsenderaddr,remoteid,urlencodename,isfavorite,folderid,downloadkey) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new Object[] { Long.valueOf(paramAttach.getHashId()), paramAttach.getAlias(), paramAttach.getName(), localObject1, paramAttach.getSuffix(), Long.valueOf(paramAttach.getBelongMailId()), paramAttach.getState().getKeyName(), Integer.valueOf(Integer.parseInt(paramAttach.getState().getDownloadSize())), Integer.valueOf(paramAttach.getAccountId()), paramAttach.getPreview().getDownloadUrl(), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(i2), Integer.valueOf(k), Integer.valueOf(i1), paramAttach.getPreview().getMyDisk(), paramAttach.getPreview().getViewType(), Integer.valueOf(i3), Integer.valueOf(0), Integer.valueOf(m), Integer.valueOf(paramAttach.getProtocol().getIsexist()), paramAttach.getDisplayName(), Long.valueOf(paramAttach.getBytes()), Long.valueOf(paramAttach.getState().getDownloadSizeByte()), Long.valueOf(paramAttach.getProtocol().getMailId()), Long.valueOf(paramAttach.getProtocol().getAttachId()), paramAttach.getProtocol().getType(), paramAttach.getProtocol().getData(), paramAttach.getProtocol().getCid(), paramAttach.getProtocol().getExchangeFileUid(), paramAttach.getProtocol().getFileContentType(), Integer.valueOf(paramAttach.getProtocol().getProtocolType()), str2, paramAttach.getPreview().getIcon(), Long.valueOf(paramAttach.getRefMailId()), Integer.valueOf(paramAttach.getOrderIndex()), Integer.valueOf(paramAttach.getFolderKey()), Integer.valueOf(paramAttach.getRank()), Integer.valueOf(paramAttach.getState().getAttr()), Long.valueOf(paramAttach.getFavTime()), localObject2, paramAttach.getMailSender(), paramAttach.getMailSubject(), paramAttach.getPreviewUrl(), paramAttach.getMailSenderAddr(), paramAttach.getRemoteId(), paramAttach.getUrlEncodeName(), Integer.valueOf(n), Integer.valueOf(paramAttach.getFolderId()), paramAttach.getDownloadKey() });
      if ((!paramBoolean) && (paramAttach.isProtocol()) && (paramAttach.getProtocol().getBodyInfo() != null) && (paramAttach.getProtocol().getProtocolType() == 1)) {
        paramSQLiteDatabase.execSQL("REPLACE INTO QM_MAIL_ATTACH_PART_INFO (id,aid,rmtaid,rmtmid,rmtid,bodyid,rmtitemid,itemtype,contentType,contentSubType,contentTypeParams,contentDescription,contentTransferEncoding,contentLineSize,contentDisposition) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new Object[] { Integer.valueOf(ItemBodyStructureHelper.MailItemBodyStructureInfo.generateHashId(paramAttach.getBelongMailId(), paramAttach.getProtocol().getBodyInfo().bodyId)), Integer.valueOf(i4), Long.valueOf(paramAttach.getProtocol().getAttachId()), Long.valueOf(paramAttach.getProtocol().getMailId()), Long.valueOf(paramAttach.getProtocol().getBodyInfo().id), paramAttach.getProtocol().getBodyInfo().bodyId, Long.valueOf(paramAttach.getProtocol().getBodyInfo().itemId), paramAttach.getProtocol().getBodyInfo().itemType, paramAttach.getProtocol().getBodyInfo().contentType, paramAttach.getProtocol().getBodyInfo().contentSubType, paramAttach.getProtocol().getBodyInfo().contentTypeParams, paramAttach.getProtocol().getBodyInfo().contentDescription, paramAttach.getProtocol().getBodyInfo().transferEncoding, paramAttach.getProtocol().getBodyInfo().contentLineSize, paramAttach.getProtocol().getBodyInfo().contentDisposition });
      }
      return true;
      i = 0;
      break;
      label1013:
      j = 0;
      break label40;
      label1019:
      k = 0;
      break label53;
      m = 0;
      break label63;
      n = 0;
      break label73;
    }
  }
  
  public void insertAttachFolder(SQLiteDatabase paramSQLiteDatabase, ArrayList<Attach> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      insertAttach(paramSQLiteDatabase, (Attach)paramArrayList.next(), false);
    }
  }
  
  public boolean insertBigAttach(SQLiteDatabase paramSQLiteDatabase, MailBigAttach paramMailBigAttach)
  {
    paramMailBigAttach.setHashId(Attach.generateHashId(paramMailBigAttach.getBelongMailId(), paramMailBigAttach.getSize(), paramMailBigAttach.getName()));
    long l3 = paramMailBigAttach.getRefMailId();
    int k = paramMailBigAttach.getOrderIndex();
    int j = 0;
    int i = j;
    if (paramMailBigAttach.getState().getIsDownload() != null)
    {
      i = j;
      if (paramMailBigAttach.getState().getIsDownload().equals("2")) {
        i = 1;
      }
    }
    String str1 = paramMailBigAttach.getPreview().getMyDisk();
    String str2 = paramMailBigAttach.getDisplayName();
    String str3 = AttachPreview.formatCopyDiskList(paramMailBigAttach.getPreview().getCopyDiskList());
    long l2 = -2L;
    long l1;
    if (paramMailBigAttach.isBizNetDiskAttach()) {
      l1 = -1L;
    }
    for (;;)
    {
      String str4 = paramMailBigAttach.getFid() + "&" + paramMailBigAttach.getSha();
      paramMailBigAttach.getState().setKeyName(str4);
      paramSQLiteDatabase.execSQL("REPLACE INTO QM_FTN_ATTACH (id,name,size,expiretime,type,previewtype,accountid,mailid,isdownload,keyname,downloadsize,downloadurl,protocoltype,mydisk,displayname,copydisklist,refmailid,orderidx) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new Object[] { Long.valueOf(paramMailBigAttach.getHashId()), paramMailBigAttach.getName(), paramMailBigAttach.getSize(), Long.valueOf(l1), "qqmail", Integer.valueOf(0), Integer.valueOf(paramMailBigAttach.getAccountId()), Long.valueOf(paramMailBigAttach.getBelongMailId()), Integer.valueOf(i), paramMailBigAttach.getState().getKeyName(), Integer.valueOf(Integer.parseInt(paramMailBigAttach.getState().getDownloadSize())), paramMailBigAttach.getPreview().getDownloadUrl(), Integer.valueOf(0), str1, str2, str3, Long.valueOf(l3), Integer.valueOf(k) });
      return true;
      l1 = l2;
      if (paramMailBigAttach.getExpire() != null)
      {
        l1 = l2;
        if (paramMailBigAttach.getExpireTimeMilli() != -2L) {
          l1 = paramMailBigAttach.getExpire().getTime();
        }
      }
    }
  }
  
  public boolean insertEditAttach(SQLiteDatabase paramSQLiteDatabase, MailEditAttach paramMailEditAttach)
  {
    paramMailEditAttach.setHashId(Attach.generateHashId(paramMailEditAttach.getBelongMailId(), paramMailEditAttach.getSize(), paramMailEditAttach.getName()));
    paramSQLiteDatabase.execSQL("REPLACE INTO QM_EDIT_ATTACH (id,name,type,icon,url,key,size,accountid,mailid) VALUES (?,?,?,?,?,?,?,?,?)", new Object[] { Long.valueOf(paramMailEditAttach.getHashId()), paramMailEditAttach.getName(), paramMailEditAttach.getType(), paramMailEditAttach.getIcon(), paramMailEditAttach.getUrl(), paramMailEditAttach.getKey(), paramMailEditAttach.getSize(), Integer.valueOf(paramMailEditAttach.getAccountId()), Long.valueOf(paramMailEditAttach.getBelongMailId()) });
    return true;
  }
  
  public boolean isAttachFavorite(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    boolean bool = false;
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT COUNT(id) FROM QM_MAIL_ATTACH WHERE isfavorite=1 AND id=? ", new String[] { String.valueOf(paramLong) });
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
      if (i > 0) {
        bool = true;
      }
      return bool;
      i = 0;
      break;
      i = 0;
    }
  }
  
  public boolean isAttachFromEml(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    boolean bool = true;
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_TMP_EML_MAIL_INFO WHERE id = ?", new String[] { String.valueOf(paramLong) });
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
  
  public void resetAttachFavorite(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    paramSQLiteDatabase.execSQL("UPDATE QM_MAIL_ATTACH SET isfavorite=0  WHERE folderkey=0 AND accountid=? ", new String[] { String.valueOf(paramInt) });
  }
  
  public void resetAttachFavorite(SQLiteDatabase paramSQLiteDatabase, ArrayList<Integer> paramArrayList)
  {
    paramSQLiteDatabase.execSQL("UPDATE QM_MAIL_ATTACH SET isfavorite=0 WHERE folderkey IN " + getInClause(paramArrayList));
  }
  
  public void updateAttachCidByID(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    paramSQLiteDatabase.execSQL("UPDATE QM_MAIL_ATTACH SET cid=? WHERE id=? ", new Object[] { paramString2, paramString1 });
  }
  
  public void updateAttachCidByUID(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    paramSQLiteDatabase.execSQL("UPDATE QM_MAIL_ATTACH SET cid=? WHERE exchangeFileUid=? ", new Object[] { paramString2, paramString1 });
  }
  
  public void updateAttachDiskById(SQLiteDatabase paramSQLiteDatabase, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (paramInt == 0) {}
    for (String str = "UPDATE QM_MAIL_ATTACH SET mydisk=?, copydisklist=?, displayname=?  WHERE id=? ";; str = "UPDATE QM_FTN_ATTACH SET mydisk=?, copydisklist=?, displayname=?  WHERE id=? ")
    {
      paramSQLiteDatabase.execSQL(str, new Object[] { paramString2, paramString3, paramString1, Long.valueOf(paramLong) });
      return;
    }
  }
  
  public void updateAttachFavorite(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "UPDATE QM_MAIL_ATTACH SET isfavorite=1  WHERE id IN ";; str = "UPDATE QM_MAIL_ATTACH SET isfavorite=0  WHERE id IN ")
    {
      paramSQLiteDatabase.execSQL(str + getInClause(paramArrayOfLong));
      return;
    }
  }
  
  public void updateAttachFolder(SQLiteDatabase paramSQLiteDatabase, ArrayList<Attach> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    if (paramArrayList.hasNext())
    {
      Attach localAttach = (Attach)paramArrayList.next();
      long l = localAttach.getHashId();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("id", Integer.valueOf(Attach.generateHashId(localAttach, false)));
      localContentValues.put("accountid", Integer.valueOf(localAttach.getAccountId()));
      localContentValues.put("viewmode", localAttach.getViewMode());
      localContentValues.put("previewurl", localAttach.getPreviewUrl());
      localContentValues.put("fileSizeByte", Long.valueOf(localAttach.getBytes()));
      localContentValues.put("mailsenderaddr", localAttach.getMailSenderAddr());
      localContentValues.put("mailsubject", localAttach.getMailSubject());
      localContentValues.put("folderkey", Integer.valueOf(localAttach.getFolderKey()));
      localContentValues.put("favtime", Long.valueOf(localAttach.getFavTime()));
      localContentValues.put("attr", Integer.valueOf(getAttachAttr(localAttach, getAttachAttr(paramSQLiteDatabase, l))));
      localContentValues.put("mailsender", localAttach.getMailSender());
      localContentValues.put("remoteid", localAttach.getRemoteId());
      localContentValues.put("urlencodename", localAttach.getUrlEncodeName());
      if (localAttach.isFav()) {}
      for (int i = 1;; i = 0)
      {
        localContentValues.put("isfavorite", Integer.valueOf(i));
        localContentValues.put("folderid", Integer.valueOf(localAttach.getFolderId()));
        paramSQLiteDatabase.update("QM_MAIL_ATTACH", localContentValues, "id=? ", new String[] { String.valueOf(l) });
        break;
      }
    }
  }
  
  public void updateAttachIsDownload(SQLiteDatabase paramSQLiteDatabase, long paramLong, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (String str = "UPDATE QM_MAIL_ATTACH SET displayname=? , isdownload=?  WHERE id=? ";; str = "UPDATE QM_FTN_ATTACH SET displayname=? , isdownload=?  WHERE id=? ")
    {
      paramSQLiteDatabase.execSQL(str, new Object[] { paramString1, paramString2, Long.valueOf(paramLong) });
      return;
    }
  }
  
  public void updateAttachRefMailId(SQLiteDatabase paramSQLiteDatabase, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (String str = "UPDATE QM_MAIL_ATTACH SET refmailid=? WHERE id=? ";; str = "UPDATE QM_FTN_ATTACH SET refmailid=? WHERE id=? ")
    {
      paramSQLiteDatabase.execSQL(str, new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      return;
    }
  }
  
  public void updateAttachTypeByCID(SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString, String paramString)
  {
    paramSQLiteDatabase.execSQL("UPDATE QM_MAIL_ATTACH SET type=? WHERE cid IN$inClause$".replace("$inClause$", getInClause(paramArrayOfString)), new Object[] { paramString });
  }
  
  public void updateAttachTypeByID(SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString, String paramString)
  {
    paramSQLiteDatabase.execSQL("UPDATE QM_MAIL_ATTACH SET type=? WHERE id IN$inClause$".replace("$inClause$", getInClause(paramArrayOfString)), new Object[] { paramString });
  }
  
  public void updateAttachTypeByUID(SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString, String paramString)
  {
    paramSQLiteDatabase.execSQL("UPDATE QM_MAIL_ATTACH SET type=? WHERE exchangeFileUid IN$inClause$".replace("$inClause$", getInClause(paramArrayOfString)), new Object[] { paramString });
  }
  
  public void updateBigAttachExpire(SQLiteDatabase paramSQLiteDatabase, long paramLong1, long paramLong2)
  {
    paramSQLiteDatabase.execSQL("UPDATE QM_FTN_ATTACH SET expiretime = ? WHERE id = ?", new String[] { String.valueOf(paramLong2), String.valueOf(paramLong1) });
  }
  
  public void updateMailAttaches(SQLiteDatabase paramSQLiteDatabase, int paramInt, MailInformation paramMailInformation, boolean paramBoolean)
  {
    if (paramMailInformation == null) {}
    ArrayList localArrayList2;
    do
    {
      return;
      Object localObject1 = paramMailInformation.getAttachList();
      Object localObject3 = paramMailInformation.getBigAttachList();
      Object localObject2 = paramMailInformation.getEditAttachList();
      ArrayList localArrayList1 = getAttachList(paramSQLiteDatabase, paramMailInformation.getId());
      localArrayList2 = getBigAttachList(paramSQLiteDatabase, paramMailInformation.getId());
      ArrayList localArrayList3 = getEditAttachList(paramSQLiteDatabase, paramMailInformation.getId());
      HashMap localHashMap = new HashMap();
      int i;
      Object localObject4;
      if ((localArrayList1 != null) && (localArrayList1.size() > 0))
      {
        i = 0;
        while (i < localArrayList1.size())
        {
          localObject4 = localArrayList1.get(i);
          if ((localObject4 instanceof Attach))
          {
            localObject4 = (Attach)localObject4;
            long l = ((Attach)localObject4).getHashId();
            localHashMap.put(l + "", localObject4);
          }
          i += 1;
        }
      }
      if (localObject1 != null)
      {
        localObject4 = ((ArrayList)localObject1).iterator();
        do
        {
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          localObject1 = ((Iterator)localObject4).next();
        } while (!(localObject1 instanceof Attach));
        Attach localAttach = (Attach)localObject1;
        localAttach.setBelongMailId(paramMailInformation.getId());
        i = QMFolderManager.sharedInstance().getDraftFolderId(paramInt);
        localObject1 = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
        if ((localObject1 != null) && (!((Account)localObject1).isQQMail()) && (i == paramMailInformation.getFolderId())) {}
        for (;;)
        {
          String str = String.valueOf(Attach.generateHashId(localAttach, paramBoolean));
          localObject1 = null;
          if (localHashMap.containsKey(str)) {
            localObject1 = (Attach)localHashMap.get(str);
          }
          if ((localAttach != null) && (localObject1 != null))
          {
            localAttach.setFolderKey(((Attach)localObject1).getFolderKey());
            localAttach.setRank(((Attach)localObject1).getRank());
            localAttach.setFavTime(((Attach)localObject1).getFavTime());
            localAttach.setViewMode(((Attach)localObject1).getViewMode());
            localAttach.setMailSender(((Attach)localObject1).getMailSender());
            localAttach.setMailSubject(((Attach)localObject1).getMailSubject());
            localAttach.setPreviewUrl(((Attach)localObject1).getPreviewUrl());
            localAttach.getPreview().setMyDisk(((Attach)localObject1).getPreview().getMyDisk());
            localAttach.setMailSenderAddr(((Attach)localObject1).getMailSenderAddr());
            localAttach.setRemoteId(((Attach)localObject1).getRemoteId());
            localAttach.setUrlEncodeName(((Attach)localObject1).getUrlEncodeName());
            localAttach.setIsFav(((Attach)localObject1).isFav());
            localAttach.setFolderId(((Attach)localObject1).getFolderId());
            localAttach.getState().setIsFavLocal(((Attach)localObject1).getState().isFavLocal());
            localAttach.setBytes(((Attach)localObject1).getBytes());
            localArrayList1.remove(localObject1);
          }
          if (StringUtils.isEmpty(localAttach.getMailSubject())) {
            localAttach.setMailSubject(paramMailInformation.getSubject());
          }
          if (StringUtils.isEmpty(localAttach.getMailSender())) {
            localAttach.setMailSender(paramMailInformation.getFrom().getName());
          }
          if (StringUtils.isEmpty(localAttach.getMailSenderAddr())) {
            localAttach.setMailSenderAddr(paramMailInformation.getFrom().getAddress());
          }
          if (localAttach.getFavTime() <= 0L) {
            localAttach.setFavTime(paramMailInformation.getDate().getTime());
          }
          localAttach.setFolderId(paramMailInformation.getFolderId());
          insertAttach(paramSQLiteDatabase, localAttach, paramBoolean);
          break;
          localAttach.setAccountId(paramInt);
          localAttach.setRemoteId(paramMailInformation.getRemoteId());
        }
      }
      if (localArrayList1 != null) {
        localArrayList1.clear();
      }
      if (localObject3 != null)
      {
        localObject1 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = ((Iterator)localObject1).next();
          if ((localObject3 instanceof MailBigAttach))
          {
            localObject3 = (MailBigAttach)localObject3;
            ((MailBigAttach)localObject3).setAccountId(paramInt);
            ((MailBigAttach)localObject3).setBelongMailId(paramMailInformation.getId());
            if (localArrayList2 != null) {
              removeAttachInListById(localArrayList2, (Attach)localObject3, paramBoolean);
            }
            insertBigAttach(paramSQLiteDatabase, (MailBigAttach)localObject3);
          }
        }
      }
      if (localArrayList2 != null) {
        localArrayList2.clear();
      }
      if (localObject2 != null)
      {
        localObject1 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          if ((localObject2 instanceof MailEditAttach))
          {
            localObject2 = (MailEditAttach)localObject2;
            ((MailEditAttach)localObject2).setAccountId(paramInt);
            ((MailEditAttach)localObject2).setBelongMailId(paramMailInformation.getId());
            insertEditAttach(paramSQLiteDatabase, (MailEditAttach)localObject2);
          }
        }
      }
      if (localArrayList3 != null) {
        localArrayList3.clear();
      }
      if ((localArrayList1 != null) && (localArrayList1.size() > 0)) {
        deleteAttach(paramSQLiteDatabase, localArrayList1, false);
      }
    } while ((localArrayList2 == null) || (localArrayList2.size() <= 0));
    deleteAttach(paramSQLiteDatabase, localArrayList2, true);
  }
  
  public void upgradeTableFor3003(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_MAIL_ATTACH ADD COLUMN refmailid INTEGER");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_MAIL_ATTACH ADD COLUMN orderidx INTEGER");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_FTN_ATTACH ADD COLUMN refmailid INTEGER");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_FTN_ATTACH ADD COLUMN orderidx INTEGER");
  }
  
  public void upgradeTableFor3008(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_MAIL_ATTACH ADD COLUMN folderid INTEGER");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_MAIL_ATTACH ADD COLUMN alias VARCHAR");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_MAIL_ATTACH ADD COLUMN folderkey INTEGER");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_MAIL_ATTACH ADD COLUMN rank INTEGER");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_MAIL_ATTACH ADD COLUMN attr INTEGER");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_MAIL_ATTACH ADD COLUMN favtime INTEGER");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_MAIL_ATTACH ADD COLUMN viewmode VARCHAR");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_MAIL_ATTACH ADD COLUMN mailsender VARCHAR");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_MAIL_ATTACH ADD COLUMN mailsubject VARCHAR");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_MAIL_ATTACH ADD COLUMN previewurl VARCHAR");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_MAIL_ATTACH ADD COLUMN mailsenderaddr VARCHAR");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_MAIL_ATTACH ADD COLUMN remoteid VARCHAR");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_MAIL_ATTACH ADD COLUMN urlencodename VARCHAR");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_MAIL_ATTACH ADD COLUMN isfavorite INTEGER");
    updateAttachExtraMailInfo(paramSQLiteDatabase);
  }
  
  public void upgradeTableFor3013(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_MAIL_ATTACH ADD COLUMN downloadkey VARCHAR");
  }
  
  public void upgradeTableFor5009(SQLiteDatabase paramSQLiteDatabase)
  {
    QMLog.log(4, "QMMailSQLite", "upgradeTableFor5009 ");
    long l = System.currentTimeMillis();
    try
    {
      paramSQLiteDatabase.beginTransactionNonExclusive();
      updateNormalAttachIdForUpgrade(paramSQLiteDatabase);
      updateBigAttachForUpgrade(paramSQLiteDatabase);
      paramSQLiteDatabase.setTransactionSuccessful();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(6, "QMMailSQLite", "upgrade for 5009 error:" + localException.getMessage());
        paramSQLiteDatabase.endTransaction();
      }
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
    QMLog.log(4, "QMMailSQLite", "upgradeTableFor5009 time:" + (System.currentTimeMillis() - l));
  }
  
  public void upgradeTableFor5301(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_EDIT_ATTACH(id integer primary key, name varchar, type varchar, icon varchar, url varchar, key varchar, size varchar, accountid integer, mailid integer)");
  }
  
  public void upgradeTableFor5302(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS QM_MAIL_ATTACH_ORDER_IDX_INDEX ON QM_MAIL_ATTACH(mailid,orderidx)");
    paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS INDEX_FTN_ATTACH ON QM_FTN_ATTACH(mailid,orderidx)");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.QMAttachSQLite
 * JD-Core Version:    0.7.0.1
 */