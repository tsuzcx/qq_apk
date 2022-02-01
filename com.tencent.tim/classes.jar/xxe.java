import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xxe
  implements View.OnClickListener
{
  xxe(xwq paramxwq) {}
  
  public void onClick(View paramView)
  {
    wja.bcO = true;
    anot.a(this.a.app, "CliOper", "", "", "Two_call", "Clk_aio_right", 0, 0, String.valueOf(0), "", "", "");
    wmj.a(this.a.app, this.a.mActivity, this.a.sessionInfo, true, null, this.a);
    anot.b(this.a.app, "dc00899", "Qidian", "", "0X8008FEB", "qidianMasterVideo", 1, 1, 0, "2", "0", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xxe
 * JD-Core Version:    0.7.0.1
 */