import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.qphone.base.util.QLog;

class wnk
  implements AbsListView.OnScrollListener
{
  boolean jdField_a_of_type_Boolean = false;
  
  wnk(wni paramwni) {}
  
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
    if ((this.jdField_a_of_type_Boolean) && (paramInt == 0) && (!wni.a(this.jdField_a_of_type_Wni)) && (!wni.b(this.jdField_a_of_type_Wni)))
    {
      QLog.i(wni.a(), 1, "onLastItemVisible");
      wni.a(this.jdField_a_of_type_Wni, wni.a(this.jdField_a_of_type_Wni).a(wni.a(this.jdField_a_of_type_Wni)));
      if (wni.a(this.jdField_a_of_type_Wni) != null)
      {
        wni.a(this.jdField_a_of_type_Wni).a(wni.a(this.jdField_a_of_type_Wni), true);
        wni.a(this.jdField_a_of_type_Wni, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wnk
 * JD-Core Version:    0.7.0.1
 */