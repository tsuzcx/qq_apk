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

public class yuz
  extends Dialog
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Application.ActivityLifecycleCallbacks jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private yvh jdField_a_of_type_Yvh;
  private yvv jdField_a_of_type_Yvv;
  private Intent b;
  
  public yuz(@NonNull Context paramContext)
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
    this.jdField_a_of_type_Yvh = new yvh((GdtMotiveVideoPageData)GdtMotiveVideoPageData.class.cast(localObject));
  }
  
  private void b()
  {
    this.jdField_a_of_type_Yvv = new yvv(new yva(this), this.jdField_a_of_type_Yvh, true);
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
      ((ViewGroup)localObject1).setOnSystemUiVisibilityChangeListener(new yvb(this, (ViewGroup)localObject1));
    }
    Object localObject2 = this.jdField_a_of_type_Yvv.a(LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity), (ViewGroup)localObject1);
    setContentView((View)localObject2);
    setOnDismissListener(new yvc(this));
    ((ViewGroup)localObject1).getViewTreeObserver().addOnGlobalLayoutListener(new yvd(this, (ViewGroup)localObject1, (View)localObject2));
    this.jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks = new yve(this);
    this.jdField_a_of_type_AndroidAppActivity.getApplication().registerActivityLifecycleCallbacks(this.jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks);
    this.jdField_a_of_type_Yvv.h();
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  public void onBackPressed()
  {
    if (this.jdField_a_of_type_Yvv.c()) {
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
    this.jdField_a_of_type_Yvv.f();
  }
  
  protected void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_Yvv.e();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    yxs.a("GdtMotiveVideoDialog", "onWindowFocusChanged() called with: hasFocus = [" + paramBoolean + "]");
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 19)) {
      getWindow().getDecorView().setSystemUiVisibility(3846);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yuz
 * JD-Core Version:    0.7.0.1
 */