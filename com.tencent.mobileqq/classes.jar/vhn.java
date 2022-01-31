import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.UiCallBack.DownAdapter;
import com.tencent.qphone.base.util.QLog;

public class vhn
  extends UiCallBack.DownAdapter
{
  public vhn(PicItemBuilder paramPicItemBuilder, BaseChatItemLayout paramBaseChatItemLayout) {}
  
  public void a(int paramInt, PicResult paramPicResult)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
    if (QLog.isColorLevel()) {
      QLog.d("PicItemBuilder", 2, "2g diy gif onDownload");
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicItemBuilder", 2, "2g diy gif onUpdateProgress");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vhn
 * JD-Core Version:    0.7.0.1
 */