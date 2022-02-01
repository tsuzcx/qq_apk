import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.share.QZoneShareActivity;

public class avzx
  implements View.OnClickListener
{
  public avzx(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.this$0.sa) {
      this.this$0.Et();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.this$0.showKeyboard();
      this.this$0.jb();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avzx
 * JD-Core Version:    0.7.0.1
 */