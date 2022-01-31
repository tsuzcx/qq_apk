import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder.Holder;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.lightReply.LightReplyMenuManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakUtils;
import mqq.os.MqqHandler;

public class uzp
  implements Runnable
{
  public uzp(PicItemBuilder paramPicItemBuilder, MessageForPic paramMessageForPic, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, PicItemBuilder.Holder paramHolder) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.checkIsGIF();
      LightReplyMenuManager localLightReplyMenuManager = LightReplyMenuManager.a();
      if ((!this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.isSend()) && (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.isDui) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPicItemBuilder.a.a == 1) && (localLightReplyMenuManager != null) && (localLightReplyMenuManager.d()) && (localLightReplyMenuManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic)) && (!PeakUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.imageType))) {}
      for (boolean bool = true;; bool = false)
      {
        ThreadManager.getUIHandler().post(new uzq(this, bool));
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PicItemBuilder", 1, "checkIsGIF exception :", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uzp
 * JD-Core Version:    0.7.0.1
 */