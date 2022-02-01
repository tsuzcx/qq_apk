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

public class aepu
  extends aehv<aept>
{
  @NonNull
  public aept a(int paramInt)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "migrateOldOrDefaultContent: type[" + paramInt + "]");
    return new aept();
  }
  
  @Nullable
  public aept a(aeic[] paramArrayOfaeic)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "onParsed");
    if (paramArrayOfaeic != null) {
      try
      {
        if (paramArrayOfaeic.length > 0)
        {
          paramArrayOfaeic = (aept)aeij.a(paramArrayOfaeic[0].content, aept.class);
          return paramArrayOfaeic;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaeic) {}
    }
    return null;
  }
  
  public void a(aept paramaept)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "onUpdate");
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface)) {}
    for (localObject1 = (QQAppInterface)localObject1;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        Object localObject2 = ((QQAppInterface)localObject1).getApp().getSharedPreferences("file_config_" + ((QQAppInterface)localObject1).getCurrentUin(), 0).edit();
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2c_up", paramaept.bVu);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2c_down", paramaept.bVv);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2czip_down", paramaept.bVw);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2c_thumb", paramaept.bVx);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disc_up", paramaept.bVy);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disc_down", paramaept.bVz);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disczip_down", paramaept.bVA);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disc_thumb", paramaept.bVB);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troop_up", paramaept.bVC);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troop_down", paramaept.bVD);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troopzip_down", paramaept.bVE);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troop_thumb", paramaept.bVF);
        ((SharedPreferences.Editor)localObject2).putBoolean("troop_video_preivew", paramaept.bVG);
        ((SharedPreferences.Editor)localObject2).putBoolean("troop_video_preivew_for_svip", paramaept.bVH);
        ((SharedPreferences.Editor)localObject2).putBoolean("troop_video_preivew_for_yearsvip", paramaept.bVI);
        ((SharedPreferences.Editor)localObject2).putBoolean("enable_file_media_platform", paramaept.bVJ);
        ((SharedPreferences.Editor)localObject2).apply();
        QLog.i("QFileCommonConfigProcessor", 1, "save download config." + paramaept.byc);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putBoolean("troop_video_preivew", paramaept.bVG);
        ((Bundle)localObject2).putBoolean("troop_video_preivew_for_svip", paramaept.bVH);
        ((Bundle)localObject2).putBoolean("troop_video_preivew_for_yearsvip", paramaept.bVI);
        ((Bundle)localObject2).putBoolean("enable_file_media_platform", paramaept.bVJ);
        paramaept = (agiq)((QQAppInterface)localObject1).getManager(317);
        if (paramaept != null) {
          paramaept.cx((Bundle)localObject2);
        }
      }
      return;
    }
  }
  
  public Class<aept> clazz()
  {
    return aept.class;
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
    QLog.i("QFileCommonConfigProcessor", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public int type()
  {
    return 396;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aepu
 * JD-Core Version:    0.7.0.1
 */