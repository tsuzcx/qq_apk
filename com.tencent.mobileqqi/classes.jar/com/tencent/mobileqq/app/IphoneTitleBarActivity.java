package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.international.LocaleUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FakeImageView;
import com.tencent.mobileqq.widget.FakeTextView;
import com.tencent.qphone.base.util.QLog;
import fhr;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class IphoneTitleBarActivity
  extends BaseActivity
{
  public static final int aH = 1;
  protected static final String a_ = "IphoneTitleBarActivity";
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View jdField_a_of_type_AndroidViewView = null;
  private boolean jdField_a_of_type_Boolean;
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  protected ViewGroup b;
  protected float c;
  protected View.OnClickListener f = new fhr(this);
  public TextView k;
  protected TextView l;
  public TextView m;
  protected TextView n;
  protected ImageView p;
  
  public static void b(View paramView)
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
    this.m = new FakeTextView(this);
    this.p = new FakeImageView(this);
    this.m.setId(2131231380);
    this.p.setId(2131231461);
    b(this.m);
    b(this.p);
    return this.m;
  }
  
  public String a(String paramString, TextView paramTextView)
  {
    if (!Build.DEVICE.contains("hwH30")) {}
    float f2;
    float f1;
    do
    {
      return paramString;
      localObject = new TextPaint(1);
      ((TextPaint)localObject).setTextSize(paramTextView.getTextSize());
      f2 = ((TextPaint)localObject).measureText(paramString);
      float f3 = paramTextView.getPaddingLeft();
      float f4 = paramTextView.getPaddingRight();
      if ((LocaleUtil.a(getApplicationContext()) != 6) && (LocaleUtil.a(getApplicationContext()) != 7))
      {
        f1 = f2;
        if (LocaleUtil.a(getApplicationContext()) != 8) {}
      }
      else
      {
        f1 = f2 + 240.0F;
      }
      f2 = paramTextView.getResources().getDisplayMetrics().widthPixels - (0.0F + 0.0F) - (f3 + f4);
    } while (f1 <= f2);
    f1 /= paramString.length();
    paramTextView = new BigDecimal((f2 - ((TextPaint)localObject).measureText("...")) / f1).setScale(0, 4);
    Object localObject = new StringBuilder();
    if (paramTextView.intValue() > 30) {}
    for (int i = 30;; i = paramTextView.intValue()) {
      return paramString.substring(0, i) + "...";
    }
  }
  
  public void a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.k.setVisibility(8);
    this.k = new FakeTextView(this);
    this.k.setId(2131231457);
    b(this.k);
    this.k.setVisibility(0);
    this.k.setText(paramInt);
    if (paramOnClickListener == null)
    {
      this.k.setOnClickListener(this.f);
      return;
    }
    this.k.setOnClickListener(paramOnClickListener);
  }
  
  public void a(CharSequence paramCharSequence, String paramString)
  {
    if ((this.l != null) && ((this.l instanceof TextView)))
    {
      this.l.setText(paramCharSequence);
      super.setTitle(paramString);
    }
    if (paramCharSequence != null) {
      g(paramCharSequence.toString());
    }
  }
  
  public View a_()
  {
    this.l = new FakeTextView(this);
    this.l.setId(2131231376);
    return this.l;
  }
  
  public String a_()
  {
    if ((this.l == null) || (this.l.getText() == null) || (this.l.getText().length() == 0)) {
      return getString(2131561692);
    }
    return this.l.getText().toString();
  }
  
  protected void b(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_Boolean = true;
    this.m.setVisibility(0);
    this.m.setText(paramInt);
    this.m.setEnabled(false);
    this.n = new FakeTextView(this);
    this.n.setId(2131231464);
    b(this.n);
    this.n.setText(paramInt);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11, 1);
    localLayoutParams.addRule(15, 1);
    localLayoutParams.rightMargin = ((int)(8.0F * this.c));
    this.b.addView(this.n, localLayoutParams);
    this.n.setVisibility(8);
    if (paramOnClickListener != null) {
      this.n.setOnClickListener(paramOnClickListener);
    }
  }
  
  protected void b(Intent paramIntent)
  {
    ((FrameLayout)findViewById(16908290)).setForeground(getResources().getDrawable(2130840100));
    if (this.k == null)
    {
      this.b = new RelativeLayout(this);
      this.b.setId(2131231448);
      b(this.b);
      d();
      a_();
      a();
      c(paramIntent);
    }
  }
  
  public boolean b()
  {
    finish();
    return false;
  }
  
  public View c(int paramInt)
  {
    BounceScrollView localBounceScrollView = (BounceScrollView)View.inflate(this, 2130903099, null);
    View localView = View.inflate(this, paramInt, null);
    localBounceScrollView.addView(localView);
    setContentView(localBounceScrollView);
    return localView;
  }
  
  public void c(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_Boolean = false;
    this.m.setVisibility(0);
    this.m.setText(paramInt);
    this.m.setEnabled(true);
    if (paramOnClickListener != null) {
      this.m.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void c(Intent paramIntent)
  {
    if ((this.k != null) && ((this.k instanceof TextView)) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      TextView localTextView = this.k;
      String str = paramIntent.getExtras().getString("leftViewText");
      paramIntent = str;
      if (str == null) {
        paramIntent = getString(2131561692);
      }
      localTextView.setText(paramIntent);
    }
  }
  
  protected View d()
  {
    this.k = new FakeTextView(this);
    this.k.setId(2131231456);
    this.k.setOnClickListener(this.f);
    b(this.k);
    return this.k;
  }
  
  protected void d(boolean paramBoolean)
  {
    if ((this.n == null) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    if (paramBoolean)
    {
      this.m.setVisibility(8);
      this.n.setVisibility(0);
      return;
    }
    this.m.setVisibility(0);
    this.n.setVisibility(8);
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130837860);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = this.l.getCompoundDrawables();
      this.jdField_a_of_type_Int = this.l.getCompoundDrawablePadding();
      this.l.setCompoundDrawablePadding(10);
      this.l.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      return true;
    }
    return false;
  }
  
  public void e(int paramInt)
  {
    setContentView(paramInt);
    getWindow().setBackgroundDrawable(null);
  }
  
  public boolean e()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.l.setCompoundDrawablePadding(this.jdField_a_of_type_Int);
      this.l.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      return true;
    }
    return false;
  }
  
  public void f(int paramInt)
  {
    this.c = getResources().getDisplayMetrics().density;
    super.setContentView(paramInt);
    b(getIntent());
  }
  
  public View findViewById(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.findViewById(paramInt);
    case 2131231456: 
      if (this.k == null)
      {
        this.k = new FakeTextView(this);
        this.k.setId(2131231456);
      }
      return this.k;
    case 2131231457: 
      if (this.k == null)
      {
        this.k = new FakeTextView(this);
        this.k.setId(2131231457);
      }
      return this.k;
    case 2131231376: 
      if (this.l == null)
      {
        this.l = new FakeTextView(this);
        this.l.setId(2131231376);
      }
      return this.l;
    case 2131231380: 
      if (this.m == null)
      {
        this.m = new FakeTextView(this);
        this.m.setId(2131231380);
      }
      return this.m;
    case 2131231461: 
      if (this.p == null)
      {
        this.p = new FakeImageView(this);
        this.p.setId(2131231461);
      }
      return this.p;
    }
    if (this.b == null)
    {
      this.b = new RelativeLayout(this);
      this.b.setId(2131231448);
    }
    return this.b;
  }
  
  public String g()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.l != null)
    {
      localObject1 = localObject2;
      if ((this.l instanceof TextView))
      {
        CharSequence localCharSequence = this.l.getText();
        localObject1 = localObject2;
        if (localCharSequence != null) {
          localObject1 = localCharSequence.toString();
        }
      }
    }
    return localObject1;
  }
  
  public void g(int paramInt)
  {
    super.setContentView(paramInt);
  }
  
  public void h(int paramInt)
  {
    if ((this.k != null) && ((this.k instanceof TextView)))
    {
      String str2 = getString(paramInt);
      TextView localTextView = this.k;
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
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (QLog.isColorLevel()) {
      QLog.i("IphoneTitleBarActivity", 2, "onOptionsItemSelected");
    }
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    case 2131231456: 
      this.k.performClick();
      return true;
    case 2131231380: 
      this.m.performClick();
      return true;
    case 2131231464: 
      this.n.performClick();
      return true;
    }
    this.p.performClick();
    return true;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (QLog.isColorLevel()) {
      QLog.i("IphoneTitleBarActivity", 2, "onPrepareOptionsMenu");
    }
    MenuItem localMenuItem;
    if ((this.m != null) && (this.m.getVisibility() == 0) && (this.m.getText() != null) && (!this.m.getText().toString().equals("")))
    {
      localMenuItem = paramMenu.findItem(this.m.getId());
      if (localMenuItem != null)
      {
        localMenuItem.setTitle(this.m.getText());
        localMenuItem.setEnabled(this.m.isEnabled());
      }
    }
    else
    {
      if ((this.n != null) && (this.n.getVisibility() == 0) && (this.n.getText() != null) && (!this.n.getText().toString().equals("")))
      {
        localMenuItem = paramMenu.findItem(this.n.getId());
        if (localMenuItem == null) {
          break label313;
        }
        localMenuItem.setTitle(this.n.getText());
        label189:
        localMenuItem.setEnabled(this.n.isEnabled());
      }
      if ((this.p != null) && (this.p.getVisibility() == 0) && (this.p.getDrawable() != null))
      {
        localMenuItem = paramMenu.findItem(this.p.getId());
        if (localMenuItem == null) {
          break label344;
        }
        localMenuItem.setIcon(this.p.getDrawable());
      }
    }
    for (;;)
    {
      localMenuItem.setEnabled(this.p.isEnabled());
      return super.onPrepareOptionsMenu(paramMenu);
      localMenuItem = paramMenu.add(0, this.m.getId(), 0, this.m.getText());
      MenuItemCompat.setShowAsAction(localMenuItem, 1);
      break;
      label313:
      localMenuItem = paramMenu.add(0, this.n.getId(), 0, this.n.getText());
      MenuItemCompat.setShowAsAction(localMenuItem, 1);
      break label189;
      label344:
      localMenuItem = paramMenu.add(0, this.p.getId(), 0, "");
      localMenuItem.setIcon(this.p.getDrawable());
      MenuItemCompat.setShowAsAction(localMenuItem, 1);
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent) {}
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
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
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    b(getIntent());
  }
  
  public void setTitle(int paramInt)
  {
    String str = getString(paramInt);
    setTitle(str);
    g(str);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    String str2 = "";
    String str1 = str2;
    if (this.l != null)
    {
      str1 = str2;
      if ((this.l instanceof TextView))
      {
        TextView localTextView = this.l;
        str1 = str2;
        if (paramCharSequence != null)
        {
          str1 = a(paramCharSequence.toString(), localTextView);
          localTextView.setText(str1);
          super.setTitle(str1);
        }
      }
    }
    if (paramCharSequence != null)
    {
      if (!str1.equals("")) {
        g(str1);
      }
    }
    else {
      return;
    }
    g(paramCharSequence.toString());
  }
  
  @TargetApi(11)
  public void x()
  {
    if (Build.VERSION.SDK_INT == 16) {
      this.b.setLayerType(0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.IphoneTitleBarActivity
 * JD-Core Version:    0.7.0.1
 */