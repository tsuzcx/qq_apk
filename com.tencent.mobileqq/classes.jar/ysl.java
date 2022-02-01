import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.view.widget.InnerListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ysl
  implements View.OnClickListener
{
  public ysl(InnerListView paramInnerListView, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((InnerListView.a(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView) != null) && (InnerListView.a(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView) != null)) {
      InnerListView.a(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView).a(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView, paramView, this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ysl
 * JD-Core Version:    0.7.0.1
 */