import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class yuj
  extends aofy<yui>
{
  public int a()
  {
    return 411;
  }
  
  public Class<yui> a()
  {
    return yui.class;
  }
  
  @NonNull
  public yui a(int paramInt)
  {
    return new yui();
  }
  
  @Nullable
  public yui a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      yui localyui = yui.a(paramArrayOfaogf[0].a);
      QLog.i("Q.videostory.config.VSEntranceProcessor", 2, "onParsed " + paramArrayOfaogf[0].a);
      a(localyui);
      return localyui;
    }
    QLog.e("Q.videostory.config.VSEntranceProcessor", 2, "onParsed conf content is null!");
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(yui paramyui)
  {
    if (paramyui != null)
    {
      yuh.a().a("mine_videostory_entrance", paramyui.a());
      yuh.a().a("enable_click_take_picture", paramyui.b());
      yuh.a().a("mine_videostory_drawer_entrance", paramyui.c());
      QLog.i("Q.videostory.config.VSEntranceProcessor", 2, "onUpdate:" + paramyui.toString());
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
 * Qualified Name:     yuj
 * JD-Core Version:    0.7.0.1
 */