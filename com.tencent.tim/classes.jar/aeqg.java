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

public class aeqg
  extends aehv<aeqf>
{
  @NonNull
  public aeqf a(int paramInt)
  {
    return new aeqf();
  }
  
  @Nullable
  public aeqf a(aeic[] paramArrayOfaeic)
  {
    QLog.i("QFileExcitingGroupUploadConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfaeic != null) {
      try
      {
        if (paramArrayOfaeic.length > 0)
        {
          paramArrayOfaeic = (aeqf)aeij.a(paramArrayOfaeic[0].content, aeqf.class);
          return paramArrayOfaeic;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaeic)
      {
        QLog.e("QFileExcitingGroupUploadConfigProcessor<FileAssistant>", 1, "onParsed : error " + paramArrayOfaeic.getMessage());
      }
    }
    return null;
  }
  
  public void a(aeqf paramaeqf)
  {
    if (paramaeqf != null)
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
        if (TextUtils.isEmpty(paramaeqf.byc)) {
          paramaeqf.byc = "{}";
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("groupfile_excitingupload_" + ((QQAppInterface)localObject).getCurrentUin(), 0).edit();
        localEditor.putString("qfile_groupfile_excitingupload", paramaeqf.byc);
        localEditor.apply();
        QLog.i("QFileExcitingGroupUploadConfigProcessor<FileAssistant>", 1, "save Exciting-Group-Upload config [" + paramaeqf.byc + "]");
        localObject = (agiq)((QQAppInterface)localObject).getManager(317);
        if (localObject != null) {
          ((agiq)localObject).a(paramaeqf);
        }
      }
      return;
    }
  }
  
  public Class<aeqf> clazz()
  {
    return aeqf.class;
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
    QLog.i("QFileExcitingGroupUploadConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public int type()
  {
    return 554;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeqg
 * JD-Core Version:    0.7.0.1
 */