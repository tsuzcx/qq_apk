import android.graphics.Matrix;
import android.graphics.Path;

public class rii
  extends rhx
{
  public int color;
  public int lineWidth;
  public Path path;
  
  public rii(Path paramPath, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    this.path = paramPath;
    this.color = paramInt2;
    this.lineWidth = paramInt3;
  }
  
  public rii(rhx paramrhx, float paramFloat)
  {
    super(paramrhx.mode);
    if ((paramrhx instanceof rii))
    {
      paramrhx = (rii)paramrhx;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat, paramFloat);
      this.path = new Path();
      this.path.addPath(paramrhx.path, localMatrix);
      this.mode = paramrhx.mode;
      this.color = paramrhx.color;
      this.lineWidth = ((int)(paramrhx.lineWidth * paramFloat));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rii
 * JD-Core Version:    0.7.0.1
 */