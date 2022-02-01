import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.List;

class ypc
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int = 0;
  
  ypc(ypa paramypa) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_a_of_type_Int == ypa.a(this.jdField_a_of_type_Ypa, ypa.a(this.jdField_a_of_type_Ypa)).a().size()) && (!ypa.a(this.jdField_a_of_type_Ypa, ypa.a(this.jdField_a_of_type_Ypa)).a()))
    {
      paramAbsListView = ypa.a(this.jdField_a_of_type_Ypa);
      ypa.a(this.jdField_a_of_type_Ypa, ypa.a(this.jdField_a_of_type_Ypa)).b(paramAbsListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ypc
 * JD-Core Version:    0.7.0.1
 */