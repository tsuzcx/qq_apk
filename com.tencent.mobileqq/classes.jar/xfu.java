import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class xfu
  extends ampa<xft>
{
  private void a(String paramString1, String paramString2)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onUpdate() apply new widget config");
    if (!TextUtils.isEmpty(paramString2))
    {
      xfo.a().a("KEY_BOOLEAN_APPLY_WIDGET_CONFIG", Boolean.valueOf(true));
      xfo.a().a("KEY_VS_ENTRANCE_WIDGET_MD5", paramString1);
      xfo.a().a("KEY_VS_ENTRANCE_WIDGET_CONTENT", paramString2);
    }
  }
  
  public int a()
  {
    return 474;
  }
  
  public Class<xft> a()
  {
    return xft.class;
  }
  
  @NonNull
  public xft a(int paramInt)
  {
    return new xft();
  }
  
  @Nullable
  public xft a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      QLog.i("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onParsed " + paramArrayOfamph[0].a);
      xft localxft = xft.a(paramArrayOfamph[0].a);
      if (localxft == null)
      {
        QLog.e("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onParsed error!");
        return null;
      }
      String str = (String)xfo.a().a("KEY_VS_ENTRANCE_WIDGET_MD5", "");
      if ((!TextUtils.isEmpty(localxft.b())) && (!localxft.b().equals(str)))
      {
        xgg.a().a(localxft);
        a(localxft.b(), paramArrayOfamph[0].a);
      }
      return localxft;
    }
    QLog.e("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onParsed conf content is null!");
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(xft paramxft)
  {
    if (paramxft != null) {
      QLog.i("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onUpdate:" + paramxft.toString());
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
 * Qualified Name:     xfu
 * JD-Core Version:    0.7.0.1
 */