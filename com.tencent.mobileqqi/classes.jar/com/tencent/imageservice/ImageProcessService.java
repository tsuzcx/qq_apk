package com.tencent.imageservice;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;

public class ImageProcessService
  extends Service
{
  public static final int BITMAP_TO_FILE_FAIL = 16777216;
  public static final int BITMAP_TO_FILE_SUCCESS = 8388608;
  public static final int CLOSE_EXCEPTION = 4194304;
  public static final int COMPRESS_EXCEPTION = 2097152;
  public static final int CREATE_BITMAP = 16384;
  public static final int CREATE_BITMAP2 = 65536;
  public static final int CREATE_BITMAP2_OOM = 131072;
  public static final int CREATE_BITMAP_OOM = 32768;
  public static final int DECODE_BITMAP_SIZE = 4;
  public static final int DECODE_BITMAP_SIZE_0 = 2;
  public static final int DECODE_FILE2 = 32;
  public static final int DECODE_FILE2_OOM = 64;
  public static final int DECODE_FILE_OOM = 16;
  public static final int DECODE_FILE_WITH_RETRY = 256;
  public static final int DECODE_FILE_WITH_RETRY_FAIL = 512;
  public static final int EMPTY_SAVE_PATH = 1048576;
  public static final int EXIF_NULL = 2048;
  public static final String KEY_MSG_COMPRESS = "KEY_MSG_COMPRESS";
  static final Milestone MILESTONE = new Milestone();
  public static final int MSG_COPY_AND_COMPRESS_IMAGE_REQUEST = 1;
  public static final int MSG_COPY_AND_COMPRESS_IMAGE_RESPONSE = 101;
  public static final int MSG_OBTAIN_PID_REQUEST = 2;
  public static final int MSG_OBTAIN_PID_RESPONSE = 102;
  public static final int POST_ROTATE = 4096;
  public static final int START_COMPRESS_FILE = 1;
  public static final int START_DECODE_FILE_WITH_RETRY = 8;
  public static final int START_DECODE_FILE_WITH_RETRY2 = 128;
  public static final int START_ROTATE = 1024;
  public static final int START_TRANSFORM_BITMAP = 8192;
  public static final int TRANSFORM_BITMAP_END = 262144;
  public static final int TRANSFORM_BITMAP_FAIL = 524288;
  static String sMsg;
  public static final String tag = "ImageProcessService";
  IncomingHandler mIncomingHandler;
  Messenger mMessenger;
  
  public IBinder onBind(Intent paramIntent)
  {
    Log.d("ImageProcessService", "onBind");
    return this.mMessenger.getBinder();
  }
  
  public void onCreate()
  {
    this.mIncomingHandler = new IncomingHandler();
    this.mMessenger = new Messenger(this.mIncomingHandler);
  }
  
  public void onDestroy()
  {
    Log.d("ImageProcessService", "onDestroy");
    super.onDestroy();
  }
  
  public void onRebind(Intent paramIntent)
  {
    Log.v("ImageProcessService", "onRebind");
    super.onRebind(paramIntent);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    Log.d("ImageProcessService", "onUnbind");
    this.mIncomingHandler.removeMessages(1);
    return super.onUnbind(paramIntent);
  }
  
  static class IncomingHandler
    extends Handler
  {
    public void handleMessage(Message paramMessage)
    {
      Message localMessage;
      switch (paramMessage.what)
      {
      default: 
        super.handleMessage(paramMessage);
        return;
      case 1: 
        Log.i("ImageProcessService", "receive MSG_COPY_AND_COMPRESS_IMAGE_REQUEST flowId=" + paramMessage.arg1);
        ImageProcessService.MILESTONE.reset();
        ImageProcessService.sMsg = null;
        localMessage = Message.obtain(null, 101);
        localMessage.arg1 = paramMessage.arg1;
        paramMessage.getData().setClassLoader(ImageProcessData.class.getClassLoader());
        Object localObject = paramMessage.getData().getParcelable("KEY_MSG_COMPRESS");
        if ((localObject instanceof ImageProcessData))
        {
          localObject = (ImageProcessData)localObject;
          Log.d("ImageProcessService", "compressFile start. file=" + ((ImageProcessData)localObject).originalFilePath + " target w=" + ((ImageProcessData)localObject).targetWidth + " h=" + ((ImageProcessData)localObject).targetHeight + " q=" + ((ImageProcessData)localObject).targetQuality);
          String str = ImageProcessUtil.compressFile(((ImageProcessData)localObject).originalFilePath, ((ImageProcessData)localObject).targetFilePath, ((ImageProcessData)localObject).targetWidth, ((ImageProcessData)localObject).targetHeight, ((ImageProcessData)localObject).targetQuality, ((ImageProcessData)localObject).autoRotate, ((ImageProcessData)localObject).compressToWebp);
          Log.d("ImageProcessService", "compressFile end. targetFile=" + str);
          ((ImageProcessData)localObject).originalFilePath = str;
          if (!TextUtils.isEmpty(ImageProcessService.sMsg)) {
            break label307;
          }
          ((ImageProcessData)localObject).msg = null;
        }
        for (;;)
        {
          localMessage.getData().putParcelable("KEY_MSG_COMPRESS", (Parcelable)localObject);
          try
          {
            paramMessage.replyTo.send(localMessage);
            Log.v("ImageProcessService", "send MSG_COPY_AND_COMPRESS_IMAGE_RESPONSE flowId=" + paramMessage.arg1);
            try
            {
              Thread.sleep(300L);
              return;
            }
            catch (InterruptedException paramMessage)
            {
              return;
            }
            label307:
            ((ImageProcessData)localObject).msg = ("imageCompressCode=" + ImageProcessService.MILESTONE.getMilestoneValue() + " errorMsg=" + ImageProcessService.sMsg);
          }
          catch (RemoteException paramMessage)
          {
            for (;;)
            {
              Log.e("ImageProcessService", "ImageProcessService", paramMessage);
            }
          }
        }
      }
      Log.i("ImageProcessService", "receive MSG_OBTAIN_PID_REQUEST");
      try
      {
        localMessage = Message.obtain(null, 102);
        localMessage.arg1 = Process.myPid();
        paramMessage.replyTo.send(localMessage);
        Log.v("ImageProcessService", "send MSG_OBTAIN_PID_RESPONSE flowId=" + paramMessage.arg1);
        return;
      }
      catch (RemoteException paramMessage)
      {
        Log.e("ImageProcessService", "send MSG_OBTAIN_PID_RESPONSE:" + paramMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.imageservice.ImageProcessService
 * JD-Core Version:    0.7.0.1
 */