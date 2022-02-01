import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class ttc
  implements tsq, tsv, tsy, ttg.a
{
  private final trz jdField_a_of_type_Trz;
  private tsp jdField_a_of_type_Tsp;
  private final twe jdField_a_of_type_Twe;
  private final ttw b;
  private final Matrix matrix = new Matrix();
  private final String name;
  private final ttg<Float, Float> p;
  private final Path path = new Path();
  private final ttg<Float, Float> q;
  
  public ttc(trz paramtrz, twe paramtwe, tvu paramtvu)
  {
    this.jdField_a_of_type_Trz = paramtrz;
    this.jdField_a_of_type_Twe = paramtwe;
    this.name = paramtvu.getName();
    this.p = paramtvu.m().g();
    paramtwe.a(this.p);
    this.p.b(this);
    this.q = paramtvu.n().g();
    paramtwe.a(this.q);
    this.q.b(this);
    this.b = paramtvu.b().a();
    this.b.a(paramtwe);
    this.b.a(this);
  }
  
  public void a(RectF paramRectF, Matrix paramMatrix)
  {
    this.jdField_a_of_type_Tsp.a(paramRectF, paramMatrix);
  }
  
  public void absorbContent(ListIterator<tso> paramListIterator)
  {
    if (this.jdField_a_of_type_Tsp != null) {
      return;
    }
    while ((paramListIterator.hasPrevious()) && (paramListIterator.previous() != this)) {}
    ArrayList localArrayList = new ArrayList();
    while (paramListIterator.hasPrevious())
    {
      localArrayList.add(paramListIterator.previous());
      paramListIterator.remove();
    }
    Collections.reverse(localArrayList);
    this.jdField_a_of_type_Tsp = new tsp(this.jdField_a_of_type_Trz, this.jdField_a_of_type_Twe, "Repeater", localArrayList, null);
  }
  
  public void b(@Nullable String paramString1, @Nullable String paramString2, @Nullable ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_Tsp.b(paramString1, paramString2, paramColorFilter);
  }
  
  public void draw(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    float f1 = ((Float)this.p.getValue()).floatValue();
    float f2 = ((Float)this.q.getValue()).floatValue();
    float f3 = ((Float)this.b.e().getValue()).floatValue() / 100.0F;
    float f4 = ((Float)this.b.f().getValue()).floatValue() / 100.0F;
    int i = (int)f1 - 1;
    while (i >= 0)
    {
      this.matrix.set(paramMatrix);
      this.matrix.preConcat(this.b.getMatrixForRepeater(i + f2));
      float f5 = paramInt;
      float f6 = twx.lerp(f3, f4, i / f1);
      this.jdField_a_of_type_Tsp.draw(paramCanvas, this.matrix, (int)(f5 * f6));
      i -= 1;
    }
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public Path getPath()
  {
    Path localPath = this.jdField_a_of_type_Tsp.getPath();
    this.path.reset();
    float f1 = ((Float)this.p.getValue()).floatValue();
    float f2 = ((Float)this.q.getValue()).floatValue();
    int i = (int)f1 - 1;
    while (i >= 0)
    {
      this.matrix.set(this.b.getMatrixForRepeater(i + f2));
      this.path.addPath(localPath, this.matrix);
      i -= 1;
    }
    return this.path;
  }
  
  public void onValueChanged()
  {
    this.jdField_a_of_type_Trz.invalidateSelf();
  }
  
  public void setContents(List<tso> paramList1, List<tso> paramList2)
  {
    this.jdField_a_of_type_Tsp.setContents(paramList1, paramList2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ttc
 * JD-Core Version:    0.7.0.1
 */