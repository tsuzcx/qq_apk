import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.ArrayList;
import java.util.List;

class ufv
  extends RecyclerView.Adapter<ufw>
{
  public List<FeedCloudMeta.StTagInfo> a;
  
  private ufv(uft paramuft)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public ufw a(ViewGroup paramViewGroup, int paramInt)
  {
    return new ufw(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560546, paramViewGroup, false));
  }
  
  public void a(List<FeedCloudMeta.StTagInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void a(ufw paramufw, int paramInt)
  {
    paramufw.a((FeedCloudMeta.StTagInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ufv
 * JD-Core Version:    0.7.0.1
 */