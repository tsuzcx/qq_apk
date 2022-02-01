import android.view.View.OnSystemUiVisibilityChangeListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class acca
  implements View.OnSystemUiVisibilityChangeListener
{
  public acca(BaseActivity paramBaseActivity) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = false;; bool = true)
    {
      BaseActivity.mIsInMultiScreen = bool;
      this.this$0.onMultiWindowModeChanged(BaseActivity.mIsInMultiScreen);
      if (QLog.isDevelopLevel()) {
        QLog.d("qqBaseActivity", 4, "onSystemUiVisibilityChange:" + paramInt + ",Activity name:" + getClass().getName());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acca
 * JD-Core Version:    0.7.0.1
 */