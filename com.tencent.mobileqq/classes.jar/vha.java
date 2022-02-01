import android.content.Context;
import android.graphics.Point;
import com.tencent.biz.qqcircle.bizparts.danmaku.core.PhotoDanmakuDrawer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class vha
  extends vgq
{
  private int[] jdField_a_of_type_ArrayOfInt;
  private vhb[] jdField_a_of_type_ArrayOfVhb;
  private List<List<vhb>> b;
  private final int c;
  private int d;
  
  protected vha(Context paramContext, vjl paramvjl, vgp paramvgp, Comparator<vhb> paramComparator)
  {
    super(paramContext, paramvjl, paramvgp, paramComparator);
    this.c = paramvgp.k;
  }
  
  private void b(vhb paramvhb)
  {
    if (!paramvhb.a()) {
      paramvhb.b(this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuCorePhotoDanmakuDrawer);
    }
  }
  
  public vhb a(vgz paramvgz)
  {
    int j = this.jdField_b_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        vhb localvhb = (vhb)localIterator.next();
        if ((localvhb.d()) && (localvhb.a(paramvgz.jdField_a_of_type_AndroidGraphicsPoint.x, paramvgz.jdField_a_of_type_AndroidGraphicsPoint.y, paramvgz.jdField_a_of_type_Int, paramvgz.jdField_a_of_type_Long)))
        {
          localvhb.b(true);
          return localvhb;
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
      this.d = this.jdField_a_of_type_Vgp.f;
      this.jdField_a_of_type_ArrayOfInt = new int[this.d];
      this.jdField_a_of_type_ArrayOfVhb = new vhb[this.d];
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
      i = 0;
      while (i < this.d)
      {
        LinkedList localLinkedList = new LinkedList();
        this.jdField_b_of_type_JavaUtilList.add(localLinkedList);
        i += 1;
      }
    }
    int k = (int)(PhotoDanmakuDrawer.a(this.jdField_a_of_type_Vgp) + 0.99999F);
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
    vhb localvhb;
    int k;
    int j;
    label86:
    int n;
    int m;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localvhb = (vhb)localIterator.next();
        b(localvhb);
        localIterator.remove();
        if (localvhb.c())
        {
          this.jdField_a_of_type_JavaUtilList.add(localvhb);
        }
        else
        {
          int i1 = localvhb.a(this.d);
          k = 2147483647;
          j = i1;
          if (j >= this.d + i1) {
            break label433;
          }
          n = j;
          while (n >= this.d) {
            n -= this.d;
          }
          if (this.jdField_a_of_type_ArrayOfVhb[n] == null)
          {
            this.jdField_a_of_type_ArrayOfVhb[n] = localvhb;
            ((List)this.jdField_b_of_type_JavaUtilList.get(n)).add(localvhb);
            this.jdField_b_of_type_Int += 1;
            localvhb.a(this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuCorePhotoDanmakuDrawer, this.c, this.jdField_a_of_type_ArrayOfInt[n]);
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
        if (localvhb.a(k))
        {
          this.jdField_a_of_type_ArrayOfVhb[j] = localvhb;
          ((List)this.jdField_b_of_type_JavaUtilList.get(j)).add(localvhb);
          this.jdField_b_of_type_Int += 1;
          localvhb.a(this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuCorePhotoDanmakuDrawer, this.c, this.jdField_a_of_type_ArrayOfInt[j]);
          m = 1;
        }
      }
      if (m == 0) {
        this.jdField_a_of_type_JavaUtilList.add(localvhb);
      }
      i = j;
      break;
      int i2 = vjk.a(this.jdField_a_of_type_ArrayOfVhb[n], localvhb, localvhb.a().a());
      m = k;
      if (i2 < k)
      {
        i = n;
        m = i2;
      }
      if (m < 0)
      {
        this.jdField_a_of_type_ArrayOfVhb[n] = localvhb;
        ((List)this.jdField_b_of_type_JavaUtilList.get(n)).add(localvhb);
        this.jdField_b_of_type_Int += 1;
        localvhb.a(this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuCorePhotoDanmakuDrawer, this.c, this.jdField_a_of_type_ArrayOfInt[n]);
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
        vhb localvhb = (vhb)localIterator.next();
        b(localvhb);
        if ((localvhb.c()) || (!localvhb.b()))
        {
          if (localvhb == this.jdField_a_of_type_ArrayOfVhb[i]) {
            this.jdField_a_of_type_ArrayOfVhb[i] = null;
          }
          localIterator.remove();
          this.jdField_b_of_type_Int -= 1;
          this.jdField_a_of_type_JavaUtilList.add(localvhb);
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
        vhb localvhb = (vhb)localIterator.next();
        localvhb.c();
        localvhb.a(this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuCorePhotoDanmakuDrawer);
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
      this.jdField_a_of_type_ArrayOfVhb[i] = null;
      i += 1;
    }
    int k = this.jdField_b_of_type_JavaUtilList.size();
    i = j;
    while (i < k)
    {
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        vhb localvhb = (vhb)localIterator.next();
        localIterator.remove();
        this.jdField_b_of_type_Int -= 1;
        this.jdField_a_of_type_JavaUtilList.add(localvhb);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vha
 * JD-Core Version:    0.7.0.1
 */