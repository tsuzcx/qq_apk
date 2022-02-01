import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aevj
  extends aehv<aevi>
{
  @NonNull
  public aevi a(int paramInt)
  {
    return new aevi();
  }
  
  @Nullable
  public aevi a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      paramArrayOfaeic = paramArrayOfaeic[0].content;
      QLog.i("SafeModeProcessor", 1, "onParsed: invoked.  content: " + paramArrayOfaeic);
      paramArrayOfaeic = aevi.a(paramArrayOfaeic);
      if (paramArrayOfaeic != null)
      {
        BaseApplicationImpl.getContext().getSharedPreferences("sp_safemode_test_crash_config", 4).edit().putBoolean("key_test_crash_switch", paramArrayOfaeic.bWD).apply();
        BaseApplicationImpl.getContext().getSharedPreferences("sp_safemode_test_crash", 0).edit().putBoolean("crash", paramArrayOfaeic.bWD).commit();
      }
      return paramArrayOfaeic;
    }
    return null;
  }
  
  public void a(aevi paramaevi) {}
  
  public Class<aevi> clazz()
  {
    return aevi.class;
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
    return 424;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aevj
 * JD-Core Version:    0.7.0.1
 */