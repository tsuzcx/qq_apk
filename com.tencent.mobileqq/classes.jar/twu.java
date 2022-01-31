import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentVideo;

public class twu
  extends RecyclerView.ViewHolder
{
  QCircleContentVideo jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentVideo;
  
  public twu(tws paramtws, View paramView)
  {
    super(paramView);
    paramtws = ((FrameLayout)paramView).getChildAt(0);
    if ((paramtws instanceof QCircleContentVideo))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentVideo = ((QCircleContentVideo)paramtws);
      return;
    }
    ((FrameLayout)paramView).removeAllViews();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     twu
 * JD-Core Version:    0.7.0.1
 */