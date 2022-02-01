package com.tencent.biz.qqstory.takevideo.slideshow;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.os.Handler;
import aqhq;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EglHandlerThread;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.LinkedList;
import rlt;

public class Image2Video
  implements ConvertRunnable.a
{
  public static final String ROOT_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/com.tencent.mobileqq/qq/video/imagevideo/";
  public static final String aBl = ROOT_PATH + "cache/";
  private LinkedList<a> A;
  private EglHandlerThreadEx a;
  private boolean aIM;
  private HashMap<Long, a> fx;
  private Context mContext;
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat, int paramInt, boolean paramBoolean)
  {
    if ((paramInt < 1) || (paramBitmap == null)) {
      paramBitmap = null;
    }
    int i14;
    int i15;
    Bitmap localBitmap;
    do
    {
      return paramBitmap;
      i14 = paramBitmap.getWidth();
      i15 = paramBitmap.getHeight();
      paramBitmap = Bitmap.createScaledBitmap(paramBitmap, Math.round(i14 * paramFloat), Math.round(i15 * paramFloat), false);
      localBitmap = paramBitmap.copy(paramBitmap.getConfig(), true);
      int i16 = localBitmap.getWidth();
      int i17 = localBitmap.getHeight();
      paramBitmap = new int[i16 * i17];
      localBitmap.getPixels(paramBitmap, 0, i16, 0, 0, i16, i17);
      int i21 = i16 - 1;
      int i18 = i17 - 1;
      int i = i16 * i17;
      int i19 = paramInt + paramInt + 1;
      int[] arrayOfInt1 = new int[i];
      int[] arrayOfInt2 = new int[i];
      int[] arrayOfInt3 = new int[i];
      int[] arrayOfInt4 = new int[Math.max(i16, i17)];
      i = i19 + 1 >> 1;
      int j = i * i;
      int[] arrayOfInt5 = new int[j * 256];
      i = 0;
      while (i < j * 256)
      {
        arrayOfInt5[i] = (i / j);
        i += 1;
      }
      int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { i19, 3 });
      int i20 = paramInt + 1;
      int i7 = 0;
      int i6 = 0;
      i = 0;
      int m;
      int i8;
      int i2;
      int k;
      int i1;
      int i3;
      int i4;
      int i5;
      int n;
      int i9;
      int[] arrayOfInt6;
      int i10;
      int i11;
      int i12;
      while (i7 < i17)
      {
        m = 0;
        i8 = -paramInt;
        j = 0;
        i2 = 0;
        k = 0;
        i1 = 0;
        i3 = 0;
        i4 = 0;
        i5 = 0;
        n = 0;
        if (i8 <= paramInt)
        {
          i9 = paramBitmap[(Math.min(i21, Math.max(i8, 0)) + i)];
          arrayOfInt6 = arrayOfInt[(i8 + paramInt)];
          arrayOfInt6[0] = ((0xFF0000 & i9) >> 16);
          arrayOfInt6[1] = ((0xFF00 & i9) >> 8);
          arrayOfInt6[2] = (i9 & 0xFF);
          i9 = i20 - Math.abs(i8);
          i3 += arrayOfInt6[0] * i9;
          i4 += arrayOfInt6[1] * i9;
          i5 += i9 * arrayOfInt6[2];
          if (i8 > 0)
          {
            m += arrayOfInt6[0];
            n += arrayOfInt6[1];
            j += arrayOfInt6[2];
          }
          for (;;)
          {
            i8 += 1;
            break;
            i2 += arrayOfInt6[0];
            k += arrayOfInt6[1];
            i1 += arrayOfInt6[2];
          }
        }
        i10 = i3;
        i11 = i1;
        i8 = n;
        i3 = paramInt;
        i12 = j;
        i9 = m;
        int i13 = 0;
        m = i5;
        i1 = i4;
        i4 = i10;
        j = i11;
        n = i2;
        i5 = i12;
        i2 = i13;
        while (i2 < i16)
        {
          arrayOfInt1[i] = arrayOfInt5[i4];
          arrayOfInt2[i] = arrayOfInt5[i1];
          arrayOfInt3[i] = arrayOfInt5[m];
          arrayOfInt6 = arrayOfInt[((i3 - paramInt + i19) % i19)];
          i12 = arrayOfInt6[0];
          i11 = arrayOfInt6[1];
          i10 = arrayOfInt6[2];
          if (i7 == 0) {
            arrayOfInt4[i2] = Math.min(i2 + paramInt + 1, i21);
          }
          i13 = paramBitmap[(arrayOfInt4[i2] + i6)];
          arrayOfInt6[0] = ((0xFF0000 & i13) >> 16);
          arrayOfInt6[1] = ((0xFF00 & i13) >> 8);
          arrayOfInt6[2] = (i13 & 0xFF);
          i9 += arrayOfInt6[0];
          i8 += arrayOfInt6[1];
          i5 += arrayOfInt6[2];
          i4 = i4 - n + i9;
          i1 = i1 - k + i8;
          m = m - j + i5;
          i3 = (i3 + 1) % i19;
          arrayOfInt6 = arrayOfInt[(i3 % i19)];
          n = n - i12 + arrayOfInt6[0];
          k = k - i11 + arrayOfInt6[1];
          j = j - i10 + arrayOfInt6[2];
          i9 -= arrayOfInt6[0];
          i8 -= arrayOfInt6[1];
          i5 -= arrayOfInt6[2];
          i += 1;
          i2 += 1;
        }
        i7 += 1;
        i6 += i16;
      }
      i = 0;
      while (i < i16)
      {
        m = 0;
        i7 = -paramInt * i16;
        i6 = -paramInt;
        j = 0;
        n = 0;
        i1 = 0;
        i2 = 0;
        i3 = 0;
        i4 = 0;
        i5 = 0;
        k = 0;
        if (i6 <= paramInt)
        {
          i9 = Math.max(0, i7) + i;
          arrayOfInt6 = arrayOfInt[(i6 + paramInt)];
          arrayOfInt6[0] = arrayOfInt1[i9];
          arrayOfInt6[1] = arrayOfInt2[i9];
          arrayOfInt6[2] = arrayOfInt3[i9];
          i10 = i20 - Math.abs(i6);
          i8 = i3 + arrayOfInt1[i9] * i10;
          i4 += arrayOfInt2[i9] * i10;
          i5 += arrayOfInt3[i9] * i10;
          if (i6 > 0)
          {
            m += arrayOfInt6[0];
            k += arrayOfInt6[1];
            j += arrayOfInt6[2];
          }
          for (;;)
          {
            i3 = i7;
            if (i6 < i18) {
              i3 = i7 + i16;
            }
            i6 += 1;
            i7 = i3;
            i3 = i8;
            break;
            n += arrayOfInt6[0];
            i1 += arrayOfInt6[1];
            i2 += arrayOfInt6[2];
          }
        }
        i6 = 0;
        i7 = i;
        i9 = paramInt;
        i8 = j;
        j = i9;
        while (i6 < i17)
        {
          paramBitmap[i7] = (0xFF000000 & paramBitmap[i7] | arrayOfInt5[i3] << 16 | arrayOfInt5[i4] << 8 | arrayOfInt5[i5]);
          arrayOfInt6 = arrayOfInt[((j - paramInt + i19) % i19)];
          i11 = arrayOfInt6[0];
          i10 = arrayOfInt6[1];
          i9 = arrayOfInt6[2];
          if (i == 0) {
            arrayOfInt4[i6] = (Math.min(i6 + i20, i18) * i16);
          }
          i12 = arrayOfInt4[i6] + i;
          arrayOfInt6[0] = arrayOfInt1[i12];
          arrayOfInt6[1] = arrayOfInt2[i12];
          arrayOfInt6[2] = arrayOfInt3[i12];
          m += arrayOfInt6[0];
          k += arrayOfInt6[1];
          i8 += arrayOfInt6[2];
          i3 = i3 - n + m;
          i4 = i4 - i1 + k;
          i5 = i5 - i2 + i8;
          j = (j + 1) % i19;
          arrayOfInt6 = arrayOfInt[j];
          n = n - i11 + arrayOfInt6[0];
          i1 = i1 - i10 + arrayOfInt6[1];
          i2 = i2 - i9 + arrayOfInt6[2];
          m -= arrayOfInt6[0];
          k -= arrayOfInt6[1];
          i8 -= arrayOfInt6[2];
          i7 += i16;
          i6 += 1;
        }
        i += 1;
      }
      localBitmap.setPixels(paramBitmap, 0, i16, 0, 0, i16, i17);
      paramBitmap = localBitmap;
    } while (!paramBoolean);
    return Bitmap.createScaledBitmap(localBitmap, i14, i15, true);
  }
  
  private void bvo()
  {
    try
    {
      if (this.fx.size() > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Image2Video", 2, "tryStartPendingTask,[not start new request] mRunningTasks.size=:" + this.fx.size());
        }
        return;
      }
      if (this.A.size() <= 0) {
        break label199;
      }
      a locala = (a)this.A.removeFirst();
      if (locala == null) {
        return;
      }
    }
    finally {}
    this.fx.put(Long.valueOf(localObject.Cj), localObject);
    ConvertRunnable localConvertRunnable = new ConvertRunnable(this.mContext, localObject.Cj, localObject.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo, localObject.mWidth, localObject.mHeight, localObject.mDuration, this.aIM, this);
    if (this.a != null)
    {
      localObject.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowConvertRunnable = localConvertRunnable;
      this.a.getHandler().post(localConvertRunnable);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Image2Video", 2, "tryStartPendingTask, taskid:" + localObject.Cj);
    }
    for (;;)
    {
      return;
      label199:
      if (QLog.isColorLevel()) {
        QLog.d("Image2Video", 2, "tryStartPendingTask, no pending task:");
      }
    }
  }
  
  public static String na()
  {
    String str = ROOT_PATH + "/noaudio";
    aqhq.UD(str);
    return str;
  }
  
  public void a(rlt paramrlt)
  {
    if (paramrlt == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Image2Video", 2, "onConvertResult, resultinfo is null!!!");
      }
    }
    Object localObject;
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Image2Video", 2, "onConvertResult, taskId:" + paramrlt.mID + ", resultcode:" + paramrlt.mResult + ", image:" + paramrlt.aBm + ". destfile:" + paramrlt.mFile);
          }
          try
          {
            localObject = (a)this.fx.remove(Long.valueOf(paramrlt.mID));
            if (localObject == null)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("Image2Video", 2, "onConvertResult, task not exist.");
            }
          }
          finally {}
        }
        if (paramrlt.mResult != 7) {
          break;
        }
        localObject = (b)((a)localObject).mListenerRef.get();
      } while (localObject == null);
      ((b)localObject).b(paramrlt);
      return;
      if (paramrlt.mResult == 0) {
        bvo();
      }
      localObject = (b)((a)localObject).mListenerRef.get();
    } while (localObject == null);
    ((b)localObject).b(paramrlt);
  }
  
  public static class EglHandlerThreadEx
    extends EglHandlerThread
  {
    private WeakReference<Object> mSynObjectRef;
    
    public void onLooperPrepared()
    {
      super.onLooperPrepared();
      if (this.mSynObjectRef != null)
      {
        Object localObject1 = this.mSynObjectRef.get();
        if (localObject1 != null) {
          try
          {
            localObject1.notify();
            return;
          }
          finally {}
        }
      }
    }
  }
  
  static class a
  {
    public static int MAX_RETRY_TIMES = 3;
    public long Cj;
    public ConvertRunnable a;
    public SlideItemInfo a;
    public long mDuration;
    public int mHeight;
    public WeakReference<Image2Video.b> mListenerRef;
    public int mWidth;
  }
  
  public static abstract interface b
  {
    public abstract void b(rlt paramrlt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.Image2Video
 * JD-Core Version:    0.7.0.1
 */