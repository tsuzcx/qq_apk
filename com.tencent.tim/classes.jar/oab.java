import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class oab
  implements View.OnClickListener
{
  oab(nzx.a parama, nzx paramnzx) {}
  
  public void onClick(View paramView)
  {
    kbp.a(this.a.a.mApp, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B6F", "0X8005B6F", 0, 0, "", "", "", "", false);
    anot.a(this.a.a.mApp, "CliOper", "", "", "0X800642D", "0X800642D", 0, 0, "", "", "", "");
    vnj.d(this.a.a.mActivity, obt.a(this.a.a.mApp, this.a.a.mActivity), null, null);
    oac.c(this.a.a.mApp, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oab
 * JD-Core Version:    0.7.0.1
 */