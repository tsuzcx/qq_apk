import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class xgb
  extends ampb<xga>
{
  public int a()
  {
    return 463;
  }
  
  public Class<xga> a()
  {
    return xga.class;
  }
  
  @NonNull
  public xga a(int paramInt)
  {
    return new xga();
  }
  
  @Nullable
  public xga a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      xga localxga = xga.a(paramArrayOfampi[0].a);
      a(localxga);
      QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, "onParsed " + paramArrayOfampi[0].a);
      return localxga;
    }
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(xga paramxga)
  {
    QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, "onUpdate ");
    if (paramxga != null)
    {
      QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, "onUpdate " + paramxga.toString());
      xfr.a().a("subscribe_entrance_enable", paramxga.a());
      xfr.a().a("is_open_sharing", paramxga.b());
      xfr.a().a("subscribe_account_title", paramxga.c());
      xfr.a().a("newfollowlist", paramxga.d());
      xfr.a().a("subscribe_publish_entrance_enable", paramxga.e());
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
 * Qualified Name:     xgb
 * JD-Core Version:    0.7.0.1
 */