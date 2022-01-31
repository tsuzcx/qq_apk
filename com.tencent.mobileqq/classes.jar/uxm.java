import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder;
import com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder.FlashPicHolder;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;

public class uxm
  implements View.OnClickListener
{
  public uxm(FlashPicItemBuilder paramFlashPicItemBuilder) {}
  
  public void onClick(View paramView)
  {
    long l = SystemClock.uptimeMillis();
    if (l - FlashPicItemBuilder.a(this.a) < 800L) {}
    FlashPicItemBuilder.FlashPicHolder localFlashPicHolder;
    label169:
    for (;;)
    {
      return;
      FlashPicItemBuilder.a(this.a, l);
      localFlashPicHolder = (FlashPicItemBuilder.FlashPicHolder)AIOUtils.a(paramView);
      if (localFlashPicHolder != null)
      {
        Object localObject2 = localFlashPicHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        Object localObject1 = null;
        paramView = localObject1;
        if (localObject2 != null)
        {
          localObject2 = this.a.a.a().a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq);
          paramView = localObject1;
          if ((localObject2 instanceof MessageForPic)) {
            paramView = (MessageForPic)localObject2;
          }
        }
        if (paramView != null)
        {
          if (HotChatHelper.a(paramView)) {}
          for (boolean bool = HotChatHelper.b(paramView);; bool = FlashPicHelper.b(paramView))
          {
            if (bool) {
              break label169;
            }
            if (localFlashPicHolder.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 0) {
              break label171;
            }
            if (localFlashPicHolder.jdField_a_of_type_ComTencentImageURLDrawable.isDownloadStarted()) {
              break;
            }
            localFlashPicHolder.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
            return;
          }
        }
      }
    }
    label171:
    FlashPicItemBuilder.a(this.a, paramView, localFlashPicHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder$FlashPicAIOThumbView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uxm
 * JD-Core Version:    0.7.0.1
 */