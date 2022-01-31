package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import dum;
import dun;
import duo;
import dup;
import duq;
import mqq.app.AppRuntime;
import mqq.manager.VerifyCodeManager;
import mqq.observer.ServerNotifyObserver;

public class VerifyCodeActivity
  extends IphoneTitleBarActivity
{
  final int jdField_a_of_type_Int = 4;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new duq(this);
  private View jdField_a_of_type_AndroidViewView;
  public EditText a;
  public ImageView a;
  public TextView a;
  VerifyCodeManager jdField_a_of_type_MqqManagerVerifyCodeManager;
  public ServerNotifyObserver a;
  public boolean a;
  private TextView b;
  public boolean b;
  
  public VerifyCodeActivity()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_MqqObserverServerNotifyObserver = new dum(this);
  }
  
  private void a(Intent paramIntent)
  {
    g();
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("image");
    int i = paramIntent.getIntExtra("seq", 0);
    String str = paramIntent.getStringExtra("key");
    paramIntent = paramIntent.getStringExtra("note");
    if (!TextUtils.isEmpty(paramIntent)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramIntent);
    }
    paramIntent = str;
    if (str == null) {
      paramIntent = "";
    }
    if (arrayOfByte != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length));
    }
    this.jdField_a_of_type_MqqObserverServerNotifyObserver.setSeq(i);
    this.jdField_a_of_type_MqqObserverServerNotifyObserver.setKey(paramIntent);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131234651));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new dup(this));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131234649);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131234650));
    this.jdField_a_of_type_MqqManagerVerifyCodeManager = ((VerifyCodeManager)getAppRuntime().getManager(6));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private void g()
  {
    setTitle(2131563158);
    a(2131561746, new dun(this));
    b(2131561977, new duo(this));
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    a(true);
    this.jdField_a_of_type_MqqManagerVerifyCodeManager.submitVerifyCode(this.jdField_a_of_type_MqqObserverServerNotifyObserver, paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void d()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = false;
    a(true);
    this.jdField_a_of_type_MqqManagerVerifyCodeManager.refreVerifyCode(this.jdField_a_of_type_MqqObserverServerNotifyObserver);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (BaseActivity.a(getIntent())) {
      finish();
    }
    do
    {
      return true;
      setContentView(2130904046);
      j(2130837729);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131234648));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131234652));
      a(getIntent());
      paramBundle = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(LoginActivity.class);
      if (paramBundle != null) {
        paramBundle.sendEmptyMessage(14825);
      }
      paramBundle = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(SubLoginActivity.class);
    } while (paramBundle == null);
    paramBundle.sendEmptyMessage(14825);
    return true;
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      e();
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_MqqManagerVerifyCodeManager != null) {
      this.jdField_a_of_type_MqqManagerVerifyCodeManager.cancelVerifyCode(this.jdField_a_of_type_MqqObserverServerNotifyObserver);
    }
    f();
  }
  
  public void f()
  {
    this.jdField_a_of_type_MqqObserverServerNotifyObserver = null;
    this.jdField_a_of_type_MqqManagerVerifyCodeManager = null;
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VerifyCodeActivity
 * JD-Core Version:    0.7.0.1
 */