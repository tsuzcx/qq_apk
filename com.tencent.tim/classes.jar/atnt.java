import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.activity.BaseFileAssistantActivity;

public class atnt
  implements View.OnClickListener
{
  public atnt(BaseFileAssistantActivity paramBaseFileAssistantActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.eum();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atnt
 * JD-Core Version:    0.7.0.1
 */