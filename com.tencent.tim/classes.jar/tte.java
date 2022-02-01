import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import com.tencent.lottieNew.model.content.ShapeStroke;
import com.tencent.lottieNew.model.content.ShapeStroke.LineCapType;
import com.tencent.lottieNew.model.content.ShapeStroke.LineJoinType;

public class tte
  extends tsm
{
  private final ttg<Integer, Integer> f;
  private final String name;
  
  public tte(trz paramtrz, twe paramtwe, ShapeStroke paramShapeStroke)
  {
    super(paramtrz, paramtwe, paramShapeStroke.a().toPaintCap(), paramShapeStroke.a().toPaintJoin(), paramShapeStroke.b(), paramShapeStroke.e(), paramShapeStroke.getLineDashPattern(), paramShapeStroke.f());
    this.name = paramShapeStroke.getName();
    this.f = paramShapeStroke.a().g();
    this.f.b(this);
    paramtwe.a(this.f);
  }
  
  public void b(@Nullable String paramString1, @Nullable String paramString2, @Nullable ColorFilter paramColorFilter)
  {
    this.paint.setColorFilter(paramColorFilter);
  }
  
  public void draw(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    this.paint.setColor(((Integer)this.f.getValue()).intValue());
    super.draw(paramCanvas, paramMatrix, paramInt);
  }
  
  public String getName()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tte
 * JD-Core Version:    0.7.0.1
 */