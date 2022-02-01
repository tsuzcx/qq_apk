package cooperation.plugin;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
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
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FakeImageView;
import com.tencent.mobileqq.widget.FakeTextView;
import iaf;
import java.lang.reflect.Method;

public class PluginIphoneTitleBarActivity
  extends PluginBaseActivity
{
  public static final int s = 1;
  protected float a;
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  protected View.OnClickListener a;
  private boolean jdField_a_of_type_Boolean;
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  public ViewGroup b;
  public ImageView k;
  public TextView l;
  public TextView m;
  public TextView n;
  protected TextView o;
  
  public PluginIphoneTitleBarActivity()
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new iaf(this);
  }
  
  private void a(String paramString)
  {
    try
    {
      getSupportActionBar().setTitle(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void b(Intent paramIntent)
  {
    ((FrameLayout)findViewById(16908290)).setForeground(getResources().getDrawable(2130840102));
    if (this.l == null)
    {
      this.b = ((ViewGroup)findViewById(2131231447));
      b(this.b);
      c();
      a();
      b_();
      a(paramIntent);
    }
  }
  
  public static void b(View paramView)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT <= 10) {
      return;
    }
    try
    {
      paramView.getClass().getMethod("setLayerType", new Class[] { Integer.TYPE, Paint.class }).invoke(paramView, new Object[] { Integer.valueOf(1), null });
      return;
    }
    catch (Exception paramView) {}
  }
  
  public View a()
  {
    this.m = ((TextView)findViewById(2131231375));
    return this.m;
  }
  
  public View a(int paramInt)
  {
    BounceScrollView localBounceScrollView = (BounceScrollView)View.inflate(this, 2130903099, null);
    View localView = View.inflate(this, paramInt, null);
    localBounceScrollView.addView(localView);
    setContentView(localBounceScrollView);
    return localView;
  }
  
  protected void a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.l.setVisibility(8);
    this.l = ((TextView)findViewById(2131231456));
    b(this.l);
    this.l.setVisibility(0);
    this.l.setText(paramInt);
    if (paramOnClickListener == null)
    {
      this.l.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
    }
    this.l.setOnClickListener(paramOnClickListener);
  }
  
  protected void a(Intent paramIntent)
  {
    if ((this.l != null) && ((this.l instanceof TextView)) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      TextView localTextView = this.l;
      String str = paramIntent.getExtras().getString("leftViewText");
      paramIntent = str;
      if (str == null) {
        paramIntent = getString(2131561692);
      }
      localTextView.setText(paramIntent);
    }
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    if (paramBoolean)
    {
      super.setContentView(paramView);
      b(getIntent());
      return;
    }
    super.setContentView(paramView);
  }
  
  public void a(CharSequence paramCharSequence, String paramString)
  {
    if ((this.m != null) && ((this.m instanceof TextView)))
    {
      this.m.setText(paramCharSequence);
      super.setTitle(paramString);
    }
    if (paramCharSequence != null) {
      a(paramCharSequence.toString());
    }
  }
  
  public boolean a()
  {
    finish();
    return false;
  }
  
  public String b()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.m != null)
    {
      localObject1 = localObject2;
      if ((this.m instanceof TextView))
      {
        CharSequence localCharSequence = this.m.getText();
        localObject1 = localObject2;
        if (localCharSequence != null) {
          localObject1 = localCharSequence.toString();
        }
      }
    }
    return localObject1;
  }
  
  protected void b(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_Boolean = true;
    this.n.setVisibility(0);
    this.n.setText(paramInt);
    this.n.setEnabled(false);
    this.o = ((TextView)getLayoutInflater().inflate(2130903161, null));
    b(this.o);
    this.o.setText(paramInt);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11, 1);
    localLayoutParams.addRule(15, 1);
    localLayoutParams.rightMargin = ((int)(8.0F * this.jdField_a_of_type_Float));
    this.b.addView(this.o, localLayoutParams);
    this.o.setVisibility(8);
    if (paramOnClickListener != null) {
      this.o.setOnClickListener(paramOnClickListener);
    }
  }
  
  public View b_()
  {
    this.n = ((TextView)findViewById(2131231379));
    this.k = ((ImageView)findViewById(2131231460));
    b(this.n);
    b(this.k);
    return this.n;
  }
  
  protected View c()
  {
    this.l = ((TextView)findViewById(2131231455));
    this.l.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    b(this.l);
    return this.l;
  }
  
  public String c()
  {
    if ((this.m == null) || (this.m.getText() == null) || (this.m.getText().length() == 0)) {
      return getString(2131561692);
    }
    return this.m.getText().toString();
  }
  
  public void c(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_Boolean = false;
    this.n.setVisibility(0);
    this.n.setText(paramInt);
    this.n.setEnabled(true);
    if (paramOnClickListener != null) {
      this.n.setOnClickListener(paramOnClickListener);
    }
  }
  
  public View findViewById(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.findViewById(paramInt);
    case 2131231455: 
      if (this.l == null)
      {
        this.l = new FakeTextView(this);
        this.l.setId(2131231455);
      }
      return this.l;
    case 2131231456: 
      if (this.l == null)
      {
        this.l = new FakeTextView(this);
        this.l.setId(2131231456);
      }
      return this.l;
    case 2131231375: 
      if (this.m == null)
      {
        this.m = new FakeTextView(this);
        this.m.setId(2131231375);
      }
      return this.m;
    case 2131231379: 
      if (this.n == null)
      {
        this.n = new FakeTextView(this);
        this.n.setId(2131231379);
      }
      return this.n;
    case 2131231460: 
      if (this.k == null)
      {
        this.k = new FakeImageView(this);
        this.k.setId(2131231460);
      }
      return this.k;
    }
    if (this.b == null)
    {
      this.b = new RelativeLayout(this);
      this.b.setId(2131231447);
    }
    return this.b;
  }
  
  public void g(int paramInt)
  {
    setContentView(paramInt);
    getWindow().setBackgroundDrawable(null);
  }
  
  public void h(int paramInt)
  {
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    super.setContentView(paramInt);
    b(getIntent());
  }
  
  protected void h(boolean paramBoolean)
  {
    if ((this.o == null) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    if (paramBoolean)
    {
      this.n.setVisibility(8);
      this.o.setVisibility(0);
      return;
    }
    this.n.setVisibility(0);
    this.o.setVisibility(8);
  }
  
  public boolean h()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130837862);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = this.m.getCompoundDrawables();
      this.jdField_a_of_type_Int = this.m.getCompoundDrawablePadding();
      this.m.setCompoundDrawablePadding(10);
      this.m.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      return true;
    }
    return false;
  }
  
  public void i(int paramInt)
  {
    if ((this.l != null) && ((this.l instanceof TextView)))
    {
      String str2 = getString(paramInt);
      TextView localTextView = this.l;
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
  
  public boolean i()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.m.setCompoundDrawablePadding(this.jdField_a_of_type_Int);
      this.m.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      return true;
    }
    return false;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    case 16908332: 
      finish();
      return true;
    case 2131231455: 
      this.l.performClick();
      return true;
    case 2131231379: 
      this.n.performClick();
      return true;
    case 2131231463: 
      this.o.performClick();
      return true;
    }
    this.k.performClick();
    return true;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    MenuItem localMenuItem;
    if ((this.n != null) && (this.n.getVisibility() == 0) && (this.n.getText() != null) && (!this.n.getText().toString().equals("")))
    {
      localMenuItem = paramMenu.findItem(this.n.getId());
      if (localMenuItem != null) {
        localMenuItem.setTitle(this.n.getText());
      }
    }
    else
    {
      if ((this.o != null) && (this.o.getVisibility() == 0) && (this.o.getText() != null) && (!this.o.getText().toString().equals("")))
      {
        localMenuItem = paramMenu.findItem(this.o.getId());
        if (localMenuItem == null) {
          break label254;
        }
        localMenuItem.setTitle(this.o.getText());
      }
      label160:
      if ((this.k != null) && (this.k.getVisibility() == 0) && (this.k.getDrawable() != null))
      {
        localMenuItem = paramMenu.findItem(this.k.getId());
        if (localMenuItem == null) {
          break label283;
        }
        localMenuItem.setIcon(this.k.getDrawable());
      }
    }
    for (;;)
    {
      return super.onPrepareOptionsMenu(paramMenu);
      MenuItemCompat.setShowAsAction(paramMenu.add(0, this.n.getId(), 0, this.n.getText()), 1);
      break;
      label254:
      MenuItemCompat.setShowAsAction(paramMenu.add(0, this.o.getId(), 0, this.o.getText()), 1);
      break label160;
      label283:
      localMenuItem = paramMenu.add(0, this.k.getId(), 0, "");
      localMenuItem.setIcon(this.k.getDrawable());
      MenuItemCompat.setShowAsAction(localMenuItem, 1);
    }
  }
  
  @TargetApi(11)
  public void p()
  {
    if (Build.VERSION.SDK_INT == 16) {
      this.b.setLayerType(0, null);
    }
  }
  
  public void setContentView(int paramInt)
  {
    boolean bool = true;
    Intent localIntent = getIntent();
    if (localIntent != null) {
      bool = localIntent.getBooleanExtra("showTitleBar", true);
    }
    if (bool) {}
    super.setContentView(paramInt);
    if (bool) {}
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    if (bool) {
      b(getIntent());
    }
  }
  
  public void setContentView(View paramView)
  {
    a(paramView, true);
  }
  
  public void setTitle(int paramInt)
  {
    String str = getString(paramInt);
    setTitle(str);
    a(str);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if ((this.m != null) && ((this.m instanceof TextView)))
    {
      this.m.setText(paramCharSequence);
      super.setTitle(paramCharSequence);
    }
    if (paramCharSequence != null) {
      a(paramCharSequence.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.plugin.PluginIphoneTitleBarActivity
 * JD-Core Version:    0.7.0.1
 */