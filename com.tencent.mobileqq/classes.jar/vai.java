import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.requests.QCircleGetTaskCenterListRequest;
import com.tencent.biz.qqcircle.widgets.QCircleTaskItemView;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import qqcircle.TaskCenterReader.TaskRecord;

public class vai
  extends vbl<TaskCenterReader.TaskRecord>
{
  private aabg<QCircleReportBean> jdField_a_of_type_Aabg;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private int[] jdField_a_of_type_ArrayOfInt = { 2130844074, 2130844075, 2130844076, 2130844077, 2130844078, 2130844079, 2130844080, 2130844081, 2130844082, 2130844083 };
  
  public vai(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private RelativeLayout a()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131560819, null));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370220));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379878));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new vaj(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, ImmersiveUtils.a(60.0F)));
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  protected int a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean != null) {
      return QCircleReportBean.getPageId("QCircleTaskCenterAdapter", this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
    }
    if (this.jdField_a_of_type_Aabg != null) {
      return QCircleReportBean.getPageId("QCircleTaskCenterAdapter", (QCircleReportBean)this.jdField_a_of_type_Aabg.getReportBean());
    }
    return 0;
  }
  
  public QCircleReportBean a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean != null) {
      return QCircleReportBean.getReportBean(a(), this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
    }
    if (this.jdField_a_of_type_Aabg != null) {
      return QCircleReportBean.getReportBean(a(), (QCircleReportBean)this.jdField_a_of_type_Aabg.getReportBean());
    }
    return null;
  }
  
  protected String a()
  {
    return "QCircleTaskCenterAdapter";
  }
  
  public void a(aabg<QCircleReportBean> paramaabg)
  {
    this.jdField_a_of_type_Aabg = paramaabg;
  }
  
  protected int b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean != null) {
      return QCircleReportBean.getParentPageId("QCircleTaskCenterAdapter", this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
    }
    if (this.jdField_a_of_type_Aabg != null) {
      return QCircleReportBean.getParentPageId("QCircleTaskCenterAdapter", (QCircleReportBean)this.jdField_a_of_type_Aabg.getReportBean());
    }
    return 0;
  }
  
  public int getItemCount()
  {
    return getDataNumber();
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public void loadData(aabu paramaabu)
  {
    if (paramaabu.d())
    {
      paramaabu = new QCircleGetTaskCenterListRequest(BaseApplicationImpl.getApplication().getRuntime().getAccount());
      paramaabu.setEnableCache(true);
      VSNetworkHelper.a().a(getContext(), paramaabu, new vak(this));
    }
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (!blgn.a(paramInt, getDataList())) {
      ((QCircleTaskItemView)paramViewHolder.itemView).setData(getDataList().get(paramInt));
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new QCircleTaskItemView(paramViewGroup.getContext());
    paramViewGroup.setReportBean(a());
    return new aabt(this, paramViewGroup);
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    setDatas(null);
  }
  
  public void onInitBlock(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      addFixViewOccupySpaceAtTop(a(), ImmersiveUtils.a(60.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vai
 * JD-Core Version:    0.7.0.1
 */