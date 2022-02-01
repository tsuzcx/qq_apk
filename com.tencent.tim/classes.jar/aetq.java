import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aetq
  extends aehv<aetp>
{
  public static aetp a()
  {
    return (aetp)aeif.a().o(261);
  }
  
  @NonNull
  public aetp a(int paramInt)
  {
    return new aetp();
  }
  
  public void a(aetp paramaetp) {}
  
  @Nullable
  public aetp b(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0)) {
      return aetp.a(paramArrayOfaeic);
    }
    return null;
  }
  
  public Class<aetp> clazz()
  {
    return aetp.class;
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
    QLog.d("TencentDocConvertConfigProcessor", 1, "TIM_CONVERT_TEAMWORK_CONFIG failed, resultCode:" + paramInt);
  }
  
  public int type()
  {
    return 261;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aetq
 * JD-Core Version:    0.7.0.1
 */