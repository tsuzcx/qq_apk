import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder.TribeShortVideoMsgHolder;

public class vje
  implements View.OnClickListener
{
  public vje(TribeShortVideoItemBuilder paramTribeShortVideoItemBuilder) {}
  
  public void onClick(View paramView)
  {
    TribeShortVideoItemBuilder.TribeShortVideoMsgHolder localTribeShortVideoMsgHolder = (TribeShortVideoItemBuilder.TribeShortVideoMsgHolder)AIOUtils.a(paramView);
    if (paramView == localTribeShortVideoMsgHolder.jdField_a_of_type_AndroidWidgetFrameLayout) {
      this.a.b(localTribeShortVideoMsgHolder);
    }
    while (paramView != localTribeShortVideoMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout) {
      return;
    }
    this.a.a(localTribeShortVideoMsgHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vje
 * JD-Core Version:    0.7.0.1
 */