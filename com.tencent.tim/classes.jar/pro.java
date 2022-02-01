import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public abstract class pro<M, VH extends prp<M>>
  extends prq<M, VH>
{
  private List<M> jl = new ArrayList();
  
  public pro(Context paramContext)
  {
    super(paramContext);
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
      notifyDataSetChanged();
    }
    return bool;
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
  
  public int d(M paramM)
  {
    int i = this.jl.indexOf(paramM);
    if (i < 0) {
      return i;
    }
    this.jl.set(i, paramM);
    if (this.bK == null)
    {
      notifyItemChanged(i);
      return i;
    }
    notifyItemChanged(i + 1);
    return i;
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
  
  public void i(M paramM, int paramInt)
  {
    int i = this.jl.indexOf(paramM);
    if (i != -1) {
      this.jl.remove(i);
    }
    this.jl.add(paramInt, paramM);
    if (i != -1)
    {
      if (this.bK == null)
      {
        notifyItemMoved(i, paramInt);
        notifyItemChanged(paramInt);
        return;
      }
      notifyItemMoved(i + 1, paramInt + 1);
      notifyItemChanged(paramInt + 1);
      return;
    }
    if (this.bK == null)
    {
      notifyItemInserted(paramInt);
      return;
    }
    notifyItemInserted(paramInt + 1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pro
 * JD-Core Version:    0.7.0.1
 */