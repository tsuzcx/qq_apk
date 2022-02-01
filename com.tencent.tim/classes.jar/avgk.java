import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.plugin.PluginIphoneTitleBarActivity;

public class avgk
  implements View.OnClickListener
{
  public avgk(PluginIphoneTitleBarActivity paramPluginIphoneTitleBarActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.onBackEvent();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avgk
 * JD-Core Version:    0.7.0.1
 */