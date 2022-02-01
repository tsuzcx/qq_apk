import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.ArrayList;
import java.util.List;

public class pib
  extends phl
{
  private pib.a a;
  private RecyclerView g;
  private List<FeedCloudMeta.StTagInfo> lI;
  
  public void a(ViewStub paramViewStub)
  {
    if (paramViewStub != null)
    {
      this.mContainer = paramViewStub.inflate();
      this.mContainer.setVisibility(8);
      this.g = ((RecyclerView)this.mContainer.findViewById(2131374530));
      this.g.setOverScrollMode(2);
      paramViewStub = new LinearLayoutManager(this.mContainer.getContext());
      paramViewStub.setOrientation(0);
      this.g.setLayoutManager(paramViewStub);
      this.a = new pib.a(null);
      this.g.setAdapter(this.a);
    }
  }
  
  public void bindData(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof FeedCloudMeta.StFeed))
    {
      this.b.mDataPosition = this.mPos;
      this.b.mFeed = ((FeedCloudMeta.StFeed)paramObject);
      this.b.mPlayScene = 1;
      this.mData = paramObject;
      this.mPos = paramInt;
      this.lI = ((FeedCloudMeta.StFeed)paramObject).tagInfos.get();
      if (this.lI.size() <= 0) {
        break label100;
      }
      this.mContainer.setVisibility(0);
      if (this.a != null) {
        this.a.setDatas(this.lI);
      }
    }
    return;
    label100:
    this.mContainer.setVisibility(8);
  }
  
  class a
    extends RecyclerView.Adapter<pib.a.a>
  {
    public List<FeedCloudMeta.StTagInfo> lJ = new ArrayList();
    
    private a() {}
    
    public pib.a.a a(ViewGroup paramViewGroup, int paramInt)
    {
      return new pib.a.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560905, paramViewGroup, false));
    }
    
    public void a(pib.a.a parama, int paramInt)
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
            break label93;
          }
          paramStTagInfo.setMargins(ankt.dip2px(12.0F), 0, 0, 0);
        }
        for (;;)
        {
          this.fL.setLayoutParams(paramStTagInfo);
          this.fL.setPadding(ankt.dip2px(5.0F), 0, ankt.dip2px(5.0F), 0);
          this.fL.setOnClickListener(new pid(this));
          return;
          label93:
          if (paramInt == pib.a.this.lJ.size() - 1) {
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
 * Qualified Name:     pib
 * JD-Core Version:    0.7.0.1
 */