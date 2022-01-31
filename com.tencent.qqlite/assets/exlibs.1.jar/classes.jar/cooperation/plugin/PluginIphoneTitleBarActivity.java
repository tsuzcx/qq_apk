package cooperation.plugin;

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
import fkn;
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
  protected ViewGroup b;
  protected ImageView k;
  protected TextView l;
  protected TextView m;
  protected TextView n;
  protected TextView o;
  
  public PluginIphoneTitleBarActivity()
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new fkn(this);
  }
  
  public static void a(View paramView)
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
  
  private void b(Intent paramIntent)
  {
    ((FrameLayout)findViewById(16908290)).setForeground(getResources().getDrawable(2130839259));
    if (this.l == null)
    {
      this.b = ((ViewGroup)findViewById(2131296890));
      a(this.b);
      b();
      c();
      a();
      a(paramIntent);
    }
  }
  
  protected View a()
  {
    this.n = ((TextView)findViewById(2131296901));
    this.k = ((ImageView)findViewById(2131296902));
    a(this.n);
    a(this.k);
    return this.n;
  }
  
  public View a(int paramInt)
  {
    BounceScrollView localBounceScrollView = (BounceScrollView)View.inflate(this, 2130903078, null);
    View localView = View.inflate(this, paramInt, null);
    localBounceScrollView.addView(localView);
    setContentView(localBounceScrollView);
    return localView;
  }
  
  protected void a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.l.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
    }
    this.l.setOnClickListener(paramOnClickListener);
  }
  
  protected void a(Intent paramIntent) {}
  
  public void a(View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    if (paramBoolean)
    {
      requestWindowFeature(7);
      super.setContentView(paramView);
      getWindow().setFeatureInt(7, 2130903131);
      b(getIntent());
      return;
    }
    requestWindowFeature(1);
    super.setContentView(paramView);
  }
  
  public void a(CharSequence paramCharSequence, String paramString)
  {
    if ((this.m != null) && ((this.m instanceof TextView)))
    {
      this.m.setText(paramCharSequence);
      super.setTitle(paramString);
    }
    if ((this.l != null) && ((this.l instanceof TextView))) {
      this.l.setText(paramCharSequence);
    }
  }
  
  public boolean a()
  {
    finish();
    return false;
  }
  
  protected View b()
  {
    this.l = ((TextView)findViewById(2131296897));
    this.l.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    a(this.l);
    return this.l;
  }
  
  protected String b()
  {
    if ((this.m == null) || (this.m.getText() == null) || (this.m.getText().length() == 0)) {
      return getString(2131363113);
    }
    return this.m.getText().toString();
  }
  
  protected void b(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_Boolean = true;
    this.n.setVisibility(0);
    this.n.setText(paramInt);
    this.n.setEnabled(false);
    this.o = ((TextView)getLayoutInflater().inflate(2130903133, null));
    a(this.o);
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
  
  protected void b(boolean paramBoolean)
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
  
  protected View c()
  {
    this.m = ((TextView)findViewById(2131296891));
    return this.m;
  }
  
  public String c()
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
  
  protected void c(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_Boolean = false;
    this.n.setVisibility(0);
    this.n.setText(paramInt);
    this.n.setEnabled(true);
    if (paramOnClickListener != null) {
      this.n.setOnClickListener(paramOnClickListener);
    }
  }
  
  protected boolean c()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130837910);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = this.m.getCompoundDrawables();
      this.jdField_a_of_type_Int = this.m.getCompoundDrawablePadding();
      this.m.setCompoundDrawablePadding(10);
      this.m.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
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
      this.m.setCompoundDrawablePadding(this.jdField_a_of_type_Int);
      this.m.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      return true;
    }
    return false;
  }
  
  public void g(int paramInt)
  {
    setContentView(paramInt);
    getWindow().setBackgroundDrawable(null);
  }
  
  public void h(int paramInt)
  {
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    requestWindowFeature(1);
    super.setContentView(paramInt);
    b(getIntent());
  }
  
  protected void i(int paramInt) {}
  
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
    if (bool) {
      requestWindowFeature(7);
    }
    super.setContentView(paramInt);
    if (bool) {
      getWindow().setFeatureInt(7, 2130903131);
    }
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
    setTitle(getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if ((this.m != null) && ((this.m instanceof TextView)))
    {
      this.m.setText(paramCharSequence);
      super.setTitle(paramCharSequence);
    }
    if ((this.l != null) && ((this.l instanceof TextView))) {
      this.l.setText(paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.plugin.PluginIphoneTitleBarActivity
 * JD-Core Version:    0.7.0.1
 */