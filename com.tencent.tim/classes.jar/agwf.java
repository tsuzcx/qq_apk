import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agwf
  implements View.OnClickListener
{
  agwf(agwc paramagwc) {}
  
  public void onClick(View paramView)
  {
    ahav.F(this.b.mContext, this.b.a.getFilePath());
    this.b.cfn = true;
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agwf
 * JD-Core Version:    0.7.0.1
 */