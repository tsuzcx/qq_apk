import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.SecSigObserver;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class cft
  extends SecSigObserver
{
  public cft(MainAssistObserver paramMainAssistObserver) {}
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sec_sig_tag", 2, "mSecSigObserver start url:" + paramString5);
    }
    paramString1 = DialogUtil.a(this.a.a, 230).setTitle(paramString1).setMessage(paramString2).setPositiveButton(paramString4, new cfv(this, paramString5)).setNegativeButton(paramString3, new cfu(this));
    if (paramString1 != null)
    {
      paramString1.setCancelable(false);
      paramString1.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cft
 * JD-Core Version:    0.7.0.1
 */