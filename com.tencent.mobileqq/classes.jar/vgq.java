import android.content.Context;
import android.graphics.Canvas;
import com.tencent.biz.qqcircle.bizparts.danmaku.core.PhotoDanmakuDrawer;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public abstract class vgq
{
  protected int a;
  protected final PhotoDanmakuDrawer a;
  protected final List<vhb> a;
  protected final TreeSet<vhb> a;
  protected final vgp a;
  protected int b;
  
  protected vgq(Context paramContext, vjl paramvjl, vgp paramvgp, Comparator<vhb> paramComparator)
  {
    this.jdField_a_of_type_Vgp = paramvgp;
    this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuCorePhotoDanmakuDrawer = new PhotoDanmakuDrawer(paramContext, paramvjl);
    this.jdField_a_of_type_JavaUtilTreeSet = new TreeSet(paramComparator);
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    a();
  }
  
  public static vgq a(Context paramContext, vjl paramvjl, vgp paramvgp, Comparator<vhb> paramComparator, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return new vha(paramContext, paramvjl, paramvgp, paramComparator);
  }
  
  public PhotoDanmakuDrawer a()
  {
    return this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuCorePhotoDanmakuDrawer;
  }
  
  public List<vhb> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public abstract vhb a(vgz paramvgz);
  
  public void a()
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_Vgp.e;
  }
  
  public void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuCorePhotoDanmakuDrawer.a(paramCanvas);
  }
  
  public void a(vhb paramvhb)
  {
    this.jdField_a_of_type_JavaUtilTreeSet.add(paramvhb);
  }
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract void e();
  
  public void f()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vgq
 * JD-Core Version:    0.7.0.1
 */