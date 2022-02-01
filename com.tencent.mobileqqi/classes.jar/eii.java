import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.SecSigObserver;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class eii
  extends SecSigObserver
{
  public eii(MainAssistObserver paramMainAssistObserver) {}
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sec_sig_tag", 2, "mSecSigObserver start url:" + paramString5);
    }
    paramString1 = DialogUtil.a(this.a.a, 230).setTitle(paramString1).setMessage(paramString2).setPositiveButton(paramString4, new eik(this, paramString5)).setNegativeButton(paramString3, new eij(this));
    if (paramString1 != null)
    {
      paramString1.setCancelable(false);
      paramString1.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eii
 * JD-Core Version:    0.7.0.1
 */