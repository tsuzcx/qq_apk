import android.text.Editable;
import android.text.TextUtils;
import com.tencent.mobileqq.tribe.view.TEditText;
import com.tencent.mobileqq.tribe.view.TEditText.a;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;

public class aout
  implements TEditText.a
{
  public aout(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void onSelectionChanged(int paramInt1, int paramInt2)
  {
    int k = 1;
    if (this.this$0.b.getText().length() <= 0) {}
    for (;;)
    {
      return;
      if (paramInt1 < 0)
      {
        if (paramInt2 > this.this$0.cnf.length() + 1) {}
        for (;;)
        {
          this.this$0.b.setSelection(paramInt2);
          return;
          paramInt2 = this.this$0.cnf.length() + 1;
        }
      }
      if (paramInt2 < 0)
      {
        if (paramInt1 > this.this$0.cnf.length() + 1) {}
        for (;;)
        {
          this.this$0.b.setSelection(paramInt1);
          return;
          paramInt1 = this.this$0.cnf.length() + 1;
        }
      }
      if (!TextUtils.isEmpty(this.this$0.cnf))
      {
        int i = 0;
        int j = paramInt1;
        if (paramInt1 < this.this$0.cnf.length() + 1)
        {
          j = this.this$0.cnf.length() + 1;
          i = 1;
        }
        if (paramInt2 < this.this$0.cnf.length() + 1) {
          paramInt2 = this.this$0.cnf.length() + 1;
        }
        for (paramInt1 = k; paramInt1 != 0; paramInt1 = i)
        {
          this.this$0.b.setSelection(j, paramInt2);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aout
 * JD-Core Version:    0.7.0.1
 */