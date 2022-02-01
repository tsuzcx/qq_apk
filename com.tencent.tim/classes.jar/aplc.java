import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

public class aplc
{
  private SparseArray<aplb> dD;
  
  public aplb a(int paramInt)
  {
    return (aplb)this.dD.get(paramInt);
  }
  
  public void a(@NonNull RecyclerView.ViewHolder paramViewHolder, apkn paramapkn, int paramInt)
  {
    aplb localaplb = a(paramapkn.getType());
    if (localaplb != null)
    {
      ((aplc.a)paramViewHolder).a = paramapkn;
      localaplb.a(paramViewHolder, paramapkn, paramInt);
    }
  }
  
  public void a(apku paramapku)
  {
    aplb localaplb = a(paramapku.getType());
    if ((localaplb != null) && ((localaplb instanceof aplp))) {
      ((aplp)localaplb).c(paramapku);
    }
  }
  
  public void c(SparseArray<aplb> paramSparseArray)
  {
    this.dD = paramSparseArray;
  }
  
  public void d(apkn paramapkn)
  {
    aplb localaplb = a(paramapkn.getType());
    if (localaplb != null) {
      localaplb.d(paramapkn);
    }
  }
  
  public void e(apkn paramapkn)
  {
    aplb localaplb = a(paramapkn.getType());
    if (localaplb != null) {
      localaplb.e(paramapkn);
    }
  }
  
  public void f(apkn paramapkn)
  {
    aplb localaplb = a(paramapkn.getType());
    if (localaplb != null) {
      localaplb.f(paramapkn);
    }
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    aplb localaplb = a(paramInt);
    if (localaplb != null) {
      return localaplb.a(paramViewGroup);
    }
    return null;
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (aplc.a)paramViewHolder;
    if (paramViewHolder.a != null)
    {
      aplb localaplb = a(paramViewHolder.a.getType());
      if (localaplb != null) {
        localaplb.onViewAttachedToWindow(paramViewHolder);
      }
    }
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (aplc.a)paramViewHolder;
    if (paramViewHolder.a != null)
    {
      aplb localaplb = a(paramViewHolder.a.getType());
      if (localaplb != null) {
        localaplb.onViewDetachedFromWindow(paramViewHolder);
      }
    }
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (aplc.a)paramViewHolder;
    if (paramViewHolder.a != null)
    {
      aplb localaplb = a(paramViewHolder.a.getType());
      if (localaplb != null) {
        localaplb.onViewRecycled(paramViewHolder);
      }
    }
  }
  
  public void release()
  {
    int i = 0;
    while (i < this.dD.size())
    {
      ((aplb)this.dD.valueAt(i)).release();
      i += 1;
    }
  }
  
  public static abstract class a<D extends apkn>
    extends RecyclerView.ViewHolder
  {
    public D a;
    
    public a(View paramView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aplc
 * JD-Core Version:    0.7.0.1
 */