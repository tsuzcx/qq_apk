package com.tencent.mobileqq.activity.aio.anim;

import adxq;
import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Transformation;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ListView;
import ram;
import rom;
import wni.a;
import wnj;
import wnq;

public class AIOAnimationConatiner
  extends ViewGroup
  implements View.OnLayoutChangeListener
{
  public static ClassLoader classLoader = AIOAnimationConatiner.class.getClassLoader();
  public static final ViewGroup.LayoutParams i = new ViewGroup.LayoutParams(-2, -2);
  private a a;
  public wnq a;
  private ListView l;
  private int mType;
  
  public AIOAnimationConatiner(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AIOAnimationConatiner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private a a(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return null;
    case 2: 
      return new FloorJumperSet(paramInt, this, this.l);
    case 1: 
      return new ComboAnimation3(paramInt, this, this.l);
    case 0: 
      return new wnj(paramInt, this, this.l);
    case 4: 
      return new PathAnimation(paramInt, this, this.l);
    }
    return new adxq(paramInt, this, this.l);
  }
  
  private void end()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAnimationContainer", 2, "animation end");
    }
    this.a = null;
    removeAllViewsInLayout();
    invalidate();
  }
  
  public void Cp(int paramInt)
  {
    if (this.a != null) {
      this.a.Cp(paramInt);
    }
  }
  
  public boolean Rz()
  {
    return this.a != null;
  }
  
  public void a(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    if ((this.a != null) && (paramInt2 < this.a.priority)) {}
    do
    {
      do
      {
        return;
        if ((this.a != null) && (paramInt2 == this.a.priority) && (this.a.gp(paramInt1)))
        {
          this.a.c(paramVarArgs);
          return;
        }
        if (this.a != null) {
          stop();
        }
        this.mType = paramInt1;
        this.a = a(paramInt1);
      } while (this.a == null);
      this.a.priority = paramInt2;
    } while (this.a.c(paramVarArgs));
    this.a = null;
  }
  
  public boolean addViewInLayout(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    return super.addViewInLayout(paramView, paramInt, paramLayoutParams, paramBoolean);
  }
  
  public ListView b()
  {
    return this.l;
  }
  
  public void bZK()
  {
    if (this.l == null) {
      return;
    }
    this.l.removeOnLayoutChangeListener(this);
    this.l = null;
  }
  
  protected boolean getChildStaticTransformation(View paramView, Transformation paramTransformation)
  {
    Object localObject = paramView.getTag();
    if ((VersionUtils.isHoneycomb()) && ((localObject instanceof wni.a)) && (((wni.a)localObject).running))
    {
      localObject = (wni.a)localObject;
      Matrix localMatrix = paramTransformation.getMatrix();
      localMatrix.reset();
      int j = paramView.getWidth() / 2;
      int k = paramView.getHeight() / 2;
      localMatrix.preRotate(((wni.a)localObject).rotate, j, k);
      localMatrix.preScale(((wni.a)localObject).scaleX, ((wni.a)localObject).scaleY, k, k);
      paramTransformation.setAlpha(((wni.a)localObject).alpha);
      return true;
    }
    return false;
  }
  
  public boolean isInEditMode()
  {
    return true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.l != null) {
      this.l.removeOnLayoutChangeListener(this);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.a != null) {
      this.a.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (this.a != null) {
      if ((paramInt1 == paramInt5) && (paramInt2 == paramInt6) && (paramInt3 == paramInt7) && (paramInt4 == paramInt8)) {
        break label53;
      }
    }
    label53:
    for (boolean bool = true;; bool = false)
    {
      this.a.a(bool, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
  }
  
  public void p(ListView paramListView)
  {
    rom.checkNotNull(paramListView);
    if (this.l == paramListView)
    {
      ram.e("AIOAnimationConatiner", "attach the same listView!");
      return;
    }
    if (this.l != null)
    {
      ram.e("AIOAnimationConatiner", "attach and override listView!");
      bZK();
    }
    this.l = paramListView;
    this.l.addOnLayoutChangeListener(this);
  }
  
  public void pause()
  {
    if (this.a != null) {
      this.a.pause();
    }
  }
  
  public void resume()
  {
    if (this.a != null) {
      this.a.resume();
    }
  }
  
  public void stop()
  {
    if (this.a != null) {
      this.a.stop();
    }
    end();
  }
  
  public void stop(int paramInt)
  {
    if ((this.a != null) && (paramInt == this.mType)) {
      stop();
    }
  }
  
  public static abstract class a
  {
    public AIOAnimationConatiner c;
    public ListView l;
    protected int priority;
    
    public a(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
    {
      this.priority = paramInt;
      this.c = paramAIOAnimationConatiner;
      this.l = paramListView;
    }
    
    protected void Cp(int paramInt) {}
    
    protected abstract boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public void bZL()
    {
      AIOAnimationConatiner.a(this.c);
    }
    
    protected abstract boolean c(Object... paramVarArgs);
    
    protected boolean gp(int paramInt)
    {
      return false;
    }
    
    protected void pause() {}
    
    protected void resume() {}
    
    protected abstract void stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner
 * JD-Core Version:    0.7.0.1
 */