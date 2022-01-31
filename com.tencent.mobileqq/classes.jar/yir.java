import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.subscribe.component.extendsadapter.ComponentRvInnerView;
import java.util.ArrayList;

public abstract class yir
  extends yhy
{
  private ComponentRvInnerView a;
  
  public yir(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public abstract int a();
  
  public abstract yis a(ViewGroup paramViewGroup, int paramInt);
  
  public abstract void a(RecyclerView.ViewHolder paramViewHolder, int paramInt);
  
  public abstract void a(ComponentRvInnerView paramComponentRvInnerView);
  
  protected boolean a()
  {
    return false;
  }
  
  public int getItemCount()
  {
    if ((!a()) || (getDataList().size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder.itemView instanceof ComponentRvInnerView)) {
      this.a.setData(getDataList());
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    this.a = new ComponentRvInnerView(paramViewGroup.getContext(), this);
    this.a.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    paramViewGroup = new yhx(this, this.a);
    paramViewGroup.setIsRecyclable(false);
    a(this.a);
    return paramViewGroup;
  }
  
  public void setDatas(ArrayList paramArrayList)
  {
    getDataList().clear();
    getDataList().addAll(paramArrayList);
    if (this.a != null) {
      this.a.setData(paramArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yir
 * JD-Core Version:    0.7.0.1
 */