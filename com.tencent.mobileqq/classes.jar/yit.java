import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.component.extendsadapter.ComponentRvInnerView;

public class yit
  extends yhw
{
  public yit(ComponentRvInnerView paramComponentRvInnerView) {}
  
  public yis a(ViewGroup paramViewGroup, int paramInt)
  {
    if (ComponentRvInnerView.a(this.a) != null) {
      return ComponentRvInnerView.a(this.a).a(paramViewGroup, paramInt);
    }
    return null;
  }
  
  public int getItemCount()
  {
    if (ComponentRvInnerView.a(this.a) != null) {
      return ComponentRvInnerView.a(this.a).a();
    }
    return 0;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((!bhrz.a(paramInt, this.mDataList)) && (ComponentRvInnerView.a(this.a) != null)) {
      ComponentRvInnerView.a(this.a).a(paramViewHolder, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yit
 * JD-Core Version:    0.7.0.1
 */