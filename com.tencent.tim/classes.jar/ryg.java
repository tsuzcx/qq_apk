import android.os.Bundle;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.richframework.part.extendsblock.HorizontalRvInnerView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public abstract class ryg
  extends rxq
{
  private HorizontalRvInnerView a;
  
  public ryg(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected boolean Mk()
  {
    return false;
  }
  
  public abstract ryg.a a(ViewGroup paramViewGroup, int paramInt);
  
  public abstract void a(HorizontalRvInnerView paramHorizontalRvInnerView);
  
  public abstract void e(RecyclerView.ViewHolder paramViewHolder, int paramInt);
  
  public int getItemCount()
  {
    if ((!Mk()) || (getDataList().size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder.itemView instanceof HorizontalRvInnerView)) {
      this.a.setData(getDataList());
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    this.a = new HorizontalRvInnerView(paramViewGroup.getContext(), this);
    this.a.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    paramViewGroup = new rxs.a(this, this.a);
    paramViewGroup.setIsRecyclable(false);
    a(this.a);
    return paramViewGroup;
  }
  
  public void setDatas(ArrayList paramArrayList)
  {
    getDataList().clear();
    getDataList().addAll(paramArrayList);
    if (this.a != null) {
      this.a.setData(paramArrayList);
    }
  }
  
  public abstract int ug();
  
  public static class a
    extends RecyclerView.ViewHolder
  {
    public a(View paramView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ryg
 * JD-Core Version:    0.7.0.1
 */