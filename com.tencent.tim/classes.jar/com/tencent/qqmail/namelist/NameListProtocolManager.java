package com.tencent.qqmail.namelist;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.namelist.model.NameListContact;
import com.tencent.qqmail.namelist.model.NameListContact.NameListContactType;
import com.tencent.qqmail.protobuf.ByteString;
import com.tencent.qqmail.protocol.CloudProtocolHelper;
import com.tencent.qqmail.protocol.CloudProtocolInfo;
import com.tencent.qqmail.protocol.CloudProtocolService;
import com.tencent.qqmail.protocol.UMA.ADBWUserInfo;
import com.tencent.qqmail.protocol.UMA.CmdAddADBWContactReq;
import com.tencent.qqmail.protocol.UMA.CmdDelADBWContactReq;
import com.tencent.qqmail.protocol.UMA.CmdLstADBWContactReq;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class NameListProtocolManager
{
  private static int ADBWUSERINFO_FUN_AD = 1;
  private static int ADBWUSERINFO_FUN_BLACKWHITELIST = 2;
  private static int ADBWUSERINFO_TYPE_BIZ = 0;
  private static int ADBWUSERINFO_TYPE_PROTOCOL = 0;
  private static int ADBWUSERINFO_TYPE_QQ = 1;
  private static final String TAG = "NameListProtocolManager";
  private QMMailSQLiteHelper sqliteHelper;
  
  static
  {
    ADBWUSERINFO_TYPE_BIZ = 2;
    ADBWUSERINFO_TYPE_PROTOCOL = 3;
  }
  
  public NameListProtocolManager(QMMailSQLiteHelper paramQMMailSQLiteHelper)
  {
    this.sqliteHelper = paramQMMailSQLiteHelper;
  }
  
  /* Error */
  private void insertItemToNameList(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 36	com/tencent/qqmail/namelist/NameListProtocolManager:sqliteHelper	Lcom/tencent/qqmail/model/mail/QMMailSQLiteHelper;
    //   4: invokevirtual 52	com/tencent/qqmail/model/mail/QMMailSQLiteHelper:getWritableDatabase	()Lcom/tencent/moai/database/sqlite/SQLiteDatabase;
    //   7: astore 4
    //   9: aload 4
    //   11: invokevirtual 57	com/tencent/moai/database/sqlite/SQLiteDatabase:beginTransactionNonExclusive	()V
    //   14: new 59	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 60	java/util/ArrayList:<init>	()V
    //   21: astore 5
    //   23: new 62	com/tencent/qqmail/namelist/model/NameListContact
    //   26: dup
    //   27: invokespecial 63	com/tencent/qqmail/namelist/model/NameListContact:<init>	()V
    //   30: astore 6
    //   32: aload 6
    //   34: aload_1
    //   35: invokevirtual 67	com/tencent/qqmail/namelist/model/NameListContact:setEmail	(Ljava/lang/String;)V
    //   38: aload 6
    //   40: iload_2
    //   41: invokevirtual 71	com/tencent/qqmail/namelist/model/NameListContact:setType	(I)V
    //   44: aload 6
    //   46: iconst_0
    //   47: invokevirtual 75	com/tencent/qqmail/namelist/model/NameListContact:setIsQQ	(Z)V
    //   50: aload 6
    //   52: iload_3
    //   53: invokevirtual 78	com/tencent/qqmail/namelist/model/NameListContact:setAccountId	(I)V
    //   56: aload 6
    //   58: iload_3
    //   59: aload 6
    //   61: invokevirtual 82	com/tencent/qqmail/namelist/model/NameListContact:getEmail	()Ljava/lang/String;
    //   64: invokestatic 86	com/tencent/qqmail/namelist/model/NameListContact:generateId	(ILjava/lang/String;)J
    //   67: invokevirtual 90	com/tencent/qqmail/namelist/model/NameListContact:setId	(J)V
    //   70: aload 5
    //   72: aload 6
    //   74: invokevirtual 94	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   77: pop
    //   78: aload_0
    //   79: getfield 36	com/tencent/qqmail/namelist/NameListProtocolManager:sqliteHelper	Lcom/tencent/qqmail/model/mail/QMMailSQLiteHelper;
    //   82: getfield 98	com/tencent/qqmail/model/mail/QMMailSQLiteHelper:nameList	Lcom/tencent/qqmail/namelist/NameListSQLite;
    //   85: aload 4
    //   87: aload 5
    //   89: invokevirtual 104	com/tencent/qqmail/namelist/NameListSQLite:insertNameListContact	(Lcom/tencent/moai/database/sqlite/SQLiteDatabase;Ljava/util/ArrayList;)V
    //   92: aload 4
    //   94: invokevirtual 107	com/tencent/moai/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   97: aload 4
    //   99: invokevirtual 110	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   102: return
    //   103: astore_1
    //   104: bipush 6
    //   106: ldc 15
    //   108: new 112	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   115: ldc 115
    //   117: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_1
    //   121: invokevirtual 122	java/lang/Exception:toString	()Ljava/lang/String;
    //   124: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 129	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   133: aload 4
    //   135: invokevirtual 110	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   138: return
    //   139: astore_1
    //   140: bipush 6
    //   142: ldc 15
    //   144: new 112	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   151: ldc 131
    //   153: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_1
    //   157: invokevirtual 122	java/lang/Exception:toString	()Ljava/lang/String;
    //   160: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 129	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   169: return
    //   170: astore_1
    //   171: aload 4
    //   173: invokevirtual 110	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   176: aload_1
    //   177: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	NameListProtocolManager
    //   0	178	1	paramString	String
    //   0	178	2	paramInt1	int
    //   0	178	3	paramInt2	int
    //   7	165	4	localSQLiteDatabase	com.tencent.moai.database.sqlite.SQLiteDatabase
    //   21	67	5	localArrayList	java.util.ArrayList
    //   30	43	6	localNameListContact	NameListContact
    // Exception table:
    //   from	to	target	type
    //   9	97	103	java/lang/Exception
    //   0	9	139	java/lang/Exception
    //   97	102	139	java/lang/Exception
    //   133	138	139	java/lang/Exception
    //   171	178	139	java/lang/Exception
    //   9	97	170	finally
    //   104	133	170	finally
  }
  
  public void addProtocolNameList(int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    Object localObject2 = AccountManager.shareInstance().getAccountList().getAccountById(paramInt1);
    CloudProtocolInfo localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
    if (localCloudProtocolInfo == null)
    {
      QMLog.log(6, "NameListProtocolManager", "syncNameList info null");
      return;
    }
    Object localObject1 = new ADBWUserInfo();
    if (!StringExtention.isNullOrEmpty(((Account)localObject2).getUin())) {
      ((ADBWUserInfo)localObject1).uin = Integer.parseInt(((Account)localObject2).getUin());
    }
    ((ADBWUserInfo)localObject1).email = ByteString.copyFromUtf8(((Account)localObject2).getEmail());
    ((ADBWUserInfo)localObject1).type = ADBWUSERINFO_TYPE_PROTOCOL;
    ((ADBWUserInfo)localObject1).func = ADBWUSERINFO_FUN_BLACKWHITELIST;
    localObject2 = new CmdAddADBWContactReq();
    ((CmdAddADBWContactReq)localObject2).user = ((ADBWUserInfo)localObject1);
    if (paramInt2 == NameListContact.NameListContactType.BLACK.ordinal()) {}
    for (boolean bool = true;; bool = false)
    {
      ((CmdAddADBWContactReq)localObject2).is_black = bool;
      localObject1 = new LinkedList();
      Collections.addAll((Collection)localObject1, paramArrayOfString);
      ((CmdAddADBWContactReq)localObject2).email = ((LinkedList)localObject1);
      localCloudProtocolInfo.add_bw_contact_req_ = ((CmdAddADBWContactReq)localObject2);
      CloudProtocolService.AddADBWContact(localCloudProtocolInfo, new NameListProtocolManager.2(this, paramArrayOfString, paramInt1, paramInt2));
      return;
    }
  }
  
  public void deleteProtocolNameList(int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    Object localObject2 = AccountManager.shareInstance().getAccountList().getAccountById(paramInt1);
    CloudProtocolInfo localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
    if (localCloudProtocolInfo == null)
    {
      QMLog.log(6, "NameListProtocolManager", "syncNameList info null");
      return;
    }
    Object localObject1 = new ADBWUserInfo();
    if (!StringExtention.isNullOrEmpty(((Account)localObject2).getUin())) {
      ((ADBWUserInfo)localObject1).uin = Integer.parseInt(((Account)localObject2).getUin());
    }
    ((ADBWUserInfo)localObject1).email = ByteString.copyFromUtf8(((Account)localObject2).getEmail());
    ((ADBWUserInfo)localObject1).type = ADBWUSERINFO_TYPE_PROTOCOL;
    ((ADBWUserInfo)localObject1).func = ADBWUSERINFO_FUN_BLACKWHITELIST;
    localObject2 = new CmdDelADBWContactReq();
    ((CmdDelADBWContactReq)localObject2).user = ((ADBWUserInfo)localObject1);
    if (paramInt2 == NameListContact.NameListContactType.BLACK.ordinal()) {}
    for (((CmdDelADBWContactReq)localObject2).type = 1;; ((CmdDelADBWContactReq)localObject2).type = 2)
    {
      localObject1 = new LinkedList();
      Collections.addAll((Collection)localObject1, paramArrayOfString);
      ((CmdDelADBWContactReq)localObject2).email = ((LinkedList)localObject1);
      localCloudProtocolInfo.del_bw_contact_req_ = ((CmdDelADBWContactReq)localObject2);
      CloudProtocolService.DelADBWContact(localCloudProtocolInfo, new NameListProtocolManager.3(this, paramInt1, paramArrayOfString, paramInt2));
      return;
    }
  }
  
  public void loadProtocolNameList(int paramInt)
  {
    Object localObject = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    CloudProtocolInfo localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
    if (localCloudProtocolInfo == null)
    {
      QMLog.log(6, "NameListProtocolManager", "syncNameList info null");
      return;
    }
    ADBWUserInfo localADBWUserInfo = new ADBWUserInfo();
    if (!StringExtention.isNullOrEmpty(((Account)localObject).getUin())) {
      localADBWUserInfo.uin = Integer.parseInt(((Account)localObject).getUin());
    }
    localADBWUserInfo.email = ByteString.copyFromUtf8(((Account)localObject).getEmail());
    localADBWUserInfo.type = ADBWUSERINFO_TYPE_PROTOCOL;
    localADBWUserInfo.func = ADBWUSERINFO_FUN_BLACKWHITELIST;
    localObject = new CmdLstADBWContactReq();
    ((CmdLstADBWContactReq)localObject).user = localADBWUserInfo;
    localCloudProtocolInfo.lst_bw_contact_req_ = ((CmdLstADBWContactReq)localObject);
    CloudProtocolService.LstADBWContact(localCloudProtocolInfo, new NameListProtocolManager.1(this, paramInt));
  }
  
  public NameListContact transformProtocolContactToNameListContact(int paramInt1, String paramString, int paramInt2)
  {
    NameListContact localNameListContact = new NameListContact();
    localNameListContact.setEmail(paramString);
    localNameListContact.setType(paramInt2);
    localNameListContact.setIsQQ(false);
    localNameListContact.setAccountId(paramInt1);
    localNameListContact.setId(NameListContact.generateId(paramInt1, localNameListContact.getEmail()));
    return localNameListContact;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.NameListProtocolManager
 * JD-Core Version:    0.7.0.1
 */