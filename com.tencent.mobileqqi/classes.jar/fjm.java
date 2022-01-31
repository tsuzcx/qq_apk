import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.subaccount.SubAccountAssistantImpl;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.SubAccountObserver;

public class fjm
  extends SubAccountObserver
{
  public fjm(OnLinePushMessageProcessor paramOnLinePushMessageProcessor) {}
  
  protected void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString3 == null) || (this.a.a == null) || (paramString1 == null)) {}
    while (!paramString1.equalsIgnoreCase(this.a.a.getAccount())) {
      return;
    }
    SubAccountAssistantImpl.a().a(this.a.a, paramString2, paramString3);
    long l = SubAccountAssistantImpl.a().a(this.a.a, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubAccountPush status = " + l);
    }
    SubAccountAssistantImpl.a().a(this.a.a, (byte)1, Long.parseLong(paramString2), HexUtil.a(paramString3), (int)l);
    this.a.a.e(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fjm
 * JD-Core Version:    0.7.0.1
 */