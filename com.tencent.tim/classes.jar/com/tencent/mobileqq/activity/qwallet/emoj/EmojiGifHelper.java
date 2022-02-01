package com.tencent.mobileqq.activity.qwallet.emoj;

import aafv;
import aagd;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseArray;
import anis;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class EmojiGifHelper
{
  private static final String TAG = "EmojiGifHelper";
  private static volatile EmojiGifHelper sInstance;
  private SparseArray<EmojiInfo> mEmojiInfos = new SparseArray();
  
  public static void compositeAndTransToGif(ConvertParam paramConvertParam, OnConvertListener paramOnConvertListener)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime == null) && (paramOnConvertListener != null)) {
      paramOnConvertListener.onConvertResult(false, null);
    }
    if ((localAppRuntime instanceof QQAppInterface))
    {
      getInstance().compositeAndTransToGifInner(paramConvertParam, paramOnConvertListener);
      return;
    }
    aafv.a(paramConvertParam, new EmojiGifHelper.1(paramOnConvertListener));
  }
  
  public static EmojiGifHelper getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new EmojiGifHelper();
      }
      return sInstance;
    }
    finally {}
  }
  
  public static void removeTask(int paramInt)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null) {
      return;
    }
    if ((localAppRuntime instanceof QQAppInterface))
    {
      getInstance().removeTaskInner(paramInt);
      return;
    }
    aafv.removeTask(paramInt);
  }
  
  private void sendPicToAIO(EmojiInfo paramEmojiInfo)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity == null) {}
    while ((paramEmojiInfo == null) || (paramEmojiInfo.sessionInfo == null) || (TextUtils.isEmpty(paramEmojiInfo.gifPath))) {
      return;
    }
    Intent localIntent = new Intent(localBaseActivity, SendPhotoActivity.class);
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1007);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramEmojiInfo.gifPath);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    localIntent.putExtra("PhotoConst.PHOTO_COUNT", localArrayList.size());
    localIntent.putExtra("uin", paramEmojiInfo.sessionInfo.aTl);
    localIntent.putExtra("uintype", paramEmojiInfo.sessionInfo.cZ);
    localIntent.putExtra("troop_uin", paramEmojiInfo.sessionInfo.troopUin);
    localIntent.putExtra("key_confess_topicid", paramEmojiInfo.sessionInfo.topicId);
    localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    localIntent.putExtra("entrance", paramEmojiInfo.sessionInfo.entrance);
    if (localArrayList.size() == 1) {
      localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", localArrayList);
    }
    localBaseActivity.startActivity(localIntent);
    this.mEmojiInfos.remove(paramEmojiInfo.tag);
  }
  
  public void attachTask(ConvertParam arg1, CompositeTask paramCompositeTask)
  {
    if ((??? == null) || (paramCompositeTask == null)) {}
    EmojiInfo localEmojiInfo;
    do
    {
      return;
      localEmojiInfo = (EmojiInfo)this.mEmojiInfos.get(???.tag);
    } while (localEmojiInfo == null);
    synchronized (localEmojiInfo.lock)
    {
      if (localEmojiInfo.task != null) {
        localEmojiInfo.task.cancel();
      }
      localEmojiInfo.task = paramCompositeTask;
      paramCompositeTask.emojiInfo = localEmojiInfo;
      return;
    }
  }
  
  public void bind(SessionInfo paramSessionInfo, int paramInt)
  {
    EmojiInfo localEmojiInfo = new EmojiInfo();
    localEmojiInfo.sessionInfo = paramSessionInfo;
    localEmojiInfo.tag = paramInt;
    this.mEmojiInfos.put(paramInt, localEmojiInfo);
  }
  
  public void compositeAndTransToGifInner(ConvertParam paramConvertParam, OnConvertListener paramOnConvertListener)
  {
    if (paramConvertParam == null)
    {
      if (paramOnConvertListener != null) {
        paramOnConvertListener.onConvertResult(false, null);
      }
      return;
    }
    paramOnConvertListener = new CompositeTask(paramConvertParam, paramOnConvertListener);
    attachTask(paramConvertParam, paramOnConvertListener);
    paramOnConvertListener.run();
  }
  
  public void removeTaskInner(int paramInt)
  {
    EmojiInfo localEmojiInfo = (EmojiInfo)this.mEmojiInfos.get(paramInt);
    if (localEmojiInfo != null) {
      localEmojiInfo.removeTask();
    }
  }
  
  public void trySendPicToAIO(int paramInt)
  {
    EmojiInfo localEmojiInfo1 = (EmojiInfo)this.mEmojiInfos.get(paramInt);
    if (localEmojiInfo1 == null) {}
    do
    {
      return;
      byte[] arrayOfByte = localEmojiInfo1.lock;
      if (localEmojiInfo1 != null) {
        try
        {
          if (TextUtils.isEmpty(localEmojiInfo1.gifPath))
          {
            if (QLog.isColorLevel()) {
              QLog.i("EmojiGifHelper", 2, "trySendPicToAIO waiting to send");
            }
            localEmojiInfo1.isImmeSend = true;
            return;
          }
        }
        finally {}
      }
      if (QLog.isColorLevel()) {
        QLog.i("EmojiGifHelper", 2, "trySendPicToAIO immediately send");
      }
    } while ((localEmojiInfo2 == null) || (TextUtils.isEmpty(localEmojiInfo2.gifPath)));
    sendPicToAIO(localEmojiInfo2);
  }
  
  public void unbind(int paramInt)
  {
    EmojiInfo localEmojiInfo = (EmojiInfo)this.mEmojiInfos.get(paramInt);
    if (localEmojiInfo != null) {
      localEmojiInfo.onDestroy();
    }
    this.mEmojiInfos.remove(paramInt);
  }
  
  public class CompositeTask
    implements Runnable
  {
    public EmojiGifHelper.EmojiInfo emojiInfo;
    public boolean isCancel;
    public EmojiGifHelper.OnConvertListener l;
    public EmojiGifHelper.ConvertParam publishParam;
    
    CompositeTask(EmojiGifHelper.ConvertParam paramConvertParam, EmojiGifHelper.OnConvertListener paramOnConvertListener)
    {
      this.publishParam = paramConvertParam;
      this.l = paramOnConvertListener;
    }
    
    private String getGifPath()
    {
      String str = aagd.au(null) + "Camera/";
      File localFile = new File(str + "gif");
      if ((localFile.exists()) && (!localFile.isDirectory())) {
        localFile.delete();
      }
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      return str + "gif" + File.separator + System.currentTimeMillis() + ".gif";
    }
    
    public void cancel()
    {
      synchronized (this.emojiInfo.lock)
      {
        this.isCancel = true;
        return;
      }
    }
    
    public boolean convertVideoToGif(EmojiGifHelper.ConvertParam paramConvertParam, String paramString)
    {
      boolean bool = false;
      try
      {
        int i = anis.a(paramConvertParam.inPath, paramConvertParam.videoWidth, paramConvertParam.videoHeight, paramConvertParam.videoDuration, paramString, 7, 30, 100);
        if (QLog.isColorLevel()) {
          QLog.i("EmojiGifHelper", 2, "Video2GifConverter: convert retCode=" + i);
        }
        if (i == 0) {
          bool = true;
        }
        return bool;
      }
      catch (Throwable paramConvertParam)
      {
        QLog.e("EmojiGifHelper", 2, "processNotExistVideoData: convert exception" + paramConvertParam);
      }
      return false;
    }
    
    public void onTransResult(boolean paramBoolean, String paramString, EmojiGifHelper.OnConvertListener arg3, EmojiGifHelper.ConvertParam paramConvertParam)
    {
      if (this.isCancel) {}
      for (;;)
      {
        return;
        if (??? != null)
        {
          if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {
            break label96;
          }
          ???.onConvertResult(true, paramString);
        }
        while ((paramBoolean) && (this.emojiInfo != null))
        {
          synchronized (this.emojiInfo.lock)
          {
            if (!this.isCancel)
            {
              this.emojiInfo.gifPath = paramString;
              if (this.emojiInfo.isImmeSend) {
                EmojiGifHelper.this.sendPicToAIO(this.emojiInfo);
              }
            }
            return;
          }
          label96:
          ???.onConvertResult(false, null);
        }
      }
    }
    
    public void run()
    {
      if (this.isCancel) {}
      String str;
      long l1;
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("EmojiGifHelper", 2, "begin convert gif, publishParam=" + this.publishParam);
        }
        str = getGifPath();
        l1 = System.currentTimeMillis();
      } while (this.isCancel);
      if (convertVideoToGif(this.publishParam, str))
      {
        if (QLog.isColorLevel()) {
          QLog.i("EmojiGifHelper", 2, "convertVideoToGif finished cost:" + (System.currentTimeMillis() - l1));
        }
        onTransResult(true, str, this.l, this.publishParam);
        return;
      }
      onTransResult(false, null, this.l, this.publishParam);
    }
  }
  
  public static class ConvertParam
    implements Serializable
  {
    public String inPath;
    public int tag;
    public long videoDuration;
    public int videoHeight;
    public int videoWidth;
    
    public String toString()
    {
      return "ConvertParam{, videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", videoDuration=" + this.videoDuration + ", tag=" + this.tag + ", inPath='" + this.inPath + '\'' + '}';
    }
  }
  
  public static class EmojiInfo
  {
    public String gifPath;
    public boolean isImmeSend;
    public final byte[] lock = new byte[0];
    public SessionInfo sessionInfo;
    public int tag;
    public EmojiGifHelper.CompositeTask task;
    
    public void onDestroy()
    {
      removeTask();
    }
    
    public void removeTask()
    {
      if (this.task != null)
      {
        this.task.cancel();
        this.task = null;
      }
      this.gifPath = null;
    }
  }
  
  public static abstract interface OnConvertListener
  {
    public abstract void onConvertResult(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.EmojiGifHelper
 * JD-Core Version:    0.7.0.1
 */