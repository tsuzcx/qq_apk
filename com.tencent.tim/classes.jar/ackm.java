import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import mqq.manager.Manager;

public class ackm
  implements Manager
{
  private QQAppInterface app;
  
  public ackm(QQAppInterface paramQQAppInterface)
    throws NullPointerException
  {
    if (paramQQAppInterface == null) {
      throw new NullPointerException("RecentManagerFor3rdPart, app is null");
    }
    this.app = paramQQAppInterface;
  }
  
  public boolean Q(String paramString, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.app != null)
    {
      bool1 = bool2;
      if (this.app.abl())
      {
        acxw localacxw = this.app.a().a();
        paramString = localacxw.b(paramString, paramInt);
        bool1 = bool2;
        if (paramString != null)
        {
          localacxw.f(paramString);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, long paramLong1, long paramLong2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    if ((this.app != null) && (this.app.abl()))
    {
      acxw localacxw = this.app.a().a();
      RecentUser localRecentUser = localacxw.a(paramString1, paramInt);
      localRecentUser.uin = paramString1;
      localRecentUser.setType(paramInt);
      localRecentUser.displayName = paramString2;
      localRecentUser.lastmsgtime = paramLong1;
      localRecentUser.lastmsgdrafttime = paramLong2;
      localacxw.e(localRecentUser);
    }
    return true;
  }
  
  public boolean c(String paramString, int paramInt, long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.app != null)
    {
      bool1 = bool2;
      if (this.app.abl())
      {
        acxw localacxw = this.app.a().a();
        paramString = localacxw.b(paramString, paramInt);
        bool1 = bool2;
        if (paramString != null)
        {
          paramString.lastmsgtime = paramLong;
          localacxw.e(paramString);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void onDestroy()
  {
    this.app = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ackm
 * JD-Core Version:    0.7.0.1
 */