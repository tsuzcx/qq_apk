package com.tencent.biz.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aqcx;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.ArrayList;
import java.util.List;
import jqn;
import soj;
import sok;
import sol;
import som;
import soo;
import sop;
import sor;

public class CustomMenuBar
  extends LinearLayout
{
  public boolean Bx;
  public boolean By;
  private int RX;
  public a a;
  public sor a;
  protected LinearLayout cp;
  protected List<soo> dK = new ArrayList();
  public View fc;
  public Handler mHandler = new Handler();
  protected int mMenuType = 0;
  public Runnable mRunnable = new CustomMenuBar.5(this);
  protected ImageView oA;
  
  public CustomMenuBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  @SuppressLint({"NewApi"})
  public CustomMenuBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setFocusable(true);
    super.setOrientation(0);
    super.setGravity(16);
    this.oA = new ImageView(paramContext);
    this.oA.setImageResource(2130850844);
    this.oA.setClickable(true);
    this.oA.setContentDescription(paramContext.getText(2131698664));
    if (isDefaultTheme()) {
      setBackgroundColor(paramContext.getResources().getColor(2131167447));
    }
    paramAttributeSet = new LinearLayout.LayoutParams(-2, -2);
    paramAttributeSet.leftMargin = 0;
    paramAttributeSet.rightMargin = aqcx.dip2px(paramContext, 7.0F);
    paramAttributeSet.gravity = 16;
    this.oA.setLayoutParams(paramAttributeSet);
    super.addView(this.oA);
    paramContext = (HorizontalScrollView)((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131559305, null);
    if (Build.VERSION.SDK_INT >= 9) {
      paramContext.setOverScrollMode(2);
    }
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0F));
    super.addView(paramContext);
    this.cp = ((LinearLayout)paramContext.findViewById(2131367123));
    this.cp.setGravity(16);
  }
  
  public static boolean isDefaultTheme()
  {
    String str = ThemeUtil.getCurrentThemeInfo().getString("themeId");
    return (str != null) && (str.equals("1000"));
  }
  
  public void SX()
  {
    if (this.jdField_a_of_type_Sor == null) {
      return;
    }
    this.jdField_a_of_type_Sor.dismiss();
  }
  
  public void SY()
  {
    this.RX = 0;
    this.cp.removeAllViews();
    this.dK.clear();
  }
  
  View a(soo paramsoo, String paramString)
  {
    String str = paramsoo.getTitle();
    Object localObject = paramsoo.getIcon();
    View localView = ((LayoutInflater)super.getContext().getSystemService("layout_inflater")).inflate(2131559306, null);
    ImageView localImageView2;
    TextView localTextView;
    ImageView localImageView1;
    if (isDefaultTheme())
    {
      localView.setBackgroundResource(2130842598);
      localImageView2 = (ImageView)localView.findViewById(2131371289);
      localTextView = (TextView)localView.findViewById(2131371301);
      localImageView1 = (ImageView)localView.findViewById(2131378947);
      if (localObject == null) {
        break label220;
      }
      localImageView2.setImageDrawable((Drawable)localObject);
      label93:
      if (str == null) {
        break label240;
      }
      if (jqn.aC(str) <= 10) {
        break label230;
      }
      localTextView.setText(jqn.c(str, 10, "..."));
    }
    int j;
    int i;
    for (;;)
    {
      localObject = paramsoo.eo();
      j = paramsoo.hF();
      if (!paramsoo.hasSubMenu()) {
        break label347;
      }
      localImageView1.setVisibility(0);
      localImageView1.setImageResource(2130844067);
      localObject = new sop(super.getContext());
      i = 0;
      while (i < paramsoo.hE())
      {
        ((sop)localObject).c(paramsoo.a(i));
        i += 1;
      }
      localView.setBackgroundResource(2130840190);
      localView.findViewById(2131371308).setVisibility(8);
      break;
      label220:
      localImageView2.setVisibility(8);
      break label93;
      label230:
      localTextView.setText(str);
      continue;
      label240:
      localTextView.setVisibility(8);
    }
    ((sop)localObject).setOnDismissListener(new soj(this, localImageView1, localTextView));
    ((sop)localObject).setOnMenuItemClickListener(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar$a);
    localView.setOnTouchListener(new sok(this, localImageView1));
    localView.setOnClickListener(new sol(this, localImageView1, localTextView, (sop)localObject, paramString, j, str));
    for (;;)
    {
      i = this.RX;
      this.RX = (i + 1);
      if (i == 0) {
        localView.findViewById(2131371308).setVisibility(8);
      }
      return localView;
      label347:
      localView.setOnClickListener(new som(this, (String)localObject, j));
    }
  }
  
  public void a(soo paramsoo, String paramString)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1, 1.0F);
    localLayoutParams.gravity = 17;
    paramString = a(paramsoo, paramString);
    this.dK.add(paramsoo);
    paramString.setFocusable(true);
    paramString.setClickable(true);
    paramString.setLayoutParams(localLayoutParams);
    this.cp.addView(paramString);
  }
  
  public void bzJ()
  {
    this.oA.performClick();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_Sor != null) {
      this.jdField_a_of_type_Sor.dismiss();
    }
  }
  
  public void setCoverView(View paramView)
  {
    this.fc = paramView;
  }
  
  public void setMenuType(int paramInt)
  {
    this.mMenuType = paramInt;
  }
  
  public void setOnBackClickListner(View.OnClickListener paramOnClickListener)
  {
    this.oA.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnMenuItemClickListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar$a = parama;
  }
  
  public void setSwitchIconDrawable(Drawable paramDrawable)
  {
    this.oA.setImageDrawable(paramDrawable);
  }
  
  public static abstract interface a
  {
    public abstract void B(String paramString, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.ui.CustomMenuBar
 * JD-Core Version:    0.7.0.1
 */