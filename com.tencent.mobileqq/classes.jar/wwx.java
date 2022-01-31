import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class wwx
  extends alzl<www>
{
  private void a(String paramString1, String paramString2)
  {
    QLog.d("Q.videostory.config.VSEntranceStyleProcessor", 2, "onUpdate() apply new style config");
    if (!TextUtils.isEmpty(paramString2))
    {
      wwt.a().a("KEY_BOOLEAN_APPLY_STYLE_CONFIG", Boolean.valueOf(true));
      wwt.a().a("KEY_VS_ENTRANCE_STYLE_MD5", paramString1);
      wwt.a().a("KEY_VS_ENTRANCE_STYLE_CONTENT", paramString2);
    }
  }
  
  public int a()
  {
    return 473;
  }
  
  public Class<www> a()
  {
    return www.class;
  }
  
  @NonNull
  public www a(int paramInt)
  {
    return new www();
  }
  
  @Nullable
  public www a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      QLog.i("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed " + paramArrayOfalzs[0].a);
      www localwww = www.a(paramArrayOfalzs[0].a);
      if (localwww == null)
      {
        QLog.e("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed error!");
        return null;
      }
      String str = (String)wwt.a().a("KEY_VS_ENTRANCE_STYLE_MD5", "");
      if ((!TextUtils.isEmpty(localwww.b())) && (!localwww.b().equals(str)))
      {
        wxj.a().a(localwww);
        a(localwww.b(), paramArrayOfalzs[0].a);
      }
      return localwww;
    }
    QLog.e("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed conf content is null!");
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(www paramwww)
  {
    if (paramwww != null) {
      QLog.i("Q.videostory.config.VSEntranceStyleProcessor", 2, "onUpdate:" + paramwww.toString());
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
 * Qualified Name:     wwx
 * JD-Core Version:    0.7.0.1
 */