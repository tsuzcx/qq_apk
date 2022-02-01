import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aeps
  extends aehv<aepr>
{
  @NonNull
  public aepr a(int paramInt)
  {
    return new aepr();
  }
  
  @Nullable
  public aepr a(aeic[] paramArrayOfaeic)
  {
    QLog.i("QFileAppStorePromoteConfigProcessor<QFile>", 1, "onParsed");
    if (paramArrayOfaeic != null) {
      try
      {
        if (paramArrayOfaeic.length > 0)
        {
          paramArrayOfaeic = (aepr)aeij.a(paramArrayOfaeic[0].content, aepr.class);
          return paramArrayOfaeic;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaeic) {}
    }
    return null;
  }
  
  public void a(aepr paramaepr)
  {
    if (paramaepr == null) {
      QLog.i("QFileAppStorePromoteConfigProcessor<QFile>", 1, "onUpdate: newConf is null.");
    }
    label123:
    for (;;)
    {
      return;
      QLog.i("QFileAppStorePromoteConfigProcessor<QFile>", 1, "onUpdate");
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface)) {}
      for (localObject = (QQAppInterface)localObject;; localObject = null)
      {
        if (localObject == null) {
          break label123;
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("file_config_" + ((QQAppInterface)localObject).getCurrentUin(), 0).edit();
        localEditor.putString("yyb_promote_dialog_key", paramaepr.bAw);
        localEditor.apply();
        localObject = (agiq)((QQAppInterface)localObject).getManager(317);
        if (localObject == null) {
          break;
        }
        ((agiq)localObject).b(paramaepr);
        return;
      }
    }
  }
  
  public Class<aepr> clazz()
  {
    return aepr.class;
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
    return 625;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeps
 * JD-Core Version:    0.7.0.1
 */