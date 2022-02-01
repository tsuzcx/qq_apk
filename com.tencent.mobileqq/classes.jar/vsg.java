import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class vsg
  extends RecyclerView.OnScrollListener
{
  public static float a;
  public static int a;
  public static String a;
  public static float b;
  public static int b;
  public static int c = 1;
  private long jdField_a_of_type_Long;
  private final Context jdField_a_of_type_AndroidContentContext;
  private final RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private QCircleFakeAdapter jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter;
  private List<vrw> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int d;
  private int e;
  
  static
  {
    jdField_a_of_type_JavaLangString = "QCircleFeedScrollHelper";
    jdField_a_of_type_Float = 200.0F;
    jdField_b_of_type_Float = 3.0F;
    jdField_a_of_type_Int = -1;
  }
  
  public vsg(Context paramContext, RecyclerView paramRecyclerView, QCircleFakeAdapter paramQCircleFakeAdapter)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter = paramQCircleFakeAdapter;
  }
  
  private void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((vrw)localIterator.next()).a(paramRecyclerView, paramInt1, paramInt2, paramBoolean);
    }
  }
  
  private void a(RecyclerView paramRecyclerView, int paramInt1, RecyclerView.LayoutManager paramLayoutManager, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((vrw)localIterator.next()).a(paramRecyclerView, paramInt1, paramLayoutManager, paramInt2, paramInt3, paramInt4, paramInt5, this.jdField_a_of_type_Boolean);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int[] arrayOfInt = a();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((vrw)localIterator.next()).a(arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], arrayOfInt[3], paramBoolean);
    }
  }
  
  private int[] a()
  {
    int[] arrayOfInt1 = new int[4];
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView == null) {
          break;
        }
        Object localObject1;
        if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager() instanceof zyj))
        {
          Object localObject2 = (zyj)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager();
          localObject1 = ((zyj)localObject2).findFirstVisibleItemPositions(null);
          int[] arrayOfInt2 = ((zyj)localObject2).findLastVisibleItemPositions(null);
          int[] arrayOfInt3 = ((zyj)localObject2).findFirstCompletelyVisibleItemPositions(null);
          localObject2 = ((zyj)localObject2).findLastCompletelyVisibleItemPositions(null);
          arrayOfInt1[0] = localObject1[0];
          arrayOfInt1[1] = arrayOfInt2[0];
          arrayOfInt1[2] = arrayOfInt3[0];
          arrayOfInt1[3] = localObject2[0];
          QLog.d(jdField_a_of_type_JavaLangString, 4, "computePosition result: " + arrayOfInt1[0] + " " + arrayOfInt1[1] + "  " + arrayOfInt1[2] + "  " + arrayOfInt1[3]);
          return arrayOfInt1;
        }
        if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager() instanceof zyh))
        {
          localObject1 = (zyh)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager();
          arrayOfInt1[0] = ((zyh)localObject1).findFirstVisibleItemPosition();
          arrayOfInt1[1] = ((zyh)localObject1).findLastVisibleItemPosition();
          arrayOfInt1[2] = ((zyh)localObject1).findFirstCompletelyVisibleItemPosition();
          arrayOfInt1[3] = ((zyh)localObject1).findLastCompletelyVisibleItemPosition();
          continue;
        }
        if (!(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager() instanceof zyi)) {
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return arrayOfInt1;
      }
      zyi localzyi = (zyi)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager();
      arrayOfInt1[0] = localzyi.findFirstVisibleItemPosition();
      arrayOfInt1[1] = localzyi.findLastVisibleItemPosition();
      arrayOfInt1[2] = localzyi.findFirstCompletelyVisibleItemPosition();
      arrayOfInt1[3] = localzyi.findLastCompletelyVisibleItemPosition();
    }
    return arrayOfInt1;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((vrw)localIterator.next()).a();
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((vrw)localIterator.next()).a(paramInt);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((vrw)localIterator.next()).a(paramViewHolder);
    }
  }
  
  public void a(RecyclerView paramRecyclerView)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((vrw)localIterator.next()).a(paramRecyclerView);
    }
  }
  
  public void a(ExtraTypeInfo paramExtraTypeInfo)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((vrw)localIterator.next()).a(paramExtraTypeInfo);
    }
  }
  
  public void a(vrw paramvrw)
  {
    if (paramvrw != null)
    {
      paramvrw.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter, this);
      this.jdField_a_of_type_JavaUtilList.add(paramvrw);
    }
  }
  
  public void b()
  {
    this.d = jdField_a_of_type_Int;
    this.e = 0;
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void b(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((vrw)localIterator.next()).b(paramInt);
    }
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((vrw)localIterator.next()).b(paramViewHolder);
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((vrw)localIterator.next()).b();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((vrw)localIterator.next()).c();
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((vrw)localIterator.next()).d();
    }
  }
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    RecyclerView.LayoutManager localLayoutManager = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager();
    int[] arrayOfInt = a();
    a(paramRecyclerView, paramInt, localLayoutManager, arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], arrayOfInt[3]);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    if (paramInt2 >= 0)
    {
      this.jdField_a_of_type_Boolean = true;
      if ((this.d != jdField_b_of_type_Int) && (this.d != jdField_a_of_type_Int))
      {
        b();
        QLog.d(jdField_a_of_type_JavaLangString, 4, "change orient to up:" + this.d);
      }
      if (this.jdField_a_of_type_Long == 0L) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      this.e += paramInt2;
      this.d = jdField_b_of_type_Int;
      float f = (float)(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      if (f > jdField_a_of_type_Float)
      {
        b();
        if (Math.abs(this.e / f) < jdField_b_of_type_Float)
        {
          if (paramInt2 < 0) {
            break label265;
          }
          bool1 = true;
          label147:
          a(bool1);
        }
      }
      if (paramInt2 < 0) {
        break label271;
      }
    }
    label265:
    label271:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      a(paramRecyclerView, paramInt1, paramInt2, bool1);
      return;
      this.jdField_a_of_type_Boolean = false;
      if ((this.d != c) && (this.d != jdField_a_of_type_Int))
      {
        b();
        QLog.d(jdField_a_of_type_JavaLangString, 4, "change orient to down:" + this.d);
      }
      if (this.jdField_a_of_type_Long == 0L) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      this.e += paramInt2;
      this.d = c;
      break;
      bool1 = false;
      break label147;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vsg
 * JD-Core Version:    0.7.0.1
 */