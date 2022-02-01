package com.tencent.qqmail.view.imageview;

public class Animator
  extends Thread
{
  private boolean active = false;
  private Animation animation;
  private long lastTime = -1L;
  private boolean running = false;
  private QMGestureImageView view;
  
  public Animator(QMGestureImageView paramQMGestureImageView, String paramString)
  {
    super(paramString);
    this.view = paramQMGestureImageView;
  }
  
  public void activate()
  {
    try
    {
      this.lastTime = System.currentTimeMillis();
      this.active = true;
      notifyAll();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void cancel()
  {
    this.active = false;
  }
  
  public void finish()
  {
    try
    {
      this.running = false;
      this.active = false;
      notifyAll();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void play(Animation paramAnimation)
  {
    if (this.active) {
      cancel();
    }
    this.animation = paramAnimation;
    activate();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: putfield 20	com/tencent/qqmail/view/imageview/Animator:running	Z
    //   5: aload_0
    //   6: getfield 20	com/tencent/qqmail/view/imageview/Animator:running	Z
    //   9: ifeq +123 -> 132
    //   12: aload_0
    //   13: getfield 22	com/tencent/qqmail/view/imageview/Animator:active	Z
    //   16: ifeq +84 -> 100
    //   19: aload_0
    //   20: getfield 50	com/tencent/qqmail/view/imageview/Animator:animation	Lcom/tencent/qqmail/view/imageview/Animation;
    //   23: ifnull +77 -> 100
    //   26: invokestatic 37	java/lang/System:currentTimeMillis	()J
    //   29: lstore_1
    //   30: aload_0
    //   31: aload_0
    //   32: getfield 50	com/tencent/qqmail/view/imageview/Animator:animation	Lcom/tencent/qqmail/view/imageview/Animation;
    //   35: aload_0
    //   36: getfield 28	com/tencent/qqmail/view/imageview/Animator:view	Lcom/tencent/qqmail/view/imageview/QMGestureImageView;
    //   39: lload_1
    //   40: aload_0
    //   41: getfield 26	com/tencent/qqmail/view/imageview/Animator:lastTime	J
    //   44: lsub
    //   45: invokeinterface 61 4 0
    //   50: putfield 22	com/tencent/qqmail/view/imageview/Animator:active	Z
    //   53: aload_0
    //   54: getfield 28	com/tencent/qqmail/view/imageview/Animator:view	Lcom/tencent/qqmail/view/imageview/QMGestureImageView;
    //   57: invokevirtual 66	com/tencent/qqmail/view/imageview/QMGestureImageView:redraw	()V
    //   60: aload_0
    //   61: lload_1
    //   62: putfield 26	com/tencent/qqmail/view/imageview/Animator:lastTime	J
    //   65: aload_0
    //   66: getfield 22	com/tencent/qqmail/view/imageview/Animator:active	Z
    //   69: ifeq -57 -> 12
    //   72: aload_0
    //   73: getfield 28	com/tencent/qqmail/view/imageview/Animator:view	Lcom/tencent/qqmail/view/imageview/QMGestureImageView;
    //   76: ldc2_w 67
    //   79: invokevirtual 72	com/tencent/qqmail/view/imageview/QMGestureImageView:waitForDraw	(J)Z
    //   82: istore_3
    //   83: iload_3
    //   84: ifeq -19 -> 65
    //   87: goto -75 -> 12
    //   90: astore 4
    //   92: aload_0
    //   93: iconst_0
    //   94: putfield 22	com/tencent/qqmail/view/imageview/Animator:active	Z
    //   97: goto -32 -> 65
    //   100: aload_0
    //   101: monitorenter
    //   102: aload_0
    //   103: getfield 20	com/tencent/qqmail/view/imageview/Animator:running	Z
    //   106: istore_3
    //   107: iload_3
    //   108: ifeq +7 -> 115
    //   111: aload_0
    //   112: invokevirtual 75	java/lang/Object:wait	()V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.imageview.Animator
 * JD-Core Version:    0.7.0.1
 */