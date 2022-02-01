import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class spx
  extends aehv<spw>
{
  @NonNull
  public spw a(int paramInt)
  {
    return new spw();
  }
  
  @Nullable
  public spw a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      spw localspw = spw.a(paramArrayOfaeic[0].content);
      a(localspw);
      QLog.i("Q.videostory.config.VSStickyNoteProcessor", 2, "onParsed " + paramArrayOfaeic[0].content);
      return localspw;
    }
    return null;
  }
  
  public void a(spw paramspw)
  {
    QLog.i("Q.videostory.config.VSStickyNoteProcessor", 2, "onUpdate ");
    if (paramspw != null)
    {
      QLog.i("Q.videostory.config.VSStickyNoteProcessor", 2, "onUpdate " + paramspw.toString());
      spp.a().m("sticky_note_publish_entrance_config", paramspw.nI());
    }
  }
  
  public Class<spw> clazz()
  {
    return spw.class;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     spx
 * JD-Core Version:    0.7.0.1
 */