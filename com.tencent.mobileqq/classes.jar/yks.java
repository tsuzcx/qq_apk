import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StQQGroup;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.List;

public class yks
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private List<CertifiedAccountMeta.StQQGroup> jdField_a_of_type_JavaUtilList;
  
  public yks(List<CertifiedAccountMeta.StQQGroup> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt))
    {
      paramViewHolder = (ykt)paramViewHolder;
      if (paramViewHolder != null) {
        paramViewHolder.a((CertifiedAccountMeta.StQQGroup)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = (ViewGroup)LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558719, paramViewGroup, false);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() == 1)) {
      paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }
    return new ykt(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yks
 * JD-Core Version:    0.7.0.1
 */