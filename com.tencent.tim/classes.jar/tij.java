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
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class tij
  extends ReportDialog
{
  private tir jdField_a_of_type_Tir;
  private tje jdField_a_of_type_Tje;
  private Application.ActivityLifecycleCallbacks b;
  private Activity mActivity;
  private Intent mIntent;
  private Intent x;
  
  public tij(@NonNull Context paramContext)
  {
    super(paramContext, 16973834);
    this.mActivity = ((Activity)paramContext);
  }
  
  private void initData()
  {
    this.x = this.mActivity.getIntent();
    this.mActivity.setIntent(this.mIntent);
    Object localObject = this.mIntent.getExtras();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((Bundle)localObject).getSerializable("data");
    } while (!(localObject instanceof GdtMotiveVideoPageData));
    this.jdField_a_of_type_Tir = new tir((GdtMotiveVideoPageData)GdtMotiveVideoPageData.class.cast(localObject));
  }
  
  private void initView()
  {
    this.jdField_a_of_type_Tje = new tje(new tik(this), this.jdField_a_of_type_Tir, true);
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
    ((ViewGroup)localObject1).setSystemUiVisibility(7942);
    if (Build.VERSION.SDK_INT >= 19) {
      ((ViewGroup)localObject1).setOnSystemUiVisibilityChangeListener(new til(this, (ViewGroup)localObject1));
    }
    Object localObject2 = this.jdField_a_of_type_Tje.b(LayoutInflater.from(this.mActivity), (ViewGroup)localObject1);
    setContentView((View)localObject2);
    setOnDismissListener(new tim(this));
    ((ViewGroup)localObject1).getViewTreeObserver().addOnGlobalLayoutListener(new tin(this, (ViewGroup)localObject1, (View)localObject2));
    this.b = new tio(this);
    this.mActivity.getApplication().registerActivityLifecycleCallbacks(this.b);
    this.jdField_a_of_type_Tje.onCreate();
  }
  
  public void onBackPressed()
  {
    if (this.jdField_a_of_type_Tje.onBackEvent()) {
      return;
    }
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initData();
    initView();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  protected void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_Tje.onResume();
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_Tje.onPause();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    tkw.d("GdtMotiveVideoDialog", "onWindowFocusChanged() called with: hasFocus = [" + paramBoolean + "]");
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 19)) {
      getWindow().getDecorView().setSystemUiVisibility(7942);
    }
  }
  
  public void setIntent(Intent paramIntent)
  {
    this.mIntent = paramIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tij
 * JD-Core Version:    0.7.0.1
 */