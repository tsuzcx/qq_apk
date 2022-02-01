import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.activity.FilePreviewActivity;

public class atoe
  implements View.OnClickListener
{
  public atoe(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.setResult(0, new Intent());
    this.this$0.finish();
    this.this$0.overridePendingTransition(2130771989, 2130771990);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atoe
 * JD-Core Version:    0.7.0.1
 */