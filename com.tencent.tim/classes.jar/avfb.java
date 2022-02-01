import com.tencent.common.app.BaseApplicationImpl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class avfb
{
  private static avfb a;
  private static int ewP = -1;
  List<String> Ly = new ArrayList();
  String So;
  String cKl;
  String cKm = "https://sqimg.qq.com/qq_product_operations/gme_sdk/GME_SDK_V1.zip";
  String cKn = "105d1e43c456bc800b4adacd57ac1199";
  WeakReference<avfd> ja;
  String mAppid;
  String mUin;
  
  public static avfb a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new avfb();
      }
      return a;
    }
    finally {}
  }
  
  public void CT(String paramString)
  {
    aveo.a().CT(paramString);
  }
  
  public void Wu(boolean paramBoolean)
  {
    aveo.a().Ek(paramBoolean);
  }
  
  public void Wv(boolean paramBoolean)
  {
    aveo.a().El(paramBoolean);
  }
  
  public void a(avfd paramavfd)
  {
    this.ja = new WeakReference(paramavfd);
  }
  
  public void b(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mAppid = paramString1;
    this.mUin = paramString2;
    this.So = paramString3;
    this.cKl = paramString4;
    aveo.a().B(1, this.cKm, this.cKn);
    aveo.a().g(BaseApplicationImpl.getContext(), this.mUin, this.mAppid, "0", this.So);
    aveo.a().a(new avfc(this, paramBoolean1, paramBoolean2));
  }
  
  public void cOC()
  {
    this.ja = null;
    a = null;
  }
  
  public void jn(String paramString1, String paramString2)
  {
    this.cKm = paramString1;
    this.cKn = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avfb
 * JD-Core Version:    0.7.0.1
 */