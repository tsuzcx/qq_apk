import UserGrowth.stSchema;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;

public class ujc
  extends uiv
{
  public ujc(uix paramuix)
  {
    super(paramuix);
  }
  
  public boolean a(uix paramuix)
  {
    MiniAppLauncher.MiniAppLaunchListener localMiniAppLaunchListener = paramuix.a();
    ueg.a(paramuix.a(), paramuix.a().miniAppSchema, new ujd(this, localMiniAppLaunchListener));
    if (paramuix.a() != null) {
      paramuix.a().b();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ujc
 * JD-Core Version:    0.7.0.1
 */