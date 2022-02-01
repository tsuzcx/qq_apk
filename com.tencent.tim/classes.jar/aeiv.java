import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aeiv
  extends aehv<aeiw>
{
  @NonNull
  public aeiw a(int paramInt)
  {
    return new aeiw();
  }
  
  @Nullable
  public aeiw a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0) && (paramArrayOfaeic[0] != null))
    {
      aeiw localaeiw = aeiw.a(paramArrayOfaeic[0].content);
      if (QLog.isColorLevel()) {
        QLog.d("AppletNotificationConfProcessor", 2, "onParsed " + paramArrayOfaeic[0].content);
      }
      return localaeiw;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppletNotificationConfProcessor", 2, "onParsed is null");
    }
    aagv.aG(true);
    return null;
  }
  
  public void a(aeiw paramaeiw)
  {
    if (paramaeiw == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppletNotificationConfProcessor", 2, "onUpdate but newConf==null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppletNotificationConfProcessor", 2, "onUpdate " + paramaeiw.toString());
    }
    aagv.aG(true);
  }
  
  public Class<aeiw> clazz()
  {
    return aeiw.class;
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
    if (QLog.isColorLevel()) {
      QLog.d("AppletNotificationConfProcessor", 2, "migrateOldVersion");
    }
    aagv.aG(true);
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppletNotificationConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
    aagv.aG(true);
  }
  
  public int type()
  {
    return 597;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeiv
 * JD-Core Version:    0.7.0.1
 */