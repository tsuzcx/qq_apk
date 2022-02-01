import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ltb
  implements View.OnClickListener
{
  ltb(lta paramlta) {}
  
  public void onClick(View paramView)
  {
    nen.aQ((Activity)lta.a(this.b).getContext());
    nen.tt(2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ltb
 * JD-Core Version:    0.7.0.1
 */