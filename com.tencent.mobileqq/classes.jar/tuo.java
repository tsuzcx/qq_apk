import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.qphone.base.util.QLog;

class tuo
  implements AbsListView.OnScrollListener
{
  boolean jdField_a_of_type_Boolean = false;
  
  tuo(tuk paramtuk) {}
  
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
    if ((this.jdField_a_of_type_Boolean) && (paramInt == 0) && (!tuk.a(this.jdField_a_of_type_Tuk)) && (!tuk.b(this.jdField_a_of_type_Tuk)))
    {
      QLog.i(tuk.a(), 1, "onLastItemVisible");
      tuk.a(this.jdField_a_of_type_Tuk, this.jdField_a_of_type_Tuk.a().a(tuk.a(this.jdField_a_of_type_Tuk)));
      if (tuk.b(this.jdField_a_of_type_Tuk) != null)
      {
        this.jdField_a_of_type_Tuk.a().a(tuk.a(this.jdField_a_of_type_Tuk), true);
        tuk.a(this.jdField_a_of_type_Tuk, true);
      }
    }
    if (paramInt == 0)
    {
      abqw.a().a("qcircle_comment_page", false);
      return;
    }
    abqw.a().a("qcircle_comment_page");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tuo
 * JD-Core Version:    0.7.0.1
 */