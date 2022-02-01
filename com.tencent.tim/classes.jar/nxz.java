import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageButton;
import com.tencent.biz.pubaccount.readinjoySearch.ReadInJoyNewSearchActivity;

public class nxz
  implements TextWatcher
{
  public nxz(ReadInJoyNewSearchActivity paramReadInJoyNewSearchActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (TextUtils.isEmpty(ReadInJoyNewSearchActivity.a(this.this$0).getText().toString()))
    {
      ReadInJoyNewSearchActivity.a(this.this$0).setVisibility(8);
      return;
    }
    ReadInJoyNewSearchActivity.a(this.this$0).setVisibility(0);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nxz
 * JD-Core Version:    0.7.0.1
 */