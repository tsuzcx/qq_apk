import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aejh
  extends aehv<aeji>
{
  @NonNull
  public aeji a(int paramInt)
  {
    return new aeji();
  }
  
  @Nullable
  public aeji a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0) && (paramArrayOfaeic[0] != null))
    {
      aeji localaeji = aeji.a(paramArrayOfaeic[0].content);
      if (QLog.isColorLevel()) {
        QLog.d("BootOptimizeConfProcessor", 2, "onParsed " + paramArrayOfaeic[0].content);
      }
      return localaeji;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BootOptimizeConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(aeji paramaeji)
  {
    if (paramaeji == null) {
      if (QLog.isColorLevel()) {
        QLog.d("BootOptimizeConfProcessor", 2, "onUpdate but newConf==null");
      }
    }
    Object localObject;
    do
    {
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("BootOptimizeConfProcessor", 2, "onUpdate " + paramaeji.toString());
        }
        localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        aako.r((QQAppInterface)localObject, paramaeji.bUt);
        ((QQAppInterface)localObject).getApp().getSharedPreferences("acc_info" + ((QQAppInterface)localObject).getAccount(), 0).edit().putLong("PREF_PLUGIN_DELAY_TIME", paramaeji.Wh).apply();
        try
        {
          localObject = new File(((QQAppInterface)localObject).getApp().getFilesDir() + File.separator + "enableKernelServiceInVivo");
          if (paramaeji.bUu)
          {
            if (((File)localObject).exists()) {
              continue;
            }
            ((File)localObject).createNewFile();
          }
        }
        catch (Throwable paramaeji)
        {
          QLog.e("BootOptimizeConfProcessor", 1, "create file failed", paramaeji);
          return;
        }
      }
    } while (!((File)localObject).exists());
    ((File)localObject).delete();
  }
  
  public Class<aeji> clazz()
  {
    return aeji.class;
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
      QLog.d("BootOptimizeConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BootOptimizeConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 566;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aejh
 * JD-Core Version:    0.7.0.1
 */