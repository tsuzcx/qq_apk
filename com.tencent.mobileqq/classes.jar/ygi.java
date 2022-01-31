import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.qphone.base.util.QLog;

class ygi
  implements AbsListView.OnScrollListener
{
  boolean jdField_a_of_type_Boolean = false;
  
  ygi(ygg paramygg) {}
  
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
    if ((this.jdField_a_of_type_Boolean) && (paramInt == 0) && (!ygg.a(this.jdField_a_of_type_Ygg)) && (!ygg.b(this.jdField_a_of_type_Ygg)))
    {
      QLog.i(ygg.a(), 1, "onLastItemVisible");
      ygg.a(this.jdField_a_of_type_Ygg, ygg.a(this.jdField_a_of_type_Ygg).a(ygg.a(this.jdField_a_of_type_Ygg)));
      if (ygg.a(this.jdField_a_of_type_Ygg) != null)
      {
        ygg.a(this.jdField_a_of_type_Ygg).a(ygg.a(this.jdField_a_of_type_Ygg), true);
        ygg.a(this.jdField_a_of_type_Ygg, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ygi
 * JD-Core Version:    0.7.0.1
 */