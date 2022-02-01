package com.tencent.image;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnDownloadCallbackListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnPreAdListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoOutputFrameListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

class QQLiveImage$4
  implements Runnable
{
  QQLiveImage$4(QQLiveImage paramQQLiveImage, Context paramContext, int paramInt) {}
  
  public void run()
  {
    if (!QQLiveImage.access$300())
    {
      TVK_SDKMgr.setDebugEnable(QQLiveImage.mIsDebugEnable);
      TVK_SDKMgr.initSdk(this.val$context, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      TVK_SDKMgr.setPreloadMaxStorageSize(524288000L);
      TVK_SDKMgr.setOnLogListener(new QQLiveImage.OnLogListener(null));
      QQLiveImage.access$302(true);
    }
    if (!TVK_SDKMgr.isInstalled(this.val$context))
    {
      if (QLog.isColorLevel()) {
        QLog.e(QQLiveImage.TAG + this.this$0.ID, 2, "initAndStartPlayer(): TVK_SDKMgr not install, mInstallProgress = " + QQLiveImage.access$100());
      }
      if (QQLiveImage.access$100().get()) {}
    }
    QQLiveDrawable.QQLiveDrawableParams localQQLiveDrawableParams;
    do
    {
      try
      {
        TVK_SDKMgr.installPlugin(this.val$context, new QQLiveImage.SDKInstallListener(null));
        return;
      }
      catch (Exception localException1)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e(QQLiveImage.TAG + this.this$0.ID, 2, "initAndStartPlayer(): Exception happens in TVK_SDKMgr.installPlugin", localException1);
        return;
      }
      localQQLiveDrawableParams = this.this$0.mParams;
    } while (localQQLiveDrawableParams == null);
    int i;
    if (localQQLiveDrawableParams.mDataSourceType == 2)
    {
      if (localQQLiveDrawableParams.mDataSourceAdapter == null) {
        break label936;
      }
      synchronized (this.this$0)
      {
        if (localQQLiveDrawableParams.mDataSourceAdapter == null) {
          break label340;
        }
        i = localQQLiveDrawableParams.mDataSourceAdapter.getStaus();
        if (QLog.isColorLevel()) {
          QLog.d(QQLiveImage.TAG + this.this$0.ID, 2, "initAndStartPlayer(): DATA_SOURCE_TYPE_THIRD，status = " + i);
        }
        if (i == 0)
        {
          localQQLiveDrawableParams.mDataSourceAdapter.requestPrepare(localQQLiveDrawableParams.mDataSource, new QQLiveImage.4.1(this, localQQLiveDrawableParams));
          return;
        }
      }
      if (i == 1)
      {
        return;
        label340:
        if (QLog.isColorLevel()) {
          QLog.e(QQLiveImage.TAG + this.this$0.ID, 2, "initAndStartPlayer(): DATA_SOURCE_TYPE_THIRD，mParams.mDataSourceAdapter == null 1 ");
        }
        return;
      }
    }
    if (QQLiveImage.access$600(this.this$0) == null) {
      QQLiveImage.access$602(this.this$0, TVK_SDKMgr.getProxyFactory());
    }
    long l;
    if (QQLiveImage.access$700(this.this$0) == null) {
      synchronized (this.this$0)
      {
        if (QQLiveImage.access$700(this.this$0) == null)
        {
          QQLiveImage.access$702(this.this$0, QQLiveImage.access$600(this.this$0).createMediaPlayer(this.val$context, null));
          if (QLog.isColorLevel()) {
            QLog.d(QQLiveImage.TAG + this.this$0.ID, 2, "initAndStartPlayer(): Runnable start ====> startPosi = " + this.val$startPosi);
          }
          QQLiveImage.access$802(this.this$0, SystemClock.uptimeMillis());
          if (QQLiveImage.access$900(this.this$0) <= 0L) {
            break label1067;
          }
          l = SystemClock.uptimeMillis() - QQLiveImage.access$900(this.this$0);
          label556:
          QQLiveImage.access$1000(this.this$0, 8, Long.valueOf(l));
          QQLiveImage.access$1102(this.this$0, new TVK_UserInfo("", ""));
          if (localObject1.mDataSourceType != 0) {
            break label1074;
          }
          QQLiveImage.access$1202(this.this$0, new TVK_PlayerVideoInfo(8, localObject1.mDataSource, ""));
          label620:
          if (localObject1.mPlayType != 1) {
            break label1092;
          }
          QQLiveImage.access$1200(this.this$0).setPlayType(1);
          label640:
          QQLiveImage.access$1200(this.this$0).setPlayMode("extern_video_output");
          ??? = new HashMap();
          if (TextUtils.isEmpty(localObject1.mReportTag)) {
            break label1230;
          }
          ((Map)???).put("shouq_bus_type", localObject1.mReportTag);
          label688:
          if (QLog.isColorLevel()) {
            QLog.d(QQLiveImage.TAG, 2, "initAndStartPlayer(): report tag=" + localObject1.mReportTag);
          }
          QQLiveImage.access$1200(this.this$0).setReportInfoMap((Map)???);
          if (!TextUtils.isEmpty(localObject1.mServerType)) {
            QQLiveImage.access$1200(this.this$0).setConfigMap("cache_servers_type", localObject1.mServerType);
          }
          if (!TextUtils.isEmpty(localObject1.mSavePath)) {
            QQLiveImage.access$1200(this.this$0).setConfigMap("file_dir", localObject1.mSavePath);
          }
          if (localObject1.mDuraion > 0) {
            QQLiveImage.access$1200(this.this$0).setConfigMap("duration", String.valueOf(localObject1.mDuraion));
          }
          if (!TextUtils.isEmpty(localObject1.mVid)) {
            QQLiveImage.access$1200(this.this$0).setVid(localObject1.mVid);
          }
          QQLiveImage.access$1200(this.this$0).addExtraParamsMap("shouq_bus_type", "bus_type_kandian_feeds");
        }
      }
    }
    for (;;)
    {
      try
      {
        ??? = this.this$0;
        if (??? != null)
        {
          TVK_IMediaPlayer localTVK_IMediaPlayer = QQLiveImage.access$700(this.this$0);
          if (localTVK_IMediaPlayer != null) {}
        }
        else
        {
          try
          {
            return;
          }
          finally {}
          label936:
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e(QQLiveImage.TAG + this.this$0.ID, 2, "initAndStartPlayer(): DATA_SOURCE_TYPE_THIRD，mParams.mDataSourceAdapter == null 2");
          return;
          if (QLog.isColorLevel()) {
            QLog.w(QQLiveImage.TAG + this.this$0.ID, 2, "initAndStartPlayer(): mVideoPlayer has been initialed, 1 just return");
          }
          return;
          localObject3 = finally;
          throw localObject3;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.w(QQLiveImage.TAG + this.this$0.ID, 2, "initAndStartPlayer(): mVideoPlayer has been initialed, 2 just return");
          return;
          label1067:
          l = -1L;
          break label556;
          label1074:
          QQLiveImage.access$1202(this.this$0, new TVK_PlayerVideoInfo());
          break label620;
          label1092:
          if (localObject3.mPlayType == 2)
          {
            QQLiveImage.access$1200(this.this$0).setPlayType(4);
            break label640;
          }
          if ((localObject3.mPlayType == 3) && (localObject3.mDataSourceAdapter != null))
          {
            i = this.this$0.mParams.mDataSourceAdapter.getPlayType();
            if (i == 2)
            {
              QQLiveImage.access$1200(this.this$0).setPlayType(4);
              break label640;
            }
            if (i == 1)
            {
              QQLiveImage.access$1200(this.this$0).setPlayType(1);
              break label640;
            }
            if (i == 0)
            {
              QQLiveImage.access$1200(this.this$0).setPlayType(2);
              break label640;
            }
            QQLiveImage.access$1200(this.this$0).setPlayType(2);
            break label640;
          }
          QQLiveImage.access$1200(this.this$0).setPlayType(2);
          break label640;
          label1230:
          ((Map)???).put("shouq_bus_type", "bus_type_aio");
          break label688;
        }
        QQLiveImage.access$700(this.this$0).setOnVideoOutputFrameListener((TVK_IMediaPlayer.OnVideoOutputFrameListener)???);
        QQLiveImage.access$700(this.this$0).setOnInfoListener((TVK_IMediaPlayer.OnInfoListener)???);
        QQLiveImage.access$700(this.this$0).setOnPreAdListener((TVK_IMediaPlayer.OnPreAdListener)???);
        QQLiveImage.access$700(this.this$0).setOnCompletionListener((TVK_IMediaPlayer.OnCompletionListener)???);
        QQLiveImage.access$700(this.this$0).setOnVideoPreparedListener((TVK_IMediaPlayer.OnVideoPreparedListener)???);
        QQLiveImage.access$700(this.this$0).setOnErrorListener((TVK_IMediaPlayer.OnErrorListener)???);
        QQLiveImage.access$700(this.this$0).setOnSeekCompleteListener((TVK_IMediaPlayer.OnSeekCompleteListener)???);
        QQLiveImage.access$700(this.this$0).setOnDownloadCallback((TVK_IMediaPlayer.OnDownloadCallbackListener)???);
        QQLiveImage.access$700(this.this$0).setLoopback(localObject3.mLoopback);
        QQLiveImage.access$700(this.this$0).setOutputMute(localObject3.mMute);
        if (localObject3.mDataSourceType != 0) {
          continue;
        }
        QQLiveImage.access$700(this.this$0).openMediaPlayer(QQLiveImage.getApplicationContext(), QQLiveImage.access$1100(this.this$0), QQLiveImage.access$1200(this.this$0), "", this.val$startPosi, 0L);
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(QQLiveImage.TAG + this.this$0.ID, 2, "initAndStartPlayer(): error happens in openMediaPlayer ", localException2);
        this.this$0.onError(QQLiveImage.access$700(this.this$0), 0, 0, 0, "inner error when openMediaPlayer", null);
        QLog.d(QQLiveImage.TAG + this.this$0.ID, 1, "initAndStartPlayer(): <==== runnable end ");
        continue;
        if (localException2.mDataSourceType != 2) {
          break label1737;
        }
        if ((localException2.mDataSourceAdapter == null) || (localException2.mDataSourceAdapter.getStaus() != 2)) {
          continue;
        }
        QQLiveImage.access$700(this.this$0).openMediaPlayerByUrl(QQLiveImage.getApplicationContext(), localException2.mDataSourceAdapter.getURL(), this.val$startPosi, 0L, QQLiveImage.access$1200(this.this$0));
        continue;
      }
      finally
      {
        QLog.d(QQLiveImage.TAG + this.this$0.ID, 1, "initAndStartPlayer(): <==== runnable end ");
      }
      QQLiveImage.access$1000(this.this$0, 9, null);
      QLog.d(QQLiveImage.TAG + this.this$0.ID, 1, "initAndStartPlayer(): <==== runnable end ");
      return;
      if (localObject3.mDataSourceType == 1) {
        QQLiveImage.access$700(this.this$0).openMediaPlayerByUrl(QQLiveImage.getApplicationContext(), localObject3.mDataSource, this.val$startPosi, 0L, QQLiveImage.access$1200(this.this$0));
      } else {
        label1737:
        if (localObject4.mDataSourceType == 3) {
          QQLiveImage.access$700(this.this$0).openMediaPlayerByUrl(QQLiveImage.getApplicationContext(), localObject4.mDataSource, this.val$startPosi, 0L, QQLiveImage.access$1200(this.this$0));
        } else if (localObject4.mDataSourceType == 4) {
          QQLiveImage.access$700(this.this$0).openMediaPlayerByUrl(QQLiveImage.getApplicationContext(), localObject4.mUrls, this.val$startPosi, 0L, QQLiveImage.access$1200(this.this$0), null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.image.QQLiveImage.4
 * JD-Core Version:    0.7.0.1
 */