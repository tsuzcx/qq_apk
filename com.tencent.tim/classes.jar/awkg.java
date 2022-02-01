import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.troop_homework.outer.TroopHWRecordBaseActivity;

public class awkg
  implements View.OnClickListener
{
  public awkg(TroopHWRecordBaseActivity paramTroopHWRecordBaseActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!this.a.cQC)
      {
        this.a.setResult(0);
        this.a.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awkg
 * JD-Core Version:    0.7.0.1
 */