package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.widget.BounceScrollView;
import cul;
import java.lang.reflect.Method;

public class IphoneTitleBarActivity
  extends BaseActivity
{
  public static final int LAYER_TYPE_SOFTWARE = 1;
  protected static final String b_ = "IphoneTitleBarActivity";
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View jdField_a_of_type_AndroidViewView = null;
  private boolean jdField_a_of_type_Boolean;
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  protected ViewGroup b;
  protected float c;
  protected View.OnClickListener e = new cul(this);
  protected TextView h;
  protected TextView i;
  protected TextView j;
  protected TextView k;
  protected ImageView p;
  
  public static void setLayerType(View paramView)
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
  
  public View a()
  {
    this.j = ((TextView)findViewById(2131296902));
    this.p = ((ImageView)findViewById(2131296903));
    setLayerType(this.j);
    setLayerType(this.p);
    return this.j;
  }
  
  protected void a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_Boolean = true;
    this.j.setVisibility(0);
    this.j.setText(paramInt);
    this.j.setEnabled(false);
    this.k = ((TextView)getLayoutInflater().inflate(2130903133, null));
    setLayerType(this.k);
    this.k.setText(paramInt);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11, 1);
    localLayoutParams.addRule(15, 1);
    localLayoutParams.rightMargin = ((int)(8.0F * this.c));
    this.b.addView(this.k, localLayoutParams);
    this.k.setVisibility(8);
    if (paramOnClickListener != null) {
      this.k.setOnClickListener(paramOnClickListener);
    }
  }
  
  public boolean a()
  {
    finish();
    return false;
  }
  
  public View a_()
  {
    this.i = ((TextView)findViewById(2131296892));
    this.i.setVisibility(4);
    return this.i;
  }
  
  protected void b(Intent paramIntent)
  {
    ((FrameLayout)findViewById(16908290)).setForeground(getResources().getDrawable(2130839317));
    if (this.h == null)
    {
      this.b = ((ViewGroup)findViewById(2131296891));
      setLayerType(this.b);
      c();
      a_();
      a();
      setLeftViewName(paramIntent);
    }
  }
  
  public String b_()
  {
    if ((this.i == null) || (this.i.getText() == null) || (this.i.getText().length() == 0)) {
      return getString(2131363123);
    }
    return this.i.getText().toString();
  }
  
  protected View c()
  {
    this.h = ((TextView)findViewById(2131296898));
    this.h.setContentDescription(getString(2131364539));
    this.h.setOnClickListener(this.e);
    setLayerType(this.h);
    return this.h;
  }
  
  protected void c(boolean paramBoolean)
  {
    if ((this.k == null) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    if (paramBoolean)
    {
      this.j.setVisibility(8);
      this.k.setVisibility(0);
      return;
    }
    this.j.setVisibility(0);
    this.k.setVisibility(8);
  }
  
  public boolean d()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130837928);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = this.h.getCompoundDrawables();
      this.jdField_a_of_type_Int = this.h.getCompoundDrawablePadding();
      this.h.setCompoundDrawablePadding(10);
      this.h.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      bool = true;
    }
    return bool;
  }
  
  public boolean e()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.h.setCompoundDrawablePadding(this.jdField_a_of_type_Int);
      this.h.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      return true;
    }
    return false;
  }
  
  public String getTextTitle()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.i != null)
    {
      localObject1 = localObject2;
      if ((this.i instanceof TextView))
      {
        CharSequence localCharSequence = this.i.getText();
        localObject1 = localObject2;
        if (localCharSequence != null) {
          localObject1 = localCharSequence.toString();
        }
      }
    }
    return localObject1;
  }
  
  public void hideTitleBar()
  {
    try
    {
      this.jdField_a_of_type_AndroidViewView = ((View)findViewById(2131296891).getParent());
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  @TargetApi(11)
  public void removeWebViewLayerType()
  {
    if (Build.VERSION.SDK_INT == 16) {
      this.b.setLayerType(0, null);
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(7);
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    getWindow().setFeatureInt(7, 2130903131);
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    this.c = getResources().getDisplayMetrics().density;
    b(getIntent());
  }
  
  public void setContentView(View paramView)
  {
    this.c = getResources().getDisplayMetrics().density;
    super.setContentView(paramView);
    getWindow().setFeatureInt(7, 2130903131);
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    b(getIntent());
  }
  
  public View setContentViewB(int paramInt)
  {
    BounceScrollView localBounceScrollView = (BounceScrollView)View.inflate(this, 2130903078, null);
    View localView = View.inflate(this, paramInt, null);
    localBounceScrollView.addView(localView);
    setContentView(localBounceScrollView);
    return localView;
  }
  
  public void setContentViewC(int paramInt)
  {
    super.setContentView(paramInt);
  }
  
  public void setContentViewNoBackground(int paramInt)
  {
    setContentView(paramInt);
    getWindow().setBackgroundDrawable(null);
  }
  
  public void setContentViewNoTitle(int paramInt)
  {
    this.c = getResources().getDisplayMetrics().density;
    super.setContentView(paramInt);
    getWindow().setFeatureInt(7, 2130903144);
    try
    {
      this.jdField_a_of_type_AndroidViewView = ((View)findViewById(2131296932).getParent());
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void setLeftButton(int paramInt, View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.h.setOnClickListener(this.e);
      return;
    }
    this.h.setOnClickListener(paramOnClickListener);
  }
  
  public void setLeftViewName(int paramInt)
  {
    if ((this.h != null) && ((this.h instanceof TextView))) {
      this.h.setVisibility(0);
    }
  }
  
  public void setLeftViewName(Intent paramIntent)
  {
    if ((this.h != null) && ((this.h instanceof TextView)) && (paramIntent != null) && (paramIntent.getExtras() != null)) {
      this.h.setVisibility(0);
    }
  }
  
  public void setRightButton(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_Boolean = false;
    this.j.setVisibility(0);
    this.j.setText(paramInt);
    this.j.setEnabled(true);
    if (paramOnClickListener != null) {
      this.j.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if ((this.i != null) && ((this.i instanceof TextView))) {
      this.i.setText(paramCharSequence);
    }
    if ((this.h != null) && ((this.h instanceof TextView)))
    {
      TextView localTextView = this.h;
      localTextView.setText(paramCharSequence);
      localTextView.setContentDescription("向上导航");
      super.setTitle(paramCharSequence);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence, String paramString)
  {
    if ((this.h != null) && ((this.h instanceof TextView)))
    {
      this.h.setText(paramCharSequence);
      super.setTitle(paramCharSequence);
      if ((this.i != null) && ((this.i instanceof TextView))) {
        this.i.setContentDescription("向上导航");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.IphoneTitleBarActivity
 * JD-Core Version:    0.7.0.1
 */