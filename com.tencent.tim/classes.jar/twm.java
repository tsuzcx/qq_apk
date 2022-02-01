import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.lottieNew.model.layer.Layer;
import java.util.Collections;

public class twm
  extends twe
{
  private final tsp a;
  
  twm(trz paramtrz, Layer paramLayer)
  {
    super(paramtrz, paramLayer);
    this.a = new tsp(paramtrz, this, new tvz(paramLayer.getName(), paramLayer.getShapes()));
    this.a.setContents(Collections.emptyList(), Collections.emptyList());
  }
  
  public void a(RectF paramRectF, Matrix paramMatrix)
  {
    super.a(paramRectF, paramMatrix);
    this.a.a(paramRectF, this.boundsMatrix);
  }
  
  public void b(@Nullable String paramString1, @Nullable String paramString2, @Nullable ColorFilter paramColorFilter)
  {
    this.a.b(paramString1, paramString2, paramColorFilter);
  }
  
  void drawLayer(@NonNull Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    this.a.draw(paramCanvas, paramMatrix, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     twm
 * JD-Core Version:    0.7.0.1
 */