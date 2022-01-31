package com.tencent.biz.TroopRedpoint;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import tencent.im.oidb.cmd0x791.oidb_0x791.GetRedDotRes;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class TroopRedTouchManager
  implements Manager
{
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  final String jdField_a_of_type_JavaLangString = "TroopRedTouchManager";
  oidb_0x791.GetRedDotRes jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes;
  
  public TroopRedTouchManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public TroopRedTouchManager(AppInterface paramAppInterface, oidb_0x791.GetRedDotRes paramGetRedDotRes)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = paramGetRedDotRes;
  }
  
  /* Error */
  private oidb_0x791.GetRedDotRes a()
  {
    // Byte code:
    //   0: new 32	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 21	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   8: invokevirtual 38	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   11: invokevirtual 44	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   14: new 46	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   21: ldc 17
    //   23: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: getfield 21	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   30: invokevirtual 54	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   33: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokespecial 60	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   42: invokestatic 65	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;)[B
    //   45: astore_2
    //   46: new 67	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes
    //   49: dup
    //   50: invokespecial 68	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes:<init>	()V
    //   53: astore_1
    //   54: aload_2
    //   55: ifnull +9 -> 64
    //   58: aload_1
    //   59: aload_2
    //   60: invokevirtual 72	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   63: pop
    //   64: aload_1
    //   65: areturn
    //   66: astore_2
    //   67: aconst_null
    //   68: astore_1
    //   69: aload_2
    //   70: invokevirtual 75	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   73: aload_1
    //   74: areturn
    //   75: astore_2
    //   76: aconst_null
    //   77: astore_1
    //   78: aload_2
    //   79: invokevirtual 76	java/lang/NullPointerException:printStackTrace	()V
    //   82: aload_1
    //   83: areturn
    //   84: astore_2
    //   85: goto -7 -> 78
    //   88: astore_2
    //   89: goto -20 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	TroopRedTouchManager
    //   53	30	1	localGetRedDotRes	oidb_0x791.GetRedDotRes
    //   45	15	2	arrayOfByte	byte[]
    //   66	4	2	localInvalidProtocolBufferMicroException1	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   75	4	2	localNullPointerException1	java.lang.NullPointerException
    //   84	1	2	localNullPointerException2	java.lang.NullPointerException
    //   88	1	2	localInvalidProtocolBufferMicroException2	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    // Exception table:
    //   from	to	target	type
    //   0	54	66	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   0	54	75	java/lang/NullPointerException
    //   58	64	84	java/lang/NullPointerException
    //   58	64	88	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private boolean a(oidb_0x791.GetRedDotRes paramGetRedDotRes)
  {
    if (paramGetRedDotRes == null) {
      return false;
    }
    return FileUtils.a(new File(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getFilesDir(), "TroopRedTouchManager" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.a()).getAbsolutePath(), paramGetRedDotRes.toByteArray(), false);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
      this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
    }
    if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
      return 0;
    }
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size(); j = k)
    {
      oidb_0x791.RedDotInfo localRedDotInfo = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
      k = j;
      if (localRedDotInfo.bool_display_reddot.get()) {
        if ((1 != localRedDotInfo.uint32_appid.get()) && (3 != localRedDotInfo.uint32_appid.get()) && (4 != localRedDotInfo.uint32_appid.get()))
        {
          k = j;
          if (5 != localRedDotInfo.uint32_appid.get()) {}
        }
        else
        {
          k = j + 1;
        }
      }
      i += 1;
    }
    return j;
  }
  
  public oidb_0x791.RedDotInfo a(int paramInt)
  {
    if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
      this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
    }
    if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
      return null;
    }
    int i = 0;
    oidb_0x791.RedDotInfo localRedDotInfo;
    if (i < this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size())
    {
      localRedDotInfo = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
      if (paramInt != localRedDotInfo.uint32_appid.get()) {}
    }
    for (;;)
    {
      return localRedDotInfo;
      i += 1;
      break;
      localRedDotInfo = null;
    }
  }
  
  public void a(oidb_0x791.GetRedDotRes paramGetRedDotRes)
  {
    this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = paramGetRedDotRes;
    a(paramGetRedDotRes);
  }
  
  public void a(oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    int k = 0;
    if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
      this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
    }
    if ((this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) || (paramRedDotInfo == null)) {
      return;
    }
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size())
      {
        if (((oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i)).uint32_appid.get() == paramRedDotInfo.uint32_appid.get())
        {
          this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.set(i, paramRedDotInfo);
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.add(paramRedDotInfo);
        }
        a(this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes);
        return;
      }
      i += 1;
    }
  }
  
  public void onDestroy()
  {
    a(this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.TroopRedpoint.TroopRedTouchManager
 * JD-Core Version:    0.7.0.1
 */