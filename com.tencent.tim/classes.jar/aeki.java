import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aeki
  extends aehv<aekh>
{
  @NonNull
  public aekh a(int paramInt)
  {
    return new aekh();
  }
  
  public void a(aekh paramaekh)
  {
    QLog.i("LebaQzoneStyleProcessor", 1, "[onUpdate]");
  }
  
  @Nullable
  public aekh b(aeic[] paramArrayOfaeic)
  {
    QLog.i("LebaQzoneStyleProcessor", 1, "[onParsed] config");
    return aekh.a(paramArrayOfaeic);
  }
  
  public Class<aekh> clazz()
  {
    return aekh.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public boolean isNeedUpgradeReset()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    QLog.i("LebaQzoneStyleProcessor", 1, "[onReqFailed] failCode=" + paramInt);
  }
  
  public int type()
  {
    return 614;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeki
 * JD-Core Version:    0.7.0.1
 */