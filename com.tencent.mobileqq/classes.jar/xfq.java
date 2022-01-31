import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class xfq
  extends ampa<xfp>
{
  public int a()
  {
    return 411;
  }
  
  public Class<xfp> a()
  {
    return xfp.class;
  }
  
  @NonNull
  public xfp a(int paramInt)
  {
    return new xfp();
  }
  
  @Nullable
  public xfp a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      xfp localxfp = xfp.a(paramArrayOfamph[0].a);
      QLog.i("Q.videostory.config.VSEntranceProcessor", 2, "onParsed " + paramArrayOfamph[0].a);
      a(localxfp);
      return localxfp;
    }
    QLog.e("Q.videostory.config.VSEntranceProcessor", 2, "onParsed conf content is null!");
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(xfp paramxfp)
  {
    if (paramxfp != null)
    {
      xfo.a().a("mine_videostory_entrance", paramxfp.a());
      xfo.a().a("enable_click_take_picture", paramxfp.b());
      xfo.a().a("mine_videostory_drawer_entrance", paramxfp.c());
      QLog.i("Q.videostory.config.VSEntranceProcessor", 2, "onUpdate:" + paramxfp.toString());
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
 * Qualified Name:     xfq
 * JD-Core Version:    0.7.0.1
 */