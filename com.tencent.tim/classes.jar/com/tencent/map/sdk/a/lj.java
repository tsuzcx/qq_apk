package com.tencent.map.sdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.tencentmap.mapsdk.maps.model.BubbleGroup;
import com.tencent.tencentmap.mapsdk.maps.model.BubbleOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

public final class lj
  extends in
{
  private static int e = 0;
  private CopyOnWriteArrayList<a> a = new CopyOnWriteArrayList();
  private Drawable[] b = new Drawable[4];
  private pn c;
  private Context d;
  private BubbleGroup f;
  
  public lj(pn parampn)
  {
    this.c = parampn;
    parampn = parampn.ay;
    Object localObject1 = fy.b(parampn, "bubble_station_lt.9.png");
    Object localObject3 = fy.b(parampn, "bubble_station_rt.9.png");
    Object localObject2 = fy.b(parampn, "bubble_station_rb.9.png");
    Bitmap localBitmap = fy.b(parampn, "bubble_station_lb.9.png");
    byte[] arrayOfByte = ((Bitmap)localObject1).getNinePatchChunk();
    localObject1 = new NinePatchDrawable(parampn.getResources(), (Bitmap)localObject1, arrayOfByte, new Rect(), null);
    arrayOfByte = ((Bitmap)localObject3).getNinePatchChunk();
    localObject3 = new NinePatchDrawable(parampn.getResources(), (Bitmap)localObject3, arrayOfByte, new Rect(), null);
    arrayOfByte = ((Bitmap)localObject2).getNinePatchChunk();
    localObject2 = new NinePatchDrawable(parampn.getResources(), (Bitmap)localObject2, arrayOfByte, new Rect(), null);
    arrayOfByte = localBitmap.getNinePatchChunk();
    parampn = new NinePatchDrawable(parampn.getResources(), localBitmap, arrayOfByte, new Rect(), null);
    this.b[0] = localObject1;
    this.b[1] = localObject3;
    this.b[2] = localObject2;
    this.b[3] = parampn;
  }
  
  private static boolean a(fu paramfu, ir paramir1, ir paramir2)
  {
    paramir1 = paramir1.b(paramfu);
    paramfu = paramir2.b(paramfu);
    if ((paramir1 == null) || (paramfu == null)) {
      return false;
    }
    return Rect.intersects(paramir1, paramfu);
  }
  
  private static int d(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return b.d;
    case 0: 
      return b.a;
    case 1: 
      return b.b;
    }
    return b.c;
  }
  
  private a e(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if ((locala != null) && (locala.b == paramInt)) {
        return locala;
      }
    }
    return null;
  }
  
  public final int a(BubbleOptions paramBubbleOptions, kg paramkg)
  {
    int i;
    if (paramBubbleOptions == null) {
      i = -1;
    }
    for (;;)
    {
      return i;
      try
      {
        i = e;
        e = i + 1;
        if (this.f == null) {
          this.f = new BubbleGroup(paramkg);
        }
        paramBubbleOptions = new a(paramBubbleOptions, i);
        this.a.add(paramBubbleOptions);
        a(paramBubbleOptions.c);
      }
      finally {}
    }
  }
  
  public final void a(GL10 paramGL10)
  {
    for (;;)
    {
      int[] arrayOfInt;
      int i;
      try
      {
        kd localkd = this.c.az.b.h;
        if ((this.a == null) || (this.a.isEmpty()))
        {
          super.a(paramGL10);
          return;
        }
        int m = this.a.size();
        int n = b.d - 1;
        arrayOfInt = new int[m];
        i = 0;
        if (i < m)
        {
          arrayOfInt[i] = b.a;
          i += 1;
          continue;
          if (i < m)
          {
            a locala1 = (a)this.a.get(i);
            ir localir1 = locala1.c;
            locala1.a(localkd, arrayOfInt[i]);
            int j = i + 1;
            if (j < m)
            {
              a locala2 = (a)this.a.get(j);
              ir localir2 = locala2.c;
              locala2.a(localkd, arrayOfInt[j]);
              if (locala1.a() > locala2.a()) {
                break label317;
              }
              k = arrayOfInt[j] - 1;
              if (k <= n)
              {
                int i1 = d(k);
                locala2.a(localkd, i1);
                arrayOfInt[j] = i1;
                if (a(localkd, localir1, localir2))
                {
                  k += 1;
                  continue;
                  if (k < n)
                  {
                    i1 = d(k);
                    locala2.a(localkd, i1);
                    arrayOfInt[i] = i1;
                    boolean bool = a(localkd, localir1, localir2);
                    if (bool)
                    {
                      k += 1;
                      continue;
                    }
                  }
                }
              }
              j += 1;
              continue;
            }
            i += 1;
            continue;
          }
          continue;
        }
        i = 0;
      }
      finally {}
      continue;
      label317:
      int k = arrayOfInt[i] - 1 - 1;
    }
  }
  
  /* Error */
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 197	com/tencent/map/sdk/a/lj:a	()I
    //   6: istore 4
    //   8: iconst_0
    //   9: istore_3
    //   10: iload_3
    //   11: iload 4
    //   13: if_icmpge +61 -> 74
    //   16: aload_0
    //   17: iload_3
    //   18: invokevirtual 200	com/tencent/map/sdk/a/lj:a	(I)Lcom/tencent/map/sdk/a/go;
    //   21: checkcast 102	com/tencent/map/sdk/a/ir
    //   24: astore 6
    //   26: aload 6
    //   28: fload_1
    //   29: fload_2
    //   30: invokevirtual 202	com/tencent/map/sdk/a/ir:a	(FF)Z
    //   33: ifeq +34 -> 67
    //   36: iload_3
    //   37: iload 4
    //   39: iconst_1
    //   40: isub
    //   41: if_icmpge +18 -> 59
    //   44: aload_0
    //   45: aload 6
    //   47: invokevirtual 205	com/tencent/map/sdk/a/lj:b	(Lcom/tencent/map/sdk/a/go;)Z
    //   50: ifeq +9 -> 59
    //   53: aload_0
    //   54: aload 6
    //   56: invokevirtual 157	com/tencent/map/sdk/a/lj:a	(Lcom/tencent/map/sdk/a/go;)V
    //   59: iconst_1
    //   60: istore 5
    //   62: aload_0
    //   63: monitorexit
    //   64: iload 5
    //   66: ireturn
    //   67: iload_3
    //   68: iconst_1
    //   69: iadd
    //   70: istore_3
    //   71: goto -61 -> 10
    //   74: iconst_0
    //   75: istore 5
    //   77: goto -15 -> 62
    //   80: astore 6
    //   82: aload_0
    //   83: monitorexit
    //   84: aload 6
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	lj
    //   0	87	1	paramFloat1	float
    //   0	87	2	paramFloat2	float
    //   9	62	3	i	int
    //   6	35	4	j	int
    //   60	16	5	bool	boolean
    //   24	31	6	localir	ir
    //   80	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	8	80	finally
    //   16	36	80	finally
    //   44	59	80	finally
  }
  
  public final boolean a(int paramInt, BubbleOptions paramBubbleOptions)
  {
    boolean bool;
    if ((paramInt < 0) || (paramBubbleOptions == null)) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      for (;;)
      {
        int i;
        try
        {
          if ((this.a == null) || (this.a.isEmpty())) {
            break label191;
          }
          int j = this.a.size();
          i = 0;
          if (i >= j) {
            break label185;
          }
          if ((this.a.get(i) == null) || (((a)this.a.get(i)).b != paramInt)) {
            break label178;
          }
          paramBubbleOptions = new a(paramBubbleOptions, paramInt);
          this.a.set(i, paramBubbleOptions);
          paramBubbleOptions = new ArrayList();
          Iterator localIterator = this.a.iterator();
          if (localIterator.hasNext())
          {
            a locala = (a)localIterator.next();
            if (locala == null) {
              continue;
            }
            paramBubbleOptions.add(locala.c);
            continue;
          }
          a(paramBubbleOptions);
        }
        finally {}
        bool = true;
        break;
        label178:
        i += 1;
      }
      label185:
      bool = false;
      continue;
      label191:
      bool = false;
    }
  }
  
  /* Error */
  public final boolean b(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: invokespecial 220	com/tencent/map/sdk/a/lj:e	(I)Lcom/tencent/map/sdk/a/lj$a;
    //   7: astore_3
    //   8: aload_3
    //   9: ifnonnull +9 -> 18
    //   12: iconst_0
    //   13: istore_2
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_2
    //   17: ireturn
    //   18: iconst_1
    //   19: istore_2
    //   20: goto -6 -> 14
    //   23: astore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_3
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	lj
    //   0	28	1	paramInt	int
    //   13	7	2	bool	boolean
    //   7	2	3	locala	a
    //   23	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	8	23	finally
  }
  
  public final void c()
  {
    try
    {
      this.a.clear();
      b();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean c(int paramInt)
  {
    boolean bool = true;
    if (paramInt < 0) {}
    for (;;)
    {
      return bool;
      try
      {
        a locala = e(paramInt);
        if (locala == null) {
          continue;
        }
        this.a.remove(locala);
        bool = b(locala.c);
      }
      finally {}
    }
  }
  
  public final List<Integer> d()
  {
    for (;;)
    {
      int i;
      try
      {
        if (this.a != null)
        {
          boolean bool = this.a.isEmpty();
          if (!bool) {}
        }
        else
        {
          localObject1 = null;
          return localObject1;
        }
        int j = this.a.size();
        Object localObject1 = new ArrayList(j);
        i = 0;
        if (i < j) {
          if (this.a.get(i) == null) {
            ((List)localObject1).add(i, Integer.valueOf(-1));
          } else {
            ((List)localObject1).add(i, Integer.valueOf(((a)this.a.get(i)).b));
          }
        }
      }
      finally {}
      continue;
      i += 1;
    }
  }
  
  public final void e()
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if ((locala != null) && (locala.a.getOnTapHidden()))
        {
          this.a.remove(locala);
          b(locala.c);
        }
      }
    }
    finally {}
  }
  
  final class a
  {
    BubbleOptions a = null;
    int b = 0;
    ir c = null;
    private Bitmap[] e = new Bitmap[4];
    
    public a(BubbleOptions paramBubbleOptions, int paramInt)
    {
      this.a = paramBubbleOptions;
      this.b = paramInt;
      this.e[0] = a(lj.a(lj.this), lj.b.a);
      this.e[1] = a(lj.a(lj.this), lj.b.b);
      this.e[2] = a(lj.a(lj.this), lj.b.c);
      this.e[3] = a(lj.a(lj.this), lj.b.d);
      if (this.a != null) {
        this.c = new ir(lj.b(lj.this).az.b.f, new is().a(0.5F, 0.5F).a(a(lj.b.a), new Bitmap[] { this.e[0] }));
      }
    }
    
    private Bitmap a(Context paramContext, int paramInt)
    {
      paramContext = b(paramContext, paramInt);
      paramContext.measure(0, 0);
      paramInt = paramContext.getMeasuredWidth();
      int i = paramContext.getMeasuredHeight();
      paramContext.layout(0, 0, paramInt, i);
      Bitmap localBitmap = Bitmap.createBitmap(paramInt, i, Bitmap.Config.ARGB_8888);
      localBitmap.eraseColor(0);
      paramContext.draw(new Canvas(localBitmap));
      return localBitmap;
    }
    
    private View a(Context paramContext)
    {
      LinearLayout localLinearLayout = new LinearLayout(paramContext);
      localLinearLayout.setOrientation(0);
      localLinearLayout.setGravity(17);
      paramContext = new pc(paramContext);
      paramContext.setGravity(17);
      paramContext.setPadding(30, 30, 30, 30);
      paramContext.setId(100);
      paramContext.setTextSize(14.0F);
      paramContext.setTextColor(-16777216);
      paramContext.setText(this.a.getContent());
      localLinearLayout.addView(paramContext, new LinearLayout.LayoutParams(-2, -2));
      return paramContext;
    }
    
    private String a(int paramInt)
    {
      String str = toString();
      if (paramInt == lj.b.a) {
        return "b_lt_".concat(String.valueOf(str));
      }
      if (paramInt == lj.b.b) {
        return "b_rt_".concat(String.valueOf(str));
      }
      if (paramInt == lj.b.c) {
        return "b_rb_".concat(String.valueOf(str));
      }
      return "b_lb_".concat(String.valueOf(str));
    }
    
    private View b(Context paramContext, int paramInt)
    {
      Object localObject2 = this.a.getBackground();
      Object localObject1;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (localObject2.length >= 4) {}
      }
      else
      {
        localObject1 = lj.c(lj.this);
      }
      View localView = this.a.getContentView();
      localObject2 = localView;
      if (localView == null) {
        localObject2 = a(paramContext);
      }
      ((View)localObject2).setBackgroundDrawable(localObject1[(paramInt - 1)]);
      return localObject2;
    }
    
    public final int a()
    {
      if (this.a == null) {
        return 0;
      }
      return this.a.getDisplayLevel();
    }
    
    public final ir a(fu paramfu, int paramInt)
    {
      Marker localMarker = this.a.getMarker();
      Object localObject2 = this.a.getPosition();
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localMarker.getPosition();
      }
      if (localObject1 == null) {
        return null;
      }
      localObject1 = paramfu.a(lj.a((LatLng)localObject1));
      int j;
      int i;
      float f2;
      float f1;
      label106:
      double d1;
      double d2;
      if (localMarker != null)
      {
        j = localMarker.getWidth(lj.a(lj.this));
        i = localMarker.getHeight(lj.a(lj.this));
        if (localMarker == null) {
          break label325;
        }
        f2 = localMarker.getAnchorU();
        f1 = localMarker.getAnchorV();
        if ((f2 >= 0.0F) && (f2 <= 1.0F))
        {
          d1 = f2;
          d2 = j;
          ((DoublePoint)localObject1).x -= (d1 - 0.5D) * d2;
        }
        if ((f1 >= 0.0F) && (f1 <= 1.0F))
        {
          d1 = f1;
          d2 = i;
          ((DoublePoint)localObject1).y -= (d1 - 0.5D) * d2;
        }
        localObject2 = this.e[(paramInt - 1)];
        j = ((Bitmap)localObject2).getWidth() / 2;
        i = ((Bitmap)localObject2).getHeight() / 2 + i / 2;
        if (paramInt != lj.b.a) {
          break label346;
        }
        d2 = ((DoublePoint)localObject1).x - j;
        d1 = ((DoublePoint)localObject1).y - i;
      }
      for (;;)
      {
        localObject1 = new DoublePoint(d2, d1);
        this.c.a(paramfu.a((DoublePoint)localObject1));
        this.c.a(a(paramInt), new Bitmap[] { localObject2 });
        return this.c;
        j = this.a.getMarkerWidth();
        i = this.a.getMarkerHeight();
        break;
        label325:
        f2 = this.a.getMarkerAnchorU();
        f1 = this.a.getMarkerAnchorV();
        break label106;
        label346:
        if (paramInt == lj.b.b)
        {
          d2 = ((DoublePoint)localObject1).x + j;
          d1 = ((DoublePoint)localObject1).y - i;
        }
        else if (paramInt == lj.b.c)
        {
          d2 = ((DoublePoint)localObject1).x + j;
          d1 = ((DoublePoint)localObject1).y;
          d1 = i + d1;
        }
        else
        {
          d2 = ((DoublePoint)localObject1).x - j;
          d1 = ((DoublePoint)localObject1).y;
          d1 = i + d1;
        }
      }
    }
  }
  
  public static enum b
  {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.lj
 * JD-Core Version:    0.7.0.1
 */