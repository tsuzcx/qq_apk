import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentVideo;

public class txn
  extends RecyclerView.ViewHolder
{
  QCircleContentVideo jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentVideo;
  
  public txn(txj paramtxj, View paramView)
  {
    super(paramView);
    paramtxj = ((FrameLayout)paramView).getChildAt(0);
    if ((paramtxj instanceof QCircleContentVideo))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentVideo = ((QCircleContentVideo)paramtxj);
      return;
    }
    ((FrameLayout)paramView).removeAllViews();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     txn
 * JD-Core Version:    0.7.0.1
 */