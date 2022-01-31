import com.tencent.widget.AbsListView;
import java.util.List;

class vit
  implements bfos
{
  int jdField_a_of_type_Int = 0;
  
  vit(vir paramvir) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_a_of_type_Int == vir.a(this.jdField_a_of_type_Vir, vir.a(this.jdField_a_of_type_Vir)).a().size()) && (!vir.a(this.jdField_a_of_type_Vir, vir.a(this.jdField_a_of_type_Vir)).a()))
    {
      paramAbsListView = vir.a(this.jdField_a_of_type_Vir);
      vir.a(this.jdField_a_of_type_Vir, vir.a(this.jdField_a_of_type_Vir)).b(paramAbsListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vit
 * JD-Core Version:    0.7.0.1
 */