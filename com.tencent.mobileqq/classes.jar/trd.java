import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.QCircleFeedCommentWidget;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import java.util.List;

public class trd
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private List<trs> jdField_a_of_type_JavaUtilList;
  private xzc jdField_a_of_type_Xzc;
  
  public void a(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramExtraTypeInfo;
  }
  
  public void a(List<trs> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(xzc paramxzc)
  {
    this.jdField_a_of_type_Xzc = paramxzc;
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
    if ((this.jdField_a_of_type_JavaUtilList != null) && ((this.jdField_a_of_type_Xzc instanceof trr))) {
      ((tre)paramViewHolder).a(this.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo, (trr)this.jdField_a_of_type_Xzc);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new tre(new QCircleFeedCommentWidget(paramViewGroup.getContext()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trd
 * JD-Core Version:    0.7.0.1
 */