import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;

public class ynx
  implements TextView.OnEditorActionListener
{
  public ynx(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 3) || ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66)))
    {
      paramTextView = this.this$0.aN.getText().toString();
      if (!TextUtils.isEmpty(paramTextView)) {
        if ((this.this$0.mSource == ClassificationSearchActivity.cad) && (!TextUtils.isEmpty(paramTextView.trim())))
        {
          this.this$0.oR(paramTextView);
          kbp.a(null, "dc00899", "Pb_account_lifeservice", "", "0X80067C4", "0X80067C4", 0, 0, "", "", paramTextView, "", true);
          ClassificationSearchActivity.a(this.this$0, paramTextView);
        }
      }
      for (;;)
      {
        return true;
        if (this.this$0.mSource == ClassificationSearchActivity.cag)
        {
          kbp.a(null, "", "0X800742D", "0X800742D", 0, 0, paramTextView, "", "", "");
          ClassificationSearchActivity.a(this.this$0, paramTextView);
        }
        else
        {
          this.this$0.a.bc(paramTextView, false);
          continue;
          if (this.this$0.mSource == ClassificationSearchActivity.cad)
          {
            paramTextView = this.this$0.aN.getHint().toString();
            if ((!TextUtils.isEmpty(paramTextView.trim())) && (!TextUtils.equals(paramTextView, acfp.m(2131703942))) && (!TextUtils.equals(paramTextView, acfp.m(2131703957))))
            {
              this.this$0.oR(paramTextView);
              kbp.a(null, "dc00899", "Pb_account_lifeservice", "", "0X80067C4", "0X80067C4", 0, 0, "", "", paramTextView, "", true);
              ClassificationSearchActivity.a(this.this$0, paramTextView);
            }
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ynx
 * JD-Core Version:    0.7.0.1
 */