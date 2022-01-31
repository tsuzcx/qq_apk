import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class yze
  extends aokh<yzd>
{
  public int a()
  {
    return 595;
  }
  
  public Class<yzd> a()
  {
    return yzd.class;
  }
  
  @NonNull
  public yzd a(int paramInt)
  {
    return new yzd();
  }
  
  @Nullable
  public yzd a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      yzd localyzd = yzd.a(paramArrayOfaoko[0].a);
      a(localyzd);
      QLog.i("Q.videostory.config.VSStickyNoteProcessor", 2, "onParsed " + paramArrayOfaoko[0].a);
      return localyzd;
    }
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(yzd paramyzd)
  {
    QLog.i("Q.videostory.config.VSStickyNoteProcessor", 2, "onUpdate ");
    if (paramyzd != null)
    {
      QLog.i("Q.videostory.config.VSStickyNoteProcessor", 2, "onUpdate " + paramyzd.toString());
      yyw.a().a("sticky_note_publish_entrance_config", paramyzd.a());
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
 * Qualified Name:     yze
 * JD-Core Version:    0.7.0.1
 */