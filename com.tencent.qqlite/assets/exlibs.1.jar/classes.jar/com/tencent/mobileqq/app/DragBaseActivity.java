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
import csk;
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
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new csk(this);
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296897));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetTextView);
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
      super.setContentView(2130903293);
      this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
      FrameLayout localFrameLayout = (FrameLayout)findViewById(2131297555);
      localFrameLayout.setForeground(getResources().getDrawable(2130839259));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = localFrameLayout;
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131296890));
      IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidViewViewGroup);
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
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
      super.setTitle(paramString);
    }
  }
  
  public boolean a()
  {
    finish();
    return false;
  }
  
  protected View b()
  {
    this.b = ((TextView)findViewById(2131296891));
    return this.b;
  }
  
  public void b(int paramInt)
  {
    setContentView(paramInt);
    try
    {
      findViewById(2131297141).setVisibility(8);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void b(Intent paramIntent) {}
  
  protected String b_()
  {
    if ((this.b == null) || (this.b.getText() == null) || (this.b.getText().length() == 0)) {
      return getString(2131363113);
    }
    return this.b.getText().toString();
  }
  
  protected View c()
  {
    this.c = ((TextView)findViewById(2131296901));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296902));
    IphoneTitleBarActivity.setLayerType(this.c);
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetImageView);
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
  
  public void c(int paramInt) {}
  
  protected boolean c()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130837910);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidWidgetTextView.getCompoundDrawables();
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidWidgetTextView.getCompoundDrawablePadding();
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      bool = true;
    }
    return bool;
  }
  
  protected boolean d()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
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
    super.setContentView(2130903293);
    a(getIntent());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams) {}
  
  public void setTitle(int paramInt)
  {
    setTitle(getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if ((this.b != null) && ((this.b instanceof TextView)))
    {
      this.b.setText(paramCharSequence);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
      super.setTitle(paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.DragBaseActivity
 * JD-Core Version:    0.7.0.1
 */