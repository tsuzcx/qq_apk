import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.common.galleryactivity.AnimationView;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.util.VersionUtils;

public class akbl
  extends sxw
{
  private sxm b;
  
  public akbl(Activity paramActivity, sxm paramsxm)
  {
    super(paramActivity, paramsxm);
    this.b = paramsxm;
  }
  
  private Drawable a(Rect paramRect1, Rect paramRect2, Rect paramRect3, Rect paramRect4, sxy paramsxy, boolean paramBoolean)
  {
    if (paramsxy == null) {}
    Drawable localDrawable;
    do
    {
      return null;
      localDrawable = paramsxy.getAnimationDrawable();
      paramRect1 = paramsxy.getThumbRect();
    } while ((paramRect1 == null) || (localDrawable == null) || (!paramsxy.needAnimation(paramBoolean)));
    int i = this.gallery.getWidth();
    int j = this.gallery.getHeight();
    int k = localDrawable.getIntrinsicWidth();
    int m = localDrawable.getIntrinsicHeight();
    paramRect2.set(0, 0, k, m);
    paramRect3.set(paramRect1);
    if ((paramsxy instanceof xuf)) {}
    for (paramRect2 = ((xuf)paramsxy).e;; paramRect2 = null)
    {
      if ((!VersionUtils.isHoneycomb()) && ((localDrawable instanceof URLDrawable)) && ((((URLDrawable)localDrawable).getCurrDrawable() instanceof GifDrawable))) {}
      for (paramRect1 = sxx.getAnimationEndDstRect(k, m, i, j, false, paramRect2);; paramRect1 = null)
      {
        if (paramRect1 == null) {
          paramRect1 = sxx.getAnimationEndDstRect(k, m, i, j, paramRect2);
        }
        for (;;)
        {
          paramRect4.set(paramRect1);
          return localDrawable;
        }
      }
    }
  }
  
  public boolean startEnterAnimation()
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1;
    if (isAnimating()) {
      bool1 = true;
    }
    Rect localRect1;
    Rect localRect2;
    sxy localsxy;
    Rect localRect3;
    Rect localRect4;
    Drawable localDrawable;
    do
    {
      do
      {
        do
        {
          return bool1;
          if (this.gallery == null) {
            init();
          }
          localRect1 = new Rect();
          localRect2 = new Rect();
          localsxy = this.b.a();
          bool1 = bool3;
        } while (localsxy == null);
        localRect3 = localsxy.getStartSrcRect();
        localRect4 = new Rect();
        localDrawable = a(null, localRect4, localRect1, localRect2, localsxy, true);
        bool1 = bool3;
      } while (localRect4.right == -1);
      bool1 = bool3;
    } while (localRect4.bottom == -1);
    this.mIsAnimating = true;
    if (localDrawable != null)
    {
      bool1 = bool2;
      this.isRectAnimation = bool1;
      if (this.isRectAnimation) {
        break label158;
      }
      this.a.setVisibility(4);
    }
    for (;;)
    {
      return this.isRectAnimation;
      bool1 = false;
      break;
      label158:
      this.a.setVisibility(0);
      this.a.setAnimationListener(this);
      this.a.isImgCenterCropMode = localsxy.isImgCenterCropMode;
      if (localRect3 == null) {
        this.a.startEnterAnimation(localDrawable, localRect1, localRect2, localsxy.getCutValue(), this.animationDuring);
      } else {
        this.a.startEnterAnimationFreeMode(localDrawable, localRect3, localRect4, localRect1, localRect2, this.animationDuring);
      }
    }
  }
  
  public boolean startExitAnimation()
  {
    if (isAnimating()) {
      return true;
    }
    if (this.gallery == null) {
      init();
    }
    Rect localRect2 = new Rect();
    Rect localRect3 = new Rect();
    sxy localsxy = this.b.a();
    Rect localRect1 = null;
    if (localsxy != null) {
      localRect1 = localsxy.getStartSrcRect();
    }
    Rect localRect4 = new Rect();
    Drawable localDrawable = a(localRect1, localRect4, localRect2, localRect3, localsxy, false);
    if ((localRect4.right == -1) || (localRect4.bottom == -1)) {
      return false;
    }
    this.mIsAnimating = true;
    boolean bool;
    if (localDrawable != null)
    {
      bool = true;
      this.isRectAnimation = bool;
      if (this.isRectAnimation) {
        break label147;
      }
      this.a.setVisibility(4);
    }
    for (;;)
    {
      return this.isRectAnimation;
      bool = false;
      break;
      label147:
      this.a.setVisibility(0);
      this.a.setAnimationListener(this);
      this.a.isImgCenterCropMode = localsxy.isImgCenterCropMode;
      this.a.startBackAnimation(localDrawable, localRect2, localRect3, localsxy.getCutValue(), localsxy.getStartX(), localsxy.getStartY(), this.animationDuring);
      if (localRect1 == null) {
        this.a.startBackAnimation(localDrawable, localRect2, localRect3, localsxy.getCutValue(), localsxy.getStartX(), localsxy.getStartY(), this.animationDuring);
      } else {
        this.a.startBackAnimationFreeMode(localDrawable, localRect1, localRect4, localRect2, localRect3, this.animationDuring);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akbl
 * JD-Core Version:    0.7.0.1
 */