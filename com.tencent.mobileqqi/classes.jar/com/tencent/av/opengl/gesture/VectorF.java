package com.tencent.av.opengl.gesture;

import android.graphics.PointF;
import android.util.FloatMath;
import android.view.MotionEvent;

public class VectorF
{
  public float a;
  public final PointF a;
  public float b;
  public final PointF b;
  
  public VectorF()
  {
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF();
    this.jdField_b_of_type_AndroidGraphicsPointF = new PointF();
  }
  
  public float a()
  {
    this.jdField_b_of_type_Float = MathUtils.a(this.jdField_a_of_type_AndroidGraphicsPointF, this.jdField_b_of_type_AndroidGraphicsPointF);
    return this.jdField_b_of_type_Float;
  }
  
  public void a()
  {
    this.jdField_b_of_type_AndroidGraphicsPointF.x = (FloatMath.cos(this.jdField_a_of_type_Float) * this.jdField_b_of_type_Float + this.jdField_a_of_type_AndroidGraphicsPointF.x);
    this.jdField_b_of_type_AndroidGraphicsPointF.y = (FloatMath.sin(this.jdField_a_of_type_Float) * this.jdField_b_of_type_Float + this.jdField_a_of_type_AndroidGraphicsPointF.y);
  }
  
  public void a(PointF paramPointF)
  {
    this.jdField_a_of_type_AndroidGraphicsPointF.x = paramPointF.x;
    this.jdField_a_of_type_AndroidGraphicsPointF.y = paramPointF.y;
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_AndroidGraphicsPointF.x = paramMotionEvent.getX(0);
    this.jdField_a_of_type_AndroidGraphicsPointF.y = paramMotionEvent.getY(0);
    this.jdField_b_of_type_AndroidGraphicsPointF.x = paramMotionEvent.getX(1);
    this.jdField_b_of_type_AndroidGraphicsPointF.y = paramMotionEvent.getY(1);
  }
  
  public float b()
  {
    this.jdField_a_of_type_Float = MathUtils.b(this.jdField_a_of_type_AndroidGraphicsPointF, this.jdField_b_of_type_AndroidGraphicsPointF);
    return this.jdField_a_of_type_Float;
  }
  
  public void b(PointF paramPointF)
  {
    this.jdField_b_of_type_AndroidGraphicsPointF.x = paramPointF.x;
    this.jdField_b_of_type_AndroidGraphicsPointF.y = paramPointF.y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.gesture.VectorF
 * JD-Core Version:    0.7.0.1
 */