import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.widget.ImageView;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.mode.AECaptureModeSelectPager;

class axgc
  implements axzv<axfz>
{
  axgc(axga paramaxga) {}
  
  public void a(@Nullable axfz paramaxfz)
  {
    boolean bool = false;
    if (paramaxfz == null) {
      return;
    }
    paramaxfz = paramaxfz.g;
    axga.a(this.a, paramaxfz);
    if (paramaxfz != AECaptureMode.NORMAL) {
      axga.a(this.a).p(196616, new Object[0]);
    }
    int i;
    if (axga.a(this.a) != null)
    {
      i = 0;
      if (i < axga.a(this.a).length) {
        if (paramaxfz != axga.a(this.a)[i]) {}
      }
    }
    for (;;)
    {
      if (i != -1) {
        axga.a(this.a).setCurrentItem(i, true);
      }
      axga localaxga = this.a;
      if (paramaxfz == AECaptureMode.GIF) {
        bool = true;
      }
      axga.a(localaxga, bool);
      axga.a(this.a).notifyDataSetChanged();
      paramaxfz = axga.a(this.a);
      if (axga.a(this.a)) {}
      for (i = 2130837712;; i = 2130837713)
      {
        paramaxfz.setImageResource(i);
        return;
        i += 1;
        break;
      }
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axgc
 * JD-Core Version:    0.7.0.1
 */