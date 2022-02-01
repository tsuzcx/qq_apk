import android.os.Bundle;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.fragments.person.QCirclePersonInfoWidget;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class uyr
  extends uzx
{
  private QCirclePersonInfoWidget jdField_a_of_type_ComTencentBizQqcircleFragmentsPersonQCirclePersonInfoWidget;
  private vng jdField_a_of_type_Vng;
  
  public uyr(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, zxu paramzxu)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsPersonQCirclePersonInfoWidget = new QCirclePersonInfoWidget(getContext());
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsPersonQCirclePersonInfoWidget.setReportBean(a());
    return this.jdField_a_of_type_ComTencentBizQqcircleFragmentsPersonQCirclePersonInfoWidget;
  }
  
  protected String a()
  {
    return "QCirclePersonalDetailHeaderBlock";
  }
  
  public void loadData(zxz paramzxz) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("personDetail has dataList");
    boolean bool;
    if (this.mDataList != null)
    {
      bool = true;
      QLog.d("QCirclePersonalDetailHeaderBlock", 1, String.valueOf(bool));
      if ((this.mDataList != null) && (this.mDataList.size() > 0))
      {
        if (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsPersonQCirclePersonInfoWidget == null) {
          break label146;
        }
        QLog.d("QCirclePersonalDetailHeaderBlock", 1, "personDetail mHeadPersonalDetailInfoView setData i" + paramInt);
        this.jdField_a_of_type_ComTencentBizQqcircleFragmentsPersonQCirclePersonInfoWidget.setInteractor(this.mInteractor);
        this.jdField_a_of_type_ComTencentBizQqcircleFragmentsPersonQCirclePersonInfoWidget.setData(this.mDataList.get(paramInt));
        this.jdField_a_of_type_ComTencentBizQqcircleFragmentsPersonQCirclePersonInfoWidget.setHeaderClickListener(this.jdField_a_of_type_Vng);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      bool = false;
      break;
      label146:
      QLog.e("QCirclePersonalDetailHeaderBlock", 1, "personDetail mHeadPersonalDetailInfoView isnull");
    }
  }
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uyr
 * JD-Core Version:    0.7.0.1
 */