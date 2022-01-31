import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class yza
  extends aokh<yyz>
{
  private void a(String paramString1, String paramString2)
  {
    QLog.d("Q.videostory.config.VSEntranceStyleProcessor", 2, "onUpdate() apply new style config");
    if (!TextUtils.isEmpty(paramString2))
    {
      yyw.a().a("KEY_BOOLEAN_APPLY_STYLE_CONFIG", Boolean.valueOf(true));
      yyw.a().a("KEY_VS_ENTRANCE_STYLE_MD5", paramString1);
      yyw.a().a("KEY_VS_ENTRANCE_STYLE_CONTENT", paramString2);
    }
  }
  
  public int a()
  {
    return 473;
  }
  
  public Class<yyz> a()
  {
    return yyz.class;
  }
  
  @NonNull
  public yyz a(int paramInt)
  {
    return new yyz();
  }
  
  @Nullable
  public yyz a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      QLog.i("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed " + paramArrayOfaoko[0].a);
      yyz localyyz = yyz.a(paramArrayOfaoko[0].a);
      if (localyyz == null)
      {
        QLog.e("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed error!");
        return null;
      }
      String str = (String)yyw.a().a("KEY_VS_ENTRANCE_STYLE_MD5", "");
      if ((!TextUtils.isEmpty(localyyz.b())) && (!localyyz.b().equals(str)))
      {
        yzo.a().a(localyyz);
        a(localyyz.b(), paramArrayOfaoko[0].a);
      }
      return localyyz;
    }
    QLog.e("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed conf content is null!");
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(yyz paramyyz)
  {
    if (paramyyz != null) {
      QLog.i("Q.videostory.config.VSEntranceStyleProcessor", 2, "onUpdate:" + paramyyz.toString());
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
 * Qualified Name:     yza
 * JD-Core Version:    0.7.0.1
 */