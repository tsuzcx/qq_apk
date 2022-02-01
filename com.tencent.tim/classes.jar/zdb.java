import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.List;

public class zdb
  extends Drawable
{
  private QQAppInterface mApp;
  private int mRadius;
  private int mWidth;
  private List<Drawable> tW;
  
  public zdb(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  public void M(List<Drawable> paramList, int paramInt)
  {
    this.tW = paramList;
    this.mRadius = paramInt;
    this.mWidth = (paramInt * 2);
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    Iterator localIterator = this.tW.iterator();
    while (localIterator.hasNext())
    {
      Drawable localDrawable = (Drawable)localIterator.next();
      localDrawable = ((aqrc)this.mApp.getManager(235)).c.e(localDrawable, this.mRadius);
      if (localDrawable != null)
      {
        localDrawable.setBounds(0, 0, this.mWidth, this.mWidth);
        localDrawable.draw(paramCanvas);
        paramCanvas.translate(this.mRadius, 0.0F);
      }
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zdb
 * JD-Core Version:    0.7.0.1
 */