import android.view.View;
import com.tencent.mobileqq.activity.RecentLoginDevActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class vqt
  implements ausj.a
{
  public vqt(RecentLoginDevActivity paramRecentLoginDevActivity, String paramString, ArrayList paramArrayList, int paramInt) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if ((RecentLoginDevActivity.a(this.this$0) != null) && (RecentLoginDevActivity.a(this.this$0).isShowing()) && (!this.this$0.isFinishing()))
      {
        RecentLoginDevActivity.a(this.this$0).dismiss();
        RecentLoginDevActivity.a(this.this$0).cancel();
        RecentLoginDevActivity.a(this.this$0, null);
      }
      return;
      if (!aqiw.isNetSupport(this.this$0))
      {
        QQToast.a(this.this$0, this.this$0.getString(2131693404), 0).show(this.this$0.getTitleBarHeight());
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.RecentLoginDevActivity", 2, "OnClick begin to delHistoryDev");
        }
        if (afsf.a().a(this.this$0.app, this.val$name, this.val$list, this.val$i)) {
          RecentLoginDevActivity.a(this.this$0);
        } else if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.RecentLoginDevActivity", 2, "showDelDevActionSheet.OnClick delHistoryDev failed");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vqt
 * JD-Core Version:    0.7.0.1
 */