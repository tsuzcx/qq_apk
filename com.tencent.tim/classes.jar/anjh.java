import android.graphics.PointF;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

public class anjh
{
  public final int TOUCH_MOVE = 2;
  private anjh.a jdField_a_of_type_Anjh$a;
  private anjh.b jdField_a_of_type_Anjh$b = new anjh.b(null);
  private PointF ag = new PointF();
  private PointF ah = new PointF();
  private PointF ai = new PointF();
  private PointF aj = new PointF();
  private PointF ak = new PointF();
  private anjh.b b = new anjh.b(null);
  private boolean cHl;
  private boolean cHm;
  private boolean cHn;
  private boolean cHo;
  private boolean cHp;
  private boolean cHq;
  public final int dHL = 0;
  public final int dHM = 1;
  public final int dHN = 2;
  public final int dHO = 3;
  public final int dHP = 4;
  public final int dHQ = 5;
  public final int dHR = 6;
  public final int dHS = -1;
  public final int dHT = 50;
  public final int dHU = 0;
  public final int dHV = 1;
  private final int dHW = 200;
  private final int dHX = 200;
  private final int dHY = 200;
  private final int dHZ = 30;
  private final int dIa = 80;
  private final int dIb = 400;
  private final int dIc = 50;
  private final int dId = 30;
  private int dIe;
  private int dIf;
  private int dIg;
  private int dIh;
  private final int dIi = 8;
  
  anjh(anjh.a parama)
  {
    this.jdField_a_of_type_Anjh$a = parama;
  }
  
