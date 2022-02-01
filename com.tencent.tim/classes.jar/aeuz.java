import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public final class aeuz
  extends aehv<aeuy>
{
  public static void initConfig()
  {
    QLog.d("TdsReaderView_TdsReaderConfigProcessor", 1, "initConfig");
    aeuy.a(false, (aeuy)aeif.a().o(482));
  }
  
  @NonNull
  public aeuy a(int paramInt)
  {
    QLog.w("TdsReaderView_TdsReaderConfigProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    return new aeuy();
  }
  
  public void a(aeuy paramaeuy)
  {
    QLog.w("TdsReaderView_TdsReaderConfigProcessor", 1, "onUpdate");
    aeuy.a(true, paramaeuy);
  }
  
  @Nullable
  public aeuy b(aeic[] paramArrayOfaeic)
  {
    return aeuy.a(paramArrayOfaeic);
  }
  
  public Class<aeuy> clazz()
  {
    return aeuy.class;
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
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    QLog.e("TdsReaderView_TdsReaderConfigProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public int type()
  {
    return 482;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeuz
 * JD-Core Version:    0.7.0.1
 */