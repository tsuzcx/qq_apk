import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class xfz
  extends ampb<xfy>
{
  public int a()
  {
    return 595;
  }
  
  public Class<xfy> a()
  {
    return xfy.class;
  }
  
  @NonNull
  public xfy a(int paramInt)
  {
    return new xfy();
  }
  
  @Nullable
  public xfy a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      xfy localxfy = xfy.a(paramArrayOfampi[0].a);
      a(localxfy);
      QLog.i("Q.videostory.config.VSStickyNoteProcessor", 2, "onParsed " + paramArrayOfampi[0].a);
      return localxfy;
    }
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(xfy paramxfy)
  {
    QLog.i("Q.videostory.config.VSStickyNoteProcessor", 2, "onUpdate ");
    if (paramxfy != null)
    {
      QLog.i("Q.videostory.config.VSStickyNoteProcessor", 2, "onUpdate " + paramxfy.toString());
      xfr.a().a("sticky_note_publish_entrance_config", paramxfy.a());
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
 * Qualified Name:     xfz
 * JD-Core Version:    0.7.0.1
 */