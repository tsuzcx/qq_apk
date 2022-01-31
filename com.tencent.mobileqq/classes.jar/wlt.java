import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalBottomView;

public class wlt
  extends wps
{
  private RelativePersonalBottomView jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView;
  private wpf jdField_a_of_type_Wpf;
  
  public wlt(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, woz paramwoz)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView = new RelativePersonalBottomView(paramViewGroup.getContext(), paramwoz);
    return this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView;
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(wpk paramwpk) {}
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView != null) {
      return this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView.c();
    }
    return 0;
  }
  
  public void b(String paramString, wpf paramwpf)
  {
    super.b(paramString, paramwpf);
    this.jdField_a_of_type_Wpf = paramwpf;
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView.a(paramwpf);
    }
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView.a(this.jdField_a_of_type_Wpf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wlt
 * JD-Core Version:    0.7.0.1
 */