import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aahj
  implements View.OnClickListener
{
  aahj(aahb paramaahb, TipsBar paramTipsBar) {}
  
  public void onClick(View paramView)
  {
    if (!ahbj.isFileExists(agrt.a().vJ()))
    {
      agrt.a().stop();
      this.f.setVisibility(8);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.setType(10008);
      Intent localIntent = new Intent(aahb.a(this.this$0), FileBrowserActivity.class);
      localIntent.putExtra("fileinfo", localForwardFileInfo);
      aahb.a(this.this$0).startActivity(localIntent);
      ahau.JH("0X8004BFE");
      anot.c(aahb.a(this.this$0).app, "dc00898", "", "", "0X8009EE5", "0X8009EE5", 2, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aahj
 * JD-Core Version:    0.7.0.1
 */