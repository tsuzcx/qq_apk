import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.events.QCircleTopTagListEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleFeedBase.StMainPageBusiRspData;

public class phg
  implements rwx
{
  private FeedCloudMeta.StUser jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
  private phg.a jdField_a_of_type_Phg$a;
  private RecyclerView g;
  private List<FeedCloudMeta.StTagInfo> lI;
  
  public void a(Object paramObject, FeedCloudMeta.StUser paramStUser)
  {
    if (paramStUser != null) {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = paramStUser;
    }
    if ((paramObject instanceof QQCircleFeedBase.StMainPageBusiRspData))
    {
      this.lI = ((QQCircleFeedBase.StMainPageBusiRspData)paramObject).recomTagList.get();
      if (this.lI.size() <= 0) {
        break label69;
      }
      this.g.setVisibility(0);
      if (this.jdField_a_of_type_Phg$a != null) {
        this.jdField_a_of_type_Phg$a.setDatas(this.lI);
      }
    }
    return;
    label69:
    this.g.setVisibility(8);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleTopTagListEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleTopTagListEvent)) && (ovd.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)))
    {
      this.lI = ((QCircleTopTagListEvent)paramSimpleBaseEvent).stTagInfos;
      this.jdField_a_of_type_Phg$a.setDatas(this.lI);
    }
  }
  
  public void u(View paramView)
  {
    rwv.a().a(this);
    if (paramView != null)
    {
      this.g = ((RecyclerView)paramView.findViewById(2131374537));
      this.g.setOverScrollMode(2);
      this.g.setVisibility(8);
      paramView = new LinearLayoutManager(paramView.getContext());
      paramView.setOrientation(0);
      this.g.setLayoutManager(paramView);
      this.jdField_a_of_type_Phg$a = new phg.a(null);
      this.g.setAdapter(this.jdField_a_of_type_Phg$a);
    }
  }
  
  class a
    extends RecyclerView.Adapter<phg.a.a>
  {
    public List<FeedCloudMeta.StTagInfo> lJ = new ArrayList();
    
    private a() {}
    
    public phg.a.a a(ViewGroup paramViewGroup, int paramInt)
    {
      return new phg.a.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560905, paramViewGroup, false));
    }
    
    public void a(phg.a.a parama, int paramInt)
    {
      parama.a((FeedCloudMeta.StTagInfo)this.lJ.get(paramInt), paramInt);
      EventCollector.getInstance().onRecyclerBindViewHolder(parama, paramInt, getItemId(paramInt));
    }
    
    public int getItemCount()
    {
      return this.lJ.size();
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public void setDatas(List<FeedCloudMeta.StTagInfo> paramList)
    {
      this.lJ.clear();
      this.lJ.addAll(paramList);
      notifyDataSetChanged();
    }
    
    class a
      extends RecyclerView.ViewHolder
    {
      public RelativeLayout fL;
      public FeedCloudMeta.StTagInfo tagInfo;
      public TextView wK;
      
      public a(View paramView)
      {
        super();
        this.wK = ((TextView)paramView.findViewById(2131370124));
        this.fL = ((RelativeLayout)paramView.findViewById(2131370122));
      }
      
      public void a(FeedCloudMeta.StTagInfo paramStTagInfo, int paramInt)
      {
        if (paramStTagInfo != null)
        {
          this.tagInfo = paramStTagInfo;
          this.wK.setText(paramStTagInfo.tagName.get());
          paramStTagInfo = (FrameLayout.LayoutParams)this.fL.getLayoutParams();
          if (paramInt != 0) {
            break label89;
          }
          paramStTagInfo.setMargins(0, 0, 0, 0);
        }
        for (;;)
        {
          this.fL.setLayoutParams(paramStTagInfo);
          this.fL.setPadding(ankt.dip2px(5.0F), 0, ankt.dip2px(5.0F), 0);
          this.fL.setOnClickListener(new phi(this));
          return;
          label89:
          if (paramInt == phg.a.this.lJ.size() - 1) {
            paramStTagInfo.setMargins(ankt.dip2px(5.0F), 0, ankt.dip2px(38.0F), 0);
          } else {
            paramStTagInfo.setMargins(ankt.dip2px(5.0F), 0, 0, 0);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     phg
 * JD-Core Version:    0.7.0.1
 */