  private anjh.b a(int paramInt)
  {
    anjh.b localb = null;
    VideoEnvironment.k("GameplayEngine.GameEvent", String.format("id=%d,pointerId0=%d,pointerId1=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_Anjh$b.dIj), Integer.valueOf(this.b.dIj) }), null);
    VideoEnvironment.k("GameplayEngine.GameEvent", String.format("id=%d,pressed0=%b,pressed1=%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.jdField_a_of_type_Anjh$b.pressed), Boolean.valueOf(this.b.pressed) }), null);
    if (paramInt == this.jdField_a_of_type_Anjh$b.dIj) {
      localb = this.jdField_a_of_type_Anjh$b;
    }
    do
    {
      return localb;
      if (paramInt == this.b.dIj) {
        return this.b;
      }
      if (this.jdField_a_of_type_Anjh$b.pressed) {
        return this.jdField_a_of_type_Anjh$b;
      }
    } while (!this.b.pressed);
    return this.b;
  }
  
  private void a(long paramLong, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    VideoEnvironment.k("GameplayEngine.GameEvent", String.format("gestureEvent:Name=%s,x=%f,y=%f,param=%f", new Object[] { fk(paramInt), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) }), null);
    if (this.jdField_a_of_type_Anjh$a != null) {
      this.jdField_a_of_type_Anjh$a.a(paramLong, paramInt, paramFloat1, paramFloat2, paramFloat3);
    }
  }
  
  private void a(long paramLong, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2)
  {
    VideoEnvironment.k("GameplayEngine.GameEvent", String.format("touchEvent:touchName=%s,x=%f,y=%f,pointerId=%d", new Object[] { fl(paramInt1), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt2) }), null);
    if (this.jdField_a_of_type_Anjh$a != null) {
      this.jdField_a_of_type_Anjh$a.a(paramLong, paramInt1, paramFloat1, paramFloat2, paramInt2);
    }
  }
  
  private boolean axz()
  {
    return !this.cHm;
  }
  
  private static float b(PointF paramPointF1, PointF paramPointF2)
  {
    float f = Math.abs(paramPointF1.x - paramPointF2.x);
    f = (float)Math.atan2(Math.abs(paramPointF1.y - paramPointF2.y), f);
    if (paramPointF1.x > paramPointF2.x)
    {
      if (paramPointF1.y < paramPointF2.y) {
        return f;
      }
      if (paramPointF1.y > paramPointF2.y) {
        return (float)(6.283185307179586D - f);
      }
      return 0.0F;
    }
    if (paramPointF1.x < paramPointF2.x)
    {
      if (paramPointF1.y < paramPointF2.y) {
        return (float)(3.141592653589793D - f);
      }
      if (paramPointF1.y > paramPointF2.y) {
        return (float)(f + 3.141592653589793D);
      }
      return 3.141593F;
    }
    if (paramPointF1.y < paramPointF2.y) {
      return 1.570796F;
    }
    return 4.712389F;
  }
  
  private boolean b(int paramInt, float paramFloat1, float paramFloat2)
  {
    anjh.b localb = a(paramInt);
    if (localb == null) {}
    do
    {
      return false;
      float f2 = localb.x;
      float f1 = localb.y;
      paramFloat1 = Math.abs(paramFloat1 - f2);
      paramFloat2 = Math.abs(paramFloat2 - f1);
    } while ((paramFloat1 <= 8.0F) && (paramFloat2 <= 8.0F));
    return true;
  }
  
  private boolean bl(int paramInt1, int paramInt2)
  {
    float f1 = Math.abs(paramInt1);
    float f2 = Math.abs(paramInt2);
    return (f1 <= 8.0F) && (f2 <= 8.0F);
  }
  
  private boolean bm(int paramInt1, int paramInt2)
  {
    return ((paramInt1 > 0) && (paramInt2 > 0)) || ((paramInt1 < 0) && (paramInt2 < 0));
  }
  
  private boolean cJ(long paramLong)
  {
    boolean bool = false;
    if ((q(paramLong, 0)) || (q(paramLong, 1)) || (q(paramLong, 2)) || (q(paramLong, 3)) || (q(paramLong, 5)) || (q(paramLong, 6))) {
      bool = true;
    }
    return bool;
  }
  
  private void dQH()
  {
    this.dIh = ((int)Math.sqrt(Math.pow(this.jdField_a_of_type_Anjh$b.x - this.b.x, 2.0D) + Math.pow(this.jdField_a_of_type_Anjh$b.y - this.b.y, 2.0D)) + 5);
  }
  
  private void dQI()
  {
    this.jdField_a_of_type_Anjh$b.pressed = false;
    this.b.pressed = false;
    this.ag.set(0.0F, 0.0F);
    this.ah.set(0.0F, 0.0F);
    this.ai.set(0.0F, 0.0F);
    this.aj.set(0.0F, 0.0F);
    this.dIe = -1;
    this.cHq = false;
    this.dIg = 0;
    this.dIf = 0;
    this.dIh = 0;
    this.ak.set(0.0F, 0.0F);
  }
  
  private void dQJ()
  {
    this.cHm = false;
    this.cHn = false;
    this.cHo = false;
    this.cHp = false;
  }
  
  private String fk(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unKnown";
    case 0: 
      return "GESTURE_TAP";
    case 1: 
      return "GESTURE_SWIPE";
    case 2: 
      return "GESTURE_PINCH";
    case 3: 
      return "GESTURE_LONG_TAP";
    case 4: 
      return "GESTURE_ROTATE";
    case 5: 
      return "GESTURE_DRAG";
    case 6: 
      return "GESTURE_DROP";
    case -1: 
      return "GESTURE_ANY_SUPPORTED";
    }
    return "GESTURE_PROMOTE";
  }
  
  private String fl(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unKnown";
    case 0: 
      return "TOUCH_PRESS";
    case 1: 
      return "TOUCH_RELEASE";
    }
    return "TOUCH_MOVE";
  }
  
