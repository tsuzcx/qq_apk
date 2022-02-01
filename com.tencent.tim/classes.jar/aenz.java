import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aenz
  extends aehv<aeoa>
{
  @NonNull
  public aeoa a(int paramInt)
  {
    return new aeoa();
  }
  
  @Nullable
  public aeoa a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0) && (paramArrayOfaeic[0] != null)) {
      return aeoa.a(paramArrayOfaeic[0].content);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(aeoa paramaeoa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountConfProcessor", 2, "onUpdate " + paramaeoa.toString());
    }
  }
  
  public Class<aeoa> clazz()
  {
    return aeoa.class;
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
      QLog.d("SubAccountConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 607;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aenz
 * JD-Core Version:    0.7.0.1
 */