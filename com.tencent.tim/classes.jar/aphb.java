import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nullable;

public class aphb
  extends aehv<apha>
{
  @NonNull
  public apha a(int paramInt)
  {
    QLog.d("PublishHwkThirdPartyEntryConfig.config", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new apha();
  }
  
  public void a(apha paramapha) {}
  
  @Nullable
  public apha b(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0)) {
      return apha.a(paramArrayOfaeic);
    }
    return null;
  }
  
  public Class<apha> clazz()
  {
    return apha.class;
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
    QLog.d("PublishHwkThirdPartyEntryConfig.config", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public int type()
  {
    return 605;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aphb
 * JD-Core Version:    0.7.0.1
 */