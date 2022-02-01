package com.tencent.mobileqq.msf.core.net.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.InflaterInputStream;
import tencent.im.oidb.cmd0x769.Oidb_0x769.Config;
import tencent.im.oidb.cmd0x769.Oidb_0x769.ConfigSeq;
import tencent.im.oidb.cmd0x769.Oidb_0x769.Content;
import tencent.im.oidb.cmd0x769.Oidb_0x769.ReqBody;
import tencent.im.oidb.cmd0x769.Oidb_0x769.RspBody;

public class MsfPullConfigUtil
{
  public static final String KEY_TEST_CRASH_SWITCH = "key_test_crash_switch";
  public static final String SP_SAFEMODE_TEST_CRASH_CONFIG = "sp_safemode_test_crash_config";
  private static final String TAG = "MsfPullConfigUtil";
  private static final int TYPE_COMMAND = 283;
  private static final int TYPE_PATCH = 46;
  public static volatile boolean sRecvProxy = false;
  public static volatile boolean sRecvRegister = false;
  
  private static void execConfigCmd(int paramInt1, int paramInt2, List paramList)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 46: 
      MsfHandlePatchUtils.handlePatchConfig(paramInt2, paramList);
      return;
    }
    MsfCmdConfig.executeSafeModeCmd(paramInt2, (String)paramList.get(0));
  }
  
  private static byte[] inflateConfigString(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramArrayOfByte = new InflaterInputStream(new ByteArrayInputStream(paramArrayOfByte));
      byte[] arrayOfByte = new byte[256];
      for (;;)
      {
        int i = paramArrayOfByte.read(arrayOfByte);
        if (-1 == i) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    }
    catch (Throwable paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsfPullConfigUtil", 2, "inflateConfigString error", paramArrayOfByte);
      }
      return null;
    }
    return paramArrayOfByte;
  }
  
  private static List parseConfigContent(Oidb_0x769.Config paramConfig)
  {
    Object localObject1 = null;
    Object localObject2;
    if ((paramConfig.rpt_msg_content_list != null) && (paramConfig.rpt_msg_content_list.size() > 0))
    {
      localObject1 = new ArrayList();
      if (QLog.isColorLevel()) {
        QLog.i("MsfPullConfigUtil", 2, "parseConfigContent rpt_msg_content_list size=" + paramConfig.rpt_msg_content_list.size());
      }
      localObject2 = paramConfig.rpt_msg_content_list.get().iterator();
      if (((Iterator)localObject2).hasNext())
      {
        paramConfig = (Oidb_0x769.Content)((Iterator)localObject2).next();
        if ((paramConfig != null) && (paramConfig.content.has())) {
          if (paramConfig.compress.get() == 1)
          {
            paramConfig = inflateConfigString(paramConfig.content.get().toByteArray());
            if (paramConfig == null) {
              break label454;
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        if (QLog.isColorLevel()) {
          QLog.i("MsfPullConfigUtil", 2, "parseConfigContent rpt_msg_content_list content item=" + paramConfig);
        }
        if (TextUtils.isEmpty(paramConfig)) {
          break;
        }
        ((List)localObject1).add(paramConfig);
      }
      catch (Exception paramConfig)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MsfPullConfigUtil", 2, "parseConfigContent rpt_msg_content_list uncompress failed", paramConfig);
        }
        paramConfig = null;
        continue;
      }
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("MsfPullConfigUtil", 2, "parseConfigContent rpt_msg_content_list content item empty");
      break;
      do
      {
        return localObject1;
        if ((paramConfig.rpt_content_list != null) && (paramConfig.rpt_content_list.size() > 0))
        {
          localObject2 = new ArrayList();
          if (QLog.isColorLevel()) {
            QLog.i("MsfPullConfigUtil", 2, "parseConfigContent rpt_content_list size=" + paramConfig.rpt_content_list.size());
          }
          paramConfig = paramConfig.rpt_content_list.get().iterator();
          for (;;)
          {
            localObject1 = localObject2;
            if (!paramConfig.hasNext()) {
              break;
            }
            localObject1 = (String)paramConfig.next();
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              ((List)localObject2).add(localObject1);
              if (QLog.isColorLevel()) {
                QLog.i("MsfPullConfigUtil", 2, "parseConfigContent rpt_content_list content item=" + (String)localObject1);
              }
            }
            else if (QLog.isColorLevel())
            {
              QLog.i("MsfPullConfigUtil", 2, "parseConfigContent rpt_content_list content item empty");
            }
          }
        }
      } while (!QLog.isColorLevel());
      QLog.i("MsfPullConfigUtil", 2, "parseConfigContent msg_content_list and rpt_content_list are empty, version=" + paramConfig.uint32_version.get());
      return null;
      label454:
      paramConfig = null;
    }
  }
  
  public static void parseConfigResponse(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("parseConfigResponse response len=");
          if (paramArrayOfByte == null)
          {
            localObject1 = "null";
            QLog.d("MsfPullConfigUtil", 2, localObject1 + ", isRegProxy=" + paramBoolean);
          }
        }
        else
        {
          if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
            continue;
          }
          localObject2 = new Oidb_0x769.RspBody();
          localObject1 = paramArrayOfByte;
          if (paramBoolean)
          {
            localObject1 = new byte[paramArrayOfByte.length - 4];
            System.arraycopy(paramArrayOfByte, 4, localObject1, 0, localObject1.length);
          }
          ((Oidb_0x769.RspBody)localObject2).mergeFrom((byte[])localObject1);
          i = ((Oidb_0x769.RspBody)localObject2).uint32_result.get();
          if (i != 0) {
            continue;
          }
          if ((((Oidb_0x769.RspBody)localObject2).rpt_config_list == null) || (((Oidb_0x769.RspBody)localObject2).rpt_config_list.size() <= 0)) {
            continue;
          }
          int j = ((Oidb_0x769.RspBody)localObject2).rpt_config_list.size();
          i = 0;
          if (i >= j) {
            continue;
          }
          paramArrayOfByte = (Oidb_0x769.Config)((Oidb_0x769.RspBody)localObject2).rpt_config_list.get(i);
          if (paramArrayOfByte == null) {
            break label349;
          }
          if (paramArrayOfByte.uint32_type.has()) {
            continue;
          }
          break label349;
        }
        localObject1 = Integer.valueOf(paramArrayOfByte.length);
        continue;
        localObject1 = parseConfigContent(paramArrayOfByte);
        if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
          execConfigCmd(paramArrayOfByte.uint32_type.get(), paramArrayOfByte.uint32_version.get(), (List)localObject1);
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        Object localObject1;
        if (QLog.isColorLevel()) {
          QLog.e("MsfPullConfigUtil", 2, "parseConfigResponse decode Oidb_0x769.RspBody --> throwable=", paramArrayOfByte);
        }
        if (paramBoolean)
        {
          sRecvProxy = true;
          return;
          if (paramArrayOfByte.uint32_type.get() == 46)
          {
            execConfigCmd(46, paramArrayOfByte.uint32_version.get(), (List)localObject1);
            break label349;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("MsfPullConfigUtil", 2, "parseConfigResponse decode Oidb_0x769.RspBody --> rpt_config_list is empty");
            continue;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("MsfPullConfigUtil", 2, "parseConfigResponse decode Oidb_0x769.RspBody --> result error=" + i);
          }
        }
        else
        {
          sRecvRegister = true;
          return;
        }
      }
      label349:
      i += 1;
    }
  }
  
  public static byte[] pullConfigRequest(boolean paramBoolean)
  {
    Oidb_0x769.ReqBody localReqBody = new Oidb_0x769.ReqBody();
    Oidb_0x769.ConfigSeq localConfigSeq = new Oidb_0x769.ConfigSeq();
    localConfigSeq.type.set(46);
    localConfigSeq.version.set(MsfHandlePatchUtils.getPatchConfigVersion());
    localReqBody.rpt_config_list.add(localConfigSeq);
    localConfigSeq = new Oidb_0x769.ConfigSeq();
    localConfigSeq.type.set(283);
    localConfigSeq.version.set(0);
    localReqBody.rpt_config_list.add(localConfigSeq);
    if (QLog.isColorLevel()) {
      QLog.d("MsfPullConfigUtil", 2, "pullConfigRequest isRegProxy=" + paramBoolean);
    }
    return localReqBody.toByteArray();
  }
  
  public static void showToastForSafeModeTest(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.utils.MsfPullConfigUtil
 * JD-Core Version:    0.7.0.1
 */