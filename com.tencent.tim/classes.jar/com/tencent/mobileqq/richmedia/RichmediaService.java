package com.tencent.mobileqq.richmedia;

import akxj;
import akyj;
import alvq;
import alvq.a;
import alvr;
import ambr;
import ambv;
import ambw;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import auru;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import java.lang.ref.WeakReference;
import mqq.app.AppService;
import mqq.os.MqqHandler;

public class RichmediaService
  extends AppService
  implements Handler.Callback
{
  static volatile RichmediaService jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService;
  static volatile auru q;
  a jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService$a;
  volatile alvq b;
  Messenger mClient;
  Messenger mMessenger;
  
  static void L(int paramInt, Bundle paramBundle)
  {
    alvr.d("RichmediaService", "sendICallBackRequest start . cmd = " + paramInt + ",data = " + paramBundle);
    auru localauru = q;
    if (localauru != null)
    {
      localauru.post(new RichmediaService.1(paramInt, paramBundle));
      return;
    }
    alvr.d("RichmediaService", "sendICallBackRequest subHandler is null");
  }
  
  public static boolean Q(Intent paramIntent)
  {
    alvr.d("RichmediaService", "addPresendMgrHandlerToIntent start .");
    Object localObject = jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService;
    if (localObject != null)
    {
      localObject = ((RichmediaService)localObject).b;
      if (localObject == null) {}
    }
    for (;;)
    {
      try
      {
        alvr.d("RichmediaService", "addPresendMgrHandlerToIntent cb.getData start . ");
        localObject = ((alvq)localObject).b(16, null);
      }
      catch (RemoteException localRemoteException1)
      {
        BinderWarpper localBinderWarpper;
        int i;
        int j;
        localObject = null;
      }
      try
      {
        alvr.d("RichmediaService", "addPresendMgrHandlerToIntent cb.getData finish. ");
        if (localObject == null) {
          break;
        }
        ((Bundle)localObject).setClassLoader(RichmediaService.class.getClassLoader());
        localBinderWarpper = (BinderWarpper)((Bundle)localObject).getParcelable("key_presend_mgr_handler");
        if (localBinderWarpper == null) {
          break;
        }
        i = ((Bundle)localObject).getInt("PhotoConst.PHOTO_COUNT");
        j = paramIntent.getIntExtra("PhotoConst.PHOTO_COUNT", -1);
        alvr.d("RichmediaService", "presend req count = " + i + ", send count = " + j);
        if (i == j) {
          break label273;
        }
        paramIntent = new Bundle();
        paramIntent.putInt("key_presend_cancel_type", 1022);
        if (q != null) {
          q.removeCallbacksAndMessages(null);
        }
        dl(paramIntent);
        bool = false;
      }
      catch (RemoteException localRemoteException2)
      {
        break label213;
        bool = false;
        continue;
      }
      alvr.d("RichmediaService", "addPresendMgrHandlerToIntent.result = " + bool);
      return bool;
      label213:
      alvr.d("RichmediaService", "addPresendMgrHandlerToIntent cb.getData ipc fail, RemoteException : " + localRemoteException1.getMessage());
      continue;
      alvr.d("RichmediaService", "addPresendMgrHandlerToIntent service.mClientCallBack is null");
      localObject = null;
      continue;
      alvr.d("RichmediaService", "addPresendMgrHandlerToIntent Richmedia Service is null");
      localObject = null;
      continue;
      label273:
      paramIntent.putExtra("presend_handler", localRemoteException1);
      bool = true;
    }
  }
  
  public static RichmediaService a()
  {
    return jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService;
  }
  
  public static void di(Bundle paramBundle)
  {
    alvr.d("RichmediaService", "initPresend. ");
    L(2, paramBundle);
  }
  
  public static void dj(Bundle paramBundle)
  {
    alvr.d("RichmediaService", "presendPic. ");
    L(3, paramBundle);
  }
  
  public static void dk(Bundle paramBundle)
  {
    alvr.d("RichmediaService", "cancelPresendPic. ");
    L(4, paramBundle);
  }
  
  public static void dl(Bundle paramBundle)
  {
    alvr.d("RichmediaService", "cancelAllPresendPic. ");
    L(5, paramBundle);
  }
  
  public static void f(CompressInfo paramCompressInfo)
  {
    alvr.d("RichmediaService", "startCompress start . compressInfo.localUUID = " + paramCompressInfo.localUUID + ",compressInfo.srcPath = " + paramCompressInfo.srcPath);
    Object localObject = jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService;
    int i = 0;
    if (localObject != null)
    {
      localObject = ((RichmediaService)localObject).b;
      if (localObject == null) {}
    }
    for (;;)
    {
      try
      {
        alvr.d("RichmediaService", "startCompress cb.compress start . compressInfo.localUUID = " + paramCompressInfo.localUUID + ",compressInfo.srcPath = " + paramCompressInfo.srcPath);
        ((alvq)localObject).e(paramCompressInfo);
        alvr.d("RichmediaService", "startCompress cb.compress finish. compressInfo.localUUID = " + paramCompressInfo.localUUID + ",compressInfo.dstPath = " + paramCompressInfo.destPath);
        if (i != 0)
        {
          alvr.d("RichmediaService", "startCompress compressInMainProcess start . compressInfo.localUUID = " + paramCompressInfo.localUUID + ",compressInfo.srcPath = " + paramCompressInfo.srcPath);
          akyj.b(paramCompressInfo);
          alvr.d("RichmediaService", "startCompress compressInMainProcess finish. compressInfo.localUUID = " + paramCompressInfo.localUUID + ",compressInfo.dstPath = " + paramCompressInfo.destPath);
        }
        return;
      }
      catch (RemoteException localRemoteException)
      {
        alvr.d("RichmediaService", "startCompress cb.compress ipc fail,compressInfo.localUUID = " + paramCompressInfo.localUUID + ",compress in main process, RemoteException : " + localRemoteException.getMessage());
        i = 1;
        continue;
      }
      alvr.d("RichmediaService", "startCompress service.mClientCallBack is null,compressInfo.localUUID = " + paramCompressInfo.localUUID + ",compress in main process");
      i = 1;
      continue;
      alvr.d("RichmediaService", "startCompress Richmedia Service is null,compressInfo.localUUID = " + paramCompressInfo.localUUID + ",compress in main process");
      i = 1;
    }
  }
  
  public boolean b(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    alvr.d("RichmediaService", "sendToClient,msgCode = " + paramInt1 + ",subCmd = " + paramInt2 + ",data = " + paramBundle);
    if (this.mClient == null)
    {
      alvr.e("RichmediaService", "sendToClient failed. mClient is null");
      return false;
    }
    Message localMessage = Message.obtain(null, paramInt1);
    if (paramBundle != null) {
      paramBundle.putInt("msg_sub_cmd", paramInt2);
    }
    localMessage.setData(paramBundle);
    try
    {
      this.mClient.send(localMessage);
      return true;
    }
    catch (Exception paramBundle)
    {
      alvr.e("RichmediaService", "sendToClient failed. e = " + paramBundle);
    }
    return false;
  }
  
  public String getModuleId()
  {
    return "peak";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PreUploadVideo", 2, "[onBind]");
    }
    return this.mMessenger.getBinder();
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService$a = new a(ThreadManager.getSubThreadLooper(), this);
    this.mMessenger = new Messenger(this.jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService$a);
    jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService = this;
    q = new auru(ThreadManager.getSubThreadLooper(), this);
    if (QLog.isColorLevel()) {
      QLog.i("PreUploadVideo", 2, "[onCreate]");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService$a = null;
    jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService = null;
    q = null;
    if (QLog.isColorLevel()) {
      QLog.i("PreUploadVideo", 2, "[onDestroy]");
    }
  }
  
  static class a
    extends Handler
  {
    final WeakReference<RichmediaService> o;
    
    public a(Looper paramLooper, RichmediaService paramRichmediaService)
    {
      super();
      this.o = new WeakReference(paramRichmediaService);
    }
    
    void a(QQAppInterface paramQQAppInterface, Message paramMessage, Bundle paramBundle)
    {
      long l = paramBundle.getLong("vidoe_record_uniseq");
      int i = paramBundle.getInt("video_segment_mode");
      ambw localambw = ambr.a(paramQQAppInterface).a(l, i);
      ambv localambv = new ambv();
      switch (paramMessage.what)
      {
      case 205: 
      default: 
        super.handleMessage(paramMessage);
      case 204: 
      case 206: 
        return;
      case 200: 
        localambv.mPath = paramBundle.getString("video_slice_path");
        localambv.mIndex = paramBundle.getInt("video_slice_index");
        localambv.mWidth = paramBundle.getInt("video_slice_width");
        localambv.mHeight = paramBundle.getInt("video_slice_height");
        localambv.mStartTime = paramBundle.getLong("video_slice_timestamp");
        localambv.mType = 1;
        localambw.a(localambv, paramBundle);
        return;
      case 201: 
        localambv.mType = 3;
        localambw.a(localambv, paramBundle);
        return;
      case 202: 
        localambv.mType = 4;
        localambw.a(localambv, paramBundle);
        return;
      case 203: 
        localambv.mType = 5;
        localambv.mWidth = paramBundle.getInt("video_slice_width");
        localambv.mHeight = paramBundle.getInt("video_slice_height");
        localambv.mVideoDuration = ((int)paramBundle.getLong("video_duration"));
        localambw.a(localambv, paramBundle);
        return;
      case 207: 
        localambw.mVideoDuration = ((int)paramBundle.getLong("video_duration"));
        localambw.aiv = paramBundle.getLong("video_start_time");
        localambw.dMk();
        return;
      }
      localambw.bme();
      ambr.a(paramQQAppInterface).a(localambw);
    }
    
    public void handleMessage(Message paramMessage)
    {
      RichmediaService localRichmediaService = (RichmediaService)this.o.get();
      if (localRichmediaService == null) {
        return;
      }
      Bundle localBundle = paramMessage.getData();
      if (localBundle != null)
      {
        localBundle.setClassLoader(getClass().getClassLoader());
        localBundle.getInt("msg_sub_cmd");
      }
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        if ((localBundle != null) && (paramMessage.what >= 200) && (paramMessage.what <= 208))
        {
          if (!QQAppInterface.class.isInstance(RichmediaService.b(localRichmediaService))) {
            break;
          }
          a((QQAppInterface)RichmediaService.c(localRichmediaService), paramMessage, localBundle);
        }
        if (((paramMessage.what != 250) && (paramMessage.what != 1)) || (!QQAppInterface.class.isInstance(RichmediaService.d(localRichmediaService)))) {
          break;
        }
        switch (paramMessage.what)
        {
        default: 
          super.handleMessage(paramMessage);
          return;
          alvr.d("RichmediaService", "handleMessage MSG_C2S_REGISTER_CLIENT");
          localRichmediaService.mClient = paramMessage.replyTo;
          if (localBundle != null)
          {
            Object localObject = (BinderWarpper)localBundle.getParcelable("ICallBack_BinderWrapper");
            if (localObject != null)
            {
              localRichmediaService.b = alvq.a.a(((BinderWarpper)localObject).binder);
              localObject = new Bundle();
              int[] arrayOfInt = akxj.b((QQAppInterface)RichmediaService.a(localRichmediaService));
              try
              {
                ((Bundle)localObject).putIntArray("key_compress_config", arrayOfInt);
                localRichmediaService.b.K(6, (Bundle)localObject);
              }
              catch (RemoteException localRemoteException)
              {
                alvr.d("RichmediaService", "ICALLBACK_CMD_INIT_COMPRESS_CONFIG remote error:" + localRemoteException);
                localRemoteException.printStackTrace();
              }
              continue;
              alvr.d("RichmediaService", "handleMessage MSG_C2S_UNREGISTER_CLIENT");
              localRichmediaService.mClient = null;
              localRichmediaService.b = null;
            }
          }
          break;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("RichmediaService", 2, "Call RichMediaService: " + paramMessage.what);
      }
      ThreadManager.getUIHandler().post(new RichmediaService.IncomingHandler.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.RichmediaService
 * JD-Core Version:    0.7.0.1
 */