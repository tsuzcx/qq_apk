package com.tencent.mobileqq.emoticonview;

import afpe;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import wmj;

public class FastImagePreviewLayout
  extends LinearLayout
{
  public static String TAG = FastImagePreviewLayout.class.getSimpleName();
  long XE = 0L;
  MqqHandler b;
  final String bEE = "/tencent/zebra/cache/";
  Context context;
  float density;
  URLDrawable z = null;
  
  public FastImagePreviewLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    this.density = this.context.getResources().getDisplayMetrics().density;
  }
  
  public void Ie(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "removeFastImage called");
    }
    setVisibility(8);
    if (paramBoolean)
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      setAnimation(localAlphaAnimation);
      localAlphaAnimation.setDuration(500L);
      localAlphaAnimation.setFillAfter(true);
      startAnimation(localAlphaAnimation);
      localAlphaAnimation.setAnimationListener(new afpe(this));
      return;
    }
    removeAllViews();
  }
  
  public void dbo()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "showFastImage called, path = " + wmj.aTf);
    }
    removeAllViews();
    Object localObject = inflate(this.context, 2131558654, null);
    ((ImageView)((View)localObject).findViewById(2131366719)).setImageDrawable(this.z);
    addView((View)localObject);
    setVisibility(0);
    localObject = new AlphaAnimation(0.0F, 1.0F);
    setAnimation((Animation)localObject);
    ((AlphaAnimation)localObject).setDuration(500L);
    ((AlphaAnimation)localObject).setFillAfter(true);
    startAnimation((Animation)localObject);
  }
  
  public void dbp()
  {
    ThreadManager.getSubThreadHandler().post(new FastImagePreviewLayout.2(this));
  }
  
  public void setHandler(MqqHandler paramMqqHandler)
  {
    this.b = paramMqqHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.FastImagePreviewLayout
 * JD-Core Version:    0.7.0.1
 */