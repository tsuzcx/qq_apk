import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.biz.troop.file.MoveFileActivity;

public class smo
  implements TextWatcher
{
  public smo(MoveFileActivity paramMoveFileActivity, EditText paramEditText, svx paramsvx) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.val$editText.getText().toString().trim();
    TextView localTextView = this.a.getBtnight();
    if (apsv.qS(paramEditable))
    {
      localTextView.setEnabled(false);
      localTextView.setTextColor(this.this$0.getResources().getColor(2131165758));
      return;
    }
    localTextView.setEnabled(true);
    localTextView.setTextColor(this.this$0.getResources().getColor(2131165750));
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 > 0)
    {
      paramCharSequence = paramCharSequence.toString();
      String str = apsv.filterEmoji(paramCharSequence);
      if ((paramCharSequence == null) || (paramCharSequence.equals(str))) {
        break label57;
      }
      this.this$0.bxK = paramInt1;
      this.this$0.aMc = true;
      this.val$editText.setText(str);
    }
    label57:
    while (!this.this$0.aMc) {
      return;
    }
    this.val$editText.setSelection(this.this$0.bxK);
    this.this$0.aMc = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     smo
 * JD-Core Version:    0.7.0.1
 */