import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class ajij
  extends aehv<ajii>
{
  @NonNull
  public ajii a(int paramInt)
  {
    return new ajii();
  }
  
  @Nullable
  public ajii a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOEntranceConfigProcessor", 2, "onParsed : " + paramArrayOfaeic[0].content);
      }
      return ajii.a(paramArrayOfaeic[0].content);
    }
    return new ajii();
  }
  
  public void a(ajii paramajii)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOEntranceConfigProcessor", 2, "onUpdate : " + paramajii);
    }
    ((ajik)BaseApplicationImpl.getApplication().getRuntime().getManager(325)).b(paramajii);
  }
  
  public Class<ajii> clazz()
  {
    return ajii.class;
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
      QLog.d("MultiAIOEntranceConfigProcessor", 2, "onUpdate : " + paramInt);
    }
  }
  
  public int type()
  {
    return 478;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajij
 * JD-Core Version:    0.7.0.1
 */