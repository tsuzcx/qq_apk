import android.os.Handler;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity.11.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class wcq
  extends acnd
{
  public wcq(TroopRequestActivity paramTroopRequestActivity) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    if (this.this$0.aKI == null) {}
    do
    {
      for (;;)
      {
        return;
        this.this$0.aKI = this.this$0.aKI.trim();
        try
        {
          long l = Long.parseLong(this.this$0.aKI);
          if (paramLong != l) {}
        }
        catch (NumberFormatException paramString)
        {
          for (;;)
          {
            if (QLog.isColorLevel())
            {
              QLog.e("Q.systemmsg.TroopRequestActivity", 2, "onOIDB0X88D_1_Ret=>NumberFormatException");
              continue;
              QQToast.a(this.this$0.app.getApplication(), 2131721390, 0).show(this.this$0.getTitleBarHeight());
            }
          }
          this.this$0.bP.sendEmptyMessage(1);
        }
      }
      this.this$0.ath();
      if (!paramBoolean) {
        break label215;
      }
      if ((paramTroopInfo.cGroupOption == 4) || (paramTroopInfo.cGroupOption == 5))
      {
        this.this$0.aRC = paramTroopInfo.joinTroopQuestion;
        this.this$0.aRD = paramTroopInfo.joinTroopAnswer;
      }
      this.this$0.J = paramTroopInfo.cGroupOption;
      if (this.this$0.J == 3) {
        break;
      }
      TroopRequestActivity.a(this.this$0);
    } while (!QLog.isColorLevel());
    QLog.i("Q.systemmsg.TroopRequestActivity", 2, "troop.cGroupOption = " + paramTroopInfo.cGroupOption);
    return;
    label215:
  }
  
  protected void b(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    if (this.this$0.aKI == null) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          this.this$0.aKI = this.this$0.aKI.trim();
          long l = Long.parseLong(this.this$0.aKI);
          if (paramLong != l) {}
        }
        catch (NumberFormatException paramString)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.systemmsg.TroopRequestActivity", 2, "onOIDB0X88D_10_Ret=>NumberFormatException");
            }
          }
        }
      }
      this.this$0.ath();
    } while ((!paramBoolean) || (paramTroopInfo == null));
    ThreadManager.post(new TroopRequestActivity.11.1(this, paramTroopInfo), 8, null, true);
  }
  
  protected void eE(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 4) || (paramInt1 == 5) || (paramInt1 == 6) || (paramInt1 == 7)) {
      this.this$0.bP.sendEmptyMessage(1);
    }
    if (paramInt1 == 8) {
      this.this$0.bP.sendEmptyMessage(1);
    }
  }
  
  protected void q(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 == 4) || (paramInt1 == 5) || (paramInt1 == 6) || (paramInt1 == 7))
    {
      if (paramInt2 != 0) {
        break label68;
      }
      this.this$0.bP.sendEmptyMessage(0);
      this.this$0.finish();
    }
    for (;;)
    {
      if (paramInt1 == 8)
      {
        if (paramInt2 != 0) {
          break;
        }
        this.this$0.bP.sendEmptyMessage(0);
      }
      return;
      label68:
      this.this$0.bP.sendEmptyMessage(1);
    }
    this.this$0.bP.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wcq
 * JD-Core Version:    0.7.0.1
 */