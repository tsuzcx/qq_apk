import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public final class jku
  extends Drawable
{
  private boolean ZN;
  private final int aAF;
  private final int aAG;
  private int aAH = -1;
  private int aAI;
  private Rect ar = new Rect();
  private HashMap<Integer, ArrayList<Bitmap>> cL = new HashMap();
  private Paint mPaint;
  private Rect mSrcRect;
  private RectF v;
  
  public jku(int paramInt1, int paramInt2)
  {
    this.aAF = paramInt1;
    this.aAG = paramInt2;
    this.mPaint = new Paint(6);
    this.mPaint.setAntiAlias(true);
    this.mSrcRect = new Rect();
    this.v = new RectF(0.0F, 0.0F, this.aAF, this.aAG);
  }
  
  private void S(Canvas paramCanvas) {}
  
  private ArrayList<Bitmap> aW()
  {
    return (ArrayList)this.cL.get(Integer.valueOf(this.aAH));
  }
  
  private boolean xN()
  {
    return (this.aAH == 1) || (this.aAH == 3);
  }
  
  public void a(int paramInt, Bitmap paramBitmap)
  {
    ArrayList localArrayList = (ArrayList)this.cL.get(Integer.valueOf(paramInt));
    if (localArrayList != null)
    {
      localArrayList.add(paramBitmap);
      return;
    }
    localArrayList = new ArrayList();
    localArrayList.add(paramBitmap);
    this.cL.put(Integer.valueOf(paramInt), localArrayList);
  }
  
  public void draw(Canvas paramCanvas)
  {
    S(paramCanvas);
    Object localObject = aW();
    if (xN())
    {
      localBitmap = (Bitmap)((ArrayList)localObject).get(0);
      this.mSrcRect.set(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
      paramCanvas.drawBitmap(localBitmap, this.mSrcRect, this.v, this.mPaint);
    }
    do
    {
      return;
      if (this.aAH == 0)
      {
        localBitmap = (Bitmap)((ArrayList)localObject).get(0);
        localObject = (Bitmap)((ArrayList)localObject).get(1);
        this.mSrcRect.set(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
        paramCanvas.drawBitmap(localBitmap, this.mSrcRect, this.v, this.mPaint);
        paramCanvas.save();
        int i = (int)(this.aAG * (10000 - this.aAI) / 10000.0F);
        if (QLog.isColorLevel()) {
          QLog.d("huanxxiao", 1, "doUpdateAudioVolumeChange nexValue:=" + this.aAI);
        }
        this.ar.set(0, i, this.aAF, this.aAG);
        paramCanvas.clipRect(this.ar);
        paramCanvas.drawBitmap((Bitmap)localObject, null, this.v, this.mPaint);
        paramCanvas.restore();
        return;
      }
    } while (this.aAH != 2);
    if (this.ZN) {}
    for (Bitmap localBitmap = (Bitmap)((ArrayList)localObject).get(1);; localBitmap = (Bitmap)((ArrayList)localObject).get(0))
    {
      this.mSrcRect.set(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
      paramCanvas.drawBitmap(localBitmap, this.mSrcRect, this.v, this.mPaint);
      return;
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.aAG;
  }
  
  public int getIntrinsicWidth()
  {
    return this.aAF;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void lg(boolean paramBoolean)
  {
    this.ZN = paramBoolean;
  }
  
  public void nN(int paramInt)
  {
    if (this.aAH == paramInt) {
      return;
    }
    int i = this.aAH;
    this.aAH = paramInt;
    invalidateSelf();
  }
  
  public void nO(int paramInt)
  {
    this.aAI = paramInt;
    invalidateSelf();
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.v = new RectF(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
  }
  
  public void setAlpha(int paramInt)
  {
    if (this.mPaint.getAlpha() == paramInt) {
      return;
    }
    this.mPaint.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jku
 * JD-Core Version:    0.7.0.1
 */