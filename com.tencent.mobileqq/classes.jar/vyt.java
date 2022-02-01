import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.List;
import qqcircle.QQCircleFeedBase.StMainPageBusiRspData;

public class vyt
  implements zxl<QCircleReportBean>
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  protected QCircleReportBean a;
  private List<FeedCloudMeta.StTagInfo> jdField_a_of_type_JavaUtilList;
  private vyv jdField_a_of_type_Vyv;
  
  public QCircleReportBean a()
  {
    return QCircleReportBean.getReportBean(a(), this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
  }
  
  protected String a()
  {
    return "QCircleTaglistView";
  }
  
  public void a(View paramView)
  {
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131373942));
      this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131380934);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOverScrollMode(2);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
      paramView = new LinearLayoutManager(paramView.getContext());
      paramView.setOrientation(0);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramView);
      this.jdField_a_of_type_Vyv = new vyv(this, null);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Vyv);
    }
  }
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean = QCircleReportBean.setReportBean(a(), paramQCircleReportBean);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof QQCircleFeedBase.StMainPageBusiRspData))
    {
      this.jdField_a_of_type_JavaUtilList = ((QQCircleFeedBase.StMainPageBusiRspData)paramObject).recomTagList.get();
      if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
        break label75;
      }
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      if (this.jdField_a_of_type_Vyv != null) {
        this.jdField_a_of_type_Vyv.a(this.jdField_a_of_type_JavaUtilList);
      }
    }
    label75:
    do
    {
      return;
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
    } while (this.jdField_a_of_type_AndroidViewView == null);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vyt
 * JD-Core Version:    0.7.0.1
 */