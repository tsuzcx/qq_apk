import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ujn
  extends augb
{
  public ujn(BaseChatPie paramBaseChatPie) {}
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2, String paramString3)
  {
    super.a(paramBoolean, paramString1, paramInt1, paramLong, paramString2, paramInt2, paramString3);
    if (paramBoolean) {}
    for (;;)
    {
      if (QLog.isDebugVersion()) {
        QLog.i(this.this$0.TAG, 1, "ScheduleAccept onAcceptSchedule:" + paramString3 + "  extStr:" + paramString2);
      }
      BaseChatPie.a(this.this$0, paramString3, paramString2, "acceptScheduleReturn", false);
      return;
      if (paramInt2 != 56) {
        if (paramInt2 == 57)
        {
          QQToast.a(this.this$0.app.getApp(), 2131719082, 0).show(this.this$0.getTitleBarHeight());
          paramString2 = "4";
        }
        else if (paramInt2 == 49)
        {
          QQToast.a(this.this$0.app.getApp(), 2131719172, 0).show(this.this$0.getTitleBarHeight());
          paramString2 = "4";
        }
        else if (paramInt2 == 44)
        {
          QQToast.a(this.this$0.app.getApp(), 2131719201, 0).show(this.this$0.getTitleBarHeight());
          paramString2 = "4";
        }
        else
        {
          QQToast.a(this.this$0.app.getApp(), 2131719058, 0).show(this.this$0.getTitleBarHeight());
          paramString2 = "4";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ujn
 * JD-Core Version:    0.7.0.1
 */