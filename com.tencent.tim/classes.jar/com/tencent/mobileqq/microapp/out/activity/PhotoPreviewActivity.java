package com.tencent.mobileqq.microapp.out.activity;

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
import com.tencent.mobileqq.microapp.R.dimen;
import com.tencent.mobileqq.microapp.R.id;
import com.tencent.mobileqq.microapp.R.layout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;
import java.net.URL;
import java.util.ArrayList;

public class PhotoPreviewActivity
  extends BaseActivity
{
  boolean a = true;
  ArrayList b;
  int c = 0;
  String d;
  BubblePopupWindow e;
  a f;
  int g;
  View h;
  ProGallery i;
  TextView j;
  
  public String a(String paramString)
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
  
  void a()
  {
    Intent localIntent = getIntent();
    this.d = localIntent.getStringExtra("back_btn_text");
    this.b = localIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if (this.b != null) {}
    for (int k = this.b.size();; k = 0)
    {
      this.c = k;
      if (this.c >= 1) {
        break;
      }
      finish();
      return;
    }
    this.g = localIntent.getIntExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
    localIntent.removeExtra("PhotoConst.CURRENT_SELECTED_INDEX");
  }
  
  void b()
  {
    this.h = findViewById(R.id.bp);
    this.j = ((TextView)findViewById(R.id.h));
    this.j.setOnClickListener(new h(this));
    if (this.a) {
      this.h.setVisibility(0);
    }
    findViewById(R.id.bj);
    this.i = ((ProGallery)findViewById(R.id.z));
    this.f = new a();
    this.i.setAdapter(this.f);
    this.i.setOnNoBlankListener(this.f);
    this.i.setSpacing(getResources().getDimensionPixelSize(R.dimen.a));
    this.i.setSelection(this.g);
    this.i.setOnItemClickListener(new i(this));
    if (!TextUtils.isEmpty(this.d))
    {
      this.j.setTextColor(-1);
      this.j.setText(this.d);
    }
  }
  
  void c()
  {
    this.a = false;
    this.h.setVisibility(4);
    if (this.e != null) {
      this.e.dismiss();
    }
  }
  
  void d()
  {
    this.a = true;
    this.h.setVisibility(0);
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    if (this.i.resetScale(false)) {
      return;
    }
    e();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    setContentView(R.layout.h);
    int k = getResources().getDisplayMetrics().widthPixels;
    k = getResources().getDisplayMetrics().heightPixels;
    a();
    b();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.e != null) {
      this.e.dismiss();
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    setIntent(paramIntent);
    a();
    b();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if ((this.a) && (this.h != null)) {
      this.h.setVisibility(0);
    }
  }
  
  void e()
  {
    aqfy.anim(this, true, false);
    super.finish();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  final class a
    extends BaseAdapter
    implements ProGallery.b
  {
    SparseArray a = new SparseArray();
    URLDrawable b;
    int c = -1;
    
    a() {}
    
    String a()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("(preview) Actives: ");
      int i = 0;
      while (i < this.a.size())
      {
        if (i > 0) {
          localStringBuilder.append(" , ");
        }
        localStringBuilder.append(this.a.keyAt(i) + 1);
        i += 1;
      }
      return localStringBuilder.toString();
    }
    
    public String a(int paramInt)
    {
      if ((PhotoPreviewActivity.this.b != null) && (paramInt < PhotoPreviewActivity.this.b.size()) && (paramInt >= 0)) {
        return (String)PhotoPreviewActivity.this.b.get(paramInt);
      }
      return null;
    }
    
    public int getCount()
    {
      if (PhotoPreviewActivity.this.b != null) {
        return PhotoPreviewActivity.this.b.size();
      }
      return 0;
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
      Object localObject2 = PhotoPreviewActivity.this.a(a(paramInt));
      Object localObject3 = (URLDrawable)this.a.get(paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPreviewActivity", 2, "getView position=" + paramInt + ",cache=" + localObject3 + ",url=" + (String)localObject2);
      }
      Object localObject1 = new AbstractImageAdapter.URLImageView2(paramViewGroup.getContext());
      if ((localObject3 != null) && (((URLDrawable)localObject3).getStatus() == 1)) {
        ((ImageView)localObject1).setImageDrawable((Drawable)localObject3);
      }
      for (;;)
      {
        ((ImageView)localObject1).setContentDescription("照片" + paramInt);
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
    
    public View onCreateView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramView = (URLDrawable)this.a.get(paramInt);
      if (paramView != null) {
        if (paramView.getStatus() == 3) {
          paramView.restartDownload();
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoPreviewActivity", 2, a());
        }
        do
        {
          return null;
          paramView = PhotoPreviewActivity.this.a(a(paramInt));
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
        this.a.put(paramInt, paramView);
      }
    }
    
    public void onDestroyView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramView = (URLDrawable)this.a.get(paramInt);
      if (paramView != null)
      {
        if (paramView.getStatus() == 0) {
          paramView.cancelDownload(true);
        }
        this.a.remove(paramInt);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPreviewActivity", 2, a());
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
      if (paramInt == this.c)
      {
        if ((this.b != null) && (this.b.getStatus() == 0)) {
          this.b.cancelDownload(true);
        }
        this.b = null;
        this.c = -1;
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
        if ((paramInt != this.c) || (this.b == null)) {
          break;
        }
      } while ((!QLog.isColorLevel()) || (this.b == null));
      QLog.d("PhotoPreviewActivity", 2, "use exist raw drawable");
      return;
      if ((QLog.isColorLevel()) && (this.b != null)) {
        QLog.d("PhotoPreviewActivity", 2, "rawDrawable is exist");
      }
      paramViewGroup = paramViewGroup.toString() + "#NOSAMPLE";
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
      ((URLDrawable.URLDrawableOptions)localObject).mUseMemoryCache = false;
      paramViewGroup = URLDrawable.getDrawable(paramViewGroup, (URLDrawable.URLDrawableOptions)localObject);
      paramViewGroup.setTag(Integer.valueOf(2));
      this.b = null;
      this.c = paramInt;
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
 * Qualified Name:     com.tencent.mobileqq.microapp.out.activity.PhotoPreviewActivity
 * JD-Core Version:    0.7.0.1
 */