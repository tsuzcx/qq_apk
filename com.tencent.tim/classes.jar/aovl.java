import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;

public class aovl
  implements TextWatcher
{
  public aovl(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((!TextUtils.isEmpty(this.this$0.cnf)) && (paramInt1 > 0) && (paramInt1 < this.this$0.cnf.length() + 1) && (paramInt2 > paramInt3))
    {
      this.this$0.Rl(false);
      return;
    }
    TroopBarPublishActivity.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aovl
 * JD-Core Version:    0.7.0.1
 */