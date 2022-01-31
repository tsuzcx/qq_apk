import com.tencent.widget.AbsListView;
import java.util.List;

class viw
  implements bfob
{
  int jdField_a_of_type_Int = 0;
  
  viw(viu paramviu) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_a_of_type_Int == viu.a(this.jdField_a_of_type_Viu, viu.a(this.jdField_a_of_type_Viu)).a().size()) && (!viu.a(this.jdField_a_of_type_Viu, viu.a(this.jdField_a_of_type_Viu)).a()))
    {
      paramAbsListView = viu.a(this.jdField_a_of_type_Viu);
      viu.a(this.jdField_a_of_type_Viu, viu.a(this.jdField_a_of_type_Viu)).b(paramAbsListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     viw
 * JD-Core Version:    0.7.0.1
 */