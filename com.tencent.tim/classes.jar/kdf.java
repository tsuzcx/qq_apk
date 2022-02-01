import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class kdf
  extends aehv<kde>
{
  @NonNull
  public kde a(int paramInt)
  {
    if (paramInt == 0)
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        return kde.a(aqmj.bn(((QQAppInterface)localAppRuntime).getApplication()));
      }
    }
    return new kde();
  }
  
  public void a(kde paramkde)
  {
    paramkde.aBF();
    paramkde.update();
  }
  
  @Nullable
  public kde b(aeic[] paramArrayOfaeic)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0)) {
      return kde.a(paramArrayOfaeic);
    }
    return null;
  }
  
  public Class<kde> clazz()
  {
    return kde.class;
  }
  
  public boolean isNeedCompressed()
  {
    return false;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return aqmj.aY(((QQAppInterface)localAppRuntime).getApp());
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 32;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kdf
 * JD-Core Version:    0.7.0.1
 */