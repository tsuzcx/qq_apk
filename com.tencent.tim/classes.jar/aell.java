import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aell
  extends aehv<aelk>
{
  public static boolean ahh()
  {
    aelk localaelk = (aelk)aeif.a().o(613);
    if (localaelk != null) {}
    for (boolean bool = localaelk.ahg();; bool = false)
    {
      QLog.d("OpenSdkD55Processor", 1, new Object[] { "isSwitchOpen = ", Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  @NonNull
  public aelk a(int paramInt)
  {
    return new aelk();
  }
  
  public void a(aelk paramaelk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenSdkD55Processor", 2, "onUpdate " + paramaelk.toString());
    }
  }
  
  @Nullable
  public aelk b(aeic[] paramArrayOfaeic)
  {
    int i = 0;
    if (paramArrayOfaeic == null) {}
    for (;;)
    {
      QLog.d("OpenSdkD55Processor", 1, new Object[] { "onParsed confFiles.length=", Integer.valueOf(i) });
      if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length <= 0)) {
        break;
      }
      new aelk();
      return aelk.a(paramArrayOfaeic);
      i = paramArrayOfaeic.length;
    }
    return null;
  }
  
  public Class<aelk> clazz()
  {
    return aelk.class;
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
    return 613;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aell
 * JD-Core Version:    0.7.0.1
 */