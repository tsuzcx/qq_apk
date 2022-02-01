import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aeln
  extends aehv<aelm>
{
  public static boolean ahi()
  {
    aelm localaelm = (aelm)aeif.a().o(632);
    if (localaelm != null) {}
    for (boolean bool = localaelm.ahi();; bool = false)
    {
      QLog.d("SDK_SHARE.OpenSdkFakeMsgProcessor", 1, new Object[] { "isEnableFakeMsg = ", Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  @NonNull
  public aelm a(int paramInt)
  {
    return new aelm();
  }
  
  public void a(aelm paramaelm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDK_SHARE.OpenSdkFakeMsgProcessor", 2, "onUpdate " + paramaelm.toString());
    }
  }
  
  @Nullable
  public aelm b(aeic[] paramArrayOfaeic)
  {
    int i = 0;
    if (paramArrayOfaeic == null) {}
    for (;;)
    {
      QLog.d("SDK_SHARE.OpenSdkFakeMsgProcessor", 1, new Object[] { "onParsed confFiles.length=", Integer.valueOf(i) });
      if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length <= 0)) {
        break;
      }
      new aelm();
      return aelm.a(paramArrayOfaeic);
      i = paramArrayOfaeic.length;
    }
    return null;
  }
  
  public Class<aelm> clazz()
  {
    return aelm.class;
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
    return 632;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeln
 * JD-Core Version:    0.7.0.1
 */