import UserGrowth.stSchema;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;

public class vdy
  extends vdr
{
  public vdy(vdt paramvdt)
  {
    super(paramvdt);
  }
  
  public boolean a(vdt paramvdt)
  {
    MiniAppLauncher.MiniAppLaunchListener localMiniAppLaunchListener = paramvdt.a();
    uyt.a(paramvdt.a(), paramvdt.a().miniAppSchema, new vdz(this, localMiniAppLaunchListener));
    if (paramvdt.a() != null) {
      paramvdt.a().b();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdy
 * JD-Core Version:    0.7.0.1
 */