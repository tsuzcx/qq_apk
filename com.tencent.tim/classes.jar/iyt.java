import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class iyt
  implements View.OnClickListener
{
  iyt(iyr paramiyr) {}
  
  public void onClick(View paramView)
  {
    this.this$0.mApp.b().b().Rg = true;
    jll.u(this.this$0.mApp);
    iyr.b(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iyt
 * JD-Core Version:    0.7.0.1
 */