import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.service.message.MessageCache;

public final class xbi
  implements Runnable
{
  public xbi(MessageRecord paramMessageRecord, String paramString, int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle) {}
  
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject == null) {
        return;
      }
      UniteGrayTipParam localUniteGrayTipParam = new UniteGrayTipParam(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, ((QQAppInterface)localObject).getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_Int, 3145729, MessageCache.a());
      if ((this.b >= 0) && (this.c > this.b) && (this.jdField_a_of_type_AndroidOsBundle != null)) {
        localUniteGrayTipParam.a(this.b, this.c, this.jdField_a_of_type_AndroidOsBundle);
      }
      MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
      localMessageForUniteGrayTip.initGrayTipMsg((QQAppInterface)localObject, localUniteGrayTipParam);
      UniteGrayTipUtil.a((QQAppInterface)localObject, localMessageForUniteGrayTip);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xbi
 * JD-Core Version:    0.7.0.1
 */