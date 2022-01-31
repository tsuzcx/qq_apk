import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class yzg
  extends aokh<yzf>
{
  public int a()
  {
    return 463;
  }
  
  public Class<yzf> a()
  {
    return yzf.class;
  }
  
  @NonNull
  public yzf a(int paramInt)
  {
    return new yzf();
  }
  
  @Nullable
  public yzf a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      yzf localyzf = yzf.a(paramArrayOfaoko[0].a);
      a(localyzf);
      QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, "onParsed " + paramArrayOfaoko[0].a);
      return localyzf;
    }
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(yzf paramyzf)
  {
    QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, "onUpdate ");
    if (paramyzf != null)
    {
      QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, "onUpdate " + paramyzf.toString());
      yyw.a().a("subscribe_entrance_enable", paramyzf.a());
      yyw.a().a("is_open_sharing", paramyzf.b());
      yyw.a().a("subscribe_account_title", paramyzf.c());
      yyw.a().a("newfollowlist", paramyzf.d());
      yyw.a().a("subscribe_publish_entrance_enable", paramyzf.e());
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
 * Qualified Name:     yzg
 * JD-Core Version:    0.7.0.1
 */