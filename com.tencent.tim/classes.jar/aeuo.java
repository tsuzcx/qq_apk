import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aeuo
  extends aehv<aeun>
{
  public static aeun a()
  {
    return (aeun)aeif.a().o(335);
  }
  
  @NonNull
  public aeun a(int paramInt)
  {
    return new aeun();
  }
  
  public void a(aeun paramaeun) {}
  
  @Nullable
  public aeun b(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0)) {
      return aeun.a(paramArrayOfaeic);
    }
    return null;
  }
  
  public Class<aeun> clazz()
  {
    return aeun.class;
  }
  
  public boolean isNeedCompressed()
  {
    return false;
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
    QLog.d("TencentDocSelectAddDocsProcessor", 1, "handleTencentDocUniversalEntry FILE_SELECT_ADD_DOCS failed, resultCode:" + paramInt);
  }
  
  public int type()
  {
    return 335;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeuo
 * JD-Core Version:    0.7.0.1
 */