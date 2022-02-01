import android.graphics.Matrix;
import android.graphics.Path;
import java.util.LinkedList;
import java.util.List;

public class ria
  extends rhx
{
  public int color;
  public int lineWidth;
  List<Integer> oP;
  List<Integer> oQ;
  public Path path;
  
  public ria(Path paramPath, int paramInt)
  {
    super(paramInt);
    this.path = paramPath;
    this.oP = new LinkedList();
    this.oQ = new LinkedList();
  }
  
  public ria(rhx paramrhx, float paramFloat)
  {
    super(paramrhx.mode);
    if ((paramrhx instanceof ria))
    {
      paramrhx = (ria)paramrhx;
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
 * Qualified Name:     ria
 * JD-Core Version:    0.7.0.1
 */