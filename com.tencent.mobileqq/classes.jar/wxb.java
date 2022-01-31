import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class wxb
  extends alzl<wxa>
{
  public int a()
  {
    return 463;
  }
  
  public Class<wxa> a()
  {
    return wxa.class;
  }
  
  @NonNull
  public wxa a(int paramInt)
  {
    return new wxa();
  }
  
  @Nullable
  public wxa a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      wxa localwxa = wxa.a(paramArrayOfalzs[0].a);
      a(localwxa);
      QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, "onParsed " + paramArrayOfalzs[0].a);
      return localwxa;
    }
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(wxa paramwxa)
  {
    QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, "onUpdate ");
    if (paramwxa != null)
    {
      QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, "onUpdate " + paramwxa.toString());
      wwt.a().a("subscribe_entrance_enable", paramwxa.a());
      wwt.a().a("is_open_sharing", paramwxa.b());
      wwt.a().a("subscribe_account_title", paramwxa.c());
      wwt.a().a("newfollowlist", paramwxa.d());
      wwt.a().a("subscribe_publish_entrance_enable", paramwxa.e());
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wxb
 * JD-Core Version:    0.7.0.1
 */