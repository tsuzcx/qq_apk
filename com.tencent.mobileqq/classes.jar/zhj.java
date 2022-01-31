import android.view.View.OnSystemUiVisibilityChangeListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class zhj
  implements View.OnSystemUiVisibilityChangeListener
{
  public zhj(BaseActivity paramBaseActivity) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = false;; bool = true)
    {
      BaseActivity.mIsInMultiScreen = bool;
      this.a.onMultiWindowModeChanged(BaseActivity.mIsInMultiScreen);
      if (QLog.isDevelopLevel()) {
        QLog.d("qqBaseActivity", 4, "onSystemUiVisibilityChange:" + paramInt + ",Activity name:" + getClass().getName());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zhj
 * JD-Core Version:    0.7.0.1
 */