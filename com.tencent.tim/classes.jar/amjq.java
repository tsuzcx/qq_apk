import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView.c;

class amjq
  implements View.OnClickListener
{
  amjq(amjp paramamjp) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(-1)).intValue();
    amjp.a(this.this$0).onItemClick(this.this$0.R, paramView, i, 0L);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amjq
 * JD-Core Version:    0.7.0.1
 */