import android.content.res.Resources;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.widget.DrawableContainer;
import com.tencent.mobileqq.widget.DrawableContainer.ContainerState;
import com.tencent.mobileqq.widget.XfermodeDrawable;

public class ezu
  extends DrawableContainer.ContainerState
{
  public Xfermode a;
  
  public ezu(Drawable paramDrawable, DrawableContainer paramDrawableContainer, Xfermode paramXfermode)
  {
    super(paramDrawable, paramDrawableContainer);
    this.a = paramXfermode;
  }
  
  ezu(ezu paramezu, DrawableContainer paramDrawableContainer, Resources paramResources)
  {
    super(paramezu, paramDrawableContainer, paramResources);
    this.a = paramezu.a;
  }
  
  public Drawable newDrawable()
  {
    return new XfermodeDrawable(this, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ezu
 * JD-Core Version:    0.7.0.1
 */