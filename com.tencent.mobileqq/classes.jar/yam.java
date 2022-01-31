import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalBottomView;

public class yam
  extends yei
{
  private RelativePersonalBottomView jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView;
  private ydw jdField_a_of_type_Ydw;
  
  public yam(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, ydp paramydp)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView = new RelativePersonalBottomView(paramViewGroup.getContext(), paramydp);
    return this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView;
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(yeb paramyeb) {}
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView != null) {
      return this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView.b();
    }
    return 0;
  }
  
  public void b(String paramString, ydw paramydw)
  {
    super.b(paramString, paramydw);
    this.jdField_a_of_type_Ydw = paramydw;
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView.a(paramydw);
    }
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView.a(this.jdField_a_of_type_Ydw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yam
 * JD-Core Version:    0.7.0.1
 */