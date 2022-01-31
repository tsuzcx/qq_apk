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
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import eai;
import eaj;
import eak;
import eal;
import eam;
import mqq.manager.VerifyCodeManager;
import mqq.observer.ServerNotifyObserver;

public class VerifyCodeActivity2
  extends IphoneTitleBarActivity
{
  final int jdField_a_of_type_Int = 4;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new eam(this);
  private View jdField_a_of_type_AndroidViewView;
  public EditText a;
  public ImageView a;
  public TextView a;
  OpenSDKAppInterface jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface;
  VerifyCodeManager jdField_a_of_type_MqqManagerVerifyCodeManager;
  public ServerNotifyObserver a;
  public boolean a;
  private TextView b;
  
  public VerifyCodeActivity2()
  {
    this.jdField_a_of_type_MqqObserverServerNotifyObserver = new eai(this);
  }
  
  private void a(Intent paramIntent)
  {
    g();
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("image");
    int i = paramIntent.getIntExtra("seq", 0);
    String str = paramIntent.getStringExtra("key");
    paramIntent = paramIntent.getStringExtra("note");
    if (!TextUtils.isEmpty(paramIntent)) {
      this.b.setText(paramIntent);
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
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131234649));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new eal(this));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131234647);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131234648));
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)getAppRuntime());
    this.jdField_a_of_type_MqqManagerVerifyCodeManager = ((VerifyCodeManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(6));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private void g()
  {
    setTitle(2131563158);
    a(2131561746, new eaj(this));
    b(2131561977, new eak(this));
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
    this.jdField_a_of_type_Boolean = false;
    a(true);
    this.jdField_a_of_type_MqqManagerVerifyCodeManager.refreVerifyCode(this.jdField_a_of_type_MqqObserverServerNotifyObserver);
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
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (BaseActivity.a(getIntent())) {
      finish();
    }
    do
    {
      return;
      setContentView(2130904044);
      j(2130837729);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131234646));
      this.b = ((TextView)findViewById(2131234650));
      a(getIntent());
      paramBundle = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(LoginActivity.class);
      if (paramBundle != null) {
        paramBundle.sendEmptyMessage(14825);
      }
      paramBundle = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(SubLoginActivity.class);
    } while (paramBundle == null);
    paramBundle.sendEmptyMessage(14825);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      e();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VerifyCodeActivity2
 * JD-Core Version:    0.7.0.1
 */