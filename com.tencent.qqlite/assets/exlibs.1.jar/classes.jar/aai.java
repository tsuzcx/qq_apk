import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.QQOperateTips;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aai
  extends ConfigObserver
{
  public aai(BaseChatPie paramBaseChatPie) {}
  
  protected void a(String paramString, int paramInt, ArrayList paramArrayList)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQOperateVoIP", 4, "on showTips, chatactivity upadte ui");
    }
    if ((!this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString)) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != paramInt)) {
      if (QLog.isDevelopLevel()) {
        QLog.d("QQOperateVoIP", 4, "on showTips, uin dosenot equal");
      }
    }
    do
    {
      do
      {
        return;
        if ((paramArrayList != null) && (paramArrayList.size() != 0)) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.d("QQOperateVoIP", 4, "on showTips,tasklist is null");
      return;
    } while (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips == null);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips.a(paramArrayList);
  }
  
  protected void a(boolean paramBoolean, AppShareID paramAppShareID)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aai
 * JD-Core Version:    0.7.0.1
 */