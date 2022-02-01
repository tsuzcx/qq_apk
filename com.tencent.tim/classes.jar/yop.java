import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageButton;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment;

public class yop
  implements TextWatcher
{
  public yop(SearchContactsActivity paramSearchContactsActivity, boolean paramBoolean) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.a.aN.getText().toString();
    SearchContactsActivity.a(this.a, paramEditable);
    ImageButton localImageButton = this.a.ap;
    if (paramEditable.equals("")) {}
    for (int i = 8;; i = 0)
    {
      localImageButton.setVisibility(i);
      if ((this.bnR) && (this.a.mFrom != 1)) {
        ((SearchContactsFragment)this.a.a).setKeyword(paramEditable);
      }
      return;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yop
 * JD-Core Version:    0.7.0.1
 */