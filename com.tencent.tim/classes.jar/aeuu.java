import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public final class aeuu
  extends aehv<aeut>
{
  public static aeut a()
  {
    QLog.d("TencentDocUrl2DocConfigProcessor", 1, "getConfig");
    return (aeut)aeif.a().o(559);
  }
  
  public static boolean lL(String paramString)
  {
    aeut localaeut = a();
    return (localaeut != null) && (localaeut.isEnable()) && (localaeut.lL(paramString));
  }
  
  @NonNull
  public aeut a(int paramInt)
  {
    QLog.w("TencentDocUrl2DocConfigProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    return new aeut();
  }
  
  public void a(aeut paramaeut)
  {
    QLog.w("TencentDocUrl2DocConfigProcessor", 1, "onUpdate");
  }
  
  @Nullable
  public aeut b(aeic[] paramArrayOfaeic)
  {
    return aeut.a(paramArrayOfaeic);
  }
  
  public Class<aeut> clazz()
  {
    return aeut.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
    QLog.e("TencentDocUrl2DocConfigProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public int type()
  {
    return 559;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeuu
 * JD-Core Version:    0.7.0.1
 */