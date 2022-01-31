import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.widget.commodity.CommodityItemView;
import com.tencent.biz.subscribe.widget.commodity.CommodityListView;
import java.util.ArrayList;

public class ykd
  extends ydn
{
  public ykd(CommodityListView paramCommodityListView) {}
  
  public ydo a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new CommodityItemView(this.jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView.getContext());
    paramViewGroup.setIsPublishUI(CommodityListView.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView));
    paramViewGroup.setCurrentFeed(CommodityListView.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView));
    return new ydo(this, paramViewGroup);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (!bhns.a(paramInt, this.jdField_a_of_type_JavaUtilArrayList))
    {
      ((CommodityItemView)paramViewHolder.itemView).setData(this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      ((CommodityItemView)paramViewHolder.itemView).b().setOnClickListener(new yke(this, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ykd
 * JD-Core Version:    0.7.0.1
 */