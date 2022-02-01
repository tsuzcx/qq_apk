package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.util.LruCache;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import anpc;
import aoop;
import aqhu;
import auru;
import awdu;
import aydg;
import ayfh;
import aygy;
import aygz;
import ayii;
import ayqb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.widget.FastAnimationDrawable;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import ram;
import ras;

public class EditGifImage
  extends aygy
  implements Handler.Callback, View.OnTouchListener, Runnable
{
  public static final int bpv = awdu.eAm;
  public auru a;
  public FastAnimationDrawable a;
  public boolean aGo = false;
  public boolean aGp = false;
  boolean aGq = false;
  public boolean aGr = false;
  boolean aGs = false;
  boolean aGu = false;
  boolean aGv;
  boolean aGw;
  boolean aGx;
  FastAnimationDrawable b;
  Bitmap cx;
  float mDownX;
  float mDownY;
  URLImageView t;
  
  public EditGifImage(@NonNull aygz paramaygz)
  {
    super(paramaygz);
    this.jdField_a_of_type_Auru = new auru(Looper.getMainLooper(), this);
  }
  
  private void aA(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("module_name", paramString1);
    localHashMap.put("module_status", paramString2);
    if ((this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable != null) && (this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.mMemoryCache != null)) {
      localHashMap.put("module_frameNum", this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.mMemoryCache.size() + "");
    }
    localHashMap.put("module_exposeStatus", this.aGx + "");
    localHashMap.put("module_showStatus", this.aGv + "");
    localHashMap.put("module_resetStatus", this.aGw + "");
    try
    {
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "GifAntishakeModule", true, 0L, 0L, localHashMap, null);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("EditPicActivity.EditGifImage", 1, "reportToBeacon failed " + paramString1.getMessage());
    }
  }
  
  private void bsc()
  {
    if ((this.aGp) && (!this.aGr))
    {
      if (this.jdField_b_of_type_CooperationQzoneWidgetFastAnimationDrawable == null)
      {
        EditLocalGifSource localEditLocalGifSource = (EditLocalGifSource)this.jdField_b_of_type_Aygz.a.a;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = this.jdField_b_of_type_Aygz.a.a.getWidth();
        localURLDrawableOptions.mRequestHeight = this.jdField_b_of_type_Aygz.a.a.getHeight();
        localURLDrawableOptions.mLoadingDrawable = aoop.TRANSPARENT;
        localURLDrawableOptions.mFailedDrawable = aoop.TRANSPARENT;
        localURLDrawableOptions.mPlayGifImage = true;
        localEditLocalGifSource.sourcePath = null;
      }
      this.jdField_a_of_type_Auru.post(new EditGifImage.1(this));
    }
  }
  
  private void bsd()
  {
    if ((this.aGp) && (this.aGr))
    {
      if (this.jdField_b_of_type_CooperationQzoneWidgetFastAnimationDrawable == null)
      {
        EditLocalGifSource localEditLocalGifSource = (EditLocalGifSource)this.jdField_b_of_type_Aygz.a.a;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = this.jdField_b_of_type_Aygz.a.a.getWidth();
        localURLDrawableOptions.mRequestHeight = this.jdField_b_of_type_Aygz.a.a.getHeight();
        localURLDrawableOptions.mLoadingDrawable = aoop.TRANSPARENT;
        localURLDrawableOptions.mFailedDrawable = aoop.TRANSPARENT;
        localURLDrawableOptions.mPlayGifImage = true;
        localEditLocalGifSource.sourcePath = null;
      }
      this.jdField_a_of_type_Auru.post(new EditGifImage.2(this));
    }
  }
  
  public static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int m = paramOptions.outWidth;
    int j = 1;
    if ((k > paramInt2) || (m > paramInt1))
    {
      int i = 2;
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
  
  public RectF a(Bitmap paramBitmap)
  {
    Object localObject = this.t.getImageMatrix();
    float[] arrayOfFloat = new float[9];
    ((Matrix)localObject).getValues(arrayOfFloat);
    float f4 = arrayOfFloat[0];
    localObject = this.jdField_a_of_type_Ayii.getActivity().getResources().getDisplayMetrics();
    int i = ((DisplayMetrics)localObject).widthPixels;
    int j = ((DisplayMetrics)localObject).heightPixels;
    int k = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    float f1 = j / i;
    float f2;
    float f3;
    if (m / k > f1)
    {
      f2 = j;
      f1 = j / m;
      f3 = k * f1 + 0.5F;
    }
    for (;;)
    {
      paramBitmap = new RectF(0.0F, 0.0F, f3, f2);
      ram.i("EditPicActivity.EditGifImage", "getDisplayBounds " + paramBitmap + " scale " + f1 + " old scale " + f4);
      return paramBitmap;
      f3 = i;
      f1 = i / k;
      f2 = m * f1 + 0.5F;
    }
  }
  
  public void a(@NonNull ayqb paramayqb)
  {
    paramayqb.a.cK = this.cx;
    aA("PublishBtn", this.aGr + "");
    if (this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable != null)
    {
      this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.stop();
      this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.eDE();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_Ayii.getActivity().isFinishing()) {
      QLog.e("EditPicActivity.EditGifImage", 1, "handleMessage isFinishing" + paramMessage.what);
    }
    do
    {
      do
      {
        do
        {
          Object localObject;
          do
          {
            return false;
            if (paramMessage.what == 998)
            {
              QQToast.a(this.jdField_a_of_type_Ayii.getActivity().getApplicationContext(), this.jdField_a_of_type_Ayii.getActivity().getResources().getString(2131721221), 0).show();
              this.jdField_a_of_type_Ayii.a(0, null, 2130772067, 0);
              return false;
            }
            if (paramMessage.what != 999) {
              break;
            }
            AbstractGifImage.resumeAll();
            paramMessage = a((Bitmap)paramMessage.obj);
            localObject = this.t.getLayoutParams();
            ((ViewGroup.LayoutParams)localObject).height = ((int)paramMessage.bottom);
            ((ViewGroup.LayoutParams)localObject).width = ((int)paramMessage.right);
            this.t.setLayoutParams((ViewGroup.LayoutParams)localObject);
            if (this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable != null)
            {
              this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.lj(((ViewGroup.LayoutParams)localObject).width, ((ViewGroup.LayoutParams)localObject).height);
              this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.start();
            }
            localObject = (aydg)a(aydg.class);
          } while (localObject == null);
          ((aydg)localObject).M((int)paramMessage.width(), (int)paramMessage.height(), false);
          return false;
          if (paramMessage.what != 995) {
            break;
          }
          this.aGs = false;
          bsd();
        } while (this.aGw);
        aA("AutoOptimizationBtn", "resetAntishake");
        this.aGw = true;
        return false;
        if (paramMessage.what != 994) {
          break;
        }
        this.aGs = true;
        bsc();
      } while (this.aGv);
      aA("AutoOptimizationBtn", "showAntishake");
      this.aGv = true;
      return false;
      if (paramMessage.what == 997)
      {
        this.jdField_b_of_type_Aygz.b.as(false, false);
        return false;
      }
    } while (paramMessage.what != 996);
    this.jdField_b_of_type_Aygz.b.as(true, false);
    aA("AutoOptimizationBtn", "exposeAntishake");
    this.aGx = true;
    return false;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.t = ((URLImageView)y(2131368026));
    this.t.setOnTouchListener(this);
    this.t.setScaleType(ImageView.ScaleType.FIT_CENTER);
    ThreadManager.post(this, 8, null, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("EditPicActivity.EditGifImage", 2, "EditGifImage onDestroy");
    }
    this.jdField_a_of_type_Auru.removeMessages(999);
    if (this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable != null)
    {
      this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.stop();
      this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.eDE();
      this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable = null;
    }
    if (this.jdField_b_of_type_CooperationQzoneWidgetFastAnimationDrawable != null)
    {
      this.jdField_b_of_type_CooperationQzoneWidgetFastAnimationDrawable.stop();
      this.jdField_b_of_type_CooperationQzoneWidgetFastAnimationDrawable.eDE();
      this.jdField_b_of_type_CooperationQzoneWidgetFastAnimationDrawable = null;
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable != null) {
      this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.start();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable != null) {
      this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.stop();
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
      if ((Math.abs(f1 - this.mDownX) < 10.0F) && (Math.abs(f2 - this.mDownY) < 10.0F)) {
        if (this.jdField_b_of_type_Aygz.bqq != 21)
        {
          if (this.jdField_b_of_type_Aygz.a.asi != 2)
          {
            this.jdField_b_of_type_Aygz.changeState(5);
            ras.sp("0X80075D7");
          }
        }
        else {
          this.jdField_b_of_type_Aygz.changeState(0);
        }
      }
    }
  }
  
  public void p(int paramInt, Object paramObject)
  {
    if (paramInt == 11)
    {
      this.t.setVisibility(8);
      return;
    }
    this.t.setVisibility(0);
  }
  
  public void run()
  {
    Object localObject1;
    Object localObject2;
    if (this.jdField_b_of_type_Aygz.a.a.getSourcePath() != null)
    {
      this.aGo = false;
      localObject1 = this.jdField_b_of_type_Aygz.a.a.getSourcePath();
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.jdField_b_of_type_Aygz.a.a.getWidth();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.jdField_b_of_type_Aygz.a.a.getHeight();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = aoop.TRANSPARENT;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = aoop.TRANSPARENT;
      ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
      localObject2 = URLDrawable.getDrawable(new File((String)localObject1), (URLDrawable.URLDrawableOptions)localObject2);
      this.t.setImageDrawable((Drawable)localObject2);
    }
    for (;;)
    {
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      BitmapFactory.decodeFile((String)localObject1, (BitmapFactory.Options)localObject2);
      if ((((BitmapFactory.Options)localObject2).outWidth < bpv) || (((BitmapFactory.Options)localObject2).outHeight < bpv))
      {
        QLog.e("EditPicActivity.EditGifImage", 1, "bitmapPath:" + (String)localObject1 + " too small width:" + ((BitmapFactory.Options)localObject2).outWidth + " height:" + ((BitmapFactory.Options)localObject2).outHeight);
        this.jdField_a_of_type_Auru.sendEmptyMessage(998);
        return;
        if (((this.jdField_b_of_type_Aygz.a.a instanceof EditLocalGifSource)) && (((EditLocalGifSource)this.jdField_b_of_type_Aygz.a.a).ns != null) && (((EditLocalGifSource)this.jdField_b_of_type_Aygz.a.a).ns.size() > 0))
        {
          this.aGo = true;
          localObject1 = (String)((EditLocalGifSource)this.jdField_b_of_type_Aygz.a.a).ns.get(0);
          this.t.setImageDrawable(this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable);
        }
      }
      else
      {
        DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_Ayii.getActivity().getResources().getDisplayMetrics();
        int i = calculateInSampleSize((BitmapFactory.Options)localObject2, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = false;
        ((BitmapFactory.Options)localObject2).inSampleSize = i;
        try
        {
          localObject2 = aqhu.d((String)localObject1, (BitmapFactory.Options)localObject2);
          if (localObject2 == null)
          {
            QLog.e("EditPicActivity.EditGifImage", 1, "decode" + null);
            this.jdField_a_of_type_Ayii.a(0, null, 2130772067, 0);
            return;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          Bitmap localBitmap;
          for (;;)
          {
            QLog.e("EditPicActivity.EditGifImage", 1, "decodeoom");
            localBitmap = null;
          }
          if (QLog.isColorLevel()) {
            QLog.d("EditPicActivity.EditGifImage", 2, "sampleSize" + i + " w " + localBitmap.getWidth() + " h " + localBitmap.getHeight());
          }
          i = aqhu.getExifOrientation((String)localObject1);
          localObject1 = localBitmap;
          if (i != 0)
          {
            localObject1 = localBitmap;
            if (i % 90 == 0)
            {
              this.jdField_b_of_type_Aygz.mOrientation = i;
              if (QLog.isColorLevel()) {
                QLog.d("EditPicActivity.EditGifImage", 2, "has exif rotate" + i);
              }
              int j = localBitmap.getWidth();
              int k = localBitmap.getHeight();
              localObject1 = new Matrix();
              ((Matrix)localObject1).postRotate(i, j / 2.0F, k / 2.0F);
              localObject1 = Bitmap.createBitmap(localBitmap, 0, 0, j, k, (Matrix)localObject1, true);
            }
          }
          this.cx = ((Bitmap)localObject1);
          this.jdField_a_of_type_Auru.obtainMessage(999, localObject1).sendToTarget();
          return;
        }
      }
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditGifImage
 * JD-Core Version:    0.7.0.1
 */