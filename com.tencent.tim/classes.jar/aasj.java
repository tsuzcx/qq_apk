import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.richmedia.QzoneSlideShowPreparingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aasj
  implements View.OnClickListener
{
  public aasj(QzoneSlideShowPreparingFragment paramQzoneSlideShowPreparingFragment) {}
  
  public void onClick(View paramView)
  {
    QzoneSlideShowPreparingFragment.a(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aasj
 * JD-Core Version:    0.7.0.1
 */