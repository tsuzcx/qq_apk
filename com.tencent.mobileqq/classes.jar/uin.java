import UserGrowth.stSchema;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;

public class uin
  extends uig
{
  public uin(uii paramuii)
  {
    super(paramuii);
  }
  
  public boolean a(uii paramuii)
  {
    MiniAppLauncher.MiniAppLaunchListener localMiniAppLaunchListener = paramuii.a();
    uee.a(paramuii.a(), paramuii.a().miniAppSchema, new uio(this, localMiniAppLaunchListener));
    if (paramuii.a() != null) {
      paramuii.a().b();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uin
 * JD-Core Version:    0.7.0.1
 */