import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.cloudfile.CloudFileWeiYunActvitiy;

public class atib
  implements View.OnClickListener
{
  public atib(CloudFileWeiYunActvitiy paramCloudFileWeiYunActvitiy) {}
  
  public void onClick(View paramView)
  {
    if (this.a.akK()) {
      this.a.IP(false);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.IP(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atib
 * JD-Core Version:    0.7.0.1
 */