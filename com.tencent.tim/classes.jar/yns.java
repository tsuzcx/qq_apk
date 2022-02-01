import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;

public class yns
  implements TextWatcher
{
  public yns(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    String str = this.this$0.aN.getText().toString();
    paramEditable = this.this$0.ap;
    if (str.equals("")) {}
    for (int i = 8;; i = 0)
    {
      paramEditable.setVisibility(i);
      if (this.this$0.mSource != ClassificationSearchActivity.caf) {
        break;
      }
      this.this$0.eg.setText(this.this$0.getResources().getString(2131721058));
      if (AppSetting.enableTalkBack) {
        this.this$0.eg.setContentDescription(this.this$0.eg.getText().toString());
      }
      if ((str.equals("")) && (this.this$0.a != null))
      {
        if ((this.this$0.mSource != ClassificationSearchActivity.cad) && (this.this$0.mSource != ClassificationSearchActivity.cag)) {
          break label219;
        }
        ClassificationSearchActivity.a(this.this$0);
      }
      return;
    }
    Button localButton = this.this$0.eg;
    if (!str.equals("")) {}
    for (paramEditable = this.this$0.getResources().getString(2131719306);; paramEditable = this.this$0.getResources().getString(2131721058))
    {
      localButton.setText(paramEditable);
      break;
    }
    label219:
    this.this$0.a.clear();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yns
 * JD-Core Version:    0.7.0.1
 */