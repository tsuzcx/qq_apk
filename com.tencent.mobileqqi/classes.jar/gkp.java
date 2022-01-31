import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;

public class gkp
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long = 0L;
  
  public gkp(AbsShareMsg paramAbsShareMsg) {}
  
  public void onClick(View paramView)
  {
    if (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long < 1000L) {}
    Object localObject;
    AbsShareMsg localAbsShareMsg;
    Context localContext;
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
          localObject = paramView.getTag();
        } while ((localObject == null) || (!AbsShareMsg.class.isInstance(localObject)));
        localAbsShareMsg = (AbsShareMsg)localObject;
        localContext = paramView.getContext();
      } while (!ChatActivity.class.isInstance(localContext));
      localObject = ((ChatActivity)localContext).a();
    } while (localObject == null);
    gkq localgkq = new gkq(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg, (QQAppInterface)localObject, paramView);
    paramView = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAction;
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "mSourceOnClickListener sourceAction = " + paramView);
    }
    if ("app".equals(paramView)) {
      if (localgkq.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceUrl, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceActionData, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSource_A_ActionData)) {
        paramView = "run";
      }
    }
    for (;;)
    {
      Util.a((QQAppInterface)localObject, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.uin, "sourceclick", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAppid, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID, paramView);
      return;
      if (localgkq.a((ChatActivity)localContext, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAppid, localAbsShareMsg.mSourceName, localAbsShareMsg.mSourceActionData, localAbsShareMsg.mSource_A_ActionData))
      {
        paramView = "setup";
      }
      else
      {
        localgkq.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceUrl);
        paramView = "setup";
        continue;
        if ("web".equals(paramView))
        {
          localgkq.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceUrl);
          paramView = "setup";
        }
        else if ("plugin".equals(paramView))
        {
          localgkq.c(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceActionData, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSource_A_ActionData);
          paramView = "plugin";
        }
        else
        {
          localgkq.a(paramView, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceUrl, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceActionData, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSource_A_ActionData);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gkp
 * JD-Core Version:    0.7.0.1
 */