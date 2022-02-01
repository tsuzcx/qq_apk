package com.tencent.qqmail.namelist;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.model.MailManagerDefines;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.namelist.model.NameListContact;
import com.tencent.qqmail.namelist.model.NameListContact.NameListContactType;
import com.tencent.qqmail.network.filter.RequestFilter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.CGIManager;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.ArrayList;

public class NameListCGIManager
{
  private static final String JSON_BLACK_ADDR_LIST = "black_addr_list";
  private static final String JSON_BLACK_DOMAIN_LIST = "black_domain_list";
  private static final String JSON_SYNCKEY = "synckey";
  private static final String JSON_SYNCKEY_MATCH = "synckey_match";
  private static final String JSON_WHITE_ADDR_LIST = "white_addr_list";
  private static final String JSON_WHITE_DOMAIN_LIST = "white_domain_list";
  private static final String PARAM_FORCE = "force";
  private static final String PARAM_SYNCKEY = "synckey";
  private static final String PARAM_USER = "user";
  private static final String TAG = "NameListCGIManager";
  private QMMailSQLiteHelper sqliteHelper;
  
  public NameListCGIManager(QMMailSQLiteHelper paramQMMailSQLiteHelper)
  {
    this.sqliteHelper = paramQMMailSQLiteHelper;
  }
  
  /* Error */
  private void insertItemToNameList(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 42	com/tencent/qqmail/namelist/NameListCGIManager:sqliteHelper	Lcom/tencent/qqmail/model/mail/QMMailSQLiteHelper;
    //   4: invokevirtual 65	com/tencent/qqmail/model/mail/QMMailSQLiteHelper:getWritableDatabase	()Lcom/tencent/moai/database/sqlite/SQLiteDatabase;
    //   7: astore 4
    //   9: aload 4
    //   11: invokevirtual 70	com/tencent/moai/database/sqlite/SQLiteDatabase:beginTransactionNonExclusive	()V
    //   14: new 72	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 73	java/util/ArrayList:<init>	()V
    //   21: astore 5
    //   23: new 75	com/tencent/qqmail/namelist/model/NameListContact
    //   26: dup
    //   27: invokespecial 76	com/tencent/qqmail/namelist/model/NameListContact:<init>	()V
    //   30: astore 6
    //   32: aload 6
    //   34: aload_1
    //   35: invokevirtual 80	com/tencent/qqmail/namelist/model/NameListContact:setEmail	(Ljava/lang/String;)V
    //   38: aload 6
    //   40: iload_2
    //   41: invokevirtual 84	com/tencent/qqmail/namelist/model/NameListContact:setType	(I)V
    //   44: aload 6
    //   46: iconst_1
    //   47: invokevirtual 88	com/tencent/qqmail/namelist/model/NameListContact:setIsQQ	(Z)V
    //   50: aload 6
    //   52: iload_3
    //   53: invokevirtual 91	com/tencent/qqmail/namelist/model/NameListContact:setAccountId	(I)V
    //   56: aload 6
    //   58: iload_3
    //   59: aload 6
    //   61: invokevirtual 95	com/tencent/qqmail/namelist/model/NameListContact:getEmail	()Ljava/lang/String;
    //   64: invokestatic 99	com/tencent/qqmail/namelist/model/NameListContact:generateId	(ILjava/lang/String;)J
    //   67: invokevirtual 103	com/tencent/qqmail/namelist/model/NameListContact:setId	(J)V
    //   70: aload 5
    //   72: aload 6
    //   74: invokevirtual 107	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   77: pop
    //   78: aload_0
    //   79: getfield 42	com/tencent/qqmail/namelist/NameListCGIManager:sqliteHelper	Lcom/tencent/qqmail/model/mail/QMMailSQLiteHelper;
    //   82: getfield 111	com/tencent/qqmail/model/mail/QMMailSQLiteHelper:nameList	Lcom/tencent/qqmail/namelist/NameListSQLite;
    //   85: aload 4
    //   87: aload 5
    //   89: invokevirtual 117	com/tencent/qqmail/namelist/NameListSQLite:insertNameListContact	(Lcom/tencent/moai/database/sqlite/SQLiteDatabase;Ljava/util/ArrayList;)V
    //   92: aload 4
    //   94: invokevirtual 120	com/tencent/moai/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   97: aload 4
    //   99: invokevirtual 123	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   102: return
    //   103: astore_1
    //   104: bipush 6
    //   106: ldc 33
    //   108: new 125	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   115: ldc 128
    //   117: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_1
    //   121: invokevirtual 135	java/lang/Exception:toString	()Ljava/lang/String;
    //   124: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 142	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   133: aload 4
    //   135: invokevirtual 123	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   138: return
    //   139: astore_1
    //   140: bipush 6
    //   142: ldc 33
    //   144: new 125	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   151: ldc 144
    //   153: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_1
    //   157: invokevirtual 135	java/lang/Exception:toString	()Ljava/lang/String;
    //   160: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 142	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   169: return
    //   170: astore_1
    //   171: aload 4
    //   173: invokevirtual 123	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   176: aload_1
    //   177: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	NameListCGIManager
    //   0	178	1	paramString	String
    //   0	178	2	paramInt1	int
    //   0	178	3	paramInt2	int
    //   7	165	4	localSQLiteDatabase	SQLiteDatabase
    //   21	67	5	localArrayList	ArrayList
    //   30	43	6	localNameListContact	NameListContact
    // Exception table:
    //   from	to	target	type
    //   9	97	103	java/lang/Exception
    //   97	102	139	java/lang/Exception
    //   133	138	139	java/lang/Exception
    //   171	178	139	java/lang/Exception
    //   9	97	170	finally
    //   104	133	170	finally
  }
  
