import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder.QQStoryMsgHolder;

public class vdm
  implements View.OnClickListener
{
  public vdm(QQStoryItemBuilder paramQQStoryItemBuilder) {}
  
  public void onClick(View paramView)
  {
    QQStoryItemBuilder.QQStoryMsgHolder localQQStoryMsgHolder = (QQStoryItemBuilder.QQStoryMsgHolder)AIOUtils.a(paramView);
    if (paramView == localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetFrameLayout) {
      this.a.b(localQQStoryMsgHolder);
    }
    while (paramView != localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout) {
      return;
    }
    this.a.a(localQQStoryMsgHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vdm
 * JD-Core Version:    0.7.0.1
 */