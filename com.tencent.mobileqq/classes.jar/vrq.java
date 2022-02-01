import android.support.v7.widget.RecyclerView.Adapter;
import android.view.ViewGroup;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class vrq
  extends RecyclerView.Adapter<vrr>
{
  private vrq(vrn paramvrn) {}
  
  public vrr a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = vsh.a(paramViewGroup.getContext(), 512, paramInt);
    return new vrr(this.a, paramViewGroup);
  }
  
  public void a(vrr paramvrr, int paramInt)
  {
    if (paramvrr != null) {
      paramvrr.a((QQCircleFeedBase.StPolyLike)vrn.a(this.a).get(paramInt), paramInt);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramvrr, paramInt, getItemId(paramInt));
  }
  
  public int getItemCount()
  {
    return vrn.a(this.a).size();
  }
  
  public int getItemViewType(int paramInt)
  {
    QQCircleFeedBase.StPolyLike localStPolyLike = (QQCircleFeedBase.StPolyLike)vrn.a(this.a).get(paramInt);
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
 * Qualified Name:     vrq
 * JD-Core Version:    0.7.0.1
 */