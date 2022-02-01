import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class kdd
  extends aehv<kdc>
{
  @NonNull
  public kdc a(int paramInt)
  {
    if (paramInt == 0)
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)localObject;
        obt.m((QQAppInterface)localObject, obt.h((QQAppInterface)localObject));
        return kdc.a();
      }
    }
    return new kdc();
  }
  
  public void a(kdc paramkdc)
  {
    paramkdc.aBF();
    paramkdc.aBG();
  }
  
  @Nullable
  public kdc b(aeic[] paramArrayOfaeic)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountCenterUrlConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0)) {
      return kdc.a(paramArrayOfaeic);
    }
    return null;
  }
  
  public Class<kdc> clazz()
  {
    return kdc.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
      return obt.i((QQAppInterface)localAppRuntime);
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 70;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kdd
 * JD-Core Version:    0.7.0.1
 */