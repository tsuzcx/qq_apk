package com.tencent.qqmail.account;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteDatabase.CursorFactory;
import com.tencent.moai.database.sqlite.SQLiteDatabase.UpdateHook;
import com.tencent.qqmail.QMBaseSQLiteOpenHelper;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.model.mail.upgrade.ISQLIteDatabaseUpgrade;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgradeManager;
import com.tencent.qqmail.utilities.encryptionalgorithm.Aes;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.Date;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;

class QMAccountSQLiteHelper
  extends QMBaseSQLiteOpenHelper
{
  private static final String ACCOUNT_INFO_TABLE = "AccountInfo";
  private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS AccountInfo(id integer primary key,name varchar,email varchar,pwd varchar, fldpwd varchar,protocol integer,uin varchar,euin varchar,relmuin varchar,relsecondpwd varchar,profile varchar,activeSyncProfile varchar,smtpuname varchar,smtppwd varchar,qqpwd varchar,secpwd varchar,lockstate integer default 0,invalid integer,sequence integer,folerlistsynckey varchar default 0,attr integer default 0,accesstoken varchar,refreshtoken varchar,tokentype varchar,expirein integer default 0,idtoken varchar,lasttokentime integer,recordsynckey varchar,deviceid varchar)";
  protected static final String DBNAME = "AccountInfo";
  private static final String DROP_TABLE = "DROP TABLE IF EXISTS AccountInfo";
  private static final String FIELD_ACCESS_TOKEN = "accesstoken";
  private static final String FIELD_ACTIVE_SYNC_PROFILE = "activeSyncProfile";
  private static final String FIELD_ATTR = "attr";
  private static final String FIELD_DEVICD_ID = "deviceid";
  private static final String FIELD_EMAIL = "email";
  private static final String FIELD_ENCRYPTED_UIN = "euin";
  private static final String FIELD_EXPIRE_IN = "expirein";
  private static final String FIELD_FLD_PWD = "fldpwd";
  private static final String FIELD_FOLDER_LIST_SYNC_KEY = "folerlistsynckey";
  private static final String FIELD_ID = "id";
  private static final String FIELD_ID_TOKEN = "idtoken";
  private static final String FIELD_INVALID = "invalid";
  private static final String FIELD_LAST_TOKEN_TIME = "lasttokentime";
  private static final String FIELD_LOCK_STATE = "lockstate";
  private static final String FIELD_NAME = "name";
  private static final String FIELD_PROFILE = "profile";
  private static final String FIELD_PROTOCOL = "protocol";
  private static final String FIELD_PWD = "pwd";
  private static final String FIELD_QQ_PWD = "qqpwd";
  private static final String FIELD_RECORD_SYNC_KEY = "recordsynckey";
  private static final String FIELD_REFRESH_TOKEN = "refreshtoken";
  private static final String FIELD_REL_MASTER_UIN = "relmuin";
  private static final String FIELD_REL_PWD = "relsecondpwd";
  private static final String FIELD_SECOND_PWD = "secpwd";
  private static final String FIELD_SEQ = "sequence";
  private static final String FIELD_SMTP_PWD = "smtppwd";
  private static final String FIELD_SMTP_UNAME = "smtpuname";
  private static final String FIELD_TOKEN_TYPE = "tokentype";
  private static final String FIELD_UIN = "uin";
  private static final String QUERY_FOLDER_LIST_SYNCKEY_BY_ACCOUNTID = "SELECT folerlistsynckey FROM AccountInfo WHERE protocol=14 AND id=?";
  private static final String SAVE_ACCOUNT = "replace into AccountInfo (id, name, email, pwd, fldpwd, protocol, uin, euin, relmuin,relsecondpwd, profile, activeSyncProfile, smtpuname, smtppwd, qqpwd,secpwd,lockstate,invalid,sequence,folerlistsynckey,attr,accesstoken,refreshtoken,tokentype,expirein,idtoken,lasttokentime,recordsynckey,deviceid) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
  private static final String SELECT_ACCOUNTS = "SELECT * FROM AccountInfo ORDER BY sequence";
  private static final String SELECT_ACCOUNT_STATE = "SELECT invalid FROM AccountInfo WHERE id =?";
  private static final String SELECT_SYNC_KEY_MAP = "SELECT id,folerlistsynckey FROM AccountInfo WHERE protocol=14";
  private static final String TAG = "QMAccountSQLite";
  protected static final SQLiteDatabase.CursorFactory cursorFactory = null;
  protected static final QMAccountSQLiteDatabaseUpgradeManager upgradeManager = new QMAccountSQLiteDatabaseUpgradeManager(null);
  private final SQLiteDatabase.UpdateHook updateHook;
  
  public QMAccountSQLiteHelper(Context paramContext, @NonNull SQLiteDatabase.UpdateHook paramUpdateHook)
  {
    super(paramContext, "AccountInfo", cursorFactory, upgradeManager.getVersion());
    this.updateHook = paramUpdateHook;
  }
  
  private void createTable(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS AccountInfo(id integer primary key,name varchar,email varchar,pwd varchar, fldpwd varchar,protocol integer,uin varchar,euin varchar,relmuin varchar,relsecondpwd varchar,profile varchar,activeSyncProfile varchar,smtpuname varchar,smtppwd varchar,qqpwd varchar,secpwd varchar,lockstate integer default 0,invalid integer,sequence integer,folerlistsynckey varchar default 0,attr integer default 0,accesstoken varchar,refreshtoken varchar,tokentype varchar,expirein integer default 0,idtoken varchar,lasttokentime integer,recordsynckey varchar,deviceid varchar)");
  }
  
  private void dropTable(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS AccountInfo");
  }
  
  public boolean deleteAccount(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    try
    {
      paramSQLiteDatabase.delete("AccountInfo", "id=?", new String[] { String.valueOf(paramInt) });
      return true;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "QMAccountSQLite", "delete account " + paramInt + " error : " + paramSQLiteDatabase.toString());
    }
    return false;
  }
  
  public boolean[] getAccountAttr(SQLiteDatabase paramSQLiteDatabase, int paramInt, int[] paramArrayOfInt)
  {
    Object localObject = null;
    boolean[] arrayOfBoolean = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT attr FROM AccountInfo WHERE id = ?", new String[] { String.valueOf(paramInt) });
    if (localCursor != null) {
      paramSQLiteDatabase = localObject;
    }
    try
    {
      arrayOfBoolean = new boolean[paramArrayOfInt.length];
      paramSQLiteDatabase = arrayOfBoolean;
      if (localCursor.moveToFirst())
      {
        paramSQLiteDatabase = arrayOfBoolean;
        int j = localCursor.getInt(localCursor.getColumnIndex("attr"));
        int i = 0;
        paramSQLiteDatabase = arrayOfBoolean;
        if (i < paramArrayOfInt.length)
        {
          if ((paramArrayOfInt[i] & j) != 0) {}
          for (int k = 1;; k = 0)
          {
            arrayOfBoolean[i] = k;
            i += 1;
            break;
          }
        }
      }
      return arrayOfBoolean;
    }
    catch (Exception paramArrayOfInt)
    {
      QMLog.log(6, "QMAccountSQLite", "getAccountAttr:" + paramInt + ", error:" + paramArrayOfInt.toString());
      return paramSQLiteDatabase;
    }
    finally
    {
      localCursor.close();
    }
  }
  
  public int getAccountState(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT invalid FROM AccountInfo WHERE id =?", new String[] { String.valueOf(paramInt) });
    paramInt = 2;
    int i = paramInt;
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst()) {
        paramInt = paramSQLiteDatabase.getInt(0);
      }
      paramSQLiteDatabase.close();
      i = paramInt;
    }
    return i;
  }
  
  /* Error */
  public void getAccounts(SQLiteDatabase paramSQLiteDatabase, IGetAccount paramIGetAccount)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aload_1
    //   4: ldc 117
    //   6: aconst_null
    //   7: invokevirtual 214	com/tencent/moai/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnull +835 -> 847
    //   15: aload_1
    //   16: invokeinterface 242 1 0
    //   21: ifeq +826 -> 847
    //   24: aload_1
    //   25: aload_1
    //   26: ldc 51
    //   28: invokeinterface 224 2 0
    //   33: invokeinterface 228 2 0
    //   38: istore_3
    //   39: aload_1
    //   40: aload_1
    //   41: ldc 66
    //   43: invokeinterface 224 2 0
    //   48: invokeinterface 245 2 0
    //   53: astore 14
    //   55: aload_1
    //   56: aload_1
    //   57: ldc 36
    //   59: invokeinterface 224 2 0
    //   64: invokeinterface 245 2 0
    //   69: astore 15
    //   71: aload_1
    //   72: aload_1
    //   73: ldc 75
    //   75: invokeinterface 224 2 0
    //   80: invokeinterface 245 2 0
    //   85: astore 16
    //   87: aload_1
    //   88: aload_1
    //   89: ldc 45
    //   91: invokeinterface 224 2 0
    //   96: invokeinterface 245 2 0
    //   101: astore 17
    //   103: aload_1
    //   104: aload_1
    //   105: ldc 72
    //   107: invokeinterface 224 2 0
    //   112: invokeinterface 228 2 0
    //   117: istore 4
    //   119: aload_1
    //   120: aload_1
    //   121: ldc 108
    //   123: invokeinterface 224 2 0
    //   128: invokeinterface 245 2 0
    //   133: astore 18
    //   135: aload_1
    //   136: aload_1
    //   137: ldc 39
    //   139: invokeinterface 224 2 0
    //   144: invokeinterface 245 2 0
    //   149: astore 19
    //   151: aload_1
    //   152: aload_1
    //   153: ldc 87
    //   155: invokeinterface 224 2 0
    //   160: invokeinterface 245 2 0
    //   165: astore 12
    //   167: aload_1
    //   168: aload_1
    //   169: ldc 90
    //   171: invokeinterface 224 2 0
    //   176: invokeinterface 245 2 0
    //   181: astore 13
    //   183: aload_1
    //   184: aload_1
    //   185: ldc 69
    //   187: invokeinterface 224 2 0
    //   192: invokeinterface 245 2 0
    //   197: astore 20
    //   199: aload_1
    //   200: aload_1
    //   201: ldc 69
    //   203: invokeinterface 224 2 0
    //   208: invokeinterface 245 2 0
    //   213: astore 21
    //   215: aload_1
    //   216: aload_1
    //   217: ldc 102
    //   219: invokeinterface 224 2 0
    //   224: invokeinterface 245 2 0
    //   229: astore 22
    //   231: aload_1
    //   232: aload_1
    //   233: ldc 99
    //   235: invokeinterface 224 2 0
    //   240: invokeinterface 245 2 0
    //   245: astore 23
    //   247: aload_1
    //   248: aload_1
    //   249: ldc 63
    //   251: invokeinterface 224 2 0
    //   256: invokeinterface 228 2 0
    //   261: istore 5
    //   263: aload_1
    //   264: aload_1
    //   265: ldc 96
    //   267: invokeinterface 224 2 0
    //   272: invokeinterface 249 2 0
    //   277: lstore 7
    //   279: aload_1
    //   280: aload_1
    //   281: ldc 48
    //   283: invokeinterface 224 2 0
    //   288: invokeinterface 245 2 0
    //   293: astore 24
    //   295: aload_1
    //   296: aload_1
    //   297: ldc 93
    //   299: invokeinterface 224 2 0
    //   304: invokeinterface 245 2 0
    //   309: astore 25
    //   311: aload_1
    //   312: aload_1
    //   313: ldc 30
    //   315: invokeinterface 224 2 0
    //   320: invokeinterface 245 2 0
    //   325: astore 26
    //   327: aload_1
    //   328: aload_1
    //   329: ldc 78
    //   331: invokeinterface 224 2 0
    //   336: invokeinterface 245 2 0
    //   341: astore 27
    //   343: aload_1
    //   344: aload_1
    //   345: ldc 81
    //   347: invokeinterface 224 2 0
    //   352: invokeinterface 245 2 0
    //   357: astore 28
    //   359: aload_1
    //   360: aload_1
    //   361: ldc 33
    //   363: invokeinterface 224 2 0
    //   368: invokeinterface 245 2 0
    //   373: astore 29
    //   375: aload_1
    //   376: aload_1
    //   377: ldc 57
    //   379: invokeinterface 224 2 0
    //   384: invokeinterface 228 2 0
    //   389: istore 6
    //   391: iload 4
    //   393: tableswitch	default:+488 -> 881, 1:+423->816, 2:+423->816
    //   417: nop
    //   418: <illegal opcode>
    //   419: dup
    //   420: invokespecial 252	com/tencent/qqmail/account/model/MailAccount:<init>	()V
    //   423: astore 11
    //   425: aload 11
    //   427: iload_3
    //   428: invokevirtual 258	com/tencent/qqmail/account/model/Account:setId	(I)V
    //   431: aload 11
    //   433: aload 15
    //   435: invokevirtual 261	com/tencent/qqmail/account/model/Account:setEmail	(Ljava/lang/String;)V
    //   438: aload 11
    //   440: aload 14
    //   442: invokevirtual 264	com/tencent/qqmail/account/model/Account:setName	(Ljava/lang/String;)V
    //   445: aload 11
    //   447: iload 4
    //   449: invokevirtual 267	com/tencent/qqmail/account/model/Account:setProtocol	(I)V
    //   452: aload 11
    //   454: aload 16
    //   456: invokevirtual 270	com/tencent/qqmail/account/model/Account:setPwd	(Ljava/lang/String;)V
    //   459: aload 11
    //   461: aload 17
    //   463: invokevirtual 273	com/tencent/qqmail/account/model/Account:setEncryptedFolderPwd	(Ljava/lang/String;)V
    //   466: aload 11
    //   468: aload 18
    //   470: invokevirtual 276	com/tencent/qqmail/account/model/Account:setUin	(Ljava/lang/String;)V
    //   473: aload 11
    //   475: aload 19
    //   477: invokevirtual 279	com/tencent/qqmail/account/model/Account:setEncryptedUin	(Ljava/lang/String;)V
    //   480: aload 11
    //   482: iload 5
    //   484: invokevirtual 282	com/tencent/qqmail/account/model/Account:parseLockState	(I)V
    //   487: aload 11
    //   489: aload 20
    //   491: invokevirtual 285	com/tencent/qqmail/account/model/Account:setProfileString	(Ljava/lang/String;)V
    //   494: aload 11
    //   496: aload 21
    //   498: invokevirtual 288	com/tencent/qqmail/account/model/Account:setActiveSyncProfileString	(Ljava/lang/String;)V
    //   501: aload 11
    //   503: aload 22
    //   505: invokevirtual 291	com/tencent/qqmail/account/model/Account:setSmtpUserName	(Ljava/lang/String;)V
    //   508: aload 11
    //   510: aload 23
    //   512: invokevirtual 294	com/tencent/qqmail/account/model/Account:setSmtppwd	(Ljava/lang/String;)V
    //   515: aload 11
    //   517: lload 7
    //   519: invokevirtual 298	com/tencent/qqmail/account/model/Account:setSequence	(J)V
    //   522: aload 11
    //   524: aload 24
    //   526: invokevirtual 301	com/tencent/qqmail/account/model/Account:setFolderListSyncKey	(Ljava/lang/String;)V
    //   529: aload 11
    //   531: aload 25
    //   533: invokevirtual 304	com/tencent/qqmail/account/model/Account:setSecondPassword	(Ljava/lang/String;)V
    //   536: aload 11
    //   538: aload 26
    //   540: invokestatic 309	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   543: invokevirtual 312	com/tencent/qqmail/account/model/Account:setAttr	(I)V
    //   546: aload 11
    //   548: aload 27
    //   550: invokevirtual 315	com/tencent/qqmail/account/model/Account:setQqPassword	(Ljava/lang/String;)V
    //   553: aload 11
    //   555: aload 28
    //   557: invokevirtual 318	com/tencent/qqmail/account/model/Account:setRecordSyncKey	(Ljava/lang/String;)V
    //   560: aload 11
    //   562: iload 6
    //   564: invokevirtual 321	com/tencent/qqmail/account/model/Account:setAccountState	(I)V
    //   567: aload 11
    //   569: aload 29
    //   571: invokevirtual 324	com/tencent/qqmail/account/model/Account:setDeviceId	(Ljava/lang/String;)V
    //   574: iload 4
    //   576: iconst_1
    //   577: if_icmpeq +9 -> 586
    //   580: iload 4
    //   582: iconst_2
    //   583: if_icmpne +34 -> 617
    //   586: aload 11
    //   588: checkcast 326	com/tencent/qqmail/account/model/QQMailAccount
    //   591: astore 14
    //   593: aload 14
    //   595: invokevirtual 329	com/tencent/qqmail/account/model/QQMailAccount:restoreSidAndCookies	()V
    //   598: aload 14
    //   600: invokevirtual 332	com/tencent/qqmail/account/model/QQMailAccount:restoreAesKey	()V
    //   603: aload 14
    //   605: aload 12
    //   607: invokevirtual 335	com/tencent/qqmail/account/model/QQMailAccount:setMasterUin	(Ljava/lang/String;)V
    //   610: aload 14
    //   612: aload 13
    //   614: invokevirtual 338	com/tencent/qqmail/account/model/QQMailAccount:setRelpwd	(Ljava/lang/String;)V
    //   617: aload_1
    //   618: aload_1
    //   619: ldc 84
    //   621: invokeinterface 224 2 0
    //   626: invokeinterface 245 2 0
    //   631: astore 12
    //   633: aload 12
    //   635: invokestatic 344	com/tencent/qqmail/utilities/stringextention/StringExtention:isNullOrEmpty	(Ljava/lang/String;)Z
    //   638: ifne +125 -> 763
    //   641: aload_1
    //   642: aload_1
    //   643: ldc 24
    //   645: invokeinterface 224 2 0
    //   650: invokeinterface 245 2 0
    //   655: astore 13
    //   657: aload_1
    //   658: aload_1
    //   659: ldc 105
    //   661: invokeinterface 224 2 0
    //   666: invokeinterface 245 2 0
    //   671: astore 14
    //   673: aload_1
    //   674: aload_1
    //   675: ldc 42
    //   677: invokeinterface 224 2 0
    //   682: invokeinterface 249 2 0
    //   687: lstore 7
    //   689: aload_1
    //   690: aload_1
    //   691: ldc 54
    //   693: invokeinterface 224 2 0
    //   698: invokeinterface 245 2 0
    //   703: astore 15
    //   705: aload_1
    //   706: aload_1
    //   707: ldc 60
    //   709: invokeinterface 224 2 0
    //   714: invokeinterface 249 2 0
    //   719: lstore 9
    //   721: aload 11
    //   723: aload 13
    //   725: invokevirtual 347	com/tencent/qqmail/account/model/Account:setAccessToken	(Ljava/lang/String;)V
    //   728: aload 11
    //   730: aload 12
    //   732: invokevirtual 350	com/tencent/qqmail/account/model/Account:setRefreshToken	(Ljava/lang/String;)V
    //   735: aload 11
    //   737: aload 14
    //   739: invokevirtual 353	com/tencent/qqmail/account/model/Account:setTokenType	(Ljava/lang/String;)V
    //   742: aload 11
    //   744: lload 7
    //   746: invokevirtual 356	com/tencent/qqmail/account/model/Account:setExpireIn	(J)V
    //   749: aload 11
    //   751: aload 15
    //   753: invokevirtual 359	com/tencent/qqmail/account/model/Account:setIdToken	(Ljava/lang/String;)V
    //   756: aload 11
    //   758: lload 9
    //   760: invokevirtual 362	com/tencent/qqmail/account/model/Account:setLastTokenTime	(J)V
    //   763: aload_2
    //   764: aload 11
    //   766: invokeinterface 366 2 0
    //   771: goto -756 -> 15
    //   774: astore_2
    //   775: bipush 6
    //   777: ldc 126
    //   779: new 182	java/lang/StringBuilder
    //   782: dup
    //   783: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   786: ldc_w 368
    //   789: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: aload_2
    //   793: invokevirtual 199	java/lang/Exception:toString	()Ljava/lang/String;
    //   796: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   802: invokestatic 206	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   805: aload_1
    //   806: ifnull +9 -> 815
    //   809: aload_1
    //   810: invokeinterface 231 1 0
    //   815: return
    //   816: new 326	com/tencent/qqmail/account/model/QQMailAccount
    //   819: dup
    //   820: invokespecial 369	com/tencent/qqmail/account/model/QQMailAccount:<init>	()V
    //   823: astore 11
    //   825: goto -400 -> 425
    //   828: astore 11
    //   830: aload_1
    //   831: astore_2
    //   832: aload 11
    //   834: astore_1
    //   835: aload_2
    //   836: ifnull +9 -> 845
    //   839: aload_2
    //   840: invokeinterface 231 1 0
    //   845: aload_1
    //   846: athrow
    //   847: aload_1
    //   848: ifnull -33 -> 815
    //   851: aload_1
    //   852: invokeinterface 231 1 0
    //   857: return
    //   858: astore_1
    //   859: aconst_null
    //   860: astore_2
    //   861: goto -26 -> 835
    //   864: astore 11
    //   866: aload_1
    //   867: astore_2
    //   868: aload 11
    //   870: astore_1
    //   871: goto -36 -> 835
    //   874: astore_2
    //   875: aload 11
    //   877: astore_1
    //   878: goto -103 -> 775
    //   881: goto -465 -> 416
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	884	0	this	QMAccountSQLiteHelper
    //   0	884	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	884	2	paramIGetAccount	IGetAccount
    //   38	390	3	i	int
    //   117	467	4	j	int
    //   261	222	5	k	int
    //   389	174	6	m	int
    //   277	468	7	l1	long
    //   719	40	9	l2	long
    //   1	823	11	localObject1	Object
    //   828	5	11	localObject2	Object
    //   864	12	11	localObject3	Object
    //   165	566	12	str1	String
    //   181	543	13	str2	String
    //   53	685	14	localObject4	Object
    //   69	683	15	str3	String
    //   85	370	16	str4	String
    //   101	361	17	str5	String
    //   133	336	18	str6	String
    //   149	327	19	str7	String
    //   197	293	20	str8	String
    //   213	284	21	str9	String
    //   229	275	22	str10	String
    //   245	266	23	str11	String
    //   293	232	24	str12	String
    //   309	223	25	str13	String
    //   325	214	26	str14	String
    //   341	208	27	str15	String
    //   357	199	28	str16	String
    //   373	197	29	str17	String
    // Exception table:
    //   from	to	target	type
    //   15	391	774	java/lang/Exception
    //   416	425	774	java/lang/Exception
    //   425	574	774	java/lang/Exception
    //   586	617	774	java/lang/Exception
    //   617	763	774	java/lang/Exception
    //   763	771	774	java/lang/Exception
    //   816	825	774	java/lang/Exception
    //   15	391	828	finally
    //   416	425	828	finally
    //   425	574	828	finally
    //   586	617	828	finally
    //   617	763	828	finally
    //   763	771	828	finally
    //   816	825	828	finally
    //   3	11	858	finally
    //   775	805	864	finally
    //   3	11	874	java/lang/Exception
  }
  
  /* Error */
  public String getFolderListSyncKey(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 111
    //   3: iconst_1
    //   4: anewarray 172	java/lang/String
    //   7: dup
    //   8: iconst_0
    //   9: iload_2
    //   10: invokestatic 176	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   13: aastore
    //   14: invokevirtual 214	com/tencent/moai/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   17: astore_3
    //   18: aload_3
    //   19: ifnull +68 -> 87
    //   22: aload_3
    //   23: astore_1
    //   24: aload_3
    //   25: invokeinterface 242 1 0
    //   30: ifeq +57 -> 87
    //   33: aload_3
    //   34: astore_1
    //   35: aload_3
    //   36: iconst_0
    //   37: invokeinterface 245 2 0
    //   42: astore 5
    //   44: aload 5
    //   46: ifnull +23 -> 69
    //   49: aload 5
    //   51: astore 4
    //   53: aload_3
    //   54: astore_1
    //   55: aload 5
    //   57: invokestatic 377	org/apache/commons/lang3/StringUtils:trim	(Ljava/lang/String;)Ljava/lang/String;
    //   60: ldc_w 379
    //   63: invokevirtual 383	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   66: ifeq +8 -> 74
    //   69: ldc_w 385
    //   72: astore 4
    //   74: aload_3
    //   75: ifnull +9 -> 84
    //   78: aload_3
    //   79: invokeinterface 231 1 0
    //   84: aload 4
    //   86: areturn
    //   87: aload_3
    //   88: ifnull +9 -> 97
    //   91: aload_3
    //   92: invokeinterface 231 1 0
    //   97: aconst_null
    //   98: areturn
    //   99: astore 4
    //   101: aconst_null
    //   102: astore_3
    //   103: aload_3
    //   104: astore_1
    //   105: bipush 6
    //   107: ldc 126
    //   109: new 182	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   116: ldc_w 387
    //   119: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload 4
    //   124: invokevirtual 199	java/lang/Exception:toString	()Ljava/lang/String;
    //   127: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 206	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   136: aload_3
    //   137: ifnull -40 -> 97
    //   140: aload_3
    //   141: invokeinterface 231 1 0
    //   146: goto -49 -> 97
    //   149: astore_3
    //   150: aconst_null
    //   151: astore_1
    //   152: aload_1
    //   153: ifnull +9 -> 162
    //   156: aload_1
    //   157: invokeinterface 231 1 0
    //   162: aload_3
    //   163: athrow
    //   164: astore_3
    //   165: goto -13 -> 152
    //   168: astore 4
    //   170: goto -67 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	QMAccountSQLiteHelper
    //   0	173	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	173	2	paramInt	int
    //   17	124	3	localCursor	Cursor
    //   149	14	3	localObject1	Object
    //   164	1	3	localObject2	Object
    //   51	34	4	str1	String
    //   99	24	4	localException1	Exception
    //   168	1	4	localException2	Exception
    //   42	14	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   0	18	99	java/lang/Exception
    //   0	18	149	finally
    //   24	33	164	finally
    //   35	44	164	finally
    //   55	69	164	finally
    //   105	136	164	finally
    //   24	33	168	java/lang/Exception
    //   35	44	168	java/lang/Exception
    //   55	69	168	java/lang/Exception
  }
  
  public HashMap<Integer, String> getFolderListSyncKeyMap(SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject = null;
    SQLiteDatabase localSQLiteDatabase = null;
    HashMap localHashMap = new HashMap();
    label193:
    for (;;)
    {
      try
      {
        paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT id,folerlistsynckey FROM AccountInfo WHERE protocol=14", null);
        if (paramSQLiteDatabase != null)
        {
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          if (paramSQLiteDatabase.moveToNext())
          {
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            int i = paramSQLiteDatabase.getInt(0);
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            String str2 = paramSQLiteDatabase.getString(1);
            if (str2 == null) {
              break label193;
            }
            str1 = str2;
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            if (StringUtils.trim(str2).equals("")) {
              break label193;
            }
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            localHashMap.put(Integer.valueOf(i), str1);
            continue;
          }
        }
        String str1 = "0";
      }
      catch (Exception paramSQLiteDatabase)
      {
        localObject = localSQLiteDatabase;
        QMLog.log(6, "QMAccountSQLite", "get account syncKey error : " + paramSQLiteDatabase.toString());
        if (localSQLiteDatabase != null) {
          localSQLiteDatabase.close();
        }
        return localHashMap;
        if (paramSQLiteDatabase != null)
        {
          paramSQLiteDatabase.close();
          return localHashMap;
        }
      }
      finally
      {
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
      }
    }
  }
  
  public String getUpgradeLastVersion()
  {
    return upgradeManager.getLastVersion();
  }
  
  public void onConfigure(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onConfigure(paramSQLiteDatabase);
    paramSQLiteDatabase.addUpdateHook(this.updateHook);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    createTable(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    QMLog.log(4, "QMAccountSQLite", "try upgrade from " + paramInt1 + " to " + paramInt2 + ", minVer:" + upgradeManager.getMinSupportVersion());
    if (paramInt1 < upgradeManager.getMinSupportVersion())
    {
      dropTable(paramSQLiteDatabase);
      createTable(paramSQLiteDatabase);
      return;
    }
    if (upgradeManager.upgrade(this, paramSQLiteDatabase, paramInt1))
    {
      QMLog.log(4, "QMAccountSQLite", "upgrade from " + paramInt1 + " to " + paramInt2);
      return;
    }
    QMLog.log(4, "QMAccountSQLite", "no need upgrade from " + paramInt1 + " to " + paramInt2);
  }
  
  public boolean saveAccount(SQLiteDatabase paramSQLiteDatabase, Account paramAccount, long paramLong)
  {
    int i = paramAccount.getId();
    String str3 = paramAccount.getEmail();
    String str2 = "";
    String str1 = "";
    if (paramAccount.isQQMail())
    {
      str2 = ((QQMailAccount)paramAccount).getMasterUin();
      str1 = ((QQMailAccount)paramAccount).getRelpwd();
    }
    String str4 = paramAccount.getName();
    String str5 = paramAccount.getPwd();
    String str6 = paramAccount.getEncryptedFolderPwd();
    int j = paramAccount.getProtocol();
    String str7 = paramAccount.getUin();
    String str8 = paramAccount.getEncryptedUin();
    String str9 = paramAccount.getProfileString();
    String str10 = paramAccount.getActiveSyncProfileString();
    String str11 = paramAccount.getSmtpUserName();
    String str12 = paramAccount.getSmtppwd();
    String str13 = paramAccount.getQqPassword();
    String str14 = paramAccount.getSecondPassword();
    int k = paramAccount.getLockState();
    long l1 = paramLong;
    if (paramLong == 0L) {
      l1 = new Date().getTime();
    }
    String str15 = paramAccount.getFolderListSyncKey();
    int m = paramAccount.getAttr();
    String str16 = paramAccount.getAccessToken();
    String str17 = paramAccount.getRefreshToken();
    String str18 = paramAccount.getTokenType();
    paramLong = paramAccount.getExpireIn();
    String str19 = paramAccount.getIdToken();
    long l2 = paramAccount.getLastTokenTime();
    String str20 = paramAccount.getRecordSyncKey();
    paramAccount = paramAccount.getDeviceId();
    try
    {
      paramSQLiteDatabase.execSQL("replace into AccountInfo (id, name, email, pwd, fldpwd, protocol, uin, euin, relmuin,relsecondpwd, profile, activeSyncProfile, smtpuname, smtppwd, qqpwd,secpwd,lockstate,invalid,sequence,folerlistsynckey,attr,accesstoken,refreshtoken,tokentype,expirein,idtoken,lasttokentime,recordsynckey,deviceid) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", new Object[] { Integer.valueOf(i), str4, str3, str5, str6, Integer.valueOf(j), str7, str8, str2, str1, str9, str10, str11, str12, str13, str14, Integer.valueOf(k), Integer.valueOf(0), Long.valueOf(l1), str15, Integer.valueOf(m), str16, str17, str18, Long.valueOf(paramLong), str19, Long.valueOf(l2), str20, paramAccount });
      return true;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "QMAccountSQLite", "save account err: " + paramSQLiteDatabase.toString());
    }
    return false;
  }
  
  public boolean saveAccountState(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("invalid", Integer.valueOf(paramInt2));
      paramSQLiteDatabase.update("AccountInfo", localContentValues, "id=?", new String[] { String.valueOf(paramInt1) });
      QMLog.log(4, "QMAccountSQLite", "saveAccountState:" + paramInt1 + "account state:" + paramInt2 + ",AccountState");
      return true;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "QMAccountSQLite", "setAccountState : " + paramInt1 + ", state : " + paramInt2 + ", error : " + paramSQLiteDatabase.toString());
    }
    return false;
  }
  
  public void setAccountEncryptFolderPwd(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString)
  {
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("fldpwd", paramString);
      paramSQLiteDatabase.update("AccountInfo", localContentValues, "id=?", new String[] { String.valueOf(paramInt) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "set encrypt folder pwd", paramSQLiteDatabase.getMessage());
    }
  }
  
  public void setAccountLockState(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("lockstate", Integer.valueOf(paramInt2));
      paramSQLiteDatabase.update("AccountInfo", localContentValues, "id=?", new String[] { String.valueOf(paramInt1) });
      QMLog.log(4, "QMAccountSQLite", "setAccountLockState" + paramInt1);
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "QMAccountSQLite", "setAccountLockState : " + paramInt1 + " error : " + paramSQLiteDatabase.toString());
    }
  }
  
  public void updateAccessTokenInfo(SQLiteDatabase paramSQLiteDatabase, Account paramAccount)
  {
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("accesstoken", paramAccount.getAccessToken());
      localContentValues.put("refreshtoken", paramAccount.getRefreshToken());
      localContentValues.put("tokentype", paramAccount.getTokenType());
      localContentValues.put("expirein", Long.valueOf(paramAccount.getExpireIn()));
      localContentValues.put("idtoken", paramAccount.getIdToken());
      localContentValues.put("lasttokentime", Long.valueOf(paramAccount.getLastTokenTime()));
      paramSQLiteDatabase.update("AccountInfo", localContentValues, "id=?", new String[] { String.valueOf(paramAccount.getId()) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "QMAccountSQLite", "updateAccessTokenInfo error:" + paramSQLiteDatabase.toString());
    }
  }
  
  public void updateAccountAttr(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "UPDATE AccountInfo SET attr=attr|(" + paramInt2 + ") WHERE " + "id" + "=" + paramInt1;; str = "UPDATE AccountInfo SET attr=attr&(~" + paramInt2 + ") WHERE " + "id" + "=" + paramInt1)
    {
      paramSQLiteDatabase.execSQL(str);
      QMLog.log(4, "QMAccountSQLite", "updateAccountAttr:" + paramInt1 + "," + paramInt2 + "," + paramBoolean);
      return;
    }
  }
  
  public void updateFolderListSyncKey(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString)
  {
    for (;;)
    {
      try
      {
        ContentValues localContentValues = new ContentValues();
        if (paramString != null)
        {
          str = paramString;
          if (!"".equals(StringUtils.trim(paramString)))
          {
            localContentValues.put("folerlistsynckey", str);
            paramSQLiteDatabase.update("AccountInfo", localContentValues, "id=?", new String[] { String.valueOf(paramInt) });
            return;
          }
        }
      }
      catch (Exception paramSQLiteDatabase)
      {
        QMLog.log(6, "QMAccountSQLite", "update account syncKey error : " + paramSQLiteDatabase.toString());
        return;
      }
      String str = "0";
    }
  }
  
  public void updateOrder(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt)
  {
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("sequence", Integer.valueOf(i));
      paramSQLiteDatabase.update("AccountInfo", localContentValues, "id=?", new String[] { String.valueOf(paramArrayOfInt[i]) });
      i += 1;
    }
  }
  
  public void updateProfile(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      ContentValues localContentValues = new ContentValues();
      if ((paramString1 != null) && (!"".equals(paramString1))) {
        localContentValues.put("profile", paramString1);
      }
      if ((paramString2 != null) && (!"".equals(paramString2))) {
        localContentValues.put("activeSyncProfile", paramString2);
      }
      if ((paramString3 != null) && (!"".equals(paramString3))) {
        localContentValues.put("smtpuname", paramString3);
      }
      if ((paramString4 != null) && (!"".equals(paramString4))) {
        localContentValues.put("smtppwd", Aes.encode(paramString4, Aes.getPureDeviceToken()));
      }
      paramSQLiteDatabase.update("AccountInfo", localContentValues, "id=?", new String[] { String.valueOf(paramInt) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "QMAccountSQLite", "update account profile error : " + paramSQLiteDatabase.toString());
    }
  }
  
  public static abstract interface IGetAccount
  {
    public abstract void onItem(Account paramAccount);
  }
  
  static final class QMAccountSQLiteDatabaseUpgradeManager
    extends QMSQLiteDatabaseUpgradeManager
  {
    private final int MIN_VERSION = 0;
    private final int VERSION = 5;
    
    public SparseArray<ISQLIteDatabaseUpgrade> addVersions()
    {
      SparseArray localSparseArray = new SparseArray();
      addVersion(localSparseArray, new QMAccountSQLiteHelper.QMAccountSQLiteDatabaseUpgradeManager.1(this, this));
      addVersion(localSparseArray, new QMAccountSQLiteHelper.QMAccountSQLiteDatabaseUpgradeManager.2(this, this));
      addVersion(localSparseArray, new QMAccountSQLiteHelper.QMAccountSQLiteDatabaseUpgradeManager.3(this, this));
      addVersion(localSparseArray, new QMAccountSQLiteHelper.QMAccountSQLiteDatabaseUpgradeManager.4(this, this));
      addVersion(localSparseArray, new QMAccountSQLiteHelper.QMAccountSQLiteDatabaseUpgradeManager.5(this, this));
      return localSparseArray;
    }
    
    public int getMinVersion()
    {
      return 0;
    }
    
    public int getVersion()
    {
      return 5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.QMAccountSQLiteHelper
 * JD-Core Version:    0.7.0.1
 */