import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity.ItemViewHolder;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.OnSlideListener;

public class ghr
  implements SlideDetectListView.OnSlideListener
{
  public ghr(StatusHistoryActivity paramStatusHistoryActivity) {}
  
  public void a(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    if ((StatusHistoryActivity.b(this.a) == 23) && (paramView != null))
    {
      paramView = paramView.getTag();
      if (paramView != null)
      {
        paramView = (StatusHistoryActivity.ItemViewHolder)paramView;
        Button localButton = (Button)paramView.jdField_a_of_type_AndroidViewView;
        localButton.setTag(Integer.valueOf(paramInt));
        localButton.setOnClickListener(StatusHistoryActivity.a(this.a));
        paramSlideDetectListView.setDeleteAreaDim(paramView.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout.getLayoutParams().width, paramView.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout.getLayoutParams().height);
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout.a();
        this.a.a(false);
      }
    }
  }
  
  public void b(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    if (paramView != null)
    {
      paramSlideDetectListView = paramView.getTag();
      if (paramSlideDetectListView != null)
      {
        paramSlideDetectListView = (StatusHistoryActivity.ItemViewHolder)paramSlideDetectListView;
        paramSlideDetectListView.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout.d();
        paramSlideDetectListView.jdField_a_of_type_AndroidViewView.setTag(null);
        paramSlideDetectListView.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
        this.a.a(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ghr
 * JD-Core Version:    0.7.0.1
 */