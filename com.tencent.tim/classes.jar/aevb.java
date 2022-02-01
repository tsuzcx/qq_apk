import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public final class aevb
  extends aehv<aeva>
{
  public static void initConfig()
  {
    QLog.d("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "initConfig");
    aeva.a(false, (aeva)aeif.a().o(501));
  }
  
  @NonNull
  public aeva a(int paramInt)
  {
    QLog.w("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    return new aeva();
  }
  
  public void a(aeva paramaeva)
  {
    QLog.w("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "onUpdate");
    aeva.a(true, paramaeva);
  }
  
  @Nullable
  public aeva b(aeic[] paramArrayOfaeic)
  {
    return aeva.a(paramArrayOfaeic);
  }
  
  public Class<aeva> clazz()
  {
    return aeva.class;
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
  
  public void onReqFailed(int paramInt)
  {
    QLog.e("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public int type()
  {
    return 501;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aevb
 * JD-Core Version:    0.7.0.1
 */