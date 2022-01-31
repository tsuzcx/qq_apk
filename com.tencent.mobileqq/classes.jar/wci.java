import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;

public abstract class wci
  extends wbp
{
  private BaseWidgetView a;
  private boolean c = true;
  
  public wci(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public int a()
  {
    return 3;
  }
  
  protected abstract BaseWidgetView a(ViewGroup paramViewGroup, wbp paramwbp);
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    a().notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    if (this.c) {
      return 1;
    }
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    return 1;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt) {}
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    this.a = a(paramViewGroup, this);
    paramViewGroup = new wbo(this, this.a);
    paramViewGroup.setIsRecyclable(false);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wci
 * JD-Core Version:    0.7.0.1
 */