import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.qphone.base.util.QLog;

public class zwq
  extends aptq<zwp>
{
  @NonNull
  public zwp a(int paramInt)
  {
    return new zwp();
  }
  
  @Nullable
  public zwp a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      zwp localzwp = zwp.a(paramArrayOfaptx[0].a);
      QLog.i("Q.videostory.config.VSEntranceProcessor", 2, "onParsed " + paramArrayOfaptx[0].a);
      a(localzwp);
      return localzwp;
    }
    QLog.e("Q.videostory.config.VSEntranceProcessor", 2, "onParsed conf content is null!");
    return null;
  }
  
  public void a(zwp paramzwp)
  {
    if (paramzwp != null)
    {
      VSConfigManager.getInstance().setValue("mine_videostory_entrance", paramzwp.a());
      VSConfigManager.getInstance().setValue("enable_click_take_picture", paramzwp.b());
      VSConfigManager.getInstance().setValue("mine_videostory_drawer_entrance", paramzwp.c());
      QLog.i("Q.videostory.config.VSEntranceProcessor", 2, "onUpdate:" + paramzwp.toString());
    }
  }
  
  public Class<zwp> clazz()
  {
    return zwp.class;
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
    return 411;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zwq
 * JD-Core Version:    0.7.0.1
 */