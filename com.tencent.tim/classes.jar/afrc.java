import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionBaseFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afrc
  implements View.OnClickListener
{
  public afrc(AIOEmotionBaseFragment paramAIOEmotionBaseFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.report("0X8009980");
    this.a.dbC();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afrc
 * JD-Core Version:    0.7.0.1
 */