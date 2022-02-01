import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aemj
  extends aehv<aemj.a>
{
  @NonNull
  public aemj.a a(int paramInt)
  {
    return new aemj.a();
  }
  
  @Nullable
  public aemj.a a(aeic[] paramArrayOfaeic)
  {
    aemj.a locala = new aemj.a();
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigProcessor", 2, "onParsed confFiles.length = " + paramArrayOfaeic.length);
    }
    if (paramArrayOfaeic.length > 0)
    {
      paramArrayOfaeic = paramArrayOfaeic[0];
      locala.taskId = paramArrayOfaeic.taskId;
      locala.content = paramArrayOfaeic.content;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigProcessor", 2, "onParsed taskId = " + locala.taskId + " | content = " + locala.content);
    }
    return locala;
  }
  
  public void a(aemj.a parama)
  {
    if ((parama != null) && (parama.content != null)) {
      try
      {
        String str = parama.content;
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (QLog.isColorLevel()) {
          QLog.d("QAssistantConfigProcessor", 2, "onUpdate content = " + parama.content);
        }
        aljk.r(localQQAppInterface, str);
        parama = (aljm)localQQAppInterface.getManager(352);
        if (parama != null) {
          parama.cis();
        }
        return;
      }
      catch (Exception parama)
      {
        parama.printStackTrace();
        QLog.e("QAssistantConfigProcessor", 2, "onUpdate has exception", parama);
        return;
      }
    }
    QLog.e("QAssistantConfigProcessor", 2, "onUpdate has empty content newConf is null = " + null);
  }
  
  public Class<aemj.a> clazz()
  {
    return aemj.a.class;
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
      QLog.d("QAssistantConfigProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigProcessor", 2, "onReqFailed, code = " + paramInt);
    }
  }
  
  public int type()
  {
    return 568;
  }
  
  public static class a
  {
    public String content = "";
    public int taskId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aemj
 * JD-Core Version:    0.7.0.1
 */