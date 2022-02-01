import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class jxt
  implements View.OnClickListener
{
  public jxt(VideoCoverView paramVideoCoverView, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    this.this$0.bJ(this.val$context);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jxt
 * JD-Core Version:    0.7.0.1
 */