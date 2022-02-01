package com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
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
import awcg;
import awcg.a;
import awdu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.widget.FastAnimationDrawable;
import cooperation.qzone.widget.FastAnimationDrawable.a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import ram;
import ras;
import rba;
import rcb;
import rdb;
import rdc;
import rel;
import rkm;

public class EditGifImage
  extends rdb
  implements Handler.Callback, View.OnTouchListener, FastAnimationDrawable.a, Runnable
{
  public static final int bpv = awdu.eAm;
  long BG = 0L;
  public auru a;
  a a;
  public FastAnimationDrawable a;
  public boolean aGo = false;
  public boolean aGp = false;
  boolean aGq = false;
  public boolean aGr = false;
  boolean aGs = false;
  boolean aGt = false;
  boolean aGu = false;
  boolean aGv;
  boolean aGw;
  boolean aGx;
  FastAnimationDrawable b;
  Bitmap cx;
  int frameNum = 0;
  float mDownX;
  float mDownY;
  long startTime = 0L;
  URLImageView t;
  
  public EditGifImage(@NonNull rdc paramrdc)
  {
    super(paramrdc);
    this.jdField_a_of_type_Auru = new auru(Looper.getMainLooper(), this);
  }
  
  private void aA(String paramString1, String paramString2)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("module_name", paramString1);
      localHashMap.put("module_status", paramString2);
      if (paramString2.equals("exposeAntishake")) {
        localHashMap.put("module_exposeTime", String.valueOf(this.BG - this.startTime));
      }
      if ((this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable != null) && (this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.mMemoryCache != null)) {
        localHashMap.put("module_frameNum", this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.mMemoryCache.size() + "");
      }
      localHashMap.put("module_exposeStatus", this.aGx + "");
      localHashMap.put("module_showStatus", this.aGv + "");
      localHashMap.put("module_resetStatus", this.aGw + "");
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "GifAntishakeModule", true, 0L, 0L, localHashMap, null);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("EditPicActivity.EditGifImage", 1, "reportToBeacon failed " + paramString1.getMessage());
    }
  }
  
  private void bsb()
  {
    for (;;)
    {
      try
      {
        HashMap localHashMap = new HashMap();
        if (this.aGt)
        {
          String str1 = "0";
          localHashMap.put("module_clickToPublish", str1);
          if (this.aGt)
          {
            str1 = "module_clickToPublishPhotoFrameNum";
            localHashMap.put(str1, this.frameNum + "");
            anpc.a(BaseApplicationImpl.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "GifChooser", true, 0L, 0L, localHashMap, null);
            return;
          }
          str1 = "module_clickToPublishVideoFrameNum";
          continue;
        }
        String str2 = "1";
      }
      catch (Exception localException)
      {
        QLog.e("EditPicActivity.EditGifImage", 1, "reportToBeacon failed " + localException.getMessage());
        return;
      }
    }
  }
  
  private void bsc()
  {
    if ((this.aGp) && (!this.aGr))
    {
      if (this.jdField_b_of_type_CooperationQzoneWidgetFastAnimationDrawable == null)
      {
        EditLocalGifSource localEditLocalGifSource = (EditLocalGifSource)this.jdField_b_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = this.jdField_b_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.getWidth();
        localURLDrawableOptions.mRequestHeight = this.jdField_b_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.getHeight();
        localURLDrawableOptions.mLoadingDrawable = aoop.TRANSPARENT;
        localURLDrawableOptions.mFailedDrawable = aoop.TRANSPARENT;
        localURLDrawableOptions.mPlayGifImage = true;
        this.jdField_b_of_type_CooperationQzoneWidgetFastAnimationDrawable = new FastAnimationDrawable(this.jdField_a_of_type_Rel.getActivity().getApplicationContext(), localEditLocalGifSource.nt, localEditLocalGifSource.delay, this);
        localEditLocalGifSource.sourcePath = null;
      }
      this.jdField_a_of_type_Auru.post(new EditGifImage.2(this));
    }
  }
  
  private void bsd()
  {
    if ((this.aGp) && (this.aGr))
    {
      if (this.jdField_b_of_type_CooperationQzoneWidgetFastAnimationDrawable == null)
      {
        EditLocalGifSource localEditLocalGifSource = (EditLocalGifSource)this.jdField_b_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = this.jdField_b_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.getWidth();
        localURLDrawableOptions.mRequestHeight = this.jdField_b_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.getHeight();
        localURLDrawableOptions.mLoadingDrawable = aoop.TRANSPARENT;
        localURLDrawableOptions.mFailedDrawable = aoop.TRANSPARENT;
        localURLDrawableOptions.mPlayGifImage = true;
        this.jdField_b_of_type_CooperationQzoneWidgetFastAnimationDrawable = new FastAnimationDrawable(this.jdField_a_of_type_Rel.getActivity().getApplicationContext(), localEditLocalGifSource.ns, localEditLocalGifSource.delay, this);
        localEditLocalGifSource.sourcePath = null;
      }
      this.jdField_a_of_type_Auru.post(new EditGifImage.3(this));
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
  
  private void cp(ArrayList<String> paramArrayList)
  {
    ((EditLocalGifSource)this.jdField_b_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).nt = paramArrayList;
    this.aGp = true;
  }
  
  public RectF a(Bitmap paramBitmap)
  {
    Object localObject = this.t.getImageMatrix();
    float[] arrayOfFloat = new float[9];
    ((Matrix)localObject).getValues(arrayOfFloat);
    float f4 = arrayOfFloat[0];
    localObject = this.jdField_a_of_type_Rel.getActivity().getResources().getDisplayMetrics();
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
  
  public void a(@NonNull rkm paramrkm)
  {
    paramrkm.a.cK = this.cx;
    aA("PublishBtn", this.aGr + "");
    if (this.aGo) {
      bsb();
    }
    if (this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable != null)
    {
      this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.stop();
      this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.eDE();
    }
  }
  
  public void b(LruCache<Integer, BitmapDrawable> paramLruCache)
  {
    if (!this.aGu)
    {
      this.aGu = true;
      if (this.aGq) {
        break label36;
      }
      ThreadManager.post(new EditGifImage.1(this, paramLruCache), 8, null, false);
    }
    label36:
    do
    {
      return;
      localArrayList = ((EditLocalGifSource)this.jdField_b_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).ns;
    } while ((paramLruCache == null) || (paramLruCache.size() != localArrayList.size()));
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramLruCache.size())
    {
      if (paramLruCache.get(Integer.valueOf(i)) != null) {
        localArrayList.add(((BitmapDrawable)paramLruCache.get(Integer.valueOf(i))).getBitmap());
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage$a = new a();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage$a.execute(new ArrayList[] { localArrayList });
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_Rel.getActivity().isFinishing()) {
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
              QQToast.a(this.jdField_a_of_type_Rel.getActivity().getApplicationContext(), this.jdField_a_of_type_Rel.getActivity().getResources().getString(2131721221), 0).show();
              this.jdField_a_of_type_Rel.a(0, null, 2130772067, 0);
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
            localObject = (rba)a(rba.class);
          } while (localObject == null);
          ((rba)localObject).dZ((int)paramMessage.width(), (int)paramMessage.height());
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
        this.jdField_b_of_type_Rdc.jdField_a_of_type_Rcb.as(false, false);
        return false;
      }
    } while (paramMessage.what != 996);
    this.jdField_b_of_type_Rdc.jdField_a_of_type_Rcb.as(true, false);
    this.BG = System.currentTimeMillis();
    aA("AutoOptimizationBtn", "exposeAntishake");
    this.aGx = true;
    return false;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.startTime = System.currentTimeMillis();
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
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage$a != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage$a.getStatus() == AsyncTask.Status.RUNNING))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage$a.cancel(false);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage$a = null;
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
        if (this.jdField_b_of_type_Rdc.bqq != 21)
        {
          if (this.jdField_b_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi != 2)
          {
            this.jdField_b_of_type_Rdc.changeState(5);
            ras.sp("0X80075D7");
          }
          else if (this.jdField_b_of_type_Rdc.bqq == 0)
          {
            this.jdField_b_of_type_Rdc.changeState(27);
          }
          else if (this.jdField_b_of_type_Rdc.bqq == 27)
          {
            this.jdField_b_of_type_Rdc.changeState(0);
          }
        }
        else {
          this.jdField_b_of_type_Rdc.changeState(0);
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
    if (this.jdField_b_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.getSourcePath() != null)
    {
      this.aGo = false;
      localObject1 = this.jdField_b_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.getSourcePath();
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.jdField_b_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.getWidth();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.jdField_b_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.getHeight();
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
        if (((this.jdField_b_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalGifSource)) && (((EditLocalGifSource)this.jdField_b_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).ns != null) && (((EditLocalGifSource)this.jdField_b_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).ns.size() > 0))
        {
          this.aGo = true;
          localObject1 = ((EditLocalGifSource)this.jdField_b_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).ns;
          this.aGt = awcg.a().Y((ArrayList)localObject1);
          this.frameNum = ((ArrayList)localObject1).size();
          if ((((EditLocalGifSource)this.jdField_b_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).hasAntishake) && (((EditLocalGifSource)this.jdField_b_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).nt != null) && (((EditLocalGifSource)this.jdField_b_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).nt.size() > 1))
          {
            this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable = new FastAnimationDrawable(this.jdField_a_of_type_Rel.getActivity().getApplicationContext(), ((EditLocalGifSource)this.jdField_b_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).nt, ((EditLocalGifSource)this.jdField_b_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).delay, this);
            this.aGp = true;
            this.aGr = true;
            label472:
            switch (((EditLocalGifSource)this.jdField_b_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).checkedSimilarityOK)
            {
            }
          }
          for (;;)
          {
            localObject1 = (String)((EditLocalGifSource)this.jdField_b_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).ns.get(0);
            this.t.setImageDrawable(this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable);
            break;
            this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable = new FastAnimationDrawable(this.jdField_a_of_type_Rel.getActivity().getApplicationContext(), ((EditLocalGifSource)this.jdField_b_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).ns, ((EditLocalGifSource)this.jdField_b_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).delay, this);
            this.aGp = false;
            this.aGr = false;
            break label472;
            this.aGq = true;
            this.jdField_a_of_type_Auru.obtainMessage(996).sendToTarget();
            continue;
            this.aGu = true;
            this.aGq = false;
            this.jdField_a_of_type_Auru.sendEmptyMessage(997);
            if (QLog.isColorLevel()) {
              QLog.d("QzoneVision", 2, "MSG_CANNOT_ANTISHAKE");
            }
          }
        }
      }
      else
      {
        Object localObject3 = this.jdField_a_of_type_Rel.getActivity().getResources().getDisplayMetrics();
        int i = calculateInSampleSize((BitmapFactory.Options)localObject2, ((DisplayMetrics)localObject3).widthPixels, ((DisplayMetrics)localObject3).heightPixels);
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = false;
        ((BitmapFactory.Options)localObject2).inSampleSize = i;
        try
        {
          localObject2 = aqhu.d((String)localObject1, (BitmapFactory.Options)localObject2);
          if (localObject2 == null)
          {
            QLog.e("EditPicActivity.EditGifImage", 1, "decode" + null);
            this.jdField_a_of_type_Rel.a(0, null, 2130772067, 0);
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
          localObject3 = localBitmap;
          if (localObject1 != null)
          {
            i = aqhu.getExifOrientation((String)localObject1);
            localObject3 = localBitmap;
            if (i != 0)
            {
              localObject3 = localBitmap;
              if (i % 90 == 0)
              {
                if (this.jdField_b_of_type_Rdc.b != null) {
                  this.jdField_b_of_type_Rdc.b.bpO = i;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("EditPicActivity.EditGifImage", 2, "has exif rotate" + i);
                }
                int j = localBitmap.getWidth();
                int k = localBitmap.getHeight();
                localObject1 = new Matrix();
                ((Matrix)localObject1).postRotate(i, j / 2.0F, k / 2.0F);
                localObject3 = Bitmap.createBitmap(localBitmap, 0, 0, j, k, (Matrix)localObject1, true);
              }
            }
          }
          this.cx = ((Bitmap)localObject3);
          this.jdField_a_of_type_Auru.obtainMessage(999, localObject3).sendToTarget();
          return;
        }
      }
      localObject1 = null;
    }
  }
  
  public class a
    extends AsyncTask<ArrayList<Bitmap>, Integer, ArrayList<String>>
    implements awcg.a
  {
    private int bpw;
    
    public a() {}
    
    protected ArrayList<String> a(ArrayList<Bitmap>... paramVarArgs)
    {
      if ((paramVarArgs == null) || (paramVarArgs.length == 0) || (isCancelled())) {
        return null;
      }
      ArrayList<Bitmap> localArrayList1 = paramVarArgs[0];
      ArrayList localArrayList = new ArrayList();
      this.bpw = localArrayList1.size();
      awcg.a().a(this);
      paramVarArgs = localArrayList;
      if (!isCancelled()) {}
      try
      {
        paramVarArgs = awcg.a().av(localArrayList1);
        localArrayList1.clear();
        return paramVarArgs;
      }
      catch (Exception paramVarArgs)
      {
        for (;;)
        {
          paramVarArgs.printStackTrace();
          paramVarArgs = localArrayList;
        }
      }
    }
    
    protected void k(ArrayList<String> paramArrayList)
    {
      if ((paramArrayList == null) || (paramArrayList.size() < 1) || (isCancelled())) {}
      do
      {
        return;
        EditGifImage.a(EditGifImage.this, paramArrayList);
      } while (!EditGifImage.this.aGs);
      EditGifImage.a(EditGifImage.this);
      EditGifImage.this.b.a.as(true, true);
    }
    
    protected void onCancelled()
    {
      super.onCancelled();
    }
    
    protected void onProgressUpdate(Integer... paramVarArgs)
    {
      if (EditGifImage.this.aGs) {
        EditGifImage.this.b.a.ea(paramVarArgs[0].intValue(), this.bpw);
      }
    }
    
    public void wQ(int paramInt)
    {
      publishProgress(new Integer[] { Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditGifImage
 * JD-Core Version:    0.7.0.1
 */