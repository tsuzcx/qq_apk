import UserGrowth.stSchema;
import android.app.Activity;
import android.text.TextUtils;

public class uik
  extends uig
{
  public uik(uii paramuii)
  {
    super(paramuii);
  }
  
  private void a(uii paramuii)
  {
    if ((paramuii.a() instanceof Activity))
    {
      uos localuos = paramuii.a();
      uoo.a((Activity)paramuii.a(), new uil(this, paramuii, localuos));
    }
  }
  
  private void b(uii paramuii)
  {
    if (!TextUtils.isEmpty(paramuii.a().schema)) {}
    for (String str = paramuii.a().schema;; str = "weishi://main")
    {
      upg.a(paramuii.a(), "biz_src_jc_gzh_weishi", str);
      if (paramuii.a() != null) {
        paramuii.a().a();
      }
      return;
    }
  }
  
  public boolean a(uii paramuii)
  {
    if (paramuii.a()) {
      a(paramuii);
    }
    for (;;)
    {
      return true;
      b(paramuii);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uik
 * JD-Core Version:    0.7.0.1
 */