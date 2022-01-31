import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class xfs
  extends ampa<xfr>
{
  private void a(String paramString1, String paramString2)
  {
    QLog.d("Q.videostory.config.VSEntranceStyleProcessor", 2, "onUpdate() apply new style config");
    if (!TextUtils.isEmpty(paramString2))
    {
      xfo.a().a("KEY_BOOLEAN_APPLY_STYLE_CONFIG", Boolean.valueOf(true));
      xfo.a().a("KEY_VS_ENTRANCE_STYLE_MD5", paramString1);
      xfo.a().a("KEY_VS_ENTRANCE_STYLE_CONTENT", paramString2);
    }
  }
  
  public int a()
  {
    return 473;
  }
  
  public Class<xfr> a()
  {
    return xfr.class;
  }
  
  @NonNull
  public xfr a(int paramInt)
  {
    return new xfr();
  }
  
  @Nullable
  public xfr a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      QLog.i("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed " + paramArrayOfamph[0].a);
      xfr localxfr = xfr.a(paramArrayOfamph[0].a);
      if (localxfr == null)
      {
        QLog.e("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed error!");
        return null;
      }
      String str = (String)xfo.a().a("KEY_VS_ENTRANCE_STYLE_MD5", "");
      if ((!TextUtils.isEmpty(localxfr.b())) && (!localxfr.b().equals(str)))
      {
        xgg.a().a(localxfr);
        a(localxfr.b(), paramArrayOfamph[0].a);
      }
      return localxfr;
    }
    QLog.e("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed conf content is null!");
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(xfr paramxfr)
  {
    if (paramxfr != null) {
      QLog.i("Q.videostory.config.VSEntranceStyleProcessor", 2, "onUpdate:" + paramxfr.toString());
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
 * Qualified Name:     xfs
 * JD-Core Version:    0.7.0.1
 */