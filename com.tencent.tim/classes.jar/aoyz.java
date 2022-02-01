import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.FrameLayout;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopContactView;

public class aoyz
  implements TextWatcher
{
  public aoyz(NewTroopContactView paramNewTroopContactView) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    if (TextUtils.isEmpty(paramEditable)) {
      this.b.aS.setVisibility(8);
    }
    for (;;)
    {
      if (this.b.c != null) {
        this.b.c.Id(paramEditable);
      }
      return;
      this.b.aS.setVisibility(0);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoyz
 * JD-Core Version:    0.7.0.1
 */