import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class aehc
{
  public static int cMV = 12;
  private static Paint sPaint = new Paint();
  public static Random sRandom = new Random();
  
  private static boolean b(String paramString, ArrayList<Pair<String, Float>> paramArrayList)
  {
    paramString = paramString.trim();
    int j = -1;
    boolean bool = true;
    int i = 0;
    if (i < paramString.length())
    {
      String str;
      if (je(paramString.codePointAt(i)))
      {
        str = paramString.substring(i, i + 1);
        paramArrayList.add(new Pair(str, Float.valueOf(d(str))));
      }
      for (;;)
      {
        i += 1;
        break;
        int k = j;
        if (j == -1) {
          k = i;
        }
        if (i + 1 < paramString.length())
        {
          j = k;
          if (!je(paramString.codePointAt(i + 1))) {}
        }
        else
        {
          str = paramString.substring(k, i + 1);
          paramArrayList.add(new Pair(str, Float.valueOf(d(str))));
          j = -1;
        }
        bool = false;
      }
    }
    return bool;
  }
  
  public static float d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      sPaint.setTextSize(36.0F);
      return sPaint.measureText(paramString) / 36.0F;
    }
    return 1.0F;
  }
  
  private static boolean je(int paramInt)
  {
    return ((paramInt >= 19968) && (paramInt <= 40959)) || (paramInt == 65292) || (paramInt == 12290) || (paramInt == 65281) || (paramInt == 8220) || (paramInt == 8221) || (paramInt == 65288) || (paramInt == 65289) || (paramInt == 126) || (paramInt == 65311);
  }
  
  public static boolean lC(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramString.length()) {
        break label37;
      }
      if (!je(paramString.codePointAt(i))) {
        break;
      }
      i += 1;
    }
    label37:
    return true;
  }
  
  public static class a
  {
    public aehc.c a;
    public Rect bS;
    public boolean bTQ;
    public boolean bold;
    public int cMW = 0;
    public int cMX = 0;
    public int cMY = 1;
    public int color = -1;
    public int size = 24;
    public ArrayList<aehc.a.a> vk = new ArrayList();
    
    public a(aehc.c paramc, int paramInt1, Rect paramRect, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      this.a = paramc;
      this.color = paramInt1;
      this.size = paramInt2;
      this.bold = paramBoolean;
      this.bS = paramRect;
      this.cMY = paramInt3;
      if (paramc.ref_count > 0) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.bTQ = paramBoolean;
        paramc.ref_count += 1;
        return;
      }
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("text: ").append(this.a.text).append("; size: ").append(this.size).append("; line_count: ").append(this.cMY).append("; container: ").append(this.bS).append("; algin: ").append(this.cMW).append("; v_algin: ").append(this.cMX);
      return localStringBuilder.toString();
    }
    
    public static class a
    {
      public Rect rect;
      public String text;
      
      public a(Rect paramRect, String paramString)
      {
        this.rect = paramRect;
        this.text = paramString;
      }
    }
  }
  
  public static class b
  {
    private Rect bF = new Rect();
    public Rect bS = new Rect();
    private boolean bTR;
    public ArrayList<Rect> fails = new ArrayList();
    public ArrayList<aehc.c> tags = new ArrayList();
    public ArrayList<Rect> vl = new ArrayList();
    public ArrayList<Rect> vm = new ArrayList();
    public ArrayList<Rect> vn = new ArrayList();
    public ArrayList<Rect> vo = new ArrayList();
    public ArrayList<aehc.a> vp = new ArrayList();
    
    private void E(ArrayList<aehc.c> paramArrayList, boolean paramBoolean)
    {
      Collections.sort(paramArrayList, new aehg(this, paramBoolean, paramArrayList));
    }
    
    private void Hr(boolean paramBoolean)
    {
      if (this.vl.isEmpty()) {}
      label21:
      label165:
      label172:
      label175:
      for (;;)
      {
        return;
        new Rect();
        int i = 0;
        Rect localRect1;
        Rect localRect2;
        if ((this.vl.size() > 0) && (i < 100))
        {
          Collections.sort(this.vl, new aehe(this));
          int k = this.vl.size();
          j = 0;
          localRect1 = null;
          localRect2 = null;
          label69:
          if (j >= k) {
            break label172;
          }
          localRect2 = (Rect)this.vl.get(j);
          localRect1 = a(localRect2, paramBoolean);
          if (localRect1 == null) {
            break label165;
          }
        }
        for (int j = 1;; j = 0)
        {
          if ((j == 0) || (localRect2 == null) || (localRect1 == null)) {
            break label175;
          }
          if (localRect1.equals(localRect2)) {
            this.vl.remove(localRect2);
          }
          j(localRect1);
          cWU();
          this.vm.add(localRect1);
          i += 1;
          break label21;
          break;
          j += 1;
          break label69;
        }
      }
    }
    
    private Rect a(aehc.c paramc, Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      int j = paramc.cNa;
      int i = j;
      if (paramc.ref_count >= 1) {
        i = Math.max(24, (int)(j * (0.95F - aehc.sRandom.nextInt(10) / 100.0F))) / 4 * 4;
      }
      Object localObject2 = null;
      j = 1;
      int n = 0;
      int m = i;
      Object localObject3 = localObject2;
      int k = j;
      Object localObject1;
      if (n < 10)
      {
        localObject3 = localObject2;
        k = j;
        if (m >= 24)
        {
          k = (int)(m * paramc.vP);
          localObject1 = localObject2;
          i = j;
          if (paramInt1 * paramInt2 >= m * k)
          {
            localObject3 = paramc.ck.iterator();
            i = j;
            localObject1 = localObject2;
            label142:
            if (((Iterator)localObject3).hasNext())
            {
              i = ((Integer)((Iterator)localObject3).next()).intValue();
              localObject1 = a(paramRect, paramInt1, paramInt2, k / i, m * i, paramInt3, paramInt4, m, 24);
              if (localObject1 == null) {
                break label214;
              }
            }
          }
          if (localObject1 != null) {
            paramRect = (Rect)localObject1;
          }
        }
      }
      for (;;)
      {
        if (paramRect == null)
        {
          return null;
          label214:
          break label142;
          localObject3 = localObject1;
          k = i;
          if (m <= 24) {
            break label324;
          }
          m = Math.max(24, (int)(m * (0.95F - aehc.sRandom.nextInt(6) / 100.0F))) / 4 * 4;
          n += 1;
          localObject2 = localObject1;
          j = i;
          break;
        }
        if ((paramRect != null) && (i > 0))
        {
          paramc = new aehc.a(paramc, -1, paramRect, m, true, i);
          a(paramc, paramRect);
          this.vp.add(paramc);
          return paramRect;
        }
        return null;
        label324:
        paramRect = (Rect)localObject3;
        i = k;
      }
    }
    
    private Rect a(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      if ((paramInt4 <= paramInt2) && (paramInt3 <= paramInt1)) {
        if (paramRect.width() - paramInt3 >= aehc.cMV + 8) {}
      }
      for (;;)
      {
        if (paramRect.height() - paramInt4 < aehc.cMV + 8) {}
        for (;;)
        {
          paramRect = new Rect(paramRect);
          if (paramInt6 == -1) {
            paramRect.bottom = (paramRect.top + paramInt2);
          }
          for (;;)
          {
            if (paramInt5 != -1) {
              break label575;
            }
            paramRect.right = (paramRect.left + paramInt1);
            return paramRect;
            this.bF.set(paramRect);
            label118:
            Rect localRect;
            if (paramInt5 == -1)
            {
              this.bF.left += paramInt3;
              if (!a(this.bF, paramRect, paramInt8)) {
                break label252;
              }
              if (this.bF.width() <= paramInt8 + 8) {
                break label630;
              }
              if (paramInt5 != -1) {
                break label254;
              }
              localRect = this.bF;
              localRect.left += 8;
            }
            for (;;)
            {
              paramInt1 = paramInt3;
              if (a(this.bF, paramRect, paramInt8)) {
                paramInt1 = paramInt3 + 8;
              }
              break;
              if (paramInt5 == 1)
              {
                this.bF.right -= paramInt3;
                break label118;
              }
              this.bF.right = (this.bF.left + (this.bF.width() - paramInt3) / 2);
              break label118;
              label252:
              break;
              label254:
              if (paramInt5 == 1)
              {
                localRect = this.bF;
                localRect.right -= 8;
              }
              else
              {
                localRect = this.bF;
                localRect.right -= 8;
              }
            }
            this.bF.set(paramRect);
            if (paramInt6 == -1)
            {
              this.bF.top += paramInt4;
              label335:
              if (!a(this.bF, paramRect, paramInt8)) {
                break label474;
              }
              if (this.bF.height() <= paramInt8 + 8) {
                break label624;
              }
              if (paramInt6 != -1) {
                break label476;
              }
              localRect = this.bF;
              localRect.top += 8;
            }
            for (;;)
            {
              paramInt2 = paramInt4;
              if (a(this.bF, paramRect, paramInt8)) {
                paramInt2 = paramInt4 + 8;
              }
              break;
              if (paramInt6 == 1)
              {
                this.bF.bottom -= paramInt4;
                break label335;
              }
              this.bF.bottom = (this.bF.top + (this.bF.bottom - this.bF.height()) / 2);
              break label335;
              label474:
              break;
              label476:
              if (paramInt6 == 1)
              {
                localRect = this.bF;
                localRect.bottom -= 8;
              }
              else
              {
                localRect = this.bF;
                localRect.bottom -= 8;
              }
            }
            if (paramInt6 == 1)
            {
              paramRect.top = (paramRect.bottom - paramInt2);
            }
            else
            {
              paramRect.top += (paramRect.height() - paramInt2) / 2;
              paramRect.bottom = (paramRect.top + paramInt2);
            }
          }
          label575:
          if (paramInt5 == 1)
          {
            paramRect.left = (paramRect.right - paramInt1);
            return paramRect;
          }
          paramRect.left += (paramRect.width() - paramInt1) / 2;
          paramRect.right = (paramRect.left + paramInt1);
          return paramRect;
          return null;
          label624:
          paramInt2 = paramInt4;
        }
        label630:
        paramInt1 = paramInt3;
      }
    }
    
    private Rect a(Rect paramRect, boolean paramBoolean)
    {
      int k = paramRect.width() * paramRect.height();
      Iterator localIterator = this.vp.iterator();
      while (localIterator.hasNext())
      {
        aehc.a locala = (aehc.a)localIterator.next();
        int i = locala.bS.width();
        int j = locala.bS.height();
        if (((paramBoolean) || (k * 5 < i * j) || (k <= 576)) && (a(paramRect, locala.bS)))
        {
          locala.bS.union(paramRect);
          a(locala, locala.bS);
          return paramRect;
        }
        if (paramBoolean)
        {
          Rect localRect = new Rect(paramRect);
          j = 0;
          if ((localRect.left <= locala.bS.left) && (localRect.right >= locala.bS.right))
          {
            localRect.left = locala.bS.left;
            localRect.right = locala.bS.right;
            i = 1;
          }
          while ((i != 0) && (a(localRect, locala.bS)))
          {
            locala.bS.union(localRect);
            a(locala, locala.bS);
            return localRect;
            i = j;
            if (paramRect.top <= locala.bS.top)
            {
              i = j;
              if (paramRect.bottom >= locala.bS.bottom)
              {
                localRect.top = locala.bS.top;
                localRect.bottom = locala.bS.bottom;
                i = 1;
              }
            }
          }
        }
      }
      return null;
    }
    
    private void a(aehc.a parama, Rect paramRect)
    {
      parama.vk.clear();
      int i4 = parama.cMY;
      int i5 = parama.size;
      float f2 = parama.a.vP;
      int i3 = 0;
      int i;
      label75:
      int j;
      label97:
      int k;
      if (Math.abs(paramRect.left - this.bS.left) <= 1)
      {
        m = 1;
        if (Math.abs(paramRect.right - this.bS.right) > 1) {
          break label285;
        }
        i = 1;
        if (Math.abs(paramRect.top - this.bS.top) > 1) {
          break label291;
        }
        j = 1;
        if (Math.abs(paramRect.bottom - this.bS.bottom) > 1) {
          break label297;
        }
        k = 1;
      }
      label119:
      Object localObject1;
      Object localObject2;
      int n;
      int i1;
      int i2;
      for (;;)
      {
        if (!this.vn.isEmpty())
        {
          localObject1 = this.vn.iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (Rect)((Iterator)localObject1).next();
              n = i;
              if (Math.abs(((Rect)localObject2).left - paramRect.right) <= 1) {
                n = 1;
              }
              i1 = m;
              if (Math.abs(((Rect)localObject2).right - paramRect.left) <= 1) {
                i1 = 1;
              }
              i2 = k;
              if (Math.abs(((Rect)localObject2).top - paramRect.bottom) <= 1) {
                i2 = 1;
              }
              i = n;
              k = i2;
              m = i1;
              if (Math.abs(((Rect)localObject2).bottom - paramRect.top) <= 1)
              {
                j = 1;
                i = n;
                k = i2;
                m = i1;
                continue;
                m = 0;
                break;
                label285:
                i = 0;
                break label75;
                label291:
                j = 0;
                break label97;
                label297:
                k = 0;
                break label119;
              }
            }
          }
          n = m;
        }
      }
      for (int m = j;; m = j)
      {
        if ((n != 0) && (i != 0))
        {
          j = 1;
          n = 0;
        }
        for (;;)
        {
          if ((m != 0) && (k != 0))
          {
            k = 1;
            i1 = i3;
          }
          for (;;)
          {
            float f1 = 0.0F;
            i2 = parama.a.cMZ / i4;
            f2 = paramRect.width() - i5 * f2 / i4;
            label393:
            label426:
            float f3;
            float f4;
            boolean bool;
            if (i2 <= 1)
            {
              i = (int)(f2 / 2.0F);
              j = i;
              f2 = paramRect.height() - i4 * i5;
              if (i4 > 1) {
                break label895;
              }
              k = (int)(f2 / 2.0F);
              m = k;
              f2 = 0.0F;
              f3 = Math.max(f1, 0.0F);
              i3 = Math.max(j, 0);
              Math.max(i, 0);
              f4 = Math.max(f2, 0.0F);
              i = Math.max(m, 0);
              Math.max(k, 0);
              bool = aehc.sRandom.nextBoolean();
              f1 = i + paramRect.top;
              i = 0;
            }
            for (;;)
            {
              if (i >= i4) {
                break label1032;
              }
              f2 = paramRect.left + i3;
              k = 0;
              label511:
              if (k < i2)
              {
                m = i * i2 + k;
                j = m;
                if (bool)
                {
                  j = m;
                  if (i2 == 2)
                  {
                    j = m;
                    if (i4 > 2) {
                      if (k != 0) {
                        break label1000;
                      }
                    }
                  }
                }
                for (j = i;; j = i4 + i)
                {
                  localObject1 = (Pair)parama.a.vr.get(j);
                  j = Math.round(f2);
                  m = Math.round(f1);
                  float f5 = i5;
                  localObject2 = new aehc.a.a(new Rect(j, m, Math.round(((Float)((Pair)localObject1).second).floatValue() * f5 + f2), Math.round(i5 + f1)), (String)((Pair)localObject1).first);
                  parama.vk.add(localObject2);
                  f5 = i5;
                  float f6 = ((Float)((Pair)localObject1).second).floatValue();
                  k += 1;
                  f2 = f6 * f5 + f2 + f3;
                  break label511;
                  if ((n == 0) && (i == 0)) {
                    break label1055;
                  }
                  if (n != 0) {
                    i = -1;
                  }
                  for (;;)
                  {
                    j = 0;
                    n = i;
                    break;
                    if (i != 0) {
                      i = 1;
                    } else {
                      i = 0;
                    }
                  }
                  if ((m == 0) && (k == 0)) {
                    break label1045;
                  }
                  if (m != 0) {
                    i = -1;
                  }
                  for (;;)
                  {
                    k = 0;
                    i1 = i;
                    break;
                    if (k != 0) {
                      i = 1;
                    } else {
                      i = 0;
                    }
                  }
                  if (j != 0)
                  {
                    i = 0;
                    f1 = (f2 - 0) / (i2 - 1);
                    j = 0;
                    break label393;
                  }
                  if (n == -1)
                  {
                    j = 0;
                    f1 = (f2 - 0) / i2;
                    i = (int)f1;
                    break label393;
                  }
                  if (n == 1)
                  {
                    i = 0;
                    f1 = (f2 - 0) / i2;
                    j = (int)f1;
                    break label393;
                  }
                  f1 = f2 / (i2 + 1);
                  i = (int)f1;
                  j = i;
                  break label393;
                  if (k != 0)
                  {
                    k = 0;
                    f2 = (f2 - 0) / (i4 - 1);
                    m = 0;
                    break label426;
                  }
                  if (i1 == -1)
                  {
                    m = 0;
                    f2 = (f2 - 0) / i4;
                    k = (int)f2;
                    break label426;
                  }
                  if (i1 == 1)
                  {
                    k = 0;
                    f2 = (f2 - 0) / i4;
                    m = (int)f2;
                    break label426;
                  }
                  f2 /= (i4 + 1);
                  k = (int)f2;
                  m = k;
                  break label426;
                }
              }
              label895:
              f2 = i5;
              label1000:
              i += 1;
              f1 = f2 + f1 + f4;
            }
            label1032:
            parama.cMW = n;
            parama.cMX = i1;
            return;
            label1045:
            k = 0;
            i1 = i3;
          }
          label1055:
          j = 0;
          n = 0;
        }
        n = m;
      }
    }
    
    private boolean a(aehc.c paramc, Rect paramRect, int paramInt)
    {
      Iterator localIterator = paramc.ck.iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        if (((paramRect.width() + 8) * localInteger.intValue() >= paramc.vP * paramInt) && (paramRect.height() + 8 >= localInteger.intValue() * paramInt)) {
          return true;
        }
      }
      return false;
    }
    
    private boolean a(Rect paramRect1, Rect paramRect2)
    {
      if ((paramRect1.contains(paramRect2)) || (paramRect2.contains(paramRect1))) {}
      while (((Math.abs(paramRect1.width() - paramRect2.width()) <= 2) && (Math.abs(paramRect1.left - paramRect2.left) <= 2) && (((paramRect1.top < paramRect2.top) && (paramRect1.bottom + 2 > paramRect2.top)) || ((paramRect2.top < paramRect1.top) && (paramRect2.bottom + 2 > paramRect1.top)))) || ((Math.abs(paramRect1.height() - paramRect2.height()) <= 2) && (Math.abs(paramRect1.top - paramRect2.top) <= 2) && (((paramRect1.left < paramRect2.left) && (paramRect1.right + 2 > paramRect2.left)) || ((paramRect2.left < paramRect1.left) && (2 + paramRect2.right > paramRect1.left))))) {
        return true;
      }
      return false;
    }
    
    private boolean a(Rect paramRect1, Rect paramRect2, int paramInt)
    {
      Iterator localIterator = this.tags.iterator();
      while (localIterator.hasNext()) {
        if (a((aehc.c)localIterator.next(), paramRect1, paramInt)) {
          return true;
        }
      }
      localIterator = this.vl.iterator();
      while (localIterator.hasNext())
      {
        Rect localRect = (Rect)localIterator.next();
        if ((localRect != paramRect2) && (a(localRect, paramRect1))) {
          return true;
        }
      }
      return false;
    }
    
    private void b(Rect paramRect1, Rect paramRect2, boolean paramBoolean)
    {
      this.vl.remove(paramRect1);
      if (paramBoolean) {
        this.vo.add(paramRect2);
      }
      if (paramRect2.equals(paramRect1)) {
        return;
      }
      Point localPoint1 = new Point(paramRect1.left, paramRect1.top);
      Point localPoint2 = new Point(paramRect1.left, paramRect1.bottom);
      Point localPoint3 = new Point(paramRect1.right, paramRect1.top);
      Point localPoint4 = new Point(paramRect1.right, paramRect1.bottom);
      Point localPoint5 = new Point(paramRect2.left, paramRect2.top);
      Point localPoint6 = new Point(paramRect2.left, paramRect2.bottom);
      Point localPoint7 = new Point(paramRect2.right, paramRect2.top);
      Point localPoint8 = new Point(paramRect2.right, paramRect2.bottom);
      if ((localPoint1.equals(localPoint5)) && (localPoint2.equals(localPoint6)))
      {
        this.vl.add(new Rect(paramRect2.right, paramRect2.top, paramRect1.right, paramRect1.bottom));
        return;
      }
      if ((localPoint1.equals(localPoint5)) && (localPoint3.equals(localPoint7)))
      {
        this.vl.add(new Rect(paramRect2.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
        return;
      }
      if ((localPoint4.equals(localPoint8)) && (localPoint3.equals(localPoint7)))
      {
        this.vl.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect2.bottom));
        return;
      }
      if ((localPoint2.equals(localPoint6)) && (localPoint4.equals(localPoint8)))
      {
        this.vl.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.right, paramRect2.top));
        return;
      }
      if (localPoint1.equals(localPoint5))
      {
        this.vl.add(new Rect(paramRect2.right, paramRect1.top, paramRect1.right, paramRect1.bottom));
        this.vl.add(new Rect(paramRect1.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
        return;
      }
      if (localPoint3.equals(localPoint7))
      {
        this.vl.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect1.bottom));
        this.vl.add(new Rect(paramRect1.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
        return;
      }
      if (localPoint4.equals(localPoint8))
      {
        this.vl.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect1.bottom));
        this.vl.add(new Rect(paramRect1.left, paramRect1.top, paramRect1.right, paramRect2.top));
        return;
      }
      if (localPoint2.equals(localPoint6))
      {
        this.vl.add(new Rect(paramRect1.left, paramRect1.top, paramRect1.right, paramRect2.top));
        this.vl.add(new Rect(paramRect2.right, paramRect1.top, paramRect1.right, paramRect1.bottom));
        return;
      }
      if ((paramRect1.left == paramRect2.left) && (paramRect1.right == paramRect2.right))
      {
        this.vl.add(new Rect(paramRect1.left, paramRect1.top, paramRect1.right, paramRect2.top));
        this.vl.add(new Rect(paramRect1.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
        return;
      }
      if ((paramRect1.top == paramRect2.top) && (paramRect1.bottom == paramRect2.bottom))
      {
        this.vl.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect1.bottom));
        this.vl.add(new Rect(paramRect2.right, paramRect1.top, paramRect1.right, paramRect1.bottom));
        return;
      }
      if (paramRect1.left == paramRect2.left)
      {
        this.vl.add(new Rect(paramRect1.left, paramRect1.top, paramRect1.right, paramRect2.top));
        this.vl.add(new Rect(paramRect2.right, paramRect1.top, paramRect1.right, paramRect1.bottom));
        this.vl.add(new Rect(paramRect1.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
        return;
      }
      if (paramRect1.top == paramRect2.top)
      {
        this.vl.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect1.bottom));
        this.vl.add(new Rect(paramRect1.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
        this.vl.add(new Rect(paramRect2.right, paramRect1.top, paramRect1.right, paramRect1.bottom));
        return;
      }
      if (paramRect1.right == paramRect2.right)
      {
        this.vl.add(new Rect(paramRect1.left, paramRect1.top, paramRect1.right, paramRect2.top));
        this.vl.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect1.bottom));
        this.vl.add(new Rect(paramRect1.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
        return;
      }
      if (paramRect1.bottom == paramRect2.bottom)
      {
        this.vl.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect1.bottom));
        this.vl.add(new Rect(paramRect1.left, paramRect1.top, paramRect1.right, paramRect2.top));
        this.vl.add(new Rect(paramRect2.right, paramRect1.top, paramRect1.right, paramRect1.bottom));
        return;
      }
      this.vl.add(new Rect(paramRect1.left, paramRect1.top, paramRect1.right, paramRect2.top));
      this.vl.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect1.bottom));
      this.vl.add(new Rect(paramRect2.right, paramRect1.top, paramRect1.right, paramRect1.bottom));
      this.vl.add(new Rect(paramRect1.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
    }
    
    private void cWU()
    {
      if (this.vl.size() <= 1) {
        return;
      }
      int i = this.vl.size() - 1;
      Rect localRect1 = null;
      label24:
      Rect localRect2;
      if (i >= 0)
      {
        localRect2 = (Rect)this.vl.get(i);
        j = i - 1;
        label45:
        if (j < 0) {
          break label138;
        }
        localRect1 = (Rect)this.vl.get(j);
        if (!a(localRect2, localRect1)) {
          break label100;
        }
      }
      label138:
      for (int j = 1;; j = 0)
      {
        if (j != 0)
        {
          localRect1.union(localRect2);
          this.vl.remove(localRect2);
        }
        for (;;)
        {
          i -= 1;
          break label24;
          break;
          label100:
          j -= 1;
          break label45;
          if ((localRect2.width() <= 1) || (localRect2.height() <= 1)) {
            this.vl.remove(localRect2);
          }
        }
      }
    }
    
    private void cWV()
    {
      if (this.vl.isEmpty()) {
        return;
      }
      int i2 = 0;
      new Rect();
      label22:
      Object localObject2;
      int i;
      Object localObject1;
      int j;
      int k;
      Rect localRect;
      int m;
      int n;
      Object localObject3;
      int i1;
      if ((this.vl.size() > 0) && (i2 < 200))
      {
        Collections.sort(this.vl, new aehf(this));
        int i4 = this.vl.size();
        localObject2 = null;
        i = 0;
        localObject1 = null;
        j = -1;
        k = aehc.cMV;
        int i3 = 0;
        while (i3 < i4)
        {
          localRect = (Rect)this.vl.get(i3);
          m = k;
          n = j;
          localObject3 = localObject1;
          i1 = i;
          if (localRect.width() >= aehc.cMV)
          {
            if (localRect.height() < aehc.cMV)
            {
              i1 = i;
              localObject3 = localObject1;
              n = j;
              m = k;
            }
          }
          else
          {
            label159:
            i3 += 1;
            localObject2 = localRect;
            k = m;
            j = n;
            localObject1 = localObject3;
            i = i1;
            continue;
          }
          Iterator localIterator1 = this.tags.iterator();
          while (localIterator1.hasNext())
          {
            localObject3 = (aehc.c)localIterator1.next();
            Iterator localIterator2 = ((aehc.c)localObject3).ck.iterator();
            i1 = i;
            localObject2 = localObject1;
            n = j;
            m = k;
            label247:
            k = m;
            j = n;
            localObject1 = localObject2;
            i = i1;
            if (localIterator2.hasNext())
            {
              localObject1 = (Integer)localIterator2.next();
              if ((localRect.width() * ((Integer)localObject1).intValue() < ((aehc.c)localObject3).vP * aehc.cMV) || (localRect.height() < aehc.cMV * ((Integer)localObject1).intValue())) {
                break label639;
              }
              float f1 = ((aehc.c)localObject3).vP / ((Integer)localObject1).intValue();
              float f2 = ((Integer)localObject1).intValue();
              float f3 = Math.min(localRect.width() / f1, localRect.height() / f2) / 4.0F * 4.0F;
              float f4 = localRect.width();
              float f5 = localRect.height();
              float f6 = localRect.height();
              if ((localRect.width() - f1 * f3) * f6 + (f5 - f2 * f3) * f4 >= 2.147484E+009F) {
                break label639;
              }
              i = (int)f3;
              j = ((Integer)localObject1).intValue();
              k = 1;
              localObject1 = localObject3;
            }
          }
        }
      }
      for (;;)
      {
        m = i;
        n = j;
        localObject2 = localObject1;
        i1 = k;
        break label247;
        m = k;
        n = j;
        localObject3 = localObject1;
        i1 = i;
        if (i == 0) {
          break label159;
        }
        localObject2 = localRect;
        for (;;)
        {
          if ((i == 0) || (localObject2 == null) || (j <= 0) || (localObject1 == null)) {
            break label637;
          }
          this.vl.remove(localObject2);
          localRect = a(localObject2, localObject2.width(), localObject2.height(), (int)(k * ((aehc.c)localObject1).vP / j), k * j, -1, -1, k, aehc.cMV);
          if (localRect == null) {
            break;
          }
          b(localObject2, localRect, true);
          localObject1 = new aehc.a((aehc.c)localObject1, -1, localRect, k, false, j);
          a((aehc.a)localObject1, localRect);
          this.vp.add(localObject1);
          j(localRect);
          cWU();
          i2 += 1;
          break label22;
          break;
        }
        label637:
        break;
        label639:
        i = m;
        j = n;
        localObject1 = localObject2;
        k = i1;
      }
    }
    
    private Rect d(Rect paramRect)
    {
      boolean bool;
      int i;
      int j;
      int m;
      int k;
      label136:
      Object localObject;
      Rect localRect;
      if (this.bTR)
      {
        bool = false;
        i = 0;
        j = 1;
        E(this.tags, bool);
        int n = this.bS.width();
        int i1 = this.bS.height();
        if (this.tags.size() <= 2)
        {
          m = i1;
          k = n;
          if (this.vp.size() < 1) {}
        }
        else
        {
          m = (int)(i1 * 0.85D);
          k = (int)(n * 0.85D);
        }
        m = Math.min(paramRect.width(), m);
        n = Math.min(paramRect.height(), k);
        if (this.bTR)
        {
          k = aehc.sRandom.nextInt(this.tags.size());
          if (k != 0)
          {
            localObject = (aehc.c)this.tags.get(0);
            this.tags.set(0, this.tags.get(k));
            this.tags.set(k, localObject);
          }
          localObject = this.tags.iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localRect = a((aehc.c)((Iterator)localObject).next(), paramRect, m, n, i, j);
          } while (localRect == null);
          return localRect;
        }
      }
      else if (!this.vn.isEmpty())
      {
        localObject = this.vn.iterator();
        j = -1;
        i = -1;
        label257:
        k = j;
        m = i;
        if (!((Iterator)localObject).hasNext()) {
          break label341;
        }
        localRect = (Rect)((Iterator)localObject).next();
        if (localRect.left == paramRect.right)
        {
          k = 1;
          j = i;
          i = k;
        }
      }
      for (;;)
      {
        k = j;
        j = i;
        i = k;
        break label257;
        if (localRect.top == paramRect.bottom)
        {
          i = j;
          j = 1;
          continue;
          k = -1;
          m = -1;
          label341:
          i = m;
          if (Math.abs(paramRect.top - this.bS.top) > Math.abs(paramRect.bottom - this.bS.bottom)) {
            i = 1;
          }
          j = k;
          if (Math.abs(paramRect.left - this.bS.left) > Math.abs(paramRect.right - this.bS.right)) {
            j = 1;
          }
          if (paramRect.width() < paramRect.height())
          {
            bool = true;
            k = i;
            i = j;
            j = k;
            break;
            k = aehc.sRandom.nextInt(Math.min(this.tags.size(), 3));
            break label136;
            return null;
          }
          bool = false;
          k = i;
          i = j;
          j = k;
          break;
        }
        k = i;
        i = j;
        j = k;
      }
    }
    
    private void j(Rect paramRect)
    {
      int i = this.vl.size();
      Rect localRect1 = new Rect();
      i -= 1;
      while (i >= 0)
      {
        Rect localRect2 = (Rect)this.vl.get(i);
        localRect1.set(paramRect);
        if (localRect1.intersect(localRect2)) {
          b(localRect2, localRect1, false);
        }
        i -= 1;
      }
    }
    
    private void reset()
    {
      this.tags.clear();
      this.bS.setEmpty();
      this.vl.clear();
      this.vm.clear();
      this.vn.clear();
      this.vo.clear();
      this.vp.clear();
      this.fails.clear();
      this.bF.setEmpty();
      this.bTR = false;
    }
    
    private Rect t()
    {
      if (this.vl.isEmpty()) {
        localObject = null;
      }
      Rect localRect;
      do
      {
        return localObject;
        Collections.sort(this.vl, new aehd(this));
        localRect = (Rect)this.vl.get(aehc.sRandom.nextInt(Math.min(this.vl.size(), 3)));
        localObject = localRect;
      } while (!this.fails.contains(localRect));
      Object localObject = this.vl.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localRect = (Rect)((Iterator)localObject).next();
        if (!this.fails.contains(localRect)) {
          return localRect;
        }
      }
      return null;
    }
    
    public ArrayList<aehc.a> a(ArrayList<aehc.c> paramArrayList, Rect paramRect, ArrayList<Rect> paramArrayList1)
    {
      reset();
      if ((paramArrayList == null) || (paramArrayList.isEmpty()) || (paramRect == null)) {
        return this.vp;
      }
      System.currentTimeMillis();
      this.tags.addAll(paramArrayList);
      this.bS.set(paramRect);
      if ((paramArrayList1 != null) && (!paramArrayList1.isEmpty())) {
        this.vn.addAll(paramArrayList1);
      }
      for (int i = 1;; i = 0)
      {
        this.vl.add(this.bS);
        if (i != 0)
        {
          paramArrayList = this.vn.iterator();
          while (paramArrayList.hasNext())
          {
            paramRect = (Rect)paramArrayList.next();
            b(this.bS, paramRect, true);
            j(paramRect);
            cWU();
          }
          this.bTR = true;
          paramArrayList = (Rect)this.vl.get(0);
          paramRect = d(paramArrayList);
          if (paramRect != null)
          {
            b(paramArrayList, paramRect, true);
            j(paramRect);
            cWU();
          }
          this.bTR = false;
        }
        i = 0;
        int j = 0;
        if ((this.vl.size() > 0) && (j < 200) && (i < 100))
        {
          j += 1;
          paramArrayList = t();
          if (paramArrayList != null) {}
        }
        else
        {
          Hr(false);
          aehc.cMV = 12;
          paramArrayList = this.tags.iterator();
          i = 1;
          label249:
          if (!paramArrayList.hasNext()) {
            break label341;
          }
          paramRect = (aehc.c)paramArrayList.next();
          paramRect.cWW();
          if (paramRect.cMZ == 13) {
            break label365;
          }
          i = 0;
        }
        label341:
        label365:
        for (;;)
        {
          break label249;
          paramRect = d(paramArrayList);
          if (paramRect == null)
          {
            i += 1;
            this.fails.add(paramArrayList);
            break;
          }
          this.fails.clear();
          b(paramArrayList, paramRect, true);
          j(paramRect);
          cWU();
          break;
          if (i != 0) {
            aehc.cMV = 8;
          }
          cWV();
          Hr(true);
          return this.vp;
        }
      }
    }
  }
  
  public static class c
  {
    public boolean bTT;
    public int cMZ;
    public int cNa = 36;
    Set<Integer> ck = new HashSet();
    public int ref_count;
    public String text;
    public float vP = 1.0F;
    public ArrayList<Pair<String, Float>> vr = new ArrayList();
    
    public c(String paramString)
    {
      this.text = paramString;
      this.bTT = aehc.b(paramString, this.vr);
      this.vP = aehc.d(paramString);
      this.cMZ = this.vr.size();
      this.cNa = hb(this.cMZ);
      this.ck.add(Integer.valueOf(1));
      if (this.bTT)
      {
        this.ck.add(Integer.valueOf(this.cMZ));
        if (this.cMZ % 2 != 0) {
          break label172;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          this.ck.add(Integer.valueOf(2));
          this.ck.add(Integer.valueOf(this.cMZ / 2));
        }
        return;
        label172:
        i = 0;
      }
    }
    
    private int hb(int paramInt)
    {
      if (paramInt <= 2) {
        paramInt = aehc.sRandom.nextInt(8) - 4 + 74;
      }
      for (;;)
      {
        return paramInt / 4 * 4;
        if (paramInt <= 4) {
          paramInt = aehc.sRandom.nextInt(8) - 4 + 70;
        } else if (paramInt <= 6) {
          paramInt = aehc.sRandom.nextInt(8) - 4 + 66;
        } else if (paramInt <= 8) {
          paramInt = aehc.sRandom.nextInt(8) - 4 + 62;
        } else {
          paramInt = aehc.sRandom.nextInt(8) - 4 + 60;
        }
      }
    }
    
    public void cWW()
    {
      if (this.bTT) {
        if (this.cMZ % 3 != 0) {
          break label56;
        }
      }
      label56:
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          this.ck.add(Integer.valueOf(3));
          this.ck.add(Integer.valueOf(this.cMZ / 3));
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aehc
 * JD-Core Version:    0.7.0.1
 */