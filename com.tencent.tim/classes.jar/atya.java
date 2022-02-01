import android.app.Activity;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tbs.reader.TbsReaderView;

class atya
  implements View.OnClickListener
{
  atya(atxz paramatxz, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.cYI == 5018)
    {
      Display localDisplay = this.a.val$activity.getWindowManager().getDefaultDisplay();
      if (localDisplay.getWidth() <= localDisplay.getHeight()) {}
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      atxy.a(this.a.this$0).doCommand(Integer.valueOf(this.cYI), null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atya
 * JD-Core Version:    0.7.0.1
 */