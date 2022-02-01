import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import tencent.im.qqwallet.QWalletPubAdReport.QueryReq;

class zyf
  implements avor.a
{
  zyf(zyd paramzyd, BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, long paramLong) {}
  
  public void ansyBack(int paramInt, String... paramVarArgs)
  {
    if ((paramVarArgs.length <= 0) || (paramVarArgs[0] == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QWalletGdtAdManager", 2, "get getPskeyAsync success");
    }
    paramVarArgs = zyd.a(this.this$0, paramVarArgs[0], this.val$activity);
    NewIntent localNewIntent = new NewIntent(this.val$app.getApplication(), zxf.class);
    localNewIntent.putExtra("cmd", "ReportSvc.Query");
    localNewIntent.putExtra("data", aqnv.I(paramVarArgs.toByteArray()));
    localNewIntent.setObserver(new zyg(this));
    this.val$app.startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zyf
 * JD-Core Version:    0.7.0.1
 */