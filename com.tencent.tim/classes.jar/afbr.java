import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.mobileqq.datareportviewer.DataReportViewer;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class afbr
  implements View.OnClickListener
{
  afbr(afbo paramafbo, WindowManager paramWindowManager) {}
  
  public void onClick(View paramView)
  {
    this.b.removeViewImmediate(this.a.this$0.jP);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afbr
 * JD-Core Version:    0.7.0.1
 */