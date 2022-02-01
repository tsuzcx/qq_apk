import android.graphics.Rect;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import qqcircle.QQCircleFeedBase.StTagPageData;

public class wfi
  implements aabg<QCircleReportBean>, View.OnClickListener
{
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleReportBean jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private QQCircleFeedBase.StTagPageData jdField_a_of_type_QqcircleQQCircleFeedBase$StTagPageData;
  private wfl jdField_a_of_type_Wfl;
  private TextView b;
  
  private void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null) && (this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView.getContext() instanceof FragmentActivity)))
    {
      Object localObject = (ViewGroup)((FragmentActivity)this.jdField_a_of_type_AndroidViewView.getContext()).getWindow().getDecorView();
      View localView = ((ViewGroup)localObject).getChildAt(0);
      if ((localView instanceof DragFrameLayout)) {
        localObject = (ViewGroup)localView;
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchEventListener(new wfj(this));
  }
  
  public QCircleReportBean a()
  {
    return QCircleReportBean.getReportBean(a(), this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
  }
  
  protected String a()
  {
    return "QCircleFuelListView";
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379857));
    this.b = ((TextView)paramView.findViewById(2131379858));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369119));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131376995));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376787));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new LinearLayoutManager(paramView.getContext(), 0, false));
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    a();
  }
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean = QCircleReportBean.setReportBean(a(), paramQCircleReportBean);
  }
  
  public void a(Object paramObject)
  {
    if (!(paramObject instanceof QQCircleFeedBase.StTagPageData)) {
      return;
    }
    this.jdField_a_of_type_QqcircleQQCircleFeedBase$StTagPageData = ((QQCircleFeedBase.StTagPageData)paramObject);
    if (this.jdField_a_of_type_QqcircleQQCircleFeedBase$StTagPageData.fuelCircleRankItem.get().size() == 0)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StTagPageData.rankName.get())) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StTagPageData.rankName.get());
      }
      if (this.jdField_a_of_type_Wfl == null) {
        this.jdField_a_of_type_Wfl = new wfl(this, null);
      }
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Wfl);
      this.jdField_a_of_type_Wfl.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_QqcircleQQCircleFeedBase$StTagPageData != null) && (this.jdField_a_of_type_QqcircleQQCircleFeedBase$StTagPageData.urlInfo.has())) {
        uyx.a(this.jdField_a_of_type_AndroidViewView.getContext(), uyw.a(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StTagPageData.urlInfo.get(), "tagFuelRankUrl"), null, -1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wfi
 * JD-Core Version:    0.7.0.1
 */