package com.tencent.mobileqq.troop.homework.entry.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import apgz.a.a;
import apim;
import com.tencent.biz.troopgift.RadioButtonIndicator;
import com.tencent.image.AbstractGifImage;
import java.util.ArrayList;

public class ComplexGuidViewPager
  extends RelativeLayout
  implements ViewPager.OnPageChangeListener
{
  protected float Ai;
  protected ArrayList<Object> BY;
  protected ImageView Ex;
  public a a;
  protected GuideViewPager a;
  protected TextView aaF;
  protected HorizontalScrollView b;
  protected RadioButtonIndicator b;
  protected String cpz;
  protected int dUk;
  protected int mScreenWidth;
  protected float rF;
  
  public ComplexGuidViewPager(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public ComplexGuidViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ComplexGuidViewPager(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(getContext()).inflate(2131561739, this, true);
    this.jdField_b_of_type_ComTencentBizTroopgiftRadioButtonIndicator = ((RadioButtonIndicator)findViewById(2131376603));
    this.jdField_b_of_type_ComTencentBizTroopgiftRadioButtonIndicator.setOrientation(0);
    this.jdField_b_of_type_ComTencentBizTroopgiftRadioButtonIndicator.setButtonResourceId(2130847082);
    this.jdField_b_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)findViewById(2131377766));
    this.aaF = ((TextView)findViewById(2131364003));
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewGuideViewPager = ((GuideViewPager)findViewById(2131368281));
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewGuideViewPager.setOnPagerSizeChangeListener(this.jdField_b_of_type_ComTencentBizTroopgiftRadioButtonIndicator);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewGuideViewPager.setOnPageChangeListener(this);
    this.Ex = ((ImageView)findViewById(2131377771));
    this.mScreenWidth = getResources().getDisplayMetrics().widthPixels;
    this.aaF.setOnClickListener(new apim(this));
  }
  
  public float by()
  {
    this.Ai = ((this.dUk - this.mScreenWidth) / (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewGuideViewPager.ul() - 1));
    this.rF = (this.Ai / this.mScreenWidth);
    return this.rF;
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if ((this.rF == 0.0F) || (this.dUk == 0))
    {
      this.dUk = this.Ex.getWidth();
      by();
    }
    paramInt1 = (int)(paramInt1 * this.Ai);
    paramInt2 = (int)(this.Ai * paramFloat);
    this.jdField_b_of_type_AndroidWidgetHorizontalScrollView.scrollTo(paramInt1 + paramInt2, 0);
  }
  
  public void onPageSelected(int paramInt)
  {
    AbstractGifImage.resumeAll();
    apgz.a.a locala = (apgz.a.a)this.BY.get(paramInt);
    this.jdField_b_of_type_ComTencentBizTroopgiftRadioButtonIndicator.onPageSelected(paramInt);
    RadioButtonIndicator localRadioButtonIndicator = this.jdField_b_of_type_ComTencentBizTroopgiftRadioButtonIndicator;
    if (locala.cQu) {}
    for (paramInt = 0;; paramInt = 8)
    {
      localRadioButtonIndicator.setVisibility(paramInt);
      return;
    }
  }
  
  public void setData(String paramString, ArrayList<Object> paramArrayList)
  {
    this.cpz = paramString;
    this.BY = paramArrayList;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewGuideViewPager.setData(paramArrayList);
    GuideViewPager.setBitmapByPath(this.Ex, this.cpz);
  }
  
  public void setOnActionBtnClickListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewComplexGuidViewPager$a = parama;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewGuideViewPager.setOnActionBtnClickListener(parama);
  }
  
  public static abstract interface a
  {
    public abstract void dZw();
    
    public abstract void dZx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.view.ComplexGuidViewPager
 * JD-Core Version:    0.7.0.1
 */