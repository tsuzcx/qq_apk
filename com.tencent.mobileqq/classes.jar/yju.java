import android.os.Handler;
import android.os.Looper;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtPreLoader.1;
import com.tencent.gdtad.aditem.GdtPreLoader.2;

public final class yju
{
  private static volatile yju a;
  
  public static yju a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new yju();
      }
      return a;
    }
    finally {}
  }
  
  private void b(GdtAd paramGdtAd)
  {
    yny.a("GdtPreLoader", "preloadVideoAfterAdLoaded() called with: ad = [" + paramGdtAd + "]");
    if (!paramGdtAd.isVideoSplice()) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new GdtPreLoader.2(this, paramGdtAd));
  }
  
  public void a(GdtAd paramGdtAd)
  {
    new Handler(Looper.getMainLooper()).post(new GdtPreLoader.1(this, paramGdtAd));
    b(paramGdtAd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yju
 * JD-Core Version:    0.7.0.1
 */