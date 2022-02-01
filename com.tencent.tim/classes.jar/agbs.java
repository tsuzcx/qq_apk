import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class agbs
  implements View.OnClickListener
{
  public agbs(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.setResult(0, new Intent());
    this.this$0.finish();
    this.this$0.overridePendingTransition(2130771989, 2130771990);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agbs
 * JD-Core Version:    0.7.0.1
 */