import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aitk
  implements View.OnClickListener
{
  aitk(aitg paramaitg, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.b.apG()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareController", 2, "myBtn onClick: invoked. set my btn black");
      }
      aitg.a(this.b).setClickable(false);
      aitg.a(this.b).setImageDrawable(this.val$activity.getResources().getDrawable(2130841358));
      aitg.a(this.b).Lv(true);
      anot.a(null, "CliOper", "", "", "0X800A771", "0X800A771", 0, 0, "", "0", "0", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aitk
 * JD-Core Version:    0.7.0.1
 */