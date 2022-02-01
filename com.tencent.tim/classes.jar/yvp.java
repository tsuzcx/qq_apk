import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public abstract class yvp<T>
  extends yvt<T>
{
  protected Context mContext;
  protected LayoutInflater mInflater;
  protected int mLayoutId;
  
  public yvp(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    this.mLayoutId = paramInt;
    a(new yvq(this, paramInt));
  }
  
  protected abstract yvx a(Context paramContext, ViewGroup paramViewGroup, int paramInt);
  
  protected abstract void a(yvx paramyvx, T paramT, int paramInt);
  
  public yvx b(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return a(paramContext, paramViewGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yvp
 * JD-Core Version:    0.7.0.1
 */