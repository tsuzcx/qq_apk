import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aevd
  extends aehv<aevc>
{
  public static aevc a()
  {
    aevc localaevc2 = (aevc)aeif.a().o(573);
    aevc localaevc1 = localaevc2;
    if (localaevc2 == null) {
      localaevc1 = new aevc();
    }
    return localaevc1;
  }
  
  @NonNull
  public aevc a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SuspiciousTroopConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new aevc();
  }
  
  @Nullable
  public aevc a(aeic[] paramArrayOfaeic)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SuspiciousTroopConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SuspiciousTroopConfProcessor", 2, "onParsed " + paramArrayOfaeic.length);
      }
      return aevc.a(paramArrayOfaeic[0]);
    }
    return null;
  }
  
  public void a(aevc paramaevc)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramaevc == null) {
        break label43;
      }
    }
    label43:
    for (paramaevc = paramaevc.toString();; paramaevc = " empty")
    {
      QLog.d("SuspiciousTroopConfProcessor", 2, paramaevc);
      return;
    }
  }
  
  public Class<aevc> clazz()
  {
    return aevc.class;
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
      QLog.e("SuspiciousTroopConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 573;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aevd
 * JD-Core Version:    0.7.0.1
 */