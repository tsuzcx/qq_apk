package com.tencent.qqmail.model.mail;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.folderlist.FolderListItemHelper;
import com.tencent.qqmail.model.cache.IMapper;
import com.tencent.qqmail.model.cache.QMFolderCache;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.QMMath;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import org.apache.commons.lang3.ArrayUtils;

public class QMFolderSQLite
  extends QMMailSQLiteHelper.UnsupportedGetDatabase
{
  private static int[] hybirdFolderMaps;
  private static SparseArray<QMFolder> hybirdFolders = new SparseArray();
  private static final String sqlCreate = "CREATE TABLE IF NOT EXISTS QM_FOLDER(id integer primary key, accountId integer, remoteId varchar, parentname varchar, parentId integer default 0, type integer, svrCount integer default -1, svrUnreadCount integer default -1, cliUnreadCount integer, cliConvUnreadCount integer, cliLastcliUnreadCount integer, cliLastConvUnreadCount integer, hasNewMail integer default 0, isVirtual integer default 0, isDisplay integer default 1, name varchar, sequence integer default 0, popId varchar, popEmail varchar, overdue integer, locked integer, colorId varchar, since integer  default 0, push integer default 1, syncKey varchar default '0', syncState varchar default '', silent integer default 0, fromtime integer default 0, personalCount integer default 0)";
  private static final String sqlCreateIndex = "CREATE INDEX IF NOT EXISTS INDEX_FOLDER ON QM_FOLDER(type,accountId)";
  private static final String sqlDeleteAccountFolders = "DELETE FROM QM_FOLDER WHERE accountId =?";
  private static final String sqlDrop = "DROP TABLE IF EXISTS QM_FOLDER";
  private static final String sqlDropIndex = "DROP INDEX IF EXISTS INDEX_FOLDER";
  private static final String sqlInsert = "REPLACE INTO QM_FOLDER (id,accountId,remoteId,parentId,type,svrCount,svrUnreadCount,cliUnreadCount,cliConvUnreadCount,sequence,isVirtual,isDisplay,name,popId,popEmail,overdue,locked,colorId,parentname,fromtime,personalCount) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
  private static final String sqlQueryAdvertiseEntranceUnreadCount = "SELECT COUNT(DISTINCT id) FROM QM_MAIL_INFO WHERE accountId IN $accountIds$ AND attr&2048 AND isUnread=1";
  public static final String sqlQueryConvIncrementUnread = "SELECT cliConvUnreadCount, cliLastConvUnreadCount, name FROM QM_FOLDER WHERE cliConvUnreadCount > cliLastConvUnreadCount AND accountId =? AND type NOT IN (";
  private static final String sqlQueryFolderById = "SELECT * FROM QM_FOLDER WHERE id=?";
  private static final String sqlQueryInboxSeqByAcc = "SELECT accountId,sequence FROM QM_FOLDER WHERE type=1 AND accountId IN ";
  public static final String sqlQueryIncrementUnread = "SELECT cliUnreadCount, cliLastcliUnreadCount, name FROM QM_FOLDER WHERE cliUnreadCount > cliLastcliUnreadCount AND accountId =? AND type NOT IN (";
  private static final String sqlQueryLastMail = "SELECT utcSent FROM QM_MAIL_INFO WHERE remoteId=?";
  private static final String sqlQuerySubscribeEntranceUnreadCount = "SELECT COUNT(DISTINCT id) FROM QM_MAIL_INFO WHERE accountId IN $accountIds$ AND attr&8192 AND isUnread=1";
  private static final String sqlQuerySubscribeUnreadCount = "SELECT cliUnreadCount FROM QM_FOLDER WHERE accountId IN $accountIds$ AND cliUnreadCount > 0 AND type=15";
  public static final String sqlUpdateAllHasNewToFalse = "UPDATE QM_FOLDER SET hasNewMail =0";
  public static final String sqlUpdateConvLatestUnread = "UPDATE QM_FOLDER SET cliLastConvUnreadCount=cliConvUnreadCount";
  private static final String sqlUpdateFolderFromTime = "SELECT MAX(utcSent) FROM QM_MAIL_INFO WHERE folderId =? AND attr&256";
  private static final String sqlUpdateFolderIdSince = "UPDATE QM_FOLDER SET since=(SELECT utcSent FROM QM_MAIL_INFO WHERE remoteId=?) WHERE id=?";
  private static final String sqlUpdateFolderSeq = "UPDATE QM_FOLDER SET sequence=sequence +1  WHERE sequence>? AND accountId=?";
  private static final String sqlUpdateFolderSequence = "UPDATE QM_FOLDER SET sequence=? WHERE id=?";
  private static final String sqlUpdateFolderSince = "UPDATE QM_FOLDER SET since =?  WHERE id=?";
  private static final String sqlUpdateFromTimeFromSync = "UPDATE QM_FOLDER SET fromtime=? WHERE id=?";
  public static final String sqlUpdateLatestUnread = "UPDATE QM_FOLDER SET cliLastcliUnreadCount=cliUnreadCount";
  private static final String sqlUpdateLocalMailSvrCntIntoFolder = "UPDATE QM_FOLDER SET svrUnreadCount=(CASE WHEN svrUnreadCount < 0 THEN svrUnreadCount ELSE svrUnreadCount+? END),svrCount=(CASE WHEN svrCount < 0 THEN svrCount ELSE svrCount+? END) WHERE id = ?";
  private static final String sqlUpdateQQFolderCounter = "UPDATE QM_FOLDER SET cliUnreadCount=cliUnreadCount+?,svrUnreadCount=svrUnreadCount+?,cliConvUnreadCount=cliConvUnreadCount+?,svrCount=svrCount+? WHERE id=?";
  private static final String sqlUpdateSequence = "UPDATE QM_FOLDER SET sequence = sequence + 1 WHERE sequence >= ? AND accountId=?";
  private static final String sqlUpdateSince = "UPDATE QM_FOLDER SET since=(SELECT utcSent FROM QM_MAIL_INFO WHERE remoteId=?) WHERE accountId=?";
  private int[] getAccountHasNewMailExcludeTypes = { 3, 14, 17, 18, 16, 15, 6, 5, 4 };
  private int[] getAccountUnreadCountExcludeTypes = { 14, 17, 18, 16, 15, 6, 5, 4 };
  private final QMFolderCache memoryStore = new QMFolderCache();
  
  static
  {
    hybirdFolderMaps = new int[] { -14, -14, 2131693935, -19, 103, 2131693940, -11, 4, 2131693933, -13, 3, 2131693936, -12, 5, 2131693938, 110, 110, 2131693945, -9, 18, 2131693939, -10, 103, 2131693946, -2, 103, 2131693937, -18, 103, 2131691226, -5, 103, 2131694073, -4, 103, 2131696400, -3, 17, 2131695181, -16, 103, 2131690982, -23, 103, 2131691269, -1, 1, 2131693934, -20, 140, 2131693944, -21, 103, 2131692041, -22, 103, 2131692063 };
    QMApplicationContext localQMApplicationContext = QMApplicationContext.sharedInstance();
    int i = 0;
    while (i < hybirdFolderMaps.length)
    {
      QMFolder localQMFolder = new QMFolder();
      int j = hybirdFolderMaps[i];
      localQMFolder.setId(j);
      int[] arrayOfInt = hybirdFolderMaps;
      i += 1;
      localQMFolder.setType(arrayOfInt[i]);
      localQMFolder.setAccountId(0);
      arrayOfInt = hybirdFolderMaps;
      i += 1;
      int k = arrayOfInt[i];
      if (k != -2147483648) {
        localQMFolder.setName(localQMApplicationContext.getString(k));
      }
      hybirdFolders.put(j, localQMFolder);
      i += 1;
    }
  }
  
  public QMFolderSQLite(Context paramContext)
  {
    super(paramContext, false);
  }
  
  private static void beginColumnIndex(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null) {
      paramArrayOfInt[0] = 0;
    }
  }
  
  private void fillFolders(SQLiteDatabase paramSQLiteDatabase, Cursor paramCursor, QMFolder paramQMFolder, int[] paramArrayOfInt)
  {
    boolean bool2 = true;
    beginColumnIndex(paramArrayOfInt);
    if (paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "isVirtual")) == 1)
    {
      bool1 = true;
      paramQMFolder.setVirtual(bool1);
      if (paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "isDisplay")) != 1) {
        break label553;
      }
      bool1 = true;
      label56:
      paramQMFolder.setDisplay(bool1);
      paramQMFolder.setId(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "id")));
      paramQMFolder.setAccountId(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "accountId")));
      paramQMFolder.setRemoteId(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "remoteId")));
      paramQMFolder.setParentId(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "parentId")));
      paramQMFolder.setParentName(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "parentname")));
      paramQMFolder.setType(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "type")));
      paramQMFolder.setSvrCount(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "svrCount")));
      paramQMFolder.setSvrUnreadCount(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "svrUnreadCount")));
      paramQMFolder.setCliUnreadCount(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "cliUnreadCount")));
      paramQMFolder.setCliConvUnreadCount(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "cliConvUnreadCount")));
      paramQMFolder.setName(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "name")));
      paramQMFolder.setPopId(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "popId")));
      paramQMFolder.setPopEmail(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "popEmail")));
      paramQMFolder.setColorId(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "colorId")));
      paramQMFolder.setSince(paramCursor.getLong(getColumnIndex(paramArrayOfInt, paramCursor, "since")));
      if (paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "overdue")) != 1) {
        break label559;
      }
      bool1 = true;
      label359:
      paramQMFolder.setOverdue(bool1);
      if (paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "hasNewMail")) != 1) {
        break label565;
      }
      bool1 = true;
      label387:
      paramQMFolder.setHasNewMail(bool1);
      if (paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "locked")) != 1) {
        break label571;
      }
      bool1 = true;
      label415:
      paramQMFolder.setLocked(bool1);
      if (paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "push")) != 1) {
        break label577;
      }
    }
    label553:
    label559:
    label565:
    label571:
    label577:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramQMFolder.setPush(bool1);
      paramQMFolder.setSyncKey(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "syncKey")));
      paramQMFolder.setSyncState(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "syncState")));
      paramQMFolder.setSequence(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "sequence")));
      paramQMFolder.setFromTime(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "fromtime")));
      paramQMFolder.setPersonalCount(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "personalCount")));
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label56;
      bool1 = false;
      break label359;
      bool1 = false;
      break label387;
      bool1 = false;
      break label415;
    }
  }
  
  private static int getColumnIndex(int[] paramArrayOfInt, Cursor paramCursor, String paramString)
  {
    if (paramArrayOfInt == null) {
      return paramCursor.getColumnIndex(paramString);
    }
    int i = paramArrayOfInt[0] + 1;
    paramArrayOfInt[0] = i;
    if (paramArrayOfInt[i] > -2147483648) {
      return paramArrayOfInt[i];
    }
    int j = paramCursor.getColumnIndex(paramString);
    paramArrayOfInt[i] = j;
    return j;
  }
  
  private long getSinceByRemoteId(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT utcSent FROM QM_MAIL_INFO WHERE remoteId=?", new String[] { paramString });
    long l1 = -1L;
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
  
  private ArrayList<QMFolder> queryFolders(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    int[] arrayOfInt = new int[40];
    Arrays.fill(arrayOfInt, -2147483648);
    paramString = paramSQLiteDatabase.rawQuery(paramString, paramArrayOfString);
    if (paramString != null)
    {
      int j = paramString.getCount();
      int i = 0;
      while (i < j)
      {
        paramString.moveToPosition(i);
        paramArrayOfString = new QMFolder();
        fillFolders(paramSQLiteDatabase, paramString, paramArrayOfString, arrayOfInt);
        localArrayList.add(paramArrayOfString);
        i += 1;
      }
      paramString.close();
    }
    return localArrayList;
  }
  
  private ArrayList<QMFolder> queryFolders(IMapper<QMFolder> paramIMapper)
  {
    TreeSet localTreeSet = new TreeSet();
    this.memoryStore.select(new QMFolderSQLite.45(this, localTreeSet, paramIMapper));
    return new ArrayList(localTreeSet);
  }
  
  public int advertiseConvUnread(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt)
  {
    int i = 0;
    int j = 0;
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT COUNT(DISTINCT id) FROM QM_MAIL_INFO WHERE accountId IN $accountIds$ AND attr&2048 AND isUnread=1".replace("$accountIds$", getInClause(paramArrayOfInt)), null);
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
  
  public void createIndex(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS INDEX_FOLDER ON QM_FOLDER(type,accountId)");
  }
  
  public void createTable(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_FOLDER(id integer primary key, accountId integer, remoteId varchar, parentname varchar, parentId integer default 0, type integer, svrCount integer default -1, svrUnreadCount integer default -1, cliUnreadCount integer, cliConvUnreadCount integer, cliLastcliUnreadCount integer, cliLastConvUnreadCount integer, hasNewMail integer default 0, isVirtual integer default 0, isDisplay integer default 1, name varchar, sequence integer default 0, popId varchar, popEmail varchar, overdue integer, locked integer, colorId varchar, since integer  default 0, push integer default 1, syncKey varchar default '0', syncState varchar default '', silent integer default 0, fromtime integer default 0, personalCount integer default 0)");
    QMLog.log(4, "QMMailSQLite", "create table");
  }
  
  public void deleteFoldersByAccountId(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    this.memoryStore.delete(new QMFolderSQLite.59(this, paramInt), null);
    paramSQLiteDatabase.execSQL("DELETE FROM QM_FOLDER WHERE accountId =?", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void dropIndex(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS INDEX_FOLDER");
  }
  
  public void dropTable(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_FOLDER");
    QMLog.log(4, "QMMailSQLite", "drop table");
  }
  
  public boolean getAccountHasNewMail(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    paramSQLiteDatabase = new boolean[1];
    paramSQLiteDatabase[0] = 0;
    boolean bool = QMSettingManager.sharedInstance().getAggregateSubject(paramInt);
    this.memoryStore.select(new QMFolderSQLite.42(this, bool, paramInt, paramSQLiteDatabase));
    return paramSQLiteDatabase[0];
  }
  
  public int getAccountUnreadCount(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    paramSQLiteDatabase = new int[1];
    paramSQLiteDatabase[0] = 0;
    this.memoryStore.select(new QMFolderSQLite.39(this, paramInt, paramSQLiteDatabase));
    return paramSQLiteDatabase[0];
  }
  
  /* Error */
  public int getAllFolderUnreadCount(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: iconst_0
    //   3: istore 6
    //   5: iconst_0
    //   6: istore 5
    //   8: iconst_0
    //   9: istore 4
    //   11: invokestatic 476	com/tencent/qqmail/account/AccountManager:shareInstance	()Lcom/tencent/qqmail/account/AccountManager;
    //   14: invokevirtual 480	com/tencent/qqmail/account/AccountManager:getAccountList	()Lcom/tencent/qqmail/account/AccountList;
    //   17: astore 7
    //   19: aload 7
    //   21: invokevirtual 485	com/tencent/qqmail/account/AccountList:size	()I
    //   24: iconst_1
    //   25: if_icmpne +477 -> 502
    //   28: aload 7
    //   30: iconst_0
    //   31: invokevirtual 489	com/tencent/qqmail/account/AccountList:get	(I)Lcom/tencent/qqmail/account/model/Account;
    //   34: invokevirtual 494	com/tencent/qqmail/account/model/Account:isQQMail	()Z
    //   37: ifeq +465 -> 502
    //   40: iload_2
    //   41: tableswitch	default:+71 -> 112, -14:+238->279, -13:+308->349, -12:+316->357, -11:+300->341, -10:+71->112, -9:+230->271, -8:+71->112, -7:+71->112, -6:+71->112, -5:+71->112, -4:+71->112, -3:+201->242, -2:+209->250, -1:+92->133
    //   113: aconst_null
    //   114: <illegal opcode>
    //   115: astore 7
    //   117: aload 7
    //   119: ldc_w 496
    //   122: invokevirtual 499	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   125: ifeq +240 -> 365
    //   128: iload 4
    //   130: istore_3
    //   131: iload_3
    //   132: ireturn
    //   133: invokestatic 452	com/tencent/qqmail/model/mail/QMSettingManager:sharedInstance	()Lcom/tencent/qqmail/model/mail/QMSettingManager;
    //   136: astore_1
    //   137: invokestatic 504	com/tencent/qqmail/folderlist/QMFolderManager:sharedInstance	()Lcom/tencent/qqmail/folderlist/QMFolderManager;
    //   140: astore 8
    //   142: aload 7
    //   144: invokevirtual 508	com/tencent/qqmail/account/AccountList:iterator	()Ljava/util/Iterator;
    //   147: astore 7
    //   149: iload 6
    //   151: istore_2
    //   152: iload_2
    //   153: istore_3
    //   154: aload 7
    //   156: invokeinterface 513 1 0
    //   161: ifeq -30 -> 131
    //   164: aload 8
    //   166: aload 7
    //   168: invokeinterface 517 1 0
    //   173: checkcast 491	com/tencent/qqmail/account/model/Account
    //   176: invokevirtual 520	com/tencent/qqmail/account/model/Account:getId	()I
    //   179: invokevirtual 523	com/tencent/qqmail/folderlist/QMFolderManager:getInboxFolderId	(I)I
    //   182: istore_3
    //   183: aload_0
    //   184: getfield 167	com/tencent/qqmail/model/mail/QMFolderSQLite:memoryStore	Lcom/tencent/qqmail/model/cache/QMFolderCache;
    //   187: iload_3
    //   188: invokestatic 438	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   191: invokevirtual 526	com/tencent/qqmail/model/cache/QMFolderCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   194: checkcast 133	com/tencent/qqmail/model/qmdomain/QMFolder
    //   197: astore 9
    //   199: aload 9
    //   201: ifnull -49 -> 152
    //   204: aload_1
    //   205: aload 9
    //   207: invokevirtual 529	com/tencent/qqmail/model/qmdomain/QMFolder:getAccountId	()I
    //   210: invokevirtual 455	com/tencent/qqmail/model/mail/QMSettingManager:getAggregateSubject	(I)Z
    //   213: ifeq +20 -> 233
    //   216: aload 9
    //   218: invokevirtual 532	com/tencent/qqmail/model/qmdomain/QMFolder:getCliConvUnreadCount	()I
    //   221: istore_3
    //   222: iload_3
    //   223: ifle -71 -> 152
    //   226: iload_2
    //   227: iload_3
    //   228: iadd
    //   229: istore_2
    //   230: goto -78 -> 152
    //   233: aload 9
    //   235: invokevirtual 535	com/tencent/qqmail/model/qmdomain/QMFolder:getCliUnreadCount	()I
    //   238: istore_3
    //   239: goto -17 -> 222
    //   242: getstatic 540	com/tencent/qqmail/model/mail/QMMailSQLite:sqlQueryVipUnreadCount	Ljava/lang/String;
    //   245: astore 7
    //   247: goto -130 -> 117
    //   250: iload_3
    //   251: ifeq +12 -> 263
    //   254: invokestatic 504	com/tencent/qqmail/folderlist/QMFolderManager:sharedInstance	()Lcom/tencent/qqmail/folderlist/QMFolderManager;
    //   257: bipush 16
    //   259: invokevirtual 543	com/tencent/qqmail/folderlist/QMFolderManager:getQQUnreadCountByType	(I)I
    //   262: ireturn
    //   263: getstatic 546	com/tencent/qqmail/model/mail/QMMailSQLite:sqlQueryStarUnreadCount	Ljava/lang/String;
    //   266: astore 7
    //   268: goto -151 -> 117
    //   271: ldc_w 548
    //   274: astore 7
    //   276: goto -159 -> 117
    //   279: aload 7
    //   281: invokevirtual 485	com/tencent/qqmail/account/AccountList:size	()I
    //   284: newarray int
    //   286: astore 8
    //   288: iconst_0
    //   289: istore_2
    //   290: iload_2
    //   291: aload 7
    //   293: invokevirtual 485	com/tencent/qqmail/account/AccountList:size	()I
    //   296: if_icmpge +26 -> 322
    //   299: aload 8
    //   301: iload_2
    //   302: aload 7
    //   304: iload_2
    //   305: invokevirtual 489	com/tencent/qqmail/account/AccountList:get	(I)Lcom/tencent/qqmail/account/model/Account;
    //   308: invokevirtual 552	com/tencent/qqmail/account/model/Account:getEmail	()Ljava/lang/String;
    //   311: invokestatic 555	com/tencent/qqmail/model/mail/QMMailSQLite:genRMAAddrId	(Ljava/lang/String;)I
    //   314: iastore
    //   315: iload_2
    //   316: iconst_1
    //   317: iadd
    //   318: istore_2
    //   319: goto -29 -> 290
    //   322: ldc_w 557
    //   325: ldc_w 559
    //   328: aload 8
    //   330: invokestatic 399	com/tencent/qqmail/model/mail/QMFolderSQLite:getInClause	([I)Ljava/lang/String;
    //   333: invokevirtual 403	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   336: astore 7
    //   338: goto -221 -> 117
    //   341: ldc_w 561
    //   344: astore 7
    //   346: goto -229 -> 117
    //   349: getstatic 564	com/tencent/qqmail/model/mail/QMMailSQLite:sqlCountAllUnreadSentMailInfo	Ljava/lang/String;
    //   352: astore 7
    //   354: goto -237 -> 117
    //   357: getstatic 567	com/tencent/qqmail/model/mail/QMMailSQLite:sqlCountAllUnreadTrashMailInfo	Ljava/lang/String;
    //   360: astore 7
    //   362: goto -245 -> 117
    //   365: aload_1
    //   366: aload 7
    //   368: aconst_null
    //   369: invokevirtual 340	com/tencent/moai/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   372: astore 7
    //   374: iload 5
    //   376: istore_2
    //   377: aload 7
    //   379: ifnull +42 -> 421
    //   382: iload 5
    //   384: istore_2
    //   385: aload 7
    //   387: astore_1
    //   388: aload 7
    //   390: invokeinterface 362 1 0
    //   395: ifle +26 -> 421
    //   398: aload 7
    //   400: astore_1
    //   401: aload 7
    //   403: invokeinterface 346 1 0
    //   408: pop
    //   409: aload 7
    //   411: astore_1
    //   412: aload 7
    //   414: iconst_0
    //   415: invokeinterface 206 2 0
    //   420: istore_2
    //   421: iload_2
    //   422: istore_3
    //   423: aload 7
    //   425: ifnull -294 -> 131
    //   428: aload 7
    //   430: invokeinterface 349 1 0
    //   435: iload_2
    //   436: ireturn
    //   437: astore 8
    //   439: aconst_null
    //   440: astore 7
    //   442: aload 7
    //   444: astore_1
    //   445: bipush 6
    //   447: ldc_w 411
    //   450: ldc_w 496
    //   453: aload 8
    //   455: invokestatic 570	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   458: iload 4
    //   460: istore_3
    //   461: aload 7
    //   463: ifnull -332 -> 131
    //   466: aload 7
    //   468: invokeinterface 349 1 0
    //   473: iconst_0
    //   474: ireturn
    //   475: astore 7
    //   477: aconst_null
    //   478: astore_1
    //   479: aload_1
    //   480: ifnull +9 -> 489
    //   483: aload_1
    //   484: invokeinterface 349 1 0
    //   489: aload 7
    //   491: athrow
    //   492: astore 7
    //   494: goto -15 -> 479
    //   497: astore 8
    //   499: goto -57 -> 442
    //   502: iconst_0
    //   503: istore_3
    //   504: goto -464 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	507	0	this	QMFolderSQLite
    //   0	507	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	507	2	paramInt	int
    //   1	503	3	i	int
    //   9	450	4	j	int
    //   6	377	5	k	int
    //   3	147	6	m	int
    //   17	450	7	localObject1	Object
    //   475	15	7	localObject2	Object
    //   492	1	7	localObject3	Object
    //   140	189	8	localObject4	Object
    //   437	17	8	localException1	Exception
    //   497	1	8	localException2	Exception
    //   197	37	9	localQMFolder	QMFolder
    // Exception table:
    //   from	to	target	type
    //   365	374	437	java/lang/Exception
    //   365	374	475	finally
    //   388	398	492	finally
    //   401	409	492	finally
    //   412	421	492	finally
    //   445	458	492	finally
    //   388	398	497	java/lang/Exception
    //   401	409	497	java/lang/Exception
    //   412	421	497	java/lang/Exception
  }
  
  public int[] getExcludeFolderIds(int paramInt, int[] paramArrayOfInt)
  {
    HashSet localHashSet = new HashSet();
    this.memoryStore.select(new QMFolderSQLite.52(this, paramInt, paramArrayOfInt, localHashSet));
    return ArrayUtils.toPrimitive((Integer[])Arrays.copyOf(localHashSet.toArray(), localHashSet.size(), [Ljava.lang.Integer.class));
  }
  
  @Nullable
  public QMFolder getFolderById(int paramInt)
  {
    return (QMFolder)this.memoryStore.get(Integer.valueOf(paramInt));
  }
  
  public int getFolderCnt(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 0;
    this.memoryStore.select(new QMFolderSQLite.60(this, paramInt1, paramInt2, arrayOfInt));
    return arrayOfInt[0];
  }
  
  public int[] getFolderIds(int paramInt)
  {
    return this.memoryStore.getFolderIds(paramInt);
  }
  
  public int[] getFolderIds(int paramInt, String[] paramArrayOfString)
  {
    HashSet localHashSet = new HashSet();
    paramArrayOfString = Arrays.asList(paramArrayOfString);
    this.memoryStore.select(new QMFolderSQLite.51(this, paramInt, paramArrayOfString, localHashSet));
    return ArrayUtils.toPrimitive((Integer[])Arrays.copyOf(localHashSet.toArray(), localHashSet.size(), [Ljava.lang.Integer.class));
  }
  
  public int getFolderPushOnCount(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 0;
    this.memoryStore.select(new QMFolderSQLite.61(this, paramInt1, paramInt2, arrayOfInt));
    return arrayOfInt[0];
  }
  
  public String getFolderSyncKey(int paramInt)
  {
    QMFolder localQMFolder = (QMFolder)this.memoryStore.get(Integer.valueOf(paramInt));
    if (localQMFolder != null) {
      return localQMFolder.getSyncKey();
    }
    return "";
  }
  
  public String getFolderSyncState(int paramInt)
  {
    QMFolder localQMFolder = (QMFolder)this.memoryStore.get(Integer.valueOf(paramInt));
    if (localQMFolder != null) {
      return localQMFolder.getSyncState();
    }
    return "";
  }
  
  public ArrayList<QMFolder> getFolders(int paramInt, boolean paramBoolean, int[] paramArrayOfInt)
  {
    return queryFolders(new QMFolderSQLite.49(this, paramInt, paramArrayOfInt, paramBoolean));
  }
  
  public ArrayList<QMFolder> getFolders(int[] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList();
    this.memoryStore.select(new QMFolderSQLite.43(this, paramArrayOfInt, localArrayList));
    return localArrayList;
  }
  
  public ArrayList<QMFolder> getFoldersByAccountAndType(int paramInt1, int paramInt2)
  {
    return queryFolders(new QMFolderSQLite.46(this, paramInt2, paramInt1));
  }
  
  public ArrayList<QMFolder> getFoldersByAccountAndTypes(int paramInt, int[] paramArrayOfInt)
  {
    Arrays.sort(paramArrayOfInt);
    return queryFolders(new QMFolderSQLite.47(this, paramInt, paramArrayOfInt));
  }
  
  public ArrayList<QMFolder> getFoldersByAccountId(int paramInt)
  {
    return queryFolders(new QMFolderSQLite.48(this, paramInt));
  }
  
  public ArrayList<QMFolder> getFoldersByAccountIdExcludeVipAndUnread(int paramInt)
  {
    return this.memoryStore.selectByAccountExcludeVipAndUnread(paramInt);
  }
  
  public ArrayList<QMFolder> getFoldersByName(int paramInt, String paramString, boolean paramBoolean)
  {
    return queryFolders(new QMFolderSQLite.44(this, paramString, paramInt, paramBoolean));
  }
  
  public ArrayList<QMFolder> getFoldersByType(int paramInt)
  {
    return this.memoryStore.selectByType(paramInt);
  }
  
  public List<QMFolder> getFoldersInIds(int[] paramArrayOfInt)
  {
    return queryFolders(new QMFolderSQLite.50(this, paramArrayOfInt));
  }
  
  @Nullable
  public QMFolder getHybirdFolder(int paramInt)
  {
    return (QMFolder)hybirdFolders.get(paramInt);
  }
  
  public boolean getInboxHasNewMail(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    paramSQLiteDatabase = new boolean[1];
    paramSQLiteDatabase[0] = 0;
    this.memoryStore.select(new QMFolderSQLite.38(this, paramInt, paramSQLiteDatabase));
    return paramSQLiteDatabase[0];
  }
  
  public int getInboxUnreadCount(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    paramSQLiteDatabase = new int[1];
    paramSQLiteDatabase[0] = 0;
    this.memoryStore.select(new QMFolderSQLite.37(this, paramInt, paramSQLiteDatabase));
    return paramSQLiteDatabase[0];
  }
  
  public int getLatestSequence(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    ArrayList localArrayList = queryFolders(new QMFolderSQLite.65(this, paramInt, paramBoolean1, paramBoolean2));
    if (localArrayList.size() > 0) {
      return ((QMFolder)localArrayList.get(localArrayList.size() - 1)).getSequence();
    }
    return 0;
  }
  
  public int getQQUnreadCountByType(int paramInt)
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 0;
    this.memoryStore.select(new QMFolderSQLite.73(this, arrayOfInt, paramInt));
    return arrayOfInt[0];
  }
  
  public boolean hasEditeFoldersOrder(int paramInt)
  {
    Iterator localIterator = this.memoryStore.entrySet().iterator();
    while (localIterator.hasNext())
    {
      QMFolder localQMFolder = (QMFolder)((Map.Entry)localIterator.next()).getValue();
      if ((localQMFolder != null) && (localQMFolder.getAccountId() == paramInt) && (FolderListItemHelper.hasEditedFolderOrder(localQMFolder))) {
        return true;
      }
    }
    return false;
  }
  
  public void increaseSequenceForAddFolder(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    this.memoryStore.update(new QMFolderSQLite.63(this, paramInt1, paramInt2), new QMFolderSQLite.64(this, paramSQLiteDatabase, paramInt2, paramInt1));
  }
  
  public void initCache(SQLiteDatabase paramSQLiteDatabase)
  {
    this.memoryStore.clear();
    paramSQLiteDatabase = queryFolders(paramSQLiteDatabase, "SELECT id, accountId, remoteId, parentname, parentId, type, svrCount, svrUnreadCount, cliUnreadCount, cliConvUnreadCount, hasNewMail, sequence, isVirtual, isDisplay, name, popId, popEmail, overdue, locked, colorId, since, push, syncKey, syncState, silent, fromtime, personalCount FROM QM_FOLDER", null).iterator();
    while (paramSQLiteDatabase.hasNext())
    {
      QMFolder localQMFolder = (QMFolder)paramSQLiteDatabase.next();
      this.memoryStore.insert(Integer.valueOf(localQMFolder.getId()), localQMFolder);
    }
  }
  
  public void insertFolder(SQLiteDatabase paramSQLiteDatabase, QMFolder paramQMFolder)
  {
    if (paramQMFolder == null) {
      return;
    }
    int i = paramQMFolder.getAccountId();
    String str = paramQMFolder.getRemoteId();
    if (paramQMFolder.getType() == 14) {}
    for (boolean bool = true;; bool = false)
    {
      paramQMFolder.setId(QMFolder.generateId(i, str, bool));
      this.memoryStore.insert(Integer.valueOf(paramQMFolder.getId()), paramQMFolder, new QMFolderSQLite.1(this, paramQMFolder, paramSQLiteDatabase));
      return;
    }
  }
  
  public int queryIncrementUnread(SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject = AccountManager.shareInstance().getAccountList();
    StringBuilder localStringBuilder = new StringBuilder(this.getAccountUnreadCountExcludeTypes.length * 2);
    int i = 0;
    if (i < this.getAccountUnreadCountExcludeTypes.length)
    {
      if (i < this.getAccountUnreadCountExcludeTypes.length - 1) {
        localStringBuilder.append(String.valueOf(this.getAccountUnreadCountExcludeTypes[i])).append(",");
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(String.valueOf(this.getAccountUnreadCountExcludeTypes[i])).append(")");
      }
    }
    Iterator localIterator = ((AccountList)localObject).iterator();
    int j;
    label338:
    for (i = 0; localIterator.hasNext(); i = j)
    {
      Account localAccount = (Account)localIterator.next();
      if (QMSettingManager.sharedInstance().getAggregateSubject(localAccount.getId())) {}
      for (localObject = "SELECT cliConvUnreadCount, cliLastConvUnreadCount, name FROM QM_FOLDER WHERE cliConvUnreadCount > cliLastConvUnreadCount AND accountId =? AND type NOT IN (" + localStringBuilder.toString();; localObject = "SELECT cliUnreadCount, cliLastcliUnreadCount, name FROM QM_FOLDER WHERE cliUnreadCount > cliLastcliUnreadCount AND accountId =? AND type NOT IN (" + localStringBuilder.toString())
      {
        localObject = paramSQLiteDatabase.rawQuery((String)localObject, new String[] { "" + localAccount.getId() });
        j = i;
        if (localObject == null) {
          break label338;
        }
        ((Cursor)localObject).moveToFirst();
        j = 0;
        while (j < ((Cursor)localObject).getCount())
        {
          int m = ((Cursor)localObject).getInt(0);
          int n = ((Cursor)localObject).getInt(1);
          ((Cursor)localObject).getString(2);
          int k = i;
          if (m > n) {
            k = i + (m - n);
          }
          ((Cursor)localObject).moveToNext();
          j += 1;
          i = k;
        }
      }
      ((Cursor)localObject).close();
      j = i;
    }
    return i;
  }
  
  public void removeFolder(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int[] paramArrayOfInt, int paramInt2, boolean paramBoolean)
  {
    int i = paramArrayOfInt.length;
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      int j = paramArrayOfInt[paramInt2];
      this.memoryStore.deleteByKey(Integer.valueOf(j));
      paramInt2 += 1;
    }
    paramSQLiteDatabase.delete("QM_FOLDER", "accountId=? AND id IN " + getInClause(paramArrayOfInt), new String[] { String.valueOf(paramInt1) });
  }
  
  public void renameFolder(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString)
  {
    this.memoryStore.updateByKey(Integer.valueOf(paramInt), new QMFolderSQLite.2(this, paramString), new QMFolderSQLite.3(this, paramString, paramSQLiteDatabase, paramInt));
  }
  
  public void renameFolder(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString1, String paramString2)
  {
    this.memoryStore.update(new QMFolderSQLite.4(this, paramString2, paramString1, paramInt), new QMFolderSQLite.5(this, paramString2, paramSQLiteDatabase, paramString1, paramInt));
  }
  
  public void resetAllInboxHasNew(SQLiteDatabase paramSQLiteDatabase)
  {
    this.memoryStore.update(new QMFolderSQLite.25(this), new QMFolderSQLite.26(this, paramSQLiteDatabase));
  }
  
  public void resetFolderHasNew(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    this.memoryStore.updateByKey(Integer.valueOf(paramInt), new QMFolderSQLite.29(this), new QMFolderSQLite.30(this, paramSQLiteDatabase, paramInt));
  }
  
  public void resetFolders(SQLiteDatabase paramSQLiteDatabase, int paramInt, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
      return;
    }
    this.memoryStore.delete(new QMFolderSQLite.23(this, paramInt, paramArrayOfInt), new QMFolderSQLite.24(this, paramArrayOfInt, paramSQLiteDatabase, paramInt));
  }
  
  /* Error */
  public void setAllHasNewMailToFalse(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 894	com/tencent/moai/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   4: invokestatic 476	com/tencent/qqmail/account/AccountManager:shareInstance	()Lcom/tencent/qqmail/account/AccountManager;
    //   7: invokevirtual 480	com/tencent/qqmail/account/AccountManager:getAccountList	()Lcom/tencent/qqmail/account/AccountList;
    //   10: invokevirtual 508	com/tencent/qqmail/account/AccountList:iterator	()Ljava/util/Iterator;
    //   13: astore_2
    //   14: aload_2
    //   15: invokeinterface 513 1 0
    //   20: ifeq +181 -> 201
    //   23: aload_2
    //   24: invokeinterface 517 1 0
    //   29: checkcast 491	com/tencent/qqmail/account/model/Account
    //   32: astore_3
    //   33: invokestatic 504	com/tencent/qqmail/folderlist/QMFolderManager:sharedInstance	()Lcom/tencent/qqmail/folderlist/QMFolderManager;
    //   36: aload_3
    //   37: invokevirtual 520	com/tencent/qqmail/account/model/Account:getId	()I
    //   40: invokevirtual 896	com/tencent/qqmail/folderlist/QMFolderManager:getFoldersByAccountId	(I)Ljava/util/ArrayList;
    //   43: invokevirtual 769	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   46: astore 4
    //   48: aload 4
    //   50: invokeinterface 513 1 0
    //   55: ifeq -41 -> 14
    //   58: aload 4
    //   60: invokeinterface 517 1 0
    //   65: checkcast 133	com/tencent/qqmail/model/qmdomain/QMFolder
    //   68: astore 5
    //   70: aload 5
    //   72: invokevirtual 898	com/tencent/qqmail/model/qmdomain/QMFolder:hasNewMail	()Z
    //   75: ifeq +47 -> 122
    //   78: iconst_4
    //   79: ldc_w 411
    //   82: new 798	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 811	java/lang/StringBuilder:<init>	()V
    //   89: ldc_w 900
    //   92: invokevirtual 806	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_3
    //   96: invokevirtual 552	com/tencent/qqmail/account/model/Account:getEmail	()Ljava/lang/String;
    //   99: invokevirtual 806	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: ldc_w 902
    //   105: invokevirtual 806	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload 5
    //   110: invokevirtual 905	com/tencent/qqmail/model/qmdomain/QMFolder:getName	()Ljava/lang/String;
    //   113: invokevirtual 806	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 814	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 419	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   122: aload 5
    //   124: iconst_0
    //   125: invokevirtual 294	com/tencent/qqmail/model/qmdomain/QMFolder:setHasNewMail	(Z)V
    //   128: aload_0
    //   129: getfield 167	com/tencent/qqmail/model/mail/QMFolderSQLite:memoryStore	Lcom/tencent/qqmail/model/cache/QMFolderCache;
    //   132: aload 5
    //   134: invokevirtual 770	com/tencent/qqmail/model/qmdomain/QMFolder:getId	()I
    //   137: invokestatic 438	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   140: new 907	com/tencent/qqmail/model/mail/QMFolderSQLite$40
    //   143: dup
    //   144: aload_0
    //   145: invokespecial 908	com/tencent/qqmail/model/mail/QMFolderSQLite$40:<init>	(Lcom/tencent/qqmail/model/mail/QMFolderSQLite;)V
    //   148: new 910	com/tencent/qqmail/model/mail/QMFolderSQLite$41
    //   151: dup
    //   152: aload_0
    //   153: aload_1
    //   154: aload 5
    //   156: invokespecial 913	com/tencent/qqmail/model/mail/QMFolderSQLite$41:<init>	(Lcom/tencent/qqmail/model/mail/QMFolderSQLite;Lcom/tencent/moai/database/sqlite/SQLiteDatabase;Lcom/tencent/qqmail/model/qmdomain/QMFolder;)V
    //   159: invokevirtual 849	com/tencent/qqmail/model/cache/QMFolderCache:updateByKey	(Ljava/lang/Integer;Lcom/tencent/qqmail/model/cache/IReducer;Ljava/lang/Runnable;)V
    //   162: goto -114 -> 48
    //   165: astore_2
    //   166: iconst_5
    //   167: ldc_w 411
    //   170: new 798	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 811	java/lang/StringBuilder:<init>	()V
    //   177: ldc_w 915
    //   180: invokevirtual 806	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload_2
    //   184: invokevirtual 918	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   187: invokevirtual 806	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 814	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 419	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   196: aload_1
    //   197: invokevirtual 921	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   200: return
    //   201: aload_1
    //   202: ldc 55
    //   204: invokevirtual 408	com/tencent/moai/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   207: aload_1
    //   208: invokevirtual 924	com/tencent/moai/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   211: aload_1
    //   212: invokevirtual 921	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   215: return
    //   216: astore_2
    //   217: aload_1
    //   218: invokevirtual 921	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   221: aload_2
    //   222: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	QMFolderSQLite
    //   0	223	1	paramSQLiteDatabase	SQLiteDatabase
    //   13	11	2	localIterator1	Iterator
    //   165	19	2	localException	Exception
    //   216	6	2	localObject	Object
    //   32	64	3	localAccount	Account
    //   46	13	4	localIterator2	Iterator
    //   68	87	5	localQMFolder	QMFolder
    // Exception table:
    //   from	to	target	type
    //   4	14	165	java/lang/Exception
    //   14	48	165	java/lang/Exception
    //   48	122	165	java/lang/Exception
    //   122	162	165	java/lang/Exception
    //   201	211	165	java/lang/Exception
    //   4	14	216	finally
    //   14	48	216	finally
    //   48	122	216	finally
    //   122	162	216	finally
    //   166	196	216	finally
    //   201	211	216	finally
  }
  
  public void setFolderHasNew(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    this.memoryStore.updateByKey(Integer.valueOf(paramInt), new QMFolderSQLite.27(this), new QMFolderSQLite.28(this, paramSQLiteDatabase, paramInt));
  }
  
  public void setOverdue(SQLiteDatabase paramSQLiteDatabase, int paramInt, boolean paramBoolean)
  {
    setOverdue(paramSQLiteDatabase, new int[] { paramInt }, paramBoolean);
  }
  
  public void setOverdue(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt, boolean paramBoolean)
  {
    this.memoryStore.update(new QMFolderSQLite.33(this, paramBoolean, paramArrayOfInt), new QMFolderSQLite.34(this, paramBoolean, paramSQLiteDatabase, paramArrayOfInt));
  }
  
  public int subscribeConvUnread(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt)
  {
    if (!QMSettingManager.sharedInstance().getAggregateSubscribeMail()) {
      return 0;
    }
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT COUNT(DISTINCT id) FROM QM_MAIL_INFO WHERE accountId IN $accountIds$ AND attr&8192 AND isUnread=1".replace("$accountIds$", getInClause(paramArrayOfInt)), null);
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
      return Math.max(0, i);
      i = 0;
      break;
      i = 0;
    }
  }
  
  public int subscribeUnreadCountOffset(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    String str;
    if (QMSettingManager.sharedInstance().getAggregateSubscribeMail())
    {
      str = "SELECT COUNT(DISTINCT id) FROM QM_MAIL_INFO WHERE accountId IN $accountIds$ AND attr&8192 AND isUnread=1";
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(str.replace("$accountIds$", getInClause(new int[] { paramInt })), null);
      if (paramSQLiteDatabase == null) {
        break label75;
      }
      if (!paramSQLiteDatabase.moveToFirst()) {
        break label70;
      }
    }
    label70:
    for (paramInt = paramSQLiteDatabase.getInt(0);; paramInt = 0)
    {
      paramSQLiteDatabase.close();
      return paramInt;
      str = "SELECT cliUnreadCount FROM QM_FOLDER WHERE accountId IN $accountIds$ AND cliUnreadCount > 0 AND type=15";
      break;
    }
    label75:
    return 0;
  }
  
  public void updateAccountHasNew(SQLiteDatabase paramSQLiteDatabase, int paramInt, boolean paramBoolean)
  {
    this.memoryStore.update(new QMFolderSQLite.10(this, paramBoolean, paramInt), new QMFolderSQLite.11(this, paramBoolean, paramSQLiteDatabase, paramInt));
  }
  
  public void updateFolder(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.memoryStore.updateByKey(Integer.valueOf(paramInt1), new QMFolderSQLite.17(this, paramBoolean1, paramBoolean2, paramInt2, paramInt3), new QMFolderSQLite.18(this, paramBoolean2, paramBoolean1, paramInt2, paramInt3, paramSQLiteDatabase, paramInt1));
  }
  
  public void updateFolderDisplay(SQLiteDatabase paramSQLiteDatabase, int paramInt, boolean paramBoolean)
  {
    this.memoryStore.updateByKey(Integer.valueOf(paramInt), new QMFolderSQLite.31(this, paramBoolean), new QMFolderSQLite.32(this, paramBoolean, paramSQLiteDatabase, paramInt));
  }
  
  public void updateFolderFromTime(SQLiteDatabase paramSQLiteDatabase, int paramInt, boolean paramBoolean, long paramLong)
  {
    long l;
    if (paramBoolean)
    {
      l = paramLong;
      this.memoryStore.updateByKey(Integer.valueOf(paramInt), new QMFolderSQLite.35(this, l), new QMFolderSQLite.36(this, paramSQLiteDatabase, l, paramInt));
      return;
    }
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT MAX(utcSent) FROM QM_MAIL_INFO WHERE folderId =? AND attr&256", new String[] { paramInt + "" });
    if ((localCursor != null) && (localCursor.moveToNext())) {}
    for (paramLong = localCursor.getLong(0) / 1000L;; paramLong = 0L)
    {
      l = paramLong;
      if (localCursor == null) {
        break;
      }
      localCursor.close();
      l = paramLong;
      break;
    }
  }
  
  public void updateFolderPersonalCnt(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    this.memoryStore.updateByKey(Integer.valueOf(paramInt1), new QMFolderSQLite.21(this, paramInt2), new QMFolderSQLite.22(this, paramInt2, paramSQLiteDatabase, paramInt1));
  }
  
  public void updateFolderPushStatus(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt, boolean[] paramArrayOfBoolean)
  {
    if (paramArrayOfInt.length != paramArrayOfBoolean.length) {
      return;
    }
    paramSQLiteDatabase.beginTransactionNonExclusive();
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < paramArrayOfInt.length)
        {
          int k = paramArrayOfBoolean[i];
          this.memoryStore.selectByKey(Integer.valueOf(paramArrayOfInt[i]), new QMFolderSQLite.62(this, k));
          ContentValues localContentValues = new ContentValues();
          if (paramArrayOfBoolean[i] != 0)
          {
            j = 1;
            localContentValues.put("push", Integer.valueOf(j));
            paramSQLiteDatabase.update("QM_FOLDER", localContentValues, "id=?", new String[] { String.valueOf(paramArrayOfInt[i]) });
            i += 1;
          }
        }
        else
        {
          paramSQLiteDatabase.setTransactionSuccessful();
          return;
        }
      }
      catch (Exception paramArrayOfInt)
      {
        QMLog.log(6, "QMMailSQLite", "update folder push status err : " + paramArrayOfInt.toString());
        return;
      }
      finally
      {
        paramSQLiteDatabase.endTransaction();
      }
      int j = 0;
    }
  }
  
  public void updateFolderRemoteId(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString)
  {
    QMFolder localQMFolder = (QMFolder)this.memoryStore.get(Integer.valueOf(paramInt));
    int i = localQMFolder.getAccountId();
    if (localQMFolder.getType() == 14) {}
    for (boolean bool = true;; bool = false)
    {
      i = QMFolder.generateId(i, paramString, bool);
      localQMFolder.setRemoteId(paramString);
      localQMFolder.setId(i);
      this.memoryStore.deleteByKey(Integer.valueOf(paramInt));
      this.memoryStore.insert(Integer.valueOf(i), localQMFolder, new QMFolderSQLite.12(this, paramSQLiteDatabase, paramString, i, paramInt));
      return;
    }
  }
  
  public void updateFolderSequence(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    this.memoryStore.updateByKey(Integer.valueOf(paramInt1), new QMFolderSQLite.68(this, paramInt2), new QMFolderSQLite.69(this, paramSQLiteDatabase, paramInt2, paramInt1));
  }
  
  public void updateFolderSvrCount(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    this.memoryStore.updateByKey(Integer.valueOf(paramInt1), new QMFolderSQLite.19(this, paramInt2), new QMFolderSQLite.20(this, paramInt2, paramSQLiteDatabase, paramInt1));
  }
  
  public void updateFolderSyncKey(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString)
  {
    this.memoryStore.updateByKey(Integer.valueOf(paramInt), new QMFolderSQLite.13(this, paramString), new QMFolderSQLite.14(this, paramString, paramSQLiteDatabase, paramInt));
  }
  
  public void updateFolderSyncState(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString)
  {
    this.memoryStore.updateByKey(Integer.valueOf(paramInt), new QMFolderSQLite.15(this, paramString), new QMFolderSQLite.16(this, paramString, paramSQLiteDatabase, paramInt));
  }
  
  public void updateFolderType(SQLiteDatabase paramSQLiteDatabase, int paramInt1, String paramString, int paramInt2)
  {
    this.memoryStore.update(new QMFolderSQLite.6(this, paramInt2, paramString, paramInt1), new QMFolderSQLite.7(this, paramInt2, paramSQLiteDatabase, paramString, paramInt1));
  }
  
  public void updateFoldersSeq(SQLiteDatabase paramSQLiteDatabase, ArrayList<Integer> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    try
    {
      paramSQLiteDatabase.beginTransactionNonExclusive();
      paramArrayList = paramArrayList.iterator();
      int i = 0;
      while (paramArrayList.hasNext())
      {
        Integer localInteger = (Integer)paramArrayList.next();
        i += 1;
        this.memoryStore.updateByKey(localInteger, new QMFolderSQLite.66(this, i), new QMFolderSQLite.67(this, paramSQLiteDatabase, i, localInteger));
      }
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
    paramSQLiteDatabase.endTransaction();
  }
  
  public void updateLatestUnread(SQLiteDatabase paramSQLiteDatabase)
  {
    QMLog.log(4, "QMMailSQLite", "updateLatestUnread");
    paramSQLiteDatabase.execSQL("UPDATE QM_FOLDER SET cliLastcliUnreadCount=cliUnreadCount");
    paramSQLiteDatabase.execSQL("UPDATE QM_FOLDER SET cliLastConvUnreadCount=cliConvUnreadCount");
  }
  
  public void updateLocalMailUnreadCountIntoFolder(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt)
  {
    updateLocalMailUnreadCountIntoFolder(paramSQLiteDatabase, paramString, new int[] { paramInt });
    this.memoryStore.update(new QMFolderSQLite.70(this, paramSQLiteDatabase, paramInt));
  }
  
  public void updateLocalMailUnreadCountIntoFolder(SQLiteDatabase paramSQLiteDatabase, String paramString, int[] paramArrayOfInt)
  {
    paramSQLiteDatabase.execSQL(paramString.replace("$inClause$", getInClause(paramArrayOfInt)));
  }
  
  public void updateProtocolMailServerCountIntoFolder(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2, int paramInt3)
  {
    this.memoryStore.update(new QMFolderSQLite.71(this, paramInt3, paramInt2, paramInt1), new QMFolderSQLite.72(this, paramSQLiteDatabase, paramInt2, paramInt3, paramInt1));
  }
  
  public void updateQQFolderCounter(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2, int paramInt3)
  {
    this.memoryStore.updateByKey(Integer.valueOf(paramInt1), new QMFolderSQLite.8(this, paramInt2, paramInt3), new QMFolderSQLite.9(this, paramSQLiteDatabase, paramInt2, paramInt3, paramInt1));
  }
  
  public void updateSinceUTC(SQLiteDatabase paramSQLiteDatabase, int paramInt, long paramLong)
  {
    if (paramLong == 0L) {
      return;
    }
    this.memoryStore.updateByKey(Integer.valueOf(paramInt), new QMFolderSQLite.53(this, paramLong), new QMFolderSQLite.54(this, paramSQLiteDatabase, paramLong, paramInt));
  }
  
  public void updateSinceUTCByAccountId(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString)
  {
    if (paramString == null) {
      return;
    }
    long l = getSinceByRemoteId(paramSQLiteDatabase, paramString);
    this.memoryStore.update(new QMFolderSQLite.57(this, l, paramInt), new QMFolderSQLite.58(this, paramSQLiteDatabase, paramString, paramInt));
  }
  
  public void updateSinceUTCByFolderId(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.memoryStore.updateByKey(Integer.valueOf(paramInt), new QMFolderSQLite.55(this, paramSQLiteDatabase, paramString), new QMFolderSQLite.56(this, paramSQLiteDatabase, paramString, paramInt));
  }
  
  public void upgradeTableFor3001(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_FOLDER ADD COLUMN parentname VARCHAR");
  }
  
  public void upgradeTableFor3006(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_FOLDER ADD COLUMN fromtime INTEGER");
  }
  
  public void upgradeTableFor3007(SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject2 = new ArrayList();
    Object localObject1 = AccountManager.shareInstance().getAccountList().iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (Account)((Iterator)localObject1).next();
      if (!((Account)localObject3).isQQMail()) {
        ((ArrayList)localObject2).add(Integer.valueOf(((Account)localObject3).getId()));
      }
    }
    if (((ArrayList)localObject2).size() > 0)
    {
      localObject1 = new SparseArray();
      localObject2 = paramSQLiteDatabase.rawQuery("SELECT accountId,sequence FROM QM_FOLDER WHERE type=1 AND accountId IN " + getInClause((ArrayList)localObject2), null);
      if (localObject2 != null)
      {
        while (((Cursor)localObject2).moveToNext()) {
          ((SparseArray)localObject1).put(((Cursor)localObject2).getInt(((Cursor)localObject2).getColumnIndex("accountId")), Integer.valueOf(((Cursor)localObject2).getInt(((Cursor)localObject2).getColumnIndex("sequence"))));
        }
        ((Cursor)localObject2).close();
      }
      if (((SparseArray)localObject1).size() > 0)
      {
        int i = 0;
        while (i < ((SparseArray)localObject1).size())
        {
          paramSQLiteDatabase.execSQL("UPDATE QM_FOLDER SET sequence=sequence +1  WHERE sequence>? AND accountId=?", new Object[] { ((SparseArray)localObject1).get(((SparseArray)localObject1).keyAt(i)), Integer.valueOf(((SparseArray)localObject1).keyAt(i)) });
          i += 1;
        }
        i = 0;
        for (;;)
        {
          if (i < ((SparseArray)localObject1).size())
          {
            localObject2 = new QMFolder();
            ((QMFolder)localObject2).setAccountId(((SparseArray)localObject1).keyAt(i));
            ((QMFolder)localObject2).setSvrCount(-1);
            ((QMFolder)localObject2).setSvrUnreadCount(-1);
            ((QMFolder)localObject2).setRemoteId(QMApplicationContext.sharedInstance().getString(2131693924));
            localObject3 = QMApplicationContext.sharedInstance().getString(2131693924);
            ((QMFolder)localObject2).setRemoteId("_REMOTE_ID_" + QMMath.hashPositivetInt((String)localObject3));
            ((QMFolder)localObject2).setName((String)localObject3);
            ((QMFolder)localObject2).setSequence(((Integer)((SparseArray)localObject1).get(((SparseArray)localObject1).keyAt(i))).intValue() + 1);
            ((QMFolder)localObject2).setType(16);
            ((QMFolder)localObject2).setVirtual(true);
            int j = ((QMFolder)localObject2).getAccountId();
            localObject3 = ((QMFolder)localObject2).getRemoteId();
            boolean bool1;
            int k;
            int m;
            int n;
            int i1;
            int i2;
            int i3;
            int i4;
            int i5;
            boolean bool2;
            String str1;
            String str2;
            String str3;
            boolean bool3;
            boolean bool4;
            String str4;
            String str5;
            long l;
            if (((QMFolder)localObject2).getType() == 14)
            {
              bool1 = true;
              ((QMFolder)localObject2).setId(QMFolder.generateId(j, (String)localObject3, bool1));
              j = ((QMFolder)localObject2).getId();
              k = ((QMFolder)localObject2).getAccountId();
              localObject3 = ((QMFolder)localObject2).getRemoteId();
              m = ((QMFolder)localObject2).getParentId();
              n = ((QMFolder)localObject2).getType();
              i1 = ((QMFolder)localObject2).getSvrCount();
              i2 = ((QMFolder)localObject2).getSvrUnreadCount();
              i3 = ((QMFolder)localObject2).getCliUnreadCount();
              i4 = ((QMFolder)localObject2).getCliUnreadCount();
              i5 = ((QMFolder)localObject2).getSequence();
              bool1 = ((QMFolder)localObject2).isVirtual();
              bool2 = ((QMFolder)localObject2).isDisplay();
              str1 = ((QMFolder)localObject2).getName();
              str2 = ((QMFolder)localObject2).getPopId();
              str3 = ((QMFolder)localObject2).getPopEmail();
              bool3 = ((QMFolder)localObject2).isOverdue();
              bool4 = ((QMFolder)localObject2).isLocked();
              str4 = ((QMFolder)localObject2).getColorId();
              str5 = ((QMFolder)localObject2).getParentName();
              l = ((QMFolder)localObject2).getFromTime();
            }
            try
            {
              paramSQLiteDatabase.execSQL("REPLACE INTO QM_FOLDER (id,accountId,remoteId,parentId,type,svrCount,svrUnreadCount,cliUnreadCount,cliConvUnreadCount,sequence,isVirtual,isDisplay,name,popId,popEmail,overdue,locked,colorId,parentname,fromtime) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new Object[] { Integer.valueOf(j), Integer.valueOf(k), localObject3, Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(bool1), Boolean.valueOf(bool2), str1, str2, str3, Boolean.valueOf(bool3), Boolean.valueOf(bool4), str4, str5, Long.valueOf(l) });
              i += 1;
              continue;
              bool1 = false;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                QMLog.log(6, "QMMailSQLite", "insert folder err : " + localException.toString());
              }
            }
          }
        }
      }
    }
  }
  
  public void upgradeTableFor3014(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_FOLDER ADD COLUMN personalCount INTEGER");
  }
  
  public void upgradeTableFor5006(SQLiteDatabase paramSQLiteDatabase)
  {
    QMLog.log(4, "QMMailSQLite", "upgradeTableFor5006 ");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_FOLDER ADD COLUMN cliLastcliUnreadCount INTEGER");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_FOLDER ADD COLUMN cliLastConvUnreadCount INTEGER");
    updateLatestUnread(paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite
 * JD-Core Version:    0.7.0.1
 */