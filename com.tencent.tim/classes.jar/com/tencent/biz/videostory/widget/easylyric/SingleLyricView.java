package com.tencent.biz.videostory.widget.easylyric;

import aiwn;
import aiwp;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import atau.a;
import com.tencent.mobileqq.app.ThreadManager;
import sra;
import srb;
import src;
import srd;
import srf;
import srg;
import srh;
import sri;
import srj;
import srk;
import srl;

public class SingleLyricView
  extends RelativeLayout
  implements sra
{
  private long Dm;
  private final String TAG = "SingleLyricView";
  private volatile aiwn jdField_a_of_type_Aiwn;
  private aiwp jdField_a_of_type_Aiwp;
  private final srb jdField_a_of_type_Srb;
  private final srd jdField_a_of_type_Srd;
  private String aFZ;
  private boolean aMC;
  private int byJ;
  private int jdField_if;
  private AnimatorSet mAnimatorSet;
  private String mCurrentText;
  private Handler mDataHandler;
  private long mStartPos;
  private TextView mTextView;
  private ImageView oF;
  
  public SingleLyricView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SingleLyricView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SingleLyricView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131563310, this, true);
    a(paramAttributeSet, paramInt);
    this.oF = ((ImageView)findViewById(2131378451));
    if (this.byJ == 1)
    {
      this.mTextView = ((TextView)findViewById(2131378452));
      if (this.mTextView != null) {
        this.mTextView.setVisibility(0);
      }
      if (this.oF != null) {
        this.oF.setVisibility(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Srb = new srb();
      this.jdField_a_of_type_Srd = new srf(this);
      this.mDataHandler = new Handler(ThreadManager.getSubThreadLooper());
      return;
      this.mTextView = ((TextView)findViewById(2131378925));
      if (this.mTextView != null) {
        this.mTextView.setVisibility(0);
      }
      if (this.oF != null) {
        this.oF.setVisibility(8);
      }
    }
  }
  
  private void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, atau.a.sg, paramInt, 0);
    try
    {
      this.byJ = paramAttributeSet.getInteger(0, 1);
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  private void ty(String paramString)
  {
    if (this.mAnimatorSet != null) {
      this.mAnimatorSet.end();
    }
    this.mAnimatorSet = new AnimatorSet();
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.3F });
    localValueAnimator.setDuration(500L);
    localValueAnimator.setInterpolator(new AccelerateInterpolator());
    localValueAnimator.addUpdateListener(new srg(this));
    localValueAnimator.addListener(new srh(this, paramString));
    paramString = ValueAnimator.ofFloat(new float[] { 0.3F, 1.0F });
    paramString.setDuration(500L);
    paramString.addUpdateListener(new sri(this));
    paramString.addListener(new srj(this));
    paramString.setInterpolator(new DecelerateInterpolator());
    paramString.addListener(new srk(this));
    this.mAnimatorSet.playSequentially(new Animator[] { localValueAnimator, paramString });
    this.mAnimatorSet.start();
  }
  
  public void clear()
  {
    this.mDataHandler.removeCallbacks(null);
    this.jdField_if = -1;
    this.jdField_a_of_type_Aiwn = null;
    if (this.mTextView != null)
    {
      this.mTextView.setText("");
      this.mTextView.setAlpha(1.0F);
    }
    if (this.mAnimatorSet != null) {
      this.mAnimatorSet.cancel();
    }
    this.aFZ = null;
    this.mStartPos = 0L;
  }
  
  public void ft(long paramLong)
  {
    int j = 1;
    if (this.jdField_a_of_type_Aiwn == null) {}
    label100:
    label106:
    do
    {
      return;
      aiwp localaiwp = src.a().a(this.jdField_a_of_type_Aiwn, this.mStartPos + paramLong);
      int i;
      if (this.jdField_a_of_type_Aiwp != localaiwp)
      {
        i = 1;
        if ((!this.aMC) || (paramLong >= this.Dm)) {
          break label100;
        }
      }
      for (;;)
      {
        if ((localaiwp == null) || (i == 0) || (j != 0)) {
          break label106;
        }
        this.jdField_a_of_type_Aiwp = localaiwp;
        ty(localaiwp.mText);
        this.mCurrentText = localaiwp.mText;
        return;
        i = 0;
        break;
        j = 0;
      }
    } while ((j == 0) || (TextUtils.isEmpty(this.aFZ)) || (this.aFZ.equals(this.mCurrentText)) || (this.mTextView == null));
    this.mTextView.setText(this.aFZ);
    this.mCurrentText = this.aFZ;
    this.jdField_a_of_type_Aiwp = null;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_a_of_type_Srb.a(this);
    srl.a().a(this.jdField_a_of_type_Srd);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    srl.a().b(this.jdField_a_of_type_Srd);
    this.jdField_a_of_type_Srb.detachView();
    if (this.mAnimatorSet != null) {
      this.mAnimatorSet.cancel();
    }
    this.mDataHandler.removeCallbacks(null);
  }
  
  public void setData(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Aiwn = null;
    this.mDataHandler.post(new SingleLyricView.7(this, paramString1, paramString2));
    this.mStartPos = 0L;
  }
  
  public void setPos(long paramLong)
  {
    if (paramLong >= 0L) {}
    for (;;)
    {
      this.mStartPos = paramLong;
      return;
      paramLong = 0L;
    }
  }
  
  public void setSongName(String paramString, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.aFZ = paramString;
      if (this.mTextView != null)
      {
        this.mTextView.setAlpha(1.0F);
        this.mTextView.setText(paramString);
      }
      this.aMC = true;
      if (paramLong < 0L) {
        break label52;
      }
    }
    for (;;)
    {
      this.Dm = paramLong;
      return;
      label52:
      paramLong = 3000L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.easylyric.SingleLyricView
 * JD-Core Version:    0.7.0.1
 */