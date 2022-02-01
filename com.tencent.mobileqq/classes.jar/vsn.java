import android.util.Log;
import android.view.View;
import com.tencent.biz.qqcircle.polylike.flowlayout.QCircleFlowLayout;
import java.util.HashSet;
import java.util.List;

public abstract class vsn<T>
{
  @Deprecated
  private HashSet<Integer> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private List<T> jdField_a_of_type_JavaUtilList;
  private vso jdField_a_of_type_Vso;
  
  public vsn(List<T> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public abstract View a(QCircleFlowLayout paramQCircleFlowLayout, int paramInt, T paramT);
  
  public T a(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  @Deprecated
  public HashSet<Integer> a()
  {
    return this.jdField_a_of_type_JavaUtilHashSet;
  }
  
  public void a(int paramInt, View paramView)
  {
    Log.d("zhy", "onSelected " + paramInt);
  }
  
  public void a(vso paramvso)
  {
    this.jdField_a_of_type_Vso = paramvso;
  }
  
  public boolean a(int paramInt, T paramT)
  {
    return false;
  }
  
  public void b(int paramInt, View paramView)
  {
    Log.d("zhy", "unSelected " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vsn
 * JD-Core Version:    0.7.0.1
 */