import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;

public class avvq
  implements View.OnClickListener
{
  public avvq(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin) {}
  
  public void onClick(View paramView)
  {
    QzoneWebMusicJsPlugin.access$300(this.this$0, "buttonclick");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avvq
 * JD-Core Version:    0.7.0.1
 */