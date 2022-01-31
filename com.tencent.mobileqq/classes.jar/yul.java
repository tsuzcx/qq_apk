import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class yul
  extends aofy<yuk>
{
  private void a(String paramString1, String paramString2)
  {
    QLog.d("Q.videostory.config.VSEntranceStyleProcessor", 2, "onUpdate() apply new style config");
    if (!TextUtils.isEmpty(paramString2))
    {
      yuh.a().a("KEY_BOOLEAN_APPLY_STYLE_CONFIG", Boolean.valueOf(true));
      yuh.a().a("KEY_VS_ENTRANCE_STYLE_MD5", paramString1);
      yuh.a().a("KEY_VS_ENTRANCE_STYLE_CONTENT", paramString2);
    }
  }
  
  public int a()
  {
    return 473;
  }
  
  public Class<yuk> a()
  {
    return yuk.class;
  }
  
  @NonNull
  public yuk a(int paramInt)
  {
    return new yuk();
  }
  
  @Nullable
  public yuk a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      QLog.i("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed " + paramArrayOfaogf[0].a);
      yuk localyuk = yuk.a(paramArrayOfaogf[0].a);
      if (localyuk == null)
      {
        QLog.e("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed error!");
        return null;
      }
      String str = (String)yuh.a().a("KEY_VS_ENTRANCE_STYLE_MD5", "");
      if ((!TextUtils.isEmpty(localyuk.b())) && (!localyuk.b().equals(str)))
      {
        yuz.a().a(localyuk);
        a(localyuk.b(), paramArrayOfaogf[0].a);
      }
      return localyuk;
    }
    QLog.e("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed conf content is null!");
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(yuk paramyuk)
  {
    if (paramyuk != null) {
      QLog.i("Q.videostory.config.VSEntranceStyleProcessor", 2, "onUpdate:" + paramyuk.toString());
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
 * Qualified Name:     yul
 * JD-Core Version:    0.7.0.1
 */