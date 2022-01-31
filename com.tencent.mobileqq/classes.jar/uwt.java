import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.widget.ARMapHongBaoListView;

class uwt
  extends RecyclerView.OnScrollListener
{
  boolean jdField_a_of_type_Boolean = false;
  
  uwt(uwn paramuwn) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    paramRecyclerView = (LinearLayoutManager)paramRecyclerView.getLayoutManager();
    if (paramInt == 0)
    {
      if ((paramRecyclerView.findLastCompletelyVisibleItemPosition() == paramRecyclerView.getItemCount() - 1) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_Uwn.jdField_a_of_type_Uvz.d();
      }
      return;
    }
    uwn.a(this.jdField_a_of_type_Uwn);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0) {}
    for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false)
    {
      if (this.jdField_a_of_type_Uwn.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.isDirty()) {
        this.jdField_a_of_type_Uwn.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.invalidate();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uwt
 * JD-Core Version:    0.7.0.1
 */