import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class jxu
  implements View.OnClickListener
{
  public jxu(VideoCoverView paramVideoCoverView) {}
  
  public void onClick(View paramView)
  {
    VideoCoverView.a(this.this$0, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jxu
 * JD-Core Version:    0.7.0.1
 */