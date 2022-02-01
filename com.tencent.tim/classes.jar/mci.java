import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderSubscribe;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class mci
  implements View.OnClickListener
{
  public mci(ComponentHeaderSubscribe paramComponentHeaderSubscribe) {}
  
  public void onClick(View paramView)
  {
    ComponentHeaderSubscribe.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mci
 * JD-Core Version:    0.7.0.1
 */