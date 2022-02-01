import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.animation.Animation;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class iqt
{
  private SparseArray<Object> U;
  protected boolean Ug;
  protected GLRootView a;
  protected iqk a;
  protected iqt.a a;
  protected iqt.b a;
  protected izp a;
  protected final Rect ag = new Rect(0, 0, 0, 0);
  protected iqk b;
  protected iqt b;
  protected WeakReference<Context> bv;
  protected RenderBuffer d;
  protected List<ira> fq = new ArrayList();
  protected float gQ;
  protected float gR;
  protected float gS;
  protected float gT;
  protected float gU = 1.0F;
  protected Animation mAnimation;
  protected int mBackgroundColor = -16777216;
  protected int mBackgroundResource;
  protected final Rect mBounds = new Rect(0, 0, 0, 0);
  protected int mLastHeightSpec = -1;
  protected int mLastWidthSpec = -1;
  protected final Rect mPaddings = new Rect(0, 0, 0, 0);
  protected float mScaleX = 1.0F;
  protected float mScaleY = 1.0F;
  protected int mScrollX;
  protected int mScrollY;
  protected int mViewFlags;
  protected int mZOrder;
  
  public iqt(Context paramContext)
  {
    this.jdField_a_of_type_Izp = new izp();
    this.bv = new WeakReference(paramContext);
  }
  
  public GLRootView a()
  {
    return this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView;
  }
  
  public izp a(ipm paramipm)
  {
    return null;
  }
  
  public void a(iql paramiql)
  {
    if (this.jdField_a_of_type_Iqk != null)
    {
      this.jdField_a_of_type_Iqk.recycle();
      this.jdField_a_of_type_Iqk = null;
    }
    if (paramiql != null)
    {
      this.jdField_a_of_type_Iqk = paramiql;
      this.mBackgroundResource = 0;
    }
  }
  
  public void a(iqt.a parama)
  {
    this.jdField_a_of_type_Iqt$a = parama;
  }
  
  protected void a(iqt.b paramb)
  {
    this.jdField_a_of_type_Iqt$b = paramb;
  }
  
  public void a(ira paramira)
  {
    List localList = this.fq;
    if (paramira != null) {}
    try
    {
      paramira.b(this);
      paramira.startAnimation();
      this.fq.add(paramira);
      invalidate();
      return;
    }
    finally {}
  }
  
  public List<ira> al()
  {
    return this.fq;
  }
  
  protected void apx() {}
  
  protected void apy() {}
  
  public void b(GLRootView paramGLRootView)
  {
    c(paramGLRootView);
  }
  
  protected void c(GLRootView paramGLRootView)
  {
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView = paramGLRootView;
  }
  
  public boolean canRender()
  {
    return (getVisibility() == 0) || (this.mAnimation != null);
  }
  
  public void cv(long paramLong)
  {
    label101:
    for (;;)
    {
      synchronized (this.fq)
      {
        if (this.fq.size() > 0)
        {
          invalidate();
          int i = 0;
          int j = this.fq.size();
          if (i < j) {
            try
            {
              boolean bool = ((ira)this.fq.get(i)).aw(paramLong);
              if (!bool) {
                break label101;
              }
              i -= 1;
              i += 1;
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
              break label101;
            }
          }
        }
        return;
      }
    }
  }
  
  public void d(ipm paramipm)
  {
    cv(System.currentTimeMillis());
    int i = this.mBounds.left;
    int j = this.mBounds.top;
    paramipm.save();
    ira localira = null;
    if (this.fq.size() > 0) {
      localira = (ira)this.fq.get(0);
    }
    if ((localira != null) && (localira.vj()))
    {
      paramipm.translate(localira.T(), localira.U(), localira.V());
      float f1 = this.mScaleX;
      f1 = this.mScaleY;
      f1 = this.gU;
      if ((localira != null) && (localira.isScale()))
      {
        f1 = localira.W();
        float f2 = localira.X();
        setBounds(i, j, (int)(f1 + i), (int)(f2 + j));
      }
      paramipm.translate(getWidth() / 2, getHeight() / 2, 0.0F);
      if ((localira == null) || (!localira.isRotate())) {
        break label268;
      }
      paramipm.rotate(localira.Y(), 1.0F, 0.0F, 0.0F);
      paramipm.rotate(localira.Z(), 0.0F, 1.0F, 0.0F);
      paramipm.rotate(localira.aa(), 0.0F, 0.0F, 1.0F);
    }
    for (;;)
    {
      f(paramipm);
      e(paramipm);
      paramipm.restore();
      return;
      paramipm.translate(i, j, this.gQ);
      break;
      label268:
      if (this.gR != 0.0F) {
        paramipm.rotate(this.gR, 1.0F, 0.0F, 0.0F);
      }
      if (this.gS != 0.0F) {
        paramipm.rotate(this.gS, 0.0F, 1.0F, 0.0F);
      }
      if (this.gT != 0.0F) {
        paramipm.rotate(this.gT, 0.0F, 0.0F, 1.0F);
      }
    }
  }
  
  public void detachFromRoot()
  {
    onDetachFromRoot();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((getVisibility() == 0) && (this.jdField_a_of_type_Iqt$a != null) && (this.jdField_a_of_type_Iqt$a.a(this, paramMotionEvent))) {
      return true;
    }
    return onTouchEvent(paramMotionEvent);
  }
  
  protected void e(ipm paramipm)
  {
    if (this.jdField_b_of_type_Iqk == null) {
      return;
    }
    int i = getWidth();
    int j = getHeight();
    Rect localRect = getPaddings();
    int k = localRect.left;
    int m = localRect.right;
    int n = localRect.top;
    int i1 = localRect.bottom;
    int i2 = localRect.left;
    int i3 = localRect.top;
    paramipm.save(2);
    this.jdField_b_of_type_Iqk.a(paramipm, i2, i3, i - k - m, j - n - i1);
    paramipm.restore();
  }
  
  protected void f(ipm paramipm)
  {
    if (this.jdField_a_of_type_Iqk != null)
    {
      i = getWidth();
      j = getHeight();
      this.jdField_a_of_type_Iqk.a(paramipm, 0, 0, i, j);
      return;
    }
    int i = getWidth();
    int j = getHeight();
    paramipm.fillRect(0.0F, 0.0F, i, j, this.mBackgroundColor);
  }
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      if (this.jdField_b_of_type_Iqk != null)
      {
        this.jdField_b_of_type_Iqk.recycle();
        this.jdField_b_of_type_Iqk = null;
      }
      if (this.jdField_a_of_type_Iqk != null)
      {
        this.jdField_a_of_type_Iqk.recycle();
        this.jdField_a_of_type_Iqk = null;
        this.mBackgroundResource = 0;
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public Rect getBounds()
  {
    return this.mBounds;
  }
  
  public int getHeight()
  {
    return this.mBounds.bottom - this.mBounds.top;
  }
  
  public Rect getPaddings()
  {
    return this.mPaddings;
  }
  
  public Object getTag(int paramInt)
  {
    if (this.U != null) {
      return this.U.get(paramInt);
    }
    return null;
  }
  
  public int getVisibility()
  {
    if ((this.mViewFlags & 0x1) == 0) {
      return 0;
    }
    return 1;
  }
  
  public int getWidth()
  {
    return this.mBounds.right - this.mBounds.left;
  }
  
  public int getZOrder()
  {
    return this.mZOrder;
  }
  
  public void iH(boolean paramBoolean)
  {
    this.Ug = paramBoolean;
  }
  
  public void invalidate()
  {
    GLRootView localGLRootView = a();
    if (localGLRootView != null) {
      localGLRootView.requestRender();
    }
  }
  
  @SuppressLint({"WrongCall"})
  public void layout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mViewFlags &= 0xFFFFFFFB;
    onLayout(bool, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onDetachFromRoot()
  {
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView = null;
  }
  
  public void onFirstDraw() {}
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  protected void onVisibilityChanged(int paramInt) {}
  
  public void post(Runnable paramRunnable)
  {
    GLRootView localGLRootView = a();
    if (localGLRootView != null) {
      localGLRootView.post(paramRunnable);
    }
  }
  
  public void postDelayed(Runnable paramRunnable, long paramLong)
  {
    GLRootView localGLRootView = a();
    if (localGLRootView != null) {
      localGLRootView.postDelayed(paramRunnable, paramLong);
    }
  }
  
  public void requestLayout()
  {
    this.mViewFlags |= 0x4;
    this.mLastHeightSpec = -1;
    this.mLastWidthSpec = -1;
    if (this.jdField_b_of_type_Iqt != null) {
      this.jdField_b_of_type_Iqt.requestLayout();
    }
    GLRootView localGLRootView;
    do
    {
      return;
      localGLRootView = a();
    } while (localGLRootView == null);
    localGLRootView.requestLayoutContentPane();
  }
  
  public void setBackground(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Iqk != null)
    {
      this.jdField_a_of_type_Iqk.recycle();
      this.jdField_a_of_type_Iqk = null;
    }
    if (paramBitmap != null)
    {
      this.jdField_a_of_type_Iqk = new iql(paramBitmap);
      this.mBackgroundResource = 0;
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.mBackgroundColor = paramInt;
  }
  
  public boolean setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt3 - paramInt1 != this.mBounds.right - this.mBounds.left) || (paramInt4 - paramInt2 != this.mBounds.bottom - this.mBounds.top)) {}
    for (boolean bool = true;; bool = false)
    {
      this.mBounds.set(paramInt1, paramInt2, paramInt3, paramInt4);
      return bool;
    }
  }
  
  public void setPaddings(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mPaddings.set(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setRotation(int paramInt) {}
  
  public void setTag(int paramInt, Object paramObject)
  {
    if (this.U == null) {
      this.U = new SparseArray();
    }
    this.U.put(paramInt, paramObject);
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt == getVisibility()) {
      return;
    }
    if (paramInt == 0) {}
    for (this.mViewFlags &= 0xFFFFFFFE;; this.mViewFlags |= 0x1)
    {
      onVisibilityChanged(paramInt);
      invalidate();
      return;
    }
  }
  
  public void setZOrder(int paramInt)
  {
    if (this.mZOrder != paramInt)
    {
      int i = this.mZOrder;
      this.mZOrder = paramInt;
      if (this.jdField_a_of_type_Iqt$b != null) {
        this.jdField_a_of_type_Iqt$b.a(this, paramInt, i);
      }
    }
  }
  
  public boolean vg()
  {
    return this.Ug;
  }
  
  public boolean vh()
  {
    return false;
  }
  
  public static abstract interface a
  {
    public abstract boolean a(iqt paramiqt, MotionEvent paramMotionEvent);
  }
  
  public static abstract interface b
  {
    public abstract void a(iqt paramiqt, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iqt
 * JD-Core Version:    0.7.0.1
 */