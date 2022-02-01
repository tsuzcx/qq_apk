package com.tencent.richmediabrowser.view;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.utils.ScreenUtils;
import com.tencent.richmediabrowser.view.page.AdapterView;
import com.tencent.richmediabrowser.view.page.Gallery;
import com.tencent.richmediabrowser.view.page.ProGallery;
import com.tencent.richmediabrowser.view.page.ProGallery.OnProGalleryGestureListener;

public class BrowserBaseView
  extends BaseView
  implements ProGallery.OnProGalleryGestureListener
{
  private static final String TAG = "BrowserBaseView";
  public BrowserBasePresenter basePresenter;
  public RelativeLayout contentView;
  public RelativeLayout galleryView;
  public boolean isInEnterAnim;
  public boolean isInExitAnim;
  public Activity mContext;
  public int mScreenHeightPx;
  public int mScreenWidthPx;
  public int midScreenWidth;
  
  public BrowserBaseView(Activity paramActivity, BrowserBasePresenter paramBrowserBasePresenter)
  {
    this.mContext = paramActivity;
    this.mScreenWidthPx = this.mContext.getResources().getDisplayMetrics().widthPixels;
    this.mScreenHeightPx = this.mContext.getResources().getDisplayMetrics().heightPixels;
    this.basePresenter = paramBrowserBasePresenter;
  }
  
  public boolean back()
  {
    return false;
  }
  
  public void buildComplete()
  {
    super.buildComplete();
  }
  
  public void buildParams(Intent paramIntent)
  {
    super.buildParams(paramIntent);
    this.midScreenWidth = (ScreenUtils.getScreenWidth(this.mContext) / 2);
  }
  
  public void buildView(ViewGroup paramViewGroup)
  {
    super.buildView(paramViewGroup);
    onCreate(paramViewGroup);
  }
  
  public void clearTheOuchCache() {}
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public boolean needEnterRectAnimation()
  {
    return true;
  }
  
  public boolean needExitRectAnimation()
  {
    return false;
  }
  
  public void notifyImageModelDataChanged()
  {
    int i = this.basePresenter.getSelectedIndex();
    Gallery localGallery = this.basePresenter.getGallery();
    if ((localGallery != null) && (i != localGallery.getSelectedItemPosition())) {
      localGallery.setSelection(i);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    int i = this.mContext.getResources().getDisplayMetrics().widthPixels;
    int j = this.mContext.getResources().getDisplayMetrics().heightPixels;
    if ((i != this.mScreenWidthPx) || (j != this.mScreenHeightPx))
    {
      this.mScreenWidthPx = i;
      this.mScreenHeightPx = j;
      URLDrawable.clearMemoryCache();
    }
  }
  
  public void onCreate(ViewGroup paramViewGroup)
  {
    if (this.basePresenter.getGallery() != null) {
      ((ProGallery)this.basePresenter.getGallery()).setGestureListener(this);
    }
  }
  
  public View onCreateView(int paramInt, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onDestroyView(int paramInt, View paramView, ViewGroup paramViewGroup) {}
  
  public void onEnterAnimationEnd() {}
  
  public void onEnterAnimationStart() {}
  
  public void onExitAnimationEnd() {}
  
  public void onExitAnimationStart() {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return true;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (Math.abs(paramMotionEvent2.getRawX() - paramMotionEvent1.getRawX()) > this.midScreenWidth)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("BrowserBaseView", 4, "onScrollHalfScreenWidth");
      onScrollHalfScreenWidth();
    }
    return false;
  }
  
  public void onScrollEnd(int paramInt) {}
  
  public void onScrollHalfScreenWidth() {}
  
  public void onScrollStart(int paramInt) {}
  
  public void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData) {}
  
  public void onViewDetached(int paramInt, View paramView, RichMediaBrowserInfo paramRichMediaBrowserInfo) {}
  
  public void onscaleBegin(int paramInt, View paramView, ViewGroup paramViewGroup) {}
  
  public void showActionSheet(int paramInt) {}
  
  public void showContentView(boolean paramBoolean) {}
  
  public void updateUI() {}
  
  public void updateView(int paramInt, View paramView, boolean paramBoolean)
  {
    updateView(paramInt, null, null, paramView, paramBoolean);
  }
  
  public void updateView(int paramInt, String paramString1, String paramString2, View paramView, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.BrowserBaseView
 * JD-Core Version:    0.7.0.1
 */