import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aodl
  implements View.OnClickListener
{
  aodl(aodk paramaodk) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof aodg.a))
    {
      aodg.a locala = (aodg.a)paramView.getTag();
      if ((this.a.onClickListener != null) && (locala.b.isClickable())) {
        this.a.onClickListener.onClick(paramView);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aodl
 * JD-Core Version:    0.7.0.1
 */