import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class mar
  implements View.OnClickListener
{
  mar(map parammap) {}
  
  public void onClick(View paramView)
  {
    kxm.a(this.a.context, ((lie)this.a.aN).a(), 2, false, 2, false);
    ndi.g(((lie)this.a.aN).a(), ((lie)this.a.aN).nh());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mar
 * JD-Core Version:    0.7.0.1
 */