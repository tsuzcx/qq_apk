import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.support.annotation.Nullable;
import com.tencent.lottieNew.model.content.GradientType;
import java.util.ArrayList;
import java.util.List;

public class tst
  implements tsq, ttg.a
{
  private final GradientType jdField_a_of_type_ComTencentLottieNewModelContentGradientType;
  private final trz jdField_a_of_type_Trz;
  private final ttg<Integer, Integer> b;
  private final RectF boundsRect = new RectF();
  private final int cacheSteps;
  private final ttg<tvk, tvk> f;
  private final ttg<PointF, PointF> g;
  private final aure<LinearGradient> jdField_h_of_type_Aure = new aure();
  private final ttg<PointF, PointF> jdField_h_of_type_Ttg;
  private final aure<RadialGradient> i = new aure();
  private final String name;
  private final Paint paint = new Paint(1);
  private final Path path = new Path();
  private final List<tsy> paths = new ArrayList();
  private final Matrix shaderMatrix = new Matrix();
  
  public tst(trz paramtrz, twe paramtwe, tvl paramtvl)
  {
    this.name = paramtvl.getName();
    this.jdField_a_of_type_Trz = paramtrz;
    this.jdField_a_of_type_ComTencentLottieNewModelContentGradientType = paramtvl.a();
    this.path.setFillType(paramtvl.getFillType());
    this.cacheSteps = ((int)(paramtrz.a().getDuration() / 32L));
    this.f = paramtvl.a().g();
    this.f.b(this);
    paramtwe.a(this.f);
    this.b = paramtvl.b().g();
    this.b.b(this);
    paramtwe.a(this.b);
    this.g = paramtvl.b().g();
    this.g.b(this);
    paramtwe.a(this.g);
    this.jdField_h_of_type_Ttg = paramtvl.c().g();
    this.jdField_h_of_type_Ttg.b(this);
    paramtwe.a(this.jdField_h_of_type_Ttg);
  }
  
  private int getGradientHash()
  {
    int k = Math.round(this.g.getProgress() * this.cacheSteps);
    int n = Math.round(this.jdField_h_of_type_Ttg.getProgress() * this.cacheSteps);
    int m = Math.round(this.f.getProgress() * this.cacheSteps);
    int j = 17;
    if (k != 0) {
      j = k * 527;
    }
    k = j;
    if (n != 0) {
      k = j * 31 * n;
    }
    j = k;
    if (m != 0) {
      j = k * 31 * m;
    }
    return j;
  }
  
  private LinearGradient getLinearGradient()
  {
    int j = getGradientHash();
    Object localObject1 = (LinearGradient)this.jdField_h_of_type_Aure.get(j);
    if (localObject1 != null) {
      return localObject1;
    }
    localObject1 = (PointF)this.g.getValue();
    PointF localPointF = (PointF)this.jdField_h_of_type_Ttg.getValue();
    Object localObject2 = (tvk)this.f.getValue();
    int[] arrayOfInt = ((tvk)localObject2).getColors();
    localObject2 = ((tvk)localObject2).getPositions();
    localObject1 = new LinearGradient(((PointF)localObject1).x, ((PointF)localObject1).y, localPointF.x, localPointF.y, arrayOfInt, (float[])localObject2, Shader.TileMode.CLAMP);
    this.jdField_h_of_type_Aure.put(j, localObject1);
    return localObject1;
  }
  
  private RadialGradient getRadialGradient()
  {
    int j = getGradientHash();
    Object localObject1 = (RadialGradient)this.i.get(j);
    if (localObject1 != null) {
      return localObject1;
    }
    localObject1 = (PointF)this.g.getValue();
    PointF localPointF = (PointF)this.jdField_h_of_type_Ttg.getValue();
    Object localObject2 = (tvk)this.f.getValue();
    int[] arrayOfInt = ((tvk)localObject2).getColors();
    localObject2 = ((tvk)localObject2).getPositions();
    float f1 = ((PointF)localObject1).x;
    float f2 = ((PointF)localObject1).y;
    float f3 = localPointF.x;
    float f4 = localPointF.y;
    localObject1 = new RadialGradient(f1, f2, (float)Math.hypot(f3 - f1, f4 - f2), arrayOfInt, (float[])localObject2, Shader.TileMode.CLAMP);
    this.i.put(j, localObject1);
    return localObject1;
  }
  
  public void a(RectF paramRectF, Matrix paramMatrix)
  {
    this.path.reset();
    int j = 0;
    while (j < this.paths.size())
    {
      this.path.addPath(((tsy)this.paths.get(j)).getPath(), paramMatrix);
      j += 1;
    }
    this.path.computeBounds(paramRectF, false);
    paramRectF.set(paramRectF.left - 1.0F, paramRectF.top - 1.0F, paramRectF.right + 1.0F, paramRectF.bottom + 1.0F);
  }
  
  public void b(@Nullable String paramString1, @Nullable String paramString2, @Nullable ColorFilter paramColorFilter) {}
  
  public void draw(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    trt.beginSection("GradientFillContent#draw");
    this.path.reset();
    int j = 0;
    while (j < this.paths.size())
    {
      this.path.addPath(((tsy)this.paths.get(j)).getPath(), paramMatrix);
      j += 1;
    }
    this.path.computeBounds(this.boundsRect, false);
    if (this.jdField_a_of_type_ComTencentLottieNewModelContentGradientType == GradientType.Linear) {}
    for (Object localObject = getLinearGradient();; localObject = getRadialGradient())
    {
      this.shaderMatrix.set(paramMatrix);
      ((Shader)localObject).setLocalMatrix(this.shaderMatrix);
      this.paint.setShader((Shader)localObject);
      float f1 = paramInt / 255.0F;
      paramInt = (int)(((Integer)this.b.getValue()).intValue() * f1 / 100.0F * 255.0F);
      this.paint.setAlpha(paramInt);
      paramCanvas.drawPath(this.path, this.paint);
      trt.endSection("GradientFillContent#draw");
      return;
    }
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void onValueChanged()
  {
    this.jdField_a_of_type_Trz.invalidateSelf();
  }
  
  public void setContents(List<tso> paramList1, List<tso> paramList2)
  {
    int j = 0;
    while (j < paramList2.size())
    {
      paramList1 = (tso)paramList2.get(j);
      if ((paramList1 instanceof tsy)) {
        this.paths.add((tsy)paramList1);
      }
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tst
 * JD-Core Version:    0.7.0.1
 */