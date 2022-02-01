import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.ar.view.ARScanEntryView;
import com.tencent.mobileqq.ar.view.ARScanEntryView.26;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adlg
  implements View.OnClickListener
{
  public adlg(ARScanEntryView.26 param26) {}
  
  public void onClick(View paramView)
  {
    if (this.a.e != null) {
      this.a.e.a(this.a.b);
    }
    ARScanEntryView.g(this.a.this$0);
    ARScanEntryView.d(this.a.this$0);
    this.a.this$0.bv.setOnClickListener(this.a.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adlg
 * JD-Core Version:    0.7.0.1
 */