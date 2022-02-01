import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import java.util.ArrayList;
import java.util.Iterator;

public class akzb
{
  public int alpha = 255;
  public Drawable drawable;
  public int height;
  public Transformation mTransformation = new Transformation();
  public float scaleX = 1.0F;
  public float scaleY = 1.0F;
  public int width;
  public int x;
  public int y;
  public ArrayList<Animation> yz = new ArrayList();
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    this.x = paramInt1;
    this.y = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
  }
  
  public boolean ata()
  {
    Iterator localIterator = this.yz.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Animation localAnimation = (Animation)localIterator.next();
      if ((bool) || (localAnimation.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.mTransformation))) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    return bool;
  }
  
  public void ba(Canvas paramCanvas)
  {
    if ((this.alpha != 0) && (this.drawable != null))
    {
      paramCanvas.save();
      paramCanvas.translate(this.x, this.y);
      this.drawable.setAlpha(this.alpha);
      this.drawable.setBounds(0, 0, this.width, this.height);
      paramCanvas.scale(this.scaleX, this.scaleY, this.width / 2, this.height / 2);
      this.drawable.draw(paramCanvas);
      paramCanvas.restore();
    }
  }
  
  public boolean draw(Canvas paramCanvas)
  {
    if ((this.alpha != 0) && (this.drawable != null))
    {
      paramCanvas.save();
      paramCanvas.translate(this.x, this.y);
      this.drawable.setAlpha(this.alpha);
      this.drawable.setBounds(0, 0, this.width, this.height);
      paramCanvas.scale(this.scaleX, this.scaleY, this.width / 2, this.height / 2);
      this.drawable.draw(paramCanvas);
      paramCanvas.restore();
    }
    paramCanvas = this.yz.iterator();
    boolean bool = false;
    if (paramCanvas.hasNext())
    {
      Animation localAnimation = (Animation)paramCanvas.next();
      if ((bool) || (localAnimation.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.mTransformation))) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    return bool;
  }
  
  public void startAnimation(Animation paramAnimation)
  {
    this.yz.add(paramAnimation);
    paramAnimation.start();
  }
  
  public void stopAnimation()
  {
    this.yz.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akzb
 * JD-Core Version:    0.7.0.1
 */