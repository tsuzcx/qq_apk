import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aetm
  extends aehv<aetl>
{
  public static aetl a()
  {
    return (aetl)aeif.a().o(342);
  }
  
  @NonNull
  public aetl a(int paramInt)
  {
    return new aetl();
  }
  
  public void a(aetl paramaetl) {}
  
  @Nullable
  public aetl b(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0)) {
      return aetl.a(paramArrayOfaeic);
    }
    return null;
  }
  
  public Class<aetl> clazz()
  {
    return aetl.class;
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
    QLog.d("TencentDocAIOShowGuideDialogProcessor", 1, "TENCENT_DOC_AIO_SHOW_GUIDE_DIALOG failed, resultCode:" + paramInt);
  }
  
  public int type()
  {
    return 342;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aetm
 * JD-Core Version:    0.7.0.1
 */