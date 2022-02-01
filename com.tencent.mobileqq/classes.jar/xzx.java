import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;

class xzx
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int = 0;
  
  xzx(xzw paramxzw) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 1) {
      bjmm.b(this.jdField_a_of_type_Xzw.a().a());
    }
    while ((paramInt != 0) || (this.jdField_a_of_type_Xzw.a == null) || (this.jdField_a_of_type_Int < this.jdField_a_of_type_Xzw.a.size())) {
      return;
    }
    xzw.a(this.jdField_a_of_type_Xzw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzx
 * JD-Core Version:    0.7.0.1
 */