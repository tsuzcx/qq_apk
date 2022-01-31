import com.tencent.widget.AbsListView;
import java.util.List;

class wxl
  implements bhpo
{
  int jdField_a_of_type_Int = 0;
  
  wxl(wxj paramwxj) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_a_of_type_Int == wxj.a(this.jdField_a_of_type_Wxj, wxj.a(this.jdField_a_of_type_Wxj)).a().size()) && (!wxj.a(this.jdField_a_of_type_Wxj, wxj.a(this.jdField_a_of_type_Wxj)).a()))
    {
      paramAbsListView = wxj.a(this.jdField_a_of_type_Wxj);
      wxj.a(this.jdField_a_of_type_Wxj, wxj.a(this.jdField_a_of_type_Wxj)).b(paramAbsListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wxl
 * JD-Core Version:    0.7.0.1
 */