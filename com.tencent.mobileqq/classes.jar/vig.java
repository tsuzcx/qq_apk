import com.tencent.widget.AbsListView;
import java.util.ArrayList;

class vig
  implements bfos
{
  int jdField_a_of_type_Int = 0;
  
  vig(vif paramvif) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 1) {
      bfni.b(this.jdField_a_of_type_Vif.a().a());
    }
    while ((paramInt != 0) || (this.jdField_a_of_type_Vif.a == null) || (this.jdField_a_of_type_Int < this.jdField_a_of_type_Vif.a.size())) {
      return;
    }
    vif.a(this.jdField_a_of_type_Vif);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vig
 * JD-Core Version:    0.7.0.1
 */