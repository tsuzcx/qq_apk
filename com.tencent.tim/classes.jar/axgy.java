import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.ViewGroup;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.play.PlayViewPagerAdapter;

class axgy
  implements axzv<axfz>
{
  axgy(axgv paramaxgv) {}
  
  public void a(@Nullable axfz paramaxfz)
  {
    if (paramaxfz == null) {}
    do
    {
      do
      {
        do
        {
          return;
          paramaxfz = paramaxfz.g;
          if (paramaxfz != AECaptureMode.NORMAL) {
            break;
          }
          if ((axgn.h == null) || (axgn.h != axbr.b())) {
            axip.a().acV("none");
          }
        } while (!this.this$0.aOe());
        axgv.a(this.this$0).setVisibility(8);
        return;
        if (paramaxfz != AECaptureMode.GIF) {
          break;
        }
      } while (!this.this$0.aOe());
      axgv.a(this.this$0).setVisibility(8);
      return;
    } while (paramaxfz != AECaptureMode.PLAY);
    axgv.c(this.this$0);
    if (axgv.a(this.this$0) != null)
    {
      paramaxfz = axgv.a(this.this$0).HN();
      if ((!TextUtils.isEmpty(paramaxfz)) && (!"-1".equals(paramaxfz))) {
        axip.a().acV(paramaxfz);
      }
    }
    axgv.a(this.this$0).setVisibility(0);
    axgv.d(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axgy
 * JD-Core Version:    0.7.0.1
 */