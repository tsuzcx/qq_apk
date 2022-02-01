import android.animation.ValueAnimator;
import android.graphics.Point;
import android.view.animation.AccelerateInterpolator;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInjoyCutImageView;
import java.util.ArrayList;

public class txb
{
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F });
  private txe jdField_a_of_type_Txe;
  
  public txe a()
  {
    return this.jdField_a_of_type_Txe;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
  
  public void a(ReadInjoyCutImageView paramReadInjoyCutImageView, tzx paramtzx1, tzx paramtzx2, int paramInt1, int paramInt2, long paramLong)
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
    if (paramtzx1.a == paramtzx2.a)
    {
      paramtzx1.b = Math.abs(paramtzx1.b);
      paramtzx2.b = Math.abs(paramtzx2.b);
      if (paramtzx1.b > paramtzx2.b) {
        paramtzx1.a(paramtzx2);
      }
      localArrayList1.add(new tzx(0.0F, 0.0F));
      localArrayList1.add(paramtzx1);
      localArrayList1.add(paramtzx2);
      localArrayList1.add(new tzx(0.0F, 1.0F));
      localArrayList1.add(new tzx(0.0F, 0.0F));
      localArrayList2.add(paramtzx1);
      localArrayList2.add(new tzx(1.0F, 0.0F));
      localArrayList2.add(new tzx(1.0F, 1.0F));
      localArrayList2.add(paramtzx2);
      localArrayList2.add(paramtzx1);
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
        paramReadInjoyCutImageView.a();
        paramReadInjoyCutImageView.setClipArea(localArrayList1, localArrayList2);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(paramLong);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new AccelerateInterpolator());
        f1 = localPoint2.x - localPoint1.x;
        f2 = localPoint2.y - localPoint1.y;
        f3 = localPoint4.x - localPoint3.x;
        float f4 = localPoint4.y - localPoint3.y;
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new txc(this, f1, f2, f3, f4, paramReadInjoyCutImageView));
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new txd(this, paramReadInjoyCutImageView));
        return;
        if (paramtzx1.b == paramtzx2.b)
        {
          paramtzx1.b = Math.abs(paramtzx1.b);
          paramtzx2.b = Math.abs(paramtzx2.b);
          if (paramtzx1.a > paramtzx2.a) {
            paramtzx1.a(paramtzx2);
          }
          localArrayList1.add(new tzx(0.0F, 0.0F));
          localArrayList1.add(new tzx(1.0F, 0.0F));
          localArrayList1.add(paramtzx2);
          localArrayList1.add(paramtzx1);
          localArrayList1.add(new tzx(0.0F, 0.0F));
          localArrayList2.add(paramtzx1);
          localArrayList2.add(paramtzx2);
          localArrayList2.add(new tzx(1.0F, 1.0F));
          localArrayList2.add(new tzx(0.0F, 1.0F));
          localArrayList2.add(paramtzx1);
          if ((paramInt1 != 5) || (paramInt2 != 5)) {
            break label2147;
          }
          m = 3;
          k = 4;
          i = 1;
          j = n;
          break;
        }
        f2 = (paramtzx2.b - paramtzx1.b) / (paramtzx2.a - paramtzx1.a);
        f3 = (paramtzx2.b + paramtzx1.b - (paramtzx2.a + paramtzx1.a) * f2) / 2.0F;
        paramtzx1.b = Math.abs(paramtzx1.b);
        paramtzx2.b = Math.abs(paramtzx2.b);
        if (f2 > 0.0F)
        {
          if (paramtzx1.a < paramtzx2.a) {
            paramtzx1.a(paramtzx2);
          }
          localArrayList1.add(new tzx(0.0F, 0.0F));
          localArrayList2.add(new tzx(paramtzx1));
          localtzx = new tzx(1.0F, 0.0F);
          if (localtzx.b > localtzx.a * f2 + f3)
          {
            localArrayList1.add(localtzx);
            label795:
            localArrayList1.add(paramtzx1);
            localArrayList2.add(new tzx(1.0F, 1.0F));
            localArrayList1.add(paramtzx2);
            localtzx = new tzx(0.0F, 1.0F);
            if (-localtzx.b <= localtzx.a * f2 + f3) {
              break label1133;
            }
            localArrayList1.add(localtzx);
          }
          for (;;)
          {
            localArrayList2.add(paramtzx2);
            localArrayList1.add(new tzx((tzx)localArrayList1.get(0)));
            localArrayList2.add(new tzx((tzx)localArrayList2.get(0)));
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
            localArrayList2.add(localtzx);
            break label795;
            label1133:
            localArrayList2.add(localtzx);
          }
        }
        if (paramtzx1.a > paramtzx2.a) {
          paramtzx1.a(paramtzx2);
        }
        localArrayList2.add(paramtzx1);
        tzx localtzx = new tzx(0.0F, 0.0F);
        if (localtzx.b < localtzx.a * f2 + f3)
        {
          localArrayList1.add(localtzx);
          label1207:
          localArrayList1.add(paramtzx1);
          localArrayList1.add(paramtzx2);
          localArrayList2.add(new tzx(1.0F, 0.0F));
          localtzx = new tzx(1.0F, 1.0F);
          if (-localtzx.b >= localtzx.a * f2 + f3) {
            break label1560;
          }
          localArrayList1.add(localtzx);
        }
        for (;;)
        {
          localArrayList1.add(new tzx(0.0F, 1.0F));
          localArrayList2.add(paramtzx2);
          localArrayList1.add(new tzx((tzx)localArrayList1.get(0)));
          localArrayList2.add(new tzx((tzx)localArrayList2.get(0)));
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
          localArrayList2.add(localtzx);
          break label1207;
          label1560:
          localArrayList2.add(localtzx);
        }
        localPoint1.x = ((int)(Math.max(paramtzx1.a, paramtzx2.a) * paramReadInjoyCutImageView.getWidth()));
        localPoint1.y = 0;
        localPoint2.x = 0;
        localPoint2.y = 0;
        break label280;
        f2 = Math.max(paramtzx1.a, paramtzx2.a);
        localPoint1.x = 0;
        localPoint1.y = 0;
        localPoint2.x = ((int)(f2 * paramReadInjoyCutImageView.getWidth()));
        localPoint2.y = 0;
        break label280;
        f2 = Math.min(paramtzx1.b, paramtzx2.b);
        f3 = Math.max(paramtzx1.b, paramtzx2.b);
        if ((i != 0) || (j != 0) || (f1 > 0.0F)) {}
        for (paramInt1 = 0;; paramInt1 = (int)(f2 * paramReadInjoyCutImageView.getHeight()))
        {
          localPoint1.y = paramInt1;
          localPoint1.x = 0;
          localPoint2.y = ((int)(paramReadInjoyCutImageView.getHeight() * f3));
          localPoint2.x = 0;
          break;
        }
        f2 = Math.min(paramtzx1.b, paramtzx2.b);
        localPoint1.y = ((int)(Math.max(paramtzx1.b, paramtzx2.b) * paramReadInjoyCutImageView.getHeight()));
        localPoint1.x = 0;
        if ((i != 0) || (j != 0) || (f1 > 0.0F)) {}
        for (paramInt1 = 0;; paramInt1 = (int)(f2 * paramReadInjoyCutImageView.getHeight()))
        {
          localPoint2.y = paramInt1;
          localPoint2.x = 0;
          break;
        }
        f1 = Math.min(paramtzx1.a, paramtzx2.a);
        localPoint3.x = paramReadInjoyCutImageView.getWidth();
        localPoint3.y = 0;
        localPoint4.x = ((int)(f1 * paramReadInjoyCutImageView.getWidth()));
        localPoint4.y = 0;
        continue;
        localPoint3.x = ((int)(Math.min(paramtzx1.a, paramtzx2.a) * paramReadInjoyCutImageView.getWidth()));
        localPoint3.y = 0;
        localPoint4.x = paramReadInjoyCutImageView.getWidth();
        localPoint4.y = 0;
      }
      float f2 = Math.min(paramtzx1.b, paramtzx2.b);
      float f3 = Math.max(paramtzx1.b, paramtzx2.b);
      localPoint3.y = ((int)(f2 * paramReadInjoyCutImageView.getHeight()));
      localPoint3.x = 0;
      if ((i != 0) || (j != 0) || (f1 > 0.0F)) {}
      for (paramInt1 = paramReadInjoyCutImageView.getHeight();; paramInt1 = (int)(paramReadInjoyCutImageView.getHeight() * f3))
      {
        localPoint4.y = paramInt1;
        localPoint4.x = 0;
        break;
      }
      f2 = Math.min(paramtzx1.b, paramtzx2.b);
      f3 = Math.max(paramtzx1.b, paramtzx2.b);
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
  
  public void a(txe paramtxe)
  {
    this.jdField_a_of_type_Txe = paramtxe;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (!this.jdField_a_of_type_AndroidAnimationValueAnimator.isStarted())) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     txb
 * JD-Core Version:    0.7.0.1
 */