package com.tencent.mobileqq.activity;

import akv;
import akw;
import akx;
import aky;
import akz;
import alc;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.Selection;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import java.io.UnsupportedEncodingException;

public class EditInfoActivity
  extends IphoneTitleBarActivity
{
  public int a;
  protected Drawable a;
  public Handler a;
  public EditText a;
  public TextView a;
  TroopObserver a;
  public ClearableEditText a;
  public QQProgressNotifier a;
  public String a;
  public boolean a;
  public int b;
  protected Drawable b;
  public String b;
  public int c;
  public String c;
  public String d;
  private String e = null;
  
  public EditInfoActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = null;
    this.jdField_a_of_type_AndroidWidgetEditText = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = "0/0";
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new akv(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new alc(this);
  }
  
  private void a(EditText paramEditText)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297066));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
    paramEditText.addTextChangedListener(new akz(this));
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.i == null) {
      this.i = ((TextView)findViewById(2131296895));
    }
    if (paramBoolean)
    {
      c(false);
      if ((this.e != null) && (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null))
      {
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130837910);
        this.i.setCompoundDrawablesWithIntrinsicBounds(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        ((Animatable)this.jdField_b_of_type_AndroidGraphicsDrawableDrawable).start();
      }
    }
    do
    {
      return;
      c(true);
    } while ((this.e == null) || (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null));
    ((Animatable)this.jdField_b_of_type_AndroidGraphicsDrawableDrawable).stop();
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
    this.i.setCompoundDrawables(null, null, null, null);
  }
  
  private void e()
  {
    setContentView(2130903182);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131297065));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setTextClearedListener(new aky(this));
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText(this.jdField_a_of_type_JavaLangString);
      int i = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().length();
      Selection.setSelection(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getEditableText(), i);
    }
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString().getBytes("utf-8");
        this.jdField_b_of_type_JavaLangString = (arrayOfByte.length + "/" + this.jdField_c_of_type_Int);
        a(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        continue;
      }
      this.jdField_b_of_type_JavaLangString = ("0/" + this.jdField_c_of_type_Int);
    }
  }
  
  private void f()
  {
    setContentView(2130903181);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131297065));
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_JavaLangString);
      int i = this.jdField_a_of_type_AndroidWidgetEditText.getText().length();
      Selection.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getEditableText(), i);
    }
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().getBytes("utf-8");
        this.jdField_b_of_type_JavaLangString = (arrayOfByte.length + "/" + this.jdField_c_of_type_Int);
        a(this.jdField_a_of_type_AndroidWidgetEditText);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        continue;
      }
      this.jdField_b_of_type_JavaLangString = ("0/" + this.jdField_c_of_type_Int);
    }
  }
  
  public void a()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      localInputMethodManager.showSoftInput(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText, 2);
      return;
    }
    localInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 2);
  }
  
  protected boolean a()
  {
    b();
    return super.a();
  }
  
  public void b()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getWindowToken(), 0);
      return;
    }
    localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
  }
  
  void c()
  {
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      setTitle(this.e);
      a(2131363430, new akx(this));
      c(true);
      return;
      e();
      continue;
      f();
    }
  }
  
  void d()
  {
    Intent localIntent = getIntent();
    this.jdField_a_of_type_Int = localIntent.getIntExtra("type", -1);
    this.jdField_b_of_type_Int = localIntent.getIntExtra("subtype", -1);
    this.e = localIntent.getStringExtra("title");
    this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("default");
    this.jdField_c_of_type_Int = localIntent.getIntExtra("num", 0);
    this.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("isTroopNick", false);
    this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("troopUin");
    this.d = localIntent.getStringExtra("uin");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    d();
    c();
    d(2130837633);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new akw(this), 500L);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
  }
  
  protected void onPause()
  {
    b();
    super.onPause();
  }
  
  protected void onResume()
  {
    a();
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity
 * JD-Core Version:    0.7.0.1
 */