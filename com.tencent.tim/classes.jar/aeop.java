import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aeop
  extends aehv<aeoo>
{
  @NonNull
  public static aeoo a()
  {
    aeoo localaeoo2 = (aeoo)aeif.a().o(435);
    aeoo localaeoo1 = localaeoo2;
    if (localaeoo2 == null) {
      localaeoo1 = new aeoo();
    }
    return localaeoo1;
  }
  
  @NonNull
  public aeoo a(int paramInt)
  {
    return new aeoo();
  }
  
  public void a(aeoo paramaeoo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopUrlConfProcessor", 2, "onUpdate " + paramaeoo.toString());
    }
  }
  
  @Nullable
  public aeoo b(aeic[] paramArrayOfaeic)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaeic != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaeic.length > 0) {
        localObject1 = aeoo.a(paramArrayOfaeic);
      }
    }
    return localObject1;
  }
  
  public Class<aeoo> clazz()
  {
    return aeoo.class;
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
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopUrlConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 435;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeop
 * JD-Core Version:    0.7.0.1
 */