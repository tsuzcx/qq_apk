import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import com.tencent.biz.subscribe.comment.CommentEditText;

class vqg
  implements TextWatcher
{
  vqg(vqe paramvqe) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable == null) {
      return;
    }
    vqe.a(this.a).removeTextChangedListener(this);
    if (vqe.b(this.a).getText().toString().isEmpty()) {
      if (vqe.a(this.a) != null) {
        vqe.b(this.a).setBackgroundResource(2130843912);
      }
    }
    for (;;)
    {
      vqe.c(this.a).addTextChangedListener(this);
      return;
      vqe.c(this.a).setBackgroundResource(2130843913);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vqg
 * JD-Core Version:    0.7.0.1
 */