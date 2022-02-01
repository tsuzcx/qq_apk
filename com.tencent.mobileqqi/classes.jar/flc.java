import android.content.res.Resources;
import android.graphics.NinePatch;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.tencent.mobileqq.bubble.VipBubbleDrawable;

public final class flc
  extends Drawable.ConstantState
{
  public final NinePatch a;
  
  public flc(NinePatch paramNinePatch)
  {
    this.a = paramNinePatch;
  }
  
  public int getChangingConfigurations()
  {
    return 0;
  }
  
  public Drawable newDrawable()
  {
    return new VipBubbleDrawable(null, this);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new VipBubbleDrawable(paramResources, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     flc
 * JD-Core Version:    0.7.0.1
 */