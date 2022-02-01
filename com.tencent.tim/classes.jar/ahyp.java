import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.os.Build.VERSION;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.hotchat.ui.HeartView;
import java.util.Random;

public class ahyp
  extends ahyo
{
  private int[] colors = { Color.parseColor("#c797ff"), Color.parseColor("#80b9f4"), Color.parseColor("#67d0d7"), Color.parseColor("#67d78e"), Color.parseColor("#b5e255"), Color.parseColor("#f2c64f"), Color.parseColor("#f6a455"), Color.parseColor("#ff96b9"), Color.parseColor("#ff6a6a") };
  private Random mRandom = new Random(System.currentTimeMillis());
  private Canvas sCanvas;
  private Paint sPaint;
  
  public ahyp(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public ahyp(Context paramContext, int paramInt, ahym paramahym)
  {
    super(paramContext, paramInt, paramahym);
  }
  
  public static void a(HeartLayout paramHeartLayout)
  {
    if ((paramHeartLayout == null) || (paramHeartLayout.b() == null)) {}
    do
    {
      return;
      paramHeartLayout = paramHeartLayout.b();
    } while (paramHeartLayout == null);
    paramHeartLayout.cav = 2400;
    ahym.a.wI = 0.05F;
  }
  
  public Bitmap ax()
  {
    super.ax();
    return ay();
  }
  
  public Bitmap ay()
  {
    if (this.fo == null) {}
    try
    {
      this.fo = BitmapFactory.decodeResource(this.mContext.getResources(), this.dct);
      if (this.fo == null) {}
      Bitmap localBitmap1;
      Bitmap localBitmap2;
      do
      {
        return null;
        if (this.sPaint == null) {
          this.sPaint = new Paint(3);
        }
        if (this.sCanvas == null) {
          this.sCanvas = new Canvas();
        }
        localBitmap1 = this.fo;
        localBitmap2 = HeartView.h(this.fo.getWidth(), this.fo.getHeight());
      } while (localBitmap2 == null);
      Canvas localCanvas = this.sCanvas;
      localCanvas.setBitmap(localBitmap2);
      Paint localPaint = this.sPaint;
      localPaint.setColorFilter(new PorterDuffColorFilter(this.colors[this.mRandom.nextInt(this.colors.length)], PorterDuff.Mode.SRC_ATOP));
      localCanvas.drawBitmap(localBitmap1, 0.0F, 0.0F, localPaint);
      localPaint.setColorFilter(null);
      if (Build.VERSION.SDK_INT >= 11) {
        localCanvas.setBitmap(null);
      }
      return localBitmap2;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahyp
 * JD-Core Version:    0.7.0.1
 */