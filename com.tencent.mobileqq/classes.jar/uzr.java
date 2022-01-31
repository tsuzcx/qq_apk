import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder.Holder;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class uzr
  implements URLDrawable.URLDrawableListener
{
  public uzr(PicItemBuilder paramPicItemBuilder, URL paramURL, BaseChatItemLayout paramBaseChatItemLayout, MessageForPic paramMessageForPic, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, PicItemBuilder.Holder paramHolder) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && (paramURLDrawable.getURL() != null) && (paramURLDrawable.getURL().equals(this.jdField_a_of_type_JavaNetURL))) {
      PicItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPicItemBuilder, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPicItemBuilder$Holder);
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if ((paramURLDrawable != null) && (paramURLDrawable.getURL() != null) && (paramURLDrawable.getURL().equals(this.jdField_a_of_type_JavaNetURL))) {
      PicItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPicItemBuilder, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPicItemBuilder$Holder);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && (paramURLDrawable.getURL() != null) && (paramURLDrawable.getURL().equals(this.jdField_a_of_type_JavaNetURL))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPicItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, this.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPicItemBuilder$Holder);
    }
    if (QLog.isColorLevel()) {
      QLog.e("PicItemBuilder", 2, "on loadsucceed ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uzr
 * JD-Core Version:    0.7.0.1
 */