import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aelb
  extends aehv<aela>
{
  private static aela a;
  
  public static aela b()
  {
    aela localaela2 = (aela)aeif.a().o(524);
    aela localaela1 = localaela2;
    if (localaela2 == null) {
      localaela1 = aela.a();
    }
    return localaela1;
  }
  
  @NonNull
  public aela a(int paramInt)
  {
    if (a != null) {
      return a;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    a = aela.a();
    return a;
  }
  
  @Nullable
  public aela a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      paramArrayOfaeic = aela.a(paramArrayOfaeic[0].content);
      a = null;
      return paramArrayOfaeic;
    }
    return aela.a();
  }
  
  public void a(aela paramaela)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkConfProcessor", 2, "onUpdate newConf:" + paramaela);
    }
  }
  
  public Class<aela> clazz()
  {
    return aela.class;
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
      QLog.d("MutualMarkConfProcessor", 2, "onReqFailed failCode:" + paramInt);
    }
  }
  
  public int type()
  {
    return 524;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aelb
 * JD-Core Version:    0.7.0.1
 */