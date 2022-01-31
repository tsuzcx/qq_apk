import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.qphone.base.util.QLog;

class tvd
  implements AbsListView.OnScrollListener
{
  boolean jdField_a_of_type_Boolean = false;
  
  tvd(tuz paramtuz) {}
  
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
    if ((this.jdField_a_of_type_Boolean) && (paramInt == 0) && (!tuz.a(this.jdField_a_of_type_Tuz)) && (!tuz.b(this.jdField_a_of_type_Tuz)))
    {
      QLog.i("QCircleCommentPanelView", 1, "onLastItemVisible");
      tuz.a(this.jdField_a_of_type_Tuz, this.jdField_a_of_type_Tuz.a().a(tuz.a(this.jdField_a_of_type_Tuz)));
      if (tuz.b(this.jdField_a_of_type_Tuz) != null)
      {
        this.jdField_a_of_type_Tuz.a().a(tuz.a(this.jdField_a_of_type_Tuz), true);
        tuz.a(this.jdField_a_of_type_Tuz, true);
      }
    }
    if (paramInt == 0)
    {
      abvl.a().a("qcircle_comment_page", false);
      return;
    }
    abvl.a().a("qcircle_comment_page");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tvd
 * JD-Core Version:    0.7.0.1
 */