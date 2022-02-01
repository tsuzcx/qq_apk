import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ubq
  implements View.OnClickListener
{
  ubq(ubp paramubp, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (!aqiw.isNetSupport(ubp.a(this.b))) {
      QQToast.a(ubp.a(this.b), ubp.a(this.b).getString(2131696270), 0).show();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.cS == null)
      {
        QLog.e("SdkAuthDialog", 1, "positiveListener is null");
      }
      else
      {
        this.cS.onClick(paramView);
        anot.a(null, "dc00898", "", "", "0X8009F79", "0X8009F79", 0, 0, "0", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ubq
 * JD-Core Version:    0.7.0.1
 */