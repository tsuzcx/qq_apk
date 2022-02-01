import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class wro<M>
  extends RecyclerView.ViewHolder
{
  private SparseArray<View> a = new SparseArray();
  
  public wro(View paramView)
  {
    super(paramView);
  }
  
  public wro(ViewGroup paramViewGroup, int paramInt)
  {
    super(LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false));
  }
  
  protected Context a()
  {
    return this.itemView.getContext();
  }
  
  protected <T extends View> T a(@IdRes int paramInt)
  {
    View localView2 = (View)this.a.get(paramInt);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = this.itemView.findViewById(paramInt);
      this.a.put(paramInt, localView1);
    }
    return localView1;
  }
  
  public void a() {}
  
  public void a(M paramM) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wro
 * JD-Core Version:    0.7.0.1
 */