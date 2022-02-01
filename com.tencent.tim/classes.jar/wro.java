import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class wro
  implements wrv
{
  public static final wrv.a<wro> a = new wrp();
  private Rect bh = new Rect();
  private int mDisplayWidth;
  private float nf;
  private float pZ;
  private float qa;
  private float qb;
  
  public wro()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    DisplayMetrics localDisplayMetrics = localBaseApplication.getResources().getDisplayMetrics();
    this.mDisplayWidth = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    float f = this.mDisplayWidth / 750.0F;
    this.nf = (12.0F * f);
    this.pZ = (f * 6.0F);
    this.qa = (jll.dp2px(localBaseApplication, 50.0F) / 1000.0F);
    this.qb = (jll.dp2px(localBaseApplication, 0.4F) / 1000.0F);
  }
  
  public wro(wru paramwru)
  {
    paramwru.readInt();
    this.bh = paramwru.r();
    this.nf = paramwru.readFloat();
    this.pZ = paramwru.readFloat();
    this.qa = paramwru.readFloat();
    this.qb = paramwru.readFloat();
  }
  
  public float J()
  {
    return this.pZ;
  }
  
  public float a(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f = (float)paramLong / 1000.0F;
    paramFloat1 = (float)Math.sqrt((paramFloat3 - paramFloat1) * (paramFloat3 - paramFloat1) + (paramFloat4 - paramFloat2) * (paramFloat4 - paramFloat2));
    if (paramFloat1 <= 0.0F)
    {
      paramFloat1 = aI();
      return paramFloat1;
    }
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    paramFloat2 = f / paramFloat1;
    if (this.bh.width() > 0) {}
    for (paramFloat1 = this.bh.width();; paramFloat1 = this.mDisplayWidth)
    {
      paramFloat2 *= jll.a(localBaseApplication, paramFloat1);
      paramFloat3 = aJ();
      paramFloat4 = aK();
      f = J();
      paramFloat1 = aI();
      if (paramFloat2 > paramFloat3) {
        break;
      }
      if (paramFloat2 >= paramFloat4) {
        break label139;
      }
      return f;
    }
    label139:
    return (paramFloat2 - paramFloat4) * (aI() - f) / (paramFloat3 - paramFloat4) + f;
  }
  
  public void a(wro paramwro)
  {
    this.qa = paramwro.aJ();
    this.qb = paramwro.aK();
    this.nf = paramwro.aI();
    this.pZ = paramwro.J();
    this.bh.set(paramwro.k());
  }
  
  public void a(wru paramwru, int paramInt)
  {
    paramwru.writeInt(1);
    paramwru.g(this.bh);
    paramwru.writeFloat(this.nf);
    paramwru.writeFloat(this.pZ);
    paramwru.writeFloat(this.qa);
    paramwru.writeFloat(this.qb);
  }
  
  public void a(wrx paramwrx)
  {
    if (paramwrx == null) {}
    for (;;)
    {
      return;
      ArrayList localArrayList = paramwrx.bJ();
      if (localArrayList != null)
      {
        int j = localArrayList.size();
        if (j == 1)
        {
          ((wrx.a)localArrayList.get(0)).setWidth(aI());
          return;
        }
        if (j > 1)
        {
          ((wrx.a)localArrayList.get(0)).setWidth(aI());
          paramwrx = (wrx.a)localArrayList.get(0);
          int i = 1;
          while (i < j)
          {
            wrx.a locala = (wrx.a)localArrayList.get(i);
            locala.setWidth(a(locala.getTime() - paramwrx.getTime(), paramwrx.getX(), paramwrx.getY(), locala.getX(), locala.getY()));
            i += 1;
            paramwrx = locala;
          }
        }
      }
    }
  }
  
  public float aI()
  {
    return this.nf;
  }
  
  public float aJ()
  {
    return this.qa;
  }
  
  public float aK()
  {
    return this.qb;
  }
  
  public void aq(float paramFloat)
  {
    this.qa = paramFloat;
  }
  
  public void ar(float paramFloat)
  {
    this.qb = paramFloat;
  }
  
  public void fv(int paramInt1, int paramInt2)
  {
    this.bh.set(0, 0, paramInt1, paramInt2);
  }
  
  public Rect k()
  {
    return this.bh;
  }
  
  public void setMaxWidth(float paramFloat)
  {
    this.nf = paramFloat;
  }
  
  public void setMinWidth(float paramFloat)
  {
    this.pZ = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wro
 * JD-Core Version:    0.7.0.1
 */