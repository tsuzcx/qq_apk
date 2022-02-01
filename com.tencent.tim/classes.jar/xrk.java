import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xrk
  implements View.OnClickListener
{
  xrk(xrh paramxrh) {}
  
  public void onClick(View paramView)
  {
    if (xrh.a(this.b) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NavigateBarManager", 2, String.format("onClick barId: %s", new Object[] { Integer.valueOf(xrh.a(this.b).id) }));
      }
      xrg localxrg = xrh.a(this.b);
      xrh.a(this.b);
      if (localxrg != null) {
        localxrg.onClick();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xrk
 * JD-Core Version:    0.7.0.1
 */