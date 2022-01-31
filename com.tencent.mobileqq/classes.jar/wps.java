import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.subscribe.component.extendsadapter.ComponentRvInnerView;
import java.util.ArrayList;

public abstract class wps
  extends wpc
{
  private ComponentRvInnerView a;
  
  public wps(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public int a()
  {
    return 3;
  }
  
  public abstract wpt a(ViewGroup paramViewGroup, int paramInt);
  
  public abstract void a(RecyclerView.ViewHolder paramViewHolder, int paramInt);
  
  public abstract void a(ComponentRvInnerView paramComponentRvInnerView);
  
  public void a(ArrayList paramArrayList)
  {
    b().clear();
    b().addAll(paramArrayList);
    if (this.a != null) {
      this.a.setData(paramArrayList);
    }
  }
  
  public abstract int b();
  
  protected boolean c()
  {
    return false;
  }
  
  public int getItemCount()
  {
    if ((!c()) || (b().size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder.itemView instanceof ComponentRvInnerView)) {
      this.a.setData(b());
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    this.a = new ComponentRvInnerView(paramViewGroup.getContext(), this);
    this.a.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    paramViewGroup = new wpb(this, this.a);
    paramViewGroup.setIsRecyclable(false);
    a(this.a);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wps
 * JD-Core Version:    0.7.0.1
 */