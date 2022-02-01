import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zfu
  implements AbsListView.OnScrollListener
{
  boolean jdField_a_of_type_Boolean = false;
  
  zfu(zfs paramzfs) {}
  
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
    if ((this.jdField_a_of_type_Boolean) && (paramInt == 0) && (!zfs.a(this.jdField_a_of_type_Zfs)) && (!zfs.b(this.jdField_a_of_type_Zfs)))
    {
      QLog.i(zfs.a(), 1, "onLastItemVisible");
      zfs.a(this.jdField_a_of_type_Zfs, zfs.a(this.jdField_a_of_type_Zfs).a(zfs.a(this.jdField_a_of_type_Zfs)));
      if (zfs.a(this.jdField_a_of_type_Zfs) != null)
      {
        zfs.a(this.jdField_a_of_type_Zfs).a(zfs.a(this.jdField_a_of_type_Zfs), true);
        zfs.a(this.jdField_a_of_type_Zfs, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zfu
 * JD-Core Version:    0.7.0.1
 */