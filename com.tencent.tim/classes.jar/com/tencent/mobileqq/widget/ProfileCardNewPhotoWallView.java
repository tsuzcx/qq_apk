package com.tencent.mobileqq.widget;

import acfp;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import arhm;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ProfilePhotoWall;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;

public class ProfileCardNewPhotoWallView
  extends LinearLayout
{
  public LinkedList<ProfilePhotoWall> ar;
  protected int bYc;
  private Context ctx;
  private boolean dar;
  private int ehx;
  protected Drawable gk;
  protected int height;
  public Activity mActivity;
  public QQAppInterface mApp;
  protected LayoutInflater mLayoutInflater;
  private float mScale;
  public String mUin;
  protected int width;
  
  public ProfileCardNewPhotoWallView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ProfileCardNewPhotoWallView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.ctx = paramContext;
    this.mLayoutInflater = LayoutInflater.from(paramContext);
    init();
  }
  
  private void init()
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.mScale = localDisplayMetrics.density;
    this.width = localDisplayMetrics.widthPixels;
    this.height = localDisplayMetrics.heightPixels;
    this.bYc = ((int)(2.0F * this.mScale + 0.5F));
    int i = Math.max(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    if (i <= 240) {
      this.ehx = 60;
    }
    for (;;)
    {
      setOrientation(1);
      return;
      if (i <= 320) {
        this.ehx = 100;
      } else {
        this.ehx = 160;
      }
    }
  }
  
  public ViewGroup a(int paramInt1, int paramInt2, int paramInt3)
  {
    ProfilePhotoWall localProfilePhotoWall = (ProfilePhotoWall)this.ar.get(paramInt3);
    try
    {
      i = this.ar.size();
      if ((i == 1) || (i == 4)) {
        break label381;
      }
      if (i != 7) {
        break label385;
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        Object localObject1;
        if (QLog.isColorLevel()) {
          QLog.i("Q.qzonecover.", 2, localMalformedURLException.toString());
        }
        Object localObject2 = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        URLImageView localURLImageView;
        if (QLog.isColorLevel()) {
          QLog.i("Q.qzonecover.", 2, localException.toString());
        }
        Object localObject3 = null;
        continue;
        localURLImageView.setColorFilter(0);
        continue;
        localObject3 = null;
        continue;
        if ((paramInt3 != 0) && (((i != 2) && (i != 5) && (i != 8)) || ((paramInt3 != 0) && (paramInt3 != 1)))) {
          if (((i != 3) && (i != 6) && (i != 9)) || (paramInt3 != 0)) {}
        }
      }
    }
    for (localObject1 = new URL("qzone_cover", "original", localProfilePhotoWall.getOriginUrl());; localObject1 = new URL("qzone_cover", "original", localProfilePhotoWall.getThumbUrl(this.ehx)))
    {
      if (localObject1 == null) {
        break label375;
      }
      if (this.gk == null) {
        this.gk = getResources().getDrawable(2131166634);
      }
      Object localObject4 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable;
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = paramInt1;
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = paramInt2;
      localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject4);
      localObject4 = (ViewGroup)cz();
      localURLImageView = (URLImageView)((ViewGroup)localObject4).findViewById(2131369055);
      View localView = ((ViewGroup)localObject4).findViewById(2131369062);
      if (!ThemeUtil.isInNightMode(this.mApp)) {
        break;
      }
      localURLImageView.setColorFilter(1996488704);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt1, paramInt2);
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, new ColorDrawable(855638016));
      localStateListDrawable.addState(View.EMPTY_STATE_SET, new ColorDrawable(0));
      ((ViewGroup)localObject4).setLayoutParams(localLayoutParams);
      localURLImageView.setImageDrawable((Drawable)localObject1);
      localURLImageView.setContentDescription(String.format(acfp.m(2131709927), new Object[] { Integer.valueOf(paramInt3 + 1) }));
      localView.setBackgroundDrawable(localStateListDrawable);
      ((ViewGroup)localObject4).setOnClickListener(new arhm(this, localProfilePhotoWall, paramInt3));
      return localObject4;
    }
  }
  
  public void a(String paramString, Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    this.mUin = paramString;
    this.mActivity = paramActivity;
    this.mApp = paramQQAppInterface;
  }
  
  public void a(LinkedList<ProfilePhotoWall> paramLinkedList, int paramInt)
  {
    this.ar = paramLinkedList;
    int j;
    Object localObject1;
    int i;
    Object localObject2;
    Object localObject3;
    if (paramInt > 3)
    {
      a(paramLinkedList, paramInt - 3);
      j = (this.width - this.bYc * 2) / 3;
      paramLinkedList = new LinearLayout(this.ctx);
      paramLinkedList.setOrientation(0);
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject1).topMargin = this.bYc;
      i = 0;
      while (i < 3)
      {
        localObject2 = a(j, j, paramInt - 3 + i);
        localObject3 = new LinearLayout.LayoutParams(j, j);
        if (i != paramInt - 1) {
          ((LinearLayout.LayoutParams)localObject3).rightMargin = this.bYc;
        }
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        paramLinkedList.addView((View)localObject2);
        i += 1;
      }
      paramLinkedList.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      addView(paramLinkedList);
      return;
    }
    paramLinkedList = new LinearLayout(this.ctx);
    paramLinkedList.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    paramLinkedList.setOrientation(0);
    switch (paramInt)
    {
    }
    for (;;)
    {
      removeAllViews();
      addView(paramLinkedList);
      return;
      paramLinkedList.addView(a(this.width, this.width * 2 / 3, 0));
      continue;
      paramInt = (this.width - this.bYc) / 2;
      localObject1 = a(paramInt, paramInt, 0);
      localObject2 = a(paramInt, paramInt, 1);
      localObject3 = (LinearLayout.LayoutParams)((View)localObject2).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject3).setMargins(this.bYc, 0, 0, 0);
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      paramLinkedList.addView((View)localObject1);
      paramLinkedList.addView((View)localObject2);
      continue;
      paramInt = (this.width - this.bYc) * 2 / 3;
      i = paramInt / 2;
      j = (paramInt - this.bYc) / 2;
      localObject1 = a(paramInt, paramInt, 0);
      localObject2 = new LinearLayout(this.ctx);
      localObject3 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject3).setMargins(this.bYc, 0, 0, 0);
      ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      ((LinearLayout)localObject2).setOrientation(1);
      localObject3 = a(i, j, 1);
      ViewGroup localViewGroup = a(i, j, 2);
      ((LinearLayout.LayoutParams)localViewGroup.getLayoutParams()).setMargins(0, this.bYc, 0, 0);
      ((LinearLayout)localObject2).addView((View)localObject3);
      ((LinearLayout)localObject2).addView(localViewGroup);
      paramLinkedList.addView((View)localObject1);
      paramLinkedList.addView((View)localObject2);
    }
  }
  
  protected View cz()
  {
    return this.mLayoutInflater.inflate(2131561592, null);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    if (this.dar) {
      bool = false;
    }
    return bool;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(536870911, -2147483648));
  }
  
  @TargetApi(9)
  public void setOverScrollMode(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      super.setOverScrollMode(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardNewPhotoWallView
 * JD-Core Version:    0.7.0.1
 */