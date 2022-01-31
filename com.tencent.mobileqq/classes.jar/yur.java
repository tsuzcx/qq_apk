import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class yur
  extends aofy<yuq>
{
  public int a()
  {
    return 463;
  }
  
  public Class<yuq> a()
  {
    return yuq.class;
  }
  
  @NonNull
  public yuq a(int paramInt)
  {
    return new yuq();
  }
  
  @Nullable
  public yuq a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      yuq localyuq = yuq.a(paramArrayOfaogf[0].a);
      a(localyuq);
      QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, "onParsed " + paramArrayOfaogf[0].a);
      return localyuq;
    }
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(yuq paramyuq)
  {
    QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, "onUpdate ");
    if (paramyuq != null)
    {
      QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, "onUpdate " + paramyuq.toString());
      yuh.a().a("subscribe_entrance_enable", paramyuq.a());
      yuh.a().a("is_open_sharing", paramyuq.b());
      yuh.a().a("subscribe_account_title", paramyuq.c());
      yuh.a().a("newfollowlist", paramyuq.d());
      yuh.a().a("subscribe_publish_entrance_enable", paramyuq.e());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yur
 * JD-Core Version:    0.7.0.1
 */