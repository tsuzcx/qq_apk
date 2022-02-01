package com.tencent.biz.troopgift;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import snc;

public class RadioViewPager
  extends RelativeLayout
{
  protected TextView AI;
  protected TextView AJ;
  protected TextView AK;
  protected GridListViewPager b;
  protected RadioButtonIndicator b;
  protected View qm;
  
  public RadioViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RadioViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = LayoutInflater.from(paramContext).inflate(2131560806, this, false);
    this.jdField_b_of_type_ComTencentBizTroopgiftGridListViewPager = ((GridListViewPager)paramContext.findViewById(2131372827));
    this.jdField_b_of_type_ComTencentBizTroopgiftRadioButtonIndicator = ((RadioButtonIndicator)paramContext.findViewById(2131369149));
    this.jdField_b_of_type_ComTencentBizTroopgiftRadioButtonIndicator.setOrientation(0);
    this.jdField_b_of_type_ComTencentBizTroopgiftGridListViewPager.setOnPagerSizeChangeListener(this.jdField_b_of_type_ComTencentBizTroopgiftRadioButtonIndicator);
    this.jdField_b_of_type_ComTencentBizTroopgiftGridListViewPager.setOnPageChangeListener(this.jdField_b_of_type_ComTencentBizTroopgiftRadioButtonIndicator);
    this.qm = paramContext.findViewById(2131368046);
    this.AI = ((TextView)paramContext.findViewById(2131368044));
    this.AK = ((TextView)paramContext.findViewById(2131368045));
    this.AJ = ((TextView)paramContext.findViewById(2131368043));
    this.AK.getPaint().setFlags(8);
    this.AK.getPaint().setAntiAlias(true);
    addView(paramContext);
  }
  
  public absMultiViewPager a()
  {
    return this.jdField_b_of_type_ComTencentBizTroopgiftGridListViewPager;
  }
  
  public void setEmptyInfo(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      this.AI.setText(paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      this.AK.setText(paramString2);
    }
  }
  
  public void setGiftPanel(TroopGiftPanel paramTroopGiftPanel)
  {
    this.jdField_b_of_type_ComTencentBizTroopgiftGridListViewPager.b = paramTroopGiftPanel;
  }
  
  public void setIsListEmpty(boolean paramBoolean)
  {
    View localView = this.qm;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void setIsShowJumpInfo(boolean paramBoolean, String paramString, Context paramContext)
  {
    int j = 0;
    TextView localTextView = this.AK;
    if (paramBoolean)
    {
      i = 0;
      localTextView.setVisibility(i);
      localTextView = this.AJ;
      if (!paramBoolean) {
        break label80;
      }
    }
    label80:
    for (int i = j;; i = 8)
    {
      localTextView.setVisibility(i);
      if ((paramBoolean) && (!TextUtils.isEmpty(paramString))) {
        this.AK.setOnClickListener(new snc(this, paramContext, paramString));
      }
      return;
      i = 8;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.troopgift.RadioViewPager
 * JD-Core Version:    0.7.0.1
 */