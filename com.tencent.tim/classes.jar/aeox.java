import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aeox
  extends aehv<aeow>
{
  @NonNull
  public aeow a(int paramInt)
  {
    return new aeow();
  }
  
  @Nullable
  public aeow a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0) && (paramArrayOfaeic[0] != null))
    {
      aeow localaeow = aeow.a(paramArrayOfaeic[0].content);
      if (QLog.isColorLevel()) {
        QLog.d("WVStatisticsConfProcessor", 2, "onParsed " + paramArrayOfaeic[0].content);
      }
      return localaeow;
    }
    return null;
  }
  
  public void a(aeow paramaeow)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVStatisticsConfProcessor", 2, "onUpdate " + paramaeow.toString());
    }
  }
  
  public Class<aeow> clazz()
  {
    return aeow.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
    return 361;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeox
 * JD-Core Version:    0.7.0.1
 */