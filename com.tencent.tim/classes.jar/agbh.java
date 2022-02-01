import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class agbh
  implements View.OnClickListener
{
  public agbh(FMActivity paramFMActivity) {}
  
  public void onClick(View paramView)
  {
    FMActivity.c(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agbh
 * JD-Core Version:    0.7.0.1
 */