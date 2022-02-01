import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.config.operation.QQOperateManager;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class byv
  extends ConfigObserver
{
  public byv(ChatActivity paramChatActivity) {}
  
  protected void a(String paramString, int paramInt, ArrayList paramArrayList)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQOperateVoIP", 4, "on showTips, chatactivity upadte ui");
    }
    if ((!this.a.a.jdField_a_of_type_JavaLangString.equals(paramString)) || (this.a.a.jdField_a_of_type_Int != paramInt)) {
      if (QLog.isDevelopLevel()) {
        QLog.d("QQOperateVoIP", 4, "on showTips, uin dosenot equal");
      }
    }
    for (;;)
    {
      return;
      if ((paramArrayList == null) || (paramArrayList.size() == 0))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QQOperateVoIP", 4, "on showTips,tasklist is null");
        }
      }
      else
      {
        paramString = QQOperateManager.a(this.a.b);
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          paramInt = ((QQOperationViopTipTask)paramArrayList.next()).taskid;
          QQOperationViopTipTask localQQOperationViopTipTask = paramString.a(paramInt);
          if ((QLog.isDevelopLevel()) && (localQQOperationViopTipTask == null)) {
            QLog.d("QQOperateVoIP", 4, "on showTips, voipTask is null, taskId=" + paramInt);
          }
          if (localQQOperationViopTipTask != null) {
            if (localQQOperationViopTipTask.isBlueTipsTask()) {
              ChatActivity.a(this.a, localQQOperationViopTipTask);
            } else if ((localQQOperationViopTipTask.isGryTipsTask()) && (!paramString.a(this.a.a.jdField_a_of_type_Int, 2))) {
              ChatActivity.b(this.a, localQQOperationViopTipTask);
            }
          }
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, AppShareID paramAppShareID)
  {
    if ((paramBoolean) && (ChatActivity.a(this.a) != null)) {
      ChatActivity.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     byv
 * JD-Core Version:    0.7.0.1
 */