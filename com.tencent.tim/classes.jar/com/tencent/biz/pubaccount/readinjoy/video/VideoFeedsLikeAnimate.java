package com.tencent.biz.pubaccount.readinjoy.video;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import mvk;
import mvl;
import wja;

public class VideoFeedsLikeAnimate
{
  private LikeExplosionCenterView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimate$LikeExplosionCenterView;
  private LikeExplosionView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimate$LikeExplosionView;
  private float jP;
  private float jQ;
  private ViewGroup mParentView;
  
  public VideoFeedsLikeAnimate(ViewGroup paramViewGroup, float paramFloat1, float paramFloat2, Random paramRandom)
  {
    this.mParentView = paramViewGroup;
    this.jP = paramFloat1;
    this.jQ = paramFloat2;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimate$LikeExplosionCenterView = new LikeExplosionCenterView(this.mParentView.getContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimate$LikeExplosionCenterView.setPivotX(this.jP);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimate$LikeExplosionCenterView.setPivotY(this.jQ);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimate$LikeExplosionCenterView.setDrawableId(2130843935);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimate$LikeExplosionView = new LikeExplosionView(this.mParentView.getContext(), paramRandom);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimate$LikeExplosionView.setAlpha(0.0F);
    this.mParentView.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimate$LikeExplosionView);
    this.mParentView.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimate$LikeExplosionCenterView);
  }
  
  public void a(Drawable[] paramArrayOfDrawable, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimate$LikeExplosionView.setIconExplosionEachDirection(paramArrayOfDrawable, paramInt1, paramInt2);
  }
  
  public void sC(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimate$LikeExplosionView.setExplosionEachDirection(paramInt);
  }
  
  public void startAnimate()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimate$LikeExplosionCenterView.startAnimate();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimate$LikeExplosionView.startAnimate();
  }
  
  public class LikeExplosionCenterView
    extends View
  {
    private Bitmap mBitmap;
    private Paint mPaint = new Paint();
    
    public LikeExplosionCenterView(Context paramContext)
    {
      super();
    }
    
    private void aSB()
    {
      setAlpha(0.0F);
      if (VideoFeedsLikeAnimate.a(VideoFeedsLikeAnimate.this) != null) {
        VideoFeedsLikeAnimate.a(VideoFeedsLikeAnimate.this).removeView(this);
      }
    }
    
    protected void onDraw(Canvas paramCanvas)
    {
      paramCanvas.drawBitmap(this.mBitmap, VideoFeedsLikeAnimate.a(VideoFeedsLikeAnimate.this) - this.mBitmap.getWidth() / 2, VideoFeedsLikeAnimate.b(VideoFeedsLikeAnimate.this) - this.mBitmap.getHeight() / 2, this.mPaint);
    }
    
    public void setBitmap(Bitmap paramBitmap)
    {
      this.mBitmap = paramBitmap;
    }
    
    public void setDrawableId(int paramInt)
    {
      this.mBitmap = BitmapFactory.decodeResource(getResources(), paramInt);
    }
    
    public void startAnimate()
    {
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.75F, 1.0F) }) });
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("scaleX", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.4F), Keyframe.ofFloat(0.75F, 1.0F), Keyframe.ofFloat(1.0F, 1.28F) }) });
      ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("scaleY", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.4F), Keyframe.ofFloat(0.75F, 1.0F), Keyframe.ofFloat(1.0F, 1.28F) }) });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.setDuration(400L);
      localObjectAnimator1.addListener(new mvk(this));
      localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3 });
      localAnimatorSet.start();
    }
  }
  
  public class LikeExplosionView
    extends View
  {
    private List<c> jE = new ArrayList();
    private float jR;
    private Matrix mMatrix = new Matrix();
    private Paint mPaint = new Paint();
    private Random mRandom;
    private long wS = 500L;
    
    public LikeExplosionView(Context paramContext, Random paramRandom)
    {
      super();
      this.mRandom = paramRandom;
    }
    
    private void endAnimation()
    {
      VideoFeedsLikeAnimate.a(VideoFeedsLikeAnimate.this).removeView(this);
    }
    
    protected void onDraw(Canvas paramCanvas)
    {
      if (this.jE != null)
      {
        Iterator localIterator = this.jE.iterator();
        while (localIterator.hasNext()) {
          ((c)localIterator.next()).onDraw(paramCanvas);
        }
      }
    }
    
    public void setExplosionEachDirection(int paramInt)
    {
      if (paramInt <= 0) {}
      do
      {
        for (;;)
        {
          return;
          int i = 0;
          while (i < 4)
          {
            int k = i * 90;
            int j = 0;
            for (;;)
            {
              if (j < paramInt) {}
              try
              {
                int m = (int)(this.mRandom.nextFloat() * ((i + 1) * 90 - k) + k);
                if (QLog.isColorLevel()) {
                  QLog.d("VideoFeedsLikeAnimate", 2, "setIconExplosionEachDirection, angele: " + m);
                }
                this.jE.add(new a(m));
                j += 1;
              }
              catch (Exception localException) {}
            }
            i += 1;
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("VideoFeedsLikeAnimate", 2, "setIconExplosionEachDirection: " + localException.getMessage());
    }
    
    public void setExplosionFraction(float paramFloat)
    {
      this.jR = paramFloat;
      Iterator localIterator = this.jE.iterator();
      while (localIterator.hasNext()) {
        ((c)localIterator.next()).setExplosionFraction(paramFloat);
      }
      invalidate();
    }
    
    public void setExplosionSize(int paramInt)
    {
      int i = 0;
      while (i < paramInt)
      {
        this.jE.add(new a());
        i += 1;
      }
    }
    
    public void setIconExplosion(Drawable[] paramArrayOfDrawable, int paramInt1, int paramInt2)
    {
      if ((paramArrayOfDrawable == null) || (paramArrayOfDrawable.length == 0) || (paramInt1 <= 0)) {}
      do
      {
        return;
        int[] arrayOfInt = new int[3];
        int[] tmp21_19 = arrayOfInt;
        tmp21_19[0] = -15;
        int[] tmp26_21 = tmp21_19;
        tmp26_21[1] = 0;
        int[] tmp30_26 = tmp26_21;
        tmp30_26[2] = 15;
        tmp30_26;
        int i = 0;
        while (i < paramInt1) {
          try
          {
            int j = this.mRandom.nextInt(paramArrayOfDrawable.length);
            int k = this.mRandom.nextInt(arrayOfInt.length);
            this.jE.add(new b(paramArrayOfDrawable[j], paramInt2, arrayOfInt[k]));
            i += 1;
          }
          catch (Exception paramArrayOfDrawable) {}
        }
      } while (!QLog.isColorLevel());
      QLog.d("VideoFeedsLikeAnimate", 2, "setIconExplosion: " + paramArrayOfDrawable.getMessage());
    }
    
    public void setIconExplosionEachDirection(Drawable[] paramArrayOfDrawable, int paramInt1, int paramInt2)
    {
      if ((paramArrayOfDrawable == null) || (paramArrayOfDrawable.length == 0) || (paramInt1 <= 0)) {
        return;
      }
      for (;;)
      {
        int[] arrayOfInt;
        int i;
        int j;
        int k;
        try
        {
          arrayOfInt = new int[3];
          int[] tmp21_19 = arrayOfInt;
          tmp21_19[0] = -15;
          int[] tmp26_21 = tmp21_19;
          tmp26_21[1] = 0;
          int[] tmp30_26 = tmp26_21;
          tmp30_26[2] = 15;
          tmp30_26;
          i = 0;
        }
        catch (Exception paramArrayOfDrawable) {}
        if (j < paramInt1)
        {
          int m = this.mRandom.nextInt(paramArrayOfDrawable.length);
          int n = this.mRandom.nextInt(arrayOfInt.length);
          int i1 = (int)(this.mRandom.nextFloat() * ((i + 1) * 90 - k) + k);
          if (QLog.isColorLevel()) {
            QLog.d("VideoFeedsLikeAnimate", 2, "angele: " + i1);
          }
          this.jE.add(new b(paramArrayOfDrawable[m], paramInt2, arrayOfInt[n], i1));
          j += 1;
        }
        else
        {
          i += 1;
          break label213;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("VideoFeedsLikeAnimate", 2, "setIconExplosionEachDirection: " + paramArrayOfDrawable.getMessage());
          return;
          label213:
          if (i >= 4) {
            break;
          }
          k = i * 90;
          j = 0;
        }
      }
    }
    
    public void startAnimate()
    {
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.12F, 1.0F), Keyframe.ofFloat(0.8F, 1.0F), Keyframe.ofFloat(1.0F, 0.0F) }) });
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this, "explosionFraction", new float[] { 0.0F, 1.0F });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localObjectAnimator2, localObjectAnimator1 });
      localAnimatorSet.setStartDelay(250L);
      localAnimatorSet.addListener(new mvl(this));
      localAnimatorSet.setDuration(this.wS);
      localAnimatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
      localAnimatorSet.start();
    }
    
    class a
      extends VideoFeedsLikeAnimate.LikeExplosionView.c
    {
      private float mRadius;
      
      public a()
      {
        super();
        init();
      }
      
      public a(int paramInt)
      {
        super();
        double d = Math.toRadians(paramInt);
        this.jV = ((float)Math.cos(d));
        this.jW = ((float)Math.sin(d));
        aSD();
        init();
      }
      
      private void init()
      {
        VideoFeedsLikeAnimate.LikeExplosionView.a(VideoFeedsLikeAnimate.LikeExplosionView.this).setColor(Color.parseColor("#E6FF4222"));
        VideoFeedsLikeAnimate.LikeExplosionView.a(VideoFeedsLikeAnimate.LikeExplosionView.this).setStyle(Paint.Style.FILL);
        this.mRadius = (VideoFeedsLikeAnimate.LikeExplosionView.a(VideoFeedsLikeAnimate.LikeExplosionView.this).nextFloat() * wja.dp2px(10.0F, VideoFeedsLikeAnimate.LikeExplosionView.this.getResources()) + wja.dp2px(4.5F, VideoFeedsLikeAnimate.LikeExplosionView.this.getResources()));
      }
      
      public void onDraw(Canvas paramCanvas)
      {
        paramCanvas.drawCircle(this.jU, this.ek, this.mRadius, VideoFeedsLikeAnimate.LikeExplosionView.a(VideoFeedsLikeAnimate.LikeExplosionView.this));
      }
    }
    
    class b
      extends VideoFeedsLikeAnimate.LikeExplosionView.c
    {
      private int OE;
      private Drawable mDrawable;
      private int mRotation;
      
      public b(Drawable paramDrawable, int paramInt1, int paramInt2)
      {
        super();
        this.mDrawable = paramDrawable;
        this.OE = paramInt1;
        this.mRotation = paramInt2;
      }
      
      public b(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3)
      {
        super();
        double d = Math.toRadians(paramInt3);
        this.jV = ((float)Math.cos(d));
        this.jW = ((float)Math.sin(d));
        aSD();
        this.mDrawable = paramDrawable;
        this.OE = paramInt1;
        this.mRotation = paramInt2;
      }
      
      public void onDraw(Canvas paramCanvas)
      {
        int i = (int)(this.jU - this.OE / 2);
        int j = (int)(this.ek - this.OE / 2);
        int k = this.OE;
        int m = this.OE;
        this.mDrawable.setBounds(i, j, k + i, m + j);
        VideoFeedsLikeAnimate.LikeExplosionView.a(VideoFeedsLikeAnimate.LikeExplosionView.this).reset();
        VideoFeedsLikeAnimate.LikeExplosionView.a(VideoFeedsLikeAnimate.LikeExplosionView.this).setRotate(this.mRotation, VideoFeedsLikeAnimate.a(VideoFeedsLikeAnimate.this), VideoFeedsLikeAnimate.b(VideoFeedsLikeAnimate.this));
        paramCanvas.setMatrix(VideoFeedsLikeAnimate.LikeExplosionView.a(VideoFeedsLikeAnimate.LikeExplosionView.this));
        this.mDrawable.draw(paramCanvas);
      }
    }
    
    class c
    {
      public int aUU = 360;
      public int aUV;
      public float ek;
      public float jS;
      public float jT;
      public float jU;
      public float jV;
      public float jW;
      public float jX = 0.8F;
      public float jY = 0.4F;
      
      public c()
      {
        prepare();
      }
      
      private void aSC()
      {
        if (this.aUV == this.aUU) {}
        for (int i = this.aUV;; i = VideoFeedsLikeAnimate.LikeExplosionView.a(VideoFeedsLikeAnimate.LikeExplosionView.this).nextInt() * (this.aUU - this.aUV) + this.aUV)
        {
          double d = Math.toRadians(i);
          this.jV = ((float)(0.9F * Math.cos(d)));
          this.jW = ((float)(0.9F * Math.sin(d)));
          return;
        }
      }
      
      private void prepare()
      {
        aSC();
        aSD();
      }
      
      protected void aSD()
      {
        this.jS = (VideoFeedsLikeAnimate.a(VideoFeedsLikeAnimate.this) - VideoFeedsLikeAnimate.a(VideoFeedsLikeAnimate.this).getWidth() / 2);
        this.jT = (VideoFeedsLikeAnimate.b(VideoFeedsLikeAnimate.this) - VideoFeedsLikeAnimate.a(VideoFeedsLikeAnimate.this).getHeight() / 2);
        this.jU = this.jS;
        this.ek = this.jT;
      }
      
      public void onDraw(Canvas paramCanvas) {}
      
      public void setExplosionFraction(float paramFloat)
      {
        this.jU = (this.jS + this.jV * (float)VideoFeedsLikeAnimate.LikeExplosionView.a(VideoFeedsLikeAnimate.LikeExplosionView.this) * paramFloat);
        this.ek = (this.jT + this.jW * (float)VideoFeedsLikeAnimate.LikeExplosionView.a(VideoFeedsLikeAnimate.LikeExplosionView.this) * paramFloat);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsLikeAnimate
 * JD-Core Version:    0.7.0.1
 */