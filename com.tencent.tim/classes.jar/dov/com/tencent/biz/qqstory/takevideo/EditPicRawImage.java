package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import aqhu;
import auru;
import axip;
import aydg;
import aygy;
import aygz;
import ayii;
import ayju;
import aymp;
import ayqb;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import ram;
import rop;
import rpv;

public class EditPicRawImage
  extends aygy
  implements Handler.Callback, View.OnLayoutChangeListener, View.OnTouchListener, Runnable
{
  public static int bpD;
  auru a;
  private long aCF;
  boolean aGD = false;
  Bitmap cx;
  boolean dyI = false;
  ImageView mImageView;
  
  public EditPicRawImage(@NonNull aygz paramaygz, long paramLong)
  {
    super(paramaygz);
    this.jdField_a_of_type_Auru = new auru(Looper.getMainLooper(), this);
    this.aCF = paramLong;
  }
  
  public static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int m = paramOptions.outHeight;
    int k = paramOptions.outWidth;
    int j = 1;
    int i = paramInt2;
    if (m > k * 6) {
      i = paramInt2 * 3;
    }
    paramInt2 = paramInt1;
    if (k > m * 6) {
      paramInt2 = paramInt1 * 3;
    }
    if ((m > i * 1.2F) || (k > paramInt2 * 1.2F))
    {
      m /= 2;
      k /= 2;
      paramInt1 = 2;
      for (;;)
      {
        if (m / paramInt1 <= i)
        {
          j = paramInt1;
          if (k / paramInt1 <= paramInt2) {
            break;
          }
        }
        paramInt1 *= 2;
      }
    }
    return j;
  }
  
  public Bitmap V()
  {
    return this.cx;
  }
  
  public void a(int paramInt, @NonNull ayqb paramayqb)
  {
    paramayqb.a.dAr = this.dyI;
    paramayqb.a.cK = this.cx;
  }
  
  void bss()
  {
    Object localObject1 = this.cx;
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = this.mImageView.getImageMatrix();
    float[] arrayOfFloat = new float[9];
    ((Matrix)localObject2).getValues(arrayOfFloat);
    float f4 = arrayOfFloat[0];
    localObject2 = this.jdField_a_of_type_Ayii.getActivity().getResources().getDisplayMetrics();
    int j = ((DisplayMetrics)localObject2).widthPixels;
    int i = ((DisplayMetrics)localObject2).heightPixels;
    if (QLog.isColorLevel()) {
      QLog.i("EditPicActivity.EditVideoRawImage", 2, "resizeDoodleView,imgH:" + i + " currentModelHeight:" + bpD);
    }
    if (bpD != 0) {
      i = bpD;
    }
    int k = ((Bitmap)localObject1).getWidth();
    int m = ((Bitmap)localObject1).getHeight();
    float f1 = i / j;
    float f2;
    float f3;
    if (m / k > f1)
    {
      f2 = i;
      f1 = i / m;
      f3 = k * f1 + 0.5F;
    }
    for (;;)
    {
      localObject1 = new RectF(0.0F, 0.0F, f3, f2);
      ram.i("EditPicActivity.EditVideoRawImage", "getDisplayBounds " + localObject1 + " scale " + f1 + " old scale " + f4);
      localObject2 = (aydg)a(aydg.class);
      if (localObject2 == null) {
        break;
      }
      try
      {
        ((aydg)localObject2).M((int)((RectF)localObject1).width(), (int)((RectF)localObject1).height(), false);
        return;
      }
      catch (Exception localException)
      {
        return;
      }
      f3 = j;
      f1 = j / k;
      f2 = m * f1 + 0.5F;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool;
    if ((this.jdField_a_of_type_Ayii == null) || (this.jdField_a_of_type_Ayii.getActivity() == null) || (this.jdField_a_of_type_Ayii.getActivity().isFinishing()))
    {
      paramMessage = "handleMessage isFinishing" + paramMessage.what + " mUi is null, ";
      if (this.jdField_a_of_type_Ayii == null)
      {
        bool = true;
        QLog.e("EditPicActivity.EditVideoRawImage", 1, new Object[] { paramMessage, Boolean.valueOf(bool) });
      }
    }
    do
    {
      do
      {
        return false;
        bool = false;
        break;
        if (paramMessage.what == 998)
        {
          QQToast.a(this.jdField_a_of_type_Ayii.getActivity().getApplicationContext(), this.jdField_a_of_type_Ayii.getActivity().getResources().getString(2131721221), 0).show();
          this.jdField_a_of_type_Ayii.a(0, null, 2130772067, 0);
          return false;
        }
      } while (paramMessage.what != 999);
      paramMessage = (Bitmap)paramMessage.obj;
      if ((this.b.a.asi == 1) || (this.b.a.th() == 8)) {
        setBitmap(paramMessage, true);
      }
      for (;;)
      {
        this.b.btf();
        if ((!(this.b.a.a instanceof EditLocalPhotoSource)) || (this.b.a.tg() == 1) || (this.b.a.tg() == 103)) {
          break;
        }
        this.b.a(Message.obtain(null, 2, 536870912, 0));
        return false;
        setBitmap(paramMessage, false);
      }
    } while (!this.aGD);
    this.b.a(Message.obtain(null, 2, 4, 0));
    return false;
  }
  
  public void onCreate()
  {
    super.onCreate();
    axip.a().setVideoDuration(-1L);
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
    bpD = 0;
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EditPicActivity.EditVideoRawImage", 2, "onLayoutChange, height pixel change,bottom:" + paramInt4 + " oldBottom:" + paramInt8 + " top:" + paramInt2 + " oldTop:" + paramInt6);
    }
    if ((paramInt8 != paramInt4) && (bpD == 0) && (paramInt4 > 0))
    {
      this.mImageView.removeOnLayoutChangeListener(this);
      bpD = paramInt4 - paramInt2;
      bss();
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return true;
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
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    aqhu.d((String)localObject2, localOptions);
    if ((localOptions.outWidth < 64) || (localOptions.outHeight < 64))
    {
      QLog.e("EditPicActivity.EditVideoRawImage", 1, "too small");
      this.jdField_a_of_type_Auru.sendEmptyMessage(998);
      return;
    }
    Object localObject1 = this.jdField_a_of_type_Ayii.getActivity().getResources().getDisplayMetrics();
    int i = calculateInSampleSize(localOptions, ((DisplayMetrics)localObject1).widthPixels, ((DisplayMetrics)localObject1).heightPixels);
    localOptions.inJustDecodeBounds = false;
    localOptions.inSampleSize = i;
    try
    {
      localObject1 = aqhu.d((String)localObject2, localOptions);
      if (localObject1 == null)
      {
        QLog.e("EditPicActivity.EditVideoRawImage", 1, "decode" + null);
        this.jdField_a_of_type_Ayii.a(0, null, 2130772067, 0);
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      Bitmap localBitmap3;
      for (;;)
      {
        QLog.e("EditPicActivity.EditVideoRawImage", 1, "decode oom" + localOptions.inSampleSize);
        localOptions.inSampleSize = (i * 2);
        try
        {
          Bitmap localBitmap1 = aqhu.d((String)localObject2, localOptions);
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          QLog.e("EditPicActivity.EditVideoRawImage", 1, "decode oom" + localOptions.inSampleSize);
          localOptions.inSampleSize = (i * 4);
          try
          {
            Bitmap localBitmap2 = aqhu.d((String)localObject2, localOptions);
          }
          catch (OutOfMemoryError localOutOfMemoryError3)
          {
            QLog.e("EditPicActivity.EditVideoRawImage", 1, "decode oom again" + localOptions.inSampleSize);
            localBitmap3 = null;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("EditPicActivity.EditVideoRawImage", 2, "sampleSize" + i + " w " + localBitmap3.getWidth() + " h " + localBitmap3.getHeight());
      }
      this.b.a.eKf = localBitmap3.getWidth();
      this.b.a.eKg = localBitmap3.getHeight();
      i = aqhu.getExifOrientation((String)localObject2);
      localObject2 = localBitmap3;
      if (i != 0)
      {
        localObject2 = localBitmap3;
        if (i % 90 == 0)
        {
          this.b.mOrientation = i;
          if (QLog.isColorLevel()) {
            QLog.d("EditPicActivity.EditVideoRawImage", 2, "has exif rotate" + i);
          }
          int j = localBitmap3.getWidth();
          int k = localBitmap3.getHeight();
          localObject2 = new Matrix();
          ((Matrix)localObject2).postRotate(i, j / 2.0F, k / 2.0F);
          localObject2 = Bitmap.createBitmap(localBitmap3, 0, 0, j, k, (Matrix)localObject2, true);
        }
      }
      this.jdField_a_of_type_Auru.obtainMessage(999, localObject2).sendToTarget();
    }
  }
  
  public void setBitmap(Bitmap paramBitmap, boolean paramBoolean)
  {
    if ((this.cx != null) && (!this.cx.isRecycled())) {
      this.cx.recycle();
    }
    int i = this.mImageView.getWidth();
    int j = this.mImageView.getHeight();
    this.cx = paramBitmap;
    Object localObject;
    if ((!this.dyI) && (!aygz.F(this.aCF, 68719476736L)) && (this.cx != null) && (this.b.bqq == 0))
    {
      this.dyI = true;
      if (rpv.c(this.cx.getWidth(), this.cx.getHeight(), i, j))
      {
        localObject = aqhu.a(getContext(), this.cx, 0.25F, 20.0F);
        if (localObject != null)
        {
          Canvas localCanvas = new Canvas();
          if (!((Bitmap)localObject).isMutable()) {
            break label293;
          }
          paramBitmap = (Bitmap)localObject;
          localCanvas.setBitmap(paramBitmap);
          localCanvas.drawColor(Color.parseColor("#3F000000"), PorterDuff.Mode.SRC_OVER);
          paramBitmap = rpv.a(this.cx.getWidth(), this.cx.getHeight(), i, j);
          this.cx = rop.b(rop.b((Bitmap)localObject, ((Integer)paramBitmap.first).intValue(), ((Integer)paramBitmap.second).intValue(), true), this.cx);
        }
      }
    }
    this.mImageView.setImageBitmap(this.cx);
    if (Build.MANUFACTURER.equalsIgnoreCase("Letv"))
    {
      this.mImageView.destroyDrawingCache();
      this.mImageView.refreshDrawableState();
      this.mImageView.invalidate();
    }
    if ((!paramBoolean) && (this.cx != null)) {
      bss();
    }
    label293:
    do
    {
      do
      {
        return;
        paramBitmap = ((Bitmap)localObject).copy(((Bitmap)localObject).getConfig(), true);
        break;
        paramBitmap = (aydg)a(aydg.class);
      } while (paramBitmap == null);
      localObject = (aymp)paramBitmap.a().a().a(104);
    } while (localObject == null);
    ((aymp)localObject).buE();
    ((aymp)localObject).buB();
    paramBitmap.a().eSK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditPicRawImage
 * JD-Core Version:    0.7.0.1
 */