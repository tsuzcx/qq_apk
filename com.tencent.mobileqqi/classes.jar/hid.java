import android.content.res.Resources;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.widget.DrawableContainer;
import com.tencent.mobileqq.widget.DrawableContainer.ContainerState;
import com.tencent.mobileqq.widget.XfermodeDrawable;

public class hid
  extends DrawableContainer.ContainerState
{
  public Xfermode a;
  
  public hid(Drawable paramDrawable, DrawableContainer paramDrawableContainer, Xfermode paramXfermode)
  {
    super(paramDrawable, paramDrawableContainer);
    this.a = paramXfermode;
  }
  
  hid(hid paramhid, DrawableContainer paramDrawableContainer, Resources paramResources)
  {
    super(paramhid, paramDrawableContainer, paramResources);
    this.a = paramhid.a;
  }
  
  public Drawable newDrawable()
  {
    return new XfermodeDrawable(this, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hid
 * JD-Core Version:    0.7.0.1
 */