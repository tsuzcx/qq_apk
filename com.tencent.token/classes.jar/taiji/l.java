package taiji;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.token.io;
import uilib.doraemon.e;

public class l
  extends cu
{
  private final String c;
  private final s d;
  
  public l(e parame, bd parambd, cm paramcm)
  {
    super(parame, parambd, paramcm.g().a(), paramcm.h().a(), paramcm.c(), paramcm.d(), paramcm.e(), paramcm.f());
    this.c = paramcm.a();
    this.d = paramcm.b().a();
    this.d.a(this);
    parambd.a(this.d);
  }
  
  public void a(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    io localio = this.a.k();
    if (localio != null) {
      this.b.setColor(localio.a(this.c, ((Integer)this.d.b()).intValue()));
    }
    for (;;)
    {
      super.a(paramCanvas, paramMatrix, paramInt);
      return;
      this.b.setColor(((Integer)this.d.b()).intValue());
    }
  }
  
  public void a(String paramString1, String paramString2, ColorFilter paramColorFilter)
  {
    this.b.setColorFilter(paramColorFilter);
  }
  
  public String b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.l
 * JD-Core Version:    0.7.0.1
 */