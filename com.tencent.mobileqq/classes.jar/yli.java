import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;

public class yli
  extends Dialog
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Application.ActivityLifecycleCallbacks jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private ylq jdField_a_of_type_Ylq;
  private yme jdField_a_of_type_Yme;
  private Intent b;
  
  public yli(@NonNull Context paramContext)
  {
    super(paramContext, 16973834);
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
  }
  
  private void a()
  {
    this.b = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    this.jdField_a_of_type_AndroidAppActivity.setIntent(this.jdField_a_of_type_AndroidContentIntent);
    Object localObject = this.jdField_a_of_type_AndroidContentIntent.getExtras();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((Bundle)localObject).getSerializable("data");
    } while (!(localObject instanceof GdtMotiveVideoPageData));
    this.jdField_a_of_type_Ylq = new ylq((GdtMotiveVideoPageData)GdtMotiveVideoPageData.class.cast(localObject));
  }
  
  private void b()
  {
    this.jdField_a_of_type_Yme = new yme(new ylj(this), this.jdField_a_of_type_Ylq, true);
    Object localObject1 = getWindow();
    if (Build.VERSION.SDK_INT >= 28)
    {
      localObject2 = ((Window)localObject1).getAttributes();
      ((WindowManager.LayoutParams)localObject2).layoutInDisplayCutoutMode = 1;
      ((Window)localObject1).setAttributes((WindowManager.LayoutParams)localObject2);
    }
    ((Window)localObject1).setFlags(1024, 1024);
    ((Window)localObject1).setVolumeControlStream(3);
    localObject1 = (ViewGroup)((Window)localObject1).getDecorView();
    ((ViewGroup)localObject1).setSystemUiVisibility(3846);
    if (Build.VERSION.SDK_INT >= 19) {
      ((ViewGroup)localObject1).setOnSystemUiVisibilityChangeListener(new ylk(this, (ViewGroup)localObject1));
    }
    Object localObject2 = this.jdField_a_of_type_Yme.a(LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity), (ViewGroup)localObject1);
    setContentView((View)localObject2);
    setOnDismissListener(new yll(this));
    ((ViewGroup)localObject1).getViewTreeObserver().addOnGlobalLayoutListener(new ylm(this, (ViewGroup)localObject1, (View)localObject2));
    this.jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks = new yln(this);
    this.jdField_a_of_type_AndroidAppActivity.getApplication().registerActivityLifecycleCallbacks(this.jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks);
    this.jdField_a_of_type_Yme.h();
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  public void onBackPressed()
  {
    if (this.jdField_a_of_type_Yme.c()) {
      return;
    }
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
    b();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  protected void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_Yme.f();
  }
  
  protected void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_Yme.e();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    yny.a("GdtMotiveVideoDialog", "onWindowFocusChanged() called with: hasFocus = [" + paramBoolean + "]");
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 19)) {
      getWindow().getDecorView().setSystemUiVisibility(3846);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yli
 * JD-Core Version:    0.7.0.1
 */