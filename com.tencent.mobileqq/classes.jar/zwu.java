import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.qphone.base.util.QLog;

public class zwu
  extends aptq<zwt>
{
  private void a(String paramString1, String paramString2)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onUpdate() apply new widget config");
    if (!TextUtils.isEmpty(paramString2))
    {
      VSConfigManager.getInstance().setValue("KEY_BOOLEAN_APPLY_WIDGET_CONFIG", Boolean.valueOf(true));
      VSConfigManager.getInstance().setValue("KEY_VS_ENTRANCE_WIDGET_MD5", paramString1);
      VSConfigManager.getInstance().setValue("KEY_VS_ENTRANCE_WIDGET_CONTENT", paramString2);
    }
  }
  
  @NonNull
  public zwt a(int paramInt)
  {
    return new zwt();
  }
  
  @Nullable
  public zwt a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      QLog.i("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onParsed " + paramArrayOfaptx[0].a);
      zwt localzwt = zwt.a(paramArrayOfaptx[0].a);
      if (localzwt == null)
      {
        QLog.e("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onParsed error!");
        return null;
      }
      String str = (String)VSConfigManager.getInstance().getValue("KEY_VS_ENTRANCE_WIDGET_MD5", "");
      if ((!TextUtils.isEmpty(localzwt.b())) && (!localzwt.b().equals(str)))
      {
        zxg.a().a(localzwt);
        a(localzwt.b(), paramArrayOfaptx[0].a);
      }
      return localzwt;
    }
    QLog.e("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onParsed conf content is null!");
    return null;
  }
  
  public void a(zwt paramzwt)
  {
    if (paramzwt != null) {
      QLog.i("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onUpdate:" + paramzwt.toString());
    }
  }
  
  public Class<zwt> clazz()
  {
    return zwt.class;
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
    return 474;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zwu
 * JD-Core Version:    0.7.0.1
 */