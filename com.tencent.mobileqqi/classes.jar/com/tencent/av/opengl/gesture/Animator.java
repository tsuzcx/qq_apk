package com.tencent.av.opengl.gesture;

import com.tencent.av.opengl.QQGLGestureView;

public class Animator
  extends Thread
{
  private long jdField_a_of_type_Long = -1L;
  private QQGLGestureView jdField_a_of_type_ComTencentAvOpenglQQGLGestureView;
  private Animation jdField_a_of_type_ComTencentAvOpenglGestureAnimation;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  public Animator(QQGLGestureView paramQQGLGestureView, String paramString)
  {
    super(paramString);
    this.jdField_a_of_type_ComTencentAvOpenglQQGLGestureView = paramQQGLGestureView;
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_Boolean = false;
      this.b = false;
      notifyAll();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(Animation paramAnimation)
  {
    if (this.b) {
      c();
    }
    this.jdField_a_of_type_ComTencentAvOpenglGestureAnimation = paramAnimation;
    b();
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.b = true;
      notifyAll();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c()
  {
    this.b = false;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: putfield 17	com/tencent/av/opengl/gesture/Animator:jdField_a_of_type_Boolean	Z
    //   5: aload_0
    //   6: getfield 17	com/tencent/av/opengl/gesture/Animator:jdField_a_of_type_Boolean	Z
    //   9: ifeq +123 -> 132
    //   12: aload_0
    //   13: getfield 19	com/tencent/av/opengl/gesture/Animator:b	Z
    //   16: ifeq +84 -> 100
    //   19: aload_0
    //   20: getfield 38	com/tencent/av/opengl/gesture/Animator:jdField_a_of_type_ComTencentAvOpenglGestureAnimation	Lcom/tencent/av/opengl/gesture/Animation;
    //   23: ifnull +77 -> 100
    //   26: invokestatic 46	java/lang/System:currentTimeMillis	()J
    //   29: lstore_1
    //   30: aload_0
    //   31: aload_0
    //   32: getfield 38	com/tencent/av/opengl/gesture/Animator:jdField_a_of_type_ComTencentAvOpenglGestureAnimation	Lcom/tencent/av/opengl/gesture/Animation;
    //   35: aload_0
    //   36: getfield 25	com/tencent/av/opengl/gesture/Animator:jdField_a_of_type_ComTencentAvOpenglQQGLGestureView	Lcom/tencent/av/opengl/QQGLGestureView;
    //   39: lload_1
    //   40: aload_0
    //   41: getfield 23	com/tencent/av/opengl/gesture/Animator:jdField_a_of_type_Long	J
    //   44: lsub
    //   45: invokeinterface 54 4 0
    //   50: putfield 19	com/tencent/av/opengl/gesture/Animator:b	Z
    //   53: aload_0
    //   54: getfield 25	com/tencent/av/opengl/gesture/Animator:jdField_a_of_type_ComTencentAvOpenglQQGLGestureView	Lcom/tencent/av/opengl/QQGLGestureView;
    //   57: invokevirtual 57	com/tencent/av/opengl/QQGLGestureView:b	()V
    //   60: aload_0
    //   61: lload_1
    //   62: putfield 23	com/tencent/av/opengl/gesture/Animator:jdField_a_of_type_Long	J
    //   65: aload_0
    //   66: getfield 19	com/tencent/av/opengl/gesture/Animator:b	Z
    //   69: ifeq -57 -> 12
    //   72: aload_0
    //   73: getfield 25	com/tencent/av/opengl/gesture/Animator:jdField_a_of_type_ComTencentAvOpenglQQGLGestureView	Lcom/tencent/av/opengl/QQGLGestureView;
    //   76: ldc2_w 58
    //   79: invokevirtual 62	com/tencent/av/opengl/QQGLGestureView:a	(J)Z
    //   82: istore_3
    //   83: iload_3
    //   84: ifeq -19 -> 65
    //   87: goto -75 -> 12
    //   90: astore 4
    //   92: aload_0
    //   93: iconst_0
    //   94: putfield 19	com/tencent/av/opengl/gesture/Animator:b	Z
    //   97: goto -32 -> 65
    //   100: aload_0
    //   101: monitorenter
    //   102: aload_0
    //   103: getfield 17	com/tencent/av/opengl/gesture/Animator:jdField_a_of_type_Boolean	Z
    //   106: istore_3
    //   107: iload_3
    //   108: ifeq +7 -> 115
    //   111: aload_0
    //   112: invokevirtual 65	java/lang/Object:wait	()V
    //   115: aload_0
    //   116: monitorexit
    //   117: goto -112 -> 5
    //   120: astore 4
    //   122: aload_0
    //   123: monitorexit
    //   124: aload 4
    //   126: athrow
    //   127: astore 4
    //   129: goto -14 -> 115
    //   132: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	Animator
    //   29	33	1	l	long
    //   82	26	3	bool	boolean
    //   90	1	4	localInterruptedException1	java.lang.InterruptedException
    //   120	5	4	localObject	Object
    //   127	1	4	localInterruptedException2	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   72	83	90	java/lang/InterruptedException
    //   102	107	120	finally
    //   111	115	120	finally
    //   115	117	120	finally
    //   122	124	120	finally
    //   111	115	127	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.gesture.Animator
 * JD-Core Version:    0.7.0.1
 */