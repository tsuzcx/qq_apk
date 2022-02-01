import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;

public class ajyy
  implements TextWatcher
{
  public ajyy(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (ShortVideoCommentsView.a(this.this$0) == null) {}
    while (ajxp.a(paramEditable.toString()) <= 140) {
      return;
    }
    int j = Selection.getSelectionEnd(paramEditable);
    paramEditable = ajxp.b(paramEditable.toString(), 0, 140).toString();
    ShortVideoCommentsView.a(this.this$0).setText(paramEditable);
    paramEditable = ShortVideoCommentsView.a(this.this$0).getText();
    int i = j;
    if (j > paramEditable.length()) {
      i = paramEditable.length();
    }
    Selection.setSelection(paramEditable, i);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajyy
 * JD-Core Version:    0.7.0.1
 */