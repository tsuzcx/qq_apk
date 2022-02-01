import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class yzc
  implements yzw
{
  protected Activity activity;
  
  public yzc(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public void Bg(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      FrameHelperActivity.EO(paramBoolean);
      return;
    }
  }
  
  public void aJ(QQAppInterface paramQQAppInterface) {}
  
  public void bMe() {}
  
  public Activity getActivity()
  {
    return this.activity;
  }
  
  public void onCreate() {}
  
  public void onDestroy() {}
  
  public void onPause() {}
  
  public void onResume(boolean paramBoolean) {}
  
  public void u(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yzc
 * JD-Core Version:    0.7.0.1
 */