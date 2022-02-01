package com.tencent.gdtad.views.videoimax;

import acbn;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import aokj;
import aolf;
import aqbn;
import aqqv;
import aqul;
import com.tencent.ad.tangram.videoceiling.AdVideoSpliceAdapter.Params;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.image.ApngSoLoader;
import com.tencent.image.ProtocolDownloader;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableParams;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicTransFragmentActivityForTool;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.lang.ref.WeakReference;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;
import tkw;
import tna;
import tnb;

public class TransitionContext
{
  private static boolean xI;
  private ValueAnimator W;
  private final AdVideoSpliceAdapter.Params jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter$Params;
  private GdtVideoImaxEnterImageView jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtVideoImaxEnterImageView;
  private boolean aPM;
  private boolean aPN;
  private int bCn;
  private ResultReceiver k;
  
  public TransitionContext(AdVideoSpliceAdapter.Params paramParams)
  {
    this.jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter$Params = paramParams;
    try
    {
      as(((Activity)paramParams.activity.get()).getApplication());
      return;
    }
    catch (Throwable paramParams)
    {
      QLog.e("TransitionContext", 1, "", paramParams);
    }
  }
  
  private static void as(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (xI) {
          return;
        }
        if (paramContext == null) {
          break;
        }
        URLDrawable.DEBUG = false;
        if ("mounted".equals(Environment.getExternalStorageState()))
        {
          localFile = new File(aqul.getSDKPrivatePath(acbn.SDCARD_PATH));
          URLDrawable.init(paramContext, new a(paramContext, new File(localFile, "diskcache")));
          xI = true;
          return;
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        QZLog.e("TransitionContext", "UrlDrawable init exception.", paramContext);
        return;
      }
      File localFile = paramContext.getCacheDir();
    }
  }
  
  private void bEi()
  {
    tkw.d("TransitionContext", "sendAnimationEnd() called");
    if (this.k != null) {
      this.k.send(1, null);
    }
  }
  
  private void bEj()
  {
    tkw.d("TransitionContext", "startImaxActivity() called");
    Intent localIntent = new Intent();
    GdtImaxData localGdtImaxData = new GdtImaxData();
    GdtAd localGdtAd = (GdtAd)GdtAd.class.cast(this.jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter$Params.ad);
    localGdtImaxData.setAd(localGdtAd);
    localGdtImaxData.setVideoSplicePageStyle(this.jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter$Params.videoSplicePageStyle);
    GdtVideoData localGdtVideoData = new GdtVideoData();
    String str2 = this.jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter$Params.videoUrl2;
    String str1 = str2;
    if (localGdtAd != null)
    {
      str1 = str2;
      if (localGdtAd.getCreativeSize() == 585) {
        str1 = localGdtAd.getVideoUrl();
      }
    }
    localGdtVideoData.setUrl(str1);
    localGdtVideoData.setStartPositionMillis(0L);
    localGdtVideoData.setLoop(true);
    localGdtVideoData.setDirectPlay(true);
    localGdtVideoData.setAd(localGdtAd);
    localGdtVideoData.setVideoDefaultBackgroundColor(0);
    localGdtVideoData.setForceNotShowControllerView(true);
    localGdtVideoData.setCoverUrl(localGdtAd.info.display_info.basic_info.img.get());
    localGdtVideoData.setNeedReport(false);
    localGdtVideoData.setPlayScene(8);
    localGdtImaxData.setVideoData(localGdtVideoData);
    localGdtImaxData.setWebUrl(this.jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter$Params.webUrl);
    localIntent.putExtra("data", localGdtImaxData);
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("callback", new MyResultReceiver(new Handler(Looper.getMainLooper()), this));
    PublicFragmentActivity.b.startForResult((Activity)this.jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter$Params.activity.get(), localIntent, PublicTransFragmentActivityForTool.class, GdtVideoImaxFragment.class, 1);
  }
  
  private void h(Window paramWindow)
  {
    paramWindow.setFlags(1024, 1024);
    paramWindow = (ViewGroup)paramWindow.getDecorView();
    this.bCn = paramWindow.getSystemUiVisibility();
    paramWindow.setSystemUiVisibility(7942);
  }
  
  private void i(Window paramWindow)
  {
    paramWindow.clearFlags(1024);
    ((ViewGroup)paramWindow.getDecorView()).setSystemUiVisibility(this.bCn);
  }
  
  private void r(ImageView paramImageView)
  {
    tkw.d("TransitionContext", "finishEnterAnimator() called with: maskView = [" + paramImageView + "]");
    ViewGroup localViewGroup = (ViewGroup)paramImageView.getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(paramImageView);
    }
    if ((this.W != null) && (this.W.isRunning()))
    {
      this.W.cancel();
      this.W = null;
    }
    i(((Activity)this.jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter$Params.activity.get()).getWindow());
  }
  
  private void x(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    tkw.d("TransitionContext", "enterAnimation() called with: l = [" + paramInt1 + "], t = [" + paramInt2 + "], width = [" + paramInt3 + "], height = [" + paramInt4 + "]");
    Object localObject1 = (Activity)this.jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter$Params.activity.get();
    Object localObject2 = ((Activity)localObject1).getWindow();
    h((Window)localObject2);
    localObject2 = (FrameLayout)((Window)localObject2).getDecorView();
    this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtVideoImaxEnterImageView = new GdtVideoImaxEnterImageView((Context)localObject1);
    Object localObject3 = new ViewGroup.MarginLayoutParams(-1, -1);
    Rect localRect = new Rect();
    paramInt3 = paramInt1 + paramInt3;
    paramInt4 = paramInt2 + paramInt4;
    int i = ((FrameLayout)localObject2).getWidth();
    int j = ((FrameLayout)localObject2).getHeight();
    tkw.d("TransitionContext", "enterAnimation() destinationClipBottom = [" + j + "]");
    this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtVideoImaxEnterImageView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
    localRect.set(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtVideoImaxEnterImageView.setClipBoundsCompact(localRect);
    localObject3 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Activity)localObject1).getResources().getDrawable(2130851770);
    ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Activity)localObject1).getResources().getDrawable(2130851770);
    localObject1 = URLDrawable.getDrawable(((GdtAd)GdtAd.class.cast(this.jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter$Params.ad)).info.display_info.basic_info.img.get(), (URLDrawable.URLDrawableOptions)localObject3);
    ((URLDrawable)localObject1).setDecodeHandler(aqbn.m);
    ((URLDrawable)localObject1).setTag(new int[] { 50 });
    this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtVideoImaxEnterImageView.setImageDrawable((Drawable)localObject1);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtVideoImaxEnterImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    ((FrameLayout)localObject2).addView(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtVideoImaxEnterImageView);
    this.W = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.W.setDuration(500L);
    this.W.setInterpolator(new AccelerateInterpolator());
    this.W.addUpdateListener(new tna(this, paramInt1, paramInt2, paramInt3, i, j, paramInt4, localRect));
    this.W.addListener(new tnb(this));
    this.W.start();
  }
  
  public void onAnimationEnd()
  {
    tkw.d("TransitionContext", "onAnimationEnd() called");
    this.aPN = true;
    if (this.aPM) {
      bEi();
    }
  }
  
  public void start()
  {
    tkw.d("TransitionContext", "start() called");
    x(this.jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter$Params.mediaViewLocationRect.left, this.jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter$Params.mediaViewLocationRect.top, this.jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter$Params.mediaViewLocationRect.width(), this.jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter$Params.mediaViewLocationRect.height());
    bEj();
  }
  
  static final class MyResultReceiver
    extends ResultReceiver
  {
    private WeakReference<TransitionContext> mContext;
    
    public MyResultReceiver(Handler paramHandler, TransitionContext paramTransitionContext)
    {
      super();
      this.mContext = new WeakReference(paramTransitionContext);
    }
    
    protected void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      super.onReceiveResult(paramInt, paramBundle);
      tkw.d("TransitionContext", "onReceiveResult() called with: resultCode = [" + paramInt + "], resultData = [" + paramBundle + "]");
      TransitionContext localTransitionContext = (TransitionContext)this.mContext.get();
      if (localTransitionContext != null)
      {
        if (paramInt != 2) {
          break label73;
        }
        TransitionContext.a(localTransitionContext, TransitionContext.a(localTransitionContext));
      }
      label73:
      do
      {
        do
        {
          return;
        } while (paramInt != 0);
        TransitionContext.a(localTransitionContext, true);
        paramBundle.setClassLoader(GdtVideoImaxFragment.MyResultReceiver.class.getClassLoader());
        TransitionContext.a(localTransitionContext, (ResultReceiver)paramBundle.getParcelable("callback"));
      } while (!TransitionContext.a(localTransitionContext));
      TransitionContext.a(localTransitionContext);
    }
  }
  
  static class a
    extends URLDrawableParams
  {
    Context F;
    
    public a(Context paramContext, File paramFile)
    {
      super();
      this.F = paramContext;
      aoop.aW = paramFile;
      com.tencent.mobileqq.startup.step.InitUrlDrawable.b = new aokj(paramFile);
    }
    
    public ProtocolDownloader doGetDownloader(String paramString, Object paramObject)
    {
      boolean bool = true;
      if (("http".equals(paramString)) || ("https".equals(paramString)))
      {
        if (BaseApplicationImpl.sProcessId == 1) {}
        for (;;)
        {
          return new aolf(bool, paramObject);
          bool = false;
        }
      }
      return null;
    }
    
    public String doGetLocalFilePath(String paramString)
    {
      return null;
    }
    
    public ApngSoLoader getApngSoLoader()
    {
      return aqqv.a();
    }
    
    public Drawable getDefaultLoadingDrawable()
    {
      return this.F.getResources().getDrawable(2130848704);
    }
    
    public Drawable getDefualtFailedDrawable()
    {
      return this.F.getResources().getDrawable(2130848704);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.videoimax.TransitionContext
 * JD-Core Version:    0.7.0.1
 */