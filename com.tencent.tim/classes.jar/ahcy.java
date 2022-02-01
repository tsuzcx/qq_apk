import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahcy
  implements View.OnClickListener
{
  public ahcy(NoFileRelativeLayout paramNoFileRelativeLayout) {}
  
  public void onClick(View paramView)
  {
    aobw.q((Activity)this.c.getContext(), "s_qq_myfile_yindao", -1);
    if ((this.c.getContext() instanceof FMActivity)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.c.getContext() instanceof FileAssistantActivity)) {
        anot.a(((FileAssistantActivity)this.c.getContext()).app, "dc00898", "", "", "0X800A226", "0X800A226", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahcy
 * JD-Core Version:    0.7.0.1
 */