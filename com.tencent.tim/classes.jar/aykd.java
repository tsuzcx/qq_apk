import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.view.MotionEvent;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import org.json.JSONObject;

public abstract class aykd
  implements aykg
{
  private static String cWP = "BaseLayer";
  protected aykd.a a;
  protected Paint aI;
  protected DoodleView b;
  protected Paint ba;
  protected int brc;
  protected int brd;
  public Context context;
  public Rect drawRect;
  protected int eKq;
  protected boolean isActive;
  protected int limitLeft;
  protected int limitRight;
  protected float scaleValue;
  
  public aykd(DoodleView paramDoodleView)
  {
    if (paramDoodleView == null) {
      throw new IllegalStateException("DoodleView can not be null.");
    }
    this.context = paramDoodleView.getContext();
    this.b = paramDoodleView;
    init();
  }
  
  private void init()
  {
    this.drawRect = new Rect();
    this.ba = new Paint();
    this.ba.setAntiAlias(true);
    this.aI = new Paint();
    this.aI.setAntiAlias(true);
    this.aI.setStyle(Paint.Style.STROKE);
    this.aI.setStrokeWidth(5.0F);
    this.aI.setColor(-16776961);
    this.isActive = false;
  }
  
  public boolean E(JSONObject paramJSONObject)
  {
    return false;
  }
  
  public Bundle G()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("BaseLayer:TopLevelWeight", this.eKq);
    return localBundle;
  }
  
  protected abstract boolean H(MotionEvent paramMotionEvent);
  
  public final boolean M(MotionEvent paramMotionEvent)
  {
    if (this.a != null) {
      this.a.a(this, paramMotionEvent);
    }
    notifyChange();
    return H(paramMotionEvent);
  }
  
  public int RV()
  {
    return this.eKq;
  }
  
  public void a(Canvas paramCanvas, float paramFloat, boolean paramBoolean)
  {
    b(paramCanvas, paramFloat);
  }
  
  public void a(aykd.a parama)
  {
    this.a = parama;
  }
  
  public abstract boolean aN(long paramLong);
  
  public void ae(float paramFloat)
  {
    this.scaleValue = paramFloat;
  }
  
  public void afk(int paramInt) {}
  
  public void afl(int paramInt)
  {
    this.eKq = (paramInt + 1);
  }
  
  protected abstract void an(Canvas paramCanvas);
  
  public void b(Canvas paramCanvas, float paramFloat)
  {
    ao(paramCanvas);
  }
  
  public float cg()
  {
    return this.scaleValue;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    an(paramCanvas);
  }
  
  public void eC(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    this.eKq = paramBundle.getInt("BaseLayer:TopLevelWeight");
  }
  
  public void eSo()
  {
    this.b.setTopLevelLayer(this);
  }
  
  public int getHeight()
  {
    return this.drawRect.height();
  }
  
  public abstract String getTag();
  
  public int getWidth()
  {
    return this.drawRect.width();
  }
  
  public boolean isActive()
  {
    return this.isActive;
  }
  
  public void notifyChange()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.b.invalidate();
      return;
    }
    this.b.postInvalidate();
  }
  
  public void onDestroy()
  {
    ram.d("BaseLayer", getClass().getName() + " onDestroy.");
  }
  
  public void onPause()
  {
    ram.d("BaseLayer", getClass().getName() + " onPause.");
    this.isActive = false;
  }
  
  public void onResume()
  {
    ram.d("BaseLayer", getClass().getName() + " onResume.");
    this.isActive = true;
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      throw new IllegalArgumentException("illegal width or height, width=" + paramInt1 + ",height=" + paramInt2);
    }
    ram.d("BaseLayer", "layer size,width=" + paramInt1 + ",height=" + paramInt2);
    this.drawRect.left = 0;
    this.drawRect.right = paramInt1;
    this.drawRect.top = 0;
    this.drawRect.bottom = paramInt2;
    this.limitLeft = this.drawRect.left;
    this.limitRight = this.drawRect.right;
    this.brc = this.drawRect.top;
    this.brd = this.drawRect.bottom;
  }
  
  public void tJ(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.b.setActiveLayer(this);
    }
    for (;;)
    {
      notifyChange();
      return;
      this.b.buy();
    }
  }
  
  public static abstract interface a<T extends aykd>
  {
    public abstract boolean a(T paramT, MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aykd
 * JD-Core Version:    0.7.0.1
 */