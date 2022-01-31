import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class yun
  extends aofy<yum>
{
  private void a(String paramString1, String paramString2)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onUpdate() apply new widget config");
    if (!TextUtils.isEmpty(paramString2))
    {
      yuh.a().a("KEY_BOOLEAN_APPLY_WIDGET_CONFIG", Boolean.valueOf(true));
      yuh.a().a("KEY_VS_ENTRANCE_WIDGET_MD5", paramString1);
      yuh.a().a("KEY_VS_ENTRANCE_WIDGET_CONTENT", paramString2);
    }
  }
  
  public int a()
  {
    return 474;
  }
  
  public Class<yum> a()
  {
    return yum.class;
  }
  
  @NonNull
  public yum a(int paramInt)
  {
    return new yum();
  }
  
  @Nullable
  public yum a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      QLog.i("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onParsed " + paramArrayOfaogf[0].a);
      yum localyum = yum.a(paramArrayOfaogf[0].a);
      if (localyum == null)
      {
        QLog.e("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onParsed error!");
        return null;
      }
      String str = (String)yuh.a().a("KEY_VS_ENTRANCE_WIDGET_MD5", "");
      if ((!TextUtils.isEmpty(localyum.b())) && (!localyum.b().equals(str)))
      {
        yuz.a().a(localyum);
        a(localyum.b(), paramArrayOfaogf[0].a);
      }
      return localyum;
    }
    QLog.e("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onParsed conf content is null!");
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(yum paramyum)
  {
    if (paramyum != null) {
      QLog.i("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onUpdate:" + paramyum.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yun
 * JD-Core Version:    0.7.0.1
 */