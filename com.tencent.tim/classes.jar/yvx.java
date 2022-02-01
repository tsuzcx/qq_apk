import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class yvx
  extends RecyclerView.ViewHolder
{
  private SparseArray<View> bG;
  private View bu;
  private Context mContext;
  
  public yvx(Context paramContext, View paramView)
  {
    super(paramView);
    this.mContext = paramContext;
    this.bu = paramView;
    this.bG = new SparseArray();
  }
  
  public static yvx a(Context paramContext, View paramView)
  {
    return new yvx(paramContext, paramView);
  }
  
  public static yvx b(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return new yvx(paramContext, LayoutInflater.from(paramContext).inflate(paramInt, paramViewGroup, false));
  }
  
  public View S()
  {
    return this.bu;
  }
  
  public <T extends View> T getView(int paramInt)
  {
    View localView2 = (View)this.bG.get(paramInt);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = this.bu.findViewById(paramInt);
      this.bG.put(paramInt, localView1);
    }
    return localView1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yvx
 * JD-Core Version:    0.7.0.1
 */