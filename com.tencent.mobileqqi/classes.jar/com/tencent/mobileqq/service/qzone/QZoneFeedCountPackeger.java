package com.tencent.mobileqq.service.qzone;

import NS_UNDEAL_COUNT.feed_host_info;
import NS_UNDEAL_COUNT.mobile_count_req;
import NS_UNDEAL_COUNT.mobile_count_rsp;
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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneVipInfoManager;
import cooperation.qzone.WNSStream;
import gnm;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
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
  public static final String b = "SQQzoneSvc.getUndealCount";
  public static final int c = 2;
  private static final String c = QZoneFeedCountPackeger.class.getSimpleName();
  public static final int d = 3;
  private static final String d = "getUndealCount";
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
    QLog.d("GetUndealCountTag", 4, "config Scene=" + paramInt);
    if (str != null) {}
    for (;;)
    {
      return new mobile_get_config_req(1000027, paramInt, str);
      str = "";
    }
  }
  
  private static JceStruct a(byte[] paramArrayOfByte, QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = new WNSStream();
    try
    {
      localObject1 = ((WNSStream)localObject1).a(b(paramArrayOfByte));
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
            break label172;
          }
          ((QmfDownstream)localObject1).BusiBuff = ((byte[])localObject2);
        }
        localObject2 = new UniAttribute();
        ((UniAttribute)localObject2).setEncodeName("utf-8");
        ((UniAttribute)localObject2).decode(((QmfDownstream)localObject1).BusiBuff);
        localObject1 = (JceStruct)((UniAttribute)localObject2).get(a());
        ThreadManager.b(new gnm(paramArrayOfByte, paramQQAppInterface));
        return localObject1;
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
    label172:
    return null;
  }
  
  public static String a()
  {
    return "getUndealCount";
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
      QLog.i("ConfigProvider", 2, "qq config update:" + paramContext);
      if (!a(parammobile_get_config_rsp.config))
      {
        QZConfigProviderUtil.a(parammobile_get_config_rsp.config, "", paramContext);
        return;
      }
      QZConfigProviderUtil.a(parammobile_get_config_rsp.config, parammobile_get_config_rsp.cookies, paramContext);
      return;
    }
    catch (Exception paramContext)
    {
      break label32;
    }
  }
  
  private static boolean a(Map paramMap)
  {
    if (paramMap == null) {}
    while ((paramMap.get("PhotoUpload") == null) || (paramMap.get("PhotoSvrList") == null)) {
      return false;
    }
    return true;
  }
  
  public static byte[] a(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramLong == 0L) {
      return null;
    }
    paramString = new mobile_count_req();
    paramString.uMask = 0L;
    paramString.iRelationType = 1;
    paramString.iVisitQZoneType = 3;
    return a(paramString, paramLong, paramInt1, paramInt2, paramInt3);
  }
  
  private static byte[] a(JceStruct paramJceStruct, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      Object localObject1 = new UniAttribute();
      ((UniAttribute)localObject1).setEncodeName("utf8");
      ((UniAttribute)localObject1).put(jdField_a_of_type_JavaLangString, Long.valueOf(paramLong));
      Object localObject2 = a();
      if ((paramJceStruct != null) && (localObject2 != null) && (((String)localObject2).length() > 0)) {
        ((UniAttribute)localObject1).put((String)localObject2, paramJceStruct);
      }
      localObject1 = ((UniAttribute)localObject1).encode();
      paramJceStruct = QZoneHelper.a();
      localObject2 = "screen_width=" + paramInt1 + "&" + "screen_height=" + paramInt2;
      localObject2 = new WNSStream(1000027, paramJceStruct, paramLong, new byte[0], (String)localObject2);
      if (localObject1 != null) {
        try
        {
          paramJceStruct = a(paramInt3);
          return a(((WNSStream)localObject2).a(jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement(), "QzoneNewService.getUndealCount", (byte[])localObject1, false, paramJceStruct));
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
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfByte.length + 4);
    DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
    try
    {
      localDataOutputStream.writeInt(paramArrayOfByte.length + 4);
      localDataOutputStream.write(paramArrayOfByte);
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      label76:
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte = paramArrayOfByte;
      paramArrayOfByte.printStackTrace();
      try
      {
        localByteArrayOutputStream.close();
        localDataOutputStream.close();
        return null;
      }
      catch (Exception paramArrayOfByte)
      {
        return null;
      }
    }
    finally
    {
      try
      {
        localByteArrayOutputStream.close();
        localDataOutputStream.close();
        throw paramArrayOfByte;
      }
      catch (Exception localException1)
      {
        break label76;
      }
    }
  }
  
  public static long[] a(byte[] arg0, QQAppInterface paramQQAppInterface, ArrayList paramArrayList)
  {
    if (??? == null) {
      return null;
    }
    mobile_count_rsp localmobile_count_rsp = (mobile_count_rsp)a(???, paramQQAppInterface);
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
  
  private static byte[] b(byte[] paramArrayOfByte)
  {
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    DataInputStream localDataInputStream = new DataInputStream(localByteArrayInputStream);
    try
    {
      paramArrayOfByte = new byte[localDataInputStream.readInt() - 4];
      label72:
      return paramArrayOfByte;
    }
    catch (Exception localException1)
    {
      try
      {
        localByteArrayInputStream.close();
        localDataInputStream.close();
        return paramArrayOfByte;
      }
      catch (Exception localException5) {}
      localException1 = localException1;
      paramArrayOfByte = null;
      localException1.printStackTrace();
      try
      {
        localByteArrayInputStream.close();
        localDataInputStream.close();
        return paramArrayOfByte;
      }
      catch (Exception localException2)
      {
        return paramArrayOfByte;
      }
    }
    finally
    {
      try
      {
        localByteArrayInputStream.close();
        localDataInputStream.close();
        throw paramArrayOfByte;
      }
      catch (Exception localException3)
      {
        break label72;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.qzone.QZoneFeedCountPackeger
 * JD-Core Version:    0.7.0.1
 */