package com.tencent.map.sdk.a;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

public abstract class il<T extends Object<E>, E extends go>
  implements go
{
  private ArrayList<E> a;
  private int b = -1;
  private int c = -1;
  
  private int c()
  {
    try
    {
      int i = this.c;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  private E d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/tencent/map/sdk/a/il:a	Ljava/util/ArrayList;
    //   6: ifnull +43 -> 49
    //   9: aload_0
    //   10: getfield 21	com/tencent/map/sdk/a/il:c	I
    //   13: iflt +36 -> 49
    //   16: aload_0
    //   17: getfield 27	com/tencent/map/sdk/a/il:a	Ljava/util/ArrayList;
    //   20: invokevirtual 32	java/util/ArrayList:size	()I
    //   23: aload_0
    //   24: getfield 21	com/tencent/map/sdk/a/il:c	I
    //   27: if_icmple +22 -> 49
    //   30: aload_0
    //   31: getfield 27	com/tencent/map/sdk/a/il:a	Ljava/util/ArrayList;
    //   34: aload_0
    //   35: getfield 21	com/tencent/map/sdk/a/il:c	I
    //   38: invokevirtual 36	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   41: checkcast 7	com/tencent/map/sdk/a/go
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: areturn
    //   49: aconst_null
    //   50: astore_1
    //   51: goto -6 -> 45
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	il
    //   44	7	1	localgo	go
    //   54	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	45	54	finally
  }
  
  /* Error */
  public final int a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/tencent/map/sdk/a/il:a	Ljava/util/ArrayList;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +9 -> 17
    //   11: iconst_0
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 27	com/tencent/map/sdk/a/il:a	Ljava/util/ArrayList;
    //   21: invokevirtual 32	java/util/ArrayList:size	()I
    //   24: istore_1
    //   25: goto -12 -> 13
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	il
    //   12	13	1	i	int
    //   6	2	2	localArrayList	ArrayList
    //   28	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   17	25	28	finally
  }
  
  public final Rect a(fu paramfu)
  {
    Object localObject1 = b(paramfu);
    int i = ((Rect)localObject1).left;
    int j = ((Rect)localObject1).right;
    int k = ((Rect)localObject1).top;
    int m = ((Rect)localObject1).bottom;
    Object localObject2 = new GeoPoint(k, i);
    Object localObject4 = new GeoPoint(m, i);
    Object localObject3 = new GeoPoint(m, j);
    localObject1 = new GeoPoint(k, j);
    localObject2 = paramfu.a((GeoPoint)localObject2);
    localObject4 = paramfu.a((GeoPoint)localObject4);
    localObject3 = paramfu.a((GeoPoint)localObject3);
    paramfu = paramfu.a((GeoPoint)localObject1);
    return new Rect((int)Math.min(Math.min(((DoublePoint)localObject2).x, ((DoublePoint)localObject4).x), Math.min(((DoublePoint)localObject3).x, paramfu.x)), (int)Math.min(Math.min(((DoublePoint)localObject2).y, ((DoublePoint)localObject4).y), Math.min(((DoublePoint)localObject3).y, paramfu.y)), (int)Math.max(Math.max(((DoublePoint)localObject2).x, ((DoublePoint)localObject4).x), Math.max(((DoublePoint)localObject3).x, paramfu.x)), (int)Math.max(Math.max(((DoublePoint)localObject2).y, ((DoublePoint)localObject4).y), Math.max(((DoublePoint)localObject3).y, paramfu.y)));
  }
  
  /* Error */
  public final E a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/tencent/map/sdk/a/il:a	Ljava/util/ArrayList;
    //   6: ifnull +20 -> 26
    //   9: iload_1
    //   10: iflt +16 -> 26
    //   13: aload_0
    //   14: getfield 27	com/tencent/map/sdk/a/il:a	Ljava/util/ArrayList;
    //   17: invokevirtual 32	java/util/ArrayList:size	()I
    //   20: istore_2
    //   21: iload_2
    //   22: iload_1
    //   23: if_icmpgt +9 -> 32
    //   26: aconst_null
    //   27: astore_3
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_3
    //   31: areturn
    //   32: aload_0
    //   33: getfield 27	com/tencent/map/sdk/a/il:a	Ljava/util/ArrayList;
    //   36: iload_1
    //   37: invokevirtual 36	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   40: checkcast 7	com/tencent/map/sdk/a/go
    //   43: astore_3
    //   44: goto -16 -> 28
    //   47: astore_3
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_3
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	il
    //   0	52	1	paramInt	int
    //   20	4	2	i	int
    //   27	17	3	localObject1	Object
    //   47	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	47	finally
    //   13	21	47	finally
    //   32	44	47	finally
  }
  
  public final void a(E paramE)
  {
    try
    {
      if (this.a == null) {
        this.a = new ArrayList();
      }
      this.a.add(paramE);
      return;
    }
    finally {}
  }
  
  public final void a(List<E> paramList)
  {
    for (;;)
    {
      try
      {
        if (paramList.size() <= 0)
        {
          this.a = null;
          return;
        }
        if (this.a == null)
        {
          this.a = new ArrayList(paramList.size());
          this.a.addAll(paramList);
        }
        else
        {
          this.a.clear();
        }
      }
      finally {}
    }
  }
  
  public void a(GL10 paramGL10)
  {
    int j = c();
    int i = 0;
    int k = a();
    while (i < k)
    {
      if (j != i)
      {
        localgo = a(i);
        if ((localgo != null) && ((localgo instanceof ip))) {
          localgo.a(paramGL10);
        }
      }
      i += 1;
    }
    go localgo = d();
    if ((localgo != null) && ((localgo instanceof ip))) {
      localgo.a(paramGL10);
    }
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    if (this.a == null) {
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        ArrayList localArrayList = new ArrayList(this.a.size());
        localArrayList.addAll(this.a);
        int j = localArrayList.size();
        i = 0;
        if (i >= j) {
          break;
        }
        int k = (this.b + i + 1) % j;
        if (((go)localArrayList.get(k)).a(paramFloat1, paramFloat2))
        {
          this.b = k;
          return true;
        }
      }
      finally {}
      i += 1;
    }
    return false;
  }
  
  public final Rect b(fu paramfu)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    for (;;)
    {
      int i;
      try
      {
        if (this.a != null)
        {
          boolean bool = this.a.isEmpty();
          if (bool) {
            localObject2 = localObject1;
          }
        }
        else
        {
          return localObject2;
        }
        int j = this.a.size();
        i = 0;
        localObject1 = localObject3;
        localObject2 = localObject1;
        if (i >= j) {
          continue;
        }
        localObject2 = ((go)this.a.get(i)).b(paramfu);
        if (localObject2 != null) {
          if (localObject1 == null)
          {
            localObject1 = localObject2;
          }
          else
          {
            localObject1.left = Math.min(localObject1.left, ((Rect)localObject2).left);
            localObject1.top = Math.max(localObject1.top, ((Rect)localObject2).top);
            localObject1.right = Math.max(localObject1.right, ((Rect)localObject2).right);
            localObject1.bottom = Math.min(localObject1.bottom, ((Rect)localObject2).bottom);
          }
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public final void b()
  {
    try
    {
      if (this.a != null) {
        this.a.clear();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final boolean b(E paramE)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/tencent/map/sdk/a/il:a	Ljava/util/ArrayList;
    //   6: ifnull +16 -> 22
    //   9: aload_0
    //   10: getfield 27	com/tencent/map/sdk/a/il:a	Ljava/util/ArrayList;
    //   13: aload_1
    //   14: invokevirtual 140	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   17: istore_2
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_2
    //   21: ireturn
    //   22: iconst_0
    //   23: istore_2
    //   24: goto -6 -> 18
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	il
    //   0	32	1	paramE	E
    //   17	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	18	27	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.il
 * JD-Core Version:    0.7.0.1
 */