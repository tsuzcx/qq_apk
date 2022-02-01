import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aety
  extends aehv<aetx>
{
  public static aetx a()
  {
    return (aetx)aeif.a().o(338);
  }
  
  @NonNull
  public aetx a(int paramInt)
  {
    return new aetx();
  }
  
  public void a(aetx paramaetx) {}
  
  @Nullable
  public aetx b(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0)) {
      return aetx.a(paramArrayOfaeic);
    }
    return null;
  }
  
  public Class<aetx> clazz()
  {
    return aetx.class;
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
    QLog.d("TencentDocGrayTipsProcessor", 1, "TENCENT_DOC_GRAY_TIPS failed, resultCode:" + paramInt);
  }
  
  public int type()
  {
    return 338;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aety
 * JD-Core Version:    0.7.0.1
 */