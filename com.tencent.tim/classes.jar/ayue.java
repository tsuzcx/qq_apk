import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZLog;

class ayue
  implements View.OnClickListener
{
  ayue(ayud paramayud) {}
  
  public void onClick(View paramView)
  {
    QZLog.d("QzoneEditPicturePartSav", 2, "onClick save button");
    this.b.b.changeState(19);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayue
 * JD-Core Version:    0.7.0.1
 */