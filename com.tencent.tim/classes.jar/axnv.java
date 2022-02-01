import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.widget.QQToast;

class axnv
  implements TextWatcher
{
  axnv(axnr paramaxnr) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable == null) {
      return;
    }
    String str = paramEditable.toString();
    if (paramEditable.length() > 40)
    {
      QQToast.a(this.this$0.getContext(), axnr.a(this.this$0), 0).show();
      str = paramEditable.subSequence(0, 40).toString();
      axnr.a(this.this$0).setText(str);
      axnr.a(this.this$0).setSelection(str.length());
    }
    if (TextUtils.isEmpty(str.trim())) {
      axnr.a(this.this$0).setContent("");
    }
    for (;;)
    {
      axnr.a(this.this$0);
      return;
      axnr.a(this.this$0).setContent(str);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axnv
 * JD-Core Version:    0.7.0.1
 */