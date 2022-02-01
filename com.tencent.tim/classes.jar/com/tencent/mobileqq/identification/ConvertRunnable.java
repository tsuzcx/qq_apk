package com.tencent.mobileqq.identification;

import ahbj;
import alxh;
import amae;
import amal;
import aman;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.support.annotation.RequiresApi;
import anih;
import aqft;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import rlt;
import rox;

@RequiresApi(api=18)
public class ConvertRunnable
  implements amal, Runnable
{
  private static int dcR = 0;
  private long Cj;
  private long Ck;
  private aman jdField_a_of_type_Aman;
  private QQFilterRenderManager jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
  private String aBi;
  private int cLt;
  private Bitmap cM;
  private byte[][] f;
  private int mHeight;
  private WeakReference<a> mListenerRef;
  private int mResult;
  private volatile boolean mRun;
  private long mTimeStamp;
  private int mWidth;
  
  private boolean LG()
  {
    if ((!this.mRun) && (QLog.isColorLevel())) {
      QLog.d("identification_convert", 2, "run exit:" + this.Cj + " run:" + this.mRun);
    }
    return !this.mRun;
  }
  
  private boolean LH()
  {
    if ((this.jdField_a_of_type_Aman == null) || (this.cLt >= this.f.length)) {}
    int i;
    do
    {
      return false;
      byte[][] arrayOfByte = this.f;
      i = this.cLt;
      this.cLt = (i + 1);
      this.cM = nv21ToBitmap(arrayOfByte[i], this.mWidth, this.mHeight);
      i = GlUtil.createTexture(3553, this.cM);
      if (this.cM != null)
      {
        this.cM.recycle();
        this.cM = null;
      }
    } while (i <= 0);
    this.jdField_a_of_type_Aman.f(3553, i, null, null, this.mTimeStamp);
    this.mTimeStamp += 50000000L;
    return true;
  }
  
  private void a(int paramInt, String paramString, MediaFormat paramMediaFormat)
  {
    if (this.mListenerRef != null)
    {
      a locala = (a)this.mListenerRef.get();
      if (locala != null)
      {
        rlt localrlt = new rlt();
        localrlt.mID = this.Cj;
        localrlt.mResult = paramInt;
        localrlt.mFile = paramString;
        localrlt.mMediaFormat = paramMediaFormat;
        locala.a(localrlt);
      }
    }
  }
  
  private void bvn()
  {
    if (QLog.isColorLevel()) {
      QLog.d("identification_convert", 2, "run begin, taskid:" + this.Cj + " run:" + this.mRun);
    }
    if (LG()) {
      a(9, null, null);
    }
    do
    {
      return;
      long l1 = System.currentTimeMillis();
      this.mTimeStamp = 0L;
      if (LG())
      {
        a(9, null, null);
        return;
      }
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("identification_convert", 2, "run, start convert, taskid:" + this.Cj + " create bitmap cost: " + (l2 - l1) + " ms");
      }
      l1 = System.currentTimeMillis();
      this.jdField_a_of_type_Aman = new aman();
      amae localamae = new amae(this.aBi, this.mWidth, this.mHeight, alxh.a().iS(1) * 1000, 1, false, 270);
      localamae.a(EGL14.eglGetCurrentContext());
      this.jdField_a_of_type_Aman.a(localamae, this);
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("identification_convert", 2, "run, init encoder, taskid:" + this.Cj + "  encoder init cost: " + (l2 - l1) + " ms");
      }
    } while (!QLog.isColorLevel());
    QLog.d("identification_convert", 2, "run end, taskid:" + this.Cj);
  }
  
  public static int getImageFormat()
  {
    if (dcR != 0) {
      return dcR;
    }
    if (anih.a().lz(17)) {
      dcR = 17;
    }
    for (;;)
    {
      return dcR;
      if (anih.a().lz(842094169)) {
        dcR = 842094169;
      } else if (anih.a().lz(20)) {
        dcR = 20;
      } else if (anih.a().lz(4)) {
        dcR = 4;
      } else if (anih.a().lz(256)) {
        dcR = 256;
      } else if (anih.a().lz(16)) {
        dcR = 16;
      }
    }
  }
  
  private static Bitmap nv21ToBitmap(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject = new YuvImage(paramArrayOfByte, getImageFormat(), paramInt1, paramInt2, null);
    paramArrayOfByte = new ByteArrayOutputStream();
    ((YuvImage)localObject).compressToJpeg(new Rect(0, 0, paramInt1, paramInt2), 80, paramArrayOfByte);
    localObject = BitmapFactory.decodeByteArray(paramArrayOfByte.toByteArray(), 0, paramArrayOfByte.size());
    aqft.d(paramArrayOfByte);
    return localObject;
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("identification_convert", 2, "onEncodeError, code:" + paramInt + " taskID:" + this.Cj + " run:" + this.mRun);
    }
    if (this.mRun)
    {
      this.mRun = false;
      this.mResult = 7;
      a(this.mResult, this.aBi, null);
    }
  }
  
  public void auv()
  {
    if (this.mRun)
    {
      if (QLog.isColorLevel()) {
        QLog.d("identification_convert", 2, "onEncodeStart, taskid:" + this.Cj);
      }
      this.Ck = System.currentTimeMillis();
      LH();
    }
    do
    {
      return;
      if (this.cM != null)
      {
        this.cM.recycle();
        this.cM = null;
      }
    } while (this.jdField_a_of_type_Aman == null);
    this.jdField_a_of_type_Aman.stopRecording();
  }
  
  public void btD()
  {
    if (!this.mRun)
    {
      if (QLog.isColorLevel()) {
        QLog.d("identification_convert", 2, "onEncodeFrame, mRun is false, tasid." + this.Cj);
      }
      if (this.jdField_a_of_type_Aman != null) {
        this.jdField_a_of_type_Aman.stopRecording();
      }
    }
    do
    {
      do
      {
        return;
      } while (LH());
      if (QLog.isColorLevel()) {
        QLog.d("identification_convert", 2, "onEncodeFrame, stop recoder");
      }
      if (this.jdField_a_of_type_Aman != null) {
        this.jdField_a_of_type_Aman.stopRecording();
      }
    } while (!QLog.isColorLevel());
    QLog.d("identification_convert", 2, "onEncodeFrame, stop recoder, taskid:" + this.Cj);
  }
  
  public void kf(String paramString)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("identification_convert", 2, "onEncodeFinish, taskid:" + this.Cj + " run:" + this.mRun + " finish cost: " + (l - this.Ck) + " ms");
    }
    if (this.mRun)
    {
      if (QLog.isColorLevel()) {
        QLog.d("identification_convert", 2, "onEncodeFinish:" + this.Cj + " file:" + this.aBi);
      }
      this.mResult = 0;
      if (ahbj.isFileExists(this.aBi))
      {
        l = ahbj.getFileSize(this.aBi);
        if (QLog.isColorLevel()) {
          QLog.d("identification_convert", 2, "onEncodeFinish, file exist, size:" + l + " file:" + this.aBi);
        }
        paramString = this.jdField_a_of_type_Aman.getMediaFormat();
        a(this.mResult, this.aBi, paramString);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceDestroyed();
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
      }
      if (this.jdField_a_of_type_Aman != null)
      {
        this.jdField_a_of_type_Aman.release();
        this.jdField_a_of_type_Aman = null;
      }
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("identification_convert", 2, "onEncodeFinish, file not exist:" + this.Cj + " file:" + this.aBi);
      break;
      rox.fB(paramString);
    }
  }
  
  public void run()
  {
    bvn();
  }
  
  public static abstract interface a
  {
    public abstract void a(rlt paramrlt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.identification.ConvertRunnable
 * JD-Core Version:    0.7.0.1
 */