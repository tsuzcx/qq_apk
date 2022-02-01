import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class nah
  extends RecyclerView.Adapter<nai>
  implements naf, nag
{
  private nah.a a;
  private VideoFeedsRecyclerView c;
  private ArrayList<VideoInfo> lt;
  private Activity mActivity;
  private QQAppInterface mApp;
  
  public nah(VideoFeedsRecyclerView paramVideoFeedsRecyclerView, ArrayList<VideoInfo> paramArrayList, Activity paramActivity, QQAppInterface paramQQAppInterface, nah.a parama)
  {
    this.c = paramVideoFeedsRecyclerView;
    this.lt = paramArrayList;
    this.mActivity = paramActivity;
    this.mApp = paramQQAppInterface;
    this.a = parama;
  }
  
  private void a(RecyclerView paramRecyclerView, List<VideoInfo> paramList, int paramInt)
  {
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerView.ViewHolder localViewHolder = paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(i));
      if ((localViewHolder instanceof nai))
      {
        VideoInfo localVideoInfo = (VideoInfo)paramList.get(((nai)localViewHolder).position);
        if ((localVideoInfo.yV()) && (localVideoInfo.a.aHc == paramInt)) {
          ((nai)localViewHolder).aEz();
        }
      }
      i += 1;
    }
  }
  
  private boolean a(RecyclerView paramRecyclerView, List<VideoInfo> paramList, VideoInfo paramVideoInfo)
  {
    int j = paramRecyclerView.getChildCount();
    int k = paramList.indexOf(paramVideoInfo);
    int i = 0;
    while (i < j)
    {
      paramList = paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(i));
      if ((k >= 0) && ((paramList instanceof nai)) && (((nai)paramList).position == k))
      {
        ((nai)paramList).aEz();
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private boolean a(RecyclerView paramRecyclerView, List<VideoInfo> paramList, String paramString)
  {
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerView.ViewHolder localViewHolder = paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(i));
      if (((localViewHolder instanceof nai)) && (paramString.equals(((VideoInfo)paramList.get(((nai)localViewHolder).position)).hH))) {
        ((nai)localViewHolder).aEz();
      }
      i += 1;
    }
    return false;
  }
  
  public nai a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = null;
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    switch (paramInt)
    {
    default: 
      paramViewGroup = localObject;
    }
    for (;;)
    {
      if (this.a != null) {
        this.a.a(paramViewGroup);
      }
      return paramViewGroup;
      paramViewGroup = new nav(localLayoutInflater.inflate(2131560417, paramViewGroup, false), this.mActivity, this.mApp);
      continue;
      paramViewGroup = new kmd(localLayoutInflater.inflate(2131560238, paramViewGroup, false), this.mActivity, this.mApp);
    }
  }
  
  public void a(nai paramnai, int paramInt)
  {
    paramnai.position = paramInt;
    VideoInfo localVideoInfo = (VideoInfo)this.lt.get(paramInt);
    if ((paramnai.itemType == 0) || (paramnai.itemType == 1)) {
      paramnai.d(localVideoInfo);
    }
    if (this.a != null) {
      this.a.a(paramnai, localVideoInfo, paramInt);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramnai, paramInt, getItemId(paramInt));
  }
  
  public int getItemCount()
  {
    return this.lt.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.lt != null) && (this.lt.size() > paramInt) && (((VideoInfo)this.lt.get(paramInt)).isAD)) {
      return 1;
    }
    return 0;
  }
  
  public void i(VideoInfo paramVideoInfo)
  {
    a(this.c, this.lt, paramVideoInfo);
  }
  
  public void m(VideoInfo paramVideoInfo)
  {
    if ((this.lt != null) && (this.lt.contains(paramVideoInfo)))
    {
      int i = this.lt.indexOf(paramVideoInfo);
      this.lt.remove(paramVideoInfo);
      notifyItemRemoved(i);
    }
  }
  
  public void nS(String paramString)
  {
    a(this.c, this.lt, paramString);
  }
  
  public void sw(int paramInt)
  {
    a(this.c, this.lt, paramInt);
  }
  
  public void tc(int paramInt)
  {
    VideoInfo localVideoInfo = (VideoInfo)this.lt.get(paramInt);
    int i = this.c.getChildCount();
    paramInt = 0;
    for (;;)
    {
      if (paramInt < i)
      {
        Object localObject = this.c.getChildViewHolder(this.c.getChildAt(paramInt));
        if ((localObject instanceof naq.b))
        {
          localObject = (naq.b)localObject;
          if (((naq.b)localObject).i() == localVideoInfo) {
            ((naq.b)localObject).aEz();
          }
        }
      }
      else
      {
        return;
      }
      paramInt += 1;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(nai paramnai);
    
    public abstract void a(nai paramnai, VideoInfo paramVideoInfo, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nah
 * JD-Core Version:    0.7.0.1
 */