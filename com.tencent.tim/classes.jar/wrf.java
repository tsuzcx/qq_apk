import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import com.tencent.mobileqq.activity.aio.doodle.DoodleMsgView;
import com.tencent.mobileqq.activity.aio.doodle.DoodleMsgView.1.1;
import com.tencent.mobileqq.activity.aio.doodle.DoodleMsgView.1.2;
import com.tencent.qphone.base.util.QLog;

public class wrf
  implements wra.a
{
  public wrf(DoodleMsgView paramDoodleMsgView) {}
  
  public void a(String arg1, long paramLong, Bitmap paramBitmap)
  {
    if (DoodleMsgView.a(this.this$0) == null) {}
    for (;;)
    {
      return;
      if (paramBitmap != null) {
        if (DoodleMsgView.a(this.this$0, paramBitmap.getWidth(), paramBitmap.getHeight())) {
          if (DoodleMsgView.a(this.this$0) == null)
          {
            DoodleMsgView.a(this.this$0, new Paint());
            DoodleMsgView.a(this.this$0).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
            DoodleMsgView.a(this.this$0).setAntiAlias(true);
          }
        }
      }
      synchronized (this.this$0)
      {
        DoodleMsgView.a(this.this$0).drawBitmap(paramBitmap, new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()), new Rect(0, 0, DoodleMsgView.a(this.this$0).getWidth(), DoodleMsgView.a(this.this$0).getHeight()), DoodleMsgView.a(this.this$0));
        this.this$0.postInvalidate();
        if ((!DoodleMsgView.a(this.this$0)) || (paramLong < DoodleMsgView.a(this.this$0).eo()) || (DoodleMsgView.a(this.this$0) < DoodleMsgView.a(this.this$0).eo())) {
          continue;
        }
        this.this$0.stop();
        this.this$0.runOnUIThread(new DoodleMsgView.1.1(this));
        return;
      }
    }
  }
  
  public void cz(String paramString, int paramInt)
  {
    QLog.d("DoodleMsgView", 2, "onDataState:" + paramInt + " - " + paramString);
    this.this$0.runOnUIThread(new DoodleMsgView.1.2(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wrf
 * JD-Core Version:    0.7.0.1
 */