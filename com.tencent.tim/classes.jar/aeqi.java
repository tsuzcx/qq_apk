import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aeqi
  extends aehv<aeqh>
{
  @NonNull
  public aeqh a(int paramInt)
  {
    QLog.i("QFileIPv6ConfigProcessor", 1, "migrateOldOrDefaultContent: type[" + paramInt + "]");
    return new aeqh();
  }
  
  @Nullable
  public aeqh a(aeic[] paramArrayOfaeic)
  {
    QLog.i("QFileIPv6ConfigProcessor", 1, "onParsed");
    if (paramArrayOfaeic != null) {
      try
      {
        if (paramArrayOfaeic.length > 0)
        {
          paramArrayOfaeic = (aeqh)aeij.a(paramArrayOfaeic[0].content, aeqh.class);
          return paramArrayOfaeic;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaeic) {}
    }
    return null;
  }
  
  public void a(aeqh paramaeqh)
  {
    if (paramaeqh == null) {
      QLog.i("QFileIPv6ConfigProcessor", 1, "FileIPv6Config onUpdate: newConf is null.");
    }
    label256:
    for (;;)
    {
      return;
      QLog.i("QFileIPv6ConfigProcessor", 1, "FileIPv6Config onUpdate");
      Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject1 instanceof QQAppInterface)) {}
      for (localObject1 = (QQAppInterface)localObject1;; localObject1 = null)
      {
        if (localObject1 == null) {
          break label256;
        }
        Object localObject2 = ((QQAppInterface)localObject1).getApp().getSharedPreferences("file_config_" + ((QQAppInterface)localObject1).getCurrentUin(), 0).edit();
        ((SharedPreferences.Editor)localObject2).putBoolean("ipv6_all_switch", paramaeqh.bVO);
        ((SharedPreferences.Editor)localObject2).putBoolean("ipv6_c2c_switch", paramaeqh.bVP);
        ((SharedPreferences.Editor)localObject2).putBoolean("ipv6_group_switch", paramaeqh.bVQ);
        ((SharedPreferences.Editor)localObject2).putBoolean("ipv6_disc_switch", paramaeqh.bVR);
        ((SharedPreferences.Editor)localObject2).putBoolean("ipv6_dataline_switch", paramaeqh.bVS);
        ((SharedPreferences.Editor)localObject2).putInt("ipv6_strategy", paramaeqh.strategy);
        ((SharedPreferences.Editor)localObject2).apply();
        localObject2 = new Bundle();
        ((Bundle)localObject2).putBoolean("ipv6_all_switch", paramaeqh.bVO);
        ((Bundle)localObject2).putBoolean("ipv6_c2c_switch", paramaeqh.bVP);
        ((Bundle)localObject2).putBoolean("ipv6_group_switch", paramaeqh.bVQ);
        ((Bundle)localObject2).putBoolean("ipv6_disc_switch", paramaeqh.bVR);
        ((Bundle)localObject2).putBoolean("ipv6_dataline_switch", paramaeqh.bVS);
        ((Bundle)localObject2).putInt("ipv6_strategy", paramaeqh.strategy);
        paramaeqh = (agiq)((QQAppInterface)localObject1).getManager(317);
        if (paramaeqh == null) {
          break;
        }
        paramaeqh.cy((Bundle)localObject2);
        return;
      }
    }
  }
  
  public Class<aeqh> clazz()
  {
    return aeqh.class;
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
    QLog.i("QFileIPv6ConfigProcessor", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public int type()
  {
    return 449;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeqi
 * JD-Core Version:    0.7.0.1
 */