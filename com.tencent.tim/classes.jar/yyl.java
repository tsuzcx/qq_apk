import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contact.troop.TroopSuspiciousFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class yyl
  extends achq
{
  public yyl(TroopSuspiciousFragment paramTroopSuspiciousFragment) {}
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopSuspiciousFragment", 2, "onSendSystemMsgActionFin");
    }
    long l2 = anze.a().hf();
    long l1 = l2;
    if (!TextUtils.isEmpty(paramString1)) {}
    try
    {
      l1 = Long.parseLong(paramString1);
      if (!paramBoolean)
      {
        TroopSuspiciousFragment.a(this.this$0, paramString2, paramInt3, paramString3, paramString4, l1);
        return;
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
        l1 = l2;
      }
      TroopSuspiciousFragment.a(this.this$0, paramInt1, paramString2, paramInt2, l1);
    }
  }
  
  protected void d(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopSuspiciousFragment", 2, "onGetSuspiciousSystemMsgFin.bengin");
    }
    if (this.this$0.k.isFinishing()) {
      return;
    }
    TroopSuspiciousFragment.d(this.this$0);
    if (!paramBoolean1) {
      TroopSuspiciousFragment.a(this.this$0, paramBoolean2);
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopSuspiciousFragment", 2, "onGetSuspiciousSystemMsgFin.success");
    }
    try
    {
      TroopSuspiciousFragment.a(this.this$0, paramList);
      return;
    }
    catch (Exception paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  protected void iv(String paramString)
  {
    if ((TroopSuspiciousFragment.a(this.this$0) != null) && (TroopSuspiciousFragment.a(this.this$0).isShowing()))
    {
      TroopSuspiciousFragment.a(this.this$0).dismiss();
      paramString = this.this$0.k.getResources().getString(2131720702);
      QQToast.a(this.this$0.k, 1, paramString, 0).show(this.this$0.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yyl
 * JD-Core Version:    0.7.0.1
 */