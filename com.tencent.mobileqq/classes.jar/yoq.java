import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;

class yoq
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int = 0;
  
  yoq(yop paramyop) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 1) {
      bkxz.b(this.jdField_a_of_type_Yop.a().a());
    }
    while ((paramInt != 0) || (this.jdField_a_of_type_Yop.a == null) || (this.jdField_a_of_type_Int < this.jdField_a_of_type_Yop.a.size())) {
      return;
    }
    yop.a(this.jdField_a_of_type_Yop);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yoq
 * JD-Core Version:    0.7.0.1
 */