import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aelf
  extends aehv<aele>
{
  public static aele a()
  {
    return (aele)aeif.a().o(572);
  }
  
  @NonNull
  public aele a(int paramInt)
  {
    return new aele();
  }
  
  public void a(aele paramaele)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotificationBannerConfProcessor", 2, "onUpdate " + paramaele.toString());
    }
  }
  
  @Nullable
  public aele b(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      new aele();
      return aele.a(paramArrayOfaeic);
    }
    return null;
  }
  
  public Class<aele> clazz()
  {
    return aele.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
    return 572;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aelf
 * JD-Core Version:    0.7.0.1
 */