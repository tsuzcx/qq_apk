import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.tencent.lottieNew.model.content.ShapeTrimPath.Type;
import java.util.ArrayList;
import java.util.List;

public abstract class tsm
  implements tsq, ttg.a
{
  private final trz jdField_a_of_type_Trz;
  private final ttg<?, Float> jdField_a_of_type_Ttg;
  private final ttg<?, Integer> b;
  @Nullable
  private final ttg<?, Float> c;
  private final List<ttg<?, Float>> dashPatternAnimations;
  private final float[] dashPatternValues;
  final Paint paint = new Paint(1);
  private final Path path = new Path();
  private final List<tsm.a> pathGroups = new ArrayList();
  private final PathMeasure pm = new PathMeasure();
  private final RectF rect = new RectF();
  private final Path trimPathPath = new Path();
  
  tsm(trz paramtrz, twe paramtwe, Paint.Cap paramCap, Paint.Join paramJoin, tuq paramtuq, tum paramtum1, List<tum> paramList, tum paramtum2)
  {
    this.jdField_a_of_type_Trz = paramtrz;
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setStrokeCap(paramCap);
    this.paint.setStrokeJoin(paramJoin);
    this.b = paramtuq.g();
    this.jdField_a_of_type_Ttg = paramtum1.g();
    if (paramtum2 == null) {}
    for (this.c = null;; this.c = paramtum2.g())
    {
      this.dashPatternAnimations = new ArrayList(paramList.size());
      this.dashPatternValues = new float[paramList.size()];
      i = 0;
      while (i < paramList.size())
      {
        this.dashPatternAnimations.add(((tum)paramList.get(i)).g());
        i += 1;
      }
    }
    paramtwe.a(this.b);
    paramtwe.a(this.jdField_a_of_type_Ttg);
    int i = 0;
    while (i < this.dashPatternAnimations.size())
    {
      paramtwe.a((ttg)this.dashPatternAnimations.get(i));
      i += 1;
    }
    if (this.c != null) {
      paramtwe.a(this.c);
    }
    this.b.b(this);
    this.jdField_a_of_type_Ttg.b(this);
    i = j;
    while (i < paramList.size())
    {
      ((ttg)this.dashPatternAnimations.get(i)).b(this);
      i += 1;
    }
    if (this.c != null) {
      this.c.b(this);
    }
  }
  
  private void a(Canvas paramCanvas, tsm.a parama, Matrix paramMatrix)
  {
    trt.beginSection("StrokeContent#applyTrimPath");
    if (tsm.a.a(parama) == null)
    {
      trt.endSection("StrokeContent#applyTrimPath");
      return;
    }
    this.path.reset();
    int i = tsm.a.a(parama).size() - 1;
    while (i >= 0)
    {
      this.path.addPath(((tsy)tsm.a.a(parama).get(i)).getPath(), paramMatrix);
      i -= 1;
    }
    this.pm.setPath(this.path, false);
    for (float f1 = this.pm.getLength(); this.pm.nextContour(); f1 = this.pm.getLength() + f1) {}
    float f2 = ((Float)tsm.a.a(parama).c().getValue()).floatValue() * f1 / 360.0F;
    float f5 = ((Float)tsm.a.a(parama).a().getValue()).floatValue() * f1 / 100.0F + f2;
    float f6 = ((Float)tsm.a.a(parama).b().getValue()).floatValue() * f1 / 100.0F + f2;
    i = tsm.a.a(parama).size() - 1;
    f2 = 0.0F;
    if (i >= 0)
    {
      this.trimPathPath.set(((tsy)tsm.a.a(parama).get(i)).getPath());
      this.trimPathPath.transform(paramMatrix);
      this.pm.setPath(this.trimPathPath, false);
      float f7 = this.pm.getLength();
      float f3;
      if ((f6 > f1) && (f6 - f1 < f2 + f7) && (f2 < f6 - f1)) {
        if (f5 > f1)
        {
          f3 = (f5 - f1) / f7;
          label331:
          f4 = Math.min((f6 - f1) / f7, 1.0F);
          twy.applyTrimPathIfNeeded(this.trimPathPath, f3, f4, 0.0F);
          paramCanvas.drawPath(this.trimPathPath, this.paint);
        }
      }
      for (;;)
      {
        i -= 1;
        f2 += f7;
        break;
        f3 = 0.0F;
        break label331;
        if ((f2 + f7 >= f5) && (f2 <= f6))
        {
          if ((f2 + f7 > f6) || (f5 >= f2)) {
            break label444;
          }
          paramCanvas.drawPath(this.trimPathPath, this.paint);
        }
      }
      label444:
      if (f5 < f2)
      {
        f3 = 0.0F;
        label455:
        if (f6 <= f2 + f7) {
          break label509;
        }
      }
      label509:
      for (float f4 = 1.0F;; f4 = (f6 - f2) / f7)
      {
        twy.applyTrimPathIfNeeded(this.trimPathPath, f3, f4, 0.0F);
        paramCanvas.drawPath(this.trimPathPath, this.paint);
        break;
        f3 = (f5 - f2) / f7;
        break label455;
      }
    }
    trt.endSection("StrokeContent#applyTrimPath");
  }
  
  private void applyDashPatternIfNeeded(Matrix paramMatrix)
  {
    trt.beginSection("StrokeContent#applyDashPattern");
    if (this.dashPatternAnimations.isEmpty())
    {
      trt.endSection("StrokeContent#applyDashPattern");
      return;
    }
    float f = twy.getScale(paramMatrix);
    int i = 0;
    if (i < this.dashPatternAnimations.size())
    {
      this.dashPatternValues[i] = ((Float)((ttg)this.dashPatternAnimations.get(i)).getValue()).floatValue();
      if (i % 2 == 0) {
        if (this.dashPatternValues[i] < 1.0F) {
          this.dashPatternValues[i] = 1.0F;
        }
      }
      for (;;)
      {
        paramMatrix = this.dashPatternValues;
        paramMatrix[i] *= f;
        i += 1;
        break;
        if (this.dashPatternValues[i] < 0.1F) {
          this.dashPatternValues[i] = 0.1F;
        }
      }
    }
    if (this.c == null) {}
    for (f = 0.0F;; f = ((Float)this.c.getValue()).floatValue())
    {
      this.paint.setPathEffect(new DashPathEffect(this.dashPatternValues, f));
      trt.endSection("StrokeContent#applyDashPattern");
      return;
    }
  }
  
  public void a(RectF paramRectF, Matrix paramMatrix)
  {
    trt.beginSection("StrokeContent#getBounds");
    this.path.reset();
    int i = 0;
    while (i < this.pathGroups.size())
    {
      tsm.a locala = (tsm.a)this.pathGroups.get(i);
      int j = 0;
      while (j < tsm.a.a(locala).size())
      {
        this.path.addPath(((tsy)tsm.a.a(locala).get(j)).getPath(), paramMatrix);
        j += 1;
      }
      i += 1;
    }
    this.path.computeBounds(this.rect, false);
    float f1 = ((Float)this.jdField_a_of_type_Ttg.getValue()).floatValue();
    paramMatrix = this.rect;
    float f2 = this.rect.left;
    float f3 = f1 / 2.0F;
    float f4 = this.rect.top;
    float f5 = f1 / 2.0F;
    float f6 = this.rect.right;
    float f7 = f1 / 2.0F;
    float f8 = this.rect.bottom;
    paramMatrix.set(f2 - f3, f4 - f5, f6 + f7, f1 / 2.0F + f8);
    paramRectF.set(this.rect);
    paramRectF.set(paramRectF.left - 1.0F, paramRectF.top - 1.0F, paramRectF.right + 1.0F, paramRectF.bottom + 1.0F);
    trt.endSection("StrokeContent#getBounds");
  }
  
  public void draw(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    trt.beginSection("StrokeContent#draw");
    float f = paramInt / 255.0F;
    paramInt = (int)(((Integer)this.b.getValue()).intValue() * f / 100.0F * 255.0F);
    this.paint.setAlpha(paramInt);
    this.paint.setStrokeWidth(((Float)this.jdField_a_of_type_Ttg.getValue()).floatValue() * twy.getScale(paramMatrix));
    if (this.paint.getStrokeWidth() <= 0.0F)
    {
      trt.endSection("StrokeContent#draw");
      return;
    }
    applyDashPatternIfNeeded(paramMatrix);
    paramInt = 0;
    if (paramInt < this.pathGroups.size())
    {
      tsm.a locala = (tsm.a)this.pathGroups.get(paramInt);
      if (tsm.a.a(locala) != null) {
        a(paramCanvas, locala, paramMatrix);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        trt.beginSection("StrokeContent#buildPath");
        this.path.reset();
        int i = tsm.a.a(locala).size() - 1;
        while (i >= 0)
        {
          this.path.addPath(((tsy)tsm.a.a(locala).get(i)).getPath(), paramMatrix);
          i -= 1;
        }
        trt.endSection("StrokeContent#buildPath");
        trt.beginSection("StrokeContent#drawPath");
        paramCanvas.drawPath(this.path, this.paint);
        trt.endSection("StrokeContent#drawPath");
      }
    }
    trt.endSection("StrokeContent#draw");
  }
  
  public void onValueChanged()
  {
    this.jdField_a_of_type_Trz.invalidateSelf();
  }
  
  public void setContents(List<tso> paramList1, List<tso> paramList2)
  {
    int i = paramList1.size() - 1;
    ttf localttf = null;
    tso localtso;
    if (i >= 0)
    {
      localtso = (tso)paramList1.get(i);
      if ((!(localtso instanceof ttf)) || (((ttf)localtso).a() != ShapeTrimPath.Type.Individually)) {
        break label232;
      }
      localttf = (ttf)localtso;
    }
    label232:
    for (;;)
    {
      i -= 1;
      break;
      if (localttf != null) {
        localttf.a(this);
      }
      i = paramList2.size() - 1;
      paramList1 = null;
      if (i >= 0)
      {
        localtso = (tso)paramList2.get(i);
        if (((localtso instanceof ttf)) && (((ttf)localtso).a() == ShapeTrimPath.Type.Individually))
        {
          if (paramList1 != null) {
            this.pathGroups.add(paramList1);
          }
          paramList1 = new tsm.a((ttf)localtso, null);
          ((ttf)localtso).a(this);
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        if ((localtso instanceof tsy))
        {
          if (paramList1 == null) {
            paramList1 = new tsm.a(localttf, null);
          }
          for (;;)
          {
            tsm.a.a(paramList1).add((tsy)localtso);
            break;
            if (paramList1 != null) {
              this.pathGroups.add(paramList1);
            }
            return;
          }
        }
      }
    }
  }
  
  static final class a
  {
    @Nullable
    private final ttf a;
    private final List<tsy> paths = new ArrayList();
    
    private a(@Nullable ttf paramttf)
    {
      this.a = paramttf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tsm
 * JD-Core Version:    0.7.0.1
 */