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
import bny;
import bnz;
import boa;
import bob;
import boc;
import com.tencent.biz.common.util.SubString;
import com.tencent.mobileqq.international.LocaleString;
import java.util.ArrayList;
import java.util.List;

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
    this.jdField_a_of_type_JavaLangRunnable = new boc(this);
    super.setFocusable(true);
    super.setOrientation(0);
    super.setGravity(16);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838053);
    this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramContext.getText(2131560552));
    paramAttributeSet = new LinearLayout.LayoutParams(-2, -2);
    paramAttributeSet.rightMargin = a(paramContext, 7.0F);
    paramAttributeSet.gravity = 16;
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramAttributeSet);
    super.addView(this.jdField_a_of_type_AndroidWidgetImageView);
    paramContext = (HorizontalScrollView)((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903222, null);
    if (Build.VERSION.SDK_INT >= 9) {
      paramContext.setOverScrollMode(2);
    }
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0F));
    super.addView(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramContext.findViewById(2131231667));
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
  
  public void a(MenuItem paramMenuItem)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramMenuItem);
    Object localObject = paramMenuItem.a();
    Drawable localDrawable = paramMenuItem.a();
    View localView = ((LayoutInflater)super.getContext().getSystemService("layout_inflater")).inflate(2130903223, null);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131231668);
    TextView localTextView = (TextView)localView.findViewById(2131231669);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131231670);
    if (localDrawable != null)
    {
      localImageView2.setImageDrawable(localDrawable);
      if (localObject == null) {
        break label232;
      }
      localObject = LocaleString.o(super.getContext(), (String)localObject);
      if (SubString.a((String)localObject) <= 10) {
        break label222;
      }
      localTextView.setText(SubString.a((String)localObject, 10, "..."));
    }
    int i;
    for (;;)
    {
      localObject = paramMenuItem.b();
      i = paramMenuItem.a();
      if (!paramMenuItem.a()) {
        break label343;
      }
      localImageView1.setVisibility(0);
      localImageView1.setImageResource(2130838493);
      localTextView.setTextColor(getResources().getColor(2131362043));
      localObject = new PopupMenu(super.getContext());
      i = 0;
      while (i < paramMenuItem.b())
      {
        ((PopupMenu)localObject).a(paramMenuItem.a(i));
        i += 1;
      }
      localImageView2.setVisibility(8);
      break;
      label222:
      localTextView.setText((CharSequence)localObject);
      continue;
      label232:
      localTextView.setVisibility(8);
    }
    ((PopupMenu)localObject).a(new bny(this, localImageView1, localTextView));
    ((PopupMenu)localObject).a(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar$OnMenuItemClickListener);
    localView.setOnTouchListener(new bnz(this, localImageView1, localTextView));
    localView.setOnClickListener(new boa(this, localImageView1, localTextView, (PopupMenu)localObject));
    for (;;)
    {
      localView.setFocusable(true);
      localView.setClickable(true);
      paramMenuItem = new LinearLayout.LayoutParams(-1, -1, 1.0F);
      paramMenuItem.gravity = 17;
      localView.setLayoutParams(paramMenuItem);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      return;
      label343:
      localView.setOnClickListener(new bob(this, (String)localObject, i));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.ui.CustomMenuBar
 * JD-Core Version:    0.7.0.1
 */