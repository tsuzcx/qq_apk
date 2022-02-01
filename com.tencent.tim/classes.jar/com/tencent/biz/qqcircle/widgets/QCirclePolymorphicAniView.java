package com.tencent.biz.qqcircle.widgets;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import ankt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import ous;
import ozq;
import pgf;
import qqcircle.QQCircleFeedBase.StPolyLike;
import spe.d;

public class QCirclePolymorphicAniView
  extends FrameLayout
{
  private static final String TAG = "QCirclePolymorphicAniView";
  
  public QCirclePolymorphicAniView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCirclePolymorphicAniView(@NonNull Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCirclePolymorphicAniView(@NonNull Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private String fetchLocal(String paramString)
  {
    paramString = ozq.a().aY(paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new File(paramString);
      if (paramString.isDirectory())
      {
        paramString = paramString.listFiles();
        if ((paramString != null) && (paramString.length > 0))
        {
          int j = paramString.length;
          int i = 0;
          while (i < j)
          {
            String str = paramString[i].getAbsolutePath();
            if (str.endsWith("000.png")) {
              return str;
            }
            i += 1;
          }
        }
      }
    }
    return "";
  }
  
  public void startZanAni(QCirclePolymorphicLikePopWindow.a parama, View paramView1, View paramView2, int[] paramArrayOfInt, boolean paramBoolean, spe.d paramd)
  {
    Object localObject3;
    Object localObject1;
    Object localObject2;
    PointF localPointF1;
    PointF localPointF2;
    if ((parama != null) && (parama.a() != null) && (paramArrayOfInt != null) && (paramView1 != null) && (paramView2 != null))
    {
      setVisibility(0);
      localObject3 = new int[2];
      localObject1 = new int[2];
      paramView1.getLocationInWindow((int[])localObject3);
      getLocationOnScreen((int[])localObject1);
      paramArrayOfInt[1] -= QCirclePolymorphicLikePopWindow.biy / 2;
      localObject2 = new PointF();
      localPointF1 = new PointF();
      localPointF2 = new PointF();
      ((PointF)localObject2).x = paramArrayOfInt[0];
      ((PointF)localObject2).y = paramArrayOfInt[1];
      if (!paramBoolean) {
        break label593;
      }
      localPointF1.x = (localObject3[0] - ankt.dip2px(7.5F));
    }
    for (localPointF1.y = (localObject3[1] - ankt.dip2px(7.5F));; localPointF1.y = localObject3[1])
    {
      localPointF2.x = ((localPointF1.x + ((PointF)localObject2).x) / 2.0F);
      localPointF2.y = (((PointF)localObject2).y - ankt.dip2px(150.0F));
      QLog.d("QCirclePolymorphicAniView", 1, "start pos:" + ((PointF)localObject2).x + " " + ((PointF)localObject2).y + "  control pos:" + localPointF2.x + " " + localPointF2.y + " edn pos:" + localPointF1.x + " " + localPointF1.y + "aniPanel:" + getWidth() + " " + getHeight());
      paramView1 = new MovingImg(getContext());
      paramView1.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130844799);
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = parama.a().getWidth();
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = parama.a().getHeight();
      ous.a(fetchLocal(parama.a().polySource.get()), paramView1, (URLDrawable.URLDrawableOptions)localObject3, true);
      paramView1.setTopShift(localObject1[1]);
      paramView1.setX(paramArrayOfInt[0]);
      paramView1.setY(paramArrayOfInt[1] - localObject1[1]);
      addView(paramView1, new FrameLayout.LayoutParams(parama.a().getWidth(), parama.a().getHeight()));
      paramArrayOfInt = ObjectAnimator.ofObject(paramView1, "mPointF", new a(localPointF2), new Object[] { localObject2, localPointF1 });
      localObject1 = ObjectAnimator.ofObject(paramView1, "mScale", new a(new PointF(0.88F, 1.0F)), new Object[] { new PointF(1.0F, 1.0F), new PointF(0.0F, 0.0F) });
      localObject2 = new AnimatorSet();
      ((AnimatorSet)localObject2).playTogether(new Animator[] { paramArrayOfInt, localObject1 });
      ((AnimatorSet)localObject2).setDuration(300L);
      ((AnimatorSet)localObject2).start();
      ((AnimatorSet)localObject2).addListener(new pgf(this, paramd, paramView2, paramView1, parama));
      return;
      label593:
      localPointF1.x = localObject3[0];
    }
  }
  
  public static class MovingImg
    extends URLImageView
  {
    private int mTopShift;
    
    public MovingImg(Context paramContext)
    {
      super();
    }
    
    public void setMPointF(PointF paramPointF)
    {
      setX(paramPointF.x);
      setY(paramPointF.y - this.mTopShift);
      QLog.d("QCirclePolymorphicAniView", 4, "compute end:" + paramPointF.y);
    }
    
    public void setMScale(PointF paramPointF)
    {
      if (paramPointF.y >= 0.0F)
      {
        setScaleX(paramPointF.y);
        setScaleY(paramPointF.y);
      }
      QLog.d("QCirclePolymorphicAniView", 4, "scale y:" + paramPointF.y);
    }
    
    public void setTopShift(int paramInt)
    {
      this.mTopShift = paramInt;
    }
  }
  
  public class a
    implements TypeEvaluator<PointF>
  {
    PointF R;
    PointF mPointF = new PointF();
    
    public a(PointF paramPointF)
    {
      this.R = paramPointF;
    }
    
    private PointF a(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, float paramFloat)
    {
      this.mPointF.x = ((1.0F - paramFloat) * (1.0F - paramFloat) * paramPointF1.x + 2.0F * paramFloat * (1.0F - paramFloat) * paramPointF3.x + paramFloat * paramFloat * paramPointF2.x);
      this.mPointF.y = ((1.0F - paramFloat) * (1.0F - paramFloat) * paramPointF1.y + 2.0F * paramFloat * (1.0F - paramFloat) * paramPointF3.y + paramFloat * paramFloat * paramPointF2.y);
      return this.mPointF;
    }
    
    public PointF evaluate(float paramFloat, PointF paramPointF1, PointF paramPointF2)
    {
      return a(paramPointF1, paramPointF2, this.R, paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePolymorphicAniView
 * JD-Core Version:    0.7.0.1
 */