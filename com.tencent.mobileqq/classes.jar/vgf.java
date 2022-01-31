import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.dancegame.DanceGameVideoManager;
import com.tencent.qphone.base.util.QLog;

public class vgf
  implements View.OnClickListener
{
  public vgf(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder, boolean paramBoolean1, boolean paramBoolean2, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder.c != 0L) && (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder.c <= 300L)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder.c = System.currentTimeMillis();
    if ((this.jdField_a_of_type_Boolean) && (this.b))
    {
      DanceGameVideoManager.a().a((Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      return;
    }
    QLog.d("ShortVideoRealItemBuilder", 1, String.format("not support dance Pendant, codec[%s], entry[%s]", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.b) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vgf
 * JD-Core Version:    0.7.0.1
 */