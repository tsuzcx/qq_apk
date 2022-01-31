import com.tencent.widget.AbsListView;
import java.util.ArrayList;

class xbh
  implements bhtv
{
  int jdField_a_of_type_Int = 0;
  
  xbh(xbg paramxbg) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 1) {
      bhsj.b(this.jdField_a_of_type_Xbg.a().a());
    }
    while ((paramInt != 0) || (this.jdField_a_of_type_Xbg.a == null) || (this.jdField_a_of_type_Int < this.jdField_a_of_type_Xbg.a.size())) {
      return;
    }
    xbg.a(this.jdField_a_of_type_Xbg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xbh
 * JD-Core Version:    0.7.0.1
 */