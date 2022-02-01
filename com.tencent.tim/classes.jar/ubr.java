import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.TMG.utils.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ubr
  implements View.OnClickListener
{
  ubr(ubp paramubp, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.cS == null) {
      QLog.e("SdkAuthDialog", 1, "negativeListener is null");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.cS.onClick(paramView);
      anot.a(null, "dc00898", "", "", "0X8009F79", "0X8009F79", 0, 0, "2", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ubr
 * JD-Core Version:    0.7.0.1
 */