import android.os.Bundle;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.QCirclePersonInfoAndStatusWidget;
import com.tencent.biz.qqcircle.widgets.QCirclePersonInfoAndStatusWidget.a;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class ovo
  extends ryh
{
  private static final String TAG = ovo.class.getSimpleName();
  private QCirclePersonInfoAndStatusWidget.a jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePersonInfoAndStatusWidget$a;
  private QCirclePersonInfoAndStatusWidget jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePersonInfoAndStatusWidget;
  
  public ovo(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, rxq paramrxq)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePersonInfoAndStatusWidget = new QCirclePersonInfoAndStatusWidget(getContext());
    return this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePersonInfoAndStatusWidget;
  }
  
  public void loadData(rxt paramrxt) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder().append("personDetail has dataList");
    boolean bool;
    if (this.mDataList != null)
    {
      bool = true;
      QLog.d(str, 1, String.valueOf(bool));
      if ((this.mDataList != null) && (this.mDataList.size() > 0))
      {
        if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePersonInfoAndStatusWidget == null) {
          break label152;
        }
        QLog.d(TAG, 1, "personDetail mHeadPersonalDetailInfoView setData i" + paramInt);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePersonInfoAndStatusWidget.setInteractor(this.mInteractor);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePersonInfoAndStatusWidget.setData(this.mDataList.get(paramInt));
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePersonInfoAndStatusWidget.setHeaderClickListener(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePersonInfoAndStatusWidget$a);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      bool = false;
      break;
      label152:
      QLog.e(TAG, 1, "personDetail mHeadPersonalDetailInfoView isnull");
    }
  }
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ovo
 * JD-Core Version:    0.7.0.1
 */