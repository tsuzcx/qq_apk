package me.ele.uetool.recyclerview;

import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import me.ele.uetool.util.JarResource;

public class UniversalAdapter
  extends RecyclerView.Adapter<ViewPool>
  implements View.OnClickListener, View.OnLongClickListener
{
  private List<BaseItem> data = new ArrayList();
  private OnItemClickListener listener;
  private OnItemLongClickListener longListener;
  
  public void clearItems()
  {
    this.data.clear();
    notifyDataSetChanged();
  }
  
  public <T extends BaseItem> T getItem(int paramInt)
  {
    return (BaseItem)this.data.get(paramInt);
  }
  
  public int getItemCount()
  {
    return this.data.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((BaseItem)this.data.get(paramInt)).getLayout();
  }
  
  public List<BaseItem> getItems()
  {
    return this.data;
  }
  
  public void insertItem(BaseItem paramBaseItem)
  {
    this.data.add(paramBaseItem);
    notifyDataSetChanged();
  }
  
  public void insertItem(BaseItem paramBaseItem, int paramInt)
  {
    this.data.add(paramInt, paramBaseItem);
    notifyDataSetChanged();
  }
  
  public void insertItems(List<? extends BaseItem> paramList, int paramInt)
  {
    this.data.addAll(paramInt, paramList);
    notifyDataSetChanged();
  }
  
  public void onBindViewHolder(ViewPool paramViewPool, int paramInt)
  {
    paramViewPool.itemView.setTag(JarResource.getIdByName("id", "pd_recycler_adapter_id"), Integer.valueOf(paramInt));
    ((BaseItem)this.data.get(paramInt)).onBinding(paramInt, paramViewPool, ((BaseItem)this.data.get(paramInt)).data);
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewPool, paramInt, getItemId(paramInt));
  }
  
  public void onClick(View paramView)
  {
    if (this.listener != null)
    {
      int i = ((Integer)paramView.getTag(JarResource.getIdByName("id", "pd_recycler_adapter_id"))).intValue();
      this.listener.onItemClick(i, (BaseItem)this.data.get(i));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public ViewPool onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false);
    paramViewGroup.setOnClickListener(this);
    paramViewGroup.setOnLongClickListener(this);
    return new ViewPool(paramViewGroup);
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.longListener != null)
    {
      int i = ((Integer)paramView.getTag(JarResource.getIdByName("id", "pd_recycler_adapter_id"))).intValue();
      return this.longListener.onItemLongClick(i, (BaseItem)this.data.get(i));
    }
    return false;
  }
  
  public void performClick(int paramInt)
  {
    if (this.listener != null) {
      this.listener.onItemClick(paramInt, (BaseItem)this.data.get(paramInt));
    }
  }
  
  public void removeItem(int paramInt)
  {
    this.data.remove(paramInt);
    notifyItemRemoved(paramInt);
    notifyItemRangeChanged(paramInt, getItemCount() - paramInt);
  }
  
  public void setItems(List<? extends BaseItem> paramList)
  {
    this.data.clear();
    this.data.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void setListener(OnItemClickListener paramOnItemClickListener)
  {
    this.listener = paramOnItemClickListener;
  }
  
  public void setLongClickListener(OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.longListener = paramOnItemLongClickListener;
  }
  
  public static abstract interface OnItemClickListener
  {
    public abstract void onItemClick(int paramInt, BaseItem paramBaseItem);
  }
  
  public static abstract interface OnItemLongClickListener
  {
    public abstract boolean onItemLongClick(int paramInt, BaseItem paramBaseItem);
  }
  
  public static final class ViewPool
    extends RecyclerView.ViewHolder
  {
    private final SparseArray<View> views = new SparseArray();
    
    public ViewPool(View paramView)
    {
      super();
    }
    
    public <T extends View> T getView(@IdRes int paramInt)
    {
      if (paramInt == -1) {
        throw new RuntimeException("id is invalid");
      }
      View localView2 = (View)this.views.get(paramInt);
      View localView1 = localView2;
      if (localView2 == null)
      {
        localView1 = this.itemView.findViewById(paramInt);
        this.views.put(paramInt, localView1);
      }
      return localView1;
    }
    
    public ViewPool setBackgroundColor(@IdRes int paramInt1, @ColorInt int paramInt2)
    {
      getView(paramInt1).setBackgroundColor(paramInt2);
      return this;
    }
    
    public ViewPool setCompoundDrawableLeft(@IdRes int paramInt1, @DrawableRes int paramInt2)
    {
      ((TextView)getView(paramInt1)).setCompoundDrawablesWithIntrinsicBounds(paramInt2, 0, 0, 0);
      return this;
    }
    
    public ViewPool setImageResource(@IdRes int paramInt1, @DrawableRes int paramInt2)
    {
      ((ImageView)getView(paramInt1)).setImageResource(paramInt2);
      return this;
    }
    
    public ViewPool setText(@IdRes int paramInt, String paramString)
    {
      ((TextView)getView(paramInt)).setText(paramString);
      return this;
    }
    
    public ViewPool setTextColor(@IdRes int paramInt1, @ColorInt int paramInt2)
    {
      ((TextView)getView(paramInt1)).setTextColor(paramInt2);
      return this;
    }
    
    public ViewPool setTextGravity(@IdRes int paramInt1, int paramInt2)
    {
      ((TextView)getView(paramInt1)).setGravity(paramInt2);
      return this;
    }
    
    public ViewPool setVisibility(@IdRes int paramInt1, int paramInt2)
    {
      getView(paramInt1).setVisibility(paramInt2);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.recyclerview.UniversalAdapter
 * JD-Core Version:    0.7.0.1
 */