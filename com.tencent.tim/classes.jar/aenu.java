import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aenu
  extends aehv<aenu.a>
{
  @NonNull
  public aenu.a a(int paramInt)
  {
    return new aenu.a();
  }
  
  @Nullable
  public aenu.a a(aeic[] paramArrayOfaeic)
  {
    aenu.a locala = new aenu.a();
    if (QLog.isColorLevel()) {
      QLog.d("ScencesEmotionConfigProcessor", 2, "onParsed confFiles.length = " + paramArrayOfaeic.length);
    }
    if (paramArrayOfaeic.length > 0)
    {
      paramArrayOfaeic = paramArrayOfaeic[0];
      locala.taskId = paramArrayOfaeic.taskId;
      locala.content = paramArrayOfaeic.content;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScencesEmotionConfigProcessor", 2, "onParsed taskId = " + locala.taskId + " | content = " + locala.content);
    }
    return locala;
  }
  
  public void a(aenu.a parama)
  {
    if ((parama != null) && (parama.content != null)) {
      try
      {
        String str = parama.content;
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (QLog.isColorLevel()) {
          QLog.d("ScencesEmotionConfigProcessor", 2, "onUpdate content = " + parama.content);
        }
        yhp.r(localQQAppInterface, str);
        ScenesRecommendManager.a(localQQAppInterface).cis();
        return;
      }
      catch (Exception parama)
      {
        parama.printStackTrace();
        QLog.e("ScencesEmotionConfigProcessor", 2, "onUpdate has exception", parama);
        return;
      }
    }
    QLog.e("ScencesEmotionConfigProcessor", 2, "onUpdate has empty content newConf is null = " + null);
  }
  
  public Class<aenu.a> clazz()
  {
    return aenu.a.class;
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
      QLog.d("ScencesEmotionConfigProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScencesEmotionConfigProcessor", 2, "onReqFailed, code = " + paramInt);
    }
  }
  
  public int type()
  {
    return 621;
  }
  
  public static class a
  {
    public String content = "";
    public int taskId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aenu
 * JD-Core Version:    0.7.0.1
 */