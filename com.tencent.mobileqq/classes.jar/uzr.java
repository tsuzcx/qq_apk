import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.widgets.QCircleFeedCommentWidget;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class uzr
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements aabg<QCircleReportBean>
{
  private aafz jdField_a_of_type_Aafz;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private QCircleReportBean jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private List<vba> jdField_a_of_type_JavaUtilList;
  
  public QCircleReportBean a()
  {
    return QCircleReportBean.getReportBean("QCircleFeedCommentAdaptr", this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
  }
  
  public void a(aafz paramaafz)
  {
    this.jdField_a_of_type_Aafz = paramaafz;
  }
  
  public void a(RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean = QCircleReportBean.setReportBean("QCircleFeedCommentAdaptr", paramQCircleReportBean);
  }
  
  public void a(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramExtraTypeInfo;
  }
  
  public void a(List<vba> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
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
    if ((this.jdField_a_of_type_JavaUtilList != null) && ((this.jdField_a_of_type_Aafz instanceof var))) {
      ((uzs)paramViewHolder).a(this.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo, (var)this.jdField_a_of_type_Aafz);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new QCircleFeedCommentWidget(paramViewGroup.getContext());
    paramViewGroup.setReportBean(a());
    paramViewGroup.setParentRecyclerView(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    return new uzs(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzr
 * JD-Core Version:    0.7.0.1
 */