package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import cxf;
import cxg;
import cxi;
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
  public DiscussionHandler a;
  private cxg jdField_a_of_type_Cxg;
  private cxi jdField_a_of_type_Cxi;
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
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131231829));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131231830));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231831));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231832));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131231833));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131231835));
  }
  
  private void e()
  {
    setTitle(getString(2131559077));
    c(2131561746, this);
    this.k.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new cxf(this));
  }
  
  private void f()
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
        str = getString(2131559082);
      }
      break;
    }
    for (;;)
    {
      QQToast.a(this, str, 0).b(d());
      return;
      str = getResources().getString(2131559078);
      continue;
      str = getResources().getString(2131559079);
      continue;
      str = getResources().getString(2131559080);
      continue;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
      str = getString(2131559081);
      continue;
      if (paramInt1 == 0) {
        str = getString(2131559083);
      }
    }
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 2130968590);
  }
  
  public void onClick(View paramView)
  {
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903252);
    paramBundle = getIntent().getExtras();
    this.jdField_a_of_type_Cxi = new cxi(this, null);
    this.jdField_a_of_type_Cxg = new cxg(this, null);
    a(this.jdField_a_of_type_Cxi);
    a(this.jdField_a_of_type_Cxg);
    this.jdField_b_of_type_Int = paramBundle.getInt(ScannerActivity.t);
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
    d();
    e();
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler = ((DiscussionHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(6));
    f();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    b(this.jdField_a_of_type_Cxi);
    b(this.jdField_a_of_type_Cxg);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JoinDiscussionActivity
 * JD-Core Version:    0.7.0.1
 */