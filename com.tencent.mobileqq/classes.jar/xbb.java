import com.tencent.widget.AbsListView;
import java.util.ArrayList;

class xbb
  implements bhtv
{
  int jdField_a_of_type_Int = 0;
  
  xbb(xba paramxba) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_a_of_type_Xba.a != null) && (this.jdField_a_of_type_Int == this.jdField_a_of_type_Xba.a.size() - 1)) {
      this.jdField_a_of_type_Xba.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xbb
 * JD-Core Version:    0.7.0.1
 */