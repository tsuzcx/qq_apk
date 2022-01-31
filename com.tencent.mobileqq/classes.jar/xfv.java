import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class xfv
  extends ampb<xfu>
{
  private void a(String paramString1, String paramString2)
  {
    QLog.d("Q.videostory.config.VSEntranceStyleProcessor", 2, "onUpdate() apply new style config");
    if (!TextUtils.isEmpty(paramString2))
    {
      xfr.a().a("KEY_BOOLEAN_APPLY_STYLE_CONFIG", Boolean.valueOf(true));
      xfr.a().a("KEY_VS_ENTRANCE_STYLE_MD5", paramString1);
      xfr.a().a("KEY_VS_ENTRANCE_STYLE_CONTENT", paramString2);
    }
  }
  
  public int a()
  {
    return 473;
  }
  
  public Class<xfu> a()
  {
    return xfu.class;
  }
  
  @NonNull
  public xfu a(int paramInt)
  {
    return new xfu();
  }
  
  @Nullable
  public xfu a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      QLog.i("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed " + paramArrayOfampi[0].a);
      xfu localxfu = xfu.a(paramArrayOfampi[0].a);
      if (localxfu == null)
      {
        QLog.e("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed error!");
        return null;
      }
      String str = (String)xfr.a().a("KEY_VS_ENTRANCE_STYLE_MD5", "");
      if ((!TextUtils.isEmpty(localxfu.b())) && (!localxfu.b().equals(str)))
      {
        xgj.a().a(localxfu);
        a(localxfu.b(), paramArrayOfampi[0].a);
      }
      return localxfu;
    }
    QLog.e("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed conf content is null!");
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(xfu paramxfu)
  {
    if (paramxfu != null) {
      QLog.i("Q.videostory.config.VSEntranceStyleProcessor", 2, "onUpdate:" + paramxfu.toString());
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
 * Qualified Name:     xfv
 * JD-Core Version:    0.7.0.1
 */