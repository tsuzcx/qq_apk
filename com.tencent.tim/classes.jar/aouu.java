import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;

public class aouu
  implements TextWatcher
{
  public aouu(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((!TextUtils.isEmpty(this.this$0.a.cmJ)) && (paramInt1 > 0) && (paramInt1 < this.this$0.a.cmJ.length() + this.this$0.a.cmK.length() + this.this$0.a.cmI.length() + this.this$0.cni.length()) && (paramInt2 > paramInt3))
    {
      this.this$0.Rm(false);
      return;
    }
    TroopBarPublishActivity.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aouu
 * JD-Core Version:    0.7.0.1
 */