import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class yvt<T>
  extends RecyclerView.Adapter<yvx>
{
  protected yvs a;
  protected yvt.a a;
  private yvt.b a;
  private SparseArray<View> bE = new SparseArray();
  private SparseArray<View> bF = new SparseArray();
  protected boolean bpi;
  protected int cbu;
  protected int cbv = -1;
  private int cbw;
  protected Context mContext;
  protected List<T> mDatas = new ArrayList();
  protected View mEmptyView;
  private View yf;
  
  public yvt(Context paramContext)
  {
    this.mContext = paramContext;
    this.jdField_a_of_type_Yvs = new yvs();
  }
  
  private yvt<T> a(yvt.b paramb)
  {
    if (paramb != null) {
      this.jdField_a_of_type_Yvt$b = paramb;
    }
    return this;
  }
  
  public void EG(int paramInt)
  {
    this.cbu = paramInt;
  }
  
  public boolean UD()
  {
    return (this.bpi) && ((this.yf != null) || (this.cbw != 0));
  }
  
  protected boolean UE()
  {
    return ((this.mEmptyView != null) || (this.cbu != 0)) && (getRealItemCount() == 0);
  }
  
  protected boolean UF()
  {
    return this.jdField_a_of_type_Yvs.xH() > 0;
  }
  
  public yvt a(int paramInt)
  {
    this.cbw = paramInt;
    return this;
  }
  
  public yvt a(yvr<T> paramyvr)
  {
    this.jdField_a_of_type_Yvs.a(paramyvr);
    return this;
  }
  
  public yvx a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 2147483646)
    {
      if (this.mEmptyView != null) {
        return yvx.a(paramViewGroup.getContext(), this.mEmptyView);
      }
      return yvx.b(paramViewGroup.getContext(), paramViewGroup, this.cbu);
    }
    if ((paramInt == 2147483645) && (UD()))
    {
      if (this.yf != null) {
        return yvx.a(paramViewGroup.getContext(), this.yf);
      }
      return yvx.b(paramViewGroup.getContext(), paramViewGroup, this.cbw);
    }
    if ((paramInt >= 1000000) && (this.bE != null) && (this.bE.get(paramInt) != null)) {
      return yvx.a(paramViewGroup.getContext(), (View)this.bE.get(paramInt));
    }
    if ((paramInt >= 2000000) && (this.bF != null) && (this.bF.get(paramInt) != null)) {
      return yvx.a(paramViewGroup.getContext(), (View)this.bF.get(paramInt));
    }
    int i = this.jdField_a_of_type_Yvs.a(paramInt).xG();
    yvx localyvx = b(this.mContext, paramViewGroup, i);
    a(localyvx, localyvx.S());
    a(paramViewGroup, localyvx, paramInt);
    return localyvx;
  }
  
  protected void a(ViewGroup paramViewGroup, yvx paramyvx, int paramInt)
  {
    if (!isEnabled(paramInt)) {
      return;
    }
    paramyvx.S().setOnClickListener(new yvv(this, paramyvx));
    paramyvx.S().setOnLongClickListener(new yvw(this, paramyvx));
  }
  
  public void a(yvt.a parama)
  {
    this.jdField_a_of_type_Yvt$a = parama;
  }
  
  public void a(yvt.b paramb)
  {
    if (UD()) {
      return;
    }
    a(paramb);
    this.bpi = true;
    notifyDataSetChanged();
  }
  
  public void a(yvx paramyvx)
  {
    super.onViewAttachedToWindow(paramyvx);
    if ((gN(paramyvx.getLayoutPosition())) || (gO(paramyvx.getLayoutPosition())) || (gP(paramyvx.getLayoutPosition())) || (UE()))
    {
      paramyvx = paramyvx.itemView.getLayoutParams();
      if ((paramyvx != null) && ((paramyvx instanceof StaggeredGridLayoutManager.LayoutParams))) {
        ((StaggeredGridLayoutManager.LayoutParams)paramyvx).setFullSpan(true);
      }
    }
  }
  
  public void a(yvx paramyvx, int paramInt)
  {
    if ((gN(paramInt)) || (gO(paramInt)) || (UE())) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramyvx, paramInt, getItemId(paramInt));
      return;
      if (gP(paramInt))
      {
        if (this.jdField_a_of_type_Yvt$b != null) {
          this.jdField_a_of_type_Yvt$b.cmk();
        }
      }
      else {
        a(paramyvx, k(paramInt));
      }
    }
  }
  
  public void a(yvx paramyvx, View paramView) {}
  
  public void a(yvx paramyvx, T paramT)
  {
    this.jdField_a_of_type_Yvs.a(paramyvx, paramT, paramyvx.getAdapterPosition());
  }
  
  public yvx b(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return yvx.b(paramContext, paramViewGroup, paramInt);
  }
  
  public void clearDatas()
  {
    this.mDatas.clear();
    notifyDataSetChanged();
  }
  
  public void cmj()
  {
    if (UD())
    {
      a(null);
      this.bpi = false;
      notifyDataSetChanged();
    }
  }
  
  protected boolean gN(int paramInt)
  {
    return paramInt < xI();
  }
  
  protected boolean gO(int paramInt)
  {
    return (paramInt >= getRealItemCount() + xI() + xL()) && (paramInt < getRealItemCount() + xI() + xL() + xJ());
  }
  
  protected boolean gP(int paramInt)
  {
    return (UD()) && (paramInt == getRealItemCount() + xI() + xL() + xJ());
  }
  
  public void gQ(List<T> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (UE())
      {
        notifyItemRemoved(this.cbv);
        notifyDataSetChanged();
      }
      int i = xI();
      int j = getRealItemCount();
      this.mDatas.addAll(paramList);
      notifyItemRangeInserted(i + j, paramList.size());
    }
  }
  
  public int getItemCount()
  {
    return xI() + xJ() + getRealItemCount() + xL() + xK();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (gN(paramInt)) {
      return this.bE.keyAt(paramInt);
    }
    if ((UE()) && ((this.cbv == -1) || (paramInt == this.cbv)))
    {
      this.cbv = paramInt;
      return 2147483646;
    }
    if (gO(paramInt)) {
      return this.bF.keyAt(paramInt - xI() - getRealItemCount() - xL());
    }
    if (gP(paramInt)) {
      return 2147483645;
    }
    if (UF()) {
      return this.jdField_a_of_type_Yvs.b(k(paramInt), paramInt);
    }
    return super.getItemViewType(paramInt);
  }
  
  public int getRealItemCount()
  {
    if (this.mDatas == null) {
      return 0;
    }
    return this.mDatas.size();
  }
  
  protected boolean isEnabled(int paramInt)
  {
    return true;
  }
  
  protected T k(int paramInt)
  {
    if (this.mDatas == null) {}
    do
    {
      return null;
      paramInt -= xI();
    } while (paramInt >= this.mDatas.size());
    return this.mDatas.get(paramInt);
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if ((paramRecyclerView instanceof GridLayoutManager))
    {
      paramRecyclerView = (GridLayoutManager)paramRecyclerView;
      paramRecyclerView.setSpanSizeLookup(new yvu(this, paramRecyclerView));
      paramRecyclerView.setSpanCount(paramRecyclerView.getSpanCount());
    }
  }
  
  public void setEmptyView(View paramView)
  {
    this.mEmptyView = paramView;
  }
  
  public int xI()
  {
    if (this.bE != null) {
      return this.bE.size();
    }
    return 0;
  }
  
  public int xJ()
  {
    if (this.bF != null) {
      return this.bF.size();
    }
    return 0;
  }
  
  protected int xK()
  {
    if (UD()) {
      return 1;
    }
    return 0;
  }
  
  protected int xL()
  {
    if (UE()) {
      return 1;
    }
    return 0;
  }
  
  public static abstract interface a
  {
    public abstract void a(View paramView, RecyclerView.ViewHolder paramViewHolder, int paramInt);
    
    public abstract boolean a(View paramView, RecyclerView.ViewHolder paramViewHolder, int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void cmk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yvt
 * JD-Core Version:    0.7.0.1
 */