import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.common.galleryactivity.AnimationView;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class sxw
  extends sxg
{
  protected AnimationView a;
  sxm b;
  View bgView;
  int densityDpi;
  protected View gallery;
  Activity mContext;
  View rootView;
  
  public sxw(Activity paramActivity, sxm paramsxm)
  {
    this.mContext = paramActivity;
    this.b = paramsxm;
    this.densityDpi = paramActivity.getResources().getDisplayMetrics().densityDpi;
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
  
  public void init()
  {
    this.gallery = this.mContext.findViewById(2131367833);
    this.a = ((AnimationView)this.mContext.findViewById(2131362725));
    this.rootView = this.mContext.findViewById(2131377546);
    this.bgView = this.mContext.findViewById(2131363236);
  }
  
  public void onEnterAnimationEnd()
  {
    this.mIsAnimating = false;
    this.a.setVisibility(4);
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext()) {
      ((sxv)localIterator.next()).onEnterAnimationEnd();
    }
    this.listeners.clear();
  }
  
  public void onEnterAnimationStart()
  {
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext()) {
      ((sxv)localIterator.next()).onEnterAnimationStart();
    }
  }
  
  public void onExitAnimationEnd()
  {
    this.mIsAnimating = false;
    this.a.setVisibility(4);
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext()) {
      ((sxv)localIterator.next()).onExitAnimationEnd();
    }
    this.listeners.clear();
  }
  
  public void onExitAnimationStart()
  {
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext()) {
      ((sxv)localIterator.next()).onExitAnimationStart();
    }
  }
  
  public boolean startEnterAnimation()
  {
    boolean bool = true;
    if (isAnimating()) {
      return true;
    }
    if (this.gallery == null) {
      init();
    }
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    sxy localsxy = this.b.a();
    if (localsxy == null) {
      return false;
    }
    Rect localRect3 = localsxy.getStartSrcRect();
    Rect localRect4 = new Rect();
    Drawable localDrawable = a(null, localRect4, localRect1, localRect2, localsxy, true);
    this.mIsAnimating = true;
    if (localDrawable != null)
    {
      this.isRectAnimation = bool;
      if (this.isRectAnimation) {
        break label126;
      }
      this.a.setVisibility(4);
    }
    for (;;)
    {
      return this.isRectAnimation;
      bool = false;
      break;
      label126:
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
    this.mIsAnimating = true;
    boolean bool;
    if (localDrawable != null)
    {
      bool = true;
      this.isRectAnimation = bool;
      if (this.isRectAnimation) {
        break label127;
      }
      this.a.setVisibility(4);
    }
    for (;;)
    {
      return this.isRectAnimation;
      bool = false;
      break;
      label127:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     sxw
 * JD-Core Version:    0.7.0.1
 */