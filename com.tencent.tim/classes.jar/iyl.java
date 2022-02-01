import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class iyl
  implements View.OnClickListener
{
  public iyl(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void onClick(View paramView)
  {
    QLog.d(this.this$0.TAG, 1, "quit double screen from reset clicker");
    if ((this.this$0.mContext != null) && (this.this$0.mContext.get() != null) && ((this.this$0.mContext.get() instanceof AVActivity))) {
      ((AVActivity)this.this$0.mContext.get()).BtnOnClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iyl
 * JD-Core Version:    0.7.0.1
 */