package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;

public class QQBrowserActivity$TopBarBtnClickListener
  implements View.OnClickListener
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  QQBrowserActivity jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity = null;
  String jdField_a_of_type_JavaLangString;
  int d = 0;
  
  public QQBrowserActivity$TopBarBtnClickListener(QQBrowserActivity paramQQBrowserActivity, int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity = paramQQBrowserActivity;
    this.d = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity == null) {
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      if (this.d == 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.d();
      }
    }
    for (;;)
    {
      if ((this.d == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a.getUrl().contains("http://admin.qun.qq.com/mcreatev3/address.html"))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.onClick(paramView);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a(this.d);
      return;
      if (this.d == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.n();
      }
      else if (this.d == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.o();
        continue;
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a(this.jdField_a_of_type_JavaLangString, new String[] { "" });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBrowserActivity.TopBarBtnClickListener
 * JD-Core Version:    0.7.0.1
 */