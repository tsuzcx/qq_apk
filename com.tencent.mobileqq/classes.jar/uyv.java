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

public class uyv
  extends uzv<TaskCenterReader.TaskRecord>
{
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private zxl<QCircleReportBean> jdField_a_of_type_Zxl;
  private int[] jdField_a_of_type_ArrayOfInt = { 2130844056, 2130844057, 2130844058, 2130844059, 2130844060, 2130844061, 2130844062, 2130844063, 2130844064, 2130844065 };
  
  public uyv(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private RelativeLayout a()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131560789, null));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370122));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379700));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new uyw(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, ImmersiveUtils.a(60.0F)));
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  protected int a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean != null) {
      return QCircleReportBean.getPageId("QCircleTaskCenterAdapter", this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
    }
    if (this.jdField_a_of_type_Zxl != null) {
      return QCircleReportBean.getPageId("QCircleTaskCenterAdapter", (QCircleReportBean)this.jdField_a_of_type_Zxl.getReportBean());
    }
    return 0;
  }
  
  public QCircleReportBean a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean != null) {
      return QCircleReportBean.getReportBean(a(), this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
    }
    if (this.jdField_a_of_type_Zxl != null) {
      return QCircleReportBean.getReportBean(a(), (QCircleReportBean)this.jdField_a_of_type_Zxl.getReportBean());
    }
    return null;
  }
  
  protected String a()
  {
    return "QCircleTaskCenterAdapter";
  }
  
  public void a(zxl<QCircleReportBean> paramzxl)
  {
    this.jdField_a_of_type_Zxl = paramzxl;
  }
  
  protected int b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean != null) {
      return QCircleReportBean.getParentPageId("QCircleTaskCenterAdapter", this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
    }
    if (this.jdField_a_of_type_Zxl != null) {
      return QCircleReportBean.getParentPageId("QCircleTaskCenterAdapter", (QCircleReportBean)this.jdField_a_of_type_Zxl.getReportBean());
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
  
  public void loadData(zxz paramzxz)
  {
    if (paramzxz.d())
    {
      paramzxz = new QCircleGetTaskCenterListRequest(BaseApplicationImpl.getApplication().getRuntime().getAccount());
      paramzxz.setEnableCache(true);
      VSNetworkHelper.a().a(getContext(), paramzxz, new uyx(this));
    }
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (!bkfj.a(paramInt, getDataList())) {
      ((QCircleTaskItemView)paramViewHolder.itemView).setData(getDataList().get(paramInt));
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new QCircleTaskItemView(paramViewGroup.getContext());
    paramViewGroup.setReportBean(a());
    return new zxy(this, paramViewGroup);
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
 * Qualified Name:     uyv
 * JD-Core Version:    0.7.0.1
 */