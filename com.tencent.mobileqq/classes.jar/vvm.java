import android.os.Message;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class vvm
  extends MqqHandler
{
  public vvm(MultiForwardChatPie paramMultiForwardChatPie) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
      } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof List)));
      this.a.b = ((List)paramMessage.obj);
      if ((this.a.b == null) || (this.a.b.size() == 0))
      {
        MultiForwardChatPie.a(this.a, System.currentTimeMillis());
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg", 2, "MultiForwardActivity.doOnCreate, start requestReceiveMultiMsg");
        }
        this.a.x();
        this.a.c = new vvn(this);
        MultiForwardChatPie.a(this.a).postDelayed(this.a.c, 60000L);
        ThreadRegulator.a().b(1);
        MultiMsgManager.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.f, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.h, 1035, this.a.a(MultiForwardChatPie.a(this.a)));
        return;
      }
      paramMessage = ChatActivityUtils.a(this.a.b, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramMessage = ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramMessage);
      MultiForwardChatPie.a(this.a).setVisibility(8);
      MultiForwardChatPie.a(this.a).setVisibility(0);
      MultiForwardChatPie.a(this.a).setVisibility(0);
      MultiForwardChatPie.a(this.a).a(this.a.b, paramMessage);
    } while (!QLog.isColorLevel());
    QLog.d("MultiMsg", 2, "MultiForwardActivity.doOnCreate, MultiMsg has been downloaded");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vvm
 * JD-Core Version:    0.7.0.1
 */