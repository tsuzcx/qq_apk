package com.tencent.mobileqq.maproam.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import gca;
import gcb;
import gcc;

public class RoamLocalSearchBar
  extends LinearLayout
  implements View.OnClickListener
{
  long a;
  public Context a;
  public View a;
  public Button a;
  public EditText a;
  public TextView a;
  public BaseActivity a;
  public QQAppInterface a;
  public RoamSearchDialog.OnRoamResultObserver a;
  public RoamSearchDialog.OnSearchResultItemClick a;
  public RoamSearchDialog a;
  public String a;
  long b = 1000L;
  public View b;
  public View c;
  
  public RoamLocalSearchBar(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public RoamLocalSearchBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext);
    this.c = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2130903944, null);
    addView(this.c);
    this.c.findViewById(2131233086).setVisibility(8);
    IphoneTitleBarActivity.b(this.c);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.c.findViewById(2131233086));
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.c.findViewById(2131233087));
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.c.findViewById(2131234398));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131563055);
  }
  
  public void a(QQAppInterface paramQQAppInterface, RoamSearchDialog.OnRoamResultObserver paramOnRoamResultObserver, RoamSearchDialog.OnSearchResultItemClick paramOnSearchResultItemClick)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnRoamResultObserver = paramOnRoamResultObserver;
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnSearchResultItemClick = paramOnSearchResultItemClick;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog != null) {
      return;
    }
    View localView1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131231448);
    View localView2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131231839);
    int i = localView1.getHeight();
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog = new RoamSearchDialog(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.a(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.a(this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnRoamResultObserver);
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.a(this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnSearchResultItemClick);
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.setCanceledOnTouchOutside(true);
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i);
    localTranslateAnimation1.setDuration(200L);
    localTranslateAnimation1.setFillAfter(true);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
    localTranslateAnimation2.setDuration(200L);
    localTranslateAnimation1.setAnimationListener(new gca(this, localView2, localView1));
    localTranslateAnimation2.setAnimationListener(new gcb(this, localView2, i));
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.setOnDismissListener(new gcc(this, localView2, i, localView1, localTranslateAnimation2));
    localView2.startAnimation(localTranslateAnimation1);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.maproam.widget.RoamLocalSearchBar
 * JD-Core Version:    0.7.0.1
 */