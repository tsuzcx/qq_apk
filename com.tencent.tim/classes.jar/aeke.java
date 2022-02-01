import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aeke
  extends aehv<aekd>
{
  @NonNull
  public aekd a(int paramInt)
  {
    return new aekd();
  }
  
  @Nullable
  public aekd a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0) && (paramArrayOfaeic[0] != null))
    {
      aekd localaekd = aekd.a(paramArrayOfaeic[0].content);
      if (QLog.isColorLevel()) {
        QLog.d("GlobalSearchConfProcessor", 2, "onParsed " + paramArrayOfaeic[0].content);
      }
      return localaekd;
    }
    return null;
  }
  
  public void a(aekd paramaekd)
  {
    com.tencent.mobileqq.search.util.SearchConfigManager.needSeparate = paramaekd.agK();
    if (QLog.isColorLevel()) {
      QLog.d("GlobalSearchConfProcessor", 2, "onUpdate " + paramaekd.toString());
    }
  }
  
  public Class<aekd> clazz()
  {
    return aekd.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 414;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeke
 * JD-Core Version:    0.7.0.1
 */