  private boolean q(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_Anjh$a != null) {
      return this.jdField_a_of_type_Anjh$a.q(paramLong, paramInt);
    }
    return false;
  }
  
  void a(long paramLong1, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, long paramLong2)
  {
    boolean bool = cJ(paramLong1);
    if (paramInt2 == 0)
    {
      dQI();
      if (bool)
      {
        this.jdField_a_of_type_Anjh$b.pressed = true;
        this.jdField_a_of_type_Anjh$b.time = paramLong2;
        this.jdField_a_of_type_Anjh$b.dIj = paramInt1;
        this.jdField_a_of_type_Anjh$b.x = paramFloat1;
        this.jdField_a_of_type_Anjh$b.y = paramFloat2;
        this.ag.set(paramFloat1, paramFloat2);
        this.ai.set(paramFloat1, paramFloat2);
      }
      dQJ();
      this.dIe = paramInt1;
      a(paramLong1, 0, paramFloat1, paramFloat2, paramInt1);
    }
    do
    {
      do
      {
        return;
      } while (paramInt2 != 5);
      if (bool)
      {
        this.b.pressed = true;
        this.b.time = paramLong2;
        this.b.dIj = paramInt1;
        this.b.x = paramFloat1;
        this.b.y = paramFloat2;
        this.ah.set(paramFloat1, paramFloat2);
        this.aj.set(paramFloat1, paramFloat2);
        dQH();
        this.ak.set((this.jdField_a_of_type_Anjh$b.x + this.b.x) / 2.0F, (this.jdField_a_of_type_Anjh$b.y + this.b.y) / 2.0F);
      }
    } while (!this.cHl);
    a(paramLong1, 0, paramFloat1, paramFloat2, paramInt1);
  }
  
  void a(long paramLong1, int[] paramArrayOfInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong2)
  {
    int m = paramArrayOfInt.length;
    int j = 0;
    int n;
    float f2;
    float f3;
    int k;
    if (j < m)
    {
      n = paramArrayOfInt[j];
      f2 = paramArrayOfFloat1[j];
      f3 = paramArrayOfFloat2[j];
      k = 0;
      i = k;
      if (!this.jdField_a_of_type_Anjh$b.pressed) {
        break label721;
      }
      if ((!this.b.pressed) || ((n != this.jdField_a_of_type_Anjh$b.dIj) && (n != this.b.dIj))) {
        break label1070;
      }
      if (this.jdField_a_of_type_Anjh$b.dIj == this.b.dIj) {
        dQJ();
      }
    }
    else
    {
      return;
    }
    int i = k;
    label197:
    int i1;
    int i2;
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    float f1;
    if (q(paramLong1, 2))
    {
      if (this.jdField_a_of_type_Anjh$b.dIj != n) {
        break label776;
      }
      this.ag.set(this.ai);
      this.ai.set(f2, f3);
      this.dIf = ((int)Math.sqrt(Math.pow(f2 - this.jdField_a_of_type_Anjh$b.x, 2.0D) + Math.pow(f3 - this.jdField_a_of_type_Anjh$b.y, 2.0D)));
      if ((!this.cHm) && (this.dIf >= 30) && (this.dIg >= 30)) {
        this.cHm = true;
      }
      i = k;
      if (this.cHm)
      {
        b(this.ag, this.ah);
        b(this.ai, this.aj);
        i = (int)Math.sqrt(Math.pow(this.ak.x - this.ai.x, 2.0D) + Math.pow(this.ak.y - this.ai.y, 2.0D));
        i1 = (int)Math.sqrt(Math.pow(this.ak.x - this.ag.x, 2.0D) + Math.pow(this.ak.y - this.ag.y, 2.0D));
        i2 = (int)Math.sqrt(Math.pow(this.ak.x - this.aj.x, 2.0D) + Math.pow(this.ak.y - this.aj.y, 2.0D));
        i3 = (int)Math.sqrt(Math.pow(this.ak.x - this.ah.x, 2.0D) + Math.pow(this.ak.y - this.ah.y, 2.0D));
        i4 = (int)(this.ai.x - this.ag.x);
        i5 = (int)(this.ai.y - this.ag.y);
        i6 = (int)(this.aj.x - this.ah.x);
        i7 = (int)(this.aj.y - this.ah.y);
        if (n != this.jdField_a_of_type_Anjh$b.dIj) {
          break label844;
        }
        f1 = i / i1;
        label559:
        int i8 = (int)Math.sqrt(Math.pow(this.ai.x - this.aj.x, 2.0D) + Math.pow(this.ai.y - this.aj.y, 2.0D));
        if ((!this.cHo) && (!this.cHn) && (!this.cHp))
        {
          if (Math.abs(0.0F) >= 0.002D) {
            break label902;
          }
          if ((!bm(i5, i7)) || (!bm(i4, i6)) || (i8 >= this.dIh)) {
            break label856;
          }
          this.cHn = true;
          this.cHo = false;
          this.cHp = false;
        }
        label689:
        if (!this.cHo) {
          break label920;
        }
        a(paramLong1, 2, this.ak.x, this.ak.y, f1);
        i = 1;
      }
    }
    for (;;)
    {
      label721:
      if ((i == 0) && ((this.cHl) || (this.dIe == n)) && (b(n, f2, f3))) {
        a(paramLong1, 2, f2, f3, n);
      }
      j += 1;
      break;
      label776:
      this.ah.set(this.aj);
      this.aj.set(f2, f3);
      this.dIg = ((int)Math.sqrt(Math.pow(f2 - this.b.x, 2.0D) + Math.pow(f3 - this.b.y, 2.0D)));
      break label197;
      label844:
      f1 = i2 / i3;
      break label559;
      label856:
      if (((i < i1) || (i2 < i3)) && ((i > i1) || (i2 > i3))) {
        break label689;
      }
      this.cHn = false;
      this.cHo = true;
      this.cHp = false;
      break label689;
      label902:
      this.cHn = false;
      this.cHo = false;
      this.cHp = true;
      break label689;
      label920:
      if (this.cHn)
      {
        if ((i5 > 0) && (i7 > 0)) {
          if (i5 > i7) {
            a(paramLong1, 50, i6, i7, 0.0F);
          }
        }
        for (;;)
        {
          i = 1;
          break;
          a(paramLong1, 50, i4, i5, 0.0F);
          continue;
          if ((i5 < 0) && (i7 < 0)) {
            if (i5 > i7) {
              a(paramLong1, 50, i4, i5, 0.0F);
            } else {
              a(paramLong1, 50, i6, i7, 0.0F);
            }
          }
        }
      }
      i = k;
      if (this.cHp)
      {
        i = 1;
        a(paramLong1, 4, this.ak.x, this.ak.y, 0.0F);
        continue;
        label1070:
        i = k;
        if (axz())
        {
          i = k;
          if (n == this.jdField_a_of_type_Anjh$b.dIj)
          {
            i = k;
            if (q(paramLong1, 5))
            {
              i1 = (int)Math.sqrt(Math.pow(f2 - this.jdField_a_of_type_Anjh$b.x, 2.0D) + Math.pow(f3 - this.jdField_a_of_type_Anjh$b.y, 2.0D));
              if (!this.cHq)
              {
                i = k;
                if (!q(paramLong1, 5)) {}
              }
              else
              {
                i = k;
                if (paramLong2 - this.jdField_a_of_type_Anjh$b.time >= 200L)
                {
                  i = k;
                  if (i1 >= 30)
                  {
                    a(paramLong1, 5, f2, f3, 0.0F);
                    this.cHq = true;
                    i = 1;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  void b(long paramLong1, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, long paramLong2)
  {
    int j;
    int i;
    anjh.b localb;
    if (paramInt2 == 1)
    {
      j = 0;
      i = 0;
      localb = a(paramInt1);
      if (localb != null) {}
    }
    label114:
    do
    {
      do
      {
        return;
        paramInt2 = i;
        float f1;
        float f2;
        if (localb.pressed)
        {
          f1 = paramFloat1 - localb.x;
          f2 = paramFloat2 - localb.y;
          if (!this.cHm) {
            break label114;
          }
          dQJ();
          paramInt2 = 1;
        }
        for (;;)
        {
          localb.pressed = false;
          if ((paramInt2 == 0) && ((this.cHl) || (this.dIe == paramInt1))) {
            a(paramLong1, 1, paramFloat1, paramFloat2, paramInt1);
          }
          this.dIe = -1;
          return;
          if (this.cHq)
          {
            paramInt2 = j;
            if (q(paramLong1, 6))
            {
              a(paramLong1, 6, paramFloat1, paramFloat2, 0.0F);
              paramInt2 = 1;
            }
            this.cHq = false;
          }
          else
          {
            if ((q(paramLong1, 1)) && (paramLong2 - localb.time < 400L) && ((Math.abs(f1) > 50.0F) || (Math.abs(f2) > 50.0F)))
            {
              paramInt2 = 0;
              if (Math.abs(f1) > Math.abs(f2)) {
                if (f1 > 0.0F) {
                  paramInt2 = 8;
                }
              }
              for (;;)
              {
                a(paramLong1, 1, paramFloat1, paramFloat2, paramInt2);
                paramInt2 = 1;
                break;
                if (f1 < 0.0F)
                {
                  paramInt2 = 4;
                  continue;
                  if (f2 > 0.0F) {
                    paramInt2 = 2;
                  } else if (f2 < 0.0F) {
                    paramInt2 = 1;
                  }
                }
              }
            }
            if ((q(paramLong1, 0)) && (bl((int)f1, (int)f2)) && (paramLong2 - localb.time < 200L))
            {
              a(paramLong1, 0, paramFloat1, paramFloat2, 0.0F);
              paramInt2 = 1;
            }
            else
            {
              paramInt2 = i;
              if (q(paramLong1, 3))
              {
                paramInt2 = i;
                if (bl((int)f1, (int)f2))
                {
                  paramInt2 = i;
                  if (paramLong2 - localb.time >= 200L)
                  {
                    a(paramLong1, 3, paramFloat1, paramFloat2, (float)(paramLong2 - localb.time));
                    paramInt2 = 1;
                  }
                }
              }
            }
          }
        }
      } while (paramInt2 != 6);
      i = 0;
      localb = a(paramInt1);
    } while (localb == null);
    paramInt2 = i;
    int k;
    if (localb.pressed)
    {
      k = (int)(paramFloat1 - localb.x);
      j = (int)(paramFloat2 - localb.y);
      if ((!this.cHl) || (!q(paramLong1, 1)) || (paramLong2 - localb.time >= 400L) || ((Math.abs(k) <= 50) && (Math.abs(j) <= 50))) {
        break label646;
      }
      paramInt2 = 0;
      if (k <= 0) {
        break label617;
      }
      paramInt2 = 8;
      label539:
      if (j <= 0) {
        break label628;
      }
      i = paramInt2 | 0x2;
      label550:
      a(paramLong1, 1, paramFloat1, paramFloat2, i);
      paramInt2 = 1;
    }
    for (;;)
    {
      localb.pressed = false;
      if ((paramInt2 == 0) && ((this.cHl) || (this.dIe == paramInt1))) {
        a(paramLong1, 1, paramFloat1, paramFloat2, paramInt1);
      }
      if (this.dIe != paramInt1) {
        break;
      }
      this.dIe = -1;
      return;
      label617:
      if (k >= 0) {
        break label539;
      }
      paramInt2 = 4;
      break label539;
      label628:
      i = paramInt2;
      if (j >= 0) {
        break label550;
      }
      i = paramInt2 | 0x1;
      break label550;
      label646:
      if ((this.cHl) && (q(paramLong1, 0)) && (bl(k, j)) && (paramLong2 - localb.time < 200L))
      {
        a(paramLong1, 0, paramFloat1, paramFloat2, 0.0F);
        paramInt2 = 1;
      }
      else
      {
        paramInt2 = i;
        if (this.cHl)
        {
          paramInt2 = i;
          if (q(paramLong1, 3))
          {
            paramInt2 = i;
            if (bl(k, j))
            {
              paramInt2 = i;
              if (paramLong2 - localb.time >= 200L)
              {
                a(paramLong1, 3, paramFloat1, paramFloat2, (float)(paramLong2 - localb.time));
                paramInt2 = 1;
              }
            }
          }
        }
      }
    }
  }
  
  void b(long paramLong1, int[] paramArrayOfInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong2) {}
  
  public static abstract interface a
  {
    public abstract void a(long paramLong, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3);
    
    public abstract void a(long paramLong, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2);
    
    public abstract boolean q(long paramLong, int paramInt);
  }
  
  class b
  {
    int dIj = 0;
    boolean pressed = false;
    long time = 0L;
    float x = 0.0F;
    float y = 0.0F;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anjh
 * JD-Core Version:    0.7.0.1
 */