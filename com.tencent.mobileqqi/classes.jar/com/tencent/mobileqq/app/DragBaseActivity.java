package com.tencent.mobileqq.app;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import fbv;
import java.lang.reflect.Method;

public class DragBaseActivity
  extends BaseActivity
{
  protected float a;
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  protected View.OnClickListener a;
  protected ViewGroup a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  protected ImageView a;
  protected TextView a;
  private boolean jdField_a_of_type_Boolean;
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  protected TextView b;
  protected TextView c;
  protected TextView d;
  
  public DragBaseActivity()
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new fbv(this);
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231456));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    IphoneTitleBarActivity.b(this.jdField_a_of_type_AndroidWidgetTextView);
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public void a(int paramInt)
  {
    setContentView(paramInt);
    getWindow().setBackgroundDrawable(null);
  }
  
  public void a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_Boolean = false;
    this.c.setVisibility(0);
    this.c.setText(paramInt);
    this.c.setEnabled(true);
    if (paramOnClickListener != null) {
      this.c.setOnClickListener(paramOnClickListener);
    }
  }
  
  protected void a(Intent paramIntent)
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null)
    {
      super.setContentView(2130903360);
      this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
      FrameLayout localFrameLayout = (FrameLayout)findViewById(2131232290);
      localFrameLayout.setForeground(getResources().getDrawable(2130840102));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = localFrameLayout;
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131231448));
      IphoneTitleBarActivity.b(this.jdField_a_of_type_AndroidViewViewGroup);
      a();
      b();
      c();
      b(paramIntent);
    }
  }
  
  public void a(CharSequence paramCharSequence, String paramString)
  {
    if ((this.b != null) && ((this.b instanceof TextView)))
    {
      this.b.setText(paramCharSequence);
      super.setTitle(paramString);
    }
    if (paramCharSequence != null) {
      g(paramCharSequence.toString());
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
    this.b = ((TextView)findViewById(2131231376));
    return this.b;
  }
  
  public void b(int paramInt)
  {
    setContentView(paramInt);
    try
    {
      findViewById(2131231374).setVisibility(8);
      return;
    }
    catch (Throwable localThrowable) {}
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
    this.c = ((TextView)findViewById(2131231380));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131231461));
    IphoneTitleBarActivity.b(this.c);
    IphoneTitleBarActivity.b(this.jdField_a_of_type_AndroidWidgetImageView);
    return this.c;
  }
  
  public String c()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.b != null)
    {
      localObject1 = localObject2;
      if ((this.b instanceof TextView))
      {
        CharSequence localCharSequence = this.b.getText();
        localObject1 = localObject2;
        if (localCharSequence != null) {
          localObject1 = localCharSequence.toString();
        }
      }
    }
    return localObject1;
  }
  
  public void c(int paramInt)
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
  
  protected boolean c()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130837862);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = this.b.getCompoundDrawables();
      this.jdField_a_of_type_Int = this.b.getCompoundDrawablePadding();
      this.b.setCompoundDrawablePadding(10);
      this.b.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      return true;
    }
    return false;
  }
  
  protected boolean d()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.b.setCompoundDrawablePadding(this.jdField_a_of_type_Int);
      this.b.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      return true;
    }
    return false;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    return super.doOnCreate(paramBundle);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    getWindow().requestFeature(1);
    super.onCreate(paramBundle);
  }
  
  public void setContentView(int paramInt)
  {
    setContentView(getLayoutInflater().inflate(paramInt, null));
  }
  
  public void setContentView(View paramView)
  {
    super.setContentView(2130903360);
    a(getIntent());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams) {}
  
  public void setTitle(int paramInt)
  {
    String str = getString(paramInt);
    setTitle(str);
    g(str);
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
 * Qualified Name:     com.tencent.mobileqq.app.DragBaseActivity
 * JD-Core Version:    0.7.0.1
 */