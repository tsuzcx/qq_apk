import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class dyc
  extends TroopObserver
{
  public dyc(TroopRequestActivity paramTroopRequestActivity) {}
  
  protected void a(int paramInt, byte paramByte)
  {
    if ((paramInt == 4) || (paramInt == 5) || (paramInt == 6) || (paramInt == 7)) {
      this.a.a.sendEmptyMessage(1);
    }
    if (paramInt == 8) {
      this.a.a.sendEmptyMessage(1);
    }
  }
  
  protected void a(int paramInt, byte paramByte, String paramString)
  {
    if ((paramInt == 4) || (paramInt == 5) || (paramInt == 6) || (paramInt == 7))
    {
      if (paramByte != 0) {
        break label68;
      }
      this.a.a.sendEmptyMessage(0);
      this.a.finish();
    }
    for (;;)
    {
      if (paramInt == 8)
      {
        if (paramByte != 0) {
          break;
        }
        this.a.a.sendEmptyMessage(0);
      }
      return;
      label68:
      this.a.a.sendEmptyMessage(1);
    }
    this.a.a.sendEmptyMessage(1);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    if (paramLong != Long.parseLong(this.a.p)) {}
    for (;;)
    {
      return;
      this.a.h();
      if (!paramBoolean) {
        break;
      }
      if ((paramTroopInfo.cGroupOption == 4) || (paramTroopInfo.cGroupOption == 5)) {
        TroopRequestActivity.a(this.a, paramTroopInfo.joinTroopQuestion);
      }
      TroopRequestActivity.a(this.a, paramTroopInfo.cGroupOption);
      if (TroopRequestActivity.a(this.a) != 3) {
        TroopRequestActivity.a(this.a);
      }
      while (QLog.isColorLevel())
      {
        QLog.i("Q.systemmsg.TroopRequestActivity", 2, "troop.cGroupOption = " + paramTroopInfo.cGroupOption);
        return;
        QQToast.a(this.a.b.getApplication(), 2131563078, 0).b(this.a.d());
      }
    }
    this.a.a.sendEmptyMessage(1);
  }
  
  protected void b(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    try
    {
      this.a.p = this.a.p.trim();
      long l = Long.parseLong(this.a.p);
      if (paramLong != l) {
        return;
      }
    }
    catch (NumberFormatException paramString)
    {
      do
      {
        do
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.systemmsg.TroopRequestActivity", 2, "NumberFormatException");
          }
        } while ((!paramBoolean) || (paramTroopInfo == null));
        paramTroopInfo = GroupCatalogTool.a(BaseApplication.getContext()).a(this.a, Long.toString(paramTroopInfo.dwGroupClassExt));
      } while (paramTroopInfo == null);
      paramString = new Message();
      paramString.what = 2;
      paramString.obj = paramTroopInfo.a();
      this.a.a.sendMessage(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dyc
 * JD-Core Version:    0.7.0.1
 */