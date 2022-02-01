import UserGrowth.stSchema;
import android.app.Activity;
import android.text.TextUtils;

public class vdv
  extends vdr
{
  public vdv(vdt paramvdt)
  {
    super(paramvdt);
  }
  
  private void a(vdt paramvdt)
  {
    if ((paramvdt.a() instanceof Activity))
    {
      vmb localvmb = paramvdt.a();
      vlx.a((Activity)paramvdt.a(), new vdw(this, paramvdt, localvmb));
    }
  }
  
  private void b(vdt paramvdt)
  {
    if (!TextUtils.isEmpty(paramvdt.a().schema)) {}
    for (String str = paramvdt.a().schema;; str = "weishi://main")
    {
      vmr.a(paramvdt.a(), "biz_src_jc_gzh_weishi", str);
      if (paramvdt.a() != null) {
        paramvdt.a().a();
      }
      return;
    }
  }
  
  public boolean a(vdt paramvdt)
  {
    if (paramvdt.a()) {
      a(paramvdt);
    }
    for (;;)
    {
      return true;
      b(paramvdt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdv
 * JD-Core Version:    0.7.0.1
 */