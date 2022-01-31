package com.tencent.biz.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.util.SubString;
import java.util.ArrayList;
import java.util.List;
import rd;
import re;
import rf;
import rg;
import rh;

public class CustomMenuBar
  extends LinearLayout
{
  public Handler a;
  public View a;
  protected ImageView a;
  protected LinearLayout a;
  public CustomMenuBar.OnMenuItemClickListener a;
  public PopupMenu a;
  public Runnable a;
  protected List a;
  public boolean a;
  public boolean b = false;
  
  public CustomMenuBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  @SuppressLint({"NewApi"})
  public CustomMenuBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizUiPopupMenu = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_JavaLangRunnable = new rh(this);
    super.setFocusable(true);
    super.setOrientation(0);
    super.setGravity(16);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839219);
    this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramContext.getText(2131362457));
    paramAttributeSet = new LinearLayout.LayoutParams(-2, -2);
    paramAttributeSet.rightMargin = a(paramContext, 7.0F);
    paramAttributeSet.gravity = 16;
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramAttributeSet);
    super.addView(this.jdField_a_of_type_AndroidWidgetImageView);
    paramContext = (HorizontalScrollView)((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903188, null);
    if (Build.VERSION.SDK_INT >= 9) {
      paramContext.setOverScrollMode(2);
    }
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0F));
    super.addView(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramContext.findViewById(2131297090));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(16);
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(MenuItem paramMenuItem, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramMenuItem);
    String str = paramMenuItem.a();
    Object localObject = paramMenuItem.a();
    View localView = ((LayoutInflater)super.getContext().getSystemService("layout_inflater")).inflate(2130903189, null);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131297091);
    TextView localTextView = (TextView)localView.findViewById(2131297092);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131297093);
    if (localObject != null)
    {
      localImageView2.setImageDrawable((Drawable)localObject);
      if (str == null) {
        break label226;
      }
      if (SubString.a(str) <= 10) {
        break label216;
      }
      localTextView.setText(SubString.a(str, 10, "..."));
    }
    int j;
    for (;;)
    {
      localObject = paramMenuItem.b();
      j = paramMenuItem.a();
      if (!paramMenuItem.a()) {
        break label348;
      }
      localImageView1.setVisibility(0);
      localImageView1.setImageResource(2130838371);
      localTextView.setTextColor(getResources().getColor(2131427446));
      localObject = new PopupMenu(super.getContext());
      int i = 0;
      while (i < paramMenuItem.b())
      {
        ((PopupMenu)localObject).a(paramMenuItem.a(i));
        i += 1;
      }
      localImageView2.setVisibility(8);
      break;
      label216:
      localTextView.setText(str);
      continue;
      label226:
      localTextView.setVisibility(8);
    }
    ((PopupMenu)localObject).a(new rd(this, localImageView1, localTextView));
    ((PopupMenu)localObject).a(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar$OnMenuItemClickListener);
    localView.setOnTouchListener(new re(this, localImageView1, localTextView));
    localView.setOnClickListener(new rf(this, localImageView1, localTextView, (PopupMenu)localObject, paramString, j, str));
    for (;;)
    {
      localView.setFocusable(true);
      localView.setClickable(true);
      paramMenuItem = new LinearLayout.LayoutParams(-1, -1, 1.0F);
      paramMenuItem.gravity = 17;
      localView.setLayoutParams(paramMenuItem);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      return;
      label348:
      localView.setOnClickListener(new rg(this, (String)localObject, j));
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_ComTencentBizUiPopupMenu != null) {
      this.jdField_a_of_type_ComTencentBizUiPopupMenu.b();
    }
  }
  
  public void setCoverView(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void setOnBackClickListner(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnMenuItemClickListener(CustomMenuBar.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar$OnMenuItemClickListener = paramOnMenuItemClickListener;
  }
  
  public void setSwitchIconDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.biz.ui.CustomMenuBar
 * JD-Core Version:    0.7.0.1
 */