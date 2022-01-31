import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class wwz
  extends alzl<wwy>
{
  private void a(String paramString1, String paramString2)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onUpdate() apply new widget config");
    if (!TextUtils.isEmpty(paramString2))
    {
      wwt.a().a("KEY_BOOLEAN_APPLY_WIDGET_CONFIG", Boolean.valueOf(true));
      wwt.a().a("KEY_VS_ENTRANCE_WIDGET_MD5", paramString1);
      wwt.a().a("KEY_VS_ENTRANCE_WIDGET_CONTENT", paramString2);
    }
  }
  
  public int a()
  {
    return 474;
  }
  
  public Class<wwy> a()
  {
    return wwy.class;
  }
  
  @NonNull
  public wwy a(int paramInt)
  {
    return new wwy();
  }
  
  @Nullable
  public wwy a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      QLog.i("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onParsed " + paramArrayOfalzs[0].a);
      wwy localwwy = wwy.a(paramArrayOfalzs[0].a);
      if (localwwy == null)
      {
        QLog.e("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onParsed error!");
        return null;
      }
      String str = (String)wwt.a().a("KEY_VS_ENTRANCE_WIDGET_MD5", "");
      if ((!TextUtils.isEmpty(localwwy.b())) && (!localwwy.b().equals(str)))
      {
        wxj.a().a(localwwy);
        a(localwwy.b(), paramArrayOfalzs[0].a);
      }
      return localwwy;
    }
    QLog.e("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onParsed conf content is null!");
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(wwy paramwwy)
  {
    if (paramwwy != null) {
      QLog.i("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onUpdate:" + paramwwy.toString());
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
 * Qualified Name:     wwz
 * JD-Core Version:    0.7.0.1
 */