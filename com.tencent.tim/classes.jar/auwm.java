import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public abstract class auwm<M, VH extends auwn<M>>
  extends auwo<M, VH>
{
  private List<M> jl = new ArrayList();
  
  public auwm(Context paramContext)
  {
    super(paramContext);
  }
  
  public auwm(Context paramContext, List<M> paramList)
  {
    super(paramContext);
    this.jl.addAll(paramList);
  }
  
  public boolean D(List<M> paramList)
  {
    if (!this.jl.isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      this.jl.clear();
      boolean bool = i | this.jl.addAll(paramList);
      if (bool) {
        notifyDataSetChanged();
      }
      return bool;
    }
  }
  
  public boolean E(List<M> paramList)
  {
    boolean bool = this.jl.addAll(paramList);
    if (bool) {
      notifyItemRangeInserted(this.jl.size() - paramList.size(), paramList.size());
    }
    return bool;
  }
  
  public int Pb()
  {
    return this.jl.size();
  }
  
  public void YW()
  {
    this.jl.clear();
    notifyDataSetChanged();
  }
  
  public void aj(M paramM)
  {
    int i = this.jl.indexOf(paramM);
    if (i < 0) {
      return;
    }
    this.jl.remove(i);
    if (this.bK == null)
    {
      notifyItemRemoved(i);
      return;
    }
    notifyItemRemoved(i + 1);
  }
  
  public List<M> be()
  {
    return this.jl;
  }
  
  public abstract int dr(int paramInt);
  
  public M getItem(int paramInt)
  {
    if (((this.bK != null) && (paramInt == 0)) || (paramInt >= this.jl.size() + st())) {
      return null;
    }
    if (this.bK == null) {
      return this.jl.get(paramInt);
    }
    return this.jl.get(paramInt - 1);
  }
  
  public int getItemCount()
  {
    return this.jl.size() + ss();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    if ((this.bK != null) && (paramInt == 0)) {
      return 1024;
    }
    if ((this.footerView != null) && (paramInt == this.jl.size() + st())) {
      return 1025;
    }
    return dr(paramInt);
  }
  
  public boolean isEmpty()
  {
    return (this.jl == null) || (this.jl.isEmpty());
  }
  
  public static abstract interface a
  {
    public abstract void onItemClick(View paramView, int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void N(View paramView, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auwm
 * JD-Core Version:    0.7.0.1
 */