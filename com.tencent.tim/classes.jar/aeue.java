import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aeue
  extends aehv<aeud>
{
  public static aeud a()
  {
    return (aeud)aeif.a().o(525);
  }
  
  @NonNull
  public aeud a(int paramInt)
  {
    return new aeud();
  }
  
  public void a(aeud paramaeud) {}
  
  @Nullable
  public aeud b(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0)) {
      return aeud.a(paramArrayOfaeic);
    }
    return null;
  }
  
  public Class<aeud> clazz()
  {
    return aeud.class;
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
    QLog.d("TencentDocLocalCooperationProcessor", 1, "TIM_CONVERT_TEAMWORK_CONFIG failed, resultCode:" + paramInt);
  }
  
  public int type()
  {
    return 525;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeue
 * JD-Core Version:    0.7.0.1
 */