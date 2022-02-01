import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.QCirclePushRankTopView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import qqcircle.QQCircleDitto.StCircleDittoDataNew;

public class ovp
  extends ryh
{
  private pdy jdField_a_of_type_Pdy;
  private QQCircleDitto.StCircleDittoDataNew jdField_a_of_type_QqcircleQQCircleDitto$StCircleDittoDataNew;
  
  public ovp(Bundle paramBundle)
  {
    super(paramBundle);
    ur(false);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, rxq paramrxq)
  {
    return new QCirclePushRankTopView(paramViewGroup.getContext());
  }
  
  public void a(pdy parampdy, LifecycleOwner paramLifecycleOwner)
  {
    this.jdField_a_of_type_Pdy = parampdy;
    this.jdField_a_of_type_Pdy.k().observe(paramLifecycleOwner, new ovq(this));
  }
  
  public void loadData(rxt paramrxt) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    ((QCirclePushRankTopView)a()).setData(this.jdField_a_of_type_QqcircleQQCircleDitto$StCircleDittoDataNew);
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ovp
 * JD-Core Version:    0.7.0.1
 */