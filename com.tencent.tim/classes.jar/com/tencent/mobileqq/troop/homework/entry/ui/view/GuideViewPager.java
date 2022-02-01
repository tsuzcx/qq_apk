package com.tencent.mobileqq.troop.homework.entry.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import apgz.a.a;
import com.tencent.biz.troopgift.absMultiViewPager;
import com.tencent.image.GifDrawable;
import com.tencent.image.GifDrawable.OnGIFPlayOnceListener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class GuideViewPager
  extends absMultiViewPager
  implements View.OnClickListener, GifDrawable.OnGIFPlayOnceListener
{
  private ComplexGuidViewPager.a b;
  
  public GuideViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GuideViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static URLDrawable d(String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = null;
    localURLDrawableOptions.mFailedDrawable = null;
    localURLDrawableOptions.mUseAutoScaleParams = false;
    localURLDrawableOptions.mPlayGifImage = true;
    return URLDrawable.getDrawable(new File(paramString), localURLDrawableOptions);
  }
  
  public static void setBitmapByPath(ImageView paramImageView, String paramString)
  {
    ThreadManager.post(new GuideViewPager.1(paramString, paramImageView), 8, null, true);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.b != null) {
        this.b.dZw();
      }
    }
  }
  
  public void onPlayOnce()
  {
    ThreadManager.getUIHandler().post(new GuideViewPager.2(this));
  }
  
  public void setOnActionBtnClickListener(ComplexGuidViewPager.a parama)
  {
    this.b = parama;
  }
  
  public int ul()
  {
    return this.mData.size();
  }
  
  public View z(int paramInt)
  {
    apgz.a.a locala = (apgz.a.a)this.mData.get(paramInt);
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(getContext()).inflate(2131561744, null);
    Object localObject = (ImageView)localRelativeLayout.findViewById(2131367804);
    ImageView localImageView3 = (ImageView)localRelativeLayout.findViewById(2131363404);
    ImageView localImageView1 = (ImageView)localRelativeLayout.findViewById(2131367741);
    ImageView localImageView2 = (ImageView)localRelativeLayout.findViewById(2131361975);
    if (locala.mIsFullScreen) {
      if (!TextUtils.isEmpty(locala.cpb))
      {
        setBitmapByPath((ImageView)localObject, locala.cpb);
        ((ImageView)localObject).setVisibility(0);
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(locala.cpc))
      {
        localImageView2.setImageDrawable(d(locala.cpc));
        localImageView2.setVisibility(0);
        localImageView2.setOnClickListener(this);
      }
      return localRelativeLayout;
      if (!TextUtils.isEmpty(locala.cpb))
      {
        setBitmapByPath(localImageView3, locala.cpb);
        localImageView3.setVisibility(0);
      }
      if (!TextUtils.isEmpty(locala.lS))
      {
        localObject = d(locala.lS);
        if ((((URLDrawable)localObject).getCurrDrawable() instanceof GifDrawable)) {
          ((GifDrawable)((URLDrawable)localObject).getCurrDrawable()).setGIFPlayOnceListener(this);
        }
        localImageView1.setImageDrawable(d(locala.lS));
        localImageView1.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.view.GuideViewPager
 * JD-Core Version:    0.7.0.1
 */