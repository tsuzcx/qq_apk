import android.content.res.Resources;
import android.graphics.NinePatch;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.tencent.mobileqq.bubble.VipBubbleDrawable;

public final class dar
  extends Drawable.ConstantState
{
  public final NinePatch a;
  
  public dar(NinePatch paramNinePatch)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dar
 * JD-Core Version:    0.7.0.1
 */