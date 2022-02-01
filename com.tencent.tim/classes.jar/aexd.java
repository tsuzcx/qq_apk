import android.graphics.Canvas;
import android.graphics.Point;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class aexd
  extends aewv
{
  protected int ZY;
  private aexe[] a;
  private int[] ch;
  private List<List<aexe>> ew;
  private int mRowCount;
  
  protected aexd(aexj paramaexj, aeww paramaeww, Comparator<aexe> paramComparator, aeyp paramaeyp, aeyk paramaeyk)
  {
    super(paramaexj, paramaeww, paramComparator, paramaeyp, paramaeyk);
  }
  
  private int a(aexe paramaexe)
  {
    if ((paramaexe == null) || (this.ch == null) || (this.ew == null)) {}
    int j;
    do
    {
      return -1;
      int i = 0;
      j = -1;
      while (i < this.ch.length)
      {
        if (paramaexe.getTop() == this.ch[i]) {
          j = i;
        }
        i += 1;
      }
    } while (this.ew.size() <= j);
    return j;
  }
  
  private void a(aexe paramaexe, int paramInt1, int paramInt2)
  {
    if (paramaexe.isDrawCacheEnable()) {
      this.jdField_a_of_type_Aeww.a(paramaexe, this.jdField_a_of_type_Aexj);
    }
    paramaexe.a(paramInt2, paramInt1, this.jdField_a_of_type_Aeyp.get(), this.jdField_a_of_type_Aeyk.getTime());
  }
  
  private void a(aexx paramaexx)
  {
    if ((this.ch == null) || (this.mRowCount != paramaexx.getRowCount()))
    {
      this.mRowCount = paramaexx.getRowCount();
      this.ch = new int[this.mRowCount];
      paramaexx = new aexe[this.mRowCount];
      if (this.jdField_a_of_type_ArrayOfAexe != null) {
        System.arraycopy(this.jdField_a_of_type_ArrayOfAexe, 0, paramaexx, 0, Math.min(paramaexx.length, this.jdField_a_of_type_ArrayOfAexe.length));
      }
      this.jdField_a_of_type_ArrayOfAexe = paramaexx;
      if (this.ew != null)
      {
        i = this.ew.size();
        if (i < this.mRowCount) {
          while (i < this.mRowCount)
          {
            this.ew.add(new LinkedList());
            i += 1;
          }
        }
        i -= 1;
        while (i >= this.mRowCount)
        {
          this.ew.remove(i);
          i -= 1;
        }
      }
      this.ew = new ArrayList(this.mRowCount);
      i = 0;
      while (i < this.mRowCount)
      {
        this.ew.add(new LinkedList());
        i += 1;
      }
    }
    int j = this.jdField_a_of_type_Aexj.CM();
    StringBuilder localStringBuilder1 = new StringBuilder("[");
    int i = 0;
    if (i < this.mRowCount)
    {
      this.ch[i] = (i * j + this.ZY);
      StringBuilder localStringBuilder2 = localStringBuilder1.append(this.ch[i]);
      if (i != this.mRowCount - 1) {}
      for (paramaexx = ", ";; paramaexx = "")
      {
        localStringBuilder2.append(paramaexx);
        i += 1;
        break;
      }
    }
    localStringBuilder1.append("]");
    aeyw.d("Danmaku_R2LWindow", new Object[] { "reloadConfig, mRowCount = %d, mMarginTop = %d, lineHeight = %d, lineTops = %s", Integer.valueOf(this.mRowCount), Integer.valueOf(this.ZY), Integer.valueOf(j), localStringBuilder1 });
    a(this.ew, this.ch);
  }
  
  private void a(List<List<aexe>> paramList, int[] paramArrayOfInt)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)paramList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        aexh localaexh = (aexh)localIterator.next();
        localaexh.cXT();
        long l = this.jdField_a_of_type_Aeyk.getTime();
        int k = (int)localaexh.getLeft();
        b(localaexh);
        localaexh.ja(l - (int)((localaexh.getScreenWidth() - k) / -localaexh.getSpeedX()));
        localaexh.aH(paramArrayOfInt[i]);
        localaexh.aG(k);
      }
      i += 1;
    }
  }
  
  private boolean a(aexe paramaexe)
  {
    Iterator localIterator = this.ew.iterator();
    while (localIterator.hasNext()) {
      if (((List)localIterator.next()).contains(paramaexe))
      {
        aeyw.d("Danmaku_R2LWindow", new Object[] { paramaexe, " is repeat" });
        return true;
      }
    }
    return false;
  }
  
  private void cXR()
  {
    int i2 = aexj.a().getScreenWidth();
    if (aeyw.LOG_LEVEL >= 5) {
      aeyw.d("Danmaku_R2LWindow", new Object[] { Integer.valueOf(this.c.size()) });
    }
    Iterator localIterator = this.c.iterator();
    int i = 0;
    aexe localaexe;
    int k;
    int j;
    int m;
    label256:
    label299:
    int i1;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localaexe = (aexe)localIterator.next();
        localIterator.remove();
        if ((localaexe.bX(this.jdField_a_of_type_Aeyk.getTime())) || (localaexe.isTimeOut(this.jdField_a_of_type_Aeyp.get())) || (a(localaexe)))
        {
          if (aeyw.LOG_LEVEL >= 5) {
            aeyw.d("Danmaku_R2LWindow", new Object[] { localaexe, " is out side" });
          }
          this.zg.add(localaexe);
        }
        else
        {
          if (!localaexe.isMeasured()) {
            aexc.a(this.jdField_a_of_type_Aexj, localaexe);
          }
          k = localaexe.hf(this.mRowCount);
          if (k >= 0)
          {
            j = k;
            m = 2147483647;
            if (k < 0) {
              break label299;
            }
          }
          for (int n = j + 1;; n = this.mRowCount + j)
          {
            aeyw.i("Danmaku_R2LWindow", "startLayout, startLine = " + j + ", maxLine = " + n + ", danmaku = " + localaexe);
            k = j;
            j = m;
            if (k >= n) {
              break label992;
            }
            m = k;
            while (m >= this.mRowCount) {
              m -= this.mRowCount;
            }
            j = localaexe.getPerferredLine(this.mRowCount);
            break;
          }
          if (aeyw.LOG_LEVEL >= 5)
          {
            aeyw.d("Danmaku_R2LWindow", new Object[] { localaexe, " try layout" });
            i1 = 0;
            if (i1 < this.mRowCount)
            {
              StringBuilder localStringBuilder = new StringBuilder().append("row ").append(i1);
              if (this.jdField_a_of_type_ArrayOfAexe[i1] == null) {}
              for (Object localObject = " null";; localObject = this.jdField_a_of_type_ArrayOfAexe[i1])
              {
                aeyw.d("Danmaku_R2LWindow", localObject);
                i1 += 1;
                break;
              }
            }
          }
          if (this.jdField_a_of_type_ArrayOfAexe[m] == null)
          {
            this.jdField_a_of_type_ArrayOfAexe[m] = localaexe;
            ((List)this.ew.get(m)).add(localaexe);
            this.ZZ += 1;
            a(localaexe, this.ch[m], i2);
            if (aeyw.LOG_LEVEL >= 4) {
              aeyw.d("Danmaku_R2LWindow", new Object[] { localaexe, " layout success:", Integer.valueOf(m), ",top:", Integer.valueOf(this.ch[m]) });
            }
            m = 1;
            k = i;
            i = m;
          }
        }
      }
    }
    for (;;)
    {
      m = i;
      if (i == 0)
      {
        m = i;
        if (localaexe.repeat(j))
        {
          this.jdField_a_of_type_ArrayOfAexe[k] = localaexe;
          ((List)this.ew.get(k)).add(localaexe);
          this.ZZ += 1;
          a(localaexe, this.ch[k], i2);
          if (aeyw.LOG_LEVEL >= 4) {
            aeyw.d("Danmaku_R2LWindow", new Object[] { localaexe, " layout success:", Integer.valueOf(k), ",top:", this.ch[k] + ", danmakuRepeatTime = " + localaexe.getRepeatTime() });
          }
          m = 1;
        }
      }
      if (m == 0)
      {
        this.zg.add(localaexe);
        if (aeyw.LOG_LEVEL >= 4) {
          aeyw.d("Danmaku_R2LWindow", new Object[] { localaexe, " can not in window" });
        }
      }
      if ((localaexe.aiz()) && (m != 0)) {
        aeyw.d("Danmaku_R2LWindow", "must show danmaku layout success :" + localaexe);
      }
      i = k;
      break;
      if (this.jdField_a_of_type_ArrayOfAexe[m].isPaused())
      {
        label800:
        k += 1;
        break label256;
      }
      i1 = aeyu.a(this.jdField_a_of_type_ArrayOfAexe[m], localaexe, this.jdField_a_of_type_Aeyk.getTime());
      if (i1 < j)
      {
        i = m;
        j = i1;
      }
      for (;;)
      {
        if (j < 0)
        {
          this.jdField_a_of_type_ArrayOfAexe[m] = localaexe;
          ((List)this.ew.get(m)).add(localaexe);
          this.ZZ += 1;
          a(localaexe, this.ch[m], i2);
          if (aeyw.LOG_LEVEL >= 4) {
            aeyw.d("Danmaku_R2LWindow", new Object[] { localaexe, " layout success:", Integer.valueOf(m), ",top:", this.ch[m] + ", hitTime = " + j });
          }
          m = 1;
          k = i;
          i = m;
          break;
          return;
        }
        break label800;
      }
      label992:
      m = 0;
      k = i;
      i = m;
    }
  }
  
  private void cXS()
  {
    int j = this.ew.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)this.ew.get(i)).iterator();
      while (localIterator.hasNext())
      {
        aexe localaexe = (aexe)localIterator.next();
        if ((localaexe.bX(this.jdField_a_of_type_Aeyk.getTime())) || (!localaexe.isShown()))
        {
          if (localaexe == this.jdField_a_of_type_ArrayOfAexe[i]) {
            this.jdField_a_of_type_ArrayOfAexe[i] = null;
          }
          localIterator.remove();
          this.ZZ -= 1;
          this.zg.add(localaexe);
        }
      }
      i += 1;
    }
  }
  
  public void Bi()
  {
    aexx localaexx = aexj.a();
    this.ZY = localaexx.CO();
    a(localaexx);
    a(this.ew, this.ch);
  }
  
  public aexe a(aeyr paramaeyr)
  {
    int j = this.ew.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)this.ew.get(i)).iterator();
      while (localIterator.hasNext())
      {
        aexe localaexe = (aexe)localIterator.next();
        if ((localaexe.isClickEnable()) && (localaexe.b(paramaeyr.mPoint.x, paramaeyr.mPoint.y, paramaeyr.cPG, paramaeyr.mTime)))
        {
          if (aeyw.LOG_LEVEL >= 5) {
            aeyw.v("Danmaku_R2LWindow", new Object[] { "onClick:", localaexe, "[left:", Float.valueOf(localaexe.getLeft()), ",top:", Float.valueOf(localaexe.getTop()), "]" });
          }
          return localaexe;
        }
      }
      i += 1;
    }
    aeyw.v("Danmaku_R2LWindow", "onClick:null");
    return null;
  }
  
  public void acg()
  {
    int j = 0;
    int i = 0;
    while (i < this.mRowCount)
    {
      this.jdField_a_of_type_ArrayOfAexe[i] = null;
      i += 1;
    }
    int k = this.ew.size();
    i = j;
    while (i < k)
    {
      Iterator localIterator = ((List)this.ew.get(i)).iterator();
      while (localIterator.hasNext())
      {
        aexe localaexe = (aexe)localIterator.next();
        localIterator.remove();
        this.ZZ -= 1;
        this.zg.add(localaexe);
      }
      i += 1;
    }
  }
  
  public boolean aix()
  {
    if (this.ew != null)
    {
      int j = this.ew.size();
      int i = 0;
      while (i < j)
      {
        List localList = (List)this.ew.get(i);
        if ((localList != null) && (localList.size() > 0)) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public void c(aexe paramaexe)
  {
    int j = a(paramaexe);
    if (j < 0) {}
    for (;;)
    {
      return;
      int i = 0;
      Iterator localIterator = ((List)this.ew.get(j)).iterator();
      while (localIterator.hasNext())
      {
        aexe localaexe = (aexe)localIterator.next();
        j = i;
        if (localaexe == paramaexe) {
          j = 1;
        }
        i = j;
        if (j != 0)
        {
          localaexe.pause();
          i = j;
        }
      }
    }
  }
  
  public void d(aexe paramaexe)
  {
    int i = a(paramaexe);
    if (i < 0) {}
    for (;;)
    {
      return;
      paramaexe = ((List)this.ew.get(i)).iterator();
      while (paramaexe.hasNext()) {
        ((aexe)paramaexe.next()).resume();
      }
    }
  }
  
  public void d(Canvas paramCanvas, long paramLong)
  {
    int j = this.ew.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)this.ew.get(i)).iterator();
      while (localIterator.hasNext())
      {
        aexe localaexe = (aexe)localIterator.next();
        localaexe.ap(this.jdField_a_of_type_Aeyk.be(), this.jdField_a_of_type_Aeyk.getTime());
        if (!localaexe.bY(this.jdField_a_of_type_Aeyk.getTime())) {
          a(paramCanvas, localaexe);
        }
      }
      i += 1;
    }
  }
  
  public void layout()
  {
    cXR();
    cXS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aexd
 * JD-Core Version:    0.7.0.1
 */