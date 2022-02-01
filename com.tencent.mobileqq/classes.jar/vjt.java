import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentVideo;

public class vjt
  extends RecyclerView.ViewHolder
{
  QCircleContentVideo jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentVideo;
  
  public vjt(vjn paramvjn, View paramView)
  {
    super(paramView);
    paramvjn = ((FrameLayout)paramView).getChildAt(0);
    if ((paramvjn instanceof QCircleContentVideo))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentVideo = ((QCircleContentVideo)paramvjn);
      return;
    }
    ((FrameLayout)paramView).removeAllViews();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vjt
 * JD-Core Version:    0.7.0.1
 */