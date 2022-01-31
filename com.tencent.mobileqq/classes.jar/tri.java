import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.QCirclePersonInfoAndStatusWidget;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class tri
  extends yei
{
  private static final String jdField_a_of_type_JavaLangString = tri.class.getSimpleName();
  private QCirclePersonInfoAndStatusWidget jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePersonInfoAndStatusWidget;
  private ubm jdField_a_of_type_Ubm;
  
  public tri(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, ydp paramydp)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePersonInfoAndStatusWidget = new QCirclePersonInfoAndStatusWidget(a());
    return this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePersonInfoAndStatusWidget;
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(yeb paramyeb) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePersonInfoAndStatusWidget != null)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "mHeadPersonalDetailInfoView setData");
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePersonInfoAndStatusWidget.setInteractor(this.jdField_a_of_type_Xzc);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePersonInfoAndStatusWidget.setData(this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePersonInfoAndStatusWidget.setHeaderClickListener(this.jdField_a_of_type_Ubm);
      }
    }
    else {
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "mHeadPersonalDetailInfoView isnull");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tri
 * JD-Core Version:    0.7.0.1
 */