package taiji;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.RectF;
import java.util.Collections;
import uilib.doraemon.e;

public class bm
  extends bd
{
  private final cy e;
  
  bm(e parame, cs paramcs)
  {
    super(parame, paramcs);
    this.e = new cy(parame, this, new ba(paramcs.f(), paramcs.n()));
    this.e.a(Collections.emptyList(), Collections.emptyList());
  }
  
  public void a(RectF paramRectF, Matrix paramMatrix)
  {
    super.a(paramRectF, paramMatrix);
    this.e.a(paramRectF, this.a);
  }
  
  public void a(String paramString1, String paramString2, ColorFilter paramColorFilter)
  {
    this.e.a(paramString1, paramString2, paramColorFilter);
  }
  
  void b(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    this.e.a(paramCanvas, paramMatrix, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.bm
 * JD-Core Version:    0.7.0.1
 */