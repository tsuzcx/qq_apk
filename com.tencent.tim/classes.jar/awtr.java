import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.AEPituCameraUnit.13;

public class awtr
  implements View.OnClickListener
{
  public awtr(AEPituCameraUnit.13 param13) {}
  
  public void onClick(View paramView)
  {
    if (awtq.a(this.a.this$0) != null) {
      awtq.a(this.a.this$0).dLp();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awtr
 * JD-Core Version:    0.7.0.1
 */