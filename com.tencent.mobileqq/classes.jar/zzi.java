import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zzi
  implements View.OnClickListener
{
  zzi(zzf paramzzf) {}
  
  public void onClick(View paramView)
  {
    zzf.b(this.a).setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zzi
 * JD-Core Version:    0.7.0.1
 */