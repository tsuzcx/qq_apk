import android.content.Context;
import android.graphics.Canvas;
import com.tencent.biz.qqcircle.bizparts.danmaku.core.PhotoDanmakuDrawer;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public abstract class vem
{
  protected int a;
  protected final PhotoDanmakuDrawer a;
  protected final List<vex> a;
  protected final TreeSet<vex> a;
  protected final vel a;
  protected int b;
  
  protected vem(Context paramContext, vhh paramvhh, vel paramvel, Comparator<vex> paramComparator)
  {
    this.jdField_a_of_type_Vel = paramvel;
    this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuCorePhotoDanmakuDrawer = new PhotoDanmakuDrawer(paramContext, paramvhh);
    this.jdField_a_of_type_JavaUtilTreeSet = new TreeSet(paramComparator);
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    a();
  }
  
  public static vem a(Context paramContext, vhh paramvhh, vel paramvel, Comparator<vex> paramComparator, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return new vew(paramContext, paramvhh, paramvel, paramComparator);
  }
  
  public PhotoDanmakuDrawer a()
  {
    return this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuCorePhotoDanmakuDrawer;
  }
  
  public List<vex> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public abstract vex a(vev paramvev);
  
  public void a()
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_Vel.e;
  }
  
  public void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuCorePhotoDanmakuDrawer.a(paramCanvas);
  }
  
  public void a(vex paramvex)
  {
    this.jdField_a_of_type_JavaUtilTreeSet.add(paramvex);
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
 * Qualified Name:     vem
 * JD-Core Version:    0.7.0.1
 */