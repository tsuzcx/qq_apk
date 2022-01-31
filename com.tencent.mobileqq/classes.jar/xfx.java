import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class xfx
  extends ampb<xfw>
{
  private void a(String paramString1, String paramString2)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onUpdate() apply new widget config");
    if (!TextUtils.isEmpty(paramString2))
    {
      xfr.a().a("KEY_BOOLEAN_APPLY_WIDGET_CONFIG", Boolean.valueOf(true));
      xfr.a().a("KEY_VS_ENTRANCE_WIDGET_MD5", paramString1);
      xfr.a().a("KEY_VS_ENTRANCE_WIDGET_CONTENT", paramString2);
    }
  }
  
  public int a()
  {
    return 474;
  }
  
  public Class<xfw> a()
  {
    return xfw.class;
  }
  
  @NonNull
  public xfw a(int paramInt)
  {
    return new xfw();
  }
  
  @Nullable
  public xfw a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      QLog.i("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onParsed " + paramArrayOfampi[0].a);
      xfw localxfw = xfw.a(paramArrayOfampi[0].a);
      if (localxfw == null)
      {
        QLog.e("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onParsed error!");
        return null;
      }
      String str = (String)xfr.a().a("KEY_VS_ENTRANCE_WIDGET_MD5", "");
      if ((!TextUtils.isEmpty(localxfw.b())) && (!localxfw.b().equals(str)))
      {
        xgj.a().a(localxfw);
        a(localxfw.b(), paramArrayOfampi[0].a);
      }
      return localxfw;
    }
    QLog.e("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onParsed conf content is null!");
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(xfw paramxfw)
  {
    if (paramxfw != null) {
      QLog.i("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onUpdate:" + paramxfw.toString());
    }
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xfx
 * JD-Core Version:    0.7.0.1
 */