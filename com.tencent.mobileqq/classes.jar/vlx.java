import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentVideo;

public class vlx
  extends RecyclerView.ViewHolder
{
  QCircleContentVideo jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentVideo;
  
  public vlx(vlr paramvlr, View paramView)
  {
    super(paramView);
    paramvlr = ((FrameLayout)paramView).getChildAt(0);
    if ((paramvlr instanceof QCircleContentVideo))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentVideo = ((QCircleContentVideo)paramvlr);
      return;
    }
    ((FrameLayout)paramView).removeAllViews();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vlx
 * JD-Core Version:    0.7.0.1
 */