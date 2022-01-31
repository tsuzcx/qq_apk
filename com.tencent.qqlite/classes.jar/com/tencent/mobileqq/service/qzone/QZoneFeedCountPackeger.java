package com.tencent.mobileqq.service.qzone;

import NS_UNDEAL_COUNT.feed_host_info;
import NS_UNDEAL_COUNT.get_relate_qq_count_req;
import NS_UNDEAL_COUNT.get_relate_qq_count_rsp;
import NS_UNDEAL_COUNT.mobile_count_req;
import NS_UNDEAL_COUNT.mobile_count_rsp;
import NS_UNDEAL_COUNT.s_passive_detail_info;
import NS_UNDEAL_COUNT.single_count;
import NS_UNDEAL_COUNT.yellow_info;
import QMF_PROTOCAL.QmfBusiControl;
import QMF_PROTOCAL.QmfDownstream;
import QMF_PROTOCAL.mobile_get_config_req;
import QMF_PROTOCAL.mobile_get_config_rsp;
import android.content.Context;
import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.config.provider.ExtraConfig;
import com.tencent.common.config.provider.QZConfigProviderUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.servlet.QZoneNotifyServlet;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneVipInfoManager;
import cooperation.qzone.WNSStream;
import cooperation.qzone.util.ProtocolUtils;
import edt;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class QZoneFeedCountPackeger
{
  public static final int a = 0;
  public static String a;
  private static AtomicInteger a;
  public static final int b = 1;
  public static final String b = "getUndealCount";
  public static final int c = 2;
  public static final String c = "getRelateUserCount";
  public static final int d = 3;
  private static final String d = QZoneFeedCountPackeger.class.getSimpleName();
  public static final int e = 4;
  public static final int f = 5;
  private static final int g = 1;
  
  static
  {
    jdField_a_of_type_JavaLangString = "hostuin";
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(Math.abs(new Random(65535L).nextInt()));
  }
  
  public static JceStruct a(int paramInt)
  {
    String str = QZConfigProviderUtil.a();
    if (QLog.isDevelopLevel()) {
      QLog.d("GetUndealCountTag", 4, "config Scene=" + paramInt);
    }
    if (str != null) {}
    for (;;)
    {
      return new mobile_get_config_req(1000027, paramInt, str);
      str = "";
    }
  }
  
  private static JceStruct a(byte[] paramArrayOfByte, QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject1 = new WNSStream();
    try
    {
      localObject1 = ((WNSStream)localObject1).a(ProtocolUtils.b(paramArrayOfByte));
      paramArrayOfByte = new UniAttribute();
      if ((localObject1 != null) && (((QmfDownstream)localObject1).WnsCode == 0))
      {
        paramArrayOfByte.setEncodeName("utf-8");
        paramArrayOfByte.decode(((QmfDownstream)localObject1).Extra);
        Object localObject2 = (QmfBusiControl)paramArrayOfByte.get("busiCompCtl");
        if ((localObject2 != null) && (1 == ((QmfBusiControl)localObject2).compFlag))
        {
          localObject2 = WNSStream.b(((QmfDownstream)localObject1).BusiBuff);
          if (localObject2 == null) {
            break label182;
          }
          ((QmfDownstream)localObject1).BusiBuff = ((byte[])localObject2);
        }
        localObject2 = new UniAttribute();
        ((UniAttribute)localObject2).setEncodeName("utf-8");
        ((UniAttribute)localObject2).decode(((QmfDownstream)localObject1).BusiBuff);
        paramString = (JceStruct)((UniAttribute)localObject2).get(paramString);
        ThreadManager.b(new edt(paramArrayOfByte, paramQQAppInterface));
        return paramString;
      }
      if (localObject1 != null)
      {
        int i = ((QmfDownstream)localObject1).WnsCode;
        if (i != 0) {
          return null;
        }
      }
      if (localObject1 == null) {
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      return null;
    }
    return null;
    label182:
    return null;
  }
  
  public static QZoneFeedCountPackeger.GetSubAccountUnreadResponse a(byte[] paramArrayOfByte, QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(QZoneNotifyServlet.jdField_a_of_type_JavaLangString, 2, "get subaccount unread count,decode error");
      }
      return null;
    }
    paramArrayOfByte = (get_relate_qq_count_rsp)a(paramArrayOfByte, paramQQAppInterface, "getRelateUserCount");
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(QZoneNotifyServlet.jdField_a_of_type_JavaLangString, 2, "get subaccount unread count,decode error");
      }
      return null;
    }
    paramArrayOfByte = (s_passive_detail_info)paramArrayOfByte.mapRelatePassiveInfo.get(Long.valueOf(paramLong));
    if (paramArrayOfByte == null) {
      return null;
    }
    paramQQAppInterface = new QZoneFeedCountPackeger.GetSubAccountUnreadResponse();
    paramQQAppInterface.jdField_a_of_type_JavaLangString = paramArrayOfByte.sPassiveMessage;
    paramQQAppInterface.jdField_a_of_type_Long = paramArrayOfByte.uPassiveCount;
    paramQQAppInterface.b = paramArrayOfByte.uRecentPassvieTime;
    paramQQAppInterface.c = paramLong;
    if (QLog.isColorLevel()) {
      QLog.d(QZoneNotifyServlet.jdField_a_of_type_JavaLangString, 2, "get subaccount unread count,decode succ");
    }
    return paramQQAppInterface;
  }
  
  private static void a(Context paramContext, mobile_get_config_rsp parammobile_get_config_rsp)
  {
    if ((parammobile_get_config_rsp != null) && (parammobile_get_config_rsp.config != null) && (!parammobile_get_config_rsp.config.isEmpty())) {}
    try
    {
      ExtraConfig.a(parammobile_get_config_rsp.config, true);
      label32:
      String str = BaseApplication.getContext().getPackageName();
      paramContext = str;
      if (TextUtils.isEmpty(str)) {
        paramContext = "unknow";
      }
      if (QLog.isColorLevel()) {
        QLog.i("ConfigProvider", 2, "qq config update:" + paramContext);
      }
      QZConfigProviderUtil.a(parammobile_get_config_rsp.config, parammobile_get_config_rsp.cookies, paramContext);
      return;
    }
    catch (Exception paramContext)
    {
      break label32;
    }
  }
  
  public static byte[] a(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramLong == 0L) {
      return null;
    }
    paramString = new mobile_count_req();
    paramString.uMask = 1L;
    paramString.iRelationType = 1;
    paramString.iVisitQZoneType = paramInt3;
    return a(paramString, "getUndealCount", paramLong, paramInt1, paramInt2, paramInt4);
  }
  
  public static byte[] a(long paramLong1, String paramString, int paramInt1, int paramInt2, int paramInt3, long paramLong2)
  {
    if (paramLong1 == 0L) {
      return null;
    }
    paramString = new get_relate_qq_count_req();
    paramString.vecRelateUserlist = new ArrayList();
    paramString.vecRelateUserlist.add(Long.valueOf(paramLong2));
    return a(paramString, "getRelateUserCount", paramLong1, paramInt1, paramInt2, paramInt3);
  }
  
  private static byte[] a(JceStruct paramJceStruct, String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      Object localObject1 = new UniAttribute();
      ((UniAttribute)localObject1).setEncodeName("utf8");
      ((UniAttribute)localObject1).put(jdField_a_of_type_JavaLangString, Long.valueOf(paramLong));
      if ((paramJceStruct != null) && (paramString != null) && (paramString.length() > 0)) {
        ((UniAttribute)localObject1).put(paramString, paramJceStruct);
      }
      localObject1 = ((UniAttribute)localObject1).encode();
      paramJceStruct = QZoneHelper.a();
      Object localObject2 = "screen_width=" + paramInt1 + "&" + "screen_height=" + paramInt2;
      localObject2 = new WNSStream(1000027, paramJceStruct, paramLong, new byte[0], (String)localObject2);
      if (localObject1 != null) {
        try
        {
          paramJceStruct = a(paramInt3);
          return ProtocolUtils.a(((WNSStream)localObject2).a(jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement(), "QzoneNewService." + paramString, (byte[])localObject1, false, paramJceStruct));
        }
        catch (Error paramJceStruct)
        {
          for (;;)
          {
            paramJceStruct.printStackTrace();
            paramJceStruct = null;
          }
        }
      }
      return null;
    }
    catch (Exception paramJceStruct)
    {
      paramJceStruct.printStackTrace();
    }
    return null;
  }
  
  public static long[] a(byte[] arg0, QQAppInterface paramQQAppInterface, ArrayList paramArrayList)
  {
    if (??? == null) {
      return null;
    }
    mobile_count_rsp localmobile_count_rsp = (mobile_count_rsp)a(???, paramQQAppInterface, "getUndealCount");
    if (localmobile_count_rsp == null) {
      return null;
    }
    synchronized (new long[5])
    {
      long l = localmobile_count_rsp.uRspMask;
      if ((0x2 & l) != 0L) {
        ???[0] = localmobile_count_rsp.stActiveCount.uCount;
      }
      if ((l & 1L) != 0L) {
        ???[1] = localmobile_count_rsp.stPassiveCount.uCount;
      }
      ???[2] = localmobile_count_rsp.iNextTimeout;
      if ((localmobile_count_rsp.vecUpdateFeedFriendsList != null) && (localmobile_count_rsp.vecUpdateFeedFriendsList.size() >= 1))
      {
        ???[3] = ((feed_host_info)localmobile_count_rsp.vecUpdateFeedFriendsList.get(0)).uUin;
        paramArrayList.addAll(localmobile_count_rsp.vecUpdateFeedFriendsList);
      }
      if ((localmobile_count_rsp.vecUpdatePassiveList != null) && (localmobile_count_rsp.vecUpdatePassiveList.size() >= 1)) {
        ???[4] = ((feed_host_info)localmobile_count_rsp.vecUpdatePassiveList.get(0)).uUin;
      }
      if (localmobile_count_rsp.stYellowInfo != null)
      {
        paramQQAppInterface = paramQQAppInterface.a();
        if (!TextUtils.isEmpty(paramQQAppInterface)) {
          QZoneVipInfoManager.a().a(paramQQAppInterface, localmobile_count_rsp.stYellowInfo.iYellowType, localmobile_count_rsp.stYellowInfo.iYellowLevel);
        }
      }
      return ???;
    }
  }
  
  private static void b(UniAttribute paramUniAttribute, QQAppInterface paramQQAppInterface)
  {
    if (paramUniAttribute != null) {}
    try
    {
      int i = ((Integer)paramUniAttribute.get("conf_info_rsp_len")).intValue();
      byte[] arrayOfByte = (byte[])paramUniAttribute.get("conf_info_rsp");
      paramUniAttribute = arrayOfByte;
      if (arrayOfByte != null)
      {
        paramUniAttribute = arrayOfByte;
        if (i != 0) {
          paramUniAttribute = WNSStream.b(arrayOfByte);
        }
      }
      if (paramUniAttribute != null)
      {
        paramUniAttribute = WNSStream.a(mobile_get_config_rsp.class, paramUniAttribute);
        if ((paramQQAppInterface != null) && (paramQQAppInterface.a() != null) && (paramUniAttribute != null)) {
          a(paramQQAppInterface.a(), (mobile_get_config_rsp)paramUniAttribute);
        }
      }
      return;
    }
    catch (Error paramUniAttribute)
    {
      paramUniAttribute.printStackTrace();
      return;
    }
    catch (Exception paramUniAttribute)
    {
      paramUniAttribute.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.qzone.QZoneFeedCountPackeger
 * JD-Core Version:    0.7.0.1
 */