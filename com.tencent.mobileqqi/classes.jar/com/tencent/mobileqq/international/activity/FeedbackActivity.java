package com.tencent.mobileqq.international.activity;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import gdr;
import gds;
import gdt;
import gdu;
import gdv;
import gdw;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;
import mqq.manager.AccountManager;

public class FeedbackActivity
  extends IphoneTitleBarActivity
{
  private static final String jdField_a_of_type_JavaLangString = "FeedBackActivity";
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  protected ProgressBar a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new gdu(this);
  private Runnable b;
  
  public FeedbackActivity()
  {
    this.jdField_b_of_type_JavaLangRunnable = new gdv(this);
  }
  
  private static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = new Uri.Builder().scheme("http").authority("ptlogin2.imqq.com").path("qqifeedback").appendQueryParameter("clientuin", paramString1).appendQueryParameter("clientkey", paramString2).appendQueryParameter("keyindex", "19").appendQueryParameter("qq", paramString1).appendQueryParameter("ckey", paramString2).appendQueryParameter("text", paramString4).build();
    if (paramString1 == null) {
      return null;
    }
    return paramString1.toString();
  }
  
  private void a(String paramString)
  {
    paramString.replace(" ", "%20");
    ((AccountManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(0)).updateSTwxWeb(new gdw(this, paramString));
  }
  
  private String b(String paramString)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramString.length());
    GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
    localGZIPOutputStream.write(paramString.getBytes());
    localGZIPOutputStream.close();
    paramString = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.close();
    return new String(paramString);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131231065));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new gdr(this));
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
  }
  
  private void g()
  {
    setTitle(2131559863);
    TextView localTextView = this.k;
    localTextView.setVisibility(0);
    localTextView.setOnClickListener(new gds(this));
    this.jdField_a_of_type_AndroidWidgetTextView = this.m;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131563018));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131562654);
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new gdt(this));
  }
  
  private void h()
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
  }
  
  public int a()
  {
    String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.d();
    if (str == null) {
      return -1;
    }
    int j = 5381;
    int i = 0;
    int k = str.length();
    while (i < k)
    {
      j += (j << 5) + Character.codePointAt(str, i);
      i += 1;
    }
    return 0x7FFFFFFF & j;
  }
  
  protected View a()
  {
    return super.a();
  }
  
  public String a(String paramString)
  {
    while (paramString.length() < 10) {
      paramString = "0" + paramString;
    }
    return "o" + paramString;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903080);
    g();
    d();
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131231066));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.international.activity.FeedbackActivity
 * JD-Core Version:    0.7.0.1
 */