import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.tencent.gdtad.api.interstitial.GdtInterstitialFragment;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;

public final class yuk
{
  private GdtInterstitialParams jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams;
  private boolean jdField_a_of_type_Boolean;
  
  public yuk(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams)
  {
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams = paramGdtInterstitialParams;
    if (yul.a().a(paramContext)) {
      yuo.a().b(paramContext);
    }
  }
  
  private GdtInterstitialParams a()
  {
    return this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams;
  }
  
  public boolean a()
  {
    if ((!this.jdField_a_of_type_Boolean) && (a() != null)) {
      return a().b();
    }
    return false;
  }
  
  public boolean a(Activity paramActivity)
  {
    boolean bool1;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool1 = false;
    }
    for (;;)
    {
      yxs.b("GdtInterstitialAd", String.format("show %b", new Object[] { Boolean.valueOf(bool1) }));
      return bool1;
      if (!a())
      {
        bool1 = false;
      }
      else
      {
        boolean bool2 = GdtInterstitialFragment.a(paramActivity, a());
        bool1 = bool2;
        if (bool2)
        {
          this.jdField_a_of_type_Boolean = true;
          bool1 = true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yuk
 * JD-Core Version:    0.7.0.1
 */