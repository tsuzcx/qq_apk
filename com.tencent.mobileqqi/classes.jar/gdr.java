import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.mobileqq.international.activity.FeedbackActivity;

public class gdr
  implements TextWatcher
{
  public gdr(FeedbackActivity paramFeedbackActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (TextUtils.isEmpty(paramEditable.toString().trim()))
    {
      FeedbackActivity.a(this.a).setEnabled(false);
      return;
    }
    FeedbackActivity.a(this.a).setEnabled(true);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gdr
 * JD-Core Version:    0.7.0.1
 */