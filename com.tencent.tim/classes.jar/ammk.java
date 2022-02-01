import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ammk
  implements View.OnClickListener
{
  ammk(ammh paramammh) {}
  
  public void onClick(View paramView)
  {
    this.a.b.PO(this.a.b.keyword);
    this.a.b.GZ.setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ammk
 * JD-Core Version:    0.7.0.1
 */