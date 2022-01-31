import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class wwv
  extends alzl<wwu>
{
  public int a()
  {
    return 411;
  }
  
  public Class<wwu> a()
  {
    return wwu.class;
  }
  
  @NonNull
  public wwu a(int paramInt)
  {
    return new wwu();
  }
  
  @Nullable
  public wwu a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      wwu localwwu = wwu.a(paramArrayOfalzs[0].a);
      QLog.i("Q.videostory.config.VSEntranceProcessor", 2, "onParsed " + paramArrayOfalzs[0].a);
      a(localwwu);
      return localwwu;
    }
    QLog.e("Q.videostory.config.VSEntranceProcessor", 2, "onParsed conf content is null!");
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(wwu paramwwu)
  {
    if (paramwwu != null)
    {
      wwt.a().a("mine_videostory_entrance", paramwwu.a());
      wwt.a().a("enable_click_take_picture", paramwwu.b());
      wwt.a().a("mine_videostory_drawer_entrance", paramwwu.c());
      QLog.i("Q.videostory.config.VSEntranceProcessor", 2, "onUpdate:" + paramwwu.toString());
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
 * Qualified Name:     wwv
 * JD-Core Version:    0.7.0.1
 */