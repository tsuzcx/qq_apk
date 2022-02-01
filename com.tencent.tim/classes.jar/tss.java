import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class tss
  implements tsq, ttg.a
{
  private final trz a;
  private final ttg<Integer, Integer> b;
  private final ttg<Integer, Integer> f;
  private final String name;
  private final Paint paint = new Paint(1);
  private final Path path = new Path();
  private final List<tsy> paths = new ArrayList();
  
  public tss(trz paramtrz, twe paramtwe, tvx paramtvx)
  {
    this.name = paramtvx.getName();
    this.a = paramtrz;
    if ((paramtvx.a() == null) || (paramtvx.b() == null))
    {
      this.f = null;
      this.b = null;
      return;
    }
    this.path.setFillType(paramtvx.getFillType());
    this.f = paramtvx.a().g();
    this.f.b(this);
    paramtwe.a(this.f);
    this.b = paramtvx.b().g();
    this.b.b(this);
    paramtwe.a(this.b);
  }
  
  public void a(RectF paramRectF, Matrix paramMatrix)
  {
    this.path.reset();
    int i = 0;
    while (i < this.paths.size())
    {
      this.path.addPath(((tsy)this.paths.get(i)).getPath(), paramMatrix);
      i += 1;
    }
    this.path.computeBounds(paramRectF, false);
    paramRectF.set(paramRectF.left - 1.0F, paramRectF.top - 1.0F, paramRectF.right + 1.0F, paramRectF.bottom + 1.0F);
  }
  
  public void b(@Nullable String paramString1, @Nullable String paramString2, @Nullable ColorFilter paramColorFilter)
  {
    this.paint.setColorFilter(paramColorFilter);
  }
  
  public void draw(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    trt.beginSection("FillContent#draw");
    this.paint.setColor(((Integer)this.f.getValue()).intValue());
    float f1 = paramInt / 255.0F;
    paramInt = (int)(((Integer)this.b.getValue()).intValue() * f1 / 100.0F * 255.0F);
    this.paint.setAlpha(paramInt);
    this.path.reset();
    paramInt = 0;
    while (paramInt < this.paths.size())
    {
      this.path.addPath(((tsy)this.paths.get(paramInt)).getPath(), paramMatrix);
      paramInt += 1;
    }
    paramCanvas.drawPath(this.path, this.paint);
    trt.endSection("FillContent#draw");
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void onValueChanged()
  {
    this.a.invalidateSelf();
  }
  
  public void setContents(List<tso> paramList1, List<tso> paramList2)
  {
    int i = 0;
    while (i < paramList2.size())
    {
      paramList1 = (tso)paramList2.get(i);
      if ((paramList1 instanceof tsy)) {
        this.paths.add((tsy)paramList1);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tss
 * JD-Core Version:    0.7.0.1
 */