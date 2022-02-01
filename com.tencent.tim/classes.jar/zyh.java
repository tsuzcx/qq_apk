import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import tencent.im.qqwallet.QWalletPubAdReport.ReportReq;

class zyh
  implements avor.a
{
  zyh(zyd paramzyd, int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, long paramLong) {}
  
  public void ansyBack(int paramInt, String... paramVarArgs)
  {
    if ((paramVarArgs.length <= 0) || (paramVarArgs[0] == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QWalletGdtAdManager", 2, "get getPskeyAsync success");
    }
    paramVarArgs = zyd.a(this.this$0, paramVarArgs[0], this.cfz, this.val$context);
    NewIntent localNewIntent = new NewIntent(this.val$app.getApplication(), zxf.class);
    localNewIntent.putExtra("cmd", "ReportSvc.Statistics");
    localNewIntent.putExtra("data", aqnv.I(paramVarArgs.toByteArray()));
    localNewIntent.setObserver(new zyi(this));
    this.val$app.startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zyh
 * JD-Core Version:    0.7.0.1
 */