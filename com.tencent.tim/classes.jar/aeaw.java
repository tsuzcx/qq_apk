import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aeaw
  extends aehv<aeav>
{
  public static aeav a()
  {
    return (aeav)aeif.a().o(549);
  }
  
  @NonNull
  public aeav a(int paramInt)
  {
    return new aeav();
  }
  
  @Nullable
  public aeav a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      aeav localaeav = aeav.a(paramArrayOfaeic[0].content);
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteConfigProcessor", 2, "onParsed " + paramArrayOfaeic[0].content);
      }
      return localaeav;
    }
    return null;
  }
  
  public void a(aeav paramaeav) {}
  
  public Class clazz()
  {
    return aeav.class;
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
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteConfigProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 549;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeaw
 * JD-Core Version:    0.7.0.1
 */