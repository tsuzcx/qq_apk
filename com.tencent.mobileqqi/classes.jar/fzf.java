import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.international.activity.FeedbackActivity;

public class fzf
  implements View.OnClickListener
{
  public fzf(FeedbackActivity paramFeedbackActivity) {}
  
  public void onClick(View paramView)
  {
    FeedbackActivity.a(this.a);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fzf
 * JD-Core Version:    0.7.0.1
 */