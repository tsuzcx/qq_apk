import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.mobileqq.minicode.recog.MiniCodeDetector;
import com.tencent.mobileqq.minicode.recog.RecogCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class adjo
  implements RecogCallback
{
  adjo(adjn paramadjn, Rect paramRect, long paramLong, Object paramObject, MiniCodeDetector paramMiniCodeDetector, boolean[] paramArrayOfBoolean, Bitmap paramBitmap) {}
  
  public void onDetectReady(int paramInt)
  {
    if ((this.b != null) && (adjn.a(this.this$0) != null)) {
      this.q[0] = this.b.detect(this.val$bmp, this.Uj);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.MiniCodeController", 2, "detectSync onDetectReady exec=" + this.q[0]);
      }
      if (this.q[0] == 0) {}
      synchronized (this.de)
      {
        this.de.notifyAll();
        return;
        this.q[0] = false;
      }
    }
  }
  
  public void onDetectResult(List<adjj> arg1, long paramLong)
  {
    int i = 0;
    label55:
    boolean bool;
    label68:
    int j;
    int k;
    int m;
    if (i < ???.size())
    {
      if (((adjj)???.get(i)).type != 2) {
        break label217;
      }
      ??? = (adjj)???.get(i);
      this.val$rect.set(???.rect);
      if (QLog.isColorLevel())
      {
        if (??? == null) {
          break label226;
        }
        bool = true;
        i = this.val$rect.left;
        j = this.val$rect.top;
        k = this.val$rect.width();
        m = this.val$rect.height();
        if (??? == null) {
          break label232;
        }
      }
    }
    label217:
    label226:
    label232:
    for (float f = ???.score;; f = 0.0F)
    {
      QLog.i("MiniRecog.MiniCodeController", 2, String.format("detectSync onDetectResult=%b [left,top,w,h,score]=[%d, %d, %d, %d]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f) }));
      if (paramLong == this.Uj)
      {
        synchronized (this.de)
        {
          this.de.notifyAll();
          return;
        }
        ??? = null;
        break label55;
      }
      return;
      i += 1;
      break;
      bool = false;
      break label68;
    }
  }
  
  public void onSaveImg(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adjo
 * JD-Core Version:    0.7.0.1
 */