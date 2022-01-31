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
import avo;
import avp;
import avt;
import avu;
import avv;
import avw;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.utils.NetworkUtil;

public class ModifyFriendInfoActivity
  extends IphoneTitleBarActivity
{
  static final int jdField_b_of_type_Int = 1;
  static final int jdField_c_of_type_Int = 2;
  private static final int d = 1000;
  public int a;
  public Handler a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new avo(this);
  private View jdField_a_of_type_AndroidViewView;
  public TextView a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new avw(this);
  public String a;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new avv(this);
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
    this.jdField_a_of_type_AndroidOsHandler = new avu(this);
  }
  
  private void d()
  {
    new avt(this).start();
  }
  
  private void e()
  {
    this.jdField_c_of_type_AndroidWidgetTextView = this.i;
    this.j.setText(2131363444);
    this.j.setVisibility(0);
    this.j.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297305));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296845));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131297303);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131297306);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131297309);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
  }
  
  protected View a()
  {
    super.a();
    this.j.setVisibility(0);
    this.j.setText(2131362943);
    this.j.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    this.j.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    return this.j;
  }
  
  public void c()
  {
    new avp(this).start();
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
              localQQAppInterface1 = this.app;
              localQQAppInterface2 = this.app;
              ((FriendListHandler)localQQAppInterface1.a(1)).a(this.jdField_a_of_type_JavaLangString);
            }
            this.jdField_b_of_type_AndroidWidgetTextView.setText(paramIntent);
            QQAppInterface localQQAppInterface1 = this.app;
            QQAppInterface localQQAppInterface2 = this.app;
            ((FriendListHandler)localQQAppInterface1.a(1)).a(this.jdField_a_of_type_JavaLangString, paramIntent, false);
            return;
          }
          Toast.makeText(this.app.a(), getString(2131363460), 1).show();
          return;
        }
      } while (paramInt1 != 0);
      paramInt1 = paramIntent.getByteExtra("result", (byte)0);
      paramIntent = ((FriendManager)this.app.getManager(8)).a(String.valueOf(paramInt1));
    } while (paramIntent == null);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramIntent.group_name);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903238);
    d(2130837660);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("uin");
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("uinname");
    if ((this.jdField_b_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString.trim().length() == 0)) {}
    for (paramBundle = this.jdField_a_of_type_JavaLangString;; paramBundle = this.jdField_b_of_type_JavaLangString)
    {
      this.jdField_b_of_type_JavaLangString = paramBundle;
      setTitle(2131363628);
      this.jdField_c_of_type_Float = getResources().getDisplayMetrics().density;
      d();
      c();
      e();
      return;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ModifyFriendInfoActivity
 * JD-Core Version:    0.7.0.1
 */