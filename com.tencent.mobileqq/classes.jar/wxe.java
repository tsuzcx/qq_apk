import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class wxe
  implements AbsListView.OnScrollListener
{
  public wxe(PhotoListActivity paramPhotoListActivity) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.a.jdField_a_of_type_ComTencentWidgetGestureSelectGridView != null) && (this.a.jdField_a_of_type_Wxw != null) && (this.a.c != null)) {
      PhotoListActivity.a(this.a);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wxe
 * JD-Core Version:    0.7.0.1
 */