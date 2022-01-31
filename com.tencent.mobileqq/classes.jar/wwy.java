import com.tencent.widget.AbsListView;
import java.util.ArrayList;

class wwy
  implements bhpo
{
  int jdField_a_of_type_Int = 0;
  
  wwy(wwx paramwwx) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 1) {
      bhoc.b(this.jdField_a_of_type_Wwx.a().a());
    }
    while ((paramInt != 0) || (this.jdField_a_of_type_Wwx.a == null) || (this.jdField_a_of_type_Int < this.jdField_a_of_type_Wwx.a.size())) {
      return;
    }
    wwx.a(this.jdField_a_of_type_Wwx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wwy
 * JD-Core Version:    0.7.0.1
 */