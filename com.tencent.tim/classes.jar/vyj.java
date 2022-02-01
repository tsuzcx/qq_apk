import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class vyj
  implements View.OnClickListener
{
  public vyj(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void onClick(View paramView)
  {
    int i = 0;
    if ((this.this$0.rk == null) || (this.this$0.rk.size() == 0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      anot.a(this.this$0.app, "dc00899", "Grp_msg", "", "helper-guide", "Clk_confirm", 0, 0, "", "", "", "");
      this.this$0.a = ((aqlz)this.this$0.app.getManager(31));
      this.this$0.dD.setCompoundDrawablesWithIntrinsicBounds(2130839651, 0, 0, 0);
      while (i < this.this$0.rk.size())
      {
        String str = String.valueOf(this.this$0.rk.get(i));
        this.this$0.cr(str, 4);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vyj
 * JD-Core Version:    0.7.0.1
 */