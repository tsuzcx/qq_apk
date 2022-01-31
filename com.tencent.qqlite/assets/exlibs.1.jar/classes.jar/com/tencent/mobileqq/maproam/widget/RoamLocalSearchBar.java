package com.tencent.mobileqq.maproam.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import dxm;

public class RoamLocalSearchBar
  extends LinearLayout
  implements View.OnClickListener
{
  public static final String a = "RoamLocalSearchBar";
  public int a;
  long a;
  public Context a;
  public View a;
  public EditText a;
  public RelativeLayout a;
  public BaseActivity a;
  public QQAppInterface a;
  public RoamSearchDialog.OnRoamResultObserver a;
  public RoamSearchDialog.OnSearchResultItemClick a;
  public RoamSearchDialog a;
  long b;
  public View b;
  public String b;
  public View c;
  
  public RoamLocalSearchBar(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 1000L;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public RoamLocalSearchBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 1000L;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext);
    LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903595, this, true);
    IphoneTitleBarActivity.setLayerType(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131297994));
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.c = findViewById(2131296898);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131298677));
    setBackgroundAlpha(0.0F);
  }
  
  public void a(QQAppInterface paramQQAppInterface, RoamSearchDialog.OnRoamResultObserver paramOnRoamResultObserver, RoamSearchDialog.OnSearchResultItemClick paramOnSearchResultItemClick)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnRoamResultObserver = paramOnRoamResultObserver;
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnSearchResultItemClick = paramOnSearchResultItemClick;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoamLocalSearchBar", 2, "updateRegion city=" + paramString);
    }
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog = new RoamSearchDialog(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.a(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.a(this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnRoamResultObserver);
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.a(this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnSearchResultItemClick);
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.setOnDismissListener(new dxm(this));
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.show();
    startAnimation(AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130968606));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
    } while (l - this.jdField_a_of_type_Long <= 1000L);
    this.jdField_a_of_type_Long = l;
    b();
  }
  
  public void setBackgroundAlpha(float paramFloat)
  {
    int j = (int)(255.0F * paramFloat);
    if ((Math.abs(j - this.jdField_a_of_type_Int) >= 10) || ((this.jdField_a_of_type_Int < 255) && (j >= 255)) || ((this.jdField_a_of_type_Int > 0) && (j <= 0))) {}
    for (int i = 1;; i = 0)
    {
      if ((j >= 0) && (j <= 255) && (i != 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("RoamLocalSearchBar", 2, "setBackgroundAlpha set background drawable alpha=" + j);
        }
        Drawable localDrawable1 = getBackground();
        if (localDrawable1 != null)
        {
          localDrawable1.setAlpha(j);
          localDrawable1.invalidateSelf();
        }
        localDrawable1 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getBackground();
        if (localDrawable1 != null)
        {
          localDrawable1.setAlpha(255 - j);
          localDrawable1.invalidateSelf();
        }
        Drawable localDrawable2 = this.jdField_a_of_type_AndroidWidgetEditText.getBackground();
        if (localDrawable1 != null)
        {
          localDrawable2.setAlpha(j);
          localDrawable2.invalidateSelf();
        }
        localDrawable1 = this.c.getBackground();
        if (localDrawable1 != null)
        {
          localDrawable1.setAlpha(255 - j);
          localDrawable1.invalidateSelf();
        }
        this.jdField_a_of_type_Int = j;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.maproam.widget.RoamLocalSearchBar
 * JD-Core Version:    0.7.0.1
 */