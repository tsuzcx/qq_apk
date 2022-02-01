import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.view.widget.AbsEmptyView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zsw
  implements View.OnClickListener
{
  public zsw(AbsEmptyView paramAbsEmptyView, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAbsEmptyView.a(3);
    this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zsw
 * JD-Core Version:    0.7.0.1
 */