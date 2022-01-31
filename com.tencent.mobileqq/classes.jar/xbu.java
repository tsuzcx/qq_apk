import com.tencent.widget.AbsListView;
import java.util.List;

class xbu
  implements bhtv
{
  int jdField_a_of_type_Int = 0;
  
  xbu(xbs paramxbs) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_a_of_type_Int == xbs.a(this.jdField_a_of_type_Xbs, xbs.a(this.jdField_a_of_type_Xbs)).a().size()) && (!xbs.a(this.jdField_a_of_type_Xbs, xbs.a(this.jdField_a_of_type_Xbs)).a()))
    {
      paramAbsListView = xbs.a(this.jdField_a_of_type_Xbs);
      xbs.a(this.jdField_a_of_type_Xbs, xbs.a(this.jdField_a_of_type_Xbs)).b(paramAbsListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xbu
 * JD-Core Version:    0.7.0.1
 */