import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.widget.commodity.CommodityItemView;
import com.tencent.biz.subscribe.widget.commodity.CommodityListView;
import java.util.ArrayList;

public class yoq
  extends yhw
{
  public yoq(CommodityListView paramCommodityListView) {}
  
  public yhx a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new CommodityItemView(this.a.getContext());
    paramViewGroup.setIsPublishUI(CommodityListView.a(this.a));
    paramViewGroup.setCurrentFeed(CommodityListView.a(this.a));
    return new yhx(this, paramViewGroup);
  }
  
  public int getItemCount()
  {
    return this.mDataList.size();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (!bhrz.a(paramInt, this.mDataList))
    {
      ((CommodityItemView)paramViewHolder.itemView).setData(this.mDataList.get(paramInt));
      ((CommodityItemView)paramViewHolder.itemView).b().setOnClickListener(new yor(this, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yoq
 * JD-Core Version:    0.7.0.1
 */