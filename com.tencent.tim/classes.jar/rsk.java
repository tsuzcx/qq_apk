import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;

public abstract class rsk
  implements View.OnAttachStateChangeListener, View.OnLayoutChangeListener
{
  protected boolean aJB;
  protected int buQ;
  protected int buR;
  protected float mOffsetX;
  protected float mOffsetY;
  protected ViewGroup mParentView;
  protected float mRotation;
  protected float mScale;
  protected float nM;
  protected float nN;
  protected float nV;
  protected float nW;
  protected View pi;
  protected View pj;
  
  static
  {
    if (!rsk.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public rsk(Context paramContext, int paramInt)
  {
    this.pi = LayoutInflater.from(paramContext).inflate(paramInt, null, false);
    this.pi.addOnLayoutChangeListener(this);
    this.pi.addOnAttachStateChangeListener(this);
    this.pj = aA();
    this.pj.setVisibility(8);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ram.d("InteractPasterWidget", "setPositionInfo:[screenWidth=%s, screenHeight=%s, targetWidth=%s, targetHeight=%s, srcPollWidth=%s, srcPollHeight=%s, srcPollX=%s, srcPollY=%s, rotation=%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) });
    this.aJB = true;
    this.mOffsetX = 0.0F;
    this.mOffsetY = 0.0F;
    if (paramInt2 * 1.0F / paramInt1 > paramInt4 * 1.0F / paramInt3)
    {
      this.mScale = (paramInt3 * 1.0F / paramInt1);
      this.mOffsetY = (-(paramInt2 * this.mScale - paramInt4) / 2.0F);
    }
    for (;;)
    {
      this.buQ = paramInt5;
      this.buR = paramInt6;
      this.nV = paramFloat1;
      this.nW = paramFloat2;
      this.mRotation = paramFloat3;
      return;
      this.mScale = (paramInt4 * 1.0F / paramInt2);
      this.mOffsetX = (-(paramInt1 * this.mScale - paramInt3) / 2.0F);
    }
  }
  
  public Rect[] a()
  {
    return null;
  }
  
  protected View aA()
  {
    return null;
  }
  
  public Bitmap aa()
  {
    Bitmap localBitmap = Bitmap.createBitmap(this.pi.getWidth(), this.pi.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    this.pi.draw(localCanvas);
    return localBitmap;
  }
  
  public final void acf()
  {
    if (!this.aJB) {}
    do
    {
      return;
      bwf();
    } while (this.pj == null);
    bwg();
  }
  
  public View az()
  {
    return this.pi;
  }
  
  protected void bwf()
  {
    int i = this.pi.getWidth();
    int j = this.pi.getHeight();
    this.nM = (this.mScale * this.buQ / i);
    this.nN = (this.mScale * this.buR / j);
    if ((i == 0) || (j == 0)) {
      return;
    }
    float f1 = this.nV * this.mScale + this.mOffsetX;
    float f2 = this.nW * this.mScale + this.mOffsetY;
    this.pi.setX(f1 - i * 1.0F / 2.0F);
    this.pi.setY(f2 - j * 1.0F / 2.0F);
    this.pi.setRotation(this.mRotation);
    this.pi.setScaleX(this.nM);
    this.pi.setScaleY(this.nN);
    ram.d("InteractPasterWidget", "relayoutWidgetView view center (%.2f, %.2f) rotation(%.2f) scale(%.2f, %.2f) widgets(%d, %d)", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(this.mRotation), Float.valueOf(this.nM), Float.valueOf(this.nN), Integer.valueOf(i), Integer.valueOf(j) });
    ram.b("InteractPasterWidget", "relayoutPollView offset(%.2f, %.2f)", Float.valueOf(this.mOffsetX), Float.valueOf(this.mOffsetY));
  }
  
  protected void bwg() {}
  
  public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (paramView == this.pj)
    {
      ram.d("InteractPasterWidget", "attendWidget onLayoutChange (%d, %d, %d, %d) -> (%d, %d, %d, %d)", new Object[] { Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      bwg();
      return;
    }
    ram.d("InteractPasterWidget", "onLayoutChange (%d, %d, %d, %d) -> (%d, %d, %d, %d)", new Object[] { Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    acf();
  }
  
  public void onViewAttachedToWindow(View paramView)
  {
    paramView = paramView.getParent();
    assert ((paramView != null) && ((paramView instanceof ViewGroup)));
    paramView = (ViewGroup)paramView;
    if (paramView.getId() == 2131373483)
    {
      if (this.mParentView != null) {
        this.mParentView.removeView(this.pj);
      }
      this.mParentView = paramView;
      this.mParentView.addView(this.pj);
      this.pj.addOnLayoutChangeListener(this);
    }
  }
  
  public void onViewDetachedFromWindow(View paramView) {}
  
  public abstract void t(String[] paramArrayOfString);
  
  public void ug(boolean paramBoolean)
  {
    View localView;
    if (this.pj != null)
    {
      localView = this.pj;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rsk
 * JD-Core Version:    0.7.0.1
 */