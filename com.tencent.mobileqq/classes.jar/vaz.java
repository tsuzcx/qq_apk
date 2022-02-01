import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.TMG.utils.QLog;

public class vaz
  extends aqwt<vay>
{
  @NonNull
  public vay a(int paramInt)
  {
    return new vay();
  }
  
  @Nullable
  public vay a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      vmp.d("WeSeeConfigProcessor", "onParsed:" + paramArrayOfaqxa[0].a);
      vay localvay = new vay();
      localvay.a(paramArrayOfaqxa[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WeSeeConfigProcessor", 0, "onParsed " + paramArrayOfaqxa[0].a);
      }
      return localvay;
    }
    return null;
  }
  
  public void a(vay paramvay)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeSeeConfigProcessor", 0, "onUpdate " + paramvay);
    }
  }
  
  public Class<vay> clazz()
  {
    return vay.class;
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
 * Qualified Name:     vaz
 * JD-Core Version:    0.7.0.1
 */