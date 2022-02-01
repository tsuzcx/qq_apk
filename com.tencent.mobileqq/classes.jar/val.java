import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class val
  implements AbsListView.OnScrollListener
{
  boolean jdField_a_of_type_Boolean = false;
  
  val(vaj paramvaj) {}
  
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
      vmp.c("comment", "onScrollStateChanged scrollState:" + paramInt);
      vaj.a(this.jdField_a_of_type_Vaj, this.jdField_a_of_type_Vaj.a().a(vaj.a(this.jdField_a_of_type_Vaj)));
      if (vaj.b(this.jdField_a_of_type_Vaj) != null)
      {
        this.jdField_a_of_type_Vaj.a().a(vaj.a(this.jdField_a_of_type_Vaj), true);
        vaj.a(this.jdField_a_of_type_Vaj, true);
      }
    }
    else
    {
      return;
    }
    vmp.c("comment", "mCommentAttachInfo is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     val
 * JD-Core Version:    0.7.0.1
 */