import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public class aazv
  extends avkd
{
  public aazv(ShortVideoPlayActivity paramShortVideoPlayActivity, Activity paramActivity, avkd.a parama, int paramInt1, int paramInt2, AppRuntime paramAppRuntime)
  {
    super(paramActivity, parama, paramInt1, paramInt2, paramAppRuntime);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aazv
 * JD-Core Version:    0.7.0.1
 */