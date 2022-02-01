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

public class aeqo
  extends aehv<aeqj>
{
  final String TAG = "QfileFileAssistantTipsConfigProcessor<FileAssistant>";
  
  @NonNull
  public aeqj a(int paramInt)
  {
    QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "migrateOldOrDefaultContent: type[" + paramInt + "]");
    return new aeqj();
  }
  
  @Nullable
  public aeqj a(aeic[] paramArrayOfaeic)
  {
    QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfaeic != null) {
      try
      {
        if (paramArrayOfaeic.length > 0)
        {
          paramArrayOfaeic = (aeqj)aeij.a(paramArrayOfaeic[0].content, aeqj.class);
          return paramArrayOfaeic;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaeic) {}
    }
    return null;
  }
  
  public void a(aeqj paramaeqj)
  {
    if (paramaeqj == null)
    {
      QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "onUpdate: newConf is null.");
      return;
    }
    QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "QfileFileAssistantTipsConfigProcessor onUpdate");
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject == null)
      {
        QLog.e("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "app is null!!!");
        return;
      }
      if (paramaeqj == null) {
        break;
      }
      if (TextUtils.isEmpty(paramaeqj.byc)) {
        paramaeqj.byc = "{}";
      }
      SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("qfile_file_assistant_tips" + ((QQAppInterface)localObject).getCurrentUin(), 0).edit();
      localEditor.putString("qfile_file_assistant_tips", paramaeqj.byc);
      localEditor.apply();
      QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "save FileAssistantTips config [" + paramaeqj.byc + "]");
      localObject = (agiq)((QQAppInterface)localObject).getManager(317);
      if (localObject == null) {
        break;
      }
      ((agiq)localObject).a(paramaeqj);
      return;
    }
  }
  
  public Class<aeqj> clazz()
  {
    return aeqj.class;
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
    QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public int type()
  {
    return 606;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeqo
 * JD-Core Version:    0.7.0.1
 */