package com.tencent.mobileqq.app;

import QQService.EVIPSPEC;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TFontFreshReq;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TFontSsoReq;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cvq;
import java.util.Random;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SVIPHandler
  extends BusinessHandler
{
  public static final int a = 100;
  protected static final long a = 5000L;
  static final String jdField_a_of_type_JavaLangString = "vip";
  public static final int b = 101;
  private static final String b = "order_listener_key";
  public static final int c = 0;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 3;
  private static final int g = 0;
  Handler jdField_a_of_type_AndroidOsHandler = new cvq(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getMainLooper());
  public WeakHashMap a;
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  private boolean jdField_a_of_type_Boolean = false;
  private int h = -1;
  private int i = -1;
  
  SVIPHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
  }
  
  /* Error */
  public int a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 42	com/tencent/mobileqq/app/SVIPHandler:i	I
    //   6: iconst_m1
    //   7: if_icmpne +45 -> 52
    //   10: aload_0
    //   11: getfield 47	com/tencent/mobileqq/app/SVIPHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14: bipush 8
    //   16: invokevirtual 82	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   19: checkcast 84	com/tencent/mobileqq/app/FriendsManagerImp
    //   22: aload_0
    //   23: getfield 47	com/tencent/mobileqq/app/SVIPHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   26: invokevirtual 88	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   29: invokevirtual 91	com/tencent/mobileqq/app/FriendsManagerImp:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ExtensionInfo;
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
    //   45: getfield 96	com/tencent/mobileqq/data/ExtensionInfo:uVipFont	J
    //   48: l2i
    //   49: putfield 42	com/tencent/mobileqq/app/SVIPHandler:i	I
    //   52: aload_0
    //   53: getfield 42	com/tencent/mobileqq/app/SVIPHandler:i	I
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
    VipFontUpdate.TFontSsoReq localTFontSsoReq = new VipFontUpdate.TFontSsoReq();
    localTFontSsoReq.u32_cmd.set(1);
    Object localObject = new Random();
    localTFontSsoReq.u64_seq.set(((Random)localObject).nextInt(1000));
    localTFontSsoReq.i32_implat.set(109);
    localTFontSsoReq.str_osver.set(String.valueOf(Build.VERSION.SDK_INT));
    localTFontSsoReq.str_mqqver.set("3.3.0.544");
    localTFontSsoReq.st_fresh_req = new VipFontUpdate.TFontFreshReq();
    localTFontSsoReq.st_fresh_req.i32_local_font_id.set(a());
    localObject = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "Font.fresh");
    ((ToServiceMsg)localObject).putWupBuffer(localTFontSsoReq.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (paramInt != this.h)
      {
        this.h = paramInt;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit().putInt("svip_bubble_id", paramInt).commit();
      }
      this.jdField_a_of_type_Boolean = false;
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
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
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
  
  public void b()
  {
    ToServiceMsg localToServiceMsg = a("ChatAvatar.ReqResUpdate");
    localToServiceMsg.extraData.putInt("req_res_order_seqid", 0);
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
      this.jdField_a_of_type_Boolean = false;
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
  
  public void c()
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "ChatAvatar.ReqResUpdate");
    localToServiceMsg.extraData.putInt("ResID", 3);
    a(localToServiceMsg);
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
  
  public void e()
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "ChatAvatar.ReqResUpdate");
    localToServiceMsg.extraData.putInt("ResID", 4);
    a(localToServiceMsg);
  }
  
  public void f()
  {
    FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    Friends localFriends = localFriendsManagerImp.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localFriends.superVipInfo = 16777216;
    localFriendsManagerImp.a(localFriends);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SVIPHandler
 * JD-Core Version:    0.7.0.1
 */