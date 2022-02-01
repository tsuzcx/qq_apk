import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tencent.lottieNew.model.content.ShapeTrimPath.Type;
import java.util.List;

public class tsr
  implements tsy, ttg.a
{
  private final trz jdField_a_of_type_Trz;
  @Nullable
  private ttf jdField_a_of_type_Ttf;
  private final ttg<?, PointF> d;
  private final ttg<?, PointF> e;
  private boolean isPathValid;
  private final String name;
  private final Path path = new Path();
  
  public tsr(trz paramtrz, twe paramtwe, tvh paramtvh)
  {
    this.name = paramtvh.getName();
    this.jdField_a_of_type_Trz = paramtrz;
    this.d = paramtvh.a().g();
    this.e = paramtvh.a().g();
    paramtwe.a(this.d);
    paramtwe.a(this.e);
    this.d.b(this);
    this.e.b(this);
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
    float f1 = localPointF.x / 2.0F;
    float f2 = localPointF.y / 2.0F;
    float f3 = f1 * 0.55228F;
    float f4 = f2 * 0.55228F;
    this.path.reset();
    this.path.moveTo(0.0F, -f2);
    this.path.cubicTo(0.0F + f3, -f2, f1, 0.0F - f4, f1, 0.0F);
    this.path.cubicTo(f1, 0.0F + f4, 0.0F + f3, f2, 0.0F, f2);
    this.path.cubicTo(0.0F - f3, f2, -f1, 0.0F + f4, -f1, 0.0F);
    this.path.cubicTo(-f1, 0.0F - f4, 0.0F - f3, -f2, 0.0F, -f2);
    localPointF = (PointF)this.e.getValue();
    this.path.offset(localPointF.x, localPointF.y);
    this.path.close();
    twy.a(this.path, this.jdField_a_of_type_Ttf);
    this.isPathValid = true;
    return this.path;
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
 * Qualified Name:     tsr
 * JD-Core Version:    0.7.0.1
 */