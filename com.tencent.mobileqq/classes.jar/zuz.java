import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zuz
  implements AbsListView.OnScrollListener
{
  boolean jdField_a_of_type_Boolean = false;
  
  zuz(zux paramzux) {}
  
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
    EventCollector.getInstance().onListScrollStateChanged(paramAbsListView, paramInt);
    if ((this.jdField_a_of_type_Boolean) && (paramInt == 0) && (!zux.a(this.jdField_a_of_type_Zux)) && (!zux.b(this.jdField_a_of_type_Zux)))
    {
      QLog.i(zux.a(), 1, "onLastItemVisible");
      zux.a(this.jdField_a_of_type_Zux, zux.a(this.jdField_a_of_type_Zux).a(zux.a(this.jdField_a_of_type_Zux)));
      if (zux.a(this.jdField_a_of_type_Zux) != null)
      {
        zux.a(this.jdField_a_of_type_Zux).a(zux.a(this.jdField_a_of_type_Zux), true);
        zux.a(this.jdField_a_of_type_Zux, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zuz
 * JD-Core Version:    0.7.0.1
 */