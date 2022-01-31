import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import com.tencent.mobileqq.activity.aio.doodle.DoodleDrawer;
import com.tencent.mobileqq.activity.aio.doodle.DoodleDrawer.DoodleDrawerListener;
import com.tencent.mobileqq.activity.aio.doodle.DoodleMsgView;
import com.tencent.qphone.base.util.QLog;

public class uwo
  implements DoodleDrawer.DoodleDrawerListener
{
  public uwo(DoodleMsgView paramDoodleMsgView) {}
  
  public void a(String paramString, int paramInt)
  {
    QLog.d("DoodleMsgView", 2, "onDataState:" + paramInt + " - " + paramString);
    this.a.a(new uwq(this, paramInt));
  }
  
  public void a(String arg1, long paramLong, Bitmap paramBitmap)
  {
    if (DoodleMsgView.a(this.a) == null) {}
    for (;;)
    {
      return;
      if (paramBitmap != null) {
        if (DoodleMsgView.a(this.a, paramBitmap.getWidth(), paramBitmap.getHeight())) {
          if (DoodleMsgView.a(this.a) == null)
          {
            DoodleMsgView.a(this.a, new Paint());
            DoodleMsgView.a(this.a).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
            DoodleMsgView.a(this.a).setAntiAlias(true);
          }
        }
      }
      synchronized (this.a)
      {
        DoodleMsgView.a(this.a).drawBitmap(paramBitmap, new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()), new Rect(0, 0, DoodleMsgView.a(this.a).getWidth(), DoodleMsgView.a(this.a).getHeight()), DoodleMsgView.a(this.a));
        this.a.postInvalidate();
        if ((!DoodleMsgView.a(this.a)) || (paramLong < DoodleMsgView.a(this.a).a()) || (DoodleMsgView.a(this.a) < DoodleMsgView.a(this.a).a())) {
          continue;
        }
        this.a.d();
        this.a.a(new uwp(this));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uwo
 * JD-Core Version:    0.7.0.1
 */