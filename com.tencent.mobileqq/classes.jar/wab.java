import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.qphone.base.util.QLog;

class wab
  implements AbsListView.OnScrollListener
{
  boolean jdField_a_of_type_Boolean = false;
  
  wab(vzz paramvzz) {}
  
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
    if ((this.jdField_a_of_type_Boolean) && (paramInt == 0) && (!vzz.a(this.jdField_a_of_type_Vzz)) && (!vzz.b(this.jdField_a_of_type_Vzz)))
    {
      QLog.i(vzz.a(), 1, "onLastItemVisible");
      vzz.a(this.jdField_a_of_type_Vzz, vzz.a(this.jdField_a_of_type_Vzz).a(vzz.a(this.jdField_a_of_type_Vzz)));
      if (vzz.a(this.jdField_a_of_type_Vzz) != null)
      {
        vzz.a(this.jdField_a_of_type_Vzz).a(vzz.a(this.jdField_a_of_type_Vzz), true);
        vzz.a(this.jdField_a_of_type_Vzz, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wab
 * JD-Core Version:    0.7.0.1
 */