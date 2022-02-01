import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.List;

class yaj
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int = 0;
  
  yaj(yah paramyah) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_a_of_type_Int == yah.a(this.jdField_a_of_type_Yah, yah.a(this.jdField_a_of_type_Yah)).a().size()) && (!yah.a(this.jdField_a_of_type_Yah, yah.a(this.jdField_a_of_type_Yah)).a()))
    {
      paramAbsListView = yah.a(this.jdField_a_of_type_Yah);
      yah.a(this.jdField_a_of_type_Yah, yah.a(this.jdField_a_of_type_Yah)).b(paramAbsListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yaj
 * JD-Core Version:    0.7.0.1
 */