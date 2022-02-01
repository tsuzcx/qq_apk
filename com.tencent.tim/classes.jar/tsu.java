import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.support.annotation.Nullable;
import com.tencent.lottieNew.model.content.GradientType;
import com.tencent.lottieNew.model.content.ShapeStroke.LineCapType;
import com.tencent.lottieNew.model.content.ShapeStroke.LineJoinType;

public class tsu
  extends tsm
{
  private final GradientType a;
  private final RectF boundsRect = new RectF();
  private final int cacheSteps;
  private final ttg<tvk, tvk> f;
  private final ttg<PointF, PointF> g;
  private final aure<LinearGradient> jdField_h_of_type_Aure = new aure();
  private final ttg<PointF, PointF> jdField_h_of_type_Ttg;
  private final aure<RadialGradient> i = new aure();
  private final String name;
  
  public tsu(trz paramtrz, twe paramtwe, tvn paramtvn)
  {
    super(paramtrz, paramtwe, paramtvn.a().toPaintCap(), paramtvn.a().toPaintJoin(), paramtvn.b(), paramtvn.e(), paramtvn.getLineDashPattern(), paramtvn.f());
    this.name = paramtvn.getName();
    this.a = paramtvn.a();
    this.cacheSteps = ((int)(paramtrz.a().getDuration() / 32L));
    this.f = paramtvn.a().g();
    this.f.b(this);
    paramtwe.a(this.f);
    this.g = paramtvn.b().g();
    this.g.b(this);
    paramtwe.a(this.g);
    this.jdField_h_of_type_Ttg = paramtvn.c().g();
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
    int k = (int)(this.boundsRect.left + this.boundsRect.width() / 2.0F + ((PointF)localObject1).x);
    float f1 = this.boundsRect.top;
    float f2 = this.boundsRect.height() / 2.0F;
    int m = (int)(((PointF)localObject1).y + (f1 + f2));
    int n = (int)(this.boundsRect.left + this.boundsRect.width() / 2.0F + localPointF.x);
    int i1 = (int)(this.boundsRect.top + this.boundsRect.height() / 2.0F + localPointF.y);
    localObject1 = new LinearGradient(k, m, n, i1, arrayOfInt, (float[])localObject2, Shader.TileMode.CLAMP);
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
    int k = (int)(this.boundsRect.left + this.boundsRect.width() / 2.0F + ((PointF)localObject1).x);
    float f1 = this.boundsRect.top;
    float f2 = this.boundsRect.height() / 2.0F;
    int m = (int)(((PointF)localObject1).y + (f1 + f2));
    int n = (int)(this.boundsRect.left + this.boundsRect.width() / 2.0F + localPointF.x);
    f1 = this.boundsRect.top;
    f2 = this.boundsRect.height() / 2.0F;
    int i1 = (int)(localPointF.y + (f1 + f2));
    f1 = (float)Math.hypot(n - k, i1 - m);
    localObject1 = new RadialGradient(k, m, f1, arrayOfInt, (float[])localObject2, Shader.TileMode.CLAMP);
    this.i.put(j, localObject1);
    return localObject1;
  }
  
  public void b(@Nullable String paramString1, @Nullable String paramString2, @Nullable ColorFilter paramColorFilter) {}
  
  public void draw(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    a(this.boundsRect, paramMatrix);
    if (this.a == GradientType.Linear) {
      this.paint.setShader(getLinearGradient());
    }
    for (;;)
    {
      super.draw(paramCanvas, paramMatrix, paramInt);
      return;
      this.paint.setShader(getRadialGradient());
    }
  }
  
  public String getName()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tsu
 * JD-Core Version:    0.7.0.1
 */