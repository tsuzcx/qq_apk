import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class jtb
  extends adai.a
{
  public jtb(EqqAccountDetailActivity paramEqqAccountDetailActivity, jzs.a parama, int paramInt1, int paramInt2) {}
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "success:" + paramBoolean);
    }
    EqqAccountDetailActivity.e(this.this$0);
  }
  
  public void c(boolean paramBoolean, Object paramObject)
  {
    EqqAccountDetailActivity.e(this.this$0);
    if (EqqAccountDetailActivity.f(this.this$0) == 0) {
      EqqAccountDetailActivity.f(this.this$0);
    }
  }
  
  public int dI()
  {
    return 7;
  }
  
  public void onSuccess(Object paramObject)
  {
    if ((paramObject instanceof ArrayList))
    {
      paramObject = ((ArrayList)paramObject).iterator();
      for (;;)
      {
        if (paramObject.hasNext())
        {
          Object localObject = paramObject.next();
          if (((localObject instanceof AppletItem)) && (((AppletItem)localObject).sb().equals(EqqAccountDetailActivity.p(this.this$0))))
          {
            this.a.state = this.BG;
            this.this$0.azC();
            if (this.a.aGI == 6)
            {
              if (this.val$state != 1) {
                break label236;
              }
              this.this$0.og(1);
              anot.a(EqqAccountDetailActivity.q(this.this$0), "P_CliOper", "Pb_account_lifeservice", EqqAccountDetailActivity.q(this.this$0), "mp_msg_ziliao_2", "share_click", 0, 0, "", "", "", "");
              anot.a(EqqAccountDetailActivity.r(this.this$0), "P_CliOper", "Pb_account_lifeservice", EqqAccountDetailActivity.r(this.this$0), "0X8004F05", "0X8004F05", 0, 0, "", "", "", "");
            }
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG, 2, String.valueOf(this.val$state));
      }
      this.this$0.azu();
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG, 2, "状态切换成功");
      }
      this.this$0.a(this.a);
      return;
      label236:
      anot.a(EqqAccountDetailActivity.s(this.this$0), "P_CliOper", "Pb_account_lifeservice", EqqAccountDetailActivity.s(this.this$0), "0X8004F07", "0X8004F07", 0, 0, "", "", "", "");
    }
  }
  
  public void p(Object paramObject)
  {
    this.this$0.oh(2131697432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jtb
 * JD-Core Version:    0.7.0.1
 */