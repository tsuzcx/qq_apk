import android.graphics.Bitmap;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;

public class veu
{
  private static volatile veu jdField_a_of_type_Veu;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  
  public static veu a()
  {
    if (jdField_a_of_type_Veu == null) {}
    try
    {
      if (jdField_a_of_type_Veu == null) {
        jdField_a_of_type_Veu = new veu();
      }
      return jdField_a_of_type_Veu;
    }
    finally {}
  }
  
  private void a(DiniFlyAnimationView paramDiniFlyAnimationView, Bitmap paramBitmap, vew paramvew)
  {
    vmp.a("WSLiveAnimation", "[WSLiveAnimationManager.java]:[startAnimation()]:" + paramDiniFlyAnimationView);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = veq.a(paramDiniFlyAnimationView);
    }
    vmp.a("WSLiveAnimation", "[WSLiveAnimationManager.java]:[startAnimation()]sBitmapLiveLogo:" + this.jdField_a_of_type_AndroidGraphicsBitmap);
    veq.a(paramDiniFlyAnimationView, this.jdField_a_of_type_AndroidGraphicsBitmap, paramBitmap, paramvew);
  }
  
  private void b(DiniFlyAnimationView paramDiniFlyAnimationView, String paramString, vew paramvew)
  {
    paramString = vnd.a(paramString);
    tlw localtlw = new tlw();
    localtlw.a = paramString;
    tlv.a().a(localtlw, new vev(this, paramDiniFlyAnimationView, paramvew));
  }
  
  public void a(DiniFlyAnimationView paramDiniFlyAnimationView)
  {
    vmp.a("WSLiveAnimation", "[WSLiveAnimationManager.java]:[stopAnimation()]" + paramDiniFlyAnimationView);
    if (paramDiniFlyAnimationView != null) {
      paramDiniFlyAnimationView.cancelAnimation();
    }
  }
  
  public void a(DiniFlyAnimationView paramDiniFlyAnimationView, String paramString, vew paramvew)
  {
    b(paramDiniFlyAnimationView, paramString, paramvew);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     veu
 * JD-Core Version:    0.7.0.1
 */