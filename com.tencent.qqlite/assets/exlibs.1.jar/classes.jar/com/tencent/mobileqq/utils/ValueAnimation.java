package com.tencent.mobileqq.utils;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Pair;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import evx;
import evy;
import evz;
import ewa;
import ewb;
import ewc;
import java.lang.reflect.Field;

public class ValueAnimation
  extends Animation
{
  static final ewc jdField_a_of_type_Ewc = new evx();
  static final ewc b;
  static final ewc c;
  static final ewc d = new ewa();
  static final ewc e = new ewb();
  protected ValueAnimation.AnimationUpdateListener a;
  protected Object a;
  protected boolean a;
  private Pair[] jdField_a_of_type_ArrayOfAndroidUtilPair;
  protected Object b;
  protected boolean b;
  protected Object c;
  protected boolean c;
  protected ewc f;
  
  static
  {
    jdField_b_of_type_Ewc = new evy();
    jdField_c_of_type_Ewc = new evz();
  }
  
  public ValueAnimation(Object paramObject1, Object paramObject2, ValueAnimation.AnimationUpdateListener paramAnimationUpdateListener)
  {
    this(paramObject1, paramObject2, paramAnimationUpdateListener, false, false, null);
  }
  
  public ValueAnimation(Object paramObject1, Object paramObject2, ValueAnimation.AnimationUpdateListener paramAnimationUpdateListener, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramObject1, paramObject2, paramAnimationUpdateListener, paramBoolean1, paramBoolean2, null);
  }
  
  public ValueAnimation(Object paramObject1, Object paramObject2, ValueAnimation.AnimationUpdateListener paramAnimationUpdateListener, boolean paramBoolean1, boolean paramBoolean2, ewc paramewc)
  {
    Class localClass = paramObject1.getClass();
    if (paramewc != null) {
      this.f = paramewc;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangObject = paramObject1;
      this.jdField_b_of_type_JavaLangObject = paramObject2;
      a(paramAnimationUpdateListener);
      this.jdField_a_of_type_Boolean = paramBoolean1;
      this.jdField_b_of_type_Boolean = paramBoolean2;
      return;
      if (localClass == Integer.class)
      {
        this.f = jdField_a_of_type_Ewc;
      }
      else if (Float.class == localClass)
      {
        this.f = jdField_b_of_type_Ewc;
      }
      else if (Rect.class == localClass)
      {
        this.f = jdField_c_of_type_Ewc;
      }
      else if (Point.class == localClass)
      {
        this.f = d;
      }
      else
      {
        if (PointF.class != localClass) {
          break;
        }
        this.f = e;
      }
    }
    throw new IllegalArgumentException("Can't support type " + this.jdField_a_of_type_JavaLangObject.getClass().getSimpleName());
  }
  
  public Object a()
  {
    return this.jdField_c_of_type_JavaLangObject;
  }
  
  public void a(ValueAnimation.AnimationUpdateListener paramAnimationUpdateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation$AnimationUpdateListener = paramAnimationUpdateListener;
  }
  
  public void a(Object paramObject)
  {
    this.jdField_c_of_type_JavaLangObject = paramObject;
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation$AnimationUpdateListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation$AnimationUpdateListener.a(this, paramFloat, this.f.a(paramFloat, this.jdField_a_of_type_JavaLangObject, this.jdField_b_of_type_JavaLangObject), paramTransformation);
    }
  }
  
  public void cancel()
  {
    int i = 0;
    this.jdField_c_of_type_Boolean = true;
    if (Build.VERSION.SDK_INT >= 8) {
      super.cancel();
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ArrayOfAndroidUtilPair == null) {
        this.jdField_a_of_type_ArrayOfAndroidUtilPair = new Pair[] { new Pair("mEnded", Boolean.valueOf(true)), new Pair("mMore", Boolean.valueOf(false)), new Pair("mOneMoreTime", Boolean.valueOf(false)) };
      }
      try
      {
        Object localObject1 = getClass().getDeclaredField("mListener");
        ((Field)localObject1).setAccessible(true);
        localObject1 = ((Field)localObject1).get(this);
        if ((localObject1 instanceof Animation.AnimationListener)) {
          ((Animation.AnimationListener)localObject1).onAnimationEnd(this);
        }
        localObject1 = getClass().getDeclaredField("mStartTime");
        ((Field)localObject1).setAccessible(true);
        ((Field)localObject1).setLong(this, -9223372036854775808L);
        localObject1 = this.jdField_a_of_type_ArrayOfAndroidUtilPair;
        int j = localObject1.length;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          Field localField = getClass().getDeclaredField((String)localObject2.first);
          localField.setAccessible(true);
          localField.setBoolean(this, ((Boolean)localObject2.second).booleanValue());
          i += 1;
        }
        return;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localNoSuchFieldException.printStackTrace();
        return;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
  }
  
  public void reset()
  {
    this.jdField_c_of_type_Boolean = false;
    super.reset();
  }
  
  public boolean willChangeBounds()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean willChangeTransformationMatrix()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ValueAnimation
 * JD-Core Version:    0.7.0.1
 */