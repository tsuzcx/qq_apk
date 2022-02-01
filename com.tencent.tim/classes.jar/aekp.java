import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aekp
  extends aehv<aeko>
{
  public static aeko a()
  {
    aeko localaeko2 = (aeko)aeif.a().o(581);
    aeko localaeko1 = localaeko2;
    if (localaeko2 == null) {
      localaeko1 = new aeko();
    }
    return localaeko1;
  }
  
  @NonNull
  public aeko a(int paramInt)
  {
    return new aeko();
  }
  
  @Nullable
  public aeko a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0) && (paramArrayOfaeic[0] != null))
    {
      aeko localaeko = aeko.a(paramArrayOfaeic[0].content);
      if (QLog.isColorLevel()) {
        QLog.d("Perf", 2, "onParsed " + paramArrayOfaeic[0].content);
      }
      return localaeko;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Perf", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(aeko paramaeko)
  {
    if (paramaeko == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Perf", 2, "onUpdate but newConf==null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Perf", 2, "onUpdate " + paramaeko.toString());
    }
    SharedPreferences.Editor localEditor = anmo.getLowDeviceSp().edit();
    localEditor.putBoolean("disablepreloadproc_new", paramaeko.bUC);
    localEditor.putBoolean("disablegettrooplist_new", paramaeko.bUE);
    localEditor.putBoolean("disablepredownload_new", paramaeko.bUD);
    localEditor.putBoolean("enableautoperf_new", paramaeko.bUF);
    localEditor.putString("userratio_new", paramaeko.byQ);
    localEditor.putString("extralsteps_new", paramaeko.byR);
    localEditor.putString("predownloadwhitelist_new", paramaeko.byS);
    localEditor.putBoolean("enable_thread_suspend", paramaeko.bUH);
    localEditor.putBoolean("fake_enable_thread_suspend", paramaeko.bUI);
    localEditor.commit();
  }
  
  public Class<aeko> clazz()
  {
    return aeko.class;
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
      QLog.d("Perf", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Perf", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 581;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aekp
 * JD-Core Version:    0.7.0.1
 */