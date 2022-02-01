package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqdf;
import aqho;
import com.tencent.mobileqq.activity.contact.connections.OverlappingImgLayout;
import com.tencent.qphone.base.util.QLog;

public class FormMutiWithAvatarItem
  extends FormMutiItem
{
  protected CharSequence aF;
  protected TextView abW;
  protected OverlappingImgLayout b;
  protected int egc = 2;
  protected LinearLayout lk;
  
  public FormMutiWithAvatarItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FormMutiWithAvatarItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ehW();
  }
  
  private void ehW()
  {
    this.lk = new LinearLayout(getContext());
    this.lk.setId(2131367516);
    this.lk.setOrientation(0);
    this.lk.setGravity(16);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(0, 2131367517);
    localLayoutParams.addRule(15);
    addView(this.lk, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(1, 2131367515);
    localLayoutParams.addRule(0, 2131367516);
    localLayoutParams.addRule(15);
    this.lj.setLayoutParams(localLayoutParams);
  }
  
  public boolean aGw()
  {
    return (this.b != null) && (this.b.getChildCount() != 0);
  }
  
  public void setOverimgLayout(int paramInt1, int paramInt2, String[] paramArrayOfString, aqdf paramaqdf)
  {
    this.b.a(paramInt1, paramInt2, paramArrayOfString, paramaqdf);
  }
  
  public void setOverloading()
  {
    this.abW = new TextView(getContext());
    this.abW.setSingleLine(true);
    this.abW.setTextColor(d(getResources(), this.egc));
    int i = getResources().getDimensionPixelSize(2131296934);
    this.abW.setTextSize(0, i);
    this.abW.setGravity(21);
    this.abW.setEllipsize(TextUtils.TruncateAt.END);
    this.abW.setDuplicateParentStateEnabled(true);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = ((int)aqho.convertDpToPixel(getContext(), 5.0F));
    this.lk.addView(this.abW, localLayoutParams);
    this.b = new OverlappingImgLayout(getContext());
    this.b.setGravity(21);
    localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = ((int)aqho.convertDpToPixel(getContext(), 12.0F));
    this.lk.addView(this.b, localLayoutParams);
    if (QLog.isColorLevel()) {
      QLog.d("FormMutiWithAvatarItem", 2, "setOverloading, run ");
    }
  }
  
  public void setPeopleText(String paramString)
  {
    this.aF = paramString;
    this.abW.setText(this.aF);
  }
  
  public void setPeopleTextColor(int paramInt)
  {
    this.egc = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormMutiWithAvatarItem
 * JD-Core Version:    0.7.0.1
 */