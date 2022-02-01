import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.qphone.base.util.QLog;

public class zwy
  extends aptq<zwx>
{
  @NonNull
  public zwx a(int paramInt)
  {
    return new zwx();
  }
  
  @Nullable
  public zwx a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      zwx localzwx = zwx.a(paramArrayOfaptx[0].a);
      a(localzwx);
      QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, "onParsed " + paramArrayOfaptx[0].a);
      return localzwx;
    }
    return null;
  }
  
  public void a(zwx paramzwx)
  {
    QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, "onUpdate ");
    if (paramzwx != null)
    {
      QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, "onUpdate " + paramzwx.toString());
      VSConfigManager.getInstance().setValue("subscribe_entrance_enable", paramzwx.a());
      VSConfigManager.getInstance().setValue("is_open_sharing", paramzwx.b());
      VSConfigManager.getInstance().setValue("subscribe_account_title", paramzwx.c());
      VSConfigManager.getInstance().setValue("newfollowlist", paramzwx.d());
      VSConfigManager.getInstance().setValue("subscribe_publish_entrance_enable", paramzwx.e());
    }
  }
  
  public Class<zwx> clazz()
  {
    return zwx.class;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 463;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zwy
 * JD-Core Version:    0.7.0.1
 */