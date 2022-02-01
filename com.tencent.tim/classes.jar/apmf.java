import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class apmf
  extends aehv<apme>
{
  @NonNull
  public apme a(int paramInt)
  {
    QLog.d("TroopHonor.config", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new apme();
  }
  
  @Nullable
  public apme a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0)) {
      return apme.a(paramArrayOfaeic[0].content);
    }
    return null;
  }
  
  public void a(apme paramapme)
  {
    QLog.d("TroopHonor.config", 1, "onUpdate, newConf = " + paramapme);
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((apmb)((QQAppInterface)localAppRuntime).getManager(346)).a(paramapme, false);
    }
  }
  
  public Class<apme> clazz()
  {
    return apme.class;
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
    QLog.d("TroopHonor.config", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public int type()
  {
    return 544;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apmf
 * JD-Core Version:    0.7.0.1
 */