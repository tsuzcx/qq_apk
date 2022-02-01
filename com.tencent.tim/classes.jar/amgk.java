import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class amgk
  implements View.OnClickListener
{
  public amgk(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  public void onClick(View paramView)
  {
    String str = (String)paramView.getTag();
    if (SignatureHistoryFragment.a(this.this$0).contains(str))
    {
      SignatureHistoryFragment.a(this.this$0).remove(str);
      ((CheckBox)paramView).setChecked(false);
    }
    for (;;)
    {
      SignatureHistoryFragment.b(this.this$0, false);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (SignatureHistoryFragment.a(this.this$0).size() >= 200)
      {
        this.this$0.ba(1, 2131720328);
        ((CheckBox)paramView).setChecked(false);
      }
      else
      {
        SignatureHistoryFragment.a(this.this$0).add(str);
        ((CheckBox)paramView).setChecked(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amgk
 * JD-Core Version:    0.7.0.1
 */