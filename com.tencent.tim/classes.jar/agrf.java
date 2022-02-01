import android.app.Activity;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tbs.reader.TbsReaderView;

class agrf
  implements View.OnClickListener
{
  agrf(agre paramagre, int paramInt) {}
  
  public void onClick(View paramView)
  {
    int i;
    if (this.cYI == 5018)
    {
      Display localDisplay = this.a.val$activity.getWindowManager().getDefaultDisplay();
      if (localDisplay.getWidth() > localDisplay.getHeight())
      {
        i = 0;
        if (i == 0) {
          break label67;
        }
        this.a.val$activity.setRequestedOrientation(0);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 1;
      break;
      label67:
      this.a.val$activity.setRequestedOrientation(1);
      continue;
      agrd.a(this.a.b).doCommand(Integer.valueOf(this.cYI), null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agrf
 * JD-Core Version:    0.7.0.1
 */