import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ammj
  implements View.OnClickListener
{
  ammj(ammh paramammh) {}
  
  public void onClick(View paramView)
  {
    this.a.b.PO(this.a.b.keyword);
    this.a.b.GY.setVisibility(0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ammj
 * JD-Core Version:    0.7.0.1
 */