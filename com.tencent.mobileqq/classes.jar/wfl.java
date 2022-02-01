import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.polymerization.QCirclePolymerizationFuelListItemView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import qqcircle.QQCircleFeedBase.StTagPageData;
import qqcircle.QQCircleRankinglist.RankingItem;

class wfl
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private wfl(wfi paramwfi) {}
  
  public int getItemCount()
  {
    if (wfi.a(this.a) == null) {
      return 0;
    }
    return wfi.a(this.a).fuelCircleRankItem.size();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((wfi.a(this.a) == null) || (wfi.a(this.a).fuelCircleRankItem.size() < paramInt)) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      ((wfk)paramViewHolder).a((QQCircleRankinglist.RankingItem)wfi.a(this.a).fuelCircleRankItem.get().get(paramInt), paramInt);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new QCirclePolymerizationFuelListItemView(wfi.a(this.a).getContext());
    paramViewGroup.setReportBean(this.a.a());
    paramViewGroup.a(paramInt);
    return new wfk(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wfl
 * JD-Core Version:    0.7.0.1
 */