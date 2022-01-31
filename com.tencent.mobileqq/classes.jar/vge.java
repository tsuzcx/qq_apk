import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;

public class vge
  implements View.OnClickListener
{
  public vge(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder.c != 0L) && (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder.c <= 500L)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder.c = System.currentTimeMillis();
    RedBagVideoManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a((Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder.a);
    FlowCameraMqqAction.b("", "0X8008CEB");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vge
 * JD-Core Version:    0.7.0.1
 */