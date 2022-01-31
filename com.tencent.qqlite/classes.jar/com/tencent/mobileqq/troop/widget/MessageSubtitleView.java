package com.tencent.mobileqq.troop.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils.TruncateAt;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.util.VersionUtils;
import epx;
import epy;
import epz;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MessageSubtitleView
  extends LinearLayout
{
  protected static final float a = 3.0F;
  protected static final int a = 18;
  protected static final float b = 3.0F;
  protected static final int b = 1;
  protected static final float c = 3.0F;
  protected static final int c = 200;
  protected static final float d = 0.2F;
  protected static final int d = 8000;
  protected static final int e = 3;
  public static final int j = 0;
  public static final int k = 1;
  public static final int l = 2;
  public static final int m = 3;
  public static final int n = 4;
  Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new epz(this);
  AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  protected LinearLayout a;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new epx(this);
  String jdField_a_of_type_JavaLangString = null;
  protected ArrayList a;
  public Queue a;
  boolean jdField_a_of_type_Boolean = false;
  AlphaAnimation jdField_b_of_type_AndroidViewAnimationAlphaAnimation;
  AnimationSet jdField_b_of_type_AndroidViewAnimationAnimationSet;
  private final Runnable jdField_b_of_type_JavaLangRunnable = new epy(this);
  boolean jdField_b_of_type_Boolean = false;
  int f = 0;
  int g = 0;
  int h = 0;
  int i = 0;
  
  public MessageSubtitleView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    a(paramContext);
  }
  
  public MessageSubtitleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    a(paramContext);
  }
  
  @TargetApi(11)
  private void a()
  {
    if (!a())
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 200L);
    }
    CharSequence localCharSequence;
    do
    {
      return;
      localCharSequence = (CharSequence)this.jdField_a_of_type_JavaUtilQueue.poll();
    } while (localCharSequence == null);
    if ((this.i > 0) && (this.jdField_a_of_type_Boolean))
    {
      int i1 = 1;
      while (i1 < this.i + 1)
      {
        ((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(i1 - 1)).setText(((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).getText());
        ((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(i1 - 1)).setContentDescription(((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).getText());
        ((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(i1 - 1)).setTag(((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).getTag());
        if (VersionUtils.e()) {
          ((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(i1 - 1)).setAlpha(1.0F);
        }
        i1 += 1;
      }
      if (this.i > 0)
      {
        ((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(this.i)).setText("");
        ((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(this.i)).setTag(Long.valueOf(0L));
      }
      this.jdField_a_of_type_Boolean = false;
    }
    if (this.i < 3)
    {
      ((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(this.i)).setText(localCharSequence);
      ((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(this.i)).setContentDescription(localCharSequence);
      ((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(this.i)).setTag(Long.valueOf(System.currentTimeMillis()));
      if (this.i == 0)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 8000L);
      }
      this.jdField_b_of_type_Boolean = true;
      this.i += 1;
      return;
    }
    ((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(3)).setText(localCharSequence);
    ((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(3)).setContentDescription(localCharSequence);
    ((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(3)).setTag(Long.valueOf(System.currentTimeMillis()));
    a(0, 4, 3, 3);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    if (((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(1)).getTag() != null) {}
    for (long l1 = System.currentTimeMillis() - ((Long)((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(1)).getTag()).longValue();; l1 = 0L)
    {
      l1 = 8000L - l1;
      if (l1 > 0L)
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, l1);
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 1000L);
      return;
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      return;
    case 0: 
      ((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1)).startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
      return;
    case 3: 
      ((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1)).startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
      return;
    case 4: 
      ((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1)).startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimationSet);
      return;
    case 1: 
      ((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1)).startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
      return;
    }
    ((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1)).startAnimation(this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramInt1, paramInt2);
    if (paramInt3 > paramInt1)
    {
      paramInt1 += 1;
      while (paramInt1 < paramInt3)
      {
        a(paramInt1, 0);
        paramInt1 += 1;
      }
      a(paramInt3, paramInt4);
    }
  }
  
  private boolean a()
  {
    return ((!this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.hasStarted()) || (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.hasEnded())) && ((!this.jdField_a_of_type_AndroidViewAnimationAnimationSet.hasStarted()) || (this.jdField_a_of_type_AndroidViewAnimationAnimationSet.hasEnded())) && ((!this.jdField_b_of_type_AndroidViewAnimationAnimationSet.hasStarted()) || (this.jdField_b_of_type_AndroidViewAnimationAnimationSet.hasEnded())) && ((!this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.hasStarted()) || (this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.hasEnded())) && ((!this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.hasStarted()) || (this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.hasEnded()));
  }
  
  private boolean a(Animation paramAnimation)
  {
    return ((paramAnimation == this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation) || (!this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.hasStarted()) || (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.hasEnded())) && ((paramAnimation == this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation) || (!this.jdField_a_of_type_AndroidViewAnimationAnimationSet.hasStarted()) || (this.jdField_a_of_type_AndroidViewAnimationAnimationSet.hasEnded())) && ((paramAnimation == this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation) || (!this.jdField_b_of_type_AndroidViewAnimationAnimationSet.hasStarted()) || (this.jdField_b_of_type_AndroidViewAnimationAnimationSet.hasEnded())) && ((paramAnimation == this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation) || (!this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.hasStarted()) || (this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.hasEnded())) && ((paramAnimation == this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation) || (!this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.hasStarted()) || (this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.hasEnded()));
  }
  
  @TargetApi(11)
  private void b()
  {
    if (!a())
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 200L);
    }
    while (this.i <= 0) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      int i1 = 1;
      while (i1 < this.i + 1)
      {
        ((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(i1 - 1)).setText(((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).getText());
        ((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(i1 - 1)).setContentDescription(((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).getText());
        ((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(i1 - 1)).setTag(((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).getTag());
        if (VersionUtils.e()) {
          ((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(i1 - 1)).setAlpha(1.0F);
        }
        i1 += 1;
      }
      if (this.i > 0)
      {
        ((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(this.i)).setText("");
        ((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(this.i)).setTag(Long.valueOf(0L));
      }
      this.jdField_a_of_type_Boolean = false;
    }
    this.i -= 1;
    a(0, 4, 3, 0);
    if (this.i > 0)
    {
      this.jdField_a_of_type_Boolean = true;
      label262:
      if (this.i <= 0) {
        break label354;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      if (((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(1)).getTag() == null) {
        break label372;
      }
    }
    label354:
    label372:
    for (long l1 = System.currentTimeMillis() - ((Long)((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(1)).getTag()).longValue();; l1 = 0L)
    {
      l1 = 8000L - l1;
      if (l1 > 0L)
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, l1);
        return;
        this.jdField_a_of_type_Boolean = false;
        break label262;
        break;
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 1000L);
      return;
    }
  }
  
  void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903316, this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296566));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidContentContext.getMainLooper());
    int i1 = 0;
    while (i1 < 4)
    {
      TextView localTextView = new TextView(paramContext);
      localTextView.setShadowLayer(3.0F, 3.0F, 3.0F, 2131427334);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setSingleLine(true);
      localTextView.setTextSize(18.0F);
      localTextView.setTextColor(-1);
      localTextView.setTag(Long.valueOf(0L));
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramContext.getResources().getDimensionPixelSize(2131493064), paramContext.getResources().getDimensionPixelSize(2131493066));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localTextView, localLayoutParams);
      this.jdField_a_of_type_JavaUtilArrayList.add(localTextView);
      i1 += 1;
    }
    this.h = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493066);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(200L);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setInterpolator(new AccelerateInterpolator(0.2F));
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setDuration(200L);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setInterpolator(new AccelerateInterpolator(0.2F));
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.h * -1);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(200L);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setInterpolator(new AccelerateInterpolator(0.2F));
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet = new AnimationSet(true);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setDuration(200L);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_b_of_type_AndroidViewAnimationAnimationSet = new AnimationSet(true);
    this.jdField_b_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_b_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation);
    this.jdField_b_of_type_AndroidViewAnimationAnimationSet.setDuration(200L);
    this.jdField_b_of_type_AndroidViewAnimationAnimationSet.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewAnimationAnimationSet.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
  }
  
  public void a(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    Object localObject = paramCharSequence1.toString();
    paramCharSequence1 = (CharSequence)localObject;
    if (localObject != null)
    {
      paramCharSequence1 = (CharSequence)localObject;
      if (((String)localObject).length() > 12) {
        paramCharSequence1 = ((String)localObject).substring(0, 11) + "...";
      }
    }
    localObject = new SpannableStringBuilder(paramCharSequence2);
    int i3 = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131427404);
    int i2 = paramCharSequence1.length() + 1;
    int i1 = i2;
    if (i2 > paramCharSequence2.length()) {
      i1 = paramCharSequence2.length();
    }
    ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(i3), 0, i1, 33);
    this.jdField_a_of_type_JavaUtilQueue.add(localObject);
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.MessageSubtitleView
 * JD-Core Version:    0.7.0.1
 */