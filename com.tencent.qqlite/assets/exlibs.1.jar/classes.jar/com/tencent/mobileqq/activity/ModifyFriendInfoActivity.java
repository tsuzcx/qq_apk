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
import avk;
import avl;
import avp;
import avq;
import avr;
import avs;
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
  private float jdField_a_of_type_Float;
  public int a;
  public Handler a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new avk(this);
  private View jdField_a_of_type_AndroidViewView;
  public TextView a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new avs(this);
  public String a;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new avr(this);
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
    this.jdField_a_of_type_AndroidOsHandler = new avq(this);
  }
  
  private void d()
  {
    new avp(this).start();
  }
  
  private void e()
  {
    this.jdField_c_of_type_AndroidWidgetTextView = this.i;
    this.j.setText(2131363430);
    this.j.setVisibility(0);
    this.j.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297309));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296848));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131297307);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131297310);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131297313);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
  }
  
  protected View a()
  {
    super.a();
    this.j.setVisibility(0);
    this.j.setText(2131362932);
    this.j.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    this.j.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    return this.j;
  }
  
  public void c()
  {
    new avl(this).start();
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
          Toast.makeText(this.app.a(), getString(2131363448), 1).show();
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
    d(2130837633);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("uin");
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("uinname");
    if ((this.jdField_b_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString.trim().length() == 0)) {}
    for (paramBundle = this.jdField_a_of_type_JavaLangString;; paramBundle = this.jdField_b_of_type_JavaLangString)
    {
      this.jdField_b_of_type_JavaLangString = paramBundle;
      setTitle(2131363623);
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