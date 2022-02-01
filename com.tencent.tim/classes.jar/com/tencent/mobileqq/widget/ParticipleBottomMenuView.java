package com.tencent.mobileqq.widget;

import acfp;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import anot;
import argp;
import atau.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ParticipleBottomMenuView
  extends LinearLayout
  implements View.OnClickListener
{
  private ImageView FA;
  private ImageView FB;
  private ImageView FC;
  private ImageView FD;
  private a jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView$a;
  private ParticipleView jdField_a_of_type_ComTencentMobileqqWidgetParticipleView;
  private int egX;
  private int mStyle;
  
  public ParticipleBottomMenuView(Context paramContext)
  {
    super(paramContext);
    init(paramContext, null);
  }
  
  public ParticipleBottomMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
  }
  
  public ParticipleBottomMenuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    LayoutInflater.from(getContext()).inflate(2131559736, this, true);
    this.FA = ((ImageView)findViewById(2131372870));
    this.FB = ((ImageView)findViewById(2131372874));
    this.FC = ((ImageView)findViewById(2131372872));
    this.FD = ((ImageView)findViewById(2131372876));
    this.FA.setContentDescription(qo(acfp.m(2131709397)));
    this.FB.setContentDescription(qo(acfp.m(2131709401)));
    this.FC.setContentDescription(qo(acfp.m(2131709400)));
    this.FD.setContentDescription(qo(acfp.m(2131709398)));
    TextView localTextView = (TextView)findViewById(2131380838);
    findViewById(2131372871).setOnClickListener(this);
    findViewById(2131372875).setOnClickListener(this);
    findViewById(2131372873).setOnClickListener(this);
    findViewById(2131372877).setOnClickListener(this);
    localTextView.setOnClickListener(this);
    if ((paramAttributeSet != null) && (paramContext != null))
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.rj);
      this.mStyle = paramContext.getInteger(1, 0);
      this.egX = paramContext.getInteger(0, 200);
      paramContext.recycle();
    }
    if (this.mStyle == 1)
    {
      paramContext = "#000000";
      setBackgroundColor(Color.parseColor(paramContext));
      if (this.mStyle != 1) {
        break label278;
      }
    }
    label278:
    for (paramContext = "#ffffff";; paramContext = "#000000")
    {
      localTextView.setTextColor(Color.parseColor(paramContext));
      eif();
      return;
      paramContext = "#e6ffffff";
      break;
    }
  }
  
  public void a(ParticipleView paramParticipleView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView = paramParticipleView;
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.setOnParticipleSelectChangeListener(new argp(this));
  }
  
  public void eif()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.CS())))
    {
      if (this.mStyle == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon enable STATE_BLACK");
        }
        this.FA.setBackgroundResource(2130846510);
        this.FB.setBackgroundResource(2130846535);
        this.FC.setBackgroundResource(2130846516);
        this.FD.setBackgroundResource(2130846548);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon enable STATE_WHITE");
      }
      this.FA.setBackgroundResource(2130846507);
      this.FB.setBackgroundResource(2130846522);
      this.FC.setBackgroundResource(2130846513);
      this.FD.setBackgroundResource(2130846528);
      return;
    }
    if (this.mStyle == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon unable STATE_BLACK");
      }
      this.FA.setBackgroundResource(2130846508);
      this.FB.setBackgroundResource(2130846523);
      this.FC.setBackgroundResource(2130846514);
      this.FD.setBackgroundResource(2130846525);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon unable STATE_BLACK");
    }
    this.FA.setBackgroundResource(2130846509);
    this.FB.setBackgroundResource(2130846524);
    this.FC.setBackgroundResource(2130846515);
    this.FD.setBackgroundResource(2130846529);
  }
  
  public void eig()
  {
    eif();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(this.egX);
    setAlpha(0.0F);
    setVisibility(0);
    localObjectAnimator.start();
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView$a != null)
    {
      if (paramView.getId() != 2131380838) {
        break label66;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView$a.auC();
      anot.a(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35F", "0X800A35F", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label66:
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView != null)
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.CS();
        if (!TextUtils.isEmpty(str)) {
          switch (paramView.getId())
          {
          case 2131372872: 
          case 2131372874: 
          case 2131372876: 
          default: 
            break;
          case 2131372871: 
            this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView$a.AX(str);
            anot.a(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35A", "0X800A35A", 0, 0, "", "", "", "");
            break;
          case 2131372873: 
            this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView$a.AZ(str);
            anot.a(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35B", "0X800A35B", 0, 0, "", "", "", "");
            break;
          case 2131372875: 
            this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView$a.AY(str);
            anot.a(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35C", "0X800A35C", 0, 0, "", "", "", "");
            break;
          case 2131372877: 
            this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView$a.Ba(str);
            anot.a(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35E", "0X800A35E", 0, 0, "", "", "", "");
            break;
          }
        } else {
          QQToast.a(BaseApplicationImpl.getContext(), -1, acfp.m(2131709396), 0).show();
        }
      }
      else
      {
        QQToast.a(getContext(), acfp.m(2131709399), 0).show();
      }
    }
  }
  
  public String qo(String paramString)
  {
    return getContext().getString(2131691041, new Object[] { paramString });
  }
  
  public void setOnMenuClickListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView$a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void AX(String paramString);
    
    public abstract void AY(String paramString);
    
    public abstract void AZ(String paramString);
    
    public abstract void Ba(String paramString);
    
    public abstract void auC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ParticipleBottomMenuView
 * JD-Core Version:    0.7.0.1
 */