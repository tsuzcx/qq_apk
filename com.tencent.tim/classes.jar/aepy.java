import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aepy
  extends aehv<aepx>
{
  @NonNull
  public aepx a(int paramInt)
  {
    return new aepx();
  }
  
  @Nullable
  public aepx a(aeic[] paramArrayOfaeic)
  {
    QLog.i("QFileExcitingC2CDownloadConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfaeic != null) {
      try
      {
        if (paramArrayOfaeic.length > 0)
        {
          paramArrayOfaeic = (aepx)aeij.a(paramArrayOfaeic[0].content, aepx.class);
          return paramArrayOfaeic;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaeic)
      {
        QLog.e("QFileExcitingC2CDownloadConfigProcessor<FileAssistant>", 1, "onParsed : error " + paramArrayOfaeic.getMessage());
      }
    }
    return null;
  }
  
  public void a(aepx paramaepx)
  {
    if (paramaepx != null)
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (!(localObject instanceof QQAppInterface)) {
        break label152;
      }
    }
    label152:
    for (Object localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        if (TextUtils.isEmpty(paramaepx.byc)) {
          paramaepx.byc = "{}";
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("c2cfile_excitingdownload_" + ((QQAppInterface)localObject).getCurrentUin(), 0).edit();
        localEditor.putString("qfile_c2cfile_excitingdownload", paramaepx.byc);
        localEditor.apply();
        QLog.i("QFileExcitingC2CDownloadConfigProcessor<FileAssistant>", 1, "save Exciting-C2C-Download config [" + paramaepx.byc + "]");
        localObject = (agiq)((QQAppInterface)localObject).getManager(317);
        if (localObject != null) {
          ((agiq)localObject).a(paramaepx);
        }
      }
      return;
    }
  }
  
  public Class<aepx> clazz()
  {
    return aepx.class;
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
    QLog.i("QFileExcitingC2CDownloadConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public int type()
  {
    return 556;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aepy
 * JD-Core Version:    0.7.0.1
 */