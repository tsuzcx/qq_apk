import android.graphics.Path;
import android.graphics.PathMeasure;
import java.util.ArrayList;
import java.util.List;

public abstract class wrw
{
  private int bRv = 10;
  private int bRw = 25;
  private float qc = 1.0F;
  
  private float a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 1) {
      return (paramFloat1 + paramFloat2) / 2.0F;
    }
    return (paramFloat2 - paramFloat1) * (paramInt2 + 1) / paramInt1 + paramFloat1;
  }
  
  private long a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 1) {
      return (paramLong1 + paramLong2) / 2L;
    }
    return (paramLong2 - paramLong1) * (paramInt2 + 1) / paramInt1 + paramLong1;
  }
  
  public void H(List<wsa.a> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    int i;
    do
    {
      return;
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
    } while (paramList.size() <= i);
    ArrayList localArrayList = new ArrayList();
    Object localObject = (wsa.a)paramList.get(i);
    paramInt = i + 1;
    while (paramInt < paramList.size())
    {
      wsa.a locala = (wsa.a)paramList.get(paramInt);
      if ((locala.getTime() - ((wsa.a)localObject).getTime() < this.bRw) && (Math.abs(locala.getWidth() - ((wsa.a)localObject).getWidth()) < this.qc))
      {
        ((wsa.a)localObject).a(locala);
        paramInt += 1;
      }
      else
      {
        localArrayList.add(localObject);
        if (((wsa.a)localObject).getTime() != locala.getTime()) {
          locala.setSeq(0);
        }
        for (;;)
        {
          localObject = locala;
          break;
          locala.setSeq(((wsa.a)localObject).getSeq() + 1);
        }
      }
    }
    localArrayList.add(localObject);
    paramList.clear();
    paramList.addAll(localArrayList);
  }
  
  public abstract void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong, Path paramPath, List<wsa.a> paramList);
  
  public abstract void a(Path paramPath, List<wsa.a> paramList);
  
  public abstract void a(List<wrx.a> paramList, Path paramPath, List<wsa.a> paramList1);
  
  public abstract void a(List<wrx.a> paramList, Path paramPath, List<wsa.a> paramList1, int paramInt);
  
  protected boolean a(List<wsa.a> paramList, Path paramPath)
  {
    if ((paramList == null) || (paramPath == null) || (paramList.size() == 0)) {
      return false;
    }
    PathMeasure localPathMeasure = new PathMeasure(paramPath, false);
    float f3 = localPathMeasure.getLength();
    int i = 0;
    float f1;
    for (float f2 = 0.0F; i < paramList.size(); f2 = f1)
    {
      Path localPath = new Path();
      float f4 = ((wsa.a)paramList.get(i)).getLength() + f2;
      f1 = f4;
      if (f4 > f3) {
        f1 = f3;
      }
      localPathMeasure.getSegment(f2, f1, localPath, true);
      localPath.rLineTo(0.0F, 0.0F);
      paramPath.addPath(localPath);
      ((wsa.a)paramList.get(i)).a(localPath);
      i += 1;
    }
    return true;
  }
  
  protected boolean a(List<wsa.a> paramList, Path paramPath, float paramFloat1, float paramFloat2, long paramLong1, long paramLong2)
  {
    if (paramList == null) {
      return false;
    }
    PathMeasure localPathMeasure = new PathMeasure(paramPath, false);
    float f2 = localPathMeasure.getLength();
    int j = (int)Math.ceil(f2 / this.bRv);
    if (j == 0) {
      return false;
    }
    int i = 0;
    paramPath = null;
    if (i < j)
    {
      Object localObject = new Path();
      float f3 = (i + 1) * this.bRv;
      float f1 = f3;
      if (f3 > f2) {
        f1 = f2;
      }
      localPathMeasure.getSegment(this.bRv * i, f1, (Path)localObject, true);
      ((Path)localObject).rLineTo(0.0F, 0.0F);
      localObject = new wsa.a((Path)localObject);
      ((wsa.a)localObject).setWidth(a(paramFloat1, paramFloat2, j, i));
      ((wsa.a)localObject).setTime(a(paramLong1, paramLong2, j, i));
      ((wsa.a)localObject).as(f1 - this.bRv * i);
      if ((paramPath != null) && (paramPath.getTime() == ((wsa.a)localObject).getTime())) {
        ((wsa.a)localObject).setSeq(paramPath.getSeq() + 1);
      }
      for (;;)
      {
        paramList.add(localObject);
        i += 1;
        paramPath = (Path)localObject;
        break;
        ((wsa.a)localObject).setSeq(0);
      }
    }
    return true;
  }
  
  public abstract void b(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong, Path paramPath, List<wsa.a> paramList);
  
  public void d(int paramInt1, int paramInt2, float paramFloat)
  {
    this.bRv = paramInt1;
    this.bRw = paramInt2;
    this.qc = paramFloat;
    if (this.bRv <= 0) {
      this.bRv = 10;
    }
    if (this.bRw <= 0) {
      this.bRw = 25;
    }
    if (this.qc <= 0.0F) {
      this.qc = 1.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wrw
 * JD-Core Version:    0.7.0.1
 */