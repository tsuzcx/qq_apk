import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneLiveVideoBaseDownLoadActivty;

public class avqe
  implements View.OnClickListener
{
  public avqe(QZoneLiveVideoBaseDownLoadActivty paramQZoneLiveVideoBaseDownLoadActivty) {}
  
  public void onClick(View paramView)
  {
    this.a.mIsCanceled = true;
    this.a.cancelInstall();
    this.a.cw();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avqe
 * JD-Core Version:    0.7.0.1
 */