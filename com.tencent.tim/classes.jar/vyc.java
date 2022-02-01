import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vyc
  implements View.OnClickListener
{
  public vyc(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.isFinishing()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.this$0.baU = false;
      if (this.this$0.b != null)
      {
        this.this$0.b.FX(4);
        this.this$0.bWu();
        this.this$0.bOm();
      }
      if (aizp.a().aqf()) {
        aizp.a().dl(this.this$0.app);
      }
      TroopAssistantActivity.b(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vyc
 * JD-Core Version:    0.7.0.1
 */