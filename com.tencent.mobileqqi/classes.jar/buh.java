import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;

public class buh
  implements TextWatcher
{
  public buh(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i = paramEditable.length();
    int j = i;
    if (i > 30)
    {
      paramEditable = paramEditable.toString();
      if (i > 30)
      {
        i = paramEditable.length();
        if ((i >= 2) && (Character.isHighSurrogate(paramEditable.charAt(i - 2)))) {}
        for (paramEditable = paramEditable.substring(0, i - 2);; paramEditable = paramEditable.substring(0, i - 1))
        {
          i = paramEditable.length();
          break;
        }
      }
      if (AddFriendVerifyActivity.a(this.a) != 9) {
        break label163;
      }
      AddFriendVerifyActivity.a(this.a).setText(paramEditable);
      AddFriendVerifyActivity.a(this.a).setSelection(paramEditable.length());
    }
    for (j = i;; j = i)
    {
      if (AddFriendVerifyActivity.b(this.a).getVisibility() == 0) {
        AddFriendVerifyActivity.b(this.a).setText(30 - j + "");
      }
      return;
      label163:
      this.a.a.setText(paramEditable);
      this.a.a.setSelection(paramEditable.length());
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     buh
 * JD-Core Version:    0.7.0.1
 */