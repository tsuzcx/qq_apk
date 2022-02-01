import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tencent.lottieNew.model.content.PolystarShape;
import com.tencent.lottieNew.model.content.PolystarShape.Type;
import com.tencent.lottieNew.model.content.ShapeTrimPath.Type;
import java.util.List;

public class tsz
  implements tsy, ttg.a
{
  private final PolystarShape.Type jdField_a_of_type_ComTencentLottieNewModelContentPolystarShape$Type;
  private final trz jdField_a_of_type_Trz;
  @Nullable
  private ttf jdField_a_of_type_Ttf;
  private final ttg<?, PointF> e;
  private final ttg<?, Float> i;
  private boolean isPathValid;
  private final ttg<?, Float> j;
  @Nullable
  private final ttg<?, Float> k;
  private final ttg<?, Float> l;
  @Nullable
  private final ttg<?, Float> m;
  private final ttg<?, Float> n;
  private final String name;
  private final Path path = new Path();
  
  public tsz(trz paramtrz, twe paramtwe, PolystarShape paramPolystarShape)
  {
    this.jdField_a_of_type_Trz = paramtrz;
    this.name = paramPolystarShape.getName();
    this.jdField_a_of_type_ComTencentLottieNewModelContentPolystarShape$Type = paramPolystarShape.a();
    this.i = paramPolystarShape.g().g();
    this.e = paramPolystarShape.a().g();
    this.j = paramPolystarShape.b().g();
    this.l = paramPolystarShape.i().g();
    this.n = paramPolystarShape.k().g();
    if (this.jdField_a_of_type_ComTencentLottieNewModelContentPolystarShape$Type == PolystarShape.Type.Star) {
      this.k = paramPolystarShape.h().g();
    }
    for (this.m = paramPolystarShape.j().g();; this.m = null)
    {
      paramtwe.a(this.i);
      paramtwe.a(this.e);
      paramtwe.a(this.j);
      paramtwe.a(this.l);
      paramtwe.a(this.n);
      if (this.jdField_a_of_type_ComTencentLottieNewModelContentPolystarShape$Type == PolystarShape.Type.Star)
      {
        paramtwe.a(this.k);
        paramtwe.a(this.m);
      }
      this.i.b(this);
      this.e.b(this);
      this.j.b(this);
      this.l.b(this);
      this.n.b(this);
      if (this.jdField_a_of_type_ComTencentLottieNewModelContentPolystarShape$Type == PolystarShape.Type.Star)
      {
        this.l.b(this);
        this.n.b(this);
      }
      return;
      this.k = null;
    }
  }
  
  private void createPolygonPath()
  {
    int i1 = (int)Math.floor(((Float)this.i.getValue()).floatValue());
    double d1;
    float f5;
    float f1;
    float f2;
    double d3;
    label134:
    float f4;
    float f3;
    if (this.j == null)
    {
      d1 = 0.0D;
      d1 = Math.toRadians(d1 - 90.0D);
      f5 = (float)(6.283185307179586D / i1);
      float f6 = ((Float)this.n.getValue()).floatValue() / 100.0F;
      float f7 = ((Float)this.l.getValue()).floatValue();
      f1 = (float)(f7 * Math.cos(d1));
      f2 = (float)(f7 * Math.sin(d1));
      this.path.moveTo(f1, f2);
      d3 = f5;
      double d2 = Math.ceil(i1);
      i1 = 0;
      d1 += d3;
      if (i1 >= d2) {
        break label365;
      }
      f4 = (float)(f7 * Math.cos(d1));
      f3 = (float)(f7 * Math.sin(d1));
      if (f6 == 0.0F) {
        break label351;
      }
      float f9 = (float)(Math.atan2(f2, f1) - 1.570796326794897D);
      float f8 = (float)Math.cos(f9);
      f9 = (float)Math.sin(f9);
      float f11 = (float)(Math.atan2(f3, f4) - 1.570796326794897D);
      float f10 = (float)Math.cos(f11);
      f11 = (float)Math.sin(f11);
      this.path.cubicTo(f1 - f8 * (f7 * f6 * 0.25F), f2 - f7 * f6 * 0.25F * f9, f4 + f10 * (f7 * f6 * 0.25F), f11 * (f7 * f6 * 0.25F) + f3, f4, f3);
    }
    for (;;)
    {
      d3 = f5;
      i1 += 1;
      f1 = f4;
      d1 += d3;
      f2 = f3;
      break label134;
      d1 = ((Float)this.j.getValue()).floatValue();
      break;
      label351:
      this.path.lineTo(f4, f3);
    }
    label365:
    PointF localPointF = (PointF)this.e.getValue();
    this.path.offset(localPointF.x, localPointF.y);
    this.path.close();
  }
  
  private void createStarPath()
  {
    float f8 = ((Float)this.i.getValue()).floatValue();
    double d1;
    float f17;
    float f14;
    float f18;
    if (this.j == null)
    {
      d1 = 0.0D;
      d1 = Math.toRadians(d1 - 90.0D);
      f17 = (float)(6.283185307179586D / f8);
      f14 = f17 / 2.0F;
      f18 = f8 - (int)f8;
      if (f18 == 0.0F) {
        break label840;
      }
      d1 += (1.0F - f18) * f14;
    }
    label265:
    label551:
    label560:
    label569:
    label578:
    label709:
    label840:
    for (;;)
    {
      float f3 = ((Float)this.l.getValue()).floatValue();
      float f4 = ((Float)this.k.getValue()).floatValue();
      if (this.m != null) {}
      for (float f1 = ((Float)this.m.getValue()).floatValue() / 100.0F;; f1 = 0.0F)
      {
        float f2 = 0.0F;
        if (this.n != null) {
          f2 = ((Float)this.n.getValue()).floatValue() / 100.0F;
        }
        float f5;
        float f6;
        float f7;
        label223:
        double d2;
        int i2;
        int i1;
        float f10;
        float f9;
        if (f18 != 0.0F)
        {
          f5 = f4 + (f3 - f4) * f18;
          f6 = (float)(f5 * Math.cos(d1));
          f7 = (float)(f5 * Math.sin(d1));
          this.path.moveTo(f6, f7);
          d1 += f17 * f18 / 2.0F;
          d2 = Math.ceil(f8) * 2.0D;
          i2 = 0;
          i1 = 0;
          f10 = f6;
          f9 = f7;
          label248:
          if (i2 >= d2) {
            break label771;
          }
          if (i1 == 0) {
            break label467;
          }
          f6 = f3;
          if ((f5 == 0.0F) || (i2 != d2 - 2.0D)) {
            break label827;
          }
        }
        for (float f11 = f17 * f18 / 2.0F;; f11 = f14)
        {
          f7 = f6;
          if (f5 != 0.0F)
          {
            f7 = f6;
            if (i2 == d2 - 1.0D) {
              f7 = f5;
            }
          }
          float f15 = (float)(f7 * Math.cos(d1));
          float f16 = (float)(f7 * Math.sin(d1));
          if ((f1 == 0.0F) && (f2 == 0.0F))
          {
            this.path.lineTo(f15, f16);
            double d3 = f11;
            if (i1 != 0) {
              break label765;
            }
            i1 = 1;
            label382:
            i2 += 1;
            f9 = f16;
            f10 = f15;
            d1 += d3;
            break label248;
            d1 = ((Float)this.j.getValue()).floatValue();
            break;
            f6 = (float)(f3 * Math.cos(d1));
            f7 = (float)(f3 * Math.sin(d1));
            this.path.moveTo(f6, f7);
            d1 += f14;
            f5 = 0.0F;
            break label223;
            label467:
            f6 = f4;
            break label265;
          }
          f6 = (float)(Math.atan2(f9, f10) - 1.570796326794897D);
          f8 = (float)Math.cos(f6);
          float f21 = (float)Math.sin(f6);
          f6 = (float)(Math.atan2(f16, f15) - 1.570796326794897D);
          float f19 = (float)Math.cos(f6);
          float f20 = (float)Math.sin(f6);
          float f12;
          float f13;
          if (i1 != 0)
          {
            f6 = f1;
            if (i1 == 0) {
              break label709;
            }
            f7 = f2;
            if (i1 == 0) {
              break label716;
            }
            f12 = f4;
            if (i1 == 0) {
              break label723;
            }
            f13 = f3;
            f8 *= f12 * f6 * 0.47829F;
            f12 = f12 * f6 * 0.47829F * f21;
            f6 = f13 * f7 * 0.47829F * f19;
            f7 = f13 * f7 * 0.47829F * f20;
            if (f18 == 0.0F) {
              break label808;
            }
            if (i2 != 0) {
              break label730;
            }
            f12 *= f18;
            f13 = f8 * f18;
            f8 = f7;
            f7 = f6;
            f6 = f13;
          }
          for (;;)
          {
            this.path.cubicTo(f10 - f6, f9 - f12, f7 + f15, f8 + f16, f15, f16);
            break;
            f6 = f2;
            break label551;
            f7 = f1;
            break label560;
            label716:
            f12 = f3;
            break label569;
            label723:
            f13 = f4;
            break label578;
            label730:
            if (i2 == d2 - 1.0D)
            {
              f13 = f7 * f18;
              f7 = f6 * f18;
              f6 = f8;
              f8 = f13;
              continue;
              label765:
              i1 = 0;
              break label382;
              PointF localPointF = (PointF)this.e.getValue();
              this.path.offset(localPointF.x, localPointF.y);
              this.path.close();
              return;
            }
            f13 = f7;
            f7 = f6;
            f6 = f8;
            f8 = f13;
          }
        }
      }
    }
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
    switch (tta.fe[this.jdField_a_of_type_ComTencentLottieNewModelContentPolystarShape$Type.ordinal()])
    {
    }
    for (;;)
    {
      this.path.close();
      twy.a(this.path, this.jdField_a_of_type_Ttf);
      this.isPathValid = true;
      return this.path;
      createStarPath();
      continue;
      createPolygonPath();
    }
  }
  
  public void onValueChanged()
  {
    invalidate();
  }
  
  public void setContents(List<tso> paramList1, List<tso> paramList2)
  {
    int i1 = 0;
    while (i1 < paramList1.size())
    {
      paramList2 = (tso)paramList1.get(i1);
      if (((paramList2 instanceof ttf)) && (((ttf)paramList2).a() == ShapeTrimPath.Type.Simultaneously))
      {
        this.jdField_a_of_type_Ttf = ((ttf)paramList2);
        this.jdField_a_of_type_Ttf.a(this);
      }
      i1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tsz
 * JD-Core Version:    0.7.0.1
 */