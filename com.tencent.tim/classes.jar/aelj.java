import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aelj
  extends aehv<aeli>
{
  public static aeli a()
  {
    return (aeli)aeif.a().o(426);
  }
  
  public static boolean ahf()
  {
    aeli localaeli = a();
    if (localaeli != null) {}
    for (boolean bool = localaeli.ahf();; bool = false)
    {
      QLog.d("OpenSdkConfProcessor", 1, new Object[] { "isUseThirdTransformPkgName, useThirdTransformPkgName = ", Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  @NonNull
  public aeli a(int paramInt)
  {
    return new aeli();
  }
  
  public void a(aeli paramaeli)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenSdkConfProcessor", 2, "onUpdate " + paramaeli.toString());
    }
  }
  
  @Nullable
  public aeli b(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      new aeli();
      return aeli.a(paramArrayOfaeic);
    }
    return null;
  }
  
  public Class<aeli> clazz()
  {
    return aeli.class;
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
    return 426;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aelj
 * JD-Core Version:    0.7.0.1
 */