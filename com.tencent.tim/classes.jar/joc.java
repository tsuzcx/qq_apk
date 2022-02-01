import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.addContactTroopView.TroopCardPopClassfic;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class joc
  implements View.OnClickListener
{
  joc(job paramjob, int paramInt) {}
  
  public void onClick(View paramView)
  {
    TroopCardPopClassfic.a(this.a.a, this.val$i);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     joc
 * JD-Core Version:    0.7.0.1
 */