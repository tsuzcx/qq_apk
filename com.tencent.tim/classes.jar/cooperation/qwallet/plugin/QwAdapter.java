package cooperation.qwallet.plugin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class QwAdapter<V>
  extends BaseAdapter
{
  protected LayoutInflater layoutInflater;
  protected List<V> list;
  private IViewHolder mCloneObj;
  private IViewHolder mHolder;
  protected int resource;
  
  public QwAdapter(Context paramContext, List<V> paramList, int paramInt, IViewHolder paramIViewHolder)
  {
    this.resource = paramInt;
    this.list = paramList;
    this.mCloneObj = paramIViewHolder;
    this.layoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  public int getCount()
  {
    return this.list.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.list.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public List<V> getList()
  {
    return this.list;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = this.layoutInflater.inflate(this.resource, paramViewGroup, false);
    }
    for (;;)
    {
      try
      {
        if (this.mCloneObj != null) {
          this.mHolder = this.mCloneObj.clone();
        }
        this.mHolder.initView(paramInt, paramView);
        paramView.setTag(this.mHolder);
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        Object localObject;
        localCloneNotSupportedException.printStackTrace();
        continue;
      }
      localObject = this.list.get(paramInt);
      this.mHolder.setItemView(paramInt, paramView, localObject);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      this.mHolder = ((IViewHolder)paramView.getTag());
    }
  }
  
  public static abstract interface IViewHolder<V>
    extends Cloneable
  {
    public abstract IViewHolder clone()
      throws CloneNotSupportedException;
    
    public abstract View initView(int paramInt, View paramView);
    
    public abstract void setItemView(int paramInt, View paramView, V paramV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qwallet.plugin.QwAdapter
 * JD-Core Version:    0.7.0.1
 */