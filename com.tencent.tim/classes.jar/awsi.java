import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;

public class awsi
  implements View.OnClickListener
{
  public awsi(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit) {}
  
  public void onClick(View paramView)
  {
    this.this$0.aNA();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awsi
 * JD-Core Version:    0.7.0.1
 */