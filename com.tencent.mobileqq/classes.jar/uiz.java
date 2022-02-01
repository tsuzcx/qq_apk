import UserGrowth.stSchema;
import android.app.Activity;
import android.text.TextUtils;

public class uiz
  extends uiv
{
  public uiz(uix paramuix)
  {
    super(paramuix);
  }
  
  private void a(uix paramuix)
  {
    if ((paramuix.a() instanceof Activity))
    {
      upr localupr = paramuix.a();
      upn.a((Activity)paramuix.a(), new uja(this, paramuix, localupr));
    }
  }
  
  private void b(uix paramuix)
  {
    if (!TextUtils.isEmpty(paramuix.a().schema)) {}
    for (String str = paramuix.a().schema;; str = "weishi://main")
    {
      uqh.a(paramuix.a(), "biz_src_jc_gzh_weishi", str);
      if (paramuix.a() != null) {
        paramuix.a().a();
      }
      return;
    }
  }
  
  public boolean a(uix paramuix)
  {
    if (paramuix.a()) {
      a(paramuix);
    }
    for (;;)
    {
      return true;
      b(paramuix);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uiz
 * JD-Core Version:    0.7.0.1
 */