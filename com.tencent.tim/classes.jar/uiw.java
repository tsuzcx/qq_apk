import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class uiw
  extends accz
{
  public uiw(BaseChatPie paramBaseChatPie) {}
  
  protected void a(String paramString, int paramInt, ArrayList<QQOperationViopTipTask> paramArrayList)
  {
    if (this.this$0.isFullScreenMode()) {}
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isDevelopLevel()) {
            QLog.d("QQOperateVoIP", 4, "on showTips, chatactivity upadte ui");
          }
          if ((this.this$0.sessionInfo.aTl.equals(paramString)) && (this.this$0.sessionInfo.cZ == paramInt)) {
            break;
          }
        } while (!QLog.isDevelopLevel());
        QLog.d("QQOperateVoIP", 4, "on showTips, uin dosenot equal");
        return;
        if ((paramArrayList != null) && (paramArrayList.size() != 0)) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.d("QQOperateVoIP", 4, "on showTips,tasklist is null");
      return;
    } while (this.this$0.jdField_a_of_type_Yja == null);
    this.this$0.jdField_a_of_type_Yja.gC(paramArrayList);
  }
  
  protected void a(boolean paramBoolean, AppShareID paramAppShareID)
  {
    if ((paramBoolean) && (this.this$0.jdField_a_of_type_Wki != null)) {
      this.this$0.jdField_a_of_type_Wki.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uiw
 * JD-Core Version:    0.7.0.1
 */