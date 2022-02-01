import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class xnb
  implements View.OnClickListener
{
  public xnb(ShortVideoItemBuilder paramShortVideoItemBuilder) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof MessageForShortVideo))
    {
      localObject = (MessageForShortVideo)localObject;
      anfy.w(paramView.getContext(), this.this$0.sessionInfo.aTl, ((MessageForShortVideo)localObject).msgTailType);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xnb
 * JD-Core Version:    0.7.0.1
 */