import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.cloudfile.FileShowListActivity;

public class atip
  implements View.OnClickListener
{
  public atip(FileShowListActivity paramFileShowListActivity) {}
  
  public void onClick(View paramView)
  {
    FileShowListActivity.a(this.a, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atip
 * JD-Core Version:    0.7.0.1
 */