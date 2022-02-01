import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;
import com.tencent.mobileqq.widget.presseffect.PressEffectImageView;

public class anyx
  extends anza
  implements anxw
{
  protected String mEvent;
  
  public anyx(SpriteNativeView paramSpriteNativeView, String paramString)
  {
    super(paramSpriteNativeView);
    this.mEvent = paramString;
  }
  
  public String on()
  {
    return this.mEvent;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mImageView.setOnClickListener(paramOnClickListener);
  }
  
  protected ImageView y()
  {
    return new PressEffectImageView(this.a.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anyx
 * JD-Core Version:    0.7.0.1
 */