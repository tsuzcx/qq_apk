import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.FastOutSlowInInterpolator;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat;

public class trh
  extends LinearLayout
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = -1;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint;
  private int b;
  private int c = -1;
  private int d = -1;
  private int e = -1;
  private int f;
  private int g;
  private int h;
  
  public trh(TabLayoutCompat paramTabLayoutCompat, Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  }
  
  private void a()
  {
    View localView = getChildAt(this.jdField_a_of_type_Int);
    int i;
    int j;
    if ((localView != null) && (localView.getWidth() > 0))
    {
      int m = localView.getLeft();
      int k = localView.getRight();
      i = k;
      j = m;
      if (this.jdField_a_of_type_Float > 0.0F)
      {
        i = k;
        j = m;
        if (this.jdField_a_of_type_Int < getChildCount() - 1)
        {
          localView = getChildAt(this.jdField_a_of_type_Int + 1);
          float f1 = this.jdField_a_of_type_Float;
          float f2 = localView.getLeft();
          float f3 = this.jdField_a_of_type_Float;
          j = (int)(m * (1.0F - f3) + f1 * f2);
          f1 = this.jdField_a_of_type_Float;
          f2 = localView.getRight();
          f3 = this.jdField_a_of_type_Float;
          i = (int)(k * (1.0F - f3) + f2 * f1);
        }
      }
    }
    for (;;)
    {
      a(j, i);
      return;
      i = -1;
      j = -1;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPaint.getColor() != paramInt)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public void a(int paramInt, float paramFloat)
  {
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Float = paramFloat;
    a();
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.d) || (paramInt2 != this.e))
    {
      this.d = paramInt1;
      this.e = paramInt2;
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    int j = getChildCount();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (getChildAt(i).getWidth() <= 0) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public void b(int paramInt)
  {
    if (this.b != paramInt)
    {
      this.b = paramInt;
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    int i;
    Object localObject;
    if (ViewCompat.getLayoutDirection(this) == 1)
    {
      i = 1;
      localObject = getChildAt(paramInt1);
      if (localObject != null) {
        break label56;
      }
      a();
    }
    for (;;)
    {
      return;
      i = 0;
      break;
      label56:
      int k = ((View)localObject).getLeft();
      int m = ((View)localObject).getRight();
      int j;
      if (Math.abs(paramInt1 - this.jdField_a_of_type_Int) <= 1)
      {
        i = this.d;
        j = this.e;
      }
      while ((i != k) || (j != m))
      {
        localObject = new ValueAnimator();
        this.jdField_a_of_type_AndroidAnimationValueAnimator = ((ValueAnimator)localObject);
        ((ValueAnimator)localObject).setInterpolator(new FastOutSlowInInterpolator());
        ((ValueAnimator)localObject).setDuration(paramInt2);
        ((ValueAnimator)localObject).setFloatValues(new float[] { 0.0F, 1.0F });
        ((ValueAnimator)localObject).addUpdateListener(new tri(this, i, k, j, m));
        ((ValueAnimator)localObject).addListener(new trj(this, paramInt1));
        ((ValueAnimator)localObject).start();
        return;
        j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.a(24);
        if (paramInt1 < this.jdField_a_of_type_Int)
        {
          if (i != 0)
          {
            j = k - j;
            i = j;
          }
          else
          {
            j = m + j;
            i = j;
          }
        }
        else if (i != 0)
        {
          j = m + j;
          i = j;
        }
        else
        {
          j = k - j;
          i = j;
        }
      }
    }
  }
  
  public void c(int paramInt)
  {
    if (this.f != paramInt)
    {
      this.f = paramInt;
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public void d(int paramInt)
  {
    if (this.g != paramInt)
    {
      this.g = paramInt;
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if ((this.d >= 0) && (this.e > this.d)) {
      paramCanvas.drawRect(this.d + this.f, getHeight() - this.b - this.h, this.e - this.g, getHeight() - this.h, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public void e(int paramInt)
  {
    if (this.h != paramInt)
    {
      this.h = paramInt;
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()))
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      long l = this.jdField_a_of_type_AndroidAnimationValueAnimator.getDuration();
      paramInt1 = this.jdField_a_of_type_Int;
      float f1 = this.jdField_a_of_type_AndroidAnimationValueAnimator.getAnimatedFraction();
      b(paramInt1, Math.round((float)l * (1.0F - f1)));
      return;
    }
    a();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = 0;
    super.onMeasure(paramInt1, paramInt2);
    if (View.MeasureSpec.getMode(paramInt1) != 1073741824) {
      break label18;
    }
    label18:
    while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.i != 1) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.h != 1)) {
      return;
    }
    int n = getChildCount();
    int k = 0;
    int j = 0;
    label53:
    Object localObject;
    if (k < n)
    {
      localObject = getChildAt(k);
      if (((View)localObject).getVisibility() != 0) {
        break label238;
      }
    }
    label136:
    label223:
    label235:
    label238:
    for (int i = Math.max(j, ((View)localObject).getMeasuredWidth());; i = j)
    {
      k += 1;
      j = i;
      break label53;
      if (j <= 0) {
        break;
      }
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.a(16);
      if (j * n <= getMeasuredWidth() - i * 2)
      {
        k = 0;
        i = m;
        m = i;
        if (k >= n) {
          break label223;
        }
        localObject = (LinearLayout.LayoutParams)getChildAt(k).getLayoutParams();
        if ((((LinearLayout.LayoutParams)localObject).width == j) && (((LinearLayout.LayoutParams)localObject).weight == 0.0F)) {
          break label235;
        }
        ((LinearLayout.LayoutParams)localObject).width = j;
        ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
        i = 1;
      }
      for (;;)
      {
        k += 1;
        break label136;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.h = 0;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.a(false);
        m = 1;
        if (m == 0) {
          break;
        }
        super.onMeasure(paramInt1, paramInt2);
        return;
      }
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    super.onRtlPropertiesChanged(paramInt);
    if ((Build.VERSION.SDK_INT < 23) && (this.c != paramInt))
    {
      requestLayout();
      this.c = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trh
 * JD-Core Version:    0.7.0.1
 */