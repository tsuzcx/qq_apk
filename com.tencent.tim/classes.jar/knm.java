import android.animation.ValueAnimator;
import android.graphics.Point;
import android.view.animation.AccelerateInterpolator;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyCutImageView;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyCutImageView.a;
import java.util.ArrayList;

public class knm
{
  private knm.a a;
  private ValueAnimator animator = ValueAnimator.ofFloat(new float[] { 1.0F });
  
  public knm.a a()
  {
    return this.a;
  }
  
  public void a(ReadInjoyCutImageView paramReadInjoyCutImageView, ReadInjoyCutImageView.a parama1, ReadInjoyCutImageView.a parama2, int paramInt1, int paramInt2, long paramLong)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Point localPoint1 = new Point();
    Point localPoint2 = new Point();
    Point localPoint3 = new Point();
    Point localPoint4 = new Point();
    float f1 = 0.0F;
    int n = 0;
    int i1 = 0;
    int m;
    int k;
    int j;
    int i;
    if (parama1.x == parama2.x)
    {
      parama1.y = Math.abs(parama1.y);
      parama2.y = Math.abs(parama2.y);
      if (parama1.y > parama2.y) {
        parama1.a(parama2);
      }
      localArrayList1.add(new ReadInjoyCutImageView.a(0.0F, 0.0F));
      localArrayList1.add(parama1);
      localArrayList1.add(parama2);
      localArrayList1.add(new ReadInjoyCutImageView.a(0.0F, 1.0F));
      localArrayList1.add(new ReadInjoyCutImageView.a(0.0F, 0.0F));
      localArrayList2.add(parama1);
      localArrayList2.add(new ReadInjoyCutImageView.a(1.0F, 0.0F));
      localArrayList2.add(new ReadInjoyCutImageView.a(1.0F, 1.0F));
      localArrayList2.add(parama2);
      localArrayList2.add(parama1);
      if ((paramInt1 != 5) || (paramInt2 != 5)) {
        break label2165;
      }
      m = 2;
      k = 1;
      j = 1;
      i = i1;
    }
    for (;;)
    {
      switch (m)
      {
      default: 
        label280:
        switch (k)
        {
        }
        break;
      }
      for (;;)
      {
        paramReadInjoyCutImageView.aFw();
        paramReadInjoyCutImageView.setClipArea(localArrayList1, localArrayList2);
        this.animator.setDuration(paramLong);
        this.animator.setInterpolator(new AccelerateInterpolator());
        f1 = localPoint2.x - localPoint1.x;
        f2 = localPoint2.y - localPoint1.y;
        f3 = localPoint4.x - localPoint3.x;
        float f4 = localPoint4.y - localPoint3.y;
        this.animator.addUpdateListener(new knn(this, f1, f2, f3, f4, paramReadInjoyCutImageView));
        this.animator.addListener(new kno(this, paramReadInjoyCutImageView));
        return;
        if (parama1.y == parama2.y)
        {
          parama1.y = Math.abs(parama1.y);
          parama2.y = Math.abs(parama2.y);
          if (parama1.x > parama2.x) {
            parama1.a(parama2);
          }
          localArrayList1.add(new ReadInjoyCutImageView.a(0.0F, 0.0F));
          localArrayList1.add(new ReadInjoyCutImageView.a(1.0F, 0.0F));
          localArrayList1.add(parama2);
          localArrayList1.add(parama1);
          localArrayList1.add(new ReadInjoyCutImageView.a(0.0F, 0.0F));
          localArrayList2.add(parama1);
          localArrayList2.add(parama2);
          localArrayList2.add(new ReadInjoyCutImageView.a(1.0F, 1.0F));
          localArrayList2.add(new ReadInjoyCutImageView.a(0.0F, 1.0F));
          localArrayList2.add(parama1);
          if ((paramInt1 != 5) || (paramInt2 != 5)) {
            break label2147;
          }
          m = 3;
          k = 4;
          i = 1;
          j = n;
          break;
        }
        f2 = (parama2.y - parama1.y) / (parama2.x - parama1.x);
        f3 = (parama2.y + parama1.y - (parama2.x + parama1.x) * f2) / 2.0F;
        parama1.y = Math.abs(parama1.y);
        parama2.y = Math.abs(parama2.y);
        if (f2 > 0.0F)
        {
          if (parama1.x < parama2.x) {
            parama1.a(parama2);
          }
          localArrayList1.add(new ReadInjoyCutImageView.a(0.0F, 0.0F));
          localArrayList2.add(new ReadInjoyCutImageView.a(parama1));
          locala = new ReadInjoyCutImageView.a(1.0F, 0.0F);
          if (locala.y > locala.x * f2 + f3)
          {
            localArrayList1.add(locala);
            label795:
            localArrayList1.add(parama1);
            localArrayList2.add(new ReadInjoyCutImageView.a(1.0F, 1.0F));
            localArrayList1.add(parama2);
            locala = new ReadInjoyCutImageView.a(0.0F, 1.0F);
            if (-locala.y <= locala.x * f2 + f3) {
              break label1133;
            }
            localArrayList1.add(locala);
          }
          for (;;)
          {
            localArrayList2.add(parama2);
            localArrayList1.add(new ReadInjoyCutImageView.a((ReadInjoyCutImageView.a)localArrayList1.get(0)));
            localArrayList2.add(new ReadInjoyCutImageView.a((ReadInjoyCutImageView.a)localArrayList2.get(0)));
            i = i1;
            j = n;
            f1 = f2;
            m = paramInt1;
            k = paramInt2;
            if (paramInt1 != 5) {
              break;
            }
            i = i1;
            j = n;
            f1 = f2;
            m = paramInt1;
            k = paramInt2;
            if (paramInt2 != 5) {
              break;
            }
            f1 = -1.0F / f2;
            f4 = f3 / (f1 - f2);
            localPoint1.x = ((int)(paramReadInjoyCutImageView.getWidth() * f4));
            localPoint1.y = (-(int)((f4 * f2 + f3) * paramReadInjoyCutImageView.getHeight()));
            localPoint2.x = 0;
            localPoint2.y = 0;
            f1 = (f3 + f1 + 1.0F) / (f1 - f2);
            localPoint3.x = ((int)(paramReadInjoyCutImageView.getWidth() * f1));
            localPoint3.y = (-(int)((f1 * f2 + f3) * paramReadInjoyCutImageView.getHeight()));
            localPoint4.x = paramReadInjoyCutImageView.getWidth();
            localPoint4.y = paramReadInjoyCutImageView.getHeight();
            i = i1;
            j = n;
            f1 = f2;
            m = paramInt1;
            k = paramInt2;
            break;
            localArrayList2.add(locala);
            break label795;
            label1133:
            localArrayList2.add(locala);
          }
        }
        if (parama1.x > parama2.x) {
          parama1.a(parama2);
        }
        localArrayList2.add(parama1);
        ReadInjoyCutImageView.a locala = new ReadInjoyCutImageView.a(0.0F, 0.0F);
        if (locala.y < locala.x * f2 + f3)
        {
          localArrayList1.add(locala);
          label1207:
          localArrayList1.add(parama1);
          localArrayList1.add(parama2);
          localArrayList2.add(new ReadInjoyCutImageView.a(1.0F, 0.0F));
          locala = new ReadInjoyCutImageView.a(1.0F, 1.0F);
          if (-locala.y >= locala.x * f2 + f3) {
            break label1560;
          }
          localArrayList1.add(locala);
        }
        for (;;)
        {
          localArrayList1.add(new ReadInjoyCutImageView.a(0.0F, 1.0F));
          localArrayList2.add(parama2);
          localArrayList1.add(new ReadInjoyCutImageView.a((ReadInjoyCutImageView.a)localArrayList1.get(0)));
          localArrayList2.add(new ReadInjoyCutImageView.a((ReadInjoyCutImageView.a)localArrayList2.get(0)));
          i = i1;
          j = n;
          f1 = f2;
          m = paramInt1;
          k = paramInt2;
          if (paramInt1 != 5) {
            break;
          }
          i = i1;
          j = n;
          f1 = f2;
          m = paramInt1;
          k = paramInt2;
          if (paramInt2 != 5) {
            break;
          }
          f1 = -1.0F / f2;
          f4 = (1.0F + f3) / (f1 - f2);
          localPoint1.x = ((int)(paramReadInjoyCutImageView.getWidth() * f4));
          localPoint1.y = (-(int)((f4 * f2 + f3) * paramReadInjoyCutImageView.getHeight()));
          localPoint2.x = 0;
          localPoint2.y = paramReadInjoyCutImageView.getHeight();
          f1 = (f3 + f1) / (f1 - f2);
          localPoint3.x = ((int)(paramReadInjoyCutImageView.getWidth() * f1));
          localPoint3.y = (-(int)((f1 * f2 + f3) * paramReadInjoyCutImageView.getHeight()));
          localPoint4.x = paramReadInjoyCutImageView.getWidth();
          localPoint4.y = 0;
          i = i1;
          j = n;
          f1 = f2;
          m = paramInt1;
          k = paramInt2;
          break;
          localArrayList2.add(locala);
          break label1207;
          label1560:
          localArrayList2.add(locala);
        }
        localPoint1.x = ((int)(Math.max(parama1.x, parama2.x) * paramReadInjoyCutImageView.getWidth()));
        localPoint1.y = 0;
        localPoint2.x = 0;
        localPoint2.y = 0;
        break label280;
        f2 = Math.max(parama1.x, parama2.x);
        localPoint1.x = 0;
        localPoint1.y = 0;
        localPoint2.x = ((int)(f2 * paramReadInjoyCutImageView.getWidth()));
        localPoint2.y = 0;
        break label280;
        f2 = Math.min(parama1.y, parama2.y);
        f3 = Math.max(parama1.y, parama2.y);
        if ((i != 0) || (j != 0) || (f1 > 0.0F)) {}
        for (paramInt1 = 0;; paramInt1 = (int)(f2 * paramReadInjoyCutImageView.getHeight()))
        {
          localPoint1.y = paramInt1;
          localPoint1.x = 0;
          localPoint2.y = ((int)(paramReadInjoyCutImageView.getHeight() * f3));
          localPoint2.x = 0;
          break;
        }
        f2 = Math.min(parama1.y, parama2.y);
        localPoint1.y = ((int)(Math.max(parama1.y, parama2.y) * paramReadInjoyCutImageView.getHeight()));
        localPoint1.x = 0;
        if ((i != 0) || (j != 0) || (f1 > 0.0F)) {}
        for (paramInt1 = 0;; paramInt1 = (int)(f2 * paramReadInjoyCutImageView.getHeight()))
        {
          localPoint2.y = paramInt1;
          localPoint2.x = 0;
          break;
        }
        f1 = Math.min(parama1.x, parama2.x);
        localPoint3.x = paramReadInjoyCutImageView.getWidth();
        localPoint3.y = 0;
        localPoint4.x = ((int)(f1 * paramReadInjoyCutImageView.getWidth()));
        localPoint4.y = 0;
        continue;
        localPoint3.x = ((int)(Math.min(parama1.x, parama2.x) * paramReadInjoyCutImageView.getWidth()));
        localPoint3.y = 0;
        localPoint4.x = paramReadInjoyCutImageView.getWidth();
        localPoint4.y = 0;
      }
      float f2 = Math.min(parama1.y, parama2.y);
      float f3 = Math.max(parama1.y, parama2.y);
      localPoint3.y = ((int)(f2 * paramReadInjoyCutImageView.getHeight()));
      localPoint3.x = 0;
      if ((i != 0) || (j != 0) || (f1 > 0.0F)) {}
      for (paramInt1 = paramReadInjoyCutImageView.getHeight();; paramInt1 = (int)(paramReadInjoyCutImageView.getHeight() * f3))
      {
        localPoint4.y = paramInt1;
        localPoint4.x = 0;
        break;
      }
      f2 = Math.min(parama1.y, parama2.y);
      f3 = Math.max(parama1.y, parama2.y);
      if ((i != 0) || (j != 0) || (f1 > 0.0F)) {}
      for (paramInt1 = paramReadInjoyCutImageView.getHeight();; paramInt1 = (int)(f3 * paramReadInjoyCutImageView.getHeight()))
      {
        localPoint3.y = paramInt1;
        localPoint3.x = 0;
        localPoint4.y = ((int)(paramReadInjoyCutImageView.getHeight() * f2));
        localPoint4.x = 0;
        break;
      }
      label2147:
      i = 1;
      j = n;
      m = paramInt1;
      k = paramInt2;
      continue;
      label2165:
      j = 1;
      i = i1;
      m = paramInt1;
      k = paramInt2;
    }
  }
  
  public void a(knm.a parama)
  {
    this.a = parama;
  }
  
  public void startAnim()
  {
    if ((this.animator != null) && (!this.animator.isStarted())) {
      this.animator.start();
    }
  }
  
  public void stopAnim()
  {
    if (this.animator != null) {
      this.animator.cancel();
    }
  }
  
  public static abstract interface a
  {
    public abstract void onAnimationEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     knm
 * JD-Core Version:    0.7.0.1
 */