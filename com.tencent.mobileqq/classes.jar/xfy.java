import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class xfy
  extends ampa<xfx>
{
  public int a()
  {
    return 463;
  }
  
  public Class<xfx> a()
  {
    return xfx.class;
  }
  
  @NonNull
  public xfx a(int paramInt)
  {
    return new xfx();
  }
  
  @Nullable
  public xfx a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      xfx localxfx = xfx.a(paramArrayOfamph[0].a);
      a(localxfx);
      QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, "onParsed " + paramArrayOfamph[0].a);
      return localxfx;
    }
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(xfx paramxfx)
  {
    QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, "onUpdate ");
    if (paramxfx != null)
    {
      QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, "onUpdate " + paramxfx.toString());
      xfo.a().a("subscribe_entrance_enable", paramxfx.a());
      xfo.a().a("is_open_sharing", paramxfx.b());
      xfo.a().a("subscribe_account_title", paramxfx.c());
      xfo.a().a("newfollowlist", paramxfx.d());
      xfo.a().a("subscribe_publish_entrance_enable", paramxfx.e());
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
 * Qualified Name:     xfy
 * JD-Core Version:    0.7.0.1
 */