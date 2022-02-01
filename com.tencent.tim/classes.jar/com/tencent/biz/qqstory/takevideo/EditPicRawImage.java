package com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import aqhu;
import auru;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import ram;
import ras;
import rba;
import rdb;
import rdc;
import rel;
import rkm;

public class EditPicRawImage
  extends rdb
  implements Handler.Callback, View.OnLayoutChangeListener, View.OnTouchListener, Runnable
{
  public static boolean aGG;
  public static final String[] bX;
  auru a;
  boolean aGD = false;
  int bpD = 0;
  Bitmap cx;
  float mDownX;
  float mDownY;
  ImageView mImageView;
  
  static
  {
    int i = 0;
    bX = new String[] { "MIX 2S", "Redmi Note 5" };
    String str1 = Build.MODEL;
    String[] arrayOfString = bX;
    int j = arrayOfString.length;
    while (i < j)
    {
      String str2 = arrayOfString[i];
      if (str1.equalsIgnoreCase(str2))
      {
        aGG = true;
        if (QLog.isColorLevel()) {
          QLog.d("EditPicActivity.EditVideoRawImage", 2, "IS_HEIGHT_PIXEL_CHANGE:" + str2);
        }
      }
      i += 1;
    }
  }
  
  public EditPicRawImage(@NonNull rdc paramrdc)
  {
    super(paramrdc);
    this.jdField_a_of_type_Auru = new auru(Looper.getMainLooper(), this);
  }
  
  public static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int i = paramOptions.outWidth;
    int j = 1;
    if ((k > paramInt2) || (i > paramInt1))
    {
      k /= 2;
      int m = i / 2;
      i = 2;
      for (;;)
      {
        if (k / i <= paramInt2)
        {
          j = i;
          if (m / i <= paramInt1) {
            break;
          }
        }
        i *= 2;
      }
    }
    return j;
  }
  
  public Bitmap V()
  {
    return this.cx;
  }
  
  public void a(int paramInt, @NonNull rkm paramrkm)
  {
    paramrkm.a.cK = this.cx;
  }
  
  void bss()
  {
    Object localObject1 = this.cx;
    Object localObject2 = this.mImageView.getImageMatrix();
    float[] arrayOfFloat = new float[9];
    ((Matrix)localObject2).getValues(arrayOfFloat);
    float f4 = arrayOfFloat[0];
    localObject2 = this.jdField_a_of_type_Rel.getActivity().getResources().getDisplayMetrics();
    int k = ((DisplayMetrics)localObject2).widthPixels;
    int j = ((DisplayMetrics)localObject2).heightPixels;
    int i = j;
    if (aGG)
    {
      i = j;
      if (this.bpD != 0) {
        i = this.bpD;
      }
    }
    j = ((Bitmap)localObject1).getWidth();
    int m = ((Bitmap)localObject1).getHeight();
    float f1 = i / k;
    float f2;
    float f3;
    if (m / j > f1)
    {
      f2 = i;
      f1 = i / m;
      f3 = j * f1 + 0.5F;
    }
    for (;;)
    {
      localObject1 = new RectF(0.0F, 0.0F, f3, f2);
      ram.i("EditPicActivity.EditVideoRawImage", "getDisplayBounds " + localObject1 + " scale " + f1 + " old scale " + f4);
      localObject2 = (rba)a(rba.class);
      if (localObject2 != null) {}
      try
      {
        ((rba)localObject2).dZ((int)((RectF)localObject1).width(), (int)((RectF)localObject1).height());
        if (QLog.isColorLevel()) {
          QLog.d("EditPicActivity.EditVideoRawImage", 2, "resizeDoodleView width:" + ((RectF)localObject1).width() + " height:" + ((RectF)localObject1).height());
        }
        return;
      }
      catch (Exception localException) {}
      f3 = k;
      f1 = k / j;
      f2 = m * f1 + 0.5F;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_Rel.getActivity().isFinishing()) {
      QLog.e("EditPicActivity.EditVideoRawImage", 1, "handleMessage isFinishing" + paramMessage.what);
    }
    do
    {
      do
      {
        return false;
        if (paramMessage.what == 998)
        {
          QQToast.a(this.jdField_a_of_type_Rel.getActivity().getApplicationContext(), this.jdField_a_of_type_Rel.getActivity().getResources().getString(2131721221), 0).show();
          this.jdField_a_of_type_Rel.a(0, null, 2130772067, 0);
          return false;
        }
      } while (paramMessage.what != 999);
      paramMessage = (Bitmap)paramMessage.obj;
      if (this.b.a.asi == 1) {
        setBitmap(paramMessage, true);
      }
      for (;;)
      {
        this.b.btf();
        if ((!(this.b.a.a instanceof EditLocalPhotoSource)) || (this.b.a.tg() == 1) || (this.b.a.tg() == 103) || (this.b.a.tg() == 11)) {
          break;
        }
        this.b.a(Message.obtain(null, 2, 1, 0));
        return false;
        setBitmap(paramMessage, false);
      }
    } while (!this.aGD);
    this.b.a(Message.obtain(null, 2, 2, 0));
    return false;
  }
  
  public void onCreate()
  {
    super.onCreate();
    ThreadManager.post(this, 8, null, false);
    this.mImageView = ((ImageView)y(2131376633));
    if (this.b.a.asi == 1) {
      this.mImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }
    this.mImageView.setOnTouchListener(this);
    this.mImageView.addOnLayoutChangeListener(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Auru.removeMessages(999);
    this.mImageView.removeOnLayoutChangeListener(this);
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (aGG)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EditPicActivity.EditVideoRawImage", 1, "onLayoutChange, height pixel change" + paramInt1 + " " + paramInt2 + " " + paramInt3 + " " + paramInt4 + " " + paramInt5 + " " + paramInt6 + " " + paramInt7 + " " + paramInt8 + " ");
      }
      if (paramInt8 != paramInt4) {
        this.bpD = (paramInt4 - paramInt2);
      }
    }
    try
    {
      bss();
      return;
    }
    catch (Throwable paramView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("EditPicActivity.EditVideoRawImage", 1, "onLayoutChange, resizeDoodleView Throwable" + paramView.getMessage());
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return true;
      this.mDownX = paramMotionEvent.getX();
      this.mDownY = paramMotionEvent.getY();
      continue;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if ((Math.abs(f1 - this.mDownX) < 10.0F) && (Math.abs(f2 - this.mDownY) < 10.0F) && (this.b.bqq != 12)) {
        if (this.b.a.asi != 2)
        {
          this.b.changeState(5);
          ras.sp("0X80075D7");
        }
        else if (this.b.bqq == 0)
        {
          this.b.changeState(27);
        }
        else if (this.b.bqq == 27)
        {
          this.b.changeState(0);
        }
      }
    }
  }
  
  public void p(int paramInt, Object paramObject)
  {
    if (paramInt == 11)
    {
      this.mImageView.setVisibility(8);
      return;
    }
    this.mImageView.setVisibility(0);
  }
  
  public void run()
  {
    Object localObject2 = this.b.a.a.getSourcePath();
    Object localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
    BitmapFactory.decodeFile((String)localObject2, (BitmapFactory.Options)localObject1);
    if ((((BitmapFactory.Options)localObject1).outWidth < 64) || (((BitmapFactory.Options)localObject1).outHeight < 64))
    {
      QLog.e("EditPicActivity.EditVideoRawImage", 1, "too small");
      this.jdField_a_of_type_Auru.sendEmptyMessage(998);
      return;
    }
    DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_Rel.getActivity().getResources().getDisplayMetrics();
    int i = calculateInSampleSize((BitmapFactory.Options)localObject1, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
    ((BitmapFactory.Options)localObject1).inSampleSize = i;
    try
    {
      localObject1 = aqhu.d((String)localObject2, (BitmapFactory.Options)localObject1);
      if (localObject1 == null)
      {
        QLog.e("EditPicActivity.EditVideoRawImage", 1, "decode" + null);
        this.jdField_a_of_type_Rel.a(0, null, 2130772067, 0);
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Bitmap localBitmap;
      for (;;)
      {
        QLog.e("EditPicActivity.EditVideoRawImage", 1, "decodeoom");
        localBitmap = null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EditPicActivity.EditVideoRawImage", 2, "sampleSize" + i + " w " + localBitmap.getWidth() + " h " + localBitmap.getHeight());
      }
      i = aqhu.getExifOrientation((String)localObject2);
      localObject2 = localBitmap;
      if (i != 0)
      {
        localObject2 = localBitmap;
        if (i % 90 == 0)
        {
          if (this.b.b != null) {
            this.b.b.bpO = i;
          }
          if (QLog.isColorLevel()) {
            QLog.d("EditPicActivity.EditVideoRawImage", 2, "has exif rotate" + i);
          }
          int j = localBitmap.getWidth();
          int k = localBitmap.getHeight();
          localObject2 = new Matrix();
          ((Matrix)localObject2).postRotate(i, j / 2.0F, k / 2.0F);
          localObject2 = Bitmap.createBitmap(localBitmap, 0, 0, j, k, (Matrix)localObject2, true);
        }
      }
      this.jdField_a_of_type_Auru.obtainMessage(999, localObject2).sendToTarget();
    }
  }
  
  public void setBitmap(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramBitmap == this.cx) {}
    do
    {
      return;
      if ((this.cx != null) && (!this.cx.isRecycled())) {
        this.cx.recycle();
      }
      this.cx = paramBitmap;
      this.mImageView.setImageBitmap(this.cx);
      if (Build.MANUFACTURER.equalsIgnoreCase("Letv"))
      {
        this.mImageView.destroyDrawingCache();
        this.mImageView.refreshDrawableState();
        this.mImageView.invalidate();
      }
    } while (paramBoolean);
    bss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditPicRawImage
 * JD-Core Version:    0.7.0.1
 */