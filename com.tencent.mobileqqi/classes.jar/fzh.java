import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.international.activity.FeedbackActivity;

public class fzh
  implements View.OnClickListener
{
  public fzh(FeedbackActivity paramFeedbackActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = FeedbackActivity.a(this.a).getEditableText().toString().trim();
    if (TextUtils.isEmpty(paramView)) {
      return;
    }
    FeedbackActivity.b(this.a);
    paramView.trim();
    FeedbackActivity.a(this.a, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fzh
 * JD-Core Version:    0.7.0.1
 */