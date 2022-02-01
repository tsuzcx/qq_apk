import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;

public class ttw
{
  private final ttg<Float, Float> A;
  private final ttg<Integer, Integer> B;
  @Nullable
  private final ttg<?, Float> C;
  @Nullable
  private final ttg<?, Float> D;
  private final Matrix matrix = new Matrix();
  private final ttg<PointF, PointF> x;
  private final ttg<?, PointF> y;
  private final ttg<tuj, tuj> z;
  
  public ttw(tvc paramtvc)
  {
    this.x = paramtvc.a().g();
    this.y = paramtvc.a().g();
    this.z = paramtvc.b().g();
    this.A = paramtvc.b().g();
    this.B = paramtvc.b().g();
    if (paramtvc.c() != null) {}
    for (this.C = paramtvc.c().g(); paramtvc.d() != null; this.C = null)
    {
      this.D = paramtvc.d().g();
      return;
    }
    this.D = null;
  }
  
  public void a(ttg.a parama)
  {
    this.x.b(parama);
    this.y.b(parama);
    this.z.b(parama);
    this.A.b(parama);
    this.B.b(parama);
    if (this.C != null) {
      this.C.b(parama);
    }
    if (this.D != null) {
      this.D.b(parama);
    }
  }
  
  public void a(twe paramtwe)
  {
    paramtwe.a(this.x);
    paramtwe.a(this.y);
    paramtwe.a(this.z);
    paramtwe.a(this.A);
    paramtwe.a(this.B);
    if (this.C != null) {
      paramtwe.a(this.C);
    }
    if (this.D != null) {
      paramtwe.a(this.D);
    }
  }
  
  public ttg<?, Integer> d()
  {
    return this.B;
  }
  
  @Nullable
  public ttg<?, Float> e()
  {
    return this.C;
  }
  
  @Nullable
  public ttg<?, Float> f()
  {
    return this.D;
  }
  
  public Matrix getMatrix()
  {
    this.matrix.reset();
    Object localObject = (PointF)this.y.getValue();
    if ((((PointF)localObject).x != 0.0F) || (((PointF)localObject).y != 0.0F)) {
      this.matrix.preTranslate(((PointF)localObject).x, ((PointF)localObject).y);
    }
    float f = ((Float)this.A.getValue()).floatValue();
    if (f != 0.0F) {
      this.matrix.preRotate(f);
    }
    localObject = (tuj)this.z.getValue();
    if ((((tuj)localObject).getScaleX() != 1.0F) || (((tuj)localObject).getScaleY() != 1.0F)) {
      this.matrix.preScale(((tuj)localObject).getScaleX(), ((tuj)localObject).getScaleY());
    }
    localObject = (PointF)this.x.getValue();
    if ((((PointF)localObject).x != 0.0F) || (((PointF)localObject).y != 0.0F)) {
      this.matrix.preTranslate(-((PointF)localObject).x, -((PointF)localObject).y);
    }
    return this.matrix;
  }
  
  public Matrix getMatrixForRepeater(float paramFloat)
  {
    PointF localPointF1 = (PointF)this.y.getValue();
    PointF localPointF2 = (PointF)this.x.getValue();
    tuj localtuj = (tuj)this.z.getValue();
    float f = ((Float)this.A.getValue()).floatValue();
    this.matrix.reset();
    this.matrix.preTranslate(localPointF1.x * paramFloat, localPointF1.y * paramFloat);
    this.matrix.preScale((float)Math.pow(localtuj.getScaleX(), paramFloat), (float)Math.pow(localtuj.getScaleY(), paramFloat));
    this.matrix.preRotate(f * paramFloat, localPointF2.x, localPointF2.y);
    return this.matrix;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ttw
 * JD-Core Version:    0.7.0.1
 */