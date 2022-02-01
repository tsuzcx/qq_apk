import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;

class yok
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int = 0;
  
  yok(yoj paramyoj) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_a_of_type_Yoj.a != null) && (this.jdField_a_of_type_Int == this.jdField_a_of_type_Yoj.a.size() - 1)) {
      this.jdField_a_of_type_Yoj.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yok
 * JD-Core Version:    0.7.0.1
 */