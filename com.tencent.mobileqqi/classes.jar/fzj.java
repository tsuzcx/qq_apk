import com.tencent.mobileqq.international.activity.FeedbackActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class fzj
  implements Runnable
{
  public fzj(FeedbackActivity paramFeedbackActivity) {}
  
  public void run()
  {
    FeedbackActivity.c(this.a);
    QQToast.a(this.a, 2131561435, 1).a();
    QLog.e("FeedBackActivity", 2, "feedback failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fzj
 * JD-Core Version:    0.7.0.1
 */