package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import com.tencent.biz.common.util.SubString;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.trunk.group_feeds.group_feeds.GroupFeedsMessage;
import com.trunk.group_feeds.group_feeds.GroupFeedsMessage.MessageContent;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class GetTroopNotificationOidbHelper
{
  protected static HashMap a = new HashMap();
  
  public static TroopNotificationCache a(int paramInt1, int paramInt2, int paramInt3, long paramLong, String paramString, int paramInt4, byte[] paramArrayOfByte)
  {
    Object localObject = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramArrayOfByte = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramArrayOfByte);
      if ((paramArrayOfByte == null) || (!paramArrayOfByte.uint32_result.has())) {
        return null;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = (byte[])localObject;
      }
      if (paramArrayOfByte.uint32_result.get() != 0) {
        try
        {
          paramString = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte.bytes_bodybuffer.get().toByteArray()));
          paramArrayOfByte = new byte[paramString.readByte()];
          paramString.read(paramArrayOfByte);
          new String(paramArrayOfByte);
          return null;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            QLog.d(GetTroopNotificationOidbHelper.class.getSimpleName(), 2, paramString.getMessage());
          }
        }
      }
      try
      {
        paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte.bytes_bodybuffer.get().toByteArray()));
        paramArrayOfByte.read();
        paramArrayOfByte.readShort();
        paramArrayOfByte.readShort();
        paramArrayOfByte.readInt();
        paramArrayOfByte.readInt();
        paramArrayOfByte.skip(32L);
        paramArrayOfByte.readInt();
        paramArrayOfByte.readInt();
        paramArrayOfByte.readInt();
        paramArrayOfByte.readInt();
        paramArrayOfByte.readInt();
        paramArrayOfByte.readInt();
        paramArrayOfByte.readInt();
        paramArrayOfByte.readInt();
        paramArrayOfByte.skip(paramArrayOfByte.readShort() * 5);
        paramArrayOfByte.skip(16L);
        localObject = new byte[paramArrayOfByte.readInt()];
        paramArrayOfByte.read((byte[])localObject);
        paramArrayOfByte = a((byte[])localObject);
        localObject = new TroopNotificationCache();
        ((TroopNotificationCache)localObject).appId = paramInt1;
        ((TroopNotificationCache)localObject).troopUin = paramInt2;
        ((TroopNotificationCache)localObject).userUin = paramLong;
        ((TroopNotificationCache)localObject).feedsId = paramString;
        ((TroopNotificationCache)localObject).time = paramInt4;
        ((TroopNotificationCache)localObject).xmlBytes = paramArrayOfByte;
        return localObject;
      }
      catch (Exception paramString)
      {
        QLog.d(GetTroopNotificationOidbHelper.class.getSimpleName(), 2, paramString.getMessage());
      }
    }
    return null;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, int paramInt3, long paramLong, String paramString, int paramInt4)
  {
    if ((a != null) && (a.containsKey(Integer.valueOf(paramInt3))))
    {
      localObject1 = (byte[])a.get(Integer.valueOf(paramInt3));
      a(paramQQAppInterface, paramInt1, paramInt2, paramInt3, (short)localObject1.length, (byte[])localObject1, paramLong, paramString, paramInt4);
      return;
    }
    Object localObject1 = new ToServiceMsg("mobileqq.service", paramQQAppInterface.a(), "OidbSvc.0x580_1");
    try
    {
      Object localObject2 = new ByteArrayOutputStream();
      DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject2);
      localDataOutputStream.writeInt(paramInt3);
      byte[] arrayOfByte = ((ByteArrayOutputStream)localObject2).toByteArray();
      localDataOutputStream.close();
      ((ByteArrayOutputStream)localObject2).close();
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1408);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(arrayOfByte));
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putInt("appId", paramInt1);
      ((ToServiceMsg)localObject1).extraData.putInt("troopUin", paramInt2);
      ((ToServiceMsg)localObject1).extraData.putInt("troopCode", paramInt3);
      ((ToServiceMsg)localObject1).extraData.putLong("userUin", paramLong);
      ((ToServiceMsg)localObject1).extraData.putString("feedsId", paramString);
      ((ToServiceMsg)localObject1).extraData.putInt("time", paramInt4);
      ((ToServiceMsg)localObject1).extraData.putBoolean("req_pb_protocol_flag", true);
      paramQQAppInterface.a((ToServiceMsg)localObject1);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d(GetTroopNotificationOidbHelper.class.getSimpleName(), 2, localException.getMessage());
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, int paramInt3, long paramLong, String paramString, int paramInt4, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(GetTroopNotificationOidbHelper.class.getSimpleName(), 2, "handGetTroopAuth");
    }
    Object localObject = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramArrayOfByte = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramArrayOfByte);
      if ((paramArrayOfByte == null) || (!paramArrayOfByte.uint32_result.has())) {
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      do
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          paramArrayOfByte = (byte[])localObject;
        }
      } while (paramArrayOfByte.uint32_result.get() != 0);
      try
      {
        paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte.bytes_bodybuffer.get().toByteArray());
        localObject = new DataInputStream(paramArrayOfByte);
        ((DataInputStream)localObject).readInt();
        ((DataInputStream)localObject).readInt();
        ((DataInputStream)localObject).readInt();
        ((DataInputStream)localObject).readInt();
        ((DataInputStream)localObject).skip(16L);
        ((DataInputStream)localObject).readInt();
        ((DataInputStream)localObject).readInt();
        ((DataInputStream)localObject).skip(4L);
        short s = ((DataInputStream)localObject).readShort();
        byte[] arrayOfByte = new byte[s];
        ((DataInputStream)localObject).read(arrayOfByte);
        a.put(Integer.valueOf(paramInt3), arrayOfByte);
        ((DataInputStream)localObject).close();
        paramArrayOfByte.close();
        a(paramQQAppInterface, paramInt1, paramInt2, paramInt3, s, arrayOfByte, paramLong, paramString, paramInt4);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.d(GetTroopNotificationOidbHelper.class.getSimpleName(), 2, paramQQAppInterface.getMessage());
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, int paramInt3, short paramShort, byte[] paramArrayOfByte, long paramLong, String paramString, int paramInt4)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramQQAppInterface.a(), "OidbSvc.0x852_35");
    paramArrayOfByte = a(paramInt3, paramShort, paramArrayOfByte, paramString);
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(2130);
    localOIDBSSOPkg.uint32_result.set(0);
    localOIDBSSOPkg.uint32_service_type.set(35);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localToServiceMsg.putWupBuffer(localOIDBSSOPkg.toByteArray());
    localToServiceMsg.extraData.putInt("appId", paramInt1);
    localToServiceMsg.extraData.putInt("troopUin", paramInt2);
    localToServiceMsg.extraData.putInt("troopCode", paramInt3);
    localToServiceMsg.extraData.putLong("userUin", paramLong);
    localToServiceMsg.extraData.putString("feedsId", paramString);
    localToServiceMsg.extraData.putInt("time", paramInt4);
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    paramQQAppInterface.a(localToServiceMsg);
  }
  
  public static byte[] a(int paramInt, short paramShort, byte[] paramArrayOfByte, String paramString)
  {
    int i = 0;
    int j = (short)65;
    byte[] arrayOfByte1 = new byte[32];
    Arrays.fill(arrayOfByte1, (byte)0);
    paramString = paramString.getBytes();
    while ((i < 32) && (i < paramString.length))
    {
      arrayOfByte1[i] = paramString[i];
      i += 1;
    }
    i = (int)(System.currentTimeMillis() / 1000L);
    j = (int)(System.currentTimeMillis() / 1000L);
    byte[] arrayOfByte2 = new byte[16];
    int k = 65 + paramShort;
    int m = (short)k;
    try
    {
      paramString = new ByteArrayOutputStream();
      DataOutputStream localDataOutputStream = new DataOutputStream(paramString);
      localDataOutputStream.writeInt(k);
      localDataOutputStream.write(1);
      localDataOutputStream.writeShort(m);
      localDataOutputStream.writeInt(paramInt);
      localDataOutputStream.write(arrayOfByte1);
      localDataOutputStream.writeInt(i);
      localDataOutputStream.writeInt(j);
      localDataOutputStream.writeShort(paramShort);
      localDataOutputStream.write(paramArrayOfByte);
      localDataOutputStream.write(arrayOfByte2);
      paramArrayOfByte = paramString.toByteArray();
      localDataOutputStream.close();
      paramString.close();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.d(GetTroopNotificationOidbHelper.class.getSimpleName(), 2, paramArrayOfByte.getMessage());
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    Object localObject1;
    Object localObject2;
    try
    {
      localObject1 = new group_feeds.GroupFeedsMessage();
      ((group_feeds.GroupFeedsMessage)localObject1).mergeFrom(paramArrayOfByte);
      if (((group_feeds.GroupFeedsMessage)localObject1).type.get() == 13)
      {
        localObject2 = ((group_feeds.GroupFeedsMessage)localObject1).content.get();
        paramArrayOfByte = "";
        localObject1 = "";
        StringBuilder localStringBuilder = new StringBuilder();
        Iterator localIterator = ((List)localObject2).iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (group_feeds.GroupFeedsMessage.MessageContent)localIterator.next();
          int i = ((group_feeds.GroupFeedsMessage.MessageContent)localObject2).type.get();
          if (i == 3)
          {
            localObject2 = String.format("http://gdynamic.qpic.cn/gdynamic/%s/42", new Object[] { ((group_feeds.GroupFeedsMessage.MessageContent)localObject2).pic_id.get().toStringUtf8() });
            localObject1 = paramArrayOfByte;
            paramArrayOfByte = (byte[])localObject2;
            break label300;
          }
          if (i == 0)
          {
            localStringBuilder.append(((group_feeds.GroupFeedsMessage.MessageContent)localObject2).value.get().toStringUtf8());
            localObject2 = paramArrayOfByte;
            paramArrayOfByte = (byte[])localObject1;
            localObject1 = localObject2;
            break label300;
          }
          if (i == 10)
          {
            localObject2 = ((group_feeds.GroupFeedsMessage.MessageContent)localObject2).value.get().toStringUtf8();
            paramArrayOfByte = (byte[])localObject1;
            localObject1 = localObject2;
            break label300;
          }
          if (i != 2) {
            break label309;
          }
          localStringBuilder.append(String.format("[\\%d]", new Object[] { Integer.valueOf(((group_feeds.GroupFeedsMessage.MessageContent)localObject2).face_idx.get()) }));
          break label309;
        }
        localObject2 = SubString.a(localStringBuilder.toString(), 60, "UTF-8", "...");
        paramArrayOfByte = String.format("<msg templateID=\"\" url=\"%s\" serviceID=\"27\" action=\"web\" actionData=\"\" a_actionData=\"\" i_actionData=\"\" brief=\"%s\" flag=\"5\"><item layout=\"2\"><picture cover=\"%s\"/><title>%s</title><summary>%s</summary></item></msg>", new Object[] { "", SubString.a(localStringBuilder.toString(), 15, "UTF-8", ""), localObject1, paramArrayOfByte, localObject2 }).getBytes();
        return paramArrayOfByte;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.d(TroopNotificationCache.class.getSimpleName(), 2, paramArrayOfByte.getMessage());
    }
    return null;
    for (;;)
    {
      label300:
      localObject2 = localObject1;
      localObject1 = paramArrayOfByte;
      paramArrayOfByte = (byte[])localObject2;
      break;
      label309:
      localObject2 = paramArrayOfByte;
      paramArrayOfByte = (byte[])localObject1;
      localObject1 = localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.GetTroopNotificationOidbHelper
 * JD-Core Version:    0.7.0.1
 */