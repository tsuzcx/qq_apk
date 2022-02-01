package com.tencent.mobileqq.mini.share;

import adqr;
import adtr;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.webkit.URLUtil;
import aojg;
import aooi;
import aook;
import aool;
import aroi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.mini.launch.CmdCallback;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

public class MiniArkShareAsyncManager
{
  private static final String TAG = "MiniArkShareAsyncManage [miniappArkShare]";
  
  static void performChangeArkShareImageUrl(String paramString, CmdCallback paramCmdCallback)
  {
    if (TextUtils.isEmpty(paramString)) {
      try
      {
        paramCmdCallback.onCmdResult(true, new Bundle());
        return;
      }
      catch (RemoteException paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    MiniAppCmdUtil.getInstance().changeShareImageUrl(paramString, new MiniArkShareAsyncManager.3(paramCmdCallback));
  }
  
  public static void performShareArkAsyncMessage(Bundle paramBundle, CmdCallback paramCmdCallback)
  {
    if (paramBundle == null)
    {
      if (paramCmdCallback != null) {}
      try
      {
        paramCmdCallback.onCmdResult(false, new Bundle());
        return;
      }
      catch (RemoteException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
    }
    String str3 = paramBundle.getString("forward_ark_app_name");
    String str2 = paramBundle.getString("sharePicturePath");
    int i;
    if ((!URLUtil.isHttpUrl(str2)) && (!URLUtil.isHttpsUrl(str2)))
    {
      i = 1;
      label63:
      if ((i == 0) || (str2 == null)) {
        break label262;
      }
    }
    label262:
    for (String str1 = adqr.aP(str3, str2);; str1 = str2)
    {
      Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject1 instanceof QQAppInterface))
      {
        localObject1 = (QQAppInterface)localObject1;
        Object localObject2 = (ArkAppCenter)((QQAppInterface)localObject1).getManager(121);
        if (localObject2 != null)
        {
          localObject2 = ((ArkAppCenter)localObject2).a();
          if (localObject2 != null) {
            ((adtr)localObject2).a(str3, new MiniArkShareAsyncPreprocessor(paramBundle));
          }
        }
        if (i != 0)
        {
          paramBundle = ((QQAppInterface)localObject1).a().createEntityManager();
          if (paramBundle != null)
          {
            paramBundle.persistOrReplace(new MiniProgramArkShareLocalImageEntity(str1, str2));
            if (QLog.isColorLevel()) {
              QLog.d("MiniArkShareAsyncManage [miniappArkShare]", 2, "performShareArkAsyncMessage: persist to database, arkPath:" + str1 + ",sharePicturePath:" + str2);
            }
          }
        }
      }
      if (paramCmdCallback == null) {
        break;
      }
      try
      {
        paramBundle = new Bundle();
        if (i != 0) {
          paramBundle.putString("arkPath", str1);
        }
        paramCmdCallback.onCmdResult(true, paramBundle);
        return;
      }
      catch (RemoteException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
      i = 0;
      break label63;
    }
  }
  
  public static void performUploadArkShareImage(String paramString, CmdCallback paramCmdCallback)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)localObject;
        aool localaool = new aool();
        localaool.cNy = true;
        localaool.dQ = paramString;
        localaool.dOM = 62;
        localaool.mUniseq = ((Math.random() * 1000000.0D));
        localaool.mPeerUin = "0";
        localaool.mSelfUin = String.valueOf(aroi.a().getUin());
        localaool.mFileType = 24;
        localaool.ckW = "miniAppArkShareUploadPicHit";
        paramString = new Bdh_extinfo.CommFileExtReq();
        paramString.uint32_action_type.set(0);
        paramString.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString()));
        localaool.gb = paramString.toByteArray();
        paramString = new MiniArkShareAsyncTransProcessorHandler(ThreadManagerV2.getFileThreadLooper(), paramCmdCallback);
        paramString.addFilter(new Class[] { aojg.class });
        if (((QQAppInterface)localObject).a() != null)
        {
          ((QQAppInterface)localObject).a().a(paramString);
          ((QQAppInterface)localObject).a().a(localaool);
        }
      }
    }
    do
    {
      return;
      QLog.e("MiniArkShareAsyncManage [miniappArkShare]", 2, "performUploadArkShareImage empty local image path");
    } while (paramCmdCallback == null);
    try
    {
      paramCmdCallback.onCmdResult(false, new Bundle());
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void registerMiniArkShareMessageProcessorAfterProcessRestart()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (ArkAppCenter)((QQAppInterface)localObject).getManager(121);
      if (localObject != null)
      {
        localObject = ((ArkAppCenter)localObject).a();
        if (localObject != null)
        {
          ((adtr)localObject).a("com.tencent.miniapp", new MiniArkShareAsyncPreprocessor(new Bundle()));
          QLog.d("MiniArkShareAsyncManage [miniappArkShare]", 2, "registerMiniArkShareMessageProcessorAfterProcessRestart");
        }
      }
    }
  }
  
  static void removeArkShareLocalImageDatabaseEntity(String paramString)
  {
    ThreadManagerV2.executeOnFileThread(new MiniArkShareAsyncManager.1(paramString));
  }
  
  public static void removeArkShareLocalTemporaryFile(String paramString)
  {
    ThreadManagerV2.executeOnFileThread(new MiniArkShareAsyncManager.2(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniArkShareAsyncManager
 * JD-Core Version:    0.7.0.1
 */