import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class wny
  extends aehv<wnx>
{
  @NonNull
  public wnx a(int paramInt)
  {
    QLog.d("TroopDragonKingAnimEntryConfig.config", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new wnx();
  }
  
  @Nullable
  public wnx a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0)) {
      return wnx.a(paramArrayOfaeic[0].content);
    }
    return null;
  }
  
  public void a(wnx paramwnx) {}
  
  public Class<wnx> clazz()
  {
    return wnx.class;
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
    QLog.d("TroopDragonKingAnimEntryConfig.config", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public int type()
  {
    return 609;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wny
 * JD-Core Version:    0.7.0.1
 */