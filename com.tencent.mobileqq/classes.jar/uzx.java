import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.fragments.message.item.QCircleMessageReplyItemView;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class uzx
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements aabg<QCircleReportBean>
{
  private QCircleReportBean jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private List<vba> jdField_a_of_type_JavaUtilList;
  private vom jdField_a_of_type_Vom;
  
  public QCircleReportBean a()
  {
    return QCircleReportBean.getReportBean("QCircleMessageReplyAdapter", this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
  }
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean = QCircleReportBean.setReportBean("QCircleMessageReplyAdapter", paramQCircleReportBean);
  }
  
  public void a(List<vba> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(vom paramvom)
  {
    this.jdField_a_of_type_Vom = paramvom;
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
      ((uzy)paramViewHolder).a(this.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new QCircleMessageReplyItemView(paramViewGroup.getContext());
    paramViewGroup.setReplyItemListener(this.jdField_a_of_type_Vom);
    paramViewGroup.setReportBean(a());
    return new uzy(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzx
 * JD-Core Version:    0.7.0.1
 */