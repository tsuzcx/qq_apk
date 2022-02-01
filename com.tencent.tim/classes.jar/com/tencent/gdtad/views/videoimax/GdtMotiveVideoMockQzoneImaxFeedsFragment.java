package com.tencent.gdtad.views.videoimax;

import acbn;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import aokj;
import aolf;
import aqqv;
import aqul;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.image.ApngSoLoader;
import com.tencent.image.ProtocolDownloader;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableParams;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import cooperation.qzone.util.QZLog;
import java.io.File;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;
import tkw;
import tmu;

public class GdtMotiveVideoMockQzoneImaxFeedsFragment
  extends PublicBaseFragment
{
  private static boolean xI;
  private GdtImaxData a;
  
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
        QZLog.e("GdtMotiveVideoMockQzoneImaxFeedsFragment", "UrlDrawable init exception.", paramContext);
        return;
      }
      File localFile = paramContext.getCacheDir();
    }
  }
  
  private void g(ImageView paramImageView, String paramString)
  {
    tkw.d("GdtMotiveVideoMockQzoneImaxFeedsFragment", "bindPreviewImage() called with: iv = [" + paramImageView + "], url = [" + paramString + "]");
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramImageView.getResources().getDrawable(2130851770);
    localURLDrawableOptions.mFailedDrawable = paramImageView.getResources().getDrawable(2130851770);
    paramImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
    paramImageView.setOnClickListener(new tmu(this));
  }
  
  private void ux(String paramString) {}
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    try
    {
      as(paramActivity.getApplication());
      this.a = ((GdtImaxData)paramActivity.getIntent().getSerializableExtra("data"));
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("GdtMotiveVideoMockQzoneImaxFeedsFragment", 1, "", localThrowable);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    tkw.d("GdtMotiveVideoMockQzoneImaxFeedsFragment", "onCreateView: ");
    paramLayoutInflater = paramLayoutInflater.inflate(2131559403, paramViewGroup, false);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    paramView = (ImageView)paramView.findViewById(2131369555);
    paramBundle = this.a.getAd().info.display_info.basic_info.img.get();
    g(paramView, paramBundle);
    ux(paramBundle);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
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
 * Qualified Name:     com.tencent.gdtad.views.videoimax.GdtMotiveVideoMockQzoneImaxFeedsFragment
 * JD-Core Version:    0.7.0.1
 */