import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class adzv
  extends Animation
{
  public static final boolean NEEDS_PROXY;
  static final WeakHashMap<View, adzv> PROXIES;
  final RectF mAfter = new RectF();
  float mAlpha = 1.0F;
  final RectF mBefore = new RectF();
  final Camera mCamera = new Camera();
  boolean mHasPivot;
  float mPivotX;
  float mPivotY;
  float mRotationX;
  float mRotationY;
  float mRotationZ;
  float mScaleX = 1.0F;
  float mScaleY = 1.0F;
  final Matrix mTempMatrix = new Matrix();
  float mTranslationX;
  float mTranslationY;
  final WeakReference<View> mView;
  
  static
  {
    if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 11) {}
    for (boolean bool = true;; bool = false)
    {
      NEEDS_PROXY = bool;
      PROXIES = new WeakHashMap();
      return;
    }
  }
  
  private adzv(View paramView)
  {
    setDuration(0L);
    setFillAfter(true);
    paramView.setAnimation(this);
    this.mView = new WeakReference(paramView);
  }
  
  public static adzv a(View paramView)
  {
    adzv localadzv2 = (adzv)PROXIES.get(paramView);
    adzv localadzv1;
    if (localadzv2 != null)
    {
      localadzv1 = localadzv2;
      if (localadzv2 == paramView.getAnimation()) {}
    }
    else
    {
      localadzv1 = new adzv(paramView);
      PROXIES.put(paramView, localadzv1);
    }
    return localadzv1;
  }
  
  private void invalidateAfterUpdate()
  {
    View localView = (View)this.mView.get();
    if ((localView == null) || (localView.getParent() == null)) {
      return;
    }
    RectF localRectF = this.mAfter;
    computeRect(localRectF, localView);
    localRectF.union(this.mBefore);
    ((View)localView.getParent()).invalidate((int)Math.floor(localRectF.left), (int)Math.floor(localRectF.top), (int)Math.ceil(localRectF.right), (int)Math.ceil(localRectF.bottom));
  }
  
  private void prepareForUpdate()
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      computeRect(this.mBefore, localView);
    }
  }
  
  private void transformMatrix(Matrix paramMatrix, View paramView)
  {
    float f3 = paramView.getWidth();
    float f4 = paramView.getHeight();
    boolean bool = this.mHasPivot;
    float f1;
    if (bool)
    {
      f1 = this.mPivotX;
      if (!bool) {
        break label226;
      }
    }
    label226:
    for (float f2 = this.mPivotY;; f2 = f4 / 2.0F)
    {
      float f5 = this.mRotationX;
      float f6 = this.mRotationY;
      float f7 = this.mRotationZ;
      if ((f5 != 0.0F) || (f6 != 0.0F) || (f7 != 0.0F))
      {
        paramView = this.mCamera;
        paramView.save();
        paramView.rotateX(f5);
        paramView.rotateY(f6);
        paramView.rotateZ(-f7);
        paramView.getMatrix(paramMatrix);
        paramView.restore();
        paramMatrix.preTranslate(-f1, -f2);
        paramMatrix.postTranslate(f1, f2);
      }
      f5 = this.mScaleX;
      f6 = this.mScaleY;
      if ((f5 != 1.0F) || (f6 != 1.0F))
      {
        paramMatrix.postScale(f5, f6);
        paramMatrix.postTranslate(-(f1 / f3) * (f5 * f3 - f3), -(f2 / f4) * (f6 * f4 - f4));
      }
      paramMatrix.postTranslate(this.mTranslationX, this.mTranslationY);
      return;
      f1 = f3 / 2.0F;
      break;
    }
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    View localView = (View)this.mView.get();
    if (localView != null)
    {
      paramTransformation.setAlpha(this.mAlpha);
      transformMatrix(paramTransformation.getMatrix(), localView);
    }
  }
  
  public void computeRect(RectF paramRectF, View paramView)
  {
    paramRectF.set(0.0F, 0.0F, paramView.getWidth(), paramView.getHeight());
    Matrix localMatrix = this.mTempMatrix;
    localMatrix.reset();
    transformMatrix(localMatrix, paramView);
    this.mTempMatrix.mapRect(paramRectF);
    paramRectF.offset(paramView.getLeft(), paramView.getTop());
    float f;
    if (paramRectF.right < paramRectF.left)
    {
      f = paramRectF.right;
      paramRectF.right = paramRectF.left;
      paramRectF.left = f;
    }
    if (paramRectF.bottom < paramRectF.top)
    {
      f = paramRectF.top;
      paramRectF.top = paramRectF.bottom;
      paramRectF.bottom = f;
    }
  }
  
  public void setAlpha(float paramFloat)
  {
    if (this.mAlpha != paramFloat)
    {
      this.mAlpha = paramFloat;
      View localView = (View)this.mView.get();
      if (localView != null) {
        localView.invalidate();
      }
    }
  }
  
  public void setPivotX(float paramFloat)
  {
    if ((!this.mHasPivot) || (this.mPivotX != paramFloat))
    {
      prepareForUpdate();
      this.mHasPivot = true;
      this.mPivotX = paramFloat;
      invalidateAfterUpdate();
    }
  }
  
  public void setPivotY(float paramFloat)
  {
    if ((!this.mHasPivot) || (this.mPivotY != paramFloat))
    {
      prepareForUpdate();
      this.mHasPivot = true;
      this.mPivotY = paramFloat;
      invalidateAfterUpdate();
    }
  }
  
  public void setScaleX(float paramFloat)
  {
    if (this.mScaleX != paramFloat)
    {
      prepareForUpdate();
      this.mScaleX = paramFloat;
      invalidateAfterUpdate();
    }
  }
  
  public void setScaleY(float paramFloat)
  {
    if (this.mScaleY != paramFloat)
    {
      prepareForUpdate();
      this.mScaleY = paramFloat;
      invalidateAfterUpdate();
    }
  }
  
  public void setTranslationX(float paramFloat)
  {
    if (this.mTranslationX != paramFloat)
    {
      prepareForUpdate();
      this.mTranslationX = paramFloat;
      invalidateAfterUpdate();
    }
  }
  
  public void setTranslationY(float paramFloat)
  {
    if (this.mTranslationY != paramFloat)
    {
      prepareForUpdate();
      this.mTranslationY = paramFloat;
      invalidateAfterUpdate();
    }
  }
  
  public void setX(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      setTranslationX(paramFloat - localView.getLeft());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adzv
 * JD-Core Version:    0.7.0.1
 */