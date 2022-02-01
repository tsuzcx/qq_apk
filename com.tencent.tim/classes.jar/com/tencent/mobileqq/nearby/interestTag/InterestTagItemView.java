package com.tencent.mobileqq.nearby.interestTag;

import acfp;
import ajux;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aomc;
import aqbn;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;

public class InterestTagItemView
  extends RelativeLayout
{
  private ImageView Bm;
  private ImageView Bn;
  private TextView Vf;
  private URLDrawable.URLDrawableOptions jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions;
  private InterestTagInfo jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTagInfo;
  private a c;
  private boolean cqs;
  private int dlh;
  private View.OnClickListener eB = new ajux(this);
  private Context mContext;
  private float sG;
  
  public InterestTagItemView(Context paramContext)
  {
    super(paramContext);
    initViews(paramContext);
  }
  
  private void initViews(Context paramContext)
  {
    this.mContext = paramContext;
    paramContext = LayoutInflater.from(this.mContext).inflate(2131561449, this);
    this.Bm = ((ImageView)paramContext.findViewById(2131369115));
    this.Vf = ((TextView)paramContext.findViewById(2131381155));
    this.Bn = ((ImageView)paramContext.findViewById(2131369097));
    setBackgroundResource(2130845958);
    int i = getResources().getColor(2131166619);
    findViewById(2131381451).setBackgroundColor(i);
    this.Bn.setOnClickListener(this.eB);
    setOnClickListener(this.eB);
    this.sG = getResources().getDisplayMetrics().density;
    this.Bm.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  public void Rt(int paramInt)
  {
    this.dlh = paramInt;
    ViewGroup.LayoutParams localLayoutParams = this.Bm.getLayoutParams();
    if (paramInt == 5)
    {
      localLayoutParams.height = ((int)(this.sG * 50.0F + 0.5D));
      this.Bm.setLayoutParams(localLayoutParams);
    }
  }
  
  public void dzw()
  {
    boolean bool = this.c.b(this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTagInfo);
    if ((!bool) && (this.cqs == true)) {
      this.Bn.setImageResource(2130847987);
    }
    for (;;)
    {
      this.cqs = bool;
      return;
      if ((bool == true) && (!this.cqs)) {
        this.Bn.setImageResource(2130847988);
      }
    }
  }
  
  public void e(InterestTagInfo paramInterestTagInfo)
  {
    Object localObject4 = null;
    localObject2 = null;
    this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTagInfo = paramInterestTagInfo;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTagInfo == null) {
      return;
    }
    if ((this.dlh == 5) || (this.dlh == 6))
    {
      localObject1 = getResources().getDrawable(2131166111);
      this.Bm.setPadding(0, 0, 0, 0);
      this.Bm.setBackgroundResource(0);
      label66:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTagInfo.tagIconUrl)) {
        localObject3 = localObject4;
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localObject3 = localObject4;
        if (this.dlh != 5) {
          continue;
        }
        localObject3 = localObject4;
        localObject2 = this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions;
        localObject3 = localObject4;
        i = getResources().getDimensionPixelSize(2131297789);
        localObject3 = localObject4;
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = i;
        localObject3 = localObject4;
        localObject2 = this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions;
        localObject3 = localObject4;
        j = getResources().getDimensionPixelSize(2131297788);
        localObject3 = localObject4;
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = j;
        localObject3 = localObject4;
        this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mFailedDrawable = ((Drawable)localObject1);
        localObject3 = localObject4;
        this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mLoadingDrawable = ((Drawable)localObject1);
        localObject3 = localObject4;
        localObject2 = URLDrawable.getDrawable(aomc.l(this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTagInfo.tagIconUrl), this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions);
        localObject3 = localObject2;
        if (this.dlh != 7) {
          continue;
        }
        localObject3 = localObject2;
        ((URLDrawable)localObject2).setTag(aqbn.d(j, i, (int)(10.0F * this.sG)));
        localObject3 = localObject2;
        ((URLDrawable)localObject2).setDecodeHandler(aqbn.d);
      }
      catch (Exception localException)
      {
        int i;
        int j;
        localObject2 = localObject3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("choose_interest_tag", 2, localException.toString());
        localObject2 = localObject3;
        continue;
        localObject3 = localObject2;
        if (this.dlh == 5) {
          continue;
        }
        localObject3 = localObject2;
        if (this.dlh == 6) {
          continue;
        }
        localObject3 = localObject2;
        ((URLDrawable)localObject2).setTag(aqbn.e(j, i));
        localObject3 = localObject2;
        ((URLDrawable)localObject2).setDecodeHandler(aqbn.b);
        continue;
        localObject1 = localObject2;
        continue;
      }
      localObject3 = localObject2;
      this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mFailedDrawable = null;
      localObject3 = localObject2;
      this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mLoadingDrawable = null;
      localObject3 = this.Bm;
      if (localObject2 != null) {
        continue;
      }
      ((ImageView)localObject3).setImageDrawable((Drawable)localObject1);
      this.Vf.setText(paramInterestTagInfo.tagName);
      dzw();
      setTag(this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTagInfo);
      if (!AppSetting.enableTalkBack) {
        break;
      }
      setContentDescription(this.Vf.getText() + acfp.m(2131707446));
      return;
      if (this.dlh == 7)
      {
        localObject1 = new GradientDrawable();
        ((GradientDrawable)localObject1).setColor(getResources().getColor(2131166111));
        ((GradientDrawable)localObject1).setCornerRadius(10.0F * this.sG);
        ((GradientDrawable)localObject1).setShape(0);
        i = getResources().getDimensionPixelSize(2131297787);
        ((GradientDrawable)localObject1).setSize(i, i);
        this.Bm.setPadding(0, 0, 0, 0);
        this.Bm.setBackgroundResource(0);
        break label66;
      }
      localObject1 = new GradientDrawable();
      ((GradientDrawable)localObject1).setColor(getResources().getColor(2131166111));
      ((GradientDrawable)localObject1).setShape(1);
      i = getResources().getDimensionPixelSize(2131297787);
      ((GradientDrawable)localObject1).setSize(i, i);
      break label66;
      localObject3 = localObject4;
      localObject2 = this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions;
      localObject3 = localObject4;
      i = getResources().getDimensionPixelSize(2131297787);
      localObject3 = localObject4;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = i;
    }
  }
  
  public void setCallback(a parama)
  {
    this.c = parama;
  }
  
  public static abstract interface a
  {
    public abstract boolean b(InterestTagInfo paramInterestTagInfo);
    
    public abstract void d(InterestTagInfo paramInterestTagInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.InterestTagItemView
 * JD-Core Version:    0.7.0.1
 */