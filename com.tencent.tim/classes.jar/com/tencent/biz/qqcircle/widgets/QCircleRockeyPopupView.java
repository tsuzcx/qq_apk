package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aqcx;
import com.tencent.biz.qqcircle.events.QCirclePushAnimationEvent;
import com.tencent.biz.qqcircle.events.QCirclePushAnimationStateEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import ozo;
import ozo.a;
import ozo.b;
import phb;
import phc;
import phd;
import phe;
import rwv;
import rwx;
import sgm;

public class QCircleRockeyPopupView
  extends FrameLayout
  implements rwx
{
  private static boolean azZ;
  private static ozo b = new ozo();
  private static Map<String, ozo.a> fz;
  private AtomicInteger ae;
  private AtomicInteger af;
  private AnimationSet j;
  private AnimationSet k;
  private AnimationSet l;
  private int mPageType;
  private String mTargetId;
  
  static
  {
    b.a(new ozo.b("https://downv6.qq.com/video_story/qcircle/animation/rockey1.zip"));
    b.a(new ozo.b("https://downv6.qq.com/video_story/qcircle/animation/rockey2.zip"));
    b.a(new ozo.b("https://downv6.qq.com/video_story/qcircle/animation/rockey3.zip"));
    b.a(new ozo.b("https://downv6.qq.com/video_story/qcircle/animation/rockey_single_click.zip"));
  }
  
  public QCircleRockeyPopupView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleRockeyPopupView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleRockeyPopupView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  private void dM(int paramInt1, int paramInt2)
  {
    setVisibility(0);
    this.af.set(paramInt1);
    int i = paramInt1 % 3;
    Object localObject1 = "https://downv6.qq.com/video_story/qcircle/animation/rockey_single_click.zip";
    if (paramInt2 == 1) {
      localObject1 = "https://downv6.qq.com/video_story/qcircle/animation/rockey_single_click.zip";
    }
    for (;;)
    {
      if ((fz != null) && (fz.containsKey(localObject1))) {}
      try
      {
        localObject1 = (ozo.a)fz.get(localObject1);
        if (localObject1 == null)
        {
          return;
          if (i == 0) {
            localObject1 = "https://downv6.qq.com/video_story/qcircle/animation/rockey1.zip";
          } else if (i == 1) {
            localObject1 = "https://downv6.qq.com/video_story/qcircle/animation/rockey2.zip";
          } else if (i == 2) {
            localObject1 = "https://downv6.qq.com/video_story/qcircle/animation/rockey3.zip";
          }
        }
        else
        {
          Object localObject2 = sgm.g(((ozo.a)localObject1).mFilePath);
          localObject1 = new QQAnimationDrawable();
          ((QQAnimationDrawable)localObject1).Q((String[])localObject2);
          localObject2 = new ImageView(getContext());
          ((ImageView)localObject2).setLayoutParams(new FrameLayout.LayoutParams(aqcx.dip2px(getContext(), 115.0F), aqcx.dip2px(getContext(), 210.0F)));
          ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
          ((QQAnimationDrawable)localObject1).setOneShot(true);
          ((QQAnimationDrawable)localObject1).setDuration(1000L);
          QLog.i("QQAnimationDrawable", 1, "hashCode" + localObject1.hashCode() + " count" + paramInt1);
          ((QQAnimationDrawable)localObject1).a(new phb(this, paramInt1, Double.valueOf(((QQAnimationDrawable)localObject1).Cb() * 0.6D).intValue(), paramInt2));
          ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
          addView((View)localObject2);
          ((QQAnimationDrawable)localObject1).start();
          ((ImageView)localObject2).postDelayed(new QCircleRockeyPopupView.2(this, (ImageView)localObject2, (QQAnimationDrawable)localObject1, paramInt1), 1000L);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.d("QCircleRecommend_", 1, "startRockeyAnimation error" + localException.getMessage());
        vB(paramInt1);
      }
    }
  }
  
  private void dN(int paramInt1, int paramInt2)
  {
    LinearLayout localLinearLayout = g();
    this.k = new AnimationSet(true);
    Object localObject = new AlphaAnimation(0.0F, 1.0F);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0, 0.0F, 0, 0.0F, 0, 0.0F, 0, -aqcx.dip2px(getContext(), 15.0F));
    this.k.addAnimation((Animation)localObject);
    this.k.addAnimation(localTranslateAnimation);
    this.k.setDuration(300L);
    this.k.setInterpolator(new DecelerateInterpolator());
    this.k.setAnimationListener(new phc(this, localLinearLayout));
    this.l = new AnimationSet(true);
    localObject = new AlphaAnimation(1.0F, 0.0F);
    localTranslateAnimation = new TranslateAnimation(0, 0.0F, 0, 0.0F, 0, 0.0F, 0, aqcx.dip2px(getContext(), 15.0F));
    this.l.addAnimation((Animation)localObject);
    this.l.addAnimation(localTranslateAnimation);
    this.l.setDuration(200L);
    this.l.setStartOffset(500L);
    this.l.setInterpolator(new AccelerateInterpolator());
    this.l.setAnimationListener(new phd(this, localLinearLayout));
    this.j = new AnimationSet(true);
    this.j.addAnimation(this.k);
    this.j.addAnimation(this.l);
    this.j.setFillAfter(true);
    localObject = (TextView)localLinearLayout.findViewById(2131380883);
    if (localObject != null) {
      ((TextView)localObject).setText(String.valueOf(paramInt1));
    }
    localLinearLayout.setVisibility(4);
    addView(localLinearLayout);
    localLinearLayout.startAnimation(this.j);
    localLinearLayout.postDelayed(new QCircleRockeyPopupView.5(this, localLinearLayout), 1500L);
  }
  
  private LinearLayout g()
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setGravity(1);
    localLinearLayout.setOrientation(0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(aqcx.dip2px(getContext(), 115.0F), -2);
    localLayoutParams.gravity = 1;
    localLayoutParams.topMargin = aqcx.dip2px(getContext(), 50.0F);
    localLinearLayout.setLayoutParams(localLayoutParams);
    LayoutInflater.from(getContext()).inflate(2131560938, localLinearLayout);
    return localLinearLayout;
  }
  
  private void initView()
  {
    this.ae = new AtomicInteger(0);
    this.af = new AtomicInteger(0);
    bringToFront();
  }
  
  private void vB(int paramInt)
  {
    if ((paramInt >= this.ae.get()) && (!TextUtils.isEmpty(this.mTargetId))) {
      rwv.a().a(new QCirclePushAnimationStateEvent(this.mTargetId, 2, this.mPageType));
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCirclePushAnimationEvent.class);
    return localArrayList;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    rwv.a().a(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    rwv.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCirclePushAnimationEvent))
    {
      paramSimpleBaseEvent = (QCirclePushAnimationEvent)paramSimpleBaseEvent;
      if ((paramSimpleBaseEvent.mTargetFeedId.equals(this.mTargetId)) && (paramSimpleBaseEvent.mPageType == this.mPageType))
      {
        QLog.d("QCircleRecommend_", 1, "onReceiveEvent QCirclePushAnimationEvent id:" + paramSimpleBaseEvent.mTargetFeedId + "pageType:" + this.mPageType);
        startAnimation(paramSimpleBaseEvent.mRecommendTimes, paramSimpleBaseEvent.mClickType);
      }
    }
  }
  
  public void setFeedId(String paramString)
  {
    this.mTargetId = paramString;
  }
  
  public void setPageType(int paramInt)
  {
    this.mPageType = paramInt;
  }
  
  public void startAnimation(int paramInt1, int paramInt2)
  {
    this.ae.set(paramInt1);
    QLog.i("QCircleRecommend_", 1, "setCount " + paramInt1);
    if (!azZ)
    {
      b.a(new phe(this, paramInt1, paramInt2));
      b.start();
      return;
    }
    try
    {
      ThreadManagerV2.getUIHandlerV2().post(new QCircleRockeyPopupView.7(this, paramInt1, paramInt2));
      return;
    }
    catch (Exception localException)
    {
      QLog.i("QCircleRecommend_", 1, "playError " + localException.getMessage());
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleRockeyPopupView
 * JD-Core Version:    0.7.0.1
 */