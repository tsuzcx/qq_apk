import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.mobileqq.fragment.MsgBackupSettingFragment;

public class ahni
  implements TextWatcher
{
  public ahni(MsgBackupSettingFragment paramMsgBackupSettingFragment, TextView paramTextView1, TextView paramTextView2) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    this.Ts.setText(String.format(MsgBackupSettingFragment.a(this.this$0), new Object[] { paramEditable }));
    this.Tt.setText(String.format(MsgBackupSettingFragment.b(this.this$0), new Object[] { paramEditable }));
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahni
 * JD-Core Version:    0.7.0.1
 */