import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class aexz
{
  private final Rect N = new Rect();
  private final Rect O = new Rect();
  private final Paint S = new Paint();
  private final aeww a;
  
  public aexz(aeww paramaeww)
  {
    this.a = paramaeww;
  }
  
  private boolean a(Canvas paramCanvas, aexe paramaexe, aexj paramaexj, aexy paramaexy)
  {
    paramaexj = this.a.a(paramaexe, paramaexj);
    if (paramaexj == null) {
      return false;
    }
    int i = paramCanvas.save();
    this.N.set(0, 0, (int)paramaexe.getPaintWidth(), (int)paramaexe.getPaintHeight());
    this.O.set((int)paramaexe.getLeft(), (int)paramaexe.getTop(), (int)paramaexe.getRight(), (int)paramaexe.getBottom());
    paramCanvas.drawBitmap(paramaexj, this.N, this.O, this.S);
    paramCanvas.restoreToCount(i);
    return true;
  }
  
  private void b(Canvas paramCanvas, aexe paramaexe, aexj paramaexj, aexy paramaexy)
  {
    int i = paramCanvas.save();
    paramaexy.a(paramCanvas, paramaexe, paramaexj, paramaexe.getContentLeft(), paramaexe.getContentTop());
    paramCanvas.restoreToCount(i);
  }
  
  public void a(Canvas paramCanvas, aexe paramaexe, aexj paramaexj, aexy paramaexy)
  {
    if (paramCanvas == null) {}
    do
    {
      return;
      if (!paramaexe.isDrawCacheEnable()) {
        break;
      }
    } while (a(paramCanvas, paramaexe, paramaexj, paramaexy));
    aexx.HC(false);
    b(paramCanvas, paramaexe, paramaexj, paramaexy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aexz
 * JD-Core Version:    0.7.0.1
 */