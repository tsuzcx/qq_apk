import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;

public abstract class zhj
  implements View.OnAttachStateChangeListener, View.OnLayoutChangeListener
{
  protected float a;
  protected int a;
  protected View a;
  protected ViewGroup a;
  protected boolean a;
  protected float b;
  protected int b;
  protected View b;
  protected float c;
  protected float d;
  protected float e;
  protected float f;
  protected float g;
  protected float h;
  
  static
  {
    if (!zhj.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_b_of_type_Boolean = bool;
      return;
    }
  }
  
  public zhj(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(paramInt, null, false);
    this.jdField_a_of_type_AndroidViewView.addOnLayoutChangeListener(this);
    this.jdField_a_of_type_AndroidViewView.addOnAttachStateChangeListener(this);
    this.jdField_b_of_type_AndroidViewView = b();
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public final void a()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      b();
    } while (this.jdField_b_of_type_AndroidViewView == null);
    c();
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ykq.b("InteractPasterWidget", "setPositionInfo:[screenWidth=%s, screenHeight=%s, targetWidth=%s, targetHeight=%s, srcPollWidth=%s, srcPollHeight=%s, srcPollX=%s, srcPollY=%s, rotation=%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) });
    this.jdField_a_of_type_Boolean = true;
    this.c = 0.0F;
    this.d = 0.0F;
    if (paramInt2 * 1.0F / paramInt1 > paramInt4 * 1.0F / paramInt3)
    {
      this.jdField_a_of_type_Float = (paramInt3 * 1.0F / paramInt1);
      this.d = (-(paramInt2 * this.jdField_a_of_type_Float - paramInt4) / 2.0F);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt5;
      this.jdField_b_of_type_Int = paramInt6;
      this.e = paramFloat1;
      this.f = paramFloat2;
      this.jdField_b_of_type_Float = paramFloat3;
      return;
      this.jdField_a_of_type_Float = (paramInt4 * 1.0F / paramInt2);
      this.c = (-(paramInt1 * this.jdField_a_of_type_Float - paramInt3) / 2.0F);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    View localView;
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      localView = this.jdField_b_of_type_AndroidViewView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public abstract void a(String[] paramArrayOfString);
  
  protected View b()
  {
    return null;
  }
  
  protected void b()
  {
    int i = this.jdField_a_of_type_AndroidViewView.getWidth();
    int j = this.jdField_a_of_type_AndroidViewView.getHeight();
    this.g = (this.jdField_a_of_type_Float * this.jdField_a_of_type_Int / i);
    this.h = (this.jdField_a_of_type_Float * this.jdField_b_of_type_Int / j);
    if ((i == 0) || (j == 0)) {
      return;
    }
    float f1 = this.e * this.jdField_a_of_type_Float + this.c;
    float f2 = this.f * this.jdField_a_of_type_Float + this.d;
    this.jdField_a_of_type_AndroidViewView.setX(f1 - i * 1.0F / 2.0F);
    this.jdField_a_of_type_AndroidViewView.setY(f2 - j * 1.0F / 2.0F);
    this.jdField_a_of_type_AndroidViewView.setRotation(this.jdField_b_of_type_Float);
    this.jdField_a_of_type_AndroidViewView.setScaleX(this.g);
    this.jdField_a_of_type_AndroidViewView.setScaleY(this.h);
    ykq.b("InteractPasterWidget", "relayoutWidgetView view center (%.2f, %.2f) rotation(%.2f) scale(%.2f, %.2f) widgets(%d, %d)", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(this.jdField_b_of_type_Float), Float.valueOf(this.g), Float.valueOf(this.h), Integer.valueOf(i), Integer.valueOf(j) });
    ykq.a("InteractPasterWidget", "relayoutPollView offset(%.2f, %.2f)", Float.valueOf(this.c), Float.valueOf(this.d));
  }
  
  protected void c() {}
  
  public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (paramView == this.jdField_b_of_type_AndroidViewView)
    {
      ykq.b("InteractPasterWidget", "attendWidget onLayoutChange (%d, %d, %d, %d) -> (%d, %d, %d, %d)", new Object[] { Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      c();
      return;
    }
    ykq.b("InteractPasterWidget", "onLayoutChange (%d, %d, %d, %d) -> (%d, %d, %d, %d)", new Object[] { Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    a();
  }
  
  public void onViewAttachedToWindow(View paramView)
  {
    paramView = paramView.getParent();
    if ((!jdField_b_of_type_Boolean) && ((paramView == null) || (!(paramView instanceof ViewGroup)))) {
      throw new AssertionError();
    }
    paramView = (ViewGroup)paramView;
    if (paramView.getId() == 2131373028)
    {
      if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_b_of_type_AndroidViewView);
      }
      this.jdField_a_of_type_AndroidViewViewGroup = paramView;
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_b_of_type_AndroidViewView);
      this.jdField_b_of_type_AndroidViewView.addOnLayoutChangeListener(this);
    }
  }
  
  public void onViewDetachedFromWindow(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zhj
 * JD-Core Version:    0.7.0.1
 */