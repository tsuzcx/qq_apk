import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;

public class fle
  implements TextWatcher
{
  public fle(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.a.b = true;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fle
 * JD-Core Version:    0.7.0.1
 */