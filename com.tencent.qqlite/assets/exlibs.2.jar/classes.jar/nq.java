import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.biz.lebasearch.SearchActivity;

public class nq
  implements TextWatcher
{
  private nq(SearchActivity paramSearchActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = SearchActivity.a(this.a).getText().toString();
    this.a.b(paramEditable);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     nq
 * JD-Core Version:    0.7.0.1
 */