import com.tencent.mobileqq.international.activity.FeedbackActivity;
import com.tencent.mobileqq.widget.QQToast;

public class gdu
  implements Runnable
{
  public gdu(FeedbackActivity paramFeedbackActivity) {}
  
  public void run()
  {
    FeedbackActivity.c(this.a);
    QQToast.a(this.a, 2131559865, 0).a();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gdu
 * JD-Core Version:    0.7.0.1
 */