import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.MotionEvent;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class iqu
  extends iqt
{
  protected boolean Uh;
  private iqt.b a;
  protected TextureRender b;
  protected TextureRender c;
  private iqt c;
  private ArrayList<iqt> mChildren;
  private Comparator<iqt> mSortComparator = new iqu.a();
  
  public iqu(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Iqt$b = new iqv(this);
  }
  
  public iqt a(int paramInt)
  {
    if ((this.mChildren == null) || (paramInt < 0) || (paramInt >= this.mChildren.size())) {
      throw new ArrayIndexOutOfBoundsException(paramInt);
    }
    return (iqt)this.mChildren.get(paramInt);
  }
  
  public void a(ipm paramipm, iqt paramiqt)
  {
    if (!paramiqt.canRender()) {
      return;
    }
    int i = -this.mScrollX;
    int j = -this.mScrollY;
    paramipm.translate(i, j);
    paramiqt.d(paramipm);
    paramipm.translate(-i, -j);
  }
  
  public void a(iqt paramiqt)
  {
    if (paramiqt.b != null) {
      throw new IllegalStateException();
    }
    if (this.mChildren == null) {
      this.mChildren = new ArrayList();
    }
    this.mChildren.add(paramiqt);
    paramiqt.b = this;
    paramiqt.a(this.jdField_a_of_type_Iqt$b);
    Collections.sort(this.mChildren, this.mSortComparator);
    if (this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView != null) {
      paramiqt.c(this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView);
    }
  }
  
  protected boolean a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2, iqt paramiqt, boolean paramBoolean)
  {
    Rect localRect = paramiqt.mBounds;
    if ((!paramBoolean) || (localRect.contains(paramInt1, paramInt2)))
    {
      if (paramiqt.dispatchTouchEvent(paramMotionEvent)) {}
      while ((this.jdField_a_of_type_Iqt$a != null) && (this.jdField_a_of_type_Iqt$a.a(paramiqt, paramMotionEvent))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(iqt paramiqt)
  {
    if (this.mChildren == null) {}
    while (!this.mChildren.remove(paramiqt)) {
      return false;
    }
    if (this.c == paramiqt)
    {
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
      dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
    }
    paramiqt.onDetachFromRoot();
    paramiqt.b = null;
    paramiqt.a(null);
    Collections.sort(this.mChildren, this.mSortComparator);
    return true;
  }
  
  public void apA()
  {
    apx();
    int i = 0;
    int j = getChildCount();
    while (i < j)
    {
      a(i).apx();
      i += 1;
    }
  }
  
  public void apB()
  {
    apy();
    int i = 0;
    int j = getChildCount();
    while (i < j)
    {
      a(i).apy();
      i += 1;
    }
  }
  
  public void apz()
  {
    if (this.mChildren != null) {
      Collections.sort(this.mChildren, this.mSortComparator);
    }
  }
  
  protected void c(GLRootView paramGLRootView)
  {
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView = paramGLRootView;
    int i = 0;
    int j = getChildCount();
    while (i < j)
    {
      a(i).c(paramGLRootView);
      i += 1;
    }
  }
  
  public void d(ipm paramipm)
  {
    paramipm.translate(getWidth() / 2, getHeight() / 2, 0.0F);
    f(paramipm);
    paramipm.translate(-getWidth() / 2, -getHeight() / 2, 0.0F);
    h(paramipm);
  }
  
  protected boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    int i = paramMotionEvent.getAction();
    Object localObject;
    if (this.c != null)
    {
      if (i == 0)
      {
        localObject = MotionEvent.obtain(paramMotionEvent);
        ((MotionEvent)localObject).setAction(3);
        a((MotionEvent)localObject, j, k, this.c, false);
        this.c = null;
      }
    }
    else
    {
      if (i != 0) {
        break label151;
      }
      i = getChildCount() - 1;
      if (i < 0) {
        break label151;
      }
      localObject = a(i);
      if (((iqt)localObject).getVisibility() == 0) {
        break label129;
      }
    }
    label129:
    while (!a(paramMotionEvent, j, k, (iqt)localObject, true))
    {
      i -= 1;
      break;
      a(paramMotionEvent, j, k, this.c, false);
      if ((i == 3) || (i == 1)) {
        this.c = null;
      }
      return true;
    }
    this.c = ((iqt)localObject);
    return true;
    label151:
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void g(ipm paramipm) {}
  
  public int getChildCount()
  {
    if (this.mChildren == null) {
      return 0;
    }
    return this.mChildren.size();
  }
  
  protected void h(ipm paramipm)
  {
    if ((this.Uh) || (vi())) {
      g(paramipm);
    }
    for (;;)
    {
      return;
      int i = 0;
      int j = getChildCount();
      while (i < j)
      {
        a(paramipm, a(i));
        i += 1;
      }
    }
  }
  
  protected void iI(boolean paramBoolean)
  {
    this.Uh = paramBoolean;
  }
  
  protected void onDetachFromRoot()
  {
    int i = 0;
    int j = getChildCount();
    while (i < j)
    {
      a(i).onDetachFromRoot();
      i += 1;
    }
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView = null;
  }
  
  protected void onFirstDraw()
  {
    int i = 0;
    int j = getChildCount();
    while (i < j)
    {
      a(i).onFirstDraw();
      i += 1;
    }
  }
  
  protected void onVisibilityChanged(int paramInt)
  {
    int i = 0;
    int j = getChildCount();
    while (i < j)
    {
      iqt localiqt = a(i);
      if (localiqt.getVisibility() == 0) {
        localiqt.onVisibilityChanged(paramInt);
      }
      i += 1;
    }
  }
  
  public void removeAllView()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      iqt localiqt = (iqt)this.mChildren.get(i);
      if (this.c == localiqt)
      {
        long l = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        dispatchTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
      }
      localiqt.onDetachFromRoot();
      localiqt.b = null;
      localiqt.a(null);
      i += 1;
    }
    this.mChildren.clear();
  }
  
  protected boolean vi()
  {
    return false;
  }
  
  class a
    implements Comparator<iqt>
  {
    a() {}
    
    public int a(iqt paramiqt1, iqt paramiqt2)
    {
      if (paramiqt1.getZOrder() >= paramiqt2.getZOrder()) {
        return 1;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iqu
 * JD-Core Version:    0.7.0.1
 */