import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.biz.subscribe.comment.CommentEditText;
import com.tencent.qphone.base.util.QLog;

public class scs
  implements TextWatcher
{
  String aDI = null;
  int bwn = -1;
  
  public scs(CommentEditText paramCommentEditText) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.aDI != null) {}
    try
    {
      int i = this.bwn;
      this.this$0.setText(this.aDI);
      if (i > this.this$0.length()) {
        this.this$0.setSelection(this.this$0.length());
      }
      return;
    }
    catch (Exception paramEditable)
    {
      QLog.e("CommentInputPopupWindow", 1, "setTextError");
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = paramCharSequence.toString().indexOf("[/", paramInt1);
    int i = paramCharSequence.toString().indexOf(']', paramInt1);
    if ((paramInt2 >= paramInt1) && (paramInt2 < paramInt1 + paramInt3) && ((i > paramInt1 + paramInt3) || (i == -1)))
    {
      this.bwn = this.this$0.getSelectionEnd();
      this.aDI = (paramCharSequence.subSequence(0, paramInt2).toString() + paramCharSequence.subSequence(paramInt1 + paramInt3, paramCharSequence.length()));
      return;
    }
    this.aDI = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     scs
 * JD-Core Version:    0.7.0.1
 */