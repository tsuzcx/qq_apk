import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class akbg
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private SparseArrayCompat<View> i = new SparseArrayCompat();
  private SparseArrayCompat<View> j = new SparseArrayCompat();
  private RecyclerView.Adapter mAdapter;
  
  public akbg(RecyclerView.Adapter paramAdapter)
  {
    this.mAdapter = paramAdapter;
  }
  
  private int GK()
  {
    return this.mAdapter.getItemCount();
  }
  
  private boolean kG(int paramInt)
  {
    return paramInt < GL();
  }
  
  private boolean kH(int paramInt)
  {
    return paramInt >= GL() + GK();
  }
  
  public int GL()
  {
    return this.i.size();
  }
  
  public int GM()
  {
    return this.j.size();
  }
  
  public void addFooterView(View paramView)
  {
    this.j.put(this.j.size() + 200000, paramView);
  }
  
  public void addHeaderView(View paramView)
  {
    this.i.put(this.i.size() + 100000, paramView);
  }
  
  public RecyclerView.Adapter getAdapter()
  {
    return this.mAdapter;
  }
  
  public int getItemCount()
  {
    return GL() + GK() + GM();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (kG(paramInt)) {
      return this.i.keyAt(paramInt);
    }
    if (kH(paramInt)) {
      return this.j.keyAt(paramInt - GL() - GK());
    }
    return this.mAdapter.getItemViewType(paramInt - GL());
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((kG(paramInt)) || (kH(paramInt))) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      this.mAdapter.onBindViewHolder(paramViewHolder, paramInt - GL());
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.i.get(paramInt) != null) {
      return new akbg.a((View)this.i.get(paramInt));
    }
    if (this.j.get(paramInt) != null) {
      return new akbg.a((View)this.j.get(paramInt));
    }
    return this.mAdapter.onCreateViewHolder(paramViewGroup, paramInt);
  }
  
  static class a
    extends RecyclerView.ViewHolder
  {
    public a(View paramView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akbg
 * JD-Core Version:    0.7.0.1
 */