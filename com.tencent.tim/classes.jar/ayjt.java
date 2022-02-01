import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public class ayjt
  extends aykb
{
  public ayjt(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
  }
  
  public void a(@NonNull Bitmap paramBitmap, @NonNull Rect[] paramArrayOfRect, String[] paramArrayOfString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (this.a == null)
    {
      this.a = new ayjt.a(paramArrayOfString, paramBitmap, new PointF(rpq.getWindowScreenWidth(this.context) / 2, rpq.getWindowScreenHeight(this.context) / 2), paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramBitmap.getWidth(), paramBitmap.getHeight(), true);
      this.a.h = paramArrayOfRect;
    }
    for (;;)
    {
      this.mMode = 1;
      super.notifyChange();
      return;
      if (!this.a.bitmap.isRecycled()) {
        this.a.bitmap.recycle();
      }
      this.a.bitmap = paramBitmap;
      this.a.width = paramBitmap.getWidth();
      this.a.height = paramBitmap.getHeight();
      this.a.h = paramArrayOfRect;
      this.a.scaleValue = paramFloat1;
      this.a.nI = paramFloat2;
      this.a.translateXValue = paramFloat3;
      this.a.translateYValue = paramFloat4;
      this.a.jn = paramArrayOfString;
    }
  }
  
  public String getTag()
  {
    return "InteractPasterLayer";
  }
  
  public class a
    extends aykb.b
  {
    public a(String[] paramArrayOfString, @NonNull Bitmap paramBitmap, @NonNull PointF paramPointF, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
    {
      super(paramArrayOfString, paramBitmap, paramPointF, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayjt
 * JD-Core Version:    0.7.0.1
 */