  private void parseNameLists(SQLiteDatabase paramSQLiteDatabase, int paramInt, JSONObject paramJSONObject, NameListContact.NameListContactType paramNameListContactType)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONObject.containsKey("items"))
    {
      paramJSONObject = (JSONArray)paramJSONObject.get("items");
      int i = 0;
      while (i < paramJSONObject.size())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        NameListContact localNameListContact = new NameListContact();
        localNameListContact.parseWithDictionary(localJSONObject);
        localNameListContact.setType(paramNameListContactType.ordinal());
        localNameListContact.setIsQQ(true);
        localNameListContact.setAccountId(paramInt);
        localNameListContact.setId(NameListContact.generateId(paramInt, localNameListContact.getEmail()));
        localArrayList.add(localNameListContact);
        i += 1;
      }
      this.sqliteHelper.nameList.insertNameListContact(paramSQLiteDatabase, localArrayList);
    }
  }
  
  public void addNameList(int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    if (paramInt2 == NameListContact.NameListContactType.BLACK.ordinal()) {}
    for (StringBuilder localStringBuilder = new StringBuilder(MailManagerDefines.PARAM_PREFIX_BLACK_WHITE_LIST_ADD_BLACK);; localStringBuilder = new StringBuilder(MailManagerDefines.PARAM_PREFIX_BLACK_WHITE_LIST_ADD_WHITE))
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(StringExtention.replaceWithEncodeURIValue("&user=$user$", "user", paramArrayOfString[i]));
        i += 1;
      }
    }
    localStringBuilder.append(StringExtention.replaceWithEncodeURIValue("&force=$force$&", "force", "1"));
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new NameListCGIManager.3(this, paramInt2, paramArrayOfString, paramInt1));
    localQMCallback.setOnError(new NameListCGIManager.4(this, paramInt2, paramInt1, paramArrayOfString));
    CGIManager.httpPost(paramInt1, "config_blackwhitelist", localStringBuilder.toString(), localQMCallback);
  }
  
  public void deleteNameList(int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    if (paramInt2 == NameListContact.NameListContactType.BLACK.ordinal()) {}
    for (StringBuilder localStringBuilder = new StringBuilder(MailManagerDefines.PARAM_PREFIX_BLACK_WHITE_LIST_DEL_BLACK);; localStringBuilder = new StringBuilder(MailManagerDefines.PARAM_PREFIX_BLACK_WHITE_LIST_DEL_WHITE))
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(StringExtention.replaceWithEncodeURIValue("&user=$user$", "user", paramArrayOfString[i]));
        i += 1;
      }
    }
    localStringBuilder.append(StringExtention.replaceWithEncodeURIValue("&force=$force$&", "force", "1"));
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new NameListCGIManager.5(this, paramInt2, paramInt1, paramArrayOfString));
    localQMCallback.setOnError(new NameListCGIManager.6(this, paramInt2, paramInt1, paramArrayOfString));
    CGIManager.httpPost(paramInt1, "config_blackwhitelist", localStringBuilder.toString(), localQMCallback);
  }
  
  public void loadNameList(int paramInt)
  {
    String str = "load_name_list" + paramInt;
    if (RequestFilter.isRequestOnRunning(str)) {
      return;
    }
    RequestFilter.setRequestRunningState(str);
    StringBuilder localStringBuilder = new StringBuilder(MailManagerDefines.PARAM_PREFIX_BLACK_WHITE_LIST);
    Object localObject = QMSettingManager.sharedInstance().getNameListSyncKey(paramInt);
    if (!StringExtention.isNullOrEmpty((String)localObject)) {
      localStringBuilder.append(StringExtention.replaceWithEncodeURIValue("&synckey=$synckey$", "synckey", (String)localObject));
    }
    QMLog.log(3, "NameListCGIManager", "loadNameList accountId:" + paramInt + " params" + localStringBuilder.toString());
    localObject = new QMCallback();
    ((QMCallback)localObject).setOnSuccess(new NameListCGIManager.1(this, str, paramInt));
    ((QMCallback)localObject).setOnError(new NameListCGIManager.2(this, str, paramInt));
    CGIManager.httpPost(paramInt, "config_blackwhitelist", localStringBuilder.toString(), (QMCallback)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.NameListCGIManager
 * JD-Core Version:    0.7.0.1
 */