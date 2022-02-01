import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.ui.GAudioMembersCtrlActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class izj
  implements View.OnClickListener
{
  public izj(GAudioMembersCtrlActivity paramGAudioMembersCtrlActivity, ausj paramausj) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    if (this.this$0.a.b().QI) {
      if (this.this$0.a.b().uinType == 1) {
        anot.a(null, "CliOper", "", "", "0X8005C28", "0X8005C28", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      if (!this.this$0.a.b().QI) {
        bool = true;
      }
      this.this$0.a.G(bool);
      this.this$0.a.b().Q("OnClick", bool);
      this.this$0.asP();
      this.this$0.asR();
      try
      {
        this.c.dismiss();
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (this.this$0.a.b().uinType != 3000) {
          continue;
        }
        anot.a(null, "CliOper", "", "", "0X8005C23", "0X8005C23", 0, 0, "", "", "", "");
        continue;
        if (this.this$0.a.b().uinType == 1)
        {
          anot.a(null, "CliOper", "", "", "0X8005C27", "0X8005C27", 0, 0, "", "", "", "");
          continue;
        }
        if (this.this$0.a.b().uinType != 3000) {
          continue;
        }
        anot.a(null, "CliOper", "", "", "0X8005C22", "0X8005C22", 0, 0, "", "", "", "");
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     izj
 * JD-Core Version:    0.7.0.1
 */