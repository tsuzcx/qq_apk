import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class nsa
  implements View.OnClickListener
{
  nsa(nrz paramnrz) {}
  
  public void onClick(View paramView)
  {
    nrz.a(this.b).e(nrz.a(this.b), nrz.a(this.b));
    this.b.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nsa
 * JD-Core Version:    0.7.0.1
 */