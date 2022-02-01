import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class aohb
  extends Handler
{
  aohb(aoha paramaoha, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Activity localActivity;
    if ((this.this$0.mActivityRef == null) || (this.this$0.mActivityRef.get() == null))
    {
      localActivity = null;
      if (localActivity != null) {
        break label75;
      }
      QLog.d("ThemeSwitchManager", 2, "handleMessage activity is not TitleBarActivity, , what=" + paramMessage.what);
    }
    label75:
    do
    {
      return;
      localActivity = (Activity)this.this$0.mActivityRef.get();
      break;
      switch (paramMessage.what)
      {
      default: 
        return;
      }
    } while ((localActivity.isFinishing()) || ((this.this$0.T != null) && (this.this$0.T.isShowing())));
    this.this$0.T = new arhz(localActivity, ((BaseActivity)localActivity).getTitleBarHeight());
    this.this$0.T.setCancelable(true);
    this.this$0.T.setMessage(2131720676);
    this.this$0.T.show();
    return;
    this.this$0.onPostThemeChanged();
    QQToast.a(localActivity, acfp.m(2131715318), 4000).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aohb
 * JD-Core Version:    0.7.0.1
 */