import android.content.res.Resources;
import android.graphics.NinePatch;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.tencent.mobileqq.bubble.DecorationVipBubbleDrawable;

public final class dbl
  extends Drawable.ConstantState
{
  public final NinePatch a;
  public final NinePatch b;
  
  public dbl(NinePatch paramNinePatch)
  {
    this.a = paramNinePatch;
    this.b = paramNinePatch;
  }
  
  public dbl(NinePatch paramNinePatch1, NinePatch paramNinePatch2)
  {
    this.a = paramNinePatch1;
    this.b = paramNinePatch2;
  }
  
  public int getChangingConfigurations()
  {
    return 0;
  }
  
  public Drawable newDrawable()
  {
    return new DecorationVipBubbleDrawable(null, this);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new DecorationVipBubbleDrawable(paramResources, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dbl
 * JD-Core Version:    0.7.0.1
 */