import UserGrowth.stSchema;
import android.app.Activity;
import android.text.TextUtils;

public class ojr
  extends ojn
{
  public ojr(ojp paramojp)
  {
    super(paramojp);
  }
  
  private void a(ojp paramojp)
  {
    if ((paramojp.getContext() instanceof Activity))
    {
      ool.a locala = paramojp.a();
      ool.a((Activity)paramojp.getContext(), new ojs(this, paramojp, locala));
    }
  }
  
  private void b(ojp paramojp)
  {
    if (!TextUtils.isEmpty(paramojp.a().schema)) {}
    for (String str = paramojp.a().schema;; str = "weishi://main")
    {
      opb.p(paramojp.getContext(), "biz_src_jc_gzh_weishi", str);
      if (paramojp.a() != null) {
        paramojp.a().bfu();
      }
      return;
    }
  }
  
  public boolean a(ojp paramojp)
  {
    if (paramojp.GX()) {
      a(paramojp);
    }
    for (;;)
    {
      return true;
      b(paramojp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ojr
 * JD-Core Version:    0.7.0.1
 */