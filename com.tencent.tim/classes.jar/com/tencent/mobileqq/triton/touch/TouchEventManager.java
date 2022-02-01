package com.tencent.mobileqq.triton.touch;

import android.view.MotionEvent;
import com.tencent.mobileqq.triton.engine.TTEngine;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class TouchEventManager
{
  private TTTouchEvents a = new TTTouchEvents();
  private long b;
  private ArrayList<TTTouchEvents> c = new ArrayList();
  private float d;
  private TTEngine e;
  private Queue<a> f = new LinkedList();
  private a g;
  
  public TouchEventManager(TTEngine paramTTEngine, float paramFloat)
  {
    this.e = paramTTEngine;
    this.d = paramFloat;
  }
  
  private void a(int paramInt)
  {
    TTTouchEvents localTTTouchEvents = this.a;
    localTTTouchEvents.action = paramInt;
    localTTTouchEvents = localTTTouchEvents.a();
    paramInt = localTTTouchEvents.action;
    if (paramInt == 5) {
      localTTTouchEvents.action = 0;
    }
    for (;;)
    {
      a(localTTTouchEvents);
      return;
      if (paramInt == 6) {
        localTTTouchEvents.action = 1;
      }
    }
  }
  
  /* Error */
  private void b(MotionEvent paramMotionEvent)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +12 -> 15
    //   6: aload_0
    //   7: getfield 61	com/tencent/mobileqq/triton/touch/TouchEventManager:g	Lcom/tencent/mobileqq/triton/touch/TouchEventManager$a;
    //   10: astore_3
    //   11: aload_3
    //   12: ifnonnull +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_1
    //   19: invokevirtual 67	android/view/MotionEvent:getActionIndex	()I
    //   22: istore_2
    //   23: aload_1
    //   24: iload_2
    //   25: invokevirtual 71	android/view/MotionEvent:getX	(I)F
    //   28: aload_3
    //   29: getfield 73	com/tencent/mobileqq/triton/touch/TouchEventManager$a:a	F
    //   32: fsub
    //   33: invokestatic 79	java/lang/Math:abs	(F)F
    //   36: fconst_1
    //   37: fcmpl
    //   38: ifgt -23 -> 15
    //   41: aload_1
    //   42: iload_2
    //   43: invokevirtual 82	android/view/MotionEvent:getY	(I)F
    //   46: aload_3
    //   47: getfield 84	com/tencent/mobileqq/triton/touch/TouchEventManager$a:b	F
    //   50: fsub
    //   51: invokestatic 79	java/lang/Math:abs	(F)F
    //   54: fconst_1
    //   55: fcmpl
    //   56: ifgt -41 -> 15
    //   59: aload_3
    //   60: aload_1
    //   61: iload_2
    //   62: invokevirtual 71	android/view/MotionEvent:getX	(I)F
    //   65: putfield 86	com/tencent/mobileqq/triton/touch/TouchEventManager$a:c	F
    //   68: aload_3
    //   69: aload_1
    //   70: iload_2
    //   71: invokevirtual 82	android/view/MotionEvent:getY	(I)F
    //   74: putfield 87	com/tencent/mobileqq/triton/touch/TouchEventManager$a:d	F
    //   77: aload_3
    //   78: invokestatic 93	java/lang/System:currentTimeMillis	()J
    //   81: putfield 95	com/tencent/mobileqq/triton/touch/TouchEventManager$a:e	J
    //   84: aload_0
    //   85: getfield 42	com/tencent/mobileqq/triton/touch/TouchEventManager:f	Ljava/util/Queue;
    //   88: aload_3
    //   89: invokeinterface 101 2 0
    //   94: pop
    //   95: aload_0
    //   96: getfield 42	com/tencent/mobileqq/triton/touch/TouchEventManager:f	Ljava/util/Queue;
    //   99: invokeinterface 104 1 0
    //   104: bipush 10
    //   106: if_icmple -91 -> 15
    //   109: aload_0
    //   110: getfield 42	com/tencent/mobileqq/triton/touch/TouchEventManager:f	Ljava/util/Queue;
    //   113: invokeinterface 108 1 0
    //   118: pop
    //   119: goto -104 -> 15
    //   122: astore_1
    //   123: aload_0
    //   124: monitorexit
    //   125: aload_1
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	TouchEventManager
    //   0	127	1	paramMotionEvent	MotionEvent
    //   22	49	2	i	int
    //   10	79	3	locala	a
    // Exception table:
    //   from	to	target	type
    //   6	11	122	finally
    //   18	119	122	finally
  }
  
  private ArrayList<TTTouchEvents> d()
  {
    ArrayList localArrayList = null;
    try
    {
      if (!this.c.isEmpty())
      {
        localArrayList = new ArrayList(this.c);
        this.c.clear();
      }
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a()
  {
    ArrayList localArrayList = d();
    if ((localArrayList != null) && (!localArrayList.isEmpty())) {
      nativeOnTouch(this.e.k(), localArrayList);
    }
  }
  
  public void a(TTTouchEvents paramTTTouchEvents)
  {
    try
    {
      paramTTTouchEvents.timeStamp = (System.currentTimeMillis() - this.b);
      this.c.add(paramTTTouchEvents);
      return;
    }
    finally
    {
      paramTTTouchEvents = finally;
      throw paramTTTouchEvents;
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int j = 0;
    int i = 0;
    int k = paramMotionEvent.getActionIndex();
    int n = paramMotionEvent.getPointerId(k);
    float f1 = paramMotionEvent.getX(k) / this.d;
    float f2 = paramMotionEvent.getY(k) / this.d;
    int m = paramMotionEvent.getActionMasked();
    this.a.changedTouches.clear();
    switch (m)
    {
    }
    for (;;)
    {
      return true;
      do
      {
        i += 1;
        if (i >= this.a.touches.size()) {
          break;
        }
        paramMotionEvent = (Touch)this.a.touches.get(i);
      } while (paramMotionEvent.identifier != n);
      this.a.changedTouches.add(paramMotionEvent);
      label164:
      if ((this.a.touches.size() > 0) && (this.a.touches.size() > i)) {
        this.a.touches.remove(i);
      }
      for (;;)
      {
        a(m);
        break;
        i = k;
        break label164;
        paramMotionEvent = this.a;
        paramMotionEvent.changedTouches.addAll(paramMotionEvent.touches);
        this.a.touches.clear();
        a(m);
        break;
        i = 0;
        while (i < paramMotionEvent.getPointerCount())
        {
          k = paramMotionEvent.getPointerId(i);
          j = 0;
          while (j < this.a.touches.size())
          {
            localTouch = (Touch)this.a.touches.get(j);
            if (localTouch.identifier == k)
            {
              f1 = paramMotionEvent.getX(i) / this.d;
              f2 = paramMotionEvent.getY(i) / this.d;
              if ((Math.abs(localTouch.screenX - f1) >= 0.01F) || (Math.abs(localTouch.screenY - f2) >= 0.01F))
              {
                localTouch.a(f1, f2);
                this.a.changedTouches.add(localTouch);
              }
            }
            j += 1;
          }
          i += 1;
        }
        if (this.a.changedTouches.size() <= 0) {
          break;
        }
      }
      do
      {
        j += 1;
        if (j >= this.a.touches.size()) {
          break;
        }
        localTouch = (Touch)this.a.touches.get(j);
      } while (localTouch.identifier != n);
      this.a.changedTouches.add(localTouch);
      this.a.touches.clear();
      a(m);
      b(paramMotionEvent);
      continue;
      Touch localTouch = new Touch(n, f1, f2);
      this.a.touches.add(localTouch);
      this.a.changedTouches.add(localTouch);
      a(m);
      if (m == 0) {
        this.g = new a(paramMotionEvent.getX(k), paramMotionEvent.getY(k));
      }
    }
  }
  
  public String b()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("[");
      Iterator localIterator = this.f.iterator();
      int i = 1;
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (i == 0) {
          localStringBuilder.append(',');
        }
        i = 0;
        localStringBuilder.append('[').append(locala.a).append(',').append(locala.b).append(',').append(locala.c).append(',').append(locala.d).append(locala.e).append("]");
      }
      localObject.append("]");
    }
    finally {}
    String str = localObject.toString();
    return str;
  }
  
  public void c()
  {
    this.a.touches.clear();
    this.a.changedTouches.clear();
    this.c.clear();
    this.f.clear();
  }
  
  public native void nativeOnTouch(long paramLong, ArrayList<TTTouchEvents> paramArrayList);
  
  static class a
  {
    public float a;
    public float b;
    public float c;
    public float d;
    public long e;
    
    public a(float paramFloat1, float paramFloat2)
    {
      this.a = paramFloat1;
      this.b = paramFloat2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.touch.TouchEventManager
 * JD-Core Version:    0.7.0.1
 */