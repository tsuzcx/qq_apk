import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class yyy
  extends aokh<yyx>
{
  public int a()
  {
    return 411;
  }
  
  public Class<yyx> a()
  {
    return yyx.class;
  }
  
  @NonNull
  public yyx a(int paramInt)
  {
    return new yyx();
  }
  
  @Nullable
  public yyx a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      yyx localyyx = yyx.a(paramArrayOfaoko[0].a);
      QLog.i("Q.videostory.config.VSEntranceProcessor", 2, "onParsed " + paramArrayOfaoko[0].a);
      a(localyyx);
      return localyyx;
    }
    QLog.e("Q.videostory.config.VSEntranceProcessor", 2, "onParsed conf content is null!");
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(yyx paramyyx)
  {
    if (paramyyx != null)
    {
      yyw.a().a("mine_videostory_entrance", paramyyx.a());
      yyw.a().a("enable_click_take_picture", paramyyx.b());
      yyw.a().a("mine_videostory_drawer_entrance", paramyyx.c());
      QLog.i("Q.videostory.config.VSEntranceProcessor", 2, "onUpdate:" + paramyyx.toString());
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
 * Qualified Name:     yyy
 * JD-Core Version:    0.7.0.1
 */