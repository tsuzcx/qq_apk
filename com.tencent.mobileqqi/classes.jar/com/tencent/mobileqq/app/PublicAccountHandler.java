package com.tencent.mobileqq.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.mp.mobileqq_mp.GetUserFollowListRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetUserFollowListResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import fex;
import fey;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import mqq.manager.ServerConfigManager.ConfigType;
import tencent.im.s2c.msgtype0x210.submsgtype0x28.SubMsgType0x28.FollowList;
import tencent.im.s2c.msgtype0x210.submsgtype0x28.SubMsgType0x28.RspFollowList;
import tencent.im.s2c.msgtype0x210.submsgtype0x28.SubMsgType0x28.RspTypeList;

public class PublicAccountHandler
  extends BusinessHandler
{
  private static final int jdField_a_of_type_Int = 20;
  public static final String a = "Pb_account_lifeservice";
  private static final int jdField_b_of_type_Int = 1;
  private static final String jdField_b_of_type_JavaLangString = PublicAccountHandler.class.getSimpleName();
  private static final int jdField_c_of_type_Int = 2;
  private static final String jdField_c_of_type_JavaLangString = "PublicAccount_TotalSwitch";
  private static final int jdField_d_of_type_Int = 1;
  private static final String jdField_d_of_type_JavaLangString = "PublicAccount_SearchSwitch";
  private static final int jdField_e_of_type_Int = 2;
  private static final String jdField_e_of_type_JavaLangString = "PublicAccountFollowSeq2";
  private static final int jdField_f_of_type_Int = 3;
  private static final String jdField_f_of_type_JavaLangString = "PublicAccountDataSeq2";
  private static final String g = "time_stamp";
  private static final String h = "get_user_follow_list_begin";
  private static final String i = "get_user_follow_list_follow_seq";
  private static final String j = "get_user_follow_list_data_seq";
  private static final String k = "get_user_follow_list_is_increment";
  public List a;
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  
  PublicAccountHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilList = null;
    this.c = true;
    String str = paramQQAppInterface.a(ServerConfigManager.ConfigType.common, "PublicAccount_TotalSwitch");
    if (str != null) {}
    try
    {
      this.jdField_a_of_type_Boolean = Boolean.parseBoolean(str);
      label37:
      paramQQAppInterface = paramQQAppInterface.a(ServerConfigManager.ConfigType.common, "PublicAccount_SearchSwitch");
      if (paramQQAppInterface != null) {}
      try
      {
        this.jdField_b_of_type_Boolean = Boolean.parseBoolean(paramQQAppInterface);
        return;
      }
      catch (Exception paramQQAppInterface) {}
    }
    catch (Exception localException)
    {
      break label37;
    }
  }
  
  private int a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, boolean paramBoolean)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "get_follow_list");
    mobileqq_mp.GetUserFollowListRequest localGetUserFollowListRequest = new mobileqq_mp.GetUserFollowListRequest();
    localGetUserFollowListRequest.follow_seqno.set(Utils.a(paramLong1));
    localGetUserFollowListRequest.public_account_seqno.set(Utils.a(paramLong2));
    localGetUserFollowListRequest.begin.set(Utils.a(paramLong3));
    localGetUserFollowListRequest.limit.set(Utils.a(paramLong4));
    localGetUserFollowListRequest.version.set(1);
    localGetUserFollowListRequest.is_increment.set(paramBoolean);
    localNewIntent.putExtra("data", localGetUserFollowListRequest.toByteArray());
    localNewIntent.putExtra("get_user_follow_list_begin", paramLong3);
    localNewIntent.putExtra("get_user_follow_list_follow_seq", paramLong1);
    localNewIntent.putExtra("get_user_follow_list_data_seq", paramLong2);
    localNewIntent.putExtra("time_stamp", paramLong5);
    localNewIntent.putExtra("get_user_follow_list_is_increment", paramBoolean);
    PublicAccountServlet.a(localNewIntent);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
    return 0;
  }
  
  private long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getLong("PublicAccountFollowSeq2", 0L);
  }
  
  private void a(long paramLong)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit();
    localEditor.putLong("PublicAccountFollowSeq2", paramLong);
    localEditor.commit();
  }
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    fey localfey = new fey();
    int n = 1;
    boolean bool2 = false;
    long l1;
    long l2;
    long l3;
    long l4;
    int m;
    boolean bool1;
    if ((paramIntent != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramArrayOfByte != null))
    {
      localfey.jdField_a_of_type_Int = 0;
      l1 = paramIntent.getLongExtra("time_stamp", 0L);
      l2 = paramIntent.getLongExtra("get_user_follow_list_begin", 0L);
      l3 = paramIntent.getLongExtra("get_user_follow_list_follow_seq", 0L);
      l4 = paramIntent.getLongExtra("get_user_follow_list_data_seq", 0L);
      bool2 = paramIntent.getBooleanExtra("get_user_follow_list_is_increment", true);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "<<---handleGetUserFollowList tiem: " + l1 + "begin: " + l2 + "preFollowSeq: " + l3 + "preDataSeq: " + l4);
      }
      for (;;)
      {
        try
        {
          paramIntent = new mobileqq_mp.GetUserFollowListResponse();
          paramIntent.mergeFrom(paramArrayOfByte);
          if ((!paramIntent.ret_info.has()) || (!((mobileqq_mp.RetInfo)paramIntent.ret_info.get()).ret_code.has())) {
            continue;
          }
          m = ((mobileqq_mp.RetInfo)paramIntent.ret_info.get()).ret_code.get();
          localfey.jdField_a_of_type_Int = m;
          if (m == 0) {
            continue;
          }
          localfey.jdField_a_of_type_Boolean = true;
          bool1 = false;
          m = 1;
        }
        catch (Exception paramIntent)
        {
          label274:
          label300:
          long l5;
          label367:
          localfey.jdField_a_of_type_Int = -1;
          localfey.jdField_a_of_type_Boolean = true;
          bool1 = false;
          m = 1;
          continue;
          a(l4);
          continue;
        }
        if (m != 0) {
          a(100, bool1, localfey);
        }
        return;
        m = 0;
        continue;
        if (!paramIntent.follow_seqno.has()) {
          break label646;
        }
        m = paramIntent.follow_seqno.get();
        l4 = Utils.a(m);
        if (!paramIntent.public_account_seqno.has()) {
          break label652;
        }
        m = paramIntent.public_account_seqno.get();
        l5 = Utils.a(m);
        if ((l4 > l3) && (l3 != 0L))
        {
          a(l4, l5, 0L, 20L, SystemClock.uptimeMillis(), false);
          m = 0;
          bool1 = false;
        }
        else
        {
          if (!paramIntent.total_count.has()) {
            break label664;
          }
          m = paramIntent.total_count.get();
          l3 = Utils.a(m);
          paramFromServiceMsg = PublicAccountInfo.createPublicAccountInfoList(paramIntent.info.get(), l1);
          localfey.jdField_a_of_type_JavaUtilList = paramFromServiceMsg;
          if (!paramIntent.has_next.has()) {
            break label658;
          }
          if (paramIntent.has_next.get()) {
            break label670;
          }
          break label658;
        }
      }
    }
    for (;;)
    {
      localfey.jdField_a_of_type_Boolean = bool1;
      localfey.jdField_a_of_type_Long = l3;
      paramIntent = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      a(paramFromServiceMsg, l1, bool2, localfey.jdField_a_of_type_Boolean);
      if (localfey.jdField_a_of_type_Boolean) {
        PubAccountAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent.a());
      }
      if (!localfey.jdField_a_of_type_Boolean)
      {
        if (bool2) {
          a(l4, l5, 0L, 20L, l1, true);
        }
        for (;;)
        {
          b(l5);
          bool1 = true;
          m = 1;
          break;
          a(l4, l5, l2 + 20L, 20L, l1, false);
        }
      }
      localfey.jdField_a_of_type_Int = -1;
      localfey.jdField_a_of_type_Boolean = true;
      bool1 = bool2;
      m = n;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_b_of_type_JavaLangString, 2, "<<---handleGetUserFollowList " + localfey.jdField_a_of_type_Int);
      bool1 = bool2;
      m = n;
      break;
      label646:
      m = 0;
      break label274;
      label652:
      m = 0;
      break label300;
      label658:
      bool1 = true;
      continue;
      label664:
      m = 0;
      break label367;
      label670:
      bool1 = false;
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    QQAppInterface localQQAppInterface = null;
    if ((paramAppInterface instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)paramAppInterface;
    }
    ReportController.b(localQQAppInterface, "P_CliOper", paramString2, "", paramString3, paramString4, 0, 0, paramString1, "", "", "");
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    QQAppInterface localQQAppInterface = null;
    if ((paramAppInterface instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)paramAppInterface;
    }
    ReportController.b(localQQAppInterface, "P_CliOper", paramString2, "", paramString3, paramString4, 0, 0, paramString1, paramString5, "", "");
  }
  
  private void a(List paramList, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(paramList, paramLong, paramBoolean1, paramBoolean2);
    paramList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localObject1 = ((List)localObject1).iterator();
    int m = 0;
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (PublicAccountInfo)((Iterator)localObject1).next();
      localObject2 = paramList.a().b(((PublicAccountInfo)localObject2).getUin(), 1008);
      if (localObject2 == null) {
        break label131;
      }
      paramList.a().b((RecentUser)localObject2);
      m = 1;
    }
    label131:
    for (;;)
    {
      break;
      paramList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
      if ((m != 0) && (paramList != null)) {
        paramList.sendEmptyMessage(1009);
      }
      return;
    }
  }
  
  private void a(SubMsgType0x28.RspFollowList paramRspFollowList)
  {
    paramRspFollowList = paramRspFollowList.rpt_msg_followlist.get();
    long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    paramRspFollowList = paramRspFollowList.iterator();
    int m = 0;
    if (paramRspFollowList.hasNext())
    {
      SubMsgType0x28.FollowList localFollowList = (SubMsgType0x28.FollowList)paramRspFollowList.next();
      String str;
      if (l == localFollowList.uint64_uin.get())
      {
        str = String.valueOf(localFollowList.uint64_puin.get());
        switch (localFollowList.uint32_type.get())
        {
        }
      }
      for (;;)
      {
        break;
        ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(str);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, 1008);
        m = 1;
        continue;
        a();
      }
    }
    if (m != 0) {
      a(103, true, null);
    }
  }
  
  private void a(SubMsgType0x28.RspTypeList paramRspTypeList) {}
  
  private long b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getLong("PublicAccountDataSeq2", 0L);
  }
  
  private void b(long paramLong)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit();
    localEditor.putLong("PublicAccountDataSeq2", paramLong);
    localEditor.commit();
  }
  
  public int a()
  {
    return a(a(), b(), 0L, 20L, SystemClock.uptimeMillis(), true);
  }
  
  protected Class a()
  {
    return PublicAccountObserver.class;
  }
  
  public void a()
  {
    this.c = false;
  }
  
  /* Error */
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: lload_1
    //   1: l2i
    //   2: lookupswitch	default:+26->28, 40:+27->29, 63:+93->95
    //   29: new 472	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody
    //   32: dup
    //   33: invokespecial 473	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody:<init>	()V
    //   36: aload_3
    //   37: invokevirtual 474	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   40: checkcast 472	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody
    //   43: astore_3
    //   44: aload_3
    //   45: getfield 477	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody:uint32_sub_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   48: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   51: istore 4
    //   53: iload 4
    //   55: iconst_1
    //   56: if_icmpne +18 -> 74
    //   59: aload_0
    //   60: aload_3
    //   61: getfield 481	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody:msg_rsp_followlist	Ltencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspFollowList;
    //   64: invokevirtual 482	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspFollowList:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   67: checkcast 415	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspFollowList
    //   70: invokespecial 484	com/tencent/mobileqq/app/PublicAccountHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspFollowList;)V
    //   73: return
    //   74: iload 4
    //   76: iconst_2
    //   77: if_icmpne -49 -> 28
    //   80: aload_0
    //   81: aload_3
    //   82: getfield 488	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody:msg_rsp_typelist	Ltencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspTypeList;
    //   85: invokevirtual 491	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspTypeList:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   88: checkcast 490	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspTypeList
    //   91: invokespecial 493	com/tencent/mobileqq/app/PublicAccountHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspTypeList;)V
    //   94: return
    //   95: new 495	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$MsgBody
    //   98: dup
    //   99: invokespecial 496	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$MsgBody:<init>	()V
    //   102: astore 7
    //   104: aload 7
    //   106: aload_3
    //   107: invokevirtual 497	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   110: pop
    //   111: aload 7
    //   113: getfield 500	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$MsgBody:rpt_msg_pubunikey	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   116: invokevirtual 309	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   119: invokeinterface 376 1 0
    //   124: astore_3
    //   125: aload_3
    //   126: invokeinterface 381 1 0
    //   131: ifeq -103 -> 28
    //   134: aload_3
    //   135: invokeinterface 385 1 0
    //   140: checkcast 502	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$PubUniKey
    //   143: astore 7
    //   145: aload 7
    //   147: getfield 505	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$PubUniKey:uint64_fromPubUin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   150: invokevirtual 436	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   153: lstore_1
    //   154: aload 7
    //   156: getfield 508	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$PubUniKey:uint64_qwMsgId	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   159: invokevirtual 436	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   162: lstore 5
    //   164: lload_1
    //   165: invokestatic 510	java/lang/Long:toString	(J)Ljava/lang/String;
    //   168: astore 7
    //   170: aload_0
    //   171: getfield 91	com/tencent/mobileqq/app/PublicAccountHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   174: invokevirtual 454	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   177: aload 7
    //   179: sipush 1008
    //   182: aconst_null
    //   183: invokevirtual 513	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;I[I)Ljava/util/List;
    //   186: invokeinterface 376 1 0
    //   191: astore 8
    //   193: aload 8
    //   195: invokeinterface 381 1 0
    //   200: ifeq -75 -> 125
    //   203: aload 8
    //   205: invokeinterface 385 1 0
    //   210: checkcast 515	com/tencent/mobileqq/data/MessageRecord
    //   213: astore 9
    //   215: aload 9
    //   217: invokestatic 520	com/tencent/mobileqq/activity/aio/XMLMessageUtils:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Lcom/tencent/mobileqq/data/PAMessage;
    //   220: astore 10
    //   222: aload 10
    //   224: ifnull -31 -> 193
    //   227: aload 10
    //   229: getfield 525	com/tencent/mobileqq/data/PAMessage:mMsgId	J
    //   232: lload 5
    //   234: lcmp
    //   235: ifne -42 -> 193
    //   238: aload_0
    //   239: getfield 91	com/tencent/mobileqq/app/PublicAccountHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   242: invokevirtual 454	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   245: aload 7
    //   247: sipush 1008
    //   250: aload 9
    //   252: getfield 528	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   255: invokevirtual 531	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;IJ)I
    //   258: pop
    //   259: goto -134 -> 125
    //   262: astore_3
    //   263: return
    //   264: astore_3
    //   265: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	this	PublicAccountHandler
    //   0	266	1	paramLong	long
    //   0	266	3	paramArrayOfByte	byte[]
    //   51	27	4	m	int
    //   162	71	5	l	long
    //   102	144	7	localObject	Object
    //   191	13	8	localIterator	Iterator
    //   213	38	9	localMessageRecord	com.tencent.mobileqq.data.MessageRecord
    //   220	8	10	localPAMessage	com.tencent.mobileqq.data.PAMessage
    // Exception table:
    //   from	to	target	type
    //   95	125	262	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   125	193	262	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   193	222	262	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   227	259	262	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   29	53	264	java/lang/Exception
    //   59	73	264	java/lang/Exception
    //   80	94	264	java/lang/Exception
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramIntent.getStringExtra("cmd");
    paramObject = (byte[])paramObject;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "<<---onReceive " + str);
    }
    if (str.equals("get_follow_list")) {
      a(paramIntent, paramFromServiceMsg, paramObject);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void a(Object paramObject)
  {
    fex localfex = new fex();
    localfex.jdField_a_of_type_Int = 0;
    long l = SystemClock.uptimeMillis();
    if ((paramObject instanceof AccountDetail)) {
      localfex.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = PublicAccountInfo.createPublicAccount((AccountDetail)paramObject, l);
    }
    for (;;)
    {
      paramObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      paramObject.a(localfex.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
      PubAccountAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject.a());
      a(101, true, localfex);
      return;
      if ((paramObject instanceof EqqDetail)) {
        localfex.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = PublicAccountInfo.createPublicAccount((EqqDetail)paramObject, l);
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(Object paramObject)
  {
    fex localfex = new fex();
    localfex.jdField_a_of_type_Int = 0;
    long l = SystemClock.uptimeMillis();
    if ((paramObject instanceof AccountDetail)) {
      localfex.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = PublicAccountInfo.createPublicAccount((AccountDetail)paramObject, l);
    }
    for (;;)
    {
      paramObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      paramObject.b(localfex.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
      PubAccountAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject.a());
      a(102, true, localfex);
      return;
      if ((paramObject instanceof EqqDetail)) {
        localfex.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = PublicAccountInfo.createPublicAccount((EqqDetail)paramObject, l);
      }
    }
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PublicAccountHandler
 * JD-Core Version:    0.7.0.1
 */