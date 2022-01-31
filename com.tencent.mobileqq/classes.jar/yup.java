import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class yup
  extends aofy<yuo>
{
  public int a()
  {
    return 595;
  }
  
  public Class<yuo> a()
  {
    return yuo.class;
  }
  
  @NonNull
  public yuo a(int paramInt)
  {
    return new yuo();
  }
  
  @Nullable
  public yuo a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      yuo localyuo = yuo.a(paramArrayOfaogf[0].a);
      a(localyuo);
      QLog.i("Q.videostory.config.VSStickyNoteProcessor", 2, "onParsed " + paramArrayOfaogf[0].a);
      return localyuo;
    }
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(yuo paramyuo)
  {
    QLog.i("Q.videostory.config.VSStickyNoteProcessor", 2, "onUpdate ");
    if (paramyuo != null)
    {
      QLog.i("Q.videostory.config.VSStickyNoteProcessor", 2, "onUpdate " + paramyuo.toString());
      yuh.a().a("sticky_note_publish_entrance_config", paramyuo.a());
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
 * Qualified Name:     yup
 * JD-Core Version:    0.7.0.1
 */