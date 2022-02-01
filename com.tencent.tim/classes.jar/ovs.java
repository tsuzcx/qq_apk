import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.requests.QCircleGetTaskCenterListRequest;
import com.tencent.biz.qqcircle.widgets.QCircleTaskItemView;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import qqcircle.TaskCenterReader.TaskRecord;

public class ovs
  extends rxq<TaskCenterReader.TaskRecord>
{
  private String arE;
  private int[] dH = { 2130844906, 2130844907, 2130844908, 2130844909, 2130844910, 2130844911, 2130844912, 2130844913, 2130844914, 2130844915 };
  LinearLayout eC;
  private RelativeLayout fJ;
  TextView vP;
  
  public ovs(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private RelativeLayout e()
  {
    this.fJ = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131560956, null));
    this.eC = ((LinearLayout)this.fJ.findViewById(2131370715));
    this.vP = ((TextView)this.fJ.findViewById(2131380738));
    this.vP.setOnClickListener(new ovt(this));
    this.fJ.setLayoutParams(new FrameLayout.LayoutParams(-1, ImmersiveUtils.dpToPx(60.0F)));
    return this.fJ;
  }
  
  public int getItemCount()
  {
    return getDataNumber();
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public void loadData(rxt paramrxt)
  {
    if (paramrxt.Mh())
    {
      paramrxt = new QCircleGetTaskCenterListRequest(BaseApplicationImpl.getApplication().getRuntime().getAccount());
      paramrxt.setEnableCache(true);
      VSNetworkHelper.a().a(getContext(), paramrxt, new ovu(this));
    }
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (!auqt.b(paramInt, getDataList())) {
      ((QCircleTaskItemView)paramViewHolder.itemView).setData(getDataList().get(paramInt));
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new rxs.a(this, new QCircleTaskItemView(paramViewGroup.getContext()));
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    setDatas(null);
  }
  
  public void onInitBlock(Bundle paramBundle)
  {
    if (this.fJ == null) {
      addFixViewOccupySpaceAtTop(e(), ImmersiveUtils.dpToPx(60.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ovs
 * JD-Core Version:    0.7.0.1
 */