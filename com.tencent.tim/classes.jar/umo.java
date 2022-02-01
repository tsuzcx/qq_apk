import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.a;
import com.tencent.qphone.base.util.QLog;

public class umo
  implements TextWatcher
{
  public umo(ChatHistory paramChatHistory) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramCharSequence != null) && (paramCharSequence.length() != 0)) {}
    for (;;)
    {
      try
      {
        paramInt1 = Integer.valueOf(paramCharSequence.toString()).intValue();
        if ((paramCharSequence.length() <= 1) || (paramCharSequence.charAt(0) != '0')) {
          break label421;
        }
        paramCharSequence = String.valueOf(paramInt1);
        paramInt2 = 1;
        if ((paramInt1 < 1) || (paramInt1 > this.this$0.pageCount)) {
          paramCharSequence = paramCharSequence.subSequence(0, paramCharSequence.length() - 1).toString();
        }
      }
      catch (Exception localException1)
      {
        try
        {
          paramInt1 = Integer.valueOf(paramCharSequence.toString()).intValue();
          paramInt2 = 1;
          continue;
          localException1 = localException1;
          paramInt1 = this.this$0.pageCount;
        }
        catch (Exception paramCharSequence)
        {
          paramInt1 = this.this$0.pageCount;
          paramCharSequence = String.valueOf(paramInt1);
          continue;
        }
      }
      if (paramInt2 != 0) {}
      try
      {
        this.this$0.au.setSelection(Math.max(0, paramCharSequence.length() - 1));
        this.this$0.au.setText(paramCharSequence.toString());
        paramCharSequence = this.this$0;
        if (paramInt1 < this.this$0.pageCount)
        {
          paramCharSequence.uo = paramInt1;
          if (this.this$0.uo < this.this$0.pageCount) {
            break label369;
          }
          this.this$0.pB.setEnabled(false);
          this.this$0.pB.setImageResource(2130850446);
          if (this.this$0.uo > 1) {
            break label395;
          }
          this.this$0.pA.setEnabled(false);
          this.this$0.pA.setImageResource(2130841231);
          this.this$0.bFe = ((this.this$0.uo - 1) * 8);
          this.this$0.a.O(this.this$0.mUin, this.this$0.mType, this.this$0.bFe);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          QLog.e("ChatHistory", 1, "current s:" + paramCharSequence);
          continue;
          paramInt1 = this.this$0.pageCount;
          continue;
          label369:
          this.this$0.pB.setEnabled(true);
          this.this$0.pB.setImageResource(2130839265);
          continue;
          label395:
          this.this$0.pA.setEnabled(true);
          this.this$0.pA.setImageResource(2130839264);
        }
      }
      label421:
      paramInt2 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     umo
 * JD-Core Version:    0.7.0.1
 */