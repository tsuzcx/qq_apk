import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class lar<K, D>
  extends RecyclerView.Adapter<auwn>
{
  public final String TAG = "ReadInJoyDynamicChannelAdapter";
  protected RecyclerViewWithHeaderFooter a;
  protected ConcurrentHashMap<K, D> aY = new ConcurrentHashMap();
  protected Map<Integer, String> ee = new HashMap();
  protected int mChannelID;
  protected Context mContext;
  protected List<D> mData = new ArrayList();
  protected VafContext mVafContext = new luh();
  
  public lar(Activity paramActivity, RecyclerViewWithHeaderFooter paramRecyclerViewWithHeaderFooter, int paramInt)
  {
    this.mChannelID = paramInt;
    this.mVafContext.setContext(paramActivity);
    this.mVafContext.setCurActivity(paramActivity);
    kvx.a(this.mVafContext, getServiceId());
    this.mContext = paramActivity;
    this.a = paramRecyclerViewWithHeaderFooter;
  }
  
  public void aIo()
  {
    if (this.aY != null) {
      this.aY.clear();
    }
  }
  
  public void c(K paramK, D paramD)
  {
    if (this.aY != null) {
      this.aY.put(paramK, paramD);
    }
  }
  
  public void ca(List<D> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = this.mData.size();
      this.mData.addAll(paramList);
      notifyItemRangeInserted(i, paramList.size());
    }
  }
  
  public ConcurrentHashMap<K, D> e()
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    if ((this.aY != null) && (!this.aY.isEmpty())) {
      localConcurrentHashMap.putAll(this.aY);
    }
    return localConcurrentHashMap;
  }
  
  protected D g(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.mData.size())) {
      return this.mData.get(paramInt);
    }
    return null;
  }
  
  public int getItemCount()
  {
    if (this.mData != null) {
      return this.mData.size();
    }
    return 0;
  }
  
  protected String getServiceId()
  {
    return "dynamic_feeds_" + this.mChannelID;
  }
  
  public VafContext getVafContext()
  {
    return this.mVafContext;
  }
  
  public void setData(List<D> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.mData.clear();
      this.mData.addAll(paramList);
      notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lar
 * JD-Core Version:    0.7.0.1
 */