import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class prp<M>
  extends RecyclerView.ViewHolder
{
  private SparseArray<View> aG = new SparseArray();
  
  public prp(View paramView)
  {
    super(paramView);
  }
  
  public prp(ViewGroup paramViewGroup, int paramInt)
  {
    super(LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false));
  }
  
  public void P(M paramM) {}
  
  public void bey() {}
  
  protected Context getContext()
  {
    return this.itemView.getContext();
  }
  
  protected <T extends View> T getView(@IdRes int paramInt)
  {
    View localView2 = (View)this.aG.get(paramInt);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = this.itemView.findViewById(paramInt);
      this.aG.put(paramInt, localView1);
    }
    return localView1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     prp
 * JD-Core Version:    0.7.0.1
 */