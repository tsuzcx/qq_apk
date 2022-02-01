import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.qphone.base.util.QLog;

public class zww
  extends aptq<zwv>
{
  @NonNull
  public zwv a(int paramInt)
  {
    return new zwv();
  }
  
  @Nullable
  public zwv a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      zwv localzwv = zwv.a(paramArrayOfaptx[0].a);
      a(localzwv);
      QLog.i("Q.videostory.config.VSStickyNoteProcessor", 2, "onParsed " + paramArrayOfaptx[0].a);
      return localzwv;
    }
    return null;
  }
  
  public void a(zwv paramzwv)
  {
    QLog.i("Q.videostory.config.VSStickyNoteProcessor", 2, "onUpdate ");
    if (paramzwv != null)
    {
      QLog.i("Q.videostory.config.VSStickyNoteProcessor", 2, "onUpdate " + paramzwv.toString());
      VSConfigManager.getInstance().setValue("sticky_note_publish_entrance_config", paramzwv.a());
    }
  }
  
  public Class<zwv> clazz()
  {
    return zwv.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 595;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zww
 * JD-Core Version:    0.7.0.1
 */