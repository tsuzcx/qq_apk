import android.graphics.Bitmap;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import dov.com.qq.im.ae.play.AETemplateInfoFragment;

public class axhg
  implements axic.d
{
  public axhg(AETemplateInfoFragment paramAETemplateInfoFragment, boolean[] paramArrayOfBoolean, String paramString) {}
  
  public void onFail(int paramInt)
  {
    this.E[0] = false;
  }
  
  public void p(Bitmap paramBitmap)
  {
    this.E[0] = true;
    BitmapUtils.saveBitmap(paramBitmap, this.cUu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axhg
 * JD-Core Version:    0.7.0.1
 */