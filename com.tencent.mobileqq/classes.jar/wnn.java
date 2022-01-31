import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.qphone.base.util.QLog;

class wnn
  implements AbsListView.OnScrollListener
{
  boolean jdField_a_of_type_Boolean = false;
  
  wnn(wnl paramwnl) {}
  
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
    if ((this.jdField_a_of_type_Boolean) && (paramInt == 0) && (!wnl.a(this.jdField_a_of_type_Wnl)) && (!wnl.b(this.jdField_a_of_type_Wnl)))
    {
      QLog.i(wnl.a(), 1, "onLastItemVisible");
      wnl.a(this.jdField_a_of_type_Wnl, wnl.a(this.jdField_a_of_type_Wnl).a(wnl.a(this.jdField_a_of_type_Wnl)));
      if (wnl.a(this.jdField_a_of_type_Wnl) != null)
      {
        wnl.a(this.jdField_a_of_type_Wnl).a(wnl.a(this.jdField_a_of_type_Wnl), true);
        wnl.a(this.jdField_a_of_type_Wnl, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wnn
 * JD-Core Version:    0.7.0.1
 */