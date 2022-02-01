package com.tencent.mobileqq.troop.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

@TargetApi(11)
public class MessageSubtitleView
  extends RelativeLayout
{
  protected static int dWX = 1;
  protected static int dWY = 2;
  protected static int dWZ = 3;
  protected ArrayList<TextView> Cw = new ArrayList(4);
  protected Queue<CharSequence> M = new LinkedList();
  private final Runnable hM = new MessageSubtitleView.1(this);
  private final Runnable hN = new MessageSubtitleView.2(this);
  private Handler handler;
  int offset = 0;
  
  public MessageSubtitleView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public MessageSubtitleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private AnimatorSet a(TextView paramTextView)
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(a(paramTextView)).with(b(paramTextView));
    return localAnimatorSet;
  }
  
  private ObjectAnimator a(TextView paramTextView)
  {
    paramTextView = ObjectAnimator.ofFloat(paramTextView, "alpha", new float[] { 0.0F, 1.0F });
    paramTextView.setDuration(200L);
    return paramTextView;
  }
  
  private ObjectAnimator b(TextView paramTextView)
  {
    paramTextView = ObjectAnimator.ofFloat(paramTextView, "translationY", new float[] { paramTextView.getTranslationY(), paramTextView.getTranslationY() - this.offset });
    paramTextView.setDuration(200L);
    return paramTextView;
  }
  
  private void ece()
  {
    if (this.Cw.size() > 3)
    {
      this.handler.removeCallbacks(this.hN);
      ecf();
    }
    do
    {
      return;
      if (this.Cw.size() == 3)
      {
        this.handler.removeCallbacks(this.hN);
        ecf();
      }
      ecg();
    } while (this.Cw.size() != 1);
    this.handler.removeCallbacks(this.hN);
    this.handler.postDelayed(this.hN, 8000L);
  }
  
  private void ecf()
  {
    if ((this.Cw != null) && (this.Cw.size() != 0))
    {
      int i = 0;
      while (i < this.Cw.size())
      {
        kc(i, dWY);
        i += 1;
      }
    }
  }
  
  private void kc(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= this.Cw.size())) {}
    label135:
    for (;;)
    {
      return;
      Object localObject = (TextView)this.Cw.get(paramInt1);
      boolean bool;
      if (paramInt1 == 0)
      {
        bool = true;
        if (paramInt2 != dWX) {
          break label95;
        }
        localObject = a((TextView)localObject);
      }
      for (;;)
      {
        if (localObject == null) {
          break label135;
        }
        ((Animator)localObject).setInterpolator(new AccelerateInterpolator(0.2F));
        ((Animator)localObject).addListener(new a(bool, paramInt2));
        ((Animator)localObject).start();
        return;
        bool = false;
        break;
        label95:
        if (paramInt2 == dWY) {
          localObject = b((TextView)localObject);
        } else if (paramInt2 == dWZ) {
          localObject = a((TextView)localObject);
        } else {
          localObject = null;
        }
      }
    }
  }
  
  public void ecg()
  {
    if ((!this.M.isEmpty()) && (this.Cw.size() <= 3))
    {
      Object localObject = getContext();
      CharSequence localCharSequence = (CharSequence)this.M.poll();
      TextView localTextView = new TextView((Context)localObject);
      localTextView.setShadowLayer(3.0F, 3.0F, 3.0F, 2131165679);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setSingleLine(true);
      localTextView.setTextSize(18.0F);
      localTextView.setTextColor(-1);
      localTextView.setTag(Long.valueOf(System.currentTimeMillis()));
      localTextView.setTranslationY(0.0F);
      localTextView.setText(localCharSequence);
      localObject = new RelativeLayout.LayoutParams(((Context)localObject).getResources().getDimensionPixelSize(2131299536), ((Context)localObject).getResources().getDimensionPixelSize(2131299534));
      ((RelativeLayout.LayoutParams)localObject).topMargin = (this.Cw.size() * this.offset);
      addView(localTextView, (ViewGroup.LayoutParams)localObject);
      this.Cw.add(localTextView);
      if (this.Cw.size() == 4) {
        kc(this.Cw.size() - 1, dWX);
      }
    }
    else
    {
      return;
    }
    kc(this.Cw.size() - 1, dWZ);
  }
  
  public void ech()
  {
    if ((this.Cw == null) || (this.Cw.size() == 0)) {
      return;
    }
    int i = 0;
    label20:
    float f;
    int j;
    if (i < this.Cw.size())
    {
      TextView localTextView = (TextView)this.Cw.get(i);
      f = localTextView.getY();
      if (f >= 0.0F) {
        break label83;
      }
      removeView(localTextView);
      this.Cw.remove(localTextView);
      j = i - 1;
    }
    for (;;)
    {
      i = j + 1;
      break label20;
      break;
      label83:
      j = i;
      if (f == 0.0F)
      {
        long l2 = 8200L - (System.currentTimeMillis() - ((Long)((TextView)this.Cw.get(0)).getTag()).longValue());
        long l1 = l2;
        if (l2 <= 0L) {
          l1 = 1000L;
        }
        this.handler.removeCallbacks(this.hN);
        this.handler.postDelayed(this.hN, l1);
        j = i;
      }
    }
  }
  
  void init(Context paramContext)
  {
    this.handler = new Handler(paramContext.getMainLooper());
    this.offset = paramContext.getResources().getDimensionPixelSize(2131299534);
  }
  
  class a
    implements Animator.AnimatorListener
  {
    boolean cSz = false;
    int type;
    
    public a(boolean paramBoolean, int paramInt)
    {
      this.cSz = paramBoolean;
      this.type = paramInt;
    }
    
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (this.cSz)
      {
        if (this.type == MessageSubtitleView.dWY) {
          MessageSubtitleView.this.ech();
        }
        if (!MessageSubtitleView.this.M.isEmpty()) {
          MessageSubtitleView.a(MessageSubtitleView.this);
        }
      }
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.MessageSubtitleView
 * JD-Core Version:    0.7.0.1
 */