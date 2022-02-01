import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;

public class aper
{
  private acnd a = new apes(this);
  QQAppInterface app;
  public Context context = null;
  public Handler dB = null;
  public String troopUin = null;
  
  public aper(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, Handler paramHandler)
  {
    this.app = paramQQAppInterface;
    this.context = paramContext;
    this.troopUin = paramString;
    this.dB = paramHandler;
  }
  
  private String in(String paramString)
  {
    TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
    if (localTroopManager != null)
    {
      paramString = localTroopManager.b(paramString);
      if (paramString != null) {
        return paramString.troopcode;
      }
    }
    return null;
  }
  
  public void Ry(boolean paramBoolean)
  {
    QLog.e("RefreshMemberList", 4, "Prepare refreshMemberListFromServer");
    if (TextUtils.isEmpty(this.troopUin)) {}
    String str;
    do
    {
      return;
      str = in(this.troopUin);
    } while (TextUtils.isEmpty(str));
    long l1 = this.context.getSharedPreferences("last_update_time", 4).getLong("key_last_update_time" + str, 0L);
    long l2 = System.currentTimeMillis();
    if ((paramBoolean) || (l1 == 0L) || ((l1 > 0L) && (l2 - l1 > 300000L)))
    {
      ((acms)this.app.getBusinessHandler(20)).b(true, this.troopUin, str, 5);
      if (l1 == 0L)
      {
        QLog.e("RefreshMemberList", 4, "Not refresh now, will refresh.");
        return;
      }
      QLog.e("RefreshMemberList", 4, "> 5min, will refresh.");
      return;
    }
    QLog.e("RefreshMemberList", 4, "< 5min, Will not refresh.");
  }
  
  public void dYI()
  {
    this.app.addObserver(this.a);
  }
  
  public void dYJ()
  {
    this.dB = null;
    this.app.removeObserver(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aper
 * JD-Core Version:    0.7.0.1
 */