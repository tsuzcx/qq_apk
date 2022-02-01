import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqcircle.polylike.QCirclePolyBaseLikeView;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAllDialog.3;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class vpe
  extends ReportDialog
{
  private GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleReportBean jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private List<QQCircleFeedBase.StPolyLike> jdField_a_of_type_JavaUtilList = new ArrayList();
  private vph jdField_a_of_type_Vph;
  private vqa jdField_a_of_type_Vqa;
  private zwk jdField_a_of_type_Zwk;
  private zwo jdField_a_of_type_Zwo;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public vpe(@NonNull Context paramContext)
  {
    super(paramContext, 2131755890);
    a();
    paramContext = getWindow();
    paramContext.setGravity(80);
    paramContext.setWindowAnimations(2131755542);
    WindowManager.LayoutParams localLayoutParams = paramContext.getAttributes();
    localLayoutParams.width = bclx.a;
    localLayoutParams.height = -2;
    paramContext.setAttributes(localLayoutParams);
    setCancelable(true);
    setCanceledOnTouchOutside(true);
  }
  
  private void a()
  {
    this.jdField_a_of_type_Vph = new vph(this, null);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131560751, null);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373868);
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(getContext(), 4);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373772));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Vph);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
    this.jdField_b_of_type_AndroidViewView.setLayoutParams(new FrameLayout.LayoutParams(bclx.a, -2));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373867));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373865));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new vpf(this));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(vpp.a().a()));
    setContentView(this.jdField_a_of_type_AndroidViewView);
  }
  
  private void a(List<QQCircleFeedBase.StPolyLike> paramList)
  {
    this.jdField_a_of_type_Zwk = new zwk();
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      QQCircleFeedBase.StPolyLike localStPolyLike = (QQCircleFeedBase.StPolyLike)paramList.next();
      this.jdField_a_of_type_Zwk.a(new zwn(localStPolyLike.polySource.get(), uwz.a()));
      if (vpp.a.containsKey(localStPolyLike.polySource.get())) {
        break label124;
      }
      i = 1;
    }
    label124:
    for (;;)
    {
      break;
      if (i != 0)
      {
        this.jdField_a_of_type_Zwo = new vpg(this);
        this.jdField_a_of_type_Zwk.a(this.jdField_a_of_type_Zwo);
        this.jdField_a_of_type_Zwk.a();
        return;
      }
      b();
      return;
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.post(new QCirclePolyLikeAllDialog.3(this));
  }
  
  public void a(QCirclePolyBaseLikeView paramQCirclePolyBaseLikeView)
  {
    if (vpp.a.containsKey(paramQCirclePolyBaseLikeView.a().polySource.get()))
    {
      AnimationView.AnimationInfo localAnimationInfo = (AnimationView.AnimationInfo)vpp.a.get(paramQCirclePolyBaseLikeView.a().polySource.get());
      paramQCirclePolyBaseLikeView.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.setImageDrawable(null);
      paramQCirclePolyBaseLikeView.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.setAnimationFromInfo(localAnimationInfo);
      paramQCirclePolyBaseLikeView.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.setVisibility(0);
      paramQCirclePolyBaseLikeView.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      paramQCirclePolyBaseLikeView.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.play();
      return;
    }
    paramQCirclePolyBaseLikeView.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.setImageDrawable(null);
    paramQCirclePolyBaseLikeView.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, List<QQCircleFeedBase.StPolyLike> paramList, vqa paramvqa, QCircleReportBean paramQCircleReportBean)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_Vph.notifyDataSetChanged();
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
    this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean = paramQCircleReportBean;
    this.jdField_a_of_type_Vqa = paramvqa;
    a(paramList);
    show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vpe
 * JD-Core Version:    0.7.0.1
 */