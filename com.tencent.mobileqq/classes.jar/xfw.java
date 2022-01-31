import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class xfw
  extends ampa<xfv>
{
  public int a()
  {
    return 595;
  }
  
  public Class<xfv> a()
  {
    return xfv.class;
  }
  
  @NonNull
  public xfv a(int paramInt)
  {
    return new xfv();
  }
  
  @Nullable
  public xfv a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      xfv localxfv = xfv.a(paramArrayOfamph[0].a);
      a(localxfv);
      QLog.i("Q.videostory.config.VSStickyNoteProcessor", 2, "onParsed " + paramArrayOfamph[0].a);
      return localxfv;
    }
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(xfv paramxfv)
  {
    QLog.i("Q.videostory.config.VSStickyNoteProcessor", 2, "onUpdate ");
    if (paramxfv != null)
    {
      QLog.i("Q.videostory.config.VSStickyNoteProcessor", 2, "onUpdate " + paramxfv.toString());
      xfo.a().a("sticky_note_publish_entrance_config", paramxfv.a());
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
 * Qualified Name:     xfw
 * JD-Core Version:    0.7.0.1
 */