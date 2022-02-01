package com.tencent.mobileqq.app;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import fdd;
import java.lang.reflect.Method;

public class IphoneTitleBarLocalAlbumsActivity
  extends BaseActivity
{
  public static final int a = 1;
  protected static final String a = "IphoneTitleBarLocalAlbumsActivity";
  protected float a;
  protected View.OnClickListener a;
  private View a;
  protected ViewGroup a;
  protected TextView a;
  protected TextView b;
  protected TextView c;
  
  public IphoneTitleBarLocalAlbumsActivity()
  {
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new fdd(this);
  }
  
  public static void a(View paramView)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT <= 10) {
      return;
    }
    try
    {
      paramView.getClass().getMethod("setLayerType", new Class[] { Integer.TYPE, Paint.class }).invoke(paramView, new Object[] { Integer.valueOf(0), null });
      return;
    }
    catch (Exception paramView) {}
  }
  
  protected View a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231455));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    a(this.jdField_a_of_type_AndroidWidgetTextView);
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && ((this.jdField_a_of_type_AndroidWidgetTextView instanceof TextView)))
    {
      String str2 = getString(paramInt);
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      String str1;
      if (str2 != null)
      {
        str1 = str2;
        if (!"".equals(str2)) {}
      }
      else
      {
        str1 = getString(2131561692);
      }
      localTextView.setText(str1);
    }
  }
  
  protected void a(Intent paramIntent)
  {
    ((FrameLayout)findViewById(16908290)).setForeground(getResources().getDrawable(2130840102));
    if (this.jdField_a_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131231447));
      a(this.jdField_a_of_type_AndroidViewViewGroup);
      a();
      b();
      c();
      b(paramIntent);
    }
  }
  
  protected String a_()
  {
    if ((this.b == null) || (this.b.getText() == null) || (this.b.getText().length() == 0)) {
      return getString(2131561692);
    }
    return this.b.getText().toString();
  }
  
  protected View b()
  {
    this.b = ((TextView)findViewById(2131231375));
    return this.b;
  }
  
  public void b(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && ((this.jdField_a_of_type_AndroidWidgetTextView instanceof TextView)) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      String str = paramIntent.getExtras().getString("leftViewText");
      paramIntent = str;
      if (str == null) {
        paramIntent = getString(2131561692);
      }
      localTextView.setText(paramIntent);
    }
  }
  
  public boolean b()
  {
    finish();
    return false;
  }
  
  protected View c()
  {
    this.c = ((TextView)findViewById(2131231379));
    a(this.c);
    return this.c;
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(7);
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    getWindow().setFeatureInt(7, 2130903159);
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    a(getIntent());
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if ((this.b != null) && ((this.b instanceof TextView)))
    {
      this.b.setText(paramCharSequence);
      super.setTitle(paramCharSequence);
    }
    if (paramCharSequence != null) {
      g(paramCharSequence.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.IphoneTitleBarLocalAlbumsActivity
 * JD-Core Version:    0.7.0.1
 */