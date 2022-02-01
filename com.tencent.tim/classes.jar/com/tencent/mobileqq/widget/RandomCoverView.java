package com.tencent.mobileqq.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import aqcx;
import aqep;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class RandomCoverView
  extends FrameLayout
{
  private View JD;
  protected URLDrawable O;
  protected QQAppInterface app;
  protected String cAz;
  private URLImageView ca;
  protected boolean dbn = true;
  protected boolean dbo;
  protected Paint mPaint;
  protected String mUin;
  protected int oR = 0;
  
  public RandomCoverView(Context paramContext)
  {
    super(paramContext);
    initUI();
  }
  
  public RandomCoverView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initUI();
  }
  
  public RandomCoverView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initUI();
  }
  
  private void initUI()
  {
    this.ca = new URLImageView(getContext());
    this.JD = new View(getContext());
    for (;;)
    {
      try
      {
        if (!ThemeUtil.isInNightMode(this.app)) {
          continue;
        }
        i = -1308622848;
        this.JD.setBackgroundColor(i);
      }
      catch (Throwable localThrowable)
      {
        int i;
        FrameLayout.LayoutParams localLayoutParams;
        continue;
      }
      localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      super.addView(this.ca, localLayoutParams);
      super.addView(this.JD, localLayoutParams);
      this.ca.setScaleType(ImageView.ScaleType.CENTER_CROP);
      return;
      i = getResources().getColor(2131165631);
    }
  }
  
  public int ML()
  {
    return this.oR;
  }
  
  public void YL(int paramInt)
  {
    if (paramInt == this.oR) {
      return;
    }
    this.oR = paramInt;
    if (this.oR == 1)
    {
      localLayoutParams = getLayoutParams();
      if (localLayoutParams != null)
      {
        paramInt = getResources().getDimensionPixelSize(2131299627);
        int i = ImmersiveUtils.getStatusBarHeight(getContext());
        int j = getResources().getDimensionPixelSize(2131297964);
        localLayoutParams.width = -1;
        localLayoutParams.height = (paramInt + j + i);
        setLayoutParams(localLayoutParams);
      }
      this.JD.setBackgroundColor(getResources().getColor(2131167599));
      this.ca.setVisibility(8);
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.width = -1;
      localLayoutParams.height = getResources().getDimensionPixelSize(2131297973);
      setLayoutParams(localLayoutParams);
    }
    this.JD.setBackgroundColor(getResources().getColor(2131165631));
    this.ca.setVisibility(0);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.app = paramQQAppInterface;
    this.mUin = paramString1;
    YL(paramInt);
    if (TextUtils.isEmpty(paramString2))
    {
      setDefaultCoverBg();
      if ((!paramQQAppInterface.getCurrentAccountUin().equals(this.mUin)) || ((!TextUtils.isEmpty(paramString2)) && (!paramBoolean1))) {
        break label149;
      }
      if (this.mPaint == null)
      {
        float f = aqcx.dip2px(getContext(), 14.0F);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(Color.parseColor("#4CFFFFFF"));
        this.mPaint.setTextSize(f);
      }
      this.cAz = getResources().getString(2131697199);
    }
    label149:
    for (this.dbn = true;; this.dbn = false)
    {
      this.dbo = paramBoolean2;
      return;
      ds(paramString2, paramBoolean1);
      break;
    }
  }
  
  public void aQ(String paramString, int paramInt1, int paramInt2)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        if (this.O != null) {
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.O.getCurrDrawable();
        }
        Drawable localDrawable;
        for (((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.O.getCurrDrawable();; ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localDrawable)
        {
          ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramInt2;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramInt1;
          localObject = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
          this.O = ((URLDrawable)localObject);
          this.ca.setScaleType(ImageView.ScaleType.CENTER_CROP);
          this.ca.setImageDrawable((Drawable)localObject);
          this.JD.setVisibility(0);
          this.JD.setBackgroundColor(getResources().getColor(2131165635));
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.profilecard.", 2, "updateCover " + paramString);
          return;
          localDrawable = getResources().getDrawable(2130846645);
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
        }
        return;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          QLog.i("Q.profilecard.", 2, paramString.toString());
          return;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.", 2, paramString.toString());
        }
      }
    }
  }
  
  public View cB()
  {
    return this.JD;
  }
  
  public void ds(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
        if (this.O != null) {
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.O.getCurrDrawable();
        }
        Object localObject2;
        for (((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.O.getCurrDrawable();; ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2))
        {
          localObject2 = (Activity)getContext();
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = aqep.y((Activity)localObject2);
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = aqep.x((Activity)localObject2);
          localObject1 = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject1);
          this.O = ((URLDrawable)localObject1);
          this.ca.setScaleType(ImageView.ScaleType.CENTER_CROP);
          this.ca.setImageDrawable((Drawable)localObject1);
          this.dbn = paramBoolean;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.profilecard.", 2, "updateCover " + paramString + " isDef:" + paramBoolean);
          return;
          localObject2 = getResources().getDrawable(2130846645);
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
        }
        return;
      }
      catch (OutOfMemoryError paramString)
      {
        QLog.e("Q.profilecard.", 1, "updateCover OutOfMemoryError happened.", paramString);
        return;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.", 2, paramString.toString());
        }
      }
    }
  }
  
  public URLImageView e()
  {
    return this.ca;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.mPaint != null) && (!TextUtils.isEmpty(this.cAz)) && (getHeight() != 0) && (getWidth() != 0) && (this.dbn) && (this.dbo))
    {
      float f = this.mPaint.measureText(this.cAz);
      int i = getHeight() / 2;
      int j = (getWidth() - (int)f) / 2;
      paramCanvas.drawText(this.cAz, j, i, this.mPaint);
    }
  }
  
  public void setDefaultCoverBg()
  {
    this.JD.setVisibility(8);
    this.ca.setImageDrawable(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RandomCoverView
 * JD-Core Version:    0.7.0.1
 */