package com.tencent.mobileqq.shortvideo.mediadevice;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import anhm;
import anhy;
import aniq;
import anis;
import anlb;
import aqhq;
import avtc;
import awed;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.maxvideo.MaxVideoConst;
import com.tencent.maxvideo.mediadevice.EncodeVideo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import pnx;
import rar;

public class EncodeThread
  implements MaxVideoConst, Runnable
{
  private String JF;
  private EncodeVideo a;
  private boolean aHe;
  private long alK = -1L;
  private long alL = -1L;
  private long alM = -1L;
  private long alN = -1L;
  private boolean bxn = true;
  private boolean cGW;
  private boolean cGX;
  private boolean cGY;
  protected boolean cGZ;
  public String cdZ;
  private String cej;
  public int errorCode;
  private PublishVideoEntry j;
  private Handler mHandler;
  private byte[] mMosaicMask;
  private int mMosaicSize;
  private int mOrientationDegree;
  
  public EncodeThread(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3)
  {
    this.mHandler = paramHandler;
    this.cej = paramString1;
    this.JF = paramString3;
    this.a = new EncodeVideo(this.mHandler);
    this.cdZ = paramString2;
    this.cGW = true;
    this.bxn = true;
    this.cGX = false;
    this.cGY = false;
  }
  
  public static void cancelCurrentEncoder()
  {
    try
    {
      EncodeVideo.cancelCurrentEncoder();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  private void dJ(int paramInt, String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    localMessage.arg1 = paramInt;
    localMessage.getData().putString("maxvideo.file.mp4", paramString);
    localMessage.getData().putString("source_path", this.cej);
    localMessage.getData().putString("client_key", this.JF);
    if ((paramInt == 0) && (this.j != null))
    {
      localMessage.getData().putString("key_background_music_path", this.j.backgroundMusicPath);
      localMessage.getData().putInt("key_background_music_offset", this.j.backgroundMusicOffset);
      localMessage.getData().putString("key_doodle_path", this.j.doodlePath);
      localMessage.getData().putString("key_local_raw_video_dir", this.j.mLocalRawVideoDir);
      localMessage.getData().putInt("key_video_width", this.j.videoWidth);
      localMessage.getData().putInt("key_video_height", this.j.videoHeight);
    }
    doNotify(localMessage);
  }
  
  private void dQv()
  {
    if (this.mHandler == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    doNotify(localMessage);
  }
  
  private void doNotify(Message paramMessage)
  {
    if (this.mHandler != null) {}
    try
    {
      this.mHandler.sendMessage(paramMessage);
      return;
    }
    catch (Exception paramMessage) {}
  }
  
  private int startEncode(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (this.cGY) {
      aniq.PV(this.cGY);
    }
    int[] arrayOfInt = aniq.aa();
    aniq.PV(false);
    if ((this.mMosaicMask != null) && (this.mMosaicSize != 0))
    {
      EncodeVideo localEncodeVideo = this.a;
      EncodeVideo.setMosaicData(this.mMosaicMask, this.mMosaicSize);
    }
    long l1 = SystemClock.uptimeMillis();
    try
    {
      i = this.a.startPartEncode(paramString1, this.alK, this.alL, paramString2, this.alM, this.alN, paramString3, paramString4, arrayOfInt);
      rar.b("take_video", "create_mp4_result", 0, i, new String[0]);
      if (i == 0)
      {
        long l2 = SystemClock.uptimeMillis();
        rar.b("take_video", "create_mp4_time", 0, 0, new String[] { "" + (l2 - l1) });
        pnx.a(paramString4, this.j);
      }
      aniq.bsT = 0;
      aniq.dHm = 23;
      if ((this.mMosaicMask != null) && (this.mMosaicSize != 0)) {
        EncodeVideo.setMosaicData(null, 0);
      }
      return i;
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      for (;;)
      {
        int k = -200;
        int i = k;
        if (QLog.isColorLevel())
        {
          QLog.e("startPartEncode", 2, "exception:", paramString1);
          i = k;
        }
      }
    }
  }
  
  public void CN(boolean paramBoolean)
  {
    this.bxn = paramBoolean;
  }
  
  public void PW(boolean paramBoolean)
  {
    this.cGW = paramBoolean;
  }
  
  public void PX(boolean paramBoolean)
  {
    this.cGY = paramBoolean;
  }
  
  public void PY(boolean paramBoolean)
  {
    this.cGZ = paramBoolean;
  }
  
  public void PZ(boolean paramBoolean)
  {
    this.aHe = paramBoolean;
  }
  
  public void UY(int paramInt)
  {
    this.mOrientationDegree = paramInt;
  }
  
  public void d(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.alK = paramLong1;
    this.alL = paramLong2;
    this.alM = paramLong3;
    this.alN = paramLong4;
  }
  
  public void q(byte[] paramArrayOfByte, int paramInt)
  {
    this.mMosaicMask = paramArrayOfByte;
    this.mMosaicSize = paramInt;
  }
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    this.errorCode = 0;
    if (TextUtils.isEmpty(this.cej))
    {
      this.errorCode = 5100;
      dJ(this.errorCode, null);
      awed.ad(anhm.sUin + "", "qzone_video_record", "9", null);
      label67:
      return;
    }
    File localFile = new File(this.cej);
    if ((!localFile.exists()) || (!localFile.isDirectory()))
    {
      this.errorCode = 5100;
      dJ(this.errorCode, null);
      awed.ad(anhm.sUin + "", "qzone_video_record", "9", null);
      return;
    }
    String[] arrayOfString = localFile.list();
    if (arrayOfString == null)
    {
      this.errorCode = 5101;
      if (QLog.isColorLevel()) {
        QLog.d("MaxVideo.Plugin", 2, "EncodeThread empty dir, mSourceDirString = " + this.cej);
      }
      dJ(this.errorCode, null);
      awed.ad(anhm.sUin + "", "qzone_video_record", "9", null);
      return;
    }
    int k = arrayOfString.length;
    String str1 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    int i = 0;
    if (i < k)
    {
      String str2 = arrayOfString[i];
      if (str2.endsWith(".vf"))
      {
        localObject4 = this.cej + File.separator + str2;
        localObject3 = localObject1;
      }
      for (;;)
      {
        i += 1;
        localObject1 = localObject3;
        localObject2 = localObject4;
        break;
        if (str2.endsWith(".af"))
        {
          localObject3 = this.cej + File.separator + str2;
          localObject4 = localObject2;
        }
        else
        {
          localObject3 = localObject1;
          localObject4 = localObject2;
          if (str2.endsWith(".ini"))
          {
            str1 = this.cej + File.separator + str2;
            localObject3 = localObject1;
            localObject4 = localObject2;
          }
        }
      }
    }
    if ((!aqhq.fileExists(localObject2)) || (!aqhq.fileExists(localObject1)) || (!aqhq.fileExists(str1)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MaxVideo.Plugin", 2, "EncodeThread empty file, mSourceDirString = " + this.cej + ",vfFilePath = " + localObject2 + ",afFilePath = " + localObject1 + ",manifestFilePath = " + str1);
      }
      this.errorCode = 5101;
      dJ(this.errorCode, null);
      awed.ad(anhm.sUin + "", "qzone_video_record", "9", null);
      return;
    }
    if (this.aHe)
    {
      str1 = avtc.cNq;
      localObject3 = anlb.w(localFile);
      localObject4 = new File(str1 + File.separator + "gif");
      if ((((File)localObject4).exists()) && (!((File)localObject4).isDirectory())) {
        ((File)localObject4).delete();
      }
      if (!((File)localObject4).exists()) {
        ((File)localObject4).mkdir();
      }
      str1 = str1 + File.separator + "gif" + File.separator + (String)localObject3 + ".gif";
      l1 = System.currentTimeMillis();
      i = anis.a(localObject2, localObject1, this.mOrientationDegree, str1);
      QLog.i("MaxVideo.Plugin", 1, "generateGifFromVFile cost=" + (System.currentTimeMillis() - l1) + " ret=" + i);
      this.cdZ = str1;
      if ((i == 0) && (this.bxn)) {
        aqhq.cn(this.cej);
      }
      if (i == 0) {}
      for (i = 0;; i = 5109)
      {
        this.errorCode = i;
        dJ(this.errorCode, str1);
        return;
      }
    }
    if (this.cGX) {
      aqhq.deleteFile(localObject1);
    }
    try
    {
      aqhq.createFile(localObject1);
      localObject4 = this.cdZ;
      if (!TextUtils.isEmpty((CharSequence)localObject4)) {
        break label1597;
      }
      localObject3 = avtc.cNq;
      localObject4 = new File((String)localObject3);
      if ((!((File)localObject4).mkdirs()) && (!((File)localObject4).isDirectory()))
      {
        this.errorCode = 5102;
        dJ(this.errorCode, null);
        awed.ad(anhm.sUin + "", "qzone_video_record", "10", null);
        return;
      }
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MaxVideo.Plugin", 2, "EncodeThread: createFile audiofile... ", localIOException);
      }
      this.errorCode = 5108;
      dJ(this.errorCode, null);
      return;
    }
    Object localObject4 = anlb.w(localFile);
    Object localObject3 = (String)localObject3 + File.separator + (String)localObject4 + ".mp4";
    this.cdZ = ((String)localObject3);
    label1024:
    dQv();
    if (this.cGW) {
      localObject4 = new anhy(localObject2, localIOException, this.cej);
    }
    for (;;)
    {
      try
      {
        i = ((anhy)localObject4).Ju();
        if (i == 0)
        {
          this.cdZ = ((anhy)localObject4).zS();
          boolean bool = aqhq.fileExistsAndNotEmpty(this.cdZ);
          if (QLog.isColorLevel()) {
            QLog.d("MaxVideo.Plugin", 2, "EncodeThread hwEncode success, mTargetFilePath = " + this.cdZ + ", isExist = " + bool);
          }
          awed.t(anhm.sUin + "", "qzone_video_record", "record_hw_success", "0", null);
          if (QLog.isColorLevel()) {
            QLog.d("MaxVideo.Plugin", 2, "EncodeThread hwEncode serrcode = " + i);
          }
          int m = 0;
          k = i;
          i = m;
          if (QLog.isColorLevel()) {
            QLog.d("MaxVideo.Plugin", 2, "EncodeThread hwEncode start soft errcode = " + k + " mEnableHardEncode=" + this.cGW);
          }
          if (k == -1)
          {
            if (!this.cGZ) {
              continue;
            }
            localObject4 = "";
            i = startEncode(localObject2, (String)localObject4, str1, (String)localObject3);
            QLog.i("MaxVideo.Plugin", 1, "EncodeThread hwEncode start soft over ret = " + i);
            if (i != 0) {
              continue;
            }
            awed.t(anhm.sUin + "", "qzone_video_record", "record_sw_success", "0", null);
          }
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("vfFilePath is " + localObject2);
            ((StringBuilder)localObject4).append('\n');
            ((StringBuilder)localObject4).append("afFilePath is " + localIOException);
            ((StringBuilder)localObject4).append('\n');
            ((StringBuilder)localObject4).append("manifestFilePath is " + str1);
            ((StringBuilder)localObject4).append('\n');
            ((StringBuilder)localObject4).append("targetFile is " + (String)localObject3);
            QLog.i("MaxVideo.Plugin", 2, ((StringBuilder)localObject4).toString());
          }
          if (i != 0) {
            continue;
          }
          awed.t(anhm.sUin + "", "qzone_video_record", "record_success", "0", null);
          switch (i)
          {
          default: 
            if (this.errorCode == 5103) {
              break label67;
            }
            dJ(this.errorCode, (String)localObject3);
            return;
            label1597:
            localFile = new File((String)localObject4).getParentFile();
            localObject3 = localObject4;
            if (localFile == null) {
              break label1024;
            }
            localObject3 = localObject4;
            if (localFile.exists()) {
              break label1024;
            }
            localFile.mkdirs();
            localObject3 = localObject4;
          }
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        localUnsatisfiedLinkError.printStackTrace();
        i = -1;
        continue;
      }
      catch (NoSuchMethodError localNoSuchMethodError)
      {
        localNoSuchMethodError.printStackTrace();
        i = -1;
        continue;
        awed.t(anhm.sUin + "", "qzone_video_record", "record_hw_success", "1", i + "_" + Build.MODEL);
        continue;
        localObject4 = localIOException;
        continue;
        awed.t(anhm.sUin + "", "qzone_video_record", "record_sw_success", "1", i + "_" + Build.MODEL);
        continue;
        awed.t(anhm.sUin + "", "qzone_video_record", "record_success", "1", i + "_" + Build.MODEL);
        continue;
        this.errorCode = 0;
        long l2 = System.currentTimeMillis();
        QLog.i("MaxVideo.Plugin", 1, "encode af vf to mp4, cost=" + (l2 - l1));
        if (!this.bxn) {
          continue;
        }
        aqhq.cn(this.cej);
        QLog.i("MaxVideo.Plugin", 1, "EncodeThread encode success delete cache... cost=" + (System.currentTimeMillis() - l2));
        continue;
        this.errorCode = 5104;
        continue;
        this.errorCode = 5105;
        continue;
        this.errorCode = 5106;
        continue;
        this.errorCode = 5107;
        continue;
        this.errorCode = 5103;
        continue;
      }
      i = 0;
      k = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread
 * JD-Core Version:    0.7.0.1
 */