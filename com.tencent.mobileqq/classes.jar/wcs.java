import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

class wcs
  extends RecyclerView.Adapter<wct>
{
  public List<Long> a;
  
  private wcs(wcp paramwcp)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public wct a(ViewGroup paramViewGroup, int paramInt)
  {
    return new wct(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560721, paramViewGroup, false));
  }
  
  public void a(List<Long> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void a(wct paramwct, int paramInt)
  {
    paramwct.a(((Long)this.jdField_a_of_type_JavaUtilList.get(paramInt)).longValue(), paramInt);
    EventCollector.getInstance().onRecyclerBindViewHolder(paramwct, paramInt, getItemId(paramInt));
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
 * Qualified Name:     wcs
 * JD-Core Version:    0.7.0.1
 */