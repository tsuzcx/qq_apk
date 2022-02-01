import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;
import java.util.List;

public class sfh
  extends RecyclerView.Adapter<sfh.b>
  implements View.OnClickListener
{
  private final int OE;
  private int UZ;
  sfh.a a;
  Context context;
  private List<sfg> mData;
  SpeedFlexibleRecyclerView recyclerView;
  
  public sfg a()
  {
    if ((this.UZ >= 0) && (this.UZ < this.mData.size())) {
      return (sfg)this.mData.get(this.UZ);
    }
    return null;
  }
  
  public sfh.b a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561132, paramViewGroup, false);
    paramViewGroup.setOnClickListener(this);
    return new sfh.b(paramViewGroup);
  }
  
  public void a(sfh.b paramb, int paramInt)
  {
    paramb.position = paramInt;
    sfg localsfg = (sfg)this.mData.get(paramInt);
    rpq.a(paramb.nY, localsfg.mIconUrl, this.OE, this.OE, this.context.getResources().getDrawable(2130847398), null);
    if ((paramInt == this.UZ) || (localsfg.MG())) {
      paramb.pN.setVisibility(8);
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramb, paramInt, getItemId(paramInt));
      return;
      paramb.pN.setVisibility(0);
    }
  }
  
  public int getItemCount()
  {
    return this.mData.size();
  }
  
  public void onClick(View paramView)
  {
    if (this.a != null)
    {
      int i = this.recyclerView.getChildAdapterPosition(paramView);
      this.a.o(i, paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public static abstract interface a
  {
    public abstract void o(int paramInt, View paramView);
  }
  
  class b
    extends RecyclerView.ViewHolder
  {
    public ImageView nY;
    public View pN;
    public int position = -1;
    public View rootView;
    
    public b(View paramView)
    {
      super();
      this.rootView = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sfh
 * JD-Core Version:    0.7.0.1
 */