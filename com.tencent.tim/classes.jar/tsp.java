import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class tsp
  implements tsq, tsy, ttg.a
{
  private final trz jdField_a_of_type_Trz;
  @Nullable
  private ttw jdField_a_of_type_Ttw;
  private final List<tso> contents;
  private final Matrix matrix = new Matrix();
  private final String name;
  private final Path path = new Path();
  @Nullable
  private List<tsy> pathContents;
  private final RectF rect = new RectF();
  
  tsp(trz paramtrz, twe paramtwe, String paramString, List<tso> paramList, @Nullable tvc paramtvc)
  {
    this.name = paramString;
    this.jdField_a_of_type_Trz = paramtrz;
    this.contents = paramList;
    if (paramtvc != null)
    {
      this.jdField_a_of_type_Ttw = paramtvc.a();
      this.jdField_a_of_type_Ttw.a(paramtwe);
      this.jdField_a_of_type_Ttw.a(this);
    }
    paramtrz = new ArrayList();
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      paramtwe = (tso)paramList.get(i);
      if ((paramtwe instanceof tsv)) {
        paramtrz.add((tsv)paramtwe);
      }
      i -= 1;
    }
    i = paramtrz.size() - 1;
    while (i >= 0)
    {
      ((tsv)paramtrz.get(i)).absorbContent(paramList.listIterator(paramList.size()));
      i -= 1;
    }
  }
  
  public tsp(trz paramtrz, twe paramtwe, tvz paramtvz)
  {
    this(paramtrz, paramtwe, paramtvz.getName(), a(paramtrz, paramtwe, paramtvz.getItems()), a(paramtvz.getItems()));
  }
  
  private static List<tso> a(trz paramtrz, twe paramtwe, List<tvj> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i = 0;
    while (i < paramList.size())
    {
      tso localtso = ((tvj)paramList.get(i)).a(paramtrz, paramtwe);
      if (localtso != null) {
        localArrayList.add(localtso);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  @Nullable
  static tvc a(List<tvj> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      tvj localtvj = (tvj)paramList.get(i);
      if ((localtvj instanceof tvc)) {
        return (tvc)localtvj;
      }
      i += 1;
    }
    return null;
  }
  
  public void a(RectF paramRectF, Matrix paramMatrix)
  {
    this.matrix.set(paramMatrix);
    if (this.jdField_a_of_type_Ttw != null) {
      this.matrix.preConcat(this.jdField_a_of_type_Ttw.getMatrix());
    }
    this.rect.set(0.0F, 0.0F, 0.0F, 0.0F);
    int i = this.contents.size() - 1;
    if (i >= 0)
    {
      paramMatrix = (tso)this.contents.get(i);
      if ((paramMatrix instanceof tsq))
      {
        ((tsq)paramMatrix).a(this.rect, this.matrix);
        if (!paramRectF.isEmpty()) {
          break label117;
        }
        paramRectF.set(this.rect);
      }
      for (;;)
      {
        i -= 1;
        break;
        label117:
        paramRectF.set(Math.min(paramRectF.left, this.rect.left), Math.min(paramRectF.top, this.rect.top), Math.max(paramRectF.right, this.rect.right), Math.max(paramRectF.bottom, this.rect.bottom));
      }
    }
  }
  
  public void b(@Nullable String paramString1, @Nullable String paramString2, @Nullable ColorFilter paramColorFilter)
  {
    int i = 0;
    if (i < this.contents.size())
    {
      tso localtso = (tso)this.contents.get(i);
      tsq localtsq;
      if ((localtso instanceof tsq))
      {
        localtsq = (tsq)localtso;
        if ((paramString2 != null) && (!paramString2.equals(localtso.getName()))) {
          break label85;
        }
        localtsq.b(paramString1, null, paramColorFilter);
      }
      for (;;)
      {
        i += 1;
        break;
        label85:
        localtsq.b(paramString1, paramString2, paramColorFilter);
      }
    }
  }
  
  public void draw(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    this.matrix.set(paramMatrix);
    int i = paramInt;
    if (this.jdField_a_of_type_Ttw != null)
    {
      this.matrix.preConcat(this.jdField_a_of_type_Ttw.getMatrix());
      i = (int)(((Integer)this.jdField_a_of_type_Ttw.d().getValue()).intValue() / 100.0F * paramInt / 255.0F * 255.0F);
    }
    paramInt = this.contents.size() - 1;
    while (paramInt >= 0)
    {
      paramMatrix = this.contents.get(paramInt);
      if ((paramMatrix instanceof tsq)) {
        ((tsq)paramMatrix).draw(paramCanvas, this.matrix, i);
      }
      paramInt -= 1;
    }
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public Path getPath()
  {
    this.matrix.reset();
    if (this.jdField_a_of_type_Ttw != null) {
      this.matrix.set(this.jdField_a_of_type_Ttw.getMatrix());
    }
    this.path.reset();
    int i = this.contents.size() - 1;
    while (i >= 0)
    {
      tso localtso = (tso)this.contents.get(i);
      if ((localtso instanceof tsy)) {
        this.path.addPath(((tsy)localtso).getPath(), this.matrix);
      }
      i -= 1;
    }
    return this.path;
  }
  
  List<tsy> getPathList()
  {
    if (this.pathContents == null)
    {
      this.pathContents = new ArrayList();
      int i = 0;
      while (i < this.contents.size())
      {
        tso localtso = (tso)this.contents.get(i);
        if ((localtso instanceof tsy)) {
          this.pathContents.add((tsy)localtso);
        }
        i += 1;
      }
    }
    return this.pathContents;
  }
  
  Matrix getTransformationMatrix()
  {
    if (this.jdField_a_of_type_Ttw != null) {
      return this.jdField_a_of_type_Ttw.getMatrix();
    }
    this.matrix.reset();
    return this.matrix;
  }
  
  public void onValueChanged()
  {
    this.jdField_a_of_type_Trz.invalidateSelf();
  }
  
  public void setContents(List<tso> paramList1, List<tso> paramList2)
  {
    paramList2 = new ArrayList(paramList1.size() + this.contents.size());
    paramList2.addAll(paramList1);
    int i = this.contents.size() - 1;
    while (i >= 0)
    {
      paramList1 = (tso)this.contents.get(i);
      paramList1.setContents(paramList2, this.contents.subList(0, i));
      paramList2.add(paramList1);
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tsp
 * JD-Core Version:    0.7.0.1
 */