package com.tencent.mobileqq.voicechange;

import aliv;
import aliv.a;
import aliw;
import aliy;
import android.content.Context;
import android.media.AudioTrack;
import android.os.Process;
import android.text.TextUtils;
import aomq;
import aqlv;
import aqxm;
import aqxn;
import aqxp;
import aqxr;
import aqxu;
import com.tencent.mobileqq.utils.AmrInputStreamWrapper;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.mobileqq.utils.WechatNsWrapper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class QQVoiceChangerThread
  extends Thread
  implements aliw
{
  aqxm jdField_a_of_type_Aqxm;
  aqxn jdField_a_of_type_Aqxn;
  aqxr jdField_a_of_type_Aqxr;
  private aliy jdField_b_of_type_Aliy;
  private FileInputStream jdField_b_of_type_JavaIoFileInputStream;
  private boolean cWN;
  private Context context;
  int currentPosition = 0;
  public String cyy;
  int edw = 0;
  private String filePath;
  private byte[] gK = new byte[960];
  public volatile boolean isRunning = true;
  private AudioTrack mAudioTrack;
  private FileOutputStream p;
  int totalSize = 0;
  
  public QQVoiceChangerThread(Context paramContext, aqxn paramaqxn, aqxr paramaqxr, String paramString, aqxm paramaqxm)
  {
    this.context = paramContext;
    this.filePath = paramaqxn.aHD;
    this.jdField_a_of_type_Aqxn = paramaqxn;
    this.jdField_a_of_type_Aqxr = paramaqxr;
    this.cyy = paramString;
    this.jdField_a_of_type_Aqxm = paramaqxm;
    if (QLog.isColorLevel()) {
      QLog.d("QQVoiceChanger", 2, "new QQVoiceChangerThread filePath=" + this.filePath + " sampleRate=" + paramaqxn.sampleRate + " bitRate=" + paramaqxn.bitRate + " voiceType=" + paramaqxn.voiceType + " changeType=" + paramaqxn.changeType);
    }
  }
  
  private void cleanUp()
    throws IOException
  {
    if (this.mAudioTrack != null) {
      this.mAudioTrack.release();
    }
    if (this.jdField_b_of_type_Aliy != null) {
      this.jdField_b_of_type_Aliy.release();
    }
    if (this.jdField_b_of_type_JavaIoFileInputStream != null) {
      this.jdField_b_of_type_JavaIoFileInputStream.close();
    }
    if (this.p != null) {
      this.p.close();
    }
    if (this.cWN) {
      aqxu.iw(this.jdField_a_of_type_Aqxn.aHD, this.filePath);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQVoiceChanger", 2, "clean up requestToCancel=" + this.cWN);
    }
  }
  
  private void egg()
    throws IOException
  {
    String str = this.jdField_a_of_type_Aqxr.cyC;
    if (!TextUtils.isEmpty(str)) {}
    for (this.filePath = str;; this.filePath = aqxu.pW(this.filePath))
    {
      this.jdField_b_of_type_JavaIoFileInputStream = new FileInputStream(this.filePath);
      if (QLog.isColorLevel()) {
        QLog.d("QQVoiceChanger", 2, "open:" + this.filePath + " a=" + this.jdField_b_of_type_JavaIoFileInputStream.available());
      }
      return;
    }
  }
  
  private void s(byte[] paramArrayOfByte, int paramInt)
  {
    int i = (int)AudioHelper.a(this.context, paramArrayOfByte, paramInt, 1.0F);
    if (this.jdField_a_of_type_Aqxm != null) {
      this.jdField_a_of_type_Aqxm.ad(i, this.currentPosition * 100 / this.totalSize, this.edw);
    }
    this.mAudioTrack.write(paramArrayOfByte, 0, paramInt);
  }
  
  protected void Ya(int paramInt)
    throws IOException
  {
    File localFile = new File(aqxu.aM(this.jdField_a_of_type_Aqxn.aHD, paramInt));
    localFile.createNewFile();
    this.p = new FileOutputStream(localFile);
  }
  
  public void a(aliv paramaliv, aliv.a parama)
  {
    if (((paramaliv instanceof VoiceChange)) && (!this.jdField_a_of_type_Aqxr.needCompress) && (this.jdField_a_of_type_Aqxr.aIS)) {
      s(parama.data, parama.size);
    }
  }
  
  public void b(aliv paramaliv, aliv.a parama)
  {
    if (((paramaliv instanceof SilkCodecWrapper)) || ((paramaliv instanceof AmrInputStreamWrapper)))
    {
      this.edw += (int)QQRecorder.a(this.jdField_a_of_type_Aqxn.sampleRate, 4, 2, parama.size);
      if (this.jdField_a_of_type_Aqxr.aIS) {
        s(parama.data, parama.size);
      }
    }
  }
  
  protected void egf()
    throws IOException
  {
    this.totalSize = this.jdField_b_of_type_JavaIoFileInputStream.available();
    if (QLog.isColorLevel()) {
      QLog.d("QQVoiceChanger", 2, "start progress totalSize=" + this.totalSize + " filePath=" + this.filePath + "pcmFilePath=" + this.jdField_a_of_type_Aqxn.aHD);
    }
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j;
      if (this.isRunning)
      {
        j = k;
        if (this.jdField_a_of_type_Aqxr.cWR)
        {
          j = k;
          if (k == 0)
          {
            if (this.jdField_a_of_type_Aqxn.voiceType != 0) {
              break label261;
            }
            this.jdField_b_of_type_JavaIoFileInputStream.skip("#!AMR\n".length());
            j = 1;
          }
        }
      }
      label261:
      aliv.a locala;
      try
      {
        k = this.jdField_b_of_type_JavaIoFileInputStream.read(this.gK, 0, 960);
        if (k == -1)
        {
          this.isRunning = false;
          if (this.jdField_a_of_type_Aqxm != null) {
            this.jdField_a_of_type_Aqxm.buY();
          }
          aomq.jK(4, this.edw);
          aqxp.a(this.edw, this.jdField_a_of_type_Aqxn.aHD, this.filePath, this.jdField_a_of_type_Aqxn.changeType, this.jdField_a_of_type_Aqxn.voiceType);
          if (QLog.isColorLevel()) {
            QLog.d("QQVoiceChanger", 2, "finishedCompress playedTime=" + this.edw);
          }
          for (;;)
          {
            if (this.jdField_a_of_type_Aqxm != null) {
              this.jdField_a_of_type_Aqxm.onPlayStop();
            }
            return;
            if (this.jdField_a_of_type_Aqxn.voiceType == 1)
            {
              this.jdField_b_of_type_JavaIoFileInputStream.skip(10L);
              break;
            }
            if (this.jdField_a_of_type_Aqxn.voiceType != 2) {
              break;
            }
            j = this.jdField_b_of_type_JavaIoFileInputStream.read(this.gK, 0, 64);
            if ((j == 64) && (this.p != null))
            {
              this.p.write(this.gK, 0, j);
              this.p.flush();
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("QQVoiceChanger", 2, "copy AFPCM failed!");
            }
          }
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.d("QQVoiceChanger", 2, "read failed" + localIOException.getStackTrace());
          }
        }
        this.currentPosition += k;
        locala = this.jdField_b_of_type_Aliy.a(this.gK, 0, k);
        aomq.dVW();
        if ((this.p != null) && (this.jdField_a_of_type_Aqxr.needCompress))
        {
          int m = i;
          if (i == 0)
          {
            byte[] arrayOfByte = aqlv.c(this.jdField_a_of_type_Aqxn.voiceType, this.jdField_a_of_type_Aqxn.sampleRate);
            this.p.write(arrayOfByte, 0, arrayOfByte.length);
            this.p.flush();
            m = 1;
          }
          k = j;
          i = m;
          if (locala == null) {
            continue;
          }
          this.p.write(locala.data, 0, locala.size);
          this.p.flush();
          k = j;
          i = m;
          continue;
        }
        k = j;
      }
      if (this.p != null)
      {
        k = j;
        if (locala != null)
        {
          this.p.write(locala.data, 0, locala.size);
          this.p.flush();
          k = j;
        }
      }
    }
  }
  
  public void egh()
  {
    this.jdField_a_of_type_Aqxr.aIS = false;
    this.jdField_a_of_type_Aqxm = null;
    if (QLog.isColorLevel()) {
      QLog.d("QQVoiceChanger", 2, "requestToSend isRunning=" + this.isRunning);
    }
  }
  
  public void egi()
  {
    if (!this.isRunning) {
      aqxu.ix(this.jdField_a_of_type_Aqxn.aHD, this.filePath);
    }
    this.jdField_a_of_type_Aqxm = null;
    this.isRunning = false;
    this.cWN = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQVoiceChanger", 2, "requestToCancel isRunning=" + this.isRunning);
    }
  }
  
  protected void initAudio()
  {
    int i = AudioTrack.getMinBufferSize(this.jdField_a_of_type_Aqxn.sampleRate, this.jdField_a_of_type_Aqxn.channel, this.jdField_a_of_type_Aqxn.sampleSize);
    this.mAudioTrack = new AudioTrack(3, this.jdField_a_of_type_Aqxn.sampleRate, 4, 2, i, 1);
    this.mAudioTrack.play();
  }
  
  public void run()
  {
    Process.setThreadPriority(-19);
    this.jdField_b_of_type_Aliy = new aliy();
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Aqxn.changeType == 0) {
          this.jdField_a_of_type_Aqxr.cWQ = false;
        }
        if (this.jdField_a_of_type_Aqxr.cWQ) {
          this.jdField_b_of_type_Aliy.a(new VoiceChange(this.context, this.jdField_a_of_type_Aqxn.changeType, this.cyy));
        }
        if (this.jdField_a_of_type_Aqxr.cWP)
        {
          WechatNsWrapper localWechatNsWrapper = new WechatNsWrapper(this.context);
          if (WechatNsWrapper.soLoaded) {
            this.jdField_b_of_type_Aliy.a(localWechatNsWrapper);
          }
        }
        if (this.jdField_a_of_type_Aqxr.needCompress)
        {
          if (this.jdField_a_of_type_Aqxn.voiceType == 0) {
            this.jdField_b_of_type_Aliy.a(new AmrInputStreamWrapper(this.context));
          }
        }
        else
        {
          egg();
          Ya(this.jdField_a_of_type_Aqxn.changeType);
          this.jdField_b_of_type_Aliy.init(this.jdField_a_of_type_Aqxn.sampleRate, this.jdField_a_of_type_Aqxn.bitRate, this.jdField_a_of_type_Aqxn.voiceType);
          this.jdField_b_of_type_Aliy.a(this);
          initAudio();
          egf();
        }
      }
      catch (IOException localIOException1)
      {
        localIOException1 = localIOException1;
        localIOException1.printStackTrace();
        if (this.jdField_a_of_type_Aqxm != null) {
          this.jdField_a_of_type_Aqxm.onError();
        }
        try
        {
          cleanUp();
          return;
        }
        catch (IOException localIOException2)
        {
          localIOException2.printStackTrace();
          return;
        }
      }
      catch (Exception localException)
      {
        localException = localException;
        if (this.jdField_a_of_type_Aqxm == null) {
          continue;
        }
        this.jdField_a_of_type_Aqxm.onError();
        localException.printStackTrace();
        try
        {
          cleanUp();
          return;
        }
        catch (IOException localIOException4)
        {
          localIOException4.printStackTrace();
          return;
        }
      }
      finally {}
      try
      {
        cleanUp();
        return;
      }
      catch (IOException localIOException3)
      {
        localIOException3.printStackTrace();
        return;
      }
      this.jdField_b_of_type_Aliy.a(new SilkCodecWrapper(this.context));
    }
    try
    {
      cleanUp();
      throw localObject;
    }
    catch (IOException localIOException5)
    {
      for (;;)
      {
        localIOException5.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.voicechange.QQVoiceChangerThread
 * JD-Core Version:    0.7.0.1
 */