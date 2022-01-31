import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class yzc
  extends aokh<yzb>
{
  private void a(String paramString1, String paramString2)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onUpdate() apply new widget config");
    if (!TextUtils.isEmpty(paramString2))
    {
      yyw.a().a("KEY_BOOLEAN_APPLY_WIDGET_CONFIG", Boolean.valueOf(true));
      yyw.a().a("KEY_VS_ENTRANCE_WIDGET_MD5", paramString1);
      yyw.a().a("KEY_VS_ENTRANCE_WIDGET_CONTENT", paramString2);
    }
  }
  
  public int a()
  {
    return 474;
  }
  
  public Class<yzb> a()
  {
    return yzb.class;
  }
  
  @NonNull
  public yzb a(int paramInt)
  {
    return new yzb();
  }
  
  @Nullable
  public yzb a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      QLog.i("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onParsed " + paramArrayOfaoko[0].a);
      yzb localyzb = yzb.a(paramArrayOfaoko[0].a);
      if (localyzb == null)
      {
        QLog.e("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onParsed error!");
        return null;
      }
      String str = (String)yyw.a().a("KEY_VS_ENTRANCE_WIDGET_MD5", "");
      if ((!TextUtils.isEmpty(localyzb.b())) && (!localyzb.b().equals(str)))
      {
        yzo.a().a(localyzb);
        a(localyzb.b(), paramArrayOfaoko[0].a);
      }
      return localyzb;
    }
    QLog.e("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onParsed conf content is null!");
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(yzb paramyzb)
  {
    if (paramyzb != null) {
      QLog.i("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onUpdate:" + paramyzb.toString());
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
 * Qualified Name:     yzc
 * JD-Core Version:    0.7.0.1
 */