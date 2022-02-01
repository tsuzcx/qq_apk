import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.ArrayList;
import java.util.List;

class wag
  extends RecyclerView.Adapter<wah>
{
  public List<FeedCloudMeta.StTagInfo> a;
  
  private wag(wae paramwae)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public wah a(ViewGroup paramViewGroup, int paramInt)
  {
    return new wah(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560704, paramViewGroup, false));
  }
  
  public void a(List<FeedCloudMeta.StTagInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void a(wah paramwah, int paramInt)
  {
    paramwah.a((FeedCloudMeta.StTagInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt);
    EventCollector.getInstance().onRecyclerBindViewHolder(paramwah, paramInt, getItemId(paramInt));
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wag
 * JD-Core Version:    0.7.0.1
 */