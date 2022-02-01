import android.content.res.Resources;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.activity.EditInfoActivity.8.1;
import com.tencent.mobileqq.activity.EditInfoActivity.8.2;
import com.tencent.mobileqq.widget.ColorClearableEditText;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;

public class uwf
  implements TextWatcher
{
  public uwf(EditInfoActivity paramEditInfoActivity, EditText paramEditText) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramCharSequence == null) || (paramCharSequence.toString().trim().length() == 0))
    {
      this.this$0.aMT = ("" + this.this$0.bGH);
      if ((this.this$0.aA instanceof ColorClearableEditText))
      {
        paramCharSequence = (ColorClearableEditText)this.this$0.aA;
        paramCharSequence.setTextColor(this.this$0.getResources().getColor(2131167398));
        paramCharSequence.setSpecialColor(0, null, null, 0, null);
      }
      this.this$0.mHandler.post(new EditInfoActivity.8.1(this));
    }
    label396:
    label415:
    label470:
    label483:
    for (;;)
    {
      return;
      try
      {
        if (this.this$0.bGJ != 0) {
          break label415;
        }
        if (!this.this$0.aVN) {
          break label396;
        }
        paramInt1 = EditInfoActivity.a(this.this$0);
        paramInt2 = paramInt1;
        if (this.this$0.bGK != 1) {
          break label254;
        }
        paramInt2 = paramInt1;
        if (paramInt1 <= this.this$0.bGH) {
          break label254;
        }
        boolean bool = paramCharSequence instanceof Editable;
        paramInt2 = paramInt1;
        if (!bool) {
          break label254;
        }
        paramInt2 = paramInt1;
      }
      catch (UnsupportedEncodingException paramCharSequence)
      {
        for (;;)
        {
          try
          {
            aofy.g(this.aB);
            if (this.this$0.bGJ == 0) {
              if (this.this$0.aVN) {
                paramInt1 = EditInfoActivity.a(this.this$0);
              }
            }
          }
          catch (Throwable paramCharSequence)
          {
            label254:
            paramInt1 = paramInt3;
          }
          try
          {
            i = this.this$0.bGH;
            paramInt2 = paramInt1;
            if (paramInt1 > i)
            {
              paramInt2 = paramInt1;
              if (paramInt3 <= paramInt1) {
                paramInt2 = paramInt1;
              }
            }
            else
            {
              this.this$0.aMT = ("" + (this.this$0.bGH - paramInt2));
              if (this.this$0.aMT.length() > 4) {
                this.this$0.aMT = (this.this$0.aMT.substring(0, 2) + "…");
              }
              this.this$0.mHandler.post(new EditInfoActivity.8.2(this, paramInt2));
              return;
            }
          }
          catch (Throwable paramCharSequence)
          {
            break label470;
          }
        }
        paramCharSequence = paramCharSequence;
      }
      paramInt3 = paramInt2;
      for (;;)
      {
        int i;
        if (!QLog.isColorLevel()) {
          break label483;
        }
        QLog.d("EditInfoActivity", 2, "UnsupportedEncodingException" + paramCharSequence.getMessage());
        return;
        paramInt1 = paramCharSequence.toString().trim().getBytes("utf-8").length;
        break;
        paramInt1 = paramCharSequence.toString().trim().length();
        break;
        paramInt1 = paramCharSequence.toString().trim().getBytes("utf-8").length;
        continue;
        paramInt1 = paramCharSequence.toString().trim().length();
        continue;
        QLog.i("EditInfoActivity", 1, paramCharSequence.toString());
        paramInt2 = paramInt1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uwf
 * JD-Core Version:    0.7.0.1
 */