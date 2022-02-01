import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profile.like.PraiseManager.a;
import com.tencent.qphone.base.util.QLog;

public class alek
  extends auqs.a
{
  public ahyq b;
  int count = 0;
  public SparseArray<Pair<Point, Integer>> dj = new SparseArray();
  public Drawable fl;
  int index = 0;
  public Drawable[] mDrawables;
  public boolean mStarted;
  public View mView;
  
  public static Animation a(Animation.AnimationListener paramAnimationListener, float paramFloat1, float paramFloat2)
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat1, paramFloat2);
    localScaleAnimation.setRepeatMode(2);
    localScaleAnimation.setRepeatCount(-1);
    localScaleAnimation.setDuration(750L);
    localAlphaAnimation.setRepeatMode(2);
    localAlphaAnimation.setRepeatCount(-1);
    localAlphaAnimation.setDuration(750L);
    localAlphaAnimation.setAnimationListener(paramAnimationListener);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setInterpolator(new alel());
    return localAnimationSet;
  }
  
  public void a(QQAppInterface paramQQAppInterface, HeartLayout paramHeartLayout, Bitmap paramBitmap, PraiseManager.a parama, int paramInt1, boolean paramBoolean, int paramInt2, float paramFloat1, float paramFloat2)
  {
    if (anlm.ayn())
    {
      if (QLog.isColorLevel()) {
        QLog.i("PraiseManager", 2, "doZanAnim, SimpleUIMode is open now");
      }
      paramHeartLayout.a(paramBitmap, paramFloat1, paramFloat2);
    }
    do
    {
      return;
      PraiseManager localPraiseManager = (PraiseManager)paramQQAppInterface.getManager(209);
      if ((paramBoolean) && (localPraiseManager.o.get(Integer.valueOf(paramInt1)) == null))
      {
        localPraiseManager.a(parama);
        this.dj.put(paramInt1, new Pair(new Point((int)paramFloat1, (int)paramFloat2), Integer.valueOf(paramInt2)));
      }
      parama = localPraiseManager.a(paramInt1, paramBoolean, "from_nearby_people");
      if (parama != null)
      {
        if ((paramInt2 == 2) && (parama.fS != null))
        {
          if (this.b != null)
          {
            paramHeartLayout.a(parama, parama.fS, paramQQAppInterface, this.b.a(paramInt2, paramHeartLayout.b), paramFloat1 - aqcx.dip2px(paramHeartLayout.getContext(), 20.0F), paramFloat2 - aqcx.dip2px(paramHeartLayout.getContext(), 120.0F), aqcx.dip2px(paramHeartLayout.getContext(), 75.0F), aqcx.dip2px(paramHeartLayout.getContext(), 65.0F));
            return;
          }
          paramHeartLayout.a(parama, parama.fS, paramFloat1, paramFloat2);
          return;
        }
        paramHeartLayout.a(parama, parama.fR, paramFloat1, paramFloat2);
        return;
      }
    } while (paramBoolean);
    paramHeartLayout.a(paramBitmap, paramFloat1, paramFloat2);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, Drawable paramDrawable, Resources paramResources)
  {
    Drawable localDrawable2 = this.fl;
    Drawable localDrawable1;
    if (paramBoolean2) {
      localDrawable1 = jqg.d(localDrawable2, paramResources.getColor(2131165885));
    }
    while (this.mDrawables == null)
    {
      this.mDrawables = new Drawable[] { paramDrawable, localDrawable1 };
      return;
      localDrawable1 = localDrawable2;
      if (paramBoolean1) {
        localDrawable1 = jqg.d(localDrawable2, paramResources.getColor(2131165888));
      }
    }
    this.mDrawables[0] = paramDrawable;
    this.mDrawables[1] = localDrawable1;
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if (this.count % 2 == 0)
    {
      this.index = ((this.index + 1) % this.mDrawables.length);
      if (!(this.mView instanceof ImageView)) {
        break label89;
      }
      ((ImageView)this.mView).setImageDrawable(this.mDrawables[this.index]);
    }
    for (;;)
    {
      this.count += 1;
      if (this.count / 2 >= alem.playNum)
      {
        this.mView.clearAnimation();
        this.mStarted = false;
      }
      return;
      label89:
      this.mView.setBackgroundDrawable(this.mDrawables[this.index]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alek
 * JD-Core Version:    0.7.0.1
 */