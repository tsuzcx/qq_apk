import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.TMG.utils.QLog;

public class umz
  extends aptq<umy>
{
  @NonNull
  public umy a(int paramInt)
  {
    return new umy();
  }
  
  @Nullable
  public umy a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      uya.d("WeSeeConfigProcessor", "onParsed:" + paramArrayOfaptx[0].a);
      umy localumy = new umy();
      localumy.a(paramArrayOfaptx[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WeSeeConfigProcessor", 0, "onParsed " + paramArrayOfaptx[0].a);
      }
      return localumy;
    }
    return null;
  }
  
  public void a(umy paramumy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeSeeConfigProcessor", 0, "onUpdate " + paramumy);
    }
  }
  
  public Class<umy> clazz()
  {
    return umy.class;
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
 * Qualified Name:     umz
 * JD-Core Version:    0.7.0.1
 */