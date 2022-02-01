import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aetk
  extends aehv<aetj>
{
  public static aetj a()
  {
    return (aetj)aeif.a().o(334);
  }
  
  @NonNull
  public aetj a(int paramInt)
  {
    return new aetj();
  }
  
  public void a(aetj paramaetj) {}
  
  @Nullable
  public aetj b(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0)) {
      return aetj.a(paramArrayOfaeic);
    }
    return null;
  }
  
  public Class<aetj> clazz()
  {
    return aetj.class;
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
    QLog.d("TencentDocAIOPlusPanelEntryConfigProcessor", 1, "AIO_PLUSPENAL_TENCENTDOC_ENRTY_CONFIG failed, resultCode:" + paramInt);
  }
  
  public int type()
  {
    return 334;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aetk
 * JD-Core Version:    0.7.0.1
 */