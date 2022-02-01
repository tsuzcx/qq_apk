import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ptv.BaseButton;
import dov.com.qq.im.ptv.LightWeightCaptureButtonLayout;
import dov.com.qq.im.ptv.LightWeightProgress;

class aybn
  implements View.OnClickListener
{
  aybn(aybl paramaybl) {}
  
  public void onClick(View paramView)
  {
    this.a.this$0.b.setStatus(true);
    this.a.this$0.a.setScaleX(1.0F);
    this.a.this$0.a.setScaleY(1.0F);
    this.a.this$0.ePV();
    ainc.dsX();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aybn
 * JD-Core Version:    0.7.0.1
 */