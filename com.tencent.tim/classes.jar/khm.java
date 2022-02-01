import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;

public class khm
  implements afmf
{
  public khm(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity) {}
  
  public void a(afmi paramafmi)
  {
    if ((paramafmi instanceof afpu))
    {
      paramafmi = (afpu)paramafmi;
      if ((this.this$0 instanceof ReadInJoyDeliverUGCActivity)) {
        ((ReadInJoyDeliverUGCActivity)this.this$0).a(paramafmi);
      }
      return;
    }
    ReadInJoyBaseDeliverActivity.a(this.this$0.app, paramafmi, this.this$0.N);
  }
  
  public void a(afmi paramafmi1, afmi paramafmi2, Drawable paramDrawable) {}
  
  public boolean a(afmi paramafmi)
  {
    return true;
  }
  
  public void b(afmi paramafmi) {}
  
  public void delete()
  {
    if (this.this$0.N.getSelectionStart() == 0) {}
    for (;;)
    {
      return;
      try
      {
        Editable localEditable = this.this$0.N.getText();
        int i = this.this$0.N.getSelectionStart();
        int j = TextUtils.getOffsetBefore(this.this$0.N.getText(), i);
        if (i != j)
        {
          localEditable.delete(Math.min(i, j), Math.max(i, j));
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void gq() {}
  
  public void send() {}
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     khm
 * JD-Core Version:    0.7.0.1
 */