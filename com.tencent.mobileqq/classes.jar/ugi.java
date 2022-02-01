import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.TMG.utils.QLog;

public class ugi
  extends arac<ugh>
{
  @NonNull
  public ugh a(int paramInt)
  {
    return new ugh();
  }
  
  @Nullable
  public ugh a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      uqf.d("WeSeeConfigProcessor", "onParsed:" + paramArrayOfaraj[0].a);
      ugh localugh = new ugh();
      localugh.a(paramArrayOfaraj[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WeSeeConfigProcessor", 0, "onParsed " + paramArrayOfaraj[0].a);
      }
      return localugh;
    }
    return null;
  }
  
  public void a(ugh paramugh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeSeeConfigProcessor", 0, "onUpdate " + paramugh);
    }
  }
  
  public Class<ugh> clazz()
  {
    return ugh.class;
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
    return 447;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ugi
 * JD-Core Version:    0.7.0.1
 */