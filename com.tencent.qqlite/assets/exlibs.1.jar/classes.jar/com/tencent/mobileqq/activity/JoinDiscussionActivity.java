package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aro;
import arp;
import arr;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.List;

public class JoinDiscussionActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  static final int jdField_a_of_type_Int = -161;
  private static final int d = -160;
  public long a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  public ImageView a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  private arp jdField_a_of_type_Arp;
  private arr jdField_a_of_type_Arr;
  public DiscussionHandler a;
  public String a;
  public ArrayList a;
  public List a;
  int jdField_b_of_type_Int = 0;
  public long b;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  public TextView b;
  String jdField_b_of_type_JavaLangString;
  public int c;
  public String c;
  public String d;
  public String e = "";
  public String f = "";
  
  public JoinDiscussionActivity()
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131297225));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297226));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297227));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297228));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131297229));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131297231));
  }
  
  private void d()
  {
    setTitle("加入讨论组");
    setRightButton(2131362801, this);
    this.h.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new aro(this));
  }
  
  private void e()
  {
    if (NetworkUtil.e(this))
    {
      d();
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.c(this.jdField_a_of_type_JavaLangString);
      }
      while ((this.jdField_b_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString.length() <= 0)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.b(this.jdField_b_of_type_JavaLangString);
      return;
    }
    a(0, -160);
  }
  
  public void a()
  {
    if (NetworkUtil.e(this))
    {
      d();
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int);
      return;
    }
    a(1, -160);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    e();
    String str = "";
    switch (paramInt2)
    {
    default: 
      if (paramInt1 == 1) {
        str = "加入讨论组失败，请稍后重试";
      }
      break;
    }
    for (;;)
    {
      QQToast.a(this, str, 0).b(getTitleBarHeight());
      return;
      str = "讨论组不存在";
      continue;
      str = "讨论组人数已达上限";
      continue;
      str = "非法讨论组链接";
      continue;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
      str = "网络错误，请稍后重试";
      continue;
      if (paramInt1 == 0) {
        str = "获取讨论组信息失败，请稍后重试";
      }
    }
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 2130968584);
  }
  
  public void onClick(View paramView)
  {
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903215);
    paramBundle = getIntent().getExtras();
    this.jdField_a_of_type_Arr = new arr(this, null);
    this.jdField_a_of_type_Arp = new arp(this, null);
    addObserver(this.jdField_a_of_type_Arr);
    addObserver(this.jdField_a_of_type_Arp);
    this.jdField_b_of_type_Int = paramBundle.getInt(ScannerActivity.o);
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("sig");
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("innerSig");
    if (this.jdField_b_of_type_JavaLangString != null)
    {
      paramBundle = this.jdField_b_of_type_JavaLangString.toUpperCase();
      if ((this.jdField_b_of_type_JavaLangString != null) && (!paramBundle.startsWith("HTTP://")) && (!paramBundle.startsWith("HTTPS://"))) {
        this.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      }
    }
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.endsWith("#flyticket"))) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.substring(0, this.jdField_a_of_type_JavaLangString.length() - "#flyticket".length());
    }
    c();
    d();
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler = ((DiscussionHandler)this.app.a(6));
    e();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    removeObserver(this.jdField_a_of_type_Arr);
    removeObserver(this.jdField_a_of_type_Arp);
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  protected void onStart()
  {
    super.onStart();
  }
  
  protected void onStop()
  {
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JoinDiscussionActivity
 * JD-Core Version:    0.7.0.1
 */