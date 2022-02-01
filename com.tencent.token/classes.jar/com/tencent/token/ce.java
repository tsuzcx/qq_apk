package com.tencent.token;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public final class ce
  extends cj
  implements cd
{
  final Drawable.Callback a = new Drawable.Callback()
  {
    public final void invalidateDrawable(Drawable paramAnonymousDrawable)
    {
      ce.this.invalidateSelf();
    }
    
    public final void scheduleDrawable(Drawable paramAnonymousDrawable, Runnable paramAnonymousRunnable, long paramAnonymousLong)
    {
      ce.this.scheduleSelf(paramAnonymousRunnable, paramAnonymousLong);
    }
    
    public final void unscheduleDrawable(Drawable paramAnonymousDrawable, Runnable paramAnonymousRunnable)
    {
      ce.this.unscheduleSelf(paramAnonymousRunnable);
    }
  };
  private a c;
  private Context d;
  private ArgbEvaluator e = null;
  private Animator.AnimatorListener f = null;
  private ArrayList<Object> g = null;
  
  ce()
  {
    this(null, (byte)0);
  }
  
  private ce(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private ce(Context paramContext, byte paramByte)
  {
    this.d = paramContext;
    this.c = new a();
  }
  
  public static ce a(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    paramContext = new ce(paramContext);
    paramContext.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return paramContext;
  }
  
  private void a(Animator paramAnimator)
  {
    Object localObject;
    if ((paramAnimator instanceof AnimatorSet))
    {
      localObject = ((AnimatorSet)paramAnimator).getChildAnimations();
      if (localObject != null)
      {
        int i = 0;
        while (i < ((List)localObject).size())
        {
          a((Animator)((List)localObject).get(i));
          i += 1;
        }
      }
    }
    if ((paramAnimator instanceof ObjectAnimator))
    {
      paramAnimator = (ObjectAnimator)paramAnimator;
      localObject = paramAnimator.getPropertyName();
      if (("fillColor".equals(localObject)) || ("strokeColor".equals(localObject)))
      {
        if (this.e == null) {
          this.e = new ArgbEvaluator();
        }
        paramAnimator.setEvaluator(this.e);
      }
    }
  }
  
  public final void applyTheme(Resources.Theme paramTheme)
  {
    if (this.b != null)
    {
      dy.a(this.b, paramTheme);
      return;
    }
  }
  
  public final boolean canApplyTheme()
  {
    if (this.b != null) {
      return dy.c(this.b);
    }
    return false;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (this.b != null)
    {
      this.b.draw(paramCanvas);
      return;
    }
    this.c.b.draw(paramCanvas);
    if (this.c.c.isStarted()) {
      invalidateSelf();
    }
  }
  
  public final int getAlpha()
  {
    if (this.b != null) {
      return dy.b(this.b);
    }
    return this.c.b.getAlpha();
  }
  
  public final int getChangingConfigurations()
  {
    if (this.b != null) {
      return this.b.getChangingConfigurations();
    }
    return super.getChangingConfigurations() | this.c.a;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if ((this.b != null) && (Build.VERSION.SDK_INT >= 24)) {
      return new b(this.b.getConstantState());
    }
    return null;
  }
  
  public final int getIntrinsicHeight()
  {
    if (this.b != null) {
      return this.b.getIntrinsicHeight();
    }
    return this.c.b.getIntrinsicHeight();
  }
  
  public final int getIntrinsicWidth()
  {
    if (this.b != null) {
      return this.b.getIntrinsicWidth();
    }
    return this.c.b.getIntrinsicWidth();
  }
  
  public final int getOpacity()
  {
    if (this.b != null) {
      return this.b.getOpacity();
    }
    return this.c.b.getOpacity();
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    if (this.b != null)
    {
      dy.a(this.b, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    int i = paramXmlPullParser.getEventType();
    int j = paramXmlPullParser.getDepth();
    while ((i != 1) && ((paramXmlPullParser.getDepth() >= j + 1) || (i != 3)))
    {
      if (i == 2)
      {
        Object localObject1 = paramXmlPullParser.getName();
        Object localObject2;
        if ("animated-vector".equals(localObject1))
        {
          localObject1 = dp.a(paramResources, paramTheme, paramAttributeSet, cc.e);
          i = ((TypedArray)localObject1).getResourceId(0, 0);
          if (i != 0)
          {
            localObject2 = ck.a(paramResources, i, paramTheme);
            ((ck)localObject2).d = false;
            ((ck)localObject2).setCallback(this.a);
            if (this.c.b != null) {
              this.c.b.setCallback(null);
            }
            this.c.b = ((ck)localObject2);
          }
          ((TypedArray)localObject1).recycle();
        }
        else if ("target".equals(localObject1))
        {
          localObject2 = paramResources.obtainAttributes(paramAttributeSet, cc.f);
          String str = ((TypedArray)localObject2).getString(0);
          i = ((TypedArray)localObject2).getResourceId(1, 0);
          if (i != 0)
          {
            localObject1 = this.d;
            if (localObject1 != null)
            {
              if (Build.VERSION.SDK_INT >= 24) {
                localObject1 = AnimatorInflater.loadAnimator((Context)localObject1, i);
              } else {
                localObject1 = cg.a((Context)localObject1, ((Context)localObject1).getResources(), ((Context)localObject1).getTheme(), i);
              }
              ((Animator)localObject1).setTarget(this.c.b.c.b.h.get(str));
              if (Build.VERSION.SDK_INT < 21) {
                a((Animator)localObject1);
              }
              if (a.a(this.c) == null)
              {
                a.a(this.c, new ArrayList());
                this.c.e = new em();
              }
              a.a(this.c).add(localObject1);
              this.c.e.put(localObject1, str);
            }
            else
            {
              ((TypedArray)localObject2).recycle();
              throw new IllegalStateException("Context can't be null when inflating animators");
            }
          }
          ((TypedArray)localObject2).recycle();
        }
      }
      i = paramXmlPullParser.next();
    }
    paramResources = this.c;
    if (paramResources.c == null) {
      paramResources.c = new AnimatorSet();
    }
    paramResources.c.playTogether(paramResources.d);
  }
  
  public final boolean isAutoMirrored()
  {
    if (this.b != null) {
      return dy.a(this.b);
    }
    return this.c.b.isAutoMirrored();
  }
  
  public final boolean isRunning()
  {
    if (this.b != null) {
      return ((AnimatedVectorDrawable)this.b).isRunning();
    }
    return this.c.c.isRunning();
  }
  
  public final boolean isStateful()
  {
    if (this.b != null) {
      return this.b.isStateful();
    }
    return this.c.b.isStateful();
  }
  
  public final Drawable mutate()
  {
    if (this.b != null) {
      this.b.mutate();
    }
    return this;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    if (this.b != null)
    {
      this.b.setBounds(paramRect);
      return;
    }
    this.c.b.setBounds(paramRect);
  }
  
  protected final boolean onLevelChange(int paramInt)
  {
    if (this.b != null) {
      return this.b.setLevel(paramInt);
    }
    return this.c.b.setLevel(paramInt);
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.b != null) {
      return this.b.setState(paramArrayOfInt);
    }
    return this.c.b.setState(paramArrayOfInt);
  }
  
  public final void setAlpha(int paramInt)
  {
    if (this.b != null)
    {
      this.b.setAlpha(paramInt);
      return;
    }
    this.c.b.setAlpha(paramInt);
  }
  
  public final void setAutoMirrored(boolean paramBoolean)
  {
    if (this.b != null)
    {
      dy.a(this.b, paramBoolean);
      return;
    }
    this.c.b.setAutoMirrored(paramBoolean);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.b != null)
    {
      this.b.setColorFilter(paramColorFilter);
      return;
    }
    this.c.b.setColorFilter(paramColorFilter);
  }
  
  public final void setTint(int paramInt)
  {
    if (this.b != null)
    {
      dy.a(this.b, paramInt);
      return;
    }
    this.c.b.setTint(paramInt);
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    if (this.b != null)
    {
      dy.a(this.b, paramColorStateList);
      return;
    }
    this.c.b.setTintList(paramColorStateList);
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    if (this.b != null)
    {
      dy.a(this.b, paramMode);
      return;
    }
    this.c.b.setTintMode(paramMode);
  }
  
  public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.b != null) {
      return this.b.setVisible(paramBoolean1, paramBoolean2);
    }
    this.c.b.setVisible(paramBoolean1, paramBoolean2);
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public final void start()
  {
    if (this.b != null)
    {
      ((AnimatedVectorDrawable)this.b).start();
      return;
    }
    if (this.c.c.isStarted()) {
      return;
    }
    this.c.c.start();
    invalidateSelf();
  }
  
  public final void stop()
  {
    if (this.b != null)
    {
      ((AnimatedVectorDrawable)this.b).stop();
      return;
    }
    this.c.c.end();
  }
  
  static final class a
    extends Drawable.ConstantState
  {
    int a;
    ck b;
    AnimatorSet c;
    ArrayList<Animator> d;
    em<Animator, String> e;
    
    public final int getChangingConfigurations()
    {
      return this.a;
    }
    
    public final Drawable newDrawable()
    {
      throw new IllegalStateException("No constant state support for SDK < 24.");
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      throw new IllegalStateException("No constant state support for SDK < 24.");
    }
  }
  
  static final class b
    extends Drawable.ConstantState
  {
    private final Drawable.ConstantState a;
    
    public b(Drawable.ConstantState paramConstantState)
    {
      this.a = paramConstantState;
    }
    
    public final boolean canApplyTheme()
    {
      return this.a.canApplyTheme();
    }
    
    public final int getChangingConfigurations()
    {
      return this.a.getChangingConfigurations();
    }
    
    public final Drawable newDrawable()
    {
      ce localce = new ce();
      localce.b = this.a.newDrawable();
      localce.b.setCallback(localce.a);
      return localce;
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      ce localce = new ce();
      localce.b = this.a.newDrawable(paramResources);
      localce.b.setCallback(localce.a);
      return localce;
    }
    
    public final Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      ce localce = new ce();
      localce.b = this.a.newDrawable(paramResources, paramTheme);
      localce.b.setCallback(localce.a);
      return localce;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ce
 * JD-Core Version:    0.7.0.1
 */