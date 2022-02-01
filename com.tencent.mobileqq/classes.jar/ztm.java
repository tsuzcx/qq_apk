import android.os.Bundle;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalBottomView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ztm
  extends zpo
{
  private RelativePersonalBottomView jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView;
  private zos jdField_a_of_type_Zos;
  
  public ztm(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, zou paramzou)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView = new RelativePersonalBottomView(paramViewGroup.getContext(), paramzou);
    return this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView;
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(zoz paramzoz) {}
  
  public void b(String paramString, zos paramzos)
  {
    super.b(paramString, paramzos);
    this.jdField_a_of_type_Zos = paramzos;
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView.a(paramzos);
    }
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView != null) {
      return this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView.b();
    }
    return 0;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView.a(this.jdField_a_of_type_Zos);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ztm
 * JD-Core Version:    0.7.0.1
 */