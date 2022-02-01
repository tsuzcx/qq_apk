import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.fileviewer.FileBrowserActivity;

public class atxe
  implements View.OnClickListener
{
  public atxe(FileBrowserActivity paramFileBrowserActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.euE();
    atvp.n(this.this$0.app.getApp(), this.this$0.app.getCurrentAccountUin(), "WpsFileEditGuideTipsCount", 3);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atxe
 * JD-Core Version:    0.7.0.1
 */