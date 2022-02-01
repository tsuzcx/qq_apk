import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.QavPanel.d;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class jcv
  implements View.OnClickListener
{
  public jcv(QavPanel paramQavPanel) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.a != null) && (this.this$0.a.a != null)) {
      this.this$0.a.a.iB(true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jcv
 * JD-Core Version:    0.7.0.1
 */