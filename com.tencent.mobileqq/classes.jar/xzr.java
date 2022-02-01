import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;

class xzr
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int = 0;
  
  xzr(xzq paramxzq) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_a_of_type_Xzq.a != null) && (this.jdField_a_of_type_Int == this.jdField_a_of_type_Xzq.a.size() - 1)) {
      this.jdField_a_of_type_Xzq.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzr
 * JD-Core Version:    0.7.0.1
 */