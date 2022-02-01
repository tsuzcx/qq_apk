import UserGrowth.stSchema;
import android.app.Activity;
import android.text.TextUtils;

public class upu
  extends upq
{
  public upu(ups paramups)
  {
    super(paramups);
  }
  
  private void a(ups paramups)
  {
    if ((paramups.a() instanceof Activity))
    {
      uxm localuxm = paramups.a();
      uxi.a((Activity)paramups.a(), new upv(this, paramups, localuxm));
    }
  }
  
  private void b(ups paramups)
  {
    if (!TextUtils.isEmpty(paramups.a().schema)) {}
    for (String str = paramups.a().schema;; str = "weishi://main")
    {
      uyc.a(paramups.a(), "biz_src_jc_gzh_weishi", str);
      if (paramups.a() != null) {
        paramups.a().a();
      }
      return;
    }
  }
  
  public boolean a(ups paramups)
  {
    if (paramups.a()) {
      a(paramups);
    }
    for (;;)
    {
      return true;
      b(paramups);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     upu
 * JD-Core Version:    0.7.0.1
 */