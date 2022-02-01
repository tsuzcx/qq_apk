import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.widget.commodity.CommodityItemView;
import com.tencent.biz.subscribe.widget.commodity.CommodityListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;

public class zmi
  extends yzs
{
  public zmi(CommodityListView paramCommodityListView) {}
  
  public yzt a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new CommodityItemView(this.jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView.getContext());
    paramViewGroup.setIsPublishUI(CommodityListView.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView));
    paramViewGroup.setCurrentFeed(CommodityListView.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView));
    return new yzt(this, paramViewGroup);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (!ArrayUtils.isOutOfArrayIndex(paramInt, this.jdField_a_of_type_JavaUtilArrayList))
    {
      ((CommodityItemView)paramViewHolder.itemView).setData(this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      ((CommodityItemView)paramViewHolder.itemView).b().setOnClickListener(new zmj(this, paramInt));
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zmi
 * JD-Core Version:    0.7.0.1
 */