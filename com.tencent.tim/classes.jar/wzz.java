import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.mobileqq.activity.aio.item.ArkAppView.a;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import java.lang.ref.WeakReference;

class wzz
  implements ArkAppView.a
{
  wzz(wzx paramwzx, MessageForArkFlashChat paramMessageForArkFlashChat) {}
  
  public void bCR() {}
  
  public void loadSucc()
  {
    AutoStartProgressBar localAutoStartProgressBar = (AutoStartProgressBar)this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat.mSendingProgress.get();
    if ((localAutoStartProgressBar.getTag() == this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat) && (localAutoStartProgressBar != null))
    {
      localAutoStartProgressBar.bwe();
      localAutoStartProgressBar.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wzz
 * JD-Core Version:    0.7.0.1
 */