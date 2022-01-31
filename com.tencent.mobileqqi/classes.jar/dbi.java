import com.tencent.mobileqq.activity.MayKnowManActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.List;

public class dbi
  implements AbsListView.OnScrollListener
{
  public dbi(MayKnowManActivity paramMayKnowManActivity) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(MayKnowManActivity.jdField_a_of_type_JavaLangString, 2, "onScrollStateChanged:" + paramInt);
    }
    if ((this.a.jdField_a_of_type_JavaUtilList != null) && (paramInt == 0) && (this.a.jdField_a_of_type_Boolean))
    {
      int i = this.a.jdField_a_of_type_ComTencentWidgetXListView.r();
      if (this.a.jdField_a_of_type_JavaUtilList.size() <= i) {
        this.a.c();
      }
    }
    if (this.a.jdField_a_of_type_Dbp != null) {
      this.a.jdField_a_of_type_Dbp.a(paramAbsListView, paramInt);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.jdField_a_of_type_Dbp != null) {
      this.a.jdField_a_of_type_Dbp.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dbi
 * JD-Core Version:    0.7.0.1
 */