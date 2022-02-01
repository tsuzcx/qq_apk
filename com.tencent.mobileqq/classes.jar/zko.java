import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;

public class zko
  extends anrc
{
  public zko(QRDisplayActivity paramQRDisplayActivity) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((TextUtils.equals(this.a.c, paramString)) && (paramBoolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QRDisplayActivity", 2, "onUpdateTroopSearchApproachPageTroopInfoUpdated ");
      }
      paramString = (TroopManager)this.a.app.getManager(QQManagerFactory.TROOP_MANAGER);
      if (paramString != null)
      {
        paramString = paramString.b(this.a.c);
        if ((paramString != null) && (!paramString.isNewTroop)) {
          ((TextView)this.a.findViewById(2131367908)).setVisibility(8);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zko
 * JD-Core Version:    0.7.0.1
 */