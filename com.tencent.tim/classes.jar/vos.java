import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vos
  implements View.OnClickListener
{
  public vos(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    if (!aqiw.isNetSupport(this.a)) {
      this.a.bTu();
    }
    for (;;)
    {
      swb.report("see_streetview");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (aqiw.isWifiEnabled(this.a)) {
        this.a.bTq();
      } else {
        aqha.a(this.a, 230).setTitle(this.a.getString(2131690278)).setMessage(2131696658).setPositiveButton(2131691972, new vou(this)).setNegativeButton(2131721058, new vot(this)).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vos
 * JD-Core Version:    0.7.0.1
 */