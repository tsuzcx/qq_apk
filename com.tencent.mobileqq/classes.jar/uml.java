import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class uml
  implements AbsListView.OnScrollListener
{
  boolean jdField_a_of_type_Boolean = false;
  
  uml(umj paramumj) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 > 0) && (paramAbsListView.getFirstVisiblePosition() + paramInt2 >= paramInt3)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    EventCollector.getInstance().onListScrollStateChanged(paramAbsListView, paramInt);
    if ((this.jdField_a_of_type_Boolean) && (paramInt == 0))
    {
      uya.c("comment", "onScrollStateChanged scrollState:" + paramInt);
      umj.a(this.jdField_a_of_type_Umj, this.jdField_a_of_type_Umj.a().a(umj.a(this.jdField_a_of_type_Umj)));
      if (umj.b(this.jdField_a_of_type_Umj) != null)
      {
        this.jdField_a_of_type_Umj.a().a(umj.a(this.jdField_a_of_type_Umj), true);
        umj.a(this.jdField_a_of_type_Umj, true);
      }
    }
    else
    {
      return;
    }
    uya.c("comment", "mCommentAttachInfo is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uml
 * JD-Core Version:    0.7.0.1
 */