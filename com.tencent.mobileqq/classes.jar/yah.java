import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;

public class yah
  implements TextWatcher
{
  public yah(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    if (TextUtils.isEmpty(paramEditable)) {
      this.a.b.setVisibility(8);
    }
    for (;;)
    {
      if (this.a.a != null) {
        this.a.a.a(paramEditable);
      }
      return;
      this.a.b.setVisibility(0);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     yah
 * JD-Core Version:    0.7.0.1
 */