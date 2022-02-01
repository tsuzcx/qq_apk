import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ahyt
  extends aehv<ahys>
{
  private ahzd a()
  {
    try
    {
      ahzd localahzd = ahzd.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      return localahzd;
    }
    catch (Exception localException) {}
    return null;
  }
  
  @NonNull
  public ahys a(int paramInt)
  {
    ahys localahys = new ahys();
    if (QLog.isColorLevel()) {
      QLog.d("HotPicConfProcessor", 2, "migrateOldOrDefaultContent " + paramInt);
    }
    return localahys;
  }
  
  @Nullable
  public ahys a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      ahys localahys = ahys.a(paramArrayOfaeic[0].content);
      if (QLog.isColorLevel()) {
        QLog.d("HotPicConfProcessor", 2, "onParsed " + paramArrayOfaeic[0].content);
      }
      return localahys;
    }
    return null;
  }
  
  public void a(ahys paramahys)
  {
    ahzd localahzd = a();
    if (localahzd != null) {
      localahzd.PA(paramahys.RH);
    }
  }
  
  public Class<ahys> clazz()
  {
    return ahys.class;
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
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface != null) {
      return ahzd.P(localQQAppInterface);
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotPicConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 164;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahyt
 * JD-Core Version:    0.7.0.1
 */