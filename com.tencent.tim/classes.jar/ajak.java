import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Locale;

public class ajak
  implements ValueAnimator.AnimatorUpdateListener
{
  private float G = 0.0005F;
  private int JO;
  private long acd;
  private ValueAnimator at;
  private int dhA = 60;
  private int dhB = 35;
  private int dhC = 160;
  private int dhD = 20;
  private int dhE = 150;
  private int dhz;
  protected float mAlpha = 1.0F;
  private final int mMaxSize;
  private final int mMode;
  protected Paint mPaint;
  private final Rect mTemp = new Rect();
  private View mView;
  private int mViewHeight;
  private Bitmap[] p;
  private final ArrayList<ajak.a> xB;
  private final ArrayList<ajak.a> xC;
  private final ArrayList<ajak.a> xD;
  
  public ajak(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    this.mView = paramView;
    this.mPaint = new Paint();
    paramView = this.mView.getResources();
    float f = paramView.getDisplayMetrics().density;
    this.mMode = paramInt1;
    this.mMaxSize = paramInt2;
    this.xB = new ArrayList(this.mMaxSize / 2);
    if ((this.mMode & 0x1) == 1) {
      this.xD = new ArrayList(150);
    }
    for (;;)
    {
      this.xC = new ArrayList(this.mMaxSize / 3);
      this.dhz = 0;
      this.p = new Bitmap[paramArrayOfInt.length];
      paramInt1 = i;
      label180:
      if (paramInt1 < this.p.length) {
        try
        {
          this.p[paramInt1] = BitmapFactory.decodeResource(paramView, paramArrayOfInt[paramInt1]);
          paramInt1 += 1;
          break label180;
          this.xD = new ArrayList(1);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            localOutOfMemoryError.printStackTrace();
          }
        }
      }
    }
    this.dhA = ((int)(this.dhA * f));
    this.dhB = ((int)(this.dhB * f));
    this.dhC = ((int)(this.dhC * f));
    this.dhD = ((int)(this.dhD * f));
    this.dhE = ((int)(this.dhE * f));
  }
  
  public static double d(double paramDouble1, double paramDouble2)
  {
    return (paramDouble2 - paramDouble1) * Math.random() + paramDouble1;
  }
  
  public void a(float paramFloat1, float paramFloat2, ajak.a parama)
  {
    if (parama != null)
    {
      double d1 = d(this.dhD, this.dhE);
      double d3 = d(0.0D, 6.283185307179586D);
      double d2 = Math.cos(d3);
      d3 = Math.sin(d3);
      int i = (int)(Math.random() * this.p.length);
      parama.x = ((float)(d2 * d1 + paramFloat1));
      parama.y = ((float)(d1 * d3 + paramFloat2));
      parama.xd = ((float)(d(5.0D, 10.0D) * d2));
      parama.xe = ((float)(d(5.0D, 10.0D) * d3));
      parama.dhG = i;
      parama.size = ((int)d(this.dhB, this.dhA));
      parama.xf = ((float)d(0.9800000190734863D, 0.9900000095367432D));
      parama.alpha = ((float)d(0.5D, 1.0D));
      parama.xg = ((float)d(0.9800000190734863D, 0.9900000095367432D));
    }
  }
  
  public boolean a(ajak.a parama)
  {
    if (parama == null) {}
    while ((parama.size < 1) || (parama.alpha <= 0.05F) || (parama.x + parama.size * 0.5F < 0.0F) || (parama.y + parama.size * 0.5F < 0.0F) || (parama.x - parama.size * 0.5F > this.JO) || (parama.y - parama.size * 0.5F > this.mViewHeight)) {
      return false;
    }
    return true;
  }
  
  public void aU(Canvas paramCanvas)
  {
    int i = this.xD.size() - 1;
    while (i >= 0)
    {
      localObject = (ajak.a)this.xD.get(i);
      if (!a((ajak.a)localObject))
      {
        this.xD.remove(i);
        if ((localObject != null) && (this.dhz < this.mMaxSize))
        {
          this.xB.add(localObject);
          this.dhz += 1;
        }
      }
      i -= 1;
    }
    Object localObject = this.mTemp;
    i = 0;
    if (i < this.xD.size())
    {
      ajak.a locala = (ajak.a)this.xD.get(i);
      if (locala == null) {}
      for (;;)
      {
        i += 1;
        break;
        this.mPaint.setAlpha((int)(this.mAlpha * locala.alpha * 2.0F * 255.0F) % 256);
        ((Rect)localObject).left = ((int)(locala.x - locala.size * 0.5F));
        ((Rect)localObject).top = ((int)(locala.y - locala.size * 0.5F));
        ((Rect)localObject).bottom = (((Rect)localObject).top + locala.size);
        ((Rect)localObject).right = (((Rect)localObject).left + locala.size);
        paramCanvas.drawBitmap(this.p[locala.dhG], null, (Rect)localObject, this.mPaint);
        locala.x += locala.xd;
        locala.y += locala.xe;
        locala.xd *= 0.98F;
        locala.xe = (locala.xe * 0.98F + this.G);
        locala.alpha *= locala.xg;
      }
    }
  }
  
  public void aV(Canvas paramCanvas)
  {
    int i = this.xC.size() - 1;
    while (i >= 0)
    {
      localObject = (ajak.a)this.xC.get(i);
      if (!a((ajak.a)localObject))
      {
        this.xC.remove(i);
        if (localObject != null) {
          this.xB.add(localObject);
        }
      }
      i -= 1;
    }
    if (Math.abs(SystemClock.elapsedRealtime() - this.acd) > 64L)
    {
      this.acd = SystemClock.elapsedRealtime();
      dvS();
    }
    Object localObject = this.mTemp;
    i = 0;
    while (i < this.xC.size())
    {
      ajak.a locala = (ajak.a)this.xC.get(i);
      if (locala != null)
      {
        float f = (float)Math.abs(Math.cos(locala.xh) * locala.alpha);
        if (f >= 0.01F)
        {
          this.mPaint.setAlpha((int)(f * this.mAlpha * 255.0F));
          ((Rect)localObject).left = ((int)(Math.cos(locala.xk) * locala.xj + (locala.x - locala.size * 0.5F)));
          ((Rect)localObject).top = ((int)(locala.y - locala.size * 0.5F));
          ((Rect)localObject).bottom = (((Rect)localObject).top + locala.size);
          ((Rect)localObject).right = (((Rect)localObject).left + locala.size);
          paramCanvas.drawBitmap(this.p[locala.dhG], null, (Rect)localObject, this.mPaint);
        }
        locala.x += locala.xd;
        locala.y += locala.xe;
        locala.alpha *= locala.xg;
        locala.xh += locala.xi;
        locala.xk += locala.xl;
      }
      i += 1;
    }
  }
  
  public void d(Canvas paramCanvas, int paramInt)
  {
    if (this.mAlpha <= 0.05F) {}
    do
    {
      return;
      if ((paramInt == 1) && ((this.mMode & 0x1) == 1) && (this.xD.size() > 0)) {
        aU(paramCanvas);
      }
    } while ((paramInt != 2) || ((this.mMode & 0x2) != 2));
    if (((this.mMode & 0x1) == 1) && (this.xD.size() < 150))
    {
      aV(paramCanvas);
      return;
    }
    aV(paramCanvas);
  }
  
  public void destroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ParticleSystem", 2, "destroy");
    }
    stop();
    this.mView = null;
  }
  
  public void dvS()
  {
    ajak.a locala = null;
    double d1 = d(this.dhC, -this.dhC);
    double d2 = d(this.dhC, -this.dhC);
    int i = (int)(Math.random() * this.p.length);
    float f1 = this.JO;
    float f2 = this.mViewHeight;
    if (this.dhz < this.mMaxSize)
    {
      locala = new ajak.a();
      this.dhz += 1;
    }
    for (;;)
    {
      if (locala != null)
      {
        locala.x = ((float)(d1 + f1 * 0.5F));
        locala.y = ((float)(f2 * 0.4F + d2));
        locala.xd = 0.0F;
        locala.xe = ((float)d(-1.0D, -2.0D));
        locala.dhG = i;
        locala.size = ((int)d(this.dhB, this.dhA));
        locala.xf = ((float)d(0.9950000047683716D, 0.9980000257492065D));
        locala.alpha = ((float)d(1.0D, 1.0D));
        locala.xg = ((float)d(0.9900000095367432D, 0.9800000190734863D));
        locala.xh = ((float)d(0.0D, 3.141592653589793D));
        locala.xi = ((float)d(0.01D, 0.001D));
        locala.xj = ((float)d(20.0D, 5.0D));
        locala.xk = ((float)d(0.0D, 3.141592653589793D));
        locala.xl = ((float)d(0.01D, 0.1D));
        locala.start = SystemClock.elapsedRealtime();
        this.xC.add(locala);
      }
      return;
      if (this.xB.size() > 0) {
        locala = (ajak.a)this.xB.remove(this.xB.size() - 1);
      }
    }
  }
  
  public void init(int paramInt1, int paramInt2)
  {
    int i = 0;
    this.JO = paramInt1;
    this.mViewHeight = paramInt2;
    this.dhC = ((int)(Math.min(this.JO, this.mViewHeight) * 0.4F));
    this.dhD = ((int)(this.dhC * 0.6F));
    this.dhE = ((int)(this.dhC * 0.8F));
    this.dhz = 0;
    this.xB.clear();
    this.xD.clear();
    this.xC.clear();
    if ((this.mMode & 0x1) == 1)
    {
      float f1 = this.JO;
      float f2 = this.mViewHeight;
      paramInt1 = 0;
      while (paramInt1 < 150)
      {
        ajak.a locala = new ajak.a();
        a(0.5F * f1, 0.4F * f2, locala);
        this.xD.add(locala);
        paramInt1 += 1;
      }
    }
    if ((this.mMode & 0x2) == 2)
    {
      paramInt1 = i;
      while (paramInt1 < 40)
      {
        dvS();
        paramInt1 += 1;
      }
    }
    start();
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.mView != null) {
      this.mView.postInvalidate();
    }
  }
  
  public void setAlpha(float paramFloat)
  {
    this.mAlpha = paramFloat;
  }
  
  public void start()
  {
    if (this.at == null)
    {
      this.at = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(1000L);
      this.at.setRepeatCount(-1);
    }
    this.at.addUpdateListener(this);
    this.at.start();
  }
  
  public void stop()
  {
    if (this.at != null)
    {
      this.at.cancel();
      this.at.removeUpdateListener(this);
      this.at.removeAllUpdateListeners();
    }
  }
  
  static class a
  {
    public static int dhF;
    public float alpha;
    public int dhG;
    public int id;
    public int size;
    public long start;
    public float x;
    public float xd;
    public float xe;
    public float xf;
    public float xg;
    public float xh;
    public float xi;
    public float xj;
    public float xk;
    public float xl;
    public float y;
    
    public a()
    {
      int i = dhF;
      dhF = i + 1;
      this.id = i;
    }
    
    public String toString()
    {
      return String.format(Locale.getDefault(), "[id:%d, start: %d, x: %f, y: %f, vx: %f, vy: %f, size: %d", new Object[] { Integer.valueOf(this.id), Long.valueOf(this.start), Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.xd), Float.valueOf(this.xe), Integer.valueOf(this.size) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajak
 * JD-Core Version:    0.7.0.1
 */