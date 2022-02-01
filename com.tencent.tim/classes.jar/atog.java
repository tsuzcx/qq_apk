import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.activity.FilePreviewActivity;

public class atog
  implements View.OnClickListener
{
  public atog(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void onClick(View paramView)
  {
    anot.a(this.this$0.app, "CliOper", "", "", "0X8008A32", "0X8008A32", 0, 0, "", "", "", "");
    FilePreviewActivity.a(this.this$0, aukp.a(this.this$0.app, FilePreviewActivity.a(this.this$0), this.this$0, "<FileAssistant>FilePreviewActivity", this.this$0.getString(2131720933), false));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atog
 * JD-Core Version:    0.7.0.1
 */