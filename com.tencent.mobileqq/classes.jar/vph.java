import android.support.v7.widget.RecyclerView.Adapter;
import android.view.ViewGroup;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class vph
  extends RecyclerView.Adapter<vpi>
{
  private vph(vpe paramvpe) {}
  
  public vpi a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = vpy.a(paramViewGroup.getContext(), 512, paramInt);
    return new vpi(this.a, paramViewGroup);
  }
  
  public void a(vpi paramvpi, int paramInt)
  {
    if (paramvpi != null) {
      paramvpi.a((QQCircleFeedBase.StPolyLike)vpe.a(this.a).get(paramInt), paramInt);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramvpi, paramInt, getItemId(paramInt));
  }
  
  public int getItemCount()
  {
    return vpe.a(this.a).size();
  }
  
  public int getItemViewType(int paramInt)
  {
    QQCircleFeedBase.StPolyLike localStPolyLike = (QQCircleFeedBase.StPolyLike)vpe.a(this.a).get(paramInt);
    if (localStPolyLike != null)
    {
      if (localStPolyLike.articleType.get() == 0) {
        return 1;
      }
      if (localStPolyLike.articleType.get() == 1) {
        return 2;
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vph
 * JD-Core Version:    0.7.0.1
 */