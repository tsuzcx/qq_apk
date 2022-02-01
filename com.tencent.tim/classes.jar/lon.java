import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class lon
  implements View.OnClickListener
{
  lon(lom paramlom, Container paramContainer, lie paramlie, int paramInt) {}
  
  public void onClick(View paramView)
  {
    lom.a(this.a, this.c.getContext(), this.b, this.val$position);
    if (QLog.isColorLevel()) {
      QLog.d("PgcProteusItem", 2, "click bottom bar for jumping to gallery articleinfo = " + this.b.a() + " position = " + this.val$position);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lon
 * JD-Core Version:    0.7.0.1
 */