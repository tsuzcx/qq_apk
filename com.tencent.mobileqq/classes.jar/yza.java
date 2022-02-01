import com.tencent.widget.AbsListView;
import java.util.List;

class yza
  implements blih
{
  int jdField_a_of_type_Int = 0;
  
  yza(yyy paramyyy) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_a_of_type_Int == yyy.a(this.jdField_a_of_type_Yyy, yyy.a(this.jdField_a_of_type_Yyy)).a().size()) && (!yyy.a(this.jdField_a_of_type_Yyy, yyy.a(this.jdField_a_of_type_Yyy)).a()))
    {
      paramAbsListView = yyy.a(this.jdField_a_of_type_Yyy);
      yyy.a(this.jdField_a_of_type_Yyy, yyy.a(this.jdField_a_of_type_Yyy)).b(paramAbsListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yza
 * JD-Core Version:    0.7.0.1
 */