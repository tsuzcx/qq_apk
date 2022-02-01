import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aepq
  extends aehv<aepp>
{
  @NonNull
  public aepp a(int paramInt)
  {
    return new aepp();
  }
  
  @Nullable
  public aepp a(aeic[] paramArrayOfaeic)
  {
    QLog.i("QFileAppStorePromoteConfigProcessor<QFile>", 1, "onParsed");
    if (paramArrayOfaeic != null) {
      try
      {
        if (paramArrayOfaeic.length > 0)
        {
          paramArrayOfaeic = (aepp)aeij.a(paramArrayOfaeic[0].content, aepp.class);
          return paramArrayOfaeic;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaeic) {}
    }
    return null;
  }
  
  public void a(aepp paramaepp)
  {
    if (paramaepp == null) {
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
        localEditor.putString("yyb_promote_action_key", paramaepp.bAw);
        localEditor.apply();
        localObject = (agiq)((QQAppInterface)localObject).getManager(317);
        if (localObject == null) {
          break;
        }
        ((agiq)localObject).b(paramaepp);
        return;
      }
    }
  }
  
  public Class<aepp> clazz()
  {
    return aepp.class;
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
    return 626;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aepq
 * JD-Core Version:    0.7.0.1
 */