import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.tencent.lottieNew.model.content.ShapeTrimPath.Type;
import java.util.List;

public class ttb
  implements tsy, ttg.a
{
  private final trz jdField_a_of_type_Trz;
  @Nullable
  private ttf jdField_a_of_type_Ttf;
  private final ttg<?, PointF> d;
  private final ttg<?, PointF> e;
  private boolean isPathValid;
  private final String name;
  private final ttg<?, Float> o;
  private final Path path = new Path();
  private final RectF rect = new RectF();
  
  public ttb(trz paramtrz, twe paramtwe, tvs paramtvs)
  {
    this.name = paramtvs.getName();
    this.jdField_a_of_type_Trz = paramtrz;
    this.e = paramtvs.a().g();
    this.d = paramtvs.a().g();
    this.o = paramtvs.l().g();
    paramtwe.a(this.e);
    paramtwe.a(this.d);
    paramtwe.a(this.o);
    this.e.b(this);
    this.d.b(this);
    this.o.b(this);
  }
  
  private void invalidate()
  {
    this.isPathValid = false;
    this.jdField_a_of_type_Trz.invalidateSelf();
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public Path getPath()
  {
    if (this.isPathValid) {
      return this.path;
    }
    this.path.reset();
    PointF localPointF = (PointF)this.d.getValue();
    float f3 = localPointF.x / 2.0F;
    float f4 = localPointF.y / 2.0F;
    float f1;
    if (this.o == null)
    {
      f1 = 0.0F;
      float f2 = Math.min(f3, f4);
      if (f1 <= f2) {
        break label516;
      }
      f1 = f2;
    }
    label516:
    for (;;)
    {
      localPointF = (PointF)this.e.getValue();
      this.path.moveTo(localPointF.x + f3, localPointF.y - f4 + f1);
      this.path.lineTo(localPointF.x + f3, localPointF.y + f4 - f1);
      if (f1 > 0.0F)
      {
        this.rect.set(localPointF.x + f3 - 2.0F * f1, localPointF.y + f4 - 2.0F * f1, localPointF.x + f3, localPointF.y + f4);
        this.path.arcTo(this.rect, 0.0F, 90.0F, false);
      }
      this.path.lineTo(localPointF.x - f3 + f1, localPointF.y + f4);
      if (f1 > 0.0F)
      {
        this.rect.set(localPointF.x - f3, localPointF.y + f4 - 2.0F * f1, localPointF.x - f3 + 2.0F * f1, localPointF.y + f4);
        this.path.arcTo(this.rect, 90.0F, 90.0F, false);
      }
      this.path.lineTo(localPointF.x - f3, localPointF.y - f4 + f1);
      if (f1 > 0.0F)
      {
        this.rect.set(localPointF.x - f3, localPointF.y - f4, localPointF.x - f3 + 2.0F * f1, localPointF.y - f4 + 2.0F * f1);
        this.path.arcTo(this.rect, 180.0F, 90.0F, false);
      }
      this.path.lineTo(localPointF.x + f3 - f1, localPointF.y - f4);
      if (f1 > 0.0F)
      {
        this.rect.set(localPointF.x + f3 - 2.0F * f1, localPointF.y - f4, f3 + localPointF.x, localPointF.y - f4 + f1 * 2.0F);
        this.path.arcTo(this.rect, 270.0F, 90.0F, false);
      }
      this.path.close();
      twy.a(this.path, this.jdField_a_of_type_Ttf);
      this.isPathValid = true;
      return this.path;
      f1 = ((Float)this.o.getValue()).floatValue();
      break;
    }
  }
  
  public void onValueChanged()
  {
    invalidate();
  }
  
  public void setContents(List<tso> paramList1, List<tso> paramList2)
  {
    int i = 0;
    while (i < paramList1.size())
    {
      paramList2 = (tso)paramList1.get(i);
      if (((paramList2 instanceof ttf)) && (((ttf)paramList2).a() == ShapeTrimPath.Type.Simultaneously))
      {
        this.jdField_a_of_type_Ttf = ((ttf)paramList2);
        this.jdField_a_of_type_Ttf.a(this);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ttb
 * JD-Core Version:    0.7.0.1
 */