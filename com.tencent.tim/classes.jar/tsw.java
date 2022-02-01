import android.annotation.TargetApi;
import android.graphics.Path;
import android.graphics.Path.Op;
import android.os.Build.VERSION;
import com.tencent.lottieNew.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@TargetApi(19)
public class tsw
  implements tsv, tsy
{
  private final MergePaths a;
  private final Path firstPath = new Path();
  private final String name;
  private final Path path = new Path();
  private final List<tsy> pathContents = new ArrayList();
  private final Path remainderPath = new Path();
  
  public tsw(MergePaths paramMergePaths)
  {
    if (Build.VERSION.SDK_INT < 19) {
      throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
    }
    this.name = paramMergePaths.getName();
    this.a = paramMergePaths;
  }
  
  private void addPaths()
  {
    int i = 0;
    while (i < this.pathContents.size())
    {
      this.path.addPath(((tsy)this.pathContents.get(i)).getPath());
      i += 1;
    }
  }
  
  @TargetApi(19)
  private void opFirstPathWithRest(Path.Op paramOp)
  {
    int k = 0;
    this.remainderPath.reset();
    this.firstPath.reset();
    int i = this.pathContents.size() - 1;
    List localList;
    Path localPath;
    while (i >= 1)
    {
      localtsy = (tsy)this.pathContents.get(i);
      if ((localtsy instanceof tsp))
      {
        localList = ((tsp)localtsy).getPathList();
        int j = localList.size() - 1;
        while (j >= 0)
        {
          localPath = ((tsy)localList.get(j)).getPath();
          localPath.transform(((tsp)localtsy).getTransformationMatrix());
          this.remainderPath.addPath(localPath);
          j -= 1;
        }
      }
      this.remainderPath.addPath(localtsy.getPath());
      i -= 1;
    }
    tsy localtsy = (tsy)this.pathContents.get(0);
    if ((localtsy instanceof tsp))
    {
      localList = ((tsp)localtsy).getPathList();
      i = k;
      while (i < localList.size())
      {
        localPath = ((tsy)localList.get(i)).getPath();
        localPath.transform(((tsp)localtsy).getTransformationMatrix());
        this.firstPath.addPath(localPath);
        i += 1;
      }
    }
    this.firstPath.set(localtsy.getPath());
    this.path.op(this.firstPath, this.remainderPath, paramOp);
  }
  
  public void absorbContent(ListIterator<tso> paramListIterator)
  {
    while ((paramListIterator.hasPrevious()) && (paramListIterator.previous() != this)) {}
    while (paramListIterator.hasPrevious())
    {
      tso localtso = (tso)paramListIterator.previous();
      if ((localtso instanceof tsy))
      {
        this.pathContents.add((tsy)localtso);
        paramListIterator.remove();
      }
    }
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public Path getPath()
  {
    this.path.reset();
    switch (tsx.fd[this.a.a().ordinal()])
    {
    }
    for (;;)
    {
      return this.path;
      addPaths();
      continue;
      opFirstPathWithRest(Path.Op.UNION);
      continue;
      opFirstPathWithRest(Path.Op.REVERSE_DIFFERENCE);
      continue;
      opFirstPathWithRest(Path.Op.INTERSECT);
      continue;
      opFirstPathWithRest(Path.Op.XOR);
    }
  }
  
  public void setContents(List<tso> paramList1, List<tso> paramList2)
  {
    int i = 0;
    while (i < this.pathContents.size())
    {
      ((tsy)this.pathContents.get(i)).setContents(paramList1, paramList2);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tsw
 * JD-Core Version:    0.7.0.1
 */