import android.graphics.Path;
import android.graphics.Path.FillType;
import android.support.annotation.Nullable;
import com.tencent.lottieNew.model.content.ShapeTrimPath.Type;
import java.util.List;

public class ttd
  implements tsy, ttg.a
{
  private final trz jdField_a_of_type_Trz;
  @Nullable
  private ttf jdField_a_of_type_Ttf;
  private boolean isPathValid;
  private final String name;
  private final Path path = new Path();
  private final ttg<?, Path> r;
  
  public ttd(trz paramtrz, twe paramtwe, twa paramtwa)
  {
    this.name = paramtwa.getName();
    this.jdField_a_of_type_Trz = paramtrz;
    this.r = paramtwa.b().g();
    paramtwe.a(this.r);
    this.r.b(this);
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
    this.path.set((Path)this.r.getValue());
    this.path.setFillType(Path.FillType.EVEN_ODD);
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
 * Qualified Name:     ttd
 * JD-Core Version:    0.7.0.1
 */