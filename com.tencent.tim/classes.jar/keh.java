import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class keh
  implements View.OnClickListener
{
  keh(keg paramkeg, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      this.a.a.aG(this.a.mContext, this.YH);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     keh
 * JD-Core Version:    0.7.0.1
 */