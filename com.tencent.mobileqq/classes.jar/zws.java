import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.qphone.base.util.QLog;

public class zws
  extends aptq<zwr>
{
  private void a(String paramString1, String paramString2)
  {
    QLog.d("Q.videostory.config.VSEntranceStyleProcessor", 2, "onUpdate() apply new style config");
    if (!TextUtils.isEmpty(paramString2))
    {
      VSConfigManager.getInstance().setValue("KEY_BOOLEAN_APPLY_STYLE_CONFIG", Boolean.valueOf(true));
      VSConfigManager.getInstance().setValue("KEY_VS_ENTRANCE_STYLE_MD5", paramString1);
      VSConfigManager.getInstance().setValue("KEY_VS_ENTRANCE_STYLE_CONTENT", paramString2);
    }
  }
  
  @NonNull
  public zwr a(int paramInt)
  {
    return new zwr();
  }
  
  @Nullable
  public zwr a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      QLog.i("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed " + paramArrayOfaptx[0].a);
      zwr localzwr = zwr.a(paramArrayOfaptx[0].a);
      if (localzwr == null)
      {
        QLog.e("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed error!");
        return null;
      }
      String str = (String)VSConfigManager.getInstance().getValue("KEY_VS_ENTRANCE_STYLE_MD5", "");
      if ((!TextUtils.isEmpty(localzwr.b())) && (!localzwr.b().equals(str)))
      {
        zxg.a().a(localzwr);
        a(localzwr.b(), paramArrayOfaptx[0].a);
      }
      return localzwr;
    }
    QLog.e("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed conf content is null!");
    return null;
  }
  
  public void a(zwr paramzwr)
  {
    if (paramzwr != null) {
      QLog.i("Q.videostory.config.VSEntranceStyleProcessor", 2, "onUpdate:" + paramzwr.toString());
    }
  }
  
  public Class<zwr> clazz()
  {
    return zwr.class;
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
    return 473;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zws
 * JD-Core Version:    0.7.0.1
 */