import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.qphone.base.util.QLog;

class ybz
  implements AbsListView.OnScrollListener
{
  boolean jdField_a_of_type_Boolean = false;
  
  ybz(ybx paramybx) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 > 0) && (paramAbsListView.getFirstVisiblePosition() + paramInt2 >= paramInt3))
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramInt == 0) && (!ybx.a(this.jdField_a_of_type_Ybx)) && (!ybx.b(this.jdField_a_of_type_Ybx)))
    {
      QLog.i(ybx.a(), 1, "onLastItemVisible");
      ybx.a(this.jdField_a_of_type_Ybx, ybx.a(this.jdField_a_of_type_Ybx).a(ybx.a(this.jdField_a_of_type_Ybx)));
      if (ybx.a(this.jdField_a_of_type_Ybx) != null)
      {
        ybx.a(this.jdField_a_of_type_Ybx).a(ybx.a(this.jdField_a_of_type_Ybx), true);
        ybx.a(this.jdField_a_of_type_Ybx, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ybz
 * JD-Core Version:    0.7.0.1
 */