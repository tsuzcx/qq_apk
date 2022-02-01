import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.datareportviewer.DataReportViewer;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afbn
  implements CompoundButton.OnCheckedChangeListener
{
  public afbn(DataReportViewer paramDataReportViewer) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.this$0.bXc = paramBoolean;
    if (this.this$0.bXc) {
      this.this$0.cYm();
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afbn
 * JD-Core Version:    0.7.0.1
 */