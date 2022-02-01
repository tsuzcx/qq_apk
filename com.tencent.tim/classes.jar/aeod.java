import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aeod
  extends aehv<aeob>
{
  @NonNull
  public aeob a(int paramInt)
  {
    return new aeob();
  }
  
  public void a(aeob paramaeob)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocsPushProcessor", 2, "onUpdate " + paramaeob.toString());
    }
  }
  
  @Nullable
  public aeob b(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      new aeob();
      return aeob.a(paramArrayOfaeic);
    }
    return null;
  }
  
  public Class<aeob> clazz()
  {
    return aeob.class;
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
    return 418;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeod
 * JD-Core Version:    0.7.0.1
 */