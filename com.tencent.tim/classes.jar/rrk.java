import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;

public class rrk
  extends Drawable
{
  private int buG;
  private int buH;
  private Bitmap cR;
  private Matrix matrix;
  
  public rrk(int paramInt1, int paramInt2)
  {
    this(null, paramInt1, paramInt2);
  }
  
  public rrk(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    ram.i("Q.qqstory.record.StoryFaceDrawable", "StoryFaceDrawable.");
    this.buG = paramInt1;
    this.buH = paramInt2;
    setBounds(0, 0, paramInt1, paramInt2);
    if (paramBitmap == null) {}
    for (this.cR = aqhu.G();; this.cR = paramBitmap)
    {
      this.matrix = new Matrix();
      this.matrix.setScale(paramInt1 / this.cR.getWidth(), paramInt2 / this.cR.getHeight());
      return;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    ram.i("Q.qqstory.record.StoryFaceDrawable", "StoryFaceDrawable draw start.");
    paramCanvas.drawBitmap(this.cR, this.matrix, null);
    ram.i("Q.qqstory.record.StoryFaceDrawable", "StoryFaceDrawable draw end.");
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void x(Bitmap paramBitmap)
  {
    this.cR = paramBitmap;
    this.matrix.setScale(this.buG / paramBitmap.getWidth(), this.buH / paramBitmap.getHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rrk
 * JD-Core Version:    0.7.0.1
 */