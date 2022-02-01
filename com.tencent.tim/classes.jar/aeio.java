import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aeio
  extends aehv<aein>
{
  @NonNull
  public aein a(int paramInt)
  {
    QLog.d("TroopNotificationConfigProcessor.config", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new aein();
  }
  
  @Nullable
  public aein a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0)) {
      return aein.a(paramArrayOfaeic[0].content);
    }
    return null;
  }
  
  public void a(aein paramaein)
  {
    QLog.d("TroopNotificationConfigProcessor.config", 1, "onUpdate, newConf = " + paramaein);
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {}
  }
  
  public Class<aein> clazz()
  {
    return aein.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    QLog.d("TroopNotificationConfigProcessor.config", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public int type()
  {
    return 634;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeio
 * JD-Core Version:    0.7.0.1
 */