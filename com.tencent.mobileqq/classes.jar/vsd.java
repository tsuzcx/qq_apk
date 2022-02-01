import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.app.hubert.guide.util.ScreenUtils;
import com.tencent.biz.qqcircle.events.QCirclePopWindowUpdateBalanceEvent;
import com.tencent.biz.qqcircle.polylike.QCirclePolyBaseLikeView;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikePopWindow.3;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class vsd
  extends PopupWindow
  implements aaam, aabg<QCircleReportBean>
{
  public static int a;
  public static int b;
  private aaaf jdField_a_of_type_Aaaf;
  private aaaj jdField_a_of_type_Aaaj;
  private aabg<QCircleReportBean> jdField_a_of_type_Aabg;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleReportBean jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private HashMap<String, QCirclePolyBaseLikeView> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<QQCircleFeedBase.StPolyLike> jdField_a_of_type_JavaUtilList;
  private vrx jdField_a_of_type_Vrx;
  private vsj jdField_a_of_type_Vsj;
  private boolean jdField_a_of_type_Boolean;
  private WeakReference<View> b;
  private int c;
  
  static
  {
    jdField_a_of_type_Int = bdep.a(101.0F);
    jdField_b_of_type_Int = 5;
  }
  
  public vsd(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localContext != null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(localContext).inflate(2131560779, null);
    }
    this.jdField_a_of_type_Vsj = new vsj(paramActivity);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131374005));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373991));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374016));
    setContentView(this.jdField_a_of_type_AndroidViewView);
    setOutsideTouchable(true);
    setFocusable(true);
    setBackgroundDrawable(new ColorDrawable(0));
  }
  
  private void a(QCirclePolyBaseLikeView paramQCirclePolyBaseLikeView)
  {
    if (!TextUtils.isEmpty(paramQCirclePolyBaseLikeView.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike.fullScreenURLAND.get()))
    {
      paramQCirclePolyBaseLikeView = new zzb(paramQCirclePolyBaseLikeView.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike.fullScreenURLAND.get());
      paramQCirclePolyBaseLikeView.b(40).a(true).a(2147483647L).b(false);
      zzc.a().a(hashCode(), paramQCirclePolyBaseLikeView.a(), new vsf(this));
    }
  }
  
  private void a(QQCircleFeedBase.StPolyLike paramStPolyLike, int paramInt)
  {
    QCirclePolyBaseLikeView localQCirclePolyBaseLikeView1 = (QCirclePolyBaseLikeView)this.jdField_a_of_type_JavaUtilHashMap.get(paramStPolyLike.polyLikeID.get());
    QCirclePolyBaseLikeView localQCirclePolyBaseLikeView2 = localQCirclePolyBaseLikeView1;
    if (localQCirclePolyBaseLikeView1 == null)
    {
      if ((paramInt != jdField_b_of_type_Int - 1) || (this.jdField_a_of_type_JavaUtilList.size() <= jdField_b_of_type_Int)) {
        break label181;
      }
      localQCirclePolyBaseLikeView1 = vsh.a(getContentView().getContext(), 256, 3);
    }
    for (;;)
    {
      localQCirclePolyBaseLikeView2 = localQCirclePolyBaseLikeView1;
      if (localQCirclePolyBaseLikeView1.c() != 3)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(paramStPolyLike.polyLikeID.get(), localQCirclePolyBaseLikeView1);
        localQCirclePolyBaseLikeView2 = localQCirclePolyBaseLikeView1;
      }
      localQCirclePolyBaseLikeView2.setExtraTypeInfo(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      localQCirclePolyBaseLikeView2.setReportBean(this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
      localQCirclePolyBaseLikeView2.setRequestManager(this.jdField_a_of_type_Vsj);
      localQCirclePolyBaseLikeView2.setCurrentFeed(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed);
      localQCirclePolyBaseLikeView2.setHookListener(new vsg(this, localQCirclePolyBaseLikeView2));
      localQCirclePolyBaseLikeView2.a(paramStPolyLike, paramInt);
      paramStPolyLike = new LinearLayout.LayoutParams(-1, -1);
      paramStPolyLike.weight = 1.0F;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localQCirclePolyBaseLikeView2.jdField_a_of_type_AndroidViewView, paramStPolyLike);
      return;
      label181:
      if (paramStPolyLike.articleType.get() == 0) {
        localQCirclePolyBaseLikeView1 = vsh.a(getContentView().getContext(), 256, 1);
      } else if (paramStPolyLike.articleType.get() == 1) {
        localQCirclePolyBaseLikeView1 = vsh.a(getContentView().getContext(), 256, 2);
      }
    }
  }
  
  public static void b()
  {
    vry.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      if (this.jdField_a_of_type_JavaUtilList.size() <= jdField_b_of_type_Int) {
        break label45;
      }
    }
    label45:
    for (int i = jdField_b_of_type_Int;; i = this.jdField_a_of_type_JavaUtilList.size())
    {
      this.c = i;
      setWidth(-2);
      setHeight(jdField_a_of_type_Int);
      return;
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_Aaaf = new aaaf();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (QCirclePolyBaseLikeView)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      this.jdField_a_of_type_Aaaf.a(new aaai(((QCirclePolyBaseLikeView)localObject).jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike.polySource.get(), uyk.a()));
      a((QCirclePolyBaseLikeView)localObject);
      if (vry.jdField_a_of_type_JavaUtilHashMap.containsKey(((QCirclePolyBaseLikeView)localObject).jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike.polySource.get())) {
        break label173;
      }
      i = 1;
    }
    label173:
    for (;;)
    {
      break;
      if (i != 0)
      {
        this.jdField_a_of_type_Aaaj = new vse(this);
        this.jdField_a_of_type_Aaaf.a(this.jdField_a_of_type_Aaaj);
        this.jdField_a_of_type_Aaaf.a();
        QLog.d("QCirclePolymorphicLikePopWindow", 1, "shouldDownload");
        return;
      }
      e();
      QLog.d("QCirclePolymorphicLikePopWindow", 1, "should not Download");
      return;
    }
  }
  
  private void e()
  {
    getContentView().post(new QCirclePolyLikePopWindow.3(this));
  }
  
  public QCircleReportBean a()
  {
    return QCircleReportBean.getReportBean("QCirclePolymorphicLikePopWindow", this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
  }
  
  public void a()
  {
    int j = 0;
    label314:
    for (;;)
    {
      try
      {
        if (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null) {
          break;
        }
        vry.a().a();
        int[] arrayOfInt = new int[2];
        int i = bdep.jdField_b_of_type_Int / 2;
        ((View)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getLocationInWindow(arrayOfInt);
        setAnimationStyle(2131755894);
        if (arrayOfInt[1] > jdField_a_of_type_Int + bdep.a(60.0F) + ScreenUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidViewView.getContext()))
        {
          setAnimationStyle(2131755894);
          i = (int)(arrayOfInt[1] - jdField_a_of_type_Int / 1.5D - i);
          if (!this.jdField_a_of_type_Boolean) {
            break label314;
          }
          i -= bdep.a(5.0F);
          showAtLocation((View)this.jdField_b_of_type_JavaLangRefWeakReference.get(), 1, 0, i);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
          aaak.a().a(this);
          i = j;
          if (this.jdField_a_of_type_AndroidWidgetTextView != null)
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext().getResources().getString(2131697295), new Object[] { Float.valueOf(vry.a().a()) }));
            i = j;
          }
          if (i < this.c)
          {
            a((QQCircleFeedBase.StPolyLike)this.jdField_a_of_type_JavaUtilList.get(i), i);
            i += 1;
            continue;
          }
        }
        else
        {
          setAnimationStyle(2131755893);
          int k = arrayOfInt[1];
          i = ((View)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getHeight() + k + jdField_a_of_type_Int / 4 - i;
          continue;
        }
        d();
        if (aaek.a())
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          return;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
  }
  
  public void a(aabg<QCircleReportBean> paramaabg)
  {
    this.jdField_a_of_type_Aabg = paramaabg;
    this.jdField_a_of_type_Vsj.a(this.jdField_a_of_type_Aabg);
  }
  
  public void a(View paramView1, View paramView2, boolean paramBoolean, QCirclePolyLikeAniView paramQCirclePolyLikeAniView, FeedCloudMeta.StFeed paramStFeed, List<QQCircleFeedBase.StPolyLike> paramList, ReportExtraTypeInfo paramReportExtraTypeInfo)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramView1);
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramReportExtraTypeInfo;
    this.jdField_a_of_type_Vsj.a(paramReportExtraTypeInfo, paramView1, paramView2, paramQCirclePolyLikeAniView);
    c();
  }
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean = QCircleReportBean.setReportBean("QCirclePolymorphicLikePopWindow", paramQCircleReportBean);
    this.jdField_a_of_type_Vsj.a(paramQCircleReportBean);
  }
  
  public void a(vrx paramvrx)
  {
    this.jdField_a_of_type_Vrx = paramvrx;
  }
  
  public void dismiss()
  {
    super.dismiss();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (QCirclePolyBaseLikeView)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      if ((localObject != null) && (((QCirclePolyBaseLikeView)localObject).jdField_a_of_type_ComTencentMobileqqWidgetAnimationView != null) && (((QCirclePolyBaseLikeView)localObject).jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.getAnimationFromInfo() != null)) {
        ((QCirclePolyBaseLikeView)localObject).jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.pause();
      }
    }
    aaak.a().b(this);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCirclePopWindowUpdateBalanceEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCirclePopWindowUpdateBalanceEvent))
    {
      paramSimpleBaseEvent = (QCirclePopWindowUpdateBalanceEvent)paramSimpleBaseEvent;
      if (uzg.a(paramSimpleBaseEvent.uin))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext().getResources().getString(2131697295), new Object[] { Float.valueOf(paramSimpleBaseEvent.balance) }));
        vry.a().a(paramSimpleBaseEvent.balance);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vsd
 * JD-Core Version:    0.7.0.1
 */