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

public class aeqe
  extends aehv<aeqd>
{
  @NonNull
  public aeqd a(int paramInt)
  {
    return new aeqd();
  }
  
  @Nullable
  public aeqd a(aeic[] paramArrayOfaeic)
  {
    QLog.i("QFileExcitingGroupDownloadConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfaeic != null) {
      try
      {
        if (paramArrayOfaeic.length > 0)
        {
          paramArrayOfaeic = (aeqd)aeij.a(paramArrayOfaeic[0].content, aeqd.class);
          return paramArrayOfaeic;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaeic)
      {
        QLog.e("QFileExcitingGroupDownloadConfigProcessor<FileAssistant>", 1, "onParsed : error " + paramArrayOfaeic.getMessage());
      }
    }
    return null;
  }
  
  public void a(aeqd paramaeqd)
  {
    if (paramaeqd != null)
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
        if (TextUtils.isEmpty(paramaeqd.byc)) {
          paramaeqd.byc = "{}";
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("groupfile_excitingdownload_" + ((QQAppInterface)localObject).getCurrentUin(), 0).edit();
        localEditor.putString("qfile_groupfile_excitingdownload", paramaeqd.byc);
        localEditor.apply();
        QLog.i("QFileExcitingGroupDownloadConfigProcessor<FileAssistant>", 1, "save Exciting-Group-Download config [" + paramaeqd.byc + "]");
        localObject = (agiq)((QQAppInterface)localObject).getManager(317);
        if (localObject != null) {
          ((agiq)localObject).a(paramaeqd);
        }
      }
      return;
    }
  }
  
  public Class<aeqd> clazz()
  {
    return aeqd.class;
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
    QLog.i("QFileExcitingGroupDownloadConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public int type()
  {
    return 555;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeqe
 * JD-Core Version:    0.7.0.1
 */