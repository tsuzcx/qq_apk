import android.content.Context;
import android.graphics.Point;
import com.tencent.biz.qqcircle.bizparts.danmaku.core.PhotoDanmakuDrawer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class vew
  extends vem
{
  private int[] jdField_a_of_type_ArrayOfInt;
  private vex[] jdField_a_of_type_ArrayOfVex;
  private List<List<vex>> b;
  private final int c;
  private int d;
  
  protected vew(Context paramContext, vhh paramvhh, vel paramvel, Comparator<vex> paramComparator)
  {
    super(paramContext, paramvhh, paramvel, paramComparator);
    this.c = paramvel.k;
  }
  
  private void b(vex paramvex)
  {
    if (!paramvex.a()) {
      paramvex.b(this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuCorePhotoDanmakuDrawer);
    }
  }
  
  public vex a(vev paramvev)
  {
    int j = this.jdField_b_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        vex localvex = (vex)localIterator.next();
        if ((localvex.d()) && (localvex.a(paramvev.jdField_a_of_type_AndroidGraphicsPoint.x, paramvev.jdField_a_of_type_AndroidGraphicsPoint.y, paramvev.jdField_a_of_type_Int, paramvev.jdField_a_of_type_Long)))
        {
          localvex.b(true);
          return localvex;
        }
      }
      i += 1;
    }
    return null;
  }
  
  public void a()
  {
    int j = 0;
    super.a();
    if (this.jdField_a_of_type_ArrayOfInt == null)
    {
      this.d = this.jdField_a_of_type_Vel.f;
      this.jdField_a_of_type_ArrayOfInt = new int[this.d];
      this.jdField_a_of_type_ArrayOfVex = new vex[this.d];
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
      i = 0;
      while (i < this.d)
      {
        LinkedList localLinkedList = new LinkedList();
        this.jdField_b_of_type_JavaUtilList.add(localLinkedList);
        i += 1;
      }
    }
    int k = (int)(PhotoDanmakuDrawer.a(this.jdField_a_of_type_Vel) + 0.99999F);
    int i = j;
    while (i < this.d)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = (i * k + this.jdField_a_of_type_Int);
      i += 1;
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilTreeSet.iterator();
    int i = 0;
    vex localvex;
    int k;
    int j;
    label86:
    int n;
    int m;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localvex = (vex)localIterator.next();
        b(localvex);
        localIterator.remove();
        if (localvex.c())
        {
          this.jdField_a_of_type_JavaUtilList.add(localvex);
        }
        else
        {
          int i1 = localvex.a(this.d);
          k = 2147483647;
          j = i1;
          if (j >= this.d + i1) {
            break label433;
          }
          n = j;
          while (n >= this.d) {
            n -= this.d;
          }
          if (this.jdField_a_of_type_ArrayOfVex[n] == null)
          {
            this.jdField_a_of_type_ArrayOfVex[n] = localvex;
            ((List)this.jdField_b_of_type_JavaUtilList.get(n)).add(localvex);
            this.jdField_b_of_type_Int += 1;
            localvex.a(this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuCorePhotoDanmakuDrawer, this.c, this.jdField_a_of_type_ArrayOfInt[n]);
            m = 1;
            j = i;
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
        if (localvex.a(k))
        {
          this.jdField_a_of_type_ArrayOfVex[j] = localvex;
          ((List)this.jdField_b_of_type_JavaUtilList.get(j)).add(localvex);
          this.jdField_b_of_type_Int += 1;
          localvex.a(this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuCorePhotoDanmakuDrawer, this.c, this.jdField_a_of_type_ArrayOfInt[j]);
          m = 1;
        }
      }
      if (m == 0) {
        this.jdField_a_of_type_JavaUtilList.add(localvex);
      }
      i = j;
      break;
      int i2 = vhg.a(this.jdField_a_of_type_ArrayOfVex[n], localvex, localvex.a().a());
      m = k;
      if (i2 < k)
      {
        i = n;
        m = i2;
      }
      if (m < 0)
      {
        this.jdField_a_of_type_ArrayOfVex[n] = localvex;
        ((List)this.jdField_b_of_type_JavaUtilList.get(n)).add(localvex);
        this.jdField_b_of_type_Int += 1;
        localvex.a(this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuCorePhotoDanmakuDrawer, this.c, this.jdField_a_of_type_ArrayOfInt[n]);
        j = i;
        i = 1;
        k = m;
      }
      else
      {
        j += 1;
        k = m;
        break label86;
        return;
        label433:
        j = i;
        i = 0;
      }
    }
  }
  
  public void c()
  {
    int j = this.jdField_b_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        vex localvex = (vex)localIterator.next();
        b(localvex);
        if ((localvex.c()) || (!localvex.b()))
        {
          if (localvex == this.jdField_a_of_type_ArrayOfVex[i]) {
            this.jdField_a_of_type_ArrayOfVex[i] = null;
          }
          localIterator.remove();
          this.jdField_b_of_type_Int -= 1;
          this.jdField_a_of_type_JavaUtilList.add(localvex);
        }
      }
      i += 1;
    }
  }
  
  public void d()
  {
    int j = this.jdField_b_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        vex localvex = (vex)localIterator.next();
        localvex.c();
        localvex.a(this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuCorePhotoDanmakuDrawer);
      }
      i += 1;
    }
  }
  
  public void e()
  {
    int j = 0;
    int i = 0;
    while (i < this.d)
    {
      this.jdField_a_of_type_ArrayOfVex[i] = null;
      i += 1;
    }
    int k = this.jdField_b_of_type_JavaUtilList.size();
    i = j;
    while (i < k)
    {
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        vex localvex = (vex)localIterator.next();
        localIterator.remove();
        this.jdField_b_of_type_Int -= 1;
        this.jdField_a_of_type_JavaUtilList.add(localvex);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vew
 * JD-Core Version:    0.7.0.1
 */