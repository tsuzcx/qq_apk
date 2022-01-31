package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.international.LocaleString;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import cwa;
import cwb;
import cwf;
import cwg;
import cwh;
import cwi;

public class ModifyFriendInfoActivity
  extends IphoneTitleBarActivity
{
  static final int jdField_b_of_type_Int = 1;
  static final int jdField_c_of_type_Int = 2;
  private static final int d = 1000;
  private float jdField_a_of_type_Float;
  public int a;
  public Handler a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new cwa(this);
  private View jdField_a_of_type_AndroidViewView;
  public TextView a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new cwi(this);
  public String a;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new cwh(this);
  private View jdField_b_of_type_AndroidViewView;
  public TextView b;
  public String b;
  private View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public String c;
  public String d = "";
  
  public ModifyFriendInfoActivity()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new cwg(this);
  }
  
  private void d()
  {
    new cwf(this).start();
  }
  
  private void e()
  {
    this.jdField_c_of_type_AndroidWidgetTextView = this.l;
    this.m.setText(2131561977);
    this.m.setVisibility(0);
    this.m.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231930));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231389));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131231928);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131231931);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131231934);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
  }
  
  protected View a()
  {
    super.a();
    this.m.setVisibility(0);
    this.m.setText(2131561819);
    this.m.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    this.m.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    return this.m;
  }
  
  public void c()
  {
    new cwb(this).start();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
        if ((paramInt2 == -1) && (paramInt1 == 1000))
        {
          if (NetworkUtil.e(this))
          {
            paramIntent = paramIntent.getStringExtra("result");
            if ((paramIntent == null) || (paramIntent.length() == 0))
            {
              localQQAppInterface1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
              localQQAppInterface2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
              ((FriendListHandler)localQQAppInterface1.a(1)).a(this.jdField_a_of_type_JavaLangString);
            }
            this.jdField_b_of_type_AndroidWidgetTextView.setText(paramIntent);
            QQAppInterface localQQAppInterface1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
            QQAppInterface localQQAppInterface2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
            ((FriendListHandler)localQQAppInterface1.a(1)).b(this.jdField_a_of_type_JavaLangString, paramIntent);
            return;
          }
          Toast.makeText(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), getString(2131562445), 1).show();
          return;
        }
      } while (paramInt1 != 0);
      paramInt1 = paramIntent.getByteExtra("result", (byte)0);
      paramIntent = ((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(String.valueOf(paramInt1));
    } while (paramIntent == null);
    LocaleString.a(paramIntent.group_name, this.jdField_a_of_type_AndroidWidgetTextView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903282);
    j(2130837729);
    a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("uin");
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("uinname");
    if ((this.jdField_b_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString.trim().length() == 0)) {}
    for (paramBundle = this.jdField_a_of_type_JavaLangString;; paramBundle = this.jdField_b_of_type_JavaLangString)
    {
      this.jdField_b_of_type_JavaLangString = paramBundle;
      setTitle(2131562139);
      this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
      d();
      c();
      e();
      return;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ModifyFriendInfoActivity
 * JD-Core Version:    0.7.0.1
 */