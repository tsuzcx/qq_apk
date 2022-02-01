import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class wuw
  implements wvs
{
  private BaseChatPie a;
  private QQAppInterface app;
  private Activity mActivity;
  private Context mContext;
  private SessionInfo sessionInfo;
  
  public wuw(BaseChatPie paramBaseChatPie)
  {
    this.app = paramBaseChatPie.app;
    this.mContext = paramBaseChatPie.mContext;
    this.mActivity = paramBaseChatPie.mActivity;
    this.a = paramBaseChatPie;
    this.sessionInfo = paramBaseChatPie.sessionInfo;
  }
  
  private void ccl()
  {
    if ((this.a.mContext instanceof Activity)) {
      abzx.a(false, (Activity)this.a.mContext, this.a.a(), this.a.app, this.a.sessionInfo.aTl, new wux(this));
    }
    ((abhe)this.a.app.getManager(211)).a(this.a.b, this.a.a);
    abvh.a().a(this.a.app);
    ((abhe)this.a.app.getManager(211)).t(1, this.a.sessionInfo.aTl, this.a.sessionInfo.cZ);
  }
  
  public int[] C()
  {
    return new int[] { 13, 7 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    case 13: 
    default: 
      return;
    }
    ccl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wuw
 * JD-Core Version:    0.7.0.1
 */