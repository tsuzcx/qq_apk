package taiji;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.token.gi;
import uilib.doraemon.e;

public class j
  extends bq
{
  private final String c;
  private final p<Integer> d;
  
  public j(e parame, ar paramar, cm paramcm)
  {
    super(parame, paramar, paramcm.g().a(), paramcm.h().a(), paramcm.c(), paramcm.d(), paramcm.e(), paramcm.f());
    this.c = paramcm.a();
    this.d = paramcm.b().a();
    this.d.a(this);
    paramar.a(this.d);
  }
  
  public void a(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    gi localgi = this.a.k();
    if (localgi != null) {
      this.b.setColor(localgi.a(this.c, ((Integer)this.d.b()).intValue()));
    } else {
      this.b.setColor(((Integer)this.d.b()).intValue());
    }
    super.a(paramCanvas, paramMatrix, paramInt);
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
 * Qualified Name:     taiji.j
 * JD-Core Version:    0.7.0.1
 */