import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import dov.com.qq.im.ae.mode.AECaptureMode;

class axcq
  implements axzv<axfz>
{
  axcq(axco paramaxco) {}
  
  public void a(@Nullable axfz paramaxfz)
  {
    if (paramaxfz == null) {}
    do
    {
      return;
      paramaxfz = paramaxfz.g;
      if (paramaxfz == AECaptureMode.NORMAL)
      {
        axco.a(this.a).setVisibility(8);
        return;
      }
      if (paramaxfz == AECaptureMode.GIF)
      {
        axco.a(this.a);
        return;
      }
    } while (paramaxfz != AECaptureMode.PLAY);
    axco.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axcq
 * JD-Core Version:    0.7.0.1
 */