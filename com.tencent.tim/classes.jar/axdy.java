import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class axdy
  extends RecyclerView.Adapter<axdy.b>
{
  private List<axby> Mx;
  private axdy.a a;
  private Context mContext;
  private int mSelectedPos;
  private RecyclerView recyclerView;
  
  public axdy(Context paramContext, List<axby> paramList)
  {
    this.mContext = paramContext;
    this.Mx = paramList;
  }
  
  private void adK(int paramInt)
  {
    int i;
    if (this.recyclerView != null)
    {
      LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)this.recyclerView.getLayoutManager();
      i = localLinearLayoutManager.findFirstVisibleItemPosition();
      i = (localLinearLayoutManager.findLastVisibleItemPosition() - i + 1) / 2 + i;
      if (paramInt <= i) {
        break label62;
      }
      this.recyclerView.smoothScrollBy(ayom.dip2px(this.recyclerView.getContext(), 60.0F), 0);
    }
    label62:
    while (paramInt >= i) {
      return;
    }
    this.recyclerView.smoothScrollBy(-ayom.dip2px(this.recyclerView.getContext(), 60.0F), 0);
  }
  
  public axdy.b a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.mContext == null) {
      this.mContext = paramViewGroup.getContext();
    }
    return new axdy.b(LayoutInflater.from(this.mContext).inflate(2131558627, paramViewGroup, false));
  }
  
  public void a(axdy.a parama)
  {
    this.a = parama;
  }
  
  public void a(axdy.b paramb, int paramInt)
  {
    Object localObject2;
    Object localObject1;
    if (paramInt == 0)
    {
      paramb.aK.setImageResource(2130838018);
      paramb.az.setVisibility(8);
      paramb.itemView.setOnClickListener(new axdz(this, paramInt));
      if (paramInt != this.mSelectedPos) {
        break label288;
      }
      localObject2 = axip.a();
      if (paramInt != 0) {
        break label266;
      }
      localObject1 = "none";
      label58:
      ((axip)localObject2).acY((String)localObject1);
      localObject1 = paramb.cA.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = ayom.dip2px(this.mContext, 75.0F);
      ((ViewGroup.LayoutParams)localObject1).height = ayom.dip2px(this.mContext, 75.0F);
      paramb.cA.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramb.cA.setBackgroundResource(2130838039);
      paramb.Ib.setVisibility(0);
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramb, paramInt, getItemId(paramInt));
      return;
      localObject1 = (axby)this.Mx.get(paramInt - 1);
      localObject2 = this.mContext.getResources().getDrawable(2130838042);
      localObject2 = aqqx.a(((axby)localObject1).b.thumbUrl, new int[] { 0 }, (Drawable)localObject2);
      paramb.aK.setImageDrawable((Drawable)localObject2);
      switch (((axby)localObject1).state)
      {
      default: 
        break;
      case 0: 
        paramb.az.setVisibility(8);
        break;
      case 2: 
        paramb.az.setVisibility(8);
        break;
      case 1: 
        paramb.az.setVisibility(0);
        break;
        label266:
        localObject1 = ((axby)this.Mx.get(paramInt - 1)).id;
        break label58;
        label288:
        localObject1 = paramb.cA.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).width = ayom.dip2px(this.mContext, 60.0F);
        ((ViewGroup.LayoutParams)localObject1).height = ayom.dip2px(this.mContext, 60.0F);
        paramb.cA.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramb.cA.setBackgroundResource(2130838038);
        paramb.Ib.setVisibility(4);
      }
    }
  }
  
  public void adJ(int paramInt)
  {
    axiy.i("AEGIFStickerAdapter", "onItemSelectedFromOutside---position=" + paramInt);
    if (paramInt != this.mSelectedPos)
    {
      if (this.recyclerView != null) {
        this.recyclerView.scrollToPosition(paramInt);
      }
      int i = this.mSelectedPos;
      this.mSelectedPos = paramInt;
      notifyItemChanged(paramInt);
      notifyItemChanged(i);
    }
  }
  
  public int getItemCount()
  {
    return this.Mx.size() + 1;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.recyclerView = paramRecyclerView;
  }
  
  public static abstract interface a
  {
    public abstract void c(axby paramaxby);
  }
  
  public static class b
    extends RecyclerView.ViewHolder
  {
    ImageView Ib;
    ImageView aK;
    ProgressBar az;
    FrameLayout cA;
    
    public b(View paramView)
    {
      super();
      this.aK = ((ImageView)paramView.findViewById(2131362309));
      this.cA = ((FrameLayout)paramView.findViewById(2131362306));
      this.Ib = ((ImageView)paramView.findViewById(2131362311));
      this.az = ((ProgressBar)paramView.findViewById(2131362310));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axdy
 * JD-Core Version:    0.7.0.1
 */