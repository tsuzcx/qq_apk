import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.tencent.biz.videostory.capture.widgets.AEPlayShowPageView;

public class wvx
  extends RecyclerView.ItemDecoration
{
  public wvx(AEPlayShowPageView paramAEPlayShowPageView, wrq paramwrq) {}
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    if (AEPlayShowPageView.a(this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEPlayShowPageView) != 1)
    {
      paramRect.left = this.jdField_a_of_type_Wrq.c;
      paramRect.right = this.jdField_a_of_type_Wrq.c;
      paramRect.top = this.jdField_a_of_type_Wrq.d;
      paramRect.bottom = this.jdField_a_of_type_Wrq.d;
      return;
    }
    paramRect.bottom = this.jdField_a_of_type_Wrq.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wvx
 * JD-Core Version:    0.7.0.1
 */