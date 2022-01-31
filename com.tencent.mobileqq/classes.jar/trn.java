import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.QCirclePersonInfoAndStatusWidget;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class trn
  extends yiu
{
  private static final String jdField_a_of_type_JavaLangString = trn.class.getSimpleName();
  private QCirclePersonInfoAndStatusWidget jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePersonInfoAndStatusWidget;
  private uef jdField_a_of_type_Uef;
  
  public trn(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, yhy paramyhy)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePersonInfoAndStatusWidget = new QCirclePersonInfoAndStatusWidget(getContext());
    return this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePersonInfoAndStatusWidget;
  }
  
  public void loadData(yii paramyii) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    paramViewHolder = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("personDetail has dataList");
    if (this.mDataList != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d(paramViewHolder, 1, String.valueOf(bool));
      if ((this.mDataList != null) && (this.mDataList.size() > 0))
      {
        if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePersonInfoAndStatusWidget == null) {
          break;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 1, "personDetail mHeadPersonalDetailInfoView setData i" + paramInt);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePersonInfoAndStatusWidget.setInteractor(this.mInteractor);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePersonInfoAndStatusWidget.setData(this.mDataList.get(paramInt));
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePersonInfoAndStatusWidget.setHeaderClickListener(this.jdField_a_of_type_Uef);
      }
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "personDetail mHeadPersonalDetailInfoView isnull");
  }
  
  public void onPrepareParams(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trn
 * JD-Core Version:    0.7.0.1
 */