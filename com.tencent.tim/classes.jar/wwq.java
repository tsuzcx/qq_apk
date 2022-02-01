import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

public class wwq
  implements wvs
{
  private xys b;
  
  public wwq(xys paramxys)
  {
    this.b = paramxys;
  }
  
  public int[] C()
  {
    return new int[] { 13 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    }
    SessionInfo localSessionInfo;
    do
    {
      return;
      localObject = this.b.a;
      localSessionInfo = this.b.sessionInfo;
      if ((localObject != null) && ((localSessionInfo.cZ == 1024) || (((asgx)localObject).sH(localSessionInfo.aTl)))) {
        ((asgx)localObject).gC(localSessionInfo.aTl, localSessionInfo.cZ);
      }
      if ((localObject != null) && (((asgx)localObject).sH(localSessionInfo.aTl))) {
        ((ashy)this.b.app.getBusinessHandler(85)).ab(null, localSessionInfo.aTl, false);
      }
    } while ((!(this.b instanceof xwq)) && (!jou.df(localSessionInfo.aTl)));
    if (localObject == null) {}
    for (Object localObject = "";; localObject = ((asgx)localObject).qW(localSessionInfo.aTl))
    {
      anot.a(this.b.app, "dc00899", "Qidian", localSessionInfo.aTl, "0X8009787", "CloseAIO", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), (String)localObject, "3.4.4", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wwq
 * JD-Core Version:    0.7.0.1
 */