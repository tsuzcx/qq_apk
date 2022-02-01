import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class wxp
  implements wvs
{
  private BaseChatPie a;
  private int aOr;
  private QQAppInterface app;
  private Activity mActivity;
  private Context mContext;
  private SessionInfo sessionInfo;
  
  public wxp(BaseChatPie paramBaseChatPie)
  {
    this.app = paramBaseChatPie.app;
    this.mContext = paramBaseChatPie.mContext;
    this.mActivity = paramBaseChatPie.mActivity;
    this.a = paramBaseChatPie;
    this.sessionInfo = paramBaseChatPie.sessionInfo;
  }
  
  private void cdl()
  {
    aize localaize;
    if (this.aOr > 0)
    {
      localaize = (aize)this.app.getManager(308);
      if (localaize == null) {
        break label93;
      }
      switch (this.sessionInfo.cZ)
      {
      }
    }
    label93:
    while (!QLog.isColorLevel())
    {
      return;
      localaize.a(this.sessionInfo, aize.dhb);
      return;
      localaize.a(this.sessionInfo, aize.dhc);
      return;
    }
    QLog.d("UnreadCountHelper", 2, "PushNotificationManager is null");
  }
  
  public int[] C()
  {
    return new int[] { 6 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.aOr = this.app.a().A(this.sessionInfo.aTl, this.sessionInfo.cZ);
    cdl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wxp
 * JD-Core Version:    0.7.0.1
 */