import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.message.item.QCircleMessageReplyItemView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import java.util.List;

public class trk
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private List<trx> jdField_a_of_type_JavaUtilList;
  private ugy jdField_a_of_type_Ugy;
  
  public void a(List<trx> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(ugy paramugy)
  {
    this.jdField_a_of_type_Ugy = paramugy;
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
    if (this.jdField_a_of_type_JavaUtilList != null) {
      ((trl)paramViewHolder).a(this.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new QCircleMessageReplyItemView(paramViewGroup.getContext());
    paramViewGroup.setReplyItemListener(this.jdField_a_of_type_Ugy);
    return new trl(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trk
 * JD-Core Version:    0.7.0.1
 */