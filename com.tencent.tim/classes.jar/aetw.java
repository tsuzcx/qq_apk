import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aetw
  extends aehv<aetv>
{
  public static aetv a()
  {
    return (aetv)aeif.a().o(569);
  }
  
  @NonNull
  public aetv a(int paramInt)
  {
    return new aetv();
  }
  
  public void a(aetv paramaetv) {}
  
  @Nullable
  public aetv b(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0)) {
      return aetv.a(paramArrayOfaeic);
    }
    return null;
  }
  
  public Class<aetv> clazz()
  {
    return aetv.class;
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
    QLog.d("TencentDocFormKeyWordsProcessor", 1, "TIM_CONVERT_TEAMWORK_CONFIG failed, resultCode:" + paramInt);
  }
  
  public int type()
  {
    return 569;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aetw
 * JD-Core Version:    0.7.0.1
 */