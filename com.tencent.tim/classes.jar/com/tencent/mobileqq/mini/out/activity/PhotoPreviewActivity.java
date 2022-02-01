package com.tencent.mobileqq.mini.out.activity;

import acfp;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import aoop;
import aqfy;
import com.tencent.common.galleryactivity.AbstractImageAdapter.URLImageView2;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.photo.ProGallery;
import com.tencent.mobileqq.activity.photo.ProGallery.b;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;
import java.net.URL;
import java.util.ArrayList;

public class PhotoPreviewActivity
  extends BaseActivity
{
  public static final String BACK_BTN_TEXT = "back_btn_text";
  public static final String TAG = "PhotoPreviewActivity";
  ImageAdapter adapter;
  TextView backBtn;
  String backBtnText;
  int currentSelectedPostion;
  ProGallery gallery;
  int mTotalPicCount = 0;
  ArrayList<String> paths;
  BubblePopupWindow popup;
  int reqHeight;
  int reqWidth;
  boolean showBar = true;
  TextView titleView;
  View topBar;
  
  void back()
  {
    aqfy.anim(this, true, false);
    super.finish();
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    if (this.gallery.resetScale(false)) {
      return;
    }
    back();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    setContentView(2131562167);
    this.reqWidth = getResources().getDisplayMetrics().widthPixels;
    this.reqHeight = getResources().getDisplayMetrics().heightPixels;
    initData();
    initUI();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.popup != null) {
      this.popup.dismiss();
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    setIntent(paramIntent);
    initData();
    initUI();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if ((this.showBar) && (this.topBar != null)) {
      this.topBar.setVisibility(0);
    }
  }
  
  public String getURL(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    do
    {
      return str;
      if (paramString.startsWith("//")) {
        return "file:/" + paramString;
      }
      str = paramString;
    } while (!paramString.startsWith("/"));
    return "file://" + paramString;
  }
  
  void hideMenuBar()
  {
    this.showBar = false;
    this.topBar.setVisibility(4);
    if (this.popup != null) {
      this.popup.dismiss();
    }
  }
  
  void initData()
  {
    Intent localIntent = getIntent();
    this.backBtnText = localIntent.getStringExtra("back_btn_text");
    this.paths = localIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if (this.paths != null) {}
    for (int i = this.paths.size();; i = 0)
    {
      this.mTotalPicCount = i;
      if (this.mTotalPicCount >= 1) {
        break;
      }
      finish();
      return;
    }
    this.currentSelectedPostion = localIntent.getIntExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
    localIntent.removeExtra("PhotoConst.CURRENT_SELECTED_INDEX");
  }
  
  void initUI()
  {
    this.topBar = findViewById(2131380001);
    this.backBtn = ((TextView)findViewById(2131363233));
    this.backBtn.setOnClickListener(new PhotoPreviewActivity.1(this));
    if (this.showBar) {
      this.topBar.setVisibility(0);
    }
    this.titleView = ((TextView)findViewById(2131379769));
    this.gallery = ((ProGallery)findViewById(2131367833));
    this.adapter = new ImageAdapter();
    this.gallery.setAdapter(this.adapter);
    this.gallery.setOnNoBlankListener(this.adapter);
    this.gallery.setSpacing(getResources().getDimensionPixelSize(2131297406));
    this.gallery.setSelection(this.currentSelectedPostion);
    this.gallery.setOnItemClickListener(new PhotoPreviewActivity.2(this));
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  void showMenuBar()
  {
    this.showBar = true;
    this.topBar.setVisibility(0);
  }
  
  class ImageAdapter
    extends BaseAdapter
    implements ProGallery.b
  {
    SparseArray<URLDrawable> mActiveDrawable = new SparseArray();
    URLDrawable mRawDrawable;
    int mRawDrawablePosition = -1;
    
    ImageAdapter() {}
    
    public int getCount()
    {
      if (PhotoPreviewActivity.this.paths != null) {
        return PhotoPreviewActivity.this.paths.size();
      }
      return 0;
    }
    
    public String getItem(int paramInt)
    {
      if ((PhotoPreviewActivity.this.paths != null) && (paramInt < PhotoPreviewActivity.this.paths.size()) && (paramInt >= 0)) {
        return (String)PhotoPreviewActivity.this.paths.get(paramInt);
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView != null)
      {
        localObject1 = paramView;
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localObject1;
      }
      Object localObject2 = PhotoPreviewActivity.this.getURL(getItem(paramInt));
      Object localObject3 = (URLDrawable)this.mActiveDrawable.get(paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPreviewActivity", 2, "getView position=" + paramInt + ",cache=" + localObject3 + ",url=" + (String)localObject2);
      }
      Object localObject1 = new AbstractImageAdapter.URLImageView2(paramViewGroup.getContext());
      if ((localObject3 != null) && (((URLDrawable)localObject3).getStatus() == 1)) {
        ((ImageView)localObject1).setImageDrawable((Drawable)localObject3);
      }
      for (;;)
      {
        ((ImageView)localObject1).setContentDescription(acfp.m(2131709623) + paramInt);
        break;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          int i = paramViewGroup.getWidth();
          int j = paramViewGroup.getHeight();
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = i;
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = j;
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = aoop.TRANSPARENT;
          localObject2 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
          switch (((URLDrawable)localObject2).getStatus())
          {
          default: 
            ((URLDrawable)localObject2).setTag(Integer.valueOf(1));
            ((URLDrawable)localObject2).startDownload();
          }
          if (QLog.isColorLevel()) {
            QLog.d("PhotoPreviewActivity", 2, "getView position=" + paramInt + ",parentWidth=" + i + ",parentHeight=" + j);
          }
          ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
        }
      }
    }
    
    String listActiviteDrawables()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("(preview) Actives: ");
      int i = 0;
      while (i < this.mActiveDrawable.size())
      {
        if (i > 0) {
          localStringBuilder.append(" , ");
        }
        localStringBuilder.append(this.mActiveDrawable.keyAt(i) + 1);
        i += 1;
      }
      return localStringBuilder.toString();
    }
    
    public View onCreateView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramView = (URLDrawable)this.mActiveDrawable.get(paramInt);
      if (paramView != null) {
        if (paramView.getStatus() == 3) {
          paramView.restartDownload();
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoPreviewActivity", 2, listActiviteDrawables());
        }
        do
        {
          return null;
          paramView = PhotoPreviewActivity.this.getURL(getItem(paramInt));
          if (QLog.isColorLevel()) {
            QLog.d("PhotoPreviewActivity", 2, "onCreateView position=" + paramInt + ", url=" + paramView);
          }
        } while (TextUtils.isEmpty(paramView));
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = paramViewGroup.getWidth();
        localURLDrawableOptions.mRequestHeight = paramViewGroup.getHeight();
        localURLDrawableOptions.mLoadingDrawable = aoop.TRANSPARENT;
        paramView = URLDrawable.getDrawable(paramView, localURLDrawableOptions);
        paramView.setTag(Integer.valueOf(1));
        paramView.startDownload();
        this.mActiveDrawable.put(paramInt, paramView);
      }
    }
    
    public void onDestroyView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramView = (URLDrawable)this.mActiveDrawable.get(paramInt);
      if (paramView != null)
      {
        if (paramView.getStatus() == 0) {
          paramView.cancelDownload(true);
        }
        this.mActiveDrawable.remove(paramInt);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPreviewActivity", 2, listActiviteDrawables());
      }
    }
    
    public void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData)
    {
      if (!ImageView.class.isInstance(paramView)) {}
      do
      {
        return;
        paramView = ((ImageView)paramView).getDrawable();
      } while (!URLDrawable.class.isInstance(paramView));
      ((URLDrawable)paramView).updateRegionBitmap(paramRegionDrawableData);
    }
    
    public void onSlot(int paramInt, View paramView, ViewGroup paramViewGroup) {}
    
    public void onViewDetached(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
    {
      if (paramInt == this.mRawDrawablePosition)
      {
        if ((this.mRawDrawable != null) && (this.mRawDrawable.getStatus() == 0)) {
          this.mRawDrawable.cancelDownload(true);
        }
        this.mRawDrawable = null;
        this.mRawDrawablePosition = -1;
        if (QLog.isColorLevel()) {
          QLog.d("PhotoPreviewActivity", 2, "(preview)destory rawDrawable, position: " + paramInt);
        }
      }
    }
    
    public void onscaleBegin(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (!(paramView instanceof AbstractImageAdapter.URLImageView2)) {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoPreviewActivity", 2, "onscaleBegin,classcast error,class of current view is " + paramView.getClass().toString());
        }
      }
      do
      {
        do
        {
          do
          {
            return;
            paramView = (AbstractImageAdapter.URLImageView2)paramView;
            paramViewGroup = paramView.getDrawable();
            localObject = paramView.mDecoding;
          } while ((!(paramViewGroup instanceof URLDrawable)) || (!((URLDrawable)paramViewGroup).isFakeSize()) || (localObject != null));
          paramViewGroup = ((URLDrawable)paramViewGroup).getURL();
        } while ((!"file".equals(paramViewGroup.getProtocol())) || (paramViewGroup.getRef() != null));
        if ((paramInt != this.mRawDrawablePosition) || (this.mRawDrawable == null)) {
          break;
        }
        paramView = this.mRawDrawable;
      } while ((!QLog.isColorLevel()) || (this.mRawDrawable == null));
      QLog.d("PhotoPreviewActivity", 2, "use exist raw drawable");
      return;
      if ((QLog.isColorLevel()) && (this.mRawDrawable != null)) {
        QLog.d("PhotoPreviewActivity", 2, "rawDrawable is exist");
      }
      paramViewGroup = paramViewGroup.toString() + "#NOSAMPLE";
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
      ((URLDrawable.URLDrawableOptions)localObject).mUseMemoryCache = false;
      paramViewGroup = URLDrawable.getDrawable(paramViewGroup, (URLDrawable.URLDrawableOptions)localObject);
      paramViewGroup.setTag(Integer.valueOf(2));
      this.mRawDrawable = null;
      this.mRawDrawablePosition = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPreviewActivity", 2, "create rawDrawable, position:" + paramInt);
      }
      if (paramViewGroup.getStatus() == 1)
      {
        paramView.ignoreLayout = true;
        paramView.setImageDrawable(paramViewGroup);
        paramView.ignoreLayout = false;
        return;
      }
      paramView.setDecodingDrawble(paramViewGroup);
      paramViewGroup.startDownload();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.PhotoPreviewActivity
 * JD-Core Version:    0.7.0.1
 */