import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.teamworkforgroup.TroopTeamWorkFileSearchDialog.6.1;
import com.tencent.mobileqq.troop.widget.CountdownTimeTask;
import com.tencent.qphone.base.util.QLog;

public class aoew
  implements TextWatcher
{
  aoew(aoeq paramaoeq) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.this$0.cLo) {
      this.this$0.cLo = false;
    }
    do
    {
      return;
      if (paramEditable == null) {}
      for (paramEditable = ""; paramEditable.trim().equals(""); paramEditable = paramEditable.toString())
      {
        this.this$0.dUp();
        return;
      }
      this.this$0.aF.setVisibility(0);
      if (!aqiw.isNetworkAvailable(this.this$0.mActivity))
      {
        if (this.this$0.a != null)
        {
          this.this$0.a.shutdown();
          this.this$0.a = null;
        }
        this.this$0.dUo();
        return;
      }
      this.this$0.ceC = false;
      if (this.this$0.a == null)
      {
        this.this$0.a = new CountdownTimeTask(new TroopTeamWorkFileSearchDialog.6.1(this), 800);
        ThreadManager.post(this.this$0.a, 5, null, true);
        return;
      }
      if (this.this$0.a.hz() > 0L)
      {
        this.this$0.a.ebZ();
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TroopTeamWorkFileSearchDialog", 2, "!!!!!! 这是个什么情况,逻辑出错了 !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((!this.this$0.cLo) || ((this.this$0.cLo) && (this.this$0.dOl <= 0)))
    {
      this.this$0.ZV.setVisibility(8);
      return;
    }
    this.this$0.ZV.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoew
 * JD-Core Version:    0.7.0.1
 */