import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class acnq
  extends accg
{
  public acnq(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return acnr.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramObject == null)) {
      notifyUI(1, false, null);
    }
    String str;
    do
    {
      return;
      str = paramToServiceMsg.getServiceCmd();
      if (TextUtils.isEmpty(str))
      {
        notifyUI(1, false, null);
        return;
      }
      if ((str.compareTo("VipPayLogicServer.getCommPayInfo ") == 0) && (QLog.isColorLevel())) {
        QLog.i("VIPRecommendPayHandler", 2, "req---" + paramToServiceMsg + ",res----" + paramFromServiceMsg + ",data-----" + paramObject);
      }
    } while (str.compareTo("VipPayLogicServer.getCommPayInfo ") != 0);
    notifyUI(1, true, paramObject);
    aqhq.y(this.app.getCurrentAccountUin() + "_" + "VIPRecommendPayFile.txt", paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acnq
 * JD-Core Version:    0.7.0.1
 */