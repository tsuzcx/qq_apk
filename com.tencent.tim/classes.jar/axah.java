import android.app.Activity;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.view.AECompoundButton;

class axah
  implements axzv<axfz>
{
  axah(axaf paramaxaf) {}
  
  public void a(@Nullable axfz paramaxfz)
  {
    if (paramaxfz == null) {}
    label211:
    do
    {
      return;
      paramaxfz = paramaxfz.g;
      if (paramaxfz == AECaptureMode.NORMAL)
      {
        if (!axcg.ay(axaf.a(this.a).getIntent())) {
          axaf.a(this.a).H().setImageResource(2130845398);
        }
        if (axcg.ay(axaf.b(this.a).getIntent()))
        {
          axaf.b(this.a).setVisibility(0);
          axaf.a(this.a).setVisibility(0);
          if (!axcg.ay(axaf.c(this.a).getIntent())) {
            axaf.c(this.a).H().setImageResource(2130838032);
          }
          axaf.d(this.a).setVisibility(0);
          if (!paramaxfz.getHasCountDown()) {
            break label211;
          }
          axaf.e(this.a).setVisibility(8);
          axaf.f(this.a).H().setImageResource(2130837912);
          axaf.f(this.a).setVisibility(0);
          axaf.a(this.a, 10);
        }
        for (;;)
        {
          axaf.g(this.a).setVisibility(8);
          return;
          axaf.b(this.a).setVisibility(8);
          break;
          if (!axcg.ay(axaf.d(this.a).getIntent())) {
            axaf.e(this.a).H().setImageResource(2130837911);
          }
          axaf.e(this.a).setVisibility(0);
          axaf.f(this.a).setVisibility(8);
        }
      }
      if (paramaxfz == AECaptureMode.GIF)
      {
        axaf.a(this.a).H().setImageResource(2130845397);
        axaf.a(this.a).setVisibility(0);
        axaf.c(this.a).H().setImageResource(2130838031);
        axaf.e(this.a).H().setImageResource(2130837910);
        axaf.d(this.a).setVisibility(8);
        axaf.f(this.a).H().setImageResource(2130837913);
        axaf.f(this.a).setVisibility(0);
        axaf.a(this.a, 3);
        axaf.g(this.a).setVisibility(0);
        return;
      }
    } while (paramaxfz != AECaptureMode.PLAY);
    axaf.a(this.a).H().setImageResource(2130845398);
    axaf.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axah
 * JD-Core Version:    0.7.0.1
 */