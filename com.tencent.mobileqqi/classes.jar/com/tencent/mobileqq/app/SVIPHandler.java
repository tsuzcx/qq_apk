package com.tencent.mobileqq.app;

import QQService.EVIPSPEC;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.bubbleupdate.BubbleUpdatePB.ReqUpdate;
import com.tencent.pb.bubbleupdate.BubbleUpdatePB.ReqUpdateData;
import com.tencent.pb.bubbleupdate.BubbleUpdatePB.ReqUpdateTable;
import com.tencent.pb.bubbleupdate.BubbleUpdatePB.RspUpdate;
import com.tencent.pb.bubbleupdate.BubbleUpdatePB.RspUpdateData;
import com.tencent.pb.bubbleupdate.BubbleUpdatePB.RspUpdateTable;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import fge;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SVIPHandler
  extends BusinessHandler
{
  public static final int a = 100;
  protected static final long a = 5000L;
  static final String jdField_a_of_type_JavaLangString = "vip";
  public static final int b = 101;
  private static final String jdField_b_of_type_JavaLangString = "order_listener_key";
  public static final int c = 0;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 3;
  private static final int g = 0;
  Handler jdField_a_of_type_AndroidOsHandler = new fge(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getMainLooper());
  public WeakHashMap a;
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  public boolean a;
  private boolean jdField_b_of_type_Boolean;
  private int h = -1;
  private int i = -1;
  
  SVIPHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    this.jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
  }
  
  /* Error */
  public int a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 44	com/tencent/mobileqq/app/SVIPHandler:i	I
    //   6: iconst_m1
    //   7: if_icmpne +45 -> 52
    //   10: aload_0
    //   11: getfield 49	com/tencent/mobileqq/app/SVIPHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14: bipush 8
    //   16: invokevirtual 84	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   19: checkcast 86	com/tencent/mobileqq/app/FriendsManagerImp
    //   22: aload_0
    //   23: getfield 49	com/tencent/mobileqq/app/SVIPHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   26: invokevirtual 90	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   29: invokevirtual 93	com/tencent/mobileqq/app/FriendsManagerImp:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ExtensionInfo;
    //   32: astore_2
    //   33: aload_2
    //   34: ifnonnull +9 -> 43
    //   37: iconst_0
    //   38: istore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: iload_1
    //   42: ireturn
    //   43: aload_0
    //   44: aload_2
    //   45: getfield 98	com/tencent/mobileqq/data/ExtensionInfo:uVipFont	J
    //   48: l2i
    //   49: putfield 44	com/tencent/mobileqq/app/SVIPHandler:i	I
    //   52: aload_0
    //   53: getfield 44	com/tencent/mobileqq/app/SVIPHandler:i	I
    //   56: istore_1
    //   57: goto -18 -> 39
    //   60: astore_2
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_2
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	SVIPHandler
    //   38	19	1	j	int
    //   32	13	2	localExtensionInfo	ExtensionInfo
    //   60	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	33	60	finally
    //   43	52	60	finally
    //   52	57	60	finally
  }
  
  protected Class a()
  {
    return SVIPObserver.class;
  }
  
  public String a(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return paramString;
    }
    if (paramString.indexOf("?") != -1) {}
    for (paramString = paramString + "&sid=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid();; paramString = paramString + "?sid=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid()) {
      return paramString + "&go=androidqipao&aid=mvip.gongneng.mobileqq.liaotianqipao.fromandroid";
    }
  }
  
  public String a(boolean paramBoolean)
  {
    String str1 = "vip";
    if (paramBoolean) {
      str1 = "svip";
    }
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid();
    return "http://m.vip.qq.com/redirect/?go=androidqipao&sid=" + str2 + "&popo=" + str1 + "&aid=mvip.gongneng.mobileqq.liaotianqipao.fromandroid";
  }
  
  public String a(boolean paramBoolean1, boolean paramBoolean2)
  {
    String str1 = "vip";
    if (paramBoolean1) {
      if ((!paramBoolean2) || (c() != 0)) {
        break label65;
      }
    }
    label65:
    for (str1 = "vip";; str1 = "svip")
    {
      String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid();
      return "http://m.vip.qq.com/redirect/?go=androidqipao&sid=" + str2 + "&popo=" + str1 + "&aid=mvip.gongneng.mobileqq.liaotianqipao.fromandroid";
    }
  }
  
  public void a()
  {
    ToServiceMsg localToServiceMsg = a("ChatAvatar.ReqResUpdate");
    localToServiceMsg.extraData.putInt("req_res_order_seqid", 0);
    a(localToServiceMsg);
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (this.h != 0)
      {
        this.h = 0;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit().putInt("svip_bubble_id", 0).commit();
      }
      this.b = false;
      return;
    }
    finally {}
  }
  
  public void a(int paramInt, SVIPHandler.OrderListener paramOrderListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("vip", 2, "orderSelfMsgBubbleId id = " + paramInt);
    }
    ToServiceMsg localToServiceMsg = a("ChatAvatar.ReqResOrder");
    localToServiceMsg.extraData.putInt("req_res_order_pkgid", paramInt);
    int j = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    localToServiceMsg.extraData.putInt("order_listener_key", j);
    this.jdField_a_of_type_JavaUtilWeakHashMap.put(Integer.valueOf(j), paramOrderListener);
    a(localToServiceMsg);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, j, paramInt), 5000L);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.istroop != 1001) {
      paramMessageRecord.vipBubbleID = b();
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j;
    if ("AvatarUpdate.checkUpdate".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      boolean bool = paramFromServiceMsg.isSuccess();
      j = paramToServiceMsg.extraData.getInt("AvatarUpdateSubCMD");
      if (bool) {
        paramToServiceMsg = new BubbleUpdatePB.RspUpdate();
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg != null) && (paramToServiceMsg.int32_ret.get() == 0)) {}
        switch (j)
        {
        default: 
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg = null;
        continue;
        j = paramToServiceMsg.uint32_used_item_id.get();
        if (j != 0) {
          ((BubbleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).a(j, true);
        }
        a(j);
        if (!paramToServiceMsg.msg_rsp_data.has()) {
          continue;
        }
        paramToServiceMsg = ((BubbleUpdatePB.RspUpdateData)paramToServiceMsg.msg_rsp_data.get()).rpt_msg_rsp_update.get().iterator();
      }
      while (paramToServiceMsg.hasNext())
      {
        paramFromServiceMsg = (BubbleUpdatePB.RspUpdateTable)paramToServiceMsg.next();
        if (paramFromServiceMsg.uint32_is_update.get() == 1) {
          ((BubbleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).a(paramFromServiceMsg.uint32_item_id.get(), true);
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public int b()
  {
    try
    {
      if (this.h == -1) {
        this.h = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getInt("svip_bubble_id", 0);
      }
      int j = this.h;
      return j;
    }
    finally {}
  }
  
  public String b(boolean paramBoolean)
  {
    String str2 = "vip";
    String str1 = "mvip.gongneng.mobileqq.liaotianqipao.androidvipguoqi";
    if (paramBoolean)
    {
      str2 = "svip";
      str1 = "mvip.gongneng.mobileqq.liaotianqipao.androidsvipguoqi";
    }
    String str3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid();
    return "http://vip.3g.qq.com/touch/touch_vip.jsp?sid=" + str3 + "&sc=" + str2 + "&aid=" + str1;
  }
  
  public void b()
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "ChatAvatar.ReqResUpdate");
    localToServiceMsg.extraData.putInt("ResID", 3);
    a(localToServiceMsg);
  }
  
  public void b(int paramInt)
  {
    try
    {
      if (paramInt != this.i)
      {
        FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        ExtensionInfo localExtensionInfo2 = localFriendsManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        ExtensionInfo localExtensionInfo1 = localExtensionInfo2;
        if (localExtensionInfo2 == null)
        {
          localExtensionInfo1 = new ExtensionInfo();
          localExtensionInfo1.uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        }
        localExtensionInfo1.uVipFont = paramInt;
        localFriendsManagerImp.a(localExtensionInfo1);
      }
      this.b = false;
      return;
    }
    finally {}
  }
  
  public boolean b()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    Object localObject = ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(str);
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("isCurrentUsrSVip findFriendEntityByUin is null :");
        if (str != null) {
          break label71;
        }
      }
      label71:
      for (boolean bool = true;; bool = false)
      {
        QLog.e("vip", 2, bool);
        return false;
      }
    }
    return ((Friends)localObject).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP);
  }
  
  public int c()
  {
    int j = VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null);
    if ((j & 0x4) != 0) {
      return 3;
    }
    if ((j & 0x2) != 0) {
      return 1;
    }
    if ((j & 0x1) != 0) {
      return 2;
    }
    return 0;
  }
  
  public void c(int paramInt)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    int j = c();
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(str, 0);
    if (QLog.isColorLevel()) {
      QLog.d("vip", 2, "checkAndSetVipTag|type=" + paramInt + ",currUin=" + str + ",userVipType=" + j);
    }
    if (j == 0)
    {
      k = localSharedPreferences.getInt("svip_last_type", 0);
      if (QLog.isColorLevel()) {
        QLog.d("vip", 2, "checkAndSetVipTag|type=" + paramInt + ",currUin=" + str + ",userVipType=" + j + ",hisType=" + k);
      }
      if (k > 0) {
        localSharedPreferences.edit().putBoolean("svip_first_expired", true).commit();
      }
    }
    while ((j != 1) && (j != 3))
    {
      int k;
      return;
    }
    localSharedPreferences.edit().putInt("svip_last_type", j).commit();
    localSharedPreferences.edit().putBoolean("svip_first_expired", false).commit();
  }
  
  public boolean c()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    Object localObject = ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(str);
    if (localObject == null) {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("isCurrentUserVipOrSVip findFriendEntityByUin is null :");
        if (str != null) {
          break label71;
        }
        bool = true;
        QLog.e("vip", 2, bool);
      }
    }
    label71:
    while ((!((Friends)localObject).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) && (!((Friends)localObject).isServiceEnabled(EVIPSPEC.E_SP_QQVIP))) {
      for (;;)
      {
        return false;
        boolean bool = false;
      }
    }
    return true;
  }
  
  public void d()
  {
    BubbleUpdatePB.ReqUpdate localReqUpdate = new BubbleUpdatePB.ReqUpdate();
    BubbleUpdatePB.ReqUpdateData localReqUpdateData = new BubbleUpdatePB.ReqUpdateData();
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "AvatarUpdate.checkUpdate");
    localReqUpdate.uint32_plat_id.set(2);
    localReqUpdate.uint64_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    localReqUpdate.str_version.set("6.0.2.6602");
    localReqUpdate.int32_cmd.set(1);
    localReqUpdate.msg_req_data.set(localReqUpdateData);
    localReqUpdate.setHasFlag(true);
    localToServiceMsg.extraData.putInt("AvatarUpdateSubCMD", 1);
    localToServiceMsg.putWupBuffer(localReqUpdate.toByteArray());
    b(localToServiceMsg);
  }
  
  public void e()
  {
    JSONArray localJSONArray = ((BubbleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).a();
    if ((localJSONArray == null) || (localJSONArray.length() == 0)) {}
    for (;;)
    {
      return;
      BubbleUpdatePB.ReqUpdate localReqUpdate = new BubbleUpdatePB.ReqUpdate();
      BubbleUpdatePB.ReqUpdateData localReqUpdateData = new BubbleUpdatePB.ReqUpdateData();
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "AvatarUpdate.checkUpdate");
      int j = 0;
      while (j < localJSONArray.length() / 100 + 1)
      {
        int k;
        if ((j + 1) * 100 > localJSONArray.length()) {
          k = localJSONArray.length();
        }
        for (;;)
        {
          int m = j * 100;
          label111:
          if (m < k)
          {
            BubbleUpdatePB.ReqUpdateTable localReqUpdateTable = new BubbleUpdatePB.ReqUpdateTable();
            try
            {
              JSONObject localJSONObject = localJSONArray.getJSONObject(m);
              localReqUpdateTable.uint32_item_id.set(localJSONObject.getInt("id"));
              localReqUpdateTable.uint32_version.set(localJSONObject.getInt("version"));
              localReqUpdateData.rpt_msg_req_update.add(localReqUpdateTable);
              localReqUpdateData.setHasFlag(true);
              m += 1;
              break label111;
              k = (j + 1) * 100;
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                localJSONException.printStackTrace();
              }
            }
          }
        }
        localReqUpdate.uint32_plat_id.set(2);
        localReqUpdate.uint64_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
        localReqUpdate.str_version.set("6.0.2.6602");
        localReqUpdate.int32_cmd.set(1);
        localReqUpdate.msg_req_data.set(localReqUpdateData);
        localReqUpdate.setHasFlag(true);
        localToServiceMsg.extraData.putInt("AvatarUpdateSubCMD", 1);
        localToServiceMsg.putWupBuffer(localReqUpdate.toByteArray());
        b(localToServiceMsg);
        j += 1;
      }
    }
  }
  
  public void f()
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "ChatAvatar.ReqResUpdate");
    localToServiceMsg.extraData.putInt("ResID", 4);
    a(localToServiceMsg);
  }
  
  public void g()
  {
    FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    Friends localFriends = localFriendsManagerImp.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localFriends.superVipInfo = 16777216;
    localFriendsManagerImp.a(localFriends);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SVIPHandler
 * JD-Core Version:    0.7.0.1
 */