import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class agbe
  implements View.OnClickListener
{
  public agbe(BaseFileAssistantActivity paramBaseFileAssistantActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.deO();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agbe
 * JD-Core Version:    0.7.0.1
 */