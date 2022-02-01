import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import com.tencent.biz.subscribe.comment.CommentEditText;

class vny
  implements TextWatcher
{
  vny(vnw paramvnw) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable == null) {
      return;
    }
    vnw.a(this.a).removeTextChangedListener(this);
    if (vnw.b(this.a).getText().toString().isEmpty()) {
      if (vnw.a(this.a) != null) {
        vnw.b(this.a).setBackgroundResource(2130843894);
      }
    }
    for (;;)
    {
      vnw.c(this.a).addTextChangedListener(this);
      return;
      vnw.c(this.a).setBackgroundResource(2130843895);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vny
 * JD-Core Version:    0.7.0.1
 */