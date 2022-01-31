import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class xft
  extends ampb<xfs>
{
  public int a()
  {
    return 411;
  }
  
  public Class<xfs> a()
  {
    return xfs.class;
  }
  
  @NonNull
  public xfs a(int paramInt)
  {
    return new xfs();
  }
  
  @Nullable
  public xfs a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      xfs localxfs = xfs.a(paramArrayOfampi[0].a);
      QLog.i("Q.videostory.config.VSEntranceProcessor", 2, "onParsed " + paramArrayOfampi[0].a);
      a(localxfs);
      return localxfs;
    }
    QLog.e("Q.videostory.config.VSEntranceProcessor", 2, "onParsed conf content is null!");
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(xfs paramxfs)
  {
    if (paramxfs != null)
    {
      xfr.a().a("mine_videostory_entrance", paramxfs.a());
      xfr.a().a("enable_click_take_picture", paramxfs.b());
      xfr.a().a("mine_videostory_drawer_entrance", paramxfs.c());
      QLog.i("Q.videostory.config.VSEntranceProcessor", 2, "onUpdate:" + paramxfs.toString());
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
 * Qualified Name:     xft
 * JD-Core Version:    0.7.0.1